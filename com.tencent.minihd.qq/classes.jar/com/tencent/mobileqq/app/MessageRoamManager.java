package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import hlw;
import hlx;
import hly;
import hlz;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class MessageRoamManager
  implements Manager
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "Q.roammsg.MessageRoamManager";
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "first_page_date";
  public static final int c = 0;
  private static final String jdField_c_of_type_JavaLangString = "last_page_date";
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  private static final int g = 604800;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoamDateCache jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
  private MessageRoamHandler jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private Calendar jdField_c_of_type_JavaUtilCalendar;
  private String jdField_d_of_type_JavaLangString;
  private Calendar jdField_d_of_type_JavaUtilCalendar;
  private Calendar e;
  private Calendar f;
  private int h = -1;
  private int i = -1;
  
  public MessageRoamManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler = ((MessageRoamHandler)paramQQAppInterface.a(59));
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache = ((RoamDateCache)paramQQAppInterface.a().a(2));
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0);
    String str = localSharedPreferences.getString("vip_message_roam_passwordmd5" + paramQQAppInterface.a(), null);
    if (str == null) {}
    for (this.jdField_a_of_type_ArrayOfByte = null;; this.jdField_a_of_type_ArrayOfByte = Base64.decode(str, 0))
    {
      paramQQAppInterface = localSharedPreferences.getString("vip_message_roam_signture" + paramQQAppInterface.a(), null);
      if (paramQQAppInterface != null) {
        break;
      }
      this.jdField_b_of_type_ArrayOfByte = null;
      return;
    }
    this.jdField_b_of_type_ArrayOfByte = Base64.decode(paramQQAppInterface, 0);
  }
  
  private long a(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("date is null!");
    }
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
    return paramCalendar.getTimeInMillis();
  }
  
  private Cursor a(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    if (localSQLiteDatabase == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "MessageProvide getDB null!");
      }
    }
    do
    {
      return null;
      if (paramString1.indexOf("mr_troop_") == -1) {
        break;
      }
      paramString2 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase);
    } while (paramString2 == null);
    paramString2.append(" t left join TroopMemberInfo m on t.senderuin=m.memberuin and t.frienduin=m.troopuin");
    if ((paramString3 != null) && (paramString3.length() > 0))
    {
      paramString2.append(" where ");
      paramString2.append(paramString3);
    }
    for (;;)
    {
      try
      {
        paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
        paramString1 = paramString2;
      }
      catch (SQLException paramString2)
      {
        paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
        continue;
      }
      return paramString1;
      if (paramString1.indexOf("mr_grp_") != -1)
      {
        paramString2 = new StringBuilder("select * from ");
        paramString2.append(paramString1);
        paramString2.append(" t left join GrpMemberInfo m on t.senderuin=m.mId and t.frienduin=m.grpID left join friends l on m.mId =l.uin ");
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          paramString2.append(" where ");
          paramString2.append(paramString3);
        }
        try
        {
          paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
          paramString1 = paramString2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("gene", 2, "cursor: " + paramString2);
          paramString1 = paramString2;
        }
        catch (SQLException paramString2)
        {
          for (;;)
          {
            paramString2 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
          }
        }
      }
      else
      {
        if (paramString1.indexOf("mr_discusssion_") != -1)
        {
          paramString2 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase);
          if (paramString2 == null) {
            break;
          }
          paramString2.append(" t left join DiscussionMemberInfo m on t.senderuin=m.memberUin and t.frienduin=m.discussionUin");
          if ((paramString3 != null) && (paramString3.length() > 0))
          {
            paramString2.append(" where ");
            paramString2.append(paramString3);
          }
          try
          {
            paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
            paramString1 = paramString2;
          }
          catch (SQLException paramString2)
          {
            paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
          }
          continue;
        }
        paramString2 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
        try
        {
          paramString2 = localSQLiteDatabase.a(paramString2.toString(), null);
          paramString1 = paramString2;
        }
        catch (SQLException paramString2)
        {
          paramString1 = localSQLiteDatabase.a(paramString1, null, paramString3, null, null, null);
        }
      }
    }
  }
  
  private String a()
  {
    String str = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if ((str != null) && (!str.trim().equals(""))) {
      return str;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private String a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
    localSimpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
    return localSimpleDateFormat.format(Long.valueOf(paramLong));
  }
  
  private String a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg == null) || (!AbsShareMsg.class.isInstance(paramAbsStructMsg))) {
      return null;
    }
    paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
    StringBuffer localStringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgBrief)) {
      localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (!TextUtils.isEmpty(paramAbsStructMsg.mSourceName))
      {
        localStringBuffer.append(paramAbsStructMsg.mSourceName);
        localStringBuffer.append(" " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368751) + " ");
        if (!TextUtils.isEmpty(paramAbsStructMsg.mContentTitle)) {
          localStringBuffer.append(paramAbsStructMsg.mContentTitle);
        }
      }
    }
  }
  
  private List a(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    if (localSQLiteDatabase == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "rawQuery db = null!");
      }
      return null;
    }
    paramString1 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
    if (paramString1 == null) {
      return null;
    }
    return ((MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createMessageRecordEntityManager()).a(paramString1.toString(), null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    a(localCalendar);
  }
  
  private void a(Calendar paramCalendar)
  {
    if (this.jdField_d_of_type_JavaUtilCalendar == null) {
      this.jdField_d_of_type_JavaUtilCalendar = Calendar.getInstance();
    }
    this.jdField_d_of_type_JavaUtilCalendar.set(1, paramCalendar.get(1));
    this.jdField_d_of_type_JavaUtilCalendar.set(2, paramCalendar.get(2));
    this.jdField_d_of_type_JavaUtilCalendar.set(5, paramCalendar.get(5));
    this.jdField_d_of_type_JavaUtilCalendar.set(11, 0);
    this.jdField_d_of_type_JavaUtilCalendar.set(12, 0);
    this.jdField_d_of_type_JavaUtilCalendar.set(13, 0);
    this.jdField_d_of_type_JavaUtilCalendar.set(14, 0);
  }
  
  private boolean a(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void b(long paramLong)
  {
    Calendar localCalendar;
    if (this.jdField_b_of_type_Boolean) {
      if (a(paramLong - 5L, this.jdField_b_of_type_JavaUtilCalendar))
      {
        localCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.b(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilCalendar);
        if (localCalendar != null) {
          this.jdField_b_of_type_JavaUtilCalendar = localCalendar;
        }
      }
    }
    label51:
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            break label51;
            break label51;
            do
            {
              return;
            } while (!a(paramLong - 5L, this.c));
            localCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, this.c);
          } while (localCalendar == null);
          this.c = localCalendar;
          return;
          if (!a(paramLong - 5L, this.e)) {
            break;
          }
          j = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.e)));
        } while ((j == -1) || (j >= this.jdField_a_of_type_JavaUtilList.size() - 1));
        this.e.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(j + 1)).longValue());
        return;
      } while (!a(paramLong - 5L, this.f));
      j = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.f)));
    } while (j <= 0);
    this.f.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(j - 1)).longValue());
  }
  
  private boolean b(long paramLong, Calendar paramCalendar)
  {
    paramCalendar = a((Calendar)paramCalendar.clone());
    return (paramLong >= ((Long)paramCalendar.first).longValue()) && (paramLong <= ((Long)paramCalendar.second).longValue());
  }
  
  private boolean b(Calendar paramCalendar)
  {
    int j = paramCalendar.get(1);
    int k = paramCalendar.get(2);
    int m = paramCalendar.get(5);
    paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, j, k + 1);
    return (paramCalendar == null) || (paramCalendar.getSerState(m - 1) == 0) || (paramCalendar.getSerState(m - 1) == 1);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0) || (paramInt1 < 0)) {
      return null;
    }
    return c(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private boolean c(Calendar paramCalendar)
  {
    long l = ((Long)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_d_of_type_JavaLangString).first).longValue();
    Pair localPair = a((Calendar)paramCalendar.clone());
    if ((l > ((Long)localPair.first).longValue()) && (l <= ((Long)localPair.second).longValue()))
    {
      int j = paramCalendar.get(1);
      int k = paramCalendar.get(2);
      int m = paramCalendar.get(5);
      paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, j, k + 1);
      if (paramCalendar != null)
      {
        paramCalendar.setLocState(m - 1, 0);
        this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(paramCalendar);
      }
      return true;
    }
    return false;
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0)) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private boolean f()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      localObject = a();
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "createLocMsgDateLine fasle");
      }
      return false;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      long l = ((MessageRecord)((Iterator)localObject).next()).time;
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l * 1000L);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l = localCalendar.getTimeInMillis();
      if (!this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(l))) {
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
      }
    }
    if (this.f == null)
    {
      this.f = Calendar.getInstance();
      this.f.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).longValue());
    }
    if (this.e == null)
    {
      this.e = Calendar.getInstance();
      this.e.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "createLocMsgDateLine true");
    }
    return true;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder(" msgtype ");
      localStringBuilder.append(MsgProxyUtils.b());
      localStringBuilder.append(" and isValid=1 ");
    }
    for (paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", localStringBuilder.toString(), ""); paramString == null; paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString()))
    {
      return 0;
      localStringBuilder = new StringBuilder(" where msgtype ");
      localStringBuilder.append(MsgProxyUtils.b());
      localStringBuilder.append(" and isValid=1 ");
    }
    paramString = localSQLiteDatabase.a(paramString.toString(), null);
    if (paramString == null) {
      return 0;
    }
    long l;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label237;
      }
      l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l > 0L) {
        paramStringBuilder.append(String.valueOf(l));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label237:
      if (paramInt == 0) {
        l = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l = 0L;
      }
    }
  }
  
  public Pair a(Calendar paramCalendar)
  {
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
    long l = paramCalendar.getTimeInMillis() / 1000L;
    paramCalendar.set(11, 23);
    paramCalendar.set(12, 59);
    paramCalendar.set(13, 59);
    paramCalendar.set(14, 0);
    return new Pair(Long.valueOf(l), Long.valueOf(paramCalendar.getTimeInMillis() / 1000L));
  }
  
  public RoamDateCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
  }
  
  public MessageRoamHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler;
  }
  
  public Calendar a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilCalendar;
    }
    return this.jdField_d_of_type_JavaUtilCalendar;
  }
  
  public List a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getAllMessageFormDB: friendUin = " + this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_d_of_type_JavaLangString == null)
    {
      Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      localHandler.sendMessageDelayed(localHandler.obtainMessage(29), 0L);
    }
    return a(MessageRecord.getTableName(this.jdField_d_of_type_JavaLangString, 0), null, "1 " + "ORDER BY time asc , longMsgIndex asc");
  }
  
  public List a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageFromDB: friendUin = " + paramString + ", start = " + paramLong1 + ", end = " + paramLong2);
    }
    String str = "time BETWEEN " + paramLong1 + " AND " + paramLong2;
    return a(MessageRecord.getTableName(paramString, 0), null, str + " " + "ORDER BY time asc , longMsgIndex asc");
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a());
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.d();
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilCalendar = null;
    this.jdField_b_of_type_JavaUtilCalendar = null;
    this.c = null;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_d_of_type_JavaUtilCalendar = null;
    this.e = null;
    this.f = null;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_JavaUtilCalendar == null) {
      this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    }
    this.jdField_a_of_type_JavaUtilCalendar.set(1, paramInt1);
    this.jdField_a_of_type_JavaUtilCalendar.set(2, paramInt2);
    this.jdField_a_of_type_JavaUtilCalendar.set(5, paramInt3);
    this.jdField_a_of_type_JavaUtilCalendar.set(11, 0);
    this.jdField_a_of_type_JavaUtilCalendar.set(12, 0);
    this.jdField_a_of_type_JavaUtilCalendar.set(13, 0);
    this.jdField_a_of_type_JavaUtilCalendar.set(14, 0);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    long l = paramMessageRecord.time;
    paramMessageRecord = Calendar.getInstance();
    paramMessageRecord.setTimeInMillis(l * 1000L);
    if (!this.jdField_b_of_type_Boolean)
    {
      a(paramMessageRecord);
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      paramMessageRecord.sendMessageDelayed(paramMessageRecord.obtainMessage(0), 0L);
      return;
    }
    Object localObject = Calendar.getInstance();
    if ((paramMessageRecord.get(1) == ((Calendar)localObject).get(1)) && (paramMessageRecord.get(2) == ((Calendar)localObject).get(2)) && (paramMessageRecord.get(5) == ((Calendar)localObject).get(5)) && (c(paramMessageRecord))) {}
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        a(false);
        return;
      }
      j = paramMessageRecord.get(1);
      int k = paramMessageRecord.get(2) + 1;
      int m = paramMessageRecord.get(5);
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, j, k);
      a(j, k - 1, m);
      if (paramMessageRecord == null)
      {
        a(false);
        return;
      }
      switch (paramMessageRecord.getLocState(m - 1))
      {
      case 2: 
      case 1: 
      default: 
        return;
      case 0: 
        if (NetworkUtil.e(BaseApplication.getContext()))
        {
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
          paramMessageRecord.sendMessageDelayed(paramMessageRecord.obtainMessage(21), 0L);
          paramMessageRecord = Calendar.getInstance();
          paramMessageRecord.setTime(new Date(j - 1900, k - 1, m));
          this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_d_of_type_JavaLangString, paramMessageRecord);
          return;
        }
        paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
        localObject = paramMessageRecord.obtainMessage(1);
        ((Message)localObject).arg1 = -1;
        paramMessageRecord.sendMessageDelayed((Message)localObject, 0L);
        return;
      }
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      paramMessageRecord.sendMessageDelayed(paramMessageRecord.obtainMessage(0), 0L);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a());
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(paramString);
    this.jdField_d_of_type_JavaLangString = paramString;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    long l1 = paramString.getLong("first_page_date" + this.jdField_d_of_type_JavaLangString, 0L);
    long l2 = paramString.getLong("last_page_date" + this.jdField_d_of_type_JavaLangString, 0L);
    this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
    if (l1 != 0L) {
      this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(l1);
    }
    this.c = Calendar.getInstance();
    if (l2 != 0L) {
      this.c.setTimeInMillis(l2);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, StringBuffer paramStringBuffer)
  {
    Object localObject2 = "";
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1;
    Cursor localCursor;
    label160:
    int k;
    label233:
    int j;
    Object localObject4;
    if ((paramInt == 1) || (paramInt == 3000))
    {
      localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString1, paramInt), MessageRecord.getTableName(paramString1, paramInt), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b());
      if (localObject1 == null) {
        break label1194;
      }
      localCursor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b().a(((StringBuilder)localObject1).toString(), null);
      if (paramInt == 1)
      {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 1);
        localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367020) + ":");
        localStringBuffer.append((String)localObject1);
        localStringBuffer.append("\r\n===========================================\r\n");
      }
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        localObject1 = localObject2;
        k = localCursor.getInt(localCursor.getColumnIndex("time"));
        localObject2 = localCursor.getString(localCursor.getColumnIndex("senderuin"));
        if (1 != paramInt) {
          break label621;
        }
        localObject2 = String.format("%s(%s)", new Object[] { ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, (String)localObject2), localObject2 });
        j = localCursor.getInt(localCursor.getColumnIndex("issend"));
        if (!MsgUtils.a(j)) {
          break label667;
        }
        localObject4 = a();
        label266:
        if ((localCursor.getColumnIndex("versionCode") >= 0) && (localCursor.getInt(localCursor.getColumnIndex("versionCode")) > 0)) {
          break label674;
        }
        localObject1 = localCursor.getString(localCursor.getColumnIndex("msg"));
      }
    }
    label318:
    Object localObject5;
    label395:
    label424:
    label621:
    int m;
    for (;;)
    {
      localObject5 = new QQText((CharSequence)localObject1, 3).a();
      localObject2 = localObject5;
      if (localObject5 != null)
      {
        localObject2 = localObject5;
        if (((String)localObject5).length() > 0)
        {
          localObject2 = localObject5;
          if (a((String)localObject5))
          {
            localObject2 = localObject5.split("\026")[1].split("\\|");
            if (localObject2.length >= 2) {
              break label1123;
            }
            j = 1;
            if ((j != 1) && (j != 65538)) {
              break label1138;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366789);
          }
        }
      }
      localObject2 = a(k * 1000L) + "  " + (String)localObject4 + "\r\n" + (String)localObject2;
      localStringBuffer.append((String)localObject2 + "\r\n\r\n");
      label667:
      label674:
      do
      {
        if (localCursor.moveToNext()) {
          break label1191;
        }
        if (localCursor != null) {
          localCursor.close();
        }
        boolean bool = FileUtils.a(AppConstants.aG, paramStringBuffer.toString(), localStringBuffer.toString());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class).obtainMessage(11, Boolean.valueOf(bool)).sendToTarget();
        return;
        localObject1 = "( isValid=1 and msgtype " + MsgProxyUtils.b() + " ) ORDER BY time asc , longMsgIndex asc";
        localObject1 = MessageDBUtils.a(MessageRecord.getOldTableName(paramString1, paramInt), MessageRecord.getTableName(paramString1, paramInt), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(), (String)localObject1, null);
        break;
        if (3000 == paramInt)
        {
          localObject2 = String.format("%s(%s)", new Object[] { ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, 0), localObject2 });
          break label233;
        }
        localObject2 = paramString2;
        break label233;
        localObject4 = localObject2;
        break label266;
        m = localCursor.getInt(localCursor.getColumnIndex("msgtype"));
        if (m == -2007)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368619);
          break label318;
        }
        if (m == -2011)
        {
          localObject1 = a(StructMsgFactory.a(localCursor.getBlob(localCursor.getColumnIndex("msgData"))));
          break label318;
        }
        if (m == -2020)
        {
          if (MsgUtils.a(j))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366057, new Object[] { paramString2 });
            break label318;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366056);
          break label318;
        }
      } while (m == -2006);
      if (m == -2000)
      {
        localObject1 = "[图片]";
      }
      else if (m == -2002)
      {
        localObject1 = "[语音]";
      }
      else
      {
        if (m != -2022) {
          break label875;
        }
        localObject1 = "[视频]";
      }
    }
    label875:
    if (m == -1035) {
      localObject1 = new StringBuilder();
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          for (;;)
          {
            localObject5 = localCursor.getBlob(localCursor.getColumnIndex("msgData"));
            localObject2 = new MixedMsg.Msg();
            try
            {
              ((MixedMsg.Msg)localObject2).mergeFrom((byte[])localObject5);
              if (((MixedMsg.Msg)localObject2).elems.get().size() <= 0) {
                break;
              }
              m = ((MixedMsg.Msg)localObject2).elems.get().size();
              j = 0;
              if (j < m)
              {
                localObject5 = (MixedMsg.Elem)((MixedMsg.Msg)localObject2).elems.get().get(j);
                if (!((MixedMsg.Elem)localObject5).textMsg.has()) {
                  break label1054;
                }
                ((StringBuilder)localObject1).append(((MixedMsg.Elem)localObject5).textMsg.get());
              }
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              for (;;)
              {
                localInvalidProtocolBufferMicroException.printStackTrace();
              }
            }
          }
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.roammsg.MessageRoamManager", 2, "Parse mix message error");
          }
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        label1054:
        if (!localInvalidProtocolBufferMicroException.picMsg.has()) {
          break label1200;
        }
        ((StringBuilder)localObject1).append("[图片]");
        break label1200;
        try
        {
          String str = new String(localCursor.getBlob(localCursor.getColumnIndex("msgData")), "UTF-8");
          localObject1 = str;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      break label318;
      label1123:
      j = Integer.valueOf(localException2[2]).intValue();
      break label395;
      label1138:
      Object localObject3 = localInvalidProtocolBufferMicroException;
      if (j != 2) {
        break label424;
      }
      localObject3 = "[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366476) + "]";
      break label424;
      label1191:
      break label160;
      label1194:
      localCursor = null;
      break;
      label1200:
      j += 1;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_d_of_type_JavaLangString != null) {}
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(paramString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    if (localObject != null)
    {
      localObject = (Calendar)((Pair)localObject).first;
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(paramString, (Calendar)localObject, localCalendar, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.d();
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = Calendar.getInstance();
    int j = ((Calendar)localObject).get(1);
    int k = ((Calendar)localObject).get(2);
    int m = ((Calendar)localObject).get(5);
    if ((paramBoolean) || (c((Calendar)localObject)) || (b((Calendar)localObject)))
    {
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
        ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(21), 0L);
        this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_d_of_type_JavaLangString, 0, 1, j, k + 1, m);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      Message localMessage = ((Handler)localObject).obtainMessage(14);
      localMessage.arg1 = 1;
      ((Handler)localObject).sendMessageDelayed(localMessage, 0L);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
    ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(16), 0L);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "savePasswordMD5ForRoamMessage signature" + Arrays.toString(this.jdField_b_of_type_ArrayOfByte));
    }
    new hly(this, "MessageRoamManager").start();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilCalendar != null;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = true;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
    if (this.jdField_a_of_type_JavaUtilCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "isSameDay return false: mCurPageDate == null");
      }
      return false;
    }
    if ((localCalendar.get(1) == this.jdField_a_of_type_JavaUtilCalendar.get(1)) && (localCalendar.get(2) == this.jdField_a_of_type_JavaUtilCalendar.get(2)) && (localCalendar.get(5) == this.jdField_a_of_type_JavaUtilCalendar.get(5))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(long paramLong, Calendar paramCalendar)
  {
    boolean bool = true;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
    if (paramCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "isSameDay return false: day == null");
      }
      return false;
    }
    if ((localCalendar.get(1) == paramCalendar.get(1)) && (localCalendar.get(2) == paramCalendar.get(2)) && (localCalendar.get(5) == paramCalendar.get(5))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(Calendar paramCalendar)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "isSameDay return false: mCurPageDate == null");
      }
      return false;
    }
    if ((paramCalendar.get(1) == this.jdField_a_of_type_JavaUtilCalendar.get(1)) && (paramCalendar.get(2) == this.jdField_a_of_type_JavaUtilCalendar.get(2)) && (paramCalendar.get(5) == this.jdField_a_of_type_JavaUtilCalendar.get(5))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public Calendar b()
  {
    return this.jdField_b_of_type_JavaUtilCalendar;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilCalendar = null;
    this.jdField_b_of_type_JavaUtilCalendar = null;
    this.c = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2 - 1);
    localCalendar.set(5, paramInt3);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_d_of_type_JavaLangString, 0);
    Object localObject;
    if (localList != null)
    {
      localObject = localList;
      if (!localList.isEmpty()) {}
    }
    else
    {
      localObject = a((Calendar)localCalendar.clone());
      localObject = a(this.jdField_d_of_type_JavaLangString, ((Long)((Pair)localObject).first).longValue(), ((Long)((Pair)localObject).second).longValue());
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (b(((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time, (Calendar)localCalendar.clone())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeLatestMsgInToday: friendUin = " + this.jdField_d_of_type_JavaLangString + ", year/month/day = " + paramInt1 + "/" + paramInt2 + "/" + paramInt3);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, localCalendar.getTimeInMillis() / 1000L, 2);
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(str);
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(1000L * l);
    Object localObject2 = a((Calendar)((Calendar)localObject1).clone());
    List localList;
    if (this.jdField_d_of_type_JavaLangString != null)
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localList = a((String)localObject1, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("judgeClearRoamDateIndex: friendUin = ");
        if (this.jdField_d_of_type_JavaLangString != null) {
          break label399;
        }
        localObject1 = str;
        label133:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(", dayList.size() = ");
        if (localList != null) {
          break label408;
        }
        localObject1 = "null";
        label158:
        QLog.d("Q.roammsg.MessageRoamManager", 2, localObject1);
      }
      localObject1 = new ArrayList();
      if ((paramMessageRecord instanceof MessageForLongMsg))
      {
        ((List)localObject1).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: delList.size() = " + ((List)localObject1).size());
        }
      }
      if (!((List)localObject1).isEmpty()) {
        break label429;
      }
      if ((localList != null) && (localList.size() == 1))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString == null) {
          break label423;
        }
        paramMessageRecord = this.jdField_d_of_type_JavaLangString;
        label287:
        ((RoamDateCache)localObject1).a(paramMessageRecord, l - 5L, 1);
        paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString != null) {
          str = this.jdField_d_of_type_JavaLangString;
        }
        paramMessageRecord.b(str, l - 5L, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l);
        }
        if (this.jdField_d_of_type_JavaLangString != null) {
          b(l);
        }
      }
    }
    label399:
    label408:
    label423:
    label429:
    do
    {
      if (this.jdField_d_of_type_JavaLangString == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.d();
      }
      return;
      localObject1 = str;
      break;
      localObject1 = this.jdField_d_of_type_JavaLangString;
      break label133;
      localObject1 = Integer.valueOf(localList.size());
      break label158;
      paramMessageRecord = str;
      break label287;
      if (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time > ((Long)((Pair)localObject2).second).longValue()) {
        break label605;
      }
    } while ((localList == null) || (localList.size() != ((List)localObject1).size()));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
    if (this.jdField_d_of_type_JavaLangString != null) {}
    for (paramMessageRecord = this.jdField_d_of_type_JavaLangString;; paramMessageRecord = str)
    {
      ((RoamDateCache)localObject1).a(paramMessageRecord, l - 5L, 1);
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
      if (this.jdField_d_of_type_JavaLangString != null) {
        str = this.jdField_d_of_type_JavaLangString;
      }
      paramMessageRecord.b(str, l - 5L, 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l);
      }
      if (this.jdField_d_of_type_JavaLangString == null) {
        break;
      }
      b(l);
      break;
    }
    label605:
    int k = 0;
    int j = ((List)localObject1).size();
    paramMessageRecord = ((List)localObject1).iterator();
    label623:
    if (paramMessageRecord.hasNext())
    {
      if (((MessageRecord)paramMessageRecord.next()).time > ((Long)((Pair)localObject2).second).longValue()) {
        break label1122;
      }
      k += 1;
      j -= 1;
    }
    label704:
    label735:
    label1122:
    for (;;)
    {
      break label623;
      if ((localList != null) && (localList.size() == k))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString == null) {
          break label1076;
        }
        paramMessageRecord = this.jdField_d_of_type_JavaLangString;
        ((RoamDateCache)localObject2).a(paramMessageRecord, l - 5L, 1);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString == null) {
          break label1082;
        }
        paramMessageRecord = this.jdField_d_of_type_JavaLangString;
        ((RoamDateCache)localObject2).b(paramMessageRecord, l - 5L, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l);
        }
        if (this.jdField_d_of_type_JavaLangString != null) {
          b(l);
        }
      }
      l = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(1000L * l);
      localObject1 = a(paramMessageRecord);
      if (this.jdField_d_of_type_JavaLangString != null)
      {
        paramMessageRecord = this.jdField_d_of_type_JavaLangString;
        localObject1 = a(paramMessageRecord, ((Long)((Pair)localObject1).first).longValue(), ((Long)((Pair)localObject1).second).longValue());
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("judgeClearRoamDateIndex: friendUin = ");
          if (this.jdField_d_of_type_JavaLangString != null) {
            break label1094;
          }
          paramMessageRecord = str;
          localObject2 = ((StringBuilder)localObject2).append(paramMessageRecord).append(", tomorrowList.size() = ");
          if (localObject1 != null) {
            break label1102;
          }
          paramMessageRecord = "null";
          QLog.d("Q.roammsg.MessageRoamManager", 2, paramMessageRecord);
        }
        if ((localObject1 == null) || (((List)localObject1).size() != j)) {
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString == null) {
          break label1116;
        }
      }
      for (paramMessageRecord = this.jdField_d_of_type_JavaLangString;; paramMessageRecord = str)
      {
        ((RoamDateCache)localObject1).a(paramMessageRecord, l - 5L, 1);
        paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_d_of_type_JavaLangString != null) {
          str = this.jdField_d_of_type_JavaLangString;
        }
        paramMessageRecord.b(str, l - 5L, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l);
        }
        if (this.jdField_d_of_type_JavaLangString == null) {
          break;
        }
        b(l);
        break;
        paramMessageRecord = str;
        break label704;
        paramMessageRecord = str;
        break label735;
        paramMessageRecord = str;
        break label851;
        paramMessageRecord = this.jdField_d_of_type_JavaLangString;
        break label911;
        paramMessageRecord = Integer.valueOf(((List)localObject1).size());
        break label934;
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class).obtainMessage(9, paramString).sendToTarget();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((short)1, (byte)1);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    Object localObject2;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = this.jdField_b_of_type_JavaUtilCalendar;
      if (!this.jdField_b_of_type_Boolean) {
        break label110;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilCalendar;
      label24:
      if ((localObject2 != null) && (localObject1 != null)) {
        break label132;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isFirstPage: firstPageDate ");
        if (localObject2 != null) {
          break label118;
        }
        localObject2 = "==";
        label60:
        localObject2 = localStringBuilder.append((String)localObject2).append(" null, curPageDate ");
        if (localObject1 != null) {
          break label125;
        }
      }
    }
    label110:
    label118:
    label125:
    for (Object localObject1 = "==";; localObject1 = "!=")
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, (String)localObject1 + " null");
      return true;
      localObject2 = this.e;
      break;
      localObject1 = this.jdField_d_of_type_JavaUtilCalendar;
      break label24;
      localObject2 = "!=";
      break label60;
    }
    label132:
    return (((Calendar)localObject2).get(1) >= ((Calendar)localObject1).get(1)) && (((Calendar)localObject2).get(2) >= ((Calendar)localObject1).get(2)) && (((Calendar)localObject2).get(5) >= ((Calendar)localObject1).get(5));
  }
  
  public byte[] b()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public Calendar c()
  {
    return this.c;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit().remove("vip_message_roam_passwordmd5" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).commit();
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public void c(String paramString)
  {
    d(paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
    int j;
    switch (this.h)
    {
    default: 
      j = -1;
    }
    for (;;)
    {
      paramString.sendMessageDelayed(paramString.obtainMessage(j), 0L);
      this.h = -1;
      return;
      j = 19;
      continue;
      j = 20;
    }
  }
  
  public boolean c()
  {
    Object localObject2;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = this.c;
      if (!this.jdField_b_of_type_Boolean) {
        break label110;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilCalendar;
      label24:
      if ((localObject2 != null) && (localObject1 != null)) {
        break label132;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isFirstPage: lastPageDate ");
        if (localObject2 != null) {
          break label118;
        }
        localObject2 = "==";
        label60:
        localObject2 = localStringBuilder.append((String)localObject2).append(" null, curPageDate ");
        if (localObject1 != null) {
          break label125;
        }
      }
    }
    label110:
    label118:
    label125:
    for (Object localObject1 = "==";; localObject1 = "!=")
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, (String)localObject1 + " null");
      return true;
      localObject2 = this.f;
      break;
      localObject1 = this.jdField_d_of_type_JavaUtilCalendar;
      break label24;
      localObject2 = "!=";
      break label60;
    }
    label132:
    return (((Calendar)localObject2).get(1) <= ((Calendar)localObject1).get(1)) && (((Calendar)localObject2).get(2) <= ((Calendar)localObject1).get(2)) && (((Calendar)localObject2).get(5) <= ((Calendar)localObject1).get(5));
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit().remove("vip_message_roam_signture" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).commit();
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "savePasswordMD5ForRoamMessage password" + paramString);
    }
    int k = paramString.length();
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      this.jdField_a_of_type_ArrayOfByte = new byte[k / 2];
    }
    int j = 0;
    while (j < k)
    {
      this.jdField_a_of_type_ArrayOfByte[(j / 2)] = ((byte)((Character.digit(paramString.charAt(j), 16) << 4) + Character.digit(paramString.charAt(j + 1), 16)));
      j += 2;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "savePasswordMD5ForRoamMessage passwordMD5" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
      QLog.d("Q.roammsg.MessageRoamManager", 2, "savePasswordMD5ForRoamMessage passwordMD52" + Arrays.toString(MD5.toMD5Byte(paramString)));
    }
    new hlx(this, "MessageRoamManager").start();
  }
  
  public boolean d()
  {
    Calendar localCalendar1;
    if (this.jdField_b_of_type_Boolean)
    {
      localCalendar1 = this.jdField_b_of_type_JavaUtilCalendar;
      if (!this.jdField_b_of_type_Boolean) {
        break label42;
      }
    }
    label42:
    for (Calendar localCalendar2 = this.c;; localCalendar2 = this.f)
    {
      if ((localCalendar1 != null) || (localCalendar2 != null)) {
        break label50;
      }
      return true;
      localCalendar1 = this.e;
      break;
    }
    label50:
    return false;
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        int j = ((Calendar)((Pair)localObject).first).get(1);
        int k = ((Calendar)((Pair)localObject).first).get(2);
        int m = ((Calendar)((Pair)localObject).first).get(5);
        int n = ((Calendar)((Pair)localObject).second).get(1);
        int i1 = ((Calendar)((Pair)localObject).second).get(2);
        int i2 = ((Calendar)((Pair)localObject).second).get(5);
        QLog.d("Q.roammsg.MessageRoamManager", 2, "setPageDateRange: first = " + j + "-" + (k + 1) + "-" + m + ", second = " + n + "-" + (i1 + 1) + "-" + i2);
      }
      this.jdField_b_of_type_JavaUtilCalendar = ((Calendar)((Pair)localObject).first);
      this.c = ((Calendar)((Pair)localObject).second);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong("first_page_date" + this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilCalendar.getTimeInMillis());
      ((SharedPreferences.Editor)localObject).putLong("last_page_date" + this.jdField_d_of_type_JavaLangString, this.c.getTimeInMillis());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "setPageDateRange: null");
    }
    this.jdField_b_of_type_JavaUtilCalendar = null;
    this.c = null;
  }
  
  public boolean e()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void f()
  {
    this.i = 3;
    g();
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (Object localObject = this.jdField_a_of_type_JavaUtilCalendar;; localObject = this.jdField_d_of_type_JavaUtilCalendar)
    {
      if (QLog.isColorLevel())
      {
        int j = ((Calendar)localObject).get(1);
        int k = ((Calendar)localObject).get(2);
        int m = ((Calendar)localObject).get(5);
        QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageByDay: friendUin = " + this.jdField_d_of_type_JavaLangString + ", curPageDate = " + j + "-" + (k + 1) + "-" + m);
      }
      localObject = a((Calendar)((Calendar)localObject).clone());
      String str3 = " time BETWEEN " + ((Pair)localObject).first + " AND " + ((Pair)localObject).second;
      String str1 = MessageRecord.getTableName(this.jdField_d_of_type_JavaLangString, 0);
      String str2 = MessageRecord.getOldTableName(this.jdField_d_of_type_JavaLangString, 0);
      str3 = "( msgtype " + MsgProxyUtils.b() + " and isValid=1 and" + str3 + " ) " + "ORDER BY time asc , longMsgIndex asc";
      ThreadManager.b().post(new hlw(this, (Pair)localObject, str1, str2, str3));
      return;
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    long l = MessageCache.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_d_of_type_JavaLangString, l - 604800L, 0L, l, (short)0, 0L, 1, null, null);
  }
  
  public void i()
  {
    this.i = 0;
    if (!this.jdField_b_of_type_Boolean) {
      if (this.f == null) {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForRecentDay error :mLocLastPageDate == null");
        }
      }
    }
    int j;
    int k;
    int m;
    do
    {
      do
      {
        return;
        a(this.f);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
        ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
        return;
        if (this.c != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForRecentDay error :mLastPageDate == null");
      return;
      j = this.c.get(1);
      k = this.c.get(2) + 1;
      m = this.c.get(5);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForRecentDay: recentDate = " + j + "-" + k + "-" + m);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, j, k);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForRecentDay: null");
    return;
    a(j, k - 1, m);
    switch (((RoamDate)localObject).getLocState(m - 1))
    {
    case 2: 
    case 1: 
    default: 
      return;
    case 0: 
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
        ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(21), 0L);
        localObject = Calendar.getInstance();
        ((Calendar)localObject).setTime(new Date(j - 1900, k - 1, m));
        this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_d_of_type_JavaLangString, (Calendar)localObject);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      Message localMessage = ((Handler)localObject).obtainMessage(1);
      localMessage.arg1 = -1;
      ((Handler)localObject).sendMessageDelayed(localMessage, 0L);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
    ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
  }
  
  public void j()
  {
    this.i = 0;
    if (this.jdField_a_of_type_JavaUtilCalendar == null) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForCurDay error :mCurPageDate == null");
      }
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Boolean) {
        break label180;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForCurDay error :mLocMsgDateLine.size == 0");
    return;
    long l = a(this.jdField_a_of_type_JavaUtilCalendar);
    int j = this.jdField_a_of_type_JavaUtilList.size() - 1;
    if ((j < 0) || (((Long)this.jdField_a_of_type_JavaUtilList.get(j)).longValue() <= l))
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (j != -1) {
        break label177;
      }
      j += 1;
    }
    label177:
    for (;;)
    {
      a(((Long)((List)localObject).get(j)).longValue());
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
      return;
      j -= 1;
      break;
    }
    label180:
    j = this.jdField_a_of_type_JavaUtilCalendar.get(1);
    int k = this.jdField_a_of_type_JavaUtilCalendar.get(2) + 1;
    int m = this.jdField_a_of_type_JavaUtilCalendar.get(5);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForCurDay: curDate = " + j + "-" + k + "-" + m);
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, j, k).getLocState(m - 1))
    {
    case 2: 
    case 1: 
    default: 
      return;
    case 0: 
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
        ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(21), 0L);
        localObject = Calendar.getInstance();
        ((Calendar)localObject).setTime(new Date(j - 1900, k - 1, m));
        this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_d_of_type_JavaLangString, (Calendar)localObject);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      Message localMessage = ((Handler)localObject).obtainMessage(1);
      localMessage.arg1 = -1;
      ((Handler)localObject).sendMessageDelayed(localMessage, 0L);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
    ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
  }
  
  public void k()
  {
    this.i = 1;
    if (!this.jdField_b_of_type_Boolean) {
      if (this.jdField_d_of_type_JavaUtilCalendar == null) {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForPreviousDay error :mLocCurPageDate == null");
        }
      }
    }
    do
    {
      int k;
      int j;
      do
      {
        return;
        k = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.jdField_d_of_type_JavaUtilCalendar)));
        j = k;
        if (k > 0) {
          j = k - 1;
        }
        if (j >= 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForPreviousDay error :index < 0");
      return;
      a(((Long)this.jdField_a_of_type_JavaUtilList.get(j)).longValue());
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilCalendar);
      if (localObject != null)
      {
        j = ((Calendar)localObject).get(1);
        k = ((Calendar)localObject).get(2) + 1;
        int m = ((Calendar)localObject).get(5);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForPreviousDay: previousDate = " + j + "-" + k + "-" + m);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, j, k);
        a(j, k - 1, m);
        switch (((RoamDate)localObject).getLocState(m - 1))
        {
        case 2: 
        case 1: 
        default: 
          return;
        case 0: 
          if (NetworkUtil.e(BaseApplication.getContext()))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
            ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(21), 0L);
            localObject = Calendar.getInstance();
            ((Calendar)localObject).setTime(new Date(j - 1900, k - 1, m));
            this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_d_of_type_JavaLangString, (Calendar)localObject);
            return;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
          Message localMessage = ((Handler)localObject).obtainMessage(1);
          localMessage.arg1 = -1;
          ((Handler)localObject).sendMessageDelayed(localMessage, 0L);
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
        ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForPreviousDay: null");
  }
  
  public void l()
  {
    this.i = 2;
    if (!this.jdField_b_of_type_Boolean) {
      if (this.jdField_d_of_type_JavaUtilCalendar == null) {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForNextDay error :mLocCurPageDate == null");
        }
      }
    }
    do
    {
      return;
      int k = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.jdField_d_of_type_JavaUtilCalendar)));
      int j = k;
      if (k < this.jdField_a_of_type_JavaUtilList.size() - 1) {
        j = k + 1;
      }
      a(((Long)this.jdField_a_of_type_JavaUtilList.get(j)).longValue());
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.b(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilCalendar);
      if (localObject != null)
      {
        j = ((Calendar)localObject).get(1);
        k = ((Calendar)localObject).get(2) + 1;
        int m = ((Calendar)localObject).get(5);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForNextDay: nextDate = " + j + "-" + k + "-" + m);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_d_of_type_JavaLangString, j, k);
        a(j, k - 1, m);
        switch (((RoamDate)localObject).getLocState(m - 1))
        {
        case 2: 
        case 1: 
        default: 
          return;
        case 0: 
          if (NetworkUtil.e(BaseApplication.getContext()))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
            ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(21), 0L);
            localObject = Calendar.getInstance();
            ((Calendar)localObject).setTime(new Date(j - 1900, k - 1, m));
            this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_d_of_type_JavaLangString, (Calendar)localObject);
            return;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
          Message localMessage = ((Handler)localObject).obtainMessage(1);
          localMessage.arg1 = -1;
          ((Handler)localObject).sendMessageDelayed(localMessage, 0L);
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatHistoryForC2C.class);
        ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(0), 0L);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryForNextDay: null");
  }
  
  public void m()
  {
    switch (this.i)
    {
    default: 
      n();
    case 3: 
      return;
    case 0: 
      k();
      return;
    case 1: 
      k();
      return;
    }
    l();
  }
  
  public void n()
  {
    this.i = -1;
  }
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_d_of_type_JavaLangString);
  }
  
  public void onDestroy() {}
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.f();
  }
  
  public void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.e();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit();
    localEditor.remove("first_page_date" + this.jdField_d_of_type_JavaLangString);
    localEditor.remove("last_page_date" + this.jdField_d_of_type_JavaLangString);
    localEditor.commit();
  }
  
  public void r()
  {
    ThreadManager.b().post(new hlz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager
 * JD-Core Version:    0.7.0.1
 */