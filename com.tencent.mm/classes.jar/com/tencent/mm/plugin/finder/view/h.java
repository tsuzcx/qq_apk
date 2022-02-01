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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "", "path", "", "textureView", "Landroid/view/TextureView;", "(Ljava/lang/String;Landroid/view/TextureView;)V", "TAG", "canPauseInput", "", "getCanPauseInput", "()Z", "setCanPauseInput", "(Z)V", "curInputTimeUs", "", "getCurInputTimeUs", "()J", "setCurInputTimeUs", "(J)V", "curOutputTimeUs", "getCurOutputTimeUs", "setCurOutputTimeUs", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "getExtractor", "()Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "setExtractor", "(Lcom/tencent/mm/compatible/video/VFSMediaExtractor;)V", "frameFlagExtractor", "getFrameFlagExtractor", "setFrameFlagExtractor", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "hasStart", "getHasStart", "setHasStart", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "lastSeekTimeMs", "getLastSeekTimeMs", "setLastSeekTimeMs", "lastSyncFrameTimeUs", "getLastSyncFrameTimeUs", "setLastSyncFrameTimeUs", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "mime", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "getPath", "getTextureView", "()Landroid/view/TextureView;", "destroy", "", "releaseDecoder", "seekTo", "timeMs", "start", "onTextureReady", "Lkotlin/Function0;", "onTextureDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class h
{
  public final String TAG;
  public final TextureView aTL;
  public c cSi;
  public MediaCodec decoder;
  public boolean gbe;
  public ao handler;
  public final Object lock;
  public MediaFormat mediaFormat;
  public String mime;
  public final String path;
  public c rZr;
  public HandlerThread rZs;
  public long rZt;
  public long rZu;
  private long rZv;
  public long rZw;
  boolean rZx;
  
  public h(String paramString, TextureView paramTextureView)
  {
    AppMethodBeat.i(204249);
    this.path = paramString;
    this.aTL = paramTextureView;
    this.TAG = "Finder.FinderVideoFrameSeeker";
    this.lock = new Object();
    this.rZt = -1L;
    this.rZu = -1L;
    this.rZv = -1L;
    this.rZw = -1L;
    AppMethodBeat.o(204249);
  }
  
  public final c cFj()
  {
    AppMethodBeat.i(204247);
    c localc = this.cSi;
    if (localc == null) {
      k.aVY("extractor");
    }
    AppMethodBeat.o(204247);
    return localc;
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(204248);
    MediaCodec localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
    localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.release();
    }
    this.decoder = null;
    AppMethodBeat.o(204248);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"})
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    public a(a parama1, b paramb, a parama2) {}
    
    public final void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204246);
      ao localao = this.rZy.handler;
      if (localao == null) {
        k.aVY("handler");
      }
      localao.post((Runnable)new a(this, paramSurfaceTexture));
      AppMethodBeat.o(204246);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(204245);
      this.rZy.releaseDecoder();
      this.rZz.invoke();
      AppMethodBeat.o(204245);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(h.a parama, SurfaceTexture paramSurfaceTexture) {}
      
      public final void run()
      {
        AppMethodBeat.i(204244);
        if (this.rZB.rZy.decoder != null) {
          this.rZB.rZy.releaseDecoder();
        }
        Object localObject1 = this.rZB.rZy;
        Object localObject2 = this.rZB.rZy.mime;
        if (localObject2 == null) {
          k.aVY("mime");
        }
        ((h)localObject1).decoder = MediaCodec.createDecoderByType((String)localObject2);
        localObject1 = this.rZB.rZy.decoder;
        if (localObject1 != null)
        {
          ((MediaCodec)localObject1).setCallback((MediaCodec.Callback)new a(this));
          localObject2 = this.rZB.rZy.mediaFormat;
          if (localObject2 == null) {
            k.aVY("mediaFormat");
          }
          ((MediaCodec)localObject1).configure((MediaFormat)localObject2, new Surface(paramSurfaceTexture), null, 0);
          this.rZB.rZy.aTL.post((Runnable)new b(this));
          AppMethodBeat.o(204244);
          return;
        }
        AppMethodBeat.o(204244);
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "decoder", "inputIndex", "", "onOutputBufferAvailable", "outputIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-finder_release"})
      public static final class a
        extends MediaCodec.Callback
      {
        a(h.a.a parama) {}
        
        public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
        {
          AppMethodBeat.i(204242);
          k.h(paramMediaCodec, "codec");
          k.h(paramCodecException, "e");
          AppMethodBeat.o(204242);
        }
        
        public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
        {
          AppMethodBeat.i(204240);
          k.h(paramMediaCodec, "decoder");
          ac.i(this.rZD.rZB.rZy.TAG, "lxl onInputBufferAvailable");
          localObject = this.rZD.rZB.rZy.lock;
          if (paramInt >= 0) {}
          for (;;)
          {
            try
            {
              ByteBuffer localByteBuffer = paramMediaCodec.getInputBuffer(paramInt);
              i = this.rZD.rZB.rZy.cFj().j(localByteBuffer);
              if (i >= 0) {
                continue;
              }
              ac.i(this.rZD.rZB.rZy.TAG, "lxl queueInputBuffer BUFFER_FLAG_END_OF_STREAM");
              paramMediaCodec.queueInputBuffer(paramInt, 0, 0, 0L, 4);
              if (this.rZD.rZB.rZy.rZx)
              {
                this.rZD.rZB.rZy.lock.wait();
                this.rZD.rZB.rZy.rZx = false;
              }
            }
            catch (Throwable paramMediaCodec)
            {
              int i;
              ac.printErrStackTrace(this.rZD.rZB.rZy.TAG, paramMediaCodec, "lxl onInputBufferAvailable exception", new Object[0]);
              continue;
            }
            finally
            {
              AppMethodBeat.o(204240);
            }
            paramMediaCodec = y.KTp;
            AppMethodBeat.o(204240);
            return;
            paramMediaCodec.queueInputBuffer(paramInt, 0, i, this.rZD.rZB.rZy.cFj().getSampleTime(), 0);
            this.rZD.rZB.rZy.cFj().advance();
            ac.i(this.rZD.rZB.rZy.TAG, "lxl queueInputBuffer " + this.rZD.rZB.rZy.cFj().getSampleTime() / 1000L);
          }
        }
        
        public final void onOutputBufferAvailable(MediaCodec arg1, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
        {
          AppMethodBeat.i(204239);
          k.h(???, "decoder");
          k.h(paramBufferInfo, "bufferInfo");
          ac.i(this.rZD.rZB.rZy.TAG, "lxl onOutputBufferAvailable");
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
            ac.i(this.rZD.rZB.rZy.TAG, "lxl releaseOutputBuffer BUFFER_FLAG_END_OF_STREAM");
            ???.releaseOutputBuffer(paramInt, false);
            AppMethodBeat.o(204239);
            return;
          }
          catch (Throwable ???)
          {
            ac.printErrStackTrace(this.rZD.rZB.rZy.TAG, ???, "lxl onOutputBufferAvailable exception", new Object[0]);
            AppMethodBeat.o(204239);
            return;
          }
          ???.releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(204239);
          return;
          label149:
          if (paramBufferInfo.presentationTimeUs >= this.rZD.rZB.rZy.rZt * 1000L)
          {
            ???.releaseOutputBuffer(paramInt, true);
            this.rZD.rZB.rQL.ay(Long.valueOf(paramBufferInfo.presentationTimeUs));
            ac.i(this.rZD.rZB.rZy.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", render!");
          }
          for (;;)
          {
            synchronized (this.rZD.rZB.rZy.lock)
            {
              this.rZD.rZB.rZy.rZx = true;
              y localy = y.KTp;
              this.rZD.rZB.rZy.rZw = paramBufferInfo.presentationTimeUs;
              AppMethodBeat.o(204239);
              return;
            }
            ac.i(this.rZD.rZB.rZy.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", no");
            ???.releaseOutputBuffer(paramInt, false);
          }
        }
        
        public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
        {
          AppMethodBeat.i(204241);
          k.h(paramMediaCodec, "codec");
          k.h(paramMediaFormat, "format");
          AppMethodBeat.o(204241);
        }
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$2"})
      static final class b
        implements Runnable
      {
        b(h.a.a parama) {}
        
        public final void run()
        {
          AppMethodBeat.i(204243);
          this.rZD.rZB.rZA.invoke();
          AppMethodBeat.o(204243);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.h
 * JD-Core Version:    0.7.0.1
 */