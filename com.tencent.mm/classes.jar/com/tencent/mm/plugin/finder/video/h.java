package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.plugin.finder.view.FinderVideoFrameView;
import com.tencent.mm.plugin.finder.view.h.a;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameView", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "seeker", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class h
  implements n
{
  private FinderVideoFrameView LbK;
  private com.tencent.mm.plugin.finder.view.h LbL;
  
  public h(Context paramContext, bmd parambmd)
  {
    AppMethodBeat.i(199721);
    this.LbK = new FinderVideoFrameView(paramContext);
    paramContext = parambmd.url;
    k.g(paramContext, "media.url");
    this.LbL = new com.tencent.mm.plugin.finder.view.h(paramContext, this.LbK.getTextureView());
    AppMethodBeat.o(199721);
  }
  
  public final void a(a<y> parama1, a<y> parama2, b<? super Long, y> paramb)
  {
    AppMethodBeat.i(199717);
    k.h(parama1, "onReady");
    k.h(parama2, "onDestroy");
    k.h(paramb, "onSeekFrame");
    com.tencent.mm.plugin.finder.view.h localh = this.LbL;
    k.h(parama1, "onTextureReady");
    k.h(parama2, "onTextureDestroy");
    k.h(paramb, "onSeekFrame");
    Object localObject = d.gu("FinderVideoFrameSeeker_renderThread" + localh.hashCode(), -2);
    k.g(localObject, "SpecialThreadFactory.cre…READ_PRIORITY_FOREGROUND)");
    localh.veL = ((HandlerThread)localObject);
    localObject = localh.veL;
    if (localObject == null) {
      k.aPZ("ht");
    }
    ((HandlerThread)localObject).start();
    localObject = localh.veL;
    if (localObject == null) {
      k.aPZ("ht");
    }
    localh.handler = new ap(((HandlerThread)localObject).getLooper());
    localh.cUM = new c();
    localh.LfO = new c();
    localObject = i.cS(localh.path, false);
    k.g(localObject, "raf");
    FileDescriptor localFileDescriptor = ((RandomAccessFile)localObject).getFD();
    c localc;
    int j;
    int i;
    if (ae.fFy.fFr == 1)
    {
      localc = localh.cUM;
      if (localc == null) {
        k.aPZ("extractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, i.aMN(localh.path));
      localc = localh.LfO;
      if (localc == null) {
        k.aPZ("frameFlagExtractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, i.aMN(localh.path));
      ((RandomAccessFile)localObject).close();
      localObject = localh.cUM;
      if (localObject == null) {
        k.aPZ("extractor");
      }
      j = ((c)localObject).getTrackCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject = localh.cUM;
        if (localObject == null) {
          k.aPZ("extractor");
        }
        localObject = ((c)localObject).getTrackFormat(i);
        k.g(localObject, "extractor.getTrackFormat(i)");
        localh.mediaFormat = ((MediaFormat)localObject);
        localObject = localh.mediaFormat;
        if (localObject == null) {
          k.aPZ("mediaFormat");
        }
        localObject = ((MediaFormat)localObject).getString("mime");
        k.g(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)");
        localh.mime = ((String)localObject);
        localObject = localh.mime;
        if (localObject == null) {
          k.aPZ("mime");
        }
        if (d.n.n.mA((String)localObject, "video/"))
        {
          localObject = localh.cUM;
          if (localObject == null) {
            k.aPZ("extractor");
          }
          ((c)localObject).selectTrack(i);
          localObject = localh.LfO;
          if (localObject == null) {
            k.aPZ("frameFlagExtractor");
          }
          ((c)localObject).selectTrack(i);
        }
      }
      else
      {
        localh.aST.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new h.a(localh, parama2, paramb, parama1));
        AppMethodBeat.o(199717);
        return;
        localc = localh.cUM;
        if (localc == null) {
          k.aPZ("extractor");
        }
        localc.setDataSource(localFileDescriptor);
        localc = localh.LfO;
        if (localc == null) {
          k.aPZ("frameFlagExtractor");
        }
        localc.setDataSource(localFileDescriptor);
        break;
      }
      i += 1;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(199719);
    Object localObject = this.LbL;
    ((com.tencent.mm.plugin.finder.view.h)localObject).releaseDecoder();
    c localc = ((com.tencent.mm.plugin.finder.view.h)localObject).cUM;
    if (localc == null) {
      k.aPZ("extractor");
    }
    localc.release();
    localc = ((com.tencent.mm.plugin.finder.view.h)localObject).LfO;
    if (localc == null) {
      k.aPZ("frameFlagExtractor");
    }
    localc.release();
    localObject = ((com.tencent.mm.plugin.finder.view.h)localObject).veL;
    if (localObject == null) {
      k.aPZ("ht");
    }
    ((HandlerThread)localObject).quit();
    AppMethodBeat.o(199719);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(199720);
    Bitmap localBitmap = this.LbK.getTextureView().getBitmap();
    AppMethodBeat.o(199720);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.LbK;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(199718);
    Object localObject2 = this.LbL;
    synchronized (((com.tencent.mm.plugin.finder.view.h)localObject2).lock)
    {
      ((com.tencent.mm.plugin.finder.view.h)localObject2).LfP = paramLong;
      Object localObject4 = ((com.tencent.mm.plugin.finder.view.h)localObject2).LfO;
      if (localObject4 == null) {
        k.aPZ("frameFlagExtractor");
      }
      ((c)localObject4).seekTo(((com.tencent.mm.plugin.finder.view.h)localObject2).LfP * 1000L, 0);
      localObject4 = ((com.tencent.mm.plugin.finder.view.h)localObject2).LfO;
      if (localObject4 == null) {
        k.aPZ("frameFlagExtractor");
      }
      long l = ((c)localObject4).getSampleTime();
      if ((l == ((com.tencent.mm.plugin.finder.view.h)localObject2).LfQ) && (((com.tencent.mm.plugin.finder.view.h)localObject2).LfS >= 0L) && (((com.tencent.mm.plugin.finder.view.h)localObject2).LfS < paramLong * 1000L))
      {
        ad.i(((com.tencent.mm.plugin.finder.view.h)localObject2).TAG, "lxl same taget~");
        if (!((com.tencent.mm.plugin.finder.view.h)localObject2).fWx)
        {
          localObject4 = ((com.tencent.mm.plugin.finder.view.h)localObject2).decoder;
          if (localObject4 != null) {
            ((MediaCodec)localObject4).start();
          }
          ((com.tencent.mm.plugin.finder.view.h)localObject2).fWx = true;
        }
        ((com.tencent.mm.plugin.finder.view.h)localObject2).lock.notify();
        localObject2 = y.JfV;
        AppMethodBeat.o(199718);
        return;
      }
      ((com.tencent.mm.plugin.finder.view.h)localObject2).LfQ = l;
      localObject4 = ((com.tencent.mm.plugin.finder.view.h)localObject2).cUM;
      if (localObject4 == null) {
        k.aPZ("extractor");
      }
      ((c)localObject4).seekTo(((com.tencent.mm.plugin.finder.view.h)localObject2).LfP * 1000L, 0);
      if (((com.tencent.mm.plugin.finder.view.h)localObject2).fWx)
      {
        localObject4 = ((com.tencent.mm.plugin.finder.view.h)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).flush();
        }
        localObject4 = ((com.tencent.mm.plugin.finder.view.h)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).start();
        }
      }
      ad.i(((com.tencent.mm.plugin.finder.view.h)localObject2).TAG, "lxl change taget, start sync time:" + ((com.tencent.mm.plugin.finder.view.h)localObject2).LfQ / 1000L + ", target time:" + paramLong + ", flush:" + ((com.tencent.mm.plugin.finder.view.h)localObject2).fWx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.h
 * JD-Core Version:    0.7.0.1
 */