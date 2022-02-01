package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.ui.MMFinderFeedDetailUI;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.ae;
import com.tencent.mm.plugin.finder.viewmodel.component.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.j;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderFeedDetailUI;", "()V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "fixActionBarStatus", "", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initAfterAttach", "initOnCreate", "isHideStatusBar", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "overlayStatusBar", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderBaseFeedUI<V extends b.b, P extends b.a>
  extends MMFinderFeedDetailUI
{
  private final com.tencent.mm.model.d nmW = new com.tencent.mm.model.d();
  
  private static final void a(FinderBaseFeedUI paramFinderBaseFeedUI, View paramView)
  {
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderBaseFeedUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderBaseFeedUI, "this$0");
    paramFinderBaseFeedUI.onBackPressed();
    a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public void eeB() {}
  
  public abstract P eeC();
  
  public abstract V eeD();
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    return ar.setOf(new Class[] { ag.class, ae.class, com.tencent.mm.plugin.finder.viewmodel.component.av.class, com.tencent.mm.plugin.finder.viewmodel.component.f.class });
  }
  
  public abstract void initOnCreate();
  
  public boolean isHideStatusBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    eeC().ebA().g(paramInt1, paramIntent);
    Object localObject;
    long l1;
    if ((-1 == paramInt2) && (paramInt1 == 101))
    {
      localObject = eeD().ATx.getRecyclerView();
      RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
      if ((localLayoutManager instanceof LinearLayoutManager))
      {
        localObject = ((RecyclerView)localObject).fU(((LinearLayoutManager)localLayoutManager).Ju());
        if (!(localObject instanceof j)) {
          break label184;
        }
        localObject = (j)localObject;
        if (localObject != null)
        {
          localObject = (FinderVideoLayout)((j)localObject).UH(e.e.finder_banner_video_layout);
          if (localObject != null)
          {
            if (paramIntent != null) {
              break label190;
            }
            l1 = -1L;
            label119:
            if (paramIntent != null) {
              break label204;
            }
          }
        }
      }
    }
    label184:
    label190:
    label204:
    for (long l2 = -1L;; l2 = paramIntent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1L))
    {
      Log.i("FinderBaseFeedUI", "[onActivityResult] feedId=" + com.tencent.mm.ae.d.hF(l1) + " seekTime=" + l2);
      if (l2 != -1L) {
        FinderVideoLayout.a((FinderVideoLayout)localObject, l2, 0, 0.0F, 6);
      }
      return;
      localObject = null;
      break;
      l1 = paramIntent.getLongExtra("KEY_CACHE_OBJECT_ID", -1L);
      break label119;
    }
  }
  
  public void onBackPressed()
  {
    eeC().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow().getDecorView();
    s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
    getWindow().setStatusBarColor(0);
    getController().s((Activity)this, getResources().getColor(e.b.transparent));
    c.h((Activity)this, false);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    paramBundle = af.mU((Context)getContext());
    int i = e.f.finder_full_action_bar_layout;
    View localView = getBodyView();
    if (localView == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    paramBundle.inflate(i, (ViewGroup)localView, true);
    i = bf.getStatusBarHeight((Context)this);
    ((FrameLayout)findViewById(e.e.full_actionbar)).setPadding(0, i, 0, 0);
    ((LinearLayout)findViewById(e.e.back_button)).setOnClickListener(new FinderBaseFeedUI..ExternalSyntheticLambda0(this));
    paramBundle = getMMTitle();
    if ((paramBundle == null) || (paramBundle.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label340;
      }
      ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(8);
    }
    for (;;)
    {
      paramBundle = com.tencent.mm.plugin.finder.utils.av.GiL;
      paramBundle = getWindow();
      s.s(paramBundle, "window");
      com.tencent.mm.plugin.finder.utils.av.d(paramBundle);
      setNavigationbarColor(getResources().getColor(e.b.black));
      ((FrameLayout)findViewById(e.e.full_actionbar)).setVisibility(0);
      paramBundle = findViewById(e.e.rl_layout);
      if (paramBundle != null)
      {
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)new CoordinatorLayout.d(-1, -1));
        paramBundle.setBackgroundResource(e.b.full_black);
      }
      initOnCreate();
      eeC().a(eeD());
      eeB();
      return;
      i = 0;
      break;
      label340:
      ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(0);
      ((TextView)findViewById(e.e.full_action_bar_title)).setText(getMMTitle());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    eeC().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    eeC().onUIPause();
    this.nmW.gR(false);
  }
  
  public void onResume()
  {
    super.onResume();
    eeC().onUIResume();
    com.tencent.mm.model.d.a(this.nmW, "FinderBaseFeedUI");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI
 * JD-Core Version:    0.7.0.1
 */