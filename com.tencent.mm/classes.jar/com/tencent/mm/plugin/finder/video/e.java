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
import com.tencent.mm.plugin.finder.view.j;
import com.tencent.mm.plugin.finder.view.j.a;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameView", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "seeker", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class e
  implements n
{
  private FinderVideoFrameView sNo;
  private j sNp;
  
  public e(Context paramContext, bvf parambvf)
  {
    AppMethodBeat.i(204615);
    this.sNo = new FinderVideoFrameView(paramContext);
    paramContext = parambvf.url;
    p.g(paramContext, "media.url");
    this.sNp = new j(paramContext, this.sNo.getTextureView());
    AppMethodBeat.o(204615);
  }
  
  public final void a(a<z> parama1, a<z> parama2, b<? super Long, z> paramb)
  {
    AppMethodBeat.i(204611);
    p.h(parama1, "onReady");
    p.h(parama2, "onDestroy");
    p.h(paramb, "onSeekFrame");
    j localj = this.sNp;
    p.h(parama1, "onTextureReady");
    p.h(parama2, "onTextureDestroy");
    p.h(paramb, "onSeekFrame");
    Object localObject = d.gW("FinderVideoFrameSeeker_renderThread" + localj.hashCode(), -2);
    p.g(localObject, "SpecialThreadFactory.cre…READ_PRIORITY_FOREGROUND)");
    localj.sWo = ((HandlerThread)localObject);
    localObject = localj.sWo;
    if (localObject == null) {
      p.bcb("ht");
    }
    ((HandlerThread)localObject).start();
    localObject = localj.sWo;
    if (localObject == null) {
      p.bcb("ht");
    }
    localj.handler = new ap(((HandlerThread)localObject).getLooper());
    localj.ddy = new c();
    localj.sWn = new c();
    localObject = i.dd(localj.path, false);
    p.g(localObject, "raf");
    FileDescriptor localFileDescriptor = ((RandomAccessFile)localObject).getFD();
    c localc;
    int j;
    int i;
    if (ae.gcG.gcz == 1)
    {
      localc = localj.ddy;
      if (localc == null) {
        p.bcb("extractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, i.aYo(localj.path));
      localc = localj.sWn;
      if (localc == null) {
        p.bcb("frameFlagExtractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, i.aYo(localj.path));
      ((RandomAccessFile)localObject).close();
      localObject = localj.ddy;
      if (localObject == null) {
        p.bcb("extractor");
      }
      j = ((c)localObject).getTrackCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject = localj.ddy;
        if (localObject == null) {
          p.bcb("extractor");
        }
        localObject = ((c)localObject).getTrackFormat(i);
        p.g(localObject, "extractor.getTrackFormat(i)");
        localj.mediaFormat = ((MediaFormat)localObject);
        localObject = localj.mediaFormat;
        if (localObject == null) {
          p.bcb("mediaFormat");
        }
        localObject = ((MediaFormat)localObject).getString("mime");
        p.g(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)");
        localj.mime = ((String)localObject);
        localObject = localj.mime;
        if (localObject == null) {
          p.bcb("mime");
        }
        if (d.n.n.nz((String)localObject, "video/"))
        {
          localObject = localj.ddy;
          if (localObject == null) {
            p.bcb("extractor");
          }
          ((c)localObject).selectTrack(i);
          localObject = localj.sWn;
          if (localObject == null) {
            p.bcb("frameFlagExtractor");
          }
          ((c)localObject).selectTrack(i);
        }
      }
      else
      {
        localj.bef.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new j.a(localj, parama2, paramb, parama1));
        AppMethodBeat.o(204611);
        return;
        localc = localj.ddy;
        if (localc == null) {
          p.bcb("extractor");
        }
        localc.setDataSource(localFileDescriptor);
        localc = localj.sWn;
        if (localc == null) {
          p.bcb("frameFlagExtractor");
        }
        localc.setDataSource(localFileDescriptor);
        break;
      }
      i += 1;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(204613);
    Object localObject = this.sNp;
    ((j)localObject).releaseDecoder();
    c localc = ((j)localObject).ddy;
    if (localc == null) {
      p.bcb("extractor");
    }
    localc.release();
    localc = ((j)localObject).sWn;
    if (localc == null) {
      p.bcb("frameFlagExtractor");
    }
    localc.release();
    localObject = ((j)localObject).sWo;
    if (localObject == null) {
      p.bcb("ht");
    }
    ((HandlerThread)localObject).quit();
    AppMethodBeat.o(204613);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(204614);
    Bitmap localBitmap = this.sNo.getTextureView().getBitmap();
    AppMethodBeat.o(204614);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.sNo;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(204612);
    Object localObject2 = this.sNp;
    synchronized (((j)localObject2).lock)
    {
      ((j)localObject2).sWp = paramLong;
      Object localObject4 = ((j)localObject2).sWn;
      if (localObject4 == null) {
        p.bcb("frameFlagExtractor");
      }
      ((c)localObject4).seekTo(((j)localObject2).sWp * 1000L, 0);
      localObject4 = ((j)localObject2).sWn;
      if (localObject4 == null) {
        p.bcb("frameFlagExtractor");
      }
      long l = ((c)localObject4).getSampleTime();
      if ((l == ((j)localObject2).sWq) && (((j)localObject2).sWs >= 0L) && (((j)localObject2).sWs < paramLong * 1000L))
      {
        ad.i(((j)localObject2).TAG, "lxl same taget~");
        if (!((j)localObject2).guO)
        {
          localObject4 = ((j)localObject2).decoder;
          if (localObject4 != null) {
            ((MediaCodec)localObject4).start();
          }
          ((j)localObject2).guO = true;
        }
        ((j)localObject2).lock.notify();
        localObject2 = z.MKo;
        AppMethodBeat.o(204612);
        return;
      }
      ((j)localObject2).sWq = l;
      localObject4 = ((j)localObject2).ddy;
      if (localObject4 == null) {
        p.bcb("extractor");
      }
      ((c)localObject4).seekTo(((j)localObject2).sWp * 1000L, 0);
      if (((j)localObject2).guO)
      {
        localObject4 = ((j)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).flush();
        }
        localObject4 = ((j)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).start();
        }
      }
      ad.i(((j)localObject2).TAG, "lxl change taget, start sync time:" + ((j)localObject2).sWq / 1000L + ", target time:" + paramLong + ", flush:" + ((j)localObject2).guO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.e
 * JD-Core Version:    0.7.0.1
 */