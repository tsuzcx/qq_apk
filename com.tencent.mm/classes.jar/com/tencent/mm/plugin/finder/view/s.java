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
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "", "path", "", "textureView", "Landroid/view/TextureView;", "(Ljava/lang/String;Landroid/view/TextureView;)V", "TAG", "canPauseInput", "", "getCanPauseInput", "()Z", "setCanPauseInput", "(Z)V", "curInputTimeUs", "", "getCurInputTimeUs", "()J", "setCurInputTimeUs", "(J)V", "curOutputTimeUs", "getCurOutputTimeUs", "setCurOutputTimeUs", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "getExtractor", "()Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "setExtractor", "(Lcom/tencent/mm/compatible/video/VFSMediaExtractor;)V", "frameFlagExtractor", "getFrameFlagExtractor", "setFrameFlagExtractor", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "hasStart", "getHasStart", "setHasStart", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "lastSeekTimeMs", "getLastSeekTimeMs", "setLastSeekTimeMs", "lastSyncFrameTimeUs", "getLastSyncFrameTimeUs", "setLastSyncFrameTimeUs", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "mime", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "getPath", "getTextureView", "()Landroid/view/TextureView;", "destroy", "", "releaseDecoder", "seekTo", "timeMs", "start", "onTextureReady", "Lkotlin/Function0;", "onTextureDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class s
{
  public c Bbt;
  public HandlerThread Bbu;
  public long Bbv;
  public long Bbw;
  private long Bbx;
  public long Bby;
  boolean Bbz;
  public final String TAG;
  public String aFM;
  public final TextureView aND;
  public MediaCodec decoder;
  public MMHandler handler;
  public boolean jVR;
  public final Object lock;
  public MediaFormat mediaFormat;
  public c miS;
  public final String path;
  
  public s(String paramString, TextureView paramTextureView)
  {
    AppMethodBeat.i(288160);
    this.path = paramString;
    this.aND = paramTextureView;
    this.TAG = "Finder.FinderVideoFrameSeeker";
    this.lock = new Object();
    this.Bbv = -1L;
    this.Bbw = -1L;
    this.Bbx = -1L;
    this.Bby = -1L;
    AppMethodBeat.o(288160);
  }
  
  public final c ejr()
  {
    AppMethodBeat.i(288158);
    c localc = this.miS;
    if (localc == null) {
      p.bGy("extractor");
    }
    AppMethodBeat.o(288158);
    return localc;
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(288159);
    MediaCodec localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
    localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.release();
    }
    this.decoder = null;
    AppMethodBeat.o(288159);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"})
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    public a(a parama1, b paramb, a parama2) {}
    
    public final void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(289349);
      MMHandler localMMHandler = this.BbA.handler;
      if (localMMHandler == null) {
        p.bGy("handler");
      }
      localMMHandler.post((Runnable)new a(this, paramSurfaceTexture));
      AppMethodBeat.o(289349);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(289348);
      this.BbA.releaseDecoder();
      this.BbB.invoke();
      AppMethodBeat.o(289348);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(s.a parama, SurfaceTexture paramSurfaceTexture) {}
      
      public final void run()
      {
        AppMethodBeat.i(285789);
        if (this.BbD.BbA.decoder != null) {
          this.BbD.BbA.releaseDecoder();
        }
        Object localObject1 = this.BbD.BbA;
        Object localObject2 = this.BbD.BbA.aFM;
        if (localObject2 == null) {
          p.bGy("mime");
        }
        ((s)localObject1).decoder = MediaCodec.createDecoderByType((String)localObject2);
        localObject1 = this.BbD.BbA.decoder;
        if (localObject1 != null)
        {
          ((MediaCodec)localObject1).setCallback((MediaCodec.Callback)new a(this));
          localObject2 = this.BbD.BbA.mediaFormat;
          if (localObject2 == null) {
            p.bGy("mediaFormat");
          }
          ((MediaCodec)localObject1).configure((MediaFormat)localObject2, new Surface(paramSurfaceTexture), null, 0);
          this.BbD.BbA.aND.post((Runnable)new b(this));
          AppMethodBeat.o(285789);
          return;
        }
        AppMethodBeat.o(285789);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "decoder", "inputIndex", "", "onOutputBufferAvailable", "outputIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-finder_release"})
      public static final class a
        extends MediaCodec.Callback
      {
        a(s.a.a parama) {}
        
        public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
        {
          AppMethodBeat.i(285680);
          p.k(paramMediaCodec, "codec");
          p.k(paramCodecException, "e");
          AppMethodBeat.o(285680);
        }
        
        public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
        {
          AppMethodBeat.i(285678);
          p.k(paramMediaCodec, "decoder");
          Log.i(this.BbF.BbD.BbA.TAG, "lxl onInputBufferAvailable");
          localObject = this.BbF.BbD.BbA.lock;
          if (paramInt >= 0) {}
          for (;;)
          {
            try
            {
              ByteBuffer localByteBuffer = paramMediaCodec.getInputBuffer(paramInt);
              c localc = this.BbF.BbD.BbA.ejr();
              if (localByteBuffer == null) {
                p.iCn();
              }
              i = localc.readSampleData(localByteBuffer, 0);
              if (i >= 0) {
                continue;
              }
              Log.i(this.BbF.BbD.BbA.TAG, "lxl queueInputBuffer BUFFER_FLAG_END_OF_STREAM");
              paramMediaCodec.queueInputBuffer(paramInt, 0, 0, 0L, 4);
              if (this.BbF.BbD.BbA.Bbz)
              {
                this.BbF.BbD.BbA.lock.wait();
                this.BbF.BbD.BbA.Bbz = false;
              }
            }
            catch (Throwable paramMediaCodec)
            {
              int i;
              Log.printErrStackTrace(this.BbF.BbD.BbA.TAG, paramMediaCodec, "lxl onInputBufferAvailable exception", new Object[0]);
              continue;
            }
            finally
            {
              AppMethodBeat.o(285678);
            }
            paramMediaCodec = x.aazN;
            AppMethodBeat.o(285678);
            return;
            paramMediaCodec.queueInputBuffer(paramInt, 0, i, this.BbF.BbD.BbA.ejr().getSampleTime(), 0);
            this.BbF.BbD.BbA.ejr().advance();
            Log.i(this.BbF.BbD.BbA.TAG, "lxl queueInputBuffer " + this.BbF.BbD.BbA.ejr().getSampleTime() / 1000L);
          }
        }
        
        public final void onOutputBufferAvailable(MediaCodec arg1, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
        {
          AppMethodBeat.i(285677);
          p.k(???, "decoder");
          p.k(paramBufferInfo, "bufferInfo");
          Log.i(this.BbF.BbD.BbA.TAG, "lxl onOutputBufferAvailable");
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
            Log.i(this.BbF.BbD.BbA.TAG, "lxl releaseOutputBuffer BUFFER_FLAG_END_OF_STREAM");
            ???.releaseOutputBuffer(paramInt, false);
            AppMethodBeat.o(285677);
            return;
          }
          catch (Throwable ???)
          {
            Log.printErrStackTrace(this.BbF.BbD.BbA.TAG, ???, "lxl onOutputBufferAvailable exception", new Object[0]);
            AppMethodBeat.o(285677);
            return;
          }
          ???.releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(285677);
          return;
          label149:
          if (paramBufferInfo.presentationTimeUs >= this.BbF.BbD.BbA.Bbv * 1000L)
          {
            ???.releaseOutputBuffer(paramInt, true);
            this.BbF.BbD.AJZ.invoke(Long.valueOf(paramBufferInfo.presentationTimeUs));
            Log.i(this.BbF.BbD.BbA.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", render!");
          }
          for (;;)
          {
            synchronized (this.BbF.BbD.BbA.lock)
            {
              this.BbF.BbD.BbA.Bbz = true;
              x localx = x.aazN;
              this.BbF.BbD.BbA.Bby = paramBufferInfo.presentationTimeUs;
              AppMethodBeat.o(285677);
              return;
            }
            Log.i(this.BbF.BbD.BbA.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", no");
            ???.releaseOutputBuffer(paramInt, false);
          }
        }
        
        public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
        {
          AppMethodBeat.i(285679);
          p.k(paramMediaCodec, "codec");
          p.k(paramMediaFormat, "format");
          AppMethodBeat.o(285679);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$2"})
      static final class b
        implements Runnable
      {
        b(s.a.a parama) {}
        
        public final void run()
        {
          AppMethodBeat.i(277617);
          this.BbF.BbD.BbC.invoke();
          AppMethodBeat.o(277617);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.s
 * JD-Core Version:    0.7.0.1
 */