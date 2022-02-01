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
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.v.a;
import com.tencent.mm.plugin.finder.feed.v.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLikeGuideUIC;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "fixActionBarStatus", "", "getModel", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initOnCreate", "isHideStatusBar", "", "isOtherEnableFullScreenEnjoy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "overlayStatusBar", "setMMTitle", "text", "", "resId", "", "plugin-finder_release"})
public abstract class FinderLoaderFeedUI<M extends BaseFinderFeedLoader, V extends v.b, P extends v.a>
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
  
  public abstract P ddK();
  
  public abstract V ddL();
  
  public abstract M ddM();
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    if (isOtherEnableFullScreenEnjoy()) {
      return ak.setOf(new Class[] { FinderHorizontalVideoPreviewUIC.class, FinderLikeGuideUIC.class });
    }
    return null;
  }
  
  public abstract void initOnCreate();
  
  public boolean isHideStatusBar()
  {
    return isOtherEnableFullScreenEnjoy();
  }
  
  public boolean isOtherEnableFullScreenEnjoy()
  {
    y localy = y.vXH;
    return y.isOtherEnableFullScreenEnjoy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    long l1;
    if ((isOtherEnableFullScreenEnjoy()) && (-1 == paramInt2) && (paramInt1 == 101))
    {
      localObject1 = ddL().tLS.getRecyclerView();
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
              break label193;
            }
            l1 = paramIntent.getLongExtra("KEY_CACHE_OBJECT_ID", -1L);
            if (paramIntent == null) {
              break label201;
            }
          }
        }
      }
    }
    label193:
    label201:
    for (long l2 = paramIntent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1L);; l2 = -1L)
    {
      Log.i("FinderLoaderFeedUI", "[onActivityResult] feedId=" + d.zs(l1) + " seekTime=" + l2);
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
    ddK().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject;
    int i;
    if (isOtherEnableFullScreenEnjoy())
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
      localObject = getBodyView();
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
      ((FrameLayout)_$_findCachedViewById(2131301815)).setOnClickListener((View.OnClickListener)new b(this));
      paramBundle = getMMTitle();
      if ((paramBundle == null) || (paramBundle.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label486;
        }
        paramBundle = (TextView)_$_findCachedViewById(2131301814);
        p.g(paramBundle, "full_action_bar_title");
        paramBundle.setVisibility(8);
        label344:
        paramBundle = y.vXH;
        paramBundle = getWindow();
        p.g(paramBundle, "window");
        y.b(paramBundle, false);
        setNavigationbarColor(getResources().getColor(2131100042));
        paramBundle = (FrameLayout)_$_findCachedViewById(2131301815);
        p.g(paramBundle, "full_actionbar");
        paramBundle.setVisibility(0);
        paramBundle = findViewById(2131307118);
        if (paramBundle != null) {
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)new CoordinatorLayout.d(-1, -1));
        }
      }
    }
    for (;;)
    {
      initOnCreate();
      paramBundle = ddK();
      localObject = ddL();
      paramBundle.a(ddM(), (v.b)localObject);
      if (!isOtherEnableFullScreenEnjoy()) {
        setTitleBarClickListener((Runnable)new d((v.b)localObject), (Runnable)e.ubL);
      }
      return;
      i = 0;
      break;
      label486:
      paramBundle = (TextView)_$_findCachedViewById(2131301814);
      p.g(paramBundle, "full_action_bar_title");
      paramBundle.setVisibility(0);
      paramBundle = (TextView)_$_findCachedViewById(2131301814);
      p.g(paramBundle, "full_action_bar_title");
      paramBundle.setText(getMMTitle());
      break label344;
      setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ddK().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    ddK().onUIPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ddK().onUIResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle = ddM();
    Intent localIntent = getIntent();
    p.g(localIntent, "intent");
    BaseFeedLoader.saveCache$default(paramBundle, localIntent, ddM().getInitPos(), null, 4, null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMTitle(int paramInt)
  {
    super.setMMTitle(paramInt);
    if (isOtherEnableFullScreenEnjoy())
    {
      localObject = getMMTitle();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label61;
      }
    }
    label61:
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      localObject = (TextView)_$_findCachedViewById(2131301814);
      p.g(localObject, "full_action_bar_title");
      ((TextView)localObject).setVisibility(8);
      return;
    }
    Object localObject = (TextView)_$_findCachedViewById(2131301814);
    p.g(localObject, "full_action_bar_title");
    ((TextView)localObject).setVisibility(0);
    localObject = (TextView)_$_findCachedViewById(2131301814);
    p.g(localObject, "full_action_bar_title");
    ((TextView)localObject).setText(getMMTitle());
  }
  
  public void setMMTitle(CharSequence paramCharSequence)
  {
    super.setMMTitle(paramCharSequence);
    if (isOtherEnableFullScreenEnjoy())
    {
      paramCharSequence = getMMTitle();
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
        break label61;
      }
    }
    label61:
    for (int i = 1; i != 0; i = 0)
    {
      paramCharSequence = (TextView)_$_findCachedViewById(2131301814);
      p.g(paramCharSequence, "full_action_bar_title");
      paramCharSequence.setVisibility(8);
      return;
    }
    paramCharSequence = (TextView)_$_findCachedViewById(2131301814);
    p.g(paramCharSequence, "full_action_bar_title");
    paramCharSequence.setVisibility(0);
    paramCharSequence = (TextView)_$_findCachedViewById(2131301814);
    p.g(paramCharSequence, "full_action_bar_title");
    paramCharSequence.setText(getMMTitle());
  }
  
  public void setMMTitle(String paramString)
  {
    super.setMMTitle(paramString);
    if (isOtherEnableFullScreenEnjoy())
    {
      paramString = getMMTitle();
      if ((paramString != null) && (paramString.length() != 0)) {
        break label61;
      }
    }
    label61:
    for (int i = 1; i != 0; i = 0)
    {
      paramString = (TextView)_$_findCachedViewById(2131301814);
      p.g(paramString, "full_action_bar_title");
      paramString.setVisibility(8);
      return;
    }
    paramString = (TextView)_$_findCachedViewById(2131301814);
    p.g(paramString, "full_action_bar_title");
    paramString.setVisibility(0);
    paramString = (TextView)_$_findCachedViewById(2131301814);
    p.g(paramString, "full_action_bar_title");
    paramString.setText(getMMTitle());
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderLoaderFeedUI paramFinderLoaderFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245410);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.ubJ.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245410);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderLoaderFeedUI paramFinderLoaderFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245411);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$fixActionBarStatus$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.ubJ.ddL().tLS.getRecyclerView();
      localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$fixActionBarStatus$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$fixActionBarStatus$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$fixActionBarStatus$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245411);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderLoaderFeedUI paramFinderLoaderFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166128);
      this.ubJ.onBackPressed();
      AppMethodBeat.o(166128);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "run"})
  static final class d
    implements Runnable
  {
    d(v.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(166129);
      RecyclerView localRecyclerView = this.ubK.tLS.getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$onCreate$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$onCreate$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(166129);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "run"})
  static final class e
    implements Runnable
  {
    public static final e ubL;
    
    static
    {
      AppMethodBeat.i(166130);
      ubL = new e();
      AppMethodBeat.o(166130);
    }
    
    public final void run() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
 * JD-Core Version:    0.7.0.1
 */