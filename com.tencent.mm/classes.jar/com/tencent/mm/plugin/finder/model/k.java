package com.tencent.mm.plugin.finder.model;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.b.a.ac;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.MMActivity;
import d.l;
import d.n.n;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FinderFavLogic;", "", "()V", "favFeed", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "", "scene", "", "plugin-finder_release"})
public final class k
{
  public static final k ruF;
  
  static
  {
    AppMethodBeat.i(202557);
    ruF = new k();
    AppMethodBeat.o(202557);
  }
  
  public static void a(MMActivity paramMMActivity, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(202556);
    d.g.b.k.h(paramMMActivity, "context");
    d.g.b.k.h(paramFinderItem, "finderObject");
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    anm localanm = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderReporterUIC.class)).cGb();
    if (paramBoolean)
    {
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().ren.ctW();
    }
    label129:
    long l1;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.ui.component.a.IrY;
      paramMMActivity = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderReporterUIC.class));
      if (paramMMActivity != null) {
        paramMMActivity.ctb().tY(paramFinderItem.getId());
      }
      paramMMActivity = com.tencent.mm.plugin.finder.report.d.rxr;
      long l2 = paramFinderItem.getId();
      if (!paramBoolean) {
        break label542;
      }
      i = 2;
      d.g.b.k.h(localanm, "contextObj");
      paramMMActivity = com.tencent.mm.plugin.finder.report.d.ur(l2);
      if (paramMMActivity != null)
      {
        ac localac = new ac();
        localac.gi(localanm.sessionId);
        localac.gj("");
        localac.gk(com.tencent.mm.plugin.finder.report.d.ut(l2));
        localac.gl(paramMMActivity.getUserName());
        localac.ct(5L);
        localac.cu(i);
        localac.cv(0L);
        localac.gm("");
        localac.cw(2L);
        localac.cx(paramMMActivity.getLikeCount());
        localac.cy(paramMMActivity.getCommentCount());
        localac.cz(paramMMActivity.getFriendLikeCount());
        localac.cA(paramMMActivity.getMediaType());
        localObject = m.rPH;
        localac.gn(n.h(m.n(paramMMActivity), ",", ";", false));
        localac.go("");
        localac.cB(localanm.rfR);
        if (!d.g.b.k.g(paramMMActivity.getUserName(), u.axE())) {
          break label547;
        }
        l1 = 1L;
        label339:
        localac.cC(l1);
        localObject = localanm.qox;
        paramMMActivity = (MMActivity)localObject;
        if (localObject == null) {
          paramMMActivity = "";
        }
        localac.gp(paramMMActivity);
        localObject = localanm.qom;
        paramMMActivity = (MMActivity)localObject;
        if (localObject == null) {
          paramMMActivity = "";
        }
        localac.gq(paramMMActivity);
        localac.gr(com.tencent.mm.plugin.finder.report.d.G(l2, localanm.rfR));
        localac.aHZ();
        com.tencent.mm.plugin.finder.report.d.a((com.tencent.mm.plugin.report.a)localac);
      }
      paramMMActivity = c.rNN;
      c.a(c.cCG(), paramFinderItem, paramBoolean, localanm);
      paramMMActivity = new ha();
      paramMMActivity.dhX.id = paramFinderItem.getId();
      paramFinderItem = paramMMActivity.dhX;
      if (!paramBoolean) {
        break label553;
      }
    }
    label542:
    label547:
    label553:
    for (int i = 1;; i = 2)
    {
      paramFinderItem.dhY = i;
      paramMMActivity.dhX.type = 5;
      com.tencent.mm.sdk.b.a.GpY.l((b)paramMMActivity);
      AppMethodBeat.o(202556);
      return;
      localObject = com.tencent.mm.ui.component.a.IrY;
      paramMMActivity = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderReporterUIC.class));
      if (paramMMActivity == null) {
        break;
      }
      paramMMActivity.ctb().tZ(paramFinderItem.getId());
      break;
      i = 1;
      break label129;
      l1 = 0L;
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.k
 * JD-Core Version:    0.7.0.1
 */