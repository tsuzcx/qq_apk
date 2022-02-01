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
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.finder.view.FinderVideoFrameView;
import com.tencent.mm.plugin.finder.view.s;
import com.tencent.mm.plugin.finder.view.s.a;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.u;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameView", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "seeker", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class f
  implements q
{
  private FinderVideoFrameView ALy;
  private s ALz;
  
  public f(Context paramContext, csg paramcsg)
  {
    AppMethodBeat.i(285427);
    this.ALy = new FinderVideoFrameView(paramContext);
    paramcsg = paramcsg.url;
    paramContext = paramcsg;
    if (paramcsg == null) {
      paramContext = "";
    }
    this.ALz = new s(paramContext, this.ALy.getTextureView());
    AppMethodBeat.o(285427);
  }
  
  public final void a(a<x> parama1, a<x> parama2, b<? super Long, x> paramb)
  {
    AppMethodBeat.i(285423);
    p.k(parama1, "onReady");
    p.k(parama2, "onDestroy");
    p.k(paramb, "onSeekFrame");
    s locals = this.ALz;
    p.k(parama1, "onTextureReady");
    p.k(parama2, "onTextureDestroy");
    p.k(paramb, "onSeekFrame");
    Object localObject = d.ij("FinderVideoFrameSeeker_renderThread" + locals.hashCode(), -2);
    p.j(localObject, "SpecialThreadFactory.cre…READ_PRIORITY_FOREGROUND)");
    locals.Bbu = ((HandlerThread)localObject);
    localObject = locals.Bbu;
    if (localObject == null) {
      p.bGy("ht");
    }
    ((HandlerThread)localObject).start();
    localObject = locals.Bbu;
    if (localObject == null) {
      p.bGy("ht");
    }
    locals.handler = new MMHandler(((HandlerThread)localObject).getLooper());
    locals.miS = new c();
    locals.Bbt = new c();
    localObject = u.dO(locals.path, false);
    p.j(localObject, "VFSFileOp.openRandomAccess(path, false)");
    FileDescriptor localFileDescriptor = ((RandomAccessFile)localObject).getFD();
    c localc;
    int j;
    int i;
    if (af.juJ.juw == 1)
    {
      localc = locals.miS;
      if (localc == null) {
        p.bGy("extractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, u.bBQ(locals.path));
      localc = locals.Bbt;
      if (localc == null) {
        p.bGy("frameFlagExtractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, u.bBQ(locals.path));
      ((RandomAccessFile)localObject).close();
      localObject = locals.miS;
      if (localObject == null) {
        p.bGy("extractor");
      }
      j = ((c)localObject).getTrackCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject = locals.miS;
        if (localObject == null) {
          p.bGy("extractor");
        }
        localObject = ((c)localObject).getTrackFormat(i);
        p.j(localObject, "extractor.getTrackFormat(i)");
        locals.mediaFormat = ((MediaFormat)localObject);
        localObject = locals.mediaFormat;
        if (localObject == null) {
          p.bGy("mediaFormat");
        }
        localObject = ((MediaFormat)localObject).getString("mime");
        p.j(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)");
        locals.aFM = ((String)localObject);
        localObject = locals.aFM;
        if (localObject == null) {
          p.bGy("mime");
        }
        if (n.M((String)localObject, "video/", false))
        {
          localObject = locals.miS;
          if (localObject == null) {
            p.bGy("extractor");
          }
          ((c)localObject).selectTrack(i);
          localObject = locals.Bbt;
          if (localObject == null) {
            p.bGy("frameFlagExtractor");
          }
          ((c)localObject).selectTrack(i);
        }
      }
      else
      {
        locals.aND.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new s.a(locals, parama2, paramb, parama1));
        AppMethodBeat.o(285423);
        return;
        localc = locals.miS;
        if (localc == null) {
          p.bGy("extractor");
        }
        localc.setDataSource(localFileDescriptor);
        localc = locals.Bbt;
        if (localc == null) {
          p.bGy("frameFlagExtractor");
        }
        localc.setDataSource(localFileDescriptor);
        break;
      }
      i += 1;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(285425);
    Object localObject = this.ALz;
    ((s)localObject).releaseDecoder();
    c localc = ((s)localObject).miS;
    if (localc == null) {
      p.bGy("extractor");
    }
    localc.release();
    localc = ((s)localObject).Bbt;
    if (localc == null) {
      p.bGy("frameFlagExtractor");
    }
    localc.release();
    localObject = ((s)localObject).Bbu;
    if (localObject == null) {
      p.bGy("ht");
    }
    ((HandlerThread)localObject).quit();
    AppMethodBeat.o(285425);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(285426);
    Bitmap localBitmap = this.ALy.getTextureView().getBitmap();
    AppMethodBeat.o(285426);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.ALy;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(285424);
    Object localObject2 = this.ALz;
    synchronized (((s)localObject2).lock)
    {
      ((s)localObject2).Bbv = paramLong;
      Object localObject4 = ((s)localObject2).Bbt;
      if (localObject4 == null) {
        p.bGy("frameFlagExtractor");
      }
      ((c)localObject4).seekTo(((s)localObject2).Bbv * 1000L, 0);
      localObject4 = ((s)localObject2).Bbt;
      if (localObject4 == null) {
        p.bGy("frameFlagExtractor");
      }
      long l = ((c)localObject4).getSampleTime();
      if ((l == ((s)localObject2).Bbw) && (((s)localObject2).Bby >= 0L) && (((s)localObject2).Bby < paramLong * 1000L))
      {
        Log.i(((s)localObject2).TAG, "lxl same taget~");
        if (!((s)localObject2).jVR)
        {
          localObject4 = ((s)localObject2).decoder;
          if (localObject4 != null) {
            ((MediaCodec)localObject4).start();
          }
          ((s)localObject2).jVR = true;
        }
        ((s)localObject2).lock.notify();
        localObject2 = x.aazN;
        AppMethodBeat.o(285424);
        return;
      }
      ((s)localObject2).Bbw = l;
      localObject4 = ((s)localObject2).miS;
      if (localObject4 == null) {
        p.bGy("extractor");
      }
      ((c)localObject4).seekTo(((s)localObject2).Bbv * 1000L, 0);
      if (((s)localObject2).jVR)
      {
        localObject4 = ((s)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).flush();
        }
        localObject4 = ((s)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).start();
        }
      }
      Log.i(((s)localObject2).TAG, "lxl change taget, start sync time:" + ((s)localObject2).Bbw / 1000L + ", target time:" + paramLong + ", flush:" + ((s)localObject2).jVR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.f
 * JD-Core Version:    0.7.0.1
 */