package com.tencent.mm.plugin.finder.model;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.autogen.mmdata.rpt.db;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFavLogic;", "", "()V", "TAG", "", "favFeed", "", "context", "Landroidx/appcompat/app/AppCompatActivity;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "", "scene", "", "source", "favMegaVideo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s ECs;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(332257);
    ECs = new s();
    TAG = "Finder.FinderFavLogic";
    AppMethodBeat.o(332257);
  }
  
  public static void a(AppCompatActivity paramAppCompatActivity, FinderItem paramFinderItem, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(332245);
    kotlin.g.b.s.u(paramAppCompatActivity, "context");
    kotlin.g.b.s.u(paramFinderItem, "finderObject");
    Log.i(TAG, "favFeed, id:" + paramFinderItem.getId() + ", pf:" + paramFinderItem.getFeedObject().permissionFlag);
    Object localObject = k.aeZF;
    bui localbui = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d(paramAppCompatActivity).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    int i;
    label154:
    long l1;
    if (paramBoolean)
    {
      localObject = k.aeZF;
      paramAppCompatActivity = k.d(paramAppCompatActivity).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
      kotlin.g.b.s.s(paramAppCompatActivity, "UICProvider.of(context).…rReporterUIC::class.java)");
      paramAppCompatActivity = ((bn)paramAppCompatActivity).foy();
      if (paramAppCompatActivity != null)
      {
        paramAppCompatActivity = paramAppCompatActivity.dYj();
        if (paramAppCompatActivity != null) {
          paramAppCompatActivity.ne(paramFinderItem.getId());
        }
      }
      paramAppCompatActivity = com.tencent.mm.plugin.finder.report.z.FrZ;
      long l2 = paramFinderItem.getId();
      if (!paramBoolean) {
        break label610;
      }
      i = 2;
      kotlin.g.b.s.u(localbui, "contextObj");
      paramAppCompatActivity = com.tencent.mm.plugin.finder.report.z.jm(l2);
      if (paramAppCompatActivity != null)
      {
        db localdb = new db();
        localdb.mV(localbui.sessionId);
        localdb.mW("");
        localdb.mX(com.tencent.mm.plugin.finder.report.z.pL(l2));
        localdb.mY(paramAppCompatActivity.getUserName());
        localdb.iyq = 5L;
        localdb.ioV = i;
        localdb.iyu = 0L;
        localdb.mZ("");
        localdb.iyw = 2L;
        localdb.iwa = paramAppCompatActivity.getLikeCount();
        localdb.iwb = paramAppCompatActivity.getCommentCount();
        localdb.iwc = paramAppCompatActivity.getFriendLikeCount();
        localdb.iwe = paramAppCompatActivity.getMediaType();
        localObject = com.tencent.mm.plugin.finder.utils.as.GiG;
        localdb.na(n.bV(com.tencent.mm.plugin.finder.utils.as.F(paramAppCompatActivity), ",", ";"));
        localdb.nb("");
        localdb.iuA = localbui.AJo;
        if (!kotlin.g.b.s.p(paramAppCompatActivity.getUserName(), com.tencent.mm.model.z.bAW())) {
          break label616;
        }
        l1 = 1L;
        label356:
        localdb.iyE = l1;
        localObject = localbui.zIO;
        paramAppCompatActivity = (AppCompatActivity)localObject;
        if (localObject == null) {
          paramAppCompatActivity = "";
        }
        localdb.nc(paramAppCompatActivity);
        localObject = localbui.zIB;
        paramAppCompatActivity = (AppCompatActivity)localObject;
        if (localObject == null) {
          paramAppCompatActivity = "";
        }
        localdb.nd(paramAppCompatActivity);
        localdb.ne(com.tencent.mm.plugin.finder.report.z.p(l2, localbui.AJo));
        paramAppCompatActivity = localbui.extraInfo;
        if (paramAppCompatActivity != null) {
          break label622;
        }
        paramAppCompatActivity = "";
        label442:
        localdb.nf(paramAppCompatActivity);
        paramAppCompatActivity = localbui.zIE;
        if (paramAppCompatActivity != null) {
          break label647;
        }
        paramAppCompatActivity = "";
        label462:
        localdb.ng(paramAppCompatActivity);
        localdb.bMH();
        com.tencent.mm.plugin.finder.report.z.a((com.tencent.mm.plugin.report.a)localdb);
      }
      paramAppCompatActivity = c.GcH;
      c.a(c.fee(), paramFinderItem, paramBoolean, 2, localbui, paramInt);
      paramAppCompatActivity = new if();
      paramAppCompatActivity.hJB.id = paramFinderItem.getId();
      paramFinderItem = paramAppCompatActivity.hJB;
      if (!paramBoolean) {
        break label672;
      }
    }
    label647:
    label672:
    for (paramInt = 1;; paramInt = 2)
    {
      paramFinderItem.hJC = paramInt;
      paramAppCompatActivity.hJB.type = 5;
      paramAppCompatActivity.publish();
      AppMethodBeat.o(332245);
      return;
      localObject = k.aeZF;
      paramAppCompatActivity = k.d(paramAppCompatActivity).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
      kotlin.g.b.s.s(paramAppCompatActivity, "UICProvider.of(context).…rReporterUIC::class.java)");
      paramAppCompatActivity = ((bn)paramAppCompatActivity).foy();
      if (paramAppCompatActivity == null) {
        break;
      }
      paramAppCompatActivity = paramAppCompatActivity.dYj();
      if (paramAppCompatActivity == null) {
        break;
      }
      paramAppCompatActivity.nf(paramFinderItem.getId());
      break;
      label610:
      i = 1;
      break label154;
      label616:
      l1 = 0L;
      break label356;
      label622:
      localObject = n.bV(paramAppCompatActivity, ",", ";");
      paramAppCompatActivity = (AppCompatActivity)localObject;
      if (localObject != null) {
        break label442;
      }
      paramAppCompatActivity = "";
      break label442;
      localObject = n.bV(paramAppCompatActivity, ",", ";");
      paramAppCompatActivity = (AppCompatActivity)localObject;
      if (localObject != null) {
        break label462;
      }
      paramAppCompatActivity = "";
      break label462;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.s
 * JD-Core Version:    0.7.0.1
 */