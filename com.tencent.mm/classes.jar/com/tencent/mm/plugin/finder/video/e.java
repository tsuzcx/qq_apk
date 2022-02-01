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
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.plugin.finder.view.h.a;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameView", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "seeker", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class e
  implements n
{
  private FinderVideoFrameView rQO;
  private h rQP;
  
  public e(Context paramContext, bqs parambqs)
  {
    AppMethodBeat.i(203706);
    this.rQO = new FinderVideoFrameView(paramContext);
    paramContext = parambqs.url;
    k.g(paramContext, "media.url");
    this.rQP = new h(paramContext, this.rQO.getTextureView());
    AppMethodBeat.o(203706);
  }
  
  public final void a(a<y> parama1, a<y> parama2, b<? super Long, y> paramb)
  {
    AppMethodBeat.i(203702);
    k.h(parama1, "onReady");
    k.h(parama2, "onDestroy");
    k.h(paramb, "onSeekFrame");
    h localh = this.rQP;
    k.h(parama1, "onTextureReady");
    k.h(parama2, "onTextureDestroy");
    k.h(paramb, "onSeekFrame");
    Object localObject = d.gy("FinderVideoFrameSeeker_renderThread" + localh.hashCode(), -2);
    k.g(localObject, "SpecialThreadFactory.cre…READ_PRIORITY_FOREGROUND)");
    localh.rZs = ((HandlerThread)localObject);
    localObject = localh.rZs;
    if (localObject == null) {
      k.aVY("ht");
    }
    ((HandlerThread)localObject).start();
    localObject = localh.rZs;
    if (localObject == null) {
      k.aVY("ht");
    }
    localh.handler = new ao(((HandlerThread)localObject).getLooper());
    localh.cSi = new c();
    localh.rZr = new c();
    localObject = i.cY(localh.path, false);
    k.g(localObject, "raf");
    FileDescriptor localFileDescriptor = ((RandomAccessFile)localObject).getFD();
    c localc;
    int j;
    int i;
    if (ae.fJf.fIY == 1)
    {
      localc = localh.cSi;
      if (localc == null) {
        k.aVY("extractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, i.aSp(localh.path));
      localc = localh.rZr;
      if (localc == null) {
        k.aVY("frameFlagExtractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, i.aSp(localh.path));
      ((RandomAccessFile)localObject).close();
      localObject = localh.cSi;
      if (localObject == null) {
        k.aVY("extractor");
      }
      j = ((c)localObject).getTrackCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject = localh.cSi;
        if (localObject == null) {
          k.aVY("extractor");
        }
        localObject = ((c)localObject).getTrackFormat(i);
        k.g(localObject, "extractor.getTrackFormat(i)");
        localh.mediaFormat = ((MediaFormat)localObject);
        localObject = localh.mediaFormat;
        if (localObject == null) {
          k.aVY("mediaFormat");
        }
        localObject = ((MediaFormat)localObject).getString("mime");
        k.g(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)");
        localh.mime = ((String)localObject);
        localObject = localh.mime;
        if (localObject == null) {
          k.aVY("mime");
        }
        if (d.n.n.nb((String)localObject, "video/"))
        {
          localObject = localh.cSi;
          if (localObject == null) {
            k.aVY("extractor");
          }
          ((c)localObject).selectTrack(i);
          localObject = localh.rZr;
          if (localObject == null) {
            k.aVY("frameFlagExtractor");
          }
          ((c)localObject).selectTrack(i);
        }
      }
      else
      {
        localh.aTL.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new h.a(localh, parama2, paramb, parama1));
        AppMethodBeat.o(203702);
        return;
        localc = localh.cSi;
        if (localc == null) {
          k.aVY("extractor");
        }
        localc.setDataSource(localFileDescriptor);
        localc = localh.rZr;
        if (localc == null) {
          k.aVY("frameFlagExtractor");
        }
        localc.setDataSource(localFileDescriptor);
        break;
      }
      i += 1;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(203704);
    Object localObject = this.rQP;
    ((h)localObject).releaseDecoder();
    c localc = ((h)localObject).cSi;
    if (localc == null) {
      k.aVY("extractor");
    }
    localc.release();
    localc = ((h)localObject).rZr;
    if (localc == null) {
      k.aVY("frameFlagExtractor");
    }
    localc.release();
    localObject = ((h)localObject).rZs;
    if (localObject == null) {
      k.aVY("ht");
    }
    ((HandlerThread)localObject).quit();
    AppMethodBeat.o(203704);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(203705);
    Bitmap localBitmap = this.rQO.getTextureView().getBitmap();
    AppMethodBeat.o(203705);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.rQO;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(203703);
    Object localObject2 = this.rQP;
    synchronized (((h)localObject2).lock)
    {
      ((h)localObject2).rZt = paramLong;
      Object localObject4 = ((h)localObject2).rZr;
      if (localObject4 == null) {
        k.aVY("frameFlagExtractor");
      }
      ((c)localObject4).seekTo(((h)localObject2).rZt * 1000L, 0);
      localObject4 = ((h)localObject2).rZr;
      if (localObject4 == null) {
        k.aVY("frameFlagExtractor");
      }
      long l = ((c)localObject4).getSampleTime();
      if ((l == ((h)localObject2).rZu) && (((h)localObject2).rZw >= 0L) && (((h)localObject2).rZw < paramLong * 1000L))
      {
        ac.i(((h)localObject2).TAG, "lxl same taget~");
        if (!((h)localObject2).gbe)
        {
          localObject4 = ((h)localObject2).decoder;
          if (localObject4 != null) {
            ((MediaCodec)localObject4).start();
          }
          ((h)localObject2).gbe = true;
        }
        ((h)localObject2).lock.notify();
        localObject2 = y.KTp;
        AppMethodBeat.o(203703);
        return;
      }
      ((h)localObject2).rZu = l;
      localObject4 = ((h)localObject2).cSi;
      if (localObject4 == null) {
        k.aVY("extractor");
      }
      ((c)localObject4).seekTo(((h)localObject2).rZt * 1000L, 0);
      if (((h)localObject2).gbe)
      {
        localObject4 = ((h)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).flush();
        }
        localObject4 = ((h)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).start();
        }
      }
      ac.i(((h)localObject2).TAG, "lxl change taget, start sync time:" + ((h)localObject2).rZu / 1000L + ", target time:" + paramLong + ", flush:" + ((h)localObject2).gbe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.e
 * JD-Core Version:    0.7.0.1
 */