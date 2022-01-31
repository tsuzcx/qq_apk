package com.tencent.mm.media.c;

import a.f.b.j;
import a.l;
import android.media.MediaCodec;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "isInvokeDecodeEnd", "", "sawInputEOS", "onDecodeEnd", "releaseDecoder", "startDecode", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  final String TAG;
  volatile boolean eSr;
  private HandlerThread eSt;
  private boolean eSu;
  private final f.a eSv;
  
  /* Error */
  public f(long paramLong1, long paramLong2, com.tencent.mm.media.e.a parama, android.view.Surface paramSurface, a.f.a.b<? super b, a.y> paramb)
  {
    // Byte code:
    //   0: aload 5
    //   2: ldc 49
    //   4: invokestatic 55	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_0
    //   8: lload_1
    //   9: lload_3
    //   10: aload 5
    //   12: aload 6
    //   14: invokespecial 58	com/tencent/mm/media/c/b:<init>	(JJLcom/tencent/mm/media/e/a;Landroid/view/Surface;)V
    //   17: sipush 12873
    //   20: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   23: aload_0
    //   24: ldc 66
    //   26: putfield 68	com/tencent/mm/media/c/f:TAG	Ljava/lang/String;
    //   29: aload_0
    //   30: ldc 70
    //   32: invokestatic 76	com/tencent/mm/sdk/g/d:aqu	(Ljava/lang/String;)Landroid/os/HandlerThread;
    //   35: putfield 78	com/tencent/mm/media/c/f:eSt	Landroid/os/HandlerThread;
    //   38: aload_0
    //   39: new 80	com/tencent/mm/media/c/f$a
    //   42: dup
    //   43: aload_0
    //   44: aload 6
    //   46: aload 5
    //   48: invokespecial 83	com/tencent/mm/media/c/f$a:<init>	(Lcom/tencent/mm/media/c/f;Landroid/view/Surface;Lcom/tencent/mm/media/e/a;)V
    //   51: putfield 85	com/tencent/mm/media/c/f:eSv	Lcom/tencent/mm/media/c/f$a;
    //   54: aload_0
    //   55: aload 5
    //   57: getfield 91	com/tencent/mm/media/e/a:eUT	Landroid/media/MediaFormat;
    //   60: putfield 94	com/tencent/mm/media/c/b:mediaFormat	Landroid/media/MediaFormat;
    //   63: aload_0
    //   64: aload 5
    //   66: invokevirtual 98	com/tencent/mm/media/e/a:UV	()Ljava/lang/String;
    //   69: invokestatic 104	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   72: putfield 108	com/tencent/mm/media/c/b:eRD	Landroid/media/MediaCodec;
    //   75: aload_0
    //   76: getfield 68	com/tencent/mm/media/c/f:TAG	Ljava/lang/String;
    //   79: new 110	java/lang/StringBuilder
    //   82: dup
    //   83: ldc 112
    //   85: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload 5
    //   90: invokevirtual 98	com/tencent/mm/media/e/a:UV	()Ljava/lang/String;
    //   93: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 127	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: bipush 23
    //   104: invokestatic 133	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   107: ifeq +108 -> 215
    //   110: aload_0
    //   111: getfield 78	com/tencent/mm/media/c/f:eSt	Landroid/os/HandlerThread;
    //   114: invokevirtual 139	android/os/HandlerThread:start	()V
    //   117: aload_0
    //   118: getfield 78	com/tencent/mm/media/c/f:eSt	Landroid/os/HandlerThread;
    //   121: astore 5
    //   123: aload 5
    //   125: ldc 140
    //   127: invokestatic 143	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   130: new 145	android/os/Handler
    //   133: dup
    //   134: aload 5
    //   136: invokevirtual 149	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   139: invokespecial 152	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   142: astore 5
    //   144: aload_0
    //   145: getfield 108	com/tencent/mm/media/c/b:eRD	Landroid/media/MediaCodec;
    //   148: astore 8
    //   150: aload 8
    //   152: ifnonnull +6 -> 158
    //   155: invokestatic 155	a/f/b/j:ebi	()V
    //   158: aload 8
    //   160: aload_0
    //   161: getfield 85	com/tencent/mm/media/c/f:eSv	Lcom/tencent/mm/media/c/f$a;
    //   164: checkcast 157	android/media/MediaCodec$Callback
    //   167: aload 5
    //   169: invokevirtual 161	android/media/MediaCodec:setCallback	(Landroid/media/MediaCodec$Callback;Landroid/os/Handler;)V
    //   172: aload_0
    //   173: getfield 108	com/tencent/mm/media/c/b:eRD	Landroid/media/MediaCodec;
    //   176: astore 5
    //   178: aload 5
    //   180: ifnonnull +6 -> 186
    //   183: invokestatic 155	a/f/b/j:ebi	()V
    //   186: aload 5
    //   188: aload_0
    //   189: getfield 94	com/tencent/mm/media/c/b:mediaFormat	Landroid/media/MediaFormat;
    //   192: aload 6
    //   194: aconst_null
    //   195: iconst_0
    //   196: invokevirtual 165	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   199: aload 7
    //   201: aload_0
    //   202: invokeinterface 171 2 0
    //   207: pop
    //   208: sipush 12873
    //   211: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: aload_0
    //   216: getfield 108	com/tencent/mm/media/c/b:eRD	Landroid/media/MediaCodec;
    //   219: astore 5
    //   221: aload 5
    //   223: ifnonnull +6 -> 229
    //   226: invokestatic 155	a/f/b/j:ebi	()V
    //   229: aload 5
    //   231: aload_0
    //   232: getfield 85	com/tencent/mm/media/c/f:eSv	Lcom/tencent/mm/media/c/f$a;
    //   235: checkcast 157	android/media/MediaCodec$Callback
    //   238: invokevirtual 177	android/media/MediaCodec:setCallback	(Landroid/media/MediaCodec$Callback;)V
    //   241: goto -69 -> 172
    //   244: astore 5
    //   246: aload_0
    //   247: getfield 68	com/tencent/mm/media/c/f:TAG	Ljava/lang/String;
    //   250: aload 5
    //   252: checkcast 179	java/lang/Throwable
    //   255: new 110	java/lang/StringBuilder
    //   258: dup
    //   259: ldc 181
    //   261: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   264: aload 5
    //   266: invokevirtual 184	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   269: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: iconst_0
    //   276: anewarray 186	java/lang/Object
    //   279: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: new 192	java/lang/IllegalStateException
    //   285: dup
    //   286: ldc 194
    //   288: invokespecial 195	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   291: checkcast 179	java/lang/Throwable
    //   294: astore 5
    //   296: sipush 12873
    //   299: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: aload 5
    //   304: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	f
    //   0	305	1	paramLong1	long
    //   0	305	3	paramLong2	long
    //   0	305	5	parama	com.tencent.mm.media.e.a
    //   0	305	6	paramSurface	android.view.Surface
    //   0	305	7	paramb	a.f.a.b<? super b, a.y>
    //   148	11	8	localMediaCodec	MediaCodec
    // Exception table:
    //   from	to	target	type
    //   54	150	244	java/lang/Exception
    //   155	158	244	java/lang/Exception
    //   158	172	244	java/lang/Exception
    //   172	178	244	java/lang/Exception
    //   183	186	244	java/lang/Exception
    //   186	199	244	java/lang/Exception
    //   215	221	244	java/lang/Exception
    //   226	229	244	java/lang/Exception
    //   229	241	244	java/lang/Exception
  }
  
  public final void pJ()
  {
    AppMethodBeat.i(12872);
    super.pJ();
    try
    {
      this.eSt.quit();
      AppMethodBeat.o(12872);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "releaseDecoder error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(12872);
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(12871);
    try
    {
      MediaCodec localMediaCodec = this.eRD;
      if (localMediaCodec == null) {
        j.ebi();
      }
      localMediaCodec.start();
      AppMethodBeat.o(12871);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "startDecode error", new Object[0]);
      AppMethodBeat.o(12871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.c.f
 * JD-Core Version:    0.7.0.1
 */