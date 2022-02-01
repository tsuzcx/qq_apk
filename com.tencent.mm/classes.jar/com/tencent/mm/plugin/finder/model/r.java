package com.tencent.mm.plugin.finder.model;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFavLogic;", "", "()V", "TAG", "", "favFeed", "", "context", "Landroid/support/v7/app/AppCompatActivity;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "", "scene", "", "favMegaVideo", "plugin-finder_release"})
public final class r
{
  private static final String TAG = "Finder.FinderFavLogic";
  public static final r uNW;
  
  static
  {
    AppMethodBeat.i(248731);
    uNW = new r();
    TAG = "Finder.FinderFavLogic";
    AppMethodBeat.o(248731);
  }
  
  public static void a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(248730);
    p.h(paramAppCompatActivity, "context");
    p.h(paramFinderItem, "finderObject");
    Log.i(TAG, "favFeed, id:" + paramFinderItem.getId() + ", pf:" + paramFinderItem.getFeedObject().permissionFlag);
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    bbn localbbn = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(FinderReporterUIC.class)).dIx();
    label137:
    long l1;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.ui.component.a.PRN;
      paramAppCompatActivity = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(FinderReporterUIC.class));
      if (paramAppCompatActivity != null) {
        paramAppCompatActivity.cZR().Er(paramFinderItem.getId());
      }
      paramAppCompatActivity = k.vfA;
      long l2 = paramFinderItem.getId();
      if (!paramBoolean) {
        break label628;
      }
      i = 2;
      p.h(localbbn, "contextObj");
      paramAppCompatActivity = k.Fc(l2);
      if (paramAppCompatActivity != null)
      {
        bm localbm = new bm();
        localbm.jt(localbbn.sessionId);
        localbm.ju("");
        localbm.jv(k.Fg(l2));
        localbm.jw(paramAppCompatActivity.getUserName());
        localbm.dU(5L);
        localbm.dV(i);
        localbm.dW(0L);
        localbm.jx("");
        localbm.dX(2L);
        localbm.dY(paramAppCompatActivity.getLikeCount());
        localbm.dZ(paramAppCompatActivity.getCommentCount());
        localbm.ea(paramAppCompatActivity.getFriendLikeCount());
        localbm.eb(paramAppCompatActivity.getMediaType());
        localObject = w.vXp;
        localbm.jy(n.j(w.z(paramAppCompatActivity), ",", ";", false));
        localbm.jz("");
        localbm.ec(localbbn.tCE);
        if (!p.j(paramAppCompatActivity.getUserName(), z.aUg())) {
          break label633;
        }
        l1 = 1L;
        label347:
        localbm.ed(l1);
        localObject = localbbn.sGQ;
        paramAppCompatActivity = (AppCompatActivity)localObject;
        if (localObject == null) {
          paramAppCompatActivity = "";
        }
        localbm.jA(paramAppCompatActivity);
        localObject = localbbn.sGE;
        paramAppCompatActivity = (AppCompatActivity)localObject;
        if (localObject == null) {
          paramAppCompatActivity = "";
        }
        localbm.jB(paramAppCompatActivity);
        localbm.jC(k.G(l2, localbbn.tCE));
        paramAppCompatActivity = localbbn.extraInfo;
        if (paramAppCompatActivity != null)
        {
          localObject = n.j(paramAppCompatActivity, ",", ";", false);
          paramAppCompatActivity = (AppCompatActivity)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramAppCompatActivity = "";
        }
        localbm.jD(paramAppCompatActivity);
        paramAppCompatActivity = localbbn.sGH;
        if (paramAppCompatActivity != null)
        {
          localObject = n.j(paramAppCompatActivity, ",", ";", false);
          paramAppCompatActivity = (AppCompatActivity)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramAppCompatActivity = "";
        }
        localbm.jE(paramAppCompatActivity);
        localbm.bfK();
        k.a((com.tencent.mm.plugin.report.a)localbm);
      }
      paramAppCompatActivity = c.vUa;
      c.a(c.dBq(), paramFinderItem, paramBoolean, localbbn);
      paramAppCompatActivity = new hn();
      paramAppCompatActivity.dLW.id = paramFinderItem.getId();
      paramFinderItem = paramAppCompatActivity.dLW;
      if (!paramBoolean) {
        break label639;
      }
    }
    label628:
    label633:
    label639:
    for (int i = 1;; i = 2)
    {
      paramFinderItem.dLX = i;
      paramAppCompatActivity.dLW.type = 5;
      EventCenter.instance.publish((IEvent)paramAppCompatActivity);
      AppMethodBeat.o(248730);
      return;
      localObject = com.tencent.mm.ui.component.a.PRN;
      paramAppCompatActivity = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(FinderReporterUIC.class));
      if (paramAppCompatActivity == null) {
        break;
      }
      paramAppCompatActivity.cZR().Es(paramFinderItem.getId());
      break;
      i = 1;
      break label137;
      l1 = 0L;
      break label347;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.r
 * JD-Core Version:    0.7.0.1
 */