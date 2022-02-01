package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderFollowLogic;", "", "()V", "follow", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "finderUser", "", "opType", "", "plugin-finder_release"})
public final class u
{
  public static final u skm;
  
  static
  {
    AppMethodBeat.i(166392);
    skm = new u();
    AppMethodBeat.o(166392);
  }
  
  public static ae a(aqy paramaqy, String paramString, int paramInt)
  {
    AppMethodBeat.i(202957);
    p.h(paramaqy, "contextObj");
    p.h(paramString, "finderUser");
    ad.i("Finder.FinderFollowLogic", "follow event commentScene:" + paramaqy.tcl + " user:" + paramString + " opType: " + paramInt + " form " + bt.flS());
    Object localObject1 = e.ygI;
    Object localObject2 = ae.rJh;
    long l;
    int i;
    if (paramInt == ae.cye())
    {
      l = 5L;
      ((e)localObject1).idkeyStat(1278L, l, 1L, false);
      localObject1 = h.soM;
      l = paramaqy.tcj;
      localObject1 = ae.rJh;
      if (paramInt != ae.cye()) {
        break label411;
      }
      i = 1;
      label129:
      p.h(paramaqy, "contextObj");
      p.h(paramString, "finderUsername");
      localObject1 = new ak();
      ((ak)localObject1).hs(paramaqy.sessionId);
      ((ak)localObject1).ht("");
      ((ak)localObject1).cV(paramaqy.tcl);
      ((ak)localObject1).hv(paramString);
      ((ak)localObject1).cN(3L);
      ((ak)localObject1).cO(i);
      ((ak)localObject1).hw("");
      ((ak)localObject1).cQ(2L);
      ((ak)localObject1).hz(paramaqy.qXu);
      ((ak)localObject1).hA(paramaqy.qXj);
      localObject2 = h.ws(l);
      if (localObject2 == null) {
        break label416;
      }
      ((ak)localObject1).hu(h.wu(l));
      ((ak)localObject1).cR(((FinderItem)localObject2).getFeedObject().likeCount);
      ((ak)localObject1).cS(((FinderItem)localObject2).getFeedObject().commentCount);
      ((ak)localObject1).cT(((FinderItem)localObject2).getFeedObject().friendLikeCount);
      ((ak)localObject1).cU(((FinderItem)localObject2).getMediaType());
      o localo = o.sMi;
      ((ak)localObject1).hx(n.h(o.p((FinderItem)localObject2), ",", ";", false));
      ((ak)localObject1).hy("");
      ((ak)localObject1).hB(h.I(l, paramaqy.tcl));
    }
    for (;;)
    {
      ((ak)localObject1).aLk();
      h.a((a)localObject1);
      paramaqy = new ae(paramString, paramInt, paramaqy, paramaqy.tcj);
      AppMethodBeat.o(202957);
      return paramaqy;
      l = 4L;
      break;
      label411:
      i = 2;
      break label129;
      label416:
      ((ak)localObject1).hu("0");
      ((ak)localObject1).hx("");
      ((ak)localObject1).hy("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.u
 * JD-Core Version:    0.7.0.1
 */