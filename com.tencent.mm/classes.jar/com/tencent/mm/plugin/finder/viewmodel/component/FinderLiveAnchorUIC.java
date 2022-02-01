package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.view.a;
import com.tencent.mm.plugin.finder.live.view.j.a;
import com.tencent.mm.plugin.finder.live.viewmodel.c;
import com.tencent.mm.plugin.finder.live.viewmodel.d;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveAnchorUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "activeFinish", "", "anchorPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getAnchorPluginLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "setAnchorPluginLayout", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "callOnce", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "getFinderLivePageFloatBallHelper", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "setFinderLivePageFloatBallHelper", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;)V", "isKeyBoardShow", "isPaused", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "unInitTask", "Ljava/lang/Runnable;", "getLayoutId", "", "getPluginLayout", "initBusiness", "", "initData", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "uninitBusiness", "uninitBusinessCheck", "plugin-finder_release"})
public class FinderLiveAnchorUIC
  extends UIComponent
{
  final String TAG;
  private h gyh;
  private boolean hwq;
  private boolean isPaused;
  com.tencent.mm.plugin.finder.live.view.j ubm;
  private Runnable vPT;
  private boolean vPU;
  private boolean vPV;
  FinderBaseLivePluginLayout wya;
  
  public FinderLiveAnchorUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255751);
    this.TAG = "MicroMsg.FinderLiveAnchorWithoutAffinityUI";
    AppMethodBeat.o(255751);
  }
  
  private final void dAn()
  {
    AppMethodBeat.i(255748);
    if (this.vPV)
    {
      AppMethodBeat.o(255748);
      return;
    }
    dei();
    this.vPV = true;
    AppMethodBeat.o(255748);
  }
  
  private void dei()
  {
    AppMethodBeat.i(255749);
    Log.i(this.TAG, "[LiveLifecycler]uninitBusiness ".concat(String.valueOf(this)));
    FinderBaseLivePluginLayout localFinderBaseLivePluginLayout = this.wya;
    if (localFinderBaseLivePluginLayout != null)
    {
      localFinderBaseLivePluginLayout.unMount();
      AppMethodBeat.o(255749);
      return;
    }
    AppMethodBeat.o(255749);
  }
  
  public FinderBaseLivePluginLayout dIk()
  {
    AppMethodBeat.i(255740);
    Object localObject = getActivity();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255740);
      throw ((Throwable)localObject);
    }
    localObject = (FinderBaseLivePluginLayout)new a((MMActivity)localObject);
    AppMethodBeat.o(255740);
    return localObject;
  }
  
  public void dIl()
  {
    AppMethodBeat.i(255736);
    Object localObject;
    if ((getActivity() instanceof MMActivity))
    {
      localObject = getActivity();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255736);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).setSelfNavigationBarVisible(8);
    }
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext().getWindow().clearFlags(67108864);
      localObject = getContext().getWindow();
      p.g(localObject, "context.window");
      localObject = ((Window)localObject).getDecorView();
      p.g(localObject, "context.window.decorView");
      ((View)localObject).setSystemUiVisibility(1792);
      getContext().getWindow().addFlags(-2147483648);
      localObject = getContext().getWindow();
      p.g(localObject, "context.window");
      ((Window)localObject).setStatusBarColor(0);
      localObject = getContext().getWindow();
      p.g(localObject, "context.window");
      ((Window)localObject).setNavigationBarColor(0);
    }
    getContext().getWindow().setFormat(-3);
    getContext().getWindow().setSoftInputMode(51);
    AppMethodBeat.o(255736);
  }
  
  public int getLayoutId()
  {
    return 2131494454;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(255747);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FinderBaseLivePluginLayout localFinderBaseLivePluginLayout = this.wya;
    if (localFinderBaseLivePluginLayout != null)
    {
      localFinderBaseLivePluginLayout.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(255747);
      return;
    }
    AppMethodBeat.o(255747);
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(255746);
    Log.i(this.TAG, "[LiveLifecycler]onBackPressed ".concat(String.valueOf(this)));
    FinderBaseLivePluginLayout localFinderBaseLivePluginLayout = this.wya;
    if (localFinderBaseLivePluginLayout != null)
    {
      boolean bool = localFinderBaseLivePluginLayout.onBackPress();
      AppMethodBeat.o(255746);
      return bool;
    }
    AppMethodBeat.o(255746);
    return false;
  }
  
  public void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(255750);
    super.onBeforeFinish(paramIntent);
    if (this.isPaused) {
      dei();
    }
    for (;;)
    {
      this.vPU = true;
      AppMethodBeat.o(255750);
      return;
      this.vPT = ((Runnable)new a(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255738);
    Log.i(this.TAG, "[LiveLifecycler]onCreate ".concat(String.valueOf(this)));
    super.onCreate(paramBundle);
    dIl();
    FinderLiveConfig localFinderLiveConfig = (FinderLiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    paramBundle = o.ujN;
    paramBundle = o.dfZ();
    int i;
    label99:
    boolean bool;
    label134:
    label207:
    Object localObject3;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.liveInfo;
      if (paramBundle != null)
      {
        paramBundle = Long.valueOf(paramBundle.liveId);
        if (localFinderLiveConfig == null) {
          break label358;
        }
        if (((Collection)localFinderLiveConfig.uiu).isEmpty()) {
          break label347;
        }
        i = 1;
        if (i == 0) {
          break label358;
        }
        localObject1 = (LiveConfig)kotlin.a.j.kt((List)localFinderLiveConfig.uiu);
        if (localObject1 == null) {
          break label352;
        }
        localObject1 = Long.valueOf(((LiveConfig)localObject1).getLiveId());
        if (!(p.j(localObject1, paramBundle) ^ true)) {
          break label358;
        }
        localObject1 = (LiveConfig)kotlin.a.j.kt((List)localFinderLiveConfig.uiu);
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          paramBundle = LiveConfig.V("", 0);
          p.g(paramBundle, "LiveConfig.getDefaultAnchorConfig(\"\", 0)");
        }
        paramBundle = new c(paramBundle);
        paramBundle.uCs.uit = localFinderLiveConfig.uit;
        bool = false;
        localObject2 = this.TAG;
        localObject1 = new StringBuilder("onCreate isFromFloat:").append(bool).append(", finderLiveData:").append(paramBundle).append(", configProvider:").append(localFinderLiveConfig).append(", FinderLiveService.liveData:");
        localObject3 = o.ujN;
        localObject3 = ((StringBuilder)localObject1).append(o.dfY()).append(", FinderLiveService.liveData?.liveDataList:");
        localObject1 = o.ujN;
        localObject1 = o.dfY();
        if (localObject1 == null) {
          break label432;
        }
      }
    }
    label425:
    label432:
    for (Object localObject1 = ((d)localObject1).uCu;; localObject1 = null)
    {
      Log.i((String)localObject2, localObject1);
      if (paramBundle != null) {
        break label438;
      }
      Log.w(this.TAG, "unkonwn data source! finish!");
      getContext().finish();
      AppMethodBeat.o(255738);
      return;
      paramBundle = null;
      break;
      label347:
      i = 0;
      break label99;
      label352:
      localObject1 = null;
      break label134;
      label358:
      if (paramBundle == null) {}
      while (paramBundle.longValue() != 0L)
      {
        paramBundle = o.ujN;
        paramBundle = o.dfY();
        if (paramBundle == null) {
          break label425;
        }
        paramBundle = paramBundle.uCu;
        if (paramBundle == null) {
          break label425;
        }
        paramBundle = (c)kotlin.a.j.kt((List)paramBundle);
        bool = true;
        break;
      }
      Log.w(this.TAG, "unkonwn data source! break onCreate");
      paramBundle = null;
      bool = false;
      break label207;
      paramBundle = null;
      bool = true;
      break label207;
    }
    label438:
    this.wya = dIk();
    ((FrameLayout)getContext().findViewById(2131300976)).addView((View)this.wya);
    localObject1 = o.ujN;
    localObject1 = new d();
    ((d)localObject1).ad(kotlin.a.j.ac(new c[] { paramBundle }));
    o.b((d)localObject1);
    localObject1 = getIntent().getByteArrayExtra("KEY_PARAMS_NOTICE");
    if (localObject1 != null)
    {
      paramBundle.ufj = new awt();
      localObject2 = paramBundle.ufj;
      if (localObject2 == null) {
        p.hyc();
      }
      ((awt)localObject2).parseFrom((byte[])localObject1);
    }
    localObject1 = o.ujN;
    Object localObject2 = o.a(paramBundle);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.g();
    }
    if (!bool)
    {
      if (localFinderLiveConfig != null) {}
      for (i = localFinderLiveConfig.sourceType;; i = 0)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).sourceType = i;
        localObject3 = getIntent().getSerializableExtra("KEY_PARAMS_TAGIFNOS");
        localObject2 = localObject3;
        if (!(localObject3 instanceof List)) {
          localObject2 = null;
        }
        localObject2 = (List)localObject2;
        if (localObject2 == null) {
          break;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uiw = new LinkedList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (byte[])((Iterator)localObject2).next();
          LinkedList localLinkedList = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uiw;
          if (localLinkedList != null)
          {
            axk localaxk = new axk();
            localaxk.parseFrom((byte[])localObject3);
            localLinkedList.add(localaxk);
          }
        }
      }
      localObject3 = getIntent().getByteArrayExtra("KEY_PARAMS_CHOSEN_TAG");
      if (localObject3 == null) {
        break label1016;
      }
      localObject2 = new axk();
      ((axk)localObject2).parseFrom((byte[])localObject3);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uix = ((axk)localObject2);
      localObject3 = getIntent().getSerializableExtra("KEY_PARAMS_VISITOR_WHITE_LIST");
      localObject2 = localObject3;
      if (!(localObject3 instanceof List)) {
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEY = ((List)localObject2);
      localObject2 = this.wya;
      if (localObject2 != null) {
        FinderBaseLivePluginLayout.bindData$default((FinderBaseLivePluginLayout)localObject2, paramBundle, (com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1, false, 4, null);
      }
      localObject2 = o.ujN;
      localObject3 = this.wya;
      if (localObject3 == null) {
        p.hyc();
      }
      ((o)localObject2).a((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1, (FinderBaseLivePluginLayout)localObject3, 0);
      localObject1 = this.wya;
      if (localObject1 != null) {
        ((FinderBaseLivePluginLayout)localObject1).activate(paramBundle, false, bool, 0);
      }
      localObject1 = this.wya;
      if (localObject1 != null) {
        ((FinderBaseLivePluginLayout)localObject1).mount();
      }
      paramBundle.ufj = new awt();
      this.ubm = new com.tencent.mm.plugin.finder.live.view.j((com.tencent.mm.plugin.ball.a.f)new e(getContext()));
      localObject1 = this.ubm;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.live.view.j)localObject1).G(21, b.cjf());
      }
      if (getIntent().getBooleanExtra("route_to_maximize", false))
      {
        localObject1 = this.wya;
        if (localObject1 != null) {
          ((FinderBaseLivePluginLayout)localObject1).post((Runnable)new b(this));
        }
      }
      localObject1 = k.vkd;
      k.a(paramBundle, localFinderLiveConfig);
      AppMethodBeat.o(255738);
      return;
      label1016:
      localObject2 = null;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(255745);
    Log.i(this.TAG, "[LiveLifecycler]onDestroy ".concat(String.valueOf(this)));
    super.onDestroy();
    com.tencent.mm.plugin.finder.live.view.j localj = this.ubm;
    if (localj != null) {
      localj.onDestroy();
    }
    if (!this.vPU) {
      dAn();
    }
    AppMethodBeat.o(255745);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(255737);
    super.onNewIntent(paramIntent);
    FinderBaseLivePluginLayout localFinderBaseLivePluginLayout = this.wya;
    if (localFinderBaseLivePluginLayout != null)
    {
      localFinderBaseLivePluginLayout.onNewIntent(paramIntent);
      AppMethodBeat.o(255737);
      return;
    }
    AppMethodBeat.o(255737);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(255743);
    Log.i(this.TAG, "[LiveLifecycler]onPause ".concat(String.valueOf(this)));
    super.onPause();
    Object localObject = this.gyh;
    if (localObject != null) {
      ((h)localObject).close();
    }
    localObject = this.wya;
    if (localObject != null) {
      ((FinderBaseLivePluginLayout)localObject).pause();
    }
    this.isPaused = true;
    localObject = this.vPT;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    this.vPT = null;
    AppMethodBeat.o(255743);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(255742);
    Log.i(this.TAG, "[LiveLifecycler]onResume ".concat(String.valueOf(this)));
    super.onResume();
    FinderBaseLivePluginLayout localFinderBaseLivePluginLayout = this.wya;
    if (localFinderBaseLivePluginLayout != null) {
      localFinderBaseLivePluginLayout.resume();
    }
    localFinderBaseLivePluginLayout = this.wya;
    if (localFinderBaseLivePluginLayout != null) {
      localFinderBaseLivePluginLayout.post((Runnable)new c(this));
    }
    Log.i(this.TAG, "[LiveLifecycler]initBusiness ".concat(String.valueOf(this)));
    AppMethodBeat.o(255742);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(255739);
    super.onSaveInstanceState(paramBundle);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("[LiveLifecycle] onSaveInstanceState ").append(this).append(" curData:");
    o localo = o.ujN;
    Log.i((String)localObject1, o.dfZ());
    localObject1 = o.ujN;
    localObject1 = o.dfZ();
    if (localObject1 != null)
    {
      localObject1 = new LiveConfig.a().qo(LiveConfig.hvT).zt(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo.liveId).Gd(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).hwg).zu(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).hFK).Gg(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).hwd).Gh(((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).desc).aBR();
      p.g(localObject1, "builder.toWhere(LiveConf…\n                .build()");
      localObject2 = new FinderLiveConfig();
      ((FinderLiveConfig)localObject2).uiu.add(localObject1);
      if (paramBundle != null) {
        paramBundle.putParcelable("KEY_PARAMS_CONFIG", (Parcelable)localObject2);
      }
      if (paramBundle != null)
      {
        localObject1 = ((FinderLiveConfig)localObject2).uiv;
        if (localObject1 != null) {}
        for (localObject1 = ((awt)localObject1).toByteArray();; localObject1 = null)
        {
          paramBundle.putByteArray("KEY_PARAMS_NOTICE", (byte[])localObject1);
          AppMethodBeat.o(255739);
          return;
        }
      }
      AppMethodBeat.o(255739);
      return;
    }
    AppMethodBeat.o(255739);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(255741);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[LiveLifecycler]onStart ").append(this).append(", activateUIKey:");
    j.a locala = com.tencent.mm.plugin.finder.live.view.j.uzS;
    Log.i((String)localObject, com.tencent.mm.plugin.finder.live.view.j.diD());
    super.onStart();
    localObject = com.tencent.mm.plugin.finder.live.view.j.uzS;
    com.tencent.mm.plugin.finder.live.view.j.atR(toString());
    localObject = this.wya;
    if (localObject != null) {
      ((FinderBaseLivePluginLayout)localObject).start();
    }
    localObject = this.ubm;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.j)localObject).aGf();
    }
    com.tencent.mm.plugin.ball.f.f.cjk();
    AppMethodBeat.o(255741);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(255744);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[LiveLifecycler]onStop ").append(this).append(", activateUIKey:");
    j.a locala = com.tencent.mm.plugin.finder.live.view.j.uzS;
    Log.i((String)localObject, com.tencent.mm.plugin.finder.live.view.j.diD());
    super.onStop();
    localObject = com.tencent.mm.plugin.finder.live.view.j.uzS;
    if (Util.isEqual(com.tencent.mm.plugin.finder.live.view.j.diD(), toString()))
    {
      localObject = this.wya;
      if (localObject != null) {
        ((FinderBaseLivePluginLayout)localObject).stop();
      }
      localObject = o.ujN;
      localObject = o.dfZ();
      if (localObject == null) {
        break label127;
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDS == true)
      {
        localObject = this.ubm;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.j)localObject).aGj();
        }
        com.tencent.mm.plugin.ball.f.f.cji();
      }
    }
    AppMethodBeat.o(255744);
    return;
    label127:
    AppMethodBeat.o(255744);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderLiveAnchorUIC paramFinderLiveAnchorUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255732);
      FinderLiveAnchorUIC.b(this.wyb);
      AppMethodBeat.o(255732);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderLiveAnchorUIC paramFinderLiveAnchorUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255733);
      FinderBaseLivePluginLayout localFinderBaseLivePluginLayout = this.wyb.wya;
      if (localFinderBaseLivePluginLayout != null)
      {
        b.b.a(localFinderBaseLivePluginLayout, b.c.hLR);
        AppMethodBeat.o(255733);
        return;
      }
      AppMethodBeat.o(255733);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderLiveAnchorUIC paramFinderLiveAnchorUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255735);
      if (FinderLiveAnchorUIC.a(this.wyb) == null)
      {
        localObject = this.wyb;
        Activity localActivity = this.wyb.getContext();
        if (localActivity == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(255735);
          throw ((Throwable)localObject);
        }
        FinderLiveAnchorUIC.a((FinderLiveAnchorUIC)localObject, new h(localActivity));
        localObject = FinderLiveAnchorUIC.a(this.wyb);
        if (localObject != null) {
          ((h)localObject).setKeyboardHeightObserver((com.tencent.mm.ui.tools.g)new com.tencent.mm.ui.tools.g()
          {
            public final void y(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(255734);
              Log.i(this.wyc.wyb.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              FinderLiveAnchorUIC localFinderLiveAnchorUIC = this.wyc.wyb;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                FinderLiveAnchorUIC.a(localFinderLiveAnchorUIC, paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(255734);
                return;
              }
            }
          });
        }
      }
      Object localObject = FinderLiveAnchorUIC.a(this.wyb);
      if (localObject != null)
      {
        ((h)localObject).start();
        AppMethodBeat.o(255735);
        return;
      }
      AppMethodBeat.o(255735);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorUIC
 * JD-Core Version:    0.7.0.1
 */