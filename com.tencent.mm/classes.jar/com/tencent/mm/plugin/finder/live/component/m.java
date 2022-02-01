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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.model.c;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.at;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveMusicScrollViewBehavior;
import com.tencent.mm.plugin.finder.live.widget.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "Landroid/view/View$OnClickListener;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;)V", "DEFAULT_PANEL_HEIGHT", "", "getDEFAULT_PANEL_HEIGHT", "()I", "MENU_ID_ITEM_DELETE", "getMENU_ID_ITEM_DELETE", "TAG", "", "getTAG", "()Ljava/lang/String;", "addAction", "getAddAction", "()Landroid/view/View;", "setAddAction", "(Landroid/view/View;)V", "appBarVisible", "", "getAppBarVisible", "()Z", "setAppBarVisible", "(Z)V", "back", "getBack", "setBack", "blankClickArea", "getBlankClickArea", "setBlankClickArea", "contentBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "getContentBarLayout", "()Lcom/google/android/material/appbar/AppBarLayout;", "setContentBarLayout", "(Lcom/google/android/material/appbar/AppBarLayout;)V", "contentContainer", "getContentContainer", "setContentContainer", "editWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget;", "getEditWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget;", "setEditWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicEditWidget;)V", "emptyAddMusicBtn", "Landroid/widget/TextView;", "getEmptyAddMusicBtn", "()Landroid/widget/TextView;", "setEmptyAddMusicBtn", "(Landroid/widget/TextView;)V", "emptyContainer", "getEmptyContainer", "setEmptyContainer", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "mainContentArea", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "getMainContentArea", "()Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "setMainContentArea", "(Lcom/tencent/mm/live/view/LiveBottomSheetPanel;)V", "mainContentRootView", "getMainContentRootView", "setMainContentRootView", "menuAction", "getMenuAction", "setMenuAction", "musicRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getMusicRv", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setMusicRv", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "musicRvWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;", "getMusicRvWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;", "setMusicRvWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMusicRvWidget;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "titleActionGroup", "getTitleActionGroup", "setTitleActionGroup", "titleContentArea", "getTitleContentArea", "setTitleContentArea", "touchLoc", "", "volumSeekbar", "Landroid/widget/SeekBar;", "getVolumSeekbar", "()Landroid/widget/SeekBar;", "setVolumSeekbar", "(Landroid/widget/SeekBar;)V", "volumeAction", "getVolumeAction", "setVolumeAction", "volumeContainer", "getVolumeContainer", "setVolumeContainer", "volumeState", "getVolumeState", "setVolumeState", "(I)V", "volumeValue", "getVolumeValue", "setVolumeValue", "adjustRvHeight", "", "doVolumeAction", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "getTouchLoc", "hideEditView", "hideVolumeView", "withAnim", "initView", "miniVolume", "onClick", "v", "onProgressChanged", "seekBar", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "recoveryVolume", "showEmptyView", "showLoadingView", "showMusicView", "musicData", "", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "showPopupMemu", "view", "pos", "musicItem", "anchorPosX", "anchorPosY", "showVolumeView", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, j.b
{
  public static final m.a CwM;
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  final j.a CwN;
  private final int CwO;
  private final int CwP;
  private View CwQ;
  private View CwR;
  private LiveBottomSheetPanel CwS;
  private View CwT;
  private View CwU;
  private View CwV;
  private View CwW;
  private View CwX;
  private View CwY;
  private View CwZ;
  private TextView Cxa;
  private View Cxb;
  private AppBarLayout Cxc;
  private boolean Cxd;
  private int Cxe;
  private View Cxf;
  private SeekBar Cxg;
  private TextView Cxh;
  WxRecyclerView Cxi;
  private n Cxj;
  private com.tencent.mm.plugin.finder.live.widget.m Cxk;
  private int[] Cxl;
  private final String TAG;
  private final MMActivity activity;
  private final View lBX;
  private ProgressBar sIX;
  private com.tencent.mm.ui.widget.b.a vEV;
  
  static
  {
    AppMethodBeat.i(353060);
    CwM = new m.a((byte)0);
    AppMethodBeat.o(353060);
  }
  
  public m(View paramView, MMActivity paramMMActivity, com.tencent.mm.plugin.finder.live.model.context.a parama, j.a parama1)
  {
    AppMethodBeat.i(352951);
    this.lBX = paramView;
    this.activity = paramMMActivity;
    this.CvU = parama;
    this.CwN = parama1;
    this.TAG = "FinderLiveAnchorMusicViewCallback";
    this.CwO = 1;
    float f = bf.bf(MMApplicationContext.getContext()).y;
    paramView = com.tencent.d.a.a.a.a.a.ahiX;
    this.CwP = ((int)(f * (com.tencent.d.a.a.a.a.a.jTt() / 100.0F)));
    this.vEV = new com.tencent.mm.ui.widget.b.a((Context)this.activity);
    this.Cxl = new int[2];
    AppMethodBeat.o(352951);
  }
  
  private static final void a(m paramm)
  {
    AppMethodBeat.i(352977);
    s.u(paramm, "this$0");
    int i = bf.bk(paramm.lBX.getContext());
    Log.i(paramm.TAG, s.X("navigationBarHeight:", Integer.valueOf(i)));
    paramm = paramm.lBX.getLayoutParams();
    if (paramm == null)
    {
      paramm = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(352977);
      throw paramm;
    }
    paramm = (ViewGroup.MarginLayoutParams)paramm;
    paramm.bottomMargin = (i + paramm.bottomMargin);
    AppMethodBeat.o(352977);
  }
  
  private static final void a(m paramm, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(353034);
    s.u(paramm, "this$0");
    paramContextMenu.add(0, paramm.CwO, 0, (CharSequence)paramm.activity.getResources().getString(p.h.Cig));
    AppMethodBeat.o(353034);
  }
  
  private static final void a(m paramm, AppBarLayout paramAppBarLayout, int paramInt)
  {
    AppMethodBeat.i(352965);
    s.u(paramm, "this$0");
    if ((paramInt == paramAppBarLayout.getHeight() * -1) && (paramm.Cxe != 1))
    {
      paramm.Cxd = false;
      paramm.Cxe = 0;
      paramm = paramm.CwX;
      if (paramm != null)
      {
        paramm.setBackground(null);
        AppMethodBeat.o(352965);
      }
    }
    else if ((paramInt == 0) && (paramm.Cxe != 2))
    {
      paramm.Cxd = true;
      paramm.Cxe = 0;
      paramAppBarLayout = paramm.CwX;
      if (paramAppBarLayout != null) {
        paramAppBarLayout.setBackground(((MMFragmentActivity)paramm.activity).getResources().getDrawable(p.d.BAK));
      }
    }
    AppMethodBeat.o(352965);
  }
  
  private static final void a(m paramm, at paramat, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(353042);
    s.u(paramm, "this$0");
    s.u(paramat, "$musicItem");
    if (paramMenuItem.getItemId() == paramm.CwO)
    {
      paramm.vEV.diW();
      paramMenuItem = paramm.CwN;
      if (paramMenuItem != null) {
        paramMenuItem.a(paramat, paramInt1);
      }
      ((j.b)paramm).qp(false);
    }
    AppMethodBeat.o(353042);
  }
  
  private static final void b(m paramm)
  {
    AppMethodBeat.i(352988);
    s.u(paramm, "this$0");
    paramm = paramm.CwS;
    if (paramm != null) {
      paramm.show();
    }
    AppMethodBeat.o(352988);
  }
  
  private static final void c(m paramm)
  {
    AppMethodBeat.i(352996);
    s.u(paramm, "this$0");
    paramm = paramm.CwS;
    if (paramm != null) {
      paramm.show();
    }
    AppMethodBeat.o(352996);
  }
  
  private static final void d(m paramm)
  {
    AppMethodBeat.i(353004);
    s.u(paramm, "this$0");
    paramm = paramm.CwS;
    if (paramm != null) {
      paramm.show();
    }
    AppMethodBeat.o(353004);
  }
  
  private static final void fN(View paramView)
  {
    AppMethodBeat.i(353012);
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
      if (paramView != null) {
        paramView.setImageResource(p.g.icons_filled_volume_down);
      }
    }
    AppMethodBeat.o(353012);
  }
  
  private static final void fO(View paramView)
  {
    AppMethodBeat.i(353019);
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
      if (paramView != null) {
        paramView.setImageResource(p.g.icons_filled_volume_down);
      }
    }
    AppMethodBeat.o(353019);
  }
  
  private static final void fP(View paramView)
  {
    AppMethodBeat.i(353027);
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
      if (paramView != null) {
        paramView.setImageResource(p.g.icons_filled_volume_up);
      }
    }
    AppMethodBeat.o(353027);
  }
  
  public final void a(View paramView, int paramInt1, at paramat, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(353236);
    s.u(paramView, "view");
    s.u(paramat, "musicItem");
    this.vEV.diW();
    this.vEV.a(paramView, new m..ExternalSyntheticLambda0(this), new m..ExternalSyntheticLambda5(this, paramat, paramInt1), paramInt2, paramInt3);
    paramView = this.vEV;
    paramInt1 = p.d.BBg;
    if (paramView.aefY != null) {
      paramView.aefY.setBackgroundDrawable(paramView.mContext.getResources().getDrawable(paramInt1));
    }
    this.vEV.akil = true;
    this.vEV.akmn = p.b.BW_100_Alpha_0_8;
    AppMethodBeat.o(353236);
  }
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final void ehE()
  {
    AppMethodBeat.i(353223);
    com.tencent.mm.plugin.finder.live.widget.m localm = this.Cxk;
    if (localm != null) {
      localm.ag(false, false);
    }
    AppMethodBeat.o(353223);
  }
  
  public final void ehG()
  {
    AppMethodBeat.i(353194);
    Object localObject = this.CwV;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.CwZ;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.Cxb;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.Cxi;
    if (localObject != null) {
      ((WxRecyclerView)localObject).setVisibility(8);
    }
    localObject = this.sIX;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(0);
    }
    localObject = this.CwS;
    if (localObject != null) {
      ((LiveBottomSheetPanel)localObject).post(new m..ExternalSyntheticLambda9(this));
    }
    ((j.b)this).qp(false);
    AppMethodBeat.o(353194);
  }
  
  public final int[] ehH()
  {
    return this.Cxl;
  }
  
  public final void ehI()
  {
    AppMethodBeat.i(353215);
    if (((e)this.CvU.business(e.class)).Eeg)
    {
      localSeekBar = this.Cxg;
      int i;
      if (localSeekBar != null)
      {
        Log.i(this.TAG, "recoveryVolume recoveryVolume:" + ((e)this.CvU.business(e.class)).Eef + ", progress:" + localSeekBar.getProgress());
        i = ((e)this.CvU.business(e.class)).Eef;
        if (i < 0) {
          break label197;
        }
        if (i > 100) {
          break label192;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          ((e)this.CvU.business(e.class)).Eeg = false;
          localSeekBar.setProgress(((e)this.CvU.business(e.class)).Eef);
          aa.a(this.lBX.getContext(), this.lBX.getContext().getResources().getString(p.h.Cim), m..ExternalSyntheticLambda3.INSTANCE);
        }
        AppMethodBeat.o(353215);
        return;
        label192:
        i = 0;
        continue;
        label197:
        i = 0;
      }
    }
    SeekBar localSeekBar = this.Cxg;
    if (localSeekBar != null)
    {
      Log.i(this.TAG, s.X("miniVolume seerBar progress:", Integer.valueOf(localSeekBar.getProgress())));
      if (localSeekBar.getProgress() > 5)
      {
        ((e)this.CvU.business(e.class)).Eeg = true;
        localSeekBar.setProgress(5);
        aa.a(this.lBX.getContext(), this.lBX.getContext().getResources().getString(p.h.Cii), m..ExternalSyntheticLambda2.INSTANCE);
        AppMethodBeat.o(353215);
        return;
      }
      aa.a(this.lBX.getContext(), this.lBX.getContext().getResources().getString(p.h.Cij), m..ExternalSyntheticLambda4.INSTANCE);
    }
    AppMethodBeat.o(353215);
  }
  
  public final void gl(List<at> paramList)
  {
    AppMethodBeat.i(353182);
    s.u(paramList, "musicData");
    int i = paramList.size();
    Log.i(this.TAG, s.X("showMusicView size:", Integer.valueOf(i)));
    paramList = this.CwV;
    if (paramList != null) {
      paramList.setVisibility(0);
    }
    paramList = this.CwZ;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    paramList = this.Cxb;
    if (paramList != null) {
      paramList.setVisibility(0);
    }
    paramList = this.Cxi;
    if (paramList != null) {
      paramList.setVisibility(0);
    }
    paramList = this.sIX;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    paramList = this.CwS;
    if (paramList != null) {
      paramList.post(new m..ExternalSyntheticLambda8(this));
    }
    ((j.b)this).qp(false);
    paramList = this.Cxi;
    if (paramList != null)
    {
      paramList = paramList.getViewTreeObserver();
      if (paramList != null) {
        paramList.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new e(this));
      }
    }
    AppMethodBeat.o(353182);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(353170);
    Log.i(this.TAG, "initView");
    this.CwQ = this.lBX.findViewById(p.e.BGe);
    Object localObject1 = this.CwQ;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.CwR = this.lBX.findViewById(p.e.BGl);
    this.CwS = ((LiveBottomSheetPanel)this.lBX.findViewById(p.e.BGf));
    localObject1 = this.CwS;
    if (localObject1 != null) {
      ((LiveBottomSheetPanel)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    localObject1 = this.CwS;
    if (localObject1 != null)
    {
      ((LiveBottomSheetPanel)localObject1).setOnVisibilityListener((kotlin.g.a.b)new b(this));
      ((LiveBottomSheetPanel)localObject1).setTranslationY(bf.bf(this.lBX.getContext()).y);
      ((LiveBottomSheetPanel)localObject1).getLayoutParams().height = this.CwP;
    }
    this.CwT = this.lBX.findViewById(p.e.BGg);
    this.CwU = this.lBX.findViewById(p.e.BPb);
    localObject1 = this.CwU;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.CwV = this.lBX.findViewById(p.e.BYb);
    this.CwW = this.lBX.findViewById(p.e.BXW);
    localObject1 = this.CwW;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.CwX = this.lBX.findViewById(p.e.Ccc);
    localObject1 = this.CwX;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.CwY = this.lBX.findViewById(p.e.BBq);
    localObject1 = this.CwY;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.CwZ = this.lBX.findViewById(p.e.BYn);
    this.Cxa = ((TextView)this.lBX.findViewById(p.e.BYm));
    localObject1 = this.Cxa;
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    this.Cxb = this.lBX.findViewById(p.e.BYc);
    this.Cxc = ((AppBarLayout)this.lBX.findViewById(p.e.BYv));
    localObject1 = this.Cxc;
    Object localObject2;
    if (localObject1 != null)
    {
      ((AppBarLayout)localObject1).a(new m..ExternalSyntheticLambda1(this));
      localObject2 = new CoordinatorLayout.d(-1, -2);
      ((CoordinatorLayout.d)localObject2).a((CoordinatorLayout.Behavior)new FinderLiveMusicScrollViewBehavior((Context)this.activity, null));
      ((AppBarLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.Cxf = this.lBX.findViewById(p.e.BYw);
    this.Cxg = ((SeekBar)this.lBX.findViewById(p.e.BYx));
    this.Cxh = ((TextView)this.lBX.findViewById(p.e.BYy));
    localObject1 = this.Cxg;
    int i;
    label585:
    label607:
    int k;
    if (localObject1 != null)
    {
      if (((e)this.CvU.business(e.class)).Eeg)
      {
        i = 5;
        ((SeekBar)localObject1).setProgress(i);
      }
    }
    else
    {
      localObject2 = this.CwN;
      if (localObject2 != null)
      {
        localObject1 = this.Cxg;
        if (localObject1 != null) {
          break label963;
        }
        localObject1 = null;
        if (localObject1 != null) {
          break label976;
        }
        i = ((e)this.CvU.business(e.class)).Eef;
        ((j.a)localObject2).OA(i);
      }
      localObject1 = this.Cxg;
      if (localObject1 != null) {
        ((SeekBar)localObject1).setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this);
      }
      localObject1 = this.lBX.findViewById(p.e.BGg);
      s.s(localObject1, "root.findViewById(R.id.f…_music_content_item_root)");
      this.Cxj = new n((ViewGroup)localObject1, (k)this.CwN, (kotlin.g.a.b)new c(this));
      localObject1 = this.Cxj;
      if (localObject1 != null) {
        break label985;
      }
      localObject1 = null;
      label703:
      this.Cxi = ((WxRecyclerView)localObject1);
      localObject1 = this.Cxi;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).a((RecyclerView.k)new d(this));
      }
      localObject1 = this.lBX.findViewById(p.e.BGh);
      s.s(localObject1, "root.findViewById<Relati…_music_edit_content_area)");
      this.Cxk = new com.tencent.mm.plugin.finder.live.widget.m((ViewGroup)localObject1, this.CvU, this.CwN);
      this.sIX = ((ProgressBar)this.lBX.findViewById(p.e.BYs));
      localObject1 = this.Cxi;
      if (localObject1 != null)
      {
        k = bf.bk(this.lBX.getContext());
        localObject2 = this.CwR;
        if (localObject2 != null) {
          break label995;
        }
        i = 0;
      }
    }
    for (;;)
    {
      int j = i;
      if (i <= 0) {
        j = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_8A);
      }
      i = this.CwP - k - j;
      ((WxRecyclerView)localObject1).getLayoutParams().height = i;
      Log.i(this.TAG, s.X("adjustRvHeight height:", Integer.valueOf(i)));
      localObject1 = this.Cxf;
      localObject2 = this.Cxg;
      if ((localObject1 != null) && (localObject2 != null))
      {
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.a((View)localObject1, (SeekBar)localObject2);
      }
      this.lBX.post(new m..ExternalSyntheticLambda6(this));
      AppMethodBeat.o(353170);
      return;
      i = ((e)this.CvU.business(e.class)).Eef;
      break;
      label963:
      localObject1 = Integer.valueOf(((SeekBar)localObject1).getProgress());
      break label585;
      label976:
      i = ((Integer)localObject1).intValue();
      break label607;
      label985:
      localObject1 = ((n)localObject1).Cxi;
      break label703;
      label995:
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null) {
        i = 0;
      } else {
        i = ((ViewGroup.LayoutParams)localObject2).height;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(353255);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BGe;
      if (paramView != null) {
        break label162;
      }
      label53:
      i = p.e.BPb;
      if (paramView != null) {
        break label201;
      }
      label61:
      i = p.e.BYm;
      if (paramView != null) {
        break label225;
      }
      label69:
      i = p.e.BBq;
      if (paramView != null) {
        break label238;
      }
      label77:
      i = 0;
      label79:
      if (i == 0) {
        break label251;
      }
      paramView = this.CwN;
      if (paramView != null) {
        paramView.ehD();
      }
      paramView = al.CAw;
      al.j(((e)this.CvU.business(e.class)).isLiveStarted(), q.at.Dzy.action, 0);
    }
    label162:
    label201:
    label225:
    label238:
    label251:
    do
    {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(353255);
        return;
        paramView = Integer.valueOf(paramView.getId());
        break;
        if (paramView.intValue() != i) {
          break label53;
        }
        paramView = this.CwS;
        if (paramView != null) {
          paramView.hide();
        }
        paramView = this.Cxk;
        if (paramView != null)
        {
          paramView.ag(false, true);
          continue;
          if (paramView.intValue() != i) {
            break label61;
          }
          paramView = this.CwS;
          if (paramView != null) {
            paramView.hide();
          }
        }
      }
      if (paramView.intValue() != i) {
        break label69;
      }
      i = 1;
      break label79;
      if (paramView.intValue() != i) {
        break label77;
      }
      i = 1;
      break label79;
      i = p.e.BXW;
      if (paramView != null) {
        break label360;
      }
      i = p.e.Ccc;
    } while ((paramView == null) || (paramView.intValue() != i));
    label259:
    Log.i(this.TAG, "doVolumeAction appBarVisible:" + this.Cxd + ", volumeState:" + this.Cxe);
    if (this.Cxd) {
      qp(true);
    }
    label360:
    do
    {
      paramView = al.CAw;
      al.j(((e)this.CvU.business(e.class)).isLiveStarted(), q.at.DzA.action, 0);
      break;
      if (paramView.intValue() != i) {
        break label259;
      }
      paramView = this.Cxk;
      if (paramView != null) {
        paramView.ag(true, false);
      }
      paramView = al.CAw;
      al.j(((e)this.CvU.business(e.class)).isLiveStarted(), q.at.DzC.action, 0);
      break;
      this.Cxd = true;
      this.Cxe = 1;
      paramView = this.Cxc;
      if (paramView != null) {
        paramView.c(true, true, true);
      }
      paramView = this.CwX;
      if (paramView != null) {
        paramView.setBackground(((MMFragmentActivity)this.activity).getResources().getDrawable(p.d.BAK));
      }
      localObject = this.Cxh;
    } while (localObject == null);
    paramView = this.Cxg;
    if (paramView == null) {}
    for (paramView = null;; paramView = Integer.valueOf(paramView.getProgress()).toString())
    {
      ((TextView)localObject).setText((CharSequence)paramView);
      break;
    }
  }
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(353264);
    Log.i(this.TAG, "onProgressChanged progress:" + paramInt + ",fromUser:" + paramBoolean);
    paramSeekBar = this.CwN;
    if (paramSeekBar != null) {
      paramSeekBar.OA(paramInt);
    }
    paramSeekBar = this.Cxh;
    if (paramSeekBar != null) {
      paramSeekBar.setText((CharSequence)String.valueOf(paramInt));
    }
    AppMethodBeat.o(353264);
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    Object localObject2 = null;
    AppMethodBeat.i(353275);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onStopTrackingTouch inMiniVolumeState:").append(((e)this.CvU.business(e.class)).Eeg).append(", recoveryVolume:").append(((e)this.CvU.business(e.class)).Eef).append(", progress:");
    Object localObject1;
    if (paramSeekBar == null)
    {
      localObject1 = null;
      Log.i(str, localObject1);
      ((e)this.CvU.business(e.class)).Eeg = false;
      localObject1 = (e)this.CvU.business(e.class);
      if (paramSeekBar != null) {
        break label155;
      }
    }
    label155:
    for (paramSeekBar = localObject2;; paramSeekBar = Integer.valueOf(paramSeekBar.getProgress()))
    {
      if (paramSeekBar != null) {
        break label166;
      }
      AppMethodBeat.o(353275);
      return;
      localObject1 = Integer.valueOf(paramSeekBar.getProgress());
      break;
    }
    label166:
    ((e)localObject1).Eef = paramSeekBar.intValue();
    AppMethodBeat.o(353275);
  }
  
  public final void po(boolean paramBoolean)
  {
    AppMethodBeat.i(353191);
    Object localObject = this.CwV;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.CwZ;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.Cxb;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.sIX;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(8);
    }
    if (paramBoolean)
    {
      localObject = this.CwS;
      if (localObject != null) {
        ((LiveBottomSheetPanel)localObject).post(new m..ExternalSyntheticLambda7(this));
      }
    }
    ((j.b)this).qp(false);
    AppMethodBeat.o(353191);
  }
  
  public final void qp(boolean paramBoolean)
  {
    AppMethodBeat.i(353200);
    this.Cxd = false;
    this.Cxe = 2;
    Object localObject = this.CwX;
    if (localObject != null) {
      ((View)localObject).setBackground(null);
    }
    localObject = this.Cxc;
    if (localObject != null) {
      ((AppBarLayout)localObject).c(false, paramBoolean, true);
    }
    AppMethodBeat.o(353200);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isShow", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$initView$4$1", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements RecyclerView.k
  {
    d(m paramm) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(352834);
      s.u(paramRecyclerView, "rv");
      s.u(paramMotionEvent, "motionEvent");
      m.f(this.Cxm)[0] = ((int)paramMotionEvent.getRawX());
      m.f(this.Cxm)[1] = ((int)paramMotionEvent.getRawY());
      AppMethodBeat.o(352834);
      return false;
    }
    
    public final void aX(boolean paramBoolean) {}
    
    public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(352826);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$initView$4$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aYj());
      s.u(paramRecyclerView, "p0");
      s.u(paramMotionEvent, "p1");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$initView$4$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(352826);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicViewCallback$showMusicView$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    e(m paramm) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(352824);
      Object localObject = this.Cxm.Cxi;
      if (localObject != null)
      {
        localObject = ((WxRecyclerView)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      int i = ((e)m.e(this.Cxm).business(e.class)).Eee.hKr;
      if ((i >= 0) && (i < ((e)m.e(this.Cxm).business(e.class)).Eee.CDH.size()))
      {
        localObject = this.Cxm.Cxi;
        if (localObject != null) {
          break label130;
        }
        localObject = null;
        if (!(localObject instanceof LinearLayoutManager)) {
          break label138;
        }
      }
      label130:
      label138:
      for (localObject = (LinearLayoutManager)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((LinearLayoutManager)localObject).bo(i, 0);
        }
        AppMethodBeat.o(352824);
        return;
        localObject = ((WxRecyclerView)localObject).getLayoutManager();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.m
 * JD-Core Version:    0.7.0.1
 */