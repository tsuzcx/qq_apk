package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.media.i.c.b;
import com.tencent.mm.media.i.g;
import com.tencent.mm.plugin.appbrand.app.k;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public final class u
{
  public static final int shM;
  
  static
  {
    AppMethodBeat.i(46609);
    shM = com.tencent.mm.plugin.sight.base.d.PFk;
    AppMethodBeat.o(46609);
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(46604);
    if (parama == null)
    {
      Log.e("MicroMsg.RemuxHelper", "remuxIfNeed, compress request is null");
      AppMethodBeat.o(46604);
      return null;
    }
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUi, 0);
    k.ceQ();
    if (i == 1) {}
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
    if (abc(str) != -50006)
    {
      d.rG(15);
      AppMethodBeat.o(46605);
      return str;
    }
    Log.i("MicroMsg.RemuxHelper", "compress info: filePath: %s, suggestWidth: %d, suggestHeight: %d, outputWidth: %d, outputHeight: %d, remuxBitRate %d", new Object[] { str, Integer.valueOf(parama.shO), Integer.valueOf(parama.shP), Integer.valueOf(parama.outputWidth), Integer.valueOf(parama.outputHeight), Integer.valueOf(parama.shQ) });
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
        break label723;
      }
      j += 1;
    }
    label194:
    label723:
    for (;;)
    {
      Log.i("MicroMsg.RemuxHelper", "outputWidth: %d, outputHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      float f;
      Object localObject;
      final CountDownLatch localCountDownLatch;
      if (parama.shQ > 0)
      {
        k = parama.shQ;
        if (parama.eGw <= 0.0F) {
          break label620;
        }
        f = parama.eGw;
        if (!y.ZC(b.bmx())) {
          y.bDX(b.bmx());
        }
        parama = b.bmx() + "microMsg." + System.currentTimeMillis() + ".mp4";
        localObject = new PInt();
        d.rG(0);
        if (!paramBoolean) {
          break label663;
        }
        Log.i("MicroMsg.RemuxHelper", "hard remux mode.");
        d.rG(1);
        localCountDownLatch = new CountDownLatch(1);
        g.nDb.a(str, parama, i, j, k, (int)f, 0, 51, new c.b()
        {
          public final void GO(String paramAnonymousString)
          {
            AppMethodBeat.i(46602);
            Log.d("MicroMsg.RemuxHelper", "remux onFinish.");
            PInt localPInt;
            if (Util.isNullOrNil(paramAnonymousString))
            {
              localPInt = u.this;
              if (!Util.isNullOrNil(paramAnonymousString)) {
                break label51;
              }
            }
            label51:
            for (int i = -1;; i = 0)
            {
              localPInt.value = i;
              localCountDownLatch.countDown();
              AppMethodBeat.o(46602);
              return;
            }
          }
        }).bpE();
      }
      for (;;)
      {
        try
        {
          Log.d("MicroMsg.RemuxHelper", "latch await ");
          localCountDownLatch.await();
          m = ((PInt)localObject).value;
          if (m < 0)
          {
            Log.e("MicroMsg.RemuxHelper", "remux failed, ret: %d, try soft remux mode", new Object[] { Integer.valueOf(m) });
            d.rG(12);
            k = SightVideoJNI.remuxingVFS(str, parama, i, j, k, com.tencent.mm.plugin.sight.base.d.PFj, 8, 2, 25.0F, f, null, 0, false, 0, 51);
            m = k;
            if (k < 0)
            {
              d.rG(13);
              m = k;
            }
            Log.i("MicroMsg.RemuxHelper", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { str, parama, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(46605);
            return parama;
            if (parama.shO > 0)
            {
              i = parama.shO;
              if (parama.shP <= 0) {
                continue;
              }
              j = parama.shP;
              localObject = abd(str);
              if (localObject != null) {
                continue;
              }
              k = 0;
              if (localObject != null) {
                continue;
              }
              m = 0;
              Log.i("MicroMsg.RemuxHelper", "sourceWidth: %d, sourceHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
              localObject = new int[2];
              q.b(str, (int[])localObject, i, j);
              i = localObject[0];
              j = localObject[1];
              break;
            }
            i = 720;
            continue;
            j = 540;
            continue;
            k = ((u.b)localObject).width;
            continue;
            m = ((u.b)localObject).height;
            continue;
            k = com.tencent.mm.plugin.sight.base.d.PFk;
            break label194;
            label620:
            f = com.tencent.mm.plugin.sight.base.d.PFl;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.e("MicroMsg.RemuxHelper", "latch await exception, %s.", new Object[] { localInterruptedException.getMessage() });
          continue;
          d.rG(10);
          k = m;
          continue;
        }
        Log.i("MicroMsg.RemuxHelper", "soft remux mode.");
        d.rG(2);
        int m = SightVideoJNI.remuxingVFS(str, parama, i, j, k, com.tencent.mm.plugin.sight.base.d.PFj, 8, 2, 25.0F, f, null, 0, false, 0, 51);
        if (m < 0) {
          d.rG(14);
        } else {
          d.rG(11);
        }
      }
    }
  }
  
  public static String aaU(String paramString)
  {
    AppMethodBeat.i(46603);
    if (paramString == null)
    {
      Log.e("MicroMsg.RemuxHelper", "remuxIfNeed, filePath is null");
      AppMethodBeat.o(46603);
      return null;
    }
    k.ceQ();
    paramString = a(new a(paramString, 720, 540, 0, 0, com.tencent.mm.plugin.sight.base.d.PFk, com.tencent.mm.plugin.sight.base.d.PFl));
    AppMethodBeat.o(46603);
    return paramString;
  }
  
  public static int abc(String paramString)
  {
    AppMethodBeat.i(46606);
    k.ceQ();
    boolean bool = com.tencent.mm.plugin.a.c.Sm(paramString);
    Log.i("MicroMsg.RemuxHelper", "checkRemux, isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
    int i;
    if (bool)
    {
      i = SightVideoJNI.shouldRemuxingVFS(paramString, 660, 500, 26214400, 1200000.0D, 1000000);
      Log.i("MicroMsg.RemuxHelper", "checkRemux, ret = %d", new Object[] { Integer.valueOf(i) });
      switch (i)
      {
      default: 
        Log.e("MicroMsg.RemuxHelper", "unknown check type");
        i = -50001;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(46606);
      return i;
      Log.i("MicroMsg.RemuxHelper", "fileLength = %d", new Object[] { Integer.valueOf((int)y.bEl(paramString)) });
      i = 1;
      break;
      i = 1;
      continue;
      i = 2;
      continue;
      i = -50006;
      continue;
      i = -50002;
    }
  }
  
  /* Error */
  public static u.b abd(String paramString)
  {
    // Byte code:
    //   0: ldc_w 289
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 291	com/tencent/mm/compatible/i/d
    //   9: dup
    //   10: invokespecial 292	com/tencent/mm/compatible/i/d:<init>	()V
    //   13: astore 11
    //   15: aload 11
    //   17: astore 10
    //   19: aload 11
    //   21: aload_0
    //   22: invokevirtual 298	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   25: aload 11
    //   27: astore 10
    //   29: aload 11
    //   31: bipush 24
    //   33: invokevirtual 302	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: iconst_0
    //   37: invokestatic 308	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   40: istore_3
    //   41: aload 11
    //   43: astore 10
    //   45: aload 11
    //   47: bipush 12
    //   49: invokevirtual 302	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: astore 12
    //   54: aload 11
    //   56: astore 10
    //   58: aload 11
    //   60: bipush 9
    //   62: invokevirtual 302	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   65: iconst_0
    //   66: invokestatic 308	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   69: istore 4
    //   71: aload 11
    //   73: astore 10
    //   75: aload_0
    //   76: invokestatic 285	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   79: lstore 8
    //   81: aload 11
    //   83: astore 10
    //   85: aload 11
    //   87: bipush 18
    //   89: invokevirtual 302	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   92: iconst_0
    //   93: invokestatic 308	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   96: istore 5
    //   98: aload 11
    //   100: astore 10
    //   102: aload 11
    //   104: bipush 19
    //   106: invokevirtual 302	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   109: iconst_0
    //   110: invokestatic 308	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   113: istore 6
    //   115: aload 11
    //   117: astore 10
    //   119: aload 11
    //   121: bipush 20
    //   123: invokevirtual 302	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   126: iconst_0
    //   127: invokestatic 308	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   130: istore 7
    //   132: fconst_0
    //   133: fstore_1
    //   134: aload 11
    //   136: astore 10
    //   138: getstatic 313	android/os/Build$VERSION:SDK_INT	I
    //   141: bipush 23
    //   143: if_icmplt +19 -> 162
    //   146: aload 11
    //   148: astore 10
    //   150: aload 11
    //   152: bipush 25
    //   154: invokevirtual 302	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   157: fconst_0
    //   158: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   161: fstore_1
    //   162: fload_1
    //   163: fstore_2
    //   164: fload_1
    //   165: fconst_0
    //   166: fcmpl
    //   167: ifne +24 -> 191
    //   170: aload 11
    //   172: astore 10
    //   174: ldc 37
    //   176: ldc_w 319
    //   179: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 11
    //   184: astore 10
    //   186: aload_0
    //   187: invokestatic 323	com/tencent/mm/plugin/appbrand/jsapi/media/u:abe	(Ljava/lang/String;)F
    //   190: fstore_2
    //   191: aload 11
    //   193: astore 10
    //   195: ldc 37
    //   197: ldc_w 325
    //   200: bipush 9
    //   202: anewarray 4	java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: aload_0
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: iload_3
    //   212: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aastore
    //   216: dup
    //   217: iconst_2
    //   218: aload 12
    //   220: aastore
    //   221: dup
    //   222: iconst_3
    //   223: iload 4
    //   225: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: aastore
    //   229: dup
    //   230: iconst_4
    //   231: lload 8
    //   233: invokestatic 330	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   236: aastore
    //   237: dup
    //   238: iconst_5
    //   239: iload 5
    //   241: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: aastore
    //   245: dup
    //   246: bipush 6
    //   248: iload 6
    //   250: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: dup
    //   255: bipush 7
    //   257: iload 7
    //   259: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: aastore
    //   263: dup
    //   264: bipush 8
    //   266: fload_2
    //   267: invokestatic 335	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   270: aastore
    //   271: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload 11
    //   276: astore 10
    //   278: new 11	com/tencent/mm/plugin/appbrand/jsapi/media/u$b
    //   281: dup
    //   282: aload_0
    //   283: iload_3
    //   284: aload 12
    //   286: iload 4
    //   288: lload 8
    //   290: iload 5
    //   292: iload 6
    //   294: iload 7
    //   296: fload_2
    //   297: invokespecial 338	com/tencent/mm/plugin/appbrand/jsapi/media/u$b:<init>	(Ljava/lang/String;ILjava/lang/String;IJIIIF)V
    //   300: astore_0
    //   301: aload 11
    //   303: invokevirtual 341	android/media/MediaMetadataRetriever:release	()V
    //   306: ldc_w 289
    //   309: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: aload_0
    //   313: areturn
    //   314: astore_0
    //   315: aconst_null
    //   316: astore_0
    //   317: aload_0
    //   318: astore 10
    //   320: ldc 37
    //   322: ldc_w 343
    //   325: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: aload_0
    //   329: ifnull +7 -> 336
    //   332: aload_0
    //   333: invokevirtual 341	android/media/MediaMetadataRetriever:release	()V
    //   336: ldc_w 289
    //   339: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aconst_null
    //   343: areturn
    //   344: astore_0
    //   345: aconst_null
    //   346: astore 10
    //   348: aload 10
    //   350: ifnull +8 -> 358
    //   353: aload 10
    //   355: invokevirtual 341	android/media/MediaMetadataRetriever:release	()V
    //   358: ldc_w 289
    //   361: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: aload_0
    //   365: athrow
    //   366: astore_0
    //   367: goto -19 -> 348
    //   370: astore_0
    //   371: aload 11
    //   373: astore_0
    //   374: goto -57 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramString	String
    //   133	32	1	f1	float
    //   163	134	2	f2	float
    //   40	244	3	i	int
    //   69	218	4	j	int
    //   96	195	5	k	int
    //   113	180	6	m	int
    //   130	165	7	n	int
    //   79	210	8	l	long
    //   17	337	10	localObject	Object
    //   13	359	11	locald	com.tencent.mm.compatible.i.d
    //   52	233	12	str	String
    // Exception table:
    //   from	to	target	type
    //   6	15	314	java/lang/Exception
    //   6	15	344	finally
    //   19	25	366	finally
    //   29	41	366	finally
    //   45	54	366	finally
    //   58	71	366	finally
    //   75	81	366	finally
    //   85	98	366	finally
    //   102	115	366	finally
    //   119	132	366	finally
    //   138	146	366	finally
    //   150	162	366	finally
    //   174	182	366	finally
    //   186	191	366	finally
    //   195	274	366	finally
    //   278	301	366	finally
    //   320	328	366	finally
    //   19	25	370	java/lang/Exception
    //   29	41	370	java/lang/Exception
    //   45	54	370	java/lang/Exception
    //   58	71	370	java/lang/Exception
    //   75	81	370	java/lang/Exception
    //   85	98	370	java/lang/Exception
    //   102	115	370	java/lang/Exception
    //   119	132	370	java/lang/Exception
    //   138	146	370	java/lang/Exception
    //   150	162	370	java/lang/Exception
    //   174	182	370	java/lang/Exception
    //   186	191	370	java/lang/Exception
    //   195	274	370	java/lang/Exception
    //   278	301	370	java/lang/Exception
  }
  
  private static float abe(String paramString)
  {
    AppMethodBeat.i(46608);
    com.tencent.mm.compatible.i.c localc = new com.tencent.mm.compatible.i.c();
    for (;;)
    {
      try
      {
        localc.setDataSource(paramString);
        int j = localc.lZm.getTrackCount();
        i = 0;
        if (i >= j) {
          break label169;
        }
        paramString = localc.getTrackFormat(i);
        if ((!paramString.getString("mime").startsWith("video/")) || (!paramString.containsKey("frame-rate"))) {
          continue;
        }
        i = paramString.getInteger("frame-rate");
        localc.lZm.release();
      }
      catch (IOException paramString)
      {
        float f;
        Log.printErrStackTrace("MicroMsg.RemuxHelper", paramString, "", new Object[0]);
        localc.lZm.release();
        i = 0;
        continue;
      }
      finally
      {
        localc.lZm.release();
        AppMethodBeat.o(46608);
      }
      Log.i("MicroMsg.RemuxHelper", "getVideoFrameRate fps: %d", new Object[] { Integer.valueOf(i) });
      f = i;
      AppMethodBeat.o(46608);
      return f * 1.0F;
      i += 1;
      continue;
      label169:
      int i = 0;
    }
  }
  
  public static final class a
  {
    public float eGw;
    public String filePath;
    public int outputHeight;
    public int outputWidth;
    public int shO;
    public int shP;
    public int shQ;
    
    public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
    {
      this.filePath = paramString;
      this.shO = paramInt1;
      this.shP = paramInt2;
      this.outputWidth = paramInt3;
      this.outputHeight = paramInt4;
      this.shQ = paramInt5;
      this.eGw = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.u
 * JD-Core Version:    0.7.0.1
 */