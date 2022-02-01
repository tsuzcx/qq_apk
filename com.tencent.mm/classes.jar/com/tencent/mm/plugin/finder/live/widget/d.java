package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostTaskWidget;", "", "activity", "Landroid/app/Activity;", "bannerView", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;)V", "getActivity", "()Landroid/app/Activity;", "getBannerView", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;", "resume", "", "stop", "update", "gameInfo", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a ElH;
  public final FinderLiveTaskBannerView ElI;
  private final Activity activity;
  
  static
  {
    AppMethodBeat.i(361009);
    ElH = new d.a((byte)0);
    AppMethodBeat.o(361009);
  }
  
  public d(Activity paramActivity, FinderLiveTaskBannerView paramFinderLiveTaskBannerView)
  {
    AppMethodBeat.i(361006);
    this.activity = paramActivity;
    this.ElI = paramFinderLiveTaskBannerView;
    AppMethodBeat.o(361006);
  }
  
  public final void b(ccb paramccb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(361019);
    s.u(paramccb, "gameInfo");
    Object localObject1 = paramccb.aalu;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((caz)localObject1).aake)
    {
      localObject4 = paramccb.aalu;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      Log.i("MicroMsg.FinderGameLivePostTaskWidget", s.X("update ", f.dg(localObject2)));
      if ((localObject1 != null) && (!((LinkedList)localObject1).isEmpty())) {
        break;
      }
      this.ElI.setVisibility(8);
      AppMethodBeat.o(361019);
      return;
    }
    this.ElI.setVisibility(0);
    Object localObject4 = this.ElI;
    Object localObject2 = paramccb.aals;
    label183:
    caz localcaz;
    if (localObject2 == null)
    {
      localObject2 = localObject3;
      ((FinderLiveTaskBannerView)localObject4).setGameAppId((String)localObject2);
      localObject2 = this.ElI;
      localObject3 = (Iterable)p.l((Iterable)localObject1);
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label259;
      }
      localObject4 = (cba)((Iterator)localObject3).next();
      localcaz = paramccb.aalu;
      if (localcaz != null) {
        break label249;
      }
    }
    label249:
    for (long l = 0L;; l = localcaz.aakf)
    {
      ((Collection)localObject1).add(new FinderLiveTaskBannerView.b((cba)localObject4, l));
      break label183;
      localObject2 = ((cbb)localObject2).app_id;
      break;
    }
    label259:
    ((FinderLiveTaskBannerView)localObject2).setTaskInfoList((List)localObject1);
    this.ElI.resume();
    AppMethodBeat.o(361019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.d
 * JD-Core Version:    0.7.0.1
 */