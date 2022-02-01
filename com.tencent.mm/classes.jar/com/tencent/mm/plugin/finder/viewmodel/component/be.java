package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.publish.c;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.FinderCropVideoView;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.n;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.e;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "()V", "activityCount", "", "aliveActivitySet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "createdVideoViews", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "headsetReceiver", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver;", "isFinished", "", "isForceWaitForRelease", "maxVideoCount", "onHeadsetStateChangeListener", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "onHeadsetStateChangeListenerList", "Ljava/util/LinkedList;", "onlineVideoEventListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$onlineVideoEventListener$1;", "preInflateCount", "preInflateVideoCount", "recentFocusView", "recentFocusViewParent", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "recycledVideoViews", "releasingVideoViewMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "waitForCallback", "waitRecycledCallbacks", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "acrossCreatedVideoViews", "", "isRemoveFun", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "addOnHeadsetStateChangeListener", "listener", "clearAllShouldPlayResumeVideoView", "createVideoView", "context", "Landroid/content/Context;", "videoType", "isCropVideo", "findOldestVideoView", "clazz", "Ljava/lang/Class;", "isForce", "getFocusView", "getFtppTag", "mediaId", "getOrCreate", "parent", "Landroid/view/ViewGroup;", "finderVideo", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "completedTo", "videoView", "getRenderViewCount", "renderViewClazz", "Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView;", "getVideoCount", "make", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "isPreInflate", "markRecentFocusView", "onCleared", "onFinish", "onInit", "onPreloadComplete", "pauseAllVideo", "filter", "pauseAndRecycle", "isForceRemove", "isTryKeep", "pauseFocusVideo", "preInflateVideoView", "recycledVideoView", "releaseUnFocusView", "releaseVideoView", "source", "removeByContext", "removeOnHeadsetStateChangeListener", "removeViewFromParent", "Landroid/view/View;", "resumeFocusVideo", "setAttachVideoMute", "isMute", "Companion", "IRecycledCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
  extends n<PluginFinder>
  implements bi
{
  public static final be.a GVF;
  private HeadsetReceiver.b EEW;
  private HeadsetReceiver EKB;
  private int EKf;
  private final HashSet<String> EKg;
  private boolean GVG;
  private int GVH;
  private int GVI;
  private final HashSet<t> GVJ;
  public final ConcurrentLinkedQueue<WeakReference<? extends t>> GVK;
  private final HashMap<Integer, String> GVL;
  private final HashMap<Integer, be.b> GVM;
  private final LinkedList<HeadsetReceiver.b> GVN;
  private t GVO;
  private FinderVideoLayout GVP;
  private final HashMap<Integer, Object> GVQ;
  private final FinderVideoRecycler.onlineVideoEventListener.1 GVR;
  private boolean isFinished;
  private final MMHandler mRi;
  
  static
  {
    AppMethodBeat.i(338512);
    GVF = new be.a((byte)0);
    AppMethodBeat.o(338512);
  }
  
  public be()
  {
    AppMethodBeat.i(338362);
    this.GVG = true;
    this.GVH = 1;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.GVJ = new HashSet();
    this.GVK = new ConcurrentLinkedQueue();
    this.GVL = new HashMap();
    this.GVM = new HashMap();
    this.EKg = new HashSet();
    this.GVN = new LinkedList();
    this.EEW = ((HeadsetReceiver.b)new be.j(this));
    this.GVQ = new HashMap();
    this.GVR = new FinderVideoRecycler.onlineVideoEventListener.1(this, f.hfK);
    AppMethodBeat.o(338362);
  }
  
  private static String a(String paramString, t paramt)
  {
    AppMethodBeat.i(338419);
    if ((paramt instanceof FinderThumbPlayerProxy))
    {
      paramString = "ftpp:" + ((FinderThumbPlayerProxy)paramt).getFTPPTag() + " mediaId:" + paramString;
      AppMethodBeat.o(338419);
      return paramString;
    }
    paramString = s.X("mediaId:", paramString);
    AppMethodBeat.o(338419);
    return paramString;
  }
  
  private final void a(t paramt, String paramString)
  {
    AppMethodBeat.i(338405);
    if (this.GVQ.containsKey(Integer.valueOf(paramt.hashCode())))
    {
      Log.w("Finder.VideoRecycler", "[releaseVideoView] videoView=" + paramt.hashCode() + " is releasing, source=" + paramString);
      AppMethodBeat.o(338405);
      return;
    }
    final long l = System.currentTimeMillis();
    ((Map)this.GVQ).put(Integer.valueOf(paramt.hashCode()), new Object());
    hm(paramt.getVideoView());
    paramt.pause();
    StringBuilder localStringBuilder = new StringBuilder("[releaseVideoView] async release videoView(").append(paramt.hashCode()).append(") parent=");
    ViewParent localViewParent = paramt.getParentView();
    if (localViewParent != null) {}
    for (int i = localViewParent.hashCode();; i = 0)
    {
      Log.i("Finder.VideoRecycler", i + " source=" + paramString);
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new n(paramt, this, l, paramString));
      AppMethodBeat.o(338405);
      return;
    }
  }
  
  private static final void b(be parambe)
  {
    AppMethodBeat.i(338430);
    s.u(parambe, "this$0");
    Object localObject2 = (Iterable)parambe.GVK;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Integer.valueOf(((WeakReference)((Iterator)localObject2).next()).hashCode()));
    }
    Log.i("Finder.VideoRecycler", s.X("onFinish createdVideoViews ", (List)localObject1));
    localObject1 = ((Iterable)parambe.GVK).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (t)((WeakReference)((Iterator)localObject1).next()).get();
      if (localObject2 != null)
      {
        ((t)localObject2).onUIDestroy();
        ((t)localObject2).onRelease();
      }
    }
    parambe.GVK.clear();
    parambe.GVJ.clear();
    parambe.mRi.removeCallbacksAndMessages(null);
    AppMethodBeat.o(338430);
  }
  
  private final t e(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(338386);
    long l = System.currentTimeMillis();
    Object localObject;
    if (paramInt == 1)
    {
      localObject = (t)((c)h.az(c.class)).publishVlogApi().gK(paramContext);
      ((t)localObject).setContextTag(paramContext.hashCode());
    }
    for (;;)
    {
      this.GVK.add(new WeakReference(localObject));
      Log.i("Finder.VideoRecycler", "[createVideoView] activity=" + paramContext.getClass().getSimpleName() + " videoCount=" + a(this) + " videoView=" + localObject.getClass().getSimpleName() + " cost=" + (System.currentTimeMillis() - l) + "ms");
      AppMethodBeat.o(338386);
      return localObject;
      if (paramInt == 2)
      {
        localObject = (com.tencent.mm.plugin.g)h.ax(com.tencent.mm.plugin.g.class);
        Context localContext = MMApplicationContext.getContext();
        s.s(localContext, "getContext()");
        localObject = ((com.tencent.mm.plugin.g)localObject).eo(localContext);
        ((t)localObject).setContextTag(paramContext.hashCode());
      }
      else if ((((com.tencent.mm.plugin.thumbplayer.a.a)h.az(com.tencent.mm.plugin.thumbplayer.a.a.class)).isOpenTPPlayer()) && (!paramBoolean))
      {
        localObject = MMApplicationContext.getContext();
        s.s(localObject, "getContext()");
        localObject = new FinderThumbPlayerProxy((Context)localObject);
        ((FinderThumbPlayerProxy)localObject).setContextTag(paramContext.hashCode());
        localObject = (t)localObject;
      }
      else
      {
        localObject = new FinderCropVideoView(paramContext);
        ((FinderCropVideoView)localObject).setContextTag(paramContext.hashCode());
        localObject = (t)localObject;
      }
    }
  }
  
  private final boolean hm(View paramView)
  {
    AppMethodBeat.i(338395);
    if (paramView != null)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null)
      {
        ((Map)this.GVL).put(Integer.valueOf(localViewParent.hashCode()), null);
        ((ViewGroup)localViewParent).removeView(paramView);
        Log.i("Finder.VideoRecycler", "[removeViewFromParent] parent=" + localViewParent.hashCode() + ", videoView=" + paramView.hashCode() + ", parentTag=" + ((ViewGroup)localViewParent).getTag());
        AppMethodBeat.o(338395);
        return true;
      }
    }
    AppMethodBeat.o(338395);
    return false;
  }
  
  private final void onFinish()
  {
    AppMethodBeat.i(338371);
    Log.i("Finder.VideoRecycler", "onFinish");
    this.isFinished = true;
    this.GVO = null;
    this.GVP = null;
    this.GVR.dead();
    this.mRi.post(new be..ExternalSyntheticLambda0(this));
    this.EKg.clear();
    this.GVM.clear();
    this.GVN.clear();
    HeadsetReceiver localHeadsetReceiver = this.EKB;
    if (localHeadsetReceiver != null)
    {
      Context localContext = MMApplicationContext.getContext();
      s.s(localContext, "getContext()");
      localHeadsetReceiver.hy(localContext);
    }
    AppMethodBeat.o(338371);
  }
  
  public final void a(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.loader.x paramx, final b<? super t, ah> paramb)
  {
    AppMethodBeat.i(338569);
    s.u(paramViewGroup, "parent");
    s.u(paramx, "finderVideo");
    s.u(paramb, "completedTo");
    Context localContext = paramViewGroup.getContext();
    Object localObject1 = paramx.eCF();
    String str = paramx.aUt();
    paramx = av.GiL;
    int i = av.j((dji)localObject1);
    paramx = av.GiL;
    boolean bool1;
    if (av.i((dji)localObject1))
    {
      paramx = av.GiL;
      if (av.k((dji)localObject1))
      {
        bool1 = true;
        paramx = paramViewGroup.findViewWithTag(Integer.valueOf(paramViewGroup.hashCode()));
        if (!(paramx instanceof t)) {
          break label201;
        }
      }
    }
    label201:
    for (paramx = (t)paramx;; paramx = null)
    {
      if ((paramx == null) || ((paramx.getVideoMediaId() != null) && (!s.p(paramx.getVideoMediaId(), str))) || (paramx.getPlayer() == null)) {
        break label206;
      }
      Log.i("Finder.VideoRecycler", s.X("getOrCreate hit cache for ", a(str, paramx)));
      paramx.setTag(e.e.finder_video_view_usage_update_time, Long.valueOf(SystemClock.uptimeMillis()));
      paramb.invoke(paramx);
      AppMethodBeat.o(338569);
      return;
      bool1 = false;
      break;
    }
    label206:
    if (paramx == null) {}
    for (paramx = null;; paramx = paramx.getVideoView())
    {
      hm(paramx);
      if (!this.GVG) {
        break label342;
      }
      paramx = (String)this.GVL.get(Integer.valueOf(paramViewGroup.hashCode()));
      if (!s.p(paramx, str)) {
        break;
      }
      AppMethodBeat.o(338569);
      return;
    }
    label342:
    Object localObject2;
    if (paramx != null)
    {
      ((Map)this.GVL).put(Integer.valueOf(paramViewGroup.hashCode()), str);
      Log.i("Finder.VideoRecycler", "replace callback. " + paramx + " => " + str + ", parent=" + paramViewGroup.hashCode());
      localObject1 = (b)new g(paramViewGroup, this, paramb);
      switch (i)
      {
      case 1: 
      default: 
        paramx = (Class)((c)h.az(c.class)).publishVlogApi().eLd();
        label407:
        paramb = (t)com.tencent.mm.ae.d.a(this.GVJ, (b)new be.e(paramx, localContext));
        if (paramb == null)
        {
          paramb = null;
          label437:
          if (paramb != null) {
            break label1334;
          }
          paramb = (be)this;
          int j = paramb.bh(paramx) - paramb.GVQ.size();
          if (j < paramb.GVH) {
            break label1294;
          }
          final boolean bool2 = paramb.GVG;
          Log.i("Finder.VideoRecycler", s.X("findOldestVideoView createdVideoViews size:", Integer.valueOf(paramb.GVK.size())));
          Object localObject3 = new ah.e();
          ((ah.e)localObject3).aixc = 9223372036854775807L;
          localObject2 = new ah.f();
          paramb.av((b)new d(paramx, (ah.e)localObject3, new int[2], bool2, paramb, (ah.f)localObject2));
          localObject3 = new StringBuilder("[findOldestVideoView] activity=");
          paramx = (t)((ah.f)localObject2).aqH;
          if (paramx != null) {
            break label1005;
          }
          paramx = null;
          label576:
          localObject3 = ((StringBuilder)localObject3).append(paramx).append(" mediaid:");
          paramx = (t)((ah.f)localObject2).aqH;
          if (paramx != null) {
            break label1057;
          }
          paramx = null;
          label605:
          localObject3 = ((StringBuilder)localObject3).append(paramx).append(" videoView=");
          paramx = (t)((ah.f)localObject2).aqH;
          if (paramx != null) {
            break label1067;
          }
          paramx = null;
          label634:
          localObject3 = ((StringBuilder)localObject3).append(paramx).append(" isAttachedToWindow=");
          paramx = (t)((ah.f)localObject2).aqH;
          if (paramx != null) {
            break label1078;
          }
          paramx = null;
          label663:
          localObject3 = ((StringBuilder)localObject3).append(paramx).append(" parent=");
          paramx = (t)((ah.f)localObject2).aqH;
          if (paramx != null) {
            break label1105;
          }
          paramx = null;
          label692:
          Log.i("Finder.VideoRecycler", paramx);
          localObject2 = (t)((ah.f)localObject2).aqH;
          localObject3 = new StringBuilder("[getOrCreate] over count(max=").append(paramb.GVH).append(':').append(j).append(") releasingVideoSize:").append(paramb.GVQ.size()).append(" waitForRelease=").append(paramb.GVG).append(" oldest=");
          if (localObject2 != null) {
            break label1132;
          }
          paramx = null;
          label788:
          Log.i("Finder.VideoRecycler", paramx);
          if (!paramb.GVG) {
            break label1228;
          }
          if (localObject2 != null) {
            break label1144;
          }
        }
        break;
      }
    }
    for (paramx = null;; paramx = ah.aiuX)
    {
      if (paramx != null) {
        break label1221;
      }
      Log.e("Finder.VideoRecycler", s.X("[getOrCreate] oldest is null! parent=", Integer.valueOf(paramViewGroup.hashCode())));
      AppMethodBeat.o(338569);
      return;
      Log.i("Finder.VideoRecycler", "wait for callback. mediaId=" + str + " parent=" + paramViewGroup.hashCode());
      break;
      if ((((com.tencent.mm.plugin.thumbplayer.a.a)h.az(com.tencent.mm.plugin.thumbplayer.a.a.class)).isOpenTPPlayer()) && (!bool1))
      {
        paramx = FinderThumbPlayerProxy.class;
        break label407;
      }
      paramx = FinderCropVideoView.class;
      break label407;
      paramx = ((com.tencent.mm.plugin.g)h.ax(com.tencent.mm.plugin.g.class)).bUt();
      break label407;
      Log.i("Finder.VideoRecycler", "[getOrCreate] get a recycled videoView(" + paramb.hashCode() + ") parent=" + paramViewGroup.hashCode() + " videoCount=" + a(this));
      ((b)localObject1).invoke(paramb);
      break label437;
      label1005:
      paramx = paramx.getVideoView();
      if (paramx == null)
      {
        paramx = null;
        break label576;
      }
      paramx = paramx.getContext();
      if (paramx == null)
      {
        paramx = null;
        break label576;
      }
      paramx = paramx.getClass();
      if (paramx == null)
      {
        paramx = null;
        break label576;
      }
      paramx = paramx.getSimpleName();
      break label576;
      label1057:
      paramx = paramx.getVideoMediaId();
      break label605;
      label1067:
      paramx = Integer.valueOf(paramx.hashCode());
      break label634;
      label1078:
      paramx = paramx.getVideoView();
      if (paramx == null)
      {
        paramx = null;
        break label663;
      }
      paramx = Boolean.valueOf(paramx.isAttachedToWindow());
      break label663;
      label1105:
      paramx = paramx.getParentView();
      if (paramx == null)
      {
        paramx = null;
        break label692;
      }
      paramx = Integer.valueOf(paramx.hashCode());
      break label692;
      label1132:
      paramx = Integer.valueOf(localObject2.hashCode());
      break label788;
      label1144:
      i = paramViewGroup.hashCode();
      ((Map)paramb.GVL).put(Integer.valueOf(i), str);
      ((Map)paramb.GVM).put(Integer.valueOf(localObject2.hashCode()), new be.f(paramb, i, str, (b)localObject1));
      paramb.a((t)localObject2, "getOrCreate");
    }
    label1221:
    AppMethodBeat.o(338569);
    return;
    label1228:
    if (localObject2 != null) {
      paramb.a((t)localObject2, "getOrCreate");
    }
    Log.i("Finder.VideoRecycler", s.X("getOrCreate hit create and release old for ", a(str, (t)localObject2)));
    s.s(localContext, "context");
    ((b)localObject1).invoke(paramb.e(localContext, i, bool1));
    AppMethodBeat.o(338569);
    return;
    label1294:
    Log.i("Finder.VideoRecycler", s.X("getOrCreate hit create for mediaId:", str));
    s.s(localContext, "context");
    ((b)localObject1).invoke(paramb.e(localContext, i, bool1));
    label1334:
    AppMethodBeat.o(338569);
  }
  
  public final void a(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(338577);
    s.u(paramViewGroup, "parent");
    ((Map)this.GVL).put(Integer.valueOf(paramViewGroup.hashCode()), null);
    paramViewGroup = paramViewGroup.findViewWithTag(Integer.valueOf(paramViewGroup.hashCode()));
    if (!(paramViewGroup instanceof t))
    {
      AppMethodBeat.o(338577);
      return;
    }
    paramViewGroup = (t)paramViewGroup;
    paramViewGroup.getVideoMediaId();
    Log.i("Finder.VideoRecycler", "[pauseOrRecycle] pauseWithCancel mediaId:" + paramViewGroup.getVideoMediaId() + " videoView(" + paramViewGroup.hashCode() + ") isForceRemove=" + paramBoolean1 + " isTryKeep=" + paramBoolean2);
    paramViewGroup.setVideoViewFocused(false);
    if ((paramBoolean2) || (!paramBoolean1))
    {
      paramViewGroup.eLK();
      AppMethodBeat.o(338577);
      return;
    }
    a(paramViewGroup, "pauseAndRecycle");
    AppMethodBeat.o(338577);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(338527);
    s.u(paramAppCompatActivity, "activity");
    String str = String.valueOf(paramAppCompatActivity.hashCode());
    if (this.EKf == 0)
    {
      this.isFinished = false;
      this.GVR.alive();
      Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      localObject = com.tencent.mm.plugin.finder.storage.d.eRj();
      this.GVH = ((Number)((r)localObject).bsC).intValue();
      this.GVG = ((Boolean)((r)localObject).bsD).booleanValue();
      this.GVI = k.qv(this.GVH - 1, 4);
      this.EKB = new HeadsetReceiver();
      localObject = this.EKB;
      if (localObject != null)
      {
        Context localContext = MMApplicationContext.getContext();
        s.s(localContext, "getContext()");
        ((HeadsetReceiver)localObject).a(localContext, this.EEW);
      }
      Log.i("Finder.VideoRecycler", "[onInit] maxVideoCount=" + this.GVH + " preInflateCount=" + this.GVI + " waitForRelease=" + this.GVG);
    }
    if (this.EKg.add(str))
    {
      Log.i("Finder.VideoRecycler", "[register] activity=" + paramAppCompatActivity.getClass().getSimpleName() + " key:" + str + " activityCount:" + this.EKf + " isPreInflate=" + paramBoolean);
      this.EKf += 1;
      paramAppCompatActivity.getLifecycle().addObserver((androidx.lifecycle.p)new FinderVideoRecycler.make.1(this, paramAppCompatActivity, str));
    }
    AppMethodBeat.o(338527);
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(338630);
    Log.i("Finder.VideoRecycler", s.X("markRecentFocusView videoView:", paramt));
    this.GVO = paramt;
    AppMethodBeat.o(338630);
  }
  
  public final void a(HeadsetReceiver.b paramb)
  {
    AppMethodBeat.i(338545);
    s.u(paramb, "listener");
    this.GVN.add(paramb);
    AppMethodBeat.o(338545);
  }
  
  public final void av(b<? super t, Boolean> paramb)
  {
    AppMethodBeat.i(338586);
    s.u(paramb, "isRemoveFun");
    Iterator localIterator = this.GVK.iterator();
    label139:
    while (localIterator.hasNext())
    {
      Object localObject = (t)((WeakReference)localIterator.next()).get();
      if (localObject == null) {}
      for (localObject = null;; localObject = ah.aiuX)
      {
        if (localObject != null) {
          break label139;
        }
        Log.i("Finder.VideoRecycler", "acrossCreatedVideoViews 2 remove");
        localIterator.remove();
        break;
        if (((Boolean)paramb.invoke(localObject)).booleanValue())
        {
          Log.i("Finder.VideoRecycler", "acrossCreatedVideoViews 1 remove it:" + localObject + " mediaid:" + ((t)localObject).getVideoMediaId());
          localIterator.remove();
        }
      }
    }
    AppMethodBeat.o(338586);
  }
  
  public final void aw(b<? super t, Boolean> paramb)
  {
    AppMethodBeat.i(338622);
    s.u(paramb, "filter");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new be.k(this, paramb));
    AppMethodBeat.o(338622);
  }
  
  public final void b(HeadsetReceiver.b paramb)
  {
    AppMethodBeat.i(338550);
    s.u(paramb, "listener");
    this.GVN.remove(paramb);
    AppMethodBeat.o(338550);
  }
  
  public final int bh(Class<? extends t> paramClass)
  {
    AppMethodBeat.i(338595);
    ah.d locald = new ah.d();
    av((b)new be.i(paramClass, locald));
    int i = locald.aixb;
    AppMethodBeat.o(338595);
    return i;
  }
  
  public final void fps()
  {
    AppMethodBeat.i(338614);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new be.c(this));
    AppMethodBeat.o(338614);
  }
  
  public final void fpt()
  {
    AppMethodBeat.i(338626);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new be.r(this));
    AppMethodBeat.o(338626);
  }
  
  public final void fpu()
  {
    AppMethodBeat.i(338637);
    Log.i("Finder.VideoRecycler", "releaseUnFocusView before createdVideoViews:" + this.GVK.size() + " recycledVideoViews:" + this.GVJ.size());
    Iterator localIterator = this.GVK.iterator();
    while (localIterator.hasNext())
    {
      t localt = (t)((WeakReference)localIterator.next()).get();
      if (localt != null) {
        if (!s.p(localt, this.GVO))
        {
          Log.i("Finder.VideoRecycler", "releaseUnFocusView view:" + localt + " mediaid:" + localt.getVideoMediaId());
          localt.onUIDestroy();
          localt.onRelease();
          hm(localt.getVideoView());
          localIterator.remove();
        }
        else
        {
          Log.i("Finder.VideoRecycler", "releaseUnFocusView return for view:" + localt + " mediaid:" + localt.getVideoMediaId());
        }
      }
    }
    Log.i("Finder.VideoRecycler", "releaseUnFocusView after createdVideoViews:" + this.GVK.size() + " recycledVideoViews:" + this.GVJ.size());
    AppMethodBeat.o(338637);
  }
  
  public final void hw(Context paramContext)
  {
    AppMethodBeat.i(338606);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new be.l(this, paramContext));
    AppMethodBeat.o(338606);
  }
  
  public final void hx(Context paramContext)
  {
    AppMethodBeat.i(338609);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new be.q(this, paramContext));
    AppMethodBeat.o(338609);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(338602);
    Log.i("Finder.VideoRecycler", s.X("[onCleared] videoCount=", Integer.valueOf(bh(null))));
    onFinish();
    AppMethodBeat.o(338602);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<t, Boolean>
  {
    d(Class<? extends t> paramClass, ah.e parame, int[] paramArrayOfInt, boolean paramBoolean, be parambe, ah.f<t> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements b<t, ah>
  {
    g(ViewGroup paramViewGroup, be parambe, b<? super t, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends u
    implements b<t, Boolean>
  {
    public h(Class<? extends t> paramClass, Class<? extends com.tencent.mm.plugin.thumbplayer.render.a> paramClass1, ah.d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<ah>
  {
    n(t paramt, be parambe, long paramLong, String paramString)
    {
      super();
    }
    
    private static final void a(be parambe, t paramt, long paramLong, String paramString)
    {
      AppMethodBeat.i(338627);
      s.u(parambe, "this$0");
      s.u(paramt, "$videoView");
      s.u(paramString, "$source");
      be.a(parambe, paramt);
      be.g(parambe).remove(Integer.valueOf(paramt.hashCode()));
      Log.i("Finder.VideoRecycler", "[releaseVideoView] completed! cost=" + (System.currentTimeMillis() - paramLong) + "ms, release view=" + paramt.hashCode() + " source=" + paramString);
      AppMethodBeat.o(338627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.be
 * JD-Core Version:    0.7.0.1
 */