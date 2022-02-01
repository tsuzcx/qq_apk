package com.tencent.mm.modelstat;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.emj;
import com.tencent.mm.protocal.protobuf.emk;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.WiFiScanResult;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashMap;
import java.util.List;

public final class n
{
  private static int hOt;
  private static long hOu;
  private static int hOv;
  private static final byte[] lock;
  private static long oXe;
  private static HashMap<String, Long> oXf;
  private static String oXg;
  private static long oXh;
  private static List<ConnectivityCompat.WiFiScanResult> oXi;
  private static long oXj;
  private static int oXk;
  private static long oXl;
  private static float oXm;
  private static float oXn;
  private static long oXo;
  private static MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(151129);
    oXe = 86400000L;
    oXf = new HashMap();
    oXg = null;
    lock = new byte[0];
    oXj = 9223372036854775807L;
    oXk = 0;
    timer = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151113);
        try
        {
          n.bNh();
          if ((n.oXk < 2000) && (n.oXk > 1000)) {
            n.wW(n.oXk);
          }
          for (;;)
          {
            AppMethodBeat.o(151113);
            return false;
            n.wX(n.oXk);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.NetTypeReporter", "run :%s", new Object[] { Util.stackTraceToString(localException) });
          }
        }
      }
    }, false);
    oXl = 0L;
    hOu = 0L;
    oXm = 0.0F;
    oXn = 0.0F;
    hOv = 0;
    hOt = 0;
    oXo = 0L;
    AppMethodBeat.o(151129);
  }
  
  /* Error */
  private static boolean A(java.util.ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: ldc 113
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 119	java/util/ArrayList:size	()I
    //   9: ifne +17 -> 26
    //   12: ldc 121
    //   14: ldc 123
    //   16: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 113
    //   21: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_0
    //   25: ireturn
    //   26: getstatic 62	com/tencent/mm/modelstat/n:oXg	Ljava/lang/String;
    //   29: invokestatic 135	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   32: ifeq +30 -> 62
    //   35: new 137	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   42: invokestatic 142	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   45: getfield 147	com/tencent/mm/kernel/f:cachePath	Ljava/lang/String;
    //   48: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 153
    //   53: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: putstatic 62	com/tencent/mm/modelstat/n:oXg	Ljava/lang/String;
    //   62: getstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   65: invokevirtual 158	java/util/HashMap:size	()I
    //   68: ifne +171 -> 239
    //   71: getstatic 62	com/tencent/mm/modelstat/n:oXg	Ljava/lang/String;
    //   74: invokestatic 164	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   77: ldc2_w 165
    //   80: lcmp
    //   81: ifle +10 -> 91
    //   84: getstatic 62	com/tencent/mm/modelstat/n:oXg	Ljava/lang/String;
    //   87: invokestatic 169	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   90: pop
    //   91: getstatic 62	com/tencent/mm/modelstat/n:oXg	Ljava/lang/String;
    //   94: invokestatic 173	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   97: astore 4
    //   99: new 175	java/io/ObjectInputStream
    //   102: dup
    //   103: new 177	java/io/BufferedInputStream
    //   106: dup
    //   107: aload 4
    //   109: invokespecial 180	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   112: invokespecial 181	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   115: astore 5
    //   117: aload 5
    //   119: astore 7
    //   121: aload 4
    //   123: astore 6
    //   125: aload 5
    //   127: invokevirtual 185	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   130: checkcast 55	java/util/HashMap
    //   133: putstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   136: aload 5
    //   138: astore 7
    //   140: aload 4
    //   142: astore 6
    //   144: ldc 121
    //   146: ldc 187
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: getstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   157: invokevirtual 158	java/util/HashMap:size	()I
    //   160: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aload 5
    //   169: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   172: aload 4
    //   174: ifnull +8 -> 182
    //   177: aload 4
    //   179: invokevirtual 202	java/io/InputStream:close	()V
    //   182: getstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   185: invokevirtual 158	java/util/HashMap:size	()I
    //   188: ifle +15 -> 203
    //   191: getstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   194: invokevirtual 158	java/util/HashMap:size	()I
    //   197: sipush 1000
    //   200: if_icmple +39 -> 239
    //   203: ldc 121
    //   205: ldc 204
    //   207: iconst_2
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: getstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   216: invokevirtual 158	java/util/HashMap:size	()I
    //   219: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: getstatic 62	com/tencent/mm/modelstat/n:oXg	Ljava/lang/String;
    //   228: aastore
    //   229: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: getstatic 62	com/tencent/mm/modelstat/n:oXg	Ljava/lang/String;
    //   235: invokestatic 169	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   238: pop
    //   239: aload_0
    //   240: invokevirtual 208	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   243: astore_0
    //   244: iconst_0
    //   245: istore_1
    //   246: aload_0
    //   247: invokeinterface 214 1 0
    //   252: ifeq +299 -> 551
    //   255: aload_0
    //   256: invokeinterface 217 1 0
    //   261: checkcast 219	java/lang/String
    //   264: astore 4
    //   266: getstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   269: aload 4
    //   271: invokevirtual 223	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   274: iconst_0
    //   275: invokestatic 227	com/tencent/mm/sdk/platformtools/Util:nullAsLong	(Ljava/lang/Object;I)J
    //   278: invokestatic 231	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   281: lstore_2
    //   282: ldc 121
    //   284: ldc 233
    //   286: iconst_2
    //   287: anewarray 4	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: aload 4
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: lload_2
    //   298: invokestatic 238	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   301: aastore
    //   302: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: lload_2
    //   306: lconst_0
    //   307: lcmp
    //   308: ifle +11 -> 319
    //   311: lload_2
    //   312: getstatic 53	com/tencent/mm/modelstat/n:oXe	J
    //   315: lcmp
    //   316: ifle +557 -> 873
    //   319: getstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   322: aload 4
    //   324: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   327: invokestatic 238	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   330: invokevirtual 249	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   333: pop
    //   334: iconst_1
    //   335: istore_1
    //   336: goto -90 -> 246
    //   339: astore 4
    //   341: ldc 121
    //   343: ldc 251
    //   345: iconst_1
    //   346: anewarray 4	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: aload 4
    //   353: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   356: aastore
    //   357: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: new 55	java/util/HashMap
    //   363: dup
    //   364: invokespecial 58	java/util/HashMap:<init>	()V
    //   367: putstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   370: goto -188 -> 182
    //   373: astore 8
    //   375: aconst_null
    //   376: astore 5
    //   378: aconst_null
    //   379: astore 4
    //   381: aload 5
    //   383: astore 7
    //   385: aload 4
    //   387: astore 6
    //   389: ldc 121
    //   391: ldc 251
    //   393: iconst_1
    //   394: anewarray 4	java/lang/Object
    //   397: dup
    //   398: iconst_0
    //   399: aload 8
    //   401: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   404: aastore
    //   405: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   408: aload 5
    //   410: astore 7
    //   412: aload 4
    //   414: astore 6
    //   416: new 55	java/util/HashMap
    //   419: dup
    //   420: invokespecial 58	java/util/HashMap:<init>	()V
    //   423: putstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   426: aload 5
    //   428: ifnull +8 -> 436
    //   431: aload 5
    //   433: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   436: aload 4
    //   438: ifnull -256 -> 182
    //   441: aload 4
    //   443: invokevirtual 202	java/io/InputStream:close	()V
    //   446: goto -264 -> 182
    //   449: astore 4
    //   451: ldc 121
    //   453: ldc 251
    //   455: iconst_1
    //   456: anewarray 4	java/lang/Object
    //   459: dup
    //   460: iconst_0
    //   461: aload 4
    //   463: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   466: aastore
    //   467: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   470: new 55	java/util/HashMap
    //   473: dup
    //   474: invokespecial 58	java/util/HashMap:<init>	()V
    //   477: putstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   480: goto -298 -> 182
    //   483: astore_0
    //   484: aconst_null
    //   485: astore 7
    //   487: aconst_null
    //   488: astore 4
    //   490: aload 7
    //   492: ifnull +8 -> 500
    //   495: aload 7
    //   497: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   500: aload 4
    //   502: ifnull +8 -> 510
    //   505: aload 4
    //   507: invokevirtual 202	java/io/InputStream:close	()V
    //   510: ldc 113
    //   512: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   515: aload_0
    //   516: athrow
    //   517: astore 4
    //   519: ldc 121
    //   521: ldc 251
    //   523: iconst_1
    //   524: anewarray 4	java/lang/Object
    //   527: dup
    //   528: iconst_0
    //   529: aload 4
    //   531: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   534: aastore
    //   535: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: new 55	java/util/HashMap
    //   541: dup
    //   542: invokespecial 58	java/util/HashMap:<init>	()V
    //   545: putstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   548: goto -38 -> 510
    //   551: iload_1
    //   552: ifeq +100 -> 652
    //   555: getstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   558: invokevirtual 158	java/util/HashMap:size	()I
    //   561: ifle +91 -> 652
    //   564: getstatic 62	com/tencent/mm/modelstat/n:oXg	Ljava/lang/String;
    //   567: iconst_0
    //   568: invokestatic 262	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   571: astore_0
    //   572: new 264	java/io/ObjectOutputStream
    //   575: dup
    //   576: aload_0
    //   577: invokespecial 267	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   580: astore 4
    //   582: aload 4
    //   584: astore 6
    //   586: aload_0
    //   587: astore 5
    //   589: aload 4
    //   591: getstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   594: invokevirtual 271	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   597: aload 4
    //   599: astore 6
    //   601: aload_0
    //   602: astore 5
    //   604: aload_0
    //   605: invokevirtual 276	java/io/OutputStream:flush	()V
    //   608: aload 4
    //   610: astore 6
    //   612: aload_0
    //   613: astore 5
    //   615: ldc 121
    //   617: ldc_w 278
    //   620: iconst_1
    //   621: anewarray 4	java/lang/Object
    //   624: dup
    //   625: iconst_0
    //   626: getstatic 60	com/tencent/mm/modelstat/n:oXf	Ljava/util/HashMap;
    //   629: invokevirtual 158	java/util/HashMap:size	()I
    //   632: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   635: aastore
    //   636: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   639: aload 4
    //   641: invokevirtual 279	java/io/ObjectOutputStream:close	()V
    //   644: aload_0
    //   645: ifnull +7 -> 652
    //   648: aload_0
    //   649: invokevirtual 280	java/io/OutputStream:close	()V
    //   652: ldc 113
    //   654: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   657: iload_1
    //   658: ireturn
    //   659: astore_0
    //   660: ldc 121
    //   662: ldc_w 282
    //   665: iconst_1
    //   666: anewarray 4	java/lang/Object
    //   669: dup
    //   670: iconst_0
    //   671: aload_0
    //   672: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   675: aastore
    //   676: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   679: goto -27 -> 652
    //   682: astore 7
    //   684: aconst_null
    //   685: astore 4
    //   687: aconst_null
    //   688: astore_0
    //   689: aload 4
    //   691: astore 6
    //   693: aload_0
    //   694: astore 5
    //   696: ldc 121
    //   698: ldc_w 282
    //   701: iconst_1
    //   702: anewarray 4	java/lang/Object
    //   705: dup
    //   706: iconst_0
    //   707: aload 7
    //   709: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   712: aastore
    //   713: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   716: aload 4
    //   718: ifnull +8 -> 726
    //   721: aload 4
    //   723: invokevirtual 279	java/io/ObjectOutputStream:close	()V
    //   726: aload_0
    //   727: ifnull -75 -> 652
    //   730: aload_0
    //   731: invokevirtual 280	java/io/OutputStream:close	()V
    //   734: goto -82 -> 652
    //   737: astore_0
    //   738: ldc 121
    //   740: ldc_w 282
    //   743: iconst_1
    //   744: anewarray 4	java/lang/Object
    //   747: dup
    //   748: iconst_0
    //   749: aload_0
    //   750: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   753: aastore
    //   754: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   757: goto -105 -> 652
    //   760: astore 4
    //   762: aconst_null
    //   763: astore 6
    //   765: aconst_null
    //   766: astore_0
    //   767: aload 6
    //   769: ifnull +8 -> 777
    //   772: aload 6
    //   774: invokevirtual 279	java/io/ObjectOutputStream:close	()V
    //   777: aload_0
    //   778: ifnull +7 -> 785
    //   781: aload_0
    //   782: invokevirtual 280	java/io/OutputStream:close	()V
    //   785: ldc 113
    //   787: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   790: aload 4
    //   792: athrow
    //   793: astore_0
    //   794: ldc 121
    //   796: ldc_w 282
    //   799: iconst_1
    //   800: anewarray 4	java/lang/Object
    //   803: dup
    //   804: iconst_0
    //   805: aload_0
    //   806: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   809: aastore
    //   810: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   813: goto -28 -> 785
    //   816: astore 4
    //   818: aconst_null
    //   819: astore 6
    //   821: goto -54 -> 767
    //   824: astore 4
    //   826: aload 5
    //   828: astore_0
    //   829: goto -62 -> 767
    //   832: astore 7
    //   834: aconst_null
    //   835: astore 4
    //   837: goto -148 -> 689
    //   840: astore 7
    //   842: goto -153 -> 689
    //   845: astore_0
    //   846: aconst_null
    //   847: astore 7
    //   849: goto -359 -> 490
    //   852: astore_0
    //   853: aload 6
    //   855: astore 4
    //   857: goto -367 -> 490
    //   860: astore 8
    //   862: aconst_null
    //   863: astore 5
    //   865: goto -484 -> 381
    //   868: astore 8
    //   870: goto -489 -> 381
    //   873: goto -537 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	876	0	paramArrayList	java.util.ArrayList<String>
    //   245	413	1	bool	boolean
    //   281	31	2	l	long
    //   97	226	4	localObject1	Object
    //   339	13	4	localException1	Exception
    //   379	63	4	localObject2	Object
    //   449	13	4	localException2	Exception
    //   488	18	4	localObject3	Object
    //   517	13	4	localException3	Exception
    //   580	142	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   760	31	4	localObject4	Object
    //   816	1	4	localObject5	Object
    //   824	1	4	localObject6	Object
    //   835	21	4	localObject7	Object
    //   115	749	5	localObject8	Object
    //   123	731	6	localObject9	Object
    //   119	377	7	localObject10	Object
    //   682	26	7	localException4	Exception
    //   832	1	7	localException5	Exception
    //   840	1	7	localException6	Exception
    //   847	1	7	localObject11	Object
    //   373	27	8	localException7	Exception
    //   860	1	8	localException8	Exception
    //   868	1	8	localException9	Exception
    // Exception table:
    //   from	to	target	type
    //   167	172	339	java/lang/Exception
    //   177	182	339	java/lang/Exception
    //   71	91	373	java/lang/Exception
    //   91	99	373	java/lang/Exception
    //   431	436	449	java/lang/Exception
    //   441	446	449	java/lang/Exception
    //   71	91	483	finally
    //   91	99	483	finally
    //   495	500	517	java/lang/Exception
    //   505	510	517	java/lang/Exception
    //   639	644	659	java/lang/Exception
    //   648	652	659	java/lang/Exception
    //   564	572	682	java/lang/Exception
    //   721	726	737	java/lang/Exception
    //   730	734	737	java/lang/Exception
    //   564	572	760	finally
    //   772	777	793	java/lang/Exception
    //   781	785	793	java/lang/Exception
    //   572	582	816	finally
    //   589	597	824	finally
    //   604	608	824	finally
    //   615	639	824	finally
    //   696	716	824	finally
    //   572	582	832	java/lang/Exception
    //   589	597	840	java/lang/Exception
    //   604	608	840	java/lang/Exception
    //   615	639	840	java/lang/Exception
    //   99	117	845	finally
    //   125	136	852	finally
    //   144	167	852	finally
    //   389	408	852	finally
    //   416	426	852	finally
    //   99	117	860	java/lang/Exception
    //   125	136	868	java/lang/Exception
    //   144	167	868	java/lang/Exception
  }
  
  private static String Ps(String paramString)
  {
    AppMethodBeat.i(151119);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(151119);
      return "";
    }
    char[] arrayOfChar = paramString.toCharArray();
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfChar[i];
      if (((k < 97) || (k > 122)) && ((k < 65) || (k > 90)) && ((k < 48) || (k > 57)) && (k != 124) && (k != 45) && (k != 32) && (k != 58))
      {
        AppMethodBeat.o(151119);
        return "";
      }
      i += 1;
    }
    AppMethodBeat.o(151119);
    return paramString;
  }
  
  public static void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(151122);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new emj();
    ((c.a)localObject).otF = new emk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((c.a)localObject).funcId = 716;
    localObject = ((c.a)localObject).bEF();
    emj localemj = (emj)c.b.b(((c)localObject).otB);
    localemj.mut = d.Yxb;
    localemj.muu = d.Yxa;
    localemj.muv = d.Yxd;
    localemj.muw = d.Yxe;
    localemj.mux = LocaleUtil.getApplicationLanguage();
    localemj.aaLf = paramInt;
    localemj.OzQ = paramString;
    Log.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    z.a((c)localObject, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(151112);
        Log.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Long.valueOf(Util.milliSecondsToNow(this.oXp)), this.oXq.OzQ });
        AppMethodBeat.o(151112);
        return 0;
      }
    });
    AppMethodBeat.o(151122);
  }
  
  /* Error */
  public static void a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 395
    //   6: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iload_0
    //   10: sipush 2000
    //   13: if_icmplt +15 -> 28
    //   16: fload_1
    //   17: fconst_0
    //   18: fcmpl
    //   19: ifeq +9 -> 28
    //   22: fload_2
    //   23: fconst_0
    //   24: fcmpl
    //   25: ifne +53 -> 78
    //   28: ldc 121
    //   30: ldc_w 397
    //   33: iconst_4
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: iload_0
    //   40: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: fload_1
    //   47: invokestatic 402	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   50: aastore
    //   51: dup
    //   52: iconst_2
    //   53: fload_2
    //   54: invokestatic 402	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   57: aastore
    //   58: dup
    //   59: iconst_3
    //   60: iload_3
    //   61: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   64: aastore
    //   65: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: ldc_w 395
    //   71: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: ldc 2
    //   76: monitorexit
    //   77: return
    //   78: getstatic 104	com/tencent/mm/modelstat/n:oXo	J
    //   81: invokestatic 231	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   84: ldc2_w 403
    //   87: lcmp
    //   88: ifge +60 -> 148
    //   91: ldc 121
    //   93: ldc_w 406
    //   96: iconst_4
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: iload_0
    //   103: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: fload_1
    //   110: invokestatic 402	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: fload_2
    //   117: invokestatic 402	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: iload_3
    //   124: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aastore
    //   128: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: ldc_w 395
    //   134: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: goto -63 -> 74
    //   140: astore 4
    //   142: ldc 2
    //   144: monitorexit
    //   145: aload 4
    //   147: athrow
    //   148: ldc 121
    //   150: ldc_w 408
    //   153: iconst_5
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: iload_0
    //   160: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: fload_1
    //   167: invokestatic 402	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   170: aastore
    //   171: dup
    //   172: iconst_2
    //   173: fload_2
    //   174: invokestatic 402	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   177: aastore
    //   178: dup
    //   179: iconst_3
    //   180: iload_3
    //   181: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: dup
    //   186: iconst_4
    //   187: getstatic 104	com/tencent/mm/modelstat/n:oXo	J
    //   190: invokestatic 231	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   193: invokestatic 238	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   196: aastore
    //   197: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   203: putstatic 104	com/tencent/mm/modelstat/n:oXo	J
    //   206: iload_0
    //   207: putstatic 102	com/tencent/mm/modelstat/n:hOt	I
    //   210: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   213: putstatic 94	com/tencent/mm/modelstat/n:hOu	J
    //   216: iload_3
    //   217: putstatic 100	com/tencent/mm/modelstat/n:hOv	I
    //   220: fload_2
    //   221: putstatic 96	com/tencent/mm/modelstat/n:oXm	F
    //   224: fload_1
    //   225: putstatic 98	com/tencent/mm/modelstat/n:oXn	F
    //   228: new 410	com/tencent/mm/autogen/a/mh
    //   231: dup
    //   232: invokespecial 411	com/tencent/mm/autogen/a/mh:<init>	()V
    //   235: astore 4
    //   237: aload 4
    //   239: getfield 415	com/tencent/mm/autogen/a/mh:hOs	Lcom/tencent/mm/autogen/a/mh$a;
    //   242: iload_0
    //   243: putfield 418	com/tencent/mm/autogen/a/mh$a:hOt	I
    //   246: aload 4
    //   248: getfield 415	com/tencent/mm/autogen/a/mh:hOs	Lcom/tencent/mm/autogen/a/mh$a;
    //   251: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   254: putfield 419	com/tencent/mm/autogen/a/mh$a:hOu	J
    //   257: aload 4
    //   259: getfield 415	com/tencent/mm/autogen/a/mh:hOs	Lcom/tencent/mm/autogen/a/mh$a;
    //   262: iload_3
    //   263: putfield 420	com/tencent/mm/autogen/a/mh$a:hOv	I
    //   266: aload 4
    //   268: getfield 415	com/tencent/mm/autogen/a/mh:hOs	Lcom/tencent/mm/autogen/a/mh$a;
    //   271: fload_1
    //   272: putfield 423	com/tencent/mm/autogen/a/mh$a:longitude	F
    //   275: aload 4
    //   277: getfield 415	com/tencent/mm/autogen/a/mh:hOs	Lcom/tencent/mm/autogen/a/mh$a;
    //   280: fload_2
    //   281: putfield 426	com/tencent/mm/autogen/a/mh$a:latitude	F
    //   284: aload 4
    //   286: invokevirtual 429	com/tencent/mm/autogen/a/mh:publish	()Z
    //   289: pop
    //   290: invokestatic 435	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   293: ldc_w 437
    //   296: invokevirtual 443	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   299: ifeq +31 -> 330
    //   302: ldc 121
    //   304: ldc_w 445
    //   307: iconst_1
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: iload_0
    //   314: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: ldc_w 395
    //   324: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: goto -253 -> 74
    //   330: getstatic 453	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   333: invokevirtual 458	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:startScanWiFi	()V
    //   336: invokestatic 78	com/tencent/mm/kernel/h:baH	()Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;
    //   339: new 12	com/tencent/mm/modelstat/n$5
    //   342: dup
    //   343: invokespecial 459	com/tencent/mm/modelstat/n$5:<init>	()V
    //   346: ldc2_w 460
    //   349: invokevirtual 465	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToWorkerDelayed	(Ljava/lang/Runnable;J)I
    //   352: pop
    //   353: ldc_w 395
    //   356: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: goto -285 -> 74
    //   362: astore 4
    //   364: ldc 121
    //   366: ldc_w 467
    //   369: iconst_1
    //   370: anewarray 4	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: aload 4
    //   377: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   380: aastore
    //   381: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: ldc_w 395
    //   387: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: goto -316 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	paramInt1	int
    //   0	393	1	paramFloat1	float
    //   0	393	2	paramFloat2	float
    //   0	393	3	paramInt2	int
    //   140	6	4	localObject	Object
    //   235	50	4	localmh	com.tencent.mm.autogen.a.mh
    //   362	14	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	9	140	finally
    //   28	74	140	finally
    //   78	137	140	finally
    //   148	327	140	finally
    //   330	353	140	finally
    //   353	359	140	finally
    //   364	390	140	finally
    //   330	353	362	java/lang/Exception
  }
  
  private static void a(int paramInt1, final float paramFloat1, final float paramFloat2, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(151121);
    long l1 = Util.nowMilliSecond();
    if ((oXl > 0L) && (l1 - oXl > 5000L))
    {
      Log.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", new Object[] { Long.valueOf(oXl), Long.valueOf(l1 - oXl) });
      AppMethodBeat.o(151121);
      return;
    }
    final String[] arrayOfString = wV(paramInt1);
    if ((arrayOfString == null) || (arrayOfString.length != 4) || (Util.isNullOrNil(arrayOfString[0])))
    {
      Log.e("MicroMsg.NetTypeReporter", "report get failed val");
      AppMethodBeat.o(151121);
      return;
    }
    Log.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(Util.milliSecondsToNow(l1)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2), Long.valueOf(paramLong), arrayOfString[0] });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new emj();
    ((c.a)localObject).otF = new emk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/rtkvreport";
    ((c.a)localObject).funcId = 716;
    c localc = ((c.a)localObject).bEF();
    emj localemj = (emj)c.b.b(localc.otB);
    localemj.mut = d.Yxb;
    localemj.muu = d.Yxa;
    localemj.muv = d.Yxd;
    localemj.muw = d.Yxe;
    localemj.mux = LocaleUtil.getApplicationLanguage();
    localemj.aaLf = 11747;
    long l2 = Util.milliSecondsToNow(oXl);
    if (l2 <= 600000L)
    {
      l1 = l2;
      if (l2 >= 0L) {}
    }
    else
    {
      l1 = 0L;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(arrayOfString[0]).append("0,").append(paramFloat1).append(",").append(paramFloat2).append(",").append(paramInt2).append(",").append(paramLong).append(",");
    if (CrashReportFactory.foreground) {}
    for (localObject = "1";; localObject = String.valueOf(l1))
    {
      localemj.OzQ = ((String)localObject + "," + arrayOfString[1] + "," + arrayOfString[2] + "," + arrayOfString[3]);
      z.a(localc, new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(151111);
          Log.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Long.valueOf(Util.milliSecondsToNow(this.oXp)), arrayOfString.OzQ });
          long l1;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            long l2 = Util.milliSecondsToNow(n.oXl);
            if (l2 <= 600000L)
            {
              l1 = l2;
              if (l2 >= 0L) {}
            }
            else
            {
              l1 = 0L;
            }
            paramAnonymousc = com.tencent.mm.plugin.report.service.h.OAn;
            paramAnonymousp = new StringBuilder().append(paramFloat1[0]).append("1,").append(paramFloat2).append(",").append(paramInt2).append(",").append(paramLong).append(",").append(this.oXv).append(",");
            if (!CrashReportFactory.foreground) {
              break label265;
            }
          }
          label265:
          for (paramAnonymousString = "1";; paramAnonymousString = String.valueOf(l1))
          {
            paramAnonymousc.kvStat(11747, paramAnonymousString + "," + paramFloat1[1] + "," + paramFloat1[2] + "," + paramFloat1[3]);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acIO, Long.valueOf(Util.nowMilliSecond()));
            AppMethodBeat.o(151111);
            return 0;
          }
        }
      }, true);
      AppMethodBeat.o(151121);
      return;
    }
  }
  
  private static void b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(151123);
    try
    {
      Log.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(Util.milliSecondsToNow(oXj)), Long.valueOf(oXj) });
      if ((paramInt1 > 2000) || (Util.milliSecondsToNow(oXj) > 300000L))
      {
        Log.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(Util.milliSecondsToNow(oXj)), Long.valueOf(oXj) });
        oXk = paramInt1;
        oXj = 9223372036854775807L;
        a(paramInt1, paramFloat1, paramFloat2, paramInt2, paramLong);
        AppMethodBeat.o(151123);
        return;
      }
      if (oXj == 9223372036854775807L) {
        oXj = Util.nowMilliSecond() + 60000L;
      }
      oXk = paramInt1;
      timer.startTimer(60000L);
      AppMethodBeat.o(151123);
      return;
    }
    finally
    {
      Log.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", new Object[] { Util.stackTraceToString(localThrowable) });
      AppMethodBeat.o(151123);
    }
  }
  
  private static long bNf()
  {
    AppMethodBeat.i(151120);
    synchronized (lock)
    {
      try
      {
        long l = Util.nullAs((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIN, null), 1L);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acIN, Long.valueOf(1L + l));
        com.tencent.mm.kernel.h.baE().ban().iZy();
        Log.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", new Object[] { Long.valueOf(l), Long.valueOf(Util.nullAs((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIN, null), 1L)) });
        AppMethodBeat.o(151120);
        return l;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.NetTypeReporter", "incSeq :%s", new Object[] { Util.stackTraceToString(localException) });
        AppMethodBeat.o(151120);
        return -1L;
      }
    }
  }
  
  public static void bNg()
  {
    for (;;)
    {
      long l;
      int i;
      float f1;
      float f2;
      int j;
      try
      {
        AppMethodBeat.i(242936);
        Log.i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d", new Object[] { Integer.valueOf(1005), Boolean.valueOf(CrashReportFactory.foreground), Long.valueOf(hOu) });
      }
      finally {}
      try
      {
        if (hOu <= 0L) {
          continue;
        }
        Log.d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", new Object[] { Integer.valueOf(1005), Integer.valueOf(hOt), Float.valueOf(oXn), Float.valueOf(oXm), Integer.valueOf(hOv), Long.valueOf(hOu) });
        l = Util.milliSecondsToNow(hOu);
        i = hOt;
        f1 = oXm;
        f2 = oXn;
        j = hOv;
        hOu = 0L;
        oXm = 0.0F;
        oXn = 0.0F;
        hOv = 0;
        hOt = 0;
        b(i, f2, f1, j, l);
        AppMethodBeat.o(242936);
      }
      finally
      {
        Log.e("MicroMsg.NetTypeReporter", "run :%s", new Object[] { Util.stackTraceToString(localThrowable) });
        AppMethodBeat.o(242936);
        continue;
      }
      return;
      if (!CrashReportFactory.foreground)
      {
        Log.w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", new Object[] { Integer.valueOf(1005) });
        AppMethodBeat.o(242936);
      }
      else
      {
        b(1005, 0.0F, 0.0F, 0, 0L);
        AppMethodBeat.o(242936);
      }
    }
  }
  
  public static void dX(Context paramContext)
  {
    AppMethodBeat.i(151116);
    if (paramContext == null) {}
    try
    {
      Log.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
      AppMethodBeat.o(151116);
      return;
    }
    finally
    {
      n.a locala;
      IntentFilter localIntentFilter;
      Log.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", new Object[] { Util.stackTraceToString(paramContext) });
      AppMethodBeat.o(151116);
    }
    locala = new n.a((byte)0);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(locala, localIntentFilter);
    Log.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
    AppMethodBeat.o(151116);
    return;
  }
  
  public static void hn(boolean paramBoolean)
  {
    AppMethodBeat.i(151124);
    if (paramBoolean)
    {
      oXl = 0L;
      AppMethodBeat.o(151124);
      return;
    }
    if (timer.stopped())
    {
      AppMethodBeat.o(151124);
      return;
    }
    Log.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
    oXl = Util.nowMilliSecond();
    timer.startTimer(0L);
    AppMethodBeat.o(151124);
  }
  
  /* Error */
  private static String[] wV(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 618
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 121
    //   8: ldc_w 620
    //   11: iconst_4
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_0
    //   18: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: getstatic 502	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   27: invokestatic 573	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: getstatic 92	com/tencent/mm/modelstat/n:oXl	J
    //   36: invokestatic 238	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   39: aastore
    //   40: dup
    //   41: iconst_3
    //   42: getstatic 92	com/tencent/mm/modelstat/n:oXl	J
    //   45: invokestatic 231	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   48: invokestatic 238	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: aastore
    //   52: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: iload_0
    //   56: ifgt +30 -> 86
    //   59: ldc 121
    //   61: ldc_w 622
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_0
    //   71: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: ldc_w 618
    //   81: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aconst_null
    //   85: areturn
    //   86: invokestatic 435	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   89: astore 11
    //   91: aload 11
    //   93: ifnonnull +30 -> 123
    //   96: ldc 121
    //   98: ldc_w 624
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: iload_0
    //   108: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: ldc_w 618
    //   118: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aconst_null
    //   122: areturn
    //   123: ldc 121
    //   125: ldc_w 626
    //   128: iconst_2
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: iload_0
    //   135: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: getstatic 502	com/tencent/mm/sdk/crash/CrashReportFactory:foreground	Z
    //   144: invokestatic 573	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   147: aastore
    //   148: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: invokestatic 631	com/tencent/mm/compatible/deviceinfo/ac:aPK	()I
    //   154: istore_2
    //   155: ldc 121
    //   157: ldc_w 633
    //   160: iconst_1
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: iload_2
    //   167: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: ldc_w 295
    //   177: astore 7
    //   179: ldc_w 295
    //   182: astore 15
    //   184: aload 7
    //   186: astore 6
    //   188: new 635	java/lang/StringBuffer
    //   191: dup
    //   192: invokespecial 636	java/lang/StringBuffer:<init>	()V
    //   195: astore 10
    //   197: aload 7
    //   199: astore 6
    //   201: new 635	java/lang/StringBuffer
    //   204: dup
    //   205: invokespecial 636	java/lang/StringBuffer:<init>	()V
    //   208: astore 8
    //   210: aload 7
    //   212: astore 6
    //   214: new 635	java/lang/StringBuffer
    //   217: dup
    //   218: invokespecial 636	java/lang/StringBuffer:<init>	()V
    //   221: astore 9
    //   223: iconst_0
    //   224: istore_1
    //   225: aload 7
    //   227: astore 6
    //   229: new 115	java/util/ArrayList
    //   232: dup
    //   233: invokespecial 637	java/util/ArrayList:<init>	()V
    //   236: astore 12
    //   238: aload 7
    //   240: astore 6
    //   242: aload 10
    //   244: getstatic 453	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   247: invokevirtual 640	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getFormattedWiFiSsid	()Ljava/lang/String;
    //   250: invokevirtual 643	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   253: pop
    //   254: aload 7
    //   256: astore 6
    //   258: aload 8
    //   260: getstatic 453	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   263: invokevirtual 646	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getFormattedWiFiBssid	()Ljava/lang/String;
    //   266: invokevirtual 643	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   269: pop
    //   270: aload 7
    //   272: astore 6
    //   274: getstatic 453	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   277: invokevirtual 646	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getFormattedWiFiBssid	()Ljava/lang/String;
    //   280: astore 13
    //   282: aload 7
    //   284: astore 6
    //   286: aload 12
    //   288: aload 13
    //   290: invokevirtual 650	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   293: pop
    //   294: aload 7
    //   296: astore 6
    //   298: invokestatic 655	java/lang/System:currentTimeMillis	()J
    //   301: getstatic 657	com/tencent/mm/modelstat/n:oXh	J
    //   304: lsub
    //   305: ldc2_w 482
    //   308: lcmp
    //   309: ifle +26 -> 335
    //   312: aload 7
    //   314: astore 6
    //   316: getstatic 453	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
    //   319: invokevirtual 661	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getWiFiScanResults	()Ljava/util/List;
    //   322: putstatic 663	com/tencent/mm/modelstat/n:oXi	Ljava/util/List;
    //   325: aload 7
    //   327: astore 6
    //   329: invokestatic 655	java/lang/System:currentTimeMillis	()J
    //   332: putstatic 657	com/tencent/mm/modelstat/n:oXh	J
    //   335: aload 7
    //   337: astore 6
    //   339: getstatic 663	com/tencent/mm/modelstat/n:oXi	Ljava/util/List;
    //   342: ifnull +298 -> 640
    //   345: aload 7
    //   347: astore 6
    //   349: getstatic 663	com/tencent/mm/modelstat/n:oXi	Ljava/util/List;
    //   352: new 665	com/tencent/mm/modelstat/n$1
    //   355: dup
    //   356: invokespecial 666	com/tencent/mm/modelstat/n$1:<init>	()V
    //   359: invokestatic 672	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   362: bipush 20
    //   364: istore_3
    //   365: aload 7
    //   367: astore 6
    //   369: getstatic 663	com/tencent/mm/modelstat/n:oXi	Ljava/util/List;
    //   372: invokeinterface 675 1 0
    //   377: astore 14
    //   379: iconst_0
    //   380: istore_1
    //   381: aload 7
    //   383: astore 6
    //   385: aload 14
    //   387: invokeinterface 214 1 0
    //   392: ifeq +1528 -> 1920
    //   395: aload 7
    //   397: astore 6
    //   399: aload 14
    //   401: invokeinterface 217 1 0
    //   406: checkcast 677	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult
    //   409: astore 16
    //   411: aload 16
    //   413: ifnull -32 -> 381
    //   416: aload 7
    //   418: astore 6
    //   420: aload 16
    //   422: invokevirtual 680	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getBssid	()Ljava/lang/String;
    //   425: invokestatic 135	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   428: ifne -47 -> 381
    //   431: aload 7
    //   433: astore 6
    //   435: aload 16
    //   437: invokevirtual 680	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getBssid	()Ljava/lang/String;
    //   440: aload 13
    //   442: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   445: ifeq +43 -> 488
    //   448: aload 7
    //   450: astore 6
    //   452: aload 16
    //   454: invokevirtual 686	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getLevel	()I
    //   457: istore_1
    //   458: goto -77 -> 381
    //   461: astore 6
    //   463: ldc 121
    //   465: ldc_w 688
    //   468: iconst_1
    //   469: anewarray 4	java/lang/Object
    //   472: dup
    //   473: iconst_0
    //   474: aload 6
    //   476: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   479: aastore
    //   480: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   483: iconst_0
    //   484: istore_2
    //   485: goto -330 -> 155
    //   488: iload_3
    //   489: ifle +1431 -> 1920
    //   492: aload 7
    //   494: astore 6
    //   496: aload 10
    //   498: ldc_w 690
    //   501: invokevirtual 643	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   504: pop
    //   505: aload 7
    //   507: astore 6
    //   509: aload 10
    //   511: aload 16
    //   513: invokevirtual 693	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getSsid	()Ljava/lang/String;
    //   516: invokestatic 696	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   519: ldc_w 690
    //   522: ldc_w 295
    //   525: invokevirtual 700	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   528: ldc_w 702
    //   531: ldc_w 295
    //   534: invokevirtual 700	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   537: invokevirtual 643	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   540: pop
    //   541: aload 7
    //   543: astore 6
    //   545: aload 8
    //   547: ldc_w 690
    //   550: invokevirtual 643	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   553: pop
    //   554: aload 7
    //   556: astore 6
    //   558: aload 8
    //   560: aload 16
    //   562: invokevirtual 680	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getBssid	()Ljava/lang/String;
    //   565: invokestatic 696	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   568: ldc_w 690
    //   571: ldc_w 295
    //   574: invokevirtual 700	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   577: ldc_w 702
    //   580: ldc_w 295
    //   583: invokevirtual 700	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   586: invokevirtual 643	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   589: pop
    //   590: aload 7
    //   592: astore 6
    //   594: aload 12
    //   596: aload 16
    //   598: invokevirtual 680	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getBssid	()Ljava/lang/String;
    //   601: invokevirtual 650	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   604: pop
    //   605: aload 7
    //   607: astore 6
    //   609: aload 9
    //   611: ldc_w 690
    //   614: invokevirtual 643	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   617: pop
    //   618: aload 7
    //   620: astore 6
    //   622: aload 9
    //   624: aload 16
    //   626: invokevirtual 686	com/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult:getLevel	()I
    //   629: invokevirtual 705	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   632: pop
    //   633: iload_3
    //   634: iconst_1
    //   635: isub
    //   636: istore_3
    //   637: goto -256 -> 381
    //   640: iload_0
    //   641: sipush 2000
    //   644: if_icmpge +46 -> 690
    //   647: aload 7
    //   649: astore 6
    //   651: aload 12
    //   653: invokestatic 707	com/tencent/mm/modelstat/n:A	(Ljava/util/ArrayList;)Z
    //   656: ifne +34 -> 690
    //   659: aload 7
    //   661: astore 6
    //   663: ldc 121
    //   665: ldc_w 709
    //   668: iconst_1
    //   669: anewarray 4	java/lang/Object
    //   672: dup
    //   673: iconst_0
    //   674: iload_0
    //   675: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   678: aastore
    //   679: invokestatic 447	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   682: ldc_w 618
    //   685: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: aconst_null
    //   689: areturn
    //   690: aload 7
    //   692: astore 6
    //   694: aload 10
    //   696: invokevirtual 710	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   699: astore 7
    //   701: aload 7
    //   703: astore 6
    //   705: aload 8
    //   707: invokevirtual 710	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   710: astore 8
    //   712: aload 8
    //   714: astore 6
    //   716: new 137	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   723: iload_1
    //   724: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   727: aload 9
    //   729: invokevirtual 710	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   732: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: astore 8
    //   740: aload 8
    //   742: astore 15
    //   744: aload 7
    //   746: astore 17
    //   748: aload 6
    //   750: astore 16
    //   752: ldc 121
    //   754: ldc_w 712
    //   757: iconst_2
    //   758: anewarray 4	java/lang/Object
    //   761: dup
    //   762: iconst_0
    //   763: aload 16
    //   765: aastore
    //   766: dup
    //   767: iconst_1
    //   768: aload 17
    //   770: aastore
    //   771: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   774: ldc_w 295
    //   777: astore 18
    //   779: aload 11
    //   781: ldc_w 714
    //   784: invokevirtual 718	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   787: checkcast 720	android/telephony/TelephonyManager
    //   790: astore 6
    //   792: aload 6
    //   794: ifnull +1118 -> 1912
    //   797: aload 6
    //   799: invokevirtual 723	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   802: astore 6
    //   804: aload 6
    //   806: astore 18
    //   808: ldc 121
    //   810: ldc_w 725
    //   813: iconst_1
    //   814: anewarray 4	java/lang/Object
    //   817: dup
    //   818: iconst_0
    //   819: aload 18
    //   821: aastore
    //   822: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   825: ldc_w 295
    //   828: astore 10
    //   830: ldc_w 295
    //   833: astore 8
    //   835: ldc_w 295
    //   838: astore 9
    //   840: ldc_w 295
    //   843: astore 7
    //   845: ldc_w 295
    //   848: astore 6
    //   850: aload 11
    //   852: invokestatic 731	com/tencent/mm/sdk/platformtools/NetStatusUtil:getCellInfoList	(Landroid/content/Context;)Ljava/util/List;
    //   855: astore 19
    //   857: iconst_0
    //   858: istore_1
    //   859: ldc_w 295
    //   862: astore 11
    //   864: aload 8
    //   866: astore 9
    //   868: aload 11
    //   870: astore 8
    //   872: aload 9
    //   874: astore 14
    //   876: aload 10
    //   878: astore 13
    //   880: iload_1
    //   881: aload 19
    //   883: invokeinterface 732 1 0
    //   888: if_icmpge +587 -> 1475
    //   891: aload 9
    //   893: astore 14
    //   895: aload 10
    //   897: astore 13
    //   899: aload 19
    //   901: iload_1
    //   902: invokeinterface 735 2 0
    //   907: checkcast 737	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo
    //   910: astore 20
    //   912: aload 9
    //   914: astore 14
    //   916: aload 10
    //   918: astore 13
    //   920: aload 20
    //   922: getfield 740	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:mcc	Ljava/lang/String;
    //   925: ldc_w 295
    //   928: invokestatic 743	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   931: astore 11
    //   933: aload 9
    //   935: astore 14
    //   937: aload 11
    //   939: astore 13
    //   941: aload 20
    //   943: getfield 746	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:mnc	Ljava/lang/String;
    //   946: ldc_w 295
    //   949: invokestatic 743	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   952: astore 12
    //   954: aload 12
    //   956: astore 14
    //   958: aload 11
    //   960: astore 13
    //   962: aload 8
    //   964: invokevirtual 749	java/lang/String:length	()I
    //   967: ifle +938 -> 1905
    //   970: aload 12
    //   972: astore 14
    //   974: aload 11
    //   976: astore 13
    //   978: aload 20
    //   980: getfield 752	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:cellid	Ljava/lang/String;
    //   983: invokestatic 135	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   986: ifne +919 -> 1905
    //   989: aload 12
    //   991: astore 14
    //   993: aload 11
    //   995: astore 13
    //   997: new 137	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   1004: aload 8
    //   1006: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: ldc_w 690
    //   1012: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: astore 10
    //   1020: aload 10
    //   1022: astore 9
    //   1024: aload 6
    //   1026: astore 13
    //   1028: aload 7
    //   1030: astore 8
    //   1032: aload 10
    //   1034: astore 14
    //   1036: aload 20
    //   1038: getfield 752	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:cellid	Ljava/lang/String;
    //   1041: invokestatic 135	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1044: ifne +40 -> 1084
    //   1047: aload 6
    //   1049: astore 13
    //   1051: aload 7
    //   1053: astore 8
    //   1055: aload 10
    //   1057: astore 14
    //   1059: new 137	java/lang/StringBuilder
    //   1062: dup
    //   1063: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   1066: aload 10
    //   1068: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: aload 20
    //   1073: getfield 752	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:cellid	Ljava/lang/String;
    //   1076: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1082: astore 9
    //   1084: aload 7
    //   1086: astore 10
    //   1088: aload 6
    //   1090: astore 13
    //   1092: aload 7
    //   1094: astore 8
    //   1096: aload 9
    //   1098: astore 14
    //   1100: aload 7
    //   1102: invokevirtual 749	java/lang/String:length	()I
    //   1105: ifle +65 -> 1170
    //   1108: aload 7
    //   1110: astore 10
    //   1112: aload 6
    //   1114: astore 13
    //   1116: aload 7
    //   1118: astore 8
    //   1120: aload 9
    //   1122: astore 14
    //   1124: aload 20
    //   1126: getfield 755	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:lac	Ljava/lang/String;
    //   1129: invokestatic 135	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1132: ifne +38 -> 1170
    //   1135: aload 6
    //   1137: astore 13
    //   1139: aload 7
    //   1141: astore 8
    //   1143: aload 9
    //   1145: astore 14
    //   1147: new 137	java/lang/StringBuilder
    //   1150: dup
    //   1151: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   1154: aload 7
    //   1156: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: ldc_w 690
    //   1162: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1168: astore 10
    //   1170: aload 10
    //   1172: astore 7
    //   1174: aload 6
    //   1176: astore 13
    //   1178: aload 10
    //   1180: astore 8
    //   1182: aload 9
    //   1184: astore 14
    //   1186: aload 20
    //   1188: getfield 755	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:lac	Ljava/lang/String;
    //   1191: invokestatic 135	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1194: ifne +40 -> 1234
    //   1197: aload 6
    //   1199: astore 13
    //   1201: aload 10
    //   1203: astore 8
    //   1205: aload 9
    //   1207: astore 14
    //   1209: new 137	java/lang/StringBuilder
    //   1212: dup
    //   1213: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   1216: aload 10
    //   1218: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: aload 20
    //   1223: getfield 755	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:lac	Ljava/lang/String;
    //   1226: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1232: astore 7
    //   1234: aload 6
    //   1236: astore 10
    //   1238: aload 6
    //   1240: astore 13
    //   1242: aload 7
    //   1244: astore 8
    //   1246: aload 9
    //   1248: astore 14
    //   1250: aload 6
    //   1252: invokevirtual 749	java/lang/String:length	()I
    //   1255: ifle +38 -> 1293
    //   1258: aload 6
    //   1260: astore 13
    //   1262: aload 7
    //   1264: astore 8
    //   1266: aload 9
    //   1268: astore 14
    //   1270: new 137	java/lang/StringBuilder
    //   1273: dup
    //   1274: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   1277: aload 6
    //   1279: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: ldc_w 690
    //   1285: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1291: astore 10
    //   1293: aload 10
    //   1295: astore 13
    //   1297: aload 7
    //   1299: astore 8
    //   1301: aload 9
    //   1303: astore 14
    //   1305: new 137	java/lang/StringBuilder
    //   1308: dup
    //   1309: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   1312: aload 10
    //   1314: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: astore 21
    //   1319: aload 10
    //   1321: astore 13
    //   1323: aload 7
    //   1325: astore 8
    //   1327: aload 9
    //   1329: astore 14
    //   1331: aload 20
    //   1333: getfield 758	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:dbm	Ljava/lang/String;
    //   1336: invokestatic 135	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1339: ifeq +114 -> 1453
    //   1342: ldc_w 760
    //   1345: astore 6
    //   1347: aload 10
    //   1349: astore 13
    //   1351: aload 7
    //   1353: astore 8
    //   1355: aload 9
    //   1357: astore 14
    //   1359: aload 21
    //   1361: aload 6
    //   1363: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: astore 6
    //   1371: iload_1
    //   1372: iconst_1
    //   1373: iadd
    //   1374: istore_1
    //   1375: aload 9
    //   1377: astore 8
    //   1379: aload 12
    //   1381: astore 9
    //   1383: aload 11
    //   1385: astore 10
    //   1387: goto -515 -> 872
    //   1390: astore 7
    //   1392: ldc_w 295
    //   1395: astore 8
    //   1397: ldc 121
    //   1399: ldc_w 762
    //   1402: iconst_1
    //   1403: anewarray 4	java/lang/Object
    //   1406: dup
    //   1407: iconst_0
    //   1408: aload 7
    //   1410: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1413: aastore
    //   1414: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1417: aload 8
    //   1419: astore 16
    //   1421: aload 6
    //   1423: astore 17
    //   1425: goto -673 -> 752
    //   1428: astore 6
    //   1430: ldc 121
    //   1432: ldc_w 688
    //   1435: iconst_1
    //   1436: anewarray 4	java/lang/Object
    //   1439: dup
    //   1440: iconst_0
    //   1441: aload 6
    //   1443: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1446: aastore
    //   1447: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1450: goto -642 -> 808
    //   1453: aload 10
    //   1455: astore 13
    //   1457: aload 7
    //   1459: astore 8
    //   1461: aload 9
    //   1463: astore 14
    //   1465: aload 20
    //   1467: getfield 758	com/tencent/mm/sdk/platformtools/NetStatusUtil$CellInfo:dbm	Ljava/lang/String;
    //   1470: astore 6
    //   1472: goto -125 -> 1347
    //   1475: aload 8
    //   1477: astore 11
    //   1479: aload 9
    //   1481: astore 8
    //   1483: aload 11
    //   1485: astore 9
    //   1487: ldc 121
    //   1489: ldc_w 764
    //   1492: iconst_3
    //   1493: anewarray 4	java/lang/Object
    //   1496: dup
    //   1497: iconst_0
    //   1498: aload 10
    //   1500: aastore
    //   1501: dup
    //   1502: iconst_1
    //   1503: aload 8
    //   1505: aastore
    //   1506: dup
    //   1507: iconst_2
    //   1508: aload 9
    //   1510: aastore
    //   1511: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1514: new 137	java/lang/StringBuilder
    //   1517: dup
    //   1518: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   1521: astore 11
    //   1523: aload 11
    //   1525: invokestatic 767	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   1528: invokevirtual 496	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1531: ldc_w 490
    //   1534: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: pop
    //   1538: aload 11
    //   1540: iload_0
    //   1541: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1544: ldc_w 490
    //   1547: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: pop
    //   1551: aload 11
    //   1553: iload_2
    //   1554: invokevirtual 493	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1557: ldc_w 490
    //   1560: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: pop
    //   1564: aload 11
    //   1566: aload 17
    //   1568: ldc_w 490
    //   1571: ldc_w 702
    //   1574: invokevirtual 700	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1577: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: ldc_w 490
    //   1583: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1586: pop
    //   1587: aload 11
    //   1589: aload 16
    //   1591: ldc_w 490
    //   1594: ldc_w 702
    //   1597: invokevirtual 700	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1600: invokestatic 769	com/tencent/mm/modelstat/n:Ps	(Ljava/lang/String;)Ljava/lang/String;
    //   1603: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: ldc_w 490
    //   1609: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: pop
    //   1613: aload 11
    //   1615: aload 18
    //   1617: ldc_w 490
    //   1620: ldc_w 702
    //   1623: invokevirtual 700	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1626: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: ldc_w 490
    //   1632: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: pop
    //   1636: aload 11
    //   1638: aload 10
    //   1640: ldc_w 490
    //   1643: ldc_w 702
    //   1646: invokevirtual 700	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1649: invokestatic 769	com/tencent/mm/modelstat/n:Ps	(Ljava/lang/String;)Ljava/lang/String;
    //   1652: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: ldc_w 490
    //   1658: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: pop
    //   1662: aload 11
    //   1664: aload 8
    //   1666: ldc_w 490
    //   1669: ldc_w 702
    //   1672: invokevirtual 700	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1675: invokestatic 769	com/tencent/mm/modelstat/n:Ps	(Ljava/lang/String;)Ljava/lang/String;
    //   1678: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1681: ldc_w 490
    //   1684: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: pop
    //   1688: aload 11
    //   1690: aload 9
    //   1692: ldc_w 490
    //   1695: ldc_w 702
    //   1698: invokevirtual 700	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1701: invokestatic 769	com/tencent/mm/modelstat/n:Ps	(Ljava/lang/String;)Ljava/lang/String;
    //   1704: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: ldc_w 490
    //   1710: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: pop
    //   1714: invokestatic 771	com/tencent/mm/modelstat/n:bNf	()J
    //   1717: lstore 4
    //   1719: lload 4
    //   1721: lconst_0
    //   1722: lcmp
    //   1723: ifge +36 -> 1759
    //   1726: ldc_w 618
    //   1729: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1732: aconst_null
    //   1733: areturn
    //   1734: astore 11
    //   1736: ldc 121
    //   1738: ldc_w 688
    //   1741: iconst_1
    //   1742: anewarray 4	java/lang/Object
    //   1745: dup
    //   1746: iconst_0
    //   1747: aload 11
    //   1749: invokestatic 255	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1752: aastore
    //   1753: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1756: goto -269 -> 1487
    //   1759: new 137	java/lang/StringBuilder
    //   1762: dup
    //   1763: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   1766: lload 4
    //   1768: invokevirtual 496	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1771: ldc_w 490
    //   1774: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: aload 11
    //   1779: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1782: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1785: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1788: astore 8
    //   1790: aload 15
    //   1792: invokestatic 769	com/tencent/mm/modelstat/n:Ps	(Ljava/lang/String;)Ljava/lang/String;
    //   1795: astore 9
    //   1797: aload 7
    //   1799: invokestatic 769	com/tencent/mm/modelstat/n:Ps	(Ljava/lang/String;)Ljava/lang/String;
    //   1802: astore 7
    //   1804: aload 6
    //   1806: invokestatic 769	com/tencent/mm/modelstat/n:Ps	(Ljava/lang/String;)Ljava/lang/String;
    //   1809: astore 6
    //   1811: ldc_w 618
    //   1814: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1817: iconst_4
    //   1818: anewarray 219	java/lang/String
    //   1821: dup
    //   1822: iconst_0
    //   1823: aload 8
    //   1825: aastore
    //   1826: dup
    //   1827: iconst_1
    //   1828: aload 9
    //   1830: aastore
    //   1831: dup
    //   1832: iconst_2
    //   1833: aload 7
    //   1835: aastore
    //   1836: dup
    //   1837: iconst_3
    //   1838: aload 6
    //   1840: aastore
    //   1841: areturn
    //   1842: astore 19
    //   1844: aload 14
    //   1846: astore 9
    //   1848: aload 13
    //   1850: astore 6
    //   1852: aload 8
    //   1854: astore 7
    //   1856: aload 12
    //   1858: astore 8
    //   1860: aload 11
    //   1862: astore 10
    //   1864: aload 19
    //   1866: astore 11
    //   1868: goto -132 -> 1736
    //   1871: astore 11
    //   1873: aload 8
    //   1875: astore 9
    //   1877: aload 14
    //   1879: astore 8
    //   1881: aload 13
    //   1883: astore 10
    //   1885: goto -149 -> 1736
    //   1888: astore 9
    //   1890: aload 6
    //   1892: astore 8
    //   1894: aload 7
    //   1896: astore 6
    //   1898: aload 9
    //   1900: astore 7
    //   1902: goto -505 -> 1397
    //   1905: aload 8
    //   1907: astore 10
    //   1909: goto -889 -> 1020
    //   1912: ldc_w 295
    //   1915: astore 6
    //   1917: goto -1113 -> 804
    //   1920: goto -1280 -> 640
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1923	0	paramInt	int
    //   224	1151	1	i	int
    //   154	1400	2	j	int
    //   364	273	3	k	int
    //   1717	50	4	l	long
    //   186	265	6	localObject1	Object
    //   461	14	6	localException1	Exception
    //   494	928	6	localObject2	Object
    //   1428	14	6	localException2	Exception
    //   1470	446	6	localObject3	Object
    //   177	1175	7	localObject4	Object
    //   1390	408	7	localException3	Exception
    //   1802	99	7	localObject5	Object
    //   208	1698	8	localObject6	Object
    //   221	1655	9	localObject7	Object
    //   1888	11	9	localException4	Exception
    //   195	1713	10	localObject8	Object
    //   89	1600	11	localObject9	Object
    //   1734	127	11	localException5	Exception
    //   1866	1	11	localObject10	Object
    //   1871	1	11	localException6	Exception
    //   236	1621	12	localObject11	Object
    //   280	1602	13	localObject12	Object
    //   377	1501	14	localObject13	Object
    //   182	1609	15	localObject14	Object
    //   409	1181	16	localObject15	Object
    //   746	821	17	localObject16	Object
    //   777	839	18	localObject17	Object
    //   855	45	19	localList	List
    //   1842	23	19	localException7	Exception
    //   910	556	20	localCellInfo	com.tencent.mm.sdk.platformtools.NetStatusUtil.CellInfo
    //   1317	43	21	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   151	155	461	java/lang/Exception
    //   188	197	1390	java/lang/Exception
    //   201	210	1390	java/lang/Exception
    //   214	223	1390	java/lang/Exception
    //   229	238	1390	java/lang/Exception
    //   242	254	1390	java/lang/Exception
    //   258	270	1390	java/lang/Exception
    //   274	282	1390	java/lang/Exception
    //   286	294	1390	java/lang/Exception
    //   298	312	1390	java/lang/Exception
    //   316	325	1390	java/lang/Exception
    //   329	335	1390	java/lang/Exception
    //   339	345	1390	java/lang/Exception
    //   349	362	1390	java/lang/Exception
    //   369	379	1390	java/lang/Exception
    //   385	395	1390	java/lang/Exception
    //   399	411	1390	java/lang/Exception
    //   420	431	1390	java/lang/Exception
    //   435	448	1390	java/lang/Exception
    //   452	458	1390	java/lang/Exception
    //   496	505	1390	java/lang/Exception
    //   509	541	1390	java/lang/Exception
    //   545	554	1390	java/lang/Exception
    //   558	590	1390	java/lang/Exception
    //   594	605	1390	java/lang/Exception
    //   609	618	1390	java/lang/Exception
    //   622	633	1390	java/lang/Exception
    //   651	659	1390	java/lang/Exception
    //   663	682	1390	java/lang/Exception
    //   694	701	1390	java/lang/Exception
    //   705	712	1390	java/lang/Exception
    //   779	792	1428	java/lang/Exception
    //   797	804	1428	java/lang/Exception
    //   850	857	1734	java/lang/Exception
    //   1036	1047	1842	java/lang/Exception
    //   1059	1084	1842	java/lang/Exception
    //   1100	1108	1842	java/lang/Exception
    //   1124	1135	1842	java/lang/Exception
    //   1147	1170	1842	java/lang/Exception
    //   1186	1197	1842	java/lang/Exception
    //   1209	1234	1842	java/lang/Exception
    //   1250	1258	1842	java/lang/Exception
    //   1270	1293	1842	java/lang/Exception
    //   1305	1319	1842	java/lang/Exception
    //   1331	1342	1842	java/lang/Exception
    //   1359	1371	1842	java/lang/Exception
    //   1465	1472	1842	java/lang/Exception
    //   880	891	1871	java/lang/Exception
    //   899	912	1871	java/lang/Exception
    //   920	933	1871	java/lang/Exception
    //   941	954	1871	java/lang/Exception
    //   962	970	1871	java/lang/Exception
    //   978	989	1871	java/lang/Exception
    //   997	1020	1871	java/lang/Exception
    //   716	740	1888	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelstat.n
 * JD-Core Version:    0.7.0.1
 */