package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "anchorPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout;", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "keyboardChange", "", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "plugin-finder-live_release"})
public final class FinderLiveAnchorUI
  extends MMFinderUI
{
  private final String TAG = "MicroMsg.FinderLiveAnchorUI";
  private HashMap _$_findViewCache;
  private com.tencent.mm.ui.tools.i jij;
  private boolean kiD;
  private boolean xOB;
  private com.tencent.mm.plugin.finder.live.view.b xOD;
  private com.tencent.mm.plugin.finder.live.view.f xOE;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233124);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233124);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233123);
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
    AppMethodBeat.o(233123);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_root;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(233099);
    Set localSet = ak.setOf(com.tencent.mm.plugin.finder.live.viewmodel.i.class);
    AppMethodBeat.o(233099);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(233119);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.live.view.b localb = this.xOD;
    if (localb != null)
    {
      localb.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(233119);
      return;
    }
    AppMethodBeat.o(233119);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(233117);
    com.tencent.mm.plugin.finder.live.view.b localb = this.xOD;
    if (localb != null)
    {
      if (!localb.onBackPress()) {
        super.onBackPressed();
      }
      AppMethodBeat.o(233117);
      return;
    }
    AppMethodBeat.o(233117);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233107);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    FinderLiveBundle localFinderLiveBundle = (FinderLiveBundle)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    this.xOD = new com.tencent.mm.plugin.finder.live.view.b((MMActivity)this, null);
    ((FrameLayout)findViewById(b.f.finder_live_content_root)).addView((View)this.xOD);
    paramBundle = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    paramBundle = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    int i;
    label262:
    label297:
    boolean bool;
    if (paramBundle != null)
    {
      paramBundle = (c)paramBundle.business(c.class);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.liveInfo;
        if (paramBundle != null)
        {
          paramBundle = Long.valueOf(paramBundle.liveId);
          if (localFinderLiveBundle == null) {
            break label450;
          }
          if (((Collection)localFinderLiveBundle.yeC).isEmpty()) {
            break label439;
          }
          i = 1;
          if (i == 0) {
            break label450;
          }
          localObject1 = (LiveConfig)j.lp((List)localFinderLiveBundle.yeC);
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = Long.valueOf(((LiveConfig)localObject1).getLiveId());
          if (!(p.h(localObject1, paramBundle) ^ true)) {
            break label450;
          }
          localObject1 = (LiveConfig)j.lp((List)localFinderLiveBundle.yeC);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            paramBundle = LiveConfig.an("", 0);
            p.j(paramBundle, "LiveConfig.getDefaultAnchorConfig(\"\", 0)");
          }
          paramBundle = new com.tencent.mm.plugin.finder.live.viewmodel.data.f(paramBundle);
          bool = false;
        }
      }
    }
    for (;;)
    {
      localObject1 = "onCreate isFromFloat:" + bool + ", finderLiveData:" + paramBundle;
      Log.i(this.TAG, (String)localObject1);
      localObject2 = com.tencent.mm.plugin.findersdk.f.b.Bxg;
      com.tencent.mm.plugin.findersdk.f.b.hA(this.TAG, (String)localObject1);
      if (paramBundle != null) {
        break label524;
      }
      Log.w(this.TAG, "unkonwn data source! finish!");
      finish();
      AppMethodBeat.o(233107);
      return;
      paramBundle = null;
      break;
      label439:
      i = 0;
      break label262;
      label444:
      localObject1 = null;
      break label297;
      label450:
      if (paramBundle == null) {}
      while (paramBundle.longValue() != 0L)
      {
        paramBundle = ah.yhC;
        paramBundle = ah.dwh();
        if (paramBundle == null) {
          break label517;
        }
        paramBundle = paramBundle.zeA;
        if (paramBundle == null) {
          break label517;
        }
        paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)j.lp((List)paramBundle);
        bool = true;
        break;
      }
      Log.w(this.TAG, "unkonwn data source! break onCreate");
      paramBundle = null;
      bool = false;
      continue;
      label517:
      paramBundle = null;
      bool = true;
    }
    label524:
    Object localObject1 = ah.yhC;
    localObject1 = new g();
    ((g)localObject1).aj(j.ag(new com.tencent.mm.plugin.finder.live.viewmodel.data.f[] { paramBundle }));
    ah.a((g)localObject1);
    localObject1 = getIntent().getByteArrayExtra("KEY_PARAMS_NOTICE");
    if (localObject1 != null)
    {
      paramBundle.xUD = new bbh();
      localObject2 = paramBundle.xUD;
      if (localObject2 == null) {
        p.iCn();
      }
      ((bbh)localObject2).parseFrom((byte[])localObject1);
    }
    localObject1 = ah.yhC;
    Object localObject2 = ah.a(paramBundle);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.finder.live.model.context.a();
    }
    localObject2 = this.xOD;
    if (localObject2 != null) {
      com.tencent.mm.plugin.finder.live.view.a.bindData$default((com.tencent.mm.plugin.finder.live.view.a)localObject2, paramBundle, false, 2, null);
    }
    localObject2 = ah.yhC;
    com.tencent.mm.plugin.finder.live.view.b localb = this.xOD;
    if (localb == null) {
      p.iCn();
    }
    ah.a((ah)localObject2, (com.tencent.mm.plugin.finder.live.model.context.a)localObject1, (com.tencent.mm.plugin.finder.live.view.a)localb, 0, 0, null, 24);
    localObject1 = this.xOD;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject1).activate(paramBundle, bool, false);
    }
    localObject1 = this.xOD;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject1).mount();
    }
    paramBundle.xUD = new bbh();
    this.xOE = new com.tencent.mm.plugin.finder.live.view.f((com.tencent.mm.plugin.ball.a.f)new e((Activity)this));
    localObject1 = this.xOE;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject1).I(21, com.tencent.mm.plugin.ball.f.b.cwx());
    }
    localObject1 = k.yBj;
    k.a(paramBundle, localFinderLiveBundle);
    AppMethodBeat.o(233107);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(233116);
    super.onDestroy();
    Object localObject = this.xOD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject).unMount();
    }
    localObject = this.xOE;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).onDestroy();
      AppMethodBeat.o(233116);
      return;
    }
    AppMethodBeat.o(233116);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(233101);
    super.onNewIntent(paramIntent);
    com.tencent.mm.plugin.finder.live.view.b localb = this.xOD;
    if (localb != null)
    {
      localb.onNewIntent(paramIntent);
      AppMethodBeat.o(233101);
      return;
    }
    AppMethodBeat.o(233101);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(233113);
    super.onPause();
    Object localObject = this.jij;
    if (localObject != null) {
      ((com.tencent.mm.ui.tools.i)localObject).close();
    }
    localObject = this.xOD;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject).pause();
      AppMethodBeat.o(233113);
      return;
    }
    AppMethodBeat.o(233113);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(233111);
    super.onResume();
    com.tencent.mm.plugin.finder.live.view.b localb = this.xOD;
    if (localb != null) {
      localb.resume();
    }
    localb = this.xOD;
    if (localb != null)
    {
      localb.post((Runnable)new a(this));
      AppMethodBeat.o(233111);
      return;
    }
    AppMethodBeat.o(233111);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(233109);
    super.onStart();
    Object localObject = this.xOD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject).start();
    }
    localObject = this.xOE;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).aOf();
    }
    com.tencent.mm.plugin.ball.f.f.cvI();
    AppMethodBeat.o(233109);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(233115);
    super.onStop();
    Object localObject = this.xOD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject).stop();
    }
    localObject = this.xOE;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).aOj();
    }
    com.tencent.mm.plugin.ball.f.f.cwA();
    AppMethodBeat.o(233115);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(233118);
    super.onSwipeBack();
    this.xOB = true;
    AppMethodBeat.o(233118);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderLiveAnchorUI paramFinderLiveAnchorUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(233459);
      if (FinderLiveAnchorUI.a(this.xOF) == null)
      {
        localObject = this.xOF;
        AppCompatActivity localAppCompatActivity = this.xOF.getContext();
        if (localAppCompatActivity == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(233459);
          throw ((Throwable)localObject);
        }
        FinderLiveAnchorUI.a((FinderLiveAnchorUI)localObject, new com.tencent.mm.ui.tools.i((Activity)localAppCompatActivity));
        localObject = FinderLiveAnchorUI.a(this.xOF);
        if (localObject != null) {
          ((com.tencent.mm.ui.tools.i)localObject).setKeyboardHeightObserver((h)new h()
          {
            public final void A(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(232448);
              Log.i(FinderLiveAnchorUI.b(this.xOG.xOF), "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              FinderLiveAnchorUI localFinderLiveAnchorUI = this.xOG.xOF;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                FinderLiveAnchorUI.a(localFinderLiveAnchorUI, paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(232448);
                return;
              }
            }
          });
        }
      }
      Object localObject = FinderLiveAnchorUI.a(this.xOF);
      if (localObject != null)
      {
        ((com.tencent.mm.ui.tools.i)localObject).start();
        AppMethodBeat.o(233459);
        return;
      }
      AppMethodBeat.o(233459);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI
 * JD-Core Version:    0.7.0.1
 */