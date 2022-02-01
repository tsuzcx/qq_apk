package com.tencent.mm.plugin.finder.model;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FinderFavLogic;", "", "()V", "TAG", "", "favFeed", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "", "scene", "", "plugin-finder_release"})
public final class m
{
  private static final String TAG = "Finder.FinderFavLogic";
  public static final m ssV;
  
  static
  {
    AppMethodBeat.i(203433);
    ssV = new m();
    TAG = "Finder.FinderFavLogic";
    AppMethodBeat.o(203433);
  }
  
  public static void a(MMActivity paramMMActivity, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(203432);
    p.h(paramMMActivity, "context");
    p.h(paramFinderItem, "finderObject");
    ae.i(TAG, "favFeed, id:" + paramFinderItem.getId() + ", pf:" + paramFinderItem.getFeedObject().permissionFlag);
    Object localObject = com.tencent.mm.ui.component.a.KEX;
    arn localarn = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).cQZ();
    label137:
    long l1;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.ui.component.a.KEX;
      paramMMActivity = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
      if (paramMMActivity != null) {
        paramMMActivity.cAI().wl(paramFinderItem.getId());
      }
      paramMMActivity = i.syT;
      long l2 = paramFinderItem.getId();
      if (!paramBoolean) {
        break label628;
      }
      i = 2;
      p.h(localarn, "contextObj");
      paramMMActivity = i.wJ(l2);
      if (paramMMActivity != null)
      {
        ak localak = new ak();
        localak.hy(localarn.sessionId);
        localak.hz("");
        localak.hA(i.wL(l2));
        localak.hB(paramMMActivity.getUserName());
        localak.cN(5L);
        localak.cO(i);
        localak.cP(0L);
        localak.hC("");
        localak.cQ(2L);
        localak.cR(paramMMActivity.getLikeCount());
        localak.cS(paramMMActivity.getCommentCount());
        localak.cT(paramMMActivity.getFriendLikeCount());
        localak.cU(paramMMActivity.getMediaType());
        localObject = o.sXt;
        localak.hD(n.h(o.p(paramMMActivity), ",", ";", false));
        localak.hE("");
        localak.cV(localarn.sch);
        if (!p.i(paramMMActivity.getUserName(), v.aAK())) {
          break label633;
        }
        l1 = 1L;
        label347:
        localak.cW(l1);
        localObject = localarn.rfA;
        paramMMActivity = (MMActivity)localObject;
        if (localObject == null) {
          paramMMActivity = "";
        }
        localak.hF(paramMMActivity);
        localObject = localarn.rfo;
        paramMMActivity = (MMActivity)localObject;
        if (localObject == null) {
          paramMMActivity = "";
        }
        localak.hG(paramMMActivity);
        localak.hH(i.I(l2, localarn.sch));
        paramMMActivity = localarn.extraInfo;
        if (paramMMActivity != null)
        {
          localObject = n.h(paramMMActivity, ",", ";", false);
          paramMMActivity = (MMActivity)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMMActivity = "";
        }
        localak.hI(paramMMActivity);
        paramMMActivity = localarn.rfr;
        if (paramMMActivity != null)
        {
          localObject = n.h(paramMMActivity, ",", ";", false);
          paramMMActivity = (MMActivity)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMMActivity = "";
        }
        localak.hJ(paramMMActivity);
        localak.aLH();
        i.a((com.tencent.mm.plugin.report.a)localak);
      }
      paramMMActivity = c.sVf;
      c.a(c.cNx(), paramFinderItem, paramBoolean, localarn);
      paramMMActivity = new hf();
      paramMMActivity.duE.id = paramFinderItem.getId();
      paramFinderItem = paramMMActivity.duE;
      if (!paramBoolean) {
        break label639;
      }
    }
    label628:
    label633:
    label639:
    for (int i = 1;; i = 2)
    {
      paramFinderItem.duF = i;
      paramMMActivity.duE.type = 5;
      com.tencent.mm.sdk.b.a.IvT.l((b)paramMMActivity);
      AppMethodBeat.o(203432);
      return;
      localObject = com.tencent.mm.ui.component.a.KEX;
      paramMMActivity = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
      if (paramMMActivity == null) {
        break;
      }
      paramMMActivity.cAI().wm(paramFinderItem.getId());
      break;
      i = 1;
      break label137;
      l1 = 0L;
      break label347;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.m
 * JD-Core Version:    0.7.0.1
 */