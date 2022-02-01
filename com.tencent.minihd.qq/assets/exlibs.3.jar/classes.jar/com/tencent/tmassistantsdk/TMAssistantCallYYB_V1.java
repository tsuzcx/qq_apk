package com.tencent.tmassistantsdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class TMAssistantCallYYB_V1
  extends TMAssistantBaseCallYYB
  implements com.tencent.tmassistantsdk.internal.openSDK.b
{
  public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";
  public static final Uri CONTENT_URI = com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.b.a;
  protected static final String TAG = "TMAssistantCallYYB_V1";
  protected static TMAssistantCallYYB_V1 mInstance = null;
  Map mDownloadParams = null;
  protected int sdkAPILevel = 1;
  
  public static TMAssistantCallYYB_V1 getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMAssistantCallYYB_V1();
      }
      TMAssistantCallYYB_V1 localTMAssistantCallYYB_V1 = mInstance;
      return localTMAssistantCallYYB_V1;
    }
    finally {}
  }
  
  private boolean isFileExist(String paramString)
  {
    if (new File(paramString).exists())
    {
      k.c("TMAssistantCallYYB_V1", "File is exist");
      return true;
    }
    k.c("TMAssistantCallYYB_V1", "File is not exist");
    return false;
  }
  
  private void relateToQQDownloader(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    k.c("TMAssistantCallYYB_V1", "context = " + paramContext + ",param = " + paramTMAssistantCallYYBParamStruct + ",taskId = " + paramString);
    paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, false, false, paramString);
    paramTMAssistantCallYYBParamStruct.put("taskid", paramString);
    paramTMAssistantCallYYBParamStruct = super.formatIntentUriPath(4, paramTMAssistantCallYYBParamStruct);
    paramString = new Intent("com.tencent.android.qqdownloader.action.RELATED");
    paramString.setPackage("com.tencent.android.qqdownloader");
    paramString.putExtra("command", "cmd_updatedownload");
    paramString.putExtra("relatedurl", paramTMAssistantCallYYBParamStruct);
    paramContext.sendBroadcast(paramString);
  }
  
  public long addDownloadTaskFromAppDetail(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    k.c("TMAssistantCallYYB_V1", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    String str = UUID.randomUUID().toString();
    if ((this.mDownloadParams != null) && (paramTMAssistantCallYYBParamStruct != null))
    {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
      StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_addDownloadTaskFromAppDetail");
      com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    }
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramTMAssistantCallYYBParamStruct.actionFlag, null, 2, str);
    k.c("TMAssistantCallYYB_V1", "result = " + l);
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    k.c("TMAssistantCallYYB_V1", "param = " + paramTMAssistantCallYYBParamStruct + ",verifyType = " + paramString);
    String str = UUID.randomUUID().toString();
    if ((this.mDownloadParams != null) && (paramTMAssistantCallYYBParamStruct != null))
    {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
      StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_addDownloadTaskFromAuthorize");
      com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    }
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, true, true, paramTMAssistantCallYYBParamStruct.actionFlag, paramString, 3, str);
    k.c("TMAssistantCallYYB_V1", "result = " + l);
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(String paramString)
  {
    k.c("TMAssistantCallYYB_V1", "url = " + paramString);
    paramString = super.formatEncryptUrl(paramString);
    long l = System.currentTimeMillis();
    l = this.sdkChannel.a(this.hostPackageName, this.hostVersionCode, "", 0, paramString, l, l + 300000L, 0, null);
    k.c("TMAssistantCallYYB_V1", "result = " + l);
    return l;
  }
  
  public long addDownloadTaskFromTaskList(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    k.c("TMAssistantCallYYB_V1", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    String str = UUID.randomUUID().toString();
    if ((this.mDownloadParams != null) && (paramTMAssistantCallYYBParamStruct != null))
    {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
      StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_addDownloadTaskFromTaskList");
      com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    }
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramTMAssistantCallYYBParamStruct.actionFlag, null, 1, str);
    k.c("TMAssistantCallYYB_V1", "result = " + l);
    return l;
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    k.c("TMAssistantCallYYB_V1", "mContext = " + this.mContext);
    NetworkMonitorReceiver.a().c();
    com.tencent.tmassistantsdk.internal.c.e.a().d();
    com.tencent.tmassistantsdk.internal.c.e.a().b();
    if (this.mContext != null)
    {
      DownloadStateChangedReceiver.a().b(this.mContext);
      DownloadStateChangedReceiver.a().b(this);
    }
    f.a().c();
    this.mContext = null;
  }
  
  /* Error */
  public TMAssistantCallYYBTaskInfo getDownloadTaskState(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 229	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mContext	Landroid/content/Context;
    //   4: ifnonnull +22 -> 26
    //   7: ldc 15
    //   9: ldc_w 271
    //   12: invokestatic 274	com/tencent/tmassistantbase/a/k:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: new 269	java/lang/Exception
    //   18: dup
    //   19: ldc_w 276
    //   22: invokespecial 277	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   25: athrow
    //   26: aload_1
    //   27: ifnonnull +22 -> 49
    //   30: ldc 15
    //   32: ldc_w 279
    //   35: invokestatic 274	com/tencent/tmassistantbase/a/k:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: new 269	java/lang/Exception
    //   41: dup
    //   42: ldc_w 281
    //   45: invokespecial 277	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: ldc 15
    //   51: new 71	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   58: ldc 136
    //   60: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 65	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 229	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mContext	Landroid/content/Context;
    //   77: invokevirtual 285	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   80: astore 10
    //   82: aload 10
    //   84: getstatic 32	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:CONTENT_URI	Landroid/net/Uri;
    //   87: aconst_null
    //   88: ldc_w 287
    //   91: iconst_3
    //   92: anewarray 289	java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: aload_1
    //   98: getfield 292	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: aload_1
    //   105: getfield 295	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   108: invokestatic 299	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   111: aastore
    //   112: dup
    //   113: iconst_2
    //   114: aload_1
    //   115: getfield 302	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:channelId	Ljava/lang/String;
    //   118: aastore
    //   119: aconst_null
    //   120: invokevirtual 308	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   123: astore 10
    //   125: ldc 15
    //   127: new 71	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 310
    //   137: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: getfield 292	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   144: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 312
    //   150: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: getfield 295	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   157: invokestatic 299	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   160: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc_w 314
    //   166: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_1
    //   170: getfield 302	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:channelId	Ljava/lang/String;
    //   173: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 316	com/tencent/tmassistantbase/a/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 10
    //   184: ifnull +553 -> 737
    //   187: aload 10
    //   189: invokeinterface 321 1 0
    //   194: ifeq +543 -> 737
    //   197: ldc 15
    //   199: new 71	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 323
    //   209: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_1
    //   213: getfield 292	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   216: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 65	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload 10
    //   227: aload 10
    //   229: ldc_w 325
    //   232: invokeinterface 329 2 0
    //   237: invokeinterface 333 2 0
    //   242: lstore_3
    //   243: aload 10
    //   245: aload 10
    //   247: ldc_w 335
    //   250: invokeinterface 329 2 0
    //   255: invokeinterface 338 2 0
    //   260: invokestatic 341	com/tencent/tmassistantbase/a/f:c	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   263: iconst_0
    //   264: invokevirtual 347	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   267: checkcast 289	java/lang/String
    //   270: astore 11
    //   272: aload 10
    //   274: aload 10
    //   276: ldc_w 349
    //   279: invokeinterface 329 2 0
    //   284: invokeinterface 338 2 0
    //   289: astore 12
    //   291: aload 10
    //   293: aload 10
    //   295: ldc_w 351
    //   298: invokeinterface 329 2 0
    //   303: invokeinterface 333 2 0
    //   308: lstore 5
    //   310: aload 10
    //   312: aload 10
    //   314: ldc_w 353
    //   317: invokeinterface 329 2 0
    //   322: invokeinterface 333 2 0
    //   327: lstore 7
    //   329: aload 10
    //   331: aload 10
    //   333: ldc_w 355
    //   336: invokeinterface 329 2 0
    //   341: invokeinterface 359 2 0
    //   346: invokestatic 361	com/tencent/tmassistantbase/a/f:a	(I)I
    //   349: istore_2
    //   350: ldc 15
    //   352: new 71	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 363
    //   362: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload_2
    //   366: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 65	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: iconst_4
    //   376: iload_2
    //   377: if_icmpne +30 -> 407
    //   380: aload_0
    //   381: aload 12
    //   383: invokespecial 368	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:isFileExist	(Ljava/lang/String;)Z
    //   386: istore 9
    //   388: iload 9
    //   390: ifne +17 -> 407
    //   393: aload 10
    //   395: ifnull +10 -> 405
    //   398: aload 10
    //   400: invokeinterface 371 1 0
    //   405: aconst_null
    //   406: areturn
    //   407: new 373	com/tencent/tmassistantsdk/TMAssistantCallYYBTaskInfo
    //   410: dup
    //   411: aload 11
    //   413: aload 12
    //   415: iload_2
    //   416: lload 5
    //   418: lload 7
    //   420: ldc_w 375
    //   423: invokespecial 378	com/tencent/tmassistantsdk/TMAssistantCallYYBTaskInfo:<init>	(Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;)V
    //   426: astore 12
    //   428: aload 12
    //   430: astore 11
    //   432: aload_0
    //   433: getfield 40	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mDownloadParams	Ljava/util/Map;
    //   436: ifnull +163 -> 599
    //   439: aload_0
    //   440: getfield 40	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mDownloadParams	Ljava/util/Map;
    //   443: invokeinterface 382 1 0
    //   448: invokeinterface 388 1 0
    //   453: astore 11
    //   455: aload 11
    //   457: invokeinterface 393 1 0
    //   462: ifeq +270 -> 732
    //   465: aload 11
    //   467: invokeinterface 397 1 0
    //   472: checkcast 399	java/util/Map$Entry
    //   475: invokeinterface 402 1 0
    //   480: checkcast 169	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct
    //   483: astore 13
    //   485: aload 13
    //   487: ifnull -32 -> 455
    //   490: aload 13
    //   492: getfield 292	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   495: aload_1
    //   496: getfield 292	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   499: invokevirtual 406	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   502: ifeq -47 -> 455
    //   505: aload 13
    //   507: getfield 295	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   510: aload_1
    //   511: getfield 295	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskVersion	I
    //   514: if_icmpne -59 -> 455
    //   517: iconst_1
    //   518: istore_2
    //   519: aload 12
    //   521: astore 11
    //   523: iload_2
    //   524: ifne +75 -> 599
    //   527: ldc 15
    //   529: new 71	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 323
    //   539: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_1
    //   543: getfield 292	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskPackageName	Ljava/lang/String;
    //   546: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 65	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   555: invokestatic 149	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   558: invokevirtual 150	java/util/UUID:toString	()Ljava/lang/String;
    //   561: astore 11
    //   563: aload_1
    //   564: lload_3
    //   565: invokestatic 409	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   568: putfield 412	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct:taskApkId	Ljava/lang/String;
    //   571: aload_0
    //   572: getfield 40	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mDownloadParams	Ljava/util/Map;
    //   575: aload 11
    //   577: aload_1
    //   578: invokeinterface 101 3 0
    //   583: pop
    //   584: aload_0
    //   585: aload_0
    //   586: getfield 229	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:mContext	Landroid/content/Context;
    //   589: aload_1
    //   590: aload 11
    //   592: invokespecial 414	com/tencent/tmassistantsdk/TMAssistantCallYYB_V1:relateToQQDownloader	(Landroid/content/Context;Lcom/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct;Ljava/lang/String;)V
    //   595: aload 12
    //   597: astore 11
    //   599: aload 11
    //   601: astore 12
    //   603: aload 10
    //   605: ifnull +14 -> 619
    //   608: aload 10
    //   610: invokeinterface 371 1 0
    //   615: aload 11
    //   617: astore 12
    //   619: ldc 15
    //   621: new 71	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 416
    //   631: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 12
    //   636: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   639: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 65	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   645: aload 12
    //   647: areturn
    //   648: astore 11
    //   650: aconst_null
    //   651: astore 10
    //   653: aconst_null
    //   654: astore_1
    //   655: aload 11
    //   657: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   660: ldc 15
    //   662: ldc_w 421
    //   665: aload 11
    //   667: invokestatic 424	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   670: aload_1
    //   671: astore 12
    //   673: aload 10
    //   675: ifnull -56 -> 619
    //   678: aload 10
    //   680: invokeinterface 371 1 0
    //   685: aload_1
    //   686: astore 12
    //   688: goto -69 -> 619
    //   691: astore_1
    //   692: aconst_null
    //   693: astore 10
    //   695: aload 10
    //   697: ifnull +10 -> 707
    //   700: aload 10
    //   702: invokeinterface 371 1 0
    //   707: aload_1
    //   708: athrow
    //   709: astore_1
    //   710: goto -15 -> 695
    //   713: astore_1
    //   714: goto -19 -> 695
    //   717: astore 11
    //   719: aconst_null
    //   720: astore_1
    //   721: goto -66 -> 655
    //   724: astore 11
    //   726: aload 12
    //   728: astore_1
    //   729: goto -74 -> 655
    //   732: iconst_0
    //   733: istore_2
    //   734: goto -215 -> 519
    //   737: aconst_null
    //   738: astore 11
    //   740: goto -141 -> 599
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	this	TMAssistantCallYYB_V1
    //   0	743	1	paramTMAssistantCallYYBParamStruct	TMAssistantCallYYBParamStruct
    //   349	385	2	i	int
    //   242	323	3	l1	long
    //   308	109	5	l2	long
    //   327	92	7	l3	long
    //   386	3	9	bool	boolean
    //   80	621	10	localObject1	Object
    //   270	346	11	localObject2	Object
    //   648	18	11	localException1	Exception
    //   717	1	11	localException2	Exception
    //   724	1	11	localException3	Exception
    //   738	1	11	localObject3	Object
    //   289	438	12	localObject4	Object
    //   483	23	13	localTMAssistantCallYYBParamStruct	TMAssistantCallYYBParamStruct
    // Exception table:
    //   from	to	target	type
    //   82	125	648	java/lang/Exception
    //   82	125	691	finally
    //   125	182	709	finally
    //   187	375	709	finally
    //   380	388	709	finally
    //   407	428	709	finally
    //   432	455	709	finally
    //   455	485	709	finally
    //   490	517	709	finally
    //   527	595	709	finally
    //   655	670	713	finally
    //   125	182	717	java/lang/Exception
    //   187	375	717	java/lang/Exception
    //   380	388	717	java/lang/Exception
    //   407	428	717	java/lang/Exception
    //   432	455	724	java/lang/Exception
    //   455	485	724	java/lang/Exception
    //   490	517	724	java/lang/Exception
    //   527	595	724	java/lang/Exception
  }
  
  public void initTMAssistantCallYYBApi(Context paramContext)
  {
    k.c("TMAssistantCallYYB_V1", "context = " + paramContext);
    this.mContext = paramContext;
    this.hostPackageName = paramContext.getPackageName();
    this.hostVersionCode = f.c(this.mContext);
    f.a().a(this.mContext);
    this.sdkAPILevel = 1;
    DownloadStateChangedReceiver.a().a(this.mContext);
    DownloadStateChangedReceiver.a().a(this);
    NetworkMonitorReceiver.a().b();
    com.tencent.tmassistantsdk.internal.c.e.a();
  }
  
  public void onDownloadStateChanged(com.tencent.tmassistantsdk.internal.openSDK.e parame)
  {
    k.c("TMAssistantCallYYB_V1", "stateChangedParam = " + parame);
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = parame.a;
    int i = f.a(parame.e);
    int j = f.b(parame.f);
    Object localObject2 = parame.g;
    Object localObject3 = parame.d;
    k.c("TMAssistantCallYYB_V1", "onDownloadStateChanged state = " + i);
    Object localObject1 = null;
    parame = (com.tencent.tmassistantsdk.internal.openSDK.e)localObject1;
    if (localObject3 != null)
    {
      parame = (com.tencent.tmassistantsdk.internal.openSDK.e)localObject1;
      if (((String)localObject3).trim().length() > 0) {
        parame = (TMAssistantCallYYBParamStruct)this.mDownloadParams.get(localObject3);
      }
    }
    if (parame != null) {
      onStateChanged(parame, i, j, (String)localObject2);
    }
    while (6 == i)
    {
      parame = new ArrayList();
      localObject1 = this.mDownloadParams.entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (TMAssistantCallYYBParamStruct)((Map.Entry)localObject3).getValue();
          localObject3 = (String)((Map.Entry)localObject3).getKey();
          if ((localObject2 != null) && (!TextUtils.isEmpty(localTMAssistantCallYYBParamStruct.taskPackageName)) && (((TMAssistantCallYYBParamStruct)localObject2).taskPackageName.equals(localTMAssistantCallYYBParamStruct.taskPackageName)) && (((TMAssistantCallYYBParamStruct)localObject2).taskVersion == localTMAssistantCallYYBParamStruct.taskVersion))
          {
            parame.add(localObject3);
            continue;
            k.c("TMAssistantCallYYB_V1", "onDownloadStateChanged storeParam = null");
            break;
          }
        }
      }
      parame = parame.iterator();
      while (parame.hasNext())
      {
        localObject1 = (String)parame.next();
        this.mDownloadParams.remove(localObject1);
      }
    }
  }
  
  public void startToAppDetail(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      k.e("TMAssistantCallYYB_V1", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    k.c("TMAssistantCallYYB_V1", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
    }
    StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_startToAppDetail");
    com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, str);
    paramTMAssistantCallYYBParamStruct.put("taskid", str);
    paramTMAssistantCallYYBParamStruct = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(2, paramTMAssistantCallYYBParamStruct)));
    if ((paramContext instanceof Application)) {
      paramTMAssistantCallYYBParamStruct.addFlags(268435456);
    }
    paramContext.startActivity(paramTMAssistantCallYYBParamStruct);
  }
  
  public void startToAuthorized(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    if (paramContext == null)
    {
      k.e("TMAssistantCallYYB_V1", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMAssistantCallYYBParamStruct == null)
    {
      k.e("TMAssistantCallYYB_V1", "QQDownloaderParam param is null");
      throw new Exception("QQDownloaderParam param cann't be null!");
    }
    k.c("TMAssistantCallYYB_V1", "context = " + paramContext + ",param = " + paramTMAssistantCallYYBParamStruct + ",verifyType = " + paramString);
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
    }
    StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_startToAuthorized");
    com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, true, true, str);
    paramTMAssistantCallYYBParamStruct.put("verifytype", paramString);
    paramTMAssistantCallYYBParamStruct.put("taskid", str);
    paramTMAssistantCallYYBParamStruct = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(3, paramTMAssistantCallYYBParamStruct)));
    if ((paramContext instanceof Application)) {
      paramTMAssistantCallYYBParamStruct.addFlags(268435456);
    }
    paramContext.startActivity(paramTMAssistantCallYYBParamStruct);
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    k.c("TMAssistantCallYYB_V1", "context = " + paramContext + ",jumpUrl = " + paramString);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(formatEncryptUrl(paramString)));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
  }
  
  public void startToDownloadTaskList(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      k.e("TMAssistantCallYYB_V1", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMAssistantCallYYBParamStruct == null)
    {
      k.e("TMAssistantCallYYB_V1", "param is null");
      return;
    }
    k.c("TMAssistantCallYYB_V1", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    String str = UUID.randomUUID().toString();
    if (this.mDownloadParams != null) {
      this.mDownloadParams.put(str, paramTMAssistantCallYYBParamStruct);
    }
    StatStdReport localStatStdReport = com.tencent.tmassistantsdk.internal.c.b.h().a(com.tencent.tmassistantsdk.internal.c.b.a(paramTMAssistantCallYYBParamStruct), str, "V1_startToDownloadTaskList");
    com.tencent.tmassistantsdk.internal.c.b.h().a(localStatStdReport);
    paramTMAssistantCallYYBParamStruct = super.formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, str);
    paramTMAssistantCallYYBParamStruct.put("taskid", str);
    paramTMAssistantCallYYBParamStruct = new Intent("android.intent.action.VIEW", Uri.parse(super.formatIntentUriPath(1, paramTMAssistantCallYYBParamStruct)));
    if ((paramContext instanceof Application)) {
      paramTMAssistantCallYYBParamStruct.addFlags(268435456);
    }
    paramContext.startActivity(paramTMAssistantCallYYBParamStruct);
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      k.e("TMAssistantCallYYB_V1", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    if (TextUtils.isEmpty(paramString))
    {
      k.e("TMAssistantCallYYB_V1", "url is null");
      throw new Exception("param url shouldn't be null!");
    }
    k.c("TMAssistantCallYYB_V1", "context = " + paramContext + ",url = " + paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    paramString = super.formatIntentUriPath(5, localHashMap);
    k.c("TMAssistantCallYYB_V1", "startToWebView finalPath:" + paramString);
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    if ((paramContext instanceof Application)) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.TMAssistantCallYYB_V1
 * JD-Core Version:    0.7.0.1
 */