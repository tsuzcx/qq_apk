package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.report.e.b;
import com.tencent.mm.plugin.finder.report.e.d;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.plugin.finder.upload.c;
import com.tencent.mm.plugin.finder.upload.c.a;
import com.tencent.mm.plugin.finder.upload.c.a.a;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.v.a;
import d.g.b.v.b;
import d.g.b.v.c;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCropTailor;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "TAG", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "onInput", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "remux", "", "it", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "result", "Lcom/tencent/mm/plugin/finder/video/FinderMediaTailorResult;", "thumbWidth", "thumbHeight", "mediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "resize", "Lkotlin/Pair;", "originWidth", "originHeight", "maxWidth", "plugin-finder_release"})
public final class d
  implements com.tencent.mm.plugin.gallery.picker.b.a<String, b.f>
{
  final String TAG;
  private final b.b qTP;
  
  public d(b.b paramb)
  {
    AppMethodBeat.i(168052);
    this.qTP = paramb;
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
  
  private final boolean a(bmd parambmd, b paramb, int paramInt1, int paramInt2, com.tencent.mm.plugin.sight.base.a parama)
  {
    AppMethodBeat.i(168050);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    Object localObject4 = com.tencent.mm.plugin.finder.storage.b.coC();
    final Object localObject3 = new Object();
    Object localObject5 = new v.a();
    ((v.a)localObject5).Jhs = false;
    final v.c localc1 = new v.c();
    localc1.Jhu = -1;
    if (com.tencent.mm.modelcontrol.d.nQ(4)) {}
    Object localObject7;
    final long l;
    for (int i = 2;; i = 1)
    {
      localObject1 = new com.tencent.mm.plugin.finder.loader.l(parambmd, h.KXa, i, null, 8);
      Object localObject6 = com.tencent.mm.plugin.finder.utils.k.qTp;
      localObject6 = String.valueOf(ce.asQ());
      d.g.b.k.h(localObject1, "video");
      d.g.b.k.h(localObject6, "suffix");
      localObject1 = com.tencent.mm.plugin.finder.utils.k.csc() + ((com.tencent.mm.plugin.finder.loader.l)localObject1).aaX() + "_" + (String)localObject6;
      localObject6 = new v.b();
      ((v.b)localObject6).Jht = 0.0F;
      i = SightVideoJNI.getMp4RotateVFS(parambmd.url);
      v.c localc2 = new v.c();
      localc2.Jhu = parambmd.qDR.width;
      final v.c localc3 = new v.c();
      localc3.Jhu = parambmd.qDR.height;
      int k = parama.width;
      int m = parama.height;
      if ((i == 90) || (i == 270))
      {
        localc2.Jhu = parambmd.qDR.height;
        localc3.Jhu = parambmd.qDR.width;
      }
      int j = ((VideoTransPara)localObject4).videoBitrate;
      localObject7 = e.b.qFJ;
      e.b.cnD();
      ad.i(this.TAG, "video rotate:" + i + ", width:" + localc2.Jhu + ", height:" + localc3.Jhu + " url " + parambmd.url + " thumbUrl: " + parambmd.thumbUrl + " size:" + bt.mK(i.aMN(parambmd.url)));
      localObject7 = c.qQG;
      localObject7 = parambmd.url;
      d.g.b.k.g(localObject7, "it.url");
      i = localc2.Jhu;
      int n = localc3.Jhu;
      float f1 = (parambmd.qDR.gBm - parambmd.qDR.cUL) / 1000.0F;
      float f2 = parambmd.qDR.cUL / 1000.0F;
      d.g.b.k.g(localObject4, "videoParams");
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
              localc2.Jhu = ((c.a.a)localObject7).width;
              localc3.Jhu = ((c.a.a)localObject7).height;
              i = ((c.a.a)localObject7).bitrate;
              ad.i(this.TAG, "video abaResult, width:" + localc2.Jhu + ", height:" + localc3.Jhu + ", " + i);
            }
          }
        }
      }
      l = bt.GC();
      try
      {
        String str = parambmd.url;
        d.g.b.k.g(str, "it.url");
        Object localObject8 = c.qQG;
        localObject8 = parambmd.qDR.DJU;
        d.g.b.k.g(localObject8, "it.cropInfo.rect");
        localObject6 = new g(str, (String)localObject1, c.a.a((dkt)localObject8), localc2.Jhu, localc3.Jhu, i, ((VideoTransPara)localObject4).audioBitrate, ((VideoTransPara)localObject4).audioSampleRate, ((VideoTransPara)localObject4).gnH, ((VideoTransPara)localObject4).fps, parambmd.qDR.cUL, parambmd.qDR.gBm, (d.g.a.b)new a((v.b)localObject6), (d.g.a.b)new b(this, localc1, l, localc2, localc3, (VideoTransPara)localObject4, localObject3, (v.a)localObject5), k, m);
        ((g)localObject6).akd();
      }
      catch (Throwable localThrowable1)
      {
        paramb.ret = -10;
        ad.printErrStackTrace(this.TAG, localThrowable1, "create remuxer failed", new Object[0]);
        localObject2 = e.b.qFJ;
        e.b.cnE();
        localObject2 = e.d.qFZ;
        e.d.qt(bt.aS(l));
        localObject2 = e.d.qFZ;
        e.d.a(parama, null, (int)i.aMN(parambmd.url), 0, bt.aS(l), paramb.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      try
      {
        if (!((v.a)localObject5).Jhs)
        {
          ad.i(this.TAG, "wait");
          localObject3.wait();
          ad.i(this.TAG, "notify, " + localc1.Jhu);
        }
        localObject5 = y.JfV;
        if (localc1.Jhu >= 0) {
          break label973;
        }
        paramb.ret = localc1.Jhu;
        localObject1 = e.d.qFZ;
        e.d.qt(bt.aS(l));
        localObject1 = e.d.qFZ;
        e.d.a(parama, null, (int)i.aMN(parambmd.url), 0, bt.aS(l), paramb.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      finally
      {
        AppMethodBeat.o(168050);
      }
    }
    Object localObject2;
    label973:
    if ((((c.a.a)localObject7).errCode == 0) && (((c.a.a)localObject7).qQH != null) && (((c.a.a)localObject7).width > 0) && (((c.a.a)localObject7).height > 0) && (((c.a.a)localObject7).bitrate > 0)) {}
    try
    {
      SightVideoJNI.addReportMetadata((String)localObject2, ((c.a.a)localObject7).qQH, ((VideoTransPara)localObject4).hcj, 0);
      label1029:
      paramb.abE((String)localObject2);
      localObject3 = com.tencent.mm.plugin.finder.upload.e.qQW;
      paramb.ru(com.tencent.mm.plugin.finder.upload.e.a((String)localObject2, paramInt1, paramInt2, null));
      localObject3 = e.d.qFZ;
      e.d.qt(bt.aS(l));
      localObject3 = com.tencent.mm.plugin.sight.base.e.ano((String)localObject2);
      localObject4 = e.d.qFZ;
      e.d.a(parama, (com.tencent.mm.plugin.sight.base.a)localObject3, (int)i.aMN(parambmd.url), (int)i.aMN((String)localObject2), bt.aS(l), paramb.ret);
      AppMethodBeat.o(168050);
      return true;
    }
    catch (Throwable localThrowable2)
    {
      break label1029;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Float, y>
  {
    a(v.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    b(d paramd, v.c paramc1, long paramLong, v.c paramc2, v.c paramc3, VideoTransPara paramVideoTransPara, Object paramObject, v.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.d
 * JD-Core Version:    0.7.0.1
 */