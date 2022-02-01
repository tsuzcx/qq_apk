package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.h;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "fixActionBarStatus", "", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initAfterAttach", "initOnCreate", "isHideStatusBar", "", "isOtherEnableFullScreenEnjoy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "overlayStatusBar", "plugin-finder_release"})
public abstract class FinderBaseFeedUI<V extends b.b, P extends b.a>
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
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
  
  public void ddP() {}
  
  public abstract P ddQ();
  
  public abstract V ddR();
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    y localy = y.vXH;
    if (y.isOtherEnableFullScreenEnjoy()) {
      return ak.setOf(FinderHorizontalVideoPreviewUIC.class);
    }
    return null;
  }
  
  public abstract void initOnCreate();
  
  public boolean isHideStatusBar()
  {
    y localy = y.vXH;
    return y.isOtherEnableFullScreenEnjoy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ddQ().dcg().d(paramInt1, paramIntent);
    Object localObject1 = y.vXH;
    long l1;
    if ((y.isOtherEnableFullScreenEnjoy()) && (-1 == paramInt2) && (paramInt1 == 101))
    {
      localObject1 = ddR().tLS.getRecyclerView();
      Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
      if ((localObject2 instanceof LinearLayoutManager))
      {
        localObject2 = ((RecyclerView)localObject1).ch(((LinearLayoutManager)localObject2).ks());
        localObject1 = localObject2;
        if (!(localObject2 instanceof h)) {
          localObject1 = null;
        }
        localObject1 = (h)localObject1;
        if (localObject1 != null)
        {
          localObject1 = (FinderVideoLayout)((h)localObject1).Mn(2131300776);
          if (localObject1 != null)
          {
            if (paramIntent == null) {
              break label209;
            }
            l1 = paramIntent.getLongExtra("KEY_CACHE_OBJECT_ID", -1L);
            if (paramIntent == null) {
              break label217;
            }
          }
        }
      }
    }
    label209:
    label217:
    for (long l2 = paramIntent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1L);; l2 = -1L)
    {
      Log.i("FinderBaseFeedUI", "[onActivityResult] feedId=" + d.zs(l1) + " seekTime=" + l2);
      if (l2 != -1L) {
        ((FinderVideoLayout)localObject1).setStartPlayTime(l2);
      }
      return;
      l1 = -1L;
      break;
    }
  }
  
  public void onBackPressed()
  {
    ddQ().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = y.vXH;
    int i;
    if (y.isOtherEnableFullScreenEnjoy())
    {
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.g(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      getController().p((Activity)this, getResources().getColor(2131101287));
      com.tencent.mm.ui.b.e((Activity)this, false);
      paramBundle = getSupportActionBar();
      if (paramBundle != null)
      {
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle.hide();
      }
      paramBundle = aa.jQ((Context)getContext());
      Object localObject = getBodyView();
      if (localObject == null) {
        throw new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      }
      paramBundle.inflate(2131494330, (ViewGroup)localObject, true);
      i = au.getStatusBarHeight((Context)this);
      paramBundle = (FrameLayout)_$_findCachedViewById(2131301815);
      p.g(paramBundle, "full_actionbar");
      paramBundle = paramBundle.getLayoutParams();
      paramBundle.height += i;
      localObject = (FrameLayout)_$_findCachedViewById(2131301815);
      p.g(localObject, "full_actionbar");
      ((FrameLayout)localObject).setLayoutParams(paramBundle);
      ((FrameLayout)_$_findCachedViewById(2131301815)).setPadding(0, i, 0, 0);
      ((LinearLayout)_$_findCachedViewById(2131297164)).setOnClickListener((View.OnClickListener)new a(this));
      paramBundle = getMMTitle();
      if ((paramBundle == null) || (paramBundle.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label440;
        }
        paramBundle = (TextView)_$_findCachedViewById(2131301814);
        p.g(paramBundle, "full_action_bar_title");
        paramBundle.setVisibility(8);
        label323:
        paramBundle = y.vXH;
        paramBundle = getWindow();
        p.g(paramBundle, "window");
        y.b(paramBundle, false);
        setNavigationbarColor(getResources().getColor(2131100042));
        paramBundle = (FrameLayout)_$_findCachedViewById(2131301815);
        p.g(paramBundle, "full_actionbar");
        paramBundle.setVisibility(0);
        paramBundle = findViewById(2131307118);
        if (paramBundle != null)
        {
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)new CoordinatorLayout.d(-1, -1));
          paramBundle.setBackgroundResource(2131100495);
        }
      }
    }
    for (;;)
    {
      initOnCreate();
      ddQ().a(ddR());
      ddP();
      return;
      i = 0;
      break;
      label440:
      paramBundle = (TextView)_$_findCachedViewById(2131301814);
      p.g(paramBundle, "full_action_bar_title");
      paramBundle.setVisibility(0);
      paramBundle = (TextView)_$_findCachedViewById(2131301814);
      p.g(paramBundle, "full_action_bar_title");
      paramBundle.setText(getMMTitle());
      break label323;
      setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ddQ().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    ddQ().onUIPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ddQ().onUIResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderBaseFeedUI paramFinderBaseFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245116);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tZs.onBackPressed();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245116);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderBaseFeedUI paramFinderBaseFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166127);
      this.tZs.onBackPressed();
      AppMethodBeat.o(166127);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
 * JD-Core Version:    0.7.0.1
 */