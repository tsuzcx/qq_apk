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
import com.tencent.mm.plugin.finder.feed.ae.a;
import com.tencent.mm.plugin.finder.feed.ae.b;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.ui.MMFinderFeedDetailUI;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.ae;
import com.tencent.mm.plugin.finder.viewmodel.component.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.ah;
import com.tencent.mm.plugin.finder.viewmodel.component.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.j;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderFeedDetailUI;", "()V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "preNavColor", "", "getPreNavColor", "()I", "setPreNavColor", "(I)V", "fixActionBarStatus", "", "getModel", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initOnCreate", "isHideStatusBar", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "overlayStatusBar", "setMMTitle", "text", "", "resId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderLoaderFeedUI<M extends BaseFinderFeedLoader, V extends ae.b, P extends ae.a>
  extends MMFinderFeedDetailUI
{
  private int Bqc;
  private final com.tencent.mm.model.d nmW = new com.tencent.mm.model.d();
  
  private static final void a(FinderLoaderFeedUI paramFinderLoaderFeedUI, View paramView)
  {
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLoaderFeedUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLoaderFeedUI, "this$0");
    paramFinderLoaderFeedUI.onBackPressed();
    a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public abstract P eef();
  
  public abstract V eeg();
  
  public abstract M eeh();
  
  public final int efA()
  {
    return this.Bqc;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    return ar.setOf(new Class[] { ag.class, ae.class, com.tencent.mm.plugin.finder.viewmodel.component.av.class, ah.class, f.class, com.tencent.mm.plugin.finder.viewmodel.component.c.class });
  }
  
  public abstract void initOnCreate();
  
  public boolean isHideStatusBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    long l1;
    if ((-1 == paramInt2) && (paramInt1 == 101))
    {
      localObject = eeg().ATx.getRecyclerView();
      RecyclerView.LayoutManager localLayoutManager = ((RecyclerView)localObject).getLayoutManager();
      if ((localLayoutManager instanceof LinearLayoutManager))
      {
        localObject = ((RecyclerView)localObject).fU(((LinearLayoutManager)localLayoutManager).Ju());
        if (!(localObject instanceof j)) {
          break label172;
        }
        localObject = (j)localObject;
        if (localObject != null)
        {
          localObject = (FinderVideoLayout)((j)localObject).UH(e.e.finder_banner_video_layout);
          if (localObject != null)
          {
            if (paramIntent != null) {
              break label178;
            }
            l1 = -1L;
            label107:
            if (paramIntent != null) {
              break label192;
            }
          }
        }
      }
    }
    label172:
    label178:
    label192:
    for (long l2 = -1L;; l2 = paramIntent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1L))
    {
      Log.i("FinderLoaderFeedUI", "[onActivityResult] feedId=" + com.tencent.mm.ae.d.hF(l1) + " seekTime=" + l2);
      if (l2 != -1L) {
        FinderVideoLayout.a((FinderVideoLayout)localObject, l2, 0, 0.0F, 6);
      }
      return;
      localObject = null;
      break;
      l1 = paramIntent.getLongExtra("KEY_CACHE_OBJECT_ID", -1L);
      break label107;
    }
  }
  
  public void onBackPressed()
  {
    Iterator localIterator = ((Iterable)getUiComponents()).iterator();
    while (localIterator.hasNext()) {
      if (((UIComponent)localIterator.next()).onBackPressed()) {
        return;
      }
    }
    eef().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow().getDecorView();
    s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
    getWindow().setStatusBarColor(0);
    getController().s((Activity)this, getResources().getColor(e.b.transparent));
    com.tencent.mm.ui.c.h((Activity)this, false);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    paramBundle = af.mU((Context)getContext());
    int i = e.f.finder_full_action_bar_layout;
    Object localObject = getBodyView();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    paramBundle.inflate(i, (ViewGroup)localObject, true);
    i = bf.getStatusBarHeight((Context)this);
    ((FrameLayout)findViewById(e.e.full_actionbar)).setPadding(0, i, 0, 0);
    ((LinearLayout)findViewById(e.e.back_button)).setOnClickListener(new FinderLoaderFeedUI..ExternalSyntheticLambda0(this));
    paramBundle = getMMTitle();
    if ((paramBundle == null) || (paramBundle.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label362;
      }
      ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(8);
    }
    for (;;)
    {
      paramBundle = com.tencent.mm.plugin.finder.utils.av.GiL;
      paramBundle = getWindow();
      s.s(paramBundle, "window");
      com.tencent.mm.plugin.finder.utils.av.d(paramBundle);
      this.Bqc = getWindow().getNavigationBarColor();
      setNavigationbarColor(getResources().getColor(e.b.black));
      ((FrameLayout)findViewById(e.e.full_actionbar)).setVisibility(0);
      paramBundle = findViewById(e.e.rl_layout);
      if (paramBundle != null)
      {
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)new CoordinatorLayout.d(-1, -1));
        paramBundle.setBackgroundColor(getResources().getColor(e.b.full_black));
      }
      initOnCreate();
      paramBundle = eef();
      localObject = eeg();
      paramBundle.a(eeh(), (ae.b)localObject);
      return;
      i = 0;
      break;
      label362:
      ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(0);
      ((TextView)findViewById(e.e.full_action_bar_title)).setText(getMMTitle());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    eef().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    eef().onUIPause();
    this.nmW.gR(false);
  }
  
  public void onResume()
  {
    super.onResume();
    eef().onUIResume();
    com.tencent.mm.model.d.a(this.nmW, "FinderLoaderFeedUI");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    s.u(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    paramBundle = (BaseFeedLoader)eeh();
    Intent localIntent = getIntent();
    s.s(localIntent, "intent");
    BaseFeedLoader.saveCache$default(paramBundle, localIntent, eeh().getInitPos(), null, 4, null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMTitle(int paramInt)
  {
    super.setMMTitle(paramInt);
    CharSequence localCharSequence = getMMTitle();
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(8);
      return;
    }
    ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(0);
    ((TextView)findViewById(e.e.full_action_bar_title)).setText(getMMTitle());
  }
  
  public void setMMTitle(CharSequence paramCharSequence)
  {
    super.setMMTitle(paramCharSequence);
    paramCharSequence = getMMTitle();
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(8);
      return;
    }
    ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(0);
    ((TextView)findViewById(e.e.full_action_bar_title)).setText(getMMTitle());
  }
  
  public void setMMTitle(String paramString)
  {
    super.setMMTitle(paramString);
    paramString = getMMTitle();
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(8);
      return;
    }
    ((TextView)findViewById(e.e.full_action_bar_title)).setVisibility(0);
    ((TextView)findViewById(e.e.full_action_bar_title)).setText(getMMTitle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI
 * JD-Core Version:    0.7.0.1
 */