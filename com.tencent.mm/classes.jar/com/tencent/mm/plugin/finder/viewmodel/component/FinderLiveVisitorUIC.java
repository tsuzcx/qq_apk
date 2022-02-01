package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.c.a;
import com.tencent.mm.plugin.finder.live.c.b;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.j;
import com.tencent.mm.plugin.finder.live.view.j.a;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.ba;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveVisitorUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "activeFinish", "", "callOnce", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "isKeyBoardShow", "isPaused", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "lastKeyBoardHeight", "", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "unInitTask", "Ljava/lang/Runnable;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "window", "Landroid/view/Window;", "kotlin.jvm.PlatformType", "getWindow", "()Landroid/view/Window;", "window$delegate", "Lkotlin/Lazy;", "getLayoutId", "getViewCallback", "initBusiness", "", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "uninitBusiness", "uninitBusinessCheck", "Companion", "plugin-finder_release"})
public class FinderLiveVisitorUIC
  extends UIComponent
{
  public static final a wyD;
  private h gyh;
  private int hgz;
  private boolean hwq;
  private boolean isPaused;
  private com.tencent.mm.plugin.finder.live.d ubD;
  private FinderLiveViewCallback ubE;
  private j ubm;
  private Runnable vPT;
  private boolean vPU;
  private boolean vPV;
  private final kotlin.f wyC;
  
  static
  {
    AppMethodBeat.i(255820);
    wyD = new a((byte)0);
    AppMethodBeat.o(255820);
  }
  
  public FinderLiveVisitorUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255819);
    this.wyC = kotlin.g.ah((a)new d(this));
    AppMethodBeat.o(255819);
  }
  
  private final void dAn()
  {
    AppMethodBeat.i(255815);
    if (this.vPV)
    {
      AppMethodBeat.o(255815);
      return;
    }
    dei();
    this.vPV = true;
    AppMethodBeat.o(255815);
  }
  
  private final void dei()
  {
    AppMethodBeat.i(255818);
    Log.i("Finder.FinderLiveVisitorUIC", "uninitBusiness");
    FinderLiveViewCallback localFinderLiveViewCallback = this.ubE;
    if (localFinderLiveViewCallback != null)
    {
      localFinderLiveViewCallback.deR();
      AppMethodBeat.o(255818);
      return;
    }
    AppMethodBeat.o(255818);
  }
  
  private Window getWindow()
  {
    AppMethodBeat.i(255803);
    Window localWindow = (Window)this.wyC.getValue();
    AppMethodBeat.o(255803);
    return localWindow;
  }
  
  public int getLayoutId()
  {
    return 2131494454;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(255814);
    Object localObject = this.ubE;
    if (localObject != null) {
      ((FinderLiveViewCallback)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1005)
      {
        localObject = new ArrayList();
        if (paramIntent != null)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          p.g(localObject, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
        }
        if (!((Collection)localObject).isEmpty()) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label243;
          }
          localObject = ((ArrayList)localObject).iterator();
          String str;
          for (paramIntent = ""; ((Iterator)localObject).hasNext(); paramIntent = paramIntent + str + ';') {
            str = (String)((Iterator)localObject).next();
          }
        }
        localObject = paramIntent;
        if (n.K(paramIntent, ";", false))
        {
          paramInt1 = paramIntent.length();
          if (paramIntent == null)
          {
            paramIntent = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(255814);
            throw paramIntent;
          }
          localObject = paramIntent.substring(0, paramInt1 - 1);
          p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        paramIntent = m.vli;
        m.a((String)localObject, s.ba.vsY);
        AppMethodBeat.o(255814);
        return;
      }
      if (paramInt1 == 1006)
      {
        paramIntent = m.vli;
        m.a(null, s.ba.vsZ);
      }
    }
    label243:
    AppMethodBeat.o(255814);
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(255812);
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onBackPressed ".concat(String.valueOf(this)));
    FinderLiveViewCallback localFinderLiveViewCallback = this.ubE;
    if (localFinderLiveViewCallback != null)
    {
      boolean bool = localFinderLiveViewCallback.onBackPressed();
      AppMethodBeat.o(255812);
      return bool;
    }
    AppMethodBeat.o(255812);
    return false;
  }
  
  public void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(255816);
    super.onBeforeFinish(paramIntent);
    if (this.isPaused) {
      dei();
    }
    for (;;)
    {
      this.vPU = true;
      AppMethodBeat.o(255816);
      return;
      this.vPT = ((Runnable)new b(this));
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(255817);
    p.h(paramConfiguration, "newConfig");
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onConfigurationChanged orientation:" + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(255817);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255804);
    super.onCreate(paramBundle);
    if ((getActivity() instanceof MMActivity))
    {
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255804);
        throw paramBundle;
      }
      ((MMActivity)paramBundle).setSelfNavigationBarVisible(8);
    }
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    Object localObject1;
    boolean bool2;
    long l;
    label299:
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(1024);
      getWindow().clearFlags(512);
      getWindow().clearFlags(67108864);
      paramBundle = getContext().getResources();
      p.g(paramBundle, "context.resources");
      if (paramBundle.getConfiguration().orientation == 2)
      {
        paramBundle = getWindow();
        p.g(paramBundle, "window");
        paramBundle = paramBundle.getDecorView();
        p.g(paramBundle, "window.decorView");
        paramBundle.setSystemUiVisibility(7942);
        getWindow().addFlags(1024);
        getWindow().addFlags(-2147483648);
        paramBundle = getWindow();
        p.g(paramBundle, "window");
        paramBundle.setStatusBarColor(0);
        paramBundle = getWindow();
        p.g(paramBundle, "window");
        paramBundle.setNavigationBarColor(0);
      }
    }
    else
    {
      getWindow().setFormat(-3);
      getWindow().setSoftInputMode(51);
      localObject1 = (FinderLiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
      bool2 = getIntent().getBooleanExtra("KEY_PARAMS_RESET_LIVE", false);
      paramBundle = o.ujN;
      paramBundle = o.dfZ();
      if (paramBundle == null) {
        break label536;
      }
      paramBundle = paramBundle.liveInfo;
      if (paramBundle == null) {
        break label536;
      }
      l = paramBundle.liveId;
      paramBundle = new StringBuilder("[LiveLifecycle] onCreate comeFromReset:").append(bool2).append(",configProvider is null:");
      if (localObject1 != null) {
        break label542;
      }
      bool1 = true;
      label327:
      localObject2 = paramBundle.append(bool1).append(",config liveId:");
      if (localObject1 == null) {
        break label547;
      }
      paramBundle = ((FinderLiveConfig)localObject1).dfu();
      if (paramBundle == null) {
        break label547;
      }
    }
    label536:
    label542:
    label547:
    for (paramBundle = Long.valueOf(paramBundle.getLiveId());; paramBundle = null)
    {
      Log.i("Finder.FinderLiveVisitorUIC", paramBundle + ", across_live " + l);
      if (localObject1 == null) {
        break label651;
      }
      paramBundle = ((FinderLiveConfig)localObject1).dfu();
      if (((paramBundle != null) && (paramBundle.getLiveId() == l)) || (bool2)) {
        break label651;
      }
      paramBundle = o.ujN;
      paramBundle = new com.tencent.mm.plugin.finder.live.viewmodel.d();
      paramBundle.a((FinderLiveConfig)localObject1);
      o.b(paramBundle);
      this.ubD = new com.tencent.mm.plugin.finder.live.d();
      paramBundle = getRootView().findViewById(2131301253);
      p.g(paramBundle, "rootView.findViewById(R.id.finder_live_rf)");
      localObject1 = (RefreshLoadMoreLayout)paramBundle;
      paramBundle = getActivity();
      if (paramBundle != null) {
        break label552;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255804);
      throw paramBundle;
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.g(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      break;
      l = 0L;
      break label299;
      bool1 = false;
      break label327;
    }
    label552:
    Object localObject2 = (MMActivity)paramBundle;
    paramBundle = getFragment();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getLifecycle();
      paramBundle = new FinderLiveViewCallback((RefreshLoadMoreLayout)localObject1, (MMActivity)localObject2, paramBundle, (c.a)this.ubD, false);
      localObject1 = this.ubD;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.d)localObject1).a((c.b)paramBundle);
      }
      this.ubE = paramBundle;
    }
    for (;;)
    {
      paramBundle = getActivity();
      if (paramBundle != null) {
        break label860;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255804);
      throw paramBundle;
      paramBundle = null;
      break;
      label651:
      if (l != 0L)
      {
        paramBundle = o.ujN;
        paramBundle = o.dfY();
        if (paramBundle != null)
        {
          localObject1 = o.ujN;
          paramBundle.Jq(o.dga());
        }
        this.ubD = new com.tencent.mm.plugin.finder.live.d();
        paramBundle = getRootView().findViewById(2131301253);
        p.g(paramBundle, "rootView.findViewById(R.id.finder_live_rf)");
        localObject1 = (RefreshLoadMoreLayout)paramBundle;
        paramBundle = getActivity();
        if (paramBundle == null)
        {
          paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(255804);
          throw paramBundle;
        }
        localObject2 = (MMActivity)paramBundle;
        paramBundle = getFragment();
        if (paramBundle != null) {}
        for (paramBundle = paramBundle.getLifecycle();; paramBundle = null)
        {
          paramBundle = new FinderLiveViewCallback((RefreshLoadMoreLayout)localObject1, (MMActivity)localObject2, paramBundle, (c.a)this.ubD, true);
          localObject1 = this.ubD;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.d)localObject1).a((c.b)paramBundle);
          }
          this.ubE = paramBundle;
          break;
        }
      }
      f.a.a(c.vVc, "liveVisitorUIParamsInvalid", false, false, null, 28);
      Log.i("Finder.FinderLiveVisitorUIC", "onCreate err stack:" + Util.getStack());
    }
    label860:
    this.ubm = new j((com.tencent.mm.plugin.ball.a.f)new e((Activity)paramBundle));
    paramBundle = this.ubm;
    if (paramBundle != null)
    {
      paramBundle.G(21, b.cjf());
      AppMethodBeat.o(255804);
      return;
    }
    AppMethodBeat.o(255804);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(255811);
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onDestroy ".concat(String.valueOf(this)));
    super.onDestroy();
    if (!this.vPU) {
      dAn();
    }
    Object localObject = this.ubD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.d)localObject).onDetach();
    }
    localObject = this.ubm;
    if (localObject != null)
    {
      ((j)localObject).onDestroy();
      AppMethodBeat.o(255811);
      return;
    }
    AppMethodBeat.o(255811);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(255813);
    super.onNewIntent(paramIntent);
    FinderLiveViewCallback localFinderLiveViewCallback = this.ubE;
    if (localFinderLiveViewCallback != null)
    {
      localFinderLiveViewCallback.onNewIntent(paramIntent);
      AppMethodBeat.o(255813);
      return;
    }
    AppMethodBeat.o(255813);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(255809);
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onPause " + this + ", " + this.vPT);
    super.onPause();
    this.isPaused = true;
    Object localObject = this.gyh;
    if (localObject != null) {
      ((h)localObject).close();
    }
    localObject = this.vPT;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    this.vPT = null;
    AppMethodBeat.o(255809);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    com.tencent.mm.plugin.finder.live.d locald = null;
    AppMethodBeat.i(255806);
    super.onRestoreInstanceState(paramBundle);
    Object localObject1;
    if (paramBundle != null)
    {
      paramBundle = (FinderLiveConfig)paramBundle.getParcelable("KEY_PARAMS_CONFIG");
      localObject1 = (FinderLiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
      localObject2 = o.ujN;
      localObject2 = o.dfZ();
      if (localObject2 == null) {
        break label259;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject2).liveInfo;
      if (localObject2 == null) {
        break label259;
      }
    }
    label259:
    for (long l = ((awe)localObject2).liveId;; l = 0L)
    {
      Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle] onRestoreInstanceState " + this + " configProvider:" + localObject1 + " restoreConfigProvider:" + paramBundle + " curLiveId:" + l);
      if ((localObject1 != null) || (l != 0L) || (paramBundle == null)) {
        break label336;
      }
      localObject1 = paramBundle.dfu();
      if ((localObject1 != null) && (((LiveConfig)localObject1).getLiveId() == 0L)) {
        break label336;
      }
      localObject1 = o.ujN;
      localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.d();
      ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject1).a(paramBundle);
      o.b((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject1);
      this.ubD = new com.tencent.mm.plugin.finder.live.d();
      paramBundle = getRootView().findViewById(2131301253);
      p.g(paramBundle, "rootView.findViewById(R.id.finder_live_rf)");
      localObject1 = (RefreshLoadMoreLayout)paramBundle;
      paramBundle = getActivity();
      if (paramBundle != null) {
        break label264;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255806);
      throw paramBundle;
      paramBundle = null;
      break;
    }
    label264:
    Object localObject2 = (MMActivity)paramBundle;
    Fragment localFragment = getFragment();
    paramBundle = locald;
    if (localFragment != null) {
      paramBundle = localFragment.getLifecycle();
    }
    paramBundle = new FinderLiveViewCallback((RefreshLoadMoreLayout)localObject1, (MMActivity)localObject2, paramBundle, (c.a)this.ubD, false);
    locald = this.ubD;
    if (locald != null) {
      locald.a((c.b)paramBundle);
    }
    this.ubE = paramBundle;
    label336:
    AppMethodBeat.o(255806);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(255808);
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onResume " + this + ',');
    super.onResume();
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(255808);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null) {
        ((View)localObject).post((Runnable)new c(this));
      }
    }
    Log.i("Finder.FinderLiveVisitorUIC", "initBusiness");
    localObject = this.ubE;
    if (localObject != null)
    {
      ((FinderLiveViewCallback)localObject).MC();
      AppMethodBeat.o(255808);
      return;
    }
    AppMethodBeat.o(255808);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(255805);
    super.onSaveInstanceState(paramBundle);
    Object localObject1 = new StringBuilder("[LiveLifecycle] onSaveInstanceState ").append(this).append(" curData:");
    Object localObject2 = o.ujN;
    Log.i("Finder.FinderLiveVisitorUIC", o.dfZ());
    localObject1 = o.ujN;
    localObject1 = o.dfZ();
    if (localObject1 != null)
    {
      localObject1 = new LiveConfig.a().qo(LiveConfig.hvU).zt(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo.liveId).Gd(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).hwg).zu(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).hFK).Gg(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).hwd).Gh(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).desc).aBR();
      p.g(localObject1, "builder.toWhere(LiveConf…\n                .build()");
      localObject2 = new FinderLiveConfig();
      ((FinderLiveConfig)localObject2).uiu.add(localObject1);
      if (paramBundle != null)
      {
        paramBundle.putParcelable("KEY_PARAMS_CONFIG", (Parcelable)localObject2);
        AppMethodBeat.o(255805);
        return;
      }
      AppMethodBeat.o(255805);
      return;
    }
    AppMethodBeat.o(255805);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(255807);
    Object localObject = new StringBuilder("[LiveLifecycle]onStart ").append(this).append(", activateUIKey:");
    j.a locala = j.uzS;
    Log.i("Finder.FinderLiveVisitorUIC", j.diD());
    super.onStart();
    localObject = j.uzS;
    j.atR(toString());
    localObject = this.ubm;
    if (localObject != null) {
      ((j)localObject).aGf();
    }
    com.tencent.mm.plugin.ball.f.f.cjk();
    AppMethodBeat.o(255807);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(255810);
    Object localObject = new StringBuilder("[LiveLifecycle]onStop ").append(this).append(", activateUIKey:");
    j.a locala = j.uzS;
    Log.i("Finder.FinderLiveVisitorUIC", j.diD());
    super.onStop();
    localObject = toString();
    locala = j.uzS;
    if (Util.isEqual((String)localObject, j.diD()))
    {
      localObject = o.ujN;
      localObject = o.dfZ();
      if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDS)) {
        break label112;
      }
      localObject = this.ubm;
      if (localObject != null) {
        ((j)localObject).nA(true);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.ball.f.f.cji();
      AppMethodBeat.o(255810);
      return;
      label112:
      localObject = this.ubm;
      if (localObject != null) {
        ((j)localObject).nA(false);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveVisitorUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderLiveVisitorUIC paramFinderLiveVisitorUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255799);
      FinderLiveVisitorUIC.b(this.wyE);
      AppMethodBeat.o(255799);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderLiveVisitorUIC paramFinderLiveVisitorUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255801);
      if (FinderLiveVisitorUIC.a(this.wyE) == null)
      {
        localObject = this.wyE;
        Activity localActivity = this.wyE.getContext();
        if (localActivity == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(255801);
          throw ((Throwable)localObject);
        }
        FinderLiveVisitorUIC.a((FinderLiveVisitorUIC)localObject, new h(localActivity));
        localObject = FinderLiveVisitorUIC.a(this.wyE);
        if (localObject != null) {
          ((h)localObject).setKeyboardHeightObserver((com.tencent.mm.ui.tools.g)new com.tencent.mm.ui.tools.g()
          {
            public final void y(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(255800);
              Log.i("Finder.FinderLiveVisitorUIC", "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              FinderLiveVisitorUIC localFinderLiveVisitorUIC = this.wyF.wyE;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                FinderLiveVisitorUIC.a(localFinderLiveVisitorUIC, paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(255800);
                return;
              }
            }
          });
        }
      }
      Object localObject = FinderLiveVisitorUIC.a(this.wyE);
      if (localObject != null)
      {
        ((h)localObject).start();
        AppMethodBeat.o(255801);
        return;
      }
      AppMethodBeat.o(255801);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/Window;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements a<Window>
  {
    d(FinderLiveVisitorUIC paramFinderLiveVisitorUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveVisitorUIC
 * JD-Core Version:    0.7.0.1
 */