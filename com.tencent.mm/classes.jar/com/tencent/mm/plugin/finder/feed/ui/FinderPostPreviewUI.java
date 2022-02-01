package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.eb;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.ag.b;
import com.tencent.mm.plugin.finder.feed.ag.c;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;", "()V", "TAG", "", "actionBarHeight", "", "cacheId", "", "closeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCloseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeIcon$delegate", "Lkotlin/Lazy;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "coordinator", "Landroid/view/View;", "getCoordinator", "()Landroid/view/View;", "coordinator$delegate", "feedLoader", "finderActionBar", "getFinderActionBar", "finderActionBar$delegate", "fromScene", "getFromScene", "()I", "fromScene$delegate", "isEnableSwitchPreviewMode", "", "isPreviewFullscreen", "()Z", "setPreviewFullscreen", "(Z)V", "isSelfFlag", "isSelfFlag$delegate", "mainContainer", "getMainContainer", "mainContainer$delegate", "presenter", "previewModeText", "Landroid/widget/TextView;", "getPreviewModeText", "()Landroid/widget/TextView;", "previewModeText$delegate", "requestAtScene", "startIntent", "Landroid/content/Intent;", "statusBarHeight", "getStatusBarHeight", "statusBarHeight$delegate", "username", "getUsername", "()Ljava/lang/String;", "username$delegate", "viewCallback", "changePreviewMode", "", "fullscreen", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportTag", "getReportType", "getViewCallback", "initOnCreate", "isHideStatusBar", "isOtherEnableFullScreenEnjoy", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "overlayStatusBar", "updateStyle", "isDarkMode", "Companion", "plugin-finder_release"})
public final class FinderPostPreviewUI
  extends FinderLoaderFeedUI<FinderAtFeedLoader, ag.c, ag.b>
{
  private static ConcurrentHashMap<Long, FinderItem> xLE;
  private static String xRD;
  private static String xRE;
  public static final a xRF;
  private final String TAG;
  private HashMap _$_findViewCache;
  private long xKc;
  private final f xLB;
  private final f xLj;
  private FinderAtFeedLoader xLy;
  private final f xLz;
  private Intent xRA;
  public boolean xRB;
  private boolean xRC;
  private ag.b xRr;
  private ag.c xRs;
  private final f xRt;
  private final int xRu;
  private final f xRv;
  private final f xRw;
  private final f xRx;
  private final f xRy;
  private final f xRz;
  private final f xjx;
  private final int xvg;
  
  static
  {
    AppMethodBeat.i(221699);
    xRF = new a((byte)0);
    xLE = new ConcurrentHashMap();
    xRD = "KEY_IS_FULLSCREEN";
    xRE = "KEY_ENABLE_SWITCH_PREVIEW_MODE";
    AppMethodBeat.o(221699);
  }
  
  public FinderPostPreviewUI()
  {
    AppMethodBeat.i(221698);
    this.TAG = "Finder.FinderPreviewAtTimelineUI";
    this.xLz = kotlin.g.ar((kotlin.g.a.a)new q(this));
    this.xLj = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.xjx = kotlin.g.ar((kotlin.g.a.a)new m(this));
    this.xLB = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.xvg = 2;
    this.xRt = kotlin.g.ar((kotlin.g.a.a)new p(this));
    this.xRu = com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 45);
    this.xRv = kotlin.g.ar((kotlin.g.a.a)new n(this));
    this.xRw = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.xRx = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.xRy = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.xRz = kotlin.g.ar((kotlin.g.a.a)new o(this));
    this.xRB = true;
    this.xRC = true;
    AppMethodBeat.o(221698);
  }
  
  private final int dvN()
  {
    AppMethodBeat.i(221645);
    int i = ((Number)this.xRt.getValue()).intValue();
    AppMethodBeat.o(221645);
    return i;
  }
  
  private final View dvO()
  {
    AppMethodBeat.i(221646);
    View localView = (View)this.xRv.getValue();
    AppMethodBeat.o(221646);
    return localView;
  }
  
  private final View dvP()
  {
    AppMethodBeat.i(221648);
    View localView = (View)this.xRw.getValue();
    AppMethodBeat.o(221648);
    return localView;
  }
  
  private final View dvQ()
  {
    AppMethodBeat.i(221649);
    View localView = (View)this.xRx.getValue();
    AppMethodBeat.o(221649);
    return localView;
  }
  
  private final TextView dvR()
  {
    AppMethodBeat.i(221651);
    TextView localTextView = (TextView)this.xRz.getValue();
    AppMethodBeat.o(221651);
    return localTextView;
  }
  
  private final WeImageView getCloseIcon()
  {
    AppMethodBeat.i(221650);
    WeImageView localWeImageView = (WeImageView)this.xRy.getValue();
    AppMethodBeat.o(221650);
    return localWeImageView;
  }
  
  private final bid getContextObj()
  {
    AppMethodBeat.i(221639);
    bid localbid = (bid)this.xLj.getValue();
    AppMethodBeat.o(221639);
    return localbid;
  }
  
  private final int getFromScene()
  {
    AppMethodBeat.i(221642);
    int i = ((Number)this.xLB.getValue()).intValue();
    AppMethodBeat.o(221642);
    return i;
  }
  
  private final String getUsername()
  {
    AppMethodBeat.i(221637);
    String str = (String)this.xLz.getValue();
    AppMethodBeat.o(221637);
    return str;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(221640);
    boolean bool = ((Boolean)this.xjx.getValue()).booleanValue();
    AppMethodBeat.o(221640);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(221708);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(221708);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(221706);
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
    AppMethodBeat.o(221706);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final String dvl()
  {
    return this.TAG;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(221690);
    if (getFromScene() == 1)
    {
      if (isSelfFlag())
      {
        AppMethodBeat.o(221690);
        return 62;
      }
      AppMethodBeat.o(221690);
      return 63;
    }
    AppMethodBeat.o(221690);
    return 13;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_preview_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(221680);
    getController().q((Activity)this, getResources().getColor(b.c.transparent));
    c.f((Activity)this, false);
    Object localObject1 = getSupportActionBar();
    if (localObject1 != null)
    {
      ((ActionBar)localObject1).setBackgroundDrawable((Drawable)new ColorDrawable(0));
      ((ActionBar)localObject1).hide();
    }
    this.xRB = getIntent().getBooleanExtra(xRD, false);
    this.xRB = this.xRB;
    Object localObject2;
    int i;
    label337:
    label484:
    label628:
    int j;
    if (this.xRB)
    {
      localObject1 = dvR();
      p.j(localObject1, "previewModeText");
      ((TextView)localObject1).setText((CharSequence)getString(b.j.multi_edit_preview_half_screen));
      dvQ().setPadding(0, dvN(), 0, 0);
      localObject1 = dvQ();
      p.j(localObject1, "finderActionBar");
      localObject2 = dvQ();
      p.j(localObject2, "finderActionBar");
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(221680);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).height = View.MeasureSpec.makeMeasureSpec(this.xRu + dvN(), 1073741824);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = dvO();
      p.j(localObject1, "mainContainer");
      localObject2 = dvO();
      p.j(localObject2, "mainContainer");
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(221680);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if ((!this.xRB) && (!ar.isDarkMode())) {
        break label1180;
      }
      i = 1;
      if (i == 0) {
        break label1185;
      }
      localObject1 = dvR();
      p.j(localObject1, "previewModeText");
      ((TextView)localObject1).setBackground(com.tencent.mm.ci.a.m((Context)getContext(), b.e.finder_post_preview_halfscreen_text_bg));
      getCloseIcon().setIconColor(-1);
      localObject1 = dvQ();
      p.j(localObject1, "finderActionBar");
      ((View)localObject1).setBackground((Drawable)new ColorDrawable(0));
      dvO().setBackgroundResource(b.c.Dark_2);
      dvP().setBackgroundResource(b.c.Dark_2);
      setNavigationbarColor(-16777216);
      getController().updataStatusBarIcon(true);
      label446:
      this.xRC = getIntent().getBooleanExtra(xRE, true);
      localObject1 = dvR();
      p.j(localObject1, "previewModeText");
      if (!this.xRC) {
        break label1304;
      }
      i = 0;
      ((TextView)localObject1).setVisibility(i);
      getCloseIcon().setOnClickListener((View.OnClickListener)new j(this));
      dvR().setOnClickListener((View.OnClickListener)new k(this));
      this.xKc = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      Log.i(this.TAG, "[initOnCreate] cacheId:" + this.xKc + " username=" + getUsername() + " fromScene=" + getFromScene());
      xLE.clear();
      if (getFromScene() == 1)
      {
        localObject1 = h.IzE;
        if (!p.h(getUsername(), z.bdh())) {
          break label1309;
        }
        i = 1;
        ((h)localObject1).a(21206, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      }
      bool = isSelfFlag();
      localObject1 = getUsername();
      p.j(localObject1, "username");
      this.xRr = new ag.b(this, bool, (String)localObject1, this.xvg, getFromScene(), getContextObj());
      localObject1 = (MMActivity)this;
      localObject2 = this.xRr;
      if (localObject2 == null) {
        p.bGy("presenter");
      }
      i = this.xvg;
      j = getCommentScene();
      if (getFromScene() == 1) {
        break label1314;
      }
    }
    label1180:
    label1185:
    label1314:
    for (boolean bool = true;; bool = false)
    {
      this.xRs = new ag.c((MMActivity)localObject1, (ag.b)localObject2, i, j, bool);
      localObject1 = (FrameLayout)_$_findCachedViewById(b.f.loading_state_container);
      p.j(localObject1, "loading_state_container");
      ((FrameLayout)localObject1).setVisibility(0);
      localObject1 = this.xRs;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      ((b.b)localObject1).xvJ.post((Runnable)new l(this));
      localObject1 = com.tencent.mm.plugin.finder.feed.model.internal.g.xKG;
      localObject2 = getUsername();
      p.j(localObject2, "username");
      localObject1 = new FinderAtFeedLoader((com.tencent.mm.plugin.finder.feed.model.internal.g)localObject1, (String)localObject2, getContextObj());
      localObject2 = getIntent();
      p.j(localObject2, "intent");
      ((FinderAtFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderAtFeedLoader)localObject1).xEI = ((kotlin.g.a.a)new g(this));
      ((FinderAtFeedLoader)localObject1).xGJ = ((kotlin.g.a.b)new h(this));
      ((FinderAtFeedLoader)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new i((FinderAtFeedLoader)localObject1, this));
      this.xLy = ((FinderAtFeedLoader)localObject1);
      AppMethodBeat.o(221680);
      return;
      localObject1 = dvR();
      p.j(localObject1, "previewModeText");
      ((TextView)localObject1).setText((CharSequence)getString(b.j.multi_edit_preview_full_screen));
      dvQ().setPadding(0, dvN(), 0, 0);
      localObject1 = dvQ();
      p.j(localObject1, "finderActionBar");
      localObject2 = dvQ();
      p.j(localObject2, "finderActionBar");
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(221680);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).height = View.MeasureSpec.makeMeasureSpec(this.xRu + dvN(), 1073741824);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = dvO();
      p.j(localObject1, "mainContainer");
      localObject2 = dvO();
      p.j(localObject2, "mainContainer");
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(221680);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (dvN() + this.xRu);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break;
      i = 0;
      break label337;
      localObject1 = dvR();
      p.j(localObject1, "previewModeText");
      ((TextView)localObject1).setBackground(com.tencent.mm.ci.a.m((Context)getContext(), b.e.finder_post_preview_fullscreen_text_bg));
      getCloseIcon().setIconColor(-16777216);
      localObject1 = dvQ();
      p.j(localObject1, "finderActionBar");
      ((View)localObject1).setBackground((Drawable)new ColorDrawable(getResources().getColor(b.c.BW_93)));
      dvO().setBackgroundResource(b.c.White);
      dvP().setBackgroundResource(b.c.UN_BW_93);
      setNavigationbarColor(-1);
      getController().updataStatusBarIcon(ar.isDarkMode());
      break label446;
      i = 4;
      break label484;
      i = 0;
      break label628;
    }
  }
  
  public final boolean isHideStatusBar()
  {
    return this.xRB;
  }
  
  public final boolean isOtherEnableFullScreenEnjoy()
  {
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(221653);
    Object localObject = getWindow();
    p.j(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(1280);
    localObject = getWindow();
    p.j(localObject, "window");
    ((Window)localObject).setStatusBarColor(0);
    getWindow().addFlags(67108864);
    this.xRA = getIntent();
    super.onCreate(paramBundle);
    AppMethodBeat.o(221653);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(221681);
    super.onDestroy();
    xLE.clear();
    AppMethodBeat.o(221681);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$Companion;", "", "()V", "KEY_IS_ENABLE_SWITCH_PREVIEW_MODE", "", "getKEY_IS_ENABLE_SWITCH_PREVIEW_MODE", "()Ljava/lang/String;", "setKEY_IS_ENABLE_SWITCH_PREVIEW_MODE", "(Ljava/lang/String;)V", "KEY_IS_FULLSCREEN", "getKEY_IS_FULLSCREEN", "setKEY_IS_FULLSCREEN", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    b(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<bid>
  {
    c(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<View>
  {
    d(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<View>
  {
    e(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<Integer>
  {
    f(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$initOnCreate$4$1"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$initOnCreate$4$2"})
  static final class h
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    h(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$initOnCreate$4$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    i(FinderAtFeedLoader paramFinderAtFeedLoader, FinderPostPreviewUI paramFinderPostPreviewUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(289922);
      Object localObject2 = kotlin.a.j.lp((List)this.xLH.getDataList());
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof af)) {
        localObject1 = null;
      }
      localObject2 = (af)localObject1;
      Rect localRect;
      if (localObject2 != null)
      {
        ((af)localObject2).zAH = jdField_this.xRB;
        ((BaseFinderFeed)localObject2).feedObject.setPostFinish();
        localObject1 = (csg)((BaseFinderFeed)localObject2).feedObject.getMediaList().get(0);
        if ((((BaseFinderFeed)localObject2).isPreview) && (((csg)localObject1).TpG != null))
        {
          localObject2 = ((csg)localObject1).TpG;
          if (localObject2 == null) {
            p.iCn();
          }
          p.j(localObject2, "media.videoCompositionInfo!!");
          localObject2 = ((acu)localObject2).NkX;
          if (localObject2 == null) {
            p.iCn();
          }
          if (((acv)localObject2).SoJ == null) {
            break label523;
          }
          if (!jdField_this.xRB) {
            break label465;
          }
          localRect = new Rect();
          localObject2 = ((acv)localObject2).SoJ.Sro;
          p.j(localObject2, "outputConfig.fullScreenConfig.cropRect");
          i.a((duz)localObject2, localRect);
          ((csg)localObject1).width = localRect.width();
          ((csg)localObject1).height = localRect.height();
        }
      }
      localObject2 = kotlin.a.j.lp((List)this.xLH.getDataList());
      localObject1 = localObject2;
      if (!(localObject2 instanceof u)) {
        localObject1 = null;
      }
      localObject1 = (u)localObject1;
      if ((localObject1 != null) && (((BaseFinderFeed)localObject1).isPreview)) {
        ((BaseFinderFeed)localObject1).feedObject.setPostFinish();
      }
      localObject2 = FinderPostPreviewUI.c(jdField_this).xvJ.getRecyclerView().getLayoutManager();
      localObject1 = localObject2;
      if (!(localObject2 instanceof FinderLinearLayoutManager)) {
        localObject1 = null;
      }
      localObject1 = (FinderLinearLayoutManager)localObject1;
      if (localObject1 != null)
      {
        ((FinderLinearLayoutManager)localObject1).au(this.xLH.getInitPos(), 0);
        ((FinderLinearLayoutManager)localObject1).BfC = false;
      }
      localObject2 = kotlin.a.j.lp((List)this.xLH.getDataList());
      localObject1 = localObject2;
      if (!(localObject2 instanceof BaseFinderFeed)) {
        localObject1 = null;
      }
      localObject1 = (BaseFinderFeed)localObject1;
      if ((localObject1 != null) && (((BaseFinderFeed)localObject1).isPreview))
      {
        localObject1 = com.tencent.mm.plugin.vlog.report.b.NqX;
        localObject1 = com.tencent.mm.plugin.vlog.report.b.gus();
        if (!jdField_this.xRB) {
          break label613;
        }
      }
      label465:
      label613:
      for (long l = 1L;; l = 2L)
      {
        ((eb)localObject1).kC(l);
        ((eb)localObject1).kD(2L);
        ((eb)localObject1).bpa();
        if (paramInt <= 0) {
          break label620;
        }
        localObject1 = (FrameLayout)jdField_this._$_findCachedViewById(b.f.loading_state_container);
        p.j(localObject1, "loading_state_container");
        ((FrameLayout)localObject1).setVisibility(8);
        AppMethodBeat.o(289922);
        return;
        localRect = new Rect();
        localObject2 = ((acv)localObject2).SoK.Sro;
        p.j(localObject2, "outputConfig.cropConfig.cropRect");
        i.a((duz)localObject2, localRect);
        ((csg)localObject1).width = localRect.width();
        ((csg)localObject1).height = localRect.height();
        break;
        if (jdField_this.xRB)
        {
          ((csg)localObject1).width = ((acv)localObject2).BXA;
          ((csg)localObject1).height = ((acv)localObject2).BXB;
          break;
        }
        localRect = new Rect();
        localObject2 = ((acv)localObject2).SoD;
        p.j(localObject2, "outputConfig.originRect");
        i.a((duz)localObject2, localRect);
        ((csg)localObject1).width = localRect.width();
        ((csg)localObject1).height = localRect.height();
        break;
      }
      label523:
      label620:
      localObject1 = (FrameLayout)jdField_this._$_findCachedViewById(b.f.loading_state_container);
      p.j(localObject1, "loading_state_container");
      ((FrameLayout)localObject1).setVisibility(0);
      localObject1 = (ProgressBar)jdField_this._$_findCachedViewById(b.f.tips_loading);
      p.j(localObject1, "tips_loading");
      ((ProgressBar)localObject1).setVisibility(0);
      AppMethodBeat.o(289922);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderPostPreviewUI paramFinderPostPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237519);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xRG.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237519);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderPostPreviewUI paramFinderPostPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(223515);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = FinderPostPreviewUI.a(this.xRG);
      if (paramView != null)
      {
        this.xRG.finish();
        localObject = FinderPostPreviewUI.xRF;
        localObject = FinderPostPreviewUI.dvS();
        if (this.xRG.xRB) {
          break label194;
        }
      }
      label194:
      for (boolean bool = true;; bool = false)
      {
        paramView.putExtra((String)localObject, bool);
        localObject = aj.AGc;
        aj.a(0, (List)FinderPostPreviewUI.b(this.xRG).getDataList(), null, paramView);
        paramView = this.xRG;
        localObject = FinderPostPreviewUI.a(this.xRG);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$initOnCreate$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$initOnCreate$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(223515);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(FinderPostPreviewUI paramFinderPostPreviewUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252769);
      FinderPostPreviewUI.c(this.xRG).xvJ.setEnableLoadMore(false);
      FinderPostPreviewUI.c(this.xRG).xvJ.setEnableRefresh(false);
      FinderPostPreviewUI.c(this.xRG).xvJ.setEnablePullDownHeader(false);
      AppMethodBeat.o(252769);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    m(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<View>
  {
    n(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<TextView>
  {
    o(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<Integer>
  {
    p(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<String>
  {
    q(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderPostPreviewUI
 * JD-Core Version:    0.7.0.1
 */