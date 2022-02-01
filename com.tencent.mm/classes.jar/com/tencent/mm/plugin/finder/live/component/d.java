package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.report.s.ai;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveMusicScrollViewBehavior;
import com.tencent.mm.plugin.finder.live.widget.h;
import com.tencent.mm.plugin.finder.live.widget.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "Landroid/view/View$OnClickListener;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;)V", "DEFAULT_PANEL_HEIGHT", "", "getDEFAULT_PANEL_HEIGHT", "()I", "MENU_ID_ITEM_DELETE", "getMENU_ID_ITEM_DELETE", "TAG", "", "getTAG", "()Ljava/lang/String;", "addAction", "getAddAction", "()Landroid/view/View;", "setAddAction", "(Landroid/view/View;)V", "appBarVisible", "", "getAppBarVisible", "()Z", "setAppBarVisible", "(Z)V", "back", "getBack", "setBack", "blankClickArea", "getBlankClickArea", "setBlankClickArea", "contentBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "getContentBarLayout", "()Lcom/google/android/material/appbar/AppBarLayout;", "setContentBarLayout", "(Lcom/google/android/material/appbar/AppBarLayout;)V", "contentContainer", "getContentContainer", "setContentContainer", "editWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget;", "getEditWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget;", "setEditWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget;)V", "emptyAddMusicBtn", "Landroid/widget/TextView;", "getEmptyAddMusicBtn", "()Landroid/widget/TextView;", "setEmptyAddMusicBtn", "(Landroid/widget/TextView;)V", "emptyContainer", "getEmptyContainer", "setEmptyContainer", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "mainContentArea", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "getMainContentArea", "()Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "setMainContentArea", "(Lcom/tencent/mm/live/view/LiveBottomSheetPanel;)V", "mainContentRootView", "getMainContentRootView", "setMainContentRootView", "menuAction", "getMenuAction", "setMenuAction", "musicRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getMusicRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setMusicRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "musicRvWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;", "getMusicRvWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;", "setMusicRvWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "titleActionGroup", "getTitleActionGroup", "setTitleActionGroup", "titleContentArea", "getTitleContentArea", "setTitleContentArea", "touchLoc", "", "volumSeekbar", "Landroid/widget/SeekBar;", "getVolumSeekbar", "()Landroid/widget/SeekBar;", "setVolumSeekbar", "(Landroid/widget/SeekBar;)V", "volumeAction", "getVolumeAction", "setVolumeAction", "volumeContainer", "getVolumeContainer", "setVolumeContainer", "volumeState", "getVolumeState", "setVolumeState", "(I)V", "volumeValue", "getVolumeValue", "setVolumeValue", "adjustRvHeight", "", "doVolumeAction", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "getTouchLoc", "hideEditView", "hideVolumeView", "withAnim", "initView", "miniVolume", "onClick", "v", "onProgressChanged", "seekBar", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "recoveryVolume", "showEmptyView", "showLoadingView", "showMusicView", "musicData", "", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "showPopupMemu", "view", "pos", "musicItem", "anchorPosX", "anchorPosY", "showVolumeView", "Companion", "plugin-finder_release"})
public final class d
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, a.b
{
  public static final a xYV;
  private final String TAG;
  final MMActivity activity;
  private final View jac;
  private ProgressBar pDL;
  private com.tencent.mm.ui.widget.b.a szq;
  LiveBottomSheetPanel xYA;
  private View xYB;
  private View xYC;
  private View xYD;
  private View xYE;
  View xYF;
  private View xYG;
  private View xYH;
  private TextView xYI;
  private View xYJ;
  private AppBarLayout xYK;
  boolean xYL;
  int xYM;
  private View xYN;
  private SeekBar xYO;
  private TextView xYP;
  WxRecyclerView xYQ;
  private i xYR;
  private h xYS;
  private int[] xYT;
  final a.a xYU;
  private final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  final int xYw;
  private final int xYx;
  private View xYy;
  private View xYz;
  
  static
  {
    AppMethodBeat.i(281416);
    xYV = new a((byte)0);
    AppMethodBeat.o(281416);
  }
  
  public d(View paramView, MMActivity paramMMActivity, com.tencent.mm.plugin.finder.live.model.context.a parama, a.a parama1)
  {
    AppMethodBeat.i(281415);
    this.jac = paramView;
    this.activity = paramMMActivity;
    this.xYp = parama;
    this.xYU = parama1;
    this.TAG = "FinderLiveAnchorMusicViewCallback";
    this.xYw = 1;
    float f = ax.au(MMApplicationContext.getContext()).y;
    paramView = com.tencent.c.a.a.a.a.a.Zlt;
    this.xYx = ((int)(f * (com.tencent.c.a.a.a.a.a.imN() / 100.0F)));
    this.szq = new com.tencent.mm.ui.widget.b.a((Context)this.activity);
    this.xYT = new int[2];
    AppMethodBeat.o(281415);
  }
  
  public final void a(View paramView, final int paramInt1, final aq paramaq, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(281411);
    p.k(paramView, "view");
    p.k(paramaq, "musicItem");
    this.szq.cFD();
    this.szq.a(paramView, (View.OnCreateContextMenuListener)new m(this), (q.g)new n(this, paramaq, paramInt1), paramInt2, paramInt3);
    this.szq.ayF(b.e.finder_sub_menu_night_bg);
    this.szq.ayG(b.c.BW_100_Alpha_0_8);
    AppMethodBeat.o(281411);
  }
  
  public final MMFragmentActivity dsB()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final void dwX()
  {
    AppMethodBeat.i(281410);
    h localh = this.xYS;
    if (localh != null)
    {
      localh.W(false, false);
      AppMethodBeat.o(281410);
      return;
    }
    AppMethodBeat.o(281410);
  }
  
  public final void dwZ()
  {
    AppMethodBeat.i(281407);
    Object localObject = this.xYD;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.xYH;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.xYJ;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.xYQ;
    if (localObject != null) {
      ((WxRecyclerView)localObject).setVisibility(8);
    }
    localObject = this.pDL;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(0);
    }
    localObject = this.xYA;
    if (localObject != null) {
      ((LiveBottomSheetPanel)localObject).post((Runnable)new j(this));
    }
    oF(false);
    AppMethodBeat.o(281407);
  }
  
  public final int[] dxa()
  {
    return this.xYT;
  }
  
  public final void dxb()
  {
    AppMethodBeat.i(281409);
    Context localContext;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgl)
    {
      localObject = this.xYO;
      if (localObject != null)
      {
        Log.i(this.TAG, "recoveryVolume recoveryVolume:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgk + ", progress:" + ((SeekBar)localObject).getProgress());
        int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgk;
        if (i < 0)
        {
          AppMethodBeat.o(281409);
          return;
        }
        if (100 >= i)
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgl = false;
          ((SeekBar)localObject).setProgress(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgk);
          localObject = this.jac.getContext();
          localContext = this.jac.getContext();
          p.j(localContext, "root.context");
          w.a((Context)localObject, localContext.getResources().getString(b.j.finder_live_anchor_music_recov_volume_tips), (w.b)d.h.xYZ);
        }
        AppMethodBeat.o(281409);
        return;
      }
      AppMethodBeat.o(281409);
      return;
    }
    Object localObject = this.xYO;
    if (localObject != null)
    {
      Log.i(this.TAG, "miniVolume seerBar progress:" + ((SeekBar)localObject).getProgress());
      if (((SeekBar)localObject).getProgress() > 5)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgl = true;
        ((SeekBar)localObject).setProgress(5);
        localObject = this.jac.getContext();
        localContext = this.jac.getContext();
        p.j(localContext, "root.context");
        w.a((Context)localObject, localContext.getResources().getString(b.j.finder_live_anchor_music_lower_volume_tips), (w.b)d.f.xYX);
        AppMethodBeat.o(281409);
        return;
      }
      localObject = this.jac.getContext();
      localContext = this.jac.getContext();
      p.j(localContext, "root.context");
      w.a((Context)localObject, localContext.getResources().getString(b.j.finder_live_anchor_music_mini_volume_tips), (w.b)d.g.xYY);
      AppMethodBeat.o(281409);
      return;
    }
    AppMethodBeat.o(281409);
  }
  
  public final void ej(List<aq> paramList)
  {
    AppMethodBeat.i(281404);
    p.k(paramList, "musicData");
    int i = paramList.size();
    Log.i(this.TAG, "showMusicView size:".concat(String.valueOf(i)));
    paramList = this.xYD;
    if (paramList != null) {
      paramList.setVisibility(0);
    }
    paramList = this.xYH;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    paramList = this.xYJ;
    if (paramList != null) {
      paramList.setVisibility(0);
    }
    paramList = this.xYQ;
    if (paramList != null) {
      paramList.setVisibility(0);
    }
    paramList = this.pDL;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    paramList = this.xYA;
    if (paramList != null) {
      paramList.post((Runnable)new k(this));
    }
    oF(false);
    paramList = this.xYQ;
    if (paramList != null)
    {
      paramList = paramList.getViewTreeObserver();
      if (paramList != null)
      {
        paramList.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new l(this));
        AppMethodBeat.o(281404);
        return;
      }
    }
    AppMethodBeat.o(281404);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(281403);
    Log.i(this.TAG, "initView");
    this.xYy = this.jac.findViewById(b.f.finder_live_anchor_music_blank_area);
    Object localObject1 = this.xYy;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.xYz = this.jac.findViewById(b.f.finder_live_anchor_music_title_item_root);
    this.xYA = ((LiveBottomSheetPanel)this.jac.findViewById(b.f.finder_live_anchor_music_content_area));
    localObject1 = this.xYA;
    if (localObject1 != null) {
      ((LiveBottomSheetPanel)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    localObject1 = this.xYA;
    if (localObject1 != null)
    {
      ((LiveBottomSheetPanel)localObject1).setOnVisibilityListener((kotlin.g.a.b)new b(this));
      ((LiveBottomSheetPanel)localObject1).setTranslationY(ax.au(this.jac.getContext()).y);
      ((LiveBottomSheetPanel)localObject1).getLayoutParams().height = this.xYx;
    }
    this.xYB = this.jac.findViewById(b.f.finder_live_anchor_music_content_item_root);
    this.xYC = this.jac.findViewById(b.f.finder_live_music_back_btn_group);
    localObject1 = this.xYC;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.xYD = this.jac.findViewById(b.f.music_action_group);
    this.xYE = this.jac.findViewById(b.f.menu_action_icon);
    localObject1 = this.xYE;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.xYF = this.jac.findViewById(b.f.volume_action_group);
    localObject1 = this.xYF;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.xYG = this.jac.findViewById(b.f.add_action_icon);
    localObject1 = this.xYG;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.xYH = this.jac.findViewById(b.f.music_empty_tip_group);
    this.xYI = ((TextView)this.jac.findViewById(b.f.music_empty_add_btn));
    localObject1 = this.xYI;
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.xYJ = this.jac.findViewById(b.f.music_content_group);
    this.xYK = ((AppBarLayout)this.jac.findViewById(b.f.music_volume_bar_layout));
    localObject1 = this.xYK;
    Object localObject2;
    if (localObject1 != null)
    {
      ((AppBarLayout)localObject1).a((AppBarLayout.b)new c(this));
      localObject2 = new CoordinatorLayout.d(-1, -2);
      ((CoordinatorLayout.d)localObject2).a((CoordinatorLayout.Behavior)new FinderLiveMusicScrollViewBehavior((Context)this.activity, null));
      ((AppBarLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.xYN = this.jac.findViewById(b.f.music_volume_container);
    this.xYO = ((SeekBar)this.jac.findViewById(b.f.music_volume_seekbar));
    this.xYP = ((TextView)this.jac.findViewById(b.f.music_volume_tv));
    localObject1 = this.xYO;
    label591:
    int k;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgl)
      {
        i = 5;
        ((SeekBar)localObject1).setProgress(i);
      }
    }
    else
    {
      localObject1 = this.xYU;
      if (localObject1 != null)
      {
        localObject2 = this.xYO;
        if (localObject2 == null) {
          break label963;
        }
        i = ((SeekBar)localObject2).getProgress();
        ((a.a)localObject1).Na(i);
      }
      localObject1 = this.xYO;
      if (localObject1 != null) {
        ((SeekBar)localObject1).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this);
      }
      localObject1 = this.jac.findViewById(b.f.finder_live_anchor_music_content_item_root);
      p.j(localObject1, "root.findViewById(R.id.f…_music_content_item_root)");
      this.xYR = new i((ViewGroup)localObject1, (b)this.xYU, (kotlin.g.a.b)new e(this));
      localObject1 = this.xYR;
      if (localObject1 == null) {
        break label983;
      }
      localObject1 = ((i)localObject1).xYQ;
      label691:
      this.xYQ = ((WxRecyclerView)localObject1);
      localObject1 = this.xYQ;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).a((RecyclerView.k)new d(this));
      }
      localObject1 = this.jac.findViewById(b.f.finder_live_anchor_music_edit_content_area);
      p.j(localObject1, "root.findViewById<Relati…_music_edit_content_area)");
      this.xYS = new h((ViewGroup)localObject1, this.xYp, this.xYU);
      this.pDL = ((ProgressBar)this.jac.findViewById(b.f.music_loading));
      localObject1 = this.xYQ;
      if (localObject1 != null)
      {
        k = ax.aB(this.jac.getContext());
        localObject2 = this.xYz;
        if (localObject2 == null) {
          break label989;
        }
        localObject2 = ((View)localObject2).getLayoutParams();
        if (localObject2 == null) {
          break label989;
        }
      }
    }
    label963:
    label983:
    label989:
    for (int i = ((ViewGroup.LayoutParams)localObject2).height;; i = 0)
    {
      int j = i;
      if (i <= 0)
      {
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        j = ((Context)localObject2).getResources().getDimensionPixelOffset(b.d.Edge_8A);
      }
      i = this.xYx - k - j;
      ((WxRecyclerView)localObject1).getLayoutParams().height = i;
      Log.i(this.TAG, "adjustRvHeight height:".concat(String.valueOf(i)));
      localObject1 = this.xYN;
      localObject2 = this.xYO;
      if ((localObject1 != null) && (localObject2 != null))
      {
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        com.tencent.mm.plugin.finder.live.utils.a.a((View)localObject1, (SeekBar)localObject2);
      }
      AppMethodBeat.o(281403);
      return;
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgk;
      break;
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgk;
      break label591;
      localObject1 = null;
      break label691;
    }
  }
  
  public final void nO(boolean paramBoolean)
  {
    AppMethodBeat.i(281406);
    Object localObject = this.xYD;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.xYH;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.xYJ;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.pDL;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(8);
    }
    if (paramBoolean)
    {
      localObject = this.xYA;
      if (localObject != null) {
        ((LiveBottomSheetPanel)localObject).post((Runnable)new i(this));
      }
    }
    oF(false);
    AppMethodBeat.o(281406);
  }
  
  public final void oF(boolean paramBoolean)
  {
    AppMethodBeat.i(281408);
    this.xYL = false;
    this.xYM = 2;
    Object localObject = this.xYF;
    if (localObject != null) {
      ((View)localObject).setBackground(null);
    }
    localObject = this.xYK;
    if (localObject != null)
    {
      ((AppBarLayout)localObject).h(false, paramBoolean);
      AppMethodBeat.o(281408);
      return;
    }
    AppMethodBeat.o(281408);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(281412);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_anchor_music_blank_area;
      if (paramView != null) {
        break label127;
      }
      label59:
      i = b.f.finder_live_music_back_btn_group;
      if (paramView != null) {
        break label166;
      }
      label67:
      i = b.f.music_empty_add_btn;
      if (paramView != null) {
        break label190;
      }
      label75:
      i = b.f.add_action_icon;
      if (paramView != null) {
        break label246;
      }
      i = b.f.menu_action_icon;
      if (paramView != null) {
        break label257;
      }
      label91:
      i = b.f.volume_action_group;
      if (paramView != null) {
        break label313;
      }
    }
    label99:
    label127:
    while (paramView.intValue() != i) {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(281412);
        return;
        paramView = null;
        break;
        if (paramView.intValue() != i) {
          break label59;
        }
        paramView = this.xYA;
        if (paramView != null) {
          paramView.hide();
        }
        paramView = this.xYS;
        if (paramView != null)
        {
          paramView.W(false, true);
          continue;
          if (paramView.intValue() != i) {
            break label67;
          }
          paramView = this.xYA;
          if (paramView != null)
          {
            paramView.hide();
            continue;
            if (paramView.intValue() != i) {
              break label75;
            }
            for (;;)
            {
              paramView = this.xYU;
              if (paramView != null) {
                paramView.dwW();
              }
              paramView = x.ych;
              x.h(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted(), s.ai.yIG.action, 0);
              break label99;
              if (paramView.intValue() != i) {
                break;
              }
            }
            if (paramView.intValue() != i) {
              break label91;
            }
            paramView = this.xYS;
            if (paramView != null) {
              paramView.W(true, false);
            }
            paramView = x.ych;
            x.h(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted(), s.ai.yIK.action, 0);
          }
        }
      }
    }
    label166:
    label190:
    label246:
    Log.i(this.TAG, "doVolumeAction appBarVisible:" + this.xYL + ", volumeState:" + this.xYM);
    label257:
    label313:
    if (this.xYL) {
      oF(true);
    }
    do
    {
      paramView = x.ych;
      x.h(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted(), s.ai.yII.action, 0);
      break;
      this.xYL = true;
      this.xYM = 1;
      paramView = this.xYK;
      if (paramView != null) {
        paramView.h(true, true);
      }
      paramView = this.xYF;
      if (paramView != null) {
        paramView.setBackground(((MMFragmentActivity)this.activity).getResources().getDrawable(b.e.finder_live_round_dark_btn_bg));
      }
      localObject = this.xYP;
    } while (localObject == null);
    paramView = this.xYO;
    if (paramView != null) {}
    for (paramView = String.valueOf(paramView.getProgress());; paramView = null)
    {
      ((TextView)localObject).setText((CharSequence)paramView);
      break;
    }
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(281413);
    Log.i(this.TAG, "onProgressChanged progress:" + paramInt + ",fromUser:" + paramBoolean);
    paramSeekBar = this.xYU;
    if (paramSeekBar != null) {
      paramSeekBar.Na(paramInt);
    }
    paramSeekBar = this.xYP;
    if (paramSeekBar != null)
    {
      paramSeekBar.setText((CharSequence)String.valueOf(paramInt));
      AppMethodBeat.o(281413);
      return;
    }
    AppMethodBeat.o(281413);
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(281414);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onStopTrackingTouch inMiniVolumeState:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgl).append(", recoveryVolume:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgk).append(", progress:");
    if (paramSeekBar != null) {}
    for (Object localObject = Integer.valueOf(paramSeekBar.getProgress());; localObject = null)
    {
      Log.i(str, localObject);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgl = false;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (paramSeekBar == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zgk = paramSeekBar.getProgress();
      AppMethodBeat.o(281414);
      return;
    }
    AppMethodBeat.o(281414);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$Companion;", "", "()V", "MINI_VOLUME", "", "VOLUME_HIDE", "VOLUME_SHOW", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isShow", "", "invoke", "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$initView$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "kotlin.jvm.PlatformType", "verticalOffset", "", "onOffsetChanged", "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$initView$2$1"})
  static final class c
    implements AppBarLayout.b
  {
    c(d paramd) {}
    
    public final void c(AppBarLayout paramAppBarLayout, int paramInt)
    {
      AppMethodBeat.i(279968);
      p.j(paramAppBarLayout, "appBarLayout");
      if ((paramInt == paramAppBarLayout.getHeight() * -1) && (this.xYW.xYM != 1))
      {
        this.xYW.xYL = false;
        this.xYW.xYM = 0;
        paramAppBarLayout = this.xYW.xYF;
        if (paramAppBarLayout != null)
        {
          paramAppBarLayout.setBackground(null);
          AppMethodBeat.o(279968);
          return;
        }
        AppMethodBeat.o(279968);
        return;
      }
      if ((paramInt == 0) && (this.xYW.xYM != 2))
      {
        this.xYW.xYL = true;
        this.xYW.xYM = 0;
        paramAppBarLayout = this.xYW.xYF;
        if (paramAppBarLayout != null)
        {
          paramAppBarLayout.setBackground(((MMFragmentActivity)this.xYW.activity).getResources().getDrawable(b.e.finder_live_round_dark_btn_bg));
          AppMethodBeat.o(279968);
          return;
        }
      }
      AppMethodBeat.o(279968);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$initView$4$1", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder_release"})
  public static final class d
    implements RecyclerView.k
  {
    d(d paramd) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(280967);
      p.k(paramRecyclerView, "rv");
      p.k(paramMotionEvent, "motionEvent");
      d.a(this.xYW)[0] = ((int)paramMotionEvent.getRawX());
      d.a(this.xYW)[1] = ((int)paramMotionEvent.getRawY());
      AppMethodBeat.o(280967);
      return false;
    }
    
    public final void ao(boolean paramBoolean) {}
    
    public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(280966);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$initView$$inlined$apply$lambda$3", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aFi());
      p.k(paramRecyclerView, "p0");
      p.k(paramMotionEvent, "p1");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$initView$$inlined$apply$lambda$3", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(280966);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Integer, kotlin.x>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(256506);
      LiveBottomSheetPanel localLiveBottomSheetPanel = this.xYW.xYA;
      if (localLiveBottomSheetPanel != null)
      {
        localLiveBottomSheetPanel.show();
        AppMethodBeat.o(256506);
        return;
      }
      AppMethodBeat.o(256506);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(272528);
      LiveBottomSheetPanel localLiveBottomSheetPanel = this.xYW.xYA;
      if (localLiveBottomSheetPanel != null)
      {
        localLiveBottomSheetPanel.show();
        AppMethodBeat.o(272528);
        return;
      }
      AppMethodBeat.o(272528);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(278937);
      LiveBottomSheetPanel localLiveBottomSheetPanel = this.xYW.xYA;
      if (localLiveBottomSheetPanel != null)
      {
        localLiveBottomSheetPanel.show();
        AppMethodBeat.o(278937);
        return;
      }
      AppMethodBeat.o(278937);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$showMusicView$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class l
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(269726);
      Object localObject1 = this.xYW.xYQ;
      if (localObject1 != null)
      {
        localObject1 = ((WxRecyclerView)localObject1).getViewTreeObserver();
        if (localObject1 != null) {
          ((ViewTreeObserver)localObject1).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)d.b(this.xYW).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.fFw;
      if ((i >= 0) && (i < ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)d.b(this.xYW).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydi.size()))
      {
        localObject1 = this.xYW.xYQ;
        if (localObject1 != null) {}
        for (localObject1 = ((WxRecyclerView)localObject1).getLayoutManager();; localObject1 = null)
        {
          Object localObject2 = localObject1;
          if (!(localObject1 instanceof LinearLayoutManager)) {
            localObject2 = null;
          }
          localObject1 = (LinearLayoutManager)localObject2;
          if (localObject1 == null) {
            break;
          }
          ((LinearLayoutManager)localObject1).au(i, 0);
          AppMethodBeat.o(269726);
          return;
        }
      }
      AppMethodBeat.o(269726);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class m
    implements View.OnCreateContextMenuListener
  {
    m(d paramd) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(286178);
      paramContextMenu.add(0, this.xYW.xYw, 0, (CharSequence)d.c(this.xYW).getResources().getString(b.j.finder_live_anchor_music_edit_delelte_tips));
      AppMethodBeat.o(286178);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class n
    implements q.g
  {
    n(d paramd, aq paramaq, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(289623);
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == this.xYW.xYw)
      {
        d.d(this.xYW).cFD();
        paramMenuItem = this.xYW.xYU;
        if (paramMenuItem != null) {
          paramMenuItem.a(paramaq, paramInt1);
        }
        this.xYW.oF(false);
      }
      AppMethodBeat.o(289623);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.d
 * JD-Core Version:    0.7.0.1
 */