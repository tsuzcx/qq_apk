package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.video.FinderCropVideoView;
import com.tencent.mm.plugin.finder.video.FinderLivePlayView;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.s;
import com.tencent.mm.plugin.finder.video.v;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.a.j;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.e;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "()V", "activityCount", "", "aliveActivitySet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "createdVideoViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "headsetReceiver", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver;", "isFinished", "", "isForceWaitForRelease", "maxVideoCount", "onHeadsetStateChangeListener", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "onHeadsetStateChangeListenerList", "Ljava/util/LinkedList;", "onlineVideoEventListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1;", "preInflateCount", "preInflateVideoCount", "recycledVideoViews", "releasingVideoViewMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "waitForCallback", "waitRecycledCallbacks", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "acrossCreatedVideoViews", "", "isRemoveFun", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "addOnHeadsetStateChangeListener", "listener", "clearAllShouldPlayResumeVideoView", "createVideoView", "context", "Landroid/content/Context;", "videoType", "isCropVideo", "findOldestVideoView", "clazz", "Ljava/lang/Class;", "isForce", "getOrCreate", "parent", "Landroid/view/ViewGroup;", "finderVideo", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "completedTo", "videoView", "getVideoCount", "make", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "isPreInflate", "onCleared", "onFinish", "onInit", "onPreloadComplete", "mediaId", "pauseAllVideo", "filter", "pauseAndRecycle", "isForceRemove", "isTryKeep", "pauseFocusVideo", "preInflateVideoView", "recycledVideoView", "releaseVideoView", "source", "removeByContext", "removeOnHeadsetStateChangeListener", "removeViewFromParent", "Landroid/view/View;", "resumeFocusVideo", "Companion", "IRecycledCallback", "plugin-finder_release"})
public final class as
  extends com.tencent.mm.ui.component.i<PluginFinder>
  implements au
{
  public static final a Bpl;
  private boolean Bpb;
  private int Bpc;
  private int Bpd;
  private final HashSet<s> Bpe;
  private final ConcurrentLinkedQueue<WeakReference<? extends s>> Bpf;
  private final HashMap<Integer, String> Bpg;
  private final HashMap<Integer, b> Bph;
  private final LinkedList<HeadsetReceiver.b> Bpi;
  private final HashMap<Integer, Object> Bpj;
  private final k Bpk;
  private boolean isFinished;
  private final MMHandler knk;
  private int xUX;
  private int xUY;
  private final HashSet<String> xUZ;
  private HeadsetReceiver.b zCi;
  private HeadsetReceiver zFi;
  
  static
  {
    AppMethodBeat.i(278195);
    Bpl = new a((byte)0);
    AppMethodBeat.o(278195);
  }
  
  public as()
  {
    AppMethodBeat.i(278194);
    this.Bpb = true;
    this.Bpc = 1;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.Bpe = new HashSet();
    this.Bpf = new ConcurrentLinkedQueue();
    this.Bpg = new HashMap();
    this.Bph = new HashMap();
    this.xUZ = new HashSet();
    this.Bpi = new LinkedList();
    this.zCi = ((HeadsetReceiver.b)new j(this));
    this.Bpj = new HashMap();
    this.Bpk = new k(this);
    AppMethodBeat.o(278194);
  }
  
  private final void a(final s params, String paramString)
  {
    AppMethodBeat.i(278182);
    if (this.Bpj.containsKey(Integer.valueOf(params.hashCode())))
    {
      Log.w("Finder.VideoRecycler", "[releaseVideoView] videoView=" + params.hashCode() + " is releasing, source=" + paramString);
      AppMethodBeat.o(278182);
      return;
    }
    final long l = System.currentTimeMillis();
    ((Map)this.Bpj).put(Integer.valueOf(params.hashCode()), new Object());
    eV(params.getVideoView());
    params.pause();
    StringBuilder localStringBuilder = new StringBuilder("[releaseVideoView] async release videoView(").append(params.hashCode()).append(") parent=");
    ViewParent localViewParent = params.getParentView();
    if (localViewParent != null) {}
    for (int i = localViewParent.hashCode();; i = 0)
    {
      Log.i("Finder.VideoRecycler", i + " source=" + paramString);
      com.tencent.mm.ae.d.h((kotlin.g.a.a)new p(this, params, l, paramString));
      AppMethodBeat.o(278182);
      return;
    }
  }
  
  private int aM(Class<? extends s> paramClass)
  {
    AppMethodBeat.i(278184);
    aa.d locald = new aa.d();
    locald.aaBA = 0;
    P((kotlin.g.a.b)new as.h(paramClass, locald));
    int i = locald.aaBA;
    AppMethodBeat.o(278184);
    return i;
  }
  
  private final s e(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(278177);
    long l = System.currentTimeMillis();
    Object localObject;
    if (paramInt == 1) {
      localObject = (s)new FinderVLogCompositionPlayView(paramContext);
    }
    for (;;)
    {
      this.Bpf.add(new WeakReference(localObject));
      Log.i("Finder.VideoRecycler", "[createVideoView] activity=" + paramContext.getClass().getSimpleName() + " videoCount=" + a(this) + ' ' + "videoView=" + localObject.getClass().getSimpleName() + " cost=" + (System.currentTimeMillis() - l) + "ms");
      AppMethodBeat.o(278177);
      return localObject;
      if (paramInt == 2)
      {
        localObject = (s)new FinderLivePlayView(paramContext);
      }
      else
      {
        localObject = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.thumbplayer.a.a.class);
        p.j(localObject, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
        if ((((com.tencent.mm.plugin.thumbplayer.a.a)localObject).isOpenTPPlayer()) && (!paramBoolean))
        {
          localObject = MMApplicationContext.getContext();
          p.j(localObject, "MMApplicationContext.getContext()");
          localObject = (s)new FinderThumbPlayerProxy((Context)localObject);
        }
        else
        {
          localObject = (s)new FinderCropVideoView(paramContext);
        }
      }
    }
  }
  
  private final boolean eV(View paramView)
  {
    AppMethodBeat.i(278179);
    if (paramView != null)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null)
      {
        ((Map)this.Bpg).put(Integer.valueOf(localViewParent.hashCode()), null);
        if (localViewParent == null)
        {
          paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(278179);
          throw paramView;
        }
        ((ViewGroup)localViewParent).removeView(paramView);
        Log.i("Finder.VideoRecycler", "[removeViewFromParent] parent=" + localViewParent.hashCode() + ", videoView=" + paramView.hashCode() + ", parentTag=" + ((ViewGroup)localViewParent).getTag());
        AppMethodBeat.o(278179);
        return true;
      }
    }
    AppMethodBeat.o(278179);
    return false;
  }
  
  private final void onFinish()
  {
    AppMethodBeat.i(278174);
    Log.i("Finder.VideoRecycler", "onFinish");
    this.isFinished = true;
    this.Bpk.dead();
    this.knk.post((Runnable)new i(this));
    this.xUZ.clear();
    this.Bph.clear();
    this.Bpi.clear();
    HeadsetReceiver localHeadsetReceiver = this.zFi;
    if (localHeadsetReceiver != null)
    {
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      localHeadsetReceiver.gd(localContext);
      AppMethodBeat.o(278174);
      return;
    }
    AppMethodBeat.o(278174);
  }
  
  public final void P(kotlin.g.a.b<? super s, Boolean> paramb)
  {
    AppMethodBeat.i(278183);
    p.k(paramb, "isRemoveFun");
    Iterator localIterator = this.Bpf.iterator();
    while (localIterator.hasNext())
    {
      s locals = (s)((WeakReference)localIterator.next()).get();
      if (locals != null)
      {
        if (((Boolean)paramb.invoke(locals)).booleanValue()) {
          localIterator.remove();
        }
      }
      else {
        localIterator.remove();
      }
    }
    AppMethodBeat.o(278183);
  }
  
  public final void Q(final kotlin.g.a.b<? super s, Boolean> paramb)
  {
    AppMethodBeat.i(278191);
    p.k(paramb, "filter");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new l(this, paramb));
    AppMethodBeat.o(278191);
  }
  
  public final void a(final ViewGroup paramViewGroup, final ac paramac, final kotlin.g.a.b<? super s, x> paramb)
  {
    AppMethodBeat.i(278180);
    p.k(paramViewGroup, "parent");
    p.k(paramac, "finderVideo");
    p.k(paramb, "completedTo");
    final Context localContext = paramViewGroup.getContext();
    Object localObject1 = paramac.dJw();
    final String str = paramac.aBv();
    paramac = aj.AGc;
    final int i = aj.h((csg)localObject1);
    paramac = aj.AGc;
    if (aj.g((csg)localObject1))
    {
      paramac = aj.AGc;
      if (!aj.i((csg)localObject1)) {}
    }
    for (final boolean bool1 = true;; bool1 = false)
    {
      localObject1 = paramViewGroup.findViewWithTag(Integer.valueOf(paramViewGroup.hashCode()));
      paramac = (ac)localObject1;
      if (!(localObject1 instanceof s)) {
        paramac = null;
      }
      paramac = (s)paramac;
      if ((paramac == null) || ((paramac.getVideoMediaId() != null) && (!p.h(paramac.getVideoMediaId(), str)))) {
        break;
      }
      paramac.setTag(b.f.finder_video_view_usage_update_time, Long.valueOf(SystemClock.uptimeMillis()));
      paramb.invoke(paramac);
      AppMethodBeat.o(278180);
      return;
    }
    if (paramac != null) {}
    for (paramac = paramac.getVideoView();; paramac = null)
    {
      eV(paramac);
      if (!this.Bpb) {
        break label317;
      }
      paramac = (String)this.Bpg.get(Integer.valueOf(paramViewGroup.hashCode()));
      if (!p.h(paramac, str)) {
        break;
      }
      AppMethodBeat.o(278180);
      return;
    }
    label317:
    label372:
    final as localas;
    Object localObject2;
    if (paramac != null)
    {
      ((Map)this.Bpg).put(Integer.valueOf(paramViewGroup.hashCode()), str);
      Log.i("Finder.VideoRecycler", "replace callback. " + paramac + " => " + str + ", parent=" + paramViewGroup.hashCode());
      localObject1 = (kotlin.g.a.b)new g(this, paramViewGroup, paramb);
      if (i != 0) {
        break label1034;
      }
      paramac = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.thumbplayer.a.a.class);
      p.j(paramac, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
      if ((!((com.tencent.mm.plugin.thumbplayer.a.a)paramac).isOpenTPPlayer()) || (bool1)) {
        break label1027;
      }
      paramac = FinderThumbPlayerProxy.class;
      paramb = (s)com.tencent.mm.ae.d.a(this.Bpe, (kotlin.g.a.b)new f(localContext, paramac));
      if (paramb != null)
      {
        Log.i("Finder.VideoRecycler", "[getOrCreate] get a recycled videoView(" + paramb.hashCode() + ") parent=" + paramViewGroup.hashCode() + " videoCount=" + a(this));
        ((kotlin.g.a.b)localObject1).invoke(paramb);
        if (paramb != null) {}
      }
      else
      {
        localas = (as)this;
        int j = localas.aM(paramac);
        if (j < localas.Bpc) {
          break label1158;
        }
        final boolean bool2 = localas.Bpb;
        paramb = new aa.e();
        paramb.aaBB = 9223372036854775807L;
        localObject2 = new aa.f();
        ((aa.f)localObject2).aaBC = null;
        localas.P((kotlin.g.a.b)new d(localas, paramac, paramb, new int[2], bool2, (aa.f)localObject2));
        StringBuilder localStringBuilder = new StringBuilder("[findOldestVideoView] activity=");
        paramb = (s)((aa.f)localObject2).aaBC;
        if (paramb == null) {
          break label1054;
        }
        paramb = paramb.getVideoView();
        if (paramb == null) {
          break label1054;
        }
        paramb = paramb.getContext();
        if (paramb == null) {
          break label1054;
        }
        paramb = paramb.getClass();
        if (paramb == null) {
          break label1054;
        }
        paramb = paramb.getSimpleName();
        label611:
        localStringBuilder = localStringBuilder.append(paramb).append(" mediaid:");
        paramb = (s)((aa.f)localObject2).aaBC;
        if (paramb == null) {
          break label1059;
        }
        paramb = paramb.getVideoMediaId();
        label645:
        localStringBuilder = localStringBuilder.append(paramb).append(" videoView=");
        paramb = (s)((aa.f)localObject2).aaBC;
        if (paramb == null) {
          break label1064;
        }
        paramb = Integer.valueOf(paramb.hashCode());
        label680:
        localStringBuilder = localStringBuilder.append(paramb).append(' ').append("isAttachedToWindow=");
        paramb = (s)((aa.f)localObject2).aaBC;
        if (paramb == null) {
          break label1069;
        }
        paramb = paramb.getVideoView();
        if (paramb == null) {
          break label1069;
        }
        paramb = Boolean.valueOf(paramb.isAttachedToWindow());
        label731:
        localStringBuilder = localStringBuilder.append(paramb).append(" parent=");
        paramb = (s)((aa.f)localObject2).aaBC;
        if (paramb == null) {
          break label1074;
        }
        paramb = paramb.getParentView();
        if (paramb == null) {
          break label1074;
        }
        paramb = Integer.valueOf(paramb.hashCode());
        label777:
        Log.i("Finder.VideoRecycler", paramb);
        localObject2 = (s)((aa.f)localObject2).aaBC;
        localStringBuilder = new StringBuilder("[getOrCreate] over count(max=").append(localas.Bpc).append(':').append(j).append(") waitForRelease=").append(localas.Bpb).append(" oldest=");
        if (localObject2 == null) {
          break label1079;
        }
        paramb = Integer.valueOf(localObject2.hashCode());
        label866:
        Log.i("Finder.VideoRecycler", paramb);
        if (!localas.Bpb) {
          break label1113;
        }
        if (localObject2 == null) {
          break label1084;
        }
        j = paramViewGroup.hashCode();
        ((Map)localas.Bpg).put(Integer.valueOf(j), str);
        ((Map)localas.Bph).put(Integer.valueOf(localObject2.hashCode()), new e(j, localas, paramac, paramViewGroup, str, (kotlin.g.a.b)localObject1, localContext, i, bool1));
        localas.a((s)localObject2, "getOrCreate");
      }
    }
    for (;;)
    {
      paramViewGroup = x.aazN;
      AppMethodBeat.o(278180);
      return;
      Log.i("Finder.VideoRecycler", "wait for callback. mediaId=" + str + " parent=" + paramViewGroup.hashCode());
      break;
      label1027:
      paramac = FinderCropVideoView.class;
      break label372;
      label1034:
      if (i == 2)
      {
        paramac = FinderLivePlayView.class;
        break label372;
      }
      paramac = FinderVLogCompositionPlayView.class;
      break label372;
      label1054:
      paramb = null;
      break label611;
      label1059:
      paramb = null;
      break label645;
      label1064:
      paramb = null;
      break label680;
      label1069:
      paramb = null;
      break label731;
      label1074:
      paramb = null;
      break label777;
      label1079:
      paramb = null;
      break label866;
      label1084:
      Log.e("Finder.VideoRecycler", "[getOrCreate] oldest is null! parent=" + paramViewGroup.hashCode());
      continue;
      label1113:
      if (localObject2 != null) {
        localas.a((s)localObject2, "getOrCreate");
      }
      p.j(localContext, "context");
      ((kotlin.g.a.b)localObject1).invoke(localas.e(localContext, i, bool1));
      continue;
      label1158:
      p.j(localContext, "context");
      ((kotlin.g.a.b)localObject1).invoke(localas.e(localContext, i, bool1));
    }
  }
  
  public final void a(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(278181);
    p.k(paramViewGroup, "parent");
    ((Map)this.Bpg).put(Integer.valueOf(paramViewGroup.hashCode()), null);
    paramViewGroup = paramViewGroup.findViewWithTag(Integer.valueOf(paramViewGroup.hashCode()));
    if (!(paramViewGroup instanceof s))
    {
      AppMethodBeat.o(278181);
      return;
    }
    paramViewGroup = (s)paramViewGroup;
    Log.i("Finder.VideoRecycler", "[pauseOrRecycle] pauseWithCancel mediaId:" + paramViewGroup.getVideoMediaId() + " videoView(" + paramViewGroup.hashCode() + ") isForceRemove=" + paramBoolean1 + " isTryKeep=" + paramBoolean2);
    paramViewGroup.setVideoViewFocused(false);
    if ((paramBoolean2) || (!paramBoolean1))
    {
      paramViewGroup.egW();
      AppMethodBeat.o(278181);
      return;
    }
    a(paramViewGroup, "pauseAndRecycle");
    AppMethodBeat.o(278181);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(278172);
    p.k(paramAppCompatActivity, "activity");
    String str = String.valueOf(paramAppCompatActivity.hashCode());
    Object localObject1;
    Object localObject2;
    if (this.xUY == 0)
    {
      this.isFinished = false;
      this.Bpk.alive();
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      localObject1 = com.tencent.mm.plugin.finder.storage.d.dSW();
      this.Bpc = ((Number)((o)localObject1).Mx).intValue();
      this.Bpb = ((Boolean)((o)localObject1).My).booleanValue();
      this.Bpd = kotlin.k.i.ow(this.Bpc - 1, 4);
      this.zFi = new HeadsetReceiver();
      localObject1 = this.zFi;
      if (localObject1 != null)
      {
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        ((HeadsetReceiver)localObject1).a((Context)localObject2, this.zCi);
      }
      Log.i("Finder.VideoRecycler", "[onInit] maxVideoCount=" + this.Bpc + " preInflateCount=" + this.Bpd + " waitForRelease=" + this.Bpb);
    }
    if (this.xUZ.add(str))
    {
      Log.i("Finder.VideoRecycler", "[register] activity=" + paramAppCompatActivity.getClass().getSimpleName() + " isPreInflate=" + paramBoolean);
      if (paramBoolean)
      {
        localObject1 = (Context)paramAppCompatActivity;
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject2 = Looper.getMainLooper();
          p.j(localObject2, "Looper.getMainLooper()");
          ((Looper)localObject2).getQueue().addIdleHandler((MessageQueue.IdleHandler)new n(this, (Context)localObject1));
        }
      }
      this.xUY += 1;
      paramAppCompatActivity.getLifecycle().a((k)new FinderVideoRecycler.make.1(this, paramAppCompatActivity, str));
    }
    AppMethodBeat.o(278172);
  }
  
  public final void a(HeadsetReceiver.b paramb)
  {
    AppMethodBeat.i(278175);
    p.k(paramb, "listener");
    this.Bpi.add(paramb);
    AppMethodBeat.o(278175);
  }
  
  public final void aGE(String paramString)
  {
    AppMethodBeat.i(278173);
    p.k(paramString, "mediaId");
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXi().aSr()).intValue() != 1)
    {
      AppMethodBeat.o(278173);
      return;
    }
    localObject = ((Iterable)this.Bpf).iterator();
    while (((Iterator)localObject).hasNext())
    {
      s locals = (s)((WeakReference)((Iterator)localObject).next()).get();
      if (locals != null)
      {
        String str = locals.getVideoMediaId();
        if (str != null)
        {
          Log.i("Finder.VideoRecycler", "onPreloadComplete " + str + ' ' + paramString);
          if (p.h(str, paramString)) {
            locals.egw();
          }
        }
      }
    }
    AppMethodBeat.o(278173);
  }
  
  public final void b(HeadsetReceiver.b paramb)
  {
    AppMethodBeat.i(278176);
    p.k(paramb, "listener");
    this.Bpi.remove(paramb);
    AppMethodBeat.o(278176);
  }
  
  public final void elA()
  {
    AppMethodBeat.i(278190);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(278190);
  }
  
  public final void ga(final Context paramContext)
  {
    AppMethodBeat.i(278186);
    p.k(paramContext, "context");
    j.a((Iterable)this.Bpe, (kotlin.g.a.b)new q(paramContext));
    final aa.d locald = new aa.d();
    locald.aaBA = 0;
    P((kotlin.g.a.b)new r(this, paramContext, locald));
    Log.i("Finder.VideoRecycler", "[removeByContext] simpleName=" + paramContext.getClass().getSimpleName() + " removeCount=" + locald.aaBA + " videoCount=" + a(this));
    AppMethodBeat.o(278186);
  }
  
  public final void gb(final Context paramContext)
  {
    AppMethodBeat.i(278188);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new m(this, paramContext));
    AppMethodBeat.o(278188);
  }
  
  public final void gc(final Context paramContext)
  {
    AppMethodBeat.i(278189);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new s(this, paramContext));
    AppMethodBeat.o(278189);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(278187);
    Log.i("Finder.VideoRecycler", "[onCleared] videoCount=" + a(this));
    onFinish();
    AppMethodBeat.o(278187);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "", "onRecycledCompleted", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract boolean a(s params);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(as paramas)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<s, Boolean>
  {
    d(as paramas, Class paramClass, aa.e parame, int[] paramArrayOfInt, boolean paramBoolean, aa.f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$getOrCreate$3$1$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "onRecycledCompleted", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$$special$$inlined$let$lambda$1"})
  public static final class e
    implements as.b
  {
    e(int paramInt1, as paramas, Class paramClass, ViewGroup paramViewGroup, String paramString, kotlin.g.a.b paramb, Context paramContext, int paramInt2, boolean paramBoolean) {}
    
    public final boolean a(s params)
    {
      AppMethodBeat.i(278742);
      p.k(params, "videoView");
      if (p.h((String)as.k(localas).get(Integer.valueOf(this.Bps)), str))
      {
        Log.i("Finder.VideoRecycler", "[getOrCreate] wait for callback successfully. mediaId=" + str + " parent=" + this.Bps);
        this.Bpv.invoke(params);
        AppMethodBeat.o(278742);
        return true;
      }
      Log.i("Finder.VideoRecycler", "wait for callback, but it(" + str + ") has been replace(" + (String)as.k(localas).get(Integer.valueOf(this.Bps)) + "). key=" + this.Bps);
      AppMethodBeat.o(278742);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<s, Boolean>
  {
    f(Context paramContext, Class paramClass)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<s, x>
  {
    g(as paramas, ViewGroup paramViewGroup, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(as paramas) {}
    
    public final void run()
    {
      AppMethodBeat.i(269372);
      Object localObject1 = new StringBuilder("onFinish createdVideoViews ");
      Object localObject3 = (Iterable)as.e(this.Bpm);
      Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(Integer.valueOf(((WeakReference)((Iterator)localObject3).next()).hashCode()));
      }
      Log.i("Finder.VideoRecycler", (List)localObject2);
      localObject1 = ((Iterable)as.e(this.Bpm)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (s)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null)
        {
          ((s)localObject2).onUIDestroy();
          ((s)localObject2).onRelease();
        }
      }
      as.e(this.Bpm).clear();
      as.f(this.Bpm).clear();
      as.g(this.Bpm).removeCallbacksAndMessages(null);
      AppMethodBeat.o(269372);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onHeadsetStateChangeListener$1", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "onHeadsetStateChange", "", "on", "", "plugin-finder_release"})
  public static final class j
    implements HeadsetReceiver.b
  {
    public final void pR(boolean paramBoolean)
    {
      AppMethodBeat.i(257511);
      Log.i("Finder.VideoRecycler", "onHeadsetStateChange on:".concat(String.valueOf(paramBoolean)));
      Iterator localIterator = ((Iterable)as.m(this.Bpm)).iterator();
      while (localIterator.hasNext()) {
        ((HeadsetReceiver.b)localIterator.next()).pR(paramBoolean);
      }
      AppMethodBeat.o(257511);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class k
    extends IListener<pn>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1$callback$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.b<s, Boolean>
    {
      a(String paramString, as.k paramk)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(as paramas, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(as paramas, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "queueIdle"})
  static final class n
    implements MessageQueue.IdleHandler
  {
    n(as paramas, Context paramContext) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(224279);
      if ((as.h(this.Bpm) > 0) && (as.i(this.Bpm) < as.h(this.Bpm)) && (!as.j(this.Bpm)))
      {
        as.f(this.Bpm).add(as.a(this.Bpm, this.$context));
        as localas = this.Bpm;
        as.b(localas, as.i(localas) + 1);
        AppMethodBeat.o(224279);
        return true;
      }
      Log.i("Finder.VideoRecycler", "[preInflateVideoView] completed! preInflateCount=" + as.i(this.Bpm) + " targetCount=" + as.h(this.Bpm) + " isFinished=" + as.j(this.Bpm));
      AppMethodBeat.o(224279);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(as paramas, s params, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.b<s, Boolean>
  {
    q(Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.b<s, Boolean>
  {
    r(as paramas, Context paramContext, aa.d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<x>
  {
    s(as paramas, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.as
 * JD-Core Version:    0.7.0.1
 */