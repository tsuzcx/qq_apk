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
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.plugin.finder.view.FinderVideoFrameView;
import com.tencent.mm.plugin.finder.view.k;
import com.tencent.mm.plugin.finder.view.k.a;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vfs.o;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameView", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "seeker", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class e
  implements n
{
  private k sYA;
  private FinderVideoFrameView sYz;
  
  public e(Context paramContext, bvz parambvz)
  {
    AppMethodBeat.i(205239);
    this.sYz = new FinderVideoFrameView(paramContext);
    parambvz = parambvz.url;
    paramContext = parambvz;
    if (parambvz == null) {
      paramContext = "";
    }
    this.sYA = new k(paramContext, this.sYz.getTextureView());
    AppMethodBeat.o(205239);
  }
  
  public final void a(a<z> parama1, a<z> parama2, b<? super Long, z> paramb)
  {
    AppMethodBeat.i(205235);
    p.h(parama1, "onReady");
    p.h(parama2, "onDestroy");
    p.h(paramb, "onSeekFrame");
    k localk = this.sYA;
    p.h(parama1, "onTextureReady");
    p.h(parama2, "onTextureDestroy");
    p.h(paramb, "onSeekFrame");
    Object localObject = d.hf("FinderVideoFrameSeeker_renderThread" + localk.hashCode(), -2);
    p.g(localObject, "SpecialThreadFactory.cre…READ_PRIORITY_FOREGROUND)");
    localk.thB = ((HandlerThread)localObject);
    localObject = localk.thB;
    if (localObject == null) {
      p.bdF("ht");
    }
    ((HandlerThread)localObject).start();
    localObject = localk.thB;
    if (localObject == null) {
      p.bdF("ht");
    }
    localk.handler = new aq(((HandlerThread)localObject).getLooper());
    localk.deA = new c();
    localk.thA = new c();
    localObject = o.dg(localk.path, false);
    p.g(localObject, "raf");
    FileDescriptor localFileDescriptor = ((RandomAccessFile)localObject).getFD();
    c localc;
    int j;
    int i;
    if (com.tencent.mm.compatible.deviceinfo.ae.geO.geH == 1)
    {
      localc = localk.deA;
      if (localc == null) {
        p.bdF("extractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, o.aZR(localk.path));
      localc = localk.thA;
      if (localc == null) {
        p.bdF("frameFlagExtractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, o.aZR(localk.path));
      ((RandomAccessFile)localObject).close();
      localObject = localk.deA;
      if (localObject == null) {
        p.bdF("extractor");
      }
      j = ((c)localObject).getTrackCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject = localk.deA;
        if (localObject == null) {
          p.bdF("extractor");
        }
        localObject = ((c)localObject).getTrackFormat(i);
        p.g(localObject, "extractor.getTrackFormat(i)");
        localk.mediaFormat = ((MediaFormat)localObject);
        localObject = localk.mediaFormat;
        if (localObject == null) {
          p.bdF("mediaFormat");
        }
        localObject = ((MediaFormat)localObject).getString("mime");
        p.g(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)");
        localk.mime = ((String)localObject);
        localObject = localk.mime;
        if (localObject == null) {
          p.bdF("mime");
        }
        if (d.n.n.nF((String)localObject, "video/"))
        {
          localObject = localk.deA;
          if (localObject == null) {
            p.bdF("extractor");
          }
          ((c)localObject).selectTrack(i);
          localObject = localk.thA;
          if (localObject == null) {
            p.bdF("frameFlagExtractor");
          }
          ((c)localObject).selectTrack(i);
        }
      }
      else
      {
        localk.bef.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new k.a(localk, parama2, paramb, parama1));
        AppMethodBeat.o(205235);
        return;
        localc = localk.deA;
        if (localc == null) {
          p.bdF("extractor");
        }
        localc.setDataSource(localFileDescriptor);
        localc = localk.thA;
        if (localc == null) {
          p.bdF("frameFlagExtractor");
        }
        localc.setDataSource(localFileDescriptor);
        break;
      }
      i += 1;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(205237);
    Object localObject = this.sYA;
    ((k)localObject).releaseDecoder();
    c localc = ((k)localObject).deA;
    if (localc == null) {
      p.bdF("extractor");
    }
    localc.release();
    localc = ((k)localObject).thA;
    if (localc == null) {
      p.bdF("frameFlagExtractor");
    }
    localc.release();
    localObject = ((k)localObject).thB;
    if (localObject == null) {
      p.bdF("ht");
    }
    ((HandlerThread)localObject).quit();
    AppMethodBeat.o(205237);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(205238);
    Bitmap localBitmap = this.sYz.getTextureView().getBitmap();
    AppMethodBeat.o(205238);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.sYz;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(205236);
    Object localObject2 = this.sYA;
    synchronized (((k)localObject2).lock)
    {
      ((k)localObject2).thC = paramLong;
      Object localObject4 = ((k)localObject2).thA;
      if (localObject4 == null) {
        p.bdF("frameFlagExtractor");
      }
      ((c)localObject4).seekTo(((k)localObject2).thC * 1000L, 0);
      localObject4 = ((k)localObject2).thA;
      if (localObject4 == null) {
        p.bdF("frameFlagExtractor");
      }
      long l = ((c)localObject4).getSampleTime();
      if ((l == ((k)localObject2).thD) && (((k)localObject2).thF >= 0L) && (((k)localObject2).thF < paramLong * 1000L))
      {
        com.tencent.mm.sdk.platformtools.ae.i(((k)localObject2).TAG, "lxl same taget~");
        if (!((k)localObject2).gxv)
        {
          localObject4 = ((k)localObject2).decoder;
          if (localObject4 != null) {
            ((MediaCodec)localObject4).start();
          }
          ((k)localObject2).gxv = true;
        }
        ((k)localObject2).lock.notify();
        localObject2 = z.Nhr;
        AppMethodBeat.o(205236);
        return;
      }
      ((k)localObject2).thD = l;
      localObject4 = ((k)localObject2).deA;
      if (localObject4 == null) {
        p.bdF("extractor");
      }
      ((c)localObject4).seekTo(((k)localObject2).thC * 1000L, 0);
      if (((k)localObject2).gxv)
      {
        localObject4 = ((k)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).flush();
        }
        localObject4 = ((k)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).start();
        }
      }
      com.tencent.mm.sdk.platformtools.ae.i(((k)localObject2).TAG, "lxl change taget, start sync time:" + ((k)localObject2).thD / 1000L + ", target time:" + paramLong + ", flush:" + ((k)localObject2).gxv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.e
 * JD-Core Version:    0.7.0.1
 */