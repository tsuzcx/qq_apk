package com.tencent.mm.plugin.finder.model;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderFavLogic;", "", "()V", "favFeed", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "", "scene", "", "plugin-finder_release"})
public final class y
{
  public static final y KTo;
  
  static
  {
    AppMethodBeat.i(198630);
    KTo = new y();
    AppMethodBeat.o(198630);
  }
  
  public static void a(MMActivity paramMMActivity, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(198629);
    k.h(paramMMActivity, "context");
    k.h(paramFinderItem, "finderObject");
    Object localObject1 = com.tencent.mm.ui.component.a.LCX;
    dzp localdzp = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).fXs();
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().qtc;
      ad.d("Finder.RedDotTransform", "checkFirstFeedFav");
      localObject2 = g.afB();
      k.g(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.e)localObject2).afk().get(ae.a.LBH, Boolean.FALSE);
      if (localObject2 == null)
      {
        paramMMActivity = new v("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(198629);
        throw paramMMActivity;
      }
      if (!((Boolean)localObject2).booleanValue())
      {
        localObject2 = new akv();
        ((akv)localObject2).Dmu = String.valueOf(ce.asS());
        ((akv)localObject2).priority = 100000;
        ((akv)localObject2).type = 1001;
        aln localaln = new aln();
        localaln.rXs = 1;
        localaln.DmL = 1;
        localaln.path = "TLPersonalCenter";
        ((akv)localObject2).Dmt.add(localaln);
        localaln = new aln();
        localaln.rXs = 1;
        localaln.DmL = 1;
        localaln.path = "FinderFirstFav";
        ((akv)localObject2).Dmt.add(localaln);
        ((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).qtJ.a((akv)localObject2, "checkTlFirstFav");
        localObject1 = g.afB();
        k.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).afk().set(ae.a.LBH, Boolean.TRUE);
      }
    }
    label348:
    long l1;
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.ui.component.a.LCX;
      paramMMActivity = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
      if (paramMMActivity != null) {
        paramMMActivity.fSl().BA(paramFinderItem.getId());
      }
      paramMMActivity = com.tencent.mm.plugin.finder.report.b.qFq;
      long l2 = paramFinderItem.getId();
      if (!paramBoolean) {
        break label768;
      }
      i = 2;
      k.h(localdzp, "contextObj");
      paramMMActivity = com.tencent.mm.plugin.finder.report.b.qh(l2);
      if (paramMMActivity != null)
      {
        localObject2 = new x();
        ((x)localObject2).gg(localdzp.sessionId);
        ((x)localObject2).gh("");
        ((x)localObject2).gi(com.tencent.mm.plugin.finder.report.b.qi(l2));
        ((x)localObject2).gj(paramMMActivity.getUserName());
        ((x)localObject2).cj(5L);
        ((x)localObject2).ck(i);
        ((x)localObject2).cl(0L);
        ((x)localObject2).gk("");
        ((x)localObject2).cm(2L);
        ((x)localObject2).cn(paramMMActivity.getLikeCount());
        ((x)localObject2).co(paramMMActivity.getCommentCount());
        ((x)localObject2).cp(paramMMActivity.getFriendLikeCount());
        ((x)localObject2).cq(paramMMActivity.getMediaType());
        localObject1 = com.tencent.mm.plugin.finder.utils.h.qSR;
        ((x)localObject2).gl(n.h(com.tencent.mm.plugin.finder.utils.h.l(paramMMActivity), ",", ";", false));
        ((x)localObject2).gm("");
        ((x)localObject2).cr(localdzp.qqE);
        if (!k.g(paramMMActivity.getUserName(), u.aqO())) {
          break label773;
        }
        l1 = 1L;
        label563:
        ((x)localObject2).vB(l1);
        localObject1 = localdzp.qwV;
        paramMMActivity = (MMActivity)localObject1;
        if (localObject1 == null) {
          paramMMActivity = "";
        }
        ((x)localObject2).NG(paramMMActivity);
        localObject1 = localdzp.KHW;
        paramMMActivity = (MMActivity)localObject1;
        if (localObject1 == null) {
          paramMMActivity = "";
        }
        ((x)localObject2).NH(paramMMActivity);
        ((x)localObject2).NI(com.tencent.mm.plugin.finder.report.b.am(l2, localdzp.qqE));
        ((x)localObject2).aBj();
        com.tencent.mm.plugin.finder.report.b.a((com.tencent.mm.plugin.report.a)localObject2);
      }
      paramMMActivity = com.tencent.mm.plugin.finder.upload.action.h.Lan;
      com.tencent.mm.plugin.finder.upload.action.h.a(com.tencent.mm.plugin.finder.upload.action.h.fVL(), paramFinderItem, paramBoolean, localdzp);
      paramMMActivity = new gy();
      paramMMActivity.dkz.id = paramFinderItem.getId();
      paramFinderItem = paramMMActivity.dkz;
      if (!paramBoolean) {
        break label779;
      }
    }
    label768:
    label773:
    label779:
    for (int i = 1;; i = 2)
    {
      paramFinderItem.aBE = i;
      paramMMActivity.dkz.type = 5;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)paramMMActivity);
      AppMethodBeat.o(198629);
      return;
      localObject1 = com.tencent.mm.ui.component.a.LCX;
      paramMMActivity = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
      if (paramMMActivity == null) {
        break;
      }
      paramMMActivity.fSl().BB(paramFinderItem.getId());
      break;
      i = 1;
      break label348;
      l1 = 0L;
      break label563;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.y
 * JD-Core Version:    0.7.0.1
 */