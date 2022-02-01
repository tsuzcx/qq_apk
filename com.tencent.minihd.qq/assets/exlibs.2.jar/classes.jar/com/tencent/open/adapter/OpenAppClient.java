package com.tencent.open.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.component.cache.CacheManager;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.common.IntentFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import kzz;

public class OpenAppClient
{
  protected static int a = 0;
  public static final String a;
  protected static boolean a = false;
  protected static int b = 0;
  public static final String b = "schemaurl";
  public static boolean b = false;
  protected static final int c = 0;
  public static final String c = "uin";
  protected static final int d = 1;
  public static final String d = "vkey";
  protected static final int e = 2;
  protected static String e;
  protected static final int f = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = OpenAppClient.class.getName();
    jdField_a_of_type_Int = 7;
    jdField_b_of_type_Int = 11;
    jdField_a_of_type_Boolean = false;
    e = null;
    jdField_b_of_type_Boolean = false;
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    LogUtility.b(jdField_a_of_type_JavaLangString, "onPcPushMsgBackground " + paramString1);
    if (APNUtil.c(paramContext))
    {
      Object localObject = Common.a(paramString1);
      ((HashMap)localObject).put("schemaUrl", paramString1);
      ((HashMap)localObject).put("friendUin", paramString2);
      ((HashMap)localObject).put("istroop", paramInt + "");
      if (a(paramContext, (HashMap)localObject)) {
        return null;
      }
      paramContext = (String)((HashMap)localObject).get("appid");
      String str1 = (String)((HashMap)localObject).get("packname");
      String str2 = (String)((HashMap)localObject).get("downurl");
      localObject = (String)((HashMap)localObject).get("appname");
      String str3 = "_" + paramContext;
      if (DownloadApi.a(paramContext))
      {
        new Handler(Looper.getMainLooper()).post(new kzz(paramContext, (String)localObject, str1, str3, str2, paramString1, paramString2, paramInt));
        return null;
      }
      return IntentFactory.a(paramString1, paramString2, paramInt);
    }
    return IntentFactory.a(paramString1, paramString2, paramInt);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      String str2;
      Object localObject;
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        jdField_a_of_type_Boolean = true;
        str2 = paramBundle.getString("schemaurl");
        localObject = paramBundle.getString("uin");
        String str1 = paramBundle.getString("vkey");
        if (localObject != null)
        {
          paramBundle = (Bundle)localObject;
          if (!((String)localObject).equals("0")) {}
        }
        else
        {
          paramBundle = String.valueOf(CommonDataAdapter.a().a());
        }
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = CommonDataAdapter.a().a();
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          ThreadManager.b(new OpenAppClient.GetVkeyRunnable(paramActivity, 1, str2));
          continue;
        }
        jdField_a_of_type_Boolean = false;
      }
      finally {}
      AppClient.a(paramActivity, str2, paramBundle, (String)localObject);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    LogUtility.b(jdField_a_of_type_JavaLangString, "onPcPushMsgForground " + paramString);
    if (APNUtil.c(paramContext)) {
      a(paramContext, Common.a(paramString));
    }
  }
  
  /* Error */
  public static void a(Context paramContext, HashMap paramHashMap)
  {
    // Byte code:
    //   0: getstatic 32	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3: new 49	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   10: ldc 198
    //   12: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 64	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iconst_m1
    //   26: istore_2
    //   27: iconst_m1
    //   28: istore_3
    //   29: aload_1
    //   30: ldc 96
    //   32: invokevirtual 100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 102	java/lang/String
    //   38: astore 11
    //   40: aload_1
    //   41: ldc 104
    //   43: invokevirtual 100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 102	java/lang/String
    //   49: astore 12
    //   51: aload_1
    //   52: ldc 203
    //   54: invokevirtual 100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 102	java/lang/String
    //   60: astore 8
    //   62: aload_1
    //   63: ldc 106
    //   65: invokevirtual 100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 102	java/lang/String
    //   71: astore 13
    //   73: aload_1
    //   74: ldc 205
    //   76: invokevirtual 100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 102	java/lang/String
    //   82: astore 9
    //   84: aload_1
    //   85: ldc 108
    //   87: invokevirtual 100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 102	java/lang/String
    //   93: astore_1
    //   94: aload_1
    //   95: astore 7
    //   97: aload_1
    //   98: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +7 -> 108
    //   104: ldc 91
    //   106: astore 7
    //   108: new 49	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   115: ldc 110
    //   117: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 11
    //   122: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore 14
    //   130: invokestatic 210	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   133: aload 11
    //   135: invokevirtual 212	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore_1
    //   139: aload 12
    //   141: invokestatic 217	com/tencent/open/business/base/AppUtil:a	(Ljava/lang/String;)I
    //   144: ifle +9 -> 153
    //   147: aload 12
    //   149: invokestatic 217	com/tencent/open/business/base/AppUtil:a	(Ljava/lang/String;)I
    //   152: istore_2
    //   153: aload_1
    //   154: invokestatic 219	com/tencent/open/business/base/AppUtil:b	(Ljava/lang/String;)I
    //   157: ifle +8 -> 165
    //   160: aload_1
    //   161: invokestatic 219	com/tencent/open/business/base/AppUtil:b	(Ljava/lang/String;)I
    //   164: istore_3
    //   165: getstatic 32	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: new 49	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   175: ldc 221
    //   177: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload_2
    //   181: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 223
    //   186: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload_3
    //   190: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: ldc 225
    //   195: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_3
    //   199: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 227	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 8
    //   210: invokestatic 232	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   213: invokevirtual 236	java/lang/Integer:intValue	()I
    //   216: istore 4
    //   218: aconst_null
    //   219: astore_1
    //   220: aconst_null
    //   221: astore 10
    //   223: aload 9
    //   225: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +167 -> 395
    //   231: aload 9
    //   233: ldc 238
    //   235: invokevirtual 242	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   238: astore 15
    //   240: aload 15
    //   242: ifnull +303 -> 545
    //   245: aload 15
    //   247: arraylength
    //   248: iconst_2
    //   249: if_icmplt +296 -> 545
    //   252: new 49	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   259: astore 8
    //   261: iconst_0
    //   262: istore 5
    //   264: aload 8
    //   266: astore_1
    //   267: iload 5
    //   269: aload 15
    //   271: arraylength
    //   272: if_icmpge +275 -> 547
    //   275: iload 5
    //   277: iconst_1
    //   278: if_icmpeq +74 -> 352
    //   281: aload 8
    //   283: aload 15
    //   285: iload 5
    //   287: aaload
    //   288: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: iload 5
    //   294: aload 15
    //   296: arraylength
    //   297: iconst_1
    //   298: isub
    //   299: if_icmpeq +11 -> 310
    //   302: aload 8
    //   304: ldc 244
    //   306: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: iload 5
    //   312: iconst_1
    //   313: iadd
    //   314: istore 5
    //   316: goto -52 -> 264
    //   319: astore_1
    //   320: getstatic 32	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   323: new 49	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   330: ldc 246
    //   332: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 8
    //   337: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 248	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: iconst_0
    //   347: istore 4
    //   349: goto -131 -> 218
    //   352: aload 8
    //   354: aload 15
    //   356: iload 5
    //   358: aaload
    //   359: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc 244
    //   364: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 250
    //   369: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: goto -81 -> 292
    //   376: astore 10
    //   378: aload 8
    //   380: astore_1
    //   381: aload 10
    //   383: astore 8
    //   385: getstatic 32	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   388: ldc 252
    //   390: aload 8
    //   392: invokestatic 255	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: aload 9
    //   397: astore 8
    //   399: aload_1
    //   400: ifnull +9 -> 409
    //   403: aload_1
    //   404: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: astore 8
    //   409: new 257	com/tencent/open/downloadnew/common/NoticeParam
    //   412: dup
    //   413: invokespecial 258	com/tencent/open/downloadnew/common/NoticeParam:<init>	()V
    //   416: astore_1
    //   417: aload_1
    //   418: aload 11
    //   420: putfield 259	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   423: aload_1
    //   424: aload 7
    //   426: putfield 261	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   429: aload_1
    //   430: aload 12
    //   432: putfield 263	com/tencent/open/downloadnew/common/NoticeParam:d	Ljava/lang/String;
    //   435: aload_1
    //   436: aload 14
    //   438: putfield 265	com/tencent/open/downloadnew/common/NoticeParam:f	Ljava/lang/String;
    //   441: new 143	android/os/Bundle
    //   444: dup
    //   445: invokespecial 266	android/os/Bundle:<init>	()V
    //   448: astore 9
    //   450: aload 9
    //   452: ldc_w 268
    //   455: aload 11
    //   457: invokevirtual 271	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload 9
    //   462: ldc 205
    //   464: aload 8
    //   466: invokevirtual 271	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload 9
    //   471: ldc_w 273
    //   474: aload 13
    //   476: invokevirtual 271	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: aload 9
    //   481: ldc_w 275
    //   484: aload 12
    //   486: invokevirtual 271	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload 9
    //   491: ldc_w 277
    //   494: ldc_w 279
    //   497: invokevirtual 271	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: iload 4
    //   502: iload_2
    //   503: if_icmpgt +47 -> 550
    //   506: ldc_w 281
    //   509: ldc_w 283
    //   512: aload 11
    //   514: invokestatic 288	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   517: aload_1
    //   518: iconst_2
    //   519: putfield 289	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_Int	I
    //   522: aload_1
    //   523: aload 13
    //   525: putfield 290	com/tencent/open/downloadnew/common/NoticeParam:e	Ljava/lang/String;
    //   528: aload_1
    //   529: aload 9
    //   531: invokestatic 293	com/tencent/open/downloadnew/common/IntentFactory:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   534: putfield 296	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   537: invokestatic 301	com/tencent/open/downloadnew/common/AppNotificationManager:a	()Lcom/tencent/open/downloadnew/common/AppNotificationManager;
    //   540: aload_1
    //   541: invokevirtual 304	com/tencent/open/downloadnew/common/AppNotificationManager:a	(Lcom/tencent/open/downloadnew/common/NoticeParam;)V
    //   544: return
    //   545: aconst_null
    //   546: astore_1
    //   547: goto -152 -> 395
    //   550: iload 4
    //   552: iload_3
    //   553: if_icmpgt +75 -> 628
    //   556: ldc_w 281
    //   559: ldc_w 306
    //   562: aload 11
    //   564: invokestatic 288	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   567: aload_1
    //   568: iconst_3
    //   569: putfield 289	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_Int	I
    //   572: aload_1
    //   573: aload 13
    //   575: putfield 290	com/tencent/open/downloadnew/common/NoticeParam:e	Ljava/lang/String;
    //   578: aload_1
    //   579: aload 9
    //   581: invokestatic 293	com/tencent/open/downloadnew/common/IntentFactory:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   584: putfield 296	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   587: invokestatic 301	com/tencent/open/downloadnew/common/AppNotificationManager:a	()Lcom/tencent/open/downloadnew/common/AppNotificationManager;
    //   590: aload_1
    //   591: invokevirtual 304	com/tencent/open/downloadnew/common/AppNotificationManager:a	(Lcom/tencent/open/downloadnew/common/NoticeParam;)V
    //   594: invokestatic 210	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   597: aload 11
    //   599: invokevirtual 212	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   602: astore_1
    //   603: aload_1
    //   604: invokestatic 307	com/tencent/open/business/base/AppUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   607: ifnull +11 -> 618
    //   610: aload_0
    //   611: aload_1
    //   612: invokestatic 310	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   615: ifeq -71 -> 544
    //   618: getstatic 32	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   621: ldc_w 312
    //   624: invokestatic 248	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: return
    //   628: invokestatic 210	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   631: aload 11
    //   633: invokevirtual 315	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   636: ifnull +14 -> 650
    //   639: ldc_w 281
    //   642: ldc_w 317
    //   645: aload 11
    //   647: invokestatic 288	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   650: aload 9
    //   652: invokestatic 293	com/tencent/open/downloadnew/common/IntentFactory:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   655: astore_0
    //   656: aload 12
    //   658: ifnull +52 -> 710
    //   661: aload 12
    //   663: invokevirtual 320	java/lang/String:trim	()Ljava/lang/String;
    //   666: ldc 91
    //   668: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   671: ifne +39 -> 710
    //   674: iconst_1
    //   675: istore 6
    //   677: new 322	com/tencent/open/downloadnew/DownloadInfo
    //   680: dup
    //   681: aload 11
    //   683: aload 13
    //   685: invokevirtual 320	java/lang/String:trim	()Ljava/lang/String;
    //   688: aload 12
    //   690: aload 7
    //   692: aload 8
    //   694: aload_0
    //   695: iconst_0
    //   696: iload 6
    //   698: invokespecial 325	com/tencent/open/downloadnew/DownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;IZ)V
    //   701: astore_0
    //   702: invokestatic 210	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   705: aload_0
    //   706: invokevirtual 328	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   709: return
    //   710: iconst_0
    //   711: istore 6
    //   713: goto -36 -> 677
    //   716: astore 8
    //   718: aload 10
    //   720: astore_1
    //   721: goto -336 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	724	0	paramContext	Context
    //   0	724	1	paramHashMap	HashMap
    //   26	478	2	i	int
    //   28	526	3	j	int
    //   216	338	4	k	int
    //   262	95	5	m	int
    //   675	37	6	bool	boolean
    //   95	596	7	localObject1	Object
    //   60	633	8	localObject2	Object
    //   716	1	8	localException1	Exception
    //   82	569	9	localObject3	Object
    //   221	1	10	localObject4	Object
    //   376	343	10	localException2	Exception
    //   38	644	11	str1	String
    //   49	640	12	str2	String
    //   71	613	13	str3	String
    //   128	309	14	str4	String
    //   238	117	15	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   208	218	319	java/lang/NumberFormatException
    //   267	275	376	java/lang/Exception
    //   281	292	376	java/lang/Exception
    //   292	310	376	java/lang/Exception
    //   352	373	376	java/lang/Exception
    //   231	240	716	java/lang/Exception
    //   245	261	716	java/lang/Exception
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    CacheManager.a(CommonDataAdapter.a().a());
    jdField_b_of_type_Boolean = true;
    Object localObject = "";
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        break label64;
      }
      localObject = ((QQAppInterface)paramAppInterface).getAccount();
      ((QQAppInterface)paramAppInterface).d();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      label64:
      try
      {
        CommonDataAdapter.a().a(Long.valueOf((String)localObject).longValue());
        return;
      }
      catch (Exception paramAppInterface) {}
      if ((paramAppInterface instanceof BrowserAppInterface))
      {
        String str = ((BrowserAppInterface)paramAppInterface).getAccount();
        localObject = str;
        if (TextUtils.isEmpty(e))
        {
          ThreadManager.a(new OpenAppClient.GetVkeyRunnable(paramAppInterface, 0, ""));
          localObject = str;
        }
      }
    }
  }
  
  /* Error */
  protected static boolean a(Context paramContext, HashMap paramHashMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 366	java/util/HashMap:size	()I
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ldc_w 368
    //   17: invokevirtual 100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 102	java/lang/String
    //   23: invokestatic 371	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   26: istore_2
    //   27: iload_2
    //   28: iconst_1
    //   29: if_icmpne +84 -> 113
    //   32: aload_1
    //   33: ldc 96
    //   35: invokevirtual 100	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 102	java/lang/String
    //   41: invokestatic 115	com/tencent/open/downloadnew/DownloadApi:a	(Ljava/lang/String;)Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifeq +23 -> 69
    //   49: iconst_0
    //   50: ireturn
    //   51: astore 4
    //   53: getstatic 32	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: ldc_w 373
    //   59: aload 4
    //   61: invokestatic 375	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   64: iconst_m1
    //   65: istore_2
    //   66: goto -39 -> 27
    //   69: new 377	laa
    //   72: dup
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial 379	laa:<init>	(Landroid/content/Context;Ljava/util/HashMap;)V
    //   78: invokestatic 183	com/tencent/mobileqq/app/ThreadManager:b	(Ljava/lang/Runnable;)V
    //   81: iconst_1
    //   82: ireturn
    //   83: astore_0
    //   84: new 49	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 381
    //   94: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_1
    //   105: getstatic 32	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: aload_1
    //   109: aload_0
    //   110: invokestatic 255	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: iconst_0
    //   114: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramHashMap	HashMap
    //   26	40	2	i	int
    //   44	2	3	bool	boolean
    //   51	9	4	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   13	27	51	java/lang/NumberFormatException
    //   32	45	83	java/lang/Exception
    //   69	81	83	java/lang/Exception
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      String str2;
      String str1;
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        jdField_a_of_type_Boolean = true;
        str2 = paramBundle.getString("schemaurl");
        str1 = paramBundle.getString("uin");
        paramBundle = paramBundle.getString("vkey");
        if (TextUtils.isEmpty(str2))
        {
          jdField_a_of_type_Boolean = false;
          continue;
        }
        try
        {
          str2 = new URL(str2).getQuery();
          if (!TextUtils.isEmpty(paramBundle)) {
            break label112;
          }
          ThreadManager.a(new OpenAppClient.GetVkeyRunnable(paramActivity, 2, str2));
        }
        catch (MalformedURLException paramActivity)
        {
          paramActivity.printStackTrace();
          jdField_a_of_type_Boolean = false;
        }
      }
      finally {}
      continue;
      label112:
      jdField_a_of_type_Boolean = false;
      AppClient.b(paramActivity, str2, str1, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient
 * JD-Core Version:    0.7.0.1
 */