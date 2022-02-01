package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.core.core.c.a.a;
import com.tencent.mm.live.core.core.d;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.c.a;
import com.tencent.mm.plugin.finder.live.c.b;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bo;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveVisitorUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activeFinish", "", "callOnce", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "isKeyBoardShow", "isPaused", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "lastKeyBoardHeight", "", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "unInitTask", "Ljava/lang/Runnable;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "window", "Landroid/view/Window;", "kotlin.jvm.PlatformType", "getWindow", "()Landroid/view/Window;", "window$delegate", "Lkotlin/Lazy;", "getLayoutId", "getViewCallback", "initBusiness", "", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "tryHideFloatBallWhenEnterPage", "tryShowFloatBallWhenExitPage", "unInitBusiness", "unInitBusinessCheck", "Companion", "plugin-finder_release"})
public class g
  extends UIComponent
{
  public static final a zen;
  private boolean isPaused;
  private int jSt;
  private i jij;
  private boolean kiD;
  private com.tencent.mm.plugin.finder.live.view.f xOE;
  private FinderLiveViewCallback xUK;
  private boolean xZp;
  private Runnable xZq;
  private boolean xZr;
  private com.tencent.mm.plugin.finder.live.j zel;
  private final kotlin.f zem;
  
  static
  {
    AppMethodBeat.i(277114);
    zen = new a((byte)0);
    AppMethodBeat.o(277114);
  }
  
  public g(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(277113);
    this.zem = kotlin.g.ar((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(277113);
  }
  
  private final void dGA()
  {
    AppMethodBeat.i(277111);
    Log.i("Finder.FinderLiveVisitorUIC", "uninitBusiness");
    FinderLiveViewCallback localFinderLiveViewCallback = this.xUK;
    if (localFinderLiveViewCallback != null)
    {
      localFinderLiveViewCallback.dwK();
      AppMethodBeat.o(277111);
      return;
    }
    AppMethodBeat.o(277111);
  }
  
  private final void dGz()
  {
    AppMethodBeat.i(277105);
    if (this.xZr)
    {
      AppMethodBeat.o(277105);
      return;
    }
    dGA();
    this.xZr = true;
    AppMethodBeat.o(277105);
  }
  
  private Window getWindow()
  {
    AppMethodBeat.i(277091);
    Window localWindow = (Window)this.zem.getValue();
    AppMethodBeat.o(277091);
    return localWindow;
  }
  
  public final void dxh()
  {
    AppMethodBeat.i(277100);
    Object localObject = toString();
    com.tencent.mm.plugin.finder.live.view.f.a locala = com.tencent.mm.plugin.finder.live.view.f.yVy;
    if (Util.isEqual((String)localObject, com.tencent.mm.plugin.finder.live.view.f.dFl()))
    {
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
      if (localObject == null) {
        break label80;
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfn)) {
        break label85;
      }
      localObject = this.xOE;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.f)localObject).pv(true);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.ball.f.f.cwA();
      AppMethodBeat.o(277100);
      return;
      label80:
      localObject = null;
      break;
      label85:
      localObject = this.xOE;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.f)localObject).pv(false);
      }
    }
  }
  
  public final void dxk()
  {
    AppMethodBeat.i(277096);
    Object localObject = com.tencent.mm.plugin.finder.live.view.f.yVy;
    com.tencent.mm.plugin.finder.live.view.f.aCV(toString());
    localObject = this.xOE;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).aOf();
    }
    com.tencent.mm.plugin.ball.f.f.cvI();
    AppMethodBeat.o(277096);
  }
  
  public int getLayoutId()
  {
    return b.g.finder_live_root;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(277104);
    Object localObject = this.xUK;
    if (localObject != null)
    {
      localObject = ((FinderLiveViewCallback)localObject).xUG.xWt;
      if (localObject != null) {
        ((FinderLiveVisitorPluginLayout)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1005)
      {
        localObject = new ArrayList();
        if (paramIntent != null)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          p.j(localObject, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
        }
        if (!((Collection)localObject).isEmpty()) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label261;
          }
          localObject = ((ArrayList)localObject).iterator();
          String str;
          for (paramIntent = ""; ((Iterator)localObject).hasNext(); paramIntent = paramIntent + str + ';') {
            str = (String)((Iterator)localObject).next();
          }
        }
        localObject = paramIntent;
        if (n.pu(paramIntent, ";"))
        {
          paramInt1 = paramIntent.length();
          if (paramIntent == null)
          {
            paramIntent = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(277104);
            throw paramIntent;
          }
          localObject = paramIntent.substring(0, paramInt1 - 1);
          p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        m.yCt.a((String)localObject, s.bo.yNf);
        AppMethodBeat.o(277104);
        return;
      }
      if (paramInt1 == 1006) {
        m.yCt.a(null, s.bo.yNg);
      }
    }
    label261:
    AppMethodBeat.o(277104);
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(277102);
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onBackPressed ".concat(String.valueOf(this)));
    Object localObject = this.xUK;
    if (localObject != null)
    {
      localObject = ((FinderLiveViewCallback)localObject).xUG.xWt;
      if (localObject != null)
      {
        boolean bool = ((FinderLiveVisitorPluginLayout)localObject).onBackPress();
        AppMethodBeat.o(277102);
        return bool;
      }
      AppMethodBeat.o(277102);
      return false;
    }
    AppMethodBeat.o(277102);
    return false;
  }
  
  public void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(277106);
    super.onBeforeFinish(paramIntent);
    if (this.isPaused) {
      dGA();
    }
    for (;;)
    {
      this.xZp = true;
      AppMethodBeat.o(277106);
      return;
      this.xZq = ((Runnable)new b(this));
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(277108);
    p.k(paramConfiguration, "newConfig");
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onConfigurationChanged orientation:" + paramConfiguration.orientation);
    super.onConfigurationChanged(paramConfiguration);
    Object localObject = this.xUK;
    if (localObject != null)
    {
      p.k(paramConfiguration, "newConfig");
      localObject = ((FinderLiveViewCallback)localObject).xUG.xWt;
      if (localObject != null)
      {
        ((FinderLiveVisitorPluginLayout)localObject).onConfigurationChanged(paramConfiguration);
        AppMethodBeat.o(277108);
        return;
      }
      AppMethodBeat.o(277108);
      return;
    }
    AppMethodBeat.o(277108);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277092);
    super.onCreate(paramBundle);
    if ((getActivity() instanceof MMActivity))
    {
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(277092);
        throw paramBundle;
      }
      ((MMActivity)paramBundle).setSelfNavigationBarVisible(8);
    }
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(1024);
      getWindow().clearFlags(512);
      getWindow().clearFlags(67108864);
      paramBundle = getContext().getResources();
      p.j(paramBundle, "context.resources");
      if (paramBundle.getConfiguration().orientation == 2)
      {
        paramBundle = getWindow();
        p.j(paramBundle, "window");
        paramBundle = paramBundle.getDecorView();
        p.j(paramBundle, "window.decorView");
        paramBundle.setSystemUiVisibility(7942);
        getWindow().addFlags(1024);
        getWindow().addFlags(-2147483648);
        paramBundle = getWindow();
        p.j(paramBundle, "window");
        paramBundle.setStatusBarColor(0);
        paramBundle = getWindow();
        p.j(paramBundle, "window");
        paramBundle.setNavigationBarColor(0);
      }
    }
    else
    {
      getWindow().setFormat(-3);
      getWindow().setSoftInputMode(51);
      paramBundle = (FinderLiveBundle)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
      bool = getIntent().getBooleanExtra("KEY_PARAMS_RESET_LIVE", false);
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
      if (localObject1 == null) {
        break label560;
      }
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject1 == null) {
        break label560;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
      if (localObject1 == null) {
        break label560;
      }
    }
    Object localObject2;
    label560:
    for (long l = ((bac)localObject1).liveId;; l = 0L)
    {
      localObject1 = "[LiveLifecycle] onCreate comeFromReset:" + bool + ", across_live " + l + " configProvider:" + paramBundle;
      Log.i("Finder.FinderLiveVisitorUIC", (String)localObject1);
      localObject2 = com.tencent.mm.plugin.findersdk.f.b.Bxg;
      com.tencent.mm.plugin.findersdk.f.b.hA("Finder.FinderLiveVisitorUIC", (String)localObject1);
      if (paramBundle == null) {
        break label644;
      }
      localObject1 = paramBundle.dyk();
      if (((localObject1 != null) && (((LiveConfig)localObject1).getLiveId() == l)) || (bool)) {
        break label644;
      }
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      paramBundle.wmL = ((aj)com.tencent.mm.ui.component.g.b(getActivity()).i(aj.class)).wmL;
      localObject1 = ah.yhC;
      localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.data.g();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).a(paramBundle);
      ah.a((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1);
      this.zel = new com.tencent.mm.plugin.finder.live.j();
      paramBundle = getRootView().findViewById(b.f.finder_live_rf);
      p.j(paramBundle, "rootView.findViewById(R.id.finder_live_rf)");
      paramBundle = (RefreshLoadMoreLayout)paramBundle;
      localObject1 = getActivity();
      if (localObject1 != null) {
        break label565;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(277092);
      throw paramBundle;
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      break;
    }
    label565:
    paramBundle = new FinderLiveViewCallback(paramBundle, (MMActivity)localObject1, getFragment(), (c.a)this.zel, false);
    Object localObject1 = this.zel;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.j)localObject1).a((c.b)paramBundle);
    }
    this.xUK = paramBundle;
    for (;;)
    {
      paramBundle = getActivity();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(277092);
      throw paramBundle;
      label644:
      if (l != 0L)
      {
        localObject1 = ah.yhC;
        localObject1 = ah.dwh();
        if (localObject1 != null)
        {
          localObject2 = ah.yhC;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).NU(ah.dzk());
        }
        localObject1 = ah.yhC;
        localObject1 = ah.dwh();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).zeA;
          if (localObject1 != null)
          {
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)kotlin.a.j.lp((List)localObject1);
            if (localObject1 != null)
            {
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject1).zey;
              if (localObject2 != null)
              {
                if (paramBundle != null)
                {
                  paramBundle = paramBundle.yeC;
                  if (paramBundle != null)
                  {
                    paramBundle = (LiveConfig)kotlin.a.j.lp((List)paramBundle);
                    if (paramBundle != null)
                    {
                      localObject1 = paramBundle.aJo();
                      paramBundle = (Bundle)localObject1;
                      if (localObject1 != null) {
                        break label781;
                      }
                    }
                  }
                }
                paramBundle = "";
                label781:
                ((LiveConfig)localObject2).Nc(paramBundle);
              }
            }
          }
        }
        this.zel = new com.tencent.mm.plugin.finder.live.j();
        paramBundle = getRootView().findViewById(b.f.finder_live_rf);
        p.j(paramBundle, "rootView.findViewById(R.id.finder_live_rf)");
        paramBundle = (RefreshLoadMoreLayout)paramBundle;
        localObject1 = getActivity();
        if (localObject1 == null)
        {
          paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(277092);
          throw paramBundle;
        }
        paramBundle = new FinderLiveViewCallback(paramBundle, (MMActivity)localObject1, getFragment(), (c.a)this.zel, true);
        localObject1 = this.zel;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.j)localObject1).a((c.b)paramBundle);
        }
        this.xUK = paramBundle;
      }
      else
      {
        com.tencent.mm.ae.f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "liveVisitorUIParamsInvalid", false, false, null, 28);
        Log.i("Finder.FinderLiveVisitorUIC", "onCreate err stack:" + Util.getStack());
      }
    }
    this.xOE = new com.tencent.mm.plugin.finder.live.view.f((com.tencent.mm.plugin.ball.a.f)new e((Activity)paramBundle));
    paramBundle = this.xOE;
    if (paramBundle != null)
    {
      paramBundle.I(21, com.tencent.mm.plugin.ball.f.b.cwx());
      AppMethodBeat.o(277092);
      return;
    }
    AppMethodBeat.o(277092);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(277101);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    long l;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject).liveInfo;
        if (localObject != null)
        {
          l = ((bac)localObject).liveId;
          localObject = com.tencent.mm.live.core.core.c.a.kqk;
          localObject = a.a.FC(l);
          if (localObject == null) {
            break label221;
          }
          localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
          if (localObject == null) {
            break label221;
          }
          bool = ((com.tencent.mm.live.core.core.model.h)localObject).isFloatMode();
          label91:
          super.onDestroy();
          if (!this.xZp) {
            dGz();
          }
          localObject = this.zel;
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.live.j)localObject).onDetach();
          }
          localObject = this.xOE;
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.live.view.f)localObject).onDestroy();
          }
          if (com.tencent.mm.compatible.e.b.ct((Context)getContext())) {
            break label226;
          }
        }
      }
    }
    for (boolean bool = true;; bool = true)
    {
      Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onDestroy " + this + " playerLeakAssert:" + bool);
      com.tencent.mm.ae.f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "liveCdnPlayerLeak", bool, false, (kotlin.g.a.a)new c(l), 12);
      AppMethodBeat.o(277101);
      return;
      l = 0L;
      break;
      label221:
      bool = false;
      break label91;
      label226:
      if (!bool) {
        break label235;
      }
    }
    label235:
    localObject = com.tencent.mm.live.core.core.c.a.kqk;
    localObject = com.tencent.mm.live.core.core.c.a.aMe().entrySet();
    p.j(localObject, "instanceArray.entries");
    localObject = ((Iterable)localObject).iterator();
    bool = false;
    label270:
    if (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (!((com.tencent.mm.live.core.core.c.a)localEntry.getValue()).kqm.isPlaying()) {
        break label373;
      }
      ((com.tencent.mm.live.core.core.c.a)localEntry.getValue()).fi(false);
      ((com.tencent.mm.live.core.core.c.a)localEntry.getValue()).release();
      bool = true;
    }
    label373:
    for (;;)
    {
      break label270;
      Log.i("FinderLiveVisitorPlayCore", "checkPlayerLeak ".concat(String.valueOf(bool)));
      if (!bool)
      {
        bool = true;
        break;
      }
      bool = false;
      break;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(277103);
    super.onNewIntent(paramIntent);
    Object localObject = this.xUK;
    if (localObject != null)
    {
      localObject = ((FinderLiveViewCallback)localObject).xUG.xWt;
      if (localObject != null)
      {
        ((FinderLiveVisitorPluginLayout)localObject).onNewIntent(paramIntent);
        AppMethodBeat.o(277103);
        return;
      }
      AppMethodBeat.o(277103);
      return;
    }
    AppMethodBeat.o(277103);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(277098);
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onPause " + this + ", " + this.xZq);
    super.onPause();
    this.isPaused = true;
    Object localObject = this.jij;
    if (localObject != null) {
      ((i)localObject).close();
    }
    localObject = this.xZq;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    this.xZq = null;
    AppMethodBeat.o(277098);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(277094);
    super.onRestoreInstanceState(paramBundle);
    Object localObject2;
    if (paramBundle != null)
    {
      paramBundle = (FinderLiveBundle)paramBundle.getParcelable("KEY_PARAMS_CONFIG");
      localObject1 = (FinderLiveBundle)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
      localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
      localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
      if (localObject2 == null) {
        break label275;
      }
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject2 == null) {
        break label275;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject2).liveInfo;
      if (localObject2 == null) {
        break label275;
      }
    }
    label275:
    for (long l = ((bac)localObject2).liveId;; l = 0L)
    {
      Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle] onRestoreInstanceState " + this + " configProvider:" + localObject1 + " restoreConfigProvider:" + paramBundle + " curLiveId:" + l);
      if ((localObject1 != null) || (l != 0L) || (paramBundle == null)) {
        break label331;
      }
      localObject1 = paramBundle.dyk();
      if ((localObject1 != null) && (((LiveConfig)localObject1).getLiveId() == 0L)) {
        break label331;
      }
      localObject1 = ah.yhC;
      localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.data.g();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).a(paramBundle);
      ah.a((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1);
      this.zel = new com.tencent.mm.plugin.finder.live.j();
      paramBundle = getRootView().findViewById(b.f.finder_live_rf);
      p.j(paramBundle, "rootView.findViewById(R.id.finder_live_rf)");
      paramBundle = (RefreshLoadMoreLayout)paramBundle;
      localObject1 = getActivity();
      if (localObject1 != null) {
        break label280;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(277094);
      throw paramBundle;
      paramBundle = null;
      break;
    }
    label280:
    paramBundle = new FinderLiveViewCallback(paramBundle, (MMActivity)localObject1, getFragment(), (c.a)this.zel, false);
    Object localObject1 = this.zel;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.j)localObject1).a((c.b)paramBundle);
    }
    this.xUK = paramBundle;
    label331:
    AppMethodBeat.o(277094);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(277097);
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onResume " + this + ',');
    super.onResume();
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(277097);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null) {
        ((View)localObject).post((Runnable)new d(this));
      }
    }
    Log.i("Finder.FinderLiveVisitorUIC", "initBusiness");
    localObject = this.xUK;
    if (localObject != null)
    {
      Log.i("Finder.LiveViewCallback", "[LiveLifecycle]onInit ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(277097);
      return;
    }
    AppMethodBeat.o(277097);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(277093);
    super.onSaveInstanceState(paramBundle);
    Object localObject2 = new StringBuilder("[LiveLifecycle] onSaveInstanceState ").append(this).append(" curData:");
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject1 != null) {}
    for (localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);; localObject1 = null)
    {
      Log.i("Finder.FinderLiveVisitorUIC", localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
      if (localObject1 == null) {
        break label223;
      }
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localObject1 == null) {
        break label223;
      }
      localObject1 = new LiveConfig.a().sP(LiveConfig.khX).Fx(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo.liveId).Nf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).nonceId).Fy(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).xbk).Ni(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig).Nk(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).desc).aJw();
      p.j(localObject1, "builder.toWhere(LiveConf…\n                .build()");
      localObject2 = new FinderLiveBundle();
      ((FinderLiveBundle)localObject2).yeC.add(localObject1);
      if (paramBundle == null) {
        break;
      }
      paramBundle.putParcelable("KEY_PARAMS_CONFIG", (Parcelable)localObject2);
      AppMethodBeat.o(277093);
      return;
    }
    AppMethodBeat.o(277093);
    return;
    label223:
    AppMethodBeat.o(277093);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(277095);
    StringBuilder localStringBuilder = new StringBuilder("[LiveLifecycle]onStart ").append(this).append(", activateUIKey:");
    com.tencent.mm.plugin.finder.live.view.f.a locala = com.tencent.mm.plugin.finder.live.view.f.yVy;
    Log.i("Finder.FinderLiveVisitorUIC", com.tencent.mm.plugin.finder.live.view.f.dFl());
    super.onStart();
    dxk();
    AppMethodBeat.o(277095);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(277099);
    StringBuilder localStringBuilder = new StringBuilder("[LiveLifecycle]onStop ").append(this).append(", activateUIKey:");
    com.tencent.mm.plugin.finder.live.view.f.a locala = com.tencent.mm.plugin.finder.live.view.f.yVy;
    Log.i("Finder.FinderLiveVisitorUIC", com.tencent.mm.plugin.finder.live.view.f.dFl());
    super.onStop();
    dxh();
    AppMethodBeat.o(277099);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveVisitorUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(290777);
      g.b(this.zeo);
      AppMethodBeat.o(290777);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<String>
  {
    c(long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(278740);
      if (g.a(this.zeo) == null)
      {
        localObject = this.zeo;
        Activity localActivity = this.zeo.getContext();
        if (localActivity == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(278740);
          throw ((Throwable)localObject);
        }
        g.a((g)localObject, new i(localActivity));
        localObject = g.a(this.zeo);
        if (localObject != null) {
          ((i)localObject).setKeyboardHeightObserver((com.tencent.mm.ui.tools.h)new com.tencent.mm.ui.tools.h()
          {
            public final void A(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(275603);
              Log.i("Finder.FinderLiveVisitorUIC", "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              g localg = this.zep.zeo;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                g.a(localg, paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(275603);
                return;
              }
            }
          });
        }
      }
      Object localObject = g.a(this.zeo);
      if (localObject != null)
      {
        ((i)localObject).start();
        AppMethodBeat.o(278740);
        return;
      }
      AppMethodBeat.o(278740);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/Window;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<Window>
  {
    e(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.g
 * JD-Core Version:    0.7.0.1
 */