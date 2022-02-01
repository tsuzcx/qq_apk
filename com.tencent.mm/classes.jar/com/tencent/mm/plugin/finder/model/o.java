package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderFollowLogic;", "", "()V", "follow", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "finderUser", "", "opType", "", "plugin-finder_release"})
public final class o
{
  public static final o qDF;
  
  static
  {
    AppMethodBeat.i(166392);
    qDF = new o();
    AppMethodBeat.o(166392);
  }
  
  public static com.tencent.mm.plugin.finder.cgi.n a(dzp paramdzp, String paramString, int paramInt)
  {
    AppMethodBeat.i(198634);
    k.h(paramdzp, "contextObj");
    k.h(paramString, "finderUser");
    ad.i("Finder.FinderFollowLogic", "follow event commentScene:" + paramdzp.LiL + " user:" + paramString + " opType: " + paramInt + " form " + bt.eGN());
    Object localObject1 = e.vIY;
    Object localObject2 = com.tencent.mm.plugin.finder.cgi.n.qpg;
    long l;
    int i;
    if (paramInt == com.tencent.mm.plugin.finder.cgi.n.ckG())
    {
      l = 5L;
      ((e)localObject1).idkeyStat(1278L, l, 1L, false);
      localObject1 = b.qFq;
      l = paramdzp.LiJ;
      localObject1 = com.tencent.mm.plugin.finder.cgi.n.qpg;
      if (paramInt != com.tencent.mm.plugin.finder.cgi.n.ckG()) {
        break label411;
      }
      i = 1;
      label129:
      k.h(paramdzp, "contextObj");
      k.h(paramString, "finderUsername");
      localObject1 = new x();
      ((x)localObject1).gg(paramdzp.sessionId);
      ((x)localObject1).gh("");
      ((x)localObject1).cr(paramdzp.LiL);
      ((x)localObject1).gj(paramString);
      ((x)localObject1).cj(3L);
      ((x)localObject1).ck(i);
      ((x)localObject1).gk("");
      ((x)localObject1).cm(2L);
      ((x)localObject1).NG(paramdzp.qwV);
      ((x)localObject1).NH(paramdzp.KHW);
      localObject2 = b.qh(l);
      if (localObject2 == null) {
        break label416;
      }
      ((x)localObject1).gi(b.qi(l));
      ((x)localObject1).cn(((FinderItem)localObject2).getFeedObject().likeCount);
      ((x)localObject1).co(((FinderItem)localObject2).getFeedObject().commentCount);
      ((x)localObject1).cp(((FinderItem)localObject2).getFeedObject().friendLikeCount);
      ((x)localObject1).cq(((FinderItem)localObject2).getMediaType());
      h localh = h.qSR;
      ((x)localObject1).gl(d.n.n.h(h.l((FinderItem)localObject2), ",", ";", false));
      ((x)localObject1).gm("");
      ((x)localObject1).NI(b.am(l, paramdzp.LiL));
    }
    for (;;)
    {
      ((x)localObject1).aBj();
      b.a((a)localObject1);
      paramdzp = new com.tencent.mm.plugin.finder.cgi.n(paramString, paramInt, paramdzp, paramdzp.LiJ);
      AppMethodBeat.o(198634);
      return paramdzp;
      l = 4L;
      break;
      label411:
      i = 2;
      break label129;
      label416:
      ((x)localObject1).gi("0");
      ((x)localObject1).gl("");
      ((x)localObject1).gm("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.o
 * JD-Core Version:    0.7.0.1
 */