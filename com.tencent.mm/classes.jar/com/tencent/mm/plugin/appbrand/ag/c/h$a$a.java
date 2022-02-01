package com.tencent.mm.plugin.appbrand.ag.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.g.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnResourceLoader$Companion$CdnDownloadManager;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "()V", "DEFAULT_LENGTH", "", "INVALID_LENGTH", "downloadingTasks", "", "", "getDownloadingTasks", "()Ljava/util/List;", "progressCallbacks", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/Function2;", "", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "progressCallbacksLock", "Ljava/util/concurrent/locks/ReentrantLock;", "startCallbacks", "Lkotlin/Function1;", "", "startLock", "startRets", "taskCallers", "", "taskInfos", "Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnResourceLoader$Companion$CdnDownloadManager$TaskInfo;", "tasksLock", "callback", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "decodePrepareResponse", "", "inbuf", "getCachedLength", "downloadId", "offset", "expectedLength", "getCdnAuthInfo", "buff", "Ljava/io/ByteArrayOutputStream;", "getTotalLength", "listenDownload", "startCallback", "progressCallback", "onDataAvailable", "length", "onFinish", "ret", "onM3U8Ready", "m3u8", "onMoovReady", "svrFlag", "onProgress", "finished", "total", "startDownload", "caller", "", "srcUrl", "cachePath", "stopDownload", "SubTaskInfo", "TaskInfo", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h$a$a
  implements g.a, h.a
{
  public static final a utK;
  private static final ReentrantLock utL;
  private static final HashMap<String, b> utM;
  private static final HashMap<String, HashSet<Integer>> utN;
  private static final ReentrantLock utO;
  private static final HashMap<String, Boolean> utP;
  private static final HashMap<String, HashSet<b<Boolean, ah>>> utQ;
  private static final ReentrantLock utR;
  private static final HashMap<String, HashSet<m<Long, Long, ah>>> utS;
  
  static
  {
    AppMethodBeat.i(317942);
    utK = new a();
    utL = new ReentrantLock();
    utM = new HashMap();
    utN = new HashMap();
    utO = new ReentrantLock();
    utP = new HashMap();
    utQ = new HashMap();
    utR = new ReentrantLock();
    utS = new HashMap();
    AppMethodBeat.o(317942);
  }
  
  /* Error */
  public static void a(Object paramObject, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 155
    //   2: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 156
    //   8: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 163
    //   14: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 164
    //   20: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_3
    //   24: ldc 165
    //   26: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: getstatic 125	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utL	Ljava/util/concurrent/locks/ReentrantLock;
    //   32: checkcast 167	java/util/concurrent/locks/Lock
    //   35: astore 10
    //   37: aload 10
    //   39: invokeinterface 170 1 0
    //   44: getstatic 130	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utM	Ljava/util/HashMap;
    //   47: aload_2
    //   48: invokevirtual 174	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 15	com/tencent/mm/plugin/appbrand/ag/c/h$a$a$b
    //   54: astore 11
    //   56: aload 11
    //   58: ifnull +54 -> 112
    //   61: iconst_1
    //   62: aload 11
    //   64: getfield 177	com/tencent/mm/plugin/appbrand/ag/c/h$a$a$b:utW	Ljava/util/HashSet;
    //   67: new 13	com/tencent/mm/plugin/appbrand/ag/c/h$a$a$a
    //   70: dup
    //   71: lload 4
    //   73: lload 6
    //   75: invokespecial 180	com/tencent/mm/plugin/appbrand/ag/c/h$a$a$a:<init>	(JJ)V
    //   78: invokevirtual 186	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   81: if_icmpne +31 -> 112
    //   84: iconst_1
    //   85: istore 8
    //   87: iload 8
    //   89: ifeq +29 -> 118
    //   92: ldc 188
    //   94: ldc 190
    //   96: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 10
    //   101: invokeinterface 199 1 0
    //   106: ldc 155
    //   108: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: return
    //   112: iconst_0
    //   113: istore 8
    //   115: goto -28 -> 87
    //   118: aload 10
    //   120: invokeinterface 199 1 0
    //   125: aload 11
    //   127: astore 10
    //   129: aload 11
    //   131: ifnonnull +563 -> 694
    //   134: new 15	com/tencent/mm/plugin/appbrand/ag/c/h$a$a$b
    //   137: dup
    //   138: aload_1
    //   139: aload_2
    //   140: aload_3
    //   141: iconst_0
    //   142: invokespecial 202	com/tencent/mm/plugin/appbrand/ag/c/h$a$a$b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V
    //   145: astore 10
    //   147: ldc 188
    //   149: ldc 204
    //   151: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: getstatic 212	com/tencent/mm/plugin/appbrand/ag/c/a:utk	Lcom/tencent/mm/plugin/appbrand/ag/c/a;
    //   157: astore 11
    //   159: new 214	com/tencent/mm/g/h
    //   162: dup
    //   163: invokespecial 215	com/tencent/mm/g/h:<init>	()V
    //   166: astore 12
    //   168: aload 12
    //   170: aload_1
    //   171: putfield 219	com/tencent/mm/g/h:url	Ljava/lang/String;
    //   174: aload 12
    //   176: aload_2
    //   177: putfield 222	com/tencent/mm/g/h:field_mediaId	Ljava/lang/String;
    //   180: aload 12
    //   182: aload_3
    //   183: putfield 225	com/tencent/mm/g/h:field_fullpath	Ljava/lang/String;
    //   186: aload 12
    //   188: iconst_1
    //   189: putfield 229	com/tencent/mm/g/h:lxi	I
    //   192: aload 12
    //   194: getstatic 120	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utK	Lcom/tencent/mm/plugin/appbrand/ag/c/h$a$a;
    //   197: checkcast 6	com/tencent/mm/g/g$a
    //   200: putfield 233	com/tencent/mm/g/h:lwL	Lcom/tencent/mm/g/g$a;
    //   203: aload 12
    //   205: getstatic 120	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utK	Lcom/tencent/mm/plugin/appbrand/ag/c/h$a$a;
    //   208: checkcast 8	com/tencent/mm/g/h$a
    //   211: putfield 237	com/tencent/mm/g/h:lxs	Lcom/tencent/mm/g/h$a;
    //   214: aload 12
    //   216: ldc 239
    //   218: putfield 242	com/tencent/mm/g/h:taskName	Ljava/lang/String;
    //   221: aload 12
    //   223: iconst_4
    //   224: putfield 245	com/tencent/mm/g/h:lxc	I
    //   227: getstatic 251	kotlin/ah:aiuX	Lkotlin/ah;
    //   230: astore_1
    //   231: aload 12
    //   233: ldc 253
    //   235: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   238: ldc 255
    //   240: ldc_w 257
    //   243: aload 12
    //   245: getfield 222	com/tencent/mm/g/h:field_mediaId	Ljava/lang/String;
    //   248: invokestatic 261	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   251: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: getstatic 265	com/tencent/mm/plugin/appbrand/ag/c/a:utl	Ljava/util/concurrent/ConcurrentHashMap;
    //   257: aload 12
    //   259: getfield 222	com/tencent/mm/g/h:field_mediaId	Ljava/lang/String;
    //   262: aload 12
    //   264: invokevirtual 271	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   267: ifnonnull +298 -> 565
    //   270: new 273	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest
    //   273: dup
    //   274: invokespecial 274	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:<init>	()V
    //   277: astore_1
    //   278: aload_1
    //   279: aload 12
    //   281: getfield 222	com/tencent/mm/g/h:field_mediaId	Ljava/lang/String;
    //   284: putfield 277	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:fileKey	Ljava/lang/String;
    //   287: aload_1
    //   288: aload 12
    //   290: getfield 219	com/tencent/mm/g/h:url	Ljava/lang/String;
    //   293: putfield 278	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:url	Ljava/lang/String;
    //   296: aload_1
    //   297: aload 12
    //   299: getfield 281	com/tencent/mm/g/h:referer	Ljava/lang/String;
    //   302: putfield 282	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:referer	Ljava/lang/String;
    //   305: aload_1
    //   306: aload 12
    //   308: getfield 225	com/tencent/mm/g/h:field_fullpath	Ljava/lang/String;
    //   311: invokevirtual 286	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:setSavePath	(Ljava/lang/String;)V
    //   314: aload_1
    //   315: iconst_0
    //   316: putfield 289	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:fileSize	I
    //   319: aload_1
    //   320: sipush 20210
    //   323: putfield 292	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:fileType	I
    //   326: aload_1
    //   327: bipush 10
    //   329: putfield 295	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:concurrentCount	I
    //   332: aload_1
    //   333: aload 12
    //   335: getfield 298	com/tencent/mm/g/h:field_preloadRatio	I
    //   338: putfield 301	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:preloadRatio	I
    //   341: aload_1
    //   342: aload 12
    //   344: getfield 305	com/tencent/mm/g/h:preloadMinSize	J
    //   347: putfield 306	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:preloadMinSize	J
    //   350: aload_1
    //   351: new 308	java/lang/StringBuilder
    //   354: dup
    //   355: ldc_w 310
    //   358: invokespecial 312	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: invokestatic 318	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   364: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   367: ldc_w 324
    //   370: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: putfield 333	com/tencent/mars/cdn/CdnLogic$C2CDownloadRequest:customHeader	Ljava/lang/String;
    //   379: aload_1
    //   380: aload 11
    //   382: checkcast 335	com/tencent/mars/cdn/CdnLogic$VideoStreamingCallback
    //   385: aload 11
    //   387: checkcast 337	com/tencent/mars/cdn/CdnLogic$DownloadCallback
    //   390: aload 12
    //   392: getfield 229	com/tencent/mm/g/h:lxi	I
    //   395: invokestatic 343	com/tencent/mars/cdn/CdnLogic:startHttpVideoStreamingDownload	(Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadRequest;Lcom/tencent/mars/cdn/CdnLogic$VideoStreamingCallback;Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;I)I
    //   398: istore 9
    //   400: ldc 255
    //   402: ldc_w 345
    //   405: iload 9
    //   407: invokestatic 351	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   410: invokestatic 261	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   413: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: iload 9
    //   418: istore 8
    //   420: iload 9
    //   422: ifeq +19 -> 441
    //   425: getstatic 265	com/tencent/mm/plugin/appbrand/ag/c/a:utl	Ljava/util/concurrent/ConcurrentHashMap;
    //   428: aload 12
    //   430: getfield 222	com/tencent/mm/g/h:field_mediaId	Ljava/lang/String;
    //   433: invokevirtual 354	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   436: pop
    //   437: iload 9
    //   439: istore 8
    //   441: iload 8
    //   443: ifeq +159 -> 602
    //   446: ldc 188
    //   448: ldc_w 356
    //   451: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: getstatic 134	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utO	Ljava/util/concurrent/locks/ReentrantLock;
    //   457: checkcast 167	java/util/concurrent/locks/Lock
    //   460: astore_1
    //   461: aload_1
    //   462: invokeinterface 170 1 0
    //   467: getstatic 136	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utP	Ljava/util/HashMap;
    //   470: checkcast 361	java/util/Map
    //   473: aload_2
    //   474: getstatic 367	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   477: invokeinterface 370 3 0
    //   482: pop
    //   483: getstatic 138	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utQ	Ljava/util/HashMap;
    //   486: aload_2
    //   487: invokevirtual 371	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   490: checkcast 182	java/util/HashSet
    //   493: astore_0
    //   494: aload_0
    //   495: ifnonnull +76 -> 571
    //   498: aconst_null
    //   499: astore_0
    //   500: aload_1
    //   501: invokeinterface 199 1 0
    //   506: aload_0
    //   507: ifnull +89 -> 596
    //   510: aload_0
    //   511: checkcast 373	java/lang/Iterable
    //   514: invokeinterface 377 1 0
    //   519: astore_0
    //   520: aload_0
    //   521: invokeinterface 383 1 0
    //   526: ifeq +70 -> 596
    //   529: aload_0
    //   530: invokeinterface 387 1 0
    //   535: checkcast 389	kotlin/g/a/b
    //   538: getstatic 367	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   541: invokeinterface 392 2 0
    //   546: pop
    //   547: goto -27 -> 520
    //   550: astore_0
    //   551: aload 10
    //   553: invokeinterface 199 1 0
    //   558: ldc 155
    //   560: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   563: aload_0
    //   564: athrow
    //   565: iconst_0
    //   566: istore 8
    //   568: goto -127 -> 441
    //   571: aload_0
    //   572: checkcast 373	java/lang/Iterable
    //   575: invokestatic 398	kotlin/a/p:r	(Ljava/lang/Iterable;)Ljava/util/Set;
    //   578: astore_0
    //   579: goto -79 -> 500
    //   582: astore_0
    //   583: aload_1
    //   584: invokeinterface 199 1 0
    //   589: ldc 155
    //   591: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   594: aload_0
    //   595: athrow
    //   596: ldc 155
    //   598: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   601: return
    //   602: getstatic 125	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utL	Ljava/util/concurrent/locks/ReentrantLock;
    //   605: checkcast 167	java/util/concurrent/locks/Lock
    //   608: astore_3
    //   609: aload_3
    //   610: invokeinterface 170 1 0
    //   615: getstatic 130	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utM	Ljava/util/HashMap;
    //   618: checkcast 361	java/util/Map
    //   621: aload_2
    //   622: aload 10
    //   624: invokeinterface 370 3 0
    //   629: pop
    //   630: getstatic 132	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utN	Ljava/util/HashMap;
    //   633: checkcast 361	java/util/Map
    //   636: astore 11
    //   638: aload 11
    //   640: aload_2
    //   641: invokeinterface 399 2 0
    //   646: astore_1
    //   647: aload_1
    //   648: ifnonnull +242 -> 890
    //   651: new 182	java/util/HashSet
    //   654: dup
    //   655: invokespecial 400	java/util/HashSet:<init>	()V
    //   658: astore_1
    //   659: aload 11
    //   661: aload_2
    //   662: aload_1
    //   663: invokeinterface 370 3 0
    //   668: pop
    //   669: aload_1
    //   670: checkcast 182	java/util/HashSet
    //   673: aload_0
    //   674: invokevirtual 404	java/lang/Object:hashCode	()I
    //   677: invokestatic 351	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: invokevirtual 407	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   683: pop
    //   684: getstatic 251	kotlin/ah:aiuX	Lkotlin/ah;
    //   687: astore_0
    //   688: aload_3
    //   689: invokeinterface 199 1 0
    //   694: ldc 188
    //   696: new 308	java/lang/StringBuilder
    //   699: dup
    //   700: ldc_w 409
    //   703: invokespecial 312	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   706: aload_2
    //   707: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: ldc_w 411
    //   713: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: lload 4
    //   718: invokevirtual 414	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   721: ldc_w 416
    //   724: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: lload 6
    //   729: invokevirtual 414	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   732: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   738: getstatic 212	com/tencent/mm/plugin/appbrand/ag/c/a:utk	Lcom/tencent/mm/plugin/appbrand/ag/c/a;
    //   741: astore_0
    //   742: aload_2
    //   743: lload 4
    //   745: lload 6
    //   747: invokestatic 420	com/tencent/mm/plugin/appbrand/ag/c/a:t	(Ljava/lang/String;JJ)I
    //   750: istore 8
    //   752: ldc 188
    //   754: ldc_w 422
    //   757: iload 8
    //   759: invokestatic 351	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   762: invokestatic 261	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   765: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   768: iload 8
    //   770: ifne +114 -> 884
    //   773: getstatic 125	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utL	Ljava/util/concurrent/locks/ReentrantLock;
    //   776: checkcast 167	java/util/concurrent/locks/Lock
    //   779: astore_0
    //   780: aload_0
    //   781: invokeinterface 170 1 0
    //   786: ldc 188
    //   788: new 308	java/lang/StringBuilder
    //   791: dup
    //   792: ldc_w 424
    //   795: invokespecial 312	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   798: lload 4
    //   800: invokevirtual 414	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   803: ldc_w 416
    //   806: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: lload 6
    //   811: invokevirtual 414	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   814: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   820: aload 10
    //   822: getfield 177	com/tencent/mm/plugin/appbrand/ag/c/h$a$a$b:utW	Ljava/util/HashSet;
    //   825: new 13	com/tencent/mm/plugin/appbrand/ag/c/h$a$a$a
    //   828: dup
    //   829: lload 4
    //   831: lload 6
    //   833: invokespecial 180	com/tencent/mm/plugin/appbrand/ag/c/h$a$a$a:<init>	(JJ)V
    //   836: invokevirtual 407	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   839: pop
    //   840: getstatic 251	kotlin/ah:aiuX	Lkotlin/ah;
    //   843: astore_1
    //   844: aload_0
    //   845: invokeinterface 199 1 0
    //   850: ldc 155
    //   852: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   855: return
    //   856: astore_0
    //   857: aload_3
    //   858: invokeinterface 199 1 0
    //   863: ldc 155
    //   865: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   868: aload_0
    //   869: athrow
    //   870: astore_1
    //   871: aload_0
    //   872: invokeinterface 199 1 0
    //   877: ldc 155
    //   879: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   882: aload_1
    //   883: athrow
    //   884: ldc 155
    //   886: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   889: return
    //   890: goto -221 -> 669
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	893	0	paramObject	Object
    //   0	893	1	paramString1	String
    //   0	893	2	paramString2	String
    //   0	893	3	paramString3	String
    //   0	893	4	paramLong1	long
    //   0	893	6	paramLong2	long
    //   85	684	8	i	int
    //   398	40	9	j	int
    //   35	786	10	localObject1	Object
    //   54	606	11	localObject2	Object
    //   166	263	12	localh	com.tencent.mm.g.h
    // Exception table:
    //   from	to	target	type
    //   44	56	550	finally
    //   61	84	550	finally
    //   92	99	550	finally
    //   467	494	582	finally
    //   571	579	582	finally
    //   615	647	856	finally
    //   651	669	856	finally
    //   669	688	856	finally
    //   786	844	870	finally
  }
  
  public static long abQ(String paramString)
  {
    AppMethodBeat.i(317934);
    s.u(paramString, "downloadId");
    Lock localLock = (Lock)utL;
    localLock.lock();
    try
    {
      paramString = (b)utM.get(paramString);
      if (paramString == null) {
        return 0L;
      }
      long l = paramString.qHg;
      return l;
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(317934);
    }
  }
  
  /* Error */
  public static void c(String paramString, b<? super Boolean, ah> paramb, m<? super Long, ? super Long, ah> paramm)
  {
    // Byte code:
    //   0: ldc_w 433
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 164
    //   9: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ldc_w 434
    //   16: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_2
    //   20: ldc_w 435
    //   23: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   26: ldc 188
    //   28: ldc_w 437
    //   31: aload_0
    //   32: invokestatic 261	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: getstatic 140	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utR	Ljava/util/concurrent/locks/ReentrantLock;
    //   41: checkcast 167	java/util/concurrent/locks/Lock
    //   44: astore 4
    //   46: aload 4
    //   48: invokeinterface 170 1 0
    //   53: getstatic 142	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utS	Ljava/util/HashMap;
    //   56: checkcast 361	java/util/Map
    //   59: astore 5
    //   61: aload 5
    //   63: aload_0
    //   64: invokeinterface 399 2 0
    //   69: astore_3
    //   70: aload_3
    //   71: ifnonnull +191 -> 262
    //   74: new 182	java/util/HashSet
    //   77: dup
    //   78: invokespecial 400	java/util/HashSet:<init>	()V
    //   81: astore_3
    //   82: aload 5
    //   84: aload_0
    //   85: aload_3
    //   86: invokeinterface 370 3 0
    //   91: pop
    //   92: aload_3
    //   93: checkcast 182	java/util/HashSet
    //   96: aload_2
    //   97: invokevirtual 407	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: aload 4
    //   103: invokeinterface 199 1 0
    //   108: getstatic 134	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utO	Ljava/util/concurrent/locks/ReentrantLock;
    //   111: checkcast 167	java/util/concurrent/locks/Lock
    //   114: astore_3
    //   115: aload_3
    //   116: invokeinterface 170 1 0
    //   121: getstatic 136	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utP	Ljava/util/HashMap;
    //   124: aload_0
    //   125: invokevirtual 174	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: checkcast 363	java/lang/Boolean
    //   131: astore_2
    //   132: aload_2
    //   133: ifnonnull +82 -> 215
    //   136: getstatic 138	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utQ	Ljava/util/HashMap;
    //   139: checkcast 361	java/util/Map
    //   142: astore 4
    //   144: aload 4
    //   146: aload_0
    //   147: invokeinterface 399 2 0
    //   152: astore_2
    //   153: aload_2
    //   154: ifnonnull +103 -> 257
    //   157: new 182	java/util/HashSet
    //   160: dup
    //   161: invokespecial 400	java/util/HashSet:<init>	()V
    //   164: astore_2
    //   165: aload 4
    //   167: aload_0
    //   168: aload_2
    //   169: invokeinterface 370 3 0
    //   174: pop
    //   175: aload_2
    //   176: astore_0
    //   177: aload_0
    //   178: checkcast 182	java/util/HashSet
    //   181: aload_1
    //   182: invokevirtual 407	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   185: pop
    //   186: aload_3
    //   187: invokeinterface 199 1 0
    //   192: ldc_w 433
    //   195: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: return
    //   199: astore_0
    //   200: aload 4
    //   202: invokeinterface 199 1 0
    //   207: ldc_w 433
    //   210: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_0
    //   214: athrow
    //   215: aload_3
    //   216: invokeinterface 199 1 0
    //   221: aload_1
    //   222: aload_2
    //   223: invokevirtual 440	java/lang/Boolean:booleanValue	()Z
    //   226: invokestatic 443	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   229: invokeinterface 392 2 0
    //   234: pop
    //   235: ldc_w 433
    //   238: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: return
    //   242: astore_0
    //   243: aload_3
    //   244: invokeinterface 199 1 0
    //   249: ldc_w 433
    //   252: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload_0
    //   256: athrow
    //   257: aload_2
    //   258: astore_0
    //   259: goto -82 -> 177
    //   262: goto -170 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramString	String
    //   0	265	1	paramb	b<? super Boolean, ah>
    //   0	265	2	paramm	m<? super Long, ? super Long, ah>
    //   69	175	3	localObject1	Object
    //   44	157	4	localObject2	Object
    //   59	24	5	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   53	70	199	finally
    //   74	92	199	finally
    //   92	101	199	finally
    //   121	132	242	finally
    //   136	153	242	finally
    //   157	175	242	finally
    //   177	186	242	finally
  }
  
  public static List<String> cOc()
  {
    AppMethodBeat.i(317855);
    Object localObject1 = (Lock)utL;
    ((Lock)localObject1).lock();
    try
    {
      Set localSet = utM.keySet();
      ((Lock)localObject1).unlock();
      s.s(localSet, "tasksLock.withLock { taskInfos.keys }");
      localObject1 = p.p((Iterable)localSet);
      AppMethodBeat.o(317855);
      return localObject1;
    }
    finally
    {
      ((Lock)localObject1).unlock();
      AppMethodBeat.o(317855);
    }
  }
  
  /* Error */
  public static void e(Object paramObject, String paramString)
  {
    // Byte code:
    //   0: ldc_w 463
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 156
    //   9: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ldc 164
    //   15: invokestatic 162	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: getstatic 125	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utL	Ljava/util/concurrent/locks/ReentrantLock;
    //   21: checkcast 167	java/util/concurrent/locks/Lock
    //   24: astore 4
    //   26: aload 4
    //   28: invokeinterface 170 1 0
    //   33: getstatic 130	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utM	Ljava/util/HashMap;
    //   36: aload_1
    //   37: invokevirtual 174	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 15	com/tencent/mm/plugin/appbrand/ag/c/h$a$a$b
    //   43: astore 5
    //   45: aload 5
    //   47: ifnonnull +17 -> 64
    //   50: aload 4
    //   52: invokeinterface 199 1 0
    //   57: ldc_w 463
    //   60: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: return
    //   64: getstatic 132	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utN	Ljava/util/HashMap;
    //   67: aload_1
    //   68: invokevirtual 174	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 182	java/util/HashSet
    //   74: astore 5
    //   76: aload 5
    //   78: ifnull +41 -> 119
    //   81: aload 5
    //   83: aload_0
    //   84: invokevirtual 404	java/lang/Object:hashCode	()I
    //   87: invokestatic 351	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: invokevirtual 465	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   93: istore_3
    //   94: iconst_1
    //   95: iload_3
    //   96: if_icmpne +23 -> 119
    //   99: iconst_1
    //   100: istore_2
    //   101: iload_2
    //   102: ifne +22 -> 124
    //   105: aload 4
    //   107: invokeinterface 199 1 0
    //   112: ldc_w 463
    //   115: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: return
    //   119: iconst_0
    //   120: istore_2
    //   121: goto -20 -> 101
    //   124: aload 5
    //   126: checkcast 467	java/util/Collection
    //   129: invokeinterface 470 1 0
    //   134: ifne +31 -> 165
    //   137: iconst_1
    //   138: istore_2
    //   139: iload_2
    //   140: ifeq +30 -> 170
    //   143: ldc 188
    //   145: ldc_w 472
    //   148: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload 4
    //   153: invokeinterface 199 1 0
    //   158: ldc_w 463
    //   161: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: return
    //   165: iconst_0
    //   166: istore_2
    //   167: goto -28 -> 139
    //   170: getstatic 251	kotlin/ah:aiuX	Lkotlin/ah;
    //   173: astore_0
    //   174: aload 4
    //   176: invokeinterface 199 1 0
    //   181: getstatic 212	com/tencent/mm/plugin/appbrand/ag/c/a:utk	Lcom/tencent/mm/plugin/appbrand/ag/c/a;
    //   184: astore_0
    //   185: aload_1
    //   186: invokestatic 476	com/tencent/mm/plugin/appbrand/ag/c/a:agO	(Ljava/lang/String;)I
    //   189: ifeq +11 -> 200
    //   192: ldc 188
    //   194: ldc_w 478
    //   197: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: getstatic 134	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utO	Ljava/util/concurrent/locks/ReentrantLock;
    //   203: checkcast 167	java/util/concurrent/locks/Lock
    //   206: astore_0
    //   207: aload_0
    //   208: invokeinterface 170 1 0
    //   213: getstatic 136	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utP	Ljava/util/HashMap;
    //   216: aload_1
    //   217: invokevirtual 371	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   220: pop
    //   221: getstatic 138	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utQ	Ljava/util/HashMap;
    //   224: aload_1
    //   225: invokevirtual 371	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   228: checkcast 182	java/util/HashSet
    //   231: astore 4
    //   233: aload_0
    //   234: invokeinterface 199 1 0
    //   239: aload 4
    //   241: ifnull +75 -> 316
    //   244: aload 4
    //   246: checkcast 373	java/lang/Iterable
    //   249: invokeinterface 377 1 0
    //   254: astore_0
    //   255: aload_0
    //   256: invokeinterface 383 1 0
    //   261: ifeq +55 -> 316
    //   264: aload_0
    //   265: invokeinterface 387 1 0
    //   270: checkcast 389	kotlin/g/a/b
    //   273: getstatic 367	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   276: invokeinterface 392 2 0
    //   281: pop
    //   282: goto -27 -> 255
    //   285: astore_0
    //   286: aload 4
    //   288: invokeinterface 199 1 0
    //   293: ldc_w 463
    //   296: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: aload_0
    //   300: athrow
    //   301: astore_1
    //   302: aload_0
    //   303: invokeinterface 199 1 0
    //   308: ldc_w 463
    //   311: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: aload_1
    //   315: athrow
    //   316: getstatic 140	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utR	Ljava/util/concurrent/locks/ReentrantLock;
    //   319: checkcast 167	java/util/concurrent/locks/Lock
    //   322: astore_0
    //   323: aload_0
    //   324: invokeinterface 170 1 0
    //   329: getstatic 142	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utS	Ljava/util/HashMap;
    //   332: aload_1
    //   333: invokevirtual 371	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   336: pop
    //   337: aload_0
    //   338: invokeinterface 199 1 0
    //   343: getstatic 125	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utL	Ljava/util/concurrent/locks/ReentrantLock;
    //   346: checkcast 167	java/util/concurrent/locks/Lock
    //   349: astore_0
    //   350: aload_0
    //   351: invokeinterface 170 1 0
    //   356: getstatic 132	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utN	Ljava/util/HashMap;
    //   359: aload_1
    //   360: invokevirtual 371	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: getstatic 130	com/tencent/mm/plugin/appbrand/ag/c/h$a$a:utM	Ljava/util/HashMap;
    //   367: aload_1
    //   368: invokevirtual 371	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: pop
    //   372: aload_0
    //   373: invokeinterface 199 1 0
    //   378: ldc_w 463
    //   381: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: return
    //   385: astore_1
    //   386: aload_0
    //   387: invokeinterface 199 1 0
    //   392: ldc_w 463
    //   395: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   398: aload_1
    //   399: athrow
    //   400: astore_1
    //   401: aload_0
    //   402: invokeinterface 199 1 0
    //   407: ldc_w 463
    //   410: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: aload_1
    //   414: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	paramObject	Object
    //   0	415	1	paramString	String
    //   100	67	2	i	int
    //   93	4	3	bool	boolean
    //   24	263	4	localObject1	Object
    //   43	82	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	45	285	finally
    //   64	76	285	finally
    //   81	94	285	finally
    //   124	137	285	finally
    //   143	151	285	finally
    //   170	174	285	finally
    //   213	233	301	finally
    //   329	337	385	finally
    //   356	372	400	finally
  }
  
  public static int u(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(317928);
    s.u(paramString, "downloadId");
    Lock localLock = (Lock)utL;
    localLock.lock();
    try
    {
      Object localObject = (b)utM.get(paramString);
      if (localObject == null) {
        return 0;
      }
      int i;
      if ((0L != ((b)localObject).qHg) && (((b)localObject).qHg == ((b)localObject).utV))
      {
        paramLong1 = k.bS(paramLong2, ((b)localObject).qHg - paramLong1);
        i = (int)paramLong1;
        return i;
      }
      localObject = ah.aiuX;
      localLock.unlock();
      if ((CdnLogic.taskExist(paramString)) && (CdnLogic.isVideoDataAvailable(paramString, paramLong1, paramLong2)))
      {
        i = (int)paramLong2;
        AppMethodBeat.o(317928);
        return i;
      }
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(317928);
    }
    AppMethodBeat.o(317928);
    return 0;
  }
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(317962);
    s.u(paramString, "mediaId");
    Log.i("MicroMsg.AppBrand.ThumbCdnResourceLoader", "callback, mediaId: " + paramString + ", startRet: " + paramInt);
    if (paramInt != 0)
    {
      paramc = (Lock)utO;
      paramc.lock();
      try
      {
        ((Map)utP).put(paramString, Boolean.FALSE);
        paramString = (HashSet)utQ.remove(paramString);
        if (paramString == null) {}
        for (paramString = null;; paramString = p.r((Iterable)paramString))
        {
          paramc.unlock();
          if (paramString == null) {
            break;
          }
          paramString = ((Iterable)paramString).iterator();
          while (paramString.hasNext()) {
            ((b)paramString.next()).invoke(Boolean.FALSE);
          }
        }
        AppMethodBeat.o(317962);
      }
      finally
      {
        paramc.unlock();
        AppMethodBeat.o(317962);
      }
    }
    return 0;
  }
  
  public final void a(String paramString, int paramInt, d paramd)
  {
    AppMethodBeat.i(318011);
    Log.i("MicroMsg.AppBrand.ThumbCdnResourceLoader", "onFinish, mediaId: " + paramString + ", ret: " + paramInt);
    if (paramString == null)
    {
      AppMethodBeat.o(318011);
      return;
    }
    if (paramd == null)
    {
      AppMethodBeat.o(318011);
      return;
    }
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    }
    Object localObject;
    for (;;)
    {
      Lock localLock = (Lock)utO;
      localLock.lock();
      try
      {
        ((Map)utP).put(paramString, Boolean.valueOf(bool));
        localObject = (HashSet)utQ.remove(paramString);
        if (localObject == null) {}
        for (localObject = null;; localObject = p.r((Iterable)localObject))
        {
          localLock.unlock();
          if (localObject == null) {
            break label213;
          }
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((b)((Iterator)localObject).next()).invoke(Boolean.valueOf(bool));
          }
          bool = false;
          break;
        }
        l = paramd.field_fileLength;
      }
      finally
      {
        localLock.unlock();
        AppMethodBeat.o(318011);
      }
    }
    label213:
    long l;
    if (bool)
    {
      paramd = (Lock)utR;
      paramd.lock();
    }
    try
    {
      localObject = (HashSet)utS.remove(paramString);
      paramd.unlock();
      if (localObject != null)
      {
        paramd = ((Iterable)localObject).iterator();
        while (paramd.hasNext()) {
          ((m)paramd.next()).invoke(Long.valueOf(l), Long.valueOf(l));
        }
      }
      Log.w("MicroMsg.AppBrand.ThumbCdnResourceLoader", "onFinish, cancelDownloadTask fail");
    }
    finally
    {
      paramd.unlock();
      AppMethodBeat.o(318011);
    }
    paramd = (Lock)utL;
    paramd.lock();
    try
    {
      utN.remove(paramString);
      utM.remove(paramString);
      return;
    }
    finally
    {
      paramd.unlock();
      AppMethodBeat.o(318011);
    }
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(317987);
    s.u(paramString2, "svrFlag");
    Log.i("MicroMsg.AppBrand.ThumbCdnResourceLoader", "onMoovReady, mediaId: " + paramString1 + ", offset: " + paramLong1 + ", length: " + paramLong2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(317987);
      return;
    }
    paramString2 = (Lock)utO;
    paramString2.lock();
    try
    {
      ((Map)utP).put(paramString1, Boolean.TRUE);
      paramString1 = (HashSet)utQ.remove(paramString1);
      if (paramString1 == null) {}
      for (paramString1 = null;; paramString1 = p.r((Iterable)paramString1))
      {
        paramString2.unlock();
        if (paramString1 == null) {
          break;
        }
        paramString1 = ((Iterable)paramString1).iterator();
        while (paramString1.hasNext()) {
          ((b)paramString1.next()).invoke(Boolean.TRUE);
        }
      }
      AppMethodBeat.o(317987);
    }
    finally
    {
      paramString2.unlock();
      AppMethodBeat.o(317987);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(317949);
    Log.i("MicroMsg.AppBrand.ThumbCdnResourceLoader", s.X("getCdnAuthInfo, mediaId: ", paramString));
    AppMethodBeat.o(317949);
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(318001);
    if (paramString == null)
    {
      AppMethodBeat.o(318001);
      return;
    }
    Object localObject2 = (Lock)utO;
    ((Lock)localObject2).lock();
    Object localObject1;
    try
    {
      ((Map)utP).put(paramString, Boolean.TRUE);
      localObject1 = (HashSet)utQ.remove(paramString);
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = p.r((Iterable)localObject1))
      {
        ((Lock)localObject2).unlock();
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((b)((Iterator)localObject1).next()).invoke(Boolean.TRUE);
        }
      }
      localObject2 = (Lock)utR;
    }
    finally
    {
      ((Lock)localObject2).unlock();
      AppMethodBeat.o(318001);
    }
    ((Lock)localObject2).lock();
    if (paramLong1 >= paramLong2) {}
    try
    {
      for (localObject1 = (HashSet)utS.remove(paramString);; localObject1 = (HashSet)utS.get(paramString))
      {
        ((Lock)localObject2).unlock();
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((m)((Iterator)localObject1).next()).invoke(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
        }
      }
      localObject1 = (Lock)utL;
    }
    finally
    {
      ((Lock)localObject2).unlock();
      AppMethodBeat.o(318001);
    }
    ((Lock)localObject1).lock();
    Object localObject3;
    for (;;)
    {
      try
      {
        paramString = (b)utM.get(paramString);
        if (paramString == null)
        {
          Log.i("MicroMsg.AppBrand.ThumbCdnResourceLoader", "onProgress, taskInfo is null");
          return;
        }
        paramString.utV = paramLong1;
        paramString.qHg = paramLong2;
        Log.i("MicroMsg.AppBrand.ThumbCdnResourceLoader", s.X("markDownloaded, downloaded: ", Long.valueOf(paramLong1)));
        localObject3 = (Iterable)paramString.utW;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        Object localObject4 = ((Iterator)localObject3).next();
        h.a.a.a locala = (h.a.a.a)localObject4;
        int i;
        if (locala.utT + locala.utU <= paramLong1)
        {
          i = 1;
          if (i != 0) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        else
        {
          i = 0;
        }
      }
      finally
      {
        ((Lock)localObject1).unlock();
        AppMethodBeat.o(318001);
      }
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (h.a.a.a)((Iterator)localObject2).next();
      paramString.utW.remove(localObject3);
    }
    paramString = ah.aiuX;
    ((Lock)localObject1).unlock();
    AppMethodBeat.o(318001);
  }
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(317968);
    Log.i("MicroMsg.AppBrand.ThumbCdnResourceLoader", s.X("decodePrepareResponse, mediaId: ", paramString));
    AppMethodBeat.o(317968);
    return new byte[0];
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(317977);
    Log.i("MicroMsg.AppBrand.ThumbCdnResourceLoader", "onDataAvailable, mediaId: " + paramString + ", offset: " + paramLong1 + ", length: " + paramLong2);
    if (paramString == null)
    {
      AppMethodBeat.o(317977);
      return;
    }
    Lock localLock = (Lock)utO;
    localLock.lock();
    try
    {
      ((Map)utP).put(paramString, Boolean.TRUE);
      paramString = (HashSet)utQ.remove(paramString);
      if (paramString == null) {}
      for (paramString = null;; paramString = p.r((Iterable)paramString))
      {
        localLock.unlock();
        if (paramString == null) {
          break;
        }
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext()) {
          ((b)paramString.next()).invoke(Boolean.TRUE);
        }
      }
      AppMethodBeat.o(317977);
    }
    finally
    {
      localLock.unlock();
      AppMethodBeat.o(317977);
    }
  }
  
  public final void onM3U8Ready(String paramString1, String paramString2)
  {
    AppMethodBeat.i(317992);
    Log.i("MicroMsg.AppBrand.ThumbCdnResourceLoader", "onMoovReady, mediaId: " + paramString1 + ", m3u8: " + paramString2);
    AppMethodBeat.o(317992);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnResourceLoader$Companion$CdnDownloadManager$TaskInfo;", "", "srcUrl", "", "downloadId", "cachePath", "cachedLength", "", "totalLength", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getCachePath", "()Ljava/lang/String;", "getCachedLength", "()J", "setCachedLength", "(J)V", "getDownloadId", "getSrcUrl", "subTaskInfoSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnResourceLoader$Companion$CdnDownloadManager$SubTaskInfo;", "Lkotlin/collections/HashSet;", "getTotalLength", "setTotalLength", "isDownloading", "", "offset", "length", "markDownloaded", "", "downloaded", "markDownloading", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private final String cachePath;
    private final String hsg;
    long qHg;
    long utV;
    HashSet<h.a.a.a> utW;
    private final String utz;
    
    private b(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(317848);
      this.hsg = paramString1;
      this.utz = paramString2;
      this.cachePath = paramString3;
      this.utV = 0L;
      this.qHg = 0L;
      this.utW = new HashSet();
      AppMethodBeat.o(317848);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.h.a.a
 * JD-Core Version:    0.7.0.1
 */