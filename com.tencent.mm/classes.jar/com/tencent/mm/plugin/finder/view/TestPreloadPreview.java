package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.si;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.preload.e;
import com.tencent.mm.plugin.finder.preload.f.e;
import com.tencent.mm.plugin.finder.preload.g;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.viewmodel.component.be;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1;", "centerFeedId", "", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "globalPreloadTv", "Landroid/widget/TextView;", "getGlobalPreloadTv", "()Landroid/widget/TextView;", "globalPreloadTv$delegate", "Lkotlin/Lazy;", "headerCount", "isCreated", "", "isOpenMultiBitRateDownload", "lastAutoLoadCost", "lastAutoLoadCount", "lastAutoLoadStatus", "listener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1;", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "notifyListener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1;", "observer", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1;", "playingIndex", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "streamInfoBtn", "getStreamInfoBtn", "streamInfoBtn$delegate", "tabType", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "buildText", "feedId", "simpleFeedId", "mediaId", "mediaType", "percent", "preloadPercent", "receivedSize", "fileFormat", "codingFormat", "position", "size", "hasPlayed", "relatedFeedId", "desc", "isLongVideo", "firstFrameTimeConsume", "findCacheInfo", "originalMediaId", "getDesc", "feed", "getItem", "getMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getOriginalMediaId", "getTranslateOffset", "", "notifyChange", "", "onAttach", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "onDetachedFromWindow", "Companion", "Info", "TestAdapter", "TestHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TestPreloadPreview
  extends FrameLayout
{
  public static final TestPreloadPreview.a GFA;
  private l AJn;
  private long AOv;
  private final j CNQ;
  private final boolean EVA;
  private DataBuffer<cc> Ewu;
  private final j GFB;
  private final j GFC;
  private final ConcurrentHashMap<String, b> GFD;
  private final e GFE;
  private int GFF;
  private long GFG;
  private int GFH;
  private int GFI;
  private final TestPreloadPreview.notifyListener.1 GFJ;
  private final listener.1 GFK;
  private final j GFL;
  private boolean feX;
  private int hJx;
  private final MMHandler mainHandler;
  private int xZt;
  
  static
  {
    AppMethodBeat.i(345359);
    GFA = new TestPreloadPreview.a((byte)0);
    AppMethodBeat.o(345359);
  }
  
  public TestPreloadPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345149);
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.GFB = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.GFC = kotlin.k.cm((kotlin.g.a.a)new l(this));
    paramContext = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.EVA = com.tencent.mm.plugin.finder.storage.d.eRL();
    setId(e.e.test_preload_view);
    LayoutInflater.from(getContext()).inflate(e.f.test_preload_view, (ViewGroup)this, true);
    Object localObject = findViewById(e.e.test_preload_container);
    paramContext = findViewById(e.e.expand_btn);
    paramAttributeSet = findViewById(e.e.expand_btn_out);
    View localView = findViewById(e.e.content_layout);
    localView.getLayoutParams().width = MMApplicationContext.getResources().getDisplayMetrics().widthPixels;
    localView.requestLayout();
    localView = findViewById(e.e.content_layout_parent);
    localView.getLayoutParams().width = (MMApplicationContext.getResources().getDisplayMetrics().widthPixels + (int)MMApplicationContext.getResources().getDimension(e.c.Edge_3A));
    localView.requestLayout();
    ((View)localObject).getLayoutParams().width = (MMApplicationContext.getResources().getDisplayMetrics().widthPixels + (int)MMApplicationContext.getResources().getDimension(e.c.Edge_3A));
    ((View)localObject).requestLayout();
    ((View)localObject).requestLayout();
    paramContext.setTag(Boolean.FALSE);
    paramAttributeSet.setAlpha(1.0F);
    paramContext.setAlpha(0.0F);
    getRecyclerView().setLayoutFrozen(true);
    ((View)localObject).post(new TestPreloadPreview..ExternalSyntheticLambda3((View)localObject, this));
    localObject = new TestPreloadPreview..ExternalSyntheticLambda0(paramContext, paramAttributeSet, (View)localObject, this);
    paramContext.setOnClickListener((View.OnClickListener)localObject);
    paramAttributeSet.setOnClickListener((View.OnClickListener)localObject);
    this.GFD = new ConcurrentHashMap();
    this.GFE = new e(this);
    this.GFF = -1;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.GFJ = new TestPreloadPreview.notifyListener.1(this, com.tencent.mm.app.f.hfK);
    this.GFK = new IListener(com.tencent.mm.app.f.hfK) {};
    this.GFL = new j(this);
    AppMethodBeat.o(345149);
  }
  
  public TestPreloadPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345158);
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.GFB = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.GFC = kotlin.k.cm((kotlin.g.a.a)new l(this));
    paramContext = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.EVA = com.tencent.mm.plugin.finder.storage.d.eRL();
    setId(e.e.test_preload_view);
    LayoutInflater.from(getContext()).inflate(e.f.test_preload_view, (ViewGroup)this, true);
    Object localObject = findViewById(e.e.test_preload_container);
    paramContext = findViewById(e.e.expand_btn);
    paramAttributeSet = findViewById(e.e.expand_btn_out);
    View localView = findViewById(e.e.content_layout);
    localView.getLayoutParams().width = MMApplicationContext.getResources().getDisplayMetrics().widthPixels;
    localView.requestLayout();
    localView = findViewById(e.e.content_layout_parent);
    localView.getLayoutParams().width = (MMApplicationContext.getResources().getDisplayMetrics().widthPixels + (int)MMApplicationContext.getResources().getDimension(e.c.Edge_3A));
    localView.requestLayout();
    ((View)localObject).getLayoutParams().width = (MMApplicationContext.getResources().getDisplayMetrics().widthPixels + (int)MMApplicationContext.getResources().getDimension(e.c.Edge_3A));
    ((View)localObject).requestLayout();
    ((View)localObject).requestLayout();
    paramContext.setTag(Boolean.FALSE);
    paramAttributeSet.setAlpha(1.0F);
    paramContext.setAlpha(0.0F);
    getRecyclerView().setLayoutFrozen(true);
    ((View)localObject).post(new TestPreloadPreview..ExternalSyntheticLambda3((View)localObject, this));
    localObject = new TestPreloadPreview..ExternalSyntheticLambda0(paramContext, paramAttributeSet, (View)localObject, this);
    paramContext.setOnClickListener((View.OnClickListener)localObject);
    paramAttributeSet.setOnClickListener((View.OnClickListener)localObject);
    this.GFD = new ConcurrentHashMap();
    this.GFE = new e(this);
    this.GFF = -1;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.GFJ = new TestPreloadPreview.notifyListener.1(this, com.tencent.mm.app.f.hfK);
    this.GFK = new IListener(com.tencent.mm.app.f.hfK) {};
    this.GFL = new j(this);
    AppMethodBeat.o(345158);
  }
  
  private static final void a(View paramView1, View paramView2, View paramView3, final TestPreloadPreview paramTestPreloadPreview, View paramView4)
  {
    AppMethodBeat.i(345228);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    localb.cH(paramView3);
    localb.cH(paramTestPreloadPreview);
    localb.cH(paramView4);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/TestPreloadPreview", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramTestPreloadPreview, "this$0");
    if (s.p(paramView1.getTag(), Boolean.TRUE))
    {
      paramView2.animate().cancel();
      paramView2.setAlpha(0.0F);
      paramView2.animate().alpha(1.0F).setDuration(360L).start();
      paramView1.animate().cancel();
      paramView1.animate().alpha(0.0F).setDuration(360L).start();
      paramView3.animate().cancel();
      paramView3.animate().translationX(-paramTestPreloadPreview.getTranslateOffset()).setListener((Animator.AnimatorListener)new f(paramTestPreloadPreview)).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(250L).start();
      paramView1.setTag(Boolean.FALSE);
      paramTestPreloadPreview.getStreamInfoBtn().setClickable(false);
      paramTestPreloadPreview.getStreamInfoBtn().setOnClickListener(null);
    }
    for (;;)
    {
      paramTestPreloadPreview.getStreamInfoBtn().setClickable(true);
      paramTestPreloadPreview.getStreamInfoBtn().setOnClickListener(new TestPreloadPreview..ExternalSyntheticLambda1(paramTestPreloadPreview));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/TestPreloadPreview", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345228);
      return;
      paramView1.animate().cancel();
      paramView1.setAlpha(0.0F);
      paramView1.animate().alpha(1.0F).setDuration(360L).start();
      paramView2.animate().cancel();
      paramView2.animate().alpha(0.0F).setDuration(360L).start();
      paramView3.animate().cancel();
      paramView3.animate().translationX(0.0F).setListener((Animator.AnimatorListener)new g(paramView3, paramTestPreloadPreview)).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(250L).start();
      paramTestPreloadPreview.mainHandler.postDelayed(new TestPreloadPreview..ExternalSyntheticLambda4(paramTestPreloadPreview), 20L);
      paramView1.setTag(Boolean.TRUE);
    }
  }
  
  private static final void a(View paramView, TestPreloadPreview paramTestPreloadPreview)
  {
    AppMethodBeat.i(345201);
    s.u(paramTestPreloadPreview, "this$0");
    paramView.setTranslationX(-paramTestPreloadPreview.getTranslateOffset());
    AppMethodBeat.o(345201);
  }
  
  private static final void a(TestPreloadPreview paramTestPreloadPreview)
  {
    AppMethodBeat.i(345184);
    s.u(paramTestPreloadPreview, "this$0");
    DataBuffer localDataBuffer = paramTestPreloadPreview.Ewu;
    Object localObject = localDataBuffer;
    if (localDataBuffer == null)
    {
      s.bIx("data");
      localObject = null;
    }
    localObject = ((List)localObject).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((cc)((Iterator)localObject).next()).bZA() == paramTestPreloadPreview.AOv)
      {
        j = 1;
        label80:
        if (j == 0) {
          break label180;
        }
      }
    }
    for (;;)
    {
      paramTestPreloadPreview = paramTestPreloadPreview.getRecyclerView();
      localObject = com.tencent.mm.hellhoundlib.b.c.a(kotlin.k.k.qu(0, i), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramTestPreloadPreview, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/view/TestPreloadPreview", "onAttach$lambda-2$lambda-1", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramTestPreloadPreview.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramTestPreloadPreview, "com/tencent/mm/plugin/finder/view/TestPreloadPreview", "onAttach$lambda-2$lambda-1", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(345184);
      return;
      j = 0;
      break label80;
      label180:
      i += 1;
      break;
      i = -1;
    }
  }
  
  private static final void a(TestPreloadPreview paramTestPreloadPreview, View paramView)
  {
    AppMethodBeat.i(345216);
    s.u(paramTestPreloadPreview, "this$0");
    paramView = com.tencent.mm.plugin.finder.tools.a.FNQ;
    paramTestPreloadPreview = paramTestPreloadPreview.getContext();
    s.s(paramTestPreloadPreview, "context");
    paramView = com.tencent.mm.plugin.finder.debug.a.ANe;
    com.tencent.mm.plugin.finder.tools.a.a(paramTestPreloadPreview, com.tencent.mm.plugin.finder.debug.a.dYg(), null, null, 60);
    AppMethodBeat.o(345216);
  }
  
  private static final boolean a(TestPreloadPreview paramTestPreloadPreview, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(345195);
    s.u(paramTestPreloadPreview, "this$0");
    if (paramMotionEvent.getAction() == 0) {
      paramTestPreloadPreview.mainHandler.removeCallbacksAndMessages(null);
    }
    for (;;)
    {
      AppMethodBeat.o(345195);
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        paramTestPreloadPreview.mainHandler.removeCallbacksAndMessages(null);
        paramTestPreloadPreview.mainHandler.postDelayed(new TestPreloadPreview..ExternalSyntheticLambda6(paramTestPreloadPreview), 3000L);
      }
    }
  }
  
  private static final void b(TestPreloadPreview paramTestPreloadPreview)
  {
    AppMethodBeat.i(345210);
    s.u(paramTestPreloadPreview, "this$0");
    DataBuffer localDataBuffer = paramTestPreloadPreview.Ewu;
    Object localObject = localDataBuffer;
    if (localDataBuffer == null)
    {
      s.bIx("data");
      localObject = null;
    }
    localObject = ((List)localObject).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((cc)((Iterator)localObject).next()).bZA() == paramTestPreloadPreview.AOv)
      {
        j = 1;
        label80:
        if (j == 0) {
          break label120;
        }
      }
    }
    for (;;)
    {
      paramTestPreloadPreview = paramTestPreloadPreview.getRecyclerView().getLayoutManager();
      if (paramTestPreloadPreview != null) {
        break label132;
      }
      paramTestPreloadPreview = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(345210);
      throw paramTestPreloadPreview;
      j = 0;
      break label80;
      label120:
      i += 1;
      break;
      i = -1;
    }
    label132:
    ((LinearLayoutManager)paramTestPreloadPreview).bo(Math.max(0, i), 0);
    AppMethodBeat.o(345210);
  }
  
  private static final void c(TestPreloadPreview paramTestPreloadPreview)
  {
    AppMethodBeat.i(345238);
    s.u(paramTestPreloadPreview, "this$0");
    int i = CdnLogic.getRecentAverageSpeed(2);
    Object localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel();
    Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject2 = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(be.class);
    s.s(localObject2, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
    localObject2 = (be)localObject2;
    int j = ((be)localObject2).bh(FinderThumbPlayerProxy.class);
    int k = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcp, 3);
    localObject2 = new StringBuilder().append(i).append("kb/s | ").append(((com.tencent.mm.plugin.finder.preload.model.b)localObject1).EVj).append(':').append(((com.tencent.mm.plugin.finder.preload.model.b)localObject1).EVk).append(':').append(((com.tencent.mm.plugin.finder.preload.model.b)localObject1).EVn).append(" | tp=").append(j).append(" ?=").append(be.a((be)localObject2) - j).append(" | autoPage=").append(k).append(':').append(paramTestPreloadPreview.GFH).append(':').append(paramTestPreloadPreview.GFG);
    if (paramTestPreloadPreview.GFI == 1) {}
    for (localObject1 = "...";; localObject1 = "")
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(paramTestPreloadPreview, (String)localObject1));
      AppMethodBeat.o(345238);
      return;
    }
  }
  
  private final float getTranslateOffset()
  {
    AppMethodBeat.i(345168);
    if (getRecyclerView().getWidth() <= 0.0F)
    {
      f = MMApplicationContext.getResources().getDisplayMetrics().widthPixels;
      AppMethodBeat.o(345168);
      return f;
    }
    float f = getRecyclerView().getWidth();
    AppMethodBeat.o(345168);
    return f;
  }
  
  public final void a(DataBuffer<cc> paramDataBuffer, int paramInt1, l paraml, com.tencent.mm.plugin.finder.event.base.c paramc, int paramInt2)
  {
    AppMethodBeat.i(345434);
    s.u(paramDataBuffer, "data");
    s.u(paraml, "videoCore");
    this.feX = true;
    this.Ewu = paramDataBuffer;
    this.hJx = paramInt2;
    this.AJn = paraml;
    this.xZt = paramInt1;
    paramDataBuffer = getRecyclerView();
    getContext();
    paramDataBuffer.setLayoutManager((RecyclerView.LayoutManager)new TestPreloadPreview.onAttach.1());
    paramDataBuffer = new c();
    paramDataBuffer.bf(true);
    getRecyclerView().setAdapter((RecyclerView.a)paramDataBuffer);
    getRecyclerView().setHasFixedSize(true);
    if (paramc != null) {
      paramc.a((com.tencent.mm.plugin.finder.event.base.d)this.GFL);
    }
    this.GFK.alive();
    this.GFJ.alive();
    paraml = paraml.Gqb;
    if (paraml != null)
    {
      paramDataBuffer = (e)this.GFE;
      s.u(paramDataBuffer, "callback");
      paraml = paraml.EUF;
      if (paraml != null)
      {
        paraml = paraml.EXc;
        if (paraml != null) {
          paraml.add(paramDataBuffer);
        }
      }
    }
    getRecyclerView().setNestedScrollingEnabled(false);
    getRecyclerView().setOnTouchListener(new TestPreloadPreview..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(345434);
  }
  
  public final TextView getGlobalPreloadTv()
  {
    AppMethodBeat.i(345414);
    Object localObject = this.GFB.getValue();
    s.s(localObject, "<get-globalPreloadTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(345414);
    return localObject;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(345406);
    Object localObject = this.CNQ.getValue();
    s.s(localObject, "<get-recyclerView>(...)");
    localObject = (RecyclerView)localObject;
    AppMethodBeat.o(345406);
    return localObject;
  }
  
  public final TextView getStreamInfoBtn()
  {
    AppMethodBeat.i(345423);
    Object localObject = this.GFC.getValue();
    s.s(localObject, "<get-streamInfoBtn>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(345423);
    return localObject;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(345442);
    super.onDetachedFromWindow();
    if (this.feX)
    {
      this.GFK.dead();
      this.GFJ.dead();
      Object localObject2 = this.AJn;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("videoCore");
        localObject1 = null;
      }
      localObject2 = ((l)localObject1).Gqb;
      if (localObject2 != null)
      {
        localObject1 = (e)this.GFE;
        s.u(localObject1, "callback");
        localObject2 = ((com.tencent.mm.plugin.finder.preload.f)localObject2).EUF;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject2).EXc;
          if (localObject2 != null) {
            p.a((Iterable)localObject2, (kotlin.g.a.b)new f.e((e)localObject1));
          }
        }
      }
      this.feX = false;
    }
    AppMethodBeat.o(345442);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "", "()V", "codingFormat", "", "getCodingFormat", "()Ljava/lang/String;", "setCodingFormat", "(Ljava/lang/String;)V", "fileFormat", "getFileFormat", "setFileFormat", "firstFrameTimeConsume", "", "getFirstFrameTimeConsume", "()J", "setFirstFrameTimeConsume", "(J)V", "hasPlayed", "getHasPlayed", "setHasPlayed", "percent", "", "getPercent", "()I", "setPercent", "(I)V", "preloadPercent", "getPreloadPercent", "setPreloadPercent", "receivedSize", "getReceivedSize", "setReceivedSize", "size", "getSize", "setSize", "state", "getState", "setState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    String EVK;
    long GFM;
    String GFN;
    long GFO;
    String hVy;
    int lxn;
    int percent;
    int size;
    int state;
    
    public final int flH()
    {
      if (this.lxn == 0) {
        return this.percent;
      }
      return this.lxn;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.a<TestPreloadPreview.d>
  {
    public c()
    {
      AppMethodBeat.i(344232);
      AppMethodBeat.o(344232);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(344240);
      DataBuffer localDataBuffer2 = TestPreloadPreview.d(this.GFP);
      DataBuffer localDataBuffer1 = localDataBuffer2;
      if (localDataBuffer2 == null)
      {
        s.bIx("data");
        localDataBuffer1 = null;
      }
      int i = localDataBuffer1.getTotalSize();
      AppMethodBeat.o(344240);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(344243);
      cc localcc = TestPreloadPreview.a(this.GFP, paramInt);
      if (localcc == null)
      {
        AppMethodBeat.o(344243);
        return 0L;
      }
      long l = localcc.bZA();
      AppMethodBeat.o(344243);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "onCancel", "", "mediaId", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "receivedSize", "", "onReject", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements e
  {
    e(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final void B(String paramString, int paramInt, long paramLong)
    {
      AppMethodBeat.i(344262);
      s.u(paramString, "mediaId");
      paramString = TestPreloadPreview.a(this.GFP, TestPreloadPreview.aCI(paramString));
      paramString.lxn = paramInt;
      paramString.GFM = paramLong;
      paramString.state = 2;
      TestPreloadPreview.g(this.GFP);
      AppMethodBeat.o(344262);
    }
    
    public final void a(String paramString1, int paramInt, String paramString2, String paramString3, g paramg)
    {
      AppMethodBeat.i(344256);
      s.u(paramString1, "mediaId");
      s.u(paramString2, "fileFormat");
      s.u(paramString3, "codingFormat");
      s.u(paramg, "task");
      paramString1 = TestPreloadPreview.a(this.GFP, TestPreloadPreview.aCI(paramString1));
      paramString1.lxn = paramInt;
      paramString1.state = 2;
      paramString1.EVK = paramString3;
      paramString1.hVy = paramString2;
      TestPreloadPreview.g(this.GFP);
      AppMethodBeat.o(344256);
    }
    
    public final void a(String paramString, g paramg)
    {
      AppMethodBeat.i(344287);
      s.u(paramString, "mediaId");
      s.u(paramg, "task");
      AppMethodBeat.o(344287);
    }
    
    public final void a(String paramString1, String paramString2, g paramg)
    {
      AppMethodBeat.i(344272);
      s.u(paramString1, "mediaId");
      s.u(paramString2, "msg");
      s.u(paramg, "task");
      AppMethodBeat.o(344272);
    }
    
    public final void a(String paramString, boolean paramBoolean, int paramInt, g paramg, long paramLong)
    {
      AppMethodBeat.i(344268);
      s.u(paramString, "mediaId");
      s.u(paramg, "task");
      paramString = TestPreloadPreview.a(this.GFP, TestPreloadPreview.aCI(paramString));
      paramString.GFM = paramLong;
      paramString.lxn = paramInt;
      paramString.state = 3;
      TestPreloadPreview.g(this.GFP);
      AppMethodBeat.o(344268);
    }
    
    public final void azf(String paramString)
    {
      AppMethodBeat.i(344279);
      s.u(paramString, "mediaId");
      AppMethodBeat.o(344279);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$clickListener$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements Animator.AnimatorListener
  {
    f(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(344258);
      this.GFP.getRecyclerView().setLayoutFrozen(true);
      AppMethodBeat.o(344258);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$clickListener$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements Animator.AnimatorListener
  {
    g(View paramView, TestPreloadPreview paramTestPreloadPreview) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(344274);
      this.xeJ.setTranslationX(0.0F);
      paramTestPreloadPreview.getRecyclerView().setLayoutFrozen(false);
      AppMethodBeat.o(344274);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TextView>
  {
    h(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(TestPreloadPreview paramTestPreloadPreview, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    j(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(344349);
      s.u(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.GFP));
        AppMethodBeat.o(344349);
        return;
      }
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this.GFP, paramb));
        AppMethodBeat.o(344349);
        return;
      }
      if ((paramb instanceof c.a)) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramb, this.GFP));
      }
      AppMethodBeat.o(344349);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(344369);
      s.u(paramc, "dispatcher");
      s.u(paramb, "event");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 7))
        {
          AppMethodBeat.o(344369);
          return true;
        }
        AppMethodBeat.o(344369);
        return false;
      }
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        AppMethodBeat.o(344369);
        return true;
      }
      if ((paramb instanceof c.a))
      {
        if ((((c.a)paramb).type == 1) || (((c.a)paramb).type == 19))
        {
          AppMethodBeat.o(344369);
          return true;
        }
        AppMethodBeat.o(344369);
        return false;
      }
      AppMethodBeat.o(344369);
      return false;
    }
    
    public final boolean dXA()
    {
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(TestPreloadPreview paramTestPreloadPreview)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(TestPreloadPreview paramTestPreloadPreview, com.tencent.mm.plugin.finder.event.base.b paramb)
      {
        super();
      }
      
      private static final void h(TestPreloadPreview paramTestPreloadPreview)
      {
        AppMethodBeat.i(344682);
        s.u(paramTestPreloadPreview, "this$0");
        DataBuffer localDataBuffer = TestPreloadPreview.d(paramTestPreloadPreview);
        Object localObject = localDataBuffer;
        if (localDataBuffer == null)
        {
          s.bIx("data");
          localObject = null;
        }
        localObject = ((List)localObject).iterator();
        int i = 0;
        int j;
        if (((Iterator)localObject).hasNext()) {
          if (((cc)((Iterator)localObject).next()).bZA() == TestPreloadPreview.f(paramTestPreloadPreview))
          {
            j = 1;
            label77:
            if (j == 0) {
              break label164;
            }
          }
        }
        for (;;)
        {
          paramTestPreloadPreview = paramTestPreloadPreview.getRecyclerView();
          localObject = com.tencent.mm.hellhoundlib.b.c.a(Math.max(0, i), new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramTestPreloadPreview, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1$onEventHappen$2", "invoke$lambda-1", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "Undefined", "smoothScrollToPosition", "(I)V");
          paramTestPreloadPreview.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramTestPreloadPreview, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1$onEventHappen$2", "invoke$lambda-1", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "Undefined", "smoothScrollToPosition", "(I)V");
          AppMethodBeat.o(344682);
          return;
          j = 0;
          break label77;
          label164:
          i += 1;
          break;
          i = -1;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(com.tencent.mm.plugin.finder.event.base.b paramb, TestPreloadPreview paramTestPreloadPreview)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    k(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<TextView>
  {
    l(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.TestPreloadPreview
 * JD-Core Version:    0.7.0.1
 */