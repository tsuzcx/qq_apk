package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.finder.view.FinderVideoFrameView;
import com.tencent.mm.plugin.finder.view.m;
import com.tencent.mm.plugin.finder.view.m.a;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.s;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameView", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "seeker", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class f
  implements p
{
  private FinderVideoFrameView wcP;
  private m wcQ;
  
  public f(Context paramContext, cjl paramcjl)
  {
    AppMethodBeat.i(254064);
    this.wcP = new FinderVideoFrameView(paramContext);
    paramcjl = paramcjl.url;
    paramContext = paramcjl;
    if (paramcjl == null) {
      paramContext = "";
    }
    this.wcQ = new m(paramContext, this.wcP.getTextureView());
    AppMethodBeat.o(254064);
  }
  
  public final void a(a<x> parama1, a<x> parama2, b<? super Long, x> paramb)
  {
    AppMethodBeat.i(254060);
    kotlin.g.b.p.h(parama1, "onReady");
    kotlin.g.b.p.h(parama2, "onDestroy");
    kotlin.g.b.p.h(paramb, "onSeekFrame");
    m localm = this.wcQ;
    kotlin.g.b.p.h(parama1, "onTextureReady");
    kotlin.g.b.p.h(parama2, "onTextureDestroy");
    kotlin.g.b.p.h(paramb, "onSeekFrame");
    Object localObject = d.hz("FinderVideoFrameSeeker_renderThread" + localm.hashCode(), -2);
    kotlin.g.b.p.g(localObject, "SpecialThreadFactory.cre…READ_PRIORITY_FOREGROUND)");
    localm.wpM = ((HandlerThread)localObject);
    localObject = localm.wpM;
    if (localObject == null) {
      kotlin.g.b.p.btv("ht");
    }
    ((HandlerThread)localObject).start();
    localObject = localm.wpM;
    if (localObject == null) {
      kotlin.g.b.p.btv("ht");
    }
    localm.handler = new MMHandler(((HandlerThread)localObject).getLooper());
    localm.jto = new c();
    localm.wpL = new c();
    localObject = s.dB(localm.path, false);
    kotlin.g.b.p.g(localObject, "VFSFileOp.openRandomAccess(path, false)");
    FileDescriptor localFileDescriptor = ((RandomAccessFile)localObject).getFD();
    c localc;
    int j;
    int i;
    if (ae.gKv.gKi == 1)
    {
      localc = localm.jto;
      if (localc == null) {
        kotlin.g.b.p.btv("extractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, s.boW(localm.path));
      localc = localm.wpL;
      if (localc == null) {
        kotlin.g.b.p.btv("frameFlagExtractor");
      }
      localc.setDataSource(localFileDescriptor, 0L, s.boW(localm.path));
      ((RandomAccessFile)localObject).close();
      localObject = localm.jto;
      if (localObject == null) {
        kotlin.g.b.p.btv("extractor");
      }
      j = ((c)localObject).getTrackCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        localObject = localm.jto;
        if (localObject == null) {
          kotlin.g.b.p.btv("extractor");
        }
        localObject = ((c)localObject).getTrackFormat(i);
        kotlin.g.b.p.g(localObject, "extractor.getTrackFormat(i)");
        localm.mediaFormat = ((MediaFormat)localObject);
        localObject = localm.mediaFormat;
        if (localObject == null) {
          kotlin.g.b.p.btv("mediaFormat");
        }
        localObject = ((MediaFormat)localObject).getString("mime");
        kotlin.g.b.p.g(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)");
        localm.mime = ((String)localObject);
        localObject = localm.mime;
        if (localObject == null) {
          kotlin.g.b.p.btv("mime");
        }
        if (n.J((String)localObject, "video/", false))
        {
          localObject = localm.jto;
          if (localObject == null) {
            kotlin.g.b.p.btv("extractor");
          }
          ((c)localObject).selectTrack(i);
          localObject = localm.wpL;
          if (localObject == null) {
            kotlin.g.b.p.btv("frameFlagExtractor");
          }
          ((c)localObject).selectTrack(i);
        }
      }
      else
      {
        localm.bec.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new m.a(localm, parama2, paramb, parama1));
        AppMethodBeat.o(254060);
        return;
        localc = localm.jto;
        if (localc == null) {
          kotlin.g.b.p.btv("extractor");
        }
        localc.setDataSource(localFileDescriptor);
        localc = localm.wpL;
        if (localc == null) {
          kotlin.g.b.p.btv("frameFlagExtractor");
        }
        localc.setDataSource(localFileDescriptor);
        break;
      }
      i += 1;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(254062);
    Object localObject = this.wcQ;
    ((m)localObject).releaseDecoder();
    c localc = ((m)localObject).jto;
    if (localc == null) {
      kotlin.g.b.p.btv("extractor");
    }
    localc.release();
    localc = ((m)localObject).wpL;
    if (localc == null) {
      kotlin.g.b.p.btv("frameFlagExtractor");
    }
    localc.release();
    localObject = ((m)localObject).wpM;
    if (localObject == null) {
      kotlin.g.b.p.btv("ht");
    }
    ((HandlerThread)localObject).quit();
    AppMethodBeat.o(254062);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(254063);
    Bitmap localBitmap = this.wcP.getTextureView().getBitmap();
    AppMethodBeat.o(254063);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.wcP;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(254061);
    Object localObject2 = this.wcQ;
    synchronized (((m)localObject2).lock)
    {
      ((m)localObject2).wpN = paramLong;
      Object localObject4 = ((m)localObject2).wpL;
      if (localObject4 == null) {
        kotlin.g.b.p.btv("frameFlagExtractor");
      }
      ((c)localObject4).seekTo(((m)localObject2).wpN * 1000L, 0);
      localObject4 = ((m)localObject2).wpL;
      if (localObject4 == null) {
        kotlin.g.b.p.btv("frameFlagExtractor");
      }
      long l = ((c)localObject4).getSampleTime();
      if ((l == ((m)localObject2).wpO) && (((m)localObject2).wpQ >= 0L) && (((m)localObject2).wpQ < paramLong * 1000L))
      {
        Log.i(((m)localObject2).TAG, "lxl same taget~");
        if (!((m)localObject2).hki)
        {
          localObject4 = ((m)localObject2).decoder;
          if (localObject4 != null) {
            ((MediaCodec)localObject4).start();
          }
          ((m)localObject2).hki = true;
        }
        ((m)localObject2).lock.notify();
        localObject2 = x.SXb;
        AppMethodBeat.o(254061);
        return;
      }
      ((m)localObject2).wpO = l;
      localObject4 = ((m)localObject2).jto;
      if (localObject4 == null) {
        kotlin.g.b.p.btv("extractor");
      }
      ((c)localObject4).seekTo(((m)localObject2).wpN * 1000L, 0);
      if (((m)localObject2).hki)
      {
        localObject4 = ((m)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).flush();
        }
        localObject4 = ((m)localObject2).decoder;
        if (localObject4 != null) {
          ((MediaCodec)localObject4).start();
        }
      }
      Log.i(((m)localObject2).TAG, "lxl change taget, start sync time:" + ((m)localObject2).wpO / 1000L + ", target time:" + paramLong + ", flush:" + ((m)localObject2).hki);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.f
 * JD-Core Version:    0.7.0.1
 */