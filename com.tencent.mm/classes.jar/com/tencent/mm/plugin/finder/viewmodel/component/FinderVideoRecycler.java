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
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderCropVideoView;
import com.tencent.mm.plugin.finder.video.FinderLivePlayView;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.video.u;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.g.b.z.e;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "activityCount", "", "aliveActivitySet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "createdVideoViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "isFinished", "", "isForceWaitForRelease", "maxVideoCount", "onlineVideoEventListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1;", "preInflateCount", "preInflateVideoCount", "recycledVideoViews", "releasingVideoViewMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "waitForCallback", "waitRecycledCallbacks", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "acrossCreatedVideoViews", "", "isRemoveFun", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "clearAllShouldPlayResumeVideoView", "createVideoView", "context", "Landroid/content/Context;", "videoType", "isCropVideo", "findOldestVideoView", "clazz", "Ljava/lang/Class;", "isForce", "getOrCreate", "parent", "Landroid/view/ViewGroup;", "finderVideo", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "completedTo", "videoView", "getVideoCount", "make", "activity", "Landroid/support/v7/app/AppCompatActivity;", "isPreInflate", "onCleared", "onFinish", "onInit", "onPreloadComplete", "mediaId", "pauseAllVideo", "filter", "pauseAndRecycle", "isForceRemove", "isTryKeep", "pauseFocusVideo", "preInflateVideoView", "recycledVideoView", "releaseVideoView", "source", "removeByContext", "removeViewFromParent", "Landroid/view/View;", "resumeFocusVideo", "Companion", "IRecycledCallback", "plugin-finder_release"})
public final class FinderVideoRecycler
  extends UIComponentPlugin<PluginFinder>
{
  public static final a wBf;
  private final MMHandler hAk;
  private boolean isFinished;
  private boolean wAT;
  private int wAU;
  private int wAV;
  final HashSet<r> wAW;
  private final ConcurrentLinkedQueue<WeakReference<? extends r>> wAX;
  public final HashMap<Integer, String> wAY;
  private final HashMap<Integer, b> wAZ;
  private final HashSet<String> wBa;
  private int wBb;
  private int wBc;
  private final HashMap<Integer, Object> wBd;
  private final j wBe;
  
  static
  {
    AppMethodBeat.i(256086);
    wBf = new a((byte)0);
    AppMethodBeat.o(256086);
  }
  
  public FinderVideoRecycler()
  {
    AppMethodBeat.i(256085);
    this.wAT = true;
    this.wAU = 1;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.wAW = new HashSet();
    this.wAX = new ConcurrentLinkedQueue();
    this.wAY = new HashMap();
    this.wAZ = new HashMap();
    this.wBa = new HashSet();
    this.wBd = new HashMap();
    this.wBe = new j(this);
    AppMethodBeat.o(256085);
  }
  
  private final void MC()
  {
    AppMethodBeat.i(256069);
    this.isFinished = false;
    this.wBe.alive();
    Object localObject = c.vCb;
    localObject = c.drF();
    this.wAU = ((Number)((o)localObject).first).intValue();
    this.wAT = ((Boolean)((o)localObject).second).booleanValue();
    this.wAV = kotlin.k.j.na(this.wAU - 1, 4);
    Log.i("Finder.VideoRecycler", "[onInit] maxVideoCount=" + this.wAU + " preInflateCount=" + this.wAV + " waitForRelease=" + this.wAT);
    AppMethodBeat.o(256069);
  }
  
  private int aP(Class<? extends r> paramClass)
  {
    AppMethodBeat.i(256079);
    final z.d locald = new z.d();
    locald.SYE = 0;
    I((kotlin.g.a.b)new h(paramClass, locald));
    int i = locald.SYE;
    AppMethodBeat.o(256079);
    return i;
  }
  
  private final r c(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(256072);
    long l = System.currentTimeMillis();
    Object localObject;
    if (paramInt == 1) {
      localObject = (r)new FinderVLogCompositionPlayView(paramContext);
    }
    for (;;)
    {
      this.wAX.add(new WeakReference(localObject));
      Log.i("Finder.VideoRecycler", "[createVideoView] activity=" + paramContext.getClass().getSimpleName() + " videoCount=" + a(this) + ' ' + "videoView=" + localObject.getClass().getSimpleName() + " cost=" + (System.currentTimeMillis() - l) + "ms");
      AppMethodBeat.o(256072);
      return localObject;
      if (paramInt == 2)
      {
        localObject = (r)new FinderLivePlayView(paramContext);
      }
      else
      {
        localObject = g.ah(com.tencent.mm.plugin.thumbplayer.a.a.class);
        p.g(localObject, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
        if ((((com.tencent.mm.plugin.thumbplayer.a.a)localObject).isOpenTPPlayer()) && (!paramBoolean)) {
          localObject = (r)new FinderThumbPlayerProxy(paramContext);
        } else {
          localObject = (r)new FinderCropVideoView(paramContext);
        }
      }
    }
  }
  
  private final r e(final Class<? extends r> paramClass, final boolean paramBoolean)
  {
    Object localObject1 = null;
    AppMethodBeat.i(256076);
    Object localObject2 = new z.e();
    ((z.e)localObject2).SYF = 9223372036854775807L;
    final z.f localf = new z.f();
    localf.SYG = null;
    I((kotlin.g.a.b)new d(this, paramClass, (z.e)localObject2, new int[2], paramBoolean, localf));
    localObject2 = new StringBuilder("[findOldestVideoView] activity=");
    paramClass = (r)localf.SYG;
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
            localObject2 = ((StringBuilder)localObject2).append(paramClass).append(" mediaid:");
            paramClass = (r)localf.SYG;
            if (paramClass == null) {
              break label336;
            }
            paramClass = paramClass.getVideoMediaId();
            label157:
            localObject2 = ((StringBuilder)localObject2).append(paramClass).append(" videoView=");
            paramClass = (r)localf.SYG;
            if (paramClass == null) {
              break label341;
            }
            paramClass = Integer.valueOf(paramClass.hashCode());
            label192:
            localObject2 = ((StringBuilder)localObject2).append(paramClass).append(' ').append("isAttachedToWindow=");
            paramClass = (r)localf.SYG;
            if (paramClass == null) {
              break label346;
            }
            paramClass = paramClass.getVideoView();
            if (paramClass == null) {
              break label346;
            }
          }
        }
      }
    }
    label336:
    label341:
    label346:
    for (paramClass = Boolean.valueOf(paramClass.isAttachedToWindow());; paramClass = null)
    {
      localObject2 = ((StringBuilder)localObject2).append(paramClass).append(" parent=");
      Object localObject3 = (r)localf.SYG;
      paramClass = localObject1;
      if (localObject3 != null)
      {
        localObject3 = ((r)localObject3).getParentView();
        paramClass = localObject1;
        if (localObject3 != null) {
          paramClass = Integer.valueOf(localObject3.hashCode());
        }
      }
      Log.i("Finder.VideoRecycler", paramClass);
      paramClass = (r)localf.SYG;
      AppMethodBeat.o(256076);
      return paramClass;
      paramClass = null;
      break;
      paramClass = null;
      break label157;
      paramClass = null;
      break label192;
    }
  }
  
  private final boolean ek(View paramView)
  {
    AppMethodBeat.i(256074);
    if (paramView != null)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null)
      {
        ((Map)this.wAY).put(Integer.valueOf(localViewParent.hashCode()), null);
        if (localViewParent == null)
        {
          paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(256074);
          throw paramView;
        }
        ((ViewGroup)localViewParent).removeView(paramView);
        Log.i("Finder.VideoRecycler", "[removeViewFromParent] parent=" + localViewParent.hashCode() + ", videoView=" + paramView.hashCode() + ", parentTag=" + ((ViewGroup)localViewParent).getTag());
        AppMethodBeat.o(256074);
        return true;
      }
    }
    AppMethodBeat.o(256074);
    return false;
  }
  
  private final void fI(final Context paramContext)
  {
    AppMethodBeat.i(256071);
    if (Build.VERSION.SDK_INT >= 23)
    {
      Looper localLooper = Looper.getMainLooper();
      p.g(localLooper, "Looper.getMainLooper()");
      localLooper.getQueue().addIdleHandler((MessageQueue.IdleHandler)new m(this, paramContext));
    }
    AppMethodBeat.o(256071);
  }
  
  private final void onFinish()
  {
    AppMethodBeat.i(256070);
    this.isFinished = true;
    this.wBe.dead();
    this.hAk.postAtFrontOfQueue((Runnable)new i(this));
    this.wBa.clear();
    this.wAZ.clear();
    AppMethodBeat.o(256070);
  }
  
  final void I(kotlin.g.a.b<? super r, Boolean> paramb)
  {
    AppMethodBeat.i(256078);
    Iterator localIterator = this.wAX.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)((WeakReference)localIterator.next()).get();
      if (localr != null)
      {
        if (((Boolean)paramb.invoke(localr)).booleanValue()) {
          localIterator.remove();
        }
      }
      else {
        localIterator.remove();
      }
    }
    AppMethodBeat.o(256078);
  }
  
  public final void J(final kotlin.g.a.b<? super r, Boolean> paramb)
  {
    AppMethodBeat.i(256084);
    p.h(paramb, "filter");
    d.h((kotlin.g.a.a)new k(this, paramb));
    AppMethodBeat.o(256084);
  }
  
  public final void a(final AppCompatActivity paramAppCompatActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(256067);
    p.h(paramAppCompatActivity, "activity");
    final String str = String.valueOf(paramAppCompatActivity.hashCode());
    if (this.wBc == 0) {
      MC();
    }
    if (this.wBa.add(str))
    {
      Log.i("Finder.VideoRecycler", "[register] activity=" + paramAppCompatActivity.getClass().getSimpleName() + " isPreInflate=" + paramBoolean);
      if (paramBoolean) {
        fI((Context)paramAppCompatActivity);
      }
      this.wBc += 1;
      paramAppCompatActivity.getLifecycle().addObserver((LifecycleObserver)new LifecycleObserver()
      {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy()
        {
          AppMethodBeat.i(256048);
          FinderVideoRecycler localFinderVideoRecycler = this.wBg;
          FinderVideoRecycler.a(localFinderVideoRecycler, FinderVideoRecycler.b(localFinderVideoRecycler) - 1);
          if (FinderVideoRecycler.b(this.wBg) == 0) {
            FinderVideoRecycler.c(this.wBg);
          }
          for (;;)
          {
            FinderVideoRecycler.d(this.wBg).remove(str);
            paramAppCompatActivity.getLifecycle().removeObserver((LifecycleObserver)this);
            AppMethodBeat.o(256048);
            return;
            localFinderVideoRecycler = this.wBg;
            Context localContext = (Context)paramAppCompatActivity;
            p.h(localContext, "context");
            kotlin.a.j.a((Iterable)localFinderVideoRecycler.wAW, (kotlin.g.a.b)new FinderVideoRecycler.p(localContext));
            z.d locald = new z.d();
            locald.SYE = 0;
            localFinderVideoRecycler.I((kotlin.g.a.b)new FinderVideoRecycler.q(localFinderVideoRecycler, localContext, locald));
            Log.i("Finder.VideoRecycler", "[removeByContext] simpleName=" + localContext.getClass().getSimpleName() + " removeCount=" + locald.SYE + " videoCount=" + FinderVideoRecycler.a(localFinderVideoRecycler));
          }
        }
      });
    }
    AppMethodBeat.o(256067);
  }
  
  public final void a(final ViewGroup paramViewGroup, final s params, final kotlin.g.a.b<? super r, x> paramb)
  {
    AppMethodBeat.i(256075);
    p.h(paramViewGroup, "parent");
    p.h(params, "finderVideo");
    p.h(paramb, "completedTo");
    final Context localContext = paramViewGroup.getContext();
    Object localObject = params.uIw;
    final String str = params.auA();
    params = y.vXH;
    final int i = y.i((cjl)localObject);
    params = y.vXH;
    if (y.h((cjl)localObject))
    {
      params = y.vXH;
      if (!y.j((cjl)localObject)) {}
    }
    for (final boolean bool = true;; bool = false)
    {
      localObject = paramViewGroup.findViewWithTag(Integer.valueOf(paramViewGroup.hashCode()));
      params = (s)localObject;
      if (!(localObject instanceof r)) {
        params = null;
      }
      params = (r)params;
      if ((params == null) || ((params.getVideoMediaId() != null) && (!p.j(params.getVideoMediaId(), str)))) {
        break;
      }
      params.setTag(2131301505, Long.valueOf(SystemClock.uptimeMillis()));
      paramb.invoke(params);
      AppMethodBeat.o(256075);
      return;
    }
    if (params != null) {}
    for (params = params.getVideoView();; params = null)
    {
      ek(params);
      if (!this.wAT) {
        break label313;
      }
      params = (String)this.wAY.get(Integer.valueOf(paramViewGroup.hashCode()));
      if (!p.j(params, str)) {
        break;
      }
      AppMethodBeat.o(256075);
      return;
    }
    label313:
    label368:
    final FinderVideoRecycler localFinderVideoRecycler;
    r localr;
    if (params != null)
    {
      ((Map)this.wAY).put(Integer.valueOf(paramViewGroup.hashCode()), str);
      Log.i("Finder.VideoRecycler", "replace callback. " + params + " => " + str + ", parent=" + paramViewGroup.hashCode());
      localObject = (kotlin.g.a.b)new g(this, paramViewGroup, paramb);
      if (i != 0) {
        break label730;
      }
      params = g.ah(com.tencent.mm.plugin.thumbplayer.a.a.class);
      p.g(params, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
      if ((!((com.tencent.mm.plugin.thumbplayer.a.a)params).isOpenTPPlayer()) || (bool)) {
        break label723;
      }
      params = FinderThumbPlayerProxy.class;
      paramb = (r)d.a(this.wAW, (kotlin.g.a.b)new f(localContext, params));
      if (paramb != null)
      {
        Log.i("Finder.VideoRecycler", "[getOrCreate] get a recycled videoView(" + paramb.hashCode() + ") parent=" + paramViewGroup.hashCode() + " videoCount=" + a(this));
        ((kotlin.g.a.b)localObject).invoke(paramb);
        if (paramb != null) {}
      }
      else
      {
        localFinderVideoRecycler = (FinderVideoRecycler)this;
        int j = localFinderVideoRecycler.aP(params);
        if (j < localFinderVideoRecycler.wAU) {
          break label829;
        }
        localr = localFinderVideoRecycler.e(params, localFinderVideoRecycler.wAT);
        StringBuilder localStringBuilder = new StringBuilder("[getOrCreate] over count(max=").append(localFinderVideoRecycler.wAU).append(':').append(j).append(") waitForRelease=").append(localFinderVideoRecycler.wAT).append(" oldest=");
        if (localr == null) {
          break label750;
        }
        paramb = Integer.valueOf(localr.hashCode());
        label562:
        Log.i("Finder.VideoRecycler", paramb);
        if (!localFinderVideoRecycler.wAT) {
          break label784;
        }
        if (localr == null) {
          break label755;
        }
        j = paramViewGroup.hashCode();
        ((Map)localFinderVideoRecycler.wAY).put(Integer.valueOf(j), str);
        ((Map)localFinderVideoRecycler.wAZ).put(Integer.valueOf(localr.hashCode()), new e(j, localFinderVideoRecycler, params, paramViewGroup, str, (kotlin.g.a.b)localObject, localContext, i, bool));
        localFinderVideoRecycler.a(localr, "getOrCreate");
      }
    }
    for (;;)
    {
      paramViewGroup = x.SXb;
      AppMethodBeat.o(256075);
      return;
      Log.i("Finder.VideoRecycler", "wait for callback. mediaId=" + str + " parent=" + paramViewGroup.hashCode());
      break;
      label723:
      params = FinderCropVideoView.class;
      break label368;
      label730:
      if (i == 2)
      {
        params = FinderLivePlayView.class;
        break label368;
      }
      params = FinderVLogCompositionPlayView.class;
      break label368;
      label750:
      paramb = null;
      break label562;
      label755:
      Log.e("Finder.VideoRecycler", "[getOrCreate] oldest is null! parent=" + paramViewGroup.hashCode());
      continue;
      label784:
      if (localr != null) {
        localFinderVideoRecycler.a(localr, "getOrCreate");
      }
      p.g(localContext, "context");
      ((kotlin.g.a.b)localObject).invoke(localFinderVideoRecycler.c(localContext, i, bool));
      continue;
      label829:
      p.g(localContext, "context");
      ((kotlin.g.a.b)localObject).invoke(localFinderVideoRecycler.c(localContext, i, bool));
    }
  }
  
  public final void a(final r paramr, String paramString)
  {
    AppMethodBeat.i(256077);
    if (this.wBd.containsKey(Integer.valueOf(paramr.hashCode())))
    {
      Log.w("Finder.VideoRecycler", "[releaseVideoView] videoView=" + paramr.hashCode() + " is releasing, source=" + paramString);
      AppMethodBeat.o(256077);
      return;
    }
    final long l = System.currentTimeMillis();
    ((Map)this.wBd).put(Integer.valueOf(paramr.hashCode()), new Object());
    ek(paramr.getVideoView());
    paramr.pause();
    StringBuilder localStringBuilder = new StringBuilder("[releaseVideoView] async release videoView(").append(paramr.hashCode()).append(") parent=");
    ViewParent localViewParent = paramr.getParentView();
    if (localViewParent != null) {}
    for (int i = localViewParent.hashCode();; i = 0)
    {
      Log.i("Finder.VideoRecycler", i + " source=" + paramString);
      d.i((kotlin.g.a.a)new o(this, paramr, l, paramString));
      AppMethodBeat.o(256077);
      return;
    }
  }
  
  public final void awV(String paramString)
  {
    AppMethodBeat.i(256068);
    p.h(paramString, "mediaId");
    Object localObject = c.vCb;
    if (((Number)c.dxe().value()).intValue() != 1)
    {
      AppMethodBeat.o(256068);
      return;
    }
    localObject = ((Iterable)this.wAX).iterator();
    while (((Iterator)localObject).hasNext())
    {
      r localr = (r)((WeakReference)((Iterator)localObject).next()).get();
      if (localr != null)
      {
        String str = localr.getVideoMediaId();
        if (str != null)
        {
          Log.i("Finder.VideoRecycler", "onPreloadComplete " + str + ' ' + paramString);
          if (p.j(str, paramString)) {
            localr.dEN();
          }
        }
      }
    }
    AppMethodBeat.o(256068);
  }
  
  public final void dIQ()
  {
    AppMethodBeat.i(256083);
    d.h((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(256083);
  }
  
  public final void fJ(final Context paramContext)
  {
    AppMethodBeat.i(256082);
    d.h((kotlin.g.a.a)new l(this, paramContext));
    AppMethodBeat.o(256082);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(256081);
    Log.i("Finder.VideoRecycler", "[onCleared] videoCount=" + a(this));
    onFinish();
    AppMethodBeat.o(256081);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "", "onRecycledCompleted", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract boolean a(r paramr);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(FinderVideoRecycler paramFinderVideoRecycler)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<r, Boolean>
  {
    d(FinderVideoRecycler paramFinderVideoRecycler, Class paramClass, z.e parame, int[] paramArrayOfInt, boolean paramBoolean, z.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$getOrCreate$3$1$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "onRecycledCompleted", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$$special$$inlined$let$lambda$1"})
  public static final class e
    implements FinderVideoRecycler.b
  {
    e(int paramInt1, FinderVideoRecycler paramFinderVideoRecycler, Class paramClass, ViewGroup paramViewGroup, String paramString, kotlin.g.a.b paramb, Context paramContext, int paramInt2, boolean paramBoolean) {}
    
    public final boolean a(r paramr)
    {
      AppMethodBeat.i(256044);
      p.h(paramr, "videoView");
      if (p.j((String)FinderVideoRecycler.k(localFinderVideoRecycler).get(Integer.valueOf(this.wBm)), str))
      {
        Log.i("Finder.VideoRecycler", "[getOrCreate] wait for callback successfully. mediaId=" + str + " parent=" + this.wBm);
        this.wBp.invoke(paramr);
        AppMethodBeat.o(256044);
        return true;
      }
      Log.i("Finder.VideoRecycler", "wait for callback, but it(" + str + ") has been replace(" + (String)FinderVideoRecycler.k(localFinderVideoRecycler).get(Integer.valueOf(this.wBm)) + "). key=" + this.wBm);
      AppMethodBeat.o(256044);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<r, Boolean>
  {
    f(Context paramContext, Class paramClass)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<r, x>
  {
    g(FinderVideoRecycler paramFinderVideoRecycler, ViewGroup paramViewGroup, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<r, Boolean>
  {
    h(Class paramClass, z.d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderVideoRecycler paramFinderVideoRecycler) {}
    
    public final void run()
    {
      AppMethodBeat.i(256049);
      Iterator localIterator = ((Iterable)FinderVideoRecycler.e(this.wBg)).iterator();
      while (localIterator.hasNext())
      {
        r localr = (r)((WeakReference)localIterator.next()).get();
        if (localr != null)
        {
          localr.onUIDestroy();
          localr.onRelease();
        }
      }
      FinderVideoRecycler.e(this.wBg).clear();
      FinderVideoRecycler.f(this.wBg).clear();
      FinderVideoRecycler.g(this.wBg).removeCallbacksAndMessages(null);
      AppMethodBeat.o(256049);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class j
    extends IListener<oq>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.b<r, Boolean>
    {
      a(String paramString, FinderVideoRecycler.j paramj)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(FinderVideoRecycler paramFinderVideoRecycler, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "queueIdle"})
  static final class m
    implements MessageQueue.IdleHandler
  {
    m(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(256057);
      if ((FinderVideoRecycler.h(this.wBg) > 0) && (FinderVideoRecycler.i(this.wBg) < FinderVideoRecycler.h(this.wBg)) && (!FinderVideoRecycler.j(this.wBg)))
      {
        FinderVideoRecycler.f(this.wBg).add(FinderVideoRecycler.a(this.wBg, paramContext));
        FinderVideoRecycler localFinderVideoRecycler = this.wBg;
        FinderVideoRecycler.b(localFinderVideoRecycler, FinderVideoRecycler.i(localFinderVideoRecycler) + 1);
        AppMethodBeat.o(256057);
        return true;
      }
      Log.i("Finder.VideoRecycler", "[preInflateVideoView] completed! preInflateCount=" + FinderVideoRecycler.i(this.wBg) + " targetCount=" + FinderVideoRecycler.h(this.wBg) + " isFinished=" + FinderVideoRecycler.j(this.wBg));
      AppMethodBeat.o(256057);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(FinderVideoRecycler paramFinderVideoRecycler, r paramr, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.b<r, Boolean>
  {
    q(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext, z.d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class r
    extends q
    implements kotlin.g.a.a<x>
  {
    public r(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler
 * JD-Core Version:    0.7.0.1
 */