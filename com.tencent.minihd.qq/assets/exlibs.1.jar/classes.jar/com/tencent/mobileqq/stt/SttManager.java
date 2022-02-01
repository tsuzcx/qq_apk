package com.tencent.mobileqq.stt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import jxv;
import jxw;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.xml.sax.helpers.DefaultHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttResp;

public class SttManager
  implements Handler.Callback, Manager, BusinessObserver
{
  public static final int a = 1;
  public static final long a = 30000L;
  public static final String a = "VoiceToTextMask";
  public static boolean a = false;
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = "rich_status";
  private static final int jdField_c_of_type_Int = 2;
  private static final String jdField_c_of_type_JavaLangString = "k_ability_";
  private static final int jdField_d_of_type_Int = 3;
  private static final String jdField_d_of_type_JavaLangString = "k_stt_guide_version";
  private static final int jdField_e_of_type_Int = 4;
  private static final String jdField_e_of_type_JavaLangString = "k_stt_guide_show";
  private static int jdField_f_of_type_Int = 0;
  private static final String jdField_f_of_type_JavaLangString = "Q.stt";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private SttManager.ISttListener jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    f = -1;
    jdField_a_of_type_Boolean = false;
  }
  
  public SttManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).getInt("k_stt_guide_version", 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    localFile = new File(paramQQAppInterface.getApplication().getFilesDir(), "VoiceToTextMask");
    for (;;)
    {
      try
      {
        bool = HttpDownloadUtil.a(paramQQAppInterface, new URL(paramString), localFile);
        if (!bool) {
          continue;
        }
        localObject = paramQQAppInterface.a().getResources().getDisplayMetrics();
        localObject = new jxw(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
      }
      catch (MalformedURLException paramQQAppInterface)
      {
        boolean bool;
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.stt", 2, "updateGuide with:", paramQQAppInterface);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.stt", 2, "updateGuide download xml failed: " + paramString);
        continue;
      }
      finally
      {
        localFile.delete();
      }
      try
      {
        SAXParserFactory.newInstance().newSAXParser().parse(localFile, (DefaultHandler)localObject);
        if (TextUtils.isEmpty(((jxw)localObject).a)) {
          bool = HttpDownloadUtil.a(paramQQAppInterface, new URL(paramString), localFile);
        }
        if (!bool) {
          continue;
        }
        paramQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).edit().putLong("k_stt_guide_version", paramLong).commit();
      }
      catch (Throwable paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.stt", 2, "updateGuide with", paramQQAppInterface);
        continue;
      }
      localFile.delete();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "updateGuide download image failed: " + ((jxw)localObject).a);
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (f < 0) {
      f = paramQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).getInt("k_ability_" + paramQQAppInterface.getAccount(), 0);
    }
    return f == 1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (a(paramQQAppInterface) != paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        f = i;
        paramQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).edit().putInt("k_ability_" + paramQQAppInterface.getAccount(), f).commit();
        return true;
      }
    }
    return false;
  }
  
  public Long a(MessageForPtt paramMessageForPtt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
    }
    Long localLong = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong)) {
      return localLong;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(localLong, paramMessageForPtt);
    SttServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, localLong);
    return localLong;
  }
  
  public void a(SttManager.ISttListener paramISttListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener = paramISttListener;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SttResultPush.MsgBody();
    for (;;)
    {
      SttResultPush.TransPttResp localTransPttResp;
      Long localLong;
      int i;
      int j;
      int k;
      int m;
      try
      {
        ((SttResultPush.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        localTransPttResp = ((SttResultPush.MsgBody)localObject).msg_ptt_resp;
        localLong = Long.valueOf(localTransPttResp.uint64_sessionid.get());
        i = localTransPttResp.uint32_pos.get();
        j = localTransPttResp.uint32_len.get();
        k = localTransPttResp.uint32_total_len.get();
        m = 1 << localTransPttResp.uint32_seq.get();
        int n = localTransPttResp.uint32_error_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "onSttResultPush with: " + n + ", " + localLong + ", " + i + ", " + j + ", " + k);
        }
        if ((n != 0) || (i + j > k))
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localLong);
          }
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, localLong).sendToTarget();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.stt", 2, "onSttResultPush failed with: ", paramArrayOfByte);
        return;
      }
      if (j >= k) {
        paramArrayOfByte = new String(localTransPttResp.bytes_text.get().toByteArray());
      }
      while (paramArrayOfByte != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, (int)(localLong.longValue() >> 32) & 0xFFFFFFFF, (int)(localLong.longValue() & 0xFFFFFFFF), paramArrayOfByte).sendToTarget();
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        localObject = (jxv)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localLong);
        paramArrayOfByte = (byte[])localObject;
        if (localObject == null)
        {
          paramArrayOfByte = new jxv(null);
          paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(k);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, localLong);
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, localLong);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 30000L);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localLong, paramArrayOfByte);
        }
        if (0L == (paramArrayOfByte.jdField_a_of_type_Long & m))
        {
          paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer.position(i);
          paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer.put(localTransPttResp.bytes_text.get().toByteArray());
          long l = paramArrayOfByte.b;
          paramArrayOfByte.b = (j + l);
          paramArrayOfByte.jdField_a_of_type_Long |= m;
          if (paramArrayOfByte.b >= k)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localLong);
            paramArrayOfByte = new String(paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer.array());
            continue;
          }
        }
        paramArrayOfByte = null;
      }
    }
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    return (this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForPtt.uniseq)));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    MessageForPtt localMessageForPtt = null;
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("unknown msg: " + paramMessage.what);
    case 2: 
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMessage.obj);
      }
    case 1: 
    case 4: 
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessage.obj);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "handleMessage with: " + paramMessage.what + ", " + paramMessage.obj + ", " + localMessageForPtt);
      }
      if ((localMessageForPtt != null) && (this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener.a(false, localMessageForPtt);
      }
      return true;
    }
    long l = paramMessage.arg1 << 32 | paramMessage.arg2 & 0xFFFFFFFF;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {}
    for (localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l));; localMessageForPtt = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "handleMessage with: " + paramMessage.what + ", " + l + ", " + localMessageForPtt);
      }
      if (localMessageForPtt == null) {
        break;
      }
      localMessageForPtt.sttAbility = 2;
      localMessageForPtt.sttText = ((String)paramMessage.obj);
      localMessageForPtt.isReadPtt = true;
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "ptt convert to text success,seq is:" + localMessageForPtt.uniseq + ",sttAbility is:" + localMessageForPtt.sttAbility + ",sttText is:" + Utils.a(localMessageForPtt.sttText));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener.a(true, localMessageForPtt);
      return true;
    }
  }
  
  public void onDestroy()
  {
    f = -1;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "onReceive bundle is null");
      }
    }
    Long localLong1;
    do
    {
      do
      {
        return;
        localLong1 = Long.valueOf(paramBundle.getLong("k_session", 0L));
        Long localLong2 = Long.valueOf(paramBundle.getLong("k_time_out", 30000L));
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "onReceive, session = " + localLong1 + ", timeout = " + localLong2);
        }
        paramBundle = null;
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          paramBundle = (MessageForPtt)this.jdField_a_of_type_JavaUtilHashMap.get(localLong1);
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBoolean)
        {
          paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localLong1);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramBundle, localLong2.longValue());
          return;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_JavaUtilHashMap.remove(localLong1);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener == null);
      this.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener.a(false, paramBundle);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.stt", 2, "onReceive with no request on: " + localLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttManager
 * JD-Core Version:    0.7.0.1
 */