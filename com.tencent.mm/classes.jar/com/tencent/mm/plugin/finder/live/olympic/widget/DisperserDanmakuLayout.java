package com.tencent.mm.plugin.finder.live.olympic.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$Adapter;", "animManager", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimManager;", "isAnimating", "", "checkStartAnim", "", "onDetachedFromWindow", "resetAnim", "setAdapter", "VH", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$ViewHolder;", "setAnimParam", "parameter", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimParameter;", "Adapter", "AnimManager", "AnimParameter", "Companion", "ViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DisperserDanmakuLayout
  extends FrameLayout
{
  public static final DisperserDanmakuLayout.d CSb;
  private a<?, ?> CSc;
  b CSd;
  boolean isAnimating;
  
  static
  {
    AppMethodBeat.i(360753);
    CSb = new DisperserDanmakuLayout.d((byte)0);
    AppMethodBeat.o(360753);
  }
  
  public DisperserDanmakuLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(360729);
    this.CSd = new b((ViewGroup)this);
    AppMethodBeat.o(360729);
  }
  
  public DisperserDanmakuLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(360734);
    this.CSd = new b((ViewGroup)this);
    AppMethodBeat.o(360734);
  }
  
  public final void eow()
  {
    AppMethodBeat.i(360778);
    this.CSd.reset();
    this.isAnimating = false;
    AppMethodBeat.o(360778);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(360773);
    super.onDetachedFromWindow();
    Log.i("DanmakuLayout", "onDetachedFromWindow: rest anim");
    eow();
    AppMethodBeat.o(360773);
  }
  
  public final <VH extends e> void setAdapter(a<VH, ?> parama)
  {
    AppMethodBeat.i(360760);
    s.u(parama, "adapter");
    WeakReference localWeakReference = new WeakReference(this);
    s.u(localWeakReference, "<set-?>");
    parama.CSf = localWeakReference;
    this.CSc = parama;
    requestLayout();
    AppMethodBeat.o(360760);
  }
  
  public final void setAnimParam(c paramc)
  {
    AppMethodBeat.i(360768);
    s.u(paramc, "parameter");
    b localb = this.CSd;
    s.u(paramc, "<set-?>");
    localb.CSm = paramc;
    AppMethodBeat.o(360768);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$Adapter;", "VH", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$ViewHolder;", "DATA", "", "()V", "danmakuLayout", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout;", "getDanmakuLayout", "()Ljava/lang/ref/WeakReference;", "setDanmakuLayout", "(Ljava/lang/ref/WeakReference;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$Adapter$DataWrapper;", "viewRecyclePool", "Ljava/util/Stack;", "getViewRecyclePool", "()Ljava/util/Stack;", "viewRecyclePool$delegate", "Lkotlin/Lazy;", "appendData", "", "list", "", "needClear", "", "bindViewHolder", "viewHolder", "data", "(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$ViewHolder;Ljava/lang/Object;)V", "clearAllData", "createViewHolder", "parent", "Landroid/view/ViewGroup;", "itemType", "", "(Landroid/view/ViewGroup;I)Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$ViewHolder;", "findValidData", "getItemType", "(Ljava/lang/Object;)I", "onBindViewHolder", "onCreateViewHolder", "recycleViewHolder", "view", "Landroid/view/View;", "requestView", "Companion", "DataWrapper", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a<VH extends DisperserDanmakuLayout.e, DATA>
  {
    public static final DisperserDanmakuLayout.a.a CSe = new DisperserDanmakuLayout.a.a((byte)0);
    public WeakReference<DisperserDanmakuLayout> CSf;
    private final j CSg = kotlin.k.cm((kotlin.g.a.a)c.CSi);
    final LinkedList<b<DATA>> vEn = new LinkedList();
    
    public abstract void a(VH paramVH, DATA paramDATA);
    
    public final WeakReference<DisperserDanmakuLayout> eox()
    {
      WeakReference localWeakReference = this.CSf;
      if (localWeakReference != null) {
        return localWeakReference;
      }
      s.bIx("danmakuLayout");
      return null;
    }
    
    final Stack<VH> eoy()
    {
      return (Stack)this.CSg.getValue();
    }
    
    public abstract VH v(ViewGroup paramViewGroup);
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$Adapter$DataWrapper;", "DATA", "", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "hasShown", "", "getHasShown", "()Z", "setHasShown", "(Z)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class b<DATA>
    {
      boolean CSh;
      final DATA cpt;
      
      public b(DATA paramDATA)
      {
        this.cpt = paramDATA;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/Stack;", "VH", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$ViewHolder;", "DATA", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<Stack<VH>>
    {
      public static final c CSi;
      
      static
      {
        AppMethodBeat.i(360716);
        CSi = new c();
        AppMethodBeat.o(360716);
      }
      
      c()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimManager;", "", "parentView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "animParameter", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimParameter;", "getAnimParameter", "()Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimParameter;", "setAnimParameter", "(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimParameter;)V", "cancelingJob", "Lkotlinx/coroutines/Job;", "isRunning", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimManager$Listener;", "runningAnimators", "", "Landroid/animation/ValueAnimator;", "workerScope", "attachChildView", "", "list", "", "Landroid/view/View;", "spanAngleList", "", "internalStart", "req", "(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimManager$Listener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "setRequest", "start", "startAnim", "(Ljava/util/List;Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimManager$Listener;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Listener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final DisperserDanmakuLayout.b.a CSj;
    b CSk;
    aq CSl;
    public DisperserDanmakuLayout.c CSm;
    private List<ValueAnimator> CSn;
    private cb CSo;
    private boolean Uz;
    private aq mainScope;
    private final ViewGroup parentView;
    
    static
    {
      AppMethodBeat.i(360779);
      CSj = new DisperserDanmakuLayout.b.a((byte)0);
      AppMethodBeat.o(360779);
    }
    
    public b(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(360689);
      this.parentView = paramViewGroup;
      this.CSl = ar.d((f)bg.kCi());
      this.mainScope = ar.d((f)bg.kCh());
      this.CSn = ((List)new ArrayList());
      AppMethodBeat.o(360689);
    }
    
    private final Object a(List<? extends View> paramList, final b paramb, List<Double> paramList1)
    {
      AppMethodBeat.i(360710);
      Object localObject = ((Iterable)paramList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        localView.setPivotX(localView.getWidth() / 2.0F);
        localView.setPivotY(localView.getHeight() / 2.0F);
      }
      localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).addUpdateListener(new DisperserDanmakuLayout.b..ExternalSyntheticLambda0(paramList, this, paramList1));
      ((ValueAnimator)localObject).setDuration(eoz().duration);
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new f(paramList, this, paramb));
      paramList = this.CSn;
      s.s(localObject, "animator");
      paramList.add(localObject);
      ((ValueAnimator)localObject).start();
      paramList = ah.aiuX;
      AppMethodBeat.o(360710);
      return paramList;
    }
    
    private static final void a(List paramList1, b paramb, List paramList2, ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(360719);
      s.u(paramList1, "$list");
      s.u(paramb, "this$0");
      s.u(paramList2, "$spanAngleList");
      float f1 = paramValueAnimator.getAnimatedFraction();
      paramValueAnimator = ((Iterable)paramList1).iterator();
      int i = 0;
      if (paramValueAnimator.hasNext())
      {
        paramList1 = paramValueAnimator.next();
        if (i < 0) {
          p.kkW();
        }
        View localView = (View)paramList1;
        float f2 = paramb.eoz().CSs;
        f2 = (paramb.eoz().CSt - paramb.eoz().CSs) * f1 + f2;
        localView.setTranslationX((float)(f2 * Math.cos(((Number)paramList2.get(i)).doubleValue())));
        localView.setTranslationY(-(float)(f2 * Math.sin(((Number)paramList2.get(i)).doubleValue())));
        paramList1 = paramb.eoz().CSw;
        if (paramList1 == null) {}
        for (paramList1 = null;; paramList1 = ah.aiuX)
        {
          if (paramList1 == null)
          {
            f2 = ((Number)paramb.eoz().CSv.bsC).floatValue();
            localView.setAlpha((((Number)paramb.eoz().CSv.bsD).floatValue() - ((Number)paramb.eoz().CSv.bsC).floatValue()) * f1 + f2);
            f2 = ((Number)paramb.eoz().CSu.bsC).floatValue();
            f2 = (((Number)paramb.eoz().CSu.bsD).floatValue() - ((Number)paramb.eoz().CSu.bsC).floatValue()) * f1 + f2;
            localView.setScaleX(f2);
            localView.setScaleY(f2);
          }
          i += 1;
          break;
          paramList1.invoke(localView, Float.valueOf(f1));
        }
      }
      AppMethodBeat.o(360719);
    }
    
    private final void v(List<? extends View> paramList, List<Double> paramList1)
    {
      AppMethodBeat.i(360702);
      if (paramList.size() > eoz().spanCount)
      {
        paramList = new RuntimeException("error, view size = " + paramList.size() + ", span count = " + eoz().spanCount);
        AppMethodBeat.o(360702);
        throw paramList;
      }
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (i < 0) {
          p.kkW();
        }
        localObject = (View)localObject;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        this.parentView.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
        if (eoz().CSs > 0)
        {
          ((View)localObject).setTranslationX((float)(eoz().CSs * Math.cos(((Number)paramList1.get(i)).doubleValue())));
          ((View)localObject).setTranslationY(-(float)(eoz().CSs * Math.sin(((Number)paramList1.get(i)).doubleValue())));
        }
        ((View)localObject).setAlpha(((Number)eoz().CSv.bsC).floatValue());
        float f = ((Number)eoz().CSu.bsC).floatValue();
        ((View)localObject).setScaleX(f);
        ((View)localObject).setScaleY(f);
        i += 1;
      }
      AppMethodBeat.o(360702);
    }
    
    public final DisperserDanmakuLayout.c eoz()
    {
      AppMethodBeat.i(360799);
      DisperserDanmakuLayout.c localc = this.CSm;
      if (localc != null)
      {
        AppMethodBeat.o(360799);
        return localc;
      }
      s.bIx("animParameter");
      AppMethodBeat.o(360799);
      return null;
    }
    
    public final void reset()
    {
      AppMethodBeat.i(360812);
      com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new d(this));
      Log.i("DanmakuLayout.Anim", "reset: cancel");
      this.CSo = ((cb)this.CSl.getCoroutineContext().get((f.c)cb.ajws));
      Object localObject = this.CSo;
      if (localObject != null) {
        ((cb)localObject).a(null);
      }
      localObject = (cb)this.mainScope.getCoroutineContext().get((f.c)cb.ajws);
      if (localObject != null) {
        ((cb)localObject).a(null);
      }
      this.CSl = ar.d((f)bg.kCi());
      this.mainScope = ar.d((f)bg.kCh());
      localObject = this.CSk;
      if (localObject != null) {
        ((b)localObject).eoB();
      }
      AppMethodBeat.o(360812);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimManager$Listener;", "", "allAnimEnd", "", "recycleView", "view", "Landroid/view/View;", "requestView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static abstract interface b
    {
      public abstract void bH(View paramView);
      
      public abstract View eoA();
      
      public abstract void eoB();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.d.b.a.d
    {
      Object L$0;
      Object Uf;
      int label;
      
      c(DisperserDanmakuLayout.b paramb, kotlin.d.d<? super c> paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(360769);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = DisperserDanmakuLayout.b.a(this.CSp, null, (kotlin.d.d)this);
        AppMethodBeat.o(360769);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<ah>
    {
      d(DisperserDanmakuLayout.b paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      Object Uf;
      int label;
      
      e(DisperserDanmakuLayout.b paramb, kotlin.d.d<? super e> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(360816);
        paramd = new e(this.CSp, paramd);
        paramd.L$0 = paramObject;
        paramObject = (kotlin.d.d)paramd;
        AppMethodBeat.o(360816);
        return paramObject;
      }
      
      /* Error */
      public final Object invokeSuspend(Object paramObject)
      {
        // Byte code:
        //   0: ldc 84
        //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: getstatic 90	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
        //   8: astore 6
        //   10: aload_0
        //   11: getfield 92	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:label	I
        //   14: tableswitch	default:+34 -> 48, 0:+51->65, 1:+119->133, 2:+332->346, 3:+458->472, 4:+573->587
        //   49: nop
        //   50: dup2_x2
        //   51: dup
        //   52: ldc 96
        //   54: invokespecial 99	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
        //   57: astore_1
        //   58: ldc 84
        //   60: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   63: aload_1
        //   64: athrow
        //   65: aload_1
        //   66: invokestatic 105	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
        //   69: aload_0
        //   70: getfield 60	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:L$0	Ljava/lang/Object;
        //   73: checkcast 71	kotlinx/coroutines/aq
        //   76: astore_3
        //   77: aload_0
        //   78: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   81: invokestatic 109	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:a	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;)Lkotlinx/coroutines/cb;
        //   84: astore 4
        //   86: aload_3
        //   87: astore_1
        //   88: aload 4
        //   90: ifnull +57 -> 147
        //   93: aload_0
        //   94: checkcast 62	kotlin/d/d
        //   97: astore 5
        //   99: aload_0
        //   100: aload_3
        //   101: putfield 60	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:L$0	Ljava/lang/Object;
        //   104: aload_0
        //   105: iconst_1
        //   106: putfield 92	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:label	I
        //   109: aload_3
        //   110: astore_1
        //   111: aload 4
        //   113: aload 5
        //   115: invokeinterface 115 2 0
        //   120: aload 6
        //   122: if_acmpne +25 -> 147
        //   125: ldc 84
        //   127: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   130: aload 6
        //   132: areturn
        //   133: aload_0
        //   134: getfield 60	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:L$0	Ljava/lang/Object;
        //   137: checkcast 71	kotlinx/coroutines/aq
        //   140: astore_3
        //   141: aload_1
        //   142: invokestatic 105	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
        //   145: aload_3
        //   146: astore_1
        //   147: aload_0
        //   148: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   151: invokestatic 118	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:b	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;)V
        //   154: ldc 120
        //   156: ldc 122
        //   158: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   161: aload_0
        //   162: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   165: invokestatic 131	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:c	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;)Z
        //   168: ifne +13 -> 181
        //   171: aload_0
        //   172: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   175: invokestatic 135	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:d	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;)Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$b;
        //   178: ifnonnull +56 -> 234
        //   181: ldc 120
        //   183: new 137	java/lang/StringBuilder
        //   186: dup
        //   187: ldc 139
        //   189: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   192: aload_0
        //   193: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   196: invokestatic 131	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:c	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;)Z
        //   199: invokevirtual 144	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
        //   202: ldc 146
        //   204: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   207: aload_0
        //   208: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   211: invokestatic 135	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:d	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;)Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$b;
        //   214: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   217: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   220: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   223: getstatic 79	kotlin/ah:aiuX	Lkotlin/ah;
        //   226: astore_1
        //   227: ldc 84
        //   229: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   232: aload_1
        //   233: areturn
        //   234: aload_0
        //   235: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   238: invokestatic 135	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:d	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;)Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$b;
        //   241: astore_3
        //   242: iconst_0
        //   243: istore_2
        //   244: iload_2
        //   245: ifne +145 -> 390
        //   248: aload_1
        //   249: invokestatic 161	kotlinx/coroutines/ar:a	(Lkotlinx/coroutines/aq;)Z
        //   252: ifeq +138 -> 390
        //   255: aload_3
        //   256: ifnull +129 -> 385
        //   259: aload_0
        //   260: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   263: iconst_1
        //   264: invokestatic 164	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:a	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;Z)V
        //   267: aload_0
        //   268: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   271: invokestatic 168	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:e	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;)Lkotlinx/coroutines/aq;
        //   274: invokeinterface 172 1 0
        //   279: astore 4
        //   281: new 14	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e$1
        //   284: dup
        //   285: aload_0
        //   286: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   289: aload_3
        //   290: aconst_null
        //   291: invokespecial 175	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e$1:<init>	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$b;Lkotlin/d/d;)V
        //   294: checkcast 7	kotlin/g/a/m
        //   297: astore 5
        //   299: aload_0
        //   300: checkcast 62	kotlin/d/d
        //   303: astore 7
        //   305: aload_0
        //   306: aload_1
        //   307: putfield 60	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:L$0	Ljava/lang/Object;
        //   310: aload_0
        //   311: aload_3
        //   312: putfield 177	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:Uf	Ljava/lang/Object;
        //   315: aload_0
        //   316: iconst_2
        //   317: putfield 92	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:label	I
        //   320: aload 4
        //   322: aload 5
        //   324: aload 7
        //   326: invokestatic 182	kotlinx/coroutines/l:a	(Lkotlin/d/f;Lkotlin/g/a/m;Lkotlin/d/d;)Ljava/lang/Object;
        //   329: astore 4
        //   331: aload 4
        //   333: aload 6
        //   335: if_acmpne +298 -> 633
        //   338: ldc 84
        //   340: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   343: aload 6
        //   345: areturn
        //   346: aload_0
        //   347: getfield 177	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:Uf	Ljava/lang/Object;
        //   350: checkcast 184	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$b
        //   353: astore_3
        //   354: aload_0
        //   355: getfield 60	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:L$0	Ljava/lang/Object;
        //   358: checkcast 71	kotlinx/coroutines/aq
        //   361: astore 4
        //   363: aload_1
        //   364: invokestatic 105	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
        //   367: aload_1
        //   368: astore 5
        //   370: aload 4
        //   372: astore_1
        //   373: aload 5
        //   375: checkcast 186	java/lang/Boolean
        //   378: invokevirtual 190	java/lang/Boolean:booleanValue	()Z
        //   381: istore_2
        //   382: goto -138 -> 244
        //   385: iconst_1
        //   386: istore_2
        //   387: goto -143 -> 244
        //   390: aload_0
        //   391: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   394: iconst_0
        //   395: invokestatic 164	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:a	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;Z)V
        //   398: aload_1
        //   399: invokestatic 161	kotlinx/coroutines/ar:a	(Lkotlinx/coroutines/aq;)Z
        //   402: ifeq +74 -> 476
        //   405: aload_0
        //   406: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   409: invokestatic 168	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:e	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;)Lkotlinx/coroutines/aq;
        //   412: invokeinterface 172 1 0
        //   417: astore_1
        //   418: new 16	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e$2
        //   421: dup
        //   422: aload_3
        //   423: aconst_null
        //   424: invokespecial 193	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e$2:<init>	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$b;Lkotlin/d/d;)V
        //   427: checkcast 7	kotlin/g/a/m
        //   430: astore_3
        //   431: aload_0
        //   432: checkcast 62	kotlin/d/d
        //   435: astore 4
        //   437: aload_0
        //   438: aconst_null
        //   439: putfield 60	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:L$0	Ljava/lang/Object;
        //   442: aload_0
        //   443: aconst_null
        //   444: putfield 177	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:Uf	Ljava/lang/Object;
        //   447: aload_0
        //   448: iconst_3
        //   449: putfield 92	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:label	I
        //   452: aload_1
        //   453: aload_3
        //   454: aload 4
        //   456: invokestatic 182	kotlinx/coroutines/l:a	(Lkotlin/d/f;Lkotlin/g/a/m;Lkotlin/d/d;)Ljava/lang/Object;
        //   459: aload 6
        //   461: if_acmpne +15 -> 476
        //   464: ldc 84
        //   466: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   469: aload 6
        //   471: areturn
        //   472: aload_1
        //   473: invokestatic 105	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
        //   476: ldc 120
        //   478: ldc 195
        //   480: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   483: getstatic 79	kotlin/ah:aiuX	Lkotlin/ah;
        //   486: astore_1
        //   487: ldc 84
        //   489: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   492: aload_1
        //   493: areturn
        //   494: astore 5
        //   496: aload_1
        //   497: astore 4
        //   499: aload 5
        //   501: astore_1
        //   502: aload_0
        //   503: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   506: iconst_0
        //   507: invokestatic 164	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:a	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;Z)V
        //   510: aload 4
        //   512: invokestatic 161	kotlinx/coroutines/ar:a	(Lkotlinx/coroutines/aq;)Z
        //   515: ifeq +115 -> 630
        //   518: aload_0
        //   519: getfield 41	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:CSp	Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;
        //   522: invokestatic 168	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b:e	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b;)Lkotlinx/coroutines/aq;
        //   525: invokeinterface 172 1 0
        //   530: astore 4
        //   532: new 16	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e$2
        //   535: dup
        //   536: aload_3
        //   537: aconst_null
        //   538: invokespecial 193	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e$2:<init>	(Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$b;Lkotlin/d/d;)V
        //   541: checkcast 7	kotlin/g/a/m
        //   544: astore_3
        //   545: aload_0
        //   546: checkcast 62	kotlin/d/d
        //   549: astore 5
        //   551: aload_0
        //   552: aload_1
        //   553: putfield 60	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:L$0	Ljava/lang/Object;
        //   556: aload_0
        //   557: aconst_null
        //   558: putfield 177	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:Uf	Ljava/lang/Object;
        //   561: aload_0
        //   562: iconst_4
        //   563: putfield 92	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:label	I
        //   566: aload 4
        //   568: aload_3
        //   569: aload 5
        //   571: invokestatic 182	kotlinx/coroutines/l:a	(Lkotlin/d/f;Lkotlin/g/a/m;Lkotlin/d/d;)Ljava/lang/Object;
        //   574: aload 6
        //   576: if_acmpne +54 -> 630
        //   579: ldc 84
        //   581: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   584: aload 6
        //   586: areturn
        //   587: aload_0
        //   588: getfield 60	com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$b$e:L$0	Ljava/lang/Object;
        //   591: checkcast 197	java/lang/Throwable
        //   594: astore_3
        //   595: aload_1
        //   596: invokestatic 105	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
        //   599: aload_3
        //   600: astore_1
        //   601: ldc 120
        //   603: ldc 195
        //   605: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   608: ldc 84
        //   610: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   613: aload_1
        //   614: athrow
        //   615: astore_1
        //   616: goto -114 -> 502
        //   619: astore 5
        //   621: aload_1
        //   622: astore 4
        //   624: aload 5
        //   626: astore_1
        //   627: goto -125 -> 502
        //   630: goto -29 -> 601
        //   633: aload 4
        //   635: astore 5
        //   637: goto -264 -> 373
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	640	0	this	e
        //   0	640	1	paramObject	Object
        //   243	144	2	bool	boolean
        //   76	524	3	localObject1	Object
        //   84	550	4	localObject2	Object
        //   97	277	5	localObject3	Object
        //   494	6	5	localObject4	Object
        //   549	21	5	locald1	kotlin.d.d
        //   619	6	5	localObject5	Object
        //   635	1	5	localObject6	Object
        //   8	577	6	locala	kotlin.d.a.a
        //   303	22	7	locald2	kotlin.d.d
        // Exception table:
        //   from	to	target	type
        //   248	255	494	finally
        //   259	331	494	finally
        //   363	367	615	finally
        //   373	382	619	finally
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimManager$startAnim$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class f
      extends AnimatorListenerAdapter
    {
      f(List<? extends View> paramList, DisperserDanmakuLayout.b paramb, DisperserDanmakuLayout.b.b paramb1) {}
      
      public final void onAnimationEnd(final Animator paramAnimator)
      {
        AppMethodBeat.i(360764);
        com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new a(jdField_this, paramAnimator));
        Object localObject = (Iterable)this.mHE;
        paramAnimator = jdField_this;
        DisperserDanmakuLayout.b.b localb = paramb;
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView = (View)((Iterator)localObject).next();
          DisperserDanmakuLayout.b.g(paramAnimator).removeView(localView);
          localb.bH(localView);
        }
        AppMethodBeat.o(360764);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(DisperserDanmakuLayout.b paramb, Animator paramAnimator)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimParameter;", "", "duration", "", "interval", "startRadius", "endRadius", "spanCount", "scalePair", "Lkotlin/Pair;", "", "alphaPair", "animateOneFrame", "Lkotlin/Function2;", "Landroid/view/View;", "", "onAllAnimEnd", "Lkotlin/Function0;", "(IIIIILkotlin/Pair;Lkotlin/Pair;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "getAlphaPair", "()Lkotlin/Pair;", "getAnimateOneFrame", "()Lkotlin/jvm/functions/Function2;", "getDuration", "()I", "getEndRadius", "getInterval", "getOnAllAnimEnd", "()Lkotlin/jvm/functions/Function0;", "getScalePair", "spanAngleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSpanAngleList", "()Ljava/util/ArrayList;", "spanAngleList$delegate", "Lkotlin/Lazy;", "getSpanCount", "getStartRadius", "Builder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    final int CSs;
    final int CSt;
    final r<Float, Float> CSu;
    final r<Float, Float> CSv;
    final m<View, Float, ah> CSw;
    final kotlin.g.a.a<ah> CSx;
    final j CSy;
    final int duration;
    final int interval;
    final int spanCount;
    
    private c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, r<Float, Float> paramr1, r<Float, Float> paramr2, m<? super View, ? super Float, ah> paramm, kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(360680);
      this.duration = paramInt1;
      this.interval = paramInt2;
      this.CSs = paramInt3;
      this.CSt = paramInt4;
      this.spanCount = paramInt5;
      this.CSu = paramr1;
      this.CSv = paramr2;
      this.CSw = paramm;
      this.CSx = parama;
      this.CSy = kotlin.k.cm((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(360680);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimParameter$Builder;", "", "()V", "alphaPair", "Lkotlin/Pair;", "", "animateOneFrame", "Lkotlin/Function2;", "Landroid/view/View;", "", "duration", "", "endRadius", "interval", "onAllAnimEnd", "Lkotlin/Function0;", "scalePair", "spanCount", "startRadius", "build", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimParameter;", "setAlpha", "startAlpha", "endAlpha", "setAnimateOneFrame", "setDuration", "setInterval", "setOnAllAnimEndListener", "setRadius", "setScale", "startScale", "endScale", "setSpanCount", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public int CSs;
      public int CSt;
      public r<Float, Float> CSu;
      public r<Float, Float> CSv;
      public m<? super View, ? super Float, ah> CSw;
      public kotlin.g.a.a<ah> CSx;
      public int duration;
      public int interval;
      public int spanCount;
      
      public a()
      {
        AppMethodBeat.i(360706);
        this.duration = 1000;
        this.CSt = 500;
        this.spanCount = 4;
        this.CSu = new r(Float.valueOf(1.0F), Float.valueOf(1.0F));
        this.CSv = new r(Float.valueOf(1.0F), Float.valueOf(1.0F));
        AppMethodBeat.o(360706);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ArrayList<Double>>
    {
      b(DisperserDanmakuLayout.c paramc)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$ViewHolder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "associatedObject", "itemType", "", "getItemType", "()I", "setItemType", "(I)V", "getItemView", "()Landroid/view/View;", "getAssociatedObject", "T", "()Ljava/lang/Object;", "setAssociatedObject", "", "data", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
  {
    Object CSA;
    public final View caK;
    int itemType;
    
    public e(View paramView)
    {
      AppMethodBeat.i(360668);
      this.caK = paramView;
      this.itemType = -1;
      AppMethodBeat.o(360668);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$checkStartAnim$1", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$AnimManager$Listener;", "allAnimEnd", "", "recycleView", "view", "Landroid/view/View;", "requestView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements DisperserDanmakuLayout.b.b
  {
    f(DisperserDanmakuLayout paramDisperserDanmakuLayout) {}
    
    public final void bH(View paramView)
    {
      AppMethodBeat.i(360693);
      s.u(paramView, "view");
      DisperserDanmakuLayout.a locala = DisperserDanmakuLayout.a(this.CSB);
      if (locala == null)
      {
        s.bIx("adapter");
        locala = null;
        s.u(paramView, "view");
        paramView = paramView.getTag();
        if (!(paramView instanceof DisperserDanmakuLayout.e)) {
          break label75;
        }
      }
      label75:
      for (paramView = (DisperserDanmakuLayout.e)paramView;; paramView = null)
      {
        if (paramView != null) {
          locala.eoy().push(paramView);
        }
        AppMethodBeat.o(360693);
        return;
        break;
      }
    }
    
    public final View eoA()
    {
      AppMethodBeat.i(360683);
      Object localObject1 = DisperserDanmakuLayout.a(this.CSB);
      if (localObject1 == null)
      {
        s.bIx("adapter");
        localObject1 = null;
      }
      Object localObject3;
      for (;;)
      {
        localObject3 = (DisperserDanmakuLayout)((DisperserDanmakuLayout.a)localObject1).eox().get();
        if (localObject3 != null) {
          break;
        }
        AppMethodBeat.o(360683);
        return null;
      }
      Object localObject4 = ((Iterable)((DisperserDanmakuLayout.a)localObject1).vEn).iterator();
      Object localObject2;
      int i;
      if (((Iterator)localObject4).hasNext())
      {
        localObject2 = ((Iterator)localObject4).next();
        if (!((DisperserDanmakuLayout.a.b)localObject2).CSh)
        {
          i = 1;
          label95:
          if (i == 0) {
            break label120;
          }
        }
      }
      for (;;)
      {
        localObject4 = (DisperserDanmakuLayout.a.b)localObject2;
        if (localObject4 != null) {
          break label127;
        }
        AppMethodBeat.o(360683);
        return null;
        i = 0;
        break label95;
        label120:
        break;
        localObject2 = null;
      }
      label127:
      s.u(((DisperserDanmakuLayout.a.b)localObject4).cpt, "data");
      if (!((Collection)((DisperserDanmakuLayout.a)localObject1).eoy()).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label225;
        }
        localObject2 = (DisperserDanmakuLayout.e)((DisperserDanmakuLayout.a)localObject1).eoy().pop();
      }
      for (;;)
      {
        s.s(localObject2, "cacheViewHolder");
        localObject3 = ((DisperserDanmakuLayout.a.b)localObject4).cpt;
        s.u(localObject3, "data");
        ((DisperserDanmakuLayout.e)localObject2).CSA = localObject3;
        ((DisperserDanmakuLayout.a)localObject1).a((DisperserDanmakuLayout.e)localObject2, localObject3);
        ((DisperserDanmakuLayout.a.b)localObject4).CSh = true;
        localObject1 = ((DisperserDanmakuLayout.e)localObject2).caK;
        AppMethodBeat.o(360683);
        return localObject1;
        i = 0;
        break;
        label225:
        localObject2 = ((DisperserDanmakuLayout.a)localObject1).v((ViewGroup)localObject3);
        if (((DisperserDanmakuLayout.e)localObject2).caK.getParent() != null)
        {
          localObject1 = new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
          AppMethodBeat.o(360683);
          throw ((Throwable)localObject1);
        }
        ((DisperserDanmakuLayout.e)localObject2).itemType = -1;
        ((DisperserDanmakuLayout.e)localObject2).caK.setTag(localObject2);
      }
    }
    
    public final void eoB()
    {
      AppMethodBeat.i(360700);
      DisperserDanmakuLayout.a locala = DisperserDanmakuLayout.a(this.CSB);
      Object localObject = locala;
      if (locala == null)
      {
        s.bIx("adapter");
        localObject = null;
      }
      ((DisperserDanmakuLayout.a)localObject).vEn.clear();
      DisperserDanmakuLayout.b(this.CSB);
      localObject = DisperserDanmakuLayout.c(this.CSB).eoz().CSx;
      if (localObject != null) {
        ((kotlin.g.a.a)localObject).invoke();
      }
      AppMethodBeat.o(360700);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.widget.DisperserDanmakuLayout
 * JD-Core Version:    0.7.0.1
 */