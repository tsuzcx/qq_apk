package com.tencent.mm.plugin.finder.view;

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
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.n.n;
import d.v;
import d.y;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bufferSet", "Ljava/util/concurrent/ConcurrentHashMap;", "callback", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1;", "centerFeedId", "", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "globalPreloadTv", "Landroid/widget/TextView;", "getGlobalPreloadTv", "()Landroid/widget/TextView;", "globalPreloadTv$delegate", "Lkotlin/Lazy;", "headerCount", "isCreated", "", "isOpenMultiBitRateDownload", "listener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1;", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaCache", "", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "notifyListener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1;", "observer", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1;", "playingIndex", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "tabType", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "buildText", "feedId", "simpleFeedId", "mediaId", "isVideo", "percent", "preloadPercent", "preloadMinSize", "fileFormat", "codingFormat", "position", "size", "hasPlayed", "relatedFeedId", "desc", "findCacheInfo", "originalMediaId", "notifyChange", "", "onCreate", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "onDetachedFromWindow", "Companion", "Info", "TestAdapter", "TestHolder", "plugin-finder_release"})
public final class TestPreloadPreview
  extends FrameLayout
{
  public static final TestPreloadPreview.a rZP;
  private boolean czD;
  private int diw;
  private final ao hBR;
  private final f rZE;
  private final ConcurrentHashMap<Integer, Integer> rZF;
  private final f rZG;
  private DataBuffer<BaseFinderFeed> rZH;
  private int rZI;
  private final ConcurrentHashMap<String, b> rZJ;
  private final e rZK;
  private int rZL;
  private final i rZM;
  private final g rZN;
  private final j rZO;
  private i rbo;
  private long rdL;
  private final boolean rwd;
  
  static
  {
    AppMethodBeat.i(204295);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(TestPreloadPreview.class), "recyclerView", "getRecyclerView()Landroid/support/v7/widget/RecyclerView;")), (d.l.k)w.a(new u(w.bn(TestPreloadPreview.class), "globalPreloadTv", "getGlobalPreloadTv()Landroid/widget/TextView;")) };
    rZP = new TestPreloadPreview.a((byte)0);
    AppMethodBeat.o(204295);
  }
  
  public TestPreloadPreview(final Context paramContext, final AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204300);
    this.rZE = d.g.K((d.g.a.a)new l(this));
    this.rZF = new ConcurrentHashMap();
    this.rZG = d.g.K((d.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.rCU;
    this.rwd = com.tencent.mm.plugin.finder.storage.b.cAk();
    setId(2131305708);
    LayoutInflater.from(getContext()).inflate(2131496366, (ViewGroup)this, true);
    paramContext = findViewById(2131308028);
    paramAttributeSet = findViewById(2131307330);
    d.g.b.k.g(paramAttributeSet, "expandBtn");
    paramAttributeSet.setTag(Boolean.FALSE);
    getRecyclerView().setLayoutFrozen(true);
    paramContext.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204264);
        View localView = paramContext;
        d.g.b.k.g(localView, "container");
        localView.setTranslationY(-this.rZQ.getRecyclerView().getHeight() - this.rZQ.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(204264);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204267);
        paramAnonymousView = paramAttributeSet;
        d.g.b.k.g(paramAnonymousView, "expandBtn");
        if (d.g.b.k.g(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.rZQ.getRecyclerView().getHeight() - this.rZQ.getGlobalPreloadTv().getHeight()).withEndAction((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(204265);
              this.rZT.rZQ.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(204265);
            }
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          paramAnonymousView = paramAttributeSet;
          d.g.b.k.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.FALSE);
          AppMethodBeat.o(204267);
          return;
        }
        paramContext.animate().cancel();
        paramContext.animate().translationY(0.0F).withEndAction((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204266);
            View localView = this.rZT.rZR;
            d.g.b.k.g(localView, "container");
            localView.setTranslationY(0.0F);
            this.rZT.rZQ.getRecyclerView().setLayoutFrozen(false);
            AppMethodBeat.o(204266);
          }
        }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
        paramAnonymousView = paramAttributeSet;
        d.g.b.k.g(paramAnonymousView, "expandBtn");
        paramAnonymousView.setTag(Boolean.TRUE);
        AppMethodBeat.o(204267);
      }
    });
    this.rZJ = new ConcurrentHashMap();
    this.rZK = new e(this);
    this.rZL = -1;
    this.hBR = new ao(Looper.getMainLooper());
    this.rZM = new i(this);
    this.rZN = new g(this);
    this.rZO = new j(this);
    AppMethodBeat.o(204300);
  }
  
  public TestPreloadPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204301);
    this.rZE = d.g.K((d.g.a.a)new l(this));
    this.rZF = new ConcurrentHashMap();
    this.rZG = d.g.K((d.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.rCU;
    this.rwd = com.tencent.mm.plugin.finder.storage.b.cAk();
    setId(2131305708);
    LayoutInflater.from(getContext()).inflate(2131496366, (ViewGroup)this, true);
    paramContext = findViewById(2131308028);
    paramAttributeSet = findViewById(2131307330);
    d.g.b.k.g(paramAttributeSet, "expandBtn");
    paramAttributeSet.setTag(Boolean.FALSE);
    getRecyclerView().setLayoutFrozen(true);
    paramContext.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204264);
        View localView = paramContext;
        d.g.b.k.g(localView, "container");
        localView.setTranslationY(-this.rZQ.getRecyclerView().getHeight() - this.rZQ.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(204264);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204267);
        paramAnonymousView = paramAttributeSet;
        d.g.b.k.g(paramAnonymousView, "expandBtn");
        if (d.g.b.k.g(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.rZQ.getRecyclerView().getHeight() - this.rZQ.getGlobalPreloadTv().getHeight()).withEndAction((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(204265);
              this.rZT.rZQ.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(204265);
            }
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          paramAnonymousView = paramAttributeSet;
          d.g.b.k.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.FALSE);
          AppMethodBeat.o(204267);
          return;
        }
        paramContext.animate().cancel();
        paramContext.animate().translationY(0.0F).withEndAction((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204266);
            View localView = this.rZT.rZR;
            d.g.b.k.g(localView, "container");
            localView.setTranslationY(0.0F);
            this.rZT.rZQ.getRecyclerView().setLayoutFrozen(false);
            AppMethodBeat.o(204266);
          }
        }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
        paramAnonymousView = paramAttributeSet;
        d.g.b.k.g(paramAnonymousView, "expandBtn");
        paramAnonymousView.setTag(Boolean.TRUE);
        AppMethodBeat.o(204267);
      }
    });
    this.rZJ = new ConcurrentHashMap();
    this.rZK = new e(this);
    this.rZL = -1;
    this.hBR = new ao(Looper.getMainLooper());
    this.rZM = new i(this);
    this.rZN = new g(this);
    this.rZO = new j(this);
    AppMethodBeat.o(204301);
  }
  
  public final void a(DataBuffer<BaseFinderFeed> paramDataBuffer, int paramInt1, i parami, com.tencent.mm.plugin.finder.event.base.c paramc, int paramInt2)
  {
    AppMethodBeat.i(204298);
    d.g.b.k.h(paramDataBuffer, "data");
    d.g.b.k.h(parami, "videoCore");
    this.czD = true;
    this.rZH = paramDataBuffer;
    this.diw = paramInt2;
    this.rbo = parami;
    this.rZI = paramInt1;
    paramDataBuffer = getRecyclerView();
    getContext();
    paramDataBuffer.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramDataBuffer = new c();
    paramDataBuffer.av(true);
    getRecyclerView().setAdapter((RecyclerView.a)paramDataBuffer);
    getRecyclerView().setHasFixedSize(true);
    if (paramc != null) {
      paramc.a((d)this.rZO);
    }
    this.rZN.alive();
    this.rZM.alive();
    paramDataBuffer = parami.rSt;
    if (paramDataBuffer != null) {
      paramDataBuffer.a((com.tencent.mm.plugin.finder.preload.b)this.rZK);
    }
    getRecyclerView().setOnTouchListener((View.OnTouchListener)new k(this));
    AppMethodBeat.o(204298);
  }
  
  public final TextView getGlobalPreloadTv()
  {
    AppMethodBeat.i(204297);
    TextView localTextView = (TextView)this.rZG.getValue();
    AppMethodBeat.o(204297);
    return localTextView;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(204296);
    RecyclerView localRecyclerView = (RecyclerView)this.rZE.getValue();
    AppMethodBeat.o(204296);
    return localRecyclerView;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(204299);
    super.onDetachedFromWindow();
    if (this.czD)
    {
      this.rZN.dead();
      this.rZM.dead();
      Object localObject1 = this.rbo;
      if (localObject1 == null) {
        d.g.b.k.aVY("videoCore");
      }
      Object localObject2 = ((i)localObject1).rSt;
      if (localObject2 != null)
      {
        localObject1 = (com.tencent.mm.plugin.finder.preload.b)this.rZK;
        d.g.b.k.h(localObject1, "callback");
        localObject2 = ((MediaPreloadCore)localObject2).rvl;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.preload.worker.b)localObject2).rwe;
          if (localObject2 != null) {
            j.a((Iterable)localObject2, (d.g.a.b)new MediaPreloadCore.d((com.tencent.mm.plugin.finder.preload.b)localObject1));
          }
        }
      }
      this.czD = false;
    }
    AppMethodBeat.o(204299);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "", "()V", "codingFormat", "", "getCodingFormat", "()Ljava/lang/String;", "setCodingFormat", "(Ljava/lang/String;)V", "fileFormat", "getFileFormat", "setFileFormat", "hasPlayed", "getHasPlayed", "setHasPlayed", "percent", "", "getPercent", "()I", "setPercent", "(I)V", "preloadMinSize", "", "getPreloadMinSize", "()J", "setPreloadMinSize", "(J)V", "preloadPercent", "getPreloadPercent", "setPreloadPercent", "size", "getSize", "setSize", "state", "getState", "setState", "plugin-finder_release"})
  public static final class b
  {
    String drn;
    int frB;
    int percent;
    long preloadMinSize;
    String rZU;
    String rvP;
    int size;
    int state;
    
    public final int cFk()
    {
      if (this.frB == 0) {
        return this.percent;
      }
      return this.frB;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "getItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "position", "", "getItemCount", "getItemId", "", "getMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "onBindViewHolder", "", "holder", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<TestPreloadPreview.d>
  {
    private final FinderItem ER(int paramInt)
    {
      AppMethodBeat.i(204273);
      FinderItem localFinderItem = ((BaseFinderFeed)TestPreloadPreview.b(this.rZQ).get(paramInt)).feedObject;
      AppMethodBeat.o(204273);
      return localFinderItem;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(204270);
      int i = TestPreloadPreview.b(this.rZQ).getTotalSize();
      AppMethodBeat.o(204270);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(204271);
      long l = ((BaseFinderFeed)TestPreloadPreview.b(this.rZQ).get(paramInt)).feedObject.getExpectId();
      AppMethodBeat.o(204271);
      return l;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class a
      implements View.OnLongClickListener
    {
      a(TestPreloadPreview.c paramc, int paramInt, TestPreloadPreview.d paramd) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(204268);
        paramView = (bqs)j.iP((List)TestPreloadPreview.c.a(this.rZV, this.fOm).getMediaList());
        if ((paramView != null) && ((TestPreloadPreview.b)TestPreloadPreview.a(this.rZV.rZQ).get(paramView.mediaId) != null))
        {
          paramView = ai.getContext().getSystemService("clipboard");
          if (paramView == null)
          {
            paramView = new v("null cannot be cast to non-null type android.content.ClipboardManager");
            AppMethodBeat.o(204268);
            throw paramView;
          }
          paramView = (ClipboardManager)paramView;
          Object localObject = this.rZW.rZX;
          d.g.b.k.g(localObject, "holder.mediaIdTv");
          localObject = ((TextView)localObject).getText().toString();
          paramView.setText((CharSequence)localObject);
          paramView = this.rZW.asD;
          d.g.b.k.g(paramView, "holder.itemView");
          Toast.makeText(paramView.getContext(), (CharSequence)localObject, 1).show();
          ac.i("TestPreloadView", (String)localObject);
        }
        AppMethodBeat.o(204268);
        return true;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getOriginalMediaId", "", "mediaId", "onCancel", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.plugin.finder.preload.b
  {
    private static String aeN(String paramString)
    {
      AppMethodBeat.i(204276);
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
        AppMethodBeat.o(204276);
        return paramString;
        j = 0;
        break label53;
        label90:
        i += 1;
        break;
        i = -1;
      }
      label102:
      AppMethodBeat.o(204276);
      return paramString;
    }
    
    public final void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(204277);
      d.g.b.k.h(paramString1, "mediaId");
      d.g.b.k.h(paramString2, "fileFormat");
      d.g.b.k.h(paramString3, "codingFormat");
      d.g.b.k.h(paramc, "task");
      paramString1 = TestPreloadPreview.a(this.rZQ, aeN(paramString1));
      paramString1.frB = paramInt;
      paramString1.state = 2;
      paramString1.rvP = paramString3;
      paramString1.drn = paramString2;
      paramString1.preloadMinSize = paramc.preloadMinSize;
      TestPreloadPreview.h(this.rZQ);
      AppMethodBeat.o(204277);
    }
    
    public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(204280);
      d.g.b.k.h(paramString1, "mediaId");
      d.g.b.k.h(paramString2, "msg");
      d.g.b.k.h(paramc, "task");
      AppMethodBeat.o(204280);
    }
    
    public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(204279);
      d.g.b.k.h(paramString, "mediaId");
      d.g.b.k.h(paramc, "task");
      paramString = TestPreloadPreview.a(this.rZQ, aeN(paramString));
      paramString.preloadMinSize = paramc.preloadMinSize;
      paramString.frB = paramInt;
      paramString.state = 3;
      TestPreloadPreview.h(this.rZQ);
      AppMethodBeat.o(204279);
    }
    
    public final void adG(String paramString)
    {
      AppMethodBeat.i(204281);
      d.g.b.k.h(paramString, "mediaId");
      AppMethodBeat.o(204281);
    }
    
    public final void cZ(String paramString, int paramInt)
    {
      AppMethodBeat.i(204278);
      d.g.b.k.h(paramString, "mediaId");
      paramString = TestPreloadPreview.a(this.rZQ, aeN(paramString));
      paramString.frB = paramInt;
      paramString.state = 2;
      TestPreloadPreview.h(this.rZQ);
      AppMethodBeat.o(204278);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<TextView>
  {
    f(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/PreloadProcessChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class g
    extends com.tencent.mm.sdk.b.c<ou>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final void run()
    {
      AppMethodBeat.i(204285);
      int i = CdnLogic.getRecentAverageSpeed(2);
      com.tencent.mm.plugin.finder.preload.model.a locala = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel();
      Object localObject = com.tencent.mm.ui.component.a.IrY;
      localObject = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderVideoRecycler.class);
      d.g.b.k.g(localObject, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
      localObject = (FinderVideoRecycler)localObject;
      com.tencent.mm.ac.c.g((d.g.a.a)new d.g.b.l(i + "kb/s | load(" + bs.qz(locala.rvK) + " : " + locala.rvF + " : " + locala.rvG + " : " + locala.rvI + ')' + " | video=" + FinderVideoRecycler.a((FinderVideoRecycler)localObject) + " | buf=" + (Integer)TestPreloadPreview.f(this.rZQ).get(Integer.valueOf(TestPreloadPreview.g(this.rZQ)))) {});
      AppMethodBeat.o(204285);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/TestPreloadPreviewNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<vw>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class j
    extends d
  {
    public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(204290);
      d.g.b.k.h(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        com.tencent.mm.ac.c.g((d.g.a.a)new a(this));
        AppMethodBeat.o(204290);
        return;
      }
      if ((paramb instanceof h))
      {
        com.tencent.mm.ac.c.g((d.g.a.a)new b(this, paramb));
        AppMethodBeat.o(204290);
        return;
      }
      if ((paramb instanceof b.a)) {
        com.tencent.mm.ac.c.g((d.g.a.a)new c(this, paramb));
      }
      AppMethodBeat.o(204290);
    }
    
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(204291);
      d.g.b.k.h(paramc, "dispatcher");
      d.g.b.k.h(paramb, "event");
      if ((paramb instanceof h))
      {
        if (((h)paramb).type == 0)
        {
          AppMethodBeat.o(204291);
          return true;
        }
        AppMethodBeat.o(204291);
        return false;
      }
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        AppMethodBeat.o(204291);
        return true;
      }
      if ((paramb instanceof b.a))
      {
        if (((b.a)paramb).type == 1)
        {
          AppMethodBeat.o(204291);
          return true;
        }
        AppMethodBeat.o(204291);
        return false;
      }
      AppMethodBeat.o(204291);
      return false;
    }
    
    public final boolean csW()
    {
      return true;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(TestPreloadPreview.j paramj)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(TestPreloadPreview.j paramj, com.tencent.mm.plugin.finder.event.base.b paramb)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(TestPreloadPreview.j paramj, com.tencent.mm.plugin.finder.event.base.b paramb)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class k
    implements View.OnTouchListener
  {
    k(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(204293);
      d.g.b.k.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0) {
        TestPreloadPreview.d(this.rZQ).removeCallbacksAndMessages(null);
      }
      for (;;)
      {
        AppMethodBeat.o(204293);
        return false;
        if (paramMotionEvent.getAction() == 1)
        {
          TestPreloadPreview.d(this.rZQ).removeCallbacksAndMessages(null);
          TestPreloadPreview.d(this.rZQ).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(204292);
              Object localObject = this.saa.rZQ.getRecyclerView().getLayoutManager();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(204292);
                throw ((Throwable)localObject);
              }
              ((LinearLayoutManager)localObject).af(Math.max(0, TestPreloadPreview.e(this.saa.rZQ) - 1), 0);
              AppMethodBeat.o(204292);
            }
          }, 3000L);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<RecyclerView>
  {
    l(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.TestPreloadPreview
 * JD-Core Version:    0.7.0.1
 */