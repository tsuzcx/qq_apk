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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "", "path", "", "textureView", "Landroid/view/TextureView;", "(Ljava/lang/String;Landroid/view/TextureView;)V", "TAG", "canPauseInput", "", "getCanPauseInput", "()Z", "setCanPauseInput", "(Z)V", "curInputTimeUs", "", "getCurInputTimeUs", "()J", "setCurInputTimeUs", "(J)V", "curOutputTimeUs", "getCurOutputTimeUs", "setCurOutputTimeUs", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "getExtractor", "()Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "setExtractor", "(Lcom/tencent/mm/compatible/video/VFSMediaExtractor;)V", "frameFlagExtractor", "getFrameFlagExtractor", "setFrameFlagExtractor", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "hasStart", "getHasStart", "setHasStart", "ht", "Landroid/os/HandlerThread;", "getHt", "()Landroid/os/HandlerThread;", "setHt", "(Landroid/os/HandlerThread;)V", "lastSeekTimeMs", "getLastSeekTimeMs", "setLastSeekTimeMs", "lastSyncFrameTimeUs", "getLastSyncFrameTimeUs", "setLastSyncFrameTimeUs", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "mime", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "getPath", "getTextureView", "()Landroid/view/TextureView;", "destroy", "", "releaseDecoder", "seekTo", "timeMs", "start", "onTextureReady", "Lkotlin/Function0;", "onTextureDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class m
{
  public final String TAG;
  public final TextureView bec;
  public MediaCodec decoder;
  public MMHandler handler;
  public boolean hki;
  public c jto;
  public final Object lock;
  public MediaFormat mediaFormat;
  public String mime;
  public final String path;
  public c wpL;
  public HandlerThread wpM;
  public long wpN;
  public long wpO;
  private long wpP;
  public long wpQ;
  boolean wpR;
  
  public m(String paramString, TextureView paramTextureView)
  {
    AppMethodBeat.i(255011);
    this.path = paramString;
    this.bec = paramTextureView;
    this.TAG = "Finder.FinderVideoFrameSeeker";
    this.lock = new Object();
    this.wpN = -1L;
    this.wpO = -1L;
    this.wpP = -1L;
    this.wpQ = -1L;
    AppMethodBeat.o(255011);
  }
  
  public final c dHm()
  {
    AppMethodBeat.i(255009);
    c localc = this.jto;
    if (localc == null) {
      p.btv("extractor");
    }
    AppMethodBeat.o(255009);
    return localc;
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(255010);
    MediaCodec localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
    localMediaCodec = this.decoder;
    if (localMediaCodec != null) {
      localMediaCodec.release();
    }
    this.decoder = null;
    AppMethodBeat.o(255010);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"})
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    public a(a parama1, b paramb, a parama2) {}
    
    public final void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(255008);
      MMHandler localMMHandler = this.wpS.handler;
      if (localMMHandler == null) {
        p.btv("handler");
      }
      localMMHandler.post((Runnable)new a(this, paramSurfaceTexture));
      AppMethodBeat.o(255008);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(255007);
      this.wpS.releaseDecoder();
      this.wpT.invoke();
      AppMethodBeat.o(255007);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(m.a parama, SurfaceTexture paramSurfaceTexture) {}
      
      public final void run()
      {
        AppMethodBeat.i(255006);
        if (this.wpV.wpS.decoder != null) {
          this.wpV.wpS.releaseDecoder();
        }
        Object localObject1 = this.wpV.wpS;
        Object localObject2 = this.wpV.wpS.mime;
        if (localObject2 == null) {
          p.btv("mime");
        }
        ((m)localObject1).decoder = MediaCodec.createDecoderByType((String)localObject2);
        localObject1 = this.wpV.wpS.decoder;
        if (localObject1 != null)
        {
          ((MediaCodec)localObject1).setCallback((MediaCodec.Callback)new a(this));
          localObject2 = this.wpV.wpS.mediaFormat;
          if (localObject2 == null) {
            p.btv("mediaFormat");
          }
          ((MediaCodec)localObject1).configure((MediaFormat)localObject2, new Surface(paramSurfaceTexture), null, 0);
          this.wpV.wpS.bec.post((Runnable)new b(this));
          AppMethodBeat.o(255006);
          return;
        }
        AppMethodBeat.o(255006);
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "decoder", "inputIndex", "", "onOutputBufferAvailable", "outputIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-finder_release"})
      public static final class a
        extends MediaCodec.Callback
      {
        a(m.a.a parama) {}
        
        public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
        {
          AppMethodBeat.i(255004);
          p.h(paramMediaCodec, "codec");
          p.h(paramCodecException, "e");
          AppMethodBeat.o(255004);
        }
        
        public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
        {
          AppMethodBeat.i(255002);
          p.h(paramMediaCodec, "decoder");
          Log.i(this.wpX.wpV.wpS.TAG, "lxl onInputBufferAvailable");
          localObject = this.wpX.wpV.wpS.lock;
          if (paramInt >= 0) {}
          for (;;)
          {
            try
            {
              ByteBuffer localByteBuffer = paramMediaCodec.getInputBuffer(paramInt);
              c localc = this.wpX.wpV.wpS.dHm();
              if (localByteBuffer == null) {
                p.hyc();
              }
              i = localc.readSampleData(localByteBuffer, 0);
              if (i >= 0) {
                continue;
              }
              Log.i(this.wpX.wpV.wpS.TAG, "lxl queueInputBuffer BUFFER_FLAG_END_OF_STREAM");
              paramMediaCodec.queueInputBuffer(paramInt, 0, 0, 0L, 4);
              if (this.wpX.wpV.wpS.wpR)
              {
                this.wpX.wpV.wpS.lock.wait();
                this.wpX.wpV.wpS.wpR = false;
              }
            }
            catch (Throwable paramMediaCodec)
            {
              int i;
              Log.printErrStackTrace(this.wpX.wpV.wpS.TAG, paramMediaCodec, "lxl onInputBufferAvailable exception", new Object[0]);
              continue;
            }
            finally
            {
              AppMethodBeat.o(255002);
            }
            paramMediaCodec = x.SXb;
            AppMethodBeat.o(255002);
            return;
            paramMediaCodec.queueInputBuffer(paramInt, 0, i, this.wpX.wpV.wpS.dHm().getSampleTime(), 0);
            this.wpX.wpV.wpS.dHm().advance();
            Log.i(this.wpX.wpV.wpS.TAG, "lxl queueInputBuffer " + this.wpX.wpV.wpS.dHm().getSampleTime() / 1000L);
          }
        }
        
        public final void onOutputBufferAvailable(MediaCodec arg1, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
        {
          AppMethodBeat.i(255001);
          p.h(???, "decoder");
          p.h(paramBufferInfo, "bufferInfo");
          Log.i(this.wpX.wpV.wpS.TAG, "lxl onOutputBufferAvailable");
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
            Log.i(this.wpX.wpV.wpS.TAG, "lxl releaseOutputBuffer BUFFER_FLAG_END_OF_STREAM");
            ???.releaseOutputBuffer(paramInt, false);
            AppMethodBeat.o(255001);
            return;
          }
          catch (Throwable ???)
          {
            Log.printErrStackTrace(this.wpX.wpV.wpS.TAG, ???, "lxl onOutputBufferAvailable exception", new Object[0]);
            AppMethodBeat.o(255001);
            return;
          }
          ???.releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(255001);
          return;
          label149:
          if (paramBufferInfo.presentationTimeUs >= this.wpX.wpV.wpS.wpN * 1000L)
          {
            ???.releaseOutputBuffer(paramInt, true);
            this.wpX.wpV.wbp.invoke(Long.valueOf(paramBufferInfo.presentationTimeUs));
            Log.i(this.wpX.wpV.wpS.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", render!");
          }
          for (;;)
          {
            synchronized (this.wpX.wpV.wpS.lock)
            {
              this.wpX.wpV.wpS.wpR = true;
              x localx = x.SXb;
              this.wpX.wpV.wpS.wpQ = paramBufferInfo.presentationTimeUs;
              AppMethodBeat.o(255001);
              return;
            }
            Log.i(this.wpX.wpV.wpS.TAG, "lxl releaseOutputBuffer " + paramBufferInfo.presentationTimeUs / 1000L + ", no");
            ???.releaseOutputBuffer(paramInt, false);
          }
        }
        
        public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
        {
          AppMethodBeat.i(255003);
          p.h(paramMediaCodec, "codec");
          p.h(paramMediaFormat, "format");
          AppMethodBeat.o(255003);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker$start$1$onSurfaceTextureAvailable$1$1$2"})
      static final class b
        implements Runnable
      {
        b(m.a.a parama) {}
        
        public final void run()
        {
          AppMethodBeat.i(255005);
          this.wpX.wpV.wpU.invoke();
          AppMethodBeat.o(255005);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.m
 * JD-Core Version:    0.7.0.1
 */