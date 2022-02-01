package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.y;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FinderFollowLogic;", "", "()V", "follow", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "finderUser", "", "opType", "", "plugin-finder_release"})
public final class t
{
  public static final t ruU;
  
  static
  {
    AppMethodBeat.i(166392);
    ruU = new t();
    AppMethodBeat.o(166392);
  }
  
  public static y a(anm paramanm, String paramString, int paramInt)
  {
    AppMethodBeat.i(202561);
    k.h(paramanm, "contextObj");
    k.h(paramString, "finderUser");
    com.tencent.mm.sdk.platformtools.ac.i("Finder.FinderFollowLogic", "follow event commentScene:" + paramanm.seo + " user:" + paramString + " opType: " + paramInt + " form " + bs.eWi());
    Object localObject1 = e.wTc;
    Object localObject2 = y.qXW;
    long l;
    int i;
    if (paramInt == y.cso())
    {
      l = 5L;
      ((e)localObject1).idkeyStat(1278L, l, 1L, false);
      localObject1 = d.rxr;
      l = paramanm.sem;
      localObject1 = y.qXW;
      if (paramInt != y.cso()) {
        break label411;
      }
      i = 1;
      label129:
      k.h(paramanm, "contextObj");
      k.h(paramString, "finderUsername");
      localObject1 = new com.tencent.mm.g.b.a.ac();
      ((com.tencent.mm.g.b.a.ac)localObject1).gi(paramanm.sessionId);
      ((com.tencent.mm.g.b.a.ac)localObject1).gj("");
      ((com.tencent.mm.g.b.a.ac)localObject1).cB(paramanm.seo);
      ((com.tencent.mm.g.b.a.ac)localObject1).gl(paramString);
      ((com.tencent.mm.g.b.a.ac)localObject1).ct(3L);
      ((com.tencent.mm.g.b.a.ac)localObject1).cu(i);
      ((com.tencent.mm.g.b.a.ac)localObject1).gm("");
      ((com.tencent.mm.g.b.a.ac)localObject1).cw(2L);
      ((com.tencent.mm.g.b.a.ac)localObject1).gp(paramanm.qox);
      ((com.tencent.mm.g.b.a.ac)localObject1).gq(paramanm.qom);
      localObject2 = d.ur(l);
      if (localObject2 == null) {
        break label416;
      }
      ((com.tencent.mm.g.b.a.ac)localObject1).gk(d.ut(l));
      ((com.tencent.mm.g.b.a.ac)localObject1).cx(((FinderItem)localObject2).getFeedObject().likeCount);
      ((com.tencent.mm.g.b.a.ac)localObject1).cy(((FinderItem)localObject2).getFeedObject().commentCount);
      ((com.tencent.mm.g.b.a.ac)localObject1).cz(((FinderItem)localObject2).getFeedObject().friendLikeCount);
      ((com.tencent.mm.g.b.a.ac)localObject1).cA(((FinderItem)localObject2).getMediaType());
      m localm = m.rPH;
      ((com.tencent.mm.g.b.a.ac)localObject1).gn(n.h(m.n((FinderItem)localObject2), ",", ";", false));
      ((com.tencent.mm.g.b.a.ac)localObject1).go("");
      ((com.tencent.mm.g.b.a.ac)localObject1).gr(d.G(l, paramanm.seo));
    }
    for (;;)
    {
      ((com.tencent.mm.g.b.a.ac)localObject1).aHZ();
      d.a((a)localObject1);
      paramanm = new y(paramString, paramInt, paramanm, paramanm.sem);
      AppMethodBeat.o(202561);
      return paramanm;
      l = 4L;
      break;
      label411:
      i = 2;
      break label129;
      label416:
      ((com.tencent.mm.g.b.a.ac)localObject1).gk("0");
      ((com.tencent.mm.g.b.a.ac)localObject1).gn("");
      ((com.tencent.mm.g.b.a.ac)localObject1).go("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.t
 * JD-Core Version:    0.7.0.1
 */