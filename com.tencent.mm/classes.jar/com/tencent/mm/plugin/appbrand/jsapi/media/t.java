package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.d.b;
import com.tencent.mm.media.i.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public final class t
{
  public static final int kZt;
  
  static
  {
    AppMethodBeat.i(46609);
    kZt = com.tencent.mm.plugin.sight.base.c.zhm;
    com.tencent.mm.plugin.appbrand.app.g.aZc();
    AppMethodBeat.o(46609);
  }
  
  public static String QE(String paramString)
  {
    AppMethodBeat.i(46603);
    if (paramString == null)
    {
      ae.e("MicroMsg.RemuxHelper", "remuxIfNeed, filePath is null");
      AppMethodBeat.o(46603);
      return null;
    }
    paramString = a(new a(paramString, 720, 540, 0, 0, com.tencent.mm.plugin.sight.base.c.zhm, com.tencent.mm.plugin.sight.base.c.zhn));
    AppMethodBeat.o(46603);
    return paramString;
  }
  
  public static int QM(String paramString)
  {
    AppMethodBeat.i(46606);
    boolean bool = com.tencent.mm.plugin.a.c.Jz(paramString);
    ae.i("MicroMsg.RemuxHelper", "checkRemux, isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
    int i;
    if (bool)
    {
      i = SightVideoJNI.shouldRemuxingVFS(paramString, 660, 500, 26214400, 1200000.0D, 1000000);
      ae.i("MicroMsg.RemuxHelper", "checkRemux, ret = %d", new Object[] { Integer.valueOf(i) });
      switch (i)
      {
      default: 
        ae.e("MicroMsg.RemuxHelper", "unknown check type");
        i = -50001;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(46606);
      return i;
      ae.i("MicroMsg.RemuxHelper", "fileLength = %d", new Object[] { Integer.valueOf((int)o.aZR(paramString)) });
      i = 1;
      break;
      i = 1;
      continue;
      i = -50006;
      continue;
      i = -50002;
    }
  }
  
  /* Error */
  public static b QN(String paramString)
  {
    // Byte code:
    //   0: ldc 118
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 120	com/tencent/mm/compatible/h/d
    //   8: dup
    //   9: invokespecial 122	com/tencent/mm/compatible/h/d:<init>	()V
    //   12: astore 11
    //   14: aload 11
    //   16: astore 10
    //   18: aload 11
    //   20: aload_0
    //   21: invokevirtual 128	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   24: aload 11
    //   26: astore 10
    //   28: aload 11
    //   30: bipush 24
    //   32: invokevirtual 132	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   35: iconst_0
    //   36: invokestatic 138	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   39: istore_3
    //   40: aload 11
    //   42: astore 10
    //   44: aload 11
    //   46: bipush 12
    //   48: invokevirtual 132	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   51: astore 12
    //   53: aload 11
    //   55: astore 10
    //   57: aload 11
    //   59: bipush 9
    //   61: invokevirtual 132	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   64: iconst_0
    //   65: invokestatic 138	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   68: istore 4
    //   70: aload 11
    //   72: astore 10
    //   74: aload_0
    //   75: invokestatic 111	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   78: lstore 8
    //   80: aload 11
    //   82: astore 10
    //   84: aload 11
    //   86: bipush 18
    //   88: invokevirtual 132	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   91: iconst_0
    //   92: invokestatic 138	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   95: istore 5
    //   97: aload 11
    //   99: astore 10
    //   101: aload 11
    //   103: bipush 19
    //   105: invokevirtual 132	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   108: iconst_0
    //   109: invokestatic 138	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   112: istore 6
    //   114: aload 11
    //   116: astore 10
    //   118: aload 11
    //   120: bipush 20
    //   122: invokevirtual 132	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   125: iconst_0
    //   126: invokestatic 138	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   129: istore 7
    //   131: fconst_0
    //   132: fstore_1
    //   133: aload 11
    //   135: astore 10
    //   137: getstatic 143	android/os/Build$VERSION:SDK_INT	I
    //   140: bipush 23
    //   142: if_icmplt +19 -> 161
    //   145: aload 11
    //   147: astore 10
    //   149: aload 11
    //   151: bipush 25
    //   153: invokevirtual 132	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   156: fconst_0
    //   157: invokestatic 147	com/tencent/mm/sdk/platformtools/bu:getFloat	(Ljava/lang/String;F)F
    //   160: fstore_1
    //   161: fload_1
    //   162: fstore_2
    //   163: fload_1
    //   164: fconst_0
    //   165: fcmpl
    //   166: ifne +23 -> 189
    //   169: aload 11
    //   171: astore 10
    //   173: ldc 44
    //   175: ldc 149
    //   177: invokestatic 151	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload 11
    //   182: astore 10
    //   184: aload_0
    //   185: invokestatic 155	com/tencent/mm/plugin/appbrand/jsapi/media/t:QO	(Ljava/lang/String;)F
    //   188: fstore_2
    //   189: aload 11
    //   191: astore 10
    //   193: ldc 44
    //   195: ldc 157
    //   197: bipush 9
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_0
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: iload_3
    //   209: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_2
    //   215: aload 12
    //   217: aastore
    //   218: dup
    //   219: iconst_3
    //   220: iload 4
    //   222: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: dup
    //   227: iconst_4
    //   228: lload 8
    //   230: invokestatic 162	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   233: aastore
    //   234: dup
    //   235: iconst_5
    //   236: iload 5
    //   238: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   241: aastore
    //   242: dup
    //   243: bipush 6
    //   245: iload 6
    //   247: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   250: aastore
    //   251: dup
    //   252: bipush 7
    //   254: iload 7
    //   256: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: aastore
    //   260: dup
    //   261: bipush 8
    //   263: fload_2
    //   264: invokestatic 167	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   267: aastore
    //   268: invokestatic 83	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 11
    //   273: astore 10
    //   275: new 11	com/tencent/mm/plugin/appbrand/jsapi/media/t$b
    //   278: dup
    //   279: aload_0
    //   280: iload_3
    //   281: aload 12
    //   283: iload 4
    //   285: lload 8
    //   287: iload 5
    //   289: iload 6
    //   291: iload 7
    //   293: fload_2
    //   294: invokespecial 170	com/tencent/mm/plugin/appbrand/jsapi/media/t$b:<init>	(Ljava/lang/String;ILjava/lang/String;IJIIIF)V
    //   297: astore_0
    //   298: aload 11
    //   300: invokevirtual 173	android/media/MediaMetadataRetriever:release	()V
    //   303: ldc 118
    //   305: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload_0
    //   309: areturn
    //   310: astore_0
    //   311: aconst_null
    //   312: astore_0
    //   313: aload_0
    //   314: astore 10
    //   316: ldc 44
    //   318: ldc 175
    //   320: invokestatic 178	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: aload_0
    //   324: ifnull +7 -> 331
    //   327: aload_0
    //   328: invokevirtual 173	android/media/MediaMetadataRetriever:release	()V
    //   331: ldc 118
    //   333: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aconst_null
    //   337: areturn
    //   338: astore_0
    //   339: aconst_null
    //   340: astore 10
    //   342: aload 10
    //   344: ifnull +8 -> 352
    //   347: aload 10
    //   349: invokevirtual 173	android/media/MediaMetadataRetriever:release	()V
    //   352: ldc 118
    //   354: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: aload_0
    //   358: athrow
    //   359: astore_0
    //   360: goto -18 -> 342
    //   363: astore_0
    //   364: aload 11
    //   366: astore_0
    //   367: goto -54 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramString	String
    //   132	32	1	f1	float
    //   162	132	2	f2	float
    //   39	242	3	i	int
    //   68	216	4	j	int
    //   95	193	5	k	int
    //   112	178	6	m	int
    //   129	163	7	n	int
    //   78	208	8	l	long
    //   16	332	10	localObject	Object
    //   12	353	11	locald	com.tencent.mm.compatible.h.d
    //   51	231	12	str	String
    // Exception table:
    //   from	to	target	type
    //   5	14	310	java/lang/Exception
    //   5	14	338	finally
    //   18	24	359	finally
    //   28	40	359	finally
    //   44	53	359	finally
    //   57	70	359	finally
    //   74	80	359	finally
    //   84	97	359	finally
    //   101	114	359	finally
    //   118	131	359	finally
    //   137	145	359	finally
    //   149	161	359	finally
    //   173	180	359	finally
    //   184	189	359	finally
    //   193	271	359	finally
    //   275	298	359	finally
    //   316	323	359	finally
    //   18	24	363	java/lang/Exception
    //   28	40	363	java/lang/Exception
    //   44	53	363	java/lang/Exception
    //   57	70	363	java/lang/Exception
    //   74	80	363	java/lang/Exception
    //   84	97	363	java/lang/Exception
    //   101	114	363	java/lang/Exception
    //   118	131	363	java/lang/Exception
    //   137	145	363	java/lang/Exception
    //   149	161	363	java/lang/Exception
    //   173	180	363	java/lang/Exception
    //   184	189	363	java/lang/Exception
    //   193	271	363	java/lang/Exception
    //   275	298	363	java/lang/Exception
  }
  
  private static float QO(String paramString)
  {
    AppMethodBeat.i(46608);
    MediaExtractor localMediaExtractor = new MediaExtractor();
    for (;;)
    {
      try
      {
        localMediaExtractor.setDataSource(paramString);
        int j = localMediaExtractor.getTrackCount();
        i = 0;
        if (i >= j) {
          break label136;
        }
        paramString = localMediaExtractor.getTrackFormat(i);
        if ((!paramString.getString("mime").startsWith("video/")) || (!paramString.containsKey("frame-rate"))) {
          continue;
        }
        i = paramString.getInteger("frame-rate");
        localMediaExtractor.release();
      }
      catch (IOException paramString)
      {
        float f;
        localMediaExtractor.release();
        i = 0;
        continue;
      }
      finally
      {
        localMediaExtractor.release();
        AppMethodBeat.o(46608);
      }
      ae.i("MicroMsg.RemuxHelper", "getVideoFrameRate fps: %d", new Object[] { Integer.valueOf(i) });
      f = i;
      AppMethodBeat.o(46608);
      return f * 1.0F;
      i += 1;
      continue;
      label136:
      int i = 0;
    }
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(46604);
    if (parama == null)
    {
      ae.e("MicroMsg.RemuxHelper", "remuxIfNeed, compress request is null");
      AppMethodBeat.o(46604);
      return null;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEO, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      parama = a(parama, bool);
      AppMethodBeat.o(46604);
      return parama;
    }
  }
  
  private static String a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(46605);
    String str = parama.filePath;
    if (QM(str) != -50006)
    {
      d.md(15);
      AppMethodBeat.o(46605);
      return str;
    }
    ae.i("MicroMsg.RemuxHelper", "compress info: filePath: %s, suggestWidth: %d, suggestHeight: %d, outputWidth: %d, outputHeight: %d, remuxBitRate %d", new Object[] { str, Integer.valueOf(parama.kZu), Integer.valueOf(parama.kZv), Integer.valueOf(parama.outputWidth), Integer.valueOf(parama.outputHeight), Integer.valueOf(parama.kZw) });
    int k;
    int j;
    int i;
    if ((parama.outputWidth != 0) && (parama.outputHeight != 0))
    {
      k = parama.outputWidth;
      j = parama.outputHeight;
      i = k;
      if (k % 2 != 0) {
        i = k + 1;
      }
      if (j % 2 == 0) {
        break label635;
      }
      j += 1;
    }
    label196:
    label635:
    for (;;)
    {
      ae.i("MicroMsg.RemuxHelper", "outputWidth: %d, outputHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      float f;
      Object localObject;
      if (parama.kZw > 0)
      {
        k = parama.kZw;
        if (parama.cwp <= 0.0F) {
          break label541;
        }
        f = parama.cwp;
        if (!o.fB(com.tencent.mm.loader.j.b.ash())) {
          o.aZI(com.tencent.mm.loader.j.b.ash());
        }
        parama = com.tencent.mm.loader.j.b.ash() + "microMsg." + System.currentTimeMillis() + ".mp4";
        d.md(0);
        if (!paramBoolean) {
          break label573;
        }
        ae.i("MicroMsg.RemuxHelper", "hard remux mode.");
        d.md(1);
        localObject = new CountDownLatch(1);
        k = h.hpM.a(str, parama, i, j, k, (int)f, 0, 51, new d.b()
        {
          public final void yO(String paramAnonymousString)
          {
            AppMethodBeat.i(46602);
            ae.d("MicroMsg.RemuxHelper", "remux onFinish.");
            this.val$latch.countDown();
            AppMethodBeat.o(46602);
          }
        }).aue();
      }
      for (;;)
      {
        try
        {
          ae.d("MicroMsg.RemuxHelper", "latch await ");
          ((CountDownLatch)localObject).await();
          d.md(10);
          ae.i("MicroMsg.RemuxHelper", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { str, parama, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(46605);
          return parama;
          if (parama.kZu > 0)
          {
            i = parama.kZu;
            if (parama.kZv <= 0) {
              continue;
            }
            j = parama.kZv;
            localObject = QN(str);
            if (localObject != null) {
              continue;
            }
            k = 0;
            if (localObject != null) {
              continue;
            }
            m = 0;
            ae.i("MicroMsg.RemuxHelper", "sourceWidth: %d, sourceHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
            localObject = new int[2];
            l.b(str, (int[])localObject, i, j);
            i = localObject[0];
            j = localObject[1];
            break;
          }
          i = 720;
          continue;
          j = 540;
          continue;
          k = ((b)localObject).width;
          continue;
          int m = ((b)localObject).height;
          continue;
          k = com.tencent.mm.plugin.sight.base.c.zhm;
          break label196;
          f = com.tencent.mm.plugin.sight.base.c.zhn;
        }
        catch (InterruptedException localInterruptedException)
        {
          ae.e("MicroMsg.RemuxHelper", "latch await exception, %s.", new Object[] { localInterruptedException.getMessage() });
          continue;
        }
        ae.i("MicroMsg.RemuxHelper", "soft remux mode.");
        d.md(2);
        k = SightVideoJNI.remuxingVFS(str, parama, i, j, k, com.tencent.mm.plugin.sight.base.c.zhl, 8, 2, 25.0F, f, null, 0, false, 0, 51);
        if (k < 0) {
          d.md(14);
        } else {
          d.md(11);
        }
      }
    }
  }
  
  public static final class a
  {
    public float cwp;
    public String filePath;
    public int kZu;
    public int kZv;
    public int kZw;
    public int outputHeight;
    public int outputWidth;
    
    public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
    {
      this.filePath = paramString;
      this.kZu = paramInt1;
      this.kZv = paramInt2;
      this.outputWidth = paramInt3;
      this.outputHeight = paramInt4;
      this.kZw = paramInt5;
      this.cwp = paramFloat;
    }
  }
  
  public static final class b
  {
    public int bitrate;
    public float cwp;
    public int duration;
    public String filePath;
    public int height;
    public int rotation;
    public long size;
    public String type;
    public int width;
    
    public b(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
    {
      this.filePath = paramString1;
      this.rotation = paramInt1;
      this.type = paramString2;
      this.duration = paramInt2;
      this.size = paramLong;
      this.width = paramInt3;
      this.height = paramInt4;
      this.bitrate = paramInt5;
      this.cwp = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.t
 * JD-Core Version:    0.7.0.1
 */