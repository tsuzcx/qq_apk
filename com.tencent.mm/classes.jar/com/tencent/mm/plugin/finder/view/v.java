package com.tencent.mm.plugin.finder.view;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "", "path", "", "textureView", "Landroid/view/TextureView;", "(Ljava/lang/String;Landroid/view/TextureView;)V", "TAG", "canPauseInput", "", "getCanPauseInput", "()Z", "setCanPauseInput", "(Z)V", "curInputTimeUs", "", "getCurInputTimeUs", "()J", "setCurInputTimeUs", "(J)V", "curOutputTimeUs", "getCurOutputTimeUs", "setCurOutputTimeUs", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "getExtractor", "()Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "setExtractor", "(Lcom/tencent/mm/compatible/video/VFSMediaExtractor;)V", "frameFlagExtractor", "getFrameFlagExtractor", "setFrameFlagExtractor", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "hasStart", "getHasStart", "setHasStart", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "lastSeekTimeMs", "getLastSeekTimeMs", "setLastSeekTimeMs", "lastSyncFrameTimeUs", "getLastSyncFrameTimeUs", "setLastSyncFrameTimeUs", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "mime", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "getPath", "getTextureView", "()Landroid/view/TextureView;", "destroy", "", "releaseDecoder", "seekTo", "timeMs", "start", "onTextureReady", "Lkotlin/Function0;", "onTextureDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public c GDE;
  public HandlerThread GDF;
  public long GDG;
  public long GDH;
  private long GDI;
  public long GDJ;
  boolean GDK;
  public final String TAG;
  public String cBw;
  public final TextureView cHz;
  public MediaCodec decoder;
  public MMHandler handler;
  public final Object lock;
  public MediaFormat mediaFormat;
  public boolean mvL;
  public final String path;
  public c pcp;
  
  public v(String paramString, TextureView paramTextureView)
  {
    AppMethodBeat.i(344394);
    this.path = paramString;
    this.cHz = paramTextureView;
    this.TAG = "Finder.FinderVideoFrameSeeker";
    this.lock = new Object();
    this.GDG = -1L;
    this.GDH = -1L;
    this.GDI = -1L;
    this.GDJ = -1L;
    AppMethodBeat.o(344394);
  }
  
  public final String OT()
  {
    AppMethodBeat.i(344414);
    String str = this.cBw;
    if (str != null)
    {
      AppMethodBeat.o(344414);
      return str;
    }
    s.bIx("mime");
    AppMethodBeat.o(344414);
    return null;
  }
  
  public final c flw()
  {
    AppMethodBeat.i(344398);
    c localc = this.pcp;
    if (localc != null)
    {
      AppMethodBeat.o(344398);
      return localc;
    }
    s.bIx("extractor");
    AppMethodBeat.o(344398);
    return null;
  }
  
  public final c flx()
  {
    AppMethodBeat.i(344404);
    c localc = this.GDE;
    if (localc != null)
    {
      AppMethodBeat.o(344404);
      return localc;
    }
    s.bIx("frameFlagExtractor");
    AppMethodBeat.o(344404);
    return null;
  }
  
  public final HandlerThread fly()
  {
    AppMethodBeat.i(344421);
    HandlerThread localHandlerThread = this.GDF;
    if (localHandlerThread != null)
    {
      AppMethodBeat.o(344421);
      return localHandlerThread;
    }
    s.bIx("ht");
    AppMethodBeat.o(344421);
    return null;
  }
  
  public final MediaFormat getMediaFormat()
  {
    AppMethodBeat.i(344409);
    MediaFormat localMediaFormat = this.mediaFormat;
    if (localMediaFormat != null)
    {
      AppMethodBeat.o(344409);
      return localMediaFormat;
    }
    s.bIx("mediaFormat");
    AppMethodBeat.o(344409);
    return null;
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(344427);
    MediaCodec localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
    localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.release();
    }
    this.decoder = null;
    AppMethodBeat.o(344427);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    public a(v paramv, a<ah> parama1, b<? super Long, ah> paramb, a<ah> parama2) {}
    
    private static final void a(v paramv, SurfaceTexture paramSurfaceTexture, final b paramb, a parama)
    {
      AppMethodBeat.i(344611);
      s.u(paramv, "this$0");
      s.u(paramSurfaceTexture, "$surface");
      s.u(paramb, "$onSeekFrame");
      s.u(parama, "$onTextureReady");
      if (paramv.decoder != null) {
        paramv.releaseDecoder();
      }
      paramv.decoder = MediaCodec.createDecoderByType(paramv.OT());
      MediaCodec localMediaCodec = paramv.decoder;
      if (localMediaCodec != null)
      {
        localMediaCodec.setCallback((MediaCodec.Callback)new a(paramv, paramb));
        localMediaCodec.configure(paramv.getMediaFormat(), new Surface(paramSurfaceTexture), null, 0);
        paramv.cHz.post(new v.a..ExternalSyntheticLambda1(parama));
      }
      AppMethodBeat.o(344611);
    }
    
    private static final void bB(a parama)
    {
      AppMethodBeat.i(344603);
      s.u(parama, "$onTextureReady");
      parama.invoke();
      AppMethodBeat.o(344603);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(344650);
      s.u(paramSurfaceTexture, "surface");
      MMHandler localMMHandler = this.GDL.handler;
      if (localMMHandler != null) {}
      for (;;)
      {
        localMMHandler.post(new v.a..ExternalSyntheticLambda0(this.GDL, paramSurfaceTexture, this.GmK, this.GDN));
        AppMethodBeat.o(344650);
        return;
        s.bIx("handler");
        localMMHandler = null;
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(344641);
      s.u(paramSurfaceTexture, "surface");
      this.GDL.releaseDecoder();
      this.GDM.invoke();
      AppMethodBeat.o(344641);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(344631);
      s.u(paramSurfaceTexture, "surface");
      AppMethodBeat.o(344631);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(344636);
      s.u(paramSurfaceTexture, "surface");
      AppMethodBeat.o(344636);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "decoder", "inputIndex", "", "onOutputBufferAvailable", "outputIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends MediaCodec.Callback
    {
      a(v paramv, b<? super Long, ah> paramb) {}
      
      public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
      {
        AppMethodBeat.i(344528);
        s.u(paramMediaCodec, "codec");
        s.u(paramCodecException, "e");
        AppMethodBeat.o(344528);
      }
      
      public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
      {
        AppMethodBeat.i(344522);
        s.u(paramMediaCodec, "decoder");
        Log.i(this.GDL.TAG, "lxl onInputBufferAvailable");
        localObject = this.GDL.lock;
        localv = this.GDL;
        if (paramInt >= 0) {}
        for (;;)
        {
          try
          {
            ByteBuffer localByteBuffer = paramMediaCodec.getInputBuffer(paramInt);
            c localc = localv.flw();
            s.checkNotNull(localByteBuffer);
            i = localc.readSampleData(localByteBuffer, 0);
            if (i < 0)
            {
              Log.i(localv.TAG, "lxl queueInputBuffer BUFFER_FLAG_END_OF_STREAM");
              paramMediaCodec.queueInputBuffer(paramInt, 0, 0, 0L, 4);
              if (localv.GDK)
              {
                localv.lock.wait();
                localv.GDK = false;
              }
            }
          }
          finally
          {
            int i;
            Log.printErrStackTrace(localv.TAG, paramMediaCodec, "lxl onInputBufferAvailable exception", new Object[0]);
            continue;
          }
          try
          {
            paramMediaCodec = ah.aiuX;
            return;
          }
          finally
          {
            AppMethodBeat.o(344522);
          }
          paramMediaCodec.queueInputBuffer(paramInt, 0, i, localv.flw().lZm.getSampleTime(), 0);
          localv.flw().lZm.advance();
          Log.i(localv.TAG, s.X("lxl queueInputBuffer ", Long.valueOf(localv.flw().lZm.getSampleTime() / 1000L)));
        }
      }
      
      public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
      {
        AppMethodBeat.i(344511);
        s.u(paramMediaCodec, "decoder");
        s.u(paramBufferInfo, "bufferInfo");
        Log.i(this.GDL.TAG, "lxl onOutputBufferAvailable");
        switch (paramInt)
        {
        default: 
          if (paramInt < 0) {
            break;
          }
        }
        try
        {
          if ((paramBufferInfo.flags & 0x4) == 0) {
            break label129;
          }
          Log.i(this.GDL.TAG, "lxl releaseOutputBuffer BUFFER_FLAG_END_OF_STREAM");
          paramMediaCodec.releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(344511);
          return;
        }
        finally
        {
          Log.printErrStackTrace(this.GDL.TAG, paramMediaCodec, "lxl onOutputBufferAvailable exception", new Object[0]);
          AppMethodBeat.o(344511);
          return;
        }
        paramMediaCodec.releaseOutputBuffer(paramInt, false);
        AppMethodBeat.o(344511);
        return;
        label129:
        Object localObject;
        if (paramBufferInfo.presentationTimeUs >= this.GDL.GDG * 1000L)
        {
          paramMediaCodec.releaseOutputBuffer(paramInt, true);
          paramb.invoke(Long.valueOf(paramBufferInfo.presentationTimeUs));
          Log.i(this.GDL.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", render!");
          paramMediaCodec = this.GDL.lock;
          localObject = this.GDL;
        }
        for (;;)
        {
          try
          {
            ((v)localObject).GDK = true;
            localObject = ah.aiuX;
            this.GDL.GDJ = paramBufferInfo.presentationTimeUs;
            AppMethodBeat.o(344511);
            return;
          }
          finally
          {
            AppMethodBeat.o(344511);
          }
          Log.i(this.GDL.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", no");
          paramMediaCodec.releaseOutputBuffer(paramInt, false);
        }
      }
      
      public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
      {
        AppMethodBeat.i(344525);
        s.u(paramMediaCodec, "codec");
        s.u(paramMediaFormat, "format");
        AppMethodBeat.o(344525);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.v
 * JD-Core Version:    0.7.0.1
 */