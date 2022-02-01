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
import com.tencent.mm.g.a.pe;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import d.a.j;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.v;
import d.z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bufferSet", "Ljava/util/concurrent/ConcurrentHashMap;", "callback", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1;", "centerFeedId", "", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "globalPreloadTv", "Landroid/widget/TextView;", "getGlobalPreloadTv", "()Landroid/widget/TextView;", "globalPreloadTv$delegate", "Lkotlin/Lazy;", "headerCount", "isCreated", "", "isOpenMultiBitRateDownload", "listener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1;", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaCache", "", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "notifyListener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1;", "observer", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1;", "playingIndex", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "tabType", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "buildText", "feedId", "simpleFeedId", "mediaId", "isVideo", "percent", "preloadPercent", "preloadMinSize", "fileFormat", "codingFormat", "position", "size", "hasPlayed", "relatedFeedId", "desc", "findCacheInfo", "originalMediaId", "notifyChange", "", "onCreate", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "onDetachedFromWindow", "Companion", "Info", "TestAdapter", "TestHolder", "plugin-finder_release"})
public final class TestPreloadPreview
  extends FrameLayout
{
  public static final TestPreloadPreview.a tip;
  private boolean cLi;
  private int dvm;
  private final aq hXp;
  private i rWB;
  private long rZL;
  private final boolean suq;
  private final f tie;
  private final ConcurrentHashMap<Integer, Integer> tif;
  private final f tig;
  private DataBuffer<am> tih;
  private int tii;
  private final ConcurrentHashMap<String, b> tij;
  private final e tik;
  private int til;
  private final TestPreloadPreview.i tim;
  private final g tin;
  private final j tio;
  
  static
  {
    AppMethodBeat.i(205943);
    tip = new TestPreloadPreview.a((byte)0);
    AppMethodBeat.o(205943);
  }
  
  public TestPreloadPreview(final Context paramContext, final AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205941);
    this.tie = d.g.O((d.g.a.a)new l(this));
    this.tif = new ConcurrentHashMap();
    this.tig = d.g.O((d.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.suq = com.tencent.mm.plugin.finder.storage.b.cIB();
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
        AppMethodBeat.i(205905);
        View localView = paramContext;
        p.g(localView, "container");
        localView.setTranslationY(-this.tiq.getRecyclerView().getHeight() - this.tiq.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(205905);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205909);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = paramAttributeSet;
        p.g(paramAnonymousView, "expandBtn");
        if (p.i(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.tiq.getRecyclerView().getHeight() - this.tiq.getGlobalPreloadTv().getHeight()).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(205906);
              this.tit.tiq.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(205906);
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
          AppMethodBeat.o(205909);
          return;
          paramContext.animate().cancel();
          paramContext.animate().translationY(0.0F).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(205907);
              paramAnonymous2Animator = this.tit.tir;
              p.g(paramAnonymous2Animator, "container");
              paramAnonymous2Animator.setTranslationY(0.0F);
              this.tit.tiq.getRecyclerView().setLayoutFrozen(false);
              AppMethodBeat.o(205907);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          TestPreloadPreview.d(this.tiq).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(205908);
              Object localObject = this.tit.tiq.getRecyclerView().getLayoutManager();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(205908);
                throw ((Throwable)localObject);
              }
              ((LinearLayoutManager)localObject).ag(Math.max(0, TestPreloadPreview.e(this.tit.tiq) - 1), 0);
              AppMethodBeat.o(205908);
            }
          }, 20L);
          paramAnonymousView = paramAttributeSet;
          p.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.TRUE);
        }
      }
    });
    this.tij = new ConcurrentHashMap();
    this.tik = new e(this);
    this.til = -1;
    this.hXp = new aq(Looper.getMainLooper());
    this.tim = new TestPreloadPreview.i(this);
    this.tin = new g(this);
    this.tio = new j(this);
    AppMethodBeat.o(205941);
  }
  
  public TestPreloadPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205942);
    this.tie = d.g.O((d.g.a.a)new l(this));
    this.tif = new ConcurrentHashMap();
    this.tig = d.g.O((d.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.suq = com.tencent.mm.plugin.finder.storage.b.cIB();
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
        AppMethodBeat.i(205905);
        View localView = paramContext;
        p.g(localView, "container");
        localView.setTranslationY(-this.tiq.getRecyclerView().getHeight() - this.tiq.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(205905);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205909);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = paramAttributeSet;
        p.g(paramAnonymousView, "expandBtn");
        if (p.i(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.tiq.getRecyclerView().getHeight() - this.tiq.getGlobalPreloadTv().getHeight()).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(205906);
              this.tit.tiq.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(205906);
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
          AppMethodBeat.o(205909);
          return;
          paramContext.animate().cancel();
          paramContext.animate().translationY(0.0F).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(205907);
              paramAnonymous2Animator = this.tit.tir;
              p.g(paramAnonymous2Animator, "container");
              paramAnonymous2Animator.setTranslationY(0.0F);
              this.tit.tiq.getRecyclerView().setLayoutFrozen(false);
              AppMethodBeat.o(205907);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator) {}
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          TestPreloadPreview.d(this.tiq).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(205908);
              Object localObject = this.tit.tiq.getRecyclerView().getLayoutManager();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(205908);
                throw ((Throwable)localObject);
              }
              ((LinearLayoutManager)localObject).ag(Math.max(0, TestPreloadPreview.e(this.tit.tiq) - 1), 0);
              AppMethodBeat.o(205908);
            }
          }, 20L);
          paramAnonymousView = paramAttributeSet;
          p.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.TRUE);
        }
      }
    });
    this.tij = new ConcurrentHashMap();
    this.tik = new e(this);
    this.til = -1;
    this.hXp = new aq(Looper.getMainLooper());
    this.tim = new TestPreloadPreview.i(this);
    this.tin = new g(this);
    this.tio = new j(this);
    AppMethodBeat.o(205942);
  }
  
  public final void a(DataBuffer<am> paramDataBuffer, int paramInt1, i parami, com.tencent.mm.plugin.finder.event.base.c paramc, int paramInt2)
  {
    AppMethodBeat.i(205939);
    p.h(paramDataBuffer, "data");
    p.h(parami, "videoCore");
    this.cLi = true;
    this.tih = paramDataBuffer;
    this.dvm = paramInt2;
    this.rWB = parami;
    this.tii = paramInt1;
    paramDataBuffer = getRecyclerView();
    getContext();
    paramDataBuffer.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramDataBuffer = new c();
    paramDataBuffer.av(true);
    getRecyclerView().setAdapter((RecyclerView.a)paramDataBuffer);
    getRecyclerView().setHasFixedSize(true);
    if (paramc != null) {
      paramc.a((d)this.tio);
    }
    this.tin.alive();
    this.tim.alive();
    paramDataBuffer = parami.tao;
    if (paramDataBuffer != null) {
      paramDataBuffer.a((com.tencent.mm.plugin.finder.preload.b)this.tik);
    }
    getRecyclerView().setOnTouchListener((View.OnTouchListener)new k(this));
    AppMethodBeat.o(205939);
  }
  
  public final TextView getGlobalPreloadTv()
  {
    AppMethodBeat.i(205938);
    TextView localTextView = (TextView)this.tig.getValue();
    AppMethodBeat.o(205938);
    return localTextView;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(205937);
    RecyclerView localRecyclerView = (RecyclerView)this.tie.getValue();
    AppMethodBeat.o(205937);
    return localRecyclerView;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(205940);
    super.onDetachedFromWindow();
    if (this.cLi)
    {
      this.tin.dead();
      this.tim.dead();
      Object localObject1 = this.rWB;
      if (localObject1 == null) {
        p.bdF("videoCore");
      }
      Object localObject2 = ((i)localObject1).tao;
      if (localObject2 != null)
      {
        localObject1 = (com.tencent.mm.plugin.finder.preload.b)this.tik;
        p.h(localObject1, "callback");
        localObject2 = ((MediaPreloadCore)localObject2).stG;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject2).svw;
          if (localObject2 != null) {
            j.a((Iterable)localObject2, (d.g.a.b)new MediaPreloadCore.e((com.tencent.mm.plugin.finder.preload.b)localObject1));
          }
        }
      }
      this.cLi = false;
    }
    AppMethodBeat.o(205940);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "", "()V", "codingFormat", "", "getCodingFormat", "()Ljava/lang/String;", "setCodingFormat", "(Ljava/lang/String;)V", "fileFormat", "getFileFormat", "setFileFormat", "hasPlayed", "getHasPlayed", "setHasPlayed", "percent", "", "getPercent", "()I", "setPercent", "(I)V", "preloadMinSize", "", "getPreloadMinSize", "()J", "setPreloadMinSize", "(J)V", "preloadPercent", "getPreloadPercent", "setPreloadPercent", "size", "getSize", "setSize", "state", "getState", "setState", "plugin-finder_release"})
  public static final class b
  {
    String dEk;
    int fLN;
    int percent;
    long preloadMinSize;
    int size;
    int state;
    String suu;
    String tiu;
    
    public final int cQo()
    {
      if (this.fLN == 0) {
        return this.percent;
      }
      return this.fLN;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "getItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "position", "", "getItemCount", "getItemId", "", "getMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "onBindViewHolder", "", "holder", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<TestPreloadPreview.d>
  {
    private final FinderItem GF(int paramInt)
    {
      AppMethodBeat.i(205915);
      Object localObject = (am)TestPreloadPreview.b(this.tiq).get(paramInt);
      if ((localObject instanceof BaseFinderFeed))
      {
        localObject = ((BaseFinderFeed)localObject).feedObject;
        AppMethodBeat.o(205915);
        return localObject;
      }
      AppMethodBeat.o(205915);
      return null;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(205912);
      int i = TestPreloadPreview.b(this.tiq).getTotalSize();
      AppMethodBeat.o(205912);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(205913);
      FinderItem localFinderItem = GF(paramInt);
      if (localFinderItem == null)
      {
        l = ((am)TestPreloadPreview.b(this.tiq).get(paramInt)).lP();
        AppMethodBeat.o(205913);
        return l;
      }
      long l = localFinderItem.getExpectId();
      AppMethodBeat.o(205913);
      return l;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class a
      implements View.OnLongClickListener
    {
      a(TestPreloadPreview.c paramc, int paramInt, TestPreloadPreview.d paramd) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(205910);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramView = TestPreloadPreview.c.a(this.tiv, this.gke);
        if (paramView != null)
        {
          paramView = paramView.getMediaList();
          if (paramView != null)
          {
            paramView = (bvz)j.jm((List)paramView);
            if ((paramView != null) && ((TestPreloadPreview.b)((Map)TestPreloadPreview.a(this.tiv.tiq)).get(paramView.mediaId) != null))
            {
              paramView = ak.getContext().getSystemService("clipboard");
              if (paramView == null)
              {
                paramView = new v("null cannot be cast to non-null type android.content.ClipboardManager");
                AppMethodBeat.o(205910);
                throw paramView;
              }
              paramView = (ClipboardManager)paramView;
              localObject = this.tiw.tix;
              p.g(localObject, "holder.mediaIdTv");
              localObject = ((TextView)localObject).getText().toString();
              paramView.setText((CharSequence)localObject);
              paramView = this.tiw.auu;
              p.g(paramView, "holder.itemView");
              Toast.makeText(paramView.getContext(), (CharSequence)localObject, 1).show();
              ae.i("TestPreloadView", (String)localObject);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(205910);
        return true;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getOriginalMediaId", "", "mediaId", "onCancel", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.plugin.finder.preload.b
  {
    private static String akh(String paramString)
    {
      AppMethodBeat.i(205918);
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
        AppMethodBeat.o(205918);
        return paramString;
        j = 0;
        break label53;
        label90:
        i += 1;
        break;
        i = -1;
      }
      label102:
      AppMethodBeat.o(205918);
      return paramString;
    }
    
    public final void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(205919);
      p.h(paramString1, "mediaId");
      p.h(paramString2, "fileFormat");
      p.h(paramString3, "codingFormat");
      p.h(paramc, "task");
      paramString1 = TestPreloadPreview.a(this.tiq, akh(paramString1));
      paramString1.fLN = paramInt;
      paramString1.state = 2;
      paramString1.suu = paramString3;
      paramString1.dEk = paramString2;
      paramString1.preloadMinSize = paramc.preloadMinSize;
      TestPreloadPreview.h(this.tiq);
      AppMethodBeat.o(205919);
    }
    
    public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(205922);
      p.h(paramString1, "mediaId");
      p.h(paramString2, "msg");
      p.h(paramc, "task");
      AppMethodBeat.o(205922);
    }
    
    public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(205921);
      p.h(paramString, "mediaId");
      p.h(paramc, "task");
      paramString = TestPreloadPreview.a(this.tiq, akh(paramString));
      paramString.preloadMinSize = paramc.preloadMinSize;
      paramString.fLN = paramInt;
      paramString.state = 3;
      TestPreloadPreview.h(this.tiq);
      AppMethodBeat.o(205921);
    }
    
    public final void aiw(String paramString)
    {
      AppMethodBeat.i(205923);
      p.h(paramString, "mediaId");
      AppMethodBeat.o(205923);
    }
    
    public final void dp(String paramString, int paramInt)
    {
      AppMethodBeat.i(205920);
      p.h(paramString, "mediaId");
      paramString = TestPreloadPreview.a(this.tiq, akh(paramString));
      paramString.fLN = paramInt;
      paramString.state = 2;
      TestPreloadPreview.h(this.tiq);
      AppMethodBeat.o(205920);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<TextView>
  {
    f(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/PreloadProcessChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class g
    extends com.tencent.mm.sdk.b.c<pe>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final void run()
    {
      AppMethodBeat.i(205927);
      int i = CdnLogic.getRecentAverageSpeed(2);
      com.tencent.mm.plugin.finder.preload.model.a locala = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel();
      Object localObject = com.tencent.mm.ui.component.a.KEX;
      localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class);
      p.g(localObject, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
      localObject = (FinderVideoRecycler)localObject;
      com.tencent.mm.ac.c.h((d.g.a.a)new q(i + "kb/s | " + locala.suk + ':' + locala.suj + ':' + locala.suc + ':' + locala.sud + ':' + locala.sug + " | video=" + FinderVideoRecycler.a((FinderVideoRecycler)localObject) + " | buf=" + (Integer)TestPreloadPreview.f(this.tiq).get(Integer.valueOf(TestPreloadPreview.g(this.tiq)))) {});
      AppMethodBeat.o(205927);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class j
    extends d
  {
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(205932);
      p.h(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        com.tencent.mm.ac.c.h((d.g.a.a)new a(this));
        AppMethodBeat.o(205932);
        return;
      }
      if ((paramb instanceof h))
      {
        com.tencent.mm.ac.c.h((d.g.a.a)new b(this, paramb));
        AppMethodBeat.o(205932);
        return;
      }
      if ((paramb instanceof c.a)) {
        com.tencent.mm.ac.c.h((d.g.a.a)new c(this, paramb));
      }
      AppMethodBeat.o(205932);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(205933);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      if ((paramb instanceof h))
      {
        if (((h)paramb).type == 0)
        {
          AppMethodBeat.o(205933);
          return true;
        }
        AppMethodBeat.o(205933);
        return false;
      }
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        AppMethodBeat.o(205933);
        return true;
      }
      if ((paramb instanceof c.a))
      {
        if (((c.a)paramb).type == 1)
        {
          AppMethodBeat.o(205933);
          return true;
        }
        AppMethodBeat.o(205933);
        return false;
      }
      AppMethodBeat.o(205933);
      return false;
    }
    
    public final boolean cAA()
    {
      return true;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(TestPreloadPreview.j paramj)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(TestPreloadPreview.j paramj, com.tencent.mm.plugin.finder.event.base.b paramb)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class k
    implements View.OnTouchListener
  {
    k(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205935);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/TestPreloadPreview$onCreate$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
      p.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0) {
        TestPreloadPreview.d(this.tiq).removeCallbacksAndMessages(null);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/view/TestPreloadPreview$onCreate$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205935);
        return false;
        if (paramMotionEvent.getAction() == 1)
        {
          TestPreloadPreview.d(this.tiq).removeCallbacksAndMessages(null);
          TestPreloadPreview.d(this.tiq).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(205934);
              Object localObject = this.tiA.tiq.getRecyclerView().getLayoutManager();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(205934);
                throw ((Throwable)localObject);
              }
              ((LinearLayoutManager)localObject).ag(Math.max(0, TestPreloadPreview.e(this.tiA.tiq) - 1), 0);
              AppMethodBeat.o(205934);
            }
          }, 3000L);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.TestPreloadPreview
 * JD-Core Version:    0.7.0.1
 */