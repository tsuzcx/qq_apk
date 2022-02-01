package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.q;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public class b
{
  public static byte[] a = null;
  private static ThirdAppInfoNew b;
  
  static
  {
    try
    {
      a = "65dRa93L".getBytes("utf-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  private static String a(Context paramContext)
  {
    try
    {
      localJSONObject = new JSONObject();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        label208:
        localObject = null;
      }
    }
    try
    {
      if ((!TbsShareManager.isThirdPartyApp(paramContext)) && (q.b(paramContext)))
      {
        int i = TbsShareManager.getTbsStableCoreVersion(paramContext, 32);
        localJSONObject.put("stableCore32", i);
        if (i <= 0) {
          localJSONObject.put("stableCoreErrorReason32", TbsShareManager.getStableCoreZeroReason());
        }
        i = TbsShareManager.getTbsStableCoreVersion(paramContext, 64);
        localJSONObject.put("stableCore64", i);
        if (i <= 0) {
          localJSONObject.put("stableCoreErrorReason64", TbsShareManager.getStableCoreZeroReason());
        }
      }
      if ((TbsShareManager.isThirdPartyApp(paramContext)) && (q.c(paramContext)))
      {
        localObject = q.b().replace(",", "-");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localJSONObject.put("coreUpdate", localObject);
        }
      }
      q.c();
      if ((TbsShareManager.isThirdPartyApp(paramContext)) && (q.i(paramContext)))
      {
        localObject = q.d();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localJSONObject.put("destroyCode", localObject);
        }
      }
      localObject = localJSONObject;
      if (TbsShareManager.isThirdPartyApp(paramContext))
      {
        localObject = localJSONObject;
        if (q.h(paramContext))
        {
          String str = q.j(paramContext);
          localObject = localJSONObject;
          if (!TextUtils.isEmpty(str))
          {
            localJSONObject.put("coreSource", str);
            q.a(QbSdk.getTbsVersion(paramContext));
            localObject = localJSONObject;
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      localObject = localJSONObject;
      break label208;
    }
    if (localObject == null) {
      return "";
    }
    return ((JSONObject)localObject).toString();
  }
  
  public static void a(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    a(paramThirdAppInfoNew, paramContext, null, null);
  }
  
  public static void a(final ThirdAppInfoNew paramThirdAppInfoNew, final Context paramContext, final String paramString1, final String paramString2)
  {
    new Thread("HttpUtils")
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 19	com/tencent/smtt/sdk/stat/b$1:a	Landroid/content/Context;
        //   4: aload_0
        //   5: getfield 21	com/tencent/smtt/sdk/stat/b$1:b	LMTT/ThirdAppInfoNew;
        //   8: getfield 48	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
        //   11: invokestatic 53	com/tencent/smtt/utils/b:b	(Landroid/content/Context;Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 21	com/tencent/smtt/sdk/stat/b$1:b	LMTT/ThirdAppInfoNew;
        //   18: invokestatic 56	com/tencent/smtt/utils/b:a	()Ljava/lang/String;
        //   21: putfield 59	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
        //   24: getstatic 65	android/os/Build$VERSION:SDK_INT	I
        //   27: bipush 8
        //   29: if_icmpge +4 -> 33
        //   32: return
        //   33: getstatic 68	com/tencent/smtt/sdk/stat/b:a	[B
        //   36: ifnonnull +13 -> 49
        //   39: ldc 70
        //   41: ldc 72
        //   43: invokevirtual 78	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   46: putstatic 68	com/tencent/smtt/sdk/stat/b:a	[B
        //   49: getstatic 68	com/tencent/smtt/sdk/stat/b:a	[B
        //   52: ifnonnull +26 -> 78
        //   55: ldc 80
        //   57: ldc 82
        //   59: invokestatic 88	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   62: return
        //   63: astore_2
        //   64: aconst_null
        //   65: putstatic 68	com/tencent/smtt/sdk/stat/b:a	[B
        //   68: ldc 80
        //   70: ldc 90
        //   72: invokestatic 88	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   75: goto -26 -> 49
        //   78: aload_0
        //   79: getfield 19	com/tencent/smtt/sdk/stat/b$1:a	Landroid/content/Context;
        //   82: invokestatic 96	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
        //   85: getfield 100	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
        //   88: ldc 102
        //   90: ldc 104
        //   92: invokeinterface 110 3 0
        //   97: astore_3
        //   98: aload_3
        //   99: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   102: ifne +774 -> 876
        //   105: aload_3
        //   106: iconst_0
        //   107: aload_3
        //   108: ldc 118
        //   110: invokevirtual 122	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   113: invokevirtual 126	java/lang/String:substring	(II)Ljava/lang/String;
        //   116: astore_2
        //   117: aload_3
        //   118: aload_3
        //   119: ldc 118
        //   121: invokevirtual 122	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   124: iconst_1
        //   125: iadd
        //   126: aload_3
        //   127: invokevirtual 130	java/lang/String:length	()I
        //   130: invokevirtual 126	java/lang/String:substring	(II)Ljava/lang/String;
        //   133: astore_3
        //   134: aload_2
        //   135: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   138: ifne +28 -> 166
        //   141: aload_2
        //   142: invokevirtual 130	java/lang/String:length	()I
        //   145: bipush 96
        //   147: if_icmpne +19 -> 166
        //   150: aload_3
        //   151: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   154: ifne +12 -> 166
        //   157: aload_3
        //   158: invokevirtual 130	java/lang/String:length	()I
        //   161: bipush 24
        //   163: if_icmpeq +158 -> 321
        //   166: iconst_1
        //   167: istore_1
        //   168: invokestatic 135	com/tencent/smtt/utils/n:a	()Lcom/tencent/smtt/utils/n;
        //   171: astore 4
        //   173: iload_1
        //   174: ifeq +152 -> 326
        //   177: new 137	java/lang/StringBuilder
        //   180: dup
        //   181: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   184: aload 4
        //   186: invokevirtual 141	com/tencent/smtt/utils/n:b	()Ljava/lang/String;
        //   189: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   192: invokestatic 150	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
        //   195: invokevirtual 151	com/tencent/smtt/utils/g:b	()Ljava/lang/String;
        //   198: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   201: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   204: astore_2
        //   205: ldc 80
        //   207: new 137	java/lang/StringBuilder
        //   210: dup
        //   211: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   214: ldc 156
        //   216: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   219: aload_2
        //   220: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   223: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   226: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   229: new 161	java/net/URL
        //   232: dup
        //   233: aload_2
        //   234: invokespecial 162	java/net/URL:<init>	(Ljava/lang/String;)V
        //   237: invokevirtual 166	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   240: checkcast 168	java/net/HttpURLConnection
        //   243: astore 6
        //   245: aload 6
        //   247: ldc 170
        //   249: invokevirtual 173	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   252: aload 6
        //   254: iconst_1
        //   255: invokevirtual 177	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   258: aload 6
        //   260: iconst_1
        //   261: invokevirtual 180	java/net/HttpURLConnection:setDoInput	(Z)V
        //   264: aload 6
        //   266: iconst_0
        //   267: invokevirtual 183	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   270: aload 6
        //   272: sipush 20000
        //   275: invokevirtual 187	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   278: getstatic 65	android/os/Build$VERSION:SDK_INT	I
        //   281: bipush 13
        //   283: if_icmple +12 -> 295
        //   286: aload 6
        //   288: ldc 189
        //   290: ldc 191
        //   292: invokevirtual 194	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   295: aload_0
        //   296: getfield 21	com/tencent/smtt/sdk/stat/b$1:b	LMTT/ThirdAppInfoNew;
        //   299: aload_0
        //   300: getfield 19	com/tencent/smtt/sdk/stat/b$1:a	Landroid/content/Context;
        //   303: invokestatic 197	com/tencent/smtt/sdk/stat/b:b	(LMTT/ThirdAppInfoNew;Landroid/content/Context;)Lorg/json/JSONObject;
        //   306: astore 4
        //   308: aload 4
        //   310: ifnonnull +131 -> 441
        //   313: ldc 80
        //   315: ldc 199
        //   317: invokestatic 88	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   320: return
        //   321: iconst_0
        //   322: istore_1
        //   323: goto -155 -> 168
        //   326: new 137	java/lang/StringBuilder
        //   329: dup
        //   330: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   333: aload 4
        //   335: invokevirtual 201	com/tencent/smtt/utils/n:i	()Ljava/lang/String;
        //   338: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   341: aload_2
        //   342: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   345: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   348: astore_2
        //   349: goto -144 -> 205
        //   352: astore_2
        //   353: ldc 80
        //   355: new 137	java/lang/StringBuilder
        //   358: dup
        //   359: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   362: ldc 203
        //   364: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   367: aload_2
        //   368: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   371: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   374: invokestatic 88	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   377: return
        //   378: astore_2
        //   379: ldc 80
        //   381: new 137	java/lang/StringBuilder
        //   384: dup
        //   385: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   388: ldc 208
        //   390: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   393: aload_2
        //   394: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   397: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   400: invokestatic 88	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   403: return
        //   404: astore_2
        //   405: ldc 80
        //   407: new 137	java/lang/StringBuilder
        //   410: dup
        //   411: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   414: ldc 210
        //   416: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   419: aload_2
        //   420: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   423: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   426: invokestatic 88	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   429: return
        //   430: astore_2
        //   431: aload_2
        //   432: invokestatic 213	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
        //   435: aconst_null
        //   436: astore 4
        //   438: goto -130 -> 308
        //   441: aload_0
        //   442: getfield 23	com/tencent/smtt/sdk/stat/b$1:c	Ljava/lang/String;
        //   445: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   448: ifne +65 -> 513
        //   451: aload_0
        //   452: getfield 25	com/tencent/smtt/sdk/stat/b$1:d	Ljava/lang/String;
        //   455: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   458: ifne +55 -> 513
        //   461: ldc 104
        //   463: astore_2
        //   464: new 215	org/json/JSONObject
        //   467: dup
        //   468: invokespecial 216	org/json/JSONObject:<init>	()V
        //   471: astore 5
        //   473: aload 5
        //   475: aload_0
        //   476: getfield 23	com/tencent/smtt/sdk/stat/b$1:c	Ljava/lang/String;
        //   479: aload_0
        //   480: getfield 25	com/tencent/smtt/sdk/stat/b$1:d	Ljava/lang/String;
        //   483: invokevirtual 220	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   486: pop
        //   487: aload 5
        //   489: ifnonnull +262 -> 751
        //   492: ldc 104
        //   494: astore_2
        //   495: aload 4
        //   497: ldc 222
        //   499: aload_2
        //   500: invokevirtual 220	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   503: pop
        //   504: aload 4
        //   506: ldc 224
        //   508: iconst_0
        //   509: invokevirtual 227	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   512: pop
        //   513: ldc 80
        //   515: new 137	java/lang/StringBuilder
        //   518: dup
        //   519: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   522: ldc 229
        //   524: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   527: aload 4
        //   529: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
        //   532: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   535: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   538: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   541: aload 4
        //   543: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
        //   546: ldc 72
        //   548: invokevirtual 78	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   551: astore_2
        //   552: iload_1
        //   553: ifeq +219 -> 772
        //   556: invokestatic 150	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
        //   559: aload_2
        //   560: invokevirtual 233	com/tencent/smtt/utils/g:a	([B)[B
        //   563: astore_2
        //   564: aload 6
        //   566: ldc 235
        //   568: ldc 237
        //   570: invokevirtual 194	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   573: aload 6
        //   575: ldc 239
        //   577: aload_2
        //   578: arraylength
        //   579: invokestatic 243	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   582: invokevirtual 194	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   585: aload 6
        //   587: invokevirtual 247	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   590: astore 5
        //   592: aload 5
        //   594: aload_2
        //   595: invokevirtual 253	java/io/OutputStream:write	([B)V
        //   598: aload 5
        //   600: invokevirtual 256	java/io/OutputStream:flush	()V
        //   603: aload 6
        //   605: invokevirtual 259	java/net/HttpURLConnection:getResponseCode	()I
        //   608: sipush 200
        //   611: if_icmpne +170 -> 781
        //   614: ldc 80
        //   616: ldc_w 261
        //   619: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   622: ldc 80
        //   624: new 137	java/lang/StringBuilder
        //   627: dup
        //   628: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   631: ldc_w 263
        //   634: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   637: aload 4
        //   639: ldc_w 265
        //   642: invokevirtual 268	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   645: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   648: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   651: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   654: aload 6
        //   656: aload_3
        //   657: iload_1
        //   658: invokestatic 271	com/tencent/smtt/sdk/stat/b:a	(Ljava/net/HttpURLConnection;Ljava/lang/String;Z)Ljava/lang/String;
        //   661: astore_2
        //   662: aload_0
        //   663: getfield 19	com/tencent/smtt/sdk/stat/b$1:a	Landroid/content/Context;
        //   666: aload_2
        //   667: invokestatic 273	com/tencent/smtt/sdk/stat/b:a	(Landroid/content/Context;Ljava/lang/String;)V
        //   670: new 275	com/tencent/smtt/sdk/TbsDownloadUpload
        //   673: dup
        //   674: aload_0
        //   675: getfield 19	com/tencent/smtt/sdk/stat/b$1:a	Landroid/content/Context;
        //   678: invokespecial 278	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
        //   681: invokevirtual 281	com/tencent/smtt/sdk/TbsDownloadUpload:clearUploadCode	()V
        //   684: return
        //   685: astore_2
        //   686: ldc 80
        //   688: new 137	java/lang/StringBuilder
        //   691: dup
        //   692: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   695: ldc_w 283
        //   698: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   701: aload_2
        //   702: invokevirtual 286	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   705: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   708: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   711: invokestatic 88	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   714: aload_0
        //   715: getfield 19	com/tencent/smtt/sdk/stat/b$1:a	Landroid/content/Context;
        //   718: invokestatic 291	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   721: invokevirtual 295	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
        //   724: astore_3
        //   725: aload_3
        //   726: bipush 126
        //   728: invokevirtual 300	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
        //   731: aload_3
        //   732: aload_2
        //   733: invokevirtual 303	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/Throwable;)V
        //   736: aload_0
        //   737: getfield 19	com/tencent/smtt/sdk/stat/b$1:a	Landroid/content/Context;
        //   740: invokestatic 291	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   743: getstatic 309	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
        //   746: aload_3
        //   747: invokevirtual 313	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
        //   750: return
        //   751: aload 5
        //   753: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
        //   756: astore 5
        //   758: aload 5
        //   760: astore_2
        //   761: goto -266 -> 495
        //   764: astore_2
        //   765: aload_2
        //   766: invokestatic 213	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
        //   769: goto -256 -> 513
        //   772: aload_2
        //   773: aload_3
        //   774: invokestatic 316	com/tencent/smtt/utils/g:a	([BLjava/lang/String;)[B
        //   777: astore_2
        //   778: goto -214 -> 564
        //   781: ldc 80
        //   783: new 137	java/lang/StringBuilder
        //   786: dup
        //   787: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   790: ldc_w 318
        //   793: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   796: aload 6
        //   798: invokevirtual 259	java/net/HttpURLConnection:getResponseCode	()I
        //   801: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   804: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   807: invokestatic 88	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   810: aload_0
        //   811: getfield 19	com/tencent/smtt/sdk/stat/b$1:a	Landroid/content/Context;
        //   814: invokestatic 291	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   817: invokevirtual 295	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
        //   820: astore_2
        //   821: aload_2
        //   822: bipush 126
        //   824: invokevirtual 300	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
        //   827: aload_2
        //   828: new 137	java/lang/StringBuilder
        //   831: dup
        //   832: invokespecial 139	java/lang/StringBuilder:<init>	()V
        //   835: ldc 104
        //   837: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   840: aload 6
        //   842: invokevirtual 259	java/net/HttpURLConnection:getResponseCode	()I
        //   845: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   848: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   851: invokevirtual 323	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
        //   854: aload_0
        //   855: getfield 19	com/tencent/smtt/sdk/stat/b$1:a	Landroid/content/Context;
        //   858: invokestatic 291	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   861: getstatic 309	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
        //   864: aload_2
        //   865: invokevirtual 313	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
        //   868: return
        //   869: astore_2
        //   870: return
        //   871: astore 5
        //   873: goto -378 -> 495
        //   876: ldc 104
        //   878: astore_2
        //   879: ldc 104
        //   881: astore_3
        //   882: goto -748 -> 134
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	885	0	this	1
        //   167	491	1	bool	boolean
        //   63	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
        //   116	233	2	str1	String
        //   352	16	2	localIOException	java.io.IOException
        //   378	16	2	localAssertionError	java.lang.AssertionError
        //   404	16	2	localNoClassDefFoundError	java.lang.NoClassDefFoundError
        //   430	2	2	localException1	Exception
        //   463	204	2	localObject1	Object
        //   685	48	2	localThrowable1	Throwable
        //   760	1	2	localObject2	Object
        //   764	9	2	localException2	Exception
        //   777	88	2	localObject3	Object
        //   869	1	2	localThrowable2	Throwable
        //   878	1	2	str2	String
        //   97	785	3	localObject4	Object
        //   171	467	4	localObject5	Object
        //   471	288	5	localObject6	Object
        //   871	1	5	localThrowable3	Throwable
        //   243	598	6	localHttpURLConnection	java.net.HttpURLConnection
        // Exception table:
        //   from	to	target	type
        //   39	49	63	java/io/UnsupportedEncodingException
        //   168	173	352	java/io/IOException
        //   177	205	352	java/io/IOException
        //   205	252	352	java/io/IOException
        //   326	349	352	java/io/IOException
        //   168	173	378	java/lang/AssertionError
        //   177	205	378	java/lang/AssertionError
        //   205	252	378	java/lang/AssertionError
        //   326	349	378	java/lang/AssertionError
        //   168	173	404	java/lang/NoClassDefFoundError
        //   177	205	404	java/lang/NoClassDefFoundError
        //   205	252	404	java/lang/NoClassDefFoundError
        //   326	349	404	java/lang/NoClassDefFoundError
        //   295	308	430	java/lang/Exception
        //   585	684	685	java/lang/Throwable
        //   781	868	685	java/lang/Throwable
        //   441	461	764	java/lang/Exception
        //   464	487	764	java/lang/Exception
        //   495	513	764	java/lang/Exception
        //   751	758	764	java/lang/Exception
        //   513	552	869	java/lang/Throwable
        //   556	564	869	java/lang/Throwable
        //   772	778	869	java/lang/Throwable
        //   464	487	871	java/lang/Throwable
        //   751	758	871	java/lang/Throwable
      }
    }.start();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    ThirdAppInfoNew localThirdAppInfoNew;
    if (b == null)
    {
      localThirdAppInfoNew = new ThirdAppInfoNew();
      localThirdAppInfoNew.sAppName = paramContext.getApplicationContext().getApplicationInfo().packageName;
      n.a(paramContext);
      Object localObject = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+08"));
      localThirdAppInfoNew.sTime = ((SimpleDateFormat)localObject).format(Calendar.getInstance().getTime());
      localThirdAppInfoNew.sVersionCode = com.tencent.smtt.utils.b.e(paramContext);
      localObject = com.tencent.smtt.utils.b.a(paramContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localThirdAppInfoNew.sMetaData = ((String)localObject);
      }
      localThirdAppInfoNew.sGuid = "";
      localThirdAppInfoNew.sQua2 = k.a(paramContext, "" + QbSdk.getTbsVersion(paramContext));
      localThirdAppInfoNew.sLc = "";
      localObject = com.tencent.smtt.utils.b.j(paramContext);
      String str1 = com.tencent.smtt.utils.b.h(paramContext);
      String str2 = com.tencent.smtt.utils.b.i(paramContext);
      String str3 = com.tencent.smtt.utils.b.k(paramContext);
      if ((str1 != null) && (!"".equals(str1))) {
        localThirdAppInfoNew.sImei = str1;
      }
      if ((str2 != null) && (!"".equals(str2))) {
        localThirdAppInfoNew.sImsi = str2;
      }
      if (!TextUtils.isEmpty(str3)) {
        localThirdAppInfoNew.sAndroidID = str3;
      }
      if ((localObject != null) && (!"".equals(localObject))) {
        localThirdAppInfoNew.sMac = ((String)localObject);
      }
      localThirdAppInfoNew.iPv = 0L;
      if (QbSdk.getTbsVersion(paramContext) <= 0) {
        break label292;
      }
      localThirdAppInfoNew.iCoreType = 1;
    }
    for (;;)
    {
      localThirdAppInfoNew.sAppVersionName = paramContext.getApplicationInfo().packageName;
      localThirdAppInfoNew.sAppSignature = b(paramContext);
      b = localThirdAppInfoNew;
      a(b, paramContext, paramString1, paramString2);
      return;
      label292:
      localThirdAppInfoNew.iCoreType = 0;
      localThirdAppInfoNew.localCoreVersion = QbSdk.getTbsVersion(paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if ((QbSdk.getSettings() != null) && (QbSdk.getSettings().containsKey("SET_SENDREQUEST_AND_UPLOAD")) && (QbSdk.getSettings().get("SET_SENDREQUEST_AND_UPLOAD").equals("false")))
    {
      TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return;
    }
    Object localObject3 = "";
    Object localObject2 = localObject3;
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        localObject1 = localObject3;
        localObject2 = localObject3;
        if ("com.tencent.mobileqq".equals(localApplicationInfo.packageName))
        {
          localObject2 = localObject3;
          localObject3 = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0).versionName;
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber()))
          {
            localObject2 = localObject3;
            localObject1 = (String)localObject3 + "." + QbSdk.getQQBuildNumber();
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1 = localObject2;
        TbsLog.i(localException);
        continue;
        ((ThirdAppInfoNew)localObject2).sQua2 = k.a(paramContext);
        continue;
        ((ThirdAppInfoNew)localObject2).iCoreType = 1;
        continue;
        ((ThirdAppInfoNew)localObject2).iCoreType = 0;
        continue;
      }
      try
      {
        localObject2 = new ThirdAppInfoNew();
        ((ThirdAppInfoNew)localObject2).sAppName = paramContext.getApplicationContext().getApplicationInfo().packageName;
        n.a(paramContext);
        localObject3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+08"));
        ((ThirdAppInfoNew)localObject2).sTime = ((SimpleDateFormat)localObject3).format(Calendar.getInstance().getTime());
        ((ThirdAppInfoNew)localObject2).sVersionCode = com.tencent.smtt.utils.b.e(paramContext);
        localObject3 = com.tencent.smtt.utils.b.a(paramContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((ThirdAppInfoNew)localObject2).sMetaData = ((String)localObject3);
        }
        ((ThirdAppInfoNew)localObject2).sGuid = paramString1;
        if (paramBoolean1)
        {
          ((ThirdAppInfoNew)localObject2).sQua2 = paramString2;
          ((ThirdAppInfoNew)localObject2).bIsSandboxMode = paramBoolean2;
          ((ThirdAppInfoNew)localObject2).sLc = paramString3;
          paramString1 = com.tencent.smtt.utils.b.j(paramContext);
          paramString2 = com.tencent.smtt.utils.b.h(paramContext);
          TbsLog.i("sdkreport", "HttpUtils.doReport(): getImeiEnable = " + com.tencent.smtt.utils.b.g(paramContext) + " imei is " + paramString2);
          paramString3 = com.tencent.smtt.utils.b.i(paramContext);
          localObject3 = com.tencent.smtt.utils.b.k(paramContext);
          if ((paramString2 != null) && (!"".equals(paramString2))) {
            ((ThirdAppInfoNew)localObject2).sImei = paramString2;
          }
          if ((paramString3 != null) && (!"".equals(paramString3))) {
            ((ThirdAppInfoNew)localObject2).sImsi = paramString3;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((ThirdAppInfoNew)localObject2).sAndroidID = ((String)localObject3);
          }
          if ((paramString1 != null) && (!"".equals(paramString1))) {
            ((ThirdAppInfoNew)localObject2).sMac = paramString1;
          }
          ((ThirdAppInfoNew)localObject2).iPv = paramInt;
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            break label613;
          }
          if (!paramBoolean1) {
            continue;
          }
          if (!TbsShareManager.getCoreFormOwn()) {
            continue;
          }
          ((ThirdAppInfoNew)localObject2).iCoreType = 2;
          if (paramBoolean2) {
            ((ThirdAppInfoNew)localObject2).iCoreType = 3;
          }
          ((ThirdAppInfoNew)localObject2).sAppVersionName = ((String)localObject1);
          ((ThirdAppInfoNew)localObject2).sAppSignature = b(paramContext);
          if (!paramBoolean1)
          {
            ((ThirdAppInfoNew)localObject2).sWifiConnectedTime = paramLong;
            ((ThirdAppInfoNew)localObject2).localCoreVersion = QbSdk.getTbsVersion(paramContext);
          }
          b = (ThirdAppInfoNew)localObject2;
          q.b(paramContext, "pv_report", "");
          q.a(paramContext, "pv_report", "");
          a((ThirdAppInfoNew)localObject2, paramContext.getApplicationContext());
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.i(paramContext);
        return;
      }
    }
    for (;;)
    {
      ((ThirdAppInfoNew)localObject2).iCoreType = paramInt;
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break;
      }
      ((ThirdAppInfoNew)localObject2).iCoreType = 3;
      break;
      label613:
      do
      {
        paramInt = 0;
        break;
      } while (!paramBoolean1);
      paramInt = 1;
    }
  }
  
  private static String b(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
      if (paramContext != null)
      {
        Object localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramContext);
        paramContext = ((MessageDigest)localObject).digest();
        if (paramContext != null)
        {
          localObject = new StringBuilder("");
          if (paramContext != null)
          {
            if (paramContext.length <= 0) {
              return null;
            }
            while (i < paramContext.length)
            {
              String str = Integer.toHexString(paramContext[i] & 0xFF).toUpperCase();
              if (i > 0) {
                ((StringBuilder)localObject).append(":");
              }
              if (str.length() < 2) {
                ((StringBuilder)localObject).append(0);
              }
              ((StringBuilder)localObject).append(str);
              i += 1;
            }
            paramContext = ((StringBuilder)localObject).toString();
            return paramContext;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i(paramContext);
    }
    return null;
  }
  
  /* Error */
  private static String b(java.net.HttpURLConnection paramHttpURLConnection, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: ldc 118
    //   8: astore 5
    //   10: aload_0
    //   11: invokevirtual 424	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   14: astore 4
    //   16: aload_0
    //   17: invokevirtual 427	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +133 -> 155
    //   25: aload_0
    //   26: ldc_w 429
    //   29: invokevirtual 433	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   32: ifeq +123 -> 155
    //   35: new 435	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 438	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_0
    //   45: new 440	java/io/ByteArrayOutputStream
    //   48: dup
    //   49: invokespecial 441	java/io/ByteArrayOutputStream:<init>	()V
    //   52: astore 4
    //   54: sipush 128
    //   57: newarray byte
    //   59: astore 6
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 447	java/io/InputStream:read	([B)I
    //   67: istore_3
    //   68: iload_3
    //   69: iconst_m1
    //   70: if_icmpeq +136 -> 206
    //   73: aload 4
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_3
    //   79: invokevirtual 451	java/io/ByteArrayOutputStream:write	([BII)V
    //   82: goto -21 -> 61
    //   85: astore_1
    //   86: aload_1
    //   87: invokestatic 371	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   90: aload 4
    //   92: ifnull +8 -> 100
    //   95: aload 4
    //   97: invokevirtual 454	java/io/ByteArrayOutputStream:close	()V
    //   100: aload 5
    //   102: astore 4
    //   104: aload_0
    //   105: ifnull +11 -> 116
    //   108: aload_0
    //   109: invokevirtual 455	java/io/InputStream:close	()V
    //   112: aload 5
    //   114: astore 4
    //   116: ldc 130
    //   118: new 227	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 457
    //   128: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload 4
    //   133: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 459
    //   139: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload_2
    //   143: invokevirtual 351	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   146: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 317	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload 4
    //   154: areturn
    //   155: aload_0
    //   156: ifnull +44 -> 200
    //   159: aload_0
    //   160: ldc_w 461
    //   163: invokevirtual 433	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   166: ifeq +34 -> 200
    //   169: new 463	java/util/zip/InflaterInputStream
    //   172: dup
    //   173: aload 4
    //   175: new 465	java/util/zip/Inflater
    //   178: dup
    //   179: iconst_1
    //   180: invokespecial 468	java/util/zip/Inflater:<init>	(Z)V
    //   183: invokespecial 471	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   186: astore_0
    //   187: goto -142 -> 45
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_0
    //   193: aload 6
    //   195: astore 4
    //   197: goto -111 -> 86
    //   200: aload 4
    //   202: astore_0
    //   203: goto -158 -> 45
    //   206: iload_2
    //   207: ifeq +60 -> 267
    //   210: new 22	java/lang/String
    //   213: dup
    //   214: invokestatic 476	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   217: aload 4
    //   219: invokevirtual 477	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   222: invokevirtual 480	com/tencent/smtt/utils/g:c	([B)[B
    //   225: invokespecial 482	java/lang/String:<init>	([B)V
    //   228: astore_1
    //   229: aload 4
    //   231: ifnull +8 -> 239
    //   234: aload 4
    //   236: invokevirtual 454	java/io/ByteArrayOutputStream:close	()V
    //   239: aload_1
    //   240: astore 4
    //   242: aload_0
    //   243: ifnull -127 -> 116
    //   246: aload_0
    //   247: invokevirtual 455	java/io/InputStream:close	()V
    //   250: aload_1
    //   251: astore 4
    //   253: goto -137 -> 116
    //   256: astore_0
    //   257: aload_0
    //   258: invokestatic 371	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   261: aload_1
    //   262: astore 4
    //   264: goto -148 -> 116
    //   267: new 22	java/lang/String
    //   270: dup
    //   271: aload 4
    //   273: invokevirtual 477	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   276: aload_1
    //   277: invokestatic 485	com/tencent/smtt/utils/g:b	([BLjava/lang/String;)[B
    //   280: invokespecial 482	java/lang/String:<init>	([B)V
    //   283: astore_1
    //   284: goto -55 -> 229
    //   287: astore 4
    //   289: aload 4
    //   291: invokestatic 371	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   294: goto -55 -> 239
    //   297: astore_1
    //   298: aload_1
    //   299: invokestatic 371	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   302: goto -202 -> 100
    //   305: astore_0
    //   306: aload_0
    //   307: invokestatic 371	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   310: aload 5
    //   312: astore 4
    //   314: goto -198 -> 116
    //   317: astore_1
    //   318: aconst_null
    //   319: astore_0
    //   320: aload 7
    //   322: astore 4
    //   324: aload 4
    //   326: ifnull +8 -> 334
    //   329: aload 4
    //   331: invokevirtual 454	java/io/ByteArrayOutputStream:close	()V
    //   334: aload_0
    //   335: ifnull +7 -> 342
    //   338: aload_0
    //   339: invokevirtual 455	java/io/InputStream:close	()V
    //   342: aload_1
    //   343: athrow
    //   344: astore 4
    //   346: aload 4
    //   348: invokestatic 371	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   351: goto -17 -> 334
    //   354: astore_0
    //   355: aload_0
    //   356: invokestatic 371	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/Throwable;)V
    //   359: goto -17 -> 342
    //   362: astore_1
    //   363: aload 7
    //   365: astore 4
    //   367: goto -43 -> 324
    //   370: astore_1
    //   371: goto -47 -> 324
    //   374: astore_1
    //   375: goto -51 -> 324
    //   378: astore_1
    //   379: aload 6
    //   381: astore 4
    //   383: goto -297 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	386	1	paramString	String
    //   0	386	2	paramBoolean	boolean
    //   67	12	3	i	int
    //   14	258	4	localObject1	Object
    //   287	3	4	localIOException1	java.io.IOException
    //   312	18	4	localObject2	Object
    //   344	3	4	localIOException2	java.io.IOException
    //   365	17	4	localObject3	Object
    //   8	303	5	str	String
    //   4	376	6	arrayOfByte	byte[]
    //   1	363	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   54	61	85	java/lang/Exception
    //   61	68	85	java/lang/Exception
    //   73	82	85	java/lang/Exception
    //   210	229	85	java/lang/Exception
    //   267	284	85	java/lang/Exception
    //   10	21	190	java/lang/Exception
    //   25	45	190	java/lang/Exception
    //   159	187	190	java/lang/Exception
    //   246	250	256	java/io/IOException
    //   234	239	287	java/io/IOException
    //   95	100	297	java/io/IOException
    //   108	112	305	java/io/IOException
    //   10	21	317	finally
    //   25	45	317	finally
    //   159	187	317	finally
    //   329	334	344	java/io/IOException
    //   338	342	354	java/io/IOException
    //   45	54	362	finally
    //   54	61	370	finally
    //   61	68	370	finally
    //   73	82	370	finally
    //   210	229	370	finally
    //   267	284	370	finally
    //   86	90	374	finally
    //   45	54	378	java/lang/Exception
  }
  
  private static void b(Context paramContext, String paramString)
  {
    try
    {
      TbsPVConfig.releaseInstance();
      TbsPVConfig.getInstance(paramContext).clear();
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = paramString.split("\\|");
      int j = paramString.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          String[] arrayOfString = paramString[i];
          try
          {
            arrayOfString = arrayOfString.split("=");
            if (arrayOfString.length == 2) {
              b(paramContext, arrayOfString[0], arrayOfString[1]);
            }
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              TbsLog.i(localException);
            }
          }
        }
      }
      TbsPVConfig.getInstance(paramContext).commit();
    }
    catch (Exception paramContext)
    {
      TbsLog.i(paramContext);
      return;
    }
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    if (("reset".equals(paramString1)) && ("true".equals(paramString2))) {
      QbSdk.reset(paramContext);
    }
    for (;;)
    {
      return;
      if (paramString1.startsWith("rmfile")) {
        try
        {
          paramContext = paramContext.getSharedPreferences("tbs_status", 0);
          if (!paramContext.getBoolean(paramString1, false))
          {
            File localFile = new File(paramString2);
            if ((paramString2 != null) && (localFile.exists()))
            {
              TbsLog.i("HttpUtils", "received command,delete" + paramString2);
              FileUtil.b(localFile);
            }
            paramContext.edit().putBoolean(paramString1, true).apply();
            return;
          }
        }
        catch (Exception paramContext)
        {
          TbsLog.i(paramContext);
          return;
        }
      }
    }
    TbsPVConfig.getInstance(paramContext).putData(paramString1, paramString2);
  }
  
  /* Error */
  private static JSONObject c(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    // Byte code:
    //   0: new 32	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 35	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 566
    //   14: aload_0
    //   15: getfield 164	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   18: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload 6
    //   24: ldc_w 568
    //   27: aload_0
    //   28: getfield 205	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   31: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   34: pop
    //   35: aload 6
    //   37: ldc_w 570
    //   40: aload_0
    //   41: getfield 242	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   44: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload 6
    //   50: ldc_w 572
    //   53: aload_0
    //   54: getfield 245	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   57: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   60: pop
    //   61: aload 6
    //   63: ldc_w 574
    //   66: aload_0
    //   67: getfield 225	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   70: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload 6
    //   76: ldc_w 576
    //   79: aload_0
    //   80: getfield 260	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   83: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload 6
    //   89: ldc_w 578
    //   92: aload_0
    //   93: getfield 263	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   96: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload 6
    //   102: ldc_w 580
    //   105: aload_0
    //   106: getfield 269	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   109: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: aload 6
    //   115: ldc_w 582
    //   118: aload_0
    //   119: getfield 273	MTT/ThirdAppInfoNew:iPv	J
    //   122: invokevirtual 585	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   125: pop
    //   126: aload 6
    //   128: ldc_w 587
    //   131: aload_0
    //   132: getfield 276	MTT/ThirdAppInfoNew:iCoreType	I
    //   135: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload 6
    //   141: ldc_w 589
    //   144: aload_0
    //   145: getfield 279	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   148: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload 6
    //   154: ldc_w 591
    //   157: aload_0
    //   158: getfield 222	MTT/ThirdAppInfoNew:sMetaData	Ljava/lang/String;
    //   161: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload 6
    //   167: ldc_w 593
    //   170: aload_0
    //   171: getfield 214	MTT/ThirdAppInfoNew:sVersionCode	I
    //   174: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload 6
    //   180: ldc_w 595
    //   183: aload_0
    //   184: getfield 598	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
    //   187: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   190: pop
    //   191: ldc_w 600
    //   194: aload_0
    //   195: getfield 164	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   198: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +29 -> 230
    //   204: ldc_w 319
    //   207: aload_0
    //   208: getfield 164	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   211: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   214: ifne +16 -> 230
    //   217: ldc_w 602
    //   220: aload_0
    //   221: getfield 164	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   224: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: ifeq +338 -> 565
    //   230: new 604	com/tencent/smtt/sdk/TbsDownloadUpload
    //   233: dup
    //   234: aload_1
    //   235: invokespecial 606	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
    //   238: astore 7
    //   240: aload 7
    //   242: aload_1
    //   243: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadUpload:readTbsDownloadInfo	(Landroid/content/Context;)V
    //   246: aload 7
    //   248: invokevirtual 612	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadCode	()I
    //   251: istore_2
    //   252: aload 7
    //   254: invokevirtual 615	com/tencent/smtt/sdk/TbsDownloadUpload:getStartDownloadCode	()I
    //   257: istore_3
    //   258: aload 7
    //   260: invokevirtual 618	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadReturn	()I
    //   263: istore 4
    //   265: aload 7
    //   267: invokevirtual 621	com/tencent/smtt/sdk/TbsDownloadUpload:getLocalCoreVersion	()I
    //   270: istore 5
    //   272: aload 6
    //   274: ldc_w 623
    //   277: new 227	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   284: ldc 118
    //   286: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload_2
    //   290: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc_w 412
    //   296: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload_3
    //   300: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: ldc_w 412
    //   306: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: iload 4
    //   311: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: ldc_w 412
    //   317: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: iload 5
    //   322: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   331: pop
    //   332: aload_1
    //   333: invokestatic 624	com/tencent/smtt/sdk/stat/b:a	(Landroid/content/Context;)Ljava/lang/String;
    //   336: astore 7
    //   338: ldc_w 310
    //   341: new 227	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 626
    //   351: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 7
    //   356: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 317	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload 7
    //   367: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   370: ifne +14 -> 384
    //   373: aload 6
    //   375: ldc_w 628
    //   378: aload 7
    //   380: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   383: pop
    //   384: aload 6
    //   386: ldc_w 630
    //   389: iconst_3
    //   390: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 6
    //   396: ldc_w 632
    //   399: aload_0
    //   400: getfield 266	MTT/ThirdAppInfoNew:sAndroidID	Ljava/lang/String;
    //   403: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   406: pop
    //   407: aload_1
    //   408: invokestatic 41	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   411: ifeq +204 -> 615
    //   414: ldc_w 634
    //   417: aload_1
    //   418: invokevirtual 151	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   421: invokevirtual 155	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   424: getfield 161	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   427: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   430: ifne +16 -> 446
    //   433: aload 6
    //   435: ldc_w 636
    //   438: aload_1
    //   439: invokestatic 640	com/tencent/smtt/sdk/TbsShareManager:getHostCoreVersions	(Landroid/content/Context;)J
    //   442: invokevirtual 585	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   445: pop
    //   446: aload 6
    //   448: ldc_w 642
    //   451: aload_0
    //   452: getfield 360	MTT/ThirdAppInfoNew:sWifiConnectedTime	J
    //   455: invokevirtual 585	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   458: pop
    //   459: aload 6
    //   461: ldc_w 644
    //   464: aload_0
    //   465: getfield 287	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   468: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   471: pop
    //   472: getstatic 649	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   475: istore_2
    //   476: aload_0
    //   477: getfield 287	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   480: ifgt +164 -> 644
    //   483: aload 6
    //   485: ldc_w 651
    //   488: aload_1
    //   489: invokestatic 656	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   492: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadInterruptCode	()I
    //   495: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   498: pop
    //   499: iload_2
    //   500: iconst_m1
    //   501: if_icmpne +12 -> 513
    //   504: ldc_w 310
    //   507: ldc_w 661
    //   510: invokestatic 663	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: aload_1
    //   514: invokestatic 656	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   517: aload_1
    //   518: invokevirtual 666	com/tencent/smtt/sdk/TbsDownloadConfig:uploadDownloadInterruptCodeIfNeeded	(Landroid/content/Context;)V
    //   521: invokestatic 669	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   524: ifnull +38 -> 562
    //   527: aload_0
    //   528: getfield 164	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   531: ldc_w 319
    //   534: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   537: ifeq +120 -> 657
    //   540: aload 6
    //   542: ldc_w 671
    //   545: invokestatic 669	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   548: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   551: pop
    //   552: aload 6
    //   554: ldc_w 673
    //   557: iconst_0
    //   558: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   561: pop
    //   562: aload 6
    //   564: areturn
    //   565: aload_0
    //   566: getfield 284	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   569: ifnonnull +30 -> 599
    //   572: aload 6
    //   574: ldc_w 623
    //   577: ldc_w 675
    //   580: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   583: pop
    //   584: goto -252 -> 332
    //   587: astore_0
    //   588: ldc_w 310
    //   591: ldc_w 677
    //   594: invokestatic 663	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: aconst_null
    //   598: areturn
    //   599: aload 6
    //   601: ldc_w 623
    //   604: aload_0
    //   605: getfield 284	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   608: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   611: pop
    //   612: goto -280 -> 332
    //   615: aload 6
    //   617: ldc_w 636
    //   620: aload_1
    //   621: invokestatic 682	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   624: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   627: pop
    //   628: aload 6
    //   630: ldc_w 684
    //   633: aload_1
    //   634: invokestatic 682	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   637: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   640: pop
    //   641: goto -195 -> 446
    //   644: aload 6
    //   646: ldc_w 651
    //   649: iload_2
    //   650: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   653: pop
    //   654: goto -155 -> 499
    //   657: aload_0
    //   658: getfield 164	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   661: ldc_w 600
    //   664: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   667: ifeq -105 -> 562
    //   670: aload 6
    //   672: ldc_w 671
    //   675: invokestatic 669	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   678: invokevirtual 64	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   681: pop
    //   682: aload 6
    //   684: ldc_w 673
    //   687: iconst_0
    //   688: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   691: pop
    //   692: aload 6
    //   694: areturn
    //   695: astore_0
    //   696: aload 6
    //   698: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	699	0	paramThirdAppInfoNew	ThirdAppInfoNew
    //   0	699	1	paramContext	Context
    //   251	399	2	i	int
    //   257	43	3	j	int
    //   263	47	4	k	int
    //   270	51	5	m	int
    //   7	690	6	localJSONObject	JSONObject
    //   238	141	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	230	587	java/lang/Exception
    //   230	332	587	java/lang/Exception
    //   332	384	587	java/lang/Exception
    //   384	446	587	java/lang/Exception
    //   446	499	587	java/lang/Exception
    //   504	513	587	java/lang/Exception
    //   513	521	587	java/lang/Exception
    //   565	584	587	java/lang/Exception
    //   599	612	587	java/lang/Exception
    //   615	641	587	java/lang/Exception
    //   644	654	587	java/lang/Exception
    //   521	562	695	java/lang/Exception
    //   657	692	695	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.b
 * JD-Core Version:    0.7.0.1
 */