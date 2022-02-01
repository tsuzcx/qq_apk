package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC;
import com.tencent.mm.plugin.finder.live.viewmodel.c;
import com.tencent.mm.plugin.finder.live.viewmodel.d;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "anchorPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout;", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "keyboardChange", "", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "plugin-finder_release"})
public final class FinderLiveAnchorUI
  extends MMFinderUI
{
  private final String TAG = "MicroMsg.FinderLiveAnchorUI";
  private HashMap _$_findViewCache;
  private h gyh;
  private boolean hwq;
  private com.tencent.mm.plugin.finder.live.view.a ubl;
  private com.tencent.mm.plugin.finder.live.view.j ubm;
  public boolean ubn;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245336);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245336);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245335);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(245335);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494454;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245323);
    Set localSet = ak.setOf(FinderLivePostUIC.class);
    AppMethodBeat.o(245323);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(245333);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.live.view.a locala = this.ubl;
    if (locala != null)
    {
      locala.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(245333);
      return;
    }
    AppMethodBeat.o(245333);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(245331);
    com.tencent.mm.plugin.finder.live.view.a locala = this.ubl;
    if (locala != null)
    {
      if (!locala.onBackPress()) {
        super.onBackPressed();
      }
      AppMethodBeat.o(245331);
      return;
    }
    AppMethodBeat.o(245331);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245325);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.g(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    FinderLiveConfig localFinderLiveConfig = (FinderLiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    this.ubl = new com.tencent.mm.plugin.finder.live.view.a((MMActivity)this);
    ((FrameLayout)findViewById(2131300976)).addView((View)this.ubl);
    paramBundle = o.ujN;
    paramBundle = o.dfZ();
    int i;
    label245:
    boolean bool;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.liveInfo;
      if (paramBundle != null)
      {
        paramBundle = Long.valueOf(paramBundle.liveId);
        if (localFinderLiveConfig == null) {
          break label427;
        }
        if (((Collection)localFinderLiveConfig.uiu).isEmpty()) {
          break label416;
        }
        i = 1;
        if (i == 0) {
          break label427;
        }
        localObject1 = (LiveConfig)kotlin.a.j.kt((List)localFinderLiveConfig.uiu);
        if (localObject1 == null) {
          break label421;
        }
        localObject1 = Long.valueOf(((LiveConfig)localObject1).getLiveId());
        label280:
        if (!(p.j(localObject1, paramBundle) ^ true)) {
          break label427;
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
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "onCreate isFromFloat:" + bool + ", finderLiveData:" + paramBundle);
      if (paramBundle != null) {
        break label501;
      }
      Log.w(this.TAG, "unkonwn data source! finish!");
      finish();
      AppMethodBeat.o(245325);
      return;
      paramBundle = null;
      break;
      label416:
      i = 0;
      break label245;
      label421:
      localObject1 = null;
      break label280;
      label427:
      if (paramBundle == null) {}
      while (paramBundle.longValue() != 0L)
      {
        paramBundle = o.ujN;
        paramBundle = o.dfY();
        if (paramBundle == null) {
          break label494;
        }
        paramBundle = paramBundle.uCu;
        if (paramBundle == null) {
          break label494;
        }
        paramBundle = (c)kotlin.a.j.kt((List)paramBundle);
        bool = true;
        break;
      }
      Log.w(this.TAG, "unkonwn data source! break onCreate");
      paramBundle = null;
      bool = false;
      continue;
      label494:
      paramBundle = null;
      bool = true;
    }
    label501:
    Object localObject1 = o.ujN;
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
    localObject2 = this.ubl;
    if (localObject2 != null) {
      FinderBaseLivePluginLayout.bindData$default((FinderBaseLivePluginLayout)localObject2, paramBundle, (com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1, false, 4, null);
    }
    localObject2 = o.ujN;
    com.tencent.mm.plugin.finder.live.view.a locala = this.ubl;
    if (locala == null) {
      p.hyc();
    }
    ((o)localObject2).a((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1, (FinderBaseLivePluginLayout)locala, 0);
    localObject1 = this.ubl;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject1).activate(paramBundle, false, bool, 0);
    }
    localObject1 = this.ubl;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject1).mount();
    }
    paramBundle.ufj = new awt();
    this.ubm = new com.tencent.mm.plugin.finder.live.view.j((com.tencent.mm.plugin.ball.a.f)new e((Activity)this));
    localObject1 = this.ubm;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.j)localObject1).G(21, b.cjf());
    }
    localObject1 = k.vkd;
    k.a(paramBundle, localFinderLiveConfig);
    AppMethodBeat.o(245325);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245330);
    super.onDestroy();
    Object localObject = this.ubl;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).unMount();
    }
    localObject = this.ubm;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.live.view.j)localObject).onDestroy();
      AppMethodBeat.o(245330);
      return;
    }
    AppMethodBeat.o(245330);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(245324);
    super.onNewIntent(paramIntent);
    com.tencent.mm.plugin.finder.live.view.a locala = this.ubl;
    if (locala != null)
    {
      locala.onNewIntent(paramIntent);
      AppMethodBeat.o(245324);
      return;
    }
    AppMethodBeat.o(245324);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245328);
    super.onPause();
    Object localObject = this.gyh;
    if (localObject != null) {
      ((h)localObject).close();
    }
    localObject = this.ubl;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).pause();
      AppMethodBeat.o(245328);
      return;
    }
    AppMethodBeat.o(245328);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245327);
    super.onResume();
    com.tencent.mm.plugin.finder.live.view.a locala = this.ubl;
    if (locala != null) {
      locala.resume();
    }
    locala = this.ubl;
    if (locala != null)
    {
      locala.post((Runnable)new a(this));
      AppMethodBeat.o(245327);
      return;
    }
    AppMethodBeat.o(245327);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(245326);
    super.onStart();
    Object localObject = this.ubl;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).start();
    }
    localObject = this.ubm;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.j)localObject).aGf();
    }
    com.tencent.mm.plugin.ball.f.f.cjk();
    AppMethodBeat.o(245326);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(245329);
    super.onStop();
    Object localObject = this.ubl;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).stop();
    }
    localObject = this.ubm;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.j)localObject).aGj();
    }
    com.tencent.mm.plugin.ball.f.f.cji();
    AppMethodBeat.o(245329);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(245332);
    super.onSwipeBack();
    this.ubn = true;
    AppMethodBeat.o(245332);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderLiveAnchorUI paramFinderLiveAnchorUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(245322);
      if (FinderLiveAnchorUI.a(this.ubo) == null)
      {
        localObject = this.ubo;
        AppCompatActivity localAppCompatActivity = this.ubo.getContext();
        if (localAppCompatActivity == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(245322);
          throw ((Throwable)localObject);
        }
        FinderLiveAnchorUI.a((FinderLiveAnchorUI)localObject, new h((Activity)localAppCompatActivity));
        localObject = FinderLiveAnchorUI.a(this.ubo);
        if (localObject != null) {
          ((h)localObject).setKeyboardHeightObserver((com.tencent.mm.ui.tools.g)new com.tencent.mm.ui.tools.g()
          {
            public final void y(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(245321);
              Log.i(FinderLiveAnchorUI.b(this.ubp.ubo), "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              FinderLiveAnchorUI localFinderLiveAnchorUI = this.ubp.ubo;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                FinderLiveAnchorUI.a(localFinderLiveAnchorUI, paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(245321);
                return;
              }
            }
          });
        }
      }
      Object localObject = FinderLiveAnchorUI.a(this.ubo);
      if (localObject != null)
      {
        ((h)localObject).start();
        AppMethodBeat.o(245322);
        return;
      }
      AppMethodBeat.o(245322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI
 * JD-Core Version:    0.7.0.1
 */