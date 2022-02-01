package com.tencent.mm.plugin.finder.model;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.f.b.a.cc;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFavLogic;", "", "()V", "TAG", "", "favFeed", "", "context", "Landroidx/appcompat/app/AppCompatActivity;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "", "scene", "", "favMegaVideo", "plugin-finder_release"})
public final class r
{
  private static final String TAG = "Finder.FinderFavLogic";
  public static final r zAk;
  
  static
  {
    AppMethodBeat.i(272293);
    zAk = new r();
    TAG = "Finder.FinderFavLogic";
    AppMethodBeat.o(272293);
  }
  
  public static void a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(272292);
    p.k(paramAppCompatActivity, "context");
    p.k(paramFinderItem, "finderObject");
    Log.i(TAG, "favFeed, id:" + paramFinderItem.getId() + ", pf:" + paramFinderItem.getFeedObject().permissionFlag);
    Object localObject = g.Xox;
    bid localbid = ((aj)g.b(paramAppCompatActivity).i(aj.class)).ekY();
    label137:
    long l1;
    if (paramBoolean)
    {
      localObject = g.Xox;
      paramAppCompatActivity = aj.b((aj)g.b(paramAppCompatActivity).i(aj.class));
      if (paramAppCompatActivity != null) {
        paramAppCompatActivity.dpO().KG(paramFinderItem.getId());
      }
      paramAppCompatActivity = com.tencent.mm.plugin.finder.report.n.zWF;
      long l2 = paramFinderItem.getId();
      if (!paramBoolean) {
        break label628;
      }
      i = 2;
      p.k(localbid, "contextObj");
      paramAppCompatActivity = com.tencent.mm.plugin.finder.report.n.Hc(l2);
      if (paramAppCompatActivity != null)
      {
        cc localcc = new cc();
        localcc.lD(localbid.sessionId);
        localcc.lE("");
        localcc.lF(com.tencent.mm.plugin.finder.report.n.Mp(l2));
        localcc.lG(paramAppCompatActivity.getUserName());
        localcc.eI(5L);
        localcc.eJ(i);
        localcc.eK(0L);
        localcc.lH("");
        localcc.eL(2L);
        localcc.eM(paramAppCompatActivity.getLikeCount());
        localcc.eN(paramAppCompatActivity.getCommentCount());
        localcc.eO(paramAppCompatActivity.getFriendLikeCount());
        localcc.eP(paramAppCompatActivity.getMediaType());
        localObject = ag.AFH;
        localcc.lI(kotlin.n.n.l(ag.A(paramAppCompatActivity), ",", ";", false));
        localcc.lJ("");
        localcc.eQ(localbid.xkX);
        if (!p.h(paramAppCompatActivity.getUserName(), z.bdh())) {
          break label633;
        }
        l1 = 1L;
        label347:
        localcc.eR(l1);
        localObject = localbid.wmL;
        paramAppCompatActivity = (AppCompatActivity)localObject;
        if (localObject == null) {
          paramAppCompatActivity = "";
        }
        localcc.lK(paramAppCompatActivity);
        localObject = localbid.wmz;
        paramAppCompatActivity = (AppCompatActivity)localObject;
        if (localObject == null) {
          paramAppCompatActivity = "";
        }
        localcc.lL(paramAppCompatActivity);
        localcc.lM(com.tencent.mm.plugin.finder.report.n.N(l2, localbid.xkX));
        paramAppCompatActivity = localbid.extraInfo;
        if (paramAppCompatActivity != null)
        {
          localObject = kotlin.n.n.l(paramAppCompatActivity, ",", ";", false);
          paramAppCompatActivity = (AppCompatActivity)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramAppCompatActivity = "";
        }
        localcc.lN(paramAppCompatActivity);
        paramAppCompatActivity = localbid.wmC;
        if (paramAppCompatActivity != null)
        {
          localObject = kotlin.n.n.l(paramAppCompatActivity, ",", ";", false);
          paramAppCompatActivity = (AppCompatActivity)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramAppCompatActivity = "";
        }
        localcc.lO(paramAppCompatActivity);
        localcc.bpa();
        com.tencent.mm.plugin.finder.report.n.a((com.tencent.mm.plugin.report.a)localcc);
      }
      paramAppCompatActivity = c.ABD;
      c.a(c.ecy(), paramFinderItem, paramBoolean, localbid);
      paramAppCompatActivity = new hu();
      paramAppCompatActivity.fEL.id = paramFinderItem.getId();
      paramFinderItem = paramAppCompatActivity.fEL;
      if (!paramBoolean) {
        break label639;
      }
    }
    label628:
    label633:
    label639:
    for (int i = 1;; i = 2)
    {
      paramFinderItem.fEM = i;
      paramAppCompatActivity.fEL.type = 5;
      EventCenter.instance.publish((IEvent)paramAppCompatActivity);
      AppMethodBeat.o(272292);
      return;
      localObject = g.Xox;
      paramAppCompatActivity = aj.b((aj)g.b(paramAppCompatActivity).i(aj.class));
      if (paramAppCompatActivity == null) {
        break;
      }
      paramAppCompatActivity.dpO().KH(paramFinderItem.getId());
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