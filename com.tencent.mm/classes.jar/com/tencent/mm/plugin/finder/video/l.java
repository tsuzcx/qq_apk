package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.report.r.c;
import com.tencent.mm.plugin.finder.report.r.e;
import com.tencent.mm.plugin.finder.upload.c.a;
import com.tencent.mm.plugin.finder.upload.c.a.a;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.g.b.z.c;
import kotlin.g.b.z.d;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCropTailor;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "TAG", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "onInput", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "remux", "", "it", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "result", "Lcom/tencent/mm/plugin/finder/video/FinderMediaTailorResult;", "thumbWidth", "thumbHeight", "mediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "resize", "Lkotlin/Pair;", "originWidth", "originHeight", "maxWidth", "plugin-finder_release"})
public final class l
  implements com.tencent.mm.plugin.gallery.picker.b.a<String, b.f>
{
  final String TAG;
  private final b.b wez;
  
  public l(b.b paramb)
  {
    AppMethodBeat.i(168052);
    this.wez = paramb;
    this.TAG = "Finder.FinderVideoCropTailor";
    AppMethodBeat.o(168052);
  }
  
  private static Rect a(Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    AppMethodBeat.i(168051);
    float f = 1.0F * paramRect1.width() / paramRect2.width();
    int i = paramRect3.left - paramRect1.left;
    int j = paramRect3.top - paramRect1.top;
    int k = paramRect3.width();
    int m = paramRect3.height();
    paramRect1 = new Rect((int)(i / f), (int)((m + j) / f), (int)((k + i) / f), (int)(j / f));
    AppMethodBeat.o(168051);
    return paramRect1;
  }
  
  private final boolean a(cjl paramcjl, e parame, int paramInt1, int paramInt2, com.tencent.mm.plugin.sight.base.a parama)
  {
    AppMethodBeat.i(168050);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    final VideoTransPara localVideoTransPara = com.tencent.mm.plugin.finder.storage.c.dqx();
    final Object localObject4 = new Object();
    final z.a locala = new z.a();
    locala.SYB = false;
    final z.d locald1 = new z.d();
    locald1.SYE = -1;
    int i;
    Object localObject3;
    String str;
    z.c localc;
    int n;
    z.d locald2;
    label196:
    final z.d locald3;
    label230:
    int k;
    int m;
    label284:
    label309:
    int j;
    int i1;
    c.a.a locala1;
    final long l1;
    if (com.tencent.mm.modelcontrol.e.sX(4))
    {
      i = 2;
      localObject1 = new com.tencent.mm.plugin.finder.loader.s(paramcjl, com.tencent.mm.plugin.finder.storage.x.vEA, i, null, 8);
      localObject3 = al.waC;
      localObject3 = String.valueOf(cl.aWy());
      p.h(localObject1, "video");
      p.h(localObject3, "suffix");
      str = al.dEG() + ((com.tencent.mm.plugin.finder.loader.s)localObject1).auA() + "_" + (String)localObject3;
      localc = new z.c();
      localc.SYD = 0.0F;
      n = SightVideoJNI.getMp4RotateVFS(paramcjl.url);
      locald2 = new z.d();
      localObject1 = paramcjl.uOR;
      if (localObject1 == null) {
        break label1057;
      }
      i = ((cjx)localObject1).width;
      locald2.SYE = i;
      locald3 = new z.d();
      localObject1 = paramcjl.uOR;
      if (localObject1 == null) {
        break label1063;
      }
      i = ((cjx)localObject1).height;
      locald3.SYE = i;
      k = parama.width;
      m = parama.height;
      if ((n == 90) || (n == 270))
      {
        localObject1 = paramcjl.uOR;
        if (localObject1 == null) {
          break label1069;
        }
        i = ((cjx)localObject1).height;
        locald2.SYE = i;
        localObject1 = paramcjl.uOR;
        if (localObject1 == null) {
          break label1075;
        }
        i = ((cjx)localObject1).width;
        locald3.SYE = i;
      }
      j = localVideoTransPara.videoBitrate;
      localObject1 = r.c.vhb;
      r.c.nT(false);
      Log.i(this.TAG, "video rotate:" + n + ", width:" + locald2.SYE + ", height:" + locald3.SYE + " url " + paramcjl.url + " thumbUrl: " + paramcjl.thumbUrl + " size:" + Util.getSizeKB(com.tencent.mm.vfs.s.boW(paramcjl.url)));
      localObject1 = com.tencent.mm.plugin.finder.upload.c.vRQ;
      localObject3 = paramcjl.url;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      i = locald2.SYE;
      n = locald3.SYE;
      localObject3 = paramcjl.uOR;
      if (localObject3 == null) {
        p.hyc();
      }
      i1 = ((cjx)localObject3).iqg;
      localObject3 = paramcjl.uOR;
      if (localObject3 == null) {
        p.hyc();
      }
      float f = (i1 - ((cjx)localObject3).dvv) / 1000.0F;
      localObject3 = paramcjl.uOR;
      if (localObject3 == null) {
        p.hyc();
      }
      locala1 = c.a.a((String)localObject1, i, n, f, ((cjx)localObject3).dvv / 1000.0F, localVideoTransPara, false);
      i = j;
      if (locala1.errCode == 0)
      {
        i = j;
        if (locala1.width > 0)
        {
          i = j;
          if (locala1.height > 0)
          {
            i = j;
            if (locala1.bitrate > 0)
            {
              locald2.SYE = locala1.width;
              locald3.SYE = locala1.height;
              i = locala1.bitrate;
              Log.i(this.TAG, "video abaResult, width:" + locald2.SYE + ", height:" + locald3.SYE + ", " + i);
            }
          }
        }
      }
      l1 = Util.currentTicks();
    }
    for (;;)
    {
      try
      {
        localObject3 = paramcjl.url;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = com.tencent.mm.plugin.finder.upload.c.vRQ;
        localObject3 = paramcjl.uOR;
        if (localObject3 != null)
        {
          localObject3 = ((cjx)localObject3).Mpq;
          if (localObject3 == null) {
            p.hyc();
          }
          p.g(localObject3, "it.cropInfo?.rect!!");
          localObject3 = c.a.a((erf)localObject3);
          j = locald2.SYE;
          n = locald3.SYE;
          i1 = localVideoTransPara.audioBitrate;
          int i2 = localVideoTransPara.audioSampleRate;
          int i3 = localVideoTransPara.audioChannelCount;
          int i4 = localVideoTransPara.fps;
          cjx localcjx = paramcjl.uOR;
          if (localcjx == null) {
            p.hyc();
          }
          long l2 = localcjx.dvv;
          localcjx = paramcjl.uOR;
          if (localcjx == null) {
            p.hyc();
          }
          localObject1 = new n(null, (String)localObject1, 1, str, (Rect)localObject3, j, n, i, i1, i2, i3, i4, l2, localcjx.iqg, false, false, localVideoTransPara.iiH, (b)new a(localc), (b)new b(this, locald1, l1, locald2, locald3, localVideoTransPara, localObject4, locala), k, m);
          ((n)localObject1).aMG();
        }
      }
      catch (Throwable localThrowable1)
      {
        label1057:
        label1063:
        label1069:
        label1075:
        parame.ret = -10;
        Log.printErrStackTrace(this.TAG, localThrowable1, "create remuxer failed", new Object[0]);
        localObject2 = r.c.vhb;
        r.c.nU(false);
        localObject2 = r.e.vhB;
        r.e.Fn(Util.ticksToNow(l1));
        localObject2 = r.e.vhB;
        r.e.a(parama, null, (int)com.tencent.mm.vfs.s.boW(paramcjl.url), 0, Util.ticksToNow(l1), parame.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      try
      {
        if (!locala.SYB)
        {
          Log.i(this.TAG, "wait");
          localObject4.wait();
          Log.i(this.TAG, "notify, " + locald1.SYE);
        }
        localObject1 = kotlin.x.SXb;
        if (locald1.SYE >= 0) {
          break label1180;
        }
        parame.ret = locald1.SYE;
        localObject1 = r.e.vhB;
        r.e.Fn(Util.ticksToNow(l1));
        localObject1 = r.e.vhB;
        r.e.a(parama, null, (int)com.tencent.mm.vfs.s.boW(paramcjl.url), 0, Util.ticksToNow(l1), parame.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      finally
      {
        AppMethodBeat.o(168050);
      }
      i = 1;
      break;
      i = 0;
      break label196;
      i = 0;
      break label230;
      i = 0;
      break label284;
      i = 0;
      break label309;
      localObject3 = null;
    }
    Object localObject2;
    label1180:
    if ((locala1.errCode == 0) && (locala1.vRR != null) && (locala1.width > 0) && (locala1.height > 0) && (locala1.bitrate > 0)) {}
    try
    {
      SightVideoJNI.addReportMetadata(str, locala1.vRR, localVideoTransPara.iTg, 0);
      label1236:
      parame.ayV(str);
      localObject2 = f.vSz;
      parame.HA(f.a(str, paramInt1, paramInt2, null));
      localObject2 = r.e.vhB;
      r.e.Fn(Util.ticksToNow(l1));
      localObject2 = com.tencent.mm.plugin.sight.base.e.aNx(str);
      localObject3 = r.e.vhB;
      r.e.a(parama, (com.tencent.mm.plugin.sight.base.a)localObject2, (int)com.tencent.mm.vfs.s.boW(paramcjl.url), (int)com.tencent.mm.vfs.s.boW(str), Util.ticksToNow(l1), parame.ret);
      AppMethodBeat.o(168050);
      return true;
    }
    catch (Throwable localThrowable2)
    {
      break label1236;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<Float, kotlin.x>
  {
    a(z.c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements b<String, kotlin.x>
  {
    b(l paraml, z.d paramd1, long paramLong, z.d paramd2, z.d paramd3, VideoTransPara paramVideoTransPara, Object paramObject, z.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.l
 * JD-Core Version:    0.7.0.1
 */