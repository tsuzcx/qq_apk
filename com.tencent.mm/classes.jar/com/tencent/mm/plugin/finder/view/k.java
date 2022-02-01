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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "", "path", "", "textureView", "Landroid/view/TextureView;", "(Ljava/lang/String;Landroid/view/TextureView;)V", "TAG", "canPauseInput", "", "getCanPauseInput", "()Z", "setCanPauseInput", "(Z)V", "curInputTimeUs", "", "getCurInputTimeUs", "()J", "setCurInputTimeUs", "(J)V", "curOutputTimeUs", "getCurOutputTimeUs", "setCurOutputTimeUs", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "getExtractor", "()Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "setExtractor", "(Lcom/tencent/mm/compatible/video/VFSMediaExtractor;)V", "frameFlagExtractor", "getFrameFlagExtractor", "setFrameFlagExtractor", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "hasStart", "getHasStart", "setHasStart", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "lastSeekTimeMs", "getLastSeekTimeMs", "setLastSeekTimeMs", "lastSyncFrameTimeUs", "getLastSyncFrameTimeUs", "setLastSyncFrameTimeUs", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "mime", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "getPath", "getTextureView", "()Landroid/view/TextureView;", "destroy", "", "releaseDecoder", "seekTo", "timeMs", "start", "onTextureReady", "Lkotlin/Function0;", "onTextureDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class k
{
  public final String TAG;
  public final TextureView bef;
  public c deA;
  public MediaCodec decoder;
  public boolean gxv;
  public aq handler;
  public final Object lock;
  public MediaFormat mediaFormat;
  public String mime;
  public final String path;
  public c thA;
  public HandlerThread thB;
  public long thC;
  public long thD;
  private long thE;
  public long thF;
  boolean thG;
  
  public k(String paramString, TextureView paramTextureView)
  {
    AppMethodBeat.i(205871);
    this.path = paramString;
    this.bef = paramTextureView;
    this.TAG = "Finder.FinderVideoFrameSeeker";
    this.lock = new Object();
    this.thC = -1L;
    this.thD = -1L;
    this.thE = -1L;
    this.thF = -1L;
    AppMethodBeat.o(205871);
  }
  
  public final c cQn()
  {
    AppMethodBeat.i(205869);
    c localc = this.deA;
    if (localc == null) {
      p.bdF("extractor");
    }
    AppMethodBeat.o(205869);
    return localc;
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(205870);
    MediaCodec localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
    localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.release();
    }
    this.decoder = null;
    AppMethodBeat.o(205870);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"})
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    public a(a parama1, b paramb, a parama2) {}
    
    public final void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205868);
      aq localaq = this.thH.handler;
      if (localaq == null) {
        p.bdF("handler");
      }
      localaq.post((Runnable)new a(this, paramSurfaceTexture));
      AppMethodBeat.o(205868);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(205867);
      this.thH.releaseDecoder();
      this.thI.invoke();
      AppMethodBeat.o(205867);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(k.a parama, SurfaceTexture paramSurfaceTexture) {}
      
      public final void run()
      {
        AppMethodBeat.i(205866);
        if (this.thK.thH.decoder != null) {
          this.thK.thH.releaseDecoder();
        }
        Object localObject1 = this.thK.thH;
        Object localObject2 = this.thK.thH.mime;
        if (localObject2 == null) {
          p.bdF("mime");
        }
        ((k)localObject1).decoder = MediaCodec.createDecoderByType((String)localObject2);
        localObject1 = this.thK.thH.decoder;
        if (localObject1 != null)
        {
          ((MediaCodec)localObject1).setCallback((MediaCodec.Callback)new a(this));
          localObject2 = this.thK.thH.mediaFormat;
          if (localObject2 == null) {
            p.bdF("mediaFormat");
          }
          ((MediaCodec)localObject1).configure((MediaFormat)localObject2, new Surface(paramSurfaceTexture), null, 0);
          this.thK.thH.bef.post((Runnable)new b(this));
          AppMethodBeat.o(205866);
          return;
        }
        AppMethodBeat.o(205866);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "decoder", "inputIndex", "", "onOutputBufferAvailable", "outputIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-finder_release"})
      public static final class a
        extends MediaCodec.Callback
      {
        a(k.a.a parama) {}
        
        public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
        {
          AppMethodBeat.i(205864);
          p.h(paramMediaCodec, "codec");
          p.h(paramCodecException, "e");
          AppMethodBeat.o(205864);
        }
        
        public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
        {
          AppMethodBeat.i(205862);
          p.h(paramMediaCodec, "decoder");
          ae.i(this.thM.thK.thH.TAG, "lxl onInputBufferAvailable");
          localObject = this.thM.thK.thH.lock;
          if (paramInt >= 0) {}
          for (;;)
          {
            try
            {
              ByteBuffer localByteBuffer = paramMediaCodec.getInputBuffer(paramInt);
              i = this.thM.thK.thH.cQn().readSampleData(localByteBuffer, 0);
              if (i >= 0) {
                continue;
              }
              ae.i(this.thM.thK.thH.TAG, "lxl queueInputBuffer BUFFER_FLAG_END_OF_STREAM");
              paramMediaCodec.queueInputBuffer(paramInt, 0, 0, 0L, 4);
              if (this.thM.thK.thH.thG)
              {
                this.thM.thK.thH.lock.wait();
                this.thM.thK.thH.thG = false;
              }
            }
            catch (Throwable paramMediaCodec)
            {
              int i;
              ae.printErrStackTrace(this.thM.thK.thH.TAG, paramMediaCodec, "lxl onInputBufferAvailable exception", new Object[0]);
              continue;
            }
            finally
            {
              AppMethodBeat.o(205862);
            }
            paramMediaCodec = z.Nhr;
            AppMethodBeat.o(205862);
            return;
            paramMediaCodec.queueInputBuffer(paramInt, 0, i, this.thM.thK.thH.cQn().getSampleTime(), 0);
            this.thM.thK.thH.cQn().advance();
            ae.i(this.thM.thK.thH.TAG, "lxl queueInputBuffer " + this.thM.thK.thH.cQn().getSampleTime() / 1000L);
          }
        }
        
        public final void onOutputBufferAvailable(MediaCodec arg1, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
        {
          AppMethodBeat.i(205861);
          p.h(???, "decoder");
          p.h(paramBufferInfo, "bufferInfo");
          ae.i(this.thM.thK.thH.TAG, "lxl onOutputBufferAvailable");
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
            ae.i(this.thM.thK.thH.TAG, "lxl releaseOutputBuffer BUFFER_FLAG_END_OF_STREAM");
            ???.releaseOutputBuffer(paramInt, false);
            AppMethodBeat.o(205861);
            return;
          }
          catch (Throwable ???)
          {
            ae.printErrStackTrace(this.thM.thK.thH.TAG, ???, "lxl onOutputBufferAvailable exception", new Object[0]);
            AppMethodBeat.o(205861);
            return;
          }
          ???.releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(205861);
          return;
          label149:
          if (paramBufferInfo.presentationTimeUs >= this.thM.thK.thH.thC * 1000L)
          {
            ???.releaseOutputBuffer(paramInt, true);
            this.thM.thK.sYw.invoke(Long.valueOf(paramBufferInfo.presentationTimeUs));
            ae.i(this.thM.thK.thH.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", render!");
          }
          for (;;)
          {
            synchronized (this.thM.thK.thH.lock)
            {
              this.thM.thK.thH.thG = true;
              z localz = z.Nhr;
              this.thM.thK.thH.thF = paramBufferInfo.presentationTimeUs;
              AppMethodBeat.o(205861);
              return;
            }
            ae.i(this.thM.thK.thH.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", no");
            ???.releaseOutputBuffer(paramInt, false);
          }
        }
        
        public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
        {
          AppMethodBeat.i(205863);
          p.h(paramMediaCodec, "codec");
          p.h(paramMediaFormat, "format");
          AppMethodBeat.o(205863);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$2"})
      static final class b
        implements Runnable
      {
        b(k.a.a parama) {}
        
        public final void run()
        {
          AppMethodBeat.i(205865);
          this.thM.thK.thJ.invoke();
          AppMethodBeat.o(205865);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.k
 * JD-Core Version:    0.7.0.1
 */