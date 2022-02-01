package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.report.o.b;
import com.tencent.mm.plugin.finder.report.o.d;
import com.tencent.mm.plugin.finder.upload.c;
import com.tencent.mm.plugin.finder.upload.c.a;
import com.tencent.mm.plugin.finder.upload.c.a.a;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.a;
import d.g.b.y.c;
import d.g.b.y.d;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCropTailor;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "TAG", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "onInput", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "remux", "", "it", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "result", "Lcom/tencent/mm/plugin/finder/video/FinderMediaTailorResult;", "thumbWidth", "thumbHeight", "mediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "resize", "Lkotlin/Pair;", "originWidth", "originHeight", "maxWidth", "plugin-finder_release"})
public final class j
  implements com.tencent.mm.plugin.gallery.picker.b.a<String, b.f>
{
  final String TAG;
  private final b.b sZV;
  
  public j(b.b paramb)
  {
    AppMethodBeat.i(168052);
    this.sZV = paramb;
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
  
  private final boolean a(bvz parambvz, d paramd, int paramInt1, int paramInt2, com.tencent.mm.plugin.sight.base.a parama)
  {
    AppMethodBeat.i(168050);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    final VideoTransPara localVideoTransPara = com.tencent.mm.plugin.finder.storage.b.cGU();
    final Object localObject4 = new Object();
    final y.a locala = new y.a();
    locala.NiT = false;
    final y.d locald1 = new y.d();
    locald1.NiW = -1;
    int i;
    Object localObject3;
    String str;
    y.c localc;
    int n;
    y.d locald2;
    label196:
    final y.d locald3;
    label230:
    int k;
    int m;
    label284:
    label309:
    int j;
    int i1;
    c.a.a locala1;
    final long l1;
    if (com.tencent.mm.modelcontrol.d.pi(4))
    {
      i = 2;
      localObject1 = new m(parambvz, com.tencent.mm.plugin.finder.storage.r.sJH, i, null, 8);
      localObject3 = com.tencent.mm.plugin.finder.utils.r.sYn;
      localObject3 = String.valueOf(ch.aDa());
      p.h(localObject1, "video");
      p.h(localObject3, "suffix");
      str = com.tencent.mm.plugin.finder.utils.r.cOx() + ((m)localObject1).aeM() + "_" + (String)localObject3;
      localc = new y.c();
      localc.NiV = 0.0F;
      n = SightVideoJNI.getMp4RotateVFS(parambvz.url);
      locald2 = new y.d();
      localObject1 = parambvz.stz;
      if (localObject1 == null) {
        break label1065;
      }
      i = ((bwj)localObject1).width;
      locald2.NiW = i;
      locald3 = new y.d();
      localObject1 = parambvz.stz;
      if (localObject1 == null) {
        break label1071;
      }
      i = ((bwj)localObject1).height;
      locald3.NiW = i;
      k = parama.width;
      m = parama.height;
      if ((n == 90) || (n == 270))
      {
        localObject1 = parambvz.stz;
        if (localObject1 == null) {
          break label1077;
        }
        i = ((bwj)localObject1).height;
        locald2.NiW = i;
        localObject1 = parambvz.stz;
        if (localObject1 == null) {
          break label1083;
        }
        i = ((bwj)localObject1).width;
        locald3.NiW = i;
      }
      j = localVideoTransPara.videoBitrate;
      localObject1 = o.b.sAp;
      o.b.cFC();
      ae.i(this.TAG, "video rotate:" + n + ", width:" + locald2.NiW + ", height:" + locald3.NiW + " url " + parambvz.url + " thumbUrl: " + parambvz.thumbUrl + " size:" + bu.sL(o.aZR(parambvz.url)));
      localObject1 = c.sTS;
      localObject3 = parambvz.url;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      i = locald2.NiW;
      n = locald3.NiW;
      localObject3 = parambvz.stz;
      if (localObject3 == null) {
        p.gkB();
      }
      i1 = ((bwj)localObject3).hwE;
      localObject3 = parambvz.stz;
      if (localObject3 == null) {
        p.gkB();
      }
      float f1 = (i1 - ((bwj)localObject3).dez) / 1000.0F;
      localObject3 = parambvz.stz;
      if (localObject3 == null) {
        p.gkB();
      }
      float f2 = ((bwj)localObject3).dez / 1000.0F;
      p.g(localVideoTransPara, "videoParams");
      locala1 = c.a.a((String)localObject1, i, n, f1, f2, localVideoTransPara);
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
              locald2.NiW = locala1.width;
              locald3.NiW = locala1.height;
              i = locala1.bitrate;
              ae.i(this.TAG, "video abaResult, width:" + locald2.NiW + ", height:" + locald3.NiW + ", " + i);
            }
          }
        }
      }
      l1 = bu.HQ();
    }
    for (;;)
    {
      try
      {
        localObject3 = parambvz.url;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = c.sTS;
        localObject3 = parambvz.stz;
        if (localObject3 != null)
        {
          localObject3 = ((bwj)localObject3).Hjn;
          if (localObject3 == null) {
            p.gkB();
          }
          p.g(localObject3, "it.cropInfo?.rect!!");
          localObject3 = c.a.a((dwz)localObject3);
          j = locald2.NiW;
          n = locald3.NiW;
          i1 = localVideoTransPara.audioBitrate;
          int i2 = localVideoTransPara.audioSampleRate;
          int i3 = localVideoTransPara.audioChannelCount;
          int i4 = localVideoTransPara.fps;
          bwj localbwj = parambvz.stz;
          if (localbwj == null) {
            p.gkB();
          }
          long l2 = localbwj.dez;
          localbwj = parambvz.stz;
          if (localbwj == null) {
            p.gkB();
          }
          localObject1 = new l(null, (String)localObject1, 1, str, (Rect)localObject3, j, n, i, i1, i2, i3, i4, l2, localbwj.hwE, localVideoTransPara.hpl, (d.g.a.b)new a(localc), (d.g.a.b)new b(this, locald1, l1, locald2, locald3, localVideoTransPara, localObject4, locala), k, m);
          ((l)localObject1).aue();
        }
      }
      catch (Throwable localThrowable1)
      {
        label1065:
        label1071:
        label1077:
        label1083:
        paramd.ret = -10;
        ae.printErrStackTrace(this.TAG, localThrowable1, "create remuxer failed", new Object[0]);
        localObject2 = o.b.sAp;
        o.b.cFD();
        localObject2 = o.d.sAM;
        o.d.wW(bu.aO(l1));
        localObject2 = o.d.sAM;
        o.d.a(parama, null, (int)o.aZR(parambvz.url), 0, bu.aO(l1), paramd.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      try
      {
        if (!locala.NiT)
        {
          ae.i(this.TAG, "wait");
          localObject4.wait();
          ae.i(this.TAG, "notify, " + locald1.NiW);
        }
        localObject1 = z.Nhr;
        if (locald1.NiW >= 0) {
          break label1187;
        }
        paramd.ret = locald1.NiW;
        localObject1 = o.d.sAM;
        o.d.wW(bu.aO(l1));
        localObject1 = o.d.sAM;
        o.d.a(parama, null, (int)o.aZR(parambvz.url), 0, bu.aO(l1), paramd.ret);
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
    label1187:
    if ((locala1.errCode == 0) && (locala1.sTT != null) && (locala1.width > 0) && (locala1.height > 0) && (locala1.bitrate > 0)) {}
    try
    {
      SightVideoJNI.addReportMetadata(str, locala1.sTT, localVideoTransPara.hYi, 0);
      label1243:
      paramd.alR(str);
      localObject2 = f.sUp;
      paramd.yY(f.a(str, paramInt1, paramInt2, null));
      localObject2 = o.d.sAM;
      o.d.wW(bu.aO(l1));
      localObject2 = e.ayN(str);
      localObject3 = o.d.sAM;
      o.d.a(parama, (com.tencent.mm.plugin.sight.base.a)localObject2, (int)o.aZR(parambvz.url), (int)o.aZR(str), bu.aO(l1), paramd.ret);
      AppMethodBeat.o(168050);
      return true;
    }
    catch (Throwable localThrowable2)
    {
      break label1243;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Float, z>
  {
    a(y.c paramc)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.j
 * JD-Core Version:    0.7.0.1
 */