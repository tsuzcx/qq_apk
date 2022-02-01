package com.tencent.mm.plugin.emojicapture.model.b;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "videoDuration", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;ILandroid/view/Surface;)V", "TAG", "codecCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1;", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "inputEos", "", "inputSampleTime", "", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "init", "processDecodeBuffer", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "plugin-emojicapture_release"})
public final class j
  extends l
{
  final String TAG;
  private String aFM;
  private HandlerThread decoderThread;
  aa kSN;
  MediaFormat mediaFormat;
  c miS;
  private final Surface surface;
  private final Object uVI;
  boolean uVK;
  long uVL;
  private final a uVM;
  private final int videoDuration;
  private final String videoPath;
  
  public j(String paramString, int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(297);
    this.videoPath = paramString;
    this.videoDuration = paramInt;
    this.surface = paramSurface;
    this.TAG = "MicroMsg.EmojiMixVideoDecoderAsync";
    this.miS = new c();
    this.aFM = "";
    this.decoderThread = com.tencent.e.c.d.ik("EmojiMixVideoDecoderAsync_decodeThread", 5);
    this.uVI = new Object();
    this.uVM = new a(this);
    try
    {
      Log.i(this.TAG, "create decoder with path: " + this.videoPath);
      this.miS.setDataSource(this.videoPath);
      int i = this.miS.getTrackCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramString = this.miS.getTrackFormat(paramInt);
        p.j(paramString, "extractor.getTrackFormat(i)");
        paramSurface = paramString.getString("mime");
        p.j(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
        if (n.g((CharSequence)paramSurface, (CharSequence)"video") == true)
        {
          paramSurface = paramString.getString("mime");
          p.j(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
          this.aFM = paramSurface;
          this.mediaFormat = paramString;
          Log.i(this.TAG, "find video format " + this.mediaFormat + ", mime: " + this.aFM);
          this.miS.selectTrack(paramInt);
          AppMethodBeat.o(297);
          return;
        }
        paramInt += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
      AppMethodBeat.o(297);
    }
  }
  
  public final void cYf()
  {
    AppMethodBeat.i(295);
    synchronized (this.uVI)
    {
      try
      {
        this.uVI.notifyAll();
        x localx = x.aazN;
        AppMethodBeat.o(295);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  public final int init()
  {
    AppMethodBeat.i(293);
    if ((this.mediaFormat != null) && (!Util.isNullOrNil(this.aFM))) {
      try
      {
        this.kSN = aa.KR(this.aFM);
        Object localObject = this.kSN;
        if (localObject != null) {
          ((aa)localObject).a(this.mediaFormat, this.surface, 0);
        }
        if (com.tencent.mm.compatible.util.d.qV(23))
        {
          this.decoderThread.start();
          localObject = this.decoderThread;
          p.j(localObject, "decoderThread");
          localObject = new Handler(((HandlerThread)localObject).getLooper());
          aa localaa = this.kSN;
          if (localaa != null) {
            localaa.a((MediaCodec.Callback)this.uVM, (Handler)localObject);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(293);
          return 0;
          localObject = this.kSN;
          if (localObject != null) {
            ((aa)localObject).a((MediaCodec.Callback)this.uVM);
          }
        }
        AppMethodBeat.o(293);
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "init decoder error " + localException.getMessage());
        AppMethodBeat.o(293);
        return -1;
      }
    }
    return -1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(296);
    Log.i(this.TAG, "release");
    try
    {
      this.decoderThread.quit();
      aa localaa = this.kSN;
      if (localaa != null) {
        localaa.stop();
      }
      localaa = this.kSN;
      if (localaa != null)
      {
        localaa.release();
        AppMethodBeat.o(296);
        return;
      }
      AppMethodBeat.o(296);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(296);
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(294);
    if (this.kSN == null)
    {
      localObject = this.uWe;
      if (localObject != null)
      {
        ((a)localObject).invoke();
        AppMethodBeat.o(294);
        return;
      }
      AppMethodBeat.o(294);
      return;
    }
    Object localObject = this.kSN;
    if (localObject != null)
    {
      ((aa)localObject).start();
      AppMethodBeat.o(294);
      return;
    }
    AppMethodBeat.o(294);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-emojicapture_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(292);
      p.k(paramMediaCodec, "codec");
      p.k(paramCodecException, "e");
      Log.e(this.uVN.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        j.a(this.uVN);
        this.uVN.release();
        paramMediaCodec = this.uVN.uWe;
        if (paramMediaCodec != null)
        {
          paramMediaCodec.invoke();
          AppMethodBeat.o(292);
          return;
        }
      }
      AppMethodBeat.o(292);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(290);
      p.k(paramMediaCodec, "codec");
      Log.i(this.uVN.TAG, "onInputBufferAvailable ".concat(String.valueOf(paramInt)));
      if (paramInt >= 0) {}
      for (;;)
      {
        int j;
        long l;
        try
        {
          if (this.uVN.uVK) {
            break label282;
          }
          paramMediaCodec = this.uVN.kSN;
          if (paramMediaCodec == null) {
            break label307;
          }
          paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
          if (paramMediaCodec == null)
          {
            Log.w(this.uVN.TAG, "inputBuffer is null");
            AppMethodBeat.o(290);
            return;
          }
          paramMediaCodec.clear();
          j = this.uVN.miS.readSampleData(paramMediaCodec, 0);
          this.uVN.miS.advance();
          paramMediaCodec.position(0);
          l = this.uVN.miS.getSampleTime();
          Log.i(this.uVN.TAG, "sampleTime: " + l + ", sampleSize: " + j);
          if (l <= this.uVN.uVL) {
            break label312;
          }
          this.uVN.uVL = l;
        }
        catch (Exception paramMediaCodec)
        {
          label196:
          Log.printErrStackTrace(this.uVN.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable", new Object[0]);
        }
        Log.i(this.uVN.TAG, "read sample end");
        boolean bool = true;
        label211:
        this.uVN.uVK = bool;
        paramMediaCodec = this.uVN.kSN;
        if (paramMediaCodec != null)
        {
          if (this.uVN.uVK)
          {
            i = 4;
            paramMediaCodec.a(paramInt, j, l, i);
            AppMethodBeat.o(290);
            return;
            label282:
            AppMethodBeat.o(290);
            return;
          }
          int i = 0;
          continue;
        }
        AppMethodBeat.o(290);
        return;
        label307:
        label312:
        do
        {
          bool = false;
          break label211;
          paramMediaCodec = null;
          break;
          if (j < 0) {
            break label196;
          }
        } while (l >= 0L);
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(289);
      p.k(paramMediaCodec, "codec");
      p.k(paramBufferInfo, "info");
      Log.i(this.uVN.TAG, "onOutputBufferAvailable " + paramInt + ", flags " + paramBufferInfo.flags);
      if (paramInt >= 0) {}
      for (;;)
      {
        long l1;
        long l2;
        try
        {
          if (paramBufferInfo.size == 0) {
            break label268;
          }
          l1 = paramBufferInfo.presentationTimeUs;
          Log.i(this.uVN.TAG, "presentationTimeUs: " + l1 + ", inputSampleTime: " + this.uVN.uVL);
          paramMediaCodec = this.uVN.kSN;
          if (paramMediaCodec != null) {
            paramMediaCodec.releaseOutputBuffer(paramInt, true);
          }
          j.a(this.uVN, paramBufferInfo);
          if (this.uVN.uVK)
          {
            l2 = this.uVN.uVL;
            if (0L <= l1) {
              break label300;
            }
            Log.i(this.uVN.TAG, "receive eos!");
            j.a(this.uVN);
            this.uVN.release();
            paramMediaCodec = this.uVN.uWe;
            if (paramMediaCodec == null) {
              continue;
            }
            paramMediaCodec.invoke();
            AppMethodBeat.o(289);
            return;
          }
          paramInt = paramBufferInfo.flags;
          if ((paramInt & 0x4) != 0) {
            continue;
          }
        }
        catch (Exception paramMediaCodec)
        {
          Log.printErrStackTrace(this.uVN.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable", new Object[0]);
          continue;
        }
        AppMethodBeat.o(289);
        return;
        AppMethodBeat.o(289);
        return;
        label268:
        paramMediaCodec = this.uVN.kSN;
        if (paramMediaCodec != null)
        {
          paramMediaCodec.releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(289);
          return;
        }
        AppMethodBeat.o(289);
        return;
        label300:
        if (l2 <= l1) {}
      }
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(291);
      p.k(paramMediaCodec, "codec");
      p.k(paramMediaFormat, "format");
      Log.i(this.uVN.TAG, "onOutputFormatChanged ".concat(String.valueOf(paramMediaFormat)));
      this.uVN.mediaFormat = paramMediaFormat;
      AppMethodBeat.o(291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.j
 * JD-Core Version:    0.7.0.1
 */