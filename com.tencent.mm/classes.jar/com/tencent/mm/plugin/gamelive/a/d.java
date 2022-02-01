package com.tencent.mm.plugin.gamelive.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.b;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/audio/GameLiveMainAudioMgrService;", "Lcom/tencent/mm/plugin/gamelive/audio/IGameLiveMainAudioMgrService;", "()V", "audioTask", "Ljava/lang/Runnable;", "getAudioTask", "()Ljava/lang/Runnable;", "forkExecutorService", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "kotlin.jvm.PlatformType", "reconnecting", "", "reconnect", "", "start", "stop", "Companion", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements f
{
  public static final d.a Jff;
  public static boolean Jfi;
  public final b Jes;
  public volatile boolean Jfg;
  public final Runnable Jfh;
  
  static
  {
    AppMethodBeat.i(277539);
    Jff = new d.a((byte)0);
    Jfi = true;
    AppMethodBeat.o(277539);
  }
  
  public d()
  {
    AppMethodBeat.i(277504);
    this.Jes = h.ahAA.bFR("gamelive_audio_mix_ipc_main");
    this.Jfh = ((Runnable)new b(this));
    AppMethodBeat.o(277504);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(277511);
    Jfi = false;
    Log.i("MicroMsg.GameLiveMainAudioMgrService", "stop main audio");
    AppMethodBeat.o(277511);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelive/audio/GameLiveMainAudioMgrService$audioTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: ldc 36
      //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 31	com/tencent/mm/plugin/gamelive/a/d$b:Jfj	Lcom/tencent/mm/plugin/gamelive/a/d;
      //   11: invokestatic 45	com/tencent/mm/plugin/gamelive/a/d:a	(Lcom/tencent/mm/plugin/gamelive/a/d;)V
      //   14: invokestatic 51	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
      //   17: pop
      //   18: ldc 53
      //   20: invokestatic 59	com/tencent/mm/kernel/b:getUin	()I
      //   23: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   26: invokestatic 71	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   29: astore_3
      //   30: getstatic 77	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   33: astore 4
      //   35: aload_3
      //   36: ifnonnull +20 -> 56
      //   39: new 79	java/lang/NullPointerException
      //   42: dup
      //   43: ldc 81
      //   45: invokespecial 84	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
      //   48: astore_3
      //   49: ldc 36
      //   51: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: aload_3
      //   55: athrow
      //   56: aload_3
      //   57: aload 4
      //   59: invokevirtual 93	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   62: astore_3
      //   63: aload_3
      //   64: ldc 95
      //   66: invokestatic 99	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   69: aload_3
      //   70: invokestatic 105	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
      //   73: astore_3
      //   74: ldc 107
      //   76: ldc 109
      //   78: aload_3
      //   79: invokestatic 71	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   82: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   85: new 116	android/net/LocalSocket
      //   88: dup
      //   89: invokespecial 117	android/net/LocalSocket:<init>	()V
      //   92: astore 7
      //   94: new 119	android/net/LocalSocketAddress
      //   97: dup
      //   98: aload_3
      //   99: getstatic 125	android/net/LocalSocketAddress$Namespace:ABSTRACT	Landroid/net/LocalSocketAddress$Namespace;
      //   102: invokespecial 128	android/net/LocalSocketAddress:<init>	(Ljava/lang/String;Landroid/net/LocalSocketAddress$Namespace;)V
      //   105: astore_3
      //   106: ldc 130
      //   108: invokestatic 134	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   111: checkcast 130	com/tencent/d/a/a/a/b
      //   114: astore 8
      //   116: aload 7
      //   118: aload_3
      //   119: invokevirtual 138	android/net/LocalSocket:connect	(Landroid/net/LocalSocketAddress;)V
      //   122: ldc 107
      //   124: ldc 140
      //   126: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   129: aconst_null
      //   130: astore_3
      //   131: aconst_null
      //   132: astore 6
      //   134: new 142	java/io/ObjectInputStream
      //   137: dup
      //   138: aload 7
      //   140: invokevirtual 146	android/net/LocalSocket:getInputStream	()Ljava/io/InputStream;
      //   143: invokespecial 149	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   146: astore 4
      //   148: aload 4
      //   150: invokevirtual 153	java/io/ObjectInputStream:readUnshared	()Ljava/lang/Object;
      //   153: astore_3
      //   154: aload_3
      //   155: ifnonnull +242 -> 397
      //   158: new 79	java/lang/NullPointerException
      //   161: dup
      //   162: ldc 155
      //   164: invokespecial 84	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
      //   167: astore_3
      //   168: ldc 36
      //   170: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   173: aload_3
      //   174: athrow
      //   175: astore 5
      //   177: aload 4
      //   179: astore_3
      //   180: aload 5
      //   182: instanceof 157
      //   185: ifeq +268 -> 453
      //   188: aload 4
      //   190: astore_3
      //   191: getstatic 161	com/tencent/mm/plugin/gamelive/a/d:Jff	Lcom/tencent/mm/plugin/gamelive/a/d$a;
      //   194: astore 5
      //   196: aload 4
      //   198: astore_3
      //   199: invokestatic 165	com/tencent/mm/plugin/gamelive/a/d:fIU	()Z
      //   202: ifeq +81 -> 283
      //   205: aload 4
      //   207: astore_3
      //   208: aload_0
      //   209: getfield 31	com/tencent/mm/plugin/gamelive/a/d$b:Jfj	Lcom/tencent/mm/plugin/gamelive/a/d;
      //   212: invokestatic 169	com/tencent/mm/plugin/gamelive/a/d:b	(Lcom/tencent/mm/plugin/gamelive/a/d;)Z
      //   215: ifne +68 -> 283
      //   218: aload 4
      //   220: astore_3
      //   221: ldc 107
      //   223: ldc 171
      //   225: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   228: aload 4
      //   230: astore_3
      //   231: aload 8
      //   233: iconst_1
      //   234: invokestatic 180	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   237: invokeinterface 184 3 0
      //   242: aload 4
      //   244: astore_3
      //   245: ldc 186
      //   247: invokestatic 134	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   250: checkcast 186	com/tencent/mm/plugin/gamelive/PluginGameLive
      //   253: getstatic 192	com/tencent/mm/plugin/gamelive/PluginGameLive$b:Jdy	Lcom/tencent/mm/plugin/gamelive/PluginGameLive$b;
      //   256: invokevirtual 196	com/tencent/mm/plugin/gamelive/PluginGameLive:setGameLiveCurrentState_$plugin_gamelive_release	(Lcom/tencent/mm/plugin/gamelive/PluginGameLive$b;)V
      //   259: aload 4
      //   261: astore_3
      //   262: ldc 186
      //   264: invokestatic 134	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   267: checkcast 186	com/tencent/mm/plugin/gamelive/PluginGameLive
      //   270: invokevirtual 200	com/tencent/mm/plugin/gamelive/PluginGameLive:getMainProcessService$plugin_gamelive_release	()Lcom/tencent/mm/plugin/gamelive/a;
      //   273: ifnull +10 -> 283
      //   276: aload 4
      //   278: astore_3
      //   279: iconst_0
      //   280: invokestatic 206	com/tencent/mm/plugin/gamelive/a:wD	(Z)V
      //   283: aload 4
      //   285: astore_3
      //   286: ldc 107
      //   288: ldc 208
      //   290: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   293: aload 4
      //   295: ifnull +8 -> 303
      //   298: aload 4
      //   300: invokevirtual 211	java/io/ObjectInputStream:close	()V
      //   303: aload 7
      //   305: invokevirtual 212	android/net/LocalSocket:close	()V
      //   308: ldc 107
      //   310: ldc 214
      //   312: aload_0
      //   313: getfield 31	com/tencent/mm/plugin/gamelive/a/d$b:Jfj	Lcom/tencent/mm/plugin/gamelive/a/d;
      //   316: invokestatic 169	com/tencent/mm/plugin/gamelive/a/d:b	(Lcom/tencent/mm/plugin/gamelive/a/d;)Z
      //   319: invokestatic 219	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   322: invokestatic 71	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   325: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   328: aload_0
      //   329: getfield 31	com/tencent/mm/plugin/gamelive/a/d$b:Jfj	Lcom/tencent/mm/plugin/gamelive/a/d;
      //   332: invokestatic 169	com/tencent/mm/plugin/gamelive/a/d:b	(Lcom/tencent/mm/plugin/gamelive/a/d;)Z
      //   335: ifeq +17 -> 352
      //   338: aload_0
      //   339: getfield 31	com/tencent/mm/plugin/gamelive/a/d$b:Jfj	Lcom/tencent/mm/plugin/gamelive/a/d;
      //   342: invokestatic 223	com/tencent/mm/plugin/gamelive/a/d:c	(Lcom/tencent/mm/plugin/gamelive/a/d;)Lcom/tencent/threadpool/b;
      //   345: aload_0
      //   346: checkcast 6	java/lang/Runnable
      //   349: invokevirtual 229	com/tencent/threadpool/b:execute	(Ljava/lang/Runnable;)V
      //   352: ldc 36
      //   354: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   357: return
      //   358: astore 4
      //   360: ldc 107
      //   362: ldc 231
      //   364: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   367: ldc2_w 235
      //   370: invokestatic 242	java/lang/Thread:sleep	(J)V
      //   373: iload_1
      //   374: iconst_1
      //   375: iadd
      //   376: istore_2
      //   377: iload_2
      //   378: istore_1
      //   379: iload_2
      //   380: iconst_1
      //   381: if_icmple -265 -> 116
      //   384: ldc 107
      //   386: ldc 244
      //   388: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   391: ldc 36
      //   393: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   396: return
      //   397: aload_3
      //   398: checkcast 246	com/tencent/mm/plugin/gamelive/a/g
      //   401: astore_3
      //   402: aload 8
      //   404: aload_3
      //   405: getfield 250	com/tencent/mm/plugin/gamelive/a/g:data	[B
      //   408: ldc 251
      //   410: iconst_2
      //   411: aload_3
      //   412: getfield 255	com/tencent/mm/plugin/gamelive/a/g:timestamp	J
      //   415: invokeinterface 259 6 0
      //   420: goto -272 -> 148
      //   423: astore 5
      //   425: aload 4
      //   427: astore_3
      //   428: aload 5
      //   430: astore 4
      //   432: aload_3
      //   433: ifnull +7 -> 440
      //   436: aload_3
      //   437: invokevirtual 211	java/io/ObjectInputStream:close	()V
      //   440: aload 7
      //   442: invokevirtual 212	android/net/LocalSocket:close	()V
      //   445: ldc 36
      //   447: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   450: aload 4
      //   452: athrow
      //   453: aload 4
      //   455: astore_3
      //   456: aload 5
      //   458: instanceof 261
      //   461: ifeq +17 -> 478
      //   464: aload 4
      //   466: astore_3
      //   467: ldc 107
      //   469: ldc_w 263
      //   472: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   475: goto -182 -> 293
      //   478: aload 4
      //   480: astore_3
      //   481: ldc 107
      //   483: aload 5
      //   485: checkcast 265	java/lang/Throwable
      //   488: ldc_w 267
      //   491: iconst_0
      //   492: anewarray 4	java/lang/Object
      //   495: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   498: goto -205 -> 293
      //   501: astore 5
      //   503: aload 6
      //   505: astore 4
      //   507: goto -330 -> 177
      //   510: astore 4
      //   512: goto -80 -> 432
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	515	0	this	b
      //   1	378	1	i	int
      //   376	6	2	j	int
      //   29	452	3	localObject1	Object
      //   33	266	4	localObject2	Object
      //   358	68	4	localIOException1	java.io.IOException
      //   430	76	4	localObject3	Object
      //   510	1	4	localObject4	Object
      //   175	6	5	localIOException2	java.io.IOException
      //   194	1	5	locala	d.a
      //   423	61	5	localObject5	Object
      //   501	1	5	localIOException3	java.io.IOException
      //   132	372	6	localObject6	Object
      //   92	349	7	localLocalSocket	android.net.LocalSocket
      //   114	289	8	localb	com.tencent.d.a.a.a.b
      // Exception table:
      //   from	to	target	type
      //   148	154	175	java/io/IOException
      //   158	175	175	java/io/IOException
      //   397	420	175	java/io/IOException
      //   116	129	358	java/io/IOException
      //   148	154	423	finally
      //   158	175	423	finally
      //   397	420	423	finally
      //   134	148	501	java/io/IOException
      //   134	148	510	finally
      //   180	188	510	finally
      //   191	196	510	finally
      //   199	205	510	finally
      //   208	218	510	finally
      //   221	228	510	finally
      //   231	242	510	finally
      //   245	259	510	finally
      //   262	276	510	finally
      //   279	283	510	finally
      //   286	293	510	finally
      //   456	464	510	finally
      //   467	475	510	finally
      //   481	498	510	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.a.d
 * JD-Core Version:    0.7.0.1
 */