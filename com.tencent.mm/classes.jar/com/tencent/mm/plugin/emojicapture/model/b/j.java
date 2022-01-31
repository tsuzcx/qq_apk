package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.a.a;
import a.l.m;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.Callback;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "videoDuration", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;ILandroid/view/Surface;)V", "TAG", "codecCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1;", "decoder", "Landroid/media/MediaCodec;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "extractor", "Landroid/media/MediaExtractor;", "inputEos", "", "inputSampleTime", "", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "init", "processDecodeBuffer", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "plugin-emojicapture_release"})
public final class j
  extends l
{
  final String TAG;
  private final Surface axw;
  MediaExtractor cfO;
  private String cfP;
  MediaCodec eRD;
  HandlerThread eSt;
  private final int eVA;
  final Object luN;
  boolean luP;
  long luQ;
  private final j.a luR;
  MediaFormat mediaFormat;
  private final String videoPath;
  
  public j(String paramString, int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(2696);
    this.videoPath = paramString;
    this.eVA = paramInt;
    this.axw = paramSurface;
    this.TAG = "MicroMsg.EmojiMixVideoDecoderAsync";
    this.cfO = new MediaExtractor();
    this.cfP = "";
    this.eSt = com.tencent.mm.sdk.g.d.aqu("EmojiMixVideoDecoderAsync_decodeThread");
    this.luN = new Object();
    this.luR = new j.a(this);
    try
    {
      ab.i(this.TAG, "create decoder with path: " + this.videoPath);
      this.cfO.setDataSource(this.videoPath);
      int i = this.cfO.getTrackCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramString = this.cfO.getTrackFormat(paramInt);
        paramSurface = paramString.getString("mime");
        a.f.b.j.p(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
        if (m.d((CharSequence)paramSurface, (CharSequence)"video") == true)
        {
          paramSurface = paramString.getString("mime");
          a.f.b.j.p(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
          this.cfP = paramSurface;
          this.mediaFormat = paramString;
          ab.i(this.TAG, "find video format " + this.mediaFormat + ", mime: " + this.cfP);
          this.cfO.selectTrack(paramInt);
          AppMethodBeat.o(2696);
          return;
        }
        paramInt += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
      AppMethodBeat.o(2696);
    }
  }
  
  public final void boK()
  {
    AppMethodBeat.i(2695);
    synchronized (this.luN)
    {
      try
      {
        this.luN.notifyAll();
        y localy = y.BMg;
        AppMethodBeat.o(2695);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  public final int init()
  {
    AppMethodBeat.i(2693);
    if ((this.mediaFormat != null) && (!bo.isNullOrNil(this.cfP))) {
      try
      {
        this.eRD = MediaCodec.createDecoderByType(this.cfP);
        Object localObject = this.eRD;
        if (localObject != null) {
          ((MediaCodec)localObject).configure(this.mediaFormat, this.axw, null, 0);
        }
        if (com.tencent.mm.compatible.util.d.fv(23))
        {
          this.eSt.start();
          localObject = this.eSt;
          a.f.b.j.p(localObject, "decoderThread");
          localObject = new Handler(((HandlerThread)localObject).getLooper());
          MediaCodec localMediaCodec = this.eRD;
          if (localMediaCodec != null) {
            localMediaCodec.setCallback((MediaCodec.Callback)this.luR, (Handler)localObject);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(2693);
          return 0;
          localObject = this.eRD;
          if (localObject != null) {
            ((MediaCodec)localObject).setCallback((MediaCodec.Callback)this.luR);
          }
        }
        AppMethodBeat.o(2693);
      }
      catch (Exception localException)
      {
        ab.e(this.TAG, "init decoder error " + localException.getMessage());
        AppMethodBeat.o(2693);
        return -1;
      }
    }
    return -1;
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(2694);
    if (this.eRD == null)
    {
      localObject = this.lvj;
      if (localObject != null)
      {
        ((a)localObject).invoke();
        AppMethodBeat.o(2694);
        return;
      }
      AppMethodBeat.o(2694);
      return;
    }
    Object localObject = this.eRD;
    if (localObject != null)
    {
      ((MediaCodec)localObject).start();
      AppMethodBeat.o(2694);
      return;
    }
    AppMethodBeat.o(2694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.j
 * JD-Core Version:    0.7.0.1
 */