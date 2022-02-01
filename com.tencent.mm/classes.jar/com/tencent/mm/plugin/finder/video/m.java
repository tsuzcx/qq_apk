package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.report.v.c;
import com.tencent.mm.plugin.finder.report.v.e;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.upload.c;
import com.tencent.mm.plugin.finder.upload.c.a;
import com.tencent.mm.plugin.finder.upload.c.a.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.gallery.picker.b.a;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.c;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCropTailor;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "TAG", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "onInput", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "remux", "", "it", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "result", "Lcom/tencent/mm/plugin/finder/video/FinderMediaTailorResult;", "thumbWidth", "thumbHeight", "mediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "resize", "Lkotlin/Pair;", "originWidth", "originHeight", "maxWidth", "plugin-finder_release"})
public final class m
  implements a<String, b.f>
{
  private final b.b ANu;
  final String TAG;
  
  public m(b.b paramb)
  {
    AppMethodBeat.i(168052);
    this.ANu = paramb;
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
  
  private final boolean a(csg paramcsg, e parame, int paramInt1, int paramInt2, com.tencent.mm.plugin.sight.base.b paramb)
  {
    AppMethodBeat.i(168050);
    Object localObject1 = d.AjH;
    final VideoTransPara localVideoTransPara = d.dRJ();
    final Object localObject4 = new Object();
    final aa.a locala = new aa.a();
    locala.aaBx = false;
    final aa.d locald1 = new aa.d();
    locald1.aaBA = -1;
    int i;
    Object localObject3;
    String str;
    aa.c localc;
    int n;
    aa.d locald2;
    label196:
    final aa.d locald3;
    label230:
    int k;
    int m;
    label284:
    label309:
    int j;
    int i1;
    c.a.a locala1;
    final long l1;
    if (com.tencent.mm.modelcontrol.e.vW(4))
    {
      i = 2;
      localObject1 = new aa(paramcsg, com.tencent.mm.plugin.finder.storage.u.AlL, i, null, 8);
      localObject3 = av.AJz;
      localObject3 = String.valueOf(cm.bfC());
      p.k(localObject1, "video");
      p.k(localObject3, "suffix");
      str = av.egt() + ((aa)localObject1).aBv() + "_" + (String)localObject3;
      localc = new aa.c();
      localc.aaBz = 0.0F;
      n = SightVideoJNI.getMp4RotateVFS(paramcsg.url);
      locald2 = new aa.d();
      localObject1 = paramcsg.zBo;
      if (localObject1 == null) {
        break label1055;
      }
      i = ((css)localObject1).width;
      locald2.aaBA = i;
      locald3 = new aa.d();
      localObject1 = paramcsg.zBo;
      if (localObject1 == null) {
        break label1061;
      }
      i = ((css)localObject1).height;
      locald3.aaBA = i;
      k = paramb.width;
      m = paramb.height;
      if ((n == 90) || (n == 270))
      {
        localObject1 = paramcsg.zBo;
        if (localObject1 == null) {
          break label1067;
        }
        i = ((css)localObject1).height;
        locald2.aaBA = i;
        localObject1 = paramcsg.zBo;
        if (localObject1 == null) {
          break label1073;
        }
        i = ((css)localObject1).width;
        locald3.aaBA = i;
      }
      j = localVideoTransPara.videoBitrate;
      localObject1 = v.c.zYk;
      v.c.qd(false);
      Log.i(this.TAG, "video rotate:" + n + ", width:" + locald2.aaBA + ", height:" + locald3.aaBA + " url " + paramcsg.url + " thumbUrl: " + paramcsg.thumbUrl + " size:" + Util.getSizeKB(com.tencent.mm.vfs.u.bBQ(paramcsg.url)));
      localObject1 = c.Azt;
      localObject3 = paramcsg.url;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      i = locald2.aaBA;
      n = locald3.aaBA;
      localObject3 = paramcsg.zBo;
      if (localObject3 == null) {
        p.iCn();
      }
      i1 = ((css)localObject3).endTime;
      localObject3 = paramcsg.zBo;
      if (localObject3 == null) {
        p.iCn();
      }
      float f = (i1 - ((css)localObject3).fod) / 1000.0F;
      localObject3 = paramcsg.zBo;
      if (localObject3 == null) {
        p.iCn();
      }
      locala1 = c.a.a((String)localObject1, i, n, f, ((css)localObject3).fod / 1000.0F, localVideoTransPara, false);
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
              locald2.aaBA = locala1.width;
              locald3.aaBA = locala1.height;
              i = locala1.bitrate;
              Log.i(this.TAG, "video abaResult, width:" + locald2.aaBA + ", height:" + locald3.aaBA + ", " + i);
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
        localObject3 = paramcsg.url;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = c.Azt;
        localObject3 = paramcsg.zBo;
        if (localObject3 != null)
        {
          localObject3 = ((css)localObject3).TAv;
          if (localObject3 == null) {
            p.iCn();
          }
          p.j(localObject3, "it.cropInfo?.rect!!");
          localObject3 = c.a.a((fbq)localObject3);
          j = locald2.aaBA;
          n = locald3.aaBA;
          i1 = localVideoTransPara.audioBitrate;
          int i2 = localVideoTransPara.audioSampleRate;
          int i3 = localVideoTransPara.audioChannelCount;
          int i4 = localVideoTransPara.fps;
          css localcss = paramcsg.zBo;
          if (localcss == null) {
            p.iCn();
          }
          long l2 = localcss.fod;
          localcss = paramcsg.zBo;
          if (localcss == null) {
            p.iCn();
          }
          localObject1 = new o(null, (String)localObject1, 1, str, (Rect)localObject3, j, n, i, i1, i2, i3, i4, l2, localcss.endTime, localVideoTransPara.kXt, (kotlin.g.a.b)new a(localc), (kotlin.g.a.b)new b(this, locald1, l1, locald2, locald3, localVideoTransPara, localObject4, locala), k, m);
          ((o)localObject1).aUW();
        }
      }
      catch (Throwable localThrowable1)
      {
        label1055:
        label1061:
        label1067:
        label1073:
        parame.ret = -10;
        Log.printErrStackTrace(this.TAG, localThrowable1, "create remuxer failed", new Object[0]);
        localObject2 = v.c.zYk;
        v.c.qe(false);
        localObject2 = v.e.zYK;
        v.e.Mw(Util.ticksToNow(l1));
        localObject2 = v.e.zYK;
        v.e.a(paramb, null, (int)com.tencent.mm.vfs.u.bBQ(paramcsg.url), 0, Util.ticksToNow(l1), parame.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      try
      {
        if (!locala.aaBx)
        {
          Log.i(this.TAG, "wait");
          localObject4.wait();
          Log.i(this.TAG, "notify, " + locald1.aaBA);
        }
        localObject1 = x.aazN;
        if (locald1.aaBA >= 0) {
          break label1178;
        }
        parame.ret = locald1.aaBA;
        localObject1 = v.e.zYK;
        v.e.Mw(Util.ticksToNow(l1));
        localObject1 = v.e.zYK;
        v.e.a(paramb, null, (int)com.tencent.mm.vfs.u.bBQ(paramcsg.url), 0, Util.ticksToNow(l1), parame.ret);
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
    label1178:
    if ((locala1.errCode == 0) && (locala1.Azu != null) && (locala1.width > 0) && (locala1.height > 0) && (locala1.bitrate > 0)) {}
    try
    {
      SightVideoJNI.addReportMetadata(str, locala1.Azu, localVideoTransPara.lJz, 0);
      label1234:
      parame.aIv(str);
      localObject2 = com.tencent.mm.plugin.finder.upload.f.AzZ;
      parame.ON(com.tencent.mm.plugin.finder.upload.f.a(str, paramInt1, paramInt2, null));
      localObject2 = v.e.zYK;
      v.e.Mw(Util.ticksToNow(l1));
      localObject2 = com.tencent.mm.plugin.sight.base.f.aYg(str);
      localObject3 = v.e.zYK;
      v.e.a(paramb, (com.tencent.mm.plugin.sight.base.b)localObject2, (int)com.tencent.mm.vfs.u.bBQ(paramcsg.url), (int)com.tencent.mm.vfs.u.bBQ(str), Util.ticksToNow(l1), parame.ret);
      AppMethodBeat.o(168050);
      return true;
    }
    catch (Throwable localThrowable2)
    {
      break label1234;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Float, x>
  {
    a(aa.c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, x>
  {
    b(m paramm, aa.d paramd1, long paramLong, aa.d paramd2, aa.d paramd3, VideoTransPara paramVideoTransPara, Object paramObject, aa.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.m
 * JD-Core Version:    0.7.0.1
 */