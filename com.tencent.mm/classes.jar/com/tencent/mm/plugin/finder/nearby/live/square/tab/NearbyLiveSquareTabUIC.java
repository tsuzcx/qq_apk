package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.live.b.a;
import com.tencent.mm.plugin.finder.nearby.live.b.b;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabViewCallback;", "liveFriendsPresenter", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabPresenter;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getLayoutId", "", "getTabInfo", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class NearbyLiveSquareTabUIC
  extends UIComponent
{
  public static final a uRT;
  private axj uQK;
  b uRR;
  private c uRS;
  
  static
  {
    AppMethodBeat.i(249250);
    uRT = new a((byte)0);
    AppMethodBeat.o(249250);
  }
  
  public NearbyLiveSquareTabUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(249249);
    AppMethodBeat.o(249249);
  }
  
  public final int getLayoutId()
  {
    return 2131495828;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(249243);
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    Object localObject2;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getByteArray("nearby_live_square_tab_info_key");
      if (paramBundle != null)
      {
        paramBundle = new axj().parseFrom(paramBundle);
        if (paramBundle == null)
        {
          paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveTabInfo");
          AppMethodBeat.o(249243);
          throw paramBundle;
        }
        paramBundle = (axj)paramBundle;
        this.uQK = paramBundle;
        localObject2 = new StringBuilder("onCreate(), tab:");
        axj localaxj = this.uQK;
        paramBundle = (Bundle)localObject1;
        if (localaxj != null) {
          paramBundle = localaxj.LHR;
        }
        Log.i("NearbyLiveSquareTabUIC", paramBundle);
        paramBundle = getFragment();
        if (paramBundle != null)
        {
          localObject1 = a.PRN;
          paramBundle = ((FinderReporterUIC)a.of(paramBundle).get(FinderReporterUIC.class)).dIx();
          if (paramBundle != null) {
            break label347;
          }
        }
        paramBundle = a.PRN;
        paramBundle = ((FinderReporterUIC)a.b(getActivity()).get(FinderReporterUIC.class)).dIx();
      }
    }
    label347:
    for (;;)
    {
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(249243);
        throw paramBundle;
        paramBundle = null;
        break;
      }
      localObject1 = (MMActivity)localObject1;
      localObject2 = getFragment();
      if (localObject2 == null) {
        p.hyc();
      }
      this.uRR = new b((MMActivity)localObject1, (Fragment)localObject2, paramBundle, this.uQK);
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(249243);
        throw paramBundle;
      }
      localObject1 = (MMActivity)localObject1;
      localObject2 = this.uRR;
      if (localObject2 == null) {
        p.btv("liveFriendsPresenter");
      }
      this.uRS = new c((MMActivity)localObject1, (b.a)localObject2, getRootView(), paramBundle);
      paramBundle = this.uRR;
      if (paramBundle == null) {
        p.btv("liveFriendsPresenter");
      }
      localObject1 = this.uRS;
      if (localObject1 == null) {
        p.btv("liveFriendsCallback");
      }
      paramBundle.a((b.b)localObject1);
      AppMethodBeat.o(249243);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(249248);
    super.onDestroy();
    StringBuilder localStringBuilder = new StringBuilder("onDestroy() tab:");
    Object localObject = this.uQK;
    if (localObject != null) {}
    for (localObject = ((axj)localObject).LHR;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = this.uRR;
      if (localObject == null) {
        p.btv("liveFriendsPresenter");
      }
      if (localObject != null) {
        ((b)localObject).onFinishing();
      }
      localObject = this.uRR;
      if (localObject == null) {
        p.btv("liveFriendsPresenter");
      }
      if (localObject == null) {
        break;
      }
      ((b)localObject).onDetach();
      AppMethodBeat.o(249248);
      return;
    }
    AppMethodBeat.o(249248);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(249245);
    super.onPause();
    StringBuilder localStringBuilder = new StringBuilder("onPause() tab:");
    Object localObject = this.uQK;
    if (localObject != null) {}
    for (localObject = ((axj)localObject).LHR;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = k.vkd;
      localObject = this.uRS;
      if (localObject == null) {
        p.btv("liveFriendsCallback");
      }
      k.a(((c)localObject).getRecyclerView(), s.p.voA, "80", com.tencent.mm.plugin.finder.report.live.c.vjg, -100, -100);
      AppMethodBeat.o(249245);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(249244);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder("onResume() tab:");
    Object localObject = this.uQK;
    if (localObject != null) {}
    for (localObject = ((axj)localObject).LHR;; localObject = null)
    {
      Log.i("NearbyLiveSquareTabUIC", (String)localObject);
      localObject = k.vkd;
      localObject = this.uRS;
      if (localObject == null) {
        p.btv("liveFriendsCallback");
      }
      k.a(((c)localObject).getRecyclerView(), s.p.voA, "80", com.tencent.mm.plugin.finder.report.live.c.vjf, -100, -100);
      AppMethodBeat.o(249244);
      return;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249246);
    super.onUserVisibleFocused();
    Object localObject = a.PRN;
    ((FinderVideoRecycler)a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J((kotlin.g.a.b)NearbyLiveSquareTabUIC.b.uRU);
    localObject = this.uRR;
    if (localObject == null) {
      p.btv("liveFriendsPresenter");
    }
    if (localObject != null)
    {
      ((b)localObject).onUserVisibleFocused();
      AppMethodBeat.o(249246);
      return;
    }
    AppMethodBeat.o(249246);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(249247);
    super.onUserVisibleUnFocused();
    if (this.uRR == null) {
      p.btv("liveFriendsPresenter");
    }
    AppMethodBeat.o(249247);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.NearbyLiveSquareTabUIC
 * JD-Core Version:    0.7.0.1
 */