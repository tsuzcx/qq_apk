package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.report.ah.e;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.upload.c;
import com.tencent.mm.plugin.finder.upload.c.a;
import com.tencent.mm.plugin.finder.upload.c.a.a;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.gallery.picker.b.a;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.fyb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCropTailor;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "TAG", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "onInput", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "remux", "", "it", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "result", "Lcom/tencent/mm/plugin/finder/video/FinderMediaTailorResult;", "thumbWidth", "thumbHeight", "mediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "resize", "Lkotlin/Pair;", "originWidth", "originHeight", "maxWidth", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements a<String, b.f>
{
  private final b.b GpU;
  final String TAG;
  
  public m(b.b paramb)
  {
    AppMethodBeat.i(168052);
    this.GpU = paramb;
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
  
  private final boolean a(dji paramdji, e parame, int paramInt1, int paramInt2, com.tencent.mm.plugin.sight.base.b paramb)
  {
    AppMethodBeat.i(168050);
    Object localObject1 = d.FAy;
    final VideoTransPara localVideoTransPara = d.ePV();
    final Object localObject5 = new Object();
    final ah.a locala = new ah.a();
    ah.d locald1 = new ah.d();
    locald1.aixb = -1;
    int i;
    Object localObject4;
    String str;
    kotlin.g.b.ah.c localc;
    int n;
    final ah.d locald2;
    label180:
    final ah.d locald3;
    label210:
    int k;
    int m;
    label260:
    int j;
    int i1;
    c.a.a locala1;
    final long l1;
    if (com.tencent.mm.modelcontrol.e.wb(4))
    {
      i = 2;
      localObject1 = new com.tencent.mm.plugin.finder.loader.v(paramdji, com.tencent.mm.plugin.finder.storage.v.FLB, i, null, 8);
      localObject4 = bm.GlZ;
      localObject4 = String.valueOf(cn.bDu());
      s.u(localObject1, "video");
      s.u(localObject4, "suffix");
      str = bm.fit() + ((com.tencent.mm.plugin.finder.loader.v)localObject1).aUt() + '_' + (String)localObject4;
      localc = new kotlin.g.b.ah.c();
      n = SightVideoJNI.getMp4RotateVFS(paramdji.url);
      locald2 = new ah.d();
      localObject1 = paramdji.EDC;
      if (localObject1 != null) {
        break label969;
      }
      i = 0;
      locald2.aixb = i;
      locald3 = new ah.d();
      localObject1 = paramdji.EDC;
      if (localObject1 != null) {
        break label979;
      }
      i = 0;
      locald3.aixb = i;
      k = paramb.width;
      m = paramb.height;
      switch (n)
      {
      default: 
        j = localVideoTransPara.videoBitrate;
        localObject1 = com.tencent.mm.plugin.finder.report.ah.c.Ftv;
        com.tencent.mm.plugin.finder.report.ah.c.tP(false);
        Log.i(this.TAG, "video rotate:" + n + ", width:" + locald2.aixb + ", height:" + locald3.aixb + " url " + paramdji.url + " thumbUrl: " + paramdji.thumbUrl + " size:" + Util.getSizeKB(y.bEl(paramdji.url)));
        localObject1 = c.Gbx;
        localObject4 = paramdji.url;
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = "";
        }
        i = locald2.aixb;
        n = locald3.aixb;
        localObject4 = paramdji.EDC;
        s.checkNotNull(localObject4);
        i1 = ((dju)localObject4).endTime;
        localObject4 = paramdji.EDC;
        s.checkNotNull(localObject4);
        float f = (i1 - ((dju)localObject4).startTime) / 1000.0F;
        localObject4 = paramdji.EDC;
        s.checkNotNull(localObject4);
        locala1 = c.a.a((String)localObject1, i, n, f, ((dju)localObject4).startTime / 1000.0F, localVideoTransPara, false);
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
                locald2.aixb = locala1.width;
                locald3.aixb = locala1.height;
                i = locala1.bitrate;
                Log.i(this.TAG, "video abaResult, width:" + locald2.aixb + ", height:" + locald3.aixb + ", " + i);
              }
            }
          }
        }
        l1 = Util.currentTicks();
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = paramdji.url;
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = "";
        }
        localObject4 = c.Gbx;
        localObject4 = paramdji.EDC;
        if (localObject4 == null)
        {
          localObject4 = null;
          s.checkNotNull(localObject4);
          s.s(localObject4, "it.cropInfo?.rect!!");
          localObject4 = c.a.a((fyb)localObject4);
          j = locald2.aixb;
          n = locald3.aixb;
          i1 = localVideoTransPara.audioBitrate;
          int i2 = localVideoTransPara.audioSampleRate;
          int i3 = localVideoTransPara.audioChannelCount;
          int i4 = localVideoTransPara.fps;
          dju localdju = paramdji.EDC;
          s.checkNotNull(localdju);
          long l2 = localdju.startTime;
          localdju = paramdji.EDC;
          s.checkNotNull(localdju);
          localObject1 = new o(null, (String)localObject1, 1, str, (Rect)localObject4, j, n, i, i1, i2, i3, i4, l2, localdju.endTime, localVideoTransPara.nCd, (kotlin.g.a.b)new m.a(localc), (kotlin.g.a.b)new b(locald1, l1, this, locald2, locald3, localVideoTransPara, localObject5, locala), k, m);
          ((o)localObject1).bpE();
        }
      }
      finally
      {
        label969:
        label979:
        parame.ret = -10;
        Log.printErrStackTrace(this.TAG, localThrowable, "create remuxer failed", new Object[0]);
        localObject2 = com.tencent.mm.plugin.finder.report.ah.c.Ftv;
        com.tencent.mm.plugin.finder.report.ah.c.ty(false);
        localObject2 = ah.e.Ftx;
        ah.e.pP(Util.ticksToNow(l1));
        localObject2 = ah.e.Ftx;
        ah.e.a(paramb, null, (int)y.bEl(paramdji.url), 0, Util.ticksToNow(l1), parame.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      try
      {
        if (!locala.aiwY)
        {
          Log.i(this.TAG, "wait");
          localObject5.wait();
          Log.i(this.TAG, s.X("notify, ", Integer.valueOf(locald1.aixb)));
        }
        localObject1 = ah.aiuX;
        if (locald1.aixb >= 0) {
          break label1157;
        }
        parame.ret = locald1.aixb;
        localObject1 = ah.e.Ftx;
        ah.e.pP(Util.ticksToNow(l1));
        localObject1 = ah.e.Ftx;
        ah.e.a(paramb, null, (int)y.bEl(paramdji.url), 0, Util.ticksToNow(l1), parame.ret);
        AppMethodBeat.o(168050);
        return false;
      }
      finally
      {
        AppMethodBeat.o(168050);
      }
      i = 1;
      break;
      i = ((dju)localObject1).width;
      break label180;
      i = ((dju)localObject1).height;
      break label210;
      localObject1 = paramdji.EDC;
      if (localObject1 == null)
      {
        i = 0;
        locald2.aixb = i;
        localObject1 = paramdji.EDC;
        if (localObject1 != null) {
          continue;
        }
        i = 0;
        locald3.aixb = i;
        break label260;
      }
      i = ((dju)localObject1).height;
      continue;
      i = ((dju)localObject1).width;
      continue;
      localObject4 = ((dju)localObject4).aaPJ;
    }
    Object localObject2;
    label1157:
    if ((locala1.errCode == 0) && (locala1.Gbz != null) && (locala1.width > 0) && (locala1.height > 0) && (locala1.bitrate > 0)) {}
    try
    {
      SightVideoJNI.addReportMetadata(str, locala1.Gbz, localVideoTransPara.oCb, 0);
      label1213:
      parame.aET(str);
      localObject2 = com.tencent.mm.plugin.finder.upload.f.GbE;
      parame.Hd(com.tencent.mm.plugin.finder.upload.f.a(str, paramInt1, paramInt2, null));
      localObject2 = ah.e.Ftx;
      ah.e.pP(Util.ticksToNow(l1));
      localObject2 = com.tencent.mm.plugin.sight.base.f.aVX(str);
      localObject4 = ah.e.Ftx;
      ah.e.a(paramb, (com.tencent.mm.plugin.sight.base.b)localObject2, (int)y.bEl(paramdji.url), (int)y.bEl(str), Util.ticksToNow(l1), parame.ret);
      AppMethodBeat.o(168050);
      return true;
    }
    finally
    {
      break label1213;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(ah.d paramd1, long paramLong, m paramm, ah.d paramd2, ah.d paramd3, VideoTransPara paramVideoTransPara, Object paramObject, ah.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.m
 * JD-Core Version:    0.7.0.1
 */