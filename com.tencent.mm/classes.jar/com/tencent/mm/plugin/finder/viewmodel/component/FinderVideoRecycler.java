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
import com.tencent.mm.g.a.nx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.video.FinderCropVideoView;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.a.j;
import d.g.b.q;
import d.g.b.y.d;
import d.g.b.y.e;
import d.g.b.y.f;
import d.k.h;
import d.l;
import d.v;
import d.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "activityCount", "", "aliveActivitySet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "createdVideoViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "isFinished", "", "isForceWaitForRelease", "maxVideoCount", "onlineVideoEventListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1;", "preInflateCount", "preInflateVideoCount", "recycledVideoViews", "releasingVideoViewMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "waitForCallback", "waitRecycledCallbacks", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "acrossCreatedVideoViews", "", "isRemoveFun", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "createVideoView", "context", "Landroid/content/Context;", "isNormalVideoView", "findOldestVideoView", "clazz", "Ljava/lang/Class;", "isForce", "getOrCreate", "parent", "Landroid/view/ViewGroup;", "finderVideo", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "completedTo", "videoView", "getVideoCount", "make", "activity", "Lcom/tencent/mm/ui/MMActivity;", "isPreInflate", "onCleared", "onFinish", "onInit", "onPreloadComplete", "mediaId", "pauseAllVideo", "filter", "pauseAndRecycle", "isForceRemove", "isTryKeep", "pauseFocusVideo", "preInflateVideoView", "recycledVideoView", "releaseVideoView", "source", "removeByContext", "removeViewFromParent", "Landroid/view/View;", "resumeFocusVideo", "Companion", "IRecycledCallback", "plugin-finder_release"})
public final class FinderVideoRecycler
  extends UIComponentPlugin<PluginFinder>
{
  public static final a tdA;
  private boolean gGM;
  private final ap gIf;
  private boolean tdo;
  private int tdp;
  private int tdq;
  final HashSet<com.tencent.mm.plugin.finder.video.o> tdr;
  private final ConcurrentLinkedQueue<WeakReference<? extends com.tencent.mm.plugin.finder.video.o>> tds;
  public final HashMap<Integer, String> tdt;
  private final HashMap<Integer, b> tdu;
  private final HashSet<String> tdv;
  private int tdw;
  private int tdx;
  private final HashMap<Integer, Object> tdy;
  private final i tdz;
  
  static
  {
    AppMethodBeat.i(205790);
    tdA = new a((byte)0);
    AppMethodBeat.o(205790);
  }
  
  public FinderVideoRecycler()
  {
    AppMethodBeat.i(205789);
    this.tdo = true;
    this.tdp = 1;
    this.gIf = new ap(Looper.getMainLooper());
    this.tdr = new HashSet();
    this.tds = new ConcurrentLinkedQueue();
    this.tdt = new HashMap();
    this.tdu = new HashMap();
    this.tdv = new HashSet();
    this.tdy = new HashMap();
    this.tdz = new i(this);
    AppMethodBeat.o(205789);
  }
  
  private final void Dd()
  {
    AppMethodBeat.i(205774);
    this.gGM = false;
    this.tdz.alive();
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject = com.tencent.mm.plugin.finder.storage.b.cFY();
    this.tdp = ((Number)((d.o)localObject).first).intValue();
    this.tdo = ((Boolean)((d.o)localObject).second).booleanValue();
    this.tdq = h.lq(this.tdp - 1, 4);
    ad.i("Finder.VideoRecycler", "[onInit] maxVideoCount=" + this.tdp + " preInflateCount=" + this.tdq + " waitForRelease=" + this.tdo);
    AppMethodBeat.o(205774);
  }
  
  private int aN(Class<? extends com.tencent.mm.plugin.finder.video.o> paramClass)
  {
    AppMethodBeat.i(205784);
    final y.d locald = new y.d();
    locald.MLT = 0;
    C((d.g.a.b)new g(paramClass, locald));
    int i = locald.MLT;
    AppMethodBeat.o(205784);
    return i;
  }
  
  private final com.tencent.mm.plugin.finder.video.o d(final Class<? extends com.tencent.mm.plugin.finder.video.o> paramClass, final boolean paramBoolean)
  {
    Object localObject1 = null;
    AppMethodBeat.i(205781);
    Object localObject2 = new y.e();
    ((y.e)localObject2).MLU = 9223372036854775807L;
    final y.f localf = new y.f();
    localf.MLV = null;
    C((d.g.a.b)new c(this, paramClass, (y.e)localObject2, new int[2], paramBoolean, localf));
    localObject2 = new StringBuilder("[findOldestVideoView] activity=");
    paramClass = (com.tencent.mm.plugin.finder.video.o)localf.MLV;
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
            paramClass = (com.tencent.mm.plugin.finder.video.o)localf.MLV;
            if (paramClass == null) {
              break label302;
            }
            paramClass = Integer.valueOf(paramClass.hashCode());
            label158:
            localObject2 = ((StringBuilder)localObject2).append(paramClass).append(' ').append("isAttachedToWindow=");
            paramClass = (com.tencent.mm.plugin.finder.video.o)localf.MLV;
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
      Object localObject3 = (com.tencent.mm.plugin.finder.video.o)localf.MLV;
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
      paramClass = (com.tencent.mm.plugin.finder.video.o)localf.MLV;
      AppMethodBeat.o(205781);
      return paramClass;
      paramClass = null;
      break;
      paramClass = null;
      break label158;
    }
  }
  
  private final void eZ(final Context paramContext)
  {
    AppMethodBeat.i(205776);
    if (Build.VERSION.SDK_INT >= 23)
    {
      Looper localLooper = Looper.getMainLooper();
      d.g.b.p.g(localLooper, "Looper.getMainLooper()");
      localLooper.getQueue().addIdleHandler((MessageQueue.IdleHandler)new l(this, paramContext));
    }
    AppMethodBeat.o(205776);
  }
  
  private final boolean em(View paramView)
  {
    AppMethodBeat.i(205779);
    if (paramView != null)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null)
      {
        ((Map)this.tdt).put(Integer.valueOf(localViewParent.hashCode()), null);
        if (localViewParent == null)
        {
          paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(205779);
          throw paramView;
        }
        ((ViewGroup)localViewParent).removeView(paramView);
        ad.i("Finder.VideoRecycler", "[removeViewFromParent] parent=" + localViewParent.hashCode() + ", videoView=" + paramView.hashCode() + ", parentTag=" + ((ViewGroup)localViewParent).getTag());
        AppMethodBeat.o(205779);
        return true;
      }
    }
    AppMethodBeat.o(205779);
    return false;
  }
  
  private final void onFinish()
  {
    AppMethodBeat.i(205775);
    this.gGM = true;
    this.tdz.dead();
    this.gIf.postAtFrontOfQueue((Runnable)new h(this));
    this.tdv.clear();
    this.tdu.clear();
    AppMethodBeat.o(205775);
  }
  
  private final com.tencent.mm.plugin.finder.video.o y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(205777);
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
      this.tds.add(new WeakReference(localObject));
      ad.i("Finder.VideoRecycler", "[createVideoView] activity=" + paramContext.getClass().getSimpleName() + " videoCount=" + a(this));
      AppMethodBeat.o(205777);
      return localObject;
      localObject = (com.tencent.mm.plugin.finder.video.o)new FinderCropVideoView(paramContext);
      continue;
      localObject = (com.tencent.mm.plugin.finder.video.o)new FinderVLogCompositionPlayView(paramContext);
    }
  }
  
  final void C(d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, Boolean> paramb)
  {
    AppMethodBeat.i(205783);
    Iterator localIterator = this.tds.iterator();
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
    AppMethodBeat.o(205783);
  }
  
  public final void D(final d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, Boolean> paramb)
  {
    AppMethodBeat.i(205788);
    d.g.b.p.h(paramb, "filter");
    com.tencent.mm.ad.c.g((d.g.a.a)new j(this, paramb));
    AppMethodBeat.o(205788);
  }
  
  public final void a(final ViewGroup paramViewGroup, final m paramm, final d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, z> paramb)
  {
    AppMethodBeat.i(205780);
    d.g.b.p.h(paramViewGroup, "parent");
    d.g.b.p.h(paramm, "finderVideo");
    d.g.b.p.h(paramb, "completedTo");
    final Context localContext = paramViewGroup.getContext();
    Object localObject = paramm.siC;
    final String str = paramm.aeA();
    paramm = com.tencent.mm.plugin.finder.utils.p.sMo;
    final boolean bool = com.tencent.mm.plugin.finder.utils.p.d((bvf)localObject);
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
      AppMethodBeat.o(205780);
      return;
    }
    if (paramm != null) {}
    for (paramm = paramm.getVideoView();; paramm = null)
    {
      em(paramm);
      if (!this.tdo) {
        break label280;
      }
      paramm = (String)this.tdt.get(Integer.valueOf(paramViewGroup.hashCode()));
      if (!d.g.b.p.i(paramm, str)) {
        break;
      }
      AppMethodBeat.o(205780);
      return;
    }
    label280:
    label330:
    final FinderVideoRecycler localFinderVideoRecycler;
    com.tencent.mm.plugin.finder.video.o localo;
    if (paramm != null)
    {
      ((Map)this.tdt).put(Integer.valueOf(paramViewGroup.hashCode()), str);
      ad.i("Finder.VideoRecycler", "replace callback. " + paramm + " => " + str + ", parent=" + paramViewGroup.hashCode());
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
      paramb = (com.tencent.mm.plugin.finder.video.o)com.tencent.mm.ad.c.a(this.tdr, (d.g.a.b)new e(localContext, paramm));
      if (paramb != null)
      {
        ad.i("Finder.VideoRecycler", "[getOrCreate] get a recycled videoView(" + paramb.hashCode() + ") parent=" + paramViewGroup.hashCode() + " videoCount=" + a(this));
        ((d.g.a.b)localObject).invoke(paramb);
        if (paramb != null) {}
      }
      else
      {
        localFinderVideoRecycler = (FinderVideoRecycler)this;
        int i = localFinderVideoRecycler.aN(paramm);
        if (i < localFinderVideoRecycler.tdp) {
          break label774;
        }
        localo = localFinderVideoRecycler.d(paramm, localFinderVideoRecycler.tdo);
        StringBuilder localStringBuilder = new StringBuilder("[getOrCreate] over count(max=").append(localFinderVideoRecycler.tdp).append(':').append(i).append(") waitForRelease=").append(localFinderVideoRecycler.tdo).append(" oldest=");
        if (localo == null) {
          break label697;
        }
        paramb = Integer.valueOf(localo.hashCode());
        label524:
        ad.i("Finder.VideoRecycler", paramb);
        if (!localFinderVideoRecycler.tdo) {
          break label731;
        }
        if (localo == null) {
          break label702;
        }
        i = paramViewGroup.hashCode();
        ((Map)localFinderVideoRecycler.tdt).put(Integer.valueOf(i), str);
        ((Map)localFinderVideoRecycler.tdu).put(Integer.valueOf(localo.hashCode()), new d(i, localFinderVideoRecycler, paramm, paramViewGroup, str, (d.g.a.b)localObject, localContext, bool));
        localFinderVideoRecycler.a(localo, "getOrCreate");
      }
    }
    for (;;)
    {
      paramViewGroup = z.MKo;
      AppMethodBeat.o(205780);
      return;
      ad.i("Finder.VideoRecycler", "wait for callback. mediaId=" + str + " parent=" + paramViewGroup.hashCode());
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
      ad.e("Finder.VideoRecycler", "[getOrCreate] oldest is null! parent=" + paramViewGroup.hashCode());
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
    AppMethodBeat.i(205782);
    if (this.tdy.containsKey(Integer.valueOf(paramo.hashCode())))
    {
      ad.w("Finder.VideoRecycler", "[releaseVideoView] videoView=" + paramo.hashCode() + " is releasing, source=" + paramString);
      AppMethodBeat.o(205782);
      return;
    }
    final long l = System.currentTimeMillis();
    ((Map)this.tdy).put(Integer.valueOf(paramo.hashCode()), new Object());
    em(paramo.getVideoView());
    paramo.pause();
    StringBuilder localStringBuilder = new StringBuilder("[releaseVideoView] async release videoView(").append(paramo.hashCode()).append(") parent=");
    ViewParent localViewParent = paramo.getParentView();
    if (localViewParent != null) {}
    for (int i = localViewParent.hashCode();; i = 0)
    {
      ad.i("Finder.VideoRecycler", i + " source=" + paramString);
      com.tencent.mm.ad.c.b(null, (d.g.a.a)new n(this, paramo, l, paramString));
      AppMethodBeat.o(205782);
      return;
    }
  }
  
  public final void af()
  {
    AppMethodBeat.i(205786);
    ad.i("Finder.VideoRecycler", "[onCleared] videoCount=" + a(this));
    onFinish();
    AppMethodBeat.o(205786);
  }
  
  public final void ajo(String paramString)
  {
    AppMethodBeat.i(205773);
    d.g.b.p.h(paramString, "mediaId");
    Iterator localIterator = ((Iterable)this.tds).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)((WeakReference)localIterator.next()).get();
      if (localo != null)
      {
        String str = localo.getVideoMediaId();
        if (str != null)
        {
          ad.d("Finder.VideoRecycler", "onPreloadComplete " + str + ' ' + paramString);
          if (d.g.b.p.i(str, paramString)) {
            localo.cLS();
          }
        }
      }
    }
    AppMethodBeat.o(205773);
  }
  
  public final void b(final MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(205772);
    d.g.b.p.h(paramMMActivity, "activity");
    final String str = String.valueOf(paramMMActivity.hashCode());
    if (this.tdx == 0) {
      Dd();
    }
    if (this.tdv.add(str))
    {
      ad.i("Finder.VideoRecycler", "[register] activity=" + paramMMActivity.getClass().getSimpleName() + " isPreInflate=" + paramBoolean);
      if (paramBoolean) {
        eZ((Context)paramMMActivity);
      }
      this.tdx += 1;
      paramMMActivity.getLifecycle().addObserver((LifecycleObserver)new LifecycleObserver()
      {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy()
        {
          AppMethodBeat.i(205753);
          FinderVideoRecycler localFinderVideoRecycler = this.tdB;
          FinderVideoRecycler.a(localFinderVideoRecycler, FinderVideoRecycler.b(localFinderVideoRecycler) - 1);
          if (FinderVideoRecycler.b(this.tdB) == 0) {
            FinderVideoRecycler.c(this.tdB);
          }
          for (;;)
          {
            FinderVideoRecycler.d(this.tdB).remove(str);
            paramMMActivity.getLifecycle().removeObserver((LifecycleObserver)this);
            AppMethodBeat.o(205753);
            return;
            localFinderVideoRecycler = this.tdB;
            Context localContext = (Context)paramMMActivity;
            d.g.b.p.h(localContext, "context");
            j.a((Iterable)localFinderVideoRecycler.tdr, (d.g.a.b)new FinderVideoRecycler.o(localContext));
            y.d locald = new y.d();
            locald.MLT = 0;
            localFinderVideoRecycler.C((d.g.a.b)new FinderVideoRecycler.p(localFinderVideoRecycler, localContext, locald));
            ad.i("Finder.VideoRecycler", "[removeByContext] simpleName=" + localContext.getClass().getSimpleName() + " removeCount=" + locald.MLT + " videoCount=" + FinderVideoRecycler.a(localFinderVideoRecycler));
          }
        }
      });
    }
    AppMethodBeat.o(205772);
  }
  
  public final void fa(final Context paramContext)
  {
    AppMethodBeat.i(205787);
    com.tencent.mm.ad.c.g((d.g.a.a)new k(this, paramContext));
    AppMethodBeat.o(205787);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "", "onRecycledCompleted", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract boolean a(com.tencent.mm.plugin.finder.video.o paramo);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    c(FinderVideoRecycler paramFinderVideoRecycler, Class paramClass, y.e parame, int[] paramArrayOfInt, boolean paramBoolean, y.f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$getOrCreate$3$1$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "onRecycledCompleted", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$$special$$inlined$let$lambda$1"})
  public static final class d
    implements FinderVideoRecycler.b
  {
    d(int paramInt, FinderVideoRecycler paramFinderVideoRecycler, Class paramClass, ViewGroup paramViewGroup, String paramString, d.g.a.b paramb, Context paramContext, boolean paramBoolean) {}
    
    public final boolean a(com.tencent.mm.plugin.finder.video.o paramo)
    {
      AppMethodBeat.i(205749);
      d.g.b.p.h(paramo, "videoView");
      if (d.g.b.p.i((String)FinderVideoRecycler.k(localFinderVideoRecycler).get(Integer.valueOf(this.tdG)), str))
      {
        ad.i("Finder.VideoRecycler", "[getOrCreate] wait for callback successfully. mediaId=" + str + " parent=" + this.tdG);
        this.tdK.invoke(paramo);
        AppMethodBeat.o(205749);
        return true;
      }
      ad.i("Finder.VideoRecycler", "wait for callback, but it(" + str + ") has been replace(" + (String)FinderVideoRecycler.k(localFinderVideoRecycler).get(Integer.valueOf(this.tdG)) + "). key=" + this.tdG);
      AppMethodBeat.o(205749);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    e(Context paramContext, Class paramClass)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, z>
  {
    f(FinderVideoRecycler paramFinderVideoRecycler, ViewGroup paramViewGroup, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    g(Class paramClass, y.d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderVideoRecycler paramFinderVideoRecycler) {}
    
    public final void run()
    {
      AppMethodBeat.i(205754);
      Iterator localIterator = ((Iterable)FinderVideoRecycler.e(this.tdB)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)((WeakReference)localIterator.next()).get();
        if (localo != null)
        {
          localo.onUIDestroy();
          localo.onRelease();
        }
      }
      FinderVideoRecycler.e(this.tdB).clear();
      FinderVideoRecycler.f(this.tdB).clear();
      FinderVideoRecycler.g(this.tdB).removeCallbacksAndMessages(null);
      AppMethodBeat.o(205754);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<nx>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1$callback$1$1"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<z>
  {
    j(FinderVideoRecycler paramFinderVideoRecycler, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<z>
  {
    k(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "queueIdle"})
  static final class l
    implements MessageQueue.IdleHandler
  {
    l(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(205762);
      if ((FinderVideoRecycler.h(this.tdB) > 0) && (FinderVideoRecycler.i(this.tdB) < FinderVideoRecycler.h(this.tdB)) && (!FinderVideoRecycler.j(this.tdB)))
      {
        FinderVideoRecycler.f(this.tdB).add(FinderVideoRecycler.a(this.tdB, paramContext));
        FinderVideoRecycler localFinderVideoRecycler = this.tdB;
        FinderVideoRecycler.b(localFinderVideoRecycler, FinderVideoRecycler.i(localFinderVideoRecycler) + 1);
        AppMethodBeat.o(205762);
        return true;
      }
      ad.i("Finder.VideoRecycler", "[preInflateVideoView] completed! preInflateCount=" + FinderVideoRecycler.i(this.tdB) + " targetCount=" + FinderVideoRecycler.h(this.tdB) + " isFinished=" + FinderVideoRecycler.j(this.tdB));
      AppMethodBeat.o(205762);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class m
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    m(com.tencent.mm.plugin.finder.video.o paramo)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements d.g.a.a<z>
  {
    n(FinderVideoRecycler paramFinderVideoRecycler, com.tencent.mm.plugin.finder.video.o paramo, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class o
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    o(Context paramContext)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class p
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    p(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext, y.d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler
 * JD-Core Version:    0.7.0.1
 */