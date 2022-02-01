package com.tencent.mm.plugin.finder.view;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "", "path", "", "textureView", "Landroid/view/TextureView;", "(Ljava/lang/String;Landroid/view/TextureView;)V", "TAG", "canPauseInput", "", "getCanPauseInput", "()Z", "setCanPauseInput", "(Z)V", "curInputTimeUs", "", "getCurInputTimeUs", "()J", "setCurInputTimeUs", "(J)V", "curOutputTimeUs", "getCurOutputTimeUs", "setCurOutputTimeUs", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "getExtractor", "()Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "setExtractor", "(Lcom/tencent/mm/compatible/video/VFSMediaExtractor;)V", "frameFlagExtractor", "getFrameFlagExtractor", "setFrameFlagExtractor", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "hasStart", "getHasStart", "setHasStart", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "lastSeekTimeMs", "getLastSeekTimeMs", "setLastSeekTimeMs", "lastSyncFrameTimeUs", "getLastSyncFrameTimeUs", "setLastSyncFrameTimeUs", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "mime", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "getPath", "getTextureView", "()Landroid/view/TextureView;", "destroy", "", "releaseDecoder", "seekTo", "timeMs", "start", "onTextureReady", "Lkotlin/Function0;", "onTextureDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class j
{
  public final String TAG;
  public final TextureView bef;
  public c ddy;
  public MediaCodec decoder;
  public boolean guO;
  public ap handler;
  public final Object lock;
  public MediaFormat mediaFormat;
  public String mime;
  public final String path;
  public c sWn;
  public HandlerThread sWo;
  public long sWp;
  public long sWq;
  private long sWr;
  public long sWs;
  boolean sWt;
  
  public j(String paramString, TextureView paramTextureView)
  {
    AppMethodBeat.i(205229);
    this.path = paramString;
    this.bef = paramTextureView;
    this.TAG = "Finder.FinderVideoFrameSeeker";
    this.lock = new Object();
    this.sWp = -1L;
    this.sWq = -1L;
    this.sWr = -1L;
    this.sWs = -1L;
    AppMethodBeat.o(205229);
  }
  
  public final c cND()
  {
    AppMethodBeat.i(205227);
    c localc = this.ddy;
    if (localc == null) {
      p.bcb("extractor");
    }
    AppMethodBeat.o(205227);
    return localc;
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(205228);
    MediaCodec localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
    localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.release();
    }
    this.decoder = null;
    AppMethodBeat.o(205228);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"})
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    public a(a parama1, b paramb, a parama2) {}
    
    public final void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205226);
      ap localap = this.sWu.handler;
      if (localap == null) {
        p.bcb("handler");
      }
      localap.post((Runnable)new a(this, paramSurfaceTexture));
      AppMethodBeat.o(205226);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(205225);
      this.sWu.releaseDecoder();
      this.sWv.invoke();
      AppMethodBeat.o(205225);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(j.a parama, SurfaceTexture paramSurfaceTexture) {}
      
      public final void run()
      {
        AppMethodBeat.i(205224);
        if (this.sWx.sWu.decoder != null) {
          this.sWx.sWu.releaseDecoder();
        }
        Object localObject1 = this.sWx.sWu;
        Object localObject2 = this.sWx.sWu.mime;
        if (localObject2 == null) {
          p.bcb("mime");
        }
        ((j)localObject1).decoder = MediaCodec.createDecoderByType((String)localObject2);
        localObject1 = this.sWx.sWu.decoder;
        if (localObject1 != null)
        {
          ((MediaCodec)localObject1).setCallback((MediaCodec.Callback)new a(this));
          localObject2 = this.sWx.sWu.mediaFormat;
          if (localObject2 == null) {
            p.bcb("mediaFormat");
          }
          ((MediaCodec)localObject1).configure((MediaFormat)localObject2, new Surface(paramSurfaceTexture), null, 0);
          this.sWx.sWu.bef.post((Runnable)new b(this));
          AppMethodBeat.o(205224);
          return;
        }
        AppMethodBeat.o(205224);
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "decoder", "inputIndex", "", "onOutputBufferAvailable", "outputIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-finder_release"})
      public static final class a
        extends MediaCodec.Callback
      {
        a(j.a.a parama) {}
        
        public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
        {
          AppMethodBeat.i(205222);
          p.h(paramMediaCodec, "codec");
          p.h(paramCodecException, "e");
          AppMethodBeat.o(205222);
        }
        
        public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
        {
          AppMethodBeat.i(205220);
          p.h(paramMediaCodec, "decoder");
          ad.i(this.sWz.sWx.sWu.TAG, "lxl onInputBufferAvailable");
          localObject = this.sWz.sWx.sWu.lock;
          if (paramInt >= 0) {}
          for (;;)
          {
            try
            {
              ByteBuffer localByteBuffer = paramMediaCodec.getInputBuffer(paramInt);
              i = this.sWz.sWx.sWu.cND().readSampleData(localByteBuffer, 0);
              if (i >= 0) {
                continue;
              }
              ad.i(this.sWz.sWx.sWu.TAG, "lxl queueInputBuffer BUFFER_FLAG_END_OF_STREAM");
              paramMediaCodec.queueInputBuffer(paramInt, 0, 0, 0L, 4);
              if (this.sWz.sWx.sWu.sWt)
              {
                this.sWz.sWx.sWu.lock.wait();
                this.sWz.sWx.sWu.sWt = false;
              }
            }
            catch (Throwable paramMediaCodec)
            {
              int i;
              ad.printErrStackTrace(this.sWz.sWx.sWu.TAG, paramMediaCodec, "lxl onInputBufferAvailable exception", new Object[0]);
              continue;
            }
            finally
            {
              AppMethodBeat.o(205220);
            }
            paramMediaCodec = z.MKo;
            AppMethodBeat.o(205220);
            return;
            paramMediaCodec.queueInputBuffer(paramInt, 0, i, this.sWz.sWx.sWu.cND().getSampleTime(), 0);
            this.sWz.sWx.sWu.cND().advance();
            ad.i(this.sWz.sWx.sWu.TAG, "lxl queueInputBuffer " + this.sWz.sWx.sWu.cND().getSampleTime() / 1000L);
          }
        }
        
        public final void onOutputBufferAvailable(MediaCodec arg1, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
        {
          AppMethodBeat.i(205219);
          p.h(???, "decoder");
          p.h(paramBufferInfo, "bufferInfo");
          ad.i(this.sWz.sWx.sWu.TAG, "lxl onOutputBufferAvailable");
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
              break label149;
            }
            ad.i(this.sWz.sWx.sWu.TAG, "lxl releaseOutputBuffer BUFFER_FLAG_END_OF_STREAM");
            ???.releaseOutputBuffer(paramInt, false);
            AppMethodBeat.o(205219);
            return;
          }
          catch (Throwable ???)
          {
            ad.printErrStackTrace(this.sWz.sWx.sWu.TAG, ???, "lxl onOutputBufferAvailable exception", new Object[0]);
            AppMethodBeat.o(205219);
            return;
          }
          ???.releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(205219);
          return;
          label149:
          if (paramBufferInfo.presentationTimeUs >= this.sWz.sWx.sWu.sWp * 1000L)
          {
            ???.releaseOutputBuffer(paramInt, true);
            this.sWz.sWx.sNl.invoke(Long.valueOf(paramBufferInfo.presentationTimeUs));
            ad.i(this.sWz.sWx.sWu.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", render!");
          }
          for (;;)
          {
            synchronized (this.sWz.sWx.sWu.lock)
            {
              this.sWz.sWx.sWu.sWt = true;
              z localz = z.MKo;
              this.sWz.sWx.sWu.sWs = paramBufferInfo.presentationTimeUs;
              AppMethodBeat.o(205219);
              return;
            }
            ad.i(this.sWz.sWx.sWu.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", no");
            ???.releaseOutputBuffer(paramInt, false);
          }
        }
        
        public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
        {
          AppMethodBeat.i(205221);
          p.h(paramMediaCodec, "codec");
          p.h(paramMediaFormat, "format");
          AppMethodBeat.o(205221);
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$2"})
      static final class b
        implements Runnable
      {
        b(j.a.a parama) {}
        
        public final void run()
        {
          AppMethodBeat.i(205223);
          this.sWz.sWx.sWw.invoke();
          AppMethodBeat.o(205223);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.j
 * JD-Core Version:    0.7.0.1
 */