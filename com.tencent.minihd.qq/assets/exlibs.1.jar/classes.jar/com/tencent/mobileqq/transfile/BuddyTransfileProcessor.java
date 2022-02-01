package com.tencent.mobileqq.transfile;

import QQService.StreamData;
import QQService.StreamInfo;
import android.os.Environment;
import android.os.StatFs;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import jzk;
import jzl;

public class BuddyTransfileProcessor
  extends BaseTransProcessor
{
  public static final int aM = 1;
  public static final int aN = 2;
  public static final String ac = "pttcenter";
  public static final String ad = "picplatform";
  private static final String ah = "photo/";
  private static final String ai = "file/";
  public static final int av = 0;
  private static List jdField_b_of_type_JavaUtilList = new ArrayList();
  public static final String c = "streamptt";
  public static final String d = "streamptt.recv";
  public static final String e = "streamptt.send";
  public static final String f = "ftn";
  public static boolean l = true;
  long jdField_a_of_type_Long = -1L;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new jzk(this);
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  public boolean a;
  private int aO;
  private String ae = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  private String af;
  private String ag;
  int aq = 0;
  int ar = 1;
  int as = 0;
  int at = -1;
  int au = -1;
  private long jdField_b_of_type_Long;
  public boolean b;
  public boolean k = false;
  public boolean m = false;
  public boolean n = false;
  private boolean o = false;
  
  public BuddyTransfileProcessor(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, int paramInt1, int paramInt2, boolean paramBoolean2, TransFileController paramTransFileController, long paramLong)
  {
    super(paramString1, paramString2, paramBoolean1, paramTransFileController);
    this.jdField_a_of_type_Boolean = false;
    paramInt2 = paramInt1;
    if (paramInt1 == 131075)
    {
      paramInt2 = 1;
      this.jdField_a_of_type_Boolean = true;
    }
    this.ag = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.p = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.q = this.ae;
    if ((!paramBoolean1) && (paramBoolean2))
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.m = this.ae;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.n = paramString1;
    }
    for (this.af = this.ae;; this.af = paramString1)
    {
      b(false);
      e(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.aV = 0;
      if (FileUtils.c(paramString3)) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString = paramString3;
      }
      if ((paramString4 != null) && (!FileUtils.c(paramString4))) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = paramString4;
      }
      if (paramInt2 == 65538)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.h = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d = "gif";
      }
      if (paramInt2 == 2) {
        RichMediaUtil.c(AppSetting.jdField_a_of_type_Int);
      }
      if ((paramInt2 == 2) && (paramBoolean1))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.af, 0, paramLong);
        if (paramString1 != null)
        {
          this.jdField_b_of_type_Long = MessageUtils.a(paramString1.msgUid);
          this.aO = ((int)paramString1.shmsgseq);
        }
        if (QLog.isColorLevel()) {
          QLog.e("streamptt", 2, "random:" + this.jdField_b_of_type_Long + " msgseq:" + this.aO);
        }
      }
      return;
    }
  }
  
  public static BuddyTransfileProcessor.A9Message a(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    BuddyTransfileProcessor.A9Message localA9Message = new BuddyTransfileProcessor.A9Message();
    long l1 = paramArrayOfLong[0];
    byte[] arrayOfByte;
    if (paramArrayOfByte[0] == 1)
    {
      localA9Message.jdField_a_of_type_Byte = paramArrayOfByte[1];
      int i1 = PkgTools.a(paramArrayOfByte, 2) + 4;
      int j = paramArrayOfByte[i1];
      int i = j;
      if (j < 0) {
        i = j + 256;
      }
      j = i1 + 1;
      arrayOfByte = new byte[i];
      PkgTools.a(arrayOfByte, 0, paramArrayOfByte, j, i);
      i += j;
      l1 = PkgTools.a(paramArrayOfByte, i + 2 + PkgTools.a(paramArrayOfByte, i));
      if (arrayOfByte != null) {
        if (l1 > 10000L) {
          paramArrayOfLong[0] = l1;
        }
      }
    }
    for (paramArrayOfByte = new String(arrayOfByte);; paramArrayOfByte = null)
    {
      localA9Message.jdField_a_of_type_JavaLangString = paramArrayOfByte;
      return localA9Message;
    }
  }
  
  public static BuddyTransfileProcessor.C2CPicMsgParseResult a(byte[] paramArrayOfByte, short paramShort, long[] paramArrayOfLong)
  {
    BuddyTransfileProcessor.C2CPicMsgParseResult localC2CPicMsgParseResult;
    long l1;
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getFileUuid msgHex:" + HexUtil.bytes2HexStr(paramArrayOfByte));
      }
      localC2CPicMsgParseResult = new BuddyTransfileProcessor.C2CPicMsgParseResult();
      if (paramShort != 169) {
        break label382;
      }
      localC2CPicMsgParseResult.jdField_a_of_type_Int = 1;
      if (paramArrayOfByte[0] != 1) {
        break label409;
      }
      paramShort = paramArrayOfByte[1];
      int i = PkgTools.a(paramArrayOfByte, 2);
      localC2CPicMsgParseResult.jdField_a_of_type_ArrayOfByte = new byte[i];
      PkgTools.a(localC2CPicMsgParseResult.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, 4, i);
      int j = i + 4;
      i = paramArrayOfByte[j];
      j += 1;
      localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte = new byte[i];
      PkgTools.a(localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, j, i);
      j += i;
      i = PkgTools.a(paramArrayOfByte, j);
      j += 2;
      localC2CPicMsgParseResult.jdField_c_of_type_ArrayOfByte = new byte[i];
      PkgTools.a(localC2CPicMsgParseResult.jdField_c_of_type_ArrayOfByte, 0, paramArrayOfByte, j, i);
      l1 = PkgTools.a(paramArrayOfByte, j + i);
    }
    for (;;)
    {
      if (localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte != null)
      {
        localC2CPicMsgParseResult.jdField_a_of_type_Long = 0L;
        if (l1 > 10000L) {
          paramArrayOfLong[0] = l1;
        }
        localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString = new String(localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "analysisFileC2cMsg  dwReserved: " + l1 + " serverPath:" + localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString != null)
        {
          localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString = TransfileUtile.a(localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString, localC2CPicMsgParseResult.jdField_a_of_type_Long, paramShort, false, localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString);
          }
        }
        return localC2CPicMsgParseResult;
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "getFriendPhotoMsg vMsg is null");
        }
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "analysisFileC2cMsg fail");
        }
        return null;
        label382:
        if ((paramArrayOfByte[0] == 22) && (paramArrayOfByte[1] == 32)) {
          return a(paramArrayOfByte, false);
        }
        paramShort = 0;
      }
      label409:
      l1 = 0L;
      paramShort = 0;
    }
  }
  
  public static BuddyTransfileProcessor.C2CPicMsgParseResult a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    BuddyTransfileProcessor.C2CPicMsgParseResult localC2CPicMsgParseResult = new BuddyTransfileProcessor.C2CPicMsgParseResult();
    localC2CPicMsgParseResult.jdField_a_of_type_Int = 2;
    PkgTools.a(paramArrayOfByte, 2, 3).longValue();
    int j;
    int i;
    if ((paramArrayOfByte[5] == 49) && (paramArrayOfByte[6] == 48))
    {
      PkgTools.a(paramArrayOfByte, 7, 3).longValue();
      if (paramArrayOfByte[10] != 50) {
        break label309;
      }
      j = 11;
      localC2CPicMsgParseResult.jdField_b_of_type_Int = (paramArrayOfByte[11] - 65);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("streamptt", 2, "getFriendPhotoMsg offline file path repeat");
        i = j;
      }
    }
    for (;;)
    {
      if (paramArrayOfByte[i] == 65)
      {
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "parse down file path success");
        }
        if ((paramArrayOfByte.length <= i + 1) || (paramArrayOfByte[(i + 1)] != 10)) {}
      }
      try
      {
        localC2CPicMsgParseResult.d = new String(paramArrayOfByte, "utf-8").substring(i + 2);
        if (localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString != null)
        {
          paramArrayOfByte = null;
          if (localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString.length() > 0) {
            paramArrayOfByte = localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString.split("\\.")[0];
          }
          localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString = TransfileUtile.a(localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString, localC2CPicMsgParseResult.jdField_a_of_type_Long, 1, false, localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString, paramArrayOfByte, null);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "<---decodeOffLinePic : md5Str:" + paramArrayOfByte + ",afterDecode:" + TransfileUtile.a(localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString));
          }
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString);
          }
        }
        return localC2CPicMsgParseResult;
        label309:
        if (paramArrayOfByte[10] == 49)
        {
          i = paramArrayOfByte[11];
          i = 12;
          if (paramArrayOfByte[12] - 65 == 0)
          {
            localC2CPicMsgParseResult.jdField_a_of_type_Long = PkgTools.a(paramArrayOfByte, 13, 10).longValue();
            j = 23;
            i = j;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("streamptt", 2, "getFriendPhotoMsg offline file path fail");
            i = j;
            continue;
          }
          if (paramArrayOfByte[12] - 65 != 1) {
            continue;
          }
          localC2CPicMsgParseResult.jdField_a_of_type_Long = PkgTools.a(paramArrayOfByte, 13, 10).longValue();
          i = paramArrayOfByte[23] - 65;
          byte[] arrayOfByte = new byte[i];
          PkgTools.a(arrayOfByte, 0, paramArrayOfByte, 24, i);
          localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString = new String(arrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "<---decodeOffLinePic : ret.fileName:" + localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString);
          }
          j = i + 24;
          i = paramArrayOfByte[j] - 65;
          j += 1;
          arrayOfByte = new byte[i];
          PkgTools.a(arrayOfByte, 0, paramArrayOfByte, j, i);
          j += i;
          try
          {
            localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString = new String(arrayOfByte, "utf-8");
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString);
              i = j;
            }
          }
          catch (Exception localException)
          {
            i = j;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          QLog.w("streamptt", 2, "buddy_mixed, decode action error");
        }
        i = 10;
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = AppConstants.aG + paramString1 + "/";
    switch (paramInt)
    {
    default: 
      paramArrayOfByte = "";
      paramString1 = null;
      paramString2 = (String)localObject;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getTransferFilePath dir: " + paramString2);
      }
      localObject = new File(paramString2);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString1 = new File(paramString2 + paramArrayOfByte + paramString1);
      if (paramInt == 0) {}
      String str1;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
        }
        return paramString1.getAbsoluteFile().toString();
        paramString1 = (String)localObject + "ptt/";
        String str2 = ".amr";
        str1 = str2;
        localObject = paramString1;
        if (paramString2 != null) {
          break label536;
        }
        if (QLog.isColorLevel()) {
          QLog.i("streamptt", 2, "pttdown,33333");
        }
        paramArrayOfByte = "stream_" + c();
        str1 = str2;
        paramString2 = paramString1;
        localObject = paramArrayOfByte;
        if (!QLog.isColorLevel()) {
          break label527;
        }
        QLog.i("streamptt", 2, "pttdown,name = " + paramArrayOfByte);
        localObject = ".amr";
        paramString2 = paramString1;
        paramString1 = (String)localObject;
        break;
        paramString1 = (String)localObject + "photo/";
        str2 = ".jpg";
        str1 = str2;
        localObject = paramString1;
        if (paramString2 != null) {
          break label536;
        }
        String str3 = c();
        str1 = str2;
        paramString2 = paramString1;
        localObject = str3;
        if (paramArrayOfByte == null) {
          break label527;
        }
        paramArrayOfByte = str3 + HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
        localObject = ".jpg";
        paramString2 = paramString1;
        paramString1 = (String)localObject;
        break;
        str1 = AppConstants.aP;
        localObject = paramString2;
        if (paramString2 == null)
        {
          paramString1 = c();
          localObject = paramString1;
          if (paramArrayOfByte != null) {
            localObject = paramString1 + HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
          }
        }
        paramString1 = "";
        paramString2 = str1;
        paramArrayOfByte = (byte[])localObject;
        break;
        if (!paramString1.exists()) {
          try
          {
            paramString1.createNewFile();
          }
          catch (IOException paramString2) {}
        }
      }
      label527:
      paramString1 = str1;
      paramArrayOfByte = (byte[])localObject;
      continue;
      label536:
      paramArrayOfByte = "";
      paramString1 = str1;
      paramString2 = (String)localObject;
    }
  }
  
  private void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramString, paramInt1, paramLong);
    if ((localMessage != null) && (localMessage.uniseq == paramLong)) {
      localMessage.extraflag = 32768;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, paramLong, 32768, paramInt2);
  }
  
  private void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    int i1 = 0;
    int i = paramUploadStreamStruct.jdField_a_of_type_Short;
    int j = (short)paramUploadStreamStruct.jdField_a_of_type_Int;
    String str = paramUploadStreamStruct.jdField_a_of_type_JavaLangString;
    if (paramBoolean) {
      if (paramUploadStreamStruct.jdField_b_of_type_Int != 0)
      {
        this.au = paramUploadStreamStruct.jdField_b_of_type_Int;
        a(this.ag, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, this.au);
        a(2, 9312, "friend_block");
        d();
        StreamDataManager.c(str);
        StreamDataManager.a(str);
        if (paramUploadStreamStruct.jdField_b_of_type_Int == 58) {
          q();
        }
      }
    }
    do
    {
      int i2;
      do
      {
        do
        {
          int i3;
          do
          {
            do
            {
              return;
              if ((i == -1) || (i == 65535))
              {
                this.m = true;
                c(2);
                this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(StreamDataManager.b(str)));
                this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString).length();
                StreamDataManager.a(str);
                this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.fileKey;
                if (paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.pttTransFlag == 1) {
                  i1 = 1;
                }
                this.at = i1;
                this.jdField_a_of_type_Long = paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.msgTime;
                e();
                return;
              }
            } while (this.m);
            i1 = StreamDataManager.a(str);
            if (i1 > 10)
            {
              if (QLog.isColorLevel()) {
                QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: preLayer > 10");
              }
              a(2, 9310, "retry overflow");
              d();
              StreamDataManager.c(str);
              StreamDataManager.a(str);
              return;
            }
            i3 = StreamDataManager.d(str);
            i2 = StreamDataManager.b(str);
            this.ar = i;
            QLog.d("streamptt.send", 2, "server reset.ResetSeq: " + i + " packnum: " + i2 + ",slices:" + i3 + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long + ",flowLayer:" + j + ",prelayer:" + i1);
          } while (i1 >= j);
          StreamDataManager.a(str, j);
          i1 = i2;
          if (i2 == 0) {
            i1 = i3 - 1;
          }
          a(true, i, (short)i1);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(2, 2);
          return;
        } while (this.m);
        i1 = StreamDataManager.d(str);
        i2 = StreamDataManager.a(str);
        if (paramUploadStreamStruct.jdField_a_of_type_Int >= i2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: info.layer < flowlayer");
      return;
      if (this.as == i)
      {
        if (this.aq < 8)
        {
          this.aq += 1;
          this.as = 0;
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.send", 2, "client check timeout.retry:severAckSlice:" + this.ar + " packnum: " + i1 + " maxSendSeq:" + this.as + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long + ",retryCount:" + this.aq + ",flowLayer:" + i2);
          }
          a(true, (short)this.ar, (short)i1);
          return;
        }
        a(2, 9310, "timeout");
        d();
        StreamDataManager.a(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: sendSeqMax != shResetSeq");
  }
  
  private static String c()
  {
    try
    {
      Thread.sleep(1L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void q()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    long l1 = MessageCache.a();
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2012);
    localMessageRecord.init(str, this.ag, str, "你已屏蔽%s的会话", l1, 0, 0, l1);
    localMessageRecord.msgtype = -2012;
    localMessageRecord.isread = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, str);
  }
  
  public MessageRecord a(long paramLong, StreamInfo paramStreamInfo)
  {
    int i = 0;
    Object localObject = new byte[3];
    PkgTools.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i.length(), (byte[])localObject, 0, 3, "utf-8");
    localObject = (MessageForPtt)MessageRecordFactory.a(-2002);
    ((MessageForPtt)localObject).selfuin = this.ae;
    ((MessageForPtt)localObject).frienduin = this.ag;
    ((MessageForPtt)localObject).senderuin = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.m;
    ((MessageForPtt)localObject).isread = false;
    ((MessageForPtt)localObject).time = MessageCache.a();
    ((MessageForPtt)localObject).time = paramStreamInfo.msgTime;
    ((MessageForPtt)localObject).setPttStreamFlag(10001);
    ((MessageForPtt)localObject).msgtype = -2002;
    ((MessageForPtt)localObject).istroop = 0;
    ((MessageForPtt)localObject).urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i;
    ((MessageForPtt)localObject).url = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
    ((MessageForPtt)localObject).fileSize = 1000L;
    ((MessageForPtt)localObject).itemType = 2;
    ((MessageForPtt)localObject).isread = false;
    ((MessageForPtt)localObject).shmsgseq = paramStreamInfo.msgSeq;
    ((MessageForPtt)localObject).msgUid = MessageUtils.a((int)paramStreamInfo.random);
    if ((paramStreamInfo.pttTransFlag == 1) || (SttManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      i = 1;
    }
    ((MessageForPtt)localObject).sttAbility = i;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((MessageForPtt)localObject).isSend()) {}
    for (paramStreamInfo = this.ae;; paramStreamInfo = this.ag)
    {
      ((MessageForPtt)localObject).longPttVipFlag = MessageUtils.a(localQQAppInterface, paramStreamInfo);
      ((MessageForPtt)localObject).serial();
      long l1 = paramLong;
      if (paramLong == 4294967295L)
      {
        paramLong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPtt)localObject).frienduin);
        l1 = paramLong;
        if (QLog.isColorLevel())
        {
          QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent: invalid bubbleID 0xffffffff. get one from cache:" + paramLong);
          l1 = paramLong;
        }
      }
      ((MessageForPtt)localObject).vipBubbleID = l1;
      if (QLog.isColorLevel()) {
        QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent:time" + ((MessageForPtt)localObject).time + " urlAtServer:" + ((MessageForPtt)localObject).urlAtServer + " bubbleId:" + l1 + " msgseq:" + ((MessageForPtt)localObject).shmsgseq + " msgUid:" + ((MessageForPtt)localObject).msgUid);
      }
      paramStreamInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPtt)localObject).frienduin, ((MessageForPtt)localObject).istroop);
      if ((paramStreamInfo == null) || (paramStreamInfo.size() <= 0)) {
        break;
      }
      paramStreamInfo = paramStreamInfo.iterator();
      do
      {
        if (!paramStreamInfo.hasNext()) {
          break;
        }
      } while (!MsgProxyUtils.a((MessageRecord)paramStreamInfo.next(), (MessageRecord)localObject, true));
      if (QLog.isColorLevel()) {
        QLog.w("streamptt", 2, "same Ptt :" + ((MessageForPtt)localObject).getBaseInfoString());
      }
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject, this.ae);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(((MessageForPtt)localObject).uniseq);
    return localObject;
  }
  
  public void a() {}
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.d = true;
    b(2);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(4, paramStreamData.vData.length);
    switch (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
          {
            if (!Environment.getExternalStorageState().equals("mounted")) {
              a(9039, "not mounted");
            }
            for (;;)
            {
              d();
              return;
              a(9040, "no enough storage");
            }
          }
          i = StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.recv", 2, "curFlowLayer: " + i + " received shFlowLayer:" + paramStreamInfo.shFlowLayer + ",seq" + paramStreamData.shPackSeq + ",packNum:" + paramStreamInfo.shPackNum + " lkey:" + paramLong1);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), 2, 0, paramStreamData.vData.length);
          StreamDataManager.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramLong1);
          if (i != paramStreamInfo.shFlowLayer)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.ae, this.af, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, StreamDataManager.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i), paramLong1);
            return;
          }
          if (StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramStreamData.shPackSeq))
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(2, 2);
            short s = (short)(StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i) + 1);
            StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, s);
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack JudgeReceiveError flowLayer: " + s);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.ae, this.af, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, StreamDataManager.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i), paramLong1);
            return;
          }
          if (paramStreamInfo.oprType == 1) {}
          for (i = 1; i != 0; i = 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "cancelled:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.ag, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
            StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
            StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
            return;
          }
          StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramStreamInfo.shFlowLayer);
          StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramStreamData.vData, 800, paramStreamData.shPackSeq);
        } while (paramStreamInfo.shPackNum <= 0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.ag, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
        StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
        StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
        paramStreamData = this.ae + "_" + this.af + "_" + paramStreamInfo.iMsgId;
        if (!jdField_b_of_type_JavaUtilList.contains(paramStreamData)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.recv", 2, "find stream stream duplicate,discard it ,key:" + paramStreamData);
      return;
      jdField_b_of_type_JavaUtilList.add(paramStreamData);
      long l1 = paramStreamInfo.iSendTime;
      paramStreamData = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(l1 * 1000L));
      paramStreamData = this.af + "_" + paramStreamData;
      if (QLog.isColorLevel()) {
        QLog.d("streamptt.recv", 2, "stream duplicateKey:" + paramStreamData);
      }
      if (!StreamDataManager.e(paramStreamData)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.recv", 2, "find stream offline duplicate,stop stream recv");
    return;
    StreamDataManager.c(paramStreamData);
    c(2);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack received success path: " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.ae, this.af, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, (short)-1, paramLong1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = paramStreamInfo.fileKey;
    if (paramStreamInfo.pttTransFlag == 1) {}
    for (int i = 1;; i = 0)
    {
      this.at = i;
      if (a(paramLong2, paramStreamInfo) != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
      }
      e();
      return;
    }
  }
  
  public void a(short paramShort, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.d = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ("0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {}
    String str;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.D = 1001;
      b(2);
      this.jdField_b_of_type_Boolean = false;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      b(2);
      if (paramShort > this.as) {
        this.as = paramShort;
      }
      switch (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int)
      {
      default: 
        return;
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new jzl(this, str, paramShort, paramBoolean));
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 2) {
          break label338;
        }
        MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.ag, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
        localMessageForPtt.url = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
        localMessageForPtt.fileSize = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long;
        localMessageForPtt.itemType = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.ad != 1) {
          break label339;
        }
        paramBoolean = true;
        localMessageForPtt.isread = paramBoolean;
        localMessageForPtt.urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i;
        if (SttManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localMessageForPtt.sttAbility = 1;
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (localMessageForPtt.isSend())
          {
            Object localObject = this.ae;
            localMessageForPtt.longPttVipFlag = MessageUtils.a(localQQAppInterface, (String)localObject);
            localMessageForPtt.serial();
            if (QLog.isColorLevel()) {
              QLog.e("streamptt.send", 2, "Stream ptt:updataMessageDataBaseContent:time" + localMessageForPtt.time + " urlAtServer:" + localMessageForPtt.urlAtServer);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.ag, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, localMessageForPtt.msgData);
            localMessageForPtt.time = this.jdField_a_of_type_Long;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.ag, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, this.jdField_a_of_type_Long);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.ag, 0);
            if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i == null) || (!this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
              break label338;
            }
            ((QQMessageFacade.Message)localObject).pttUrl = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
          }
        }
        else
        {
          localMessageForPtt.sttAbility = this.at;
          continue;
        }
        String str = this.ag;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      continue;
      label338:
      return;
      label339:
      paramBoolean = false;
    }
  }
  
  public void a(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    while (paramShort1 <= paramShort2)
    {
      a((short)paramShort1, true);
      paramShort1 += 1;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  }
  
  protected void c(boolean paramBoolean)
  {
    if (RichMediaStrategy.c(this.aC)) {}
    label557:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 2) && (!this.o) && (!RichMediaStrategy.c(this.aC)))
      {
        long l1 = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
        HashMap localHashMap = new HashMap();
        if (!this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.d) {
          localHashMap.put("param_step", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a(2) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a(3));
        }
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0)
          {
            localHashMap.put("param_toUin", this.af);
            localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_a_of_type_JavaUtilHashMap);
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CStreamPttUpload", true, l1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, localHashMap, "");
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-2002);
            return;
          }
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CStreamPttDownload", true, l1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, localHashMap, "");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
          if (!BaseTransProcessor.a(this.aC, localHashMap))
          {
            localHashMap.put("param_FailCode", Integer.toString(this.aC));
            if ((this.aC == -9527) || (this.aC == 9311) || (this.aC == 9044) || (this.aC == 9350) || (this.aC == 9351))
            {
              localHashMap.put(BaseTransProcessor.V, this.T);
              localHashMap.put("param_toUin", this.af);
              StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CStreamPttUpload", false, l1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, localHashMap, "");
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-2002);
            }
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 2) {
            break label557;
          }
          RichMediaUtil.c(true, String.valueOf(this.aC) + "_" + this.T);
          return;
          localHashMap.put("param_errorDesc", this.T);
          break;
          this.aC = -9527;
          localHashMap.put("param_errorDesc", this.T);
          break;
          localHashMap.put("param_FailCode", String.valueOf(this.aC));
          localHashMap.put("param_errorDesc", this.T);
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CStreamPttDownload", false, l1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, localHashMap, "");
        }
      }
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
    long l1 = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      a(9366, "account switch");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {}
    for (String str = "streamptt.send";; str = "streamptt.recv")
    {
      QLog.d(str, 2, "onError elapsed:" + l1 + " errCode:" + this.aC + " errDesc:" + this.T + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason") + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      c(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int != 0) {
        break;
      }
      d(1005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.ag, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      return;
    }
    d(2005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.ag, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
  }
  
  void e()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
    long l1 = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {}
    for (String str = "streamptt.send";; str = "streamptt.recv")
    {
      QLog.d(str, 2, "onSuccess elapsed:" + l1 + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      c(true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
        a(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int != 0) {
        break;
      }
      d(1003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.m, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      return;
    }
    d(2003);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.ag, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor
 * JD-Core Version:    0.7.0.1
 */