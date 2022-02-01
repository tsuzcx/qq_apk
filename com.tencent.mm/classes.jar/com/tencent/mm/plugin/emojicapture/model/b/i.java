package com.tencent.mm.plugin.emojicapture.model.b;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaExtractor;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "videoDuration", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;ILandroid/view/Surface;)V", "TAG", "codecCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1;", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "inputEos", "", "inputSampleTime", "", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "init", "processDecodeBuffer", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends k
{
  final String TAG;
  private String cBw;
  private HandlerThread decoderThread;
  MediaFormat mediaFormat;
  aa nyz;
  c pcp;
  private final Surface surface;
  private final int videoDuration;
  private final String videoPath;
  private final Object yik;
  boolean yim;
  long yin;
  private final a yio;
  
  public i(String paramString, int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(297);
    this.videoPath = paramString;
    this.videoDuration = paramInt;
    this.surface = paramSurface;
    this.TAG = "MicroMsg.EmojiMixVideoDecoderAsync";
    this.pcp = new c();
    this.cBw = "";
    this.decoderThread = com.tencent.threadpool.c.d.jw("EmojiMixVideoDecoderAsync_decodeThread", 5);
    this.yik = new Object();
    this.yio = new a(this);
    for (;;)
    {
      int i;
      try
      {
        Log.i(this.TAG, s.X("create decoder with path: ", this.videoPath));
        this.pcp.setDataSource(this.videoPath);
        int j = this.pcp.lZm.getTrackCount();
        if (j > 0)
        {
          paramInt = 0;
          i = paramInt + 1;
          paramString = this.pcp.getTrackFormat(paramInt);
          s.s(paramString, "extractor.getTrackFormat(i)");
          paramSurface = paramString.getString("mime");
          s.checkNotNull(paramSurface);
          s.s(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)!!");
          if (n.i((CharSequence)paramSurface, (CharSequence)"video") == true)
          {
            paramSurface = paramString.getString("mime");
            s.checkNotNull(paramSurface);
            s.s(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)!!");
            this.cBw = paramSurface;
            this.mediaFormat = paramString;
            Log.i(this.TAG, "find video format " + this.mediaFormat + ", mime: " + this.cBw);
            this.pcp.selectTrack(paramInt);
            AppMethodBeat.o(297);
            return;
          }
          if (i < j) {
            break label311;
          }
          AppMethodBeat.o(297);
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
        AppMethodBeat.o(297);
        return;
      }
      label311:
      paramInt = i;
    }
  }
  
  public final void dEv()
  {
    AppMethodBeat.i(295);
    synchronized (this.yik)
    {
      try
      {
        this.yik.notifyAll();
        ah localah = ah.aiuX;
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
    if ((this.mediaFormat != null) && (!Util.isNullOrNil(this.cBw))) {
      try
      {
        this.nyz = aa.Dw(this.cBw);
        Object localObject = this.nyz;
        if (localObject != null) {
          ((aa)localObject).a(this.mediaFormat, this.surface, 0);
        }
        if (com.tencent.mm.compatible.util.d.rb(23))
        {
          this.decoderThread.start();
          localObject = new Handler(this.decoderThread.getLooper());
          aa localaa = this.nyz;
          if (localaa != null) {
            localaa.setCallback((MediaCodec.Callback)this.yio, (Handler)localObject);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(293);
          return 0;
          localObject = this.nyz;
          if (localObject != null) {
            ((aa)localObject).setCallback((MediaCodec.Callback)this.yio);
          }
        }
        AppMethodBeat.o(293);
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, s.X("init decoder error ", localException.getMessage()));
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
      aa localaa = this.nyz;
      if (localaa != null) {
        localaa.stop();
      }
      localaa = this.nyz;
      if (localaa != null)
      {
        localaa.release();
        AppMethodBeat.o(296);
        return;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(296);
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(294);
    Object localObject;
    if (this.nyz == null)
    {
      localObject = this.yiD;
      if (localObject != null)
      {
        ((a)localObject).invoke();
        AppMethodBeat.o(294);
      }
    }
    else
    {
      localObject = this.nyz;
      if (localObject != null) {
        ((aa)localObject).start();
      }
    }
    AppMethodBeat.o(294);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends MediaCodec.Callback
  {
    a(i parami) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(292);
      s.u(paramMediaCodec, "codec");
      s.u(paramCodecException, "e");
      Log.e(this.yip.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        i.a(this.yip);
        this.yip.release();
        paramMediaCodec = this.yip.yiD;
        if (paramMediaCodec != null) {
          paramMediaCodec.invoke();
        }
      }
      AppMethodBeat.o(292);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(290);
      s.u(paramMediaCodec, "codec");
      Log.i(this.yip.TAG, s.X("onInputBufferAvailable ", Integer.valueOf(paramInt)));
      if (paramInt >= 0) {}
      for (;;)
      {
        int j;
        long l;
        try
        {
          if (this.yip.yim) {
            break label298;
          }
          paramMediaCodec = this.yip.nyz;
          if (paramMediaCodec == null)
          {
            paramMediaCodec = null;
            if (paramMediaCodec == null)
            {
              Log.w(this.yip.TAG, "inputBuffer is null");
              AppMethodBeat.o(290);
            }
          }
          else
          {
            paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
            continue;
          }
          paramMediaCodec.clear();
          j = this.yip.pcp.readSampleData(paramMediaCodec, 0);
          this.yip.pcp.lZm.advance();
          paramMediaCodec.position(0);
          l = this.yip.pcp.lZm.getSampleTime();
          Log.i(this.yip.TAG, "sampleTime: " + l + ", sampleSize: " + j);
          if (l <= this.yip.yin) {
            break label311;
          }
          this.yip.yin = l;
        }
        catch (Exception paramMediaCodec)
        {
          int i;
          Log.printErrStackTrace(this.yip.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable", new Object[0]);
        }
        Log.i(this.yip.TAG, "read sample end");
        boolean bool = true;
        label222:
        this.yip.yim = bool;
        paramMediaCodec = this.yip.nyz;
        if (paramMediaCodec != null)
        {
          if (this.yip.yim)
          {
            i = 4;
            paramMediaCodec.a(paramInt, j, l, i);
            AppMethodBeat.o(290);
            return;
          }
          i = 0;
          continue;
        }
        label298:
        AppMethodBeat.o(290);
        return;
        label311:
        do
        {
          bool = false;
          break label222;
          if (j < 0) {
            break;
          }
        } while (l >= 0L);
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      int i = 1;
      AppMethodBeat.i(289);
      s.u(paramMediaCodec, "codec");
      s.u(paramBufferInfo, "info");
      Log.i(this.yip.TAG, "onOutputBufferAvailable " + paramInt + ", flags " + paramBufferInfo.flags);
      if (paramInt >= 0) {}
      label296:
      label303:
      label308:
      label311:
      for (;;)
      {
        try
        {
          if (paramBufferInfo.size != 0)
          {
            long l = paramBufferInfo.presentationTimeUs;
            Log.i(this.yip.TAG, "presentationTimeUs: " + l + ", inputSampleTime: " + this.yip.yin);
            paramMediaCodec = this.yip.nyz;
            if (paramMediaCodec != null) {
              paramMediaCodec.releaseOutputBuffer(paramInt, true);
            }
            i.a(this.yip, paramBufferInfo);
            if (this.yip.yim)
            {
              if (0L > l) {
                break label308;
              }
              if (l >= this.yip.yin) {
                break label303;
              }
              paramInt = i;
              break label296;
            }
            if ((paramBufferInfo.flags & 0x4) != 0)
            {
              Log.i(this.yip.TAG, "receive eos!");
              i.a(this.yip);
              this.yip.release();
              paramMediaCodec = this.yip.yiD;
              if (paramMediaCodec != null) {
                paramMediaCodec.invoke();
              }
              AppMethodBeat.o(289);
            }
          }
          else
          {
            paramMediaCodec = this.yip.nyz;
            if (paramMediaCodec != null)
            {
              paramMediaCodec.releaseOutputBuffer(paramInt, false);
              AppMethodBeat.o(289);
              return;
            }
          }
        }
        catch (Exception paramMediaCodec)
        {
          Log.printErrStackTrace(this.yip.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable", new Object[0]);
          AppMethodBeat.o(289);
          return;
        }
        for (;;)
        {
          if (paramInt == 0) {
            break label311;
          }
          break;
          paramInt = 0;
          continue;
          paramInt = 0;
        }
      }
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(291);
      s.u(paramMediaCodec, "codec");
      s.u(paramMediaFormat, "format");
      Log.i(this.yip.TAG, s.X("onOutputFormatChanged ", paramMediaFormat));
      this.yip.mediaFormat = paramMediaFormat;
      AppMethodBeat.o(291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.i
 * JD-Core Version:    0.7.0.1
 */