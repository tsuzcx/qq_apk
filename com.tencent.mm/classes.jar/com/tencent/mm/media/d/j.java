package com.tencent.mm.media.d;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZLkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "isInvokeDecodeEnd", "sawInputEOS", "onDecodeEnd", "releaseDecoder", "startDecode", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends f
{
  final String TAG;
  private HandlerThread decoderThread;
  volatile boolean nze;
  private boolean nzm;
  private final a nzn;
  
  /* Error */
  public j(long paramLong1, long paramLong2, final com.tencent.mm.media.f.a parama, android.view.Surface paramSurface, int paramInt, boolean paramBoolean, b<? super f, kotlin.ah> paramb)
  {
    // Byte code:
    //   0: aload 5
    //   2: ldc 55
    //   4: invokestatic 61	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_0
    //   8: lload_1
    //   9: lload_3
    //   10: aload 5
    //   12: aload 6
    //   14: iload 7
    //   16: iload 8
    //   18: invokespecial 64	com/tencent/mm/media/d/f:<init>	(JJLcom/tencent/mm/media/f/a;Landroid/view/Surface;IZ)V
    //   21: ldc 65
    //   23: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   26: aload_0
    //   27: ldc 73
    //   29: putfield 75	com/tencent/mm/media/d/j:TAG	Ljava/lang/String;
    //   32: aload_0
    //   33: ldc 77
    //   35: iconst_5
    //   36: invokestatic 83	com/tencent/threadpool/c/d:jx	(Ljava/lang/String;I)Landroid/os/HandlerThread;
    //   39: putfield 85	com/tencent/mm/media/d/j:decoderThread	Landroid/os/HandlerThread;
    //   42: aload_0
    //   43: new 6	com/tencent/mm/media/d/j$a
    //   46: dup
    //   47: aload_0
    //   48: aload 5
    //   50: invokespecial 88	com/tencent/mm/media/d/j$a:<init>	(Lcom/tencent/mm/media/d/j;Lcom/tencent/mm/media/f/a;)V
    //   53: putfield 90	com/tencent/mm/media/d/j:nzn	Lcom/tencent/mm/media/d/j$a;
    //   56: aload_0
    //   57: aload 5
    //   59: getfield 96	com/tencent/mm/media/f/a:nAs	Landroid/media/MediaFormat;
    //   62: putfield 99	com/tencent/mm/media/d/f:mediaFormat	Landroid/media/MediaFormat;
    //   65: aload_0
    //   66: aload 5
    //   68: invokevirtual 103	com/tencent/mm/media/f/a:bpp	()Ljava/lang/String;
    //   71: invokestatic 109	com/tencent/mm/compatible/deviceinfo/aa:Dw	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   74: putfield 113	com/tencent/mm/media/d/f:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   77: aload_0
    //   78: getfield 75	com/tencent/mm/media/d/j:TAG	Ljava/lang/String;
    //   81: ldc 115
    //   83: aload 5
    //   85: invokevirtual 103	com/tencent/mm/media/f/a:bpp	()Ljava/lang/String;
    //   88: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   91: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: bipush 23
    //   96: invokestatic 130	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   99: ifeq +94 -> 193
    //   102: aload_0
    //   103: getfield 85	com/tencent/mm/media/d/j:decoderThread	Landroid/os/HandlerThread;
    //   106: invokevirtual 136	android/os/HandlerThread:start	()V
    //   109: new 138	android/os/Handler
    //   112: dup
    //   113: aload_0
    //   114: getfield 85	com/tencent/mm/media/d/j:decoderThread	Landroid/os/HandlerThread;
    //   117: invokevirtual 142	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   120: invokespecial 145	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   123: astore 5
    //   125: aload_0
    //   126: getfield 113	com/tencent/mm/media/d/f:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   129: astore 10
    //   131: aload 10
    //   133: invokestatic 149	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   136: aload 10
    //   138: aload_0
    //   139: getfield 90	com/tencent/mm/media/d/j:nzn	Lcom/tencent/mm/media/d/j$a;
    //   142: checkcast 151	android/media/MediaCodec$Callback
    //   145: aload 5
    //   147: invokevirtual 155	com/tencent/mm/compatible/deviceinfo/aa:setCallback	(Landroid/media/MediaCodec$Callback;Landroid/os/Handler;)V
    //   150: aload_0
    //   151: getfield 113	com/tencent/mm/media/d/f:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   154: astore 5
    //   156: aload 5
    //   158: invokestatic 149	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   161: aload 5
    //   163: aload_0
    //   164: getfield 99	com/tencent/mm/media/d/f:mediaFormat	Landroid/media/MediaFormat;
    //   167: aload 6
    //   169: iconst_0
    //   170: invokevirtual 159	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   173: aload 9
    //   175: ifnull +12 -> 187
    //   178: aload 9
    //   180: aload_0
    //   181: invokeinterface 165 2 0
    //   186: pop
    //   187: ldc 65
    //   189: invokestatic 168	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: return
    //   193: aload_0
    //   194: getfield 113	com/tencent/mm/media/d/f:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   197: astore 5
    //   199: aload 5
    //   201: invokestatic 149	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   204: aload 5
    //   206: aload_0
    //   207: getfield 90	com/tencent/mm/media/d/j:nzn	Lcom/tencent/mm/media/d/j$a;
    //   210: checkcast 151	android/media/MediaCodec$Callback
    //   213: invokevirtual 171	com/tencent/mm/compatible/deviceinfo/aa:setCallback	(Landroid/media/MediaCodec$Callback;)V
    //   216: goto -66 -> 150
    //   219: astore 5
    //   221: aload_0
    //   222: getfield 75	com/tencent/mm/media/d/j:TAG	Ljava/lang/String;
    //   225: aload 5
    //   227: checkcast 173	java/lang/Throwable
    //   230: ldc 175
    //   232: aload 5
    //   234: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   237: invokestatic 119	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   240: iconst_0
    //   241: anewarray 180	java/lang/Object
    //   244: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: new 186	java/lang/IllegalStateException
    //   250: dup
    //   251: ldc 188
    //   253: invokespecial 191	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   256: astore 5
    //   258: ldc 65
    //   260: invokestatic 168	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload 5
    //   265: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	j
    //   0	266	1	paramLong1	long
    //   0	266	3	paramLong2	long
    //   0	266	5	parama	com.tencent.mm.media.f.a
    //   0	266	6	paramSurface	android.view.Surface
    //   0	266	7	paramInt	int
    //   0	266	8	paramBoolean	boolean
    //   0	266	9	paramb	b<? super f, kotlin.ah>
    //   129	8	10	localaa	aa
    // Exception table:
    //   from	to	target	type
    //   56	150	219	java/lang/Exception
    //   150	173	219	java/lang/Exception
    //   193	216	219	java/lang/Exception
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(93554);
    super.releaseDecoder();
    try
    {
      this.decoderThread.quit();
      AppMethodBeat.o(93554);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, s.X("releaseDecoder error:", localException.getMessage()), new Object[0]);
      AppMethodBeat.o(93554);
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(93553);
    try
    {
      aa localaa = this.nyz;
      s.checkNotNull(localaa);
      localaa.start();
      AppMethodBeat.o(93553);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "startDecode error", new Object[0]);
      AppMethodBeat.o(93553);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends MediaCodec.Callback
  {
    a(j paramj, com.tencent.mm.media.f.a parama) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93552);
      s.u(paramMediaCodec, "codec");
      s.u(paramCodecException, "e");
      Log.e(this.nzo.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if (this.nzo.nyT)
      {
        paramMediaCodec = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brX();
      }
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        paramMediaCodec = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brY();
        this.nzo.releaseDecoder();
        paramMediaCodec = this.nzo.nyN;
        if (paramMediaCodec != null) {
          paramMediaCodec.invoke();
        }
      }
      AppMethodBeat.o(93552);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93550);
      s.u(paramMediaCodec, "codec");
      Log.i(this.nzo.TAG, s.X("onInputBufferAvailable, index:", Integer.valueOf(paramInt)));
      if (paramInt >= 0)
      {
        try
        {
          paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
          if (paramMediaCodec != null) {
            break label105;
          }
          paramMediaCodec = new NullPointerException("null cannot be cast to non-null type java.nio.ByteBuffer");
          AppMethodBeat.o(93550);
          throw paramMediaCodec;
        }
        catch (Exception paramMediaCodec)
        {
          Log.printErrStackTrace(this.nzo.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
          if (this.nzo.nyT)
          {
            paramMediaCodec = com.tencent.mm.media.util.f.nFE;
            com.tencent.mm.media.util.f.brW();
          }
        }
      }
      else
      {
        AppMethodBeat.o(93550);
        return;
      }
      label105:
      paramMediaCodec.clear();
      if (com.tencent.mm.media.f.a.a(parama, paramMediaCodec))
      {
        long l = parama.getSampleTime();
        int i = parama.sampleSize;
        Log.i(this.nzo.TAG, "input sampleTime:" + l + ", sampleSize:" + i);
        paramMediaCodec.position(0);
        paramMediaCodec = this.nzo.nyz;
        s.checkNotNull(paramMediaCodec);
        paramMediaCodec.a(paramInt, i, l, 0);
        AppMethodBeat.o(93550);
        return;
      }
      Log.i(this.nzo.TAG, "read sample end");
      this.nzo.nze = true;
      paramMediaCodec = this.nzo.nyz;
      s.checkNotNull(paramMediaCodec);
      paramMediaCodec.a(paramInt, 0, 0L, 4);
      AppMethodBeat.o(93550);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93549);
      s.u(paramMediaCodec, "codec");
      s.u(paramBufferInfo, "bufferInfo");
      Log.i(this.nzo.TAG, "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", isFinished:" + this.nzo.isFinished);
      if (paramInt >= 0)
      {
        do
        {
          try
          {
            long l = paramBufferInfo.presentationTimeUs;
            Log.i(this.nzo.TAG, s.X("presentationTimeUs : ", Long.valueOf(l)));
            if ((l < this.nzo.startTimeMs * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
            {
              paramMediaCodec = this.nzo.nyz;
              s.checkNotNull(paramMediaCodec);
              paramMediaCodec.releaseOutputBuffer(paramInt, false);
              Log.i(this.nzo.TAG, "decoder pts: " + l + ", not reach start: " + this.nzo.startTimeMs * 1000L);
              AppMethodBeat.o(93549);
              return;
            }
            this.nzo.a(paramInt, paramBufferInfo);
            if ((this.nzo.endTimeMs * 1000L != 1L) && (l >= this.nzo.endTimeMs * 1000L))
            {
              Log.e(this.nzo.TAG, "exceed endTimeMs");
              j.a(this.nzo);
              this.nzo.releaseDecoder();
              AppMethodBeat.o(93549);
              return;
            }
          }
          catch (Exception paramMediaCodec)
          {
            Log.printErrStackTrace(this.nzo.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
            if (this.nzo.nyT)
            {
              paramMediaCodec = com.tencent.mm.media.util.f.nFE;
              com.tencent.mm.media.util.f.brW();
            }
            AppMethodBeat.o(93549);
            return;
          }
        } while (((paramBufferInfo.flags & 0x4) == 0) && (!this.nzo.nze));
        Log.i(this.nzo.TAG, "receive eos!");
        j.a(this.nzo);
        this.nzo.releaseDecoder();
        AppMethodBeat.o(93549);
        return;
      }
      paramMediaCodec = this.nzo.nyz;
      s.checkNotNull(paramMediaCodec);
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93549);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93551);
      s.u(paramMediaCodec, "codec");
      s.u(paramMediaFormat, "format");
      this.nzo.mediaFormat = paramMediaFormat;
      Log.i(this.nzo.TAG, s.X("decoder output format changed: ", this.nzo.mediaFormat));
      paramMediaCodec = this.nzo.mediaFormat;
      if (paramMediaCodec != null)
      {
        paramMediaFormat = this.nzo.nyM;
        if (paramMediaFormat != null) {
          paramMediaFormat.invoke(paramMediaCodec);
        }
      }
      AppMethodBeat.o(93551);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.d.j
 * JD-Core Version:    0.7.0.1
 */