package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dj;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.aa.b;
import com.tencent.mm.plugin.finder.feed.aa.c;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;", "()V", "TAG", "", "actionBarHeight", "", "cacheId", "", "closeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCloseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeIcon$delegate", "Lkotlin/Lazy;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "contextObj$delegate", "coordinator", "Landroid/view/View;", "getCoordinator", "()Landroid/view/View;", "coordinator$delegate", "feedLoader", "finderActionBar", "getFinderActionBar", "finderActionBar$delegate", "fromScene", "getFromScene", "()I", "fromScene$delegate", "isEnableSwitchPreviewMode", "", "isPreviewFullscreen", "()Z", "setPreviewFullscreen", "(Z)V", "isSelfFlag", "isSelfFlag$delegate", "mainContainer", "getMainContainer", "mainContainer$delegate", "presenter", "previewModeText", "Landroid/widget/TextView;", "getPreviewModeText", "()Landroid/widget/TextView;", "previewModeText$delegate", "requestAtScene", "startIntent", "Landroid/content/Intent;", "statusBarHeight", "getStatusBarHeight", "statusBarHeight$delegate", "username", "getUsername", "()Ljava/lang/String;", "username$delegate", "viewCallback", "changePreviewMode", "", "fullscreen", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "isHideStatusBar", "isOtherEnableFullScreenEnjoy", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "overlayStatusBar", "updateStyle", "isDarkMode", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI10
  extends FinderLoaderFeedUI<FinderAtFeedLoader, aa.c, aa.b>
{
  private static ConcurrentHashMap<Long, FinderItem> tZo;
  private static String udV;
  private static String udW;
  public static final a udX;
  private final String TAG;
  private HashMap _$_findViewCache;
  private final int tLA;
  private final f tYU;
  private FinderAtFeedLoader tZi;
  private long tZj;
  private final f tZk;
  private final f tZl;
  private final f tZn;
  private aa.b udJ;
  private aa.c udK;
  private final f udL;
  private final int udM;
  private final f udN;
  private final f udO;
  private final f udP;
  private final f udQ;
  private final f udR;
  private Intent udS;
  public boolean udT;
  private boolean udU;
  
  static
  {
    AppMethodBeat.i(245651);
    udX = new a((byte)0);
    tZo = new ConcurrentHashMap();
    udV = "KEY_IS_FULLSCREEN";
    udW = "KEY_ENABLE_SWITCH_PREVIEW_MODE";
    AppMethodBeat.o(245651);
  }
  
  public OccupyFinderUI10()
  {
    AppMethodBeat.i(245650);
    this.TAG = "Finder.FinderPreviewAtTimelineUI";
    this.tZk = g.ah((kotlin.g.a.a)new q(this));
    this.tYU = g.ah((kotlin.g.a.a)new c(this));
    this.tZl = g.ah((kotlin.g.a.a)new m(this));
    this.tZn = g.ah((kotlin.g.a.a)new f(this));
    this.tLA = 2;
    this.udL = g.ah((kotlin.g.a.a)new p(this));
    this.udM = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 45);
    this.udN = g.ah((kotlin.g.a.a)new n(this));
    this.udO = g.ah((kotlin.g.a.a)new d(this));
    this.udP = g.ah((kotlin.g.a.a)new e(this));
    this.udQ = g.ah((kotlin.g.a.a)new b(this));
    this.udR = g.ah((kotlin.g.a.a)new o(this));
    this.udT = true;
    this.udU = true;
    AppMethodBeat.o(245650);
  }
  
  private final int deu()
  {
    AppMethodBeat.i(245637);
    int i = ((Number)this.udL.getValue()).intValue();
    AppMethodBeat.o(245637);
    return i;
  }
  
  private final View dev()
  {
    AppMethodBeat.i(245638);
    View localView = (View)this.udN.getValue();
    AppMethodBeat.o(245638);
    return localView;
  }
  
  private final View dew()
  {
    AppMethodBeat.i(245639);
    View localView = (View)this.udO.getValue();
    AppMethodBeat.o(245639);
    return localView;
  }
  
  private final View dex()
  {
    AppMethodBeat.i(245640);
    View localView = (View)this.udP.getValue();
    AppMethodBeat.o(245640);
    return localView;
  }
  
  private final TextView dey()
  {
    AppMethodBeat.i(245642);
    TextView localTextView = (TextView)this.udR.getValue();
    AppMethodBeat.o(245642);
    return localTextView;
  }
  
  private final WeImageView getCloseIcon()
  {
    AppMethodBeat.i(245641);
    WeImageView localWeImageView = (WeImageView)this.udQ.getValue();
    AppMethodBeat.o(245641);
    return localWeImageView;
  }
  
  private final bbn getContextObj()
  {
    AppMethodBeat.i(245634);
    bbn localbbn = (bbn)this.tYU.getValue();
    AppMethodBeat.o(245634);
    return localbbn;
  }
  
  private final int getFromScene()
  {
    AppMethodBeat.i(245636);
    int i = ((Number)this.tZn.getValue()).intValue();
    AppMethodBeat.o(245636);
    return i;
  }
  
  private final String getUsername()
  {
    AppMethodBeat.i(245633);
    String str = (String)this.tZk.getValue();
    AppMethodBeat.o(245633);
    return str;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(245635);
    boolean bool = ((Boolean)this.tZl.getValue()).booleanValue();
    AppMethodBeat.o(245635);
    return bool;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245655);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245655);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245654);
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
    AppMethodBeat.o(245654);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(245649);
    if (getFromScene() == 1)
    {
      if (isSelfFlag())
      {
        AppMethodBeat.o(245649);
        return 62;
      }
      AppMethodBeat.o(245649);
      return 63;
    }
    AppMethodBeat.o(245649);
    return 13;
  }
  
  public final int getLayoutId()
  {
    return 2131494581;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245644);
    getController().p((Activity)this, getResources().getColor(2131101287));
    com.tencent.mm.ui.b.e((Activity)this, false);
    Object localObject1 = getSupportActionBar();
    if (localObject1 != null)
    {
      ((ActionBar)localObject1).setBackgroundDrawable((Drawable)new ColorDrawable(0));
      ((ActionBar)localObject1).hide();
    }
    this.udT = getIntent().getBooleanExtra(udV, false);
    this.udT = this.udT;
    Object localObject2;
    int i;
    label337:
    label484:
    label628:
    int j;
    if (this.udT)
    {
      localObject1 = dey();
      p.g(localObject1, "previewModeText");
      ((TextView)localObject1).setText((CharSequence)getString(2131763223));
      dex().setPadding(0, deu(), 0, 0);
      localObject1 = dex();
      p.g(localObject1, "finderActionBar");
      localObject2 = dex();
      p.g(localObject2, "finderActionBar");
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(245644);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).height = View.MeasureSpec.makeMeasureSpec(this.udM + deu(), 1073741824);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = dev();
      p.g(localObject1, "mainContainer");
      localObject2 = dev();
      p.g(localObject2, "mainContainer");
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(245644);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if ((!this.udT) && (!ao.isDarkMode())) {
        break label1180;
      }
      i = 1;
      if (i == 0) {
        break label1185;
      }
      localObject1 = dey();
      p.g(localObject1, "previewModeText");
      ((TextView)localObject1).setBackground(com.tencent.mm.cb.a.l((Context)getContext(), 2131232692));
      getCloseIcon().setIconColor(-1);
      localObject1 = dex();
      p.g(localObject1, "finderActionBar");
      ((View)localObject1).setBackground((Drawable)new ColorDrawable(0));
      dev().setBackgroundResource(2131099742);
      dew().setBackgroundResource(2131099742);
      setNavigationbarColor(-16777216);
      getController().updataStatusBarIcon(true);
      label446:
      this.udU = getIntent().getBooleanExtra(udW, true);
      localObject1 = dey();
      p.g(localObject1, "previewModeText");
      if (!this.udU) {
        break label1304;
      }
      i = 0;
      ((TextView)localObject1).setVisibility(i);
      getCloseIcon().setOnClickListener((View.OnClickListener)new j(this));
      dey().setOnClickListener((View.OnClickListener)new k(this));
      this.tZj = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      Log.i(this.TAG, "[initOnCreate] cacheId:" + this.tZj + " username=" + getUsername() + " fromScene=" + getFromScene());
      tZo.clear();
      if (getFromScene() == 1)
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
        if (!p.j(getUsername(), z.aUg())) {
          break label1309;
        }
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(21206, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      }
      bool = isSelfFlag();
      localObject1 = getUsername();
      p.g(localObject1, "username");
      this.udJ = new aa.b(this, bool, (String)localObject1, this.tLA, getFromScene(), getContextObj());
      localObject1 = (MMActivity)this;
      localObject2 = this.udJ;
      if (localObject2 == null) {
        p.btv("presenter");
      }
      i = this.tLA;
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
      this.udK = new aa.c((MMActivity)localObject1, (aa.b)localObject2, i, j, bool);
      localObject1 = (FrameLayout)_$_findCachedViewById(2131303713);
      p.g(localObject1, "loading_state_container");
      ((FrameLayout)localObject1).setVisibility(0);
      localObject1 = this.udK;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      ((b.b)localObject1).tLS.post((Runnable)new l(this));
      localObject1 = e.tYz;
      localObject2 = getUsername();
      p.g(localObject2, "username");
      localObject1 = new FinderAtFeedLoader((e)localObject1, (String)localObject2, getContextObj());
      localObject2 = getIntent();
      p.g(localObject2, "intent");
      ((FinderAtFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderAtFeedLoader)localObject1).tTS = ((kotlin.g.a.a)new g(this));
      ((FinderAtFeedLoader)localObject1).tVa = ((kotlin.g.a.b)new h(this));
      ((FinderAtFeedLoader)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.h)new i((FinderAtFeedLoader)localObject1, this));
      this.tZi = ((FinderAtFeedLoader)localObject1);
      AppMethodBeat.o(245644);
      return;
      localObject1 = dey();
      p.g(localObject1, "previewModeText");
      ((TextView)localObject1).setText((CharSequence)getString(2131763222));
      dex().setPadding(0, deu(), 0, 0);
      localObject1 = dex();
      p.g(localObject1, "finderActionBar");
      localObject2 = dex();
      p.g(localObject2, "finderActionBar");
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(245644);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).height = View.MeasureSpec.makeMeasureSpec(this.udM + deu(), 1073741824);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = dev();
      p.g(localObject1, "mainContainer");
      localObject2 = dev();
      p.g(localObject2, "mainContainer");
      localObject2 = ((View)localObject2).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(245644);
        throw ((Throwable)localObject1);
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (deu() + this.udM);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break;
      i = 0;
      break label337;
      localObject1 = dey();
      p.g(localObject1, "previewModeText");
      ((TextView)localObject1).setBackground(com.tencent.mm.cb.a.l((Context)getContext(), 2131232691));
      getCloseIcon().setIconColor(-16777216);
      localObject1 = dex();
      p.g(localObject1, "finderActionBar");
      ((View)localObject1).setBackground((Drawable)new ColorDrawable(getResources().getColor(2131099689)));
      dev().setBackgroundResource(2131099844);
      dew().setBackgroundResource(2131099837);
      setNavigationbarColor(-1);
      getController().updataStatusBarIcon(ao.isDarkMode());
      break label446;
      i = 4;
      break label484;
      i = 0;
      break label628;
    }
  }
  
  public final boolean isHideStatusBar()
  {
    return this.udT;
  }
  
  public final boolean isOtherEnableFullScreenEnjoy()
  {
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245643);
    Object localObject = getWindow();
    p.g(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(1280);
    localObject = getWindow();
    p.g(localObject, "window");
    ((Window)localObject).setStatusBarColor(0);
    getWindow().addFlags(67108864);
    this.udS = getIntent();
    super.onCreate(paramBundle);
    AppMethodBeat.o(245643);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245645);
    super.onDestroy();
    tZo.clear();
    AppMethodBeat.o(245645);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$Companion;", "", "()V", "KEY_IS_ENABLE_SWITCH_PREVIEW_MODE", "", "getKEY_IS_ENABLE_SWITCH_PREVIEW_MODE", "()Ljava/lang/String;", "setKEY_IS_ENABLE_SWITCH_PREVIEW_MODE", "(Ljava/lang/String;)V", "KEY_IS_FULLSCREEN", "getKEY_IS_FULLSCREEN", "setKEY_IS_FULLSCREEN", "finderFeedCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderFeedCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setFinderFeedCacheMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    b(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<bbn>
  {
    c(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<View>
  {
    d(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<View>
  {
    e(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<Integer>
  {
    f(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$4$1"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$4$2"})
  static final class h
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    h(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$4$3", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    i(FinderAtFeedLoader paramFinderAtFeedLoader, OccupyFinderUI10 paramOccupyFinderUI10) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(245624);
      Object localObject2 = j.kt((List)this.tZr.getDataList());
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ad)) {
        localObject1 = null;
      }
      localObject2 = (ad)localObject1;
      if (localObject2 != null)
      {
        ((ad)localObject2).uOq = jdField_this.udT;
        ((BaseFinderFeed)localObject2).feedObject.setPostFinish();
        localObject1 = (cjl)((BaseFinderFeed)localObject2).feedObject.getMediaList().get(0);
        if ((((BaseFinderFeed)localObject2).isPreview) && (((cjl)localObject1).MfU != null))
        {
          localObject2 = ((cjl)localObject1).MfU;
          if (localObject2 == null) {
            p.hyc();
          }
          p.g(localObject2, "media.videoCompositionInfo!!");
          localObject2 = ((acn)localObject2).Gxw;
          if (localObject2 == null) {
            p.hyc();
          }
          if (!jdField_this.udT) {
            break label423;
          }
          ((cjl)localObject1).width = ((aco)localObject2).xlg;
          ((cjl)localObject1).height = ((aco)localObject2).xlh;
        }
      }
      localObject2 = j.kt((List)this.tZr.getDataList());
      localObject1 = localObject2;
      if (!(localObject2 instanceof u)) {
        localObject1 = null;
      }
      localObject1 = (u)localObject1;
      if ((localObject1 != null) && (((BaseFinderFeed)localObject1).isPreview)) {
        ((BaseFinderFeed)localObject1).feedObject.setPostFinish();
      }
      localObject2 = OccupyFinderUI10.c(jdField_this).tLS.getRecyclerView().getLayoutManager();
      localObject1 = localObject2;
      if (!(localObject2 instanceof FinderLinearLayoutManager)) {
        localObject1 = null;
      }
      localObject1 = (FinderLinearLayoutManager)localObject1;
      if (localObject1 != null)
      {
        ((FinderLinearLayoutManager)localObject1).ah(this.tZr.getInitPos(), 0);
        ((FinderLinearLayoutManager)localObject1).wtl = false;
      }
      localObject2 = j.kt((List)this.tZr.getDataList());
      localObject1 = localObject2;
      if (!(localObject2 instanceof BaseFinderFeed)) {
        localObject1 = null;
      }
      localObject1 = (BaseFinderFeed)localObject1;
      if ((localObject1 != null) && (((BaseFinderFeed)localObject1).isPreview))
      {
        localObject1 = com.tencent.mm.plugin.vlog.report.a.GDl;
        localObject1 = com.tencent.mm.plugin.vlog.report.a.fCt();
        if (!jdField_this.udT) {
          break label470;
        }
      }
      label423:
      label470:
      for (long l = 1L;; l = 2L)
      {
        ((dj)localObject1).jE(l);
        ((dj)localObject1).jF(2L);
        ((dj)localObject1).bfK();
        if (paramInt <= 0) {
          break label477;
        }
        localObject1 = (FrameLayout)jdField_this._$_findCachedViewById(2131303713);
        p.g(localObject1, "loading_state_container");
        ((FrameLayout)localObject1).setVisibility(8);
        AppMethodBeat.o(245624);
        return;
        localObject2 = ((cjl)localObject1).MoU;
        if (localObject2 == null) {
          break;
        }
        ((cjl)localObject1).width = (((aty)localObject2).right - ((aty)localObject2).left);
        ((cjl)localObject1).height = (((aty)localObject2).bottom - ((aty)localObject2).top);
        break;
      }
      label477:
      localObject1 = (FrameLayout)jdField_this._$_findCachedViewById(2131303713);
      p.g(localObject1, "loading_state_container");
      ((FrameLayout)localObject1).setVisibility(0);
      localObject1 = (ProgressBar)jdField_this._$_findCachedViewById(2131309182);
      p.g(localObject1, "tips_loading");
      ((ProgressBar)localObject1).setVisibility(0);
      AppMethodBeat.o(245624);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(OccupyFinderUI10 paramOccupyFinderUI10) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245625);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.udY.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245625);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(OccupyFinderUI10 paramOccupyFinderUI10) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245626);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = OccupyFinderUI10.a(this.udY);
      if (paramView != null)
      {
        this.udY.finish();
        localObject = OccupyFinderUI10.udX;
        localObject = OccupyFinderUI10.dez();
        if (this.udY.udT) {
          break label194;
        }
      }
      label194:
      for (boolean bool = true;; bool = false)
      {
        paramView.putExtra((String)localObject, bool);
        localObject = y.vXH;
        y.a(0, (List)OccupyFinderUI10.b(this.udY).getDataList(), null, paramView);
        paramView = this.udY;
        localObject = OccupyFinderUI10.a(this.udY);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245626);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(OccupyFinderUI10 paramOccupyFinderUI10) {}
    
    public final void run()
    {
      AppMethodBeat.i(245627);
      OccupyFinderUI10.c(this.udY).tLS.setEnableLoadMore(false);
      OccupyFinderUI10.c(this.udY).tLS.setEnableRefresh(false);
      OccupyFinderUI10.c(this.udY).tLS.setEnablePullDownHeader(false);
      AppMethodBeat.o(245627);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    m(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<View>
  {
    n(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<TextView>
  {
    o(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<Integer>
  {
    p(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<String>
  {
    q(OccupyFinderUI10 paramOccupyFinderUI10)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10
 * JD-Core Version:    0.7.0.1
 */