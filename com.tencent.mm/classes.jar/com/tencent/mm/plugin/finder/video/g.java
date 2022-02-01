package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.finder.view.FinderVideoFrameView;
import com.tencent.mm.plugin.finder.view.v;
import com.tencent.mm.plugin.finder.view.v.a;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.c.d;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameView", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "seeker", "Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameSeeker;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements r
{
  private FinderVideoFrameView Gou;
  private v Gov;
  
  public g(Context paramContext, dji paramdji)
  {
    AppMethodBeat.i(334722);
    this.Gou = new FinderVideoFrameView(paramContext);
    paramdji = paramdji.url;
    paramContext = paramdji;
    if (paramdji == null) {
      paramContext = "";
    }
    this.Gov = new v(paramContext, this.Gou.getTextureView());
    AppMethodBeat.o(334722);
  }
  
  public final void a(a<ah> parama1, a<ah> parama2, b<? super Long, ah> paramb)
  {
    AppMethodBeat.i(334749);
    s.u(parama1, "onReady");
    s.u(parama2, "onDestroy");
    s.u(paramb, "onSeekFrame");
    v localv = this.Gov;
    s.u(parama1, "onTextureReady");
    s.u(parama2, "onTextureDestroy");
    s.u(paramb, "onSeekFrame");
    Object localObject = d.jv(s.X("FinderVideoFrameSeeker_renderThread", Integer.valueOf(localv.hashCode())), -2);
    s.s(localObject, "createEGLThread(\"FinderV…READ_PRIORITY_FOREGROUND)");
    s.u(localObject, "<set-?>");
    localv.GDF = ((HandlerThread)localObject);
    localv.fly().start();
    localObject = new MMHandler(localv.fly().getLooper());
    s.u(localObject, "<set-?>");
    localv.handler = ((MMHandler)localObject);
    localObject = new c();
    s.u(localObject, "<set-?>");
    localv.pcp = ((c)localObject);
    localObject = new c();
    s.u(localObject, "<set-?>");
    localv.GDE = ((c)localObject);
    localObject = y.eA(localv.path, false);
    s.s(localObject, "openRandomAccess(path, false)");
    FileDescriptor localFileDescriptor = ((RandomAccessFile)localObject).getFD();
    int k;
    if (af.lYa.lXN == 1)
    {
      localv.flw().setDataSource(localFileDescriptor, 0L, y.bEl(localv.path));
      localv.flx().setDataSource(localFileDescriptor, 0L, y.bEl(localv.path));
      ((RandomAccessFile)localObject).close();
      k = localv.flw().lZm.getTrackCount();
      if (k <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject = localv.flw().getTrackFormat(i);
      s.s(localObject, "extractor.getTrackFormat(i)");
      s.u(localObject, "<set-?>");
      localv.mediaFormat = ((MediaFormat)localObject);
      localObject = localv.getMediaFormat().getString("mime");
      s.checkNotNull(localObject);
      s.s(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)!!");
      s.u(localObject, "<set-?>");
      localv.cBw = ((String)localObject);
      if (n.U(localv.OT(), "video/", false))
      {
        localv.flw().selectTrack(i);
        localv.flx().selectTrack(i);
      }
      while (j >= k)
      {
        localv.cHz.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new v.a(localv, parama2, paramb, parama1));
        AppMethodBeat.o(334749);
        return;
        localv.flw().setDataSource(localFileDescriptor);
        localv.flx().setDataSource(localFileDescriptor);
        break;
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(334783);
    v localv = this.Gov;
    localv.releaseDecoder();
    localv.flw().lZm.release();
    localv.flx().lZm.release();
    localv.fly().quit();
    AppMethodBeat.o(334783);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(334804);
    Bitmap localBitmap = this.Gou.getTextureView().getBitmap();
    AppMethodBeat.o(334804);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.Gou;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(334771);
    Object localObject2 = this.Gov;
    synchronized (((v)localObject2).lock)
    {
      ((v)localObject2).GDG = paramLong;
      ((v)localObject2).flx().seekTo(((v)localObject2).GDG * 1000L, 0);
      long l = ((v)localObject2).flx().lZm.getSampleTime();
      MediaCodec localMediaCodec;
      if ((l == ((v)localObject2).GDH) && (((v)localObject2).GDJ >= 0L) && (((v)localObject2).GDJ < paramLong * 1000L))
      {
        Log.i(((v)localObject2).TAG, "lxl same taget~");
        if (!((v)localObject2).mvL)
        {
          localMediaCodec = ((v)localObject2).decoder;
          if (localMediaCodec != null) {
            localMediaCodec.start();
          }
          ((v)localObject2).mvL = true;
        }
        ((v)localObject2).lock.notify();
        localObject2 = ah.aiuX;
        AppMethodBeat.o(334771);
        return;
      }
      ((v)localObject2).GDH = l;
      ((v)localObject2).flw().seekTo(((v)localObject2).GDG * 1000L, 0);
      if (((v)localObject2).mvL)
      {
        localMediaCodec = ((v)localObject2).decoder;
        if (localMediaCodec != null) {
          localMediaCodec.flush();
        }
        localMediaCodec = ((v)localObject2).decoder;
        if (localMediaCodec != null) {
          localMediaCodec.start();
        }
      }
      Log.i(((v)localObject2).TAG, "lxl change taget, start sync time:" + ((v)localObject2).GDH / 1000L + ", target time:" + paramLong + ", flush:" + ((v)localObject2).mvL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.g
 * JD-Core Version:    0.7.0.1
 */