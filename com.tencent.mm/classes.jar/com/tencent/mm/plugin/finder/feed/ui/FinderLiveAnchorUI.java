package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.live.viewmodel.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.i;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "anchorPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveAnchorPluginLayout;", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "keyboardChange", "", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveAnchorUI
  extends MMFinderUI
{
  private boolean BoA;
  private com.tencent.mm.plugin.finder.live.view.b BoC;
  private com.tencent.mm.plugin.finder.live.view.f BoD;
  private final String TAG = "MicroMsg.FinderLiveAnchorUI";
  private i lKz;
  private boolean mJk;
  
  private static final void a(FinderLiveAnchorUI paramFinderLiveAnchorUI)
  {
    AppMethodBeat.i(364414);
    s.u(paramFinderLiveAnchorUI, "this$0");
    if (paramFinderLiveAnchorUI.lKz == null)
    {
      Object localObject = paramFinderLiveAnchorUI.getContext();
      if (localObject == null)
      {
        paramFinderLiveAnchorUI = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(364414);
        throw paramFinderLiveAnchorUI;
      }
      paramFinderLiveAnchorUI.lKz = new i((Activity)localObject);
      localObject = paramFinderLiveAnchorUI.lKz;
      if (localObject != null) {
        ((i)localObject).afIL = new FinderLiveAnchorUI..ExternalSyntheticLambda0(paramFinderLiveAnchorUI);
      }
    }
    paramFinderLiveAnchorUI = paramFinderLiveAnchorUI.lKz;
    if (paramFinderLiveAnchorUI != null) {
      paramFinderLiveAnchorUI.start();
    }
    AppMethodBeat.o(364414);
  }
  
  private static final void a(FinderLiveAnchorUI paramFinderLiveAnchorUI, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(364402);
    s.u(paramFinderLiveAnchorUI, "this$0");
    Log.i(paramFinderLiveAnchorUI.TAG, "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (paramInt > 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramFinderLiveAnchorUI.mJk != paramBoolean)
      {
        paramFinderLiveAnchorUI.mJk = paramBoolean;
        paramFinderLiveAnchorUI = paramFinderLiveAnchorUI.BoC;
        if (paramFinderLiveAnchorUI != null) {
          paramFinderLiveAnchorUI.keyboardChange(paramBoolean, paramInt);
        }
      }
      AppMethodBeat.o(364402);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return p.f.Cfw;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364446);
    Set localSet = ar.setOf(k.class);
    AppMethodBeat.o(364446);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(364596);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.live.view.b localb = this.BoC;
    if (localb != null) {
      localb.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(364596);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(364571);
    com.tencent.mm.plugin.finder.live.view.b localb = this.BoC;
    if ((localb != null) && (!localb.onBackPress())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        super.onBackPressed();
      }
      AppMethodBeat.o(364571);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364496);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      getWindow().getDecorView().setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    FinderLiveBundle localFinderLiveBundle = (FinderLiveBundle)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    this.BoC = new com.tencent.mm.plugin.finder.live.view.b((MMActivity)this, null);
    ((FrameLayout)findViewById(p.e.BKe)).addView((View)this.BoC);
    paramBundle = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    paramBundle = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    int i;
    label201:
    label229:
    boolean bool;
    if (paramBundle == null)
    {
      paramBundle = null;
      if (localFinderLiveBundle == null) {
        break label427;
      }
      if (((Collection)localFinderLiveBundle.CFa).isEmpty()) {
        break label409;
      }
      i = 1;
      if (i == 0) {
        break label427;
      }
      localObject1 = (LiveConfig)p.oL((List)localFinderLiveBundle.CFa);
      if (localObject1 != null) {
        break label414;
      }
      localObject1 = null;
      if (s.p(localObject1, paramBundle)) {
        break label427;
      }
      localObject1 = (LiveConfig)p.oL((List)localFinderLiveBundle.CFa);
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = LiveConfig.aw("", 0);
      }
      s.s(paramBundle, "configProvider.liveConfi…efaultAnchorConfig(\"\", 0)");
      paramBundle = new com.tencent.mm.plugin.finder.live.viewmodel.data.f(paramBundle);
      bool = false;
    }
    for (;;)
    {
      localObject1 = "onCreate isFromFloat:" + bool + ", finderLiveData:" + paramBundle;
      Log.i(this.TAG, (String)localObject1);
      localObject2 = com.tencent.mm.plugin.findersdk.f.b.HeJ;
      com.tencent.mm.plugin.findersdk.f.b.iz(this.TAG, (String)localObject1);
      if (paramBundle != null) {
        break label508;
      }
      Log.w(this.TAG, "unkonwn data source! finish!");
      finish();
      AppMethodBeat.o(364496);
      return;
      paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramBundle.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (paramBundle == null)
      {
        paramBundle = null;
        break;
      }
      paramBundle = paramBundle.liveInfo;
      if (paramBundle == null)
      {
        paramBundle = null;
        break;
      }
      paramBundle = Long.valueOf(paramBundle.liveId);
      break;
      label409:
      i = 0;
      break label201;
      label414:
      localObject1 = Long.valueOf(((LiveConfig)localObject1).liveId);
      break label229;
      label427:
      if (paramBundle == null) {}
      while (paramBundle.longValue() != 0L)
      {
        paramBundle = aj.CGT;
        paramBundle = aj.egD();
        if (paramBundle != null) {
          break label476;
        }
        paramBundle = null;
        bool = true;
        break;
      }
      Log.w(this.TAG, "unkonwn data source! break onCreate");
      paramBundle = null;
      bool = false;
      continue;
      label476:
      paramBundle = paramBundle.Ebx;
      if (paramBundle == null)
      {
        paramBundle = null;
        bool = true;
      }
      else
      {
        paramBundle = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)p.oL((List)paramBundle);
        bool = true;
      }
    }
    label508:
    Object localObject1 = aj.CGT;
    localObject1 = new g();
    ((g)localObject1).an(p.al(new com.tencent.mm.plugin.finder.live.viewmodel.data.f[] { paramBundle }));
    Object localObject2 = ah.aiuX;
    aj.a((g)localObject1);
    localObject1 = getIntent().getByteArrayExtra("KEY_PARAMS_NOTICE");
    if (localObject1 != null)
    {
      paramBundle.BvE = new bkk();
      localObject2 = paramBundle.BvE;
      s.checkNotNull(localObject2);
      ((bkk)localObject2).parseFrom((byte[])localObject1);
    }
    localObject1 = aj.CGT;
    localObject2 = aj.a(paramBundle);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.finder.live.model.context.a();
    }
    localObject2 = this.BoC;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject2).bindData(paramBundle);
    }
    localObject2 = aj.CGT;
    com.tencent.mm.plugin.finder.live.view.b localb = this.BoC;
    s.checkNotNull(localb);
    aj.a((aj)localObject2, (com.tencent.mm.plugin.finder.live.model.context.a)localObject1, (com.tencent.mm.plugin.finder.live.view.a)localb, 0, null, 12);
    localObject1 = this.BoC;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject1).activate(paramBundle, bool, false);
    }
    localObject1 = this.BoC;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject1).mount();
    }
    paramBundle.BvE = new bkk();
    this.BoD = new com.tencent.mm.plugin.finder.live.view.f((com.tencent.mm.plugin.ball.a.f)new e((Activity)this));
    localObject1 = this.BoD;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject1).J(21, "LiveFloatBall");
    }
    j.Dob.a(paramBundle, localFinderLiveBundle);
    AppMethodBeat.o(364496);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364561);
    super.onDestroy();
    Object localObject = this.BoC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject).unMount();
    }
    localObject = this.BoD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).onDestroy();
    }
    AppMethodBeat.o(364561);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(364458);
    super.onNewIntent(paramIntent);
    com.tencent.mm.plugin.finder.live.view.b localb = this.BoC;
    if (localb != null) {
      localb.onNewIntent(paramIntent);
    }
    AppMethodBeat.o(364458);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(364540);
    super.onPause();
    Object localObject = this.lKz;
    if (localObject != null) {
      ((i)localObject).close();
    }
    localObject = this.BoC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject).pause();
    }
    AppMethodBeat.o(364540);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364526);
    super.onResume();
    com.tencent.mm.plugin.finder.live.view.b localb = this.BoC;
    if (localb != null) {
      localb.resume();
    }
    localb = this.BoC;
    if (localb != null) {
      localb.post(new FinderLiveAnchorUI..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(364526);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(364511);
    super.onStart();
    Object localObject = this.BoC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject).start();
    }
    localObject = this.BoD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).bhT();
    }
    com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    AppMethodBeat.o(364511);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(364551);
    super.onStop();
    Object localObject = this.BoC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.b)localObject).stop();
    }
    localObject = this.BoD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.f)localObject).bhW();
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(364551);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(364584);
    super.onSwipeBack();
    this.BoA = true;
    AppMethodBeat.o(364584);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorUI
 * JD-Core Version:    0.7.0.1
 */