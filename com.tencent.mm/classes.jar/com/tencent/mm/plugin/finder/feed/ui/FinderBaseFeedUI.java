package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import androidx.appcompat.app.ActionBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.finder.viewmodel.component.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.w;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.i;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "fixActionBarStatus", "", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initAfterAttach", "initOnCreate", "isHideStatusBar", "", "isOtherEnableFullScreenEnjoy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "overlayStatusBar", "plugin-finder_release"})
public abstract class FinderBaseFeedUI<V extends b.b, P extends b.a>
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  private final com.tencent.mm.model.d kKI = com.tencent.mm.model.d.bcs();
  
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
  
  public void duT() {}
  
  public abstract P duU();
  
  public abstract V duV();
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    aj localaj = aj.AGc;
    if (aj.isOtherEnableFullScreenEnjoy()) {
      return ak.setOf(new Class[] { ab.class, al.class });
    }
    return null;
  }
  
  public abstract void initOnCreate();
  
  public boolean isHideStatusBar()
  {
    aj localaj = aj.AGc;
    return aj.isOtherEnableFullScreenEnjoy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    duU().dsw().d(paramInt1, paramIntent);
    Object localObject1 = aj.AGc;
    long l1;
    if ((aj.isOtherEnableFullScreenEnjoy()) && (-1 == paramInt2) && (paramInt1 == 101))
    {
      localObject1 = duV().xvJ.getRecyclerView();
      Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
      if ((localObject2 instanceof LinearLayoutManager))
      {
        localObject2 = ((RecyclerView)localObject1).cK(((LinearLayoutManager)localObject2).kJ());
        localObject1 = localObject2;
        if (!(localObject2 instanceof i)) {
          localObject1 = null;
        }
        localObject1 = (i)localObject1;
        if (localObject1 != null)
        {
          localObject1 = (FinderVideoLayout)((i)localObject1).RD(b.f.finder_banner_video_layout);
          if (localObject1 != null)
          {
            if (paramIntent == null) {
              break label214;
            }
            l1 = paramIntent.getLongExtra("KEY_CACHE_OBJECT_ID", -1L);
            if (paramIntent == null) {
              break label222;
            }
          }
        }
      }
    }
    label214:
    label222:
    for (long l2 = paramIntent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1L);; l2 = -1L)
    {
      Log.i("FinderBaseFeedUI", "[onActivityResult] feedId=" + com.tencent.mm.ae.d.Fw(l1) + " seekTime=" + l2);
      if (l2 != -1L) {
        FinderVideoLayout.a((FinderVideoLayout)localObject1, l2, 0, 0.0F, 6);
      }
      return;
      l1 = -1L;
      break;
    }
  }
  
  public void onBackPressed()
  {
    duU().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = aj.AGc;
    int i;
    if (aj.isOtherEnableFullScreenEnjoy())
    {
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      getController().q((Activity)this, getResources().getColor(b.c.transparent));
      c.f((Activity)this, false);
      paramBundle = getSupportActionBar();
      if (paramBundle != null)
      {
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle.hide();
      }
      paramBundle = ad.kS((Context)getContext());
      i = b.g.finder_full_action_bar_layout;
      Object localObject = getBodyView();
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type android.view.ViewGroup");
      }
      paramBundle.inflate(i, (ViewGroup)localObject, true);
      i = ax.getStatusBarHeight((Context)this);
      paramBundle = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
      p.j(paramBundle, "full_actionbar");
      paramBundle = paramBundle.getLayoutParams();
      paramBundle.height += i;
      localObject = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
      p.j(localObject, "full_actionbar");
      ((FrameLayout)localObject).setLayoutParams(paramBundle);
      ((FrameLayout)_$_findCachedViewById(b.f.full_actionbar)).setPadding(0, i, 0, 0);
      ((LinearLayout)_$_findCachedViewById(b.f.back_button)).setOnClickListener((View.OnClickListener)new a(this));
      paramBundle = getMMTitle();
      if ((paramBundle == null) || (paramBundle.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label443;
        }
        paramBundle = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
        p.j(paramBundle, "full_action_bar_title");
        paramBundle.setVisibility(8);
        label326:
        paramBundle = aj.AGc;
        paramBundle = getWindow();
        p.j(paramBundle, "window");
        aj.b(paramBundle, false);
        setNavigationbarColor(getResources().getColor(b.c.black));
        paramBundle = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
        p.j(paramBundle, "full_actionbar");
        paramBundle.setVisibility(0);
        paramBundle = findViewById(b.f.rl_layout);
        if (paramBundle != null)
        {
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)new CoordinatorLayout.d(-1, -1));
          paramBundle.setBackgroundResource(b.c.full_black);
        }
      }
    }
    for (;;)
    {
      initOnCreate();
      duU().a(duV());
      duT();
      return;
      i = 0;
      break;
      label443:
      paramBundle = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
      p.j(paramBundle, "full_action_bar_title");
      paramBundle.setVisibility(0);
      paramBundle = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
      p.j(paramBundle, "full_action_bar_title");
      paramBundle.setText(getMMTitle());
      break label326;
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    duU().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    duU().onUIPause();
    this.kKI.avz();
  }
  
  public void onResume()
  {
    super.onResume();
    duU().onUIResume();
    com.tencent.mm.model.d.a(this.kKI, "FinderBaseFeedUI");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderBaseFeedUI paramFinderBaseFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277756);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xLI.onBackPressed();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277756);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderBaseFeedUI paramFinderBaseFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166127);
      this.xLI.onBackPressed();
      AppMethodBeat.o(166127);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
 * JD-Core Version:    0.7.0.1
 */