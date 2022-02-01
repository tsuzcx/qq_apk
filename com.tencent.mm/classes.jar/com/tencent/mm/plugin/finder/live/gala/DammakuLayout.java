package com.tencent.mm.plugin.finder.live.gala;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$Adapter;", "animManager", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimManager;", "isAnimating", "", "isInit", "()Z", "setInit", "(Z)V", "checkStartAnim", "", "getAdapter", "isViewPinned", "view", "Landroid/view/View;", "onDetachedFromWindow", "pinDanmaku", "resetAnim", "resumeAll", "resumeAfter", "Lkotlin/Function1;", "setAdapter", "VH", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$ViewHolder;", "setAnimParam", "parameter", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimParameter;", "Adapter", "AnimManager", "AnimParameter", "Companion", "RowStatus", "ViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DammakuLayout
  extends FrameLayout
{
  public static final d aarA;
  private a<?, ?> aarB;
  private b aarC;
  private boolean isAnimating;
  private boolean isInit;
  
  static
  {
    AppMethodBeat.i(371137);
    aarA = new d((byte)0);
    AppMethodBeat.o(371137);
  }
  
  public DammakuLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(371129);
    this.aarC = new b((ViewGroup)this);
    AppMethodBeat.o(371129);
  }
  
  public DammakuLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(371133);
    this.aarC = new b((ViewGroup)this);
    AppMethodBeat.o(371133);
  }
  
  public final a<?, ?> getAdapter()
  {
    AppMethodBeat.i(371154);
    a locala = this.aarB;
    if (locala == null)
    {
      s.bIx("adapter");
      AppMethodBeat.o(371154);
      return null;
    }
    AppMethodBeat.o(371154);
    return locala;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(371172);
    super.onDetachedFromWindow();
    this.aarC.reset();
    this.isAnimating = false;
    AppMethodBeat.o(371172);
  }
  
  public final <VH> void setAdapter(a<VH, ?> parama)
  {
    AppMethodBeat.i(371147);
    s.u(parama, "adapter");
    WeakReference localWeakReference = new WeakReference(this);
    s.u(localWeakReference, "<set-?>");
    parama.CSf = localWeakReference;
    this.aarB = parama;
    requestLayout();
    this.isInit = true;
    AppMethodBeat.o(371147);
  }
  
  public final void setAnimParam(c paramc)
  {
    AppMethodBeat.i(371165);
    s.u(paramc, "parameter");
    b localb = this.aarC;
    s.u(paramc, "value");
    localb.aarG = paramc;
    localb.aarH = new HashMap();
    int m = paramc.aarJ;
    int j;
    if (m > 0) {
      j = 0;
    }
    int n;
    int i1;
    for (int i = 0;; i = n + i1 + i)
    {
      int k = j + 1;
      HashMap localHashMap2 = localb.aarH;
      HashMap localHashMap1 = localHashMap2;
      if (localHashMap2 == null)
      {
        s.bIx("rowInfoMap");
        localHashMap1 = null;
      }
      ((Map)localHashMap1).put(Integer.valueOf(j), new e(i, paramc.aarK, (byte)0));
      n = paramc.aarK;
      i1 = paramc.aarL;
      if (k >= m)
      {
        AppMethodBeat.o(371165);
        return;
      }
      j = k;
    }
  }
  
  public final void setInit(boolean paramBoolean)
  {
    this.isInit = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$Adapter;", "VH", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$ViewHolder;", "DATA", "", "()V", "danmakuLayout", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout;", "getDanmakuLayout", "()Ljava/lang/ref/WeakReference;", "setDanmakuLayout", "(Ljava/lang/ref/WeakReference;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$Adapter$DataWrapper;", "viewRecyclePool", "Ljava/util/Stack;", "getViewRecyclePool", "()Ljava/util/Stack;", "viewRecyclePool$delegate", "Lkotlin/Lazy;", "appendData", "", "list", "", "needClear", "", "bindViewHolder", "viewHolder", "data", "(Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$ViewHolder;Ljava/lang/Object;)V", "clearAllData", "createViewHolder", "parent", "Landroid/view/ViewGroup;", "itemType", "", "(Landroid/view/ViewGroup;I)Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$ViewHolder;", "findValidData", "getItemType", "(Ljava/lang/Object;)I", "onBindViewHolder", "onCreateViewHolder", "recycleViewHolder", "view", "Landroid/view/View;", "requestView", "DataWrapper", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a<VH, DATA>
  {
    public WeakReference<DammakuLayout> CSf;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimManager;", "", "parentView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "value", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimParameter;", "animParameter", "getAnimParameter", "()Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimParameter;", "setAnimParameter", "(Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimParameter;)V", "cancelingJob", "Lkotlinx/coroutines/Job;", "interpolator", "Landroid/view/animation/LinearInterpolator;", "isRunning", "", "lastAttachView", "Landroid/view/View;", "mainHandler", "Landroid/os/Handler;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimManager$Listener;", "rowInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$RowStatus;", "Lkotlin/collections/HashMap;", "runningAnimators", "Ljava/util/LinkedHashMap;", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/LinkedHashMap;", "workerScope", "attachAndStartAnim", "", "view", "req", "checkCanAddNew", "findIdleRow", "internalStart", "isViewAnimPaused", "pauseAnim", "reset", "resumeAnim", "resumeAfter", "Lkotlin/Function1;", "setRequest", "start", "Companion", "Listener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private static final long INTERVAL;
    public static final a aarF;
    private aq CSl;
    private cb CSo;
    private final LinearInterpolator GOS;
    DammakuLayout.c aarG;
    HashMap<Integer, DammakuLayout.e> aarH;
    private LinkedHashMap<View, ValueAnimator> aarI;
    private final Handler mainHandler;
    private aq mainScope;
    private final ViewGroup parentView;
    
    static
    {
      AppMethodBeat.i(371197);
      aarF = new a((byte)0);
      INTERVAL = 100L;
      AppMethodBeat.o(371197);
    }
    
    public b(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(371184);
      this.parentView = paramViewGroup;
      this.CSl = ar.d((f)bg.kCi());
      this.mainScope = ar.d((f)bg.kCh());
      paramViewGroup = new DammakuLayout.c.a();
      this.aarG = new DammakuLayout.c(paramViewGroup.duration, paramViewGroup.aarJ, paramViewGroup.aarK, paramViewGroup.aarL, paramViewGroup.aarM, paramViewGroup.CSx, (byte)0);
      this.aarI = new LinkedHashMap();
      this.mainHandler = new Handler(Looper.getMainLooper());
      this.GOS = new LinearInterpolator();
      AppMethodBeat.o(371184);
    }
    
    private static final void a(b paramb)
    {
      AppMethodBeat.i(371190);
      s.u(paramb, "this$0");
      paramb = ((Map)paramb.aarI).entrySet().iterator();
      while (paramb.hasNext()) {
        ((ValueAnimator)((Map.Entry)paramb.next()).getValue()).cancel();
      }
      AppMethodBeat.o(371190);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(371211);
      this.mainHandler.post(new DammakuLayout.b..ExternalSyntheticLambda0(this));
      Log.i("DammakuLayout", "reset: cancel");
      this.CSo = ((cb)this.CSl.getCoroutineContext().get((f.c)cb.ajws));
      cb localcb = this.CSo;
      if (localcb != null) {
        localcb.a(null);
      }
      localcb = (cb)this.mainScope.getCoroutineContext().get((f.c)cb.ajws);
      if (localcb != null) {
        localcb.a(null);
      }
      this.CSl = ar.d((f)bg.kCi());
      this.mainScope = ar.d((f)bg.kCh());
      AppMethodBeat.o(371211);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimManager$Companion;", "", "()V", "INTERVAL", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimParameter;", "", "duration", "", "rowCnt", "rowHeight", "rowGap", "columnGap", "onAllAnimEnd", "Lkotlin/Function0;", "", "(IIIIILkotlin/jvm/functions/Function0;)V", "getColumnGap", "()I", "getDuration", "getOnAllAnimEnd", "()Lkotlin/jvm/functions/Function0;", "getRowCnt", "getRowGap", "getRowHeight", "Builder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    private final a<ah> CSx;
    final int aarJ;
    final int aarK;
    final int aarL;
    private final int aarM;
    private final int duration;
    
    private c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, a<ah> parama)
    {
      this.duration = paramInt1;
      this.aarJ = paramInt2;
      this.aarK = paramInt3;
      this.aarL = paramInt4;
      this.aarM = paramInt5;
      this.CSx = parama;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimParameter$Builder;", "", "()V", "columnGap", "", "duration", "onAllAnimEnd", "Lkotlin/Function0;", "", "rowCnt", "rowGap", "rowHeight", "build", "Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$AnimParameter;", "setColumnGap", "setDuration", "setOnAllAnimEndListener", "setRowCnt", "setRowGap", "setRowHeight", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      a<ah> CSx;
      int aarJ = 1;
      int aarK;
      int aarL;
      int aarM;
      int duration = 4000;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/DammakuLayout$RowStatus;", "", "top", "", "height", "isOccupy", "", "(IIZ)V", "getHeight", "()I", "()Z", "setOccupy", "(Z)V", "getTop", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
  {
    private boolean aarN;
    private final int height;
    private final int top;
    
    private e(int paramInt1, int paramInt2)
    {
      this.top = paramInt1;
      this.height = paramInt2;
      this.aarN = false;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof e)) {
          return false;
        }
        paramObject = (e)paramObject;
        if (this.top != paramObject.top) {
          return false;
        }
        if (this.height != paramObject.height) {
          return false;
        }
      } while (this.aarN == paramObject.aarN);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(371186);
      String str = "RowStatus(top=" + this.top + ", height=" + this.height + ", isOccupy=" + this.aarN + ')';
      AppMethodBeat.o(371186);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.DammakuLayout
 * JD-Core Version:    0.7.0.1
 */