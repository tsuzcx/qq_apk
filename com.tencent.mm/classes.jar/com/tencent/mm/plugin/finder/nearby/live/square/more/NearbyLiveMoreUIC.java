package com.tencent.mm.plugin.finder.nearby.live.square.more;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.live.b.a;
import com.tencent.mm.plugin.finder.nearby.live.b.b;
import com.tencent.mm.plugin.finder.nearby.live.e;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveMoreUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback;", "liveFriendsPresenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "livePostHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostForNearby;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class NearbyLiveMoreUIC
  extends UIComponent
{
  public static final a uRN;
  private f uRi;
  private com.tencent.mm.plugin.finder.nearby.live.d uRj;
  private e uRk;
  
  static
  {
    AppMethodBeat.i(249219);
    uRN = new a((byte)0);
    AppMethodBeat.o(249219);
  }
  
  public NearbyLiveMoreUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(249218);
    AppMethodBeat.o(249218);
  }
  
  public final int getLayoutId()
  {
    return 2131495825;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249211);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx();
    this.uRi = new f((Activity)getActivity());
    Object localObject = getActivity();
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(249211);
      throw paramBundle;
    }
    this.uRj = ((com.tencent.mm.plugin.finder.nearby.live.d)new a((MMActivity)localObject, paramBundle));
    localObject = getActivity();
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(249211);
      throw paramBundle;
    }
    localObject = (MMActivity)localObject;
    com.tencent.mm.plugin.finder.nearby.live.d locald = this.uRj;
    if (locald == null) {
      p.btv("liveFriendsPresenter");
    }
    this.uRk = ((e)new b((MMActivity)localObject, (b.a)locald, getRootView(), paramBundle));
    paramBundle = this.uRj;
    if (paramBundle == null) {
      p.btv("liveFriendsPresenter");
    }
    localObject = this.uRk;
    if (localObject == null) {
      p.btv("liveFriendsCallback");
    }
    paramBundle.a((b.b)localObject);
    AppMethodBeat.o(249211);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(249217);
    super.onDestroy();
    com.tencent.mm.plugin.finder.nearby.live.d locald = this.uRj;
    if (locald == null) {
      p.btv("liveFriendsPresenter");
    }
    if (locald != null)
    {
      locald.onDetach();
      AppMethodBeat.o(249217);
      return;
    }
    AppMethodBeat.o(249217);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(249216);
    super.onFinished();
    com.tencent.mm.plugin.finder.nearby.live.d locald = this.uRj;
    if (locald == null) {
      p.btv("liveFriendsPresenter");
    }
    if (locald != null)
    {
      locald.onFinishing();
      AppMethodBeat.o(249216);
      return;
    }
    AppMethodBeat.o(249216);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(249213);
    super.onPause();
    Log.i("NearbyLiveMoreUIC", "onPause()");
    Object localObject = k.vkd;
    localObject = this.uRk;
    if (localObject == null) {
      p.btv("liveFriendsCallback");
    }
    k.a(((e)localObject).getRecyclerView(), s.p.voA, "80", c.vjg, -100, -100);
    AppMethodBeat.o(249213);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(249212);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
    com.tencent.mm.plugin.finder.nearby.report.d.dlB();
    Log.i("NearbyLiveMoreUIC", "onResume()");
    localObject = k.vkd;
    localObject = this.uRk;
    if (localObject == null) {
      p.btv("liveFriendsCallback");
    }
    k.a(((e)localObject).getRecyclerView(), s.p.voA, "80", c.vjf, -100, -100);
    AppMethodBeat.o(249212);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249214);
    super.onUserVisibleFocused();
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J((kotlin.g.a.b)NearbyLiveMoreUIC.b.uRO);
    localObject = this.uRj;
    if (localObject == null) {
      p.btv("liveFriendsPresenter");
    }
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.nearby.live.d)localObject).onUserVisibleFocused();
      AppMethodBeat.o(249214);
      return;
    }
    AppMethodBeat.o(249214);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(249215);
    super.onUserVisibleUnFocused();
    if (this.uRj == null) {
      p.btv("liveFriendsPresenter");
    }
    AppMethodBeat.o(249215);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveMoreUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveMoreUIC
 * JD-Core Version:    0.7.0.1
 */