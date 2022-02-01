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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.aa.a;
import com.tencent.mm.plugin.finder.feed.aa.b;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.ac;
import com.tencent.mm.plugin.finder.viewmodel.component.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ax;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "preNavColor", "", "getPreNavColor", "()I", "setPreNavColor", "(I)V", "fixActionBarStatus", "", "getModel", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initOnCreate", "isHideStatusBar", "", "isOtherEnableFullScreenEnjoy", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "overlayStatusBar", "setMMTitle", "text", "", "resId", "", "plugin-finder_release"})
public abstract class FinderLoaderFeedUI<M extends BaseFinderFeedLoader, V extends aa.b, P extends aa.a>
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  private final com.tencent.mm.model.d kKI = com.tencent.mm.model.d.bcs();
  private int xQB;
  
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
  
  public abstract P duO();
  
  public abstract V duP();
  
  public abstract M duQ();
  
  public final int dvH()
  {
    return this.xQB;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    if (isOtherEnableFullScreenEnjoy()) {
      return ak.setOf(new Class[] { ab.class, al.class, ac.class });
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
    aj localaj = aj.AGc;
    return aj.isOtherEnableFullScreenEnjoy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    long l1;
    if ((isOtherEnableFullScreenEnjoy()) && (-1 == paramInt2) && (paramInt1 == 101))
    {
      localObject1 = duP().xvJ.getRecyclerView();
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
              break label198;
            }
            l1 = paramIntent.getLongExtra("KEY_CACHE_OBJECT_ID", -1L);
            if (paramIntent == null) {
              break label206;
            }
          }
        }
      }
    }
    label198:
    label206:
    for (long l2 = paramIntent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1L);; l2 = -1L)
    {
      Log.i("FinderLoaderFeedUI", "[onActivityResult] feedId=" + com.tencent.mm.ae.d.Fw(l1) + " seekTime=" + l2);
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
    duO().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i;
    Object localObject;
    if (isOtherEnableFullScreenEnjoy())
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
      com.tencent.mm.ui.c.f((Activity)this, false);
      paramBundle = getSupportActionBar();
      if (paramBundle != null)
      {
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle.hide();
      }
      paramBundle = ad.kS((Context)getContext());
      i = b.g.finder_full_action_bar_layout;
      localObject = getBodyView();
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
          break label502;
        }
        paramBundle = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
        p.j(paramBundle, "full_action_bar_title");
        paramBundle.setVisibility(8);
        label325:
        paramBundle = aj.AGc;
        paramBundle = getWindow();
        p.j(paramBundle, "window");
        aj.b(paramBundle, false);
        paramBundle = getWindow();
        p.j(paramBundle, "window");
        this.xQB = paramBundle.getNavigationBarColor();
        setNavigationbarColor(getResources().getColor(b.c.black));
        paramBundle = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
        p.j(paramBundle, "full_actionbar");
        paramBundle.setVisibility(0);
        paramBundle = findViewById(b.f.rl_layout);
        if (paramBundle != null)
        {
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)new CoordinatorLayout.d(-1, -1));
          paramBundle.setBackgroundColor(getResources().getColor(b.c.full_black));
        }
      }
    }
    for (;;)
    {
      initOnCreate();
      paramBundle = duO();
      localObject = duP();
      paramBundle.a(duQ(), (aa.b)localObject);
      if (!isOtherEnableFullScreenEnjoy()) {
        setTitleBarClickListener((Runnable)new c((aa.b)localObject), (Runnable)d.xQE);
      }
      return;
      i = 0;
      break;
      label502:
      paramBundle = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
      p.j(paramBundle, "full_action_bar_title");
      paramBundle.setVisibility(0);
      paramBundle = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
      p.j(paramBundle, "full_action_bar_title");
      paramBundle.setText(getMMTitle());
      break label325;
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    duO().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    duO().onUIPause();
    this.kKI.avz();
  }
  
  public void onResume()
  {
    super.onResume();
    duO().onUIResume();
    com.tencent.mm.model.d.a(this.kKI, "FinderLoaderFeedUI");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    p.k(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    paramBundle = duQ();
    Intent localIntent = getIntent();
    p.j(localIntent, "intent");
    BaseFeedLoader.saveCache$default(paramBundle, localIntent, duQ().getInitPos(), null, 4, null);
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
      localObject = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
      p.j(localObject, "full_action_bar_title");
      ((TextView)localObject).setVisibility(8);
      return;
    }
    Object localObject = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
    p.j(localObject, "full_action_bar_title");
    ((TextView)localObject).setVisibility(0);
    localObject = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
    p.j(localObject, "full_action_bar_title");
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
      paramCharSequence = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
      p.j(paramCharSequence, "full_action_bar_title");
      paramCharSequence.setVisibility(8);
      return;
    }
    paramCharSequence = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
    p.j(paramCharSequence, "full_action_bar_title");
    paramCharSequence.setVisibility(0);
    paramCharSequence = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
    p.j(paramCharSequence, "full_action_bar_title");
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
      paramString = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
      p.j(paramString, "full_action_bar_title");
      paramString.setVisibility(8);
      return;
    }
    paramString = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
    p.j(paramString, "full_action_bar_title");
    paramString.setVisibility(0);
    paramString = (TextView)_$_findCachedViewById(b.f.full_action_bar_title);
    p.j(paramString, "full_action_bar_title");
    paramString.setText(getMMTitle());
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderLoaderFeedUI paramFinderLoaderFeedUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(284866);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xQC.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(284866);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderLoaderFeedUI paramFinderLoaderFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(166128);
      this.xQC.onBackPressed();
      AppMethodBeat.o(166128);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "run"})
  static final class c
    implements Runnable
  {
    c(aa.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(166129);
      RecyclerView localRecyclerView = this.xQD.xvJ.getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$onCreate$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$onCreate$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(166129);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "run"})
  static final class d
    implements Runnable
  {
    public static final d xQE;
    
    static
    {
      AppMethodBeat.i(166130);
      xQE = new d();
      AppMethodBeat.o(166130);
    }
    
    public final void run() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
 * JD-Core Version:    0.7.0.1
 */