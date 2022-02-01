package com.tencent.mobileqq.service.gamecenter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import jvb;
import jvc;
import jvd;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

public class AppLaucherHelper
{
  public static final int a = 1;
  protected static long a = 0L;
  public static boolean a = false;
  public static final int b = 2;
  protected static String b;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 16;
  public static final int f = 32;
  public static final int g = 64;
  public static final int h = 128;
  public static final int i = 256;
  public Handler a;
  public String a;
  public HashMap a;
  public NewIntent a;
  public Handler b;
  public boolean b;
  protected int j = 0;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_JavaLangString = "";
  }
  
  public AppLaucherHelper()
  {
    this.jdField_a_of_type_MqqAppNewIntent = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static int a(String paramString)
  {
    int m = 0;
    if (paramString.contains("$OPID$")) {
      m = 1;
    }
    int k = m;
    if (paramString.contains("$AT$")) {
      k = m | 0x2;
    }
    m = k;
    if (paramString.contains("$PT$")) {
      m = k | 0x4;
    }
    k = m;
    if (paramString.contains("$PF$")) {
      k = m | 0x40;
    }
    m = k;
    if (paramString.contains("$ESK$")) {
      m = k | 0x80;
    }
    return m;
  }
  
  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return localBundle;
      paramString = paramString.split("&");
    } while (paramString == null);
    int m = paramString.length;
    int k = 0;
    while (k < m)
    {
      Object localObject = paramString[k];
      int n = localObject.indexOf('=');
      if (n != -1) {}
      try
      {
        localBundle.putString(localObject.substring(0, n), localObject.substring(n + 1));
        k += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("AppLaucherHelper", 2, localException.getMessage(), localException);
        }
      }
    }
  }
  
  public static void a()
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  /* Error */
  private void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    // Byte code:
    //   0: new 127	jve
    //   3: dup
    //   4: aload_0
    //   5: invokestatic 133	java/lang/System:currentTimeMillis	()J
    //   8: aload 5
    //   10: aload_2
    //   11: iload 7
    //   13: invokespecial 136	jve:<init>	(Lcom/tencent/mobileqq/service/gamecenter/AppLaucherHelper;JLjava/lang/String;Landroid/content/Context;I)V
    //   16: astore 14
    //   18: aload_0
    //   19: getfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   22: ifnonnull +17 -> 39
    //   25: aload_0
    //   26: new 138	mqq/app/NewIntent
    //   29: dup
    //   30: aload_2
    //   31: ldc 140
    //   33: invokespecial 143	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   36: putfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   39: new 145	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest
    //   42: dup
    //   43: invokespecial 146	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:<init>	()V
    //   46: astore 15
    //   48: lconst_0
    //   49: lstore 9
    //   51: aload_1
    //   52: invokevirtual 150	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   55: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   58: lstore 11
    //   60: lload 11
    //   62: lstore 9
    //   64: aload 15
    //   66: getfield 160	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:uin	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   69: lload 9
    //   71: invokevirtual 166	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   74: lconst_0
    //   75: lstore 9
    //   77: aload_3
    //   78: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: lstore 11
    //   83: lload 11
    //   85: lstore 9
    //   87: aload 15
    //   89: getfield 169	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:client_id	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   92: lload 9
    //   94: invokevirtual 166	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   97: aload 15
    //   99: getfield 173	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:pf	Lcom/tencent/mobileqq/pb/PBStringField;
    //   102: ldc 41
    //   104: invokevirtual 178	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   107: aload_2
    //   108: invokestatic 183	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;)Ljava/lang/String;
    //   111: astore_3
    //   112: aload 15
    //   114: getfield 186	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:qqv	Lcom/tencent/mobileqq/pb/PBStringField;
    //   117: aload_3
    //   118: invokevirtual 178	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   121: aload 15
    //   123: getfield 189	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:sdkp	Lcom/tencent/mobileqq/pb/PBStringField;
    //   126: ldc 190
    //   128: invokevirtual 178	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   131: getstatic 195	android/os/Build:DISPLAY	Ljava/lang/String;
    //   134: astore_3
    //   135: aload 15
    //   137: getfield 198	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:os	Lcom/tencent/mobileqq/pb/PBStringField;
    //   140: aload_3
    //   141: invokevirtual 178	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   144: aload_1
    //   145: invokevirtual 201	com/tencent/common/app/AppInterface:getSid	()Ljava/lang/String;
    //   148: astore_3
    //   149: aload 15
    //   151: getfield 204	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:sid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   154: aload_3
    //   155: invokevirtual 178	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   158: aload 15
    //   160: getfield 207	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:skey	Lcom/tencent/mobileqq/pb/PBStringField;
    //   163: aload 6
    //   165: invokevirtual 178	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   168: ldc 41
    //   170: astore_3
    //   171: aload_1
    //   172: instanceof 209
    //   175: ifeq +65 -> 240
    //   178: aload_1
    //   179: checkcast 209	com/tencent/mobileqq/app/QQAppInterface
    //   182: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:d	()Ljava/lang/String;
    //   185: astore_3
    //   186: aload_3
    //   187: astore 6
    //   189: aload_3
    //   190: ifnonnull +7 -> 197
    //   193: ldc 41
    //   195: astore 6
    //   197: aload 15
    //   199: getfield 214	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:vkey	Lcom/tencent/mobileqq/pb/PBStringField;
    //   202: aload 6
    //   204: invokevirtual 178	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   207: aload 4
    //   209: invokestatic 216	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:a	(Ljava/lang/String;)I
    //   212: istore 8
    //   214: iload 8
    //   216: ifne +42 -> 258
    //   219: aload_2
    //   220: aload 5
    //   222: aload_0
    //   223: getfield 218	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   226: invokestatic 220	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   229: iload 7
    //   231: invokestatic 223	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;I)Z
    //   234: pop
    //   235: iconst_0
    //   236: putstatic 37	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_Boolean	Z
    //   239: return
    //   240: aload_1
    //   241: instanceof 225
    //   244: ifeq -58 -> 186
    //   247: aload_1
    //   248: checkcast 225	com/tencent/mobileqq/app/BrowserAppInterface
    //   251: invokevirtual 227	com/tencent/mobileqq/app/BrowserAppInterface:b	()Ljava/lang/String;
    //   254: astore_3
    //   255: goto -69 -> 186
    //   258: aload 15
    //   260: getfield 231	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:flags	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   263: iload 8
    //   265: invokevirtual 236	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   268: ldc 41
    //   270: astore 4
    //   272: aload 4
    //   274: astore_3
    //   275: aload_2
    //   276: invokevirtual 242	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   279: aload 5
    //   281: bipush 64
    //   283: invokevirtual 248	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   286: getfield 254	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   289: astore 16
    //   291: aload 4
    //   293: astore_3
    //   294: aload 16
    //   296: ifnull +78 -> 374
    //   299: aload 4
    //   301: astore 6
    //   303: aload 4
    //   305: astore_3
    //   306: ldc_w 256
    //   309: invokestatic 262	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   312: astore 13
    //   314: aload 4
    //   316: astore 6
    //   318: aload 4
    //   320: astore_3
    //   321: aload 13
    //   323: aload 16
    //   325: iconst_0
    //   326: aaload
    //   327: invokevirtual 268	android/content/pm/Signature:toByteArray	()[B
    //   330: invokevirtual 272	java/security/MessageDigest:update	([B)V
    //   333: aload 4
    //   335: astore 6
    //   337: aload 4
    //   339: astore_3
    //   340: aload 13
    //   342: invokevirtual 275	java/security/MessageDigest:digest	()[B
    //   345: invokestatic 280	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   348: astore 4
    //   350: aload 4
    //   352: invokevirtual 283	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   355: astore_3
    //   356: aload_3
    //   357: astore 4
    //   359: aload 4
    //   361: astore 6
    //   363: aload 4
    //   365: astore_3
    //   366: aload 13
    //   368: invokevirtual 286	java/security/MessageDigest:reset	()V
    //   371: aload 4
    //   373: astore_3
    //   374: aload_3
    //   375: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   378: ifeq +69 -> 447
    //   381: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +17 -> 401
    //   387: aload_0
    //   388: invokevirtual 294	java/lang/Object:getClass	()Ljava/lang/Class;
    //   391: invokevirtual 299	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   394: iconst_2
    //   395: ldc_w 301
    //   398: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: iconst_0
    //   402: putstatic 37	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_Boolean	Z
    //   405: aload_2
    //   406: aload 5
    //   408: aload_0
    //   409: getfield 218	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   412: invokestatic 220	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   415: iload 7
    //   417: invokestatic 223	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;I)Z
    //   420: pop
    //   421: return
    //   422: astore 13
    //   424: aload 6
    //   426: astore 4
    //   428: aload 4
    //   430: astore_3
    //   431: aload 13
    //   433: invokevirtual 307	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   436: aload 4
    //   438: astore_3
    //   439: goto -65 -> 374
    //   442: astore 4
    //   444: goto -70 -> 374
    //   447: aload 15
    //   449: getfield 310	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:apk_sign	Lcom/tencent/mobileqq/pb/PBStringField;
    //   452: aload_3
    //   453: invokevirtual 178	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   456: aload_0
    //   457: getfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   460: ldc_w 312
    //   463: ldc_w 314
    //   466: invokevirtual 318	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   469: pop
    //   470: aload_0
    //   471: getfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   474: ldc_w 320
    //   477: aload 15
    //   479: invokevirtual 321	com/tencent/qconn/protofile/fastauthorize/FastAuthorize$AuthorizeRequest:toByteArray	()[B
    //   482: invokevirtual 324	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   485: pop
    //   486: aload_0
    //   487: getfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   490: aload 14
    //   492: invokevirtual 328	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   495: aload_1
    //   496: aload_0
    //   497: getfield 49	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_MqqAppNewIntent	Lmqq/app/NewIntent;
    //   500: invokevirtual 332	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   503: aload_0
    //   504: getfield 51	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   507: iconst_0
    //   508: ldc2_w 333
    //   511: invokevirtual 340	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   514: pop
    //   515: return
    //   516: astore_1
    //   517: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +18 -> 538
    //   523: aload_0
    //   524: invokevirtual 294	java/lang/Object:getClass	()Ljava/lang/Class;
    //   527: invokevirtual 299	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   530: iconst_2
    //   531: aload_1
    //   532: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   535: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: iconst_0
    //   539: putstatic 37	com/tencent/mobileqq/service/gamecenter/AppLaucherHelper:jdField_a_of_type_Boolean	Z
    //   542: return
    //   543: astore_3
    //   544: goto -457 -> 87
    //   547: astore_3
    //   548: aload 4
    //   550: astore_3
    //   551: goto -177 -> 374
    //   554: astore 13
    //   556: goto -128 -> 428
    //   559: astore 13
    //   561: goto -497 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	this	AppLaucherHelper
    //   0	564	1	paramAppInterface	AppInterface
    //   0	564	2	paramContext	Context
    //   0	564	3	paramString1	String
    //   0	564	4	paramString2	String
    //   0	564	5	paramString3	String
    //   0	564	6	paramString4	String
    //   0	564	7	paramInt	int
    //   212	52	8	k	int
    //   49	44	9	l1	long
    //   58	26	11	l2	long
    //   312	55	13	localMessageDigest	java.security.MessageDigest
    //   422	10	13	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   554	1	13	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   559	1	13	localException	Exception
    //   16	475	14	localjve	jve
    //   46	432	15	localAuthorizeRequest	com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest
    //   289	35	16	arrayOfSignature	android.content.pm.Signature[]
    // Exception table:
    //   from	to	target	type
    //   306	314	422	java/security/NoSuchAlgorithmException
    //   321	333	422	java/security/NoSuchAlgorithmException
    //   340	350	422	java/security/NoSuchAlgorithmException
    //   366	371	422	java/security/NoSuchAlgorithmException
    //   275	291	442	java/lang/Exception
    //   306	314	442	java/lang/Exception
    //   321	333	442	java/lang/Exception
    //   340	350	442	java/lang/Exception
    //   366	371	442	java/lang/Exception
    //   431	436	442	java/lang/Exception
    //   470	486	516	java/lang/Exception
    //   77	83	543	java/lang/Exception
    //   350	356	547	java/lang/Exception
    //   350	356	554	java/security/NoSuchAlgorithmException
    //   51	60	559	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public boolean a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (jdField_a_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp");
    }
    jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new jvd(this, Looper.getMainLooper(), paramContext, paramString3, paramInt, paramAppInterface, paramString1, paramString2);
    }
    if (paramString2.startsWith("?")) {}
    for (this.jdField_a_of_type_JavaLangString = paramString2.substring(1);; this.jdField_a_of_type_JavaLangString = paramString2)
    {
      a(paramAppInterface, paramContext, paramString1, paramString2, paramString3, ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount()), paramInt);
      return true;
    }
  }
  
  public boolean a(String paramString1, Context paramContext, String paramString2, AppInterface paramAppInterface, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (jdField_a_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin");
    }
    if ((TextUtils.isEmpty(paramString2)) || (!AuthorizeConfig.a().d(paramString2))) {
      return false;
    }
    jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new jvb(this);
    }
    try
    {
      paramString2 = Long.valueOf(paramString3);
      long l1 = 1L;
      try
      {
        long l2 = Long.valueOf(paramString5).longValue();
        l1 = l2;
      }
      catch (Exception paramString3)
      {
        label93:
        break label93;
      }
      paramString3 = new WtloginHelper(paramAppInterface.getApplication().getApplicationContext());
      paramString5 = util.getPkgSigFromApkName(paramContext, paramString4);
      paramString3.GetA1WithA1(paramAppInterface.getAccount(), 16L, 16L, paramString4.getBytes(), 1L, paramString2.longValue(), l1, "5.2".getBytes(), paramString5, new WUserSigInfo(), new WFastLoginInfo());
      paramString3.SetListener(new jvc(this, paramString1, paramString3, paramInt, paramContext));
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 10000L);
      return true;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("appcenter", 2, "parse appid error = " + paramString3);
        }
        paramString2 = Long.valueOf(0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.gamecenter.AppLaucherHelper
 * JD-Core Version:    0.7.0.1
 */