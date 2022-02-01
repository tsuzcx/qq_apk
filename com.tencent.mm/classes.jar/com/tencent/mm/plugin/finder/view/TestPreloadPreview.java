package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.arch.lifecycle.ViewModelProvider;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import d.a.j;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.v;
import d.z;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bufferSet", "Ljava/util/concurrent/ConcurrentHashMap;", "callback", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1;", "centerFeedId", "", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "globalPreloadTv", "Landroid/widget/TextView;", "getGlobalPreloadTv", "()Landroid/widget/TextView;", "globalPreloadTv$delegate", "Lkotlin/Lazy;", "headerCount", "isCreated", "", "isOpenMultiBitRateDownload", "listener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1;", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaCache", "", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "notifyListener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1;", "observer", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1;", "playingIndex", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "tabType", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "buildText", "feedId", "simpleFeedId", "mediaId", "isVideo", "percent", "preloadPercent", "preloadMinSize", "fileFormat", "codingFormat", "position", "size", "hasPlayed", "relatedFeedId", "desc", "findCacheInfo", "originalMediaId", "notifyChange", "", "onCreate", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "onDetachedFromWindow", "Companion", "Info", "TestAdapter", "TestHolder", "plugin-finder_release"})
public final class TestPreloadPreview
  extends FrameLayout
{
  public static final a sXb;
  private boolean cKz;
  private int duh;
  private final ap hUx;
  private i rOe;
  private long rRj;
  private final f sWQ;
  private final ConcurrentHashMap<Integer, Integer> sWR;
  private final f sWS;
  private DataBuffer<al> sWT;
  private int sWU;
  private final ConcurrentHashMap<String, b> sWV;
  private final e sWW;
  private int sWX;
  private final i sWY;
  private final g sWZ;
  private final j sXa;
  private final boolean slr;
  
  static
  {
    AppMethodBeat.i(205301);
    sXb = new a((byte)0);
    AppMethodBeat.o(205301);
  }
  
  public TestPreloadPreview(final Context paramContext, final AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205299);
    this.sWQ = d.g.O((d.g.a.a)new l(this));
    this.sWR = new ConcurrentHashMap();
    this.sWS = d.g.O((d.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.slr = com.tencent.mm.plugin.finder.storage.b.cGE();
    setId(2131305708);
    LayoutInflater.from(getContext()).inflate(2131496366, (ViewGroup)this, true);
    paramContext = findViewById(2131308028);
    paramAttributeSet = findViewById(2131307330);
    p.g(paramAttributeSet, "expandBtn");
    paramAttributeSet.setTag(Boolean.FALSE);
    getRecyclerView().setLayoutFrozen(true);
    paramContext.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205263);
        View localView = paramContext;
        p.g(localView, "container");
        localView.setTranslationY(-this.sXc.getRecyclerView().getHeight() - this.sXc.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(205263);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205267);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = paramAttributeSet;
        p.g(paramAnonymousView, "expandBtn");
        if (p.i(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.sXc.getRecyclerView().getHeight() - this.sXc.getGlobalPreloadTv().getHeight()).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(221573);
              this.sXf.sXc.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(221573);
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
          AppMethodBeat.o(205267);
          return;
          paramContext.animate().cancel();
          paramContext.animate().translationY(0.0F).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(221574);
              paramAnonymous2Animator = this.sXf.sXd;
              p.g(paramAnonymous2Animator, "container");
              paramAnonymous2Animator.setTranslationY(0.0F);
              this.sXf.sXc.getRecyclerView().setLayoutFrozen(false);
              AppMethodBeat.o(221574);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          TestPreloadPreview.d(this.sXc).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(205266);
              Object localObject = this.sXf.sXc.getRecyclerView().getLayoutManager();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(205266);
                throw ((Throwable)localObject);
              }
              ((LinearLayoutManager)localObject).ag(Math.max(0, TestPreloadPreview.e(this.sXf.sXc) - 1), 0);
              AppMethodBeat.o(205266);
            }
          }, 20L);
          paramAnonymousView = paramAttributeSet;
          p.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.TRUE);
        }
      }
    });
    this.sWV = new ConcurrentHashMap();
    this.sWW = new e(this);
    this.sWX = -1;
    this.hUx = new ap(Looper.getMainLooper());
    this.sWY = new i(this);
    this.sWZ = new g(this);
    this.sXa = new j(this);
    AppMethodBeat.o(205299);
  }
  
  public TestPreloadPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205300);
    this.sWQ = d.g.O((d.g.a.a)new l(this));
    this.sWR = new ConcurrentHashMap();
    this.sWS = d.g.O((d.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.slr = com.tencent.mm.plugin.finder.storage.b.cGE();
    setId(2131305708);
    LayoutInflater.from(getContext()).inflate(2131496366, (ViewGroup)this, true);
    paramContext = findViewById(2131308028);
    paramAttributeSet = findViewById(2131307330);
    p.g(paramAttributeSet, "expandBtn");
    paramAttributeSet.setTag(Boolean.FALSE);
    getRecyclerView().setLayoutFrozen(true);
    paramContext.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205263);
        View localView = paramContext;
        p.g(localView, "container");
        localView.setTranslationY(-this.sXc.getRecyclerView().getHeight() - this.sXc.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(205263);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205267);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = paramAttributeSet;
        p.g(paramAnonymousView, "expandBtn");
        if (p.i(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.sXc.getRecyclerView().getHeight() - this.sXc.getGlobalPreloadTv().getHeight()).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(221573);
              this.sXf.sXc.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(221573);
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
          AppMethodBeat.o(205267);
          return;
          paramContext.animate().cancel();
          paramContext.animate().translationY(0.0F).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(221574);
              paramAnonymous2Animator = this.sXf.sXd;
              p.g(paramAnonymous2Animator, "container");
              paramAnonymous2Animator.setTranslationY(0.0F);
              this.sXf.sXc.getRecyclerView().setLayoutFrozen(false);
              AppMethodBeat.o(221574);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          TestPreloadPreview.d(this.sXc).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(205266);
              Object localObject = this.sXf.sXc.getRecyclerView().getLayoutManager();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(205266);
                throw ((Throwable)localObject);
              }
              ((LinearLayoutManager)localObject).ag(Math.max(0, TestPreloadPreview.e(this.sXf.sXc) - 1), 0);
              AppMethodBeat.o(205266);
            }
          }, 20L);
          paramAnonymousView = paramAttributeSet;
          p.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.TRUE);
        }
      }
    });
    this.sWV = new ConcurrentHashMap();
    this.sWW = new e(this);
    this.sWX = -1;
    this.hUx = new ap(Looper.getMainLooper());
    this.sWY = new i(this);
    this.sWZ = new g(this);
    this.sXa = new j(this);
    AppMethodBeat.o(205300);
  }
  
  public final void a(DataBuffer<al> paramDataBuffer, int paramInt1, i parami, com.tencent.mm.plugin.finder.event.base.c paramc, int paramInt2)
  {
    AppMethodBeat.i(205297);
    p.h(paramDataBuffer, "data");
    p.h(parami, "videoCore");
    this.cKz = true;
    this.sWT = paramDataBuffer;
    this.duh = paramInt2;
    this.rOe = parami;
    this.sWU = paramInt1;
    paramDataBuffer = getRecyclerView();
    getContext();
    paramDataBuffer.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramDataBuffer = new c();
    paramDataBuffer.av(true);
    getRecyclerView().setAdapter((RecyclerView.a)paramDataBuffer);
    getRecyclerView().setHasFixedSize(true);
    if (paramc != null) {
      paramc.a((d)this.sXa);
    }
    this.sWZ.alive();
    this.sWY.alive();
    paramDataBuffer = parami.sPb;
    if (paramDataBuffer != null) {
      paramDataBuffer.a((com.tencent.mm.plugin.finder.preload.b)this.sWW);
    }
    getRecyclerView().setOnTouchListener((View.OnTouchListener)new k(this));
    AppMethodBeat.o(205297);
  }
  
  public final TextView getGlobalPreloadTv()
  {
    AppMethodBeat.i(205296);
    TextView localTextView = (TextView)this.sWS.getValue();
    AppMethodBeat.o(205296);
    return localTextView;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(205295);
    RecyclerView localRecyclerView = (RecyclerView)this.sWQ.getValue();
    AppMethodBeat.o(205295);
    return localRecyclerView;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(205298);
    super.onDetachedFromWindow();
    if (this.cKz)
    {
      this.sWZ.dead();
      this.sWY.dead();
      Object localObject1 = this.rOe;
      if (localObject1 == null) {
        p.bcb("videoCore");
      }
      Object localObject2 = ((i)localObject1).sPb;
      if (localObject2 != null)
      {
        localObject1 = (com.tencent.mm.plugin.finder.preload.b)this.sWW;
        p.h(localObject1, "callback");
        localObject2 = ((MediaPreloadCore)localObject2).skJ;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject2).slF;
          if (localObject2 != null) {
            j.a((Iterable)localObject2, (d.g.a.b)new MediaPreloadCore.e((com.tencent.mm.plugin.finder.preload.b)localObject1));
          }
        }
      }
      this.cKz = false;
    }
    AppMethodBeat.o(205298);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "", "()V", "codingFormat", "", "getCodingFormat", "()Ljava/lang/String;", "setCodingFormat", "(Ljava/lang/String;)V", "fileFormat", "getFileFormat", "setFileFormat", "hasPlayed", "getHasPlayed", "setHasPlayed", "percent", "", "getPercent", "()I", "setPercent", "(I)V", "preloadMinSize", "", "getPreloadMinSize", "()J", "setPreloadMinSize", "(J)V", "preloadPercent", "getPreloadPercent", "setPreloadPercent", "size", "getSize", "setSize", "state", "getState", "setState", "plugin-finder_release"})
  public static final class b
  {
    String dDf;
    int fJK;
    int percent;
    long preloadMinSize;
    String sXg;
    int size;
    String slv;
    int state;
    
    public final int cNE()
    {
      if (this.fJK == 0) {
        return this.percent;
      }
      return this.fJK;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "getItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "position", "", "getItemCount", "getItemId", "", "getMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "onBindViewHolder", "", "holder", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<TestPreloadPreview.d>
  {
    private final FinderItem Gf(int paramInt)
    {
      AppMethodBeat.i(205273);
      Object localObject = (al)TestPreloadPreview.b(this.sXc).get(paramInt);
      if ((localObject instanceof BaseFinderFeed))
      {
        localObject = ((BaseFinderFeed)localObject).feedObject;
        AppMethodBeat.o(205273);
        return localObject;
      }
      AppMethodBeat.o(205273);
      return null;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(205270);
      int i = TestPreloadPreview.b(this.sXc).getTotalSize();
      AppMethodBeat.o(205270);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(205271);
      FinderItem localFinderItem = Gf(paramInt);
      if (localFinderItem == null)
      {
        l = ((al)TestPreloadPreview.b(this.sXc).get(paramInt)).lP();
        AppMethodBeat.o(205271);
        return l;
      }
      long l = localFinderItem.getExpectId();
      AppMethodBeat.o(205271);
      return l;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class a
      implements View.OnLongClickListener
    {
      a(TestPreloadPreview.c paramc, int paramInt, TestPreloadPreview.d paramd) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(205268);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramView = TestPreloadPreview.c.a(this.sXh, this.ghM);
        if (paramView != null)
        {
          paramView = paramView.getMediaList();
          if (paramView != null)
          {
            paramView = (bvf)j.jd((List)paramView);
            if ((paramView != null) && ((TestPreloadPreview.b)TestPreloadPreview.a(this.sXh.sXc).get(paramView.mediaId) != null))
            {
              paramView = aj.getContext().getSystemService("clipboard");
              if (paramView == null)
              {
                paramView = new v("null cannot be cast to non-null type android.content.ClipboardManager");
                AppMethodBeat.o(205268);
                throw paramView;
              }
              paramView = (ClipboardManager)paramView;
              localObject = this.sXi.sXj;
              p.g(localObject, "holder.mediaIdTv");
              localObject = ((TextView)localObject).getText().toString();
              paramView.setText((CharSequence)localObject);
              paramView = this.sXi.auu;
              p.g(paramView, "holder.itemView");
              Toast.makeText(paramView.getContext(), (CharSequence)localObject, 1).show();
              ad.i("TestPreloadView", (String)localObject);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(205268);
        return true;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getOriginalMediaId", "", "mediaId", "onCancel", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.plugin.finder.preload.b
  {
    private static String ajk(String paramString)
    {
      AppMethodBeat.i(205276);
      String str = n.h(paramString, "finder_video_", "", false);
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
        AppMethodBeat.o(205276);
        return paramString;
        j = 0;
        break label53;
        label90:
        i += 1;
        break;
        i = -1;
      }
      label102:
      AppMethodBeat.o(205276);
      return paramString;
    }
    
    public final void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(205277);
      p.h(paramString1, "mediaId");
      p.h(paramString2, "fileFormat");
      p.h(paramString3, "codingFormat");
      p.h(paramc, "task");
      paramString1 = TestPreloadPreview.a(this.sXc, ajk(paramString1));
      paramString1.fJK = paramInt;
      paramString1.state = 2;
      paramString1.slv = paramString3;
      paramString1.dDf = paramString2;
      paramString1.preloadMinSize = paramc.preloadMinSize;
      TestPreloadPreview.h(this.sXc);
      AppMethodBeat.o(205277);
    }
    
    public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(205280);
      p.h(paramString1, "mediaId");
      p.h(paramString2, "msg");
      p.h(paramc, "task");
      AppMethodBeat.o(205280);
    }
    
    public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(205279);
      p.h(paramString, "mediaId");
      p.h(paramc, "task");
      paramString = TestPreloadPreview.a(this.sXc, ajk(paramString));
      paramString.preloadMinSize = paramc.preloadMinSize;
      paramString.fJK = paramInt;
      paramString.state = 3;
      TestPreloadPreview.h(this.sXc);
      AppMethodBeat.o(205279);
    }
    
    public final void ahz(String paramString)
    {
      AppMethodBeat.i(205281);
      p.h(paramString, "mediaId");
      AppMethodBeat.o(205281);
    }
    
    public final void dk(String paramString, int paramInt)
    {
      AppMethodBeat.i(205278);
      p.h(paramString, "mediaId");
      paramString = TestPreloadPreview.a(this.sXc, ajk(paramString));
      paramString.fJK = paramInt;
      paramString.state = 2;
      TestPreloadPreview.h(this.sXc);
      AppMethodBeat.o(205278);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<TextView>
  {
    f(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/PreloadProcessChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class g
    extends com.tencent.mm.sdk.b.c<pd>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final void run()
    {
      AppMethodBeat.i(205285);
      int i = CdnLogic.getRecentAverageSpeed(2);
      com.tencent.mm.plugin.finder.preload.model.a locala = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel();
      Object localObject = com.tencent.mm.ui.component.a.KiD;
      localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class);
      p.g(localObject, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
      localObject = (FinderVideoRecycler)localObject;
      com.tencent.mm.ad.c.g((d.g.a.a)new q(i + "kb/s | " + locala.sln + ':' + locala.slm + ':' + locala.slf + ':' + locala.slg + ':' + locala.slj + " | video=" + FinderVideoRecycler.a((FinderVideoRecycler)localObject) + " | buf=" + (Integer)TestPreloadPreview.f(this.sXc).get(Integer.valueOf(TestPreloadPreview.g(this.sXc)))) {});
      AppMethodBeat.o(205285);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/TestPreloadPreviewNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<wp>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class j
    extends d
  {
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(205290);
      p.h(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        com.tencent.mm.ad.c.g((d.g.a.a)new a(this));
        AppMethodBeat.o(205290);
        return;
      }
      if ((paramb instanceof h))
      {
        com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramb));
        AppMethodBeat.o(205290);
        return;
      }
      if ((paramb instanceof b.a)) {
        com.tencent.mm.ad.c.g((d.g.a.a)new c(this, paramb));
      }
      AppMethodBeat.o(205290);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(205291);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      if ((paramb instanceof h))
      {
        if (((h)paramb).type == 0)
        {
          AppMethodBeat.o(205291);
          return true;
        }
        AppMethodBeat.o(205291);
        return false;
      }
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        AppMethodBeat.o(205291);
        return true;
      }
      if ((paramb instanceof b.a))
      {
        if (((b.a)paramb).type == 1)
        {
          AppMethodBeat.o(205291);
          return true;
        }
        AppMethodBeat.o(205291);
        return false;
      }
      AppMethodBeat.o(205291);
      return false;
    }
    
    public final boolean cyW()
    {
      return true;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(TestPreloadPreview.j paramj)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(TestPreloadPreview.j paramj, com.tencent.mm.plugin.finder.event.base.b paramb)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(TestPreloadPreview.j paramj, com.tencent.mm.plugin.finder.event.base.b paramb)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class k
    implements View.OnTouchListener
  {
    k(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205293);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$onCreate$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      p.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0) {
        TestPreloadPreview.d(this.sXc).removeCallbacksAndMessages(null);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$onCreate$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205293);
        return false;
        if (paramMotionEvent.getAction() == 1)
        {
          TestPreloadPreview.d(this.sXc).removeCallbacksAndMessages(null);
          TestPreloadPreview.d(this.sXc).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(205292);
              Object localObject = this.sXm.sXc.getRecyclerView().getLayoutManager();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(205292);
                throw ((Throwable)localObject);
              }
              ((LinearLayoutManager)localObject).ag(Math.max(0, TestPreloadPreview.e(this.sXm.sXc) - 1), 0);
              AppMethodBeat.o(205292);
            }
          }, 3000L);
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<RecyclerView>
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