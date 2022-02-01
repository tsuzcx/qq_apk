package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
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
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.xu;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bufferSet", "Ljava/util/concurrent/ConcurrentHashMap;", "callback", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1;", "centerFeedId", "", "data", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "globalPreloadTv", "Landroid/widget/TextView;", "getGlobalPreloadTv", "()Landroid/widget/TextView;", "globalPreloadTv$delegate", "Lkotlin/Lazy;", "headerCount", "isCreated", "", "isOpenMultiBitRateDownload", "listener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1;", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaCache", "", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "notifyListener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1;", "observer", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1;", "playingIndex", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "tabType", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "buildText", "feedId", "simpleFeedId", "mediaId", "isVideo", "percent", "preloadPercent", "preloadMinSize", "fileFormat", "codingFormat", "position", "size", "hasPlayed", "relatedFeedId", "desc", "isLongVideo", "likeCount", "createDataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "findCacheInfo", "originalMediaId", "getDesc", "feed", "getItem", "getMedia", "notifyChange", "", "onCreate", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "onDetachedFromWindow", "Companion", "Info", "TestAdapter", "TestHolder", "plugin-finder_release"})
public final class TestPreloadPreview
  extends FrameLayout
{
  public static final a wqQ;
  private int dLS;
  private boolean dbG;
  private final MMHandler mainHandler;
  private List<? extends o<? extends bo, ? extends cjl>> qzs;
  private k tCD;
  private long tIC;
  private final boolean uUD;
  private final f vau;
  private final ConcurrentHashMap<Integer, Integer> wqH;
  private final f wqI;
  private int wqJ;
  private final ConcurrentHashMap<String, b> wqK;
  private final e wqL;
  private int wqM;
  private final i wqN;
  private final g wqO;
  private final j wqP;
  
  static
  {
    AppMethodBeat.i(255125);
    wqQ = new a((byte)0);
    AppMethodBeat.o(255125);
  }
  
  public TestPreloadPreview(final Context paramContext, final AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(255123);
    this.vau = kotlin.g.ah((kotlin.g.a.a)new l(this));
    this.wqH = new ConcurrentHashMap();
    this.wqI = kotlin.g.ah((kotlin.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.uUD = com.tencent.mm.plugin.finder.storage.c.dsh();
    setId(2131308975);
    LayoutInflater.from(getContext()).inflate(2131496671, (ViewGroup)this, true);
    paramContext = findViewById(2131308974);
    paramAttributeSet = findViewById(2131300230);
    p.g(paramAttributeSet, "expandBtn");
    paramAttributeSet.setTag(Boolean.FALSE);
    getRecyclerView().setLayoutFrozen(true);
    paramContext.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(255089);
        View localView = paramContext;
        p.g(localView, "container");
        localView.setTranslationY(-this.wqR.getRecyclerView().getHeight() - this.wqR.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(255089);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(255093);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = paramAttributeSet;
        p.g(paramAnonymousView, "expandBtn");
        if (p.j(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.wqR.getRecyclerView().getHeight() - this.wqR.getGlobalPreloadTv().getHeight()).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(255090);
              this.wqT.wqR.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(255090);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          paramAnonymousView = paramAttributeSet;
          p.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.FALSE);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255093);
          return;
          paramContext.animate().cancel();
          paramContext.animate().translationY(0.0F).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(255091);
              paramAnonymous2Animator = this.wqT.qCr;
              p.g(paramAnonymous2Animator, "container");
              paramAnonymous2Animator.setTranslationY(0.0F);
              this.wqT.wqR.getRecyclerView().setLayoutFrozen(false);
              AppMethodBeat.o(255091);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          TestPreloadPreview.d(this.wqR).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(255092);
              Object localObject = TestPreloadPreview.a(this.wqT.wqR).iterator();
              int i = 0;
              int j;
              if (((Iterator)localObject).hasNext()) {
                if (((bo)((o)((Iterator)localObject).next()).first).lT() == TestPreloadPreview.c(this.wqT.wqR))
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
                localObject = this.wqT.wqR.getRecyclerView().getLayoutManager();
                if (localObject != null) {
                  break label124;
                }
                localObject = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(255092);
                throw ((Throwable)localObject);
                j = 0;
                break label68;
                label112:
                i += 1;
                break;
                i = -1;
              }
              label124:
              ((LinearLayoutManager)localObject).ah(Math.max(0, i), 0);
              AppMethodBeat.o(255092);
            }
          }, 20L);
          paramAnonymousView = paramAttributeSet;
          p.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.TRUE);
        }
      }
    });
    this.wqK = new ConcurrentHashMap();
    this.wqL = new e(this);
    this.wqM = -1;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.wqN = new i(this);
    this.wqO = new g(this);
    this.wqP = new j(this);
    AppMethodBeat.o(255123);
  }
  
  public TestPreloadPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255124);
    this.vau = kotlin.g.ah((kotlin.g.a.a)new l(this));
    this.wqH = new ConcurrentHashMap();
    this.wqI = kotlin.g.ah((kotlin.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.c.vCb;
    this.uUD = com.tencent.mm.plugin.finder.storage.c.dsh();
    setId(2131308975);
    LayoutInflater.from(getContext()).inflate(2131496671, (ViewGroup)this, true);
    paramContext = findViewById(2131308974);
    paramAttributeSet = findViewById(2131300230);
    p.g(paramAttributeSet, "expandBtn");
    paramAttributeSet.setTag(Boolean.FALSE);
    getRecyclerView().setLayoutFrozen(true);
    paramContext.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(255089);
        View localView = paramContext;
        p.g(localView, "container");
        localView.setTranslationY(-this.wqR.getRecyclerView().getHeight() - this.wqR.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(255089);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(255093);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = paramAttributeSet;
        p.g(paramAnonymousView, "expandBtn");
        if (p.j(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.wqR.getRecyclerView().getHeight() - this.wqR.getGlobalPreloadTv().getHeight()).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(255090);
              this.wqT.wqR.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(255090);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          paramAnonymousView = paramAttributeSet;
          p.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.FALSE);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255093);
          return;
          paramContext.animate().cancel();
          paramContext.animate().translationY(0.0F).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(255091);
              paramAnonymous2Animator = this.wqT.qCr;
              p.g(paramAnonymous2Animator, "container");
              paramAnonymous2Animator.setTranslationY(0.0F);
              this.wqT.wqR.getRecyclerView().setLayoutFrozen(false);
              AppMethodBeat.o(255091);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          TestPreloadPreview.d(this.wqR).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(255092);
              Object localObject = TestPreloadPreview.a(this.wqT.wqR).iterator();
              int i = 0;
              int j;
              if (((Iterator)localObject).hasNext()) {
                if (((bo)((o)((Iterator)localObject).next()).first).lT() == TestPreloadPreview.c(this.wqT.wqR))
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
                localObject = this.wqT.wqR.getRecyclerView().getLayoutManager();
                if (localObject != null) {
                  break label124;
                }
                localObject = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(255092);
                throw ((Throwable)localObject);
                j = 0;
                break label68;
                label112:
                i += 1;
                break;
                i = -1;
              }
              label124:
              ((LinearLayoutManager)localObject).ah(Math.max(0, i), 0);
              AppMethodBeat.o(255092);
            }
          }, 20L);
          paramAnonymousView = paramAttributeSet;
          p.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.TRUE);
        }
      }
    });
    this.wqK = new ConcurrentHashMap();
    this.wqL = new e(this);
    this.wqM = -1;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.wqN = new i(this);
    this.wqO = new g(this);
    this.wqP = new j(this);
    AppMethodBeat.o(255124);
  }
  
  private static List<o<bo, cjl>> a(DataBuffer<bo> paramDataBuffer)
  {
    AppMethodBeat.i(255120);
    LinkedList localLinkedList = new LinkedList();
    paramDataBuffer = ((Iterable)paramDataBuffer).iterator();
    while (paramDataBuffer.hasNext())
    {
      bo localbo = (bo)paramDataBuffer.next();
      Object localObject;
      if ((localbo instanceof BaseFinderFeed))
      {
        localObject = (cjl)j.kt((List)((BaseFinderFeed)localbo).feedObject.getMediaList());
        if (localObject != null) {
          localLinkedList.add(new o(localbo, localObject));
        }
      }
      else if ((localbo instanceof bm))
      {
        localObject = (cjl)j.kt((List)((bm)localbo).dkV());
        if (localObject != null) {
          localLinkedList.add(new o(localbo, localObject));
        }
      }
      else if ((localbo instanceof ag))
      {
        localObject = (BaseFinderFeed)j.kt((List)((ag)localbo).rvFeedList);
        if (localObject != null)
        {
          localObject = ((BaseFinderFeed)localObject).feedObject;
          if (localObject != null)
          {
            localObject = ((FinderItem)localObject).getMediaList();
            if (localObject != null)
            {
              localObject = (cjl)j.kt((List)localObject);
              if (localObject != null) {
                localLinkedList.add(new o(localbo, localObject));
              }
            }
          }
        }
      }
    }
    paramDataBuffer = (List)localLinkedList;
    AppMethodBeat.o(255120);
    return paramDataBuffer;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(DataBuffer<bo> paramDataBuffer, int paramInt1, k paramk, com.tencent.mm.plugin.finder.event.base.c paramc, int paramInt2)
  {
    AppMethodBeat.i(255121);
    p.h(paramDataBuffer, "data");
    p.h(paramk, "videoCore");
    this.dbG = true;
    this.qzs = a(paramDataBuffer);
    this.dLS = paramInt2;
    this.tCD = paramk;
    this.wqJ = paramInt1;
    paramDataBuffer = getRecyclerView();
    getContext();
    paramDataBuffer.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramDataBuffer = new c();
    paramDataBuffer.au(true);
    getRecyclerView().setAdapter((RecyclerView.a)paramDataBuffer);
    getRecyclerView().setHasFixedSize(true);
    if (paramc != null) {
      paramc.a((com.tencent.mm.plugin.finder.event.base.d)this.wqP);
    }
    this.wqO.alive();
    this.wqN.alive();
    paramDataBuffer = paramk.weU;
    if (paramDataBuffer != null) {
      paramDataBuffer.a((com.tencent.mm.plugin.finder.preload.b)this.wqL);
    }
    getRecyclerView().setOnTouchListener((View.OnTouchListener)new k(this));
    AppMethodBeat.o(255121);
  }
  
  public final TextView getGlobalPreloadTv()
  {
    AppMethodBeat.i(255119);
    TextView localTextView = (TextView)this.wqI.getValue();
    AppMethodBeat.o(255119);
    return localTextView;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(255118);
    RecyclerView localRecyclerView = (RecyclerView)this.vau.getValue();
    AppMethodBeat.o(255118);
    return localRecyclerView;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(255122);
    super.onDetachedFromWindow();
    if (this.dbG)
    {
      this.wqO.dead();
      this.wqN.dead();
      Object localObject1 = this.tCD;
      if (localObject1 == null) {
        p.btv("videoCore");
      }
      Object localObject2 = ((k)localObject1).weU;
      if (localObject2 != null)
      {
        localObject1 = (com.tencent.mm.plugin.finder.preload.b)this.wqL;
        p.h(localObject1, "callback");
        localObject2 = ((MediaPreloadCore)localObject2).uTQ;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject2).uVL;
          if (localObject2 != null) {
            j.a((Iterable)localObject2, (kotlin.g.a.b)new MediaPreloadCore.e((com.tencent.mm.plugin.finder.preload.b)localObject1));
          }
        }
      }
      this.dbG = false;
    }
    AppMethodBeat.o(255122);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "", "()V", "codingFormat", "", "getCodingFormat", "()Ljava/lang/String;", "setCodingFormat", "(Ljava/lang/String;)V", "fileFormat", "getFileFormat", "setFileFormat", "hasPlayed", "getHasPlayed", "setHasPlayed", "percent", "", "getPercent", "()I", "setPercent", "(I)V", "preloadMinSize", "", "getPreloadMinSize", "()J", "setPreloadMinSize", "(J)V", "preloadPercent", "getPreloadPercent", "setPreloadPercent", "size", "getSize", "setSize", "state", "getState", "setState", "plugin-finder_release"})
  public static final class b
  {
    String dVY;
    int gqZ;
    int percent;
    long preloadMinSize;
    int size;
    int state;
    String uUI;
    String wqU;
    
    public final int dHn()
    {
      if (this.gqZ == 0) {
        return this.percent;
      }
      return this.gqZ;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<TestPreloadPreview.d>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(255095);
      int i = TestPreloadPreview.a(this.wqR).size();
      AppMethodBeat.o(255095);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(255096);
      Object localObject = TestPreloadPreview.a(this.wqR, paramInt);
      if (localObject != null)
      {
        localObject = (bo)((o)localObject).first;
        if (localObject != null)
        {
          long l = ((bo)localObject).lT();
          AppMethodBeat.o(255096);
          return l;
        }
      }
      AppMethodBeat.o(255096);
      return 0L;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getOriginalMediaId", "", "mediaId", "onCancel", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.plugin.finder.preload.b
  {
    private static String awS(String paramString)
    {
      AppMethodBeat.i(255099);
      String str = n.j(paramString, "finder_video_", "", false);
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
        AppMethodBeat.o(255099);
        return paramString;
        j = 0;
        break label53;
        label90:
        i += 1;
        break;
        i = -1;
      }
      label102:
      AppMethodBeat.o(255099);
      return paramString;
    }
    
    public final void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(255100);
      p.h(paramString1, "mediaId");
      p.h(paramString2, "fileFormat");
      p.h(paramString3, "codingFormat");
      p.h(paramc, "task");
      paramString1 = TestPreloadPreview.a(this.wqR, awS(paramString1));
      paramString1.gqZ = paramInt;
      paramString1.state = 2;
      paramString1.uUI = paramString3;
      paramString1.dVY = paramString2;
      paramString1.preloadMinSize = paramc.preloadMinSize;
      TestPreloadPreview.g(this.wqR);
      AppMethodBeat.o(255100);
    }
    
    public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(255103);
      p.h(paramString1, "mediaId");
      p.h(paramString2, "msg");
      p.h(paramc, "task");
      AppMethodBeat.o(255103);
    }
    
    public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(255102);
      p.h(paramString, "mediaId");
      p.h(paramc, "task");
      paramString = TestPreloadPreview.a(this.wqR, awS(paramString));
      paramString.preloadMinSize = paramc.preloadMinSize;
      paramString.gqZ = paramInt;
      paramString.state = 3;
      TestPreloadPreview.g(this.wqR);
      AppMethodBeat.o(255102);
    }
    
    public final void aum(String paramString)
    {
      AppMethodBeat.i(255104);
      p.h(paramString, "mediaId");
      AppMethodBeat.o(255104);
    }
    
    public final void dx(String paramString, int paramInt)
    {
      AppMethodBeat.i(255101);
      p.h(paramString, "mediaId");
      paramString = TestPreloadPreview.a(this.wqR, awS(paramString));
      paramString.gqZ = paramInt;
      paramString.state = 2;
      TestPreloadPreview.g(this.wqR);
      AppMethodBeat.o(255101);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<TextView>
  {
    f(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/PreloadProcessChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class g
    extends IListener<pw>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final void run()
    {
      AppMethodBeat.i(255108);
      int i = CdnLogic.getRecentAverageSpeed(2);
      com.tencent.mm.plugin.finder.preload.model.a locala = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel();
      Object localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class);
      p.g(localObject, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
      localObject = (FinderVideoRecycler)localObject;
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(i + "kb/s | " + locala.uUu + ':' + locala.uUt + ':' + locala.uUm + ':' + locala.uUn + ':' + locala.uUq + " | video=" + FinderVideoRecycler.a((FinderVideoRecycler)localObject) + " | buf=" + (Integer)TestPreloadPreview.e(this.wqR).get(Integer.valueOf(TestPreloadPreview.f(this.wqR)))) {});
      AppMethodBeat.o(255108);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/TestPreloadPreviewNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends IListener<xu>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class j
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(255113);
      p.h(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this));
        AppMethodBeat.o(255113);
        return;
      }
      if ((paramb instanceof h))
      {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this, paramb));
        AppMethodBeat.o(255113);
        return;
      }
      if ((paramb instanceof c.a)) {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, paramb));
      }
      AppMethodBeat.o(255113);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(255114);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      if ((paramb instanceof h))
      {
        if (((h)paramb).type == 0)
        {
          AppMethodBeat.o(255114);
          return true;
        }
        AppMethodBeat.o(255114);
        return false;
      }
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        AppMethodBeat.o(255114);
        return true;
      }
      if ((paramb instanceof c.a))
      {
        if (((c.a)paramb).type == 1)
        {
          AppMethodBeat.o(255114);
          return true;
        }
        AppMethodBeat.o(255114);
        return false;
      }
      AppMethodBeat.o(255114);
      return false;
    }
    
    public final boolean cZD()
    {
      return true;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(TestPreloadPreview.j paramj)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(TestPreloadPreview.j paramj, com.tencent.mm.plugin.finder.event.base.b paramb)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class k
    implements View.OnTouchListener
  {
    k(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(255116);
      p.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0) {
        TestPreloadPreview.d(this.wqR).removeCallbacksAndMessages(null);
      }
      for (;;)
      {
        AppMethodBeat.o(255116);
        return false;
        if (paramMotionEvent.getAction() == 1)
        {
          TestPreloadPreview.d(this.wqR).removeCallbacksAndMessages(null);
          TestPreloadPreview.d(this.wqR).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(255115);
              Object localObject = TestPreloadPreview.a(this.wqY.wqR).iterator();
              int i = 0;
              int j;
              if (((Iterator)localObject).hasNext()) {
                if (((bo)((o)((Iterator)localObject).next()).first).lT() == TestPreloadPreview.c(this.wqY.wqR))
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
                localObject = this.wqY.wqR.getRecyclerView().getLayoutManager();
                if (localObject != null) {
                  break label124;
                }
                localObject = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(255115);
                throw ((Throwable)localObject);
                j = 0;
                break label68;
                label112:
                i += 1;
                break;
                i = -1;
              }
              label124:
              ((LinearLayoutManager)localObject).ah(Math.max(0, i), 0);
              AppMethodBeat.o(255115);
            }
          }, 3000L);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.TestPreloadPreview
 * JD-Core Version:    0.7.0.1
 */