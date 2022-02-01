package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.c.a;
import com.tencent.mm.plugin.finder.live.c.b;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.j;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitor;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finderLivePageFloatBallHelper", "Lcom/tencent/mm/plugin/finder/live/view/FinderLivePageFloatBallHelper;", "isKeyBoardShow", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "presenter", "Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "swipeBack", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "getLayoutId", "", "initBusiness", "", "keyboardChange", "show", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "uninitBusiness", "Companion", "plugin-finder_release"})
public abstract class FinderLiveVisitor
  extends MMFinderUI
{
  public static final a ubF = new a((byte)0);
  private HashMap _$_findViewCache;
  private h gyh;
  private boolean hwq;
  private com.tencent.mm.plugin.finder.live.d ubD;
  private FinderLiveViewCallback ubE;
  private j ubm;
  public boolean ubn;
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
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
    return localView1;
  }
  
  public final void deh()
  {
    FinderLiveViewCallback localFinderLiveViewCallback = this.ubE;
    if (localFinderLiveViewCallback != null) {
      localFinderLiveViewCallback.MC();
    }
  }
  
  public final void dei()
  {
    FinderLiveViewCallback localFinderLiveViewCallback = this.ubE;
    if (localFinderLiveViewCallback != null) {
      localFinderLiveViewCallback.deR();
    }
  }
  
  public int getLayoutId()
  {
    return 2131494454;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    FinderLiveViewCallback localFinderLiveViewCallback = this.ubE;
    if (localFinderLiveViewCallback != null) {
      localFinderLiveViewCallback.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onBackPressed " + this + ", lifecycleOwner:" + getLifecycle());
    FinderLiveViewCallback localFinderLiveViewCallback = this.ubE;
    if ((localFinderLiveViewCallback != null) && (!localFinderLiveViewCallback.onBackPressed())) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onCreate " + this + ", lifecycleOwner:" + getLifecycle());
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
    paramBundle = (FinderLiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    Object localObject = o.ujN;
    localObject = o.dfZ();
    long l;
    Lifecycle localLifecycle;
    com.tencent.mm.plugin.finder.live.d locald;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo;
      if (localObject != null)
      {
        l = ((awe)localObject).liveId;
        Log.i("Finder.FinderLiveVisitorUI", "FinderLiveVisitorUI onCreate across_live ".concat(String.valueOf(l)));
        if (paramBundle == null) {
          break label447;
        }
        localObject = paramBundle.dfu();
        if ((localObject != null) && (((LiveConfig)localObject).getLiveId() == l)) {
          break label447;
        }
        localObject = o.ujN;
        localObject = new com.tencent.mm.plugin.finder.live.viewmodel.d();
        ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject).a(paramBundle);
        o.b((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject);
        this.ubD = new com.tencent.mm.plugin.finder.live.d();
        paramBundle = findViewById(2131301253);
        p.g(paramBundle, "findViewById(R.id.finder_live_rf)");
        paramBundle = (RefreshLoadMoreLayout)paramBundle;
        localObject = (MMActivity)this;
        localLifecycle = getLifecycle();
        locald = this.ubD;
        if (locald == null) {
          p.hyc();
        }
        this.ubE = new FinderLiveViewCallback(paramBundle, (MMActivity)localObject, localLifecycle, (c.a)locald, false);
        paramBundle = this.ubD;
        if (paramBundle == null) {
          p.hyc();
        }
        localObject = this.ubE;
        if (localObject == null) {
          p.hyc();
        }
        paramBundle.a((c.b)localObject);
      }
    }
    for (;;)
    {
      this.ubm = new j((com.tencent.mm.plugin.ball.a.f)new e((Activity)this));
      paramBundle = this.ubm;
      if (paramBundle != null) {
        paramBundle.G(21, b.cjf());
      }
      return;
      l = 0L;
      break;
      label447:
      if (l != 0L)
      {
        paramBundle = o.ujN;
        paramBundle = o.dfY();
        if (paramBundle != null)
        {
          localObject = o.ujN;
          paramBundle.Jq(o.dga());
        }
        this.ubD = new com.tencent.mm.plugin.finder.live.d();
        paramBundle = findViewById(2131301253);
        p.g(paramBundle, "findViewById(R.id.finder_live_rf)");
        paramBundle = (RefreshLoadMoreLayout)paramBundle;
        localObject = (MMActivity)this;
        localLifecycle = getLifecycle();
        locald = this.ubD;
        if (locald == null) {
          p.hyc();
        }
        this.ubE = new FinderLiveViewCallback(paramBundle, (MMActivity)localObject, localLifecycle, (c.a)locald, true);
        paramBundle = this.ubD;
        if (paramBundle == null) {
          p.hyc();
        }
        localObject = this.ubE;
        if (localObject == null) {
          p.hyc();
        }
        paramBundle.a((c.b)localObject);
      }
      else
      {
        paramBundle = new StringBuilder("onCreate with invalid params [curLiveId:").append(l).append(", FinderLiveService.curLiveRoomData:");
        localObject = o.ujN;
        paramBundle = paramBundle.append(o.dfZ()).append(", FinderLiveService.liveData:");
        localObject = o.ujN;
        Log.w("Finder.FinderLiveVisitorUI", o.dfY() + ']');
      }
    }
  }
  
  public void onDestroy()
  {
    Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onDestroy " + this + ", lifecycleOwner:" + getLifecycle());
    super.onDestroy();
    Object localObject = this.ubD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.d)localObject).onDetach();
    }
    localObject = this.ubm;
    if (localObject != null) {
      ((j)localObject).onDestroy();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    FinderLiveViewCallback localFinderLiveViewCallback = this.ubE;
    if (localFinderLiveViewCallback != null) {
      localFinderLiveViewCallback.onNewIntent(paramIntent);
    }
  }
  
  public void onPause()
  {
    Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onPause " + this + ", lifecycleOwner:" + getLifecycle());
    super.onPause();
    h localh = this.gyh;
    if (localh != null) {
      localh.close();
    }
  }
  
  public void onResume()
  {
    Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onResume " + this + ", lifecycleOwner:" + getLifecycle());
    super.onResume();
    Object localObject = getContext();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.app.Activity");
    }
    localObject = ((Activity)localObject).getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null) {
        ((View)localObject).post((Runnable)new b(this));
      }
    }
  }
  
  public void onStart()
  {
    Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onStart " + this + ", lifecycleOwner:" + getLifecycle());
    super.onStart();
    j localj = this.ubm;
    if (localj != null) {
      localj.aGf();
    }
    com.tencent.mm.plugin.ball.f.f.cjk();
  }
  
  public void onStop()
  {
    Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onStop " + this + ", lifecycleOwner:" + getLifecycle());
    super.onStop();
    Object localObject = o.ujN;
    localObject = o.dfZ();
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).uDS == true))
    {
      localObject = this.ubm;
      if (localObject != null) {
        ((j)localObject).aGj();
      }
      com.tencent.mm.plugin.ball.f.f.cji();
    }
  }
  
  public void onSwipeBack()
  {
    super.onSwipeBack();
    this.ubn = true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderLiveVisitor paramFinderLiveVisitor) {}
    
    public final void run()
    {
      AppMethodBeat.i(245395);
      if (FinderLiveVisitor.a(this.ubG) == null)
      {
        localObject = this.ubG;
        AppCompatActivity localAppCompatActivity = this.ubG.getContext();
        if (localAppCompatActivity == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(245395);
          throw ((Throwable)localObject);
        }
        FinderLiveVisitor.a((FinderLiveVisitor)localObject, new h((Activity)localAppCompatActivity));
        localObject = FinderLiveVisitor.a(this.ubG);
        if (localObject != null) {
          ((h)localObject).setKeyboardHeightObserver((com.tencent.mm.ui.tools.g)new com.tencent.mm.ui.tools.g()
          {
            public final void y(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(245394);
              Log.i("Finder.FinderLiveVisitorUI", "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              FinderLiveVisitor localFinderLiveVisitor = this.ubH.ubG;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                FinderLiveVisitor.a(localFinderLiveVisitor, paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(245394);
                return;
              }
            }
          });
        }
      }
      Object localObject = FinderLiveVisitor.a(this.ubG);
      if (localObject != null)
      {
        ((h)localObject).start();
        AppMethodBeat.o(245395);
        return;
      }
      AppMethodBeat.o(245395);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitor
 * JD-Core Version:    0.7.0.1
 */