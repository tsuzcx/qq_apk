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
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.video.FinderCropVideoView;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.g.b.q;
import d.g.b.y.d;
import d.g.b.y.e;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "activityCount", "", "aliveActivitySet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "createdVideoViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "isFinished", "", "isForceWaitForRelease", "maxVideoCount", "onlineVideoEventListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1;", "preInflateCount", "preInflateVideoCount", "recycledVideoViews", "releasingVideoViewMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "waitForCallback", "waitRecycledCallbacks", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "acrossCreatedVideoViews", "", "isRemoveFun", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "createVideoView", "context", "Landroid/content/Context;", "isNormalVideoView", "findOldestVideoView", "clazz", "Ljava/lang/Class;", "isForce", "getOrCreate", "parent", "Landroid/view/ViewGroup;", "finderVideo", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "completedTo", "videoView", "getVideoCount", "make", "activity", "Lcom/tencent/mm/ui/MMActivity;", "isPreInflate", "onCleared", "onFinish", "onInit", "onPreloadComplete", "mediaId", "pauseAllVideo", "filter", "pauseAndRecycle", "isForceRemove", "isTryKeep", "pauseFocusVideo", "preInflateVideoView", "recycledVideoView", "releaseVideoView", "source", "removeByContext", "removeViewFromParent", "Landroid/view/View;", "resumeFocusVideo", "Companion", "IRecycledCallback", "plugin-finder_release"})
public final class FinderVideoRecycler
  extends UIComponentPlugin<PluginFinder>
{
  public static final FinderVideoRecycler.a tot;
  private boolean gJv;
  private final aq gKO;
  private boolean tog;
  private int toh;
  private int toi;
  final HashSet<com.tencent.mm.plugin.finder.video.o> toj;
  private final ConcurrentLinkedQueue<WeakReference<? extends com.tencent.mm.plugin.finder.video.o>> tok;
  public final HashMap<Integer, String> tol;
  private final HashMap<Integer, FinderVideoRecycler.b> tom;
  private final HashSet<String> ton;
  private int too;
  private int toq;
  private final HashMap<Integer, Object> tor;
  private final i tos;
  
  static
  {
    AppMethodBeat.i(206404);
    tot = new FinderVideoRecycler.a((byte)0);
    AppMethodBeat.o(206404);
  }
  
  public FinderVideoRecycler()
  {
    AppMethodBeat.i(206403);
    this.tog = true;
    this.toh = 1;
    this.gKO = new aq(Looper.getMainLooper());
    this.toj = new HashSet();
    this.tok = new ConcurrentLinkedQueue();
    this.tol = new HashMap();
    this.tom = new HashMap();
    this.ton = new HashSet();
    this.tor = new HashMap();
    this.tos = new i(this);
    AppMethodBeat.o(206403);
  }
  
  private final void Dg()
  {
    AppMethodBeat.i(206388);
    this.gJv = false;
    this.tos.alive();
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    localObject = com.tencent.mm.plugin.finder.storage.b.cHV();
    this.toh = ((Number)((d.o)localObject).first).intValue();
    this.tog = ((Boolean)((d.o)localObject).second).booleanValue();
    this.toi = d.k.j.lx(this.toh - 1, 4);
    ae.i("Finder.VideoRecycler", "[onInit] maxVideoCount=" + this.toh + " preInflateCount=" + this.toi + " waitForRelease=" + this.tog);
    AppMethodBeat.o(206388);
  }
  
  private int aN(Class<? extends com.tencent.mm.plugin.finder.video.o> paramClass)
  {
    AppMethodBeat.i(206398);
    y.d locald = new y.d();
    locald.NiW = 0;
    D((d.g.a.b)new FinderVideoRecycler.g(paramClass, locald));
    int i = locald.NiW;
    AppMethodBeat.o(206398);
    return i;
  }
  
  private final com.tencent.mm.plugin.finder.video.o d(final Class<? extends com.tencent.mm.plugin.finder.video.o> paramClass, final boolean paramBoolean)
  {
    Object localObject1 = null;
    AppMethodBeat.i(206395);
    Object localObject2 = new y.e();
    ((y.e)localObject2).NiX = 9223372036854775807L;
    final y.f localf = new y.f();
    localf.NiY = null;
    D((d.g.a.b)new c(this, paramClass, (y.e)localObject2, new int[2], paramBoolean, localf));
    localObject2 = new StringBuilder("[findOldestVideoView] activity=");
    paramClass = (com.tencent.mm.plugin.finder.video.o)localf.NiY;
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
            paramClass = (com.tencent.mm.plugin.finder.video.o)localf.NiY;
            if (paramClass == null) {
              break label302;
            }
            paramClass = Integer.valueOf(paramClass.hashCode());
            label158:
            localObject2 = ((StringBuilder)localObject2).append(paramClass).append(' ').append("isAttachedToWindow=");
            paramClass = (com.tencent.mm.plugin.finder.video.o)localf.NiY;
            if (paramClass == null) {
              break label307;
            }
            paramClass = paramClass.getVideoView();
            if (paramClass == null) {
              break label307;
            }
          }
        }
      }
    }
    label302:
    label307:
    for (paramClass = Boolean.valueOf(paramClass.isAttachedToWindow());; paramClass = null)
    {
      localObject2 = ((StringBuilder)localObject2).append(paramClass).append(" parent=");
      Object localObject3 = (com.tencent.mm.plugin.finder.video.o)localf.NiY;
      paramClass = localObject1;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.video.o)localObject3).getParentView();
        paramClass = localObject1;
        if (localObject3 != null) {
          paramClass = Integer.valueOf(localObject3.hashCode());
        }
      }
      ae.i("Finder.VideoRecycler", paramClass);
      paramClass = (com.tencent.mm.plugin.finder.video.o)localf.NiY;
      AppMethodBeat.o(206395);
      return paramClass;
      paramClass = null;
      break;
      paramClass = null;
      break label158;
    }
  }
  
  private final boolean em(View paramView)
  {
    AppMethodBeat.i(206393);
    if (paramView != null)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null)
      {
        ((Map)this.tol).put(Integer.valueOf(localViewParent.hashCode()), null);
        if (localViewParent == null)
        {
          paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(206393);
          throw paramView;
        }
        ((ViewGroup)localViewParent).removeView(paramView);
        ae.i("Finder.VideoRecycler", "[removeViewFromParent] parent=" + localViewParent.hashCode() + ", videoView=" + paramView.hashCode() + ", parentTag=" + ((ViewGroup)localViewParent).getTag());
        AppMethodBeat.o(206393);
        return true;
      }
    }
    AppMethodBeat.o(206393);
    return false;
  }
  
  private final void fd(final Context paramContext)
  {
    AppMethodBeat.i(206390);
    if (Build.VERSION.SDK_INT >= 23)
    {
      Looper localLooper = Looper.getMainLooper();
      d.g.b.p.g(localLooper, "Looper.getMainLooper()");
      localLooper.getQueue().addIdleHandler((MessageQueue.IdleHandler)new l(this, paramContext));
    }
    AppMethodBeat.o(206390);
  }
  
  private final void onFinish()
  {
    AppMethodBeat.i(206389);
    this.gJv = true;
    this.tos.dead();
    this.gKO.postAtFrontOfQueue((Runnable)new h(this));
    this.ton.clear();
    this.tom.clear();
    AppMethodBeat.o(206389);
  }
  
  private final com.tencent.mm.plugin.finder.video.o y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(206391);
    Object localObject;
    if (paramBoolean)
    {
      localObject = g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
      d.g.b.p.g(localObject, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
      if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject).isOpenTPPlayer()) {
        localObject = (com.tencent.mm.plugin.finder.video.o)new FinderThumbPlayerProxy(paramContext);
      }
    }
    for (;;)
    {
      this.tok.add(new WeakReference(localObject));
      ae.i("Finder.VideoRecycler", "[createVideoView] activity=" + paramContext.getClass().getSimpleName() + " videoCount=" + a(this));
      AppMethodBeat.o(206391);
      return localObject;
      localObject = (com.tencent.mm.plugin.finder.video.o)new FinderCropVideoView(paramContext);
      continue;
      localObject = (com.tencent.mm.plugin.finder.video.o)new FinderVLogCompositionPlayView(paramContext);
    }
  }
  
  final void D(d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, Boolean> paramb)
  {
    AppMethodBeat.i(206397);
    Iterator localIterator = this.tok.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)((WeakReference)localIterator.next()).get();
      if (localo != null)
      {
        if (((Boolean)paramb.invoke(localo)).booleanValue()) {
          localIterator.remove();
        }
      }
      else {
        localIterator.remove();
      }
    }
    AppMethodBeat.o(206397);
  }
  
  public final void E(final d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, Boolean> paramb)
  {
    AppMethodBeat.i(206402);
    d.g.b.p.h(paramb, "filter");
    com.tencent.mm.ac.c.h((d.g.a.a)new j(this, paramb));
    AppMethodBeat.o(206402);
  }
  
  public final void a(final ViewGroup paramViewGroup, m paramm, final d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, z> paramb)
  {
    AppMethodBeat.i(206394);
    d.g.b.p.h(paramViewGroup, "parent");
    d.g.b.p.h(paramm, "finderVideo");
    d.g.b.p.h(paramb, "completedTo");
    Context localContext = paramViewGroup.getContext();
    Object localObject = paramm.srx;
    String str = paramm.aeM();
    paramm = com.tencent.mm.plugin.finder.utils.p.sXz;
    boolean bool = com.tencent.mm.plugin.finder.utils.p.d((bvz)localObject);
    localObject = paramViewGroup.findViewWithTag(Integer.valueOf(paramViewGroup.hashCode()));
    paramm = (m)localObject;
    if (!(localObject instanceof com.tencent.mm.plugin.finder.video.o)) {
      paramm = null;
    }
    paramm = (com.tencent.mm.plugin.finder.video.o)paramm;
    if ((paramm != null) && ((paramm.getVideoMediaId() == null) || (d.g.b.p.i(paramm.getVideoMediaId(), str))))
    {
      paramm.setTag(2131307441, Long.valueOf(SystemClock.uptimeMillis()));
      paramb.invoke(paramm);
      AppMethodBeat.o(206394);
      return;
    }
    if (paramm != null) {}
    for (paramm = paramm.getVideoView();; paramm = null)
    {
      em(paramm);
      if (!this.tog) {
        break label280;
      }
      paramm = (String)this.tol.get(Integer.valueOf(paramViewGroup.hashCode()));
      if (!d.g.b.p.i(paramm, str)) {
        break;
      }
      AppMethodBeat.o(206394);
      return;
    }
    label280:
    label330:
    FinderVideoRecycler localFinderVideoRecycler;
    com.tencent.mm.plugin.finder.video.o localo;
    if (paramm != null)
    {
      ((Map)this.tol).put(Integer.valueOf(paramViewGroup.hashCode()), str);
      ae.i("Finder.VideoRecycler", "replace callback. " + paramm + " => " + str + ", parent=" + paramViewGroup.hashCode());
      localObject = (d.g.a.b)new f(this, paramViewGroup, paramb);
      if (!bool) {
        break label690;
      }
      paramm = g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
      d.g.b.p.g(paramm, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
      if (!((com.tencent.mm.plugin.thumbplayer.a.a)paramm).isOpenTPPlayer()) {
        break label683;
      }
      paramm = FinderThumbPlayerProxy.class;
      paramb = (com.tencent.mm.plugin.finder.video.o)com.tencent.mm.ac.c.a(this.toj, (d.g.a.b)new FinderVideoRecycler.e(localContext, paramm));
      if (paramb != null)
      {
        ae.i("Finder.VideoRecycler", "[getOrCreate] get a recycled videoView(" + paramb.hashCode() + ") parent=" + paramViewGroup.hashCode() + " videoCount=" + a(this));
        ((d.g.a.b)localObject).invoke(paramb);
        if (paramb != null) {}
      }
      else
      {
        localFinderVideoRecycler = (FinderVideoRecycler)this;
        int i = localFinderVideoRecycler.aN(paramm);
        if (i < localFinderVideoRecycler.toh) {
          break label774;
        }
        localo = localFinderVideoRecycler.d(paramm, localFinderVideoRecycler.tog);
        StringBuilder localStringBuilder = new StringBuilder("[getOrCreate] over count(max=").append(localFinderVideoRecycler.toh).append(':').append(i).append(") waitForRelease=").append(localFinderVideoRecycler.tog).append(" oldest=");
        if (localo == null) {
          break label697;
        }
        paramb = Integer.valueOf(localo.hashCode());
        label524:
        ae.i("Finder.VideoRecycler", paramb);
        if (!localFinderVideoRecycler.tog) {
          break label731;
        }
        if (localo == null) {
          break label702;
        }
        i = paramViewGroup.hashCode();
        ((Map)localFinderVideoRecycler.tol).put(Integer.valueOf(i), str);
        ((Map)localFinderVideoRecycler.tom).put(Integer.valueOf(localo.hashCode()), new FinderVideoRecycler.d(i, localFinderVideoRecycler, paramm, paramViewGroup, str, (d.g.a.b)localObject, localContext, bool));
        localFinderVideoRecycler.a(localo, "getOrCreate");
      }
    }
    for (;;)
    {
      paramViewGroup = z.Nhr;
      AppMethodBeat.o(206394);
      return;
      ae.i("Finder.VideoRecycler", "wait for callback. mediaId=" + str + " parent=" + paramViewGroup.hashCode());
      break;
      label683:
      paramm = FinderCropVideoView.class;
      break label330;
      label690:
      paramm = FinderVLogCompositionPlayView.class;
      break label330;
      label697:
      paramb = null;
      break label524;
      label702:
      ae.e("Finder.VideoRecycler", "[getOrCreate] oldest is null! parent=" + paramViewGroup.hashCode());
      continue;
      label731:
      if (localo != null) {
        localFinderVideoRecycler.a(localo, "getOrCreate");
      }
      d.g.b.p.g(localContext, "context");
      ((d.g.a.b)localObject).invoke(localFinderVideoRecycler.y(localContext, bool));
      continue;
      label774:
      d.g.b.p.g(localContext, "context");
      ((d.g.a.b)localObject).invoke(localFinderVideoRecycler.y(localContext, bool));
    }
  }
  
  public final void a(final com.tencent.mm.plugin.finder.video.o paramo, String paramString)
  {
    AppMethodBeat.i(206396);
    if (this.tor.containsKey(Integer.valueOf(paramo.hashCode())))
    {
      ae.w("Finder.VideoRecycler", "[releaseVideoView] videoView=" + paramo.hashCode() + " is releasing, source=" + paramString);
      AppMethodBeat.o(206396);
      return;
    }
    final long l = System.currentTimeMillis();
    ((Map)this.tor).put(Integer.valueOf(paramo.hashCode()), new Object());
    em(paramo.getVideoView());
    paramo.pause();
    StringBuilder localStringBuilder = new StringBuilder("[releaseVideoView] async release videoView(").append(paramo.hashCode()).append(") parent=");
    ViewParent localViewParent = paramo.getParentView();
    if (localViewParent != null) {}
    for (int i = localViewParent.hashCode();; i = 0)
    {
      ae.i("Finder.VideoRecycler", i + " source=" + paramString);
      com.tencent.mm.ac.c.b(null, (d.g.a.a)new n(this, paramo, l, paramString));
      AppMethodBeat.o(206396);
      return;
    }
  }
  
  public final void af()
  {
    AppMethodBeat.i(206400);
    ae.i("Finder.VideoRecycler", "[onCleared] videoCount=" + a(this));
    onFinish();
    AppMethodBeat.o(206400);
  }
  
  public final void akm(String paramString)
  {
    AppMethodBeat.i(206387);
    d.g.b.p.h(paramString, "mediaId");
    Iterator localIterator = ((Iterable)this.tok).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)((WeakReference)localIterator.next()).get();
      if (localo != null)
      {
        String str = localo.getVideoMediaId();
        if (str != null)
        {
          ae.d("Finder.VideoRecycler", "onPreloadComplete " + str + ' ' + paramString);
          if (d.g.b.p.i(str, paramString)) {
            localo.cOA();
          }
        }
      }
    }
    AppMethodBeat.o(206387);
  }
  
  public final void b(final MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(206386);
    d.g.b.p.h(paramMMActivity, "activity");
    final String str = String.valueOf(paramMMActivity.hashCode());
    if (this.toq == 0) {
      Dg();
    }
    if (this.ton.add(str))
    {
      ae.i("Finder.VideoRecycler", "[register] activity=" + paramMMActivity.getClass().getSimpleName() + " isPreInflate=" + paramBoolean);
      if (paramBoolean) {
        fd((Context)paramMMActivity);
      }
      this.toq += 1;
      paramMMActivity.getLifecycle().addObserver((LifecycleObserver)new LifecycleObserver()
      {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy()
        {
          AppMethodBeat.i(206367);
          FinderVideoRecycler localFinderVideoRecycler = this.tou;
          FinderVideoRecycler.a(localFinderVideoRecycler, FinderVideoRecycler.b(localFinderVideoRecycler) - 1);
          if (FinderVideoRecycler.b(this.tou) == 0) {
            FinderVideoRecycler.c(this.tou);
          }
          for (;;)
          {
            FinderVideoRecycler.d(this.tou).remove(str);
            paramMMActivity.getLifecycle().removeObserver((LifecycleObserver)this);
            AppMethodBeat.o(206367);
            return;
            localFinderVideoRecycler = this.tou;
            Context localContext = (Context)paramMMActivity;
            d.g.b.p.h(localContext, "context");
            d.a.j.a((Iterable)localFinderVideoRecycler.toj, (d.g.a.b)new FinderVideoRecycler.o(localContext));
            y.d locald = new y.d();
            locald.NiW = 0;
            localFinderVideoRecycler.D((d.g.a.b)new FinderVideoRecycler.p(localFinderVideoRecycler, localContext, locald));
            ae.i("Finder.VideoRecycler", "[removeByContext] simpleName=" + localContext.getClass().getSimpleName() + " removeCount=" + locald.NiW + " videoCount=" + FinderVideoRecycler.a(localFinderVideoRecycler));
          }
        }
      });
    }
    AppMethodBeat.o(206386);
  }
  
  public final void fe(final Context paramContext)
  {
    AppMethodBeat.i(206401);
    com.tencent.mm.ac.c.h((d.g.a.a)new k(this, paramContext));
    AppMethodBeat.o(206401);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    c(FinderVideoRecycler paramFinderVideoRecycler, Class paramClass, y.e parame, int[] paramArrayOfInt, boolean paramBoolean, y.f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, z>
  {
    f(FinderVideoRecycler paramFinderVideoRecycler, ViewGroup paramViewGroup, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderVideoRecycler paramFinderVideoRecycler) {}
    
    public final void run()
    {
      AppMethodBeat.i(206368);
      Iterator localIterator = ((Iterable)FinderVideoRecycler.e(this.tou)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)((WeakReference)localIterator.next()).get();
        if (localo != null)
        {
          localo.onUIDestroy();
          localo.onRelease();
        }
      }
      FinderVideoRecycler.e(this.tou).clear();
      FinderVideoRecycler.f(this.tou).clear();
      FinderVideoRecycler.g(this.tou).removeCallbacksAndMessages(null);
      AppMethodBeat.o(206368);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<ny>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1$callback$1$1"})
    static final class a
      extends q
      implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
    {
      a(String paramString, FinderVideoRecycler.i parami)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<z>
  {
    j(FinderVideoRecycler paramFinderVideoRecycler, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<z>
  {
    k(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "queueIdle"})
  static final class l
    implements MessageQueue.IdleHandler
  {
    l(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(206376);
      if ((FinderVideoRecycler.h(this.tou) > 0) && (FinderVideoRecycler.i(this.tou) < FinderVideoRecycler.h(this.tou)) && (!FinderVideoRecycler.j(this.tou)))
      {
        FinderVideoRecycler.f(this.tou).add(FinderVideoRecycler.a(this.tou, paramContext));
        FinderVideoRecycler localFinderVideoRecycler = this.tou;
        FinderVideoRecycler.b(localFinderVideoRecycler, FinderVideoRecycler.i(localFinderVideoRecycler) + 1);
        AppMethodBeat.o(206376);
        return true;
      }
      ae.i("Finder.VideoRecycler", "[preInflateVideoView] completed! preInflateCount=" + FinderVideoRecycler.i(this.tou) + " targetCount=" + FinderVideoRecycler.h(this.tou) + " isFinished=" + FinderVideoRecycler.j(this.tou));
      AppMethodBeat.o(206376);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements d.g.a.a<z>
  {
    n(FinderVideoRecycler paramFinderVideoRecycler, com.tencent.mm.plugin.finder.video.o paramo, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class q
    extends q
    implements d.g.a.a<z>
  {
    public q(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler
 * JD-Core Version:    0.7.0.1
 */