package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.video.FinderCropVideoView;
import com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.a.j;
import d.g.a.a;
import d.g.b.k;
import d.g.b.v.c;
import d.g.b.v.d;
import d.g.b.v.e;
import d.k.h;
import d.v;
import d.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "activityCount", "", "createdVideoViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "isForceWaitForRelease", "", "makeActivitySet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "maxVideoCount", "onlineVideoEventListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1;", "preInflateCount", "preInflateVideoCount", "recycledCallbackMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "Lkotlin/collections/HashMap;", "recycledVideoViews", "releasingVideoViewMap", "", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "waitForCallback", "acrossCreatedVideoViews", "", "operation", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "createVideoView", "context", "Landroid/content/Context;", "isNormalVideoView", "findOldestVideoView", "clazz", "Ljava/lang/Class;", "isForce", "getOrCreate", "parent", "Landroid/view/ViewGroup;", "finderVideo", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "completedTo", "videoView", "getVideoCount", "make", "activity", "Lcom/tencent/mm/ui/MMActivity;", "isPreInflate", "onCleared", "onFinish", "onInit", "pauseAllVideo", "filter", "pauseAndRecycle", "isForceRemove", "isTryKeep", "pauseFocusVideo", "preInflateVideoView", "recycledVideoView", "releaseVideoView", "source", "isRecycle", "removeByContext", "removeViewFromParent", "Landroid/view/View;", "resumeFocusVideo", "Companion", "IRecycledCallback", "plugin-finder_release"})
public final class FinderVideoRecycler
  extends UIComponentPlugin<PluginFinder>
{
  public static final a LjW;
  private boolean LjK;
  private int LjL;
  private int LjM;
  final HashSet<com.tencent.mm.plugin.finder.video.o> LjN;
  private final ConcurrentLinkedQueue<WeakReference<? extends com.tencent.mm.plugin.finder.video.o>> LjO;
  public final HashMap<Integer, String> LjP;
  private final HashMap<Integer, b> LjQ;
  private final HashSet<String> LjR;
  private int LjS;
  private int LjT;
  private final HashMap<Integer, Object> LjU;
  private final i LjV;
  private final ap gAC;
  
  static
  {
    AppMethodBeat.i(200607);
    LjW = new a((byte)0);
    AppMethodBeat.o(200607);
  }
  
  public FinderVideoRecycler()
  {
    AppMethodBeat.i(200606);
    this.LjK = true;
    this.LjL = 1;
    this.gAC = new ap(Looper.getMainLooper());
    this.LjN = new HashSet();
    this.LjO = new ConcurrentLinkedQueue();
    this.LjP = new HashMap();
    this.LjQ = new HashMap();
    this.LjR = new HashSet();
    this.LjU = new HashMap();
    this.LjV = new i(this);
    AppMethodBeat.o(200606);
  }
  
  private final void Ca()
  {
    AppMethodBeat.i(200590);
    this.LjV.alive();
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    localObject = com.tencent.mm.plugin.finder.storage.b.fUe();
    this.LjL = ((Number)((d.o)localObject).first).intValue();
    this.LjK = ((Boolean)((d.o)localObject).second).booleanValue();
    this.LjM = h.kL(this.LjL - 1, 4);
    ad.i("Finder.VideoRecycler", "[onInit] maxVideoCount=" + this.LjL + " preInflateCount=" + this.LjM + " waitForRelease=" + this.LjK);
    AppMethodBeat.o(200590);
  }
  
  private final com.tencent.mm.plugin.finder.video.o I(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(200593);
    if (paramBoolean) {}
    for (com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)new FinderCropVideoView(paramContext);; localo = (com.tencent.mm.plugin.finder.video.o)new FinderVLogCompositionPlayView(paramContext))
    {
      this.LjO.add(new WeakReference(localo));
      ad.i("Finder.VideoRecycler", "[createVideoView] activity=" + paramContext.getClass().getSimpleName() + " videoCount=" + a(this));
      AppMethodBeat.o(200593);
      return localo;
    }
  }
  
  private final void a(final com.tencent.mm.plugin.finder.video.o paramo, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(200598);
    if (this.LjU.containsKey(Integer.valueOf(paramo.hashCode())))
    {
      ad.w("Finder.VideoRecycler", "[releaseVideoView] videoView=" + paramo.hashCode() + " is releasing, source=" + paramString);
      AppMethodBeat.o(200598);
      return;
    }
    ((Map)this.LjU).put(Integer.valueOf(paramo.hashCode()), new Object());
    gR(paramo.getVideoView());
    final long l = System.currentTimeMillis();
    paramo.pause();
    StringBuilder localStringBuilder = new StringBuilder("[releaseVideoView] async release videoView(").append(paramo.hashCode()).append(") isRecycle=").append(paramBoolean).append(" parent=");
    ViewParent localViewParent = paramo.getParentView();
    if (localViewParent != null) {}
    for (int i = localViewParent.hashCode();; i = 0)
    {
      ad.i("Finder.VideoRecycler", i + " source=" + paramString);
      com.tencent.mm.ad.c.b(null, (a)new n(this, paramo, paramBoolean, l, paramString));
      AppMethodBeat.o(200598);
      return;
    }
  }
  
  private int bD(Class<? extends com.tencent.mm.plugin.finder.video.o> paramClass)
  {
    AppMethodBeat.i(200601);
    final v.c localc = new v.c();
    localc.Jhu = 0;
    I((d.g.a.b)new g(paramClass, localc));
    int i = localc.Jhu;
    AppMethodBeat.o(200601);
    return i;
  }
  
  private final com.tencent.mm.plugin.finder.video.o d(Class<? extends com.tencent.mm.plugin.finder.video.o> paramClass, final boolean paramBoolean)
  {
    Object localObject1 = null;
    AppMethodBeat.i(200597);
    Object localObject2 = new v.d();
    ((v.d)localObject2).Jhv = 9223372036854775807L;
    final v.e locale = new v.e();
    locale.Jhw = null;
    I((d.g.a.b)new c(paramClass, (v.d)localObject2, new int[2], paramBoolean, locale));
    localObject2 = new StringBuilder("[findOldestVideoView] activity=");
    paramClass = (com.tencent.mm.plugin.finder.video.o)locale.Jhw;
    if (paramClass != null)
    {
      paramClass = paramClass.getVideoView();
      if (paramClass != null)
      {
        paramClass = paramClass.getContext();
        if (paramClass != null)
        {
          paramClass = paramClass.getClass();
          if (paramClass != null)
          {
            paramClass = paramClass.getSimpleName();
            localObject2 = ((StringBuilder)localObject2).append(paramClass).append(" videoView=");
            paramClass = (com.tencent.mm.plugin.finder.video.o)locale.Jhw;
            if (paramClass == null) {
              break label301;
            }
            paramClass = Integer.valueOf(paramClass.hashCode());
            label157:
            localObject2 = ((StringBuilder)localObject2).append(paramClass).append(' ').append("isAttachedToWindow=");
            paramClass = (com.tencent.mm.plugin.finder.video.o)locale.Jhw;
            if (paramClass == null) {
              break label306;
            }
            paramClass = paramClass.getVideoView();
            if (paramClass == null) {
              break label306;
            }
          }
        }
      }
    }
    label301:
    label306:
    for (paramClass = Boolean.valueOf(paramClass.isAttachedToWindow());; paramClass = null)
    {
      localObject2 = ((StringBuilder)localObject2).append(paramClass).append(" parent=");
      Object localObject3 = (com.tencent.mm.plugin.finder.video.o)locale.Jhw;
      paramClass = localObject1;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.video.o)localObject3).getParentView();
        paramClass = localObject1;
        if (localObject3 != null) {
          paramClass = Integer.valueOf(localObject3.hashCode());
        }
      }
      ad.i("Finder.VideoRecycler", paramClass);
      paramClass = (com.tencent.mm.plugin.finder.video.o)locale.Jhw;
      AppMethodBeat.o(200597);
      return paramClass;
      paramClass = null;
      break;
      paramClass = null;
      break label157;
    }
  }
  
  private final boolean gR(View paramView)
  {
    AppMethodBeat.i(200595);
    if (paramView != null)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null)
      {
        ((Map)this.LjP).put(Integer.valueOf(localViewParent.hashCode()), null);
        if (localViewParent == null)
        {
          paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(200595);
          throw paramView;
        }
        ((ViewGroup)localViewParent).removeView(paramView);
        ad.i("Finder.VideoRecycler", "[removeViewFromParent] parent=" + localViewParent.hashCode() + ", videoView=" + paramView.hashCode() + ", parentTag=" + ((ViewGroup)localViewParent).getTag());
        AppMethodBeat.o(200595);
        return true;
      }
    }
    AppMethodBeat.o(200595);
    return false;
  }
  
  private final void lC(final Context paramContext)
  {
    AppMethodBeat.i(200592);
    if (Build.VERSION.SDK_INT >= 23)
    {
      Looper localLooper = Looper.getMainLooper();
      k.g(localLooper, "Looper.getMainLooper()");
      localLooper.getQueue().addIdleHandler((MessageQueue.IdleHandler)new l(this, paramContext));
    }
    AppMethodBeat.o(200592);
  }
  
  private final void onFinish()
  {
    AppMethodBeat.i(200591);
    this.LjV.dead();
    this.gAC.postAtFrontOfQueue((Runnable)new h(this));
    this.LjR.clear();
    this.LjQ.clear();
    AppMethodBeat.o(200591);
  }
  
  final void I(d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, Boolean> paramb)
  {
    AppMethodBeat.i(200600);
    Iterator localIterator = this.LjO.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)((WeakReference)localIterator.next()).get();
      if (localo != null)
      {
        if (((Boolean)paramb.aA(localo)).booleanValue()) {
          localIterator.remove();
        }
      }
      else {
        localIterator.remove();
      }
    }
    AppMethodBeat.o(200600);
  }
  
  public final void J(final d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, Boolean> paramb)
  {
    AppMethodBeat.i(200605);
    k.h(paramb, "filter");
    com.tencent.mm.ad.c.g((a)new j(this, paramb));
    AppMethodBeat.o(200605);
  }
  
  public final void a(final ViewGroup paramViewGroup, final com.tencent.mm.plugin.finder.loader.l paraml, final d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, y> paramb)
  {
    AppMethodBeat.i(200596);
    k.h(paramViewGroup, "parent");
    k.h(paraml, "finderVideo");
    k.h(paramb, "completedTo");
    final Context localContext = paramViewGroup.getContext();
    Object localObject = paraml.qCj;
    final String str = paraml.aaX();
    paraml = i.qTa;
    final boolean bool = i.c((bmd)localObject);
    localObject = paramViewGroup.findViewWithTag(Integer.valueOf(paramViewGroup.hashCode()));
    paraml = (com.tencent.mm.plugin.finder.loader.l)localObject;
    if (!(localObject instanceof com.tencent.mm.plugin.finder.video.o)) {
      paraml = null;
    }
    paraml = (com.tencent.mm.plugin.finder.video.o)paraml;
    if ((paraml != null) && ((paraml.getVideoMediaId() == null) || (k.g(paraml.getVideoMediaId(), str))))
    {
      paraml.setTag(2131307372, Long.valueOf(SystemClock.uptimeMillis()));
      paramb.aA(paraml);
      AppMethodBeat.o(200596);
      return;
    }
    if (paraml != null) {}
    for (paraml = paraml.getVideoView();; paraml = null)
    {
      gR(paraml);
      if (!this.LjK) {
        break label280;
      }
      paraml = (String)this.LjP.get(Integer.valueOf(paramViewGroup.hashCode()));
      if (!k.g(paraml, str)) {
        break;
      }
      AppMethodBeat.o(200596);
      return;
    }
    label280:
    label304:
    final FinderVideoRecycler localFinderVideoRecycler;
    com.tencent.mm.plugin.finder.video.o localo;
    if (paraml != null)
    {
      ((Map)this.LjP).put(Integer.valueOf(paramViewGroup.hashCode()), str);
      ad.i("Finder.VideoRecycler", "replace callback. " + paraml + " => " + str + ", parent=" + paramViewGroup.hashCode());
      localObject = (d.g.a.b)new f(this, paramViewGroup, paramb);
      if (!bool) {
        break label658;
      }
      paraml = FinderCropVideoView.class;
      paramb = (com.tencent.mm.plugin.finder.video.o)com.tencent.mm.ad.c.a(this.LjN, (d.g.a.b)new e(localContext, paraml));
      if (paramb != null)
      {
        ad.i("Finder.VideoRecycler", "[getOrCreate] get a recycled videoView(" + paramb.hashCode() + ") parent=" + paramViewGroup.hashCode() + " videoCount=" + a(this));
        ((d.g.a.b)localObject).aA(paramb);
        if (paramb != null) {}
      }
      else
      {
        localFinderVideoRecycler = (FinderVideoRecycler)this;
        int i = localFinderVideoRecycler.bD(paraml);
        if (i < localFinderVideoRecycler.LjL) {
          break label743;
        }
        localo = localFinderVideoRecycler.d(paraml, localFinderVideoRecycler.LjK);
        StringBuilder localStringBuilder = new StringBuilder("[getOrCreate] over count(max=").append(localFinderVideoRecycler.LjL).append(':').append(i).append(") waitForRelease=").append(localFinderVideoRecycler.LjK).append(" oldest=");
        if (localo == null) {
          break label665;
        }
        paramb = Integer.valueOf(localo.hashCode());
        label498:
        ad.i("Finder.VideoRecycler", paramb);
        if (!localFinderVideoRecycler.LjK) {
          break label699;
        }
        if (localo == null) {
          break label670;
        }
        i = paramViewGroup.hashCode();
        ((Map)localFinderVideoRecycler.LjP).put(Integer.valueOf(i), str);
        ((Map)localFinderVideoRecycler.LjQ).put(Integer.valueOf(localo.hashCode()), new d(i, localFinderVideoRecycler, paraml, paramViewGroup, str, (d.g.a.b)localObject, localContext, bool));
        localFinderVideoRecycler.a(localo, "getOrCreate", true);
      }
    }
    for (;;)
    {
      paramViewGroup = y.JfV;
      AppMethodBeat.o(200596);
      return;
      ad.i("Finder.VideoRecycler", "wait for callback. mediaId=" + str + " parent=" + paramViewGroup.hashCode());
      break;
      label658:
      paraml = FinderVLogCompositionPlayView.class;
      break label304;
      label665:
      paramb = null;
      break label498;
      label670:
      ad.e("Finder.VideoRecycler", "[getOrCreate] oldest is null! parent=" + paramViewGroup.hashCode());
      continue;
      label699:
      if (localo != null) {
        localFinderVideoRecycler.a(localo, "getOrCreate", true);
      }
      k.g(localContext, "context");
      ((d.g.a.b)localObject).aA(localFinderVideoRecycler.I(localContext, bool));
      continue;
      label743:
      k.g(localContext, "context");
      ((d.g.a.b)localObject).aA(localFinderVideoRecycler.I(localContext, bool));
    }
  }
  
  public final void ae()
  {
    AppMethodBeat.i(200603);
    ad.i("Finder.VideoRecycler", "[onCleared] videoCount=" + a(this));
    onFinish();
    AppMethodBeat.o(200603);
  }
  
  public final void d(final MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(200589);
    k.h(paramMMActivity, "activity");
    final String str = String.valueOf(paramMMActivity.hashCode());
    if (this.LjT == 0) {
      Ca();
    }
    if (this.LjR.add(str))
    {
      ad.i("Finder.VideoRecycler", "[register] activity=" + paramMMActivity.getClass().getSimpleName() + " isPreInflate=" + paramBoolean);
      if (paramBoolean) {
        lC((Context)paramMMActivity);
      }
      this.LjT += 1;
      paramMMActivity.getLifecycle().addObserver((LifecycleObserver)new LifecycleObserver()
      {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy()
        {
          AppMethodBeat.i(200572);
          FinderVideoRecycler localFinderVideoRecycler = this.Lki;
          FinderVideoRecycler.a(localFinderVideoRecycler, FinderVideoRecycler.b(localFinderVideoRecycler) - 1);
          if (FinderVideoRecycler.b(this.Lki) == 0) {
            FinderVideoRecycler.c(this.Lki);
          }
          for (;;)
          {
            FinderVideoRecycler.d(this.Lki).remove(str);
            paramMMActivity.getLifecycle().removeObserver((LifecycleObserver)this);
            AppMethodBeat.o(200572);
            return;
            localFinderVideoRecycler = this.Lki;
            Context localContext = (Context)paramMMActivity;
            k.h(localContext, "context");
            j.a((Iterable)localFinderVideoRecycler.LjN, (d.g.a.b)new FinderVideoRecycler.o(localContext));
            v.c localc = new v.c();
            localc.Jhu = 0;
            localFinderVideoRecycler.I((d.g.a.b)new FinderVideoRecycler.p(localFinderVideoRecycler, localContext, localc));
            ad.i("Finder.VideoRecycler", "[removeByContext] simpleName=" + localContext.getClass().getSimpleName() + " removeCount=" + localc.Jhu + " videoCount=" + FinderVideoRecycler.a(localFinderVideoRecycler));
          }
        }
      });
    }
    AppMethodBeat.o(200589);
  }
  
  public final void lD(final Context paramContext)
  {
    AppMethodBeat.i(200604);
    com.tencent.mm.ad.c.g((a)new k(this, paramContext));
    AppMethodBeat.o(200604);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "", "onRecycled", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract boolean a(com.tencent.mm.plugin.finder.video.o paramo);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    c(Class paramClass, v.d paramd, int[] paramArrayOfInt, boolean paramBoolean, v.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$getOrCreate$3$1$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "onRecycled", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$$special$$inlined$let$lambda$1"})
  public static final class d
    implements FinderVideoRecycler.b
  {
    d(int paramInt, FinderVideoRecycler paramFinderVideoRecycler, Class paramClass, ViewGroup paramViewGroup, String paramString, d.g.a.b paramb, Context paramContext, boolean paramBoolean) {}
    
    public final boolean a(com.tencent.mm.plugin.finder.video.o paramo)
    {
      AppMethodBeat.i(200568);
      k.h(paramo, "videoView");
      if (k.g((String)FinderVideoRecycler.j(localFinderVideoRecycler).get(Integer.valueOf(this.Lkb)), str))
      {
        ad.i("Finder.VideoRecycler", "[getOrCreate] wait for callback successfully. mediaId=" + str + " parent=" + this.Lkb);
        this.Lkf.aA(paramo);
        AppMethodBeat.o(200568);
        return true;
      }
      ad.i("Finder.VideoRecycler", "wait for callback, but it(" + str + ") has been replace(" + (String)FinderVideoRecycler.j(localFinderVideoRecycler).get(Integer.valueOf(this.Lkb)) + "). key=" + this.Lkb);
      AppMethodBeat.o(200568);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    e(Context paramContext, Class paramClass)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, y>
  {
    f(FinderVideoRecycler paramFinderVideoRecycler, ViewGroup paramViewGroup, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    g(Class paramClass, v.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderVideoRecycler paramFinderVideoRecycler) {}
    
    public final void run()
    {
      AppMethodBeat.i(200573);
      Iterator localIterator = ((Iterable)FinderVideoRecycler.e(this.Lki)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)((WeakReference)localIterator.next()).get();
        if (localo != null) {
          localo.onUIDestroy();
        }
      }
      FinderVideoRecycler.e(this.Lki).clear();
      FinderVideoRecycler.f(this.Lki).clear();
      FinderVideoRecycler.g(this.Lki).quit();
      AppMethodBeat.o(200573);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<ng>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
    {
      a(String paramString, FinderVideoRecycler.i parami)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements a<y>
  {
    j(FinderVideoRecycler paramFinderVideoRecycler, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements a<y>
  {
    k(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "queueIdle"})
  static final class l
    implements MessageQueue.IdleHandler
  {
    l(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(200581);
      if ((FinderVideoRecycler.h(this.Lki) > 0) && (FinderVideoRecycler.i(this.Lki) < FinderVideoRecycler.h(this.Lki)))
      {
        FinderVideoRecycler.f(this.Lki).add(FinderVideoRecycler.a(this.Lki, paramContext));
        FinderVideoRecycler localFinderVideoRecycler = this.Lki;
        FinderVideoRecycler.b(localFinderVideoRecycler, FinderVideoRecycler.i(localFinderVideoRecycler) + 1);
        AppMethodBeat.o(200581);
        return true;
      }
      ad.i("Finder.VideoRecycler", "[preInflateVideoView] completed! preInflateCount=" + FinderVideoRecycler.i(this.Lki) + " targetCount=" + FinderVideoRecycler.h(this.Lki));
      AppMethodBeat.o(200581);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    m(com.tencent.mm.plugin.finder.video.o paramo)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements a<y>
  {
    n(FinderVideoRecycler paramFinderVideoRecycler, com.tencent.mm.plugin.finder.video.o paramo, boolean paramBoolean, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    o(Context paramContext)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    p(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext, v.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class q
    extends d.g.b.l
    implements a<y>
  {
    public q(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler
 * JD-Core Version:    0.7.0.1
 */