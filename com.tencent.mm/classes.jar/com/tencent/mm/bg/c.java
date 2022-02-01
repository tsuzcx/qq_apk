package com.tencent.mm.bg;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.ah.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

public final class c
{
  private static c lYH;
  private QueueWorkerThread lYI = null;
  
  public static String WO(String paramString)
  {
    AppMethodBeat.i(90695);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90695);
      return null;
    }
    paramString = FilePathGenerator.genPath(a.fzI(), "remark_", g.getMessageDigest((paramString + "ZnVjaw==").getBytes()), ".png", 1);
    AppMethodBeat.o(90695);
    return paramString;
  }
  
  public static boolean WP(String paramString)
  {
    AppMethodBeat.i(90696);
    String str = WO(paramString);
    Log.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = new q(str).ifE();
    AppMethodBeat.o(90696);
    return bool;
  }
  
  public static boolean WQ(String paramString)
  {
    AppMethodBeat.i(90697);
    String str = WO(paramString);
    Log.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = u.deleteFile(str);
    AppMethodBeat.o(90697);
    return bool;
  }
  
  public static Bitmap WR(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(90698);
    paramString = BitmapUtil.getBitmapNative(WO(paramString), 0, 0);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (!paramString.isRecycled()) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(90698);
      return paramString;
    }
    AppMethodBeat.o(90698);
    return null;
  }
  
  public static c bnY()
  {
    AppMethodBeat.i(90694);
    if (lYH == null) {
      lYH = new c();
    }
    c localc = lYH;
    AppMethodBeat.o(90694);
    return localc;
  }
  
  public final void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(90699);
    if ((!Util.isNullOrNil(paramString2)) && (!WP(paramString1)))
    {
      if ((this.lYI == null) || (this.lYI.isDead())) {
        this.lYI = new QueueWorkerThread(1, "download-remark-img", 1);
      }
      this.lYI.add(new b(paramString1, paramString2, parama));
    }
    AppMethodBeat.o(90699);
  }
  
  public static abstract interface a
  {
    public abstract void gu(boolean paramBoolean);
  }
  
  final class b
    implements QueueWorkerThread.ThreadObject
  {
    private String fullPath;
    private String imageUrl;
    private c.a lYJ;
    private boolean success = false;
    private String username;
    
    public b(String paramString1, String paramString2, c.a parama)
    {
      this.username = paramString1;
      this.imageUrl = paramString2;
      this.lYJ = parama;
    }
    
    /* Error */
    public final boolean doInBackground()
    {
      // Byte code:
      //   0: ldc 40
      //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 30	com/tencent/mm/bg/c$b:username	Ljava/lang/String;
      //   9: invokestatic 52	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifeq +10 -> 22
      //   15: ldc 40
      //   17: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   20: iconst_0
      //   21: ireturn
      //   22: aload_0
      //   23: aload_0
      //   24: getfield 30	com/tencent/mm/bg/c$b:username	Ljava/lang/String;
      //   27: invokestatic 59	com/tencent/mm/bg/c:WO	(Ljava/lang/String;)Ljava/lang/String;
      //   30: putfield 61	com/tencent/mm/bg/c$b:fullPath	Ljava/lang/String;
      //   33: invokestatic 67	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
      //   36: invokevirtual 72	com/tencent/mm/kernel/b:aGM	()Z
      //   39: ifeq +904 -> 943
      //   42: new 74	java/lang/StringBuilder
      //   45: dup
      //   46: ldc 76
      //   48: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   51: getstatic 85	com/tencent/mm/plugin/messenger/b$d:host_weixin_qq_com	I
      //   54: invokestatic 91	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
      //   57: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   60: ldc 97
      //   62: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   65: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   68: astore_2
      //   69: getstatic 106	com/tencent/mm/protocal/d:RAD	I
      //   72: istore_1
      //   73: invokestatic 67	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
      //   76: pop
      //   77: aload_2
      //   78: iconst_4
      //   79: anewarray 4	java/lang/Object
      //   82: dup
      //   83: iconst_0
      //   84: iload_1
      //   85: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   88: aastore
      //   89: dup
      //   90: iconst_1
      //   91: invokestatic 116	com/tencent/mm/kernel/b:getUin	()I
      //   94: invokestatic 121	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
      //   97: aastore
      //   98: dup
      //   99: iconst_2
      //   100: invokestatic 127	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   103: invokestatic 133	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetTypeForStat	(Landroid/content/Context;)I
      //   106: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   109: aastore
      //   110: dup
      //   111: iconst_3
      //   112: getstatic 139	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
      //   115: invokevirtual 144	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getCompatMixStrength	()I
      //   118: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   121: aastore
      //   122: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   125: astore_2
      //   126: ldc 152
      //   128: ldc 154
      //   130: iconst_3
      //   131: anewarray 4	java/lang/Object
      //   134: dup
      //   135: iconst_0
      //   136: aload_0
      //   137: getfield 30	com/tencent/mm/bg/c$b:username	Ljava/lang/String;
      //   140: aastore
      //   141: dup
      //   142: iconst_1
      //   143: aload_2
      //   144: aastore
      //   145: dup
      //   146: iconst_2
      //   147: aload_0
      //   148: getfield 32	com/tencent/mm/bg/c$b:imageUrl	Ljava/lang/String;
      //   151: aastore
      //   152: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   155: aload_0
      //   156: iconst_0
      //   157: putfield 28	com/tencent/mm/bg/c$b:success	Z
      //   160: ldc 162
      //   162: invokestatic 166	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   165: checkcast 162	com/tencent/mm/plugin/expt/b/b
      //   168: getstatic 172	com/tencent/mm/plugin/expt/b/b$a:vUw	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   171: iconst_0
      //   172: invokeinterface 176 3 0
      //   177: pop
      //   178: aload_0
      //   179: getfield 32	com/tencent/mm/bg/c$b:imageUrl	Ljava/lang/String;
      //   182: aconst_null
      //   183: invokestatic 181	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
      //   186: astore 5
      //   188: aload 5
      //   190: astore_3
      //   191: aload_0
      //   192: getfield 32	com/tencent/mm/bg/c$b:imageUrl	Ljava/lang/String;
      //   195: invokestatic 185	com/tencent/mm/network/d:Zq	(Ljava/lang/String;)Lcom/tencent/mm/network/z;
      //   198: astore 4
      //   200: aload 4
      //   202: astore_3
      //   203: aload 4
      //   205: astore 5
      //   207: aload 4
      //   209: ldc 187
      //   211: invokeinterface 192 2 0
      //   216: aload 4
      //   218: astore_3
      //   219: aload 4
      //   221: astore 5
      //   223: aload 4
      //   225: ldc 194
      //   227: aload_2
      //   228: invokeinterface 198 3 0
      //   233: aload 4
      //   235: astore_3
      //   236: aload 4
      //   238: astore 5
      //   240: aload 4
      //   242: sipush 5000
      //   245: invokeinterface 201 2 0
      //   250: aload 4
      //   252: astore_3
      //   253: aload 4
      //   255: astore 5
      //   257: aload 4
      //   259: sipush 5000
      //   262: invokeinterface 204 2 0
      //   267: aload 4
      //   269: astore_3
      //   270: aload 4
      //   272: astore 5
      //   274: aload 4
      //   276: checkcast 206	com/tencent/mm/network/z
      //   279: sipush 1196
      //   282: putfield 209	com/tencent/mm/network/z:mvT	I
      //   285: aload 4
      //   287: astore_3
      //   288: aload 4
      //   290: astore 5
      //   292: aload 4
      //   294: invokestatic 212	com/tencent/mm/network/d:a	(Lcom/tencent/mm/network/y;)I
      //   297: ifeq +64 -> 361
      //   300: aload 4
      //   302: astore_3
      //   303: aload 4
      //   305: astore 5
      //   307: ldc 152
      //   309: ldc 214
      //   311: iconst_1
      //   312: anewarray 4	java/lang/Object
      //   315: dup
      //   316: iconst_0
      //   317: aload_0
      //   318: getfield 32	com/tencent/mm/bg/c$b:imageUrl	Ljava/lang/String;
      //   321: aastore
      //   322: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   325: aload 4
      //   327: invokeinterface 220 1 0
      //   332: ldc 40
      //   334: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   337: iconst_1
      //   338: ireturn
      //   339: astore_2
      //   340: ldc 152
      //   342: ldc 222
      //   344: iconst_1
      //   345: anewarray 4	java/lang/Object
      //   348: dup
      //   349: iconst_0
      //   350: aload_2
      //   351: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   354: aastore
      //   355: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   358: goto -26 -> 332
      //   361: aload 4
      //   363: astore_3
      //   364: aload 4
      //   366: astore 5
      //   368: aload 4
      //   370: invokeinterface 230 1 0
      //   375: astore_2
      //   376: aload_2
      //   377: astore 5
      //   379: aload 5
      //   381: ifnonnull +89 -> 470
      //   384: ldc 152
      //   386: ldc 232
      //   388: iconst_1
      //   389: anewarray 4	java/lang/Object
      //   392: dup
      //   393: iconst_0
      //   394: aload_0
      //   395: getfield 32	com/tencent/mm/bg/c$b:imageUrl	Ljava/lang/String;
      //   398: aastore
      //   399: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   402: aload 4
      //   404: invokeinterface 220 1 0
      //   409: aload 5
      //   411: ifnull +8 -> 419
      //   414: aload 5
      //   416: invokevirtual 237	java/io/InputStream:close	()V
      //   419: ldc 40
      //   421: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   424: iconst_1
      //   425: ireturn
      //   426: astore_2
      //   427: ldc 152
      //   429: ldc 222
      //   431: iconst_1
      //   432: anewarray 4	java/lang/Object
      //   435: dup
      //   436: iconst_0
      //   437: aload_2
      //   438: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   441: aastore
      //   442: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   445: goto -36 -> 409
      //   448: astore_2
      //   449: ldc 152
      //   451: ldc 222
      //   453: iconst_1
      //   454: anewarray 4	java/lang/Object
      //   457: dup
      //   458: iconst_0
      //   459: aload_2
      //   460: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   463: aastore
      //   464: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   467: goto -48 -> 419
      //   470: sipush 1024
      //   473: newarray byte
      //   475: astore_3
      //   476: new 74	java/lang/StringBuilder
      //   479: dup
      //   480: invokespecial 238	java/lang/StringBuilder:<init>	()V
      //   483: aload_0
      //   484: getfield 61	com/tencent/mm/bg/c$b:fullPath	Ljava/lang/String;
      //   487: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   490: ldc 240
      //   492: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   495: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   498: invokestatic 246	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
      //   501: astore_2
      //   502: aload 5
      //   504: aload_3
      //   505: invokevirtual 250	java/io/InputStream:read	([B)I
      //   508: istore_1
      //   509: iload_1
      //   510: iconst_m1
      //   511: if_icmpeq +80 -> 591
      //   514: aload_2
      //   515: aload_3
      //   516: iconst_0
      //   517: iload_1
      //   518: invokevirtual 256	java/io/OutputStream:write	([BII)V
      //   521: goto -19 -> 502
      //   524: astore 6
      //   526: aload_2
      //   527: astore_3
      //   528: aload 6
      //   530: astore_2
      //   531: ldc 152
      //   533: ldc 222
      //   535: iconst_1
      //   536: anewarray 4	java/lang/Object
      //   539: dup
      //   540: iconst_0
      //   541: aload_2
      //   542: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   545: aastore
      //   546: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   549: aload_0
      //   550: iconst_0
      //   551: putfield 28	com/tencent/mm/bg/c$b:success	Z
      //   554: aload 4
      //   556: ifnull +10 -> 566
      //   559: aload 4
      //   561: invokeinterface 220 1 0
      //   566: aload 5
      //   568: ifnull +8 -> 576
      //   571: aload 5
      //   573: invokevirtual 237	java/io/InputStream:close	()V
      //   576: aload_3
      //   577: ifnull +7 -> 584
      //   580: aload_3
      //   581: invokevirtual 257	java/io/OutputStream:close	()V
      //   584: ldc 40
      //   586: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   589: iconst_1
      //   590: ireturn
      //   591: aload_0
      //   592: iconst_1
      //   593: putfield 28	com/tencent/mm/bg/c$b:success	Z
      //   596: aload 4
      //   598: invokeinterface 220 1 0
      //   603: aload 5
      //   605: ifnull +8 -> 613
      //   608: aload 5
      //   610: invokevirtual 237	java/io/InputStream:close	()V
      //   613: aload_2
      //   614: ifnull -30 -> 584
      //   617: aload_2
      //   618: invokevirtual 257	java/io/OutputStream:close	()V
      //   621: goto -37 -> 584
      //   624: astore_2
      //   625: ldc 152
      //   627: ldc 222
      //   629: iconst_1
      //   630: anewarray 4	java/lang/Object
      //   633: dup
      //   634: iconst_0
      //   635: aload_2
      //   636: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   639: aastore
      //   640: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   643: goto -59 -> 584
      //   646: astore_3
      //   647: ldc 152
      //   649: ldc 222
      //   651: iconst_1
      //   652: anewarray 4	java/lang/Object
      //   655: dup
      //   656: iconst_0
      //   657: aload_3
      //   658: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   661: aastore
      //   662: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   665: goto -62 -> 603
      //   668: astore_3
      //   669: ldc 152
      //   671: ldc 222
      //   673: iconst_1
      //   674: anewarray 4	java/lang/Object
      //   677: dup
      //   678: iconst_0
      //   679: aload_3
      //   680: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   683: aastore
      //   684: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   687: goto -74 -> 613
      //   690: astore_2
      //   691: ldc 152
      //   693: ldc 222
      //   695: iconst_1
      //   696: anewarray 4	java/lang/Object
      //   699: dup
      //   700: iconst_0
      //   701: aload_2
      //   702: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   705: aastore
      //   706: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   709: goto -143 -> 566
      //   712: astore_2
      //   713: ldc 152
      //   715: ldc 222
      //   717: iconst_1
      //   718: anewarray 4	java/lang/Object
      //   721: dup
      //   722: iconst_0
      //   723: aload_2
      //   724: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   727: aastore
      //   728: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   731: goto -155 -> 576
      //   734: astore_2
      //   735: ldc 152
      //   737: ldc 222
      //   739: iconst_1
      //   740: anewarray 4	java/lang/Object
      //   743: dup
      //   744: iconst_0
      //   745: aload_2
      //   746: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   749: aastore
      //   750: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   753: goto -169 -> 584
      //   756: astore_2
      //   757: aconst_null
      //   758: astore 5
      //   760: aconst_null
      //   761: astore_3
      //   762: aconst_null
      //   763: astore 4
      //   765: aload 4
      //   767: ifnull +10 -> 777
      //   770: aload 4
      //   772: invokeinterface 220 1 0
      //   777: aload 5
      //   779: ifnull +8 -> 787
      //   782: aload 5
      //   784: invokevirtual 237	java/io/InputStream:close	()V
      //   787: aload_3
      //   788: ifnull +7 -> 795
      //   791: aload_3
      //   792: invokevirtual 257	java/io/OutputStream:close	()V
      //   795: ldc 40
      //   797: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   800: aload_2
      //   801: athrow
      //   802: astore 4
      //   804: ldc 152
      //   806: ldc 222
      //   808: iconst_1
      //   809: anewarray 4	java/lang/Object
      //   812: dup
      //   813: iconst_0
      //   814: aload 4
      //   816: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   819: aastore
      //   820: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   823: goto -46 -> 777
      //   826: astore 4
      //   828: ldc 152
      //   830: ldc 222
      //   832: iconst_1
      //   833: anewarray 4	java/lang/Object
      //   836: dup
      //   837: iconst_0
      //   838: aload 4
      //   840: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   843: aastore
      //   844: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   847: goto -60 -> 787
      //   850: astore_3
      //   851: ldc 152
      //   853: ldc 222
      //   855: iconst_1
      //   856: anewarray 4	java/lang/Object
      //   859: dup
      //   860: iconst_0
      //   861: aload_3
      //   862: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   865: aastore
      //   866: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   869: goto -74 -> 795
      //   872: astore_2
      //   873: aconst_null
      //   874: astore 5
      //   876: aconst_null
      //   877: astore 6
      //   879: aload_3
      //   880: astore 4
      //   882: aload 6
      //   884: astore_3
      //   885: goto -120 -> 765
      //   888: astore_2
      //   889: aconst_null
      //   890: astore_3
      //   891: goto -126 -> 765
      //   894: astore 6
      //   896: aload_2
      //   897: astore_3
      //   898: aload 6
      //   900: astore_2
      //   901: goto -136 -> 765
      //   904: astore_2
      //   905: goto -140 -> 765
      //   908: astore_2
      //   909: aconst_null
      //   910: astore 5
      //   912: aconst_null
      //   913: astore_3
      //   914: aconst_null
      //   915: astore 4
      //   917: goto -386 -> 531
      //   920: astore_2
      //   921: aconst_null
      //   922: astore 6
      //   924: aconst_null
      //   925: astore_3
      //   926: aload 5
      //   928: astore 4
      //   930: aload 6
      //   932: astore 5
      //   934: goto -403 -> 531
      //   937: astore_2
      //   938: aconst_null
      //   939: astore_3
      //   940: goto -409 -> 531
      //   943: ldc_w 259
      //   946: astore_2
      //   947: goto -821 -> 126
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	950	0	this	b
      //   72	446	1	i	int
      //   68	160	2	str1	String
      //   339	12	2	localException1	java.lang.Exception
      //   375	2	2	localInputStream	java.io.InputStream
      //   426	12	2	localException2	java.lang.Exception
      //   448	12	2	localException3	java.lang.Exception
      //   501	117	2	localObject1	Object
      //   624	12	2	localException4	java.lang.Exception
      //   690	12	2	localException5	java.lang.Exception
      //   712	12	2	localException6	java.lang.Exception
      //   734	12	2	localException7	java.lang.Exception
      //   756	45	2	localObject2	Object
      //   872	1	2	localObject3	Object
      //   888	9	2	localObject4	Object
      //   900	1	2	localObject5	Object
      //   904	1	2	localObject6	Object
      //   908	1	2	localException8	java.lang.Exception
      //   920	1	2	localException9	java.lang.Exception
      //   937	1	2	localException10	java.lang.Exception
      //   946	1	2	str2	String
      //   190	391	3	localObject7	Object
      //   646	12	3	localException11	java.lang.Exception
      //   668	12	3	localException12	java.lang.Exception
      //   761	31	3	localObject8	Object
      //   850	30	3	localException13	java.lang.Exception
      //   884	56	3	localObject9	Object
      //   198	573	4	localz	com.tencent.mm.network.z
      //   802	13	4	localException14	java.lang.Exception
      //   826	13	4	localException15	java.lang.Exception
      //   880	49	4	localObject10	Object
      //   186	747	5	localObject11	Object
      //   524	5	6	localException16	java.lang.Exception
      //   877	6	6	localObject12	Object
      //   894	5	6	localObject13	Object
      //   922	9	6	localObject14	Object
      // Exception table:
      //   from	to	target	type
      //   325	332	339	java/lang/Exception
      //   402	409	426	java/lang/Exception
      //   414	419	448	java/lang/Exception
      //   502	509	524	java/lang/Exception
      //   514	521	524	java/lang/Exception
      //   591	596	524	java/lang/Exception
      //   617	621	624	java/lang/Exception
      //   596	603	646	java/lang/Exception
      //   608	613	668	java/lang/Exception
      //   559	566	690	java/lang/Exception
      //   571	576	712	java/lang/Exception
      //   580	584	734	java/lang/Exception
      //   160	188	756	finally
      //   770	777	802	java/lang/Exception
      //   782	787	826	java/lang/Exception
      //   791	795	850	java/lang/Exception
      //   191	200	872	finally
      //   207	216	872	finally
      //   223	233	872	finally
      //   240	250	872	finally
      //   257	267	872	finally
      //   274	285	872	finally
      //   292	300	872	finally
      //   307	325	872	finally
      //   368	376	872	finally
      //   384	402	888	finally
      //   470	502	888	finally
      //   502	509	894	finally
      //   514	521	894	finally
      //   591	596	894	finally
      //   531	554	904	finally
      //   160	188	908	java/lang/Exception
      //   191	200	920	java/lang/Exception
      //   207	216	920	java/lang/Exception
      //   223	233	920	java/lang/Exception
      //   240	250	920	java/lang/Exception
      //   257	267	920	java/lang/Exception
      //   274	285	920	java/lang/Exception
      //   292	300	920	java/lang/Exception
      //   307	325	920	java/lang/Exception
      //   368	376	920	java/lang/Exception
      //   384	402	937	java/lang/Exception
      //   470	502	937	java/lang/Exception
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(90693);
      if (!this.success)
      {
        this.lYJ.gu(false);
        AppMethodBeat.o(90693);
        return false;
      }
      u.deleteFile(this.fullPath);
      new q(this.fullPath + ".tmp").aj(new q(this.fullPath));
      this.lYJ.gu(true);
      AppMethodBeat.o(90693);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bg.c
 * JD-Core Version:    0.7.0.1
 */