package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.tencent.mm.compatible.e.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  private static String bnX = "";
  private static int bvD = 0;
  private static int bvE = 0;
  private static p bvF = new p(Process.myPid());
  private static final a.b bvG = new a.b()
  {
    public final void c(a.a paramAnonymousa)
    {
      int i = ae.getContext().getSharedPreferences("system_config_prefs", 4).getInt("main_thread_watch_report", 0);
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        y.w("MicroMsg.ANRWatchDog.summeranr", "summeranr onAppNotResponding error reportFlag[%b]", new Object[] { Boolean.valueOf(bool) });
        try
        {
          paramAnonymousa = a.b(paramAnonymousa);
          if (i > 0)
          {
            b.t(Base64.encodeToString(paramAnonymousa.getBytes(), 2), "main_thread_watch");
            return;
          }
          h.nFQ.a(510L, 14L, 1L, true);
          return;
        }
        catch (OutOfMemoryError paramAnonymousa)
        {
          y.e("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport OutOfMemory %s", new Object[] { paramAnonymousa.getMessage() });
          System.gc();
          h.nFQ.a(510L, 15L, 1L, true);
          return;
        }
      }
    }
  };
  private static final a.d bvH = new a.d()
  {
    public final void a(InterruptedException paramAnonymousInterruptedException)
    {
      y.w("MicroMsg.ANRWatchDog.summeranr", "summeranr DEFAULT_INTERRUPTION_LISTENER onInterrupted exception.getMessage[%s]", new Object[] { paramAnonymousInterruptedException.getMessage() });
    }
  };
  private static a.b bvI = bvG;
  private static a.d bvJ = bvH;
  private static Handler bvK;
  private static int bvL = 4500;
  private static int bvM = 500;
  private static String bvN = "";
  private static boolean bvO = true;
  private static boolean bvP = false;
  private static Thread bvQ;
  
  /* Error */
  private static String a(a.a parama)
  {
    // Byte code:
    //   0: new 93	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 94	org/json/JSONObject:<init>	()V
    //   7: astore 9
    //   9: new 93	org/json/JSONObject
    //   12: dup
    //   13: invokespecial 94	org/json/JSONObject:<init>	()V
    //   16: astore 8
    //   18: aload 9
    //   20: ldc 96
    //   22: aload 8
    //   24: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   27: pop
    //   28: aload 8
    //   30: ldc 102
    //   32: new 104	java/lang/Integer
    //   35: dup
    //   36: iconst_1
    //   37: invokespecial 107	java/lang/Integer:<init>	(I)V
    //   40: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload 8
    //   46: ldc 109
    //   48: new 111	java/lang/String
    //   51: dup
    //   52: getstatic 116	android/os/Build:MODEL	Ljava/lang/String;
    //   55: invokespecial 119	java/lang/String:<init>	(Ljava/lang/String;)V
    //   58: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   61: pop
    //   62: aload 8
    //   64: ldc 121
    //   66: new 111	java/lang/String
    //   69: dup
    //   70: new 123	java/lang/StringBuilder
    //   73: dup
    //   74: ldc 125
    //   76: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: getstatic 131	android/os/Build$VERSION:SDK_INT	I
    //   82: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 119	java/lang/String:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   94: pop
    //   95: new 93	org/json/JSONObject
    //   98: dup
    //   99: invokespecial 94	org/json/JSONObject:<init>	()V
    //   102: astore 10
    //   104: aload 9
    //   106: ldc 141
    //   108: aload 10
    //   110: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload 10
    //   116: ldc 143
    //   118: ldc 145
    //   120: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: pop
    //   124: new 147	org/json/JSONArray
    //   127: dup
    //   128: invokespecial 148	org/json/JSONArray:<init>	()V
    //   131: astore 8
    //   133: new 93	org/json/JSONObject
    //   136: dup
    //   137: invokespecial 94	org/json/JSONObject:<init>	()V
    //   140: astore 11
    //   142: aload 8
    //   144: aload 11
    //   146: invokevirtual 151	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   149: pop
    //   150: aload 10
    //   152: ldc 153
    //   154: aload 8
    //   156: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   159: pop
    //   160: new 93	org/json/JSONObject
    //   163: dup
    //   164: invokespecial 94	org/json/JSONObject:<init>	()V
    //   167: astore 8
    //   169: aload 11
    //   171: ldc 155
    //   173: aload 8
    //   175: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload_0
    //   180: getfield 159	com/tencent/mm/app/a$a:bvR	Ljava/util/LinkedList;
    //   183: astore_0
    //   184: aload_0
    //   185: invokestatic 165	com/tencent/mm/sdk/platformtools/bk:dk	(Ljava/util/List;)Z
    //   188: ifne +281 -> 469
    //   191: aload_0
    //   192: invokevirtual 171	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   195: astore_0
    //   196: aload_0
    //   197: invokeinterface 177 1 0
    //   202: ifeq +267 -> 469
    //   205: aload_0
    //   206: invokeinterface 181 1 0
    //   211: checkcast 183	android/util/Pair
    //   214: astore 12
    //   216: aload 12
    //   218: getfield 187	android/util/Pair:first	Ljava/lang/Object;
    //   221: checkcast 189	java/lang/Thread
    //   224: astore 13
    //   226: aload 12
    //   228: getfield 192	android/util/Pair:second	Ljava/lang/Object;
    //   231: checkcast 194	[Ljava/lang/StackTraceElement;
    //   234: astore 12
    //   236: aload 12
    //   238: ifnull -42 -> 196
    //   241: aload 12
    //   243: arraylength
    //   244: ifle -48 -> 196
    //   247: new 123	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   254: aload 13
    //   256: invokevirtual 198	java/lang/Thread:getName	()Ljava/lang/String;
    //   259: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 203
    //   264: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 13
    //   269: invokevirtual 206	java/lang/Thread:getPriority	()I
    //   272: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: ldc 208
    //   277: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 13
    //   282: invokevirtual 212	java/lang/Thread:getId	()J
    //   285: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   288: ldc 217
    //   290: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload 13
    //   295: invokevirtual 221	java/lang/Thread:getState	()Ljava/lang/Thread$State;
    //   298: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: ldc 226
    //   303: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: astore 13
    //   311: new 147	org/json/JSONArray
    //   314: dup
    //   315: invokespecial 148	org/json/JSONArray:<init>	()V
    //   318: astore 14
    //   320: aload 12
    //   322: arraylength
    //   323: istore_2
    //   324: iconst_0
    //   325: istore_1
    //   326: iload_1
    //   327: iload_2
    //   328: if_icmpge +28 -> 356
    //   331: aload 12
    //   333: iload_1
    //   334: aaload
    //   335: astore 15
    //   337: aload 15
    //   339: ifnull +1047 -> 1386
    //   342: aload 14
    //   344: aload 15
    //   346: invokevirtual 229	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   349: invokevirtual 151	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   352: pop
    //   353: goto +1033 -> 1386
    //   356: aload 8
    //   358: aload 13
    //   360: aload 14
    //   362: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   365: pop
    //   366: goto -170 -> 196
    //   369: astore_0
    //   370: ldc 231
    //   372: aload_0
    //   373: ldc 233
    //   375: iconst_0
    //   376: anewarray 4	java/lang/Object
    //   379: invokestatic 239	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   382: getstatic 245	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   385: ldc2_w 246
    //   388: ldc2_w 248
    //   391: lconst_1
    //   392: iconst_1
    //   393: invokevirtual 252	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   396: aload 9
    //   398: invokevirtual 253	org/json/JSONObject:toString	()Ljava/lang/String;
    //   401: astore 8
    //   403: aload 9
    //   405: invokevirtual 256	org/json/JSONObject:length	()I
    //   408: istore_1
    //   409: aload 8
    //   411: invokevirtual 257	java/lang/String:length	()I
    //   414: istore_2
    //   415: aload 8
    //   417: invokevirtual 257	java/lang/String:length	()I
    //   420: ldc_w 258
    //   423: if_icmple +957 -> 1380
    //   426: aload 8
    //   428: iconst_0
    //   429: ldc_w 258
    //   432: invokevirtual 262	java/lang/String:substring	(II)Ljava/lang/String;
    //   435: astore_0
    //   436: ldc 231
    //   438: ldc_w 264
    //   441: iconst_3
    //   442: anewarray 4	java/lang/Object
    //   445: dup
    //   446: iconst_0
    //   447: iload_1
    //   448: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   451: aastore
    //   452: dup
    //   453: iconst_1
    //   454: iload_2
    //   455: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: aastore
    //   459: dup
    //   460: iconst_2
    //   461: aload_0
    //   462: aastore
    //   463: invokestatic 272	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: aload 8
    //   468: areturn
    //   469: getstatic 59	com/tencent/mm/app/a:bvF	Lcom/tencent/mm/compatible/e/p;
    //   472: invokevirtual 275	com/tencent/mm/compatible/e/p:zd	()I
    //   475: istore_1
    //   476: getstatic 59	com/tencent/mm/app/a:bvF	Lcom/tencent/mm/compatible/e/p;
    //   479: invokevirtual 278	com/tencent/mm/compatible/e/p:ze	()I
    //   482: istore_2
    //   483: getstatic 59	com/tencent/mm/app/a:bvF	Lcom/tencent/mm/compatible/e/p;
    //   486: invokevirtual 281	com/tencent/mm/compatible/e/p:zc	()I
    //   489: istore_3
    //   490: ldc 231
    //   492: ldc_w 283
    //   495: iconst_3
    //   496: anewarray 4	java/lang/Object
    //   499: dup
    //   500: iconst_0
    //   501: iload_1
    //   502: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   505: aastore
    //   506: dup
    //   507: iconst_1
    //   508: iload_2
    //   509: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   512: aastore
    //   513: dup
    //   514: iconst_2
    //   515: iload_3
    //   516: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   519: aastore
    //   520: invokestatic 272	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   523: aload 11
    //   525: ldc_w 285
    //   528: iload_1
    //   529: invokevirtual 288	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   532: pop
    //   533: aload 11
    //   535: ldc_w 290
    //   538: iload_2
    //   539: invokevirtual 288	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   542: pop
    //   543: aload 11
    //   545: ldc_w 292
    //   548: iload_3
    //   549: invokevirtual 288	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   552: pop
    //   553: invokestatic 298	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   556: ldc_w 300
    //   559: invokevirtual 306	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   562: checkcast 308	android/app/ActivityManager
    //   565: astore 8
    //   567: new 310	android/app/ActivityManager$MemoryInfo
    //   570: dup
    //   571: invokespecial 311	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   574: astore 12
    //   576: aload 8
    //   578: aload 12
    //   580: invokevirtual 315	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   583: lconst_0
    //   584: lstore 4
    //   586: bipush 16
    //   588: invokestatic 321	com/tencent/mm/compatible/util/d:gF	(I)Z
    //   591: ifeq +402 -> 993
    //   594: aload 12
    //   596: getfield 325	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   599: lstore 4
    //   601: ldc 231
    //   603: ldc_w 327
    //   606: iconst_4
    //   607: anewarray 4	java/lang/Object
    //   610: dup
    //   611: iconst_0
    //   612: lload 4
    //   614: invokestatic 332	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   617: aastore
    //   618: dup
    //   619: iconst_1
    //   620: aload 12
    //   622: getfield 335	android/app/ActivityManager$MemoryInfo:availMem	J
    //   625: invokestatic 332	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   628: aastore
    //   629: dup
    //   630: iconst_2
    //   631: aload 12
    //   633: getfield 338	android/app/ActivityManager$MemoryInfo:threshold	J
    //   636: invokestatic 332	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   639: aastore
    //   640: dup
    //   641: iconst_3
    //   642: aload 12
    //   644: getfield 341	android/app/ActivityManager$MemoryInfo:lowMemory	Z
    //   647: invokestatic 346	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   650: aastore
    //   651: invokestatic 272	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   654: aload 11
    //   656: ldc_w 348
    //   659: lload 4
    //   661: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   664: pop
    //   665: aload 11
    //   667: ldc_w 353
    //   670: aload 12
    //   672: getfield 335	android/app/ActivityManager$MemoryInfo:availMem	J
    //   675: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   678: pop
    //   679: aload 11
    //   681: ldc_w 355
    //   684: aload 12
    //   686: getfield 338	android/app/ActivityManager$MemoryInfo:threshold	J
    //   689: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   692: pop
    //   693: aload 11
    //   695: ldc_w 357
    //   698: aload 12
    //   700: getfield 341	android/app/ActivityManager$MemoryInfo:lowMemory	Z
    //   703: invokevirtual 360	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   706: pop
    //   707: aload 11
    //   709: ldc_w 362
    //   712: invokestatic 367	android/os/Debug:getNativeHeapSize	()J
    //   715: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   718: pop
    //   719: aload 11
    //   721: ldc_w 369
    //   724: invokestatic 372	android/os/Debug:getNativeHeapAllocatedSize	()J
    //   727: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   730: pop
    //   731: aload 11
    //   733: ldc_w 374
    //   736: invokestatic 377	android/os/Debug:getNativeHeapFreeSize	()J
    //   739: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   742: pop
    //   743: aload 8
    //   745: iconst_1
    //   746: newarray int
    //   748: dup
    //   749: iconst_0
    //   750: invokestatic 53	android/os/Process:myPid	()I
    //   753: iastore
    //   754: invokevirtual 381	android/app/ActivityManager:getProcessMemoryInfo	([I)[Landroid/os/Debug$MemoryInfo;
    //   757: astore_0
    //   758: aload_0
    //   759: ifnull +66 -> 825
    //   762: aload_0
    //   763: arraylength
    //   764: ifle +61 -> 825
    //   767: aload_0
    //   768: iconst_0
    //   769: aaload
    //   770: ifnull +55 -> 825
    //   773: aload_0
    //   774: iconst_0
    //   775: aaload
    //   776: astore_0
    //   777: aload 11
    //   779: ldc_w 383
    //   782: aload_0
    //   783: invokevirtual 388	android/os/Debug$MemoryInfo:getTotalPrivateDirty	()I
    //   786: bipush 10
    //   788: ishl
    //   789: invokevirtual 288	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   792: pop
    //   793: aload 11
    //   795: ldc_w 390
    //   798: aload_0
    //   799: invokevirtual 393	android/os/Debug$MemoryInfo:getTotalSharedDirty	()I
    //   802: bipush 10
    //   804: ishl
    //   805: invokevirtual 288	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   808: pop
    //   809: aload 11
    //   811: ldc_w 395
    //   814: aload_0
    //   815: invokevirtual 398	android/os/Debug$MemoryInfo:getTotalPss	()I
    //   818: bipush 10
    //   820: ishl
    //   821: invokevirtual 288	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   824: pop
    //   825: getstatic 43	com/tencent/mm/app/a:bvD	I
    //   828: iconst_1
    //   829: if_icmpne +397 -> 1226
    //   832: invokestatic 403	com/tencent/mm/model/au:DK	()Z
    //   835: ifeq +391 -> 1226
    //   838: invokestatic 409	com/tencent/mm/kernel/g:DN	()Lcom/tencent/mm/kernel/a;
    //   841: getfield 414	com/tencent/mm/kernel/a:dJH	Z
    //   844: ifeq +382 -> 1226
    //   847: getstatic 420	com/tencent/mm/storage/ac$a:uvb	Lcom/tencent/mm/storage/ac$a;
    //   850: astore 12
    //   852: getstatic 423	com/tencent/mm/storage/ac$a:uvc	Lcom/tencent/mm/storage/ac$a;
    //   855: astore 13
    //   857: getstatic 426	com/tencent/mm/storage/ac$a:uvd	Lcom/tencent/mm/storage/ac$a;
    //   860: astore 14
    //   862: getstatic 429	com/tencent/mm/storage/ac$a:uve	Lcom/tencent/mm/storage/ac$a;
    //   865: astore 15
    //   867: getstatic 432	com/tencent/mm/storage/ac$a:uvf	Lcom/tencent/mm/storage/ac$a;
    //   870: astore 16
    //   872: getstatic 435	com/tencent/mm/storage/ac$a:uvg	Lcom/tencent/mm/storage/ac$a;
    //   875: astore 17
    //   877: getstatic 438	com/tencent/mm/storage/ac$a:uvh	Lcom/tencent/mm/storage/ac$a;
    //   880: astore 18
    //   882: iconst_0
    //   883: istore_1
    //   884: ldc 76
    //   886: astore_0
    //   887: iload_1
    //   888: bipush 7
    //   890: if_icmpge +304 -> 1194
    //   893: bipush 7
    //   895: anewarray 416	com/tencent/mm/storage/ac$a
    //   898: dup
    //   899: iconst_0
    //   900: aload 12
    //   902: aastore
    //   903: dup
    //   904: iconst_1
    //   905: aload 13
    //   907: aastore
    //   908: dup
    //   909: iconst_2
    //   910: aload 14
    //   912: aastore
    //   913: dup
    //   914: iconst_3
    //   915: aload 15
    //   917: aastore
    //   918: dup
    //   919: iconst_4
    //   920: aload 16
    //   922: aastore
    //   923: dup
    //   924: iconst_5
    //   925: aload 17
    //   927: aastore
    //   928: dup
    //   929: bipush 6
    //   931: aload 18
    //   933: aastore
    //   934: iload_1
    //   935: aaload
    //   936: astore 8
    //   938: new 123	java/lang/StringBuilder
    //   941: dup
    //   942: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   945: aload_0
    //   946: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: astore 19
    //   951: invokestatic 442	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   954: pop
    //   955: aload 19
    //   957: invokestatic 448	com/tencent/mm/model/c:Dz	()Lcom/tencent/mm/storage/z;
    //   960: aload 8
    //   962: lconst_0
    //   963: invokestatic 332	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   966: invokevirtual 454	com/tencent/mm/storage/z:get	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   969: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   972: ldc_w 456
    //   975: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: astore 8
    //   983: iload_1
    //   984: iconst_1
    //   985: iadd
    //   986: istore_1
    //   987: aload 8
    //   989: astore_0
    //   990: goto -103 -> 887
    //   993: new 458	java/io/RandomAccessFile
    //   996: dup
    //   997: ldc_w 460
    //   1000: ldc_w 462
    //   1003: invokespecial 465	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1006: astore_0
    //   1007: new 467	java/lang/StringBuffer
    //   1010: dup
    //   1011: invokespecial 468	java/lang/StringBuffer:<init>	()V
    //   1014: astore 13
    //   1016: aload_0
    //   1017: invokevirtual 471	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   1020: invokevirtual 475	java/lang/String:toCharArray	()[C
    //   1023: astore 14
    //   1025: aload 14
    //   1027: arraylength
    //   1028: istore_2
    //   1029: iconst_0
    //   1030: istore_1
    //   1031: iload_1
    //   1032: iload_2
    //   1033: if_icmpge +34 -> 1067
    //   1036: aload 14
    //   1038: iload_1
    //   1039: caload
    //   1040: bipush 57
    //   1042: if_icmpgt +351 -> 1393
    //   1045: aload 14
    //   1047: iload_1
    //   1048: caload
    //   1049: bipush 48
    //   1051: if_icmplt +342 -> 1393
    //   1054: aload 13
    //   1056: aload 14
    //   1058: iload_1
    //   1059: caload
    //   1060: invokevirtual 478	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   1063: pop
    //   1064: goto +329 -> 1393
    //   1067: aload 13
    //   1069: invokevirtual 479	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1072: ldc2_w 480
    //   1075: invokestatic 485	com/tencent/mm/sdk/platformtools/bk:getLong	(Ljava/lang/String;J)J
    //   1078: lstore 6
    //   1080: lload 6
    //   1082: lconst_0
    //   1083: lcmp
    //   1084: ifle +10 -> 1094
    //   1087: lload 6
    //   1089: bipush 10
    //   1091: lshl
    //   1092: lstore 4
    //   1094: aload_0
    //   1095: invokevirtual 488	java/io/RandomAccessFile:close	()V
    //   1098: goto -497 -> 601
    //   1101: astore_0
    //   1102: ldc 231
    //   1104: aload_0
    //   1105: ldc_w 490
    //   1108: iconst_0
    //   1109: anewarray 4	java/lang/Object
    //   1112: invokestatic 239	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1115: getstatic 245	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1118: ldc2_w 246
    //   1121: ldc2_w 491
    //   1124: lconst_1
    //   1125: iconst_1
    //   1126: invokevirtual 252	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   1129: goto -733 -> 396
    //   1132: astore 13
    //   1134: ldc 231
    //   1136: aload 13
    //   1138: ldc_w 494
    //   1141: iconst_0
    //   1142: anewarray 4	java/lang/Object
    //   1145: invokestatic 239	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1148: aload_0
    //   1149: invokevirtual 488	java/io/RandomAccessFile:close	()V
    //   1152: goto -551 -> 601
    //   1155: astore 8
    //   1157: aload_0
    //   1158: invokevirtual 488	java/io/RandomAccessFile:close	()V
    //   1161: aload 8
    //   1163: athrow
    //   1164: astore 8
    //   1166: ldc 231
    //   1168: aload 8
    //   1170: ldc_w 496
    //   1173: iconst_0
    //   1174: anewarray 4	java/lang/Object
    //   1177: invokestatic 239	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1180: getstatic 245	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1183: ldc2_w 246
    //   1186: ldc2_w 497
    //   1189: lconst_1
    //   1190: iconst_1
    //   1191: invokevirtual 252	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   1194: ldc 231
    //   1196: ldc_w 500
    //   1199: iconst_2
    //   1200: anewarray 4	java/lang/Object
    //   1203: dup
    //   1204: iconst_0
    //   1205: getstatic 84	com/tencent/mm/app/a:bnX	Ljava/lang/String;
    //   1208: aastore
    //   1209: dup
    //   1210: iconst_1
    //   1211: aload_0
    //   1212: aastore
    //   1213: invokestatic 272	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1216: aload 11
    //   1218: ldc_w 502
    //   1221: aload_0
    //   1222: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1225: pop
    //   1226: aload 11
    //   1228: ldc_w 504
    //   1231: new 104	java/lang/Integer
    //   1234: dup
    //   1235: getstatic 72	com/tencent/mm/app/a:bvL	I
    //   1238: invokespecial 107	java/lang/Integer:<init>	(I)V
    //   1241: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1244: pop
    //   1245: iconst_0
    //   1246: istore_1
    //   1247: new 506	java/io/File
    //   1250: dup
    //   1251: getstatic 511	com/tencent/mm/storage/ac:dOP	Ljava/lang/String;
    //   1254: invokespecial 512	java/io/File:<init>	(Ljava/lang/String;)V
    //   1257: invokevirtual 515	java/io/File:exists	()Z
    //   1260: ifeq +23 -> 1283
    //   1263: invokestatic 298	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   1266: ldc_w 517
    //   1269: iconst_4
    //   1270: invokevirtual 521	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1273: ldc_w 523
    //   1276: iconst_0
    //   1277: invokeinterface 529 3 0
    //   1282: istore_1
    //   1283: aload 10
    //   1285: ldc_w 531
    //   1288: new 329	java/lang/Long
    //   1291: dup
    //   1292: iload_1
    //   1293: i2l
    //   1294: invokespecial 532	java/lang/Long:<init>	(J)V
    //   1297: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1300: pop
    //   1301: aload 10
    //   1303: ldc_w 534
    //   1306: getstatic 84	com/tencent/mm/app/a:bnX	Ljava/lang/String;
    //   1309: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1312: pop
    //   1313: aload 10
    //   1315: ldc_w 504
    //   1318: new 329	java/lang/Long
    //   1321: dup
    //   1322: invokestatic 539	java/lang/System:currentTimeMillis	()J
    //   1325: invokespecial 532	java/lang/Long:<init>	(J)V
    //   1328: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1331: pop
    //   1332: aload 10
    //   1334: ldc_w 541
    //   1337: new 104	java/lang/Integer
    //   1340: dup
    //   1341: getstatic 546	com/tencent/mm/protocal/d:spa	I
    //   1344: invokespecial 107	java/lang/Integer:<init>	(I)V
    //   1347: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1350: pop
    //   1351: aload 10
    //   1353: ldc_w 548
    //   1356: invokestatic 553	com/tencent/mm/loader/a/a:EO	()Ljava/lang/String;
    //   1359: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1362: pop
    //   1363: getstatic 245	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1366: ldc2_w 246
    //   1369: ldc2_w 554
    //   1372: lconst_1
    //   1373: iconst_1
    //   1374: invokevirtual 252	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   1377: goto -981 -> 396
    //   1380: aload 8
    //   1382: astore_0
    //   1383: goto -947 -> 436
    //   1386: iload_1
    //   1387: iconst_1
    //   1388: iadd
    //   1389: istore_1
    //   1390: goto -1064 -> 326
    //   1393: iload_1
    //   1394: iconst_1
    //   1395: iadd
    //   1396: istore_1
    //   1397: goto -366 -> 1031
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1400	0	parama	a.a
    //   325	1072	1	i	int
    //   323	711	2	j	int
    //   489	60	3	k	int
    //   584	509	4	l1	long
    //   1078	10	6	l2	long
    //   16	972	8	localObject1	Object
    //   1155	7	8	localObject2	Object
    //   1164	217	8	localException1	java.lang.Exception
    //   7	397	9	localJSONObject1	org.json.JSONObject
    //   102	1250	10	localJSONObject2	org.json.JSONObject
    //   140	1087	11	localJSONObject3	org.json.JSONObject
    //   214	687	12	localObject3	Object
    //   224	844	13	localObject4	Object
    //   1132	5	13	localException2	java.lang.Exception
    //   318	739	14	localObject5	Object
    //   335	581	15	locala1	com.tencent.mm.storage.ac.a
    //   870	51	16	locala2	com.tencent.mm.storage.ac.a
    //   875	51	17	locala3	com.tencent.mm.storage.ac.a
    //   880	52	18	locala4	com.tencent.mm.storage.ac.a
    //   949	7	19	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	196	369	org/json/JSONException
    //   196	236	369	org/json/JSONException
    //   241	324	369	org/json/JSONException
    //   342	353	369	org/json/JSONException
    //   356	366	369	org/json/JSONException
    //   469	583	369	org/json/JSONException
    //   586	601	369	org/json/JSONException
    //   601	758	369	org/json/JSONException
    //   762	767	369	org/json/JSONException
    //   777	825	369	org/json/JSONException
    //   825	882	369	org/json/JSONException
    //   893	983	369	org/json/JSONException
    //   993	1007	369	org/json/JSONException
    //   1094	1098	369	org/json/JSONException
    //   1148	1152	369	org/json/JSONException
    //   1157	1164	369	org/json/JSONException
    //   1166	1194	369	org/json/JSONException
    //   1194	1226	369	org/json/JSONException
    //   1226	1245	369	org/json/JSONException
    //   1247	1283	369	org/json/JSONException
    //   1283	1377	369	org/json/JSONException
    //   9	196	1101	java/lang/Exception
    //   196	236	1101	java/lang/Exception
    //   241	324	1101	java/lang/Exception
    //   342	353	1101	java/lang/Exception
    //   356	366	1101	java/lang/Exception
    //   469	583	1101	java/lang/Exception
    //   586	601	1101	java/lang/Exception
    //   601	758	1101	java/lang/Exception
    //   762	767	1101	java/lang/Exception
    //   777	825	1101	java/lang/Exception
    //   825	882	1101	java/lang/Exception
    //   993	1007	1101	java/lang/Exception
    //   1094	1098	1101	java/lang/Exception
    //   1148	1152	1101	java/lang/Exception
    //   1157	1164	1101	java/lang/Exception
    //   1166	1194	1101	java/lang/Exception
    //   1194	1226	1101	java/lang/Exception
    //   1226	1245	1101	java/lang/Exception
    //   1247	1283	1101	java/lang/Exception
    //   1283	1377	1101	java/lang/Exception
    //   1007	1029	1132	java/lang/Exception
    //   1054	1064	1132	java/lang/Exception
    //   1067	1080	1132	java/lang/Exception
    //   1007	1029	1155	finally
    //   1054	1064	1155	finally
    //   1067	1080	1155	finally
    //   1134	1148	1155	finally
    //   893	983	1164	java/lang/Exception
  }
  
  public static void cg(String paramString)
  {
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("system_config_prefs", 4);
    int n = localSharedPreferences.getInt("main_thread_watch_enable", 65535);
    int j = localSharedPreferences.getInt("main_thread_watch_timeout", 0);
    int k = localSharedPreferences.getInt("main_thread_watch_log_loop", 0);
    int i1 = localSharedPreferences.getInt("main_thread_watch_report", 0);
    int m = k;
    int i = j;
    if (n(paramString, n))
    {
      i = j;
      if (j <= 0) {
        i = 4500;
      }
      j = k;
      if (k <= 0) {
        j = 500;
      }
      if (bvQ != null) {
        bvQ.interrupt();
      }
      bnX = paramString;
      if (i > 0) {
        bvL = i;
      }
      if (j > 0) {
        bvM = j;
      }
      bvQ = e.b(new a.c(), paramString + "_ANRWatchDog");
      if (bvK == null) {
        bvK = new Handler(Looper.getMainLooper());
      }
      bvQ.start();
      y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch sProcessName[%s], sTimeoutInterval[%d], logLoop[%d], sWatchThread[%s], stack[%s]", new Object[] { bnX, Integer.valueOf(bvL), Integer.valueOf(bvM), bvQ.getName(), bk.csb() });
      m = j;
    }
    y.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch processName[%s] enable[%d], timeout[%d], loop[%d], report[%d]", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(i1) });
  }
  
  private static boolean n(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return false;
                  if (!paramString.equals(ae.getPackageName())) {
                    break;
                  }
                  bvD = 1;
                } while ((paramInt & 0x1) == 0);
                return true;
                if (!paramString.endsWith(":push")) {
                  break;
                }
                bvD = 2;
              } while ((paramInt & 0x2) == 0);
              return true;
              if ((!paramString.endsWith(":tools")) && (!paramString.endsWith(":toolsmp"))) {
                break;
              }
              bvD = 4;
            } while ((paramInt & 0x4) == 0);
            return true;
            if (!paramString.endsWith(":sandbox")) {
              break;
            }
            bvD = 8;
          } while ((paramInt & 0x8) == 0);
          return true;
          if (!paramString.endsWith(":exdevice")) {
            break;
          }
          bvD = 16;
        } while ((paramInt & 0x10) == 0);
        return true;
      } while (!paramString.contains(":appbrand"));
      bvD = 32;
    } while ((paramInt & 0x20) == 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.a
 * JD-Core Version:    0.7.0.1
 */