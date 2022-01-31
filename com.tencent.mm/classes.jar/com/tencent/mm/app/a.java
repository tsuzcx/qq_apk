package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.p;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  private static String bNv;
  private static int bWO;
  private static int bWP;
  private static p bWQ;
  private static final a.b bWR;
  private static final a.d bWS;
  private static a.b bWT;
  private static a.d bWU;
  private static Handler bWV;
  private static int bWW;
  private static int bWX;
  private static String bWY;
  private static boolean bWZ;
  private static boolean bXa;
  private static Thread bXb;
  
  static
  {
    AppMethodBeat.i(15364);
    bWO = 0;
    bWP = 0;
    bWQ = new p(Process.myPid());
    bWR = new a.b()
    {
      public final void c(a.a paramAnonymousa)
      {
        AppMethodBeat.i(15348);
        int i = ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getInt("main_thread_watch_report", 0);
        if (i > 0) {}
        for (boolean bool = true;; bool = false)
        {
          ab.w("MicroMsg.ANRWatchDog.summeranr", "summeranr onAppNotResponding error reportFlag[%b]", new Object[] { Boolean.valueOf(bool) });
          try
          {
            String str = a.b(paramAnonymousa);
            if (i > 0)
            {
              paramAnonymousa = str;
              if (str != null)
              {
                paramAnonymousa = str;
                if (str.length() > 51200) {
                  paramAnonymousa = str.substring(0, 51200);
                }
              }
              b.G(Base64.encodeToString(paramAnonymousa.getBytes(), 2), "main_thread_watch");
              AppMethodBeat.o(15348);
              return;
            }
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(510L, 14L, 1L, true);
            AppMethodBeat.o(15348);
            return;
          }
          catch (OutOfMemoryError paramAnonymousa)
          {
            ab.e("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport OutOfMemory %s", new Object[] { paramAnonymousa.getMessage() });
            System.gc();
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(510L, 15L, 1L, true);
            AppMethodBeat.o(15348);
            return;
          }
        }
      }
    };
    bWS = new a.d()
    {
      public final void a(InterruptedException paramAnonymousInterruptedException)
      {
        AppMethodBeat.i(15349);
        ab.w("MicroMsg.ANRWatchDog.summeranr", "summeranr DEFAULT_INTERRUPTION_LISTENER onInterrupted exception.getMessage[%s]", new Object[] { paramAnonymousInterruptedException.getMessage() });
        AppMethodBeat.o(15349);
      }
    };
    bWT = bWR;
    bWU = bWS;
    bWW = 4500;
    bWX = 500;
    bWY = "";
    bWZ = true;
    bXa = false;
    bNv = "";
    AppMethodBeat.o(15364);
  }
  
  /* Error */
  private static String a(a.a parama)
  {
    // Byte code:
    //   0: sipush 15361
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 123	org/json/JSONObject
    //   9: dup
    //   10: invokespecial 124	org/json/JSONObject:<init>	()V
    //   13: astore 9
    //   15: new 123	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 124	org/json/JSONObject:<init>	()V
    //   22: astore 8
    //   24: aload 9
    //   26: ldc 126
    //   28: aload 8
    //   30: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: pop
    //   34: aload 8
    //   36: ldc 132
    //   38: iconst_1
    //   39: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   45: pop
    //   46: aload 8
    //   48: ldc 140
    //   50: new 142	java/lang/String
    //   53: dup
    //   54: getstatic 147	android/os/Build:MODEL	Ljava/lang/String;
    //   57: invokespecial 150	java/lang/String:<init>	(Ljava/lang/String;)V
    //   60: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   63: pop
    //   64: aload 8
    //   66: ldc 152
    //   68: new 142	java/lang/String
    //   71: dup
    //   72: new 154	java/lang/StringBuilder
    //   75: dup
    //   76: ldc 156
    //   78: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: getstatic 162	android/os/Build$VERSION:SDK_INT	I
    //   84: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokespecial 150	java/lang/String:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   96: pop
    //   97: new 123	org/json/JSONObject
    //   100: dup
    //   101: invokespecial 124	org/json/JSONObject:<init>	()V
    //   104: astore 10
    //   106: aload 9
    //   108: ldc 172
    //   110: aload 10
    //   112: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload 10
    //   118: ldc 174
    //   120: ldc 176
    //   122: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   125: pop
    //   126: new 178	org/json/JSONArray
    //   129: dup
    //   130: invokespecial 179	org/json/JSONArray:<init>	()V
    //   133: astore 8
    //   135: new 123	org/json/JSONObject
    //   138: dup
    //   139: invokespecial 124	org/json/JSONObject:<init>	()V
    //   142: astore 11
    //   144: aload 8
    //   146: aload 11
    //   148: invokevirtual 182	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   151: pop
    //   152: aload 10
    //   154: ldc 184
    //   156: aload 8
    //   158: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   161: pop
    //   162: new 123	org/json/JSONObject
    //   165: dup
    //   166: invokespecial 124	org/json/JSONObject:<init>	()V
    //   169: astore 8
    //   171: aload 11
    //   173: ldc 186
    //   175: aload 8
    //   177: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   180: pop
    //   181: aload_0
    //   182: getfield 190	com/tencent/mm/app/a$a:bXc	Ljava/util/LinkedList;
    //   185: astore_0
    //   186: aload_0
    //   187: invokestatic 196	com/tencent/mm/sdk/platformtools/bo:es	(Ljava/util/List;)Z
    //   190: ifne +291 -> 481
    //   193: aload_0
    //   194: invokevirtual 202	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   197: astore_0
    //   198: aload_0
    //   199: invokeinterface 207 1 0
    //   204: ifeq +277 -> 481
    //   207: aload_0
    //   208: invokeinterface 211 1 0
    //   213: checkcast 213	android/util/Pair
    //   216: astore 12
    //   218: aload 12
    //   220: getfield 217	android/util/Pair:first	Ljava/lang/Object;
    //   223: checkcast 219	java/lang/Thread
    //   226: astore 13
    //   228: aload 12
    //   230: getfield 222	android/util/Pair:second	Ljava/lang/Object;
    //   233: checkcast 224	[Ljava/lang/StackTraceElement;
    //   236: astore 12
    //   238: aload 12
    //   240: ifnull -42 -> 198
    //   243: aload 12
    //   245: arraylength
    //   246: ifle -48 -> 198
    //   249: new 154	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   256: aload 13
    //   258: invokevirtual 228	java/lang/Thread:getName	()Ljava/lang/String;
    //   261: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 233
    //   266: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 13
    //   271: invokevirtual 236	java/lang/Thread:getPriority	()I
    //   274: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc 238
    //   279: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 13
    //   284: invokevirtual 242	java/lang/Thread:getId	()J
    //   287: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   290: ldc 247
    //   292: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 13
    //   297: invokevirtual 251	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   300: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: ldc_w 256
    //   306: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: astore 13
    //   314: new 178	org/json/JSONArray
    //   317: dup
    //   318: invokespecial 179	org/json/JSONArray:<init>	()V
    //   321: astore 14
    //   323: aload 12
    //   325: arraylength
    //   326: istore_2
    //   327: iconst_0
    //   328: istore_1
    //   329: iload_1
    //   330: iload_2
    //   331: if_icmpge +28 -> 359
    //   334: aload 12
    //   336: iload_1
    //   337: aaload
    //   338: astore 15
    //   340: aload 15
    //   342: ifnull +1062 -> 1404
    //   345: aload 14
    //   347: aload 15
    //   349: invokevirtual 259	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   352: invokevirtual 182	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   355: pop
    //   356: goto +1048 -> 1404
    //   359: aload 8
    //   361: aload 13
    //   363: aload 14
    //   365: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   368: pop
    //   369: goto -171 -> 198
    //   372: astore_0
    //   373: ldc_w 261
    //   376: aload_0
    //   377: ldc_w 263
    //   380: iconst_0
    //   381: anewarray 4	java/lang/Object
    //   384: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: getstatic 275	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   390: ldc2_w 276
    //   393: ldc2_w 278
    //   396: lconst_1
    //   397: iconst_1
    //   398: invokevirtual 283	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   401: aload 9
    //   403: invokevirtual 284	org/json/JSONObject:toString	()Ljava/lang/String;
    //   406: astore 8
    //   408: aload 9
    //   410: invokevirtual 287	org/json/JSONObject:length	()I
    //   413: istore_1
    //   414: aload 8
    //   416: invokevirtual 288	java/lang/String:length	()I
    //   419: istore_2
    //   420: aload 8
    //   422: invokevirtual 288	java/lang/String:length	()I
    //   425: ldc_w 289
    //   428: if_icmple +970 -> 1398
    //   431: aload 8
    //   433: iconst_0
    //   434: ldc_w 289
    //   437: invokevirtual 293	java/lang/String:substring	(II)Ljava/lang/String;
    //   440: astore_0
    //   441: ldc_w 261
    //   444: ldc_w 295
    //   447: iconst_3
    //   448: anewarray 4	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: iload_1
    //   454: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   457: aastore
    //   458: dup
    //   459: iconst_1
    //   460: iload_2
    //   461: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   464: aastore
    //   465: dup
    //   466: iconst_2
    //   467: aload_0
    //   468: aastore
    //   469: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   472: sipush 15361
    //   475: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   478: aload 8
    //   480: areturn
    //   481: getstatic 65	com/tencent/mm/app/a:bWQ	Lcom/tencent/mm/compatible/e/p;
    //   484: invokevirtual 301	com/tencent/mm/compatible/e/p:LA	()I
    //   487: istore_1
    //   488: getstatic 65	com/tencent/mm/app/a:bWQ	Lcom/tencent/mm/compatible/e/p;
    //   491: invokevirtual 304	com/tencent/mm/compatible/e/p:LB	()I
    //   494: istore_2
    //   495: getstatic 65	com/tencent/mm/app/a:bWQ	Lcom/tencent/mm/compatible/e/p;
    //   498: invokevirtual 307	com/tencent/mm/compatible/e/p:Lz	()I
    //   501: istore_3
    //   502: ldc_w 261
    //   505: ldc_w 309
    //   508: iconst_3
    //   509: anewarray 4	java/lang/Object
    //   512: dup
    //   513: iconst_0
    //   514: iload_1
    //   515: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   518: aastore
    //   519: dup
    //   520: iconst_1
    //   521: iload_2
    //   522: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   525: aastore
    //   526: dup
    //   527: iconst_2
    //   528: iload_3
    //   529: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   532: aastore
    //   533: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   536: aload 11
    //   538: ldc_w 311
    //   541: iload_1
    //   542: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   545: pop
    //   546: aload 11
    //   548: ldc_w 316
    //   551: iload_2
    //   552: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   555: pop
    //   556: aload 11
    //   558: ldc_w 318
    //   561: iload_3
    //   562: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   565: pop
    //   566: invokestatic 324	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   569: ldc_w 326
    //   572: invokevirtual 332	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   575: checkcast 334	android/app/ActivityManager
    //   578: astore 8
    //   580: new 336	android/app/ActivityManager$MemoryInfo
    //   583: dup
    //   584: invokespecial 337	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   587: astore 12
    //   589: aload 8
    //   591: aload 12
    //   593: invokevirtual 341	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   596: lconst_0
    //   597: lstore 4
    //   599: bipush 16
    //   601: invokestatic 347	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   604: ifeq +403 -> 1007
    //   607: aload 12
    //   609: getfield 351	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   612: lstore 4
    //   614: ldc_w 261
    //   617: ldc_w 353
    //   620: iconst_4
    //   621: anewarray 4	java/lang/Object
    //   624: dup
    //   625: iconst_0
    //   626: lload 4
    //   628: invokestatic 358	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   631: aastore
    //   632: dup
    //   633: iconst_1
    //   634: aload 12
    //   636: getfield 361	android/app/ActivityManager$MemoryInfo:availMem	J
    //   639: invokestatic 358	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   642: aastore
    //   643: dup
    //   644: iconst_2
    //   645: aload 12
    //   647: getfield 364	android/app/ActivityManager$MemoryInfo:threshold	J
    //   650: invokestatic 358	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   653: aastore
    //   654: dup
    //   655: iconst_3
    //   656: aload 12
    //   658: getfield 367	android/app/ActivityManager$MemoryInfo:lowMemory	Z
    //   661: invokestatic 372	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   664: aastore
    //   665: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   668: aload 11
    //   670: ldc_w 374
    //   673: lload 4
    //   675: invokevirtual 377	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   678: pop
    //   679: aload 11
    //   681: ldc_w 379
    //   684: aload 12
    //   686: getfield 361	android/app/ActivityManager$MemoryInfo:availMem	J
    //   689: invokevirtual 377	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   692: pop
    //   693: aload 11
    //   695: ldc_w 381
    //   698: aload 12
    //   700: getfield 364	android/app/ActivityManager$MemoryInfo:threshold	J
    //   703: invokevirtual 377	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   706: pop
    //   707: aload 11
    //   709: ldc_w 383
    //   712: aload 12
    //   714: getfield 367	android/app/ActivityManager$MemoryInfo:lowMemory	Z
    //   717: invokevirtual 386	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   720: pop
    //   721: aload 11
    //   723: ldc_w 388
    //   726: invokestatic 393	android/os/Debug:getNativeHeapSize	()J
    //   729: invokevirtual 377	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   732: pop
    //   733: aload 11
    //   735: ldc_w 395
    //   738: invokestatic 398	android/os/Debug:getNativeHeapAllocatedSize	()J
    //   741: invokevirtual 377	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   744: pop
    //   745: aload 11
    //   747: ldc_w 400
    //   750: invokestatic 403	android/os/Debug:getNativeHeapFreeSize	()J
    //   753: invokevirtual 377	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   756: pop
    //   757: aload 8
    //   759: iconst_1
    //   760: newarray int
    //   762: dup
    //   763: iconst_0
    //   764: invokestatic 59	android/os/Process:myPid	()I
    //   767: iastore
    //   768: invokevirtual 407	android/app/ActivityManager:getProcessMemoryInfo	([I)[Landroid/os/Debug$MemoryInfo;
    //   771: astore_0
    //   772: aload_0
    //   773: ifnull +66 -> 839
    //   776: aload_0
    //   777: arraylength
    //   778: ifle +61 -> 839
    //   781: aload_0
    //   782: iconst_0
    //   783: aaload
    //   784: ifnull +55 -> 839
    //   787: aload_0
    //   788: iconst_0
    //   789: aaload
    //   790: astore_0
    //   791: aload 11
    //   793: ldc_w 409
    //   796: aload_0
    //   797: invokevirtual 414	android/os/Debug$MemoryInfo:getTotalPrivateDirty	()I
    //   800: bipush 10
    //   802: ishl
    //   803: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   806: pop
    //   807: aload 11
    //   809: ldc_w 416
    //   812: aload_0
    //   813: invokevirtual 419	android/os/Debug$MemoryInfo:getTotalSharedDirty	()I
    //   816: bipush 10
    //   818: ishl
    //   819: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   822: pop
    //   823: aload 11
    //   825: ldc_w 421
    //   828: aload_0
    //   829: invokevirtual 424	android/os/Debug$MemoryInfo:getTotalPss	()I
    //   832: bipush 10
    //   834: ishl
    //   835: invokevirtual 314	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   838: pop
    //   839: getstatic 49	com/tencent/mm/app/a:bWO	I
    //   842: iconst_1
    //   843: if_icmpne +407 -> 1250
    //   846: invokestatic 429	com/tencent/mm/model/aw:RG	()Z
    //   849: ifeq +401 -> 1250
    //   852: invokestatic 435	com/tencent/mm/kernel/g:RJ	()Lcom/tencent/mm/kernel/a;
    //   855: getfield 440	com/tencent/mm/kernel/a:eHg	Z
    //   858: ifeq +392 -> 1250
    //   861: getstatic 446	com/tencent/mm/storage/ac$a:yFi	Lcom/tencent/mm/storage/ac$a;
    //   864: astore 12
    //   866: getstatic 449	com/tencent/mm/storage/ac$a:yFj	Lcom/tencent/mm/storage/ac$a;
    //   869: astore 13
    //   871: getstatic 452	com/tencent/mm/storage/ac$a:yFk	Lcom/tencent/mm/storage/ac$a;
    //   874: astore 14
    //   876: getstatic 455	com/tencent/mm/storage/ac$a:yFl	Lcom/tencent/mm/storage/ac$a;
    //   879: astore 15
    //   881: getstatic 458	com/tencent/mm/storage/ac$a:yFm	Lcom/tencent/mm/storage/ac$a;
    //   884: astore 16
    //   886: getstatic 461	com/tencent/mm/storage/ac$a:yFn	Lcom/tencent/mm/storage/ac$a;
    //   889: astore 17
    //   891: getstatic 464	com/tencent/mm/storage/ac$a:yFo	Lcom/tencent/mm/storage/ac$a;
    //   894: astore 18
    //   896: iconst_0
    //   897: istore_1
    //   898: ldc 82
    //   900: astore_0
    //   901: iload_1
    //   902: bipush 7
    //   904: if_icmpge +313 -> 1217
    //   907: bipush 7
    //   909: anewarray 442	com/tencent/mm/storage/ac$a
    //   912: dup
    //   913: iconst_0
    //   914: aload 12
    //   916: aastore
    //   917: dup
    //   918: iconst_1
    //   919: aload 13
    //   921: aastore
    //   922: dup
    //   923: iconst_2
    //   924: aload 14
    //   926: aastore
    //   927: dup
    //   928: iconst_3
    //   929: aload 15
    //   931: aastore
    //   932: dup
    //   933: iconst_4
    //   934: aload 16
    //   936: aastore
    //   937: dup
    //   938: iconst_5
    //   939: aload 17
    //   941: aastore
    //   942: dup
    //   943: bipush 6
    //   945: aload 18
    //   947: aastore
    //   948: iload_1
    //   949: aaload
    //   950: astore 8
    //   952: new 154	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   959: aload_0
    //   960: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: astore 19
    //   965: invokestatic 468	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   968: pop
    //   969: aload 19
    //   971: invokestatic 474	com/tencent/mm/model/c:Ru	()Lcom/tencent/mm/storage/z;
    //   974: aload 8
    //   976: lconst_0
    //   977: invokestatic 358	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   980: invokevirtual 480	com/tencent/mm/storage/z:get	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   983: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   986: ldc_w 482
    //   989: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: astore 8
    //   997: iload_1
    //   998: iconst_1
    //   999: iadd
    //   1000: istore_1
    //   1001: aload 8
    //   1003: astore_0
    //   1004: goto -103 -> 901
    //   1007: new 484	java/io/RandomAccessFile
    //   1010: dup
    //   1011: ldc_w 486
    //   1014: ldc_w 488
    //   1017: invokespecial 491	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1020: astore_0
    //   1021: new 493	java/lang/StringBuffer
    //   1024: dup
    //   1025: invokespecial 494	java/lang/StringBuffer:<init>	()V
    //   1028: astore 13
    //   1030: aload_0
    //   1031: invokevirtual 497	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   1034: invokevirtual 501	java/lang/String:toCharArray	()[C
    //   1037: astore 14
    //   1039: aload 14
    //   1041: arraylength
    //   1042: istore_2
    //   1043: iconst_0
    //   1044: istore_1
    //   1045: iload_1
    //   1046: iload_2
    //   1047: if_icmpge +34 -> 1081
    //   1050: aload 14
    //   1052: iload_1
    //   1053: caload
    //   1054: bipush 57
    //   1056: if_icmpgt +355 -> 1411
    //   1059: aload 14
    //   1061: iload_1
    //   1062: caload
    //   1063: bipush 48
    //   1065: if_icmplt +346 -> 1411
    //   1068: aload 13
    //   1070: aload 14
    //   1072: iload_1
    //   1073: caload
    //   1074: invokevirtual 504	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   1077: pop
    //   1078: goto +333 -> 1411
    //   1081: aload 13
    //   1083: invokevirtual 505	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1086: ldc2_w 506
    //   1089: invokestatic 511	com/tencent/mm/sdk/platformtools/bo:getLong	(Ljava/lang/String;J)J
    //   1092: lstore 6
    //   1094: lload 6
    //   1096: lconst_0
    //   1097: lcmp
    //   1098: ifle +10 -> 1108
    //   1101: lload 6
    //   1103: bipush 10
    //   1105: lshl
    //   1106: lstore 4
    //   1108: aload_0
    //   1109: invokevirtual 514	java/io/RandomAccessFile:close	()V
    //   1112: goto -498 -> 614
    //   1115: astore_0
    //   1116: ldc_w 261
    //   1119: aload_0
    //   1120: ldc_w 516
    //   1123: iconst_0
    //   1124: anewarray 4	java/lang/Object
    //   1127: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1130: getstatic 275	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1133: ldc2_w 276
    //   1136: ldc2_w 517
    //   1139: lconst_1
    //   1140: iconst_1
    //   1141: invokevirtual 283	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1144: goto -743 -> 401
    //   1147: astore 13
    //   1149: ldc_w 261
    //   1152: aload 13
    //   1154: ldc_w 520
    //   1157: iconst_0
    //   1158: anewarray 4	java/lang/Object
    //   1161: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1164: aload_0
    //   1165: invokevirtual 514	java/io/RandomAccessFile:close	()V
    //   1168: goto -554 -> 614
    //   1171: astore 8
    //   1173: aload_0
    //   1174: invokevirtual 514	java/io/RandomAccessFile:close	()V
    //   1177: sipush 15361
    //   1180: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1183: aload 8
    //   1185: athrow
    //   1186: astore 8
    //   1188: ldc_w 261
    //   1191: aload 8
    //   1193: ldc_w 522
    //   1196: iconst_0
    //   1197: anewarray 4	java/lang/Object
    //   1200: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1203: getstatic 275	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1206: ldc2_w 276
    //   1209: ldc2_w 523
    //   1212: lconst_1
    //   1213: iconst_1
    //   1214: invokevirtual 283	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1217: ldc_w 261
    //   1220: ldc_w 526
    //   1223: iconst_2
    //   1224: anewarray 4	java/lang/Object
    //   1227: dup
    //   1228: iconst_0
    //   1229: getstatic 90	com/tencent/mm/app/a:bNv	Ljava/lang/String;
    //   1232: aastore
    //   1233: dup
    //   1234: iconst_1
    //   1235: aload_0
    //   1236: aastore
    //   1237: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1240: aload 11
    //   1242: ldc_w 528
    //   1245: aload_0
    //   1246: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1249: pop
    //   1250: aload 11
    //   1252: ldc_w 530
    //   1255: getstatic 78	com/tencent/mm/app/a:bWW	I
    //   1258: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1261: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1264: pop
    //   1265: iconst_0
    //   1266: istore_1
    //   1267: new 532	java/io/File
    //   1270: dup
    //   1271: getstatic 537	com/tencent/mm/storage/ac:eQv	Ljava/lang/String;
    //   1274: invokespecial 538	java/io/File:<init>	(Ljava/lang/String;)V
    //   1277: invokevirtual 541	java/io/File:exists	()Z
    //   1280: ifeq +25 -> 1305
    //   1283: invokestatic 324	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   1286: ldc_w 543
    //   1289: invokestatic 548	com/tencent/mm/compatible/util/h:Mp	()I
    //   1292: invokevirtual 552	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1295: ldc_w 554
    //   1298: iconst_0
    //   1299: invokeinterface 560 3 0
    //   1304: istore_1
    //   1305: aload 10
    //   1307: ldc_w 562
    //   1310: new 355	java/lang/Long
    //   1313: dup
    //   1314: iload_1
    //   1315: i2l
    //   1316: invokespecial 563	java/lang/Long:<init>	(J)V
    //   1319: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1322: pop
    //   1323: aload 10
    //   1325: ldc_w 565
    //   1328: getstatic 90	com/tencent/mm/app/a:bNv	Ljava/lang/String;
    //   1331: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1334: pop
    //   1335: aload 10
    //   1337: ldc_w 530
    //   1340: new 355	java/lang/Long
    //   1343: dup
    //   1344: invokestatic 570	java/lang/System:currentTimeMillis	()J
    //   1347: invokespecial 563	java/lang/Long:<init>	(J)V
    //   1350: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1353: pop
    //   1354: aload 10
    //   1356: ldc_w 572
    //   1359: getstatic 577	com/tencent/mm/protocal/d:whH	I
    //   1362: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1365: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1368: pop
    //   1369: aload 10
    //   1371: ldc_w 579
    //   1374: invokestatic 584	com/tencent/mm/loader/j/a:Ui	()Ljava/lang/String;
    //   1377: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1380: pop
    //   1381: getstatic 275	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1384: ldc2_w 276
    //   1387: ldc2_w 585
    //   1390: lconst_1
    //   1391: iconst_1
    //   1392: invokevirtual 283	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1395: goto -994 -> 401
    //   1398: aload 8
    //   1400: astore_0
    //   1401: goto -960 -> 441
    //   1404: iload_1
    //   1405: iconst_1
    //   1406: iadd
    //   1407: istore_1
    //   1408: goto -1079 -> 329
    //   1411: iload_1
    //   1412: iconst_1
    //   1413: iadd
    //   1414: istore_1
    //   1415: goto -370 -> 1045
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1418	0	parama	a.a
    //   328	1087	1	i	int
    //   326	722	2	j	int
    //   501	61	3	k	int
    //   597	510	4	l1	long
    //   1092	10	6	l2	long
    //   22	980	8	localObject1	Object
    //   1171	13	8	localObject2	Object
    //   1186	213	8	localException1	java.lang.Exception
    //   13	396	9	localJSONObject1	org.json.JSONObject
    //   104	1266	10	localJSONObject2	org.json.JSONObject
    //   142	1109	11	localJSONObject3	org.json.JSONObject
    //   216	699	12	localObject3	Object
    //   226	856	13	localObject4	Object
    //   1147	6	13	localException2	java.lang.Exception
    //   321	750	14	localObject5	Object
    //   338	592	15	locala1	com.tencent.mm.storage.ac.a
    //   884	51	16	locala2	com.tencent.mm.storage.ac.a
    //   889	51	17	locala3	com.tencent.mm.storage.ac.a
    //   894	52	18	locala4	com.tencent.mm.storage.ac.a
    //   963	7	19	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   15	198	372	org/json/JSONException
    //   198	238	372	org/json/JSONException
    //   243	327	372	org/json/JSONException
    //   345	356	372	org/json/JSONException
    //   359	369	372	org/json/JSONException
    //   481	596	372	org/json/JSONException
    //   599	614	372	org/json/JSONException
    //   614	772	372	org/json/JSONException
    //   776	781	372	org/json/JSONException
    //   791	839	372	org/json/JSONException
    //   839	896	372	org/json/JSONException
    //   907	997	372	org/json/JSONException
    //   1007	1021	372	org/json/JSONException
    //   1108	1112	372	org/json/JSONException
    //   1164	1168	372	org/json/JSONException
    //   1173	1186	372	org/json/JSONException
    //   1188	1217	372	org/json/JSONException
    //   1217	1250	372	org/json/JSONException
    //   1250	1265	372	org/json/JSONException
    //   1267	1305	372	org/json/JSONException
    //   1305	1395	372	org/json/JSONException
    //   15	198	1115	java/lang/Exception
    //   198	238	1115	java/lang/Exception
    //   243	327	1115	java/lang/Exception
    //   345	356	1115	java/lang/Exception
    //   359	369	1115	java/lang/Exception
    //   481	596	1115	java/lang/Exception
    //   599	614	1115	java/lang/Exception
    //   614	772	1115	java/lang/Exception
    //   776	781	1115	java/lang/Exception
    //   791	839	1115	java/lang/Exception
    //   839	896	1115	java/lang/Exception
    //   1007	1021	1115	java/lang/Exception
    //   1108	1112	1115	java/lang/Exception
    //   1164	1168	1115	java/lang/Exception
    //   1173	1186	1115	java/lang/Exception
    //   1188	1217	1115	java/lang/Exception
    //   1217	1250	1115	java/lang/Exception
    //   1250	1265	1115	java/lang/Exception
    //   1267	1305	1115	java/lang/Exception
    //   1305	1395	1115	java/lang/Exception
    //   1021	1043	1147	java/lang/Exception
    //   1068	1078	1147	java/lang/Exception
    //   1081	1094	1147	java/lang/Exception
    //   1021	1043	1171	finally
    //   1068	1078	1171	finally
    //   1081	1094	1171	finally
    //   1149	1164	1171	finally
    //   907	997	1186	java/lang/Exception
  }
  
  public static void dr(String paramString)
  {
    AppMethodBeat.i(15360);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp());
    int n = localSharedPreferences.getInt("main_thread_watch_enable", 65535);
    int j = localSharedPreferences.getInt("main_thread_watch_timeout", 0);
    int k = localSharedPreferences.getInt("main_thread_watch_log_loop", 0);
    int i1 = localSharedPreferences.getInt("main_thread_watch_report", 0);
    int m = k;
    int i = j;
    if (q(paramString, n))
    {
      i = j;
      if (j <= 0) {
        i = 4500;
      }
      j = k;
      if (k <= 0) {
        j = 500;
      }
      if (bXb != null) {
        bXb.interrupt();
      }
      bNv = paramString;
      if (i > 0) {
        bWW = i;
      }
      if (j > 0) {
        bWX = j;
      }
      bXb = com.tencent.mm.sdk.g.d.h(new a.c(), paramString + "_ANRWatchDog");
      if (bWV == null) {
        bWV = new Handler(Looper.getMainLooper());
      }
      bXb.start();
      ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch sProcessName[%s], sTimeoutInterval[%d], logLoop[%d], sWatchThread[%s], stack[%s]", new Object[] { bNv, Integer.valueOf(bWW), Integer.valueOf(bWX), bXb.getName(), bo.dtY() });
      m = j;
    }
    ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch processName[%s] enable[%d], timeout[%d], loop[%d], report[%d]", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(i1) });
    AppMethodBeat.o(15360);
  }
  
  private static boolean q(String paramString, int paramInt)
  {
    AppMethodBeat.i(15359);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(15359);
      return false;
    }
    if (paramString.equals(ah.getPackageName()))
    {
      bWO = 1;
      if ((com.tencent.mm.protocal.d.whL) || ((paramInt & 0x1) != 0))
      {
        AppMethodBeat.o(15359);
        return true;
      }
      AppMethodBeat.o(15359);
      return false;
    }
    if (paramString.endsWith(":push"))
    {
      bWO = 2;
      if ((paramInt & 0x2) != 0)
      {
        AppMethodBeat.o(15359);
        return true;
      }
      AppMethodBeat.o(15359);
      return false;
    }
    if ((paramString.endsWith(":tools")) || (paramString.endsWith(":toolsmp")))
    {
      bWO = 4;
      if ((paramInt & 0x4) != 0)
      {
        AppMethodBeat.o(15359);
        return true;
      }
      AppMethodBeat.o(15359);
      return false;
    }
    if (paramString.endsWith(":sandbox"))
    {
      bWO = 8;
      if ((paramInt & 0x8) != 0)
      {
        AppMethodBeat.o(15359);
        return true;
      }
      AppMethodBeat.o(15359);
      return false;
    }
    if (paramString.endsWith(":exdevice"))
    {
      bWO = 16;
      if ((paramInt & 0x10) != 0)
      {
        AppMethodBeat.o(15359);
        return true;
      }
      AppMethodBeat.o(15359);
      return false;
    }
    if (paramString.contains(":appbrand"))
    {
      bWO = 32;
      if ((paramInt & 0x20) != 0)
      {
        AppMethodBeat.o(15359);
        return true;
      }
      AppMethodBeat.o(15359);
      return false;
    }
    AppMethodBeat.o(15359);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.a
 * JD-Core Version:    0.7.0.1
 */