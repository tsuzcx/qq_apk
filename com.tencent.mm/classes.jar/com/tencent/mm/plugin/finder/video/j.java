package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.report.i.b;
import com.tencent.mm.plugin.finder.report.i.d;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.upload.c;
import com.tencent.mm.plugin.finder.upload.c.a;
import com.tencent.mm.plugin.finder.upload.c.a.a;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.g.b.v.a;
import d.g.b.v.c;
import d.g.b.v.d;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCropTailor;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "TAG", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "onInput", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "remux", "", "it", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "result", "Lcom/tencent/mm/plugin/finder/video/FinderMediaTailorResult;", "thumbWidth", "thumbHeight", "mediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "resize", "Lkotlin/Pair;", "originWidth", "originHeight", "maxWidth", "plugin-finder_release"})
public final class j
  implements com.tencent.mm.plugin.gallery.picker.b.a<String, b.f>
{
  final String TAG;
  private final b.b rSg;
  
  public j(b.b paramb)
  {
    AppMethodBeat.i(168052);
    this.rSg = paramb;
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
  
  private final boolean a(bqs parambqs, d paramd, int paramInt1, int paramInt2, com.tencent.mm.plugin.sight.base.a parama)
  {
    AppMethodBeat.i(168050);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    Object localObject4 = com.tencent.mm.plugin.finder.storage.b.cxZ();
    final Object localObject3 = new Object();
    Object localObject5 = new v.a();
    ((v.a)localObject5).KUL = false;
    final v.d locald1 = new v.d();
    locald1.KUO = -1;
    if (com.tencent.mm.modelcontrol.d.oE(4)) {}
    Object localObject7;
    final long l;
    for (int i = 2;; i = 1)
    {
      localObject1 = new com.tencent.mm.plugin.finder.loader.l(parambqs, m.rEd, i, null, 8);
      Object localObject6 = p.rQw;
      localObject6 = String.valueOf(ce.azH());
      k.h(localObject1, "video");
      k.h(localObject6, "suffix");
      localObject1 = p.cDv() + ((com.tencent.mm.plugin.finder.loader.l)localObject1).abW() + "_" + (String)localObject6;
      localObject6 = new v.c();
      ((v.c)localObject6).KUN = 0.0F;
      i = SightVideoJNI.getMp4RotateVFS(parambqs.url);
      v.d locald2 = new v.d();
      locald2.KUO = parambqs.rvh.width;
      final v.d locald3 = new v.d();
      locald3.KUO = parambqs.rvh.height;
      int k = parama.width;
      int m = parama.height;
      if ((i == 90) || (i == 270))
      {
        locald2.KUO = parambqs.rvh.height;
        locald3.KUO = parambqs.rvh.width;
      }
      int j = ((VideoTransPara)localObject4).videoBitrate;
      localObject7 = i.b.ryD;
      i.b.cwY();
      ac.i(this.TAG, "video rotate:" + i + ", width:" + locald2.KUO + ", height:" + locald3.KUO + " url " + parambqs.url + " thumbUrl: " + parambqs.thumbUrl + " size:" + bs.qz(i.aSp(parambqs.url)));
      localObject7 = c.rME;
      localObject7 = parambqs.url;
      k.g(localObject7, "it.url");
      i = locald2.KUO;
      int n = locald3.KUO;
      float f1 = (parambqs.rvh.hbI - parambqs.rvh.cSh) / 1000.0F;
      float f2 = parambqs.rvh.cSh / 1000.0F;
      k.g(localObject4, "videoParams");
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
              locald2.KUO = ((c.a.a)localObject7).width;
              locald3.KUO = ((c.a.a)localObject7).height;
              i = ((c.a.a)localObject7).bitrate;
              ac.i(this.TAG, "video abaResult, width:" + locald2.KUO + ", height:" + locald3.KUO + ", " + i);
            }
          }
        }
      }
      l = bs.Gn();
      try
      {
        String str = parambqs.url;
        k.g(str, "it.url");
        Object localObject8 = c.rME;
        localObject8 = parambqs.rvh.Fgj;
        k.g(localObject8, "it.cropInfo.rect");
        localObject6 = new l(null, str, 1, (String)localObject1, c.a.a((dqk)localObject8), locald2.KUO, locald3.KUO, i, ((VideoTransPara)localObject4).audioBitrate, ((VideoTransPara)localObject4).audioSampleRate, ((VideoTransPara)localObject4).gOt, ((VideoTransPara)localObject4).fps, parambqs.rvh.cSh, parambqs.rvh.hbI, (d.g.a.b)new a((v.c)localObject6), (d.g.a.b)new b(this, locald1, l, locald2, locald3, (VideoTransPara)localObject4, localObject3, (v.a)localObject5), k, m);
        ((l)localObject6).arc();
      }
      catch (Throwable localThrowable1)
      {
        paramd.ret = -10;
        ac.printErrStackTrace(this.TAG, localThrowable1, "create remuxer failed", new Object[0]);
        localObject2 = i.b.ryD;
        i.b.cwZ();
        localObject2 = i.d.ryT;
        i.d.uE(bs.aO(l));
        localObject2 = i.d.ryT;
        i.d.a(parama, null, (int)i.aSp(parambqs.url), 0, bs.aO(l), paramd.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      try
      {
        if (!((v.a)localObject5).KUL)
        {
          ac.i(this.TAG, "wait");
          localObject3.wait();
          ac.i(this.TAG, "notify, " + locald1.KUO);
        }
        localObject5 = y.KTp;
        if (locald1.KUO >= 0) {
          break label975;
        }
        paramd.ret = locald1.KUO;
        localObject1 = i.d.ryT;
        i.d.uE(bs.aO(l));
        localObject1 = i.d.ryT;
        i.d.a(parama, null, (int)i.aSp(parambqs.url), 0, bs.aO(l), paramd.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      finally
      {
        AppMethodBeat.o(168050);
      }
    }
    Object localObject2;
    label975:
    if ((((c.a.a)localObject7).errCode == 0) && (((c.a.a)localObject7).rMF != null) && (((c.a.a)localObject7).width > 0) && (((c.a.a)localObject7).height > 0) && (((c.a.a)localObject7).bitrate > 0)) {}
    try
    {
      SightVideoJNI.addReportMetadata((String)localObject2, ((c.a.a)localObject7).rMF, ((VideoTransPara)localObject4).hCL, 0);
      label1031:
      paramd.agw((String)localObject2);
      localObject3 = com.tencent.mm.plugin.finder.upload.e.rMX;
      paramd.vx(com.tencent.mm.plugin.finder.upload.e.a((String)localObject2, paramInt1, paramInt2, null));
      localObject3 = i.d.ryT;
      i.d.uE(bs.aO(l));
      localObject3 = com.tencent.mm.plugin.sight.base.e.asx((String)localObject2);
      localObject4 = i.d.ryT;
      i.d.a(parama, (com.tencent.mm.plugin.sight.base.a)localObject3, (int)i.aSp(parambqs.url), (int)i.aSp((String)localObject2), bs.aO(l), paramd.ret);
      AppMethodBeat.o(168050);
      return true;
    }
    catch (Throwable localThrowable2)
    {
      break label1031;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Float, y>
  {
    a(v.c paramc)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    b(j paramj, v.d paramd1, long paramLong, v.d paramd2, v.d paramd3, VideoTransPara paramVideoTransPara, Object paramObject, v.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.j
 * JD-Core Version:    0.7.0.1
 */