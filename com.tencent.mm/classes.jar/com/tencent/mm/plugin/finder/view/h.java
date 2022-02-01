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
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "", "path", "", "textureView", "Landroid/view/TextureView;", "(Ljava/lang/String;Landroid/view/TextureView;)V", "TAG", "canPauseInput", "", "getCanPauseInput", "()Z", "setCanPauseInput", "(Z)V", "curInputTimeUs", "", "getCurInputTimeUs", "()J", "setCurInputTimeUs", "(J)V", "curOutputTimeUs", "getCurOutputTimeUs", "setCurOutputTimeUs", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "getExtractor", "()Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "setExtractor", "(Lcom/tencent/mm/compatible/video/VFSMediaExtractor;)V", "frameFlagExtractor", "getFrameFlagExtractor", "setFrameFlagExtractor", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "hasStart", "getHasStart", "setHasStart", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "lastSeekTimeMs", "getLastSeekTimeMs", "setLastSeekTimeMs", "lastSyncFrameTimeUs", "getLastSyncFrameTimeUs", "setLastSyncFrameTimeUs", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "mime", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "getPath", "getTextureView", "()Landroid/view/TextureView;", "destroy", "", "releaseDecoder", "seekTo", "timeMs", "start", "onTextureReady", "Lkotlin/Function0;", "onTextureDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class h
{
  public c LfO;
  public long LfP;
  public long LfQ;
  private long LfR;
  public long LfS;
  boolean LfT;
  public final String TAG;
  public final TextureView aST;
  public c cUM;
  public MediaCodec decoder;
  public boolean fWx;
  public ap handler;
  public final Object lock;
  public MediaFormat mediaFormat;
  public String mime;
  public final String path;
  public HandlerThread veL;
  
  public h(String paramString, TextureView paramTextureView)
  {
    AppMethodBeat.i(200179);
    this.path = paramString;
    this.aST = paramTextureView;
    this.TAG = "Finder.FinderVideoFrameSeeker";
    this.lock = new Object();
    this.LfP = -1L;
    this.LfQ = -1L;
    this.LfR = -1L;
    this.LfS = -1L;
    AppMethodBeat.o(200179);
  }
  
  public final c fWY()
  {
    AppMethodBeat.i(200177);
    c localc = this.cUM;
    if (localc == null) {
      k.aPZ("extractor");
    }
    AppMethodBeat.o(200177);
    return localc;
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(200178);
    MediaCodec localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
    localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.release();
    }
    this.decoder = null;
    AppMethodBeat.o(200178);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"})
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    public a(a parama1, b paramb, a parama2) {}
    
    public final void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200176);
      ap localap = this.LfU.handler;
      if (localap == null) {
        k.aPZ("handler");
      }
      localap.post((Runnable)new a(this, paramSurfaceTexture));
      AppMethodBeat.o(200176);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(200175);
      this.LfU.releaseDecoder();
      this.LfV.invoke();
      AppMethodBeat.o(200175);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(h.a parama, SurfaceTexture paramSurfaceTexture) {}
      
      public final void run()
      {
        AppMethodBeat.i(200174);
        if (this.LfX.LfU.decoder != null) {
          this.LfX.LfU.releaseDecoder();
        }
        Object localObject1 = this.LfX.LfU;
        Object localObject2 = this.LfX.LfU.mime;
        if (localObject2 == null) {
          k.aPZ("mime");
        }
        ((h)localObject1).decoder = MediaCodec.createDecoderByType((String)localObject2);
        localObject1 = this.LfX.LfU.decoder;
        if (localObject1 != null)
        {
          ((MediaCodec)localObject1).setCallback((MediaCodec.Callback)new a(this));
          localObject2 = this.LfX.LfU.mediaFormat;
          if (localObject2 == null) {
            k.aPZ("mediaFormat");
          }
          ((MediaCodec)localObject1).configure((MediaFormat)localObject2, new Surface(paramSurfaceTexture), null, 0);
          this.LfX.LfU.aST.post((Runnable)new b(this));
          AppMethodBeat.o(200174);
          return;
        }
        AppMethodBeat.o(200174);
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "decoder", "inputIndex", "", "onOutputBufferAvailable", "outputIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-finder_release"})
      public static final class a
        extends MediaCodec.Callback
      {
        a(h.a.a parama) {}
        
        public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
        {
          AppMethodBeat.i(200172);
          k.h(paramMediaCodec, "codec");
          k.h(paramCodecException, "e");
          AppMethodBeat.o(200172);
        }
        
        public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
        {
          AppMethodBeat.i(200170);
          k.h(paramMediaCodec, "decoder");
          ad.i(this.LfZ.LfX.LfU.TAG, "lxl onInputBufferAvailable");
          localObject = this.LfZ.LfX.LfU.lock;
          if (paramInt >= 0) {}
          for (;;)
          {
            try
            {
              ByteBuffer localByteBuffer = paramMediaCodec.getInputBuffer(paramInt);
              i = this.LfZ.LfX.LfU.fWY().j(localByteBuffer);
              if (i >= 0) {
                continue;
              }
              ad.i(this.LfZ.LfX.LfU.TAG, "lxl queueInputBuffer BUFFER_FLAG_END_OF_STREAM");
              paramMediaCodec.queueInputBuffer(paramInt, 0, 0, 0L, 4);
              if (this.LfZ.LfX.LfU.LfT)
              {
                this.LfZ.LfX.LfU.lock.wait();
                this.LfZ.LfX.LfU.LfT = false;
              }
            }
            catch (Throwable paramMediaCodec)
            {
              int i;
              ad.printErrStackTrace(this.LfZ.LfX.LfU.TAG, paramMediaCodec, "lxl onInputBufferAvailable exception", new Object[0]);
              continue;
            }
            finally
            {
              AppMethodBeat.o(200170);
            }
            paramMediaCodec = y.JfV;
            AppMethodBeat.o(200170);
            return;
            paramMediaCodec.queueInputBuffer(paramInt, 0, i, this.LfZ.LfX.LfU.fWY().getSampleTime(), 0);
            this.LfZ.LfX.LfU.fWY().advance();
            ad.i(this.LfZ.LfX.LfU.TAG, "lxl queueInputBuffer " + this.LfZ.LfX.LfU.fWY().getSampleTime() / 1000L);
          }
        }
        
        public final void onOutputBufferAvailable(MediaCodec arg1, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
        {
          AppMethodBeat.i(200169);
          k.h(???, "decoder");
          k.h(paramBufferInfo, "bufferInfo");
          ad.i(this.LfZ.LfX.LfU.TAG, "lxl onOutputBufferAvailable");
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
            ad.i(this.LfZ.LfX.LfU.TAG, "lxl releaseOutputBuffer BUFFER_FLAG_END_OF_STREAM");
            ???.releaseOutputBuffer(paramInt, false);
            AppMethodBeat.o(200169);
            return;
          }
          catch (Throwable ???)
          {
            ad.printErrStackTrace(this.LfZ.LfX.LfU.TAG, ???, "lxl onOutputBufferAvailable exception", new Object[0]);
            AppMethodBeat.o(200169);
            return;
          }
          ???.releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(200169);
          return;
          label149:
          if (paramBufferInfo.presentationTimeUs >= this.LfZ.LfX.LfU.LfP * 1000L)
          {
            ???.releaseOutputBuffer(paramInt, true);
            this.LfZ.LfX.LbI.aA(Long.valueOf(paramBufferInfo.presentationTimeUs));
            ad.i(this.LfZ.LfX.LfU.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", render!");
          }
          for (;;)
          {
            synchronized (this.LfZ.LfX.LfU.lock)
            {
              this.LfZ.LfX.LfU.LfT = true;
              y localy = y.JfV;
              this.LfZ.LfX.LfU.LfS = paramBufferInfo.presentationTimeUs;
              AppMethodBeat.o(200169);
              return;
            }
            ad.i(this.LfZ.LfX.LfU.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", no");
            ???.releaseOutputBuffer(paramInt, false);
          }
        }
        
        public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
        {
          AppMethodBeat.i(200171);
          k.h(paramMediaCodec, "codec");
          k.h(paramMediaFormat, "format");
          AppMethodBeat.o(200171);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$2"})
      static final class b
        implements Runnable
      {
        b(h.a.a parama) {}
        
        public final void run()
        {
          AppMethodBeat.i(200173);
          this.LfZ.LfX.LfW.invoke();
          AppMethodBeat.o(200173);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.h
 * JD-Core Version:    0.7.0.1
 */