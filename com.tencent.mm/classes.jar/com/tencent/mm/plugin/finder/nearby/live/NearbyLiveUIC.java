package com.tencent.mm.plugin.finder.nearby.live;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "liveFriendsCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback;", "liveFriendsPresenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "livePostHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostForNearby;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onMenuClick", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class NearbyLiveUIC
  extends UIComponent
{
  public static final a uRl;
  f uRi;
  d uRj;
  private e uRk;
  
  static
  {
    AppMethodBeat.i(249112);
    uRl = new a((byte)0);
    AppMethodBeat.o(249112);
  }
  
  public NearbyLiveUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(249111);
    AppMethodBeat.o(249111);
  }
  
  public NearbyLiveUIC(MMFragmentActivity paramMMFragmentActivity)
  {
    super((AppCompatActivity)paramMMFragmentActivity);
    AppMethodBeat.i(249110);
    AppMethodBeat.o(249110);
  }
  
  public final int getLayoutId()
  {
    return 2131495831;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(249105);
    f localf = this.uRi;
    if (localf == null) {
      p.btv("livePostHelper");
    }
    localf.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(249105);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249101);
    super.onCreate(paramBundle);
    paramBundle = getFragment();
    Object localObject;
    if (paramBundle != null)
    {
      localObject = a.PRN;
      paramBundle = ((FinderReporterUIC)a.of(paramBundle).get(FinderReporterUIC.class)).dIx();
      if (paramBundle != null) {}
    }
    else
    {
      paramBundle = a.PRN;
      paramBundle = ((FinderReporterUIC)a.b(getActivity()).get(FinderReporterUIC.class)).dIx();
    }
    for (;;)
    {
      this.uRi = new f((Activity)getActivity());
      localObject = getActivity();
      if (localObject == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(249101);
        throw paramBundle;
      }
      this.uRj = new d((MMActivity)localObject, paramBundle);
      localObject = getActivity();
      if (localObject == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(249101);
        throw paramBundle;
      }
      localObject = (MMActivity)localObject;
      d locald = this.uRj;
      if (locald == null) {
        p.btv("liveFriendsPresenter");
      }
      this.uRk = new e((MMActivity)localObject, (b.a)locald, getRootView(), paramBundle);
      paramBundle = this.uRj;
      if (paramBundle == null) {
        p.btv("liveFriendsPresenter");
      }
      localObject = this.uRk;
      if (localObject == null) {
        p.btv("liveFriendsCallback");
      }
      paramBundle.a((b.b)localObject);
      AppMethodBeat.o(249101);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(249109);
    super.onDestroy();
    Object localObject = this.uRj;
    if (localObject == null) {
      p.btv("liveFriendsPresenter");
    }
    if (localObject != null) {
      ((d)localObject).onDetach();
    }
    localObject = this.uRi;
    if (localObject == null) {
      p.btv("livePostHelper");
    }
    if (localObject != null)
    {
      Log.i("Finder.FinderLivePostForNearby", "release()");
      ((f)localObject).reset();
      g.azz().b(5231, (i)localObject);
      g.azz().b(3761, (i)localObject);
      ((f)localObject).vKL = null;
      ((f)localObject).vKM = null;
      ((f)localObject).uiv = null;
      ((f)localObject).vKN = null;
      AppMethodBeat.o(249109);
      return;
    }
    AppMethodBeat.o(249109);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(249108);
    super.onFinished();
    d locald = this.uRj;
    if (locald == null) {
      p.btv("liveFriendsPresenter");
    }
    if (locald != null)
    {
      locald.onFinishing();
      AppMethodBeat.o(249108);
      return;
    }
    AppMethodBeat.o(249108);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(249103);
    super.onPause();
    Object localObject = this.uRi;
    if (localObject == null) {
      p.btv("livePostHelper");
    }
    if (localObject != null) {
      ((f)localObject).reset();
    }
    localObject = k.vkd;
    localObject = this.uRk;
    if (localObject == null) {
      p.btv("liveFriendsCallback");
    }
    k.a(((e)localObject).getRecyclerView(), s.p.voA, "94", c.vjg, -100, -100);
    AppMethodBeat.o(249103);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(249106);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    f localf = this.uRi;
    if (localf == null) {
      p.btv("livePostHelper");
    }
    localf.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(249106);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(249102);
    super.onResume();
    Object localObject = k.vkd;
    localObject = this.uRk;
    if (localObject == null) {
      p.btv("liveFriendsCallback");
    }
    k.a(((e)localObject).getRecyclerView(), s.p.voA, "94", c.vjf, -100, -100);
    AppMethodBeat.o(249102);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249104);
    super.onUserVisibleFocused();
    Object localObject = this.uRj;
    if (localObject == null) {
      p.btv("liveFriendsPresenter");
    }
    if (localObject != null) {
      ((d)localObject).onUserVisibleFocused();
    }
    localObject = a.PRN;
    ((FinderVideoRecycler)a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J((b)NearbyLiveUIC.b.uRm);
    AppMethodBeat.o(249104);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(249107);
    super.onUserVisibleUnFocused();
    if (this.uRj == null) {
      p.btv("liveFriendsPresenter");
    }
    AppMethodBeat.o(249107);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.NearbyLiveUIC
 * JD-Core Version:    0.7.0.1
 */