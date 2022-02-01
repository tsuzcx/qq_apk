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
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.a;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.u;
import d.g.b.w;
import d.n.n;
import d.v;
import d.y;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bufferSet", "Ljava/util/concurrent/ConcurrentHashMap;", "callback", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1;", "centerFeedId", "", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "globalPreloadTv", "Landroid/widget/TextView;", "getGlobalPreloadTv", "()Landroid/widget/TextView;", "globalPreloadTv$delegate", "Lkotlin/Lazy;", "headerCount", "isCreated", "", "isOpenMultiBitRateDownload", "listener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1;", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mediaCache", "", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "notifyListener", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1;", "observer", "com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1;", "playingIndex", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "tabType", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "buildText", "feedId", "simpleFeedId", "mediaId", "isVideo", "percent", "preloadPercent", "preloadMinSize", "fileFormat", "codingFormat", "position", "size", "hasPlayed", "relatedFeedId", "desc", "findCacheInfo", "originalMediaId", "notifyChange", "", "onCreate", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "onDetachedFromWindow", "Companion", "Info", "TestAdapter", "TestHolder", "plugin-finder_release"})
public final class TestPreloadPreview
  extends FrameLayout
{
  public static final a Lgk;
  private int IoU;
  private final boolean KUi;
  private final d.f Lga;
  private final ConcurrentHashMap<Integer, Integer> Lgb;
  private final d.f Lgc;
  private DataBuffer<BaseFinderFeed> Lgd;
  private final ConcurrentHashMap<String, b> Lge;
  private final e Lgf;
  private int Lgg;
  private final i Lgh;
  private final g Lgi;
  private final j Lgj;
  private boolean cCu;
  private final ap hbq;
  private int qYg;
  private com.tencent.mm.plugin.finder.video.c qrq;
  private long qsk;
  
  static
  {
    AppMethodBeat.i(200225);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(TestPreloadPreview.class), "recyclerView", "getRecyclerView()Landroid/support/v7/widget/RecyclerView;")), (d.l.k)w.a(new u(w.bk(TestPreloadPreview.class), "globalPreloadTv", "getGlobalPreloadTv()Landroid/widget/TextView;")) };
    Lgk = new a((byte)0);
    AppMethodBeat.o(200225);
  }
  
  public TestPreloadPreview(final Context paramContext, final AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200230);
    this.Lga = d.g.E((d.g.a.a)new l(this));
    this.Lgb = new ConcurrentHashMap();
    this.Lgc = d.g.E((d.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.qJA;
    this.KUi = com.tencent.mm.plugin.finder.storage.b.fUN();
    setId(2131305708);
    LayoutInflater.from(getContext()).inflate(2131496352, (ViewGroup)this, true);
    paramContext = findViewById(2131307891);
    paramAttributeSet = findViewById(2131307299);
    d.g.b.k.g(paramAttributeSet, "expandBtn");
    paramAttributeSet.setTag(Boolean.FALSE);
    getRecyclerView().setLayoutFrozen(true);
    paramContext.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200194);
        View localView = paramContext;
        d.g.b.k.g(localView, "container");
        localView.setTranslationY(-this.Lgl.getRecyclerView().getHeight() - this.Lgl.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(200194);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200197);
        paramAnonymousView = paramAttributeSet;
        d.g.b.k.g(paramAnonymousView, "expandBtn");
        if (d.g.b.k.g(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.Lgl.getRecyclerView().getHeight() - this.Lgl.getGlobalPreloadTv().getHeight()).withEndAction((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200195);
              this.Lgn.Lgl.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(200195);
            }
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          paramAnonymousView = paramAttributeSet;
          d.g.b.k.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.FALSE);
          AppMethodBeat.o(200197);
          return;
        }
        paramContext.animate().cancel();
        paramContext.animate().translationY(0.0F).withEndAction((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200196);
            View localView = this.Lgn.uGQ;
            d.g.b.k.g(localView, "container");
            localView.setTranslationY(0.0F);
            this.Lgn.Lgl.getRecyclerView().setLayoutFrozen(false);
            AppMethodBeat.o(200196);
          }
        }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
        paramAnonymousView = paramAttributeSet;
        d.g.b.k.g(paramAnonymousView, "expandBtn");
        paramAnonymousView.setTag(Boolean.TRUE);
        AppMethodBeat.o(200197);
      }
    });
    this.Lge = new ConcurrentHashMap();
    this.Lgf = new e(this);
    this.Lgg = -1;
    this.hbq = new ap(Looper.getMainLooper());
    this.Lgh = new i(this);
    this.Lgi = new g(this);
    this.Lgj = new j(this);
    AppMethodBeat.o(200230);
  }
  
  public TestPreloadPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200231);
    this.Lga = d.g.E((d.g.a.a)new l(this));
    this.Lgb = new ConcurrentHashMap();
    this.Lgc = d.g.E((d.g.a.a)new f(this));
    paramContext = com.tencent.mm.plugin.finder.storage.b.qJA;
    this.KUi = com.tencent.mm.plugin.finder.storage.b.fUN();
    setId(2131305708);
    LayoutInflater.from(getContext()).inflate(2131496352, (ViewGroup)this, true);
    paramContext = findViewById(2131307891);
    paramAttributeSet = findViewById(2131307299);
    d.g.b.k.g(paramAttributeSet, "expandBtn");
    paramAttributeSet.setTag(Boolean.FALSE);
    getRecyclerView().setLayoutFrozen(true);
    paramContext.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200194);
        View localView = paramContext;
        d.g.b.k.g(localView, "container");
        localView.setTranslationY(-this.Lgl.getRecyclerView().getHeight() - this.Lgl.getGlobalPreloadTv().getHeight());
        AppMethodBeat.o(200194);
      }
    });
    paramAttributeSet.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200197);
        paramAnonymousView = paramAttributeSet;
        d.g.b.k.g(paramAnonymousView, "expandBtn");
        if (d.g.b.k.g(paramAnonymousView.getTag(), Boolean.TRUE))
        {
          paramContext.animate().cancel();
          paramContext.animate().translationY(-this.Lgl.getRecyclerView().getHeight() - this.Lgl.getGlobalPreloadTv().getHeight()).withEndAction((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200195);
              this.Lgn.Lgl.getRecyclerView().setLayoutFrozen(true);
              AppMethodBeat.o(200195);
            }
          }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
          paramAnonymousView = paramAttributeSet;
          d.g.b.k.g(paramAnonymousView, "expandBtn");
          paramAnonymousView.setTag(Boolean.FALSE);
          AppMethodBeat.o(200197);
          return;
        }
        paramContext.animate().cancel();
        paramContext.animate().translationY(0.0F).withEndAction((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200196);
            View localView = this.Lgn.uGQ;
            d.g.b.k.g(localView, "container");
            localView.setTranslationY(0.0F);
            this.Lgn.Lgl.getRecyclerView().setLayoutFrozen(false);
            AppMethodBeat.o(200196);
          }
        }).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.6F)).setDuration(220L).start();
        paramAnonymousView = paramAttributeSet;
        d.g.b.k.g(paramAnonymousView, "expandBtn");
        paramAnonymousView.setTag(Boolean.TRUE);
        AppMethodBeat.o(200197);
      }
    });
    this.Lge = new ConcurrentHashMap();
    this.Lgf = new e(this);
    this.Lgg = -1;
    this.hbq = new ap(Looper.getMainLooper());
    this.Lgh = new i(this);
    this.Lgi = new g(this);
    this.Lgj = new j(this);
    AppMethodBeat.o(200231);
  }
  
  public final void a(DataBuffer<BaseFinderFeed> paramDataBuffer, int paramInt1, com.tencent.mm.plugin.finder.video.c paramc, d paramd, int paramInt2)
  {
    AppMethodBeat.i(200228);
    d.g.b.k.h(paramDataBuffer, "data");
    d.g.b.k.h(paramc, "videoCore");
    this.cCu = true;
    this.Lgd = paramDataBuffer;
    this.IoU = paramInt2;
    this.qrq = paramc;
    this.qYg = paramInt1;
    paramDataBuffer = getRecyclerView();
    getContext();
    paramDataBuffer.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramDataBuffer = new c();
    paramDataBuffer.av(true);
    getRecyclerView().setAdapter((RecyclerView.a)paramDataBuffer);
    getRecyclerView().setHasFixedSize(true);
    if (paramd != null) {
      paramd.a((com.tencent.mm.plugin.finder.event.base.f)this.Lgj);
    }
    this.Lgi.alive();
    this.Lgh.alive();
    paramDataBuffer = paramc.Lct;
    if (paramDataBuffer != null) {
      paramDataBuffer.a((com.tencent.mm.plugin.finder.preload.b)this.Lgf);
    }
    getRecyclerView().setOnTouchListener((View.OnTouchListener)new k(this));
    AppMethodBeat.o(200228);
  }
  
  public final TextView getGlobalPreloadTv()
  {
    AppMethodBeat.i(200227);
    TextView localTextView = (TextView)this.Lgc.getValue();
    AppMethodBeat.o(200227);
    return localTextView;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(200226);
    RecyclerView localRecyclerView = (RecyclerView)this.Lga.getValue();
    AppMethodBeat.o(200226);
    return localRecyclerView;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(200229);
    super.onDetachedFromWindow();
    if (this.cCu)
    {
      this.Lgi.dead();
      this.Lgh.dead();
      Object localObject1 = this.qrq;
      if (localObject1 == null) {
        d.g.b.k.aPZ("videoCore");
      }
      Object localObject2 = ((com.tencent.mm.plugin.finder.video.c)localObject1).Lct;
      if (localObject2 != null)
      {
        localObject1 = (com.tencent.mm.plugin.finder.preload.b)this.Lgf;
        d.g.b.k.h(localObject1, "callback");
        localObject2 = ((MediaPreloadCore)localObject2).KTx;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.preload.a.b)localObject2).KUj;
          if (localObject2 != null) {
            j.a((Iterable)localObject2, (d.g.a.b)new MediaPreloadCore.d((com.tencent.mm.plugin.finder.preload.b)localObject1));
          }
        }
      }
      this.cCu = false;
    }
    AppMethodBeat.o(200229);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$Info;", "", "()V", "codingFormat", "", "getCodingFormat", "()Ljava/lang/String;", "setCodingFormat", "(Ljava/lang/String;)V", "fileFormat", "getFileFormat", "setFileFormat", "hasPlayed", "getHasPlayed", "setHasPlayed", "percent", "", "getPercent", "()I", "setPercent", "(I)V", "preloadMinSize", "", "getPreloadMinSize", "()J", "setPreloadMinSize", "(J)V", "preloadPercent", "getPreloadPercent", "setPreloadPercent", "size", "getSize", "setSize", "state", "getState", "setState", "plugin-finder_release"})
  public static final class b
  {
    String DkS;
    String KTW;
    String Lgo;
    int foh;
    int percent;
    long preloadMinSize;
    int size;
    int state;
    
    public final int fWZ()
    {
      if (this.foh == 0) {
        return this.percent;
      }
      return this.foh;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "(Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview;)V", "getItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "position", "", "getItemCount", "getItemId", "", "getMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "onBindViewHolder", "", "holder", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<TestPreloadPreview.d>
  {
    private final FinderItem ahL(int paramInt)
    {
      AppMethodBeat.i(200203);
      FinderItem localFinderItem = ((BaseFinderFeed)TestPreloadPreview.b(this.Lgl).get(paramInt)).feedObject;
      AppMethodBeat.o(200203);
      return localFinderItem;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(200200);
      int i = TestPreloadPreview.b(this.Lgl).getTotalSize();
      AppMethodBeat.o(200200);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(200201);
      long l = ((BaseFinderFeed)TestPreloadPreview.b(this.Lgl).get(paramInt)).feedObject.getExpectId();
      AppMethodBeat.o(200201);
      return l;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class a
      implements View.OnLongClickListener
    {
      a(TestPreloadPreview.c paramc, int paramInt, TestPreloadPreview.d paramd) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(200198);
        paramView = (bmd)j.iz((List)TestPreloadPreview.c.a(this.Lgp, this.fKG).getMediaList());
        if ((paramView != null) && ((TestPreloadPreview.b)TestPreloadPreview.a(this.Lgp.Lgl).get(paramView.mediaId) != null))
        {
          paramView = aj.getContext().getSystemService("clipboard");
          if (paramView == null)
          {
            paramView = new v("null cannot be cast to non-null type android.content.ClipboardManager");
            AppMethodBeat.o(200198);
            throw paramView;
          }
          paramView = (ClipboardManager)paramView;
          Object localObject = this.Lgq.Lgr;
          d.g.b.k.g(localObject, "holder.mediaIdTv");
          localObject = ((TextView)localObject).getText().toString();
          paramView.setText((CharSequence)localObject);
          paramView = this.Lgq.arI;
          d.g.b.k.g(paramView, "holder.itemView");
          Toast.makeText(paramView.getContext(), (CharSequence)localObject, 1).show();
          ad.i("TestPreloadView", (String)localObject);
        }
        AppMethodBeat.o(200198);
        return true;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mediaIdTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getMediaIdTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.v
  {
    final TextView Lgr;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(200205);
      this.Lgr = ((TextView)paramView.findViewById(2131307780));
      AppMethodBeat.o(200205);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$callback$1", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getOriginalMediaId", "", "mediaId", "onCancel", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.plugin.finder.preload.b
  {
    private static String aVI(String paramString)
    {
      AppMethodBeat.i(200206);
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
        AppMethodBeat.o(200206);
        return paramString;
        j = 0;
        break label53;
        label90:
        i += 1;
        break;
        i = -1;
      }
      label102:
      AppMethodBeat.o(200206);
      return paramString;
    }
    
    public final void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(200207);
      d.g.b.k.h(paramString1, "mediaId");
      d.g.b.k.h(paramString2, "fileFormat");
      d.g.b.k.h(paramString3, "codingFormat");
      d.g.b.k.h(paramc, "task");
      paramString1 = TestPreloadPreview.a(this.Lgl, aVI(paramString1));
      paramString1.foh = paramInt;
      paramString1.state = 2;
      paramString1.KTW = paramString3;
      paramString1.DkS = paramString2;
      paramString1.preloadMinSize = paramc.preloadMinSize;
      TestPreloadPreview.h(this.Lgl);
      AppMethodBeat.o(200207);
    }
    
    public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(200210);
      d.g.b.k.h(paramString1, "mediaId");
      d.g.b.k.h(paramString2, "msg");
      d.g.b.k.h(paramc, "task");
      AppMethodBeat.o(200210);
    }
    
    public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.finder.preload.c paramc)
    {
      AppMethodBeat.i(200209);
      d.g.b.k.h(paramString, "mediaId");
      d.g.b.k.h(paramc, "task");
      paramString = TestPreloadPreview.a(this.Lgl, aVI(paramString));
      paramString.preloadMinSize = paramc.preloadMinSize;
      paramString.foh = paramInt;
      paramString.state = 3;
      TestPreloadPreview.h(this.Lgl);
      AppMethodBeat.o(200209);
    }
    
    public final void aVn(String paramString)
    {
      AppMethodBeat.i(200211);
      d.g.b.k.h(paramString, "mediaId");
      AppMethodBeat.o(200211);
    }
    
    public final void cU(String paramString, int paramInt)
    {
      AppMethodBeat.i(200208);
      d.g.b.k.h(paramString, "mediaId");
      paramString = TestPreloadPreview.a(this.Lgl, aVI(paramString));
      paramString.foh = paramInt;
      paramString.state = 2;
      TestPreloadPreview.h(this.Lgl);
      AppMethodBeat.o(200208);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<TextView>
  {
    f(TestPreloadPreview paramTestPreloadPreview)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/PreloadProcessChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class g
    extends com.tencent.mm.sdk.b.c<ol>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final void run()
    {
      AppMethodBeat.i(200215);
      int i = CdnLogic.getRecentAverageSpeed(2);
      com.tencent.mm.plugin.finder.preload.model.a locala = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel();
      Object localObject = com.tencent.mm.ui.component.a.LCX;
      localObject = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderVideoRecycler.class);
      d.g.b.k.g(localObject, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
      localObject = (FinderVideoRecycler)localObject;
      com.tencent.mm.ad.c.g((d.g.a.a)new d.g.b.l(i + "kb/s | load(" + bt.mK(locala.KTT) + " : " + locala.Dmf + " : " + locala.wAk + " : " + locala.KTR + ')' + " | video=" + FinderVideoRecycler.a((FinderVideoRecycler)localObject) + " | buf=" + (Integer)TestPreloadPreview.f(this.Lgl).get(Integer.valueOf(TestPreloadPreview.g(this.Lgl)))) {});
      AppMethodBeat.o(200215);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$notifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/TestPreloadPreviewNotifyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<ys>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/TestPreloadPreview$observer$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class j
    extends com.tencent.mm.plugin.finder.event.base.f
  {
    public final void a(final com.tencent.mm.plugin.finder.event.base.c paramc)
    {
      AppMethodBeat.i(200220);
      d.g.b.k.h(paramc, "ev");
      if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        com.tencent.mm.ad.c.g((d.g.a.a)new a(this));
        AppMethodBeat.o(200220);
        return;
      }
      if ((paramc instanceof i))
      {
        com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramc));
        AppMethodBeat.o(200220);
        return;
      }
      if ((paramc instanceof b.a)) {
        com.tencent.mm.ad.c.g((d.g.a.a)new c(this, paramc));
      }
      AppMethodBeat.o(200220);
    }
    
    public final boolean a(d paramd, com.tencent.mm.plugin.finder.event.base.c paramc)
    {
      AppMethodBeat.i(200221);
      d.g.b.k.h(paramd, "dispatcher");
      d.g.b.k.h(paramc, "event");
      if ((paramc instanceof i))
      {
        if (((i)paramc).type == 0)
        {
          AppMethodBeat.o(200221);
          return true;
        }
        AppMethodBeat.o(200221);
        return false;
      }
      if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.a))
      {
        AppMethodBeat.o(200221);
        return true;
      }
      if ((paramc instanceof b.a))
      {
        if (((b.a)paramc).type == 1)
        {
          AppMethodBeat.o(200221);
          return true;
        }
        AppMethodBeat.o(200221);
        return false;
      }
      AppMethodBeat.o(200221);
      return false;
    }
    
    public final boolean clc()
    {
      return true;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(TestPreloadPreview.j paramj)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(TestPreloadPreview.j paramj, com.tencent.mm.plugin.finder.event.base.c paramc)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(TestPreloadPreview.j paramj, com.tencent.mm.plugin.finder.event.base.c paramc)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class k
    implements View.OnTouchListener
  {
    k(TestPreloadPreview paramTestPreloadPreview) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200223);
      d.g.b.k.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0) {
        TestPreloadPreview.d(this.Lgl).removeCallbacksAndMessages(null);
      }
      for (;;)
      {
        AppMethodBeat.o(200223);
        return false;
        if (paramMotionEvent.getAction() == 1)
        {
          TestPreloadPreview.d(this.Lgl).removeCallbacksAndMessages(null);
          TestPreloadPreview.d(this.Lgl).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200222);
              Object localObject = this.Lgv.Lgl.getRecyclerView().getLayoutManager();
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(200222);
                throw ((Throwable)localObject);
              }
              ((LinearLayoutManager)localObject).af(Math.max(0, TestPreloadPreview.e(this.Lgv.Lgl) - 1), 0);
              AppMethodBeat.o(200222);
            }
          }, 3000L);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.TestPreloadPreview
 * JD-Core Version:    0.7.0.1
 */