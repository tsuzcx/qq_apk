package com.tencent.mm.plugin.finder.nearby.live.square.find;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.cp;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.live.square.tab.b.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment$onCreateView$1", "Landroid/view/View$OnClickListener;", "FAST_CLICK_DELAY_TIME", "", "lastClickTime", "", "isFastClick", "", "onClick", "", "v", "Landroid/view/View;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveFindPageFragment$a
  implements View.OnClickListener
{
  private final int akhy = 500;
  private long lastClickTime;
  
  FinderLiveFindPageFragment$a(FinderLiveFindPageFragment paramFinderLiveFindPageFragment) {}
  
  public final void onClick(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(370453);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment$onCreateView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    int i = 1;
    long l = System.currentTimeMillis();
    if (l - this.lastClickTime >= this.akhy) {
      i = 0;
    }
    this.lastClickTime = l;
    if (i != 0)
    {
      Log.i("NearbyLiveSquareFragment", "fast click, too fast guys.");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment$onCreateView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(370453);
      return;
    }
    this.akhz.eEp();
    paramView = this.akhz;
    bui localbui;
    i locali;
    label169:
    label175:
    label187:
    label193:
    cp localcp;
    if (paramView.getActivity() != null)
    {
      localObject = k.aeZF;
      localbui = ((as)k.y((Fragment)paramView).q(as.class)).fou();
      locali = new i();
      paramView = paramView.rootView;
      if (paramView != null) {
        break label385;
      }
      paramView = null;
      if (paramView != null) {
        break label399;
      }
      i = 0;
      if (paramView != null) {
        break label407;
      }
      paramView = null;
      if (!(paramView instanceof b.b)) {
        break label430;
      }
      paramView = (b.b)paramView;
      if (paramView != null) {
        break label435;
      }
      i = j;
      locali.n("tab_id", Integer.valueOf(i));
      localcp = new cp();
      localcp.ixo = Util.nowMilliSecond();
      localcp.lV("");
      localcp.lW("");
      localcp.lX("");
      localcp.lY("");
      localObject = c.dLD().dHN();
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      localcp.lZ(paramView);
      if (localbui != null) {
        break label443;
      }
      paramView = "";
    }
    for (;;)
    {
      localcp.ma(paramView);
      localObject = com.tencent.mm.plugin.expt.hellhound.a.dIJ();
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      localcp.mb(paramView);
      localcp.mc("");
      localcp.md("");
      localcp.me("");
      localcp.mf("more_page_star_live");
      localcp.mg(locali.toString());
      localcp.bMH();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment$onCreateView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(370453);
      return;
      label385:
      paramView = (TabLayout)paramView.findViewById(f.d.EGE);
      break;
      label399:
      i = paramView.getSelectedTabPosition();
      break label169;
      label407:
      paramView = paramView.js(i);
      if (paramView == null)
      {
        paramView = null;
        break label175;
      }
      paramView = paramView.tag;
      break label175;
      label430:
      paramView = null;
      break label187;
      label435:
      i = paramView.idY;
      break label193;
      label443:
      localObject = localbui.zIO;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageFragment.a
 * JD-Core Version:    0.7.0.1
 */