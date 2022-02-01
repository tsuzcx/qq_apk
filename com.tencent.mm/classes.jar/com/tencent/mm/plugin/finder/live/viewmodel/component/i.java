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
import com.tencent.mm.ae.e.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.core.core.f.a.a;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.c.a;
import com.tencent.mm.plugin.finder.live.c.b;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.report.q.ch;
import com.tencent.mm.plugin.finder.live.util.ai;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.view.f.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveVisitorUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activeFinish", "", "callOnce", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "isKeyBoardShow", "isPaused", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "lastKeyBoardHeight", "", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "unInitTask", "Ljava/lang/Runnable;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "window", "Landroid/view/Window;", "kotlin.jvm.PlatformType", "getWindow", "()Landroid/view/Window;", "window$delegate", "Lkotlin/Lazy;", "checkPlayerLeak", "", "getIFinderLiveCommonAdapter", "Lcom/tencent/mm/plugin/finder/live/model/service/IFinderLiveCommonAdapter;", "getLayoutId", "getViewCallback", "initBusiness", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "tryHideFloatBallWhenEnterPage", "tryShowFloatBallWhenExitPage", "unInitBusiness", "unInitBusinessCheck", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class i
  extends UIComponent
{
  public static final i.a EaW;
  private com.tencent.mm.plugin.finder.live.view.f BoD;
  private FinderLiveViewCallback BvJ;
  private Runnable CxA;
  private boolean Cxz;
  private com.tencent.mm.plugin.finder.live.g EaX;
  private final j EaY;
  private boolean callOnce;
  private boolean isPaused;
  private com.tencent.mm.ui.tools.i lKz;
  private boolean mJk;
  private int msK;
  
  static
  {
    AppMethodBeat.i(357006);
    EaW = new i.a((byte)0);
    AppMethodBeat.o(357006);
  }
  
  public i(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(356927);
    this.EaY = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(356927);
  }
  
  private static final void a(i parami)
  {
    AppMethodBeat.i(356993);
    s.u(parami, "this$0");
    if (parami.lKz == null)
    {
      parami.lKz = new com.tencent.mm.ui.tools.i(parami.getContext());
      com.tencent.mm.ui.tools.i locali = parami.lKz;
      if (locali != null) {
        locali.afIL = new i..ExternalSyntheticLambda0(parami);
      }
    }
    parami = parami.lKz;
    if (parami != null) {
      parami.start();
    }
    AppMethodBeat.o(356993);
  }
  
  private static final void a(i parami, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(356986);
    s.u(parami, "this$0");
    Log.i("Finder.FinderLiveVisitorUIC", "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (paramInt > 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if ((parami.mJk != paramBoolean) || (parami.msK != paramInt))
      {
        parami.msK = paramInt;
        parami.mJk = paramBoolean;
        parami = parami.BvJ;
        if (parami != null)
        {
          parami = parami.BwK.Bxq;
          if (parami != null) {
            parami.keyboardChange(paramBoolean, paramInt);
          }
        }
      }
      AppMethodBeat.o(356986);
      return;
    }
  }
  
  private static final void b(i parami)
  {
    AppMethodBeat.i(356997);
    s.u(parami, "this$0");
    parami.exR();
    AppMethodBeat.o(356997);
  }
  
  private final void exQ()
  {
    AppMethodBeat.i(356958);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    long l;
    label39:
    boolean bool2;
    if (localObject == null)
    {
      l = 0L;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject != null) {
        break label188;
      }
      bool1 = false;
      localObject = com.tencent.mm.live.core.core.f.a.mUf;
      localObject = a.a.hH(l);
      if (localObject != null) {
        break label220;
      }
      bool2 = false;
      label58:
      if (com.tencent.mm.compatible.e.b.dh((Context)getContext())) {
        break label248;
      }
      bool1 = true;
    }
    for (;;)
    {
      Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onDestroy " + this + " playerLeakAssert:" + bool1);
      e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "liveCdnPlayerLeak", bool1, null, false, (kotlin.g.a.a)new i.b(l), 28);
      AppMethodBeat.o(356958);
      return;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject == null)
      {
        l = 0L;
        break;
      }
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).liveInfo;
      if (localObject == null)
      {
        l = 0L;
        break;
      }
      l = ((bip)localObject).liveId;
      break;
      label188:
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject == null)
      {
        bool1 = false;
        break label39;
      }
      bool1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Eda;
      break label39;
      label220:
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if (localObject == null)
      {
        bool2 = false;
        break label58;
      }
      bool2 = ((com.tencent.mm.live.core.core.model.i)localObject).isFloatMode();
      break label58;
      label248:
      if (bool2)
      {
        bool1 = true;
      }
      else
      {
        if (!bool1) {
          break label267;
        }
        bool1 = true;
      }
    }
    label267:
    localObject = com.tencent.mm.live.core.core.f.a.mUf;
    localObject = com.tencent.mm.live.core.core.f.a.bfB().entrySet();
    s.s(localObject, "instanceArray.entries");
    localObject = ((Iterable)localObject).iterator();
    boolean bool1 = false;
    label302:
    if (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (!((com.tencent.mm.live.core.core.f.a)localEntry.getValue()).mUn.isPlaying()) {
        break label405;
      }
      ((com.tencent.mm.live.core.core.f.a)localEntry.getValue()).fO(false);
      ((com.tencent.mm.live.core.core.f.a)localEntry.getValue()).release();
      bool1 = true;
    }
    label405:
    for (;;)
    {
      break label302;
      Log.i("FinderLiveVisitorPlayCore", s.X("checkPlayerLeak ", Boolean.valueOf(bool1)));
      if (!bool1)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
    }
  }
  
  private final void exR()
  {
    AppMethodBeat.i(356968);
    if (this.callOnce)
    {
      AppMethodBeat.o(356968);
      return;
    }
    exS();
    this.callOnce = true;
    exQ();
    AppMethodBeat.o(356968);
  }
  
  private final void exS()
  {
    AppMethodBeat.i(356975);
    Log.i("Finder.FinderLiveVisitorUIC", "uninitBusiness");
    FinderLiveViewCallback localFinderLiveViewCallback = this.BvJ;
    if (localFinderLiveViewCallback != null) {
      localFinderLiveViewCallback.ehd();
    }
    AppMethodBeat.o(356975);
  }
  
  private Window getWindow()
  {
    AppMethodBeat.i(356936);
    Window localWindow = (Window)this.EaY.getValue();
    AppMethodBeat.o(356936);
    return localWindow;
  }
  
  public final void ehO()
  {
    AppMethodBeat.i(357135);
    Object localObject = toString();
    f.a locala = com.tencent.mm.plugin.finder.live.view.f.DOI;
    if (Util.isEqual((String)localObject, com.tencent.mm.plugin.finder.live.view.f.evB()))
    {
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject != null) {
        break label77;
      }
      localObject = null;
      if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).EcI)) {
        break label91;
      }
      localObject = this.BoD;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.f)localObject).rZ(true);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      AppMethodBeat.o(357135);
      return;
      label77:
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      break;
      label91:
      localObject = this.BoD;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.view.f)localObject).rZ(false);
      }
    }
  }
  
  public final void ehR()
  {
    AppMethodBeat.i(357106);
    Object localObject = com.tencent.mm.plugin.finder.live.view.f.DOI;
    com.tencent.mm.plugin.finder.live.view.f.axX(toString());
    localObject = this.BoD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).bhT();
    }
    com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    AppMethodBeat.o(357106);
  }
  
  public final com.tencent.mm.plugin.finder.live.model.service.a getIFinderLiveCommonAdapter()
  {
    AppMethodBeat.i(357188);
    Object localObject = this.BvJ;
    if (localObject == null)
    {
      AppMethodBeat.o(357188);
      return null;
    }
    localObject = ((FinderLiveViewCallback)localObject).getIFinderLiveCommonAdapter();
    AppMethodBeat.o(357188);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return p.f.Cfw;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(357166);
    Object localObject1 = this.BvJ;
    if (localObject1 != null)
    {
      localObject1 = ((FinderLiveViewCallback)localObject1).BwK.Bxq;
      if (localObject1 != null) {
        ((FinderLiveVisitorPluginLayout)localObject1).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (paramInt1 == 1010)
      {
        paramIntent = aj.CGT;
        paramIntent = aj.elL();
        if (paramIntent != null) {
          paramIntent.setMute(false);
        }
      }
      if (paramInt1 == 1011)
      {
        paramIntent = aj.CGT;
        paramIntent = aj.getFinderLiveAssistant();
        if (paramIntent != null) {
          paramIntent.eko();
        }
      }
      AppMethodBeat.o(357166);
      return;
      localObject1 = new ArrayList();
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        paramIntent = (Intent)localObject1;
        if (localObject1 == null) {
          paramIntent = new ArrayList(0);
        }
        localObject1 = paramIntent;
      }
      if (!((Collection)localObject1).isEmpty()) {}
      for (paramInt2 = 1; paramInt2 != 0; paramInt2 = 0)
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        for (paramIntent = ""; ((Iterator)localObject2).hasNext(); paramIntent = paramIntent + (String)localObject3 + ';') {
          localObject3 = (String)((Iterator)localObject2).next();
        }
      }
      Object localObject2 = paramIntent;
      if (n.rs(paramIntent, ";"))
      {
        paramInt2 = paramIntent.length();
        if (paramIntent == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(357166);
          throw paramIntent;
        }
        localObject2 = paramIntent.substring(0, paramInt2 - 1);
        s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      paramIntent = com.tencent.mm.plugin.finder.live.olympic.report.b.CRS;
      paramIntent = com.tencent.mm.plugin.finder.live.olympic.report.b.eoo();
      Object localObject3 = ai.akfD;
      ai.e((List)localObject1, paramIntent);
      com.tencent.mm.plugin.finder.live.report.k.Doi.a((String)localObject2, q.ch.DFy, paramIntent);
      continue;
      paramIntent = com.tencent.mm.plugin.finder.live.olympic.report.b.CRS;
      paramIntent = com.tencent.mm.plugin.finder.live.olympic.report.b.eoo();
      com.tencent.mm.plugin.finder.live.report.k.Doi.a(null, q.ch.DFz, paramIntent);
    }
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(357148);
    Log.i("Finder.FinderLiveVisitorUIC", s.X("[LiveLifecycle]onBackPressed ", this));
    Object localObject = this.BvJ;
    if (localObject == null)
    {
      AppMethodBeat.o(357148);
      return false;
    }
    localObject = ((FinderLiveViewCallback)localObject).BwK.Bxq;
    if (localObject == null)
    {
      AppMethodBeat.o(357148);
      return false;
    }
    boolean bool = ((FinderLiveVisitorPluginLayout)localObject).onBackPress();
    AppMethodBeat.o(357148);
    return bool;
  }
  
  public void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(357173);
    super.onBeforeFinish(paramIntent);
    if (this.isPaused) {
      exS();
    }
    for (;;)
    {
      this.Cxz = true;
      AppMethodBeat.o(357173);
      return;
      this.CxA = new i..ExternalSyntheticLambda1(this);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(357181);
    s.u(paramConfiguration, "newConfig");
    Log.i("Finder.FinderLiveVisitorUIC", s.X("[LiveLifecycle]onConfigurationChanged orientation:", Integer.valueOf(paramConfiguration.orientation)));
    super.onConfigurationChanged(paramConfiguration);
    Object localObject = this.BvJ;
    if (localObject != null)
    {
      s.u(paramConfiguration, "newConfig");
      localObject = ((FinderLiveViewCallback)localObject).BwK.Bxq;
      if (localObject != null) {
        ((FinderLiveVisitorPluginLayout)localObject).onConfigurationChanged(paramConfiguration);
      }
    }
    AppMethodBeat.o(357181);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(357053);
    super.onCreate(paramBundle);
    if ((getActivity() instanceof MMActivity)) {
      ((MMActivity)getActivity()).setSelfNavigationBarVisible(8);
    }
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    boolean bool1;
    Object localObject1;
    long l;
    label237:
    Object localObject2;
    int i;
    label337:
    com.tencent.mm.bx.a locala;
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(1024);
      getWindow().clearFlags(512);
      getWindow().clearFlags(67108864);
      if (getContext().getResources().getConfiguration().orientation == 2)
      {
        getWindow().getDecorView().setSystemUiVisibility(7942);
        getWindow().addFlags(1024);
        getWindow().addFlags(-2147483648);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
      }
    }
    else
    {
      getWindow().setFormat(-3);
      getWindow().setSoftInputMode(51);
      paramBundle = (FinderLiveBundle)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
      if (paramBundle != null) {
        paramBundle.CFn = getIntent().getBundleExtra("KEY_PARAMS_ENTRANCE_REPORT_INFO");
      }
      bool1 = getIntent().getBooleanExtra("KEY_PARAMS_RESET_LIVE", false);
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject1 != null) {
        break label680;
      }
      l = 0L;
      localObject1 = "[LiveLifecycle] onCreate comeFromReset:" + bool1 + ", across_live " + l + " configProvider:" + paramBundle;
      boolean bool2 = getIntent().getBooleanExtra("KEY_PARAMS_NOT_KEEP_CUR_LIVE", false);
      Log.i("Finder.FinderLiveVisitorUIC", (String)localObject1);
      localObject2 = com.tencent.mm.plugin.findersdk.f.b.HeJ;
      com.tencent.mm.plugin.findersdk.f.b.iz("Finder.FinderLiveVisitorUIC", (String)localObject1);
      if (paramBundle == null) {
        break label774;
      }
      localObject1 = paramBundle.ekC();
      if ((localObject1 == null) || (((LiveConfig)localObject1).liveId != l)) {
        break label732;
      }
      i = 1;
      if ((i != 0) || (bool1)) {
        break label774;
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      paramBundle.zIO = ((bn)com.tencent.mm.ui.component.k.d(getActivity()).cq(bn.class)).fov();
      localObject1 = aj.CGT;
      localObject2 = aj.egD();
      if ((l == 0L) || (bool2)) {
        break label737;
      }
      bool1 = true;
      label399:
      localObject1 = aj.CGT;
      localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.data.g();
      if (!bool1) {
        break label742;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).a(paramBundle, l, (com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject2);
      localObject2 = getIntent().getByteArrayExtra("PRE_JOIN_LIVE_INFO");
      if (localObject2 != null)
      {
        paramBundle = new bkt();
        locala = (com.tencent.mm.bx.a)paramBundle;
      }
    }
    for (;;)
    {
      try
      {
        locala.parseFrom((byte[])localObject2);
        localObject2 = ah.aiuX;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Ebz = paramBundle;
        paramBundle = ah.aiuX;
        aj.a((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1);
        this.EaX = new com.tencent.mm.plugin.finder.live.g((Context)getContext());
        paramBundle = getRootView().findViewById(p.e.BSe);
        s.s(paramBundle, "rootView.findViewById(R.id.finder_live_rf)");
        paramBundle = (RefreshLoadMoreLayout)paramBundle;
        localObject1 = getRootView().findViewById(p.e.BKe);
        s.s(localObject1, "rootView.findViewById(R.…finder_live_content_root)");
        paramBundle = new FinderLiveViewCallback(paramBundle, (View)localObject1, (MMActivity)getActivity(), getFragment(), (c.a)this.EaX, bool1, bool1);
        localObject1 = this.EaX;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.g)localObject1).a((c.b)paramBundle);
        }
        localObject1 = ah.aiuX;
        this.BvJ = paramBundle;
        this.BoD = new com.tencent.mm.plugin.finder.live.view.f((com.tencent.mm.plugin.ball.a.f)new com.tencent.mm.plugin.ball.a.e((Activity)getActivity()));
        paramBundle = this.BoD;
        if (paramBundle != null) {
          paramBundle.J(21, "LiveFloatBall");
        }
        AppMethodBeat.o(357053);
        return;
        getWindow().getDecorView().setSystemUiVisibility(1792);
        break;
        label680:
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (localObject1 == null)
        {
          l = 0L;
          break label237;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
        if (localObject1 == null)
        {
          l = 0L;
          break label237;
        }
        l = ((bip)localObject1).liveId;
        break label237;
        label732:
        i = 0;
        break label337;
        label737:
        bool1 = false;
        break label399;
        label742:
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).a(paramBundle);
      }
      catch (Exception localException)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        continue;
      }
      label774:
      if (l != 0L)
      {
        localObject1 = aj.CGT;
        localObject1 = aj.egD();
        if (localObject1 == null)
        {
          localObject1 = null;
          label799:
          if (localObject1 != null)
          {
            if (paramBundle != null) {
              break label994;
            }
            paramBundle = "";
          }
        }
        for (;;)
        {
          ((LiveConfig)localObject1).mIQ = paramBundle;
          this.EaX = new com.tencent.mm.plugin.finder.live.g((Context)getContext());
          paramBundle = getRootView().findViewById(p.e.BSe);
          s.s(paramBundle, "rootView.findViewById(R.id.finder_live_rf)");
          paramBundle = (RefreshLoadMoreLayout)paramBundle;
          localObject1 = getRootView().findViewById(p.e.BKe);
          s.s(localObject1, "rootView.findViewById(R.…finder_live_content_root)");
          paramBundle = new FinderLiveViewCallback(paramBundle, (View)localObject1, (MMActivity)getActivity(), getFragment(), (c.a)this.EaX, true);
          localObject1 = this.EaX;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.live.g)localObject1).a((c.b)paramBundle);
          }
          localObject1 = ah.aiuX;
          this.BvJ = paramBundle;
          break;
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).Ebx;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label799;
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)p.oL((List)localObject1);
          if (localObject1 == null)
          {
            localObject1 = null;
            break label799;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject1).Ebr;
          break label799;
          label994:
          paramBundle = paramBundle.CFa;
          if (paramBundle == null)
          {
            paramBundle = "";
          }
          else
          {
            paramBundle = (LiveConfig)p.oL((List)paramBundle);
            if (paramBundle == null)
            {
              paramBundle = "";
            }
            else
            {
              String str = paramBundle.mIQ;
              paramBundle = str;
              if (str == null) {
                paramBundle = "";
              }
            }
          }
        }
      }
      e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "liveVisitorUIParamsInvalid", false, null, false, null, 60);
      Log.i("Finder.FinderLiveVisitorUIC", s.X("onCreate err stack:", Util.getStack()));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(357143);
    super.onDestroy();
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onDestroy " + this + ' ' + this.Cxz + ' ' + this.isPaused);
    if ((!this.Cxz) || (!this.isPaused)) {
      exR();
    }
    Object localObject = this.EaX;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.g)localObject).onDetach();
    }
    localObject = this.BoD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).onDestroy();
    }
    localObject = com.tencent.mm.plugin.finder.live.olympic.report.b.CRS;
    com.tencent.mm.plugin.finder.live.olympic.report.b.eol();
    AppMethodBeat.o(357143);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(357156);
    super.onNewIntent(paramIntent);
    Object localObject = this.BvJ;
    if (localObject != null)
    {
      localObject = ((FinderLiveViewCallback)localObject).BwK.Bxq;
      if (localObject != null) {
        ((FinderLiveVisitorPluginLayout)localObject).onNewIntent(paramIntent);
      }
    }
    AppMethodBeat.o(357156);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(357119);
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onPause " + this + ", " + this.CxA);
    super.onPause();
    this.isPaused = true;
    Object localObject = this.lKz;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.i)localObject).close();
    }
    localObject = this.CxA;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    this.CxA = null;
    AppMethodBeat.o(357119);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(357193);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    Object localObject = this.BvJ;
    if (localObject != null)
    {
      s.u(paramArrayOfString, "permissions");
      s.u(paramArrayOfInt, "grantResults");
      localObject = ((FinderLiveViewCallback)localObject).BwK.Bxq;
      if (localObject != null) {
        ((FinderLiveVisitorPluginLayout)localObject).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
    }
    AppMethodBeat.o(357193);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(357097);
    super.onRestoreInstanceState(paramBundle);
    Object localObject1;
    Object localObject2;
    long l;
    if (paramBundle == null)
    {
      paramBundle = null;
      localObject1 = (FinderLiveBundle)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
      localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject2 != null) {
        break label315;
      }
      l = 0L;
      label49:
      Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle] onRestoreInstanceState " + this + " configProvider:" + localObject1 + " restoreConfigProvider:" + paramBundle + " curLiveId:" + l);
      if ((localObject1 == null) && (l == 0L) && (paramBundle != null))
      {
        localObject1 = paramBundle.ekC();
        if ((localObject1 == null) || (((LiveConfig)localObject1).liveId != 0L)) {
          break label364;
        }
      }
    }
    label315:
    label364:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject1 = aj.CGT;
        localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.data.g();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1).a(paramBundle);
        paramBundle = ah.aiuX;
        aj.a((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject1);
        this.EaX = new com.tencent.mm.plugin.finder.live.g((Context)getContext());
        paramBundle = getRootView().findViewById(p.e.BSe);
        s.s(paramBundle, "rootView.findViewById(R.id.finder_live_rf)");
        paramBundle = (RefreshLoadMoreLayout)paramBundle;
        localObject1 = getRootView().findViewById(p.e.BKe);
        s.s(localObject1, "rootView.findViewById(R.…finder_live_content_root)");
        paramBundle = new FinderLiveViewCallback(paramBundle, (View)localObject1, (MMActivity)getActivity(), getFragment(), (c.a)this.EaX, false);
        localObject1 = this.EaX;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.live.g)localObject1).a((c.b)paramBundle);
        }
        localObject1 = ah.aiuX;
        this.BvJ = paramBundle;
      }
      AppMethodBeat.o(357097);
      return;
      paramBundle = (FinderLiveBundle)paramBundle.getParcelable("KEY_PARAMS_CONFIG");
      break;
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject2 == null)
      {
        l = 0L;
        break label49;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).liveInfo;
      if (localObject2 == null)
      {
        l = 0L;
        break label49;
      }
      l = ((bip)localObject2).liveId;
      break label49;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(357115);
    Log.i("Finder.FinderLiveVisitorUIC", "[LiveLifecycle]onResume " + this + ',');
    super.onResume();
    Object localObject = getContext().getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null) {
        ((View)localObject).post(new i..ExternalSyntheticLambda2(this));
      }
    }
    Log.i("Finder.FinderLiveVisitorUIC", "initBusiness");
    localObject = this.BvJ;
    if (localObject != null) {
      Log.i("Finder.FinderLiveViewCallback", s.X("[LiveLifecycle]onInit ", localObject));
    }
    AppMethodBeat.o(357115);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(357088);
    super.onSaveInstanceState(paramBundle);
    Object localObject2 = new StringBuilder("[LiveLifecycle] onSaveInstanceState ").append(this).append(" curData:");
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))
    {
      Log.i("Finder.FinderLiveVisitorUIC", localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (localObject1 != null)
        {
          localObject2 = new LiveConfig.a();
          ((LiveConfig.a)localObject2).mIy = LiveConfig.mIt;
          ((LiveConfig.a)localObject2).liveId = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo.liveId;
          ((LiveConfig.a)localObject2).nonceId = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).nonceId;
          ((LiveConfig.a)localObject2).mIH = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).hKN;
          ((LiveConfig.a)localObject2).mIC = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
          ((LiveConfig.a)localObject2).desc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).desc;
          localObject1 = ((LiveConfig.a)localObject2).bcd();
          s.s(localObject1, "builder.toWhere(LiveConf…\n                .build()");
          localObject2 = new FinderLiveBundle();
          ((FinderLiveBundle)localObject2).CFa.add(localObject1);
          if (paramBundle != null) {
            paramBundle.putParcelable("KEY_PARAMS_CONFIG", (Parcelable)localObject2);
          }
        }
      }
      AppMethodBeat.o(357088);
      return;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(357101);
    StringBuilder localStringBuilder = new StringBuilder("[LiveLifecycle]onStart ").append(this).append(", activateUIKey:");
    f.a locala = com.tencent.mm.plugin.finder.live.view.f.DOI;
    Log.i("Finder.FinderLiveVisitorUIC", com.tencent.mm.plugin.finder.live.view.f.evB());
    super.onStart();
    ehR();
    AppMethodBeat.o(357101);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(357128);
    Object localObject = new StringBuilder("[LiveLifecycle]onStop ").append(this).append(", activateUIKey:");
    f.a locala = com.tencent.mm.plugin.finder.live.view.f.DOI;
    Log.i("Finder.FinderLiveVisitorUIC", com.tencent.mm.plugin.finder.live.view.f.evB());
    super.onStop();
    ehO();
    localObject = aj.CGT;
    localObject = aj.egD();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject).exW();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject).Ebr;
        if (localObject != null)
        {
          long l = ((LiveConfig)localObject).mIH;
          localObject = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
          localObject = com.tencent.mm.plugin.finder.live.fluent.g.nW(l);
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.live.fluent.k)localObject).ejn();
          }
        }
      }
    }
    AppMethodBeat.o(357128);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/Window;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Window>
  {
    c(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.i
 * JD-Core Version:    0.7.0.1
 */