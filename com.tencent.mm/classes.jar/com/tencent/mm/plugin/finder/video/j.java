package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.report.n.b;
import com.tencent.mm.plugin.finder.report.n.d;
import com.tencent.mm.plugin.finder.upload.c;
import com.tencent.mm.plugin.finder.upload.c.a;
import com.tencent.mm.plugin.finder.upload.c.a.a;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.a;
import d.g.b.y.c;
import d.g.b.y.d;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCropTailor;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "TAG", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "onInput", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "remux", "", "it", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "result", "Lcom/tencent/mm/plugin/finder/video/FinderMediaTailorResult;", "thumbWidth", "thumbHeight", "mediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "resize", "Lkotlin/Pair;", "originWidth", "originHeight", "maxWidth", "plugin-finder_release"})
public final class j
  implements com.tencent.mm.plugin.gallery.picker.b.a<String, b.f>
{
  final String TAG;
  private final b.b sOK;
  
  public j(b.b paramb)
  {
    AppMethodBeat.i(168052);
    this.sOK = paramb;
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
  
  private final boolean a(bvf parambvf, d paramd, int paramInt1, int paramInt2, com.tencent.mm.plugin.sight.base.a parama)
  {
    AppMethodBeat.i(168050);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    Object localObject4 = com.tencent.mm.plugin.finder.storage.b.cEY();
    final Object localObject3 = new Object();
    Object localObject5 = new y.a();
    ((y.a)localObject5).MLQ = false;
    final y.d locald1 = new y.d();
    locald1.MLT = -1;
    if (com.tencent.mm.modelcontrol.d.pf(4)) {}
    Object localObject7;
    final long l;
    for (int i = 2;; i = 1)
    {
      localObject1 = new m(parambvf, com.tencent.mm.plugin.finder.storage.r.syQ, i, null, 8);
      Object localObject6 = com.tencent.mm.plugin.finder.utils.r.sNc;
      localObject6 = String.valueOf(cf.aCK());
      p.h(localObject1, "video");
      p.h(localObject6, "suffix");
      localObject1 = com.tencent.mm.plugin.finder.utils.r.cLP() + ((m)localObject1).aeA() + "_" + (String)localObject6;
      localObject6 = new y.c();
      ((y.c)localObject6).MLS = 0.0F;
      i = SightVideoJNI.getMp4RotateVFS(parambvf.url);
      y.d locald2 = new y.d();
      locald2.MLT = parambvf.skC.width;
      final y.d locald3 = new y.d();
      locald3.MLT = parambvf.skC.height;
      int k = parama.width;
      int m = parama.height;
      if ((i == 90) || (i == 270))
      {
        locald2.MLT = parambvf.skC.height;
        locald3.MLT = parambvf.skC.width;
      }
      int j = ((VideoTransPara)localObject4).videoBitrate;
      localObject7 = n.b.sqe;
      n.b.cDG();
      ad.i(this.TAG, "video rotate:" + i + ", width:" + locald2.MLT + ", height:" + locald3.MLT + " url " + parambvf.url + " thumbUrl: " + parambvf.thumbUrl + " size:" + bt.sy(i.aYo(parambvf.url)));
      localObject7 = c.sIG;
      localObject7 = parambvf.url;
      p.g(localObject7, "it.url");
      i = locald2.MLT;
      int n = locald3.MLT;
      float f1 = (parambvf.skC.htQ - parambvf.skC.ddx) / 1000.0F;
      float f2 = parambvf.skC.ddx / 1000.0F;
      p.g(localObject4, "videoParams");
      localObject7 = c.a.a((String)localObject7, i, n, f1, f2, (VideoTransPara)localObject4);
      i = j;
      if (((c.a.a)localObject7).errCode == 0)
      {
        i = j;
        if (((c.a.a)localObject7).width > 0)
        {
          i = j;
          if (((c.a.a)localObject7).height > 0)
          {
            i = j;
            if (((c.a.a)localObject7).bitrate > 0)
            {
              locald2.MLT = ((c.a.a)localObject7).width;
              locald3.MLT = ((c.a.a)localObject7).height;
              i = ((c.a.a)localObject7).bitrate;
              ad.i(this.TAG, "video abaResult, width:" + locald2.MLT + ", height:" + locald3.MLT + ", " + i);
            }
          }
        }
      }
      l = bt.HI();
      try
      {
        String str = parambvf.url;
        p.g(str, "it.url");
        Object localObject8 = c.sIG;
        localObject8 = parambvf.skC.GPL;
        p.g(localObject8, "it.cropInfo.rect");
        localObject6 = new l(null, str, 1, (String)localObject1, c.a.a((dwe)localObject8), locald2.MLT, locald3.MLT, i, ((VideoTransPara)localObject4).audioBitrate, ((VideoTransPara)localObject4).audioSampleRate, ((VideoTransPara)localObject4).audioChannelCount, ((VideoTransPara)localObject4).fps, parambvf.skC.ddx, parambvf.skC.htQ, ((VideoTransPara)localObject4).hmx, (d.g.a.b)new a((y.c)localObject6), (d.g.a.b)new b(this, locald1, l, locald2, locald3, (VideoTransPara)localObject4, localObject3, (y.a)localObject5), k, m);
        ((l)localObject6).atP();
      }
      catch (Throwable localThrowable1)
      {
        paramd.ret = -10;
        ad.printErrStackTrace(this.TAG, localThrowable1, "create remuxer failed", new Object[0]);
        localObject2 = n.b.sqe;
        n.b.cDH();
        localObject2 = n.d.sqC;
        n.d.wF(bt.aO(l));
        localObject2 = n.d.sqC;
        n.d.a(parama, null, (int)i.aYo(parambvf.url), 0, bt.aO(l), paramd.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      try
      {
        if (!((y.a)localObject5).MLQ)
        {
          ad.i(this.TAG, "wait");
          localObject3.wait();
          ad.i(this.TAG, "notify, " + locald1.MLT);
        }
        localObject5 = z.MKo;
        if (locald1.MLT >= 0) {
          break label980;
        }
        paramd.ret = locald1.MLT;
        localObject1 = n.d.sqC;
        n.d.wF(bt.aO(l));
        localObject1 = n.d.sqC;
        n.d.a(parama, null, (int)i.aYo(parambvf.url), 0, bt.aO(l), paramd.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      finally
      {
        AppMethodBeat.o(168050);
      }
    }
    Object localObject2;
    label980:
    if ((((c.a.a)localObject7).errCode == 0) && (((c.a.a)localObject7).sIH != null) && (((c.a.a)localObject7).width > 0) && (((c.a.a)localObject7).height > 0) && (((c.a.a)localObject7).bitrate > 0)) {}
    try
    {
      SightVideoJNI.addReportMetadata((String)localObject2, ((c.a.a)localObject7).sIH, ((VideoTransPara)localObject4).hVq, 0);
      label1036:
      paramd.akT((String)localObject2);
      localObject3 = f.sJc;
      paramd.yo(f.a((String)localObject2, paramInt1, paramInt2, null));
      localObject3 = n.d.sqC;
      n.d.wF(bt.aO(l));
      localObject3 = e.axx((String)localObject2);
      localObject4 = n.d.sqC;
      n.d.a(parama, (com.tencent.mm.plugin.sight.base.a)localObject3, (int)i.aYo(parambvf.url), (int)i.aYo((String)localObject2), bt.aO(l), paramd.ret);
      AppMethodBeat.o(168050);
      return true;
    }
    catch (Throwable localThrowable2)
    {
      break label1036;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Float, z>
  {
    a(y.c paramc)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<String, z>
  {
    b(j paramj, y.d paramd1, long paramLong, y.d paramd2, y.d paramd3, VideoTransPara paramVideoTransPara, Object paramObject, y.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.j
 * JD-Core Version:    0.7.0.1
 */