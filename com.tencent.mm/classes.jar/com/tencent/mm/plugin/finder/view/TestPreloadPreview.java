package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qu;
import com.tencent.mm.f.a.zb;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.preload.c.e;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.g.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bufferSet", "Ljava/util/concurrent/ConcurrentHashMap;", "callback", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1;", "centerFeedId", "", "data", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "globalPreloadTv", "Landroid/widget/TextView;", "getGlobalPreloadTv", "()Landroid/widget/TextView;", "globalPreloadTv$delegate", "Lkotlin/Lazy;", "headerCount", "isCreated", "", "isOpenMultiBitRateDownload", "listener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1;", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaCache", "", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "notifyListener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1;", "observer", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1;", "playingIndex", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "tabType", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "buildText", "feedId", "simpleFeedId", "mediaId", "isVideo", "percent", "preloadPercent", "preloadMinSize", "fileFormat", "codingFormat", "position", "size", "hasPlayed", "relatedFeedId", "desc", "isLongVideo", "likeCount", "createDataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "findCacheInfo", "originalMediaId", "getDesc", "feed", "getItem", "notifyChange", "", "onCreate", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "onDetachedFromWindow", "Companion", "Info", "TestAdapter", "TestHolder", "plugin-finder_release"})
public final class TestPreloadPreview
  extends FrameLayout
{
  public static final a BcV;
  private final ConcurrentHashMap<Integer, Integer> BcM;
  private final f BcN;
  private int BcO;
  private final ConcurrentHashMap<String, b> BcP;
  private final e BcQ;
  private int BcR;
  private final i BcS;
  private final g BcT;
  private final j BcU;
  private boolean dfI;
  private int fEH;
  private final MMHandler mainHandler;
  private List<? extends o<? extends bu, ? extends csg>> tYs;
  private com.tencent.mm.plugin.finder.video.l xkW;
  private long xrl;
  private final boolean zKT;
  private final f zQD;
  
  static
  {
    AppMethodBeat.i(287836);
    BcV = new a((byte)0);
    AppMethodBeat.o(287836);
  }
  
  public TestPreloadPreview(final Context paramContext, final AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(287834);
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.BcM = new ConcurrentHashMap();
    this.BcN = kotlin.g.ar((kotlin.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.zKT = com.tencent.mm.plugin.finder.storage.d.dTw();
    setId(b.f.test_preload_view);
    LayoutInflater.from(getContext()).inflate(b.g.test_preload_view, (ViewGroup)this, true);
    paramContext = findViewById(b.f.test_preload_container);
    paramAttributeSet = findViewById(b.f.expand_btn);
    p.j(paramAttributeSet, "expandBtn");
    paramAttributeSet.setTag(Boolean.FALSE);
    getRecyclerView().setLayoutFrozen(true);
    paramContext.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277583);
        View localView = paramContext;
        p.j(localView, "container");
        localView.setTranslationY(-this.BcW.getRecyclerView().getHeight() - this.BcW.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(277583);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268812);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = paramAttributeSet;
        p.j(paramAnonymousView, "expandBtn");
        if (p.h(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.BcW.getRecyclerView().getHeight() - this.BcW.getGlobalPreloadTv().getHeight()).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(286420);
              this.BcY.BcW.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(286420);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          paramAnonymousView = paramAttributeSet;
          p.j(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.FALSE);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268812);
          return;
          paramContext.animate().cancel();
          paramContext.animate().translationY(0.0F).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(292066);
              paramAnonymous2Animator = this.BcY.ubr;
              p.j(paramAnonymous2Animator, "container");
              paramAnonymous2Animator.setTranslationY(0.0F);
              this.BcY.BcW.getRecyclerView().setLayoutFrozen(false);
              AppMethodBeat.o(292066);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          TestPreloadPreview.d(this.BcW).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(279203);
              Object localObject = TestPreloadPreview.a(this.BcY.BcW).iterator();
              int i = 0;
              int j;
              if (((Iterator)localObject).hasNext()) {
                if (((bu)((o)((Iterator)localObject).next()).Mx).mf() == TestPreloadPreview.c(this.BcY.BcW))
                {
                  j = 1;
                  label68:
                  if (j == 0) {
                    break label112;
                  }
                }
              }
              for (;;)
              {
                localObject = this.BcY.BcW.getRecyclerView().getLayoutManager();
                if (localObject != null) {
                  break label124;
                }
                localObject = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                AppMethodBeat.o(279203);
                throw ((Throwable)localObject);
                j = 0;
                break label68;
                label112:
                i += 1;
                break;
                i = -1;
              }
              label124:
              ((LinearLayoutManager)localObject).au(Math.max(0, i), 0);
              AppMethodBeat.o(279203);
            }
          }, 20L);
          paramAnonymousView = paramAttributeSet;
          p.j(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.TRUE);
        }
      }
    });
    this.BcP = new ConcurrentHashMap();
    this.BcQ = new e(this);
    this.BcR = -1;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.BcS = new i(this);
    this.BcT = new g(this);
    this.BcU = new j(this);
    AppMethodBeat.o(287834);
  }
  
  public TestPreloadPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(287835);
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.BcM = new ConcurrentHashMap();
    this.BcN = kotlin.g.ar((kotlin.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.zKT = com.tencent.mm.plugin.finder.storage.d.dTw();
    setId(b.f.test_preload_view);
    LayoutInflater.from(getContext()).inflate(b.g.test_preload_view, (ViewGroup)this, true);
    paramContext = findViewById(b.f.test_preload_container);
    paramAttributeSet = findViewById(b.f.expand_btn);
    p.j(paramAttributeSet, "expandBtn");
    paramAttributeSet.setTag(Boolean.FALSE);
    getRecyclerView().setLayoutFrozen(true);
    paramContext.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277583);
        View localView = paramContext;
        p.j(localView, "container");
        localView.setTranslationY(-this.BcW.getRecyclerView().getHeight() - this.BcW.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(277583);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268812);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = paramAttributeSet;
        p.j(paramAnonymousView, "expandBtn");
        if (p.h(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.BcW.getRecyclerView().getHeight() - this.BcW.getGlobalPreloadTv().getHeight()).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(286420);
              this.BcY.BcW.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(286420);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          paramAnonymousView = paramAttributeSet;
          p.j(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.FALSE);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268812);
          return;
          paramContext.animate().cancel();
          paramContext.animate().translationY(0.0F).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(292066);
              paramAnonymous2Animator = this.BcY.ubr;
              p.j(paramAnonymous2Animator, "container");
              paramAnonymous2Animator.setTranslationY(0.0F);
              this.BcY.BcW.getRecyclerView().setLayoutFrozen(false);
              AppMethodBeat.o(292066);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          TestPreloadPreview.d(this.BcW).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(279203);
              Object localObject = TestPreloadPreview.a(this.BcY.BcW).iterator();
              int i = 0;
              int j;
              if (((Iterator)localObject).hasNext()) {
                if (((bu)((o)((Iterator)localObject).next()).Mx).mf() == TestPreloadPreview.c(this.BcY.BcW))
                {
                  j = 1;
                  label68:
                  if (j == 0) {
                    break label112;
                  }
                }
              }
              for (;;)
              {
                localObject = this.BcY.BcW.getRecyclerView().getLayoutManager();
                if (localObject != null) {
                  break label124;
                }
                localObject = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                AppMethodBeat.o(279203);
                throw ((Throwable)localObject);
                j = 0;
                break label68;
                label112:
                i += 1;
                break;
                i = -1;
              }
              label124:
              ((LinearLayoutManager)localObject).au(Math.max(0, i), 0);
              AppMethodBeat.o(279203);
            }
          }, 20L);
          paramAnonymousView = paramAttributeSet;
          p.j(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.TRUE);
        }
      }
    });
    this.BcP = new ConcurrentHashMap();
    this.BcQ = new e(this);
    this.BcR = -1;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.BcS = new i(this);
    this.BcT = new g(this);
    this.BcU = new j(this);
    AppMethodBeat.o(287835);
  }
  
  private static List<o<bu, csg>> a(DataBuffer<bu> paramDataBuffer)
  {
    AppMethodBeat.i(287831);
    LinkedList localLinkedList = new LinkedList();
    paramDataBuffer = ((Iterable)paramDataBuffer).iterator();
    while (paramDataBuffer.hasNext())
    {
      bu localbu = (bu)paramDataBuffer.next();
      Object localObject;
      if ((localbu instanceof BaseFinderFeed))
      {
        localObject = FeedData.Companion;
        localObject = (csg)j.lp((List)FeedData.a.t((BaseFinderFeed)localbu).getMediaList());
        if (localObject != null) {
          localLinkedList.add(new o(localbu, localObject));
        }
      }
      else if ((localbu instanceof bs))
      {
        localObject = (csg)j.lp((List)((bs)localbu).dKV());
        if (localObject != null) {
          localLinkedList.add(new o(localbu, localObject));
        }
      }
      else if ((localbu instanceof an))
      {
        localObject = (BaseFinderFeed)j.lp((List)((an)localbu).rvFeedList);
        if (localObject != null)
        {
          localObject = ((BaseFinderFeed)localObject).feedObject;
          if (localObject != null)
          {
            localObject = ((FinderItem)localObject).getMediaList();
            if (localObject != null)
            {
              localObject = (csg)j.lp((List)localObject);
              if (localObject != null) {
                localLinkedList.add(new o(localbu, localObject));
              }
            }
          }
        }
      }
    }
    paramDataBuffer = (List)localLinkedList;
    AppMethodBeat.o(287831);
    return paramDataBuffer;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(DataBuffer<bu> paramDataBuffer, int paramInt1, com.tencent.mm.plugin.finder.video.l paraml, com.tencent.mm.plugin.finder.event.base.c paramc, int paramInt2)
  {
    AppMethodBeat.i(287832);
    p.k(paramDataBuffer, "data");
    p.k(paraml, "videoCore");
    this.dfI = true;
    this.tYs = a(paramDataBuffer);
    this.fEH = paramInt2;
    this.xkW = paraml;
    this.BcO = paramInt1;
    paramDataBuffer = getRecyclerView();
    getContext();
    paramDataBuffer.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramDataBuffer = new c();
    paramDataBuffer.aw(true);
    getRecyclerView().setAdapter((RecyclerView.a)paramDataBuffer);
    getRecyclerView().setHasFixedSize(true);
    if (paramc != null) {
      paramc.a((com.tencent.mm.plugin.finder.event.base.d)this.BcU);
    }
    this.BcT.alive();
    this.BcS.alive();
    paramDataBuffer = paraml.ANC;
    if (paramDataBuffer != null) {
      paramDataBuffer.a((com.tencent.mm.plugin.finder.preload.b)this.BcQ);
    }
    getRecyclerView().setOnTouchListener((View.OnTouchListener)new k(this));
    AppMethodBeat.o(287832);
  }
  
  public final TextView getGlobalPreloadTv()
  {
    AppMethodBeat.i(287830);
    TextView localTextView = (TextView)this.BcN.getValue();
    AppMethodBeat.o(287830);
    return localTextView;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(287829);
    RecyclerView localRecyclerView = (RecyclerView)this.zQD.getValue();
    AppMethodBeat.o(287829);
    return localRecyclerView;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(287833);
    super.onDetachedFromWindow();
    if (this.dfI)
    {
      this.BcT.dead();
      this.BcS.dead();
      Object localObject1 = this.xkW;
      if (localObject1 == null) {
        p.bGy("videoCore");
      }
      Object localObject2 = ((com.tencent.mm.plugin.finder.video.l)localObject1).ANC;
      if (localObject2 != null)
      {
        localObject1 = (com.tencent.mm.plugin.finder.preload.b)this.BcQ;
        p.k(localObject1, "callback");
        localObject2 = ((com.tencent.mm.plugin.finder.preload.c)localObject2).zKg;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject2).zMc;
          if (localObject2 != null) {
            j.a((Iterable)localObject2, (kotlin.g.a.b)new c.e((com.tencent.mm.plugin.finder.preload.b)localObject1));
          }
        }
      }
      this.dfI = false;
    }
    AppMethodBeat.o(287833);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "", "()V", "codingFormat", "", "getCodingFormat", "()Ljava/lang/String;", "setCodingFormat", "(Ljava/lang/String;)V", "fileFormat", "getFileFormat", "setFileFormat", "hasPlayed", "getHasPlayed", "setHasPlayed", "percent", "", "getPercent", "()I", "setPercent", "(I)V", "preloadMinSize", "", "getPreloadMinSize", "()J", "setPreloadMinSize", "(J)V", "preloadPercent", "getPreloadPercent", "setPreloadPercent", "size", "getSize", "setSize", "state", "getState", "setState", "plugin-finder_release"})
  public static final class b
  {
    String BcZ;
    String fPD;
    int iVi;
    int percent;
    long preloadMinSize;
    int size;
    int state;
    String zKY;
    
    public final int eju()
    {
      if (this.iVi == 0) {
        return this.percent;
      }
      return this.iVi;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<TestPreloadPreview.d>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(290281);
      int i = TestPreloadPreview.a(this.BcW).size();
      AppMethodBeat.o(290281);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(290282);
      Object localObject = TestPreloadPreview.a(this.BcW, paramInt);
      if (localObject != null)
      {
        localObject = (bu)((o)localObject).Mx;
        if (localObject != null)
        {
          long l = ((bu)localObject).mf();
          AppMethodBeat.o(290282);
          return l;
        }
      }
      AppMethodBeat.o(290282);
      return 0L;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mediaIdTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getMediaIdTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.v
  {
    final TextView Bda;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(276404);
      this.Bda = ((TextView)paramView.findViewById(b.f.media_id_tv));
      AppMethodBeat.o(276404);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getOriginalMediaId", "", "mediaId", "onCancel", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onReject", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.plugin.finder.preload.b
  {
    private static String aGy(String paramString)
    {
      AppMethodBeat.i(280031);
      String str = n.l(paramString, "finder_video_", "", false);
      CharSequence localCharSequence = (CharSequence)str;
      int k = localCharSequence.length();
      int i = 0;
      int j;
      if (i < k) {
        if (localCharSequence.charAt(i) == '_')
        {
          j = 1;
          label53:
          if (j == 0) {
            break label90;
          }
        }
      }
      for (;;)
      {
        if (i < 0) {
          break label102;
        }
        paramString = str.subSequence(i + 1, str.length()).toString();
        AppMethodBeat.o(280031);
        return paramString;
        j = 0;
        break label53;
        label90:
        i += 1;
        break;
        i = -1;
      }
      label102:
      AppMethodBeat.o(280031);
      return paramString;
    }
    
    public final void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.plugin.finder.preload.d paramd)
    {
      AppMethodBeat.i(280032);
      p.k(paramString1, "mediaId");
      p.k(paramString2, "fileFormat");
      p.k(paramString3, "codingFormat");
      p.k(paramd, "task");
      paramString1 = TestPreloadPreview.a(this.BcW, aGy(paramString1));
      paramString1.iVi = paramInt;
      paramString1.state = 2;
      paramString1.zKY = paramString3;
      paramString1.fPD = paramString2;
      paramString1.preloadMinSize = paramd.preloadMinSize;
      TestPreloadPreview.g(this.BcW);
      AppMethodBeat.o(280032);
    }
    
    public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.finder.preload.d paramd)
    {
      AppMethodBeat.i(280037);
      p.k(paramString1, "mediaId");
      p.k(paramString2, "msg");
      p.k(paramd, "task");
      AppMethodBeat.o(280037);
    }
    
    public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.finder.preload.d paramd)
    {
      AppMethodBeat.i(280035);
      p.k(paramString, "mediaId");
      p.k(paramd, "task");
      paramString = TestPreloadPreview.a(this.BcW, aGy(paramString));
      paramString.preloadMinSize = paramd.preloadMinSize;
      paramString.iVi = paramInt;
      paramString.state = 3;
      TestPreloadPreview.g(this.BcW);
      AppMethodBeat.o(280035);
    }
    
    public final void aDB(String paramString)
    {
      AppMethodBeat.i(280038);
      p.k(paramString, "mediaId");
      AppMethodBeat.o(280038);
    }
    
    public final void aDC(String paramString)
    {
      AppMethodBeat.i(280040);
      p.k(paramString, "mediaId");
      AppMethodBeat.o(280040);
    }
    
    public final void dT(String paramString, int paramInt)
    {
      AppMethodBeat.i(280034);
      p.k(paramString, "mediaId");
      paramString = TestPreloadPreview.a(this.BcW, aGy(paramString));
      paramString.iVi = paramInt;
      paramString.state = 2;
      TestPreloadPreview.g(this.BcW);
      AppMethodBeat.o(280034);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<TextView>
  {
    f(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/PreloadProcessChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class g
    extends IListener<qu>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final void run()
    {
      AppMethodBeat.i(286177);
      int i = CdnLogic.getRecentAverageSpeed(2);
      com.tencent.mm.plugin.finder.preload.model.a locala = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getMediaPreloadModel();
      Object localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(as.class);
      p.j(localObject, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
      localObject = (as)localObject;
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(i + "kb/s | " + locala.zKK + ':' + locala.zKJ + ':' + locala.zKC + ':' + locala.zKD + ':' + locala.zKG + " | video=" + as.a((as)localObject) + " | buf=" + (Integer)TestPreloadPreview.e(this.BcW).get(Integer.valueOf(TestPreloadPreview.f(this.BcW)))) {});
      AppMethodBeat.o(286177);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/TestPreloadPreviewNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends IListener<zb>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class j
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(269364);
      p.k(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
        AppMethodBeat.o(269364);
        return;
      }
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramb));
        AppMethodBeat.o(269364);
        return;
      }
      if ((paramb instanceof c.a)) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramb));
      }
      AppMethodBeat.o(269364);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(269365);
      p.k(paramc, "dispatcher");
      p.k(paramb, "event");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        if (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0)
        {
          AppMethodBeat.o(269365);
          return true;
        }
        AppMethodBeat.o(269365);
        return false;
      }
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        AppMethodBeat.o(269365);
        return true;
      }
      if ((paramb instanceof c.a))
      {
        if (((c.a)paramb).type == 1)
        {
          AppMethodBeat.o(269365);
          return true;
        }
        AppMethodBeat.o(269365);
        return false;
      }
      AppMethodBeat.o(269365);
      return false;
    }
    
    public final boolean dpw()
    {
      return true;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(TestPreloadPreview.j paramj)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(TestPreloadPreview.j paramj, com.tencent.mm.plugin.finder.event.base.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(TestPreloadPreview.j paramj, com.tencent.mm.plugin.finder.event.base.b paramb)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class k
    implements View.OnTouchListener
  {
    k(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(247435);
      p.j(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0) {
        TestPreloadPreview.d(this.BcW).removeCallbacksAndMessages(null);
      }
      for (;;)
      {
        AppMethodBeat.o(247435);
        return false;
        if (paramMotionEvent.getAction() == 1)
        {
          TestPreloadPreview.d(this.BcW).removeCallbacksAndMessages(null);
          TestPreloadPreview.d(this.BcW).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(285878);
              Object localObject = TestPreloadPreview.a(this.Bdd.BcW).iterator();
              int i = 0;
              int j;
              if (((Iterator)localObject).hasNext()) {
                if (((bu)((o)((Iterator)localObject).next()).Mx).mf() == TestPreloadPreview.c(this.Bdd.BcW))
                {
                  j = 1;
                  label68:
                  if (j == 0) {
                    break label112;
                  }
                }
              }
              for (;;)
              {
                localObject = this.Bdd.BcW.getRecyclerView().getLayoutManager();
                if (localObject != null) {
                  break label124;
                }
                localObject = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                AppMethodBeat.o(285878);
                throw ((Throwable)localObject);
                j = 0;
                break label68;
                label112:
                i += 1;
                break;
                i = -1;
              }
              label124:
              ((LinearLayoutManager)localObject).au(Math.max(0, i), 0);
              AppMethodBeat.o(285878);
            }
          }, 3000L);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    l(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.TestPreloadPreview
 * JD-Core Version:    0.7.0.1
 */