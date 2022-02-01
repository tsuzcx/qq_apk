package com.tencent.biz.common.offline;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import cdv;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineExpire
{
  public static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OfflineExpire";
    jdField_a_of_type_Int = 3;
  }
  
  protected static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire:" + paramString);
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        int j = paramString.length();
        if (i >= j) {
          break;
        }
        localObject = paramString.optJSONObject(i);
        if (localObject != null) {
          break label121;
        }
        i += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire: " + QLog.getStackTraceString(paramString));
      return;
      label121:
      int k = ((JSONObject)localObject).optInt("bid");
      if (k > 0)
      {
        localObject = HtmlOffline.a(k + "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (String)localObject + k;
          if (new File((String)localObject).exists()) {
            Util.a((String)localObject);
          }
        }
      }
    }
  }
  
  protected static void a(String paramString1, String paramString2, Context paramContext, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire:" + paramString1);
    }
    long l1;
    long l2;
    try
    {
      paramString1 = new JSONArray(paramString1);
      l1 = 0L;
    }
    catch (JSONException paramString1)
    {
      label63:
      int n;
      int j;
      paramString1.printStackTrace();
    }
    try
    {
      l2 = Long.parseLong("uin");
      l1 = l2;
    }
    catch (Exception localException)
    {
      int i;
      break label63;
    }
    ArrayList localArrayList = new ArrayList();
    n = paramString1.length();
    j = 0;
    label81:
    if (j < n)
    {
      JSONObject localJSONObject = paramString1.optJSONObject(j);
      if (localJSONObject == null) {}
      for (;;)
      {
        j += 1;
        break label81;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExpire: " + QLog.getStackTraceString(paramString1));
        return;
        int i1 = localJSONObject.optInt("bid");
        JSONArray localJSONArray = localJSONObject.optJSONArray("uins");
        if (localJSONObject.optInt("gray") > 0)
        {
          i = 1;
          if ((i != 0) && (localJSONArray != null)) {
            break label294;
          }
        }
        int m;
        for (i = 1;; i = 0)
        {
          m = i;
          if (i != 0) {
            break label300;
          }
          int k = 0;
          for (;;)
          {
            m = i;
            if (k >= localJSONArray.length()) {
              break;
            }
            localJSONObject = localJSONArray.optJSONObject(k);
            l2 = localJSONObject.optLong("min");
            long l3 = localJSONObject.optLong("max");
            m = i;
            if (l1 > l2)
            {
              m = i;
              if (l1 < l3) {
                m = 1;
              }
            }
            k += 1;
            i = m;
          }
          i = 0;
          break;
        }
        if ((m != 0) && (i1 > 0)) {
          localArrayList.add(i1 + "");
        }
      }
    }
    label294:
    label300:
    i = 0;
    if (paramInt == 1) {
      i = 60000;
    }
    ThreadManager.b().postDelayed(new cdv(paramContext, localArrayList, paramString2, paramInt), i);
  }
  
  /* Error */
  public static void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: getstatic 13	com/tencent/biz/common/offline/OfflineExpire:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: ldc 159
    //   12: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: ifnonnull +4 -> 20
    //   19: return
    //   20: new 161	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgBody
    //   23: dup
    //   24: invokespecial 162	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgBody:<init>	()V
    //   27: astore_1
    //   28: aload_1
    //   29: aload_0
    //   30: invokevirtual 166	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 170	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   38: invokevirtual 175	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   41: iconst_1
    //   42: if_icmpne -23 -> 19
    //   45: aload_1
    //   46: getfield 179	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgBody:msg_expired_pkg	Ltencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg;
    //   49: invokevirtual 184	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   52: checkcast 181	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg
    //   55: astore_0
    //   56: aload_0
    //   57: ifnull -38 -> 19
    //   60: aload_0
    //   61: getfield 187	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg:uint32_platform	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   64: invokevirtual 175	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   67: getstatic 15	com/tencent/biz/common/offline/OfflineExpire:jdField_a_of_type_Int	I
    //   70: if_icmpeq +13 -> 83
    //   73: aload_0
    //   74: getfield 187	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg:uint32_platform	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   77: invokevirtual 175	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   80: ifne -61 -> 19
    //   83: new 189	java/lang/String
    //   86: dup
    //   87: aload_0
    //   88: getfield 193	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg:bytes_expire_pkg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   91: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   94: invokevirtual 204	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   97: ldc 206
    //   99: invokespecial 209	java/lang/String:<init>	([BLjava/lang/String;)V
    //   102: invokestatic 211	com/tencent/biz/common/offline/OfflineExpire:a	(Ljava/lang/String;)V
    //   105: new 189	java/lang/String
    //   108: dup
    //   109: aload_0
    //   110: getfield 214	tencent/im/s2c/msgtype0x210/submsgtype0x65/SubMsgType0x65$MsgExpiredPkg:bytes_predown_pkg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: invokevirtual 204	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   119: ldc 206
    //   121: invokespecial 209	java/lang/String:<init>	([BLjava/lang/String;)V
    //   124: astore_0
    //   125: invokestatic 219	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   128: invokevirtual 223	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   131: astore_1
    //   132: aload_0
    //   133: invokestatic 219	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   136: invokevirtual 226	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   139: invokevirtual 231	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   142: aload_1
    //   143: iconst_2
    //   144: invokestatic 233	com/tencent/biz/common/offline/OfflineExpire:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;I)V
    //   147: return
    //   148: astore_0
    //   149: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq -133 -> 19
    //   155: getstatic 13	com/tencent/biz/common/offline/OfflineExpire:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   158: iconst_2
    //   159: new 36	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   166: ldc 235
    //   168: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: invokestatic 72	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   175: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: return
    //   185: astore_0
    //   186: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -170 -> 19
    //   192: getstatic 13	com/tencent/biz/common/offline/OfflineExpire:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   195: iconst_2
    //   196: new 36	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   203: ldc 237
    //   205: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: invokevirtual 240	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   212: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: return
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 244	java/lang/Exception:printStackTrace	()V
    //   227: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq -211 -> 19
    //   233: getstatic 13	com/tencent/biz/common/offline/OfflineExpire:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   236: iconst_2
    //   237: new 36	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   244: ldc 235
    //   246: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: invokestatic 72	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   253: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramArrayOfByte	byte[]
    //   27	116	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   83	147	148	java/io/UnsupportedEncodingException
    //   28	34	185	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   83	147	222	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire
 * JD-Core Version:    0.7.0.1
 */