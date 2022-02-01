package com.tencent.mm.plugin.finder.model;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.n.n;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderFavLogic;", "", "()V", "TAG", "", "favFeed", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "", "scene", "", "plugin-finder_release"})
public final class l
{
  private static final String TAG = "Finder.FinderFavLogic";
  public static final l sjY;
  
  static
  {
    AppMethodBeat.i(202951);
    sjY = new l();
    TAG = "Finder.FinderFavLogic";
    AppMethodBeat.o(202951);
  }
  
  public static void a(MMActivity paramMMActivity, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(202950);
    p.h(paramMMActivity, "context");
    p.h(paramFinderItem, "finderObject");
    ad.i(TAG, "favFeed, id:" + paramFinderItem.getId() + ", pf:" + paramFinderItem.getFeedObject().permissionFlag);
    Object localObject = com.tencent.mm.ui.component.a.KiD;
    aqy localaqy = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).cOu();
    label137:
    long l1;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.ui.component.a.KiD;
      paramMMActivity = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
      if (paramMMActivity != null) {
        paramMMActivity.cze().vV(paramFinderItem.getId());
      }
      paramMMActivity = h.soM;
      long l2 = paramFinderItem.getId();
      if (!paramBoolean) {
        break label550;
      }
      i = 2;
      p.h(localaqy, "contextObj");
      paramMMActivity = h.ws(l2);
      if (paramMMActivity != null)
      {
        ak localak = new ak();
        localak.hs(localaqy.sessionId);
        localak.ht("");
        localak.hu(h.wu(l2));
        localak.hv(paramMMActivity.getUserName());
        localak.cN(5L);
        localak.cO(i);
        localak.cP(0L);
        localak.hw("");
        localak.cQ(2L);
        localak.cR(paramMMActivity.getLikeCount());
        localak.cS(paramMMActivity.getCommentCount());
        localak.cT(paramMMActivity.getFriendLikeCount());
        localak.cU(paramMMActivity.getMediaType());
        localObject = o.sMi;
        localak.hx(n.h(o.p(paramMMActivity), ",", ";", false));
        localak.hy("");
        localak.cV(localaqy.rTD);
        if (!p.i(paramMMActivity.getUserName(), u.aAu())) {
          break label555;
        }
        l1 = 1L;
        label347:
        localak.cW(l1);
        localObject = localaqy.qXu;
        paramMMActivity = (MMActivity)localObject;
        if (localObject == null) {
          paramMMActivity = "";
        }
        localak.hz(paramMMActivity);
        localObject = localaqy.qXj;
        paramMMActivity = (MMActivity)localObject;
        if (localObject == null) {
          paramMMActivity = "";
        }
        localak.hA(paramMMActivity);
        localak.hB(h.I(l2, localaqy.rTD));
        localak.aLk();
        h.a((com.tencent.mm.plugin.report.a)localak);
      }
      paramMMActivity = c.sJS;
      c.a(c.cKT(), paramFinderItem, paramBoolean, localaqy);
      paramMMActivity = new he();
      paramMMActivity.dtz.id = paramFinderItem.getId();
      paramFinderItem = paramMMActivity.dtz;
      if (!paramBoolean) {
        break label561;
      }
    }
    label550:
    label555:
    label561:
    for (int i = 1;; i = 2)
    {
      paramFinderItem.dtA = i;
      paramMMActivity.dtz.type = 5;
      com.tencent.mm.sdk.b.a.IbL.l((b)paramMMActivity);
      AppMethodBeat.o(202950);
      return;
      localObject = com.tencent.mm.ui.component.a.KiD;
      paramMMActivity = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
      if (paramMMActivity == null) {
        break;
      }
      paramMMActivity.cze().vW(paramFinderItem.getId());
      break;
      i = 1;
      break label137;
      l1 = 0L;
      break label347;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.l
 * JD-Core Version:    0.7.0.1
 */