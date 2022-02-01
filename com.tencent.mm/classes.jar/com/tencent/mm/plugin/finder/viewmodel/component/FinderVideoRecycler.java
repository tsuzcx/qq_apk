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
import com.tencent.mm.g.a.np;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.video.FinderCropVideoView;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentPlugin;
import d.a.j;
import d.g.b.k;
import d.g.b.v.d;
import d.g.b.v.e;
import d.g.b.v.f;
import d.k.h;
import d.v;
import d.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "activityCount", "", "aliveActivitySet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "createdVideoViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "isFinished", "", "isForceWaitForRelease", "maxVideoCount", "onlineVideoEventListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1;", "preInflateCount", "preInflateVideoCount", "recycledVideoViews", "releasingVideoViewMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "waitForCallback", "waitRecycledCallbacks", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "acrossCreatedVideoViews", "", "isRemoveFun", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "createVideoView", "context", "Landroid/content/Context;", "isNormalVideoView", "findOldestVideoView", "clazz", "Ljava/lang/Class;", "isForce", "getOrCreate", "parent", "Landroid/view/ViewGroup;", "finderVideo", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "completedTo", "videoView", "getVideoCount", "make", "activity", "Lcom/tencent/mm/ui/MMActivity;", "isPreInflate", "onCleared", "onFinish", "onInit", "onPreloadComplete", "mediaId", "pauseAllVideo", "filter", "pauseAndRecycle", "isForceRemove", "isTryKeep", "pauseFocusVideo", "preInflateVideoView", "recycledVideoView", "releaseVideoView", "source", "removeByContext", "removeViewFromParent", "Landroid/view/View;", "resumeFocusVideo", "Companion", "IRecycledCallback", "plugin-finder_release"})
public final class FinderVideoRecycler
  extends UIComponentPlugin<PluginFinder>
{
  public static final FinderVideoRecycler.a sfD;
  private boolean gnd;
  private final ao gox;
  private int sfA;
  private final HashMap<Integer, Object> sfB;
  private final i sfC;
  private boolean sfr;
  private int sfs;
  private int sft;
  final HashSet<com.tencent.mm.plugin.finder.video.o> sfu;
  private final ConcurrentLinkedQueue<WeakReference<? extends com.tencent.mm.plugin.finder.video.o>> sfv;
  public final HashMap<Integer, String> sfw;
  private final HashMap<Integer, b> sfx;
  private final HashSet<String> sfy;
  private int sfz;
  
  static
  {
    AppMethodBeat.i(204738);
    sfD = new FinderVideoRecycler.a((byte)0);
    AppMethodBeat.o(204738);
  }
  
  public FinderVideoRecycler()
  {
    AppMethodBeat.i(204737);
    this.sfr = true;
    this.sfs = 1;
    this.gox = new ao(Looper.getMainLooper());
    this.sfu = new HashSet();
    this.sfv = new ConcurrentLinkedQueue();
    this.sfw = new HashMap();
    this.sfx = new HashMap();
    this.sfy = new HashSet();
    this.sfB = new HashMap();
    this.sfC = new i(this);
    AppMethodBeat.o(204737);
  }
  
  private final void BE()
  {
    AppMethodBeat.i(204722);
    this.gnd = false;
    this.sfC.alive();
    Object localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    localObject = com.tencent.mm.plugin.finder.storage.b.czd();
    this.sfs = ((Number)((d.o)localObject).first).intValue();
    this.sfr = ((Boolean)((d.o)localObject).second).booleanValue();
    this.sft = h.lb(this.sfs - 1, 4);
    ac.i("Finder.VideoRecycler", "[onInit] maxVideoCount=" + this.sfs + " preInflateCount=" + this.sft + " waitForRelease=" + this.sfr);
    AppMethodBeat.o(204722);
  }
  
  private int aN(Class<? extends com.tencent.mm.plugin.finder.video.o> paramClass)
  {
    AppMethodBeat.i(204732);
    v.d locald = new v.d();
    locald.KUO = 0;
    B((d.g.a.b)new FinderVideoRecycler.g(paramClass, locald));
    int i = locald.KUO;
    AppMethodBeat.o(204732);
    return i;
  }
  
  private final com.tencent.mm.plugin.finder.video.o d(final Class<? extends com.tencent.mm.plugin.finder.video.o> paramClass, final boolean paramBoolean)
  {
    Object localObject1 = null;
    AppMethodBeat.i(204729);
    Object localObject2 = new v.e();
    ((v.e)localObject2).KUP = 9223372036854775807L;
    final v.f localf = new v.f();
    localf.KUQ = null;
    B((d.g.a.b)new c(this, paramClass, (v.e)localObject2, new int[2], paramBoolean, localf));
    localObject2 = new StringBuilder("[findOldestVideoView] activity=");
    paramClass = (com.tencent.mm.plugin.finder.video.o)localf.KUQ;
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
            paramClass = (com.tencent.mm.plugin.finder.video.o)localf.KUQ;
            if (paramClass == null) {
              break label302;
            }
            paramClass = Integer.valueOf(paramClass.hashCode());
            label158:
            localObject2 = ((StringBuilder)localObject2).append(paramClass).append(' ').append("isAttachedToWindow=");
            paramClass = (com.tencent.mm.plugin.finder.video.o)localf.KUQ;
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
      Object localObject3 = (com.tencent.mm.plugin.finder.video.o)localf.KUQ;
      paramClass = localObject1;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.video.o)localObject3).getParentView();
        paramClass = localObject1;
        if (localObject3 != null) {
          paramClass = Integer.valueOf(localObject3.hashCode());
        }
      }
      ac.i("Finder.VideoRecycler", paramClass);
      paramClass = (com.tencent.mm.plugin.finder.video.o)localf.KUQ;
      AppMethodBeat.o(204729);
      return paramClass;
      paramClass = null;
      break;
      paramClass = null;
      break label158;
    }
  }
  
  private final void eW(final Context paramContext)
  {
    AppMethodBeat.i(204724);
    if (Build.VERSION.SDK_INT >= 23)
    {
      Looper localLooper = Looper.getMainLooper();
      k.g(localLooper, "Looper.getMainLooper()");
      localLooper.getQueue().addIdleHandler((MessageQueue.IdleHandler)new l(this, paramContext));
    }
    AppMethodBeat.o(204724);
  }
  
  private final boolean ee(View paramView)
  {
    AppMethodBeat.i(204727);
    if (paramView != null)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null)
      {
        ((Map)this.sfw).put(Integer.valueOf(localViewParent.hashCode()), null);
        if (localViewParent == null)
        {
          paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(204727);
          throw paramView;
        }
        ((ViewGroup)localViewParent).removeView(paramView);
        ac.i("Finder.VideoRecycler", "[removeViewFromParent] parent=" + localViewParent.hashCode() + ", videoView=" + paramView.hashCode() + ", parentTag=" + ((ViewGroup)localViewParent).getTag());
        AppMethodBeat.o(204727);
        return true;
      }
    }
    AppMethodBeat.o(204727);
    return false;
  }
  
  private final void onFinish()
  {
    AppMethodBeat.i(204723);
    this.gnd = true;
    this.sfC.dead();
    this.gox.postAtFrontOfQueue((Runnable)new h(this));
    this.sfy.clear();
    this.sfx.clear();
    AppMethodBeat.o(204723);
  }
  
  private final com.tencent.mm.plugin.finder.video.o w(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(204725);
    Object localObject;
    if (paramBoolean)
    {
      localObject = g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
      k.g(localObject, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
      if (((com.tencent.mm.plugin.thumbplayer.a.a)localObject).isOpenTPPlayer()) {
        localObject = (com.tencent.mm.plugin.finder.video.o)new FinderThumbPlayerProxy(paramContext);
      }
    }
    for (;;)
    {
      this.sfv.add(new WeakReference(localObject));
      ac.i("Finder.VideoRecycler", "[createVideoView] activity=" + paramContext.getClass().getSimpleName() + " videoCount=" + a(this));
      AppMethodBeat.o(204725);
      return localObject;
      localObject = (com.tencent.mm.plugin.finder.video.o)new FinderCropVideoView(paramContext);
      continue;
      localObject = (com.tencent.mm.plugin.finder.video.o)new FinderVLogCompositionPlayView(paramContext);
    }
  }
  
  final void B(d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, Boolean> paramb)
  {
    AppMethodBeat.i(204731);
    Iterator localIterator = this.sfv.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)((WeakReference)localIterator.next()).get();
      if (localo != null)
      {
        if (((Boolean)paramb.ay(localo)).booleanValue()) {
          localIterator.remove();
        }
      }
      else {
        localIterator.remove();
      }
    }
    AppMethodBeat.o(204731);
  }
  
  public final void C(final d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, Boolean> paramb)
  {
    AppMethodBeat.i(204736);
    k.h(paramb, "filter");
    com.tencent.mm.ac.c.g((d.g.a.a)new j(this, paramb));
    AppMethodBeat.o(204736);
  }
  
  public final void a(final ViewGroup paramViewGroup, final com.tencent.mm.plugin.finder.loader.l paraml, final d.g.a.b<? super com.tencent.mm.plugin.finder.video.o, y> paramb)
  {
    AppMethodBeat.i(204728);
    k.h(paramViewGroup, "parent");
    k.h(paraml, "finderVideo");
    k.h(paramb, "completedTo");
    final Context localContext = paramViewGroup.getContext();
    Object localObject = paraml.rtl;
    final String str = paraml.abW();
    paraml = n.rPN;
    final boolean bool = n.c((bqs)localObject);
    localObject = paramViewGroup.findViewWithTag(Integer.valueOf(paramViewGroup.hashCode()));
    paraml = (com.tencent.mm.plugin.finder.loader.l)localObject;
    if (!(localObject instanceof com.tencent.mm.plugin.finder.video.o)) {
      paraml = null;
    }
    paraml = (com.tencent.mm.plugin.finder.video.o)paraml;
    if ((paraml != null) && ((paraml.getVideoMediaId() == null) || (k.g(paraml.getVideoMediaId(), str))))
    {
      paraml.setTag(2131307441, Long.valueOf(SystemClock.uptimeMillis()));
      paramb.ay(paraml);
      AppMethodBeat.o(204728);
      return;
    }
    if (paraml != null) {}
    for (paraml = paraml.getVideoView();; paraml = null)
    {
      ee(paraml);
      if (!this.sfr) {
        break label280;
      }
      paraml = (String)this.sfw.get(Integer.valueOf(paramViewGroup.hashCode()));
      if (!k.g(paraml, str)) {
        break;
      }
      AppMethodBeat.o(204728);
      return;
    }
    label280:
    label330:
    final FinderVideoRecycler localFinderVideoRecycler;
    com.tencent.mm.plugin.finder.video.o localo;
    if (paraml != null)
    {
      ((Map)this.sfw).put(Integer.valueOf(paramViewGroup.hashCode()), str);
      ac.i("Finder.VideoRecycler", "replace callback. " + paraml + " => " + str + ", parent=" + paramViewGroup.hashCode());
      localObject = (d.g.a.b)new f(this, paramViewGroup, paramb);
      if (!bool) {
        break label690;
      }
      paraml = g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
      k.g(paraml, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
      if (!((com.tencent.mm.plugin.thumbplayer.a.a)paraml).isOpenTPPlayer()) {
        break label683;
      }
      paraml = FinderThumbPlayerProxy.class;
      paramb = (com.tencent.mm.plugin.finder.video.o)com.tencent.mm.ac.c.a(this.sfu, (d.g.a.b)new FinderVideoRecycler.e(localContext, paraml));
      if (paramb != null)
      {
        ac.i("Finder.VideoRecycler", "[getOrCreate] get a recycled videoView(" + paramb.hashCode() + ") parent=" + paramViewGroup.hashCode() + " videoCount=" + a(this));
        ((d.g.a.b)localObject).ay(paramb);
        if (paramb != null) {}
      }
      else
      {
        localFinderVideoRecycler = (FinderVideoRecycler)this;
        int i = localFinderVideoRecycler.aN(paraml);
        if (i < localFinderVideoRecycler.sfs) {
          break label774;
        }
        localo = localFinderVideoRecycler.d(paraml, localFinderVideoRecycler.sfr);
        StringBuilder localStringBuilder = new StringBuilder("[getOrCreate] over count(max=").append(localFinderVideoRecycler.sfs).append(':').append(i).append(") waitForRelease=").append(localFinderVideoRecycler.sfr).append(" oldest=");
        if (localo == null) {
          break label697;
        }
        paramb = Integer.valueOf(localo.hashCode());
        label524:
        ac.i("Finder.VideoRecycler", paramb);
        if (!localFinderVideoRecycler.sfr) {
          break label731;
        }
        if (localo == null) {
          break label702;
        }
        i = paramViewGroup.hashCode();
        ((Map)localFinderVideoRecycler.sfw).put(Integer.valueOf(i), str);
        ((Map)localFinderVideoRecycler.sfx).put(Integer.valueOf(localo.hashCode()), new d(i, localFinderVideoRecycler, paraml, paramViewGroup, str, (d.g.a.b)localObject, localContext, bool));
        localFinderVideoRecycler.a(localo, "getOrCreate");
      }
    }
    for (;;)
    {
      paramViewGroup = y.KTp;
      AppMethodBeat.o(204728);
      return;
      ac.i("Finder.VideoRecycler", "wait for callback. mediaId=" + str + " parent=" + paramViewGroup.hashCode());
      break;
      label683:
      paraml = FinderCropVideoView.class;
      break label330;
      label690:
      paraml = FinderVLogCompositionPlayView.class;
      break label330;
      label697:
      paramb = null;
      break label524;
      label702:
      ac.e("Finder.VideoRecycler", "[getOrCreate] oldest is null! parent=" + paramViewGroup.hashCode());
      continue;
      label731:
      if (localo != null) {
        localFinderVideoRecycler.a(localo, "getOrCreate");
      }
      k.g(localContext, "context");
      ((d.g.a.b)localObject).ay(localFinderVideoRecycler.w(localContext, bool));
      continue;
      label774:
      k.g(localContext, "context");
      ((d.g.a.b)localObject).ay(localFinderVideoRecycler.w(localContext, bool));
    }
  }
  
  public final void a(final com.tencent.mm.plugin.finder.video.o paramo, String paramString)
  {
    AppMethodBeat.i(204730);
    if (this.sfB.containsKey(Integer.valueOf(paramo.hashCode())))
    {
      ac.w("Finder.VideoRecycler", "[releaseVideoView] videoView=" + paramo.hashCode() + " is releasing, source=" + paramString);
      AppMethodBeat.o(204730);
      return;
    }
    final long l = System.currentTimeMillis();
    ((Map)this.sfB).put(Integer.valueOf(paramo.hashCode()), new Object());
    ee(paramo.getVideoView());
    paramo.pause();
    StringBuilder localStringBuilder = new StringBuilder("[releaseVideoView] async release videoView(").append(paramo.hashCode()).append(") parent=");
    ViewParent localViewParent = paramo.getParentView();
    if (localViewParent != null) {}
    for (int i = localViewParent.hashCode();; i = 0)
    {
      ac.i("Finder.VideoRecycler", i + " source=" + paramString);
      com.tencent.mm.ac.c.b(null, (d.g.a.a)new n(this, paramo, l, paramString));
      AppMethodBeat.o(204730);
      return;
    }
  }
  
  public final void aCm(String paramString)
  {
    AppMethodBeat.i(210215);
    k.h(paramString, "mediaId");
    Iterator localIterator = ((Iterable)this.sfv).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)((WeakReference)localIterator.next()).get();
      if (localo != null)
      {
        String str = localo.getVideoMediaId();
        if (str != null)
        {
          ac.d("Finder.VideoRecycler", "onPreloadComplete " + str + ' ' + paramString);
          if (k.g(str, paramString)) {
            localo.cBe();
          }
        }
      }
    }
    AppMethodBeat.o(210215);
  }
  
  public final void ae()
  {
    AppMethodBeat.i(204734);
    ac.i("Finder.VideoRecycler", "[onCleared] videoCount=" + a(this));
    onFinish();
    AppMethodBeat.o(204734);
  }
  
  public final void b(final MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(204721);
    k.h(paramMMActivity, "activity");
    final String str = String.valueOf(paramMMActivity.hashCode());
    if (this.sfA == 0) {
      BE();
    }
    if (this.sfy.add(str))
    {
      ac.i("Finder.VideoRecycler", "[register] activity=" + paramMMActivity.getClass().getSimpleName() + " isPreInflate=" + paramBoolean);
      if (paramBoolean) {
        eW((Context)paramMMActivity);
      }
      this.sfA += 1;
      paramMMActivity.getLifecycle().addObserver((LifecycleObserver)new LifecycleObserver()
      {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy()
        {
          AppMethodBeat.i(204702);
          FinderVideoRecycler localFinderVideoRecycler = this.sfE;
          FinderVideoRecycler.a(localFinderVideoRecycler, FinderVideoRecycler.b(localFinderVideoRecycler) - 1);
          if (FinderVideoRecycler.b(this.sfE) == 0) {
            FinderVideoRecycler.c(this.sfE);
          }
          for (;;)
          {
            FinderVideoRecycler.d(this.sfE).remove(str);
            paramMMActivity.getLifecycle().removeObserver((LifecycleObserver)this);
            AppMethodBeat.o(204702);
            return;
            localFinderVideoRecycler = this.sfE;
            Context localContext = (Context)paramMMActivity;
            k.h(localContext, "context");
            j.a((Iterable)localFinderVideoRecycler.sfu, (d.g.a.b)new FinderVideoRecycler.o(localContext));
            v.d locald = new v.d();
            locald.KUO = 0;
            localFinderVideoRecycler.B((d.g.a.b)new FinderVideoRecycler.p(localFinderVideoRecycler, localContext, locald));
            ac.i("Finder.VideoRecycler", "[removeByContext] simpleName=" + localContext.getClass().getSimpleName() + " removeCount=" + locald.KUO + " videoCount=" + FinderVideoRecycler.a(localFinderVideoRecycler));
          }
        }
      });
    }
    AppMethodBeat.o(204721);
  }
  
  public final void eX(final Context paramContext)
  {
    AppMethodBeat.i(204735);
    com.tencent.mm.ac.c.g((d.g.a.a)new k(this, paramContext));
    AppMethodBeat.o(204735);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "", "onRecycledCompleted", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract boolean a(com.tencent.mm.plugin.finder.video.o paramo);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    c(FinderVideoRecycler paramFinderVideoRecycler, Class paramClass, v.e parame, int[] paramArrayOfInt, boolean paramBoolean, v.f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$getOrCreate$3$1$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "onRecycledCompleted", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$$special$$inlined$let$lambda$1"})
  public static final class d
    implements FinderVideoRecycler.b
  {
    d(int paramInt, FinderVideoRecycler paramFinderVideoRecycler, Class paramClass, ViewGroup paramViewGroup, String paramString, d.g.a.b paramb, Context paramContext, boolean paramBoolean) {}
    
    public final boolean a(com.tencent.mm.plugin.finder.video.o paramo)
    {
      AppMethodBeat.i(204698);
      k.h(paramo, "videoView");
      if (k.g((String)FinderVideoRecycler.j(localFinderVideoRecycler).get(Integer.valueOf(this.sfJ)), str))
      {
        ac.i("Finder.VideoRecycler", "[getOrCreate] wait for callback successfully. mediaId=" + str + " parent=" + this.sfJ);
        this.sfN.ay(paramo);
        AppMethodBeat.o(204698);
        return true;
      }
      ac.i("Finder.VideoRecycler", "wait for callback, but it(" + str + ") has been replace(" + (String)FinderVideoRecycler.j(localFinderVideoRecycler).get(Integer.valueOf(this.sfJ)) + "). key=" + this.sfJ);
      AppMethodBeat.o(204698);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, y>
  {
    f(FinderVideoRecycler paramFinderVideoRecycler, ViewGroup paramViewGroup, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(FinderVideoRecycler paramFinderVideoRecycler) {}
    
    public final void run()
    {
      AppMethodBeat.i(204703);
      Iterator localIterator = ((Iterable)FinderVideoRecycler.e(this.sfE)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.finder.video.o localo = (com.tencent.mm.plugin.finder.video.o)((WeakReference)localIterator.next()).get();
        if (localo != null)
        {
          localo.onUIDestroy();
          localo.onRelease();
        }
      }
      FinderVideoRecycler.e(this.sfE).clear();
      FinderVideoRecycler.f(this.sfE).clear();
      FinderVideoRecycler.g(this.sfE).removeCallbacksAndMessages(null);
      AppMethodBeat.o(204703);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<np>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1$callback$1$1"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    j(FinderVideoRecycler paramFinderVideoRecycler, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "queueIdle"})
  static final class l
    implements MessageQueue.IdleHandler
  {
    l(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(204711);
      if ((FinderVideoRecycler.h(this.sfE) > 0) && (FinderVideoRecycler.i(this.sfE) < FinderVideoRecycler.h(this.sfE)) && (!FinderVideoRecycler.l(this.sfE)))
      {
        FinderVideoRecycler.f(this.sfE).add(FinderVideoRecycler.a(this.sfE, paramContext));
        FinderVideoRecycler localFinderVideoRecycler = this.sfE;
        FinderVideoRecycler.b(localFinderVideoRecycler, FinderVideoRecycler.i(localFinderVideoRecycler) + 1);
        AppMethodBeat.o(204711);
        return true;
      }
      ac.i("Finder.VideoRecycler", "[preInflateVideoView] completed! preInflateCount=" + FinderVideoRecycler.i(this.sfE) + " targetCount=" + FinderVideoRecycler.h(this.sfE) + " isFinished=" + FinderVideoRecycler.l(this.sfE));
      AppMethodBeat.o(204711);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    n(FinderVideoRecycler paramFinderVideoRecycler, com.tencent.mm.plugin.finder.video.o paramo, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class q
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public q(FinderVideoRecycler paramFinderVideoRecycler, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler
 * JD-Core Version:    0.7.0.1
 */