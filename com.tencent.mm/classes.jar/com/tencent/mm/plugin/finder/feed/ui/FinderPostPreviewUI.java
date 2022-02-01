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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.fm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.am.b;
import com.tencent.mm.plugin.finder.feed.am.c;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.d;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;", "()V", "TAG", "", "actionBarHeight", "", "cacheId", "", "closeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCloseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeIcon$delegate", "Lkotlin/Lazy;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "coordinator", "Landroid/view/View;", "getCoordinator", "()Landroid/view/View;", "coordinator$delegate", "feedLoader", "finderActionBar", "getFinderActionBar", "finderActionBar$delegate", "fromScene", "getFromScene", "()I", "fromScene$delegate", "isEnableSwitchPreviewMode", "", "isPreviewFullscreen", "()Z", "setPreviewFullscreen", "(Z)V", "isSelfFlag", "isSelfFlag$delegate", "mainContainer", "getMainContainer", "mainContainer$delegate", "presenter", "previewModeText", "Landroid/widget/TextView;", "getPreviewModeText", "()Landroid/widget/TextView;", "previewModeText$delegate", "requestAtScene", "startIntent", "Landroid/content/Intent;", "statusBarHeight", "getStatusBarHeight", "statusBarHeight$delegate", "username", "getUsername", "()Ljava/lang/String;", "username$delegate", "viewCallback", "changePreviewMode", "", "fullscreen", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportTag", "getReportType", "getViewCallback", "initOnCreate", "isHideStatusBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "overlayStatusBar", "updateStyle", "isDarkMode", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPostPreviewUI
  extends FinderLoaderFeedUI<FinderAtFeedLoader, am.c, am.b>
{
  private static ConcurrentHashMap<Long, FinderItem> BlP;
  public static final a BqQ;
  private final kotlin.j AIq;
  private final int ASQ;
  private long BjP;
  private FinderAtFeedLoader BlJ;
  private final kotlin.j BlK;
  private final kotlin.j BlM;
  private final kotlin.j Bld;
  private am.b BqR;
  private am.c BqS;
  private final kotlin.j BqT;
  private final int BqU;
  private final kotlin.j BqV;
  private final kotlin.j BqW;
  private final kotlin.j BqX;
  private final kotlin.j BqY;
  private final kotlin.j BqZ;
  private Intent Bra;
  public boolean Brb;
  private boolean Brc;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(364576);
    BqQ = new a((byte)0);
    BlP = new ConcurrentHashMap();
    AppMethodBeat.o(364576);
  }
  
  public FinderPostPreviewUI()
  {
    AppMethodBeat.i(364436);
    this.TAG = "Finder.FinderPreviewAtTimelineUI";
    this.BlK = k.cm((kotlin.g.a.a)new n(this));
    this.Bld = k.cm((kotlin.g.a.a)new c(this));
    this.AIq = k.cm((kotlin.g.a.a)new j(this));
    this.BlM = k.cm((kotlin.g.a.a)new f(this));
    this.ASQ = 2;
    this.BqT = k.cm((kotlin.g.a.a)new m(this));
    this.BqU = com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 45);
    this.BqV = k.cm((kotlin.g.a.a)new k(this));
    this.BqW = k.cm((kotlin.g.a.a)new d(this));
    this.BqX = k.cm((kotlin.g.a.a)new e(this));
    this.BqY = k.cm((kotlin.g.a.a)new b(this));
    this.BqZ = k.cm((kotlin.g.a.a)new l(this));
    this.Brb = true;
    this.Brc = true;
    AppMethodBeat.o(364436);
  }
  
  private static final void a(FinderPostPreviewUI paramFinderPostPreviewUI)
  {
    Object localObject = null;
    AppMethodBeat.i(364557);
    s.u(paramFinderPostPreviewUI, "this$0");
    am.c localc2 = paramFinderPostPreviewUI.BqS;
    am.c localc1 = localc2;
    if (localc2 == null)
    {
      s.bIx("viewCallback");
      localc1 = null;
    }
    localc1.ATx.setEnableLoadMore(false);
    localc2 = paramFinderPostPreviewUI.BqS;
    localc1 = localc2;
    if (localc2 == null)
    {
      s.bIx("viewCallback");
      localc1 = null;
    }
    localc1.ATx.setEnableRefresh(false);
    paramFinderPostPreviewUI = paramFinderPostPreviewUI.BqS;
    if (paramFinderPostPreviewUI == null)
    {
      s.bIx("viewCallback");
      paramFinderPostPreviewUI = localObject;
    }
    for (;;)
    {
      paramFinderPostPreviewUI.ATx.setEnablePullDownHeader(false);
      AppMethodBeat.o(364557);
      return;
    }
  }
  
  private static final void a(FinderPostPreviewUI paramFinderPostPreviewUI, View paramView)
  {
    AppMethodBeat.i(364532);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderPostPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderPostPreviewUI, "this$0");
    paramFinderPostPreviewUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364532);
  }
  
  private static final void b(FinderPostPreviewUI paramFinderPostPreviewUI, View paramView)
  {
    AppMethodBeat.i(364547);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderPostPreviewUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramFinderPostPreviewUI, "this$0");
    localObject2 = paramFinderPostPreviewUI.Bra;
    if (localObject2 != null)
    {
      paramFinderPostPreviewUI.finish();
      if (paramFinderPostPreviewUI.Brb) {
        break label240;
      }
    }
    label240:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject2).putExtra("KEY_IS_FULLSCREEN", bool);
      paramView = av.GiL;
      localObject1 = paramFinderPostPreviewUI.BlJ;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        s.bIx("feedLoader");
        paramView = null;
      }
      av.a(0, (List)paramView.getDataList(), null, (Intent)localObject2);
      paramView = paramFinderPostPreviewUI.Bra;
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(paramFinderPostPreviewUI, paramView.aYi(), "com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI", "initOnCreate$lambda-3", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramFinderPostPreviewUI.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramFinderPostPreviewUI, "com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI", "initOnCreate$lambda-3", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364547);
      return;
    }
  }
  
  private final int efM()
  {
    AppMethodBeat.i(364477);
    int i = ((Number)this.BqT.getValue()).intValue();
    AppMethodBeat.o(364477);
    return i;
  }
  
  private final View efN()
  {
    AppMethodBeat.i(364486);
    View localView = (View)this.BqV.getValue();
    AppMethodBeat.o(364486);
    return localView;
  }
  
  private final View efO()
  {
    AppMethodBeat.i(364494);
    View localView = (View)this.BqW.getValue();
    AppMethodBeat.o(364494);
    return localView;
  }
  
  private final View efP()
  {
    AppMethodBeat.i(364501);
    View localView = (View)this.BqX.getValue();
    AppMethodBeat.o(364501);
    return localView;
  }
  
  private final TextView efQ()
  {
    AppMethodBeat.i(364517);
    TextView localTextView = (TextView)this.BqZ.getValue();
    AppMethodBeat.o(364517);
    return localTextView;
  }
  
  private final WeImageView getCloseIcon()
  {
    AppMethodBeat.i(364508);
    WeImageView localWeImageView = (WeImageView)this.BqY.getValue();
    AppMethodBeat.o(364508);
    return localWeImageView;
  }
  
  private final bui getContextObj()
  {
    AppMethodBeat.i(364451);
    bui localbui = (bui)this.Bld.getValue();
    AppMethodBeat.o(364451);
    return localbui;
  }
  
  private final int getFromScene()
  {
    AppMethodBeat.i(364470);
    int i = ((Number)this.BlM.getValue()).intValue();
    AppMethodBeat.o(364470);
    return i;
  }
  
  private final String getUsername()
  {
    AppMethodBeat.i(364443);
    String str = (String)this.BlK.getValue();
    AppMethodBeat.o(364443);
    return str;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(364462);
    boolean bool = ((Boolean)this.AIq.getValue()).booleanValue();
    AppMethodBeat.o(364462);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final String efe()
  {
    return this.TAG;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(364690);
    if (getFromScene() == 1)
    {
      if (isSelfFlag())
      {
        AppMethodBeat.o(364690);
        return 62;
      }
      AppMethodBeat.o(364690);
      return 63;
    }
    AppMethodBeat.o(364690);
    return 13;
  }
  
  public final int getLayoutId()
  {
    return l.f.finder_preview_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(364663);
    getController().s((Activity)this, getResources().getColor(l.b.transparent));
    c.h((Activity)this, false);
    Object localObject1 = getSupportActionBar();
    if (localObject1 != null)
    {
      ((ActionBar)localObject1).setBackgroundDrawable((Drawable)new ColorDrawable(0));
      ((ActionBar)localObject1).hide();
    }
    this.Brb = getIntent().getBooleanExtra("KEY_IS_FULLSCREEN", false);
    this.Brb = this.Brb;
    Object localObject2;
    Object localObject3;
    int i;
    label295:
    label380:
    int j;
    if (this.Brb)
    {
      efQ().setText((CharSequence)getString(l.i.multi_edit_preview_half_screen));
      efP().setPadding(0, efM(), 0, 0);
      localObject1 = efP();
      localObject2 = efP().getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(364663);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).height = View.MeasureSpec.makeMeasureSpec(this.BqU + efM(), 1073741824);
      localObject3 = kotlin.ah.aiuX;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = efN();
      localObject2 = efN().getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(364663);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
      localObject3 = kotlin.ah.aiuX;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if ((!this.Brb) && (!aw.isDarkMode())) {
        break label1089;
      }
      i = 1;
      if (i == 0) {
        break label1094;
      }
      efQ().setBackground(com.tencent.mm.cd.a.m((Context)getContext(), l.d.finder_post_preview_halfscreen_text_bg));
      getCloseIcon().setIconColor(-1);
      efP().setBackground((Drawable)new ColorDrawable(0));
      efN().setBackgroundResource(l.b.Dark_2);
      efO().setBackgroundResource(l.b.Dark_2);
      setNavigationbarColor(-16777216);
      getController().updataStatusBarIcon(true);
      this.Brc = getIntent().getBooleanExtra("KEY_ENABLE_SWITCH_PREVIEW_MODE", true);
      localObject1 = efQ();
      if (!this.Brc) {
        break label1189;
      }
      i = 0;
      label410:
      ((TextView)localObject1).setVisibility(i);
      getCloseIcon().setOnClickListener(new FinderPostPreviewUI..ExternalSyntheticLambda0(this));
      efQ().setOnClickListener(new FinderPostPreviewUI..ExternalSyntheticLambda1(this));
      this.BjP = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      Log.i(this.TAG, "[initOnCreate] cacheId:" + this.BjP + " username=" + getUsername() + " fromScene=" + getFromScene());
      BlP.clear();
      if (getFromScene() == 1)
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
        if (!s.p(getUsername(), z.bAW())) {
          break label1194;
        }
        i = 1;
        label548:
        ((com.tencent.mm.plugin.report.service.h)localObject1).b(21206, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      }
      bool = isSelfFlag();
      localObject1 = getUsername();
      s.s(localObject1, "username");
      this.BqR = new am.b(this, bool, (String)localObject1, this.ASQ, getFromScene(), getContextObj());
      localObject3 = (MMActivity)this;
      localObject2 = this.BqR;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      i = this.ASQ;
      j = getCommentScene();
      if (getFromScene() == 1) {
        break label1199;
      }
    }
    label1189:
    label1194:
    label1199:
    for (boolean bool = true;; bool = false)
    {
      this.BqS = new am.c((MMActivity)localObject3, (am.b)localObject1, i, j, bool);
      localObject1 = findViewById(l.e.loading_state_container);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = findViewById(l.e.finder_preview_actionbar);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject2 = this.BqS;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      ((b.b)localObject1).ATx.post(new FinderPostPreviewUI..ExternalSyntheticLambda2(this));
      localObject1 = g.Bkv;
      localObject2 = getUsername();
      s.s(localObject2, "username");
      localObject1 = new FinderAtFeedLoader((g)localObject1, (String)localObject2, getContextObj());
      localObject2 = getIntent();
      s.s(localObject2, "intent");
      ((FinderAtFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderAtFeedLoader)localObject1).BbB = ((kotlin.g.a.a)new g(this));
      ((FinderAtFeedLoader)localObject1).BfX = ((kotlin.g.a.b)new h(this));
      ((FinderAtFeedLoader)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new i((FinderAtFeedLoader)localObject1, this));
      localObject2 = kotlin.ah.aiuX;
      this.BlJ = ((FinderAtFeedLoader)localObject1);
      AppMethodBeat.o(364663);
      return;
      efQ().setText((CharSequence)getString(l.i.multi_edit_preview_full_screen));
      efP().setPadding(0, efM(), 0, 0);
      localObject1 = efP();
      localObject2 = efP().getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(364663);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).height = View.MeasureSpec.makeMeasureSpec(this.BqU + efM(), 1073741824);
      localObject3 = kotlin.ah.aiuX;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = efN();
      localObject2 = efN().getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(364663);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (efM() + this.BqU);
      localObject3 = kotlin.ah.aiuX;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break;
      label1089:
      i = 0;
      break label295;
      label1094:
      efQ().setBackground(com.tencent.mm.cd.a.m((Context)getContext(), l.d.finder_post_preview_fullscreen_text_bg));
      getCloseIcon().setIconColor(-16777216);
      efP().setBackground((Drawable)new ColorDrawable(getResources().getColor(l.b.BW_93)));
      efN().setBackgroundResource(l.b.White);
      efO().setBackgroundResource(l.b.UN_BW_93);
      setNavigationbarColor(-1);
      getController().updataStatusBarIcon(aw.isDarkMode());
      break label380;
      i = 4;
      break label410;
      i = 0;
      break label548;
    }
  }
  
  public final boolean isHideStatusBar()
  {
    return this.Brb;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364622);
    View localView = getWindow().getDecorView();
    s.s(localView, "window.decorView");
    localView.setSystemUiVisibility(1280);
    getWindow().setStatusBarColor(0);
    getWindow().addFlags(67108864);
    this.Bra = getIntent();
    super.onCreate(paramBundle);
    AppMethodBeat.o(364622);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364673);
    super.onDestroy();
    BlP.clear();
    AppMethodBeat.o(364673);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$Companion;", "", "()V", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    b(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<bui>
  {
    c(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<View>
  {
    e(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Integer>
  {
    f(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    g(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<IResponse<cc>, kotlin.ah>
  {
    h(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI$initOnCreate$4$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    i(FinderAtFeedLoader paramFinderAtFeedLoader, FinderPostPreviewUI paramFinderPostPreviewUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(364995);
      Object localObject1 = p.oL((List)this.BlR.getDataList());
      Object localObject3;
      Object localObject2;
      if ((localObject1 instanceof com.tencent.mm.plugin.finder.model.ah))
      {
        localObject1 = (com.tencent.mm.plugin.finder.model.ah)localObject1;
        if (localObject1 != null)
        {
          localObject3 = jdField_this;
          ((com.tencent.mm.plugin.finder.model.ah)localObject1).ECP = ((FinderPostPreviewUI)localObject3).Brb;
          ((BaseFinderFeed)localObject1).feedObject.setPostFinish();
          localObject2 = (dji)((BaseFinderFeed)localObject1).feedObject.getMediaList().get(0);
          if ((((BaseFinderFeed)localObject1).isPreview) && (((dji)localObject2).aaDI != null))
          {
            localObject1 = ((dji)localObject2).aaDI;
            s.checkNotNull(localObject1);
            s.s(localObject1, "media.videoCompositionInfo!!");
            localObject1 = ((afb)localObject1).TYB;
            s.checkNotNull(localObject1);
            if (((afc)localObject1).Znv == null) {
              break label493;
            }
            if (!((FinderPostPreviewUI)localObject3).Brb) {
              break label446;
            }
            localObject3 = new Rect();
            com.tencent.mm.plugin.vlog.model.h.a(((afc)localObject1).Znv.Zqq, (Rect)localObject3);
            ((dji)localObject2).width = ((Rect)localObject3).width();
            ((dji)localObject2).height = ((Rect)localObject3).height();
          }
        }
        label188:
        localObject1 = p.oL((List)this.BlR.getDataList());
        if (!(localObject1 instanceof v)) {
          break label570;
        }
        localObject1 = (v)localObject1;
        label218:
        if ((localObject1 != null) && (((BaseFinderFeed)localObject1).isPreview)) {
          ((BaseFinderFeed)localObject1).feedObject.setPostFinish();
        }
        localObject2 = FinderPostPreviewUI.b(jdField_this);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
        if (!(localObject1 instanceof FinderLinearLayoutManager)) {
          break label576;
        }
        localObject1 = (FinderLinearLayoutManager)localObject1;
        label293:
        if (localObject1 != null)
        {
          ((FinderLinearLayoutManager)localObject1).bo(this.BlR.getInitPos(), 0);
          ((FinderLinearLayoutManager)localObject1).GHU = false;
        }
        localObject1 = p.oL((List)this.BlR.getDataList());
        if (!(localObject1 instanceof BaseFinderFeed)) {
          break label582;
        }
        localObject1 = (BaseFinderFeed)localObject1;
        label347:
        if (localObject1 != null)
        {
          localObject2 = jdField_this;
          if (((BaseFinderFeed)localObject1).isPreview)
          {
            localObject1 = com.tencent.mm.plugin.vlog.report.b.UeG;
            localObject1 = com.tencent.mm.plugin.vlog.report.b.hSh();
            if (!((FinderPostPreviewUI)localObject2).Brb) {
              break label588;
            }
          }
        }
      }
      label446:
      label576:
      label582:
      label588:
      for (long l = 1L;; l = 2L)
      {
        ((fm)localObject1).iHQ = l;
        ((fm)localObject1).iHR = 2L;
        ((fm)localObject1).bMH();
        if (paramInt <= 0) {
          break label595;
        }
        localObject1 = jdField_this.findViewById(l.e.loading_state_container);
        if (localObject1 == null) {
          break label641;
        }
        ((View)localObject1).setVisibility(8);
        AppMethodBeat.o(364995);
        return;
        localObject1 = null;
        break;
        localObject3 = new Rect();
        com.tencent.mm.plugin.vlog.model.h.a(((afc)localObject1).Znw.Zqq, (Rect)localObject3);
        ((dji)localObject2).width = ((Rect)localObject3).width();
        ((dji)localObject2).height = ((Rect)localObject3).height();
        break label188;
        label493:
        if (((FinderPostPreviewUI)localObject3).Brb)
        {
          ((dji)localObject2).width = ((afc)localObject1).HJN;
          ((dji)localObject2).height = ((afc)localObject1).HJO;
          break label188;
        }
        localObject3 = new Rect();
        com.tencent.mm.plugin.vlog.model.h.a(((afc)localObject1).Znp, (Rect)localObject3);
        ((dji)localObject2).width = ((Rect)localObject3).width();
        ((dji)localObject2).height = ((Rect)localObject3).height();
        break label188;
        localObject1 = null;
        break label218;
        localObject1 = null;
        break label293;
        localObject1 = null;
        break label347;
      }
      label570:
      label595:
      localObject1 = jdField_this.findViewById(l.e.loading_state_container);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = jdField_this.findViewById(l.e.tips_loading);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      label641:
      AppMethodBeat.o(364995);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    j(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<View>
  {
    k(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<TextView>
  {
    l(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<Integer>
  {
    m(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<String>
  {
    n(FinderPostPreviewUI paramFinderPostPreviewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderPostPreviewUI
 * JD-Core Version:    0.7.0.1
 */