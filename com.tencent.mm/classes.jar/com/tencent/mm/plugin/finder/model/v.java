package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FinderFollowLogic;", "", "()V", "follow", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "finderUser", "", "opType", "", "plugin-finder_release"})
public final class v
{
  public static final v stj;
  
  static
  {
    AppMethodBeat.i(166392);
    stj = new v();
    AppMethodBeat.o(166392);
  }
  
  public static af a(arn paramarn, String paramString, int paramInt)
  {
    AppMethodBeat.i(203440);
    p.h(paramarn, "contextObj");
    p.h(paramString, "finderUser");
    ae.i("Finder.FinderFollowLogic", "follow event commentScene:" + paramarn.tnf + " user:" + paramString + " opType: " + paramInt + " form " + bu.fpN());
    Object localObject1 = e.ywz;
    Object localObject2 = af.rRv;
    long l;
    int i;
    label129:
    ak localak;
    if (paramInt == af.czF())
    {
      l = 5L;
      ((e)localObject1).idkeyStat(1278L, l, 1L, false);
      localObject1 = i.syT;
      l = paramarn.tnd;
      localObject1 = af.rRv;
      if (paramInt != af.czF()) {
        break label499;
      }
      i = 1;
      p.h(paramarn, "contextObj");
      p.h(paramString, "finderUsername");
      localak = new ak();
      localak.hy(paramarn.sessionId);
      localak.hz("");
      localak.cV(paramarn.sch);
      localak.hB(paramString);
      localak.cN(3L);
      localak.cO(i);
      localak.hC("");
      localak.cQ(2L);
      localak.hF(paramarn.rfA);
      localak.hG(paramarn.rfo);
      localObject1 = i.wJ(l);
      if (localObject1 == null) {
        break label504;
      }
      localak.hA(i.wL(l));
      localak.cR(((FinderItem)localObject1).getFeedObject().likeCount);
      localak.cS(((FinderItem)localObject1).getFeedObject().commentCount);
      localak.cT(((FinderItem)localObject1).getFeedObject().friendLikeCount);
      localak.cU(((FinderItem)localObject1).getMediaType());
      localObject2 = o.sXt;
      localak.hD(n.h(o.p((FinderItem)localObject1), ",", ";", false));
      localak.hE("");
      localak.hH(i.I(l, paramarn.tnf));
    }
    for (;;)
    {
      localObject1 = paramarn.extraInfo;
      if (localObject1 != null)
      {
        localObject2 = n.h((String)localObject1, ",", ";", false);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localak.hI((String)localObject1);
      localObject1 = paramarn.rfr;
      if (localObject1 != null)
      {
        localObject2 = n.h((String)localObject1, ",", ";", false);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localak.hJ((String)localObject1);
      localak.aLH();
      i.a((a)localak);
      paramarn = new af(paramString, paramInt, paramarn, paramarn.tnd);
      AppMethodBeat.o(203440);
      return paramarn;
      l = 4L;
      break;
      label499:
      i = 2;
      break label129;
      label504:
      localak.hA("0");
      localak.hD("");
      localak.hE("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.v
 * JD-Core Version:    0.7.0.1
 */