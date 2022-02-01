package com.tencent.mm.plugin.gamelive.a;

import com.tencent.e.b;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/audio/GameLiveMainAudioMgrService;", "Lcom/tencent/mm/plugin/gamelive/audio/IGameLiveMainAudioMgrService;", "()V", "audioTask", "Ljava/lang/Runnable;", "getAudioTask", "()Ljava/lang/Runnable;", "forkExecutorService", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "kotlin.jvm.PlatformType", "reconnecting", "", "reconnect", "", "start", "stop", "Companion", "plugin-gamelive_release"})
public final class d
  implements f
{
  public static boolean DlY;
  public static final d.a DlZ;
  public volatile boolean DlW;
  public final Runnable DlX;
  public final b Dli;
  
  static
  {
    AppMethodBeat.i(207806);
    DlZ = new d.a((byte)0);
    DlY = true;
    AppMethodBeat.o(207806);
  }
  
  public d()
  {
    AppMethodBeat.i(207803);
    this.Dli = h.ZvG.bDi("gamelive_audio_mix_ipc_main");
    this.DlX = ((Runnable)new b(this));
    AppMethodBeat.o(207803);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(207802);
    DlY = false;
    Log.i("MicroMsg.GameLiveMainAudioMgrService", "stop main audio");
    AppMethodBeat.o(207802);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gamelive/audio/GameLiveMainAudioMgrService$audioTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-gamelive_release"})
  public static final class b
    implements Runnable
  {
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: ldc 34
      //   4: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 28	com/tencent/mm/plugin/gamelive/a/d$b:Dma	Lcom/tencent/mm/plugin/gamelive/a/d;
      //   11: invokestatic 43	com/tencent/mm/plugin/gamelive/a/d:b	(Lcom/tencent/mm/plugin/gamelive/a/d;)V
      //   14: new 45	java/lang/StringBuilder
      //   17: dup
      //   18: ldc 47
      //   20: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   23: astore_3
      //   24: invokestatic 56	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
      //   27: ldc 58
      //   29: invokestatic 64	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   32: aload_3
      //   33: invokestatic 70	com/tencent/mm/kernel/b:getUin	()I
      //   36: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   39: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   42: astore_3
      //   43: getstatic 84	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
      //   46: astore 4
      //   48: aload_3
      //   49: ifnonnull +20 -> 69
      //   52: new 86	kotlin/t
      //   55: dup
      //   56: ldc 88
      //   58: invokespecial 89	kotlin/t:<init>	(Ljava/lang/String;)V
      //   61: astore_3
      //   62: ldc 34
      //   64: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   67: aload_3
      //   68: athrow
      //   69: aload_3
      //   70: aload 4
      //   72: invokevirtual 98	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   75: astore_3
      //   76: aload_3
      //   77: ldc 100
      //   79: invokestatic 64	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   82: aload_3
      //   83: invokestatic 106	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
      //   86: astore_3
      //   87: ldc 108
      //   89: ldc 110
      //   91: aload_3
      //   92: invokestatic 114	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   95: invokevirtual 118	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   98: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   101: new 125	android/net/LocalSocket
      //   104: dup
      //   105: invokespecial 126	android/net/LocalSocket:<init>	()V
      //   108: astore 7
      //   110: new 128	android/net/LocalSocketAddress
      //   113: dup
      //   114: aload_3
      //   115: getstatic 134	android/net/LocalSocketAddress$Namespace:ABSTRACT	Landroid/net/LocalSocketAddress$Namespace;
      //   118: invokespecial 137	android/net/LocalSocketAddress:<init>	(Ljava/lang/String;Landroid/net/LocalSocketAddress$Namespace;)V
      //   121: astore_3
      //   122: ldc 139
      //   124: invokestatic 143	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   127: checkcast 139	com/tencent/c/a/a/a/b
      //   130: astore 8
      //   132: aload 7
      //   134: aload_3
      //   135: invokevirtual 147	android/net/LocalSocket:connect	(Landroid/net/LocalSocketAddress;)V
      //   138: ldc 108
      //   140: ldc 149
      //   142: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   145: aconst_null
      //   146: astore_3
      //   147: aconst_null
      //   148: astore 6
      //   150: new 151	java/io/ObjectInputStream
      //   153: dup
      //   154: aload 7
      //   156: invokevirtual 155	android/net/LocalSocket:getInputStream	()Ljava/io/InputStream;
      //   159: invokespecial 158	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   162: astore 4
      //   164: aload 4
      //   166: invokevirtual 162	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   169: astore_3
      //   170: aload_3
      //   171: ifnonnull +249 -> 420
      //   174: new 86	kotlin/t
      //   177: dup
      //   178: ldc 164
      //   180: invokespecial 89	kotlin/t:<init>	(Ljava/lang/String;)V
      //   183: astore_3
      //   184: ldc 34
      //   186: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   189: aload_3
      //   190: athrow
      //   191: astore 5
      //   193: aload 4
      //   195: astore_3
      //   196: aload 5
      //   198: instanceof 166
      //   201: ifeq +276 -> 477
      //   204: aload 4
      //   206: astore_3
      //   207: getstatic 170	com/tencent/mm/plugin/gamelive/a/d:DlZ	Lcom/tencent/mm/plugin/gamelive/a/d$a;
      //   210: astore 5
      //   212: aload 4
      //   214: astore_3
      //   215: invokestatic 174	com/tencent/mm/plugin/gamelive/a/d:eAS	()Z
      //   218: ifeq +81 -> 299
      //   221: aload 4
      //   223: astore_3
      //   224: aload_0
      //   225: getfield 28	com/tencent/mm/plugin/gamelive/a/d$b:Dma	Lcom/tencent/mm/plugin/gamelive/a/d;
      //   228: invokestatic 178	com/tencent/mm/plugin/gamelive/a/d:a	(Lcom/tencent/mm/plugin/gamelive/a/d;)Z
      //   231: ifne +68 -> 299
      //   234: aload 4
      //   236: astore_3
      //   237: ldc 108
      //   239: ldc 180
      //   241: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   244: aload 4
      //   246: astore_3
      //   247: aload 8
      //   249: iconst_1
      //   250: invokestatic 189	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   253: invokeinterface 193 3 0
      //   258: aload 4
      //   260: astore_3
      //   261: ldc 195
      //   263: invokestatic 143	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   266: checkcast 195	com/tencent/mm/plugin/gamelive/PluginGameLive
      //   269: getstatic 201	com/tencent/mm/plugin/gamelive/PluginGameLive$b:Dkq	Lcom/tencent/mm/plugin/gamelive/PluginGameLive$b;
      //   272: invokevirtual 205	com/tencent/mm/plugin/gamelive/PluginGameLive:setGameLiveCurrentState_$plugin_gamelive_release	(Lcom/tencent/mm/plugin/gamelive/PluginGameLive$b;)V
      //   275: aload 4
      //   277: astore_3
      //   278: ldc 195
      //   280: invokestatic 143	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   283: checkcast 195	com/tencent/mm/plugin/gamelive/PluginGameLive
      //   286: invokevirtual 209	com/tencent/mm/plugin/gamelive/PluginGameLive:getMainProcessService$plugin_gamelive_release	()Lcom/tencent/mm/plugin/gamelive/b;
      //   289: ifnull +10 -> 299
      //   292: aload 4
      //   294: astore_3
      //   295: iconst_0
      //   296: invokestatic 215	com/tencent/mm/plugin/gamelive/b:sx	(Z)V
      //   299: aload 4
      //   301: astore_3
      //   302: ldc 108
      //   304: ldc 217
      //   306: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   309: aload 4
      //   311: ifnull +8 -> 319
      //   314: aload 4
      //   316: invokevirtual 220	java/io/ObjectInputStream:close	()V
      //   319: aload 7
      //   321: invokevirtual 221	android/net/LocalSocket:close	()V
      //   324: ldc 108
      //   326: new 45	java/lang/StringBuilder
      //   329: dup
      //   330: ldc 223
      //   332: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   335: aload_0
      //   336: getfield 28	com/tencent/mm/plugin/gamelive/a/d$b:Dma	Lcom/tencent/mm/plugin/gamelive/a/d;
      //   339: invokestatic 178	com/tencent/mm/plugin/gamelive/a/d:a	(Lcom/tencent/mm/plugin/gamelive/a/d;)Z
      //   342: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   345: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   348: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   351: aload_0
      //   352: getfield 28	com/tencent/mm/plugin/gamelive/a/d$b:Dma	Lcom/tencent/mm/plugin/gamelive/a/d;
      //   355: invokestatic 178	com/tencent/mm/plugin/gamelive/a/d:a	(Lcom/tencent/mm/plugin/gamelive/a/d;)Z
      //   358: ifeq +17 -> 375
      //   361: aload_0
      //   362: getfield 28	com/tencent/mm/plugin/gamelive/a/d$b:Dma	Lcom/tencent/mm/plugin/gamelive/a/d;
      //   365: invokestatic 230	com/tencent/mm/plugin/gamelive/a/d:c	(Lcom/tencent/mm/plugin/gamelive/a/d;)Lcom/tencent/e/b;
      //   368: aload_0
      //   369: checkcast 6	java/lang/Runnable
      //   372: invokevirtual 236	com/tencent/e/b:execute	(Ljava/lang/Runnable;)V
      //   375: ldc 34
      //   377: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   380: return
      //   381: astore 4
      //   383: ldc 108
      //   385: ldc 238
      //   387: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   390: ldc2_w 242
      //   393: invokestatic 249	java/lang/Thread:sleep	(J)V
      //   396: iload_1
      //   397: iconst_1
      //   398: iadd
      //   399: istore_2
      //   400: iload_2
      //   401: istore_1
      //   402: iload_2
      //   403: iconst_1
      //   404: if_icmple -272 -> 132
      //   407: ldc 108
      //   409: ldc 251
      //   411: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   414: ldc 34
      //   416: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   419: return
      //   420: aload_3
      //   421: checkcast 253	com/tencent/mm/plugin/gamelive/a/g
      //   424: astore_3
      //   425: aload 8
      //   427: aload_3
      //   428: getfield 257	com/tencent/mm/plugin/gamelive/a/g:data	[B
      //   431: ldc_w 258
      //   434: iconst_2
      //   435: aload_3
      //   436: getfield 262	com/tencent/mm/plugin/gamelive/a/g:timestamp	J
      //   439: invokeinterface 266 6 0
      //   444: goto -280 -> 164
      //   447: astore 5
      //   449: aload 4
      //   451: astore_3
      //   452: aload 5
      //   454: astore 4
      //   456: aload_3
      //   457: ifnull +7 -> 464
      //   460: aload_3
      //   461: invokevirtual 220	java/io/ObjectInputStream:close	()V
      //   464: aload 7
      //   466: invokevirtual 221	android/net/LocalSocket:close	()V
      //   469: ldc 34
      //   471: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   474: aload 4
      //   476: athrow
      //   477: aload 4
      //   479: astore_3
      //   480: aload 5
      //   482: instanceof 268
      //   485: ifeq +17 -> 502
      //   488: aload 4
      //   490: astore_3
      //   491: ldc 108
      //   493: ldc_w 270
      //   496: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   499: goto -190 -> 309
      //   502: aload 4
      //   504: astore_3
      //   505: ldc 108
      //   507: aload 5
      //   509: checkcast 272	java/lang/Throwable
      //   512: ldc_w 274
      //   515: iconst_0
      //   516: anewarray 4	java/lang/Object
      //   519: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   522: goto -213 -> 309
      //   525: astore 5
      //   527: aload 6
      //   529: astore 4
      //   531: goto -338 -> 193
      //   534: astore 4
      //   536: goto -80 -> 456
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	539	0	this	b
      //   1	401	1	i	int
      //   399	6	2	j	int
      //   23	482	3	localObject1	Object
      //   46	269	4	localObject2	Object
      //   381	69	4	localIOException1	java.io.IOException
      //   454	76	4	localObject3	Object
      //   534	1	4	localObject4	Object
      //   191	6	5	localIOException2	java.io.IOException
      //   210	1	5	locala	d.a
      //   447	61	5	localObject5	Object
      //   525	1	5	localIOException3	java.io.IOException
      //   148	380	6	localObject6	Object
      //   108	357	7	localLocalSocket	android.net.LocalSocket
      //   130	296	8	localb	com.tencent.c.a.a.a.b
      // Exception table:
      //   from	to	target	type
      //   164	170	191	java/io/IOException
      //   174	191	191	java/io/IOException
      //   420	444	191	java/io/IOException
      //   132	145	381	java/io/IOException
      //   164	170	447	finally
      //   174	191	447	finally
      //   420	444	447	finally
      //   150	164	525	java/io/IOException
      //   150	164	534	finally
      //   196	204	534	finally
      //   207	212	534	finally
      //   215	221	534	finally
      //   224	234	534	finally
      //   237	244	534	finally
      //   247	258	534	finally
      //   261	275	534	finally
      //   278	292	534	finally
      //   295	299	534	finally
      //   302	309	534	finally
      //   480	488	534	finally
      //   491	499	534	finally
      //   505	522	534	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.a.d
 * JD-Core Version:    0.7.0.1
 */