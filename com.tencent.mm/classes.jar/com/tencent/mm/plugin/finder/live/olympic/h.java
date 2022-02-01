package com.tencent.mm.plugin.finder.live.olympic;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.d.a.a.a.b.b.b;
import com.tencent.d.a.a.a.b.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.olympic.loader.FinderLiveOlympicRunnerPannelLoader;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "haveLocationPermission", "", "getHaveLocationPermission", "()Z", "setHaveLocationPermission", "(Z)V", "haveRequestLocationPermission", "getHaveRequestLocationPermission", "setHaveRequestLocationPermission", "locationRefreshCallback", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "locationRefreshHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getLocationRefreshHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "locationRefreshHandler$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerPresenter;)V", "refreshCount", "", "getRefreshCount", "()I", "setRefreshCount", "(I)V", "checkLocationRefresh", "onCleared", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onUserVisibleFocused", "onUserVisibleUnFocused", "requestLocationPermission", "requestLocationPermissionForBoard", "withDialog", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends UIComponent
{
  public static final a CNZ;
  g.a CNN;
  private boolean COa;
  private boolean COb;
  private int COc;
  private final MTimerHandler.CallBack COd;
  private final j COe;
  
  static
  {
    AppMethodBeat.i(360632);
    CNZ = new a((byte)0);
    AppMethodBeat.o(360632);
  }
  
  public h(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(360519);
    this.COd = new h..ExternalSyntheticLambda2(this);
    this.COe = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(360519);
  }
  
  private static final void a(h paramh, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(360577);
    s.u(paramh, "this$0");
    paramDialogInterface.dismiss();
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramh.getContext());
    AppMethodBeat.o(360577);
  }
  
  private static final boolean a(h paramh)
  {
    AppMethodBeat.i(360567);
    s.u(paramh, "this$0");
    paramh.COc += 1;
    int i;
    label91:
    boolean bool;
    if (paramh.COc <= 6)
    {
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = ((g)com.tencent.mm.ui.component.k.cn(cn.class).cq(g.class)).dUh();
      if (((Number)((r)localObject).bsC).floatValue() == 0.0F)
      {
        i = 1;
        if (i != 0)
        {
          if (((Number)((r)localObject).bsD).floatValue() != 0.0F) {
            break label172;
          }
          i = 1;
          if (i != 0) {
            break label177;
          }
        }
        bool = true;
        label97:
        Log.i("FinderLiveOlympicRunnerUIC", "checkLocationRefresh time:" + paramh.COc + ", haveLocationInfo:" + bool);
        if (!bool) {
          break label182;
        }
        paramh.COc = 7;
        d.uiThread((kotlin.g.a.a)new b(paramh));
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label206;
      }
      AppMethodBeat.o(360567);
      return true;
      i = 0;
      break;
      label172:
      i = 0;
      break label91;
      label177:
      bool = false;
      break label97;
      label182:
      i = 0;
      continue;
      d.uiThread((kotlin.g.a.a)new c(paramh));
      i = 1;
    }
    label206:
    AppMethodBeat.o(360567);
    return false;
  }
  
  private static final void b(h paramh)
  {
    AppMethodBeat.i(360602);
    if (paramh.enC())
    {
      paramh.COa = true;
      g.a locala = paramh.CNN;
      if (locala != null) {
        locala.qO(false);
      }
      paramh = paramh.CNN;
      if (paramh != null)
      {
        paramh.j(true, 300L);
        AppMethodBeat.o(360602);
      }
    }
    else
    {
      paramh = paramh.CNN;
      if (paramh != null) {
        paramh.qO(true);
      }
    }
    AppMethodBeat.o(360602);
  }
  
  private final MTimerHandler enB()
  {
    AppMethodBeat.i(360529);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.COe.getValue();
    AppMethodBeat.o(360529);
    return localMTimerHandler;
  }
  
  private final boolean enC()
  {
    AppMethodBeat.i(360546);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().d(274436, null);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(360546);
      throw ((Throwable)localObject);
    }
    boolean bool2;
    boolean bool1;
    if (com.tencent.mm.au.b.OE((String)localObject))
    {
      bool2 = com.tencent.mm.pluginsdk.permission.b.s((Context)getContext(), "android.permission.ACCESS_FINE_LOCATION");
      bool1 = bool2;
      if (!bool2)
      {
        if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acXn, false)) {
          break label166;
        }
        com.tencent.mm.plugin.account.sdk.c.a.b((Context)getContext(), getContext().getString(p.h.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
        bool1 = bool2;
      }
    }
    Fragment localFragment;
    for (;;)
    {
      localObject = new StringBuilder("requestLocationPermission boardScene:");
      localFragment = getFragment();
      if (localFragment != null) {
        break;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.olympic.FinderLiveOlympicsRunnerFramgent");
      AppMethodBeat.o(360546);
      throw ((Throwable)localObject);
      label166:
      com.tencent.mm.pluginsdk.permission.b.b(getContext(), "android.permission.ACCESS_FINE_LOCATION", 1002);
      bool1 = bool2;
      continue;
      bool1 = com.tencent.mm.pluginsdk.permission.b.a(getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 1002, null);
    }
    Log.i("FinderLiveOlympicRunnerUIC", ((FinderLiveOlympicsRunnerFramgent)localFragment).CNG + " checkLocation:" + bool1);
    AppMethodBeat.o(360546);
    return bool1;
  }
  
  private static final void p(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(360589);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(360589);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(360711);
    super.onCleared();
    Log.printInfoStack("FinderLiveOlympicRunnerUIC", "onCleared" + hashCode() + '!', new Object[0]);
    AppMethodBeat.o(360711);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    View localView = null;
    AppMethodBeat.i(360679);
    super.onCreate(paramBundle);
    this.COa = false;
    this.COb = false;
    paramBundle = getFragment();
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.olympic.FinderLiveOlympicsRunnerFramgent");
      AppMethodBeat.o(360679);
      throw paramBundle;
    }
    int i = ((FinderLiveOlympicsRunnerFramgent)paramBundle).CNG;
    Log.i("FinderLiveOlympicRunnerUIC", "onCreate " + hashCode() + " boardScene:" + i + '!');
    paramBundle = getFragment();
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.olympic.FinderLiveOlympicsRunnerFramgent");
      AppMethodBeat.o(360679);
      throw paramBundle;
    }
    paramBundle = ((FinderLiveOlympicsRunnerFramgent)paramBundle).COJ;
    Object localObject = getFragment();
    if (localObject == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.olympic.FinderLiveOlympicsRunnerFramgent");
      AppMethodBeat.o(360679);
      throw paramBundle;
    }
    this.CNN = new g.a(i, paramBundle, (BaseFeedLoader)new FinderLiveOlympicRunnerPannelLoader(((FinderLiveOlympicsRunnerFramgent)localObject).COJ), (kotlin.g.a.a)new e(this));
    paramBundle = getFragment();
    label230:
    boolean bool;
    if (paramBundle == null)
    {
      paramBundle = null;
      localObject = getFragment();
      if (localObject != null) {
        break label355;
      }
      localObject = this.CNN;
      if ((paramBundle == null) || (localView == null) || (localObject == null)) {
        break label383;
      }
      ((g.a)localObject).a(new g.b(paramBundle, (g.a)localObject, localView));
      paramBundle = b.b.ahnZ;
      if (i != b.b.a.jVT()) {
        break label374;
      }
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      bool = ((g)com.tencent.mm.ui.component.k.cn(cn.class).cq(g.class)).dUi();
      if (!bool) {
        break label365;
      }
      this.COa = true;
      ((g.a)localObject).qO(false);
      ((g.a)localObject).j(true, 300L);
    }
    for (;;)
    {
      Log.i("FinderLiveOlympicRunnerUIC", s.X("havePermission locationPermission:", Boolean.valueOf(bool)));
      AppMethodBeat.o(360679);
      return;
      paramBundle = paramBundle.getContext();
      break;
      label355:
      localView = ((Fragment)localObject).getView();
      break label230;
      label365:
      ((g.a)localObject).qO(true);
    }
    label374:
    ((g.a)localObject).j(true, 300L);
    label383:
    AppMethodBeat.o(360679);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(360733);
    super.onDestroy();
    Log.i("FinderLiveOlympicRunnerUIC", "onDestroy" + hashCode() + '!');
    enB().stopTimer();
    g.a locala = this.CNN;
    if (locala != null) {
      locala.onDetach();
    }
    this.CNN = null;
    AppMethodBeat.o(360733);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(360725);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    paramArrayOfString = getFragment();
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.olympic.FinderLiveOlympicsRunnerFramgent");
      AppMethodBeat.o(360725);
      throw paramArrayOfString;
    }
    int i = ((FinderLiveOlympicsRunnerFramgent)paramArrayOfString).CNG;
    Log.i("FinderLiveOlympicRunnerUIC", "onRequestPermissionsResult boardScene:" + i + ", requestCode:" + paramInt + " grantResults[0]:" + paramArrayOfInt[0]);
    paramArrayOfString = b.b.ahnZ;
    if (i != b.b.a.jVT())
    {
      AppMethodBeat.o(360725);
      return;
    }
    if (paramInt == 1002)
    {
      if (paramArrayOfInt[0] == 0)
      {
        this.COa = true;
        Log.i("FinderLiveOlympicRunnerUIC", "onRequestPermissionsResult return for grant.");
        paramArrayOfString = com.tencent.mm.ui.component.k.aeZF;
        ((g)com.tencent.mm.ui.component.k.cn(cn.class).cq(g.class)).pH(false);
        paramArrayOfString = this.CNN;
        if (paramArrayOfString != null) {
          paramArrayOfString.qO(false);
        }
        paramArrayOfString = this.CNN;
        if (paramArrayOfString != null) {
          paramArrayOfString.enw().pZ(true);
        }
        this.COc = 0;
        enB().startTimer(1000L);
        AppMethodBeat.o(360725);
        return;
      }
      paramArrayOfString = this.CNN;
      if (paramArrayOfString != null) {
        paramArrayOfString.qO(true);
      }
      Log.i("FinderLiveOlympicRunnerUIC", "onRequestPermissionsResult return for unGrant.");
      com.tencent.mm.ui.base.k.a((Context)getContext(), getContext().getString(p.h.permission_location_request_again_msg), "", getContext().getString(p.h.jump_to_settings), getContext().getString(p.h.permission_cancel), false, new h..ExternalSyntheticLambda0(this), h..ExternalSyntheticLambda1.INSTANCE);
    }
    AppMethodBeat.o(360725);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(360691);
    super.onUserVisibleFocused();
    Object localObject = getFragment();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.olympic.FinderLiveOlympicsRunnerFramgent");
      AppMethodBeat.o(360691);
      throw ((Throwable)localObject);
    }
    int i = ((FinderLiveOlympicsRunnerFramgent)localObject).CNG;
    Log.i("FinderLiveOlympicRunnerUIC", "onUserVisibleFocused" + hashCode() + ",boardScene:" + i + ",haveLocationPermission:" + this.COa + ",haveRequestLocationPermission:" + this.COb + '!');
    localObject = b.b.ahnZ;
    if ((i == b.b.a.jVT()) && (!this.COa) && (!this.COb))
    {
      this.COb = true;
      b(this);
    }
    AppMethodBeat.o(360691);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(360701);
    super.onUserVisibleUnFocused();
    Object localObject = getFragment();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.olympic.FinderLiveOlympicsRunnerFramgent");
      AppMethodBeat.o(360701);
      throw ((Throwable)localObject);
    }
    int i = ((FinderLiveOlympicsRunnerFramgent)localObject).CNG;
    Log.i("FinderLiveOlympicRunnerUIC", "onUserVisibleUnFocused" + hashCode() + ",boardScene:" + i + ",haveLocationPermission:" + this.COa + ",haveRequestLocationPermission:" + this.COb + '!');
    AppMethodBeat.o(360701);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerUIC$Companion;", "", "()V", "REFRESH_COUNT", "", "REFRESH_INTERVAL", "", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MTimerHandler>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.h
 * JD-Core Version:    0.7.0.1
 */