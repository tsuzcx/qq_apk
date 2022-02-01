package androidx.compose.a.a;

import androidx.compose.runtime.a.e;
import androidx.compose.runtime.am;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/Transition;", "S", "", "initialState", "label", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "transitionState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;)V", "_animations", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "_transitions", "animations", "", "getAnimations$annotations", "()V", "getAnimations", "()Ljava/util/List;", "value", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core_release", "(Ljava/lang/Object;)V", "isRunning", "", "()Z", "<set-?>", "isSeeking", "isSeeking$annotations", "setSeeking", "(Z)V", "isSeeking$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "lastSeekedTimeNanos", "", "playTimeNanos", "getPlayTimeNanos$annotations", "getPlayTimeNanos", "()J", "setPlayTimeNanos", "(J)V", "playTimeNanos$delegate", "Landroidx/compose/animation/core/Transition$Segment;", "segment", "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment$delegate", "startTimeNanos", "getStartTimeNanos", "setStartTimeNanos", "startTimeNanos$delegate", "targetState", "getTargetState", "setTargetState$animation_core_release", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos$annotations", "getTotalDurationNanos", "setTotalDurationNanos", "totalDurationNanos$delegate", "updateChildrenNeeded", "getUpdateChildrenNeeded$animation_core_release", "setUpdateChildrenNeeded$animation_core_release", "updateChildrenNeeded$delegate", "addAnimation", "animation", "addAnimation$animation_core_release", "addTransition", "transition", "addTransition$animation_core_release", "animateTo", "", "animateTo$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "onChildAnimationUpdated", "onFrame", "frameTimeNanos", "onFrame$animation_core_release", "onTransitionEnd", "onTransitionEnd$animation_core_release", "onTransitionStart", "onTransitionStart$animation_core_release", "removeAnimation", "deferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "removeAnimation$animation_core_release", "removeTransition", "removeTransition$animation_core_release", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "updateTarget", "updateTarget$animation_core_release", "DeferredAnimation", "Segment", "SegmentImpl", "TransitionAnimationState", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at<S>
{
  private final an Vu;
  public final aj<S> Wd;
  private final an We;
  private final an Wf;
  private final an Wg;
  private final an Wh;
  final e<at<S>.d<?, ?>> Wi;
  final e<at<?>> Wj;
  private final List<at<S>.d<?, ?>> Wk;
  private final an Wl;
  long Wm;
  final an Wn;
  private final String label;
  
  public at(aj<S> paramaj, String paramString)
  {
    AppMethodBeat.i(203404);
    this.Wd = paramaj;
    this.label = paramString;
    this.Vu = androidx.compose.runtime.bj.T(this.Wd.lN());
    this.We = androidx.compose.runtime.bj.T(new c(this.Wd.lN(), this.Wd.lN()));
    this.Wf = androidx.compose.runtime.bj.T(Long.valueOf(0L));
    this.Wg = androidx.compose.runtime.bj.T(Long.valueOf(-9223372036854775808L));
    this.Wh = androidx.compose.runtime.bj.T(Boolean.TRUE);
    this.Wi = new e(new d[16]);
    this.Wj = new e(new at[16]);
    this.Wk = this.Wi.qp();
    this.Wl = androidx.compose.runtime.bj.T(Boolean.FALSE);
    this.Wn = androidx.compose.runtime.bj.T(Long.valueOf(0L));
    AppMethodBeat.o(203404);
  }
  
  public at(S paramS)
  {
    this(new aj(paramS), null);
    AppMethodBeat.i(203413);
    AppMethodBeat.o(203413);
  }
  
  private void B(S paramS)
  {
    AppMethodBeat.i(203420);
    this.Wd.Vt.setValue(paramS);
    AppMethodBeat.o(203420);
  }
  
  private boolean isRunning()
  {
    AppMethodBeat.i(203429);
    if (lT() != -9223372036854775808L)
    {
      AppMethodBeat.o(203429);
      return true;
    }
    AppMethodBeat.o(203429);
    return false;
  }
  
  private final long lT()
  {
    AppMethodBeat.i(203450);
    long l = ((Number)((bm)this.Wg).getValue()).longValue();
    AppMethodBeat.o(203450);
    return l;
  }
  
  private boolean lU()
  {
    AppMethodBeat.i(203464);
    boolean bool = ((Boolean)((bm)this.Wh).getValue()).booleanValue();
    AppMethodBeat.o(203464);
    return bool;
  }
  
  private void o(long paramLong)
  {
    AppMethodBeat.i(203439);
    this.Wf.setValue(Long.valueOf(paramLong));
    AppMethodBeat.o(203439);
  }
  
  private final void p(long paramLong)
  {
    AppMethodBeat.i(203457);
    this.Wg.setValue(Long.valueOf(paramLong));
    AppMethodBeat.o(203457);
  }
  
  public final void a(final S paramS, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(203549);
    paramh = paramh.by(-1598253567);
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramS)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j;
      if ((paramInt & 0x70) == 0) {
        if (paramh.G(this))
        {
          j = 32;
          label63:
          i = j | i;
        }
      }
      for (;;)
      {
        Object localObject;
        if (((i & 0x5B ^ 0x12) != 0) || (!paramh.nZ())) {
          if ((!lV()) && (!s.p(lO(), paramS)))
          {
            localObject = (b)new c(lO(), paramS);
            this.We.setValue(localObject);
            B(lO());
            this.Vu.setValue(paramS);
            if (!isRunning()) {
              aj(true);
            }
            localObject = this.Wi;
            j = ((e)localObject).size;
            if (j > 0)
            {
              localObject = ((e)localObject).aqq;
              i = 0;
            }
          }
        }
        for (;;)
        {
          ((d)localObject[i]).al(true);
          i += 1;
          if (i >= j) {
            for (;;)
            {
              paramh = paramh.oh();
              if (paramh != null) {
                paramh.b((m)new g(this, paramS, paramInt));
              }
              AppMethodBeat.o(203549);
              return;
              i = 2;
              break;
              j = 16;
              break label63;
              paramh.oi();
            }
          }
        }
      }
    }
  }
  
  public final boolean a(at<S>.d<?, ?> paramat)
  {
    AppMethodBeat.i(203527);
    s.u(paramat, "animation");
    boolean bool = this.Wi.add(paramat);
    AppMethodBeat.o(203527);
    return bool;
  }
  
  final void aj(boolean paramBoolean)
  {
    AppMethodBeat.i(203488);
    this.Wh.setValue(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(203488);
  }
  
  public final void b(at<S>.d<?, ?> paramat)
  {
    AppMethodBeat.i(203535);
    s.u(paramat, "animation");
    this.Wi.remove(paramat);
    AppMethodBeat.o(203535);
  }
  
  public final void b(final S paramS, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(203565);
    androidx.compose.runtime.h localh = paramh.by(-1097579936);
    if ((paramInt & 0xE) == 0) {
      if (localh.G(paramS)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j;
      if ((paramInt & 0x70) == 0) {
        if (localh.G(this))
        {
          j = 32;
          label66:
          i = j | i;
        }
      }
      for (;;)
      {
        if (((i & 0x5B ^ 0x12) != 0) || (!localh.nZ())) {
          if (!lV())
          {
            localh.bx(-1097579880);
            a(paramS, localh, i & 0x70 | i & 0xE);
            if ((!s.p(paramS, this.Wd.lN())) || (isRunning()) || (lU()))
            {
              localh.bx(-1097579635);
              localh.bx(-3686930);
              boolean bool = localh.G(this);
              paramh = localh.or();
              if (!bool)
              {
                h.a locala = androidx.compose.runtime.h.alD;
                if (paramh != h.a.ox()) {}
              }
              else
              {
                paramh = (m)new e(this, null);
                localh.F(paramh);
                label233:
                localh.od();
                androidx.compose.runtime.aa.a(this, (m)paramh, localh);
                localh.od();
                label257:
                localh.od();
              }
            }
          }
        }
        for (;;)
        {
          paramh = localh.oh();
          if (paramh != null) {
            paramh.b((m)new f(this, paramS, paramInt));
          }
          AppMethodBeat.o(203565);
          return;
          i = 2;
          break;
          j = 16;
          break label66;
          break label233;
          localh.bx(-1097579369);
          localh.od();
          break label257;
          localh.bx(-1097579359);
          localh.od();
          continue;
          localh.oi();
        }
      }
    }
  }
  
  public final S lO()
  {
    AppMethodBeat.i(203471);
    Object localObject = ((bm)this.Vu).getValue();
    AppMethodBeat.o(203471);
    return localObject;
  }
  
  public final b<S> lR()
  {
    AppMethodBeat.i(203474);
    b localb = (b)((bm)this.We).getValue();
    AppMethodBeat.o(203474);
    return localb;
  }
  
  public final long lS()
  {
    AppMethodBeat.i(203478);
    long l = ((Number)((bm)this.Wf).getValue()).longValue();
    AppMethodBeat.o(203478);
    return l;
  }
  
  public final boolean lV()
  {
    AppMethodBeat.i(203499);
    boolean bool = ((Boolean)((bm)this.Wl).getValue()).booleanValue();
    AppMethodBeat.o(203499);
    return bool;
  }
  
  public final void lW()
  {
    AppMethodBeat.i(203517);
    p(-9223372036854775808L);
    B(lO());
    o(0L);
    this.Wd.ai(false);
    AppMethodBeat.o(203517);
  }
  
  public final void q(long paramLong)
  {
    AppMethodBeat.i(203512);
    if (lT() == -9223372036854775808L)
    {
      p(paramLong);
      this.Wd.ai(true);
    }
    aj(false);
    o(paramLong - lT());
    Object localObject1 = this.Wi;
    int k = ((e)localObject1).size;
    int j;
    int i;
    Object localObject2;
    if (k > 0)
    {
      localObject1 = ((e)localObject1).aqq;
      j = 0;
      i = 1;
      localObject2 = (d)localObject1[j];
      if (!((d)localObject2).mb())
      {
        paramLong = lS() - ((Number)((bm)((d)localObject2).Wy).getValue()).longValue();
        ((d)localObject2).A(((d)localObject2).ma().k(paramLong));
        ((d)localObject2).Uw = ((d)localObject2).ma().l(paramLong);
        if (c.a.a(((d)localObject2).ma(), paramLong))
        {
          ((d)localObject2).ak(true);
          ((d)localObject2).r(0L);
        }
      }
      if (!((d)localObject2).mb())
      {
        i = 0;
        label180:
        j += 1;
        if (j < k) {}
      }
    }
    for (;;)
    {
      localObject1 = this.Wj;
      k = ((e)localObject1).size;
      j = i;
      if (k > 0)
      {
        localObject1 = ((e)localObject1).aqq;
        j = 0;
      }
      for (;;)
      {
        localObject2 = (at)localObject1[j];
        if (!s.p(((at)localObject2).lO(), ((at)localObject2).Wd.lN())) {
          ((at)localObject2).q(lS());
        }
        if (!s.p(((at)localObject2).lO(), ((at)localObject2).Wd.lN())) {
          i = 0;
        }
        j += 1;
        if (j >= k)
        {
          j = i;
          if (j != 0) {
            lW();
          }
          AppMethodBeat.o(203512);
          return;
        }
      }
      break;
      break label180;
      i = 1;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/animation/core/Transition$DeferredAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "data", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "getData$animation_core_release", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core_release", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "getLabel", "()Ljava/lang/String;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "animate", "Landroidx/compose/runtime/State;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "setupSeeking", "", "setupSeeking$animation_core_release", "DeferredAnimationData", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a<T, V extends k>
  {
    private final aw<T, V> TT;
    at<S>.a<T, V>.a<T, V> Wo;
    private final String label;
    
    public a(String paramString)
    {
      AppMethodBeat.i(203469);
      this.TT = paramString;
      this.label = localObject;
      AppMethodBeat.o(203469);
    }
    
    public final bm<T> a(b<? super at.b<S>, ? extends aa<T>> paramb, b<? super S, ? extends T> paramb1)
    {
      AppMethodBeat.i(203475);
      s.u(paramb, "transitionSpec");
      s.u(paramb1, "targetValueByState");
      Object localObject2 = this.Wo;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a(new at.d(at.this, paramb1.invoke(at.this.Wd.lN()), j.a(this.TT, paramb1.invoke(at.this.Wd.lN())), this.TT, this.label), paramb, paramb1);
        localObject2 = at.this;
        this.Wo = ((a)localObject1);
        ((at)localObject2).a(((a)localObject1).Wq);
      }
      localObject2 = at.this;
      ((a)localObject1).c(paramb1);
      ((a)localObject1).b(paramb);
      ((a)localObject1).Wq.a(paramb1.invoke(((at)localObject2).lO()), (aa)paramb.invoke(((at)localObject2).lR()));
      paramb = (bm)localObject1;
      AppMethodBeat.o(203475);
      return paramb;
    }
    
    public final void lX()
    {
      AppMethodBeat.i(203477);
      a locala = this.Wo;
      if (locala != null)
      {
        at localat = at.this;
        locala.Wq.a(locala.Wr.invoke(localat.lR().lY()), locala.Wr.invoke(localat.lR().lO()), (aa)locala.TM.invoke(localat.lR()));
      }
      AppMethodBeat.o(203477);
    }
    
    @Metadata(d1={""}, d2={"Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "animation", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAnimation", "()Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "getTargetValueByState", "()Lkotlin/jvm/functions/Function1;", "setTargetValueByState", "(Lkotlin/jvm/functions/Function1;)V", "getTransitionSpec", "setTransitionSpec", "value", "getValue", "()Ljava/lang/Object;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a<T, V extends k>
      implements bm<T>
    {
      b<? super at.b<S>, ? extends aa<T>> TM;
      final at<S>.d<T, V> Wq;
      b<? super S, ? extends T> Wr;
      
      public a(b<? super at.b<S>, ? extends aa<T>> paramb, b<? super S, ? extends T> paramb1)
      {
        AppMethodBeat.i(203428);
        this.Wq = paramb;
        this.TM = paramb1;
        this.Wr = localObject;
        AppMethodBeat.o(203428);
      }
      
      public final void b(b<? super at.b<S>, ? extends aa<T>> paramb)
      {
        AppMethodBeat.i(203438);
        s.u(paramb, "<set-?>");
        this.TM = paramb;
        AppMethodBeat.o(203438);
      }
      
      public final void c(b<? super S, ? extends T> paramb)
      {
        AppMethodBeat.i(203448);
        s.u(paramb, "<set-?>");
        this.Wr = paramb;
        AppMethodBeat.o(203448);
      }
      
      public final T getValue()
      {
        AppMethodBeat.i(203458);
        this.Wq.a(this.Wr.invoke(at.this.lO()), (aa)this.TM.invoke(at.this.lR()));
        Object localObject = this.Wq.getValue();
        AppMethodBeat.o(203458);
        return localObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/animation/core/Transition$Segment;", "S", "", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b<S>
  {
    public abstract boolean e(S paramS1, S paramS2);
    
    public abstract S lO();
    
    public abstract S lY();
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/animation/core/Transition$SegmentImpl;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", "", "other", "", "hashCode", "", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c<S>
    implements at.b<S>
  {
    private final S Wt;
    private final S Wu;
    
    public c(S paramS1, S paramS2)
    {
      this.Wt = paramS1;
      this.Wu = paramS2;
    }
    
    public final boolean e(S paramS1, S paramS2)
    {
      AppMethodBeat.i(203492);
      s.u(this, "this");
      if ((s.p(paramS1, lY())) && (s.p(paramS2, lO())))
      {
        AppMethodBeat.o(203492);
        return true;
      }
      AppMethodBeat.o(203492);
      return false;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203479);
      if (((paramObject instanceof at.b)) && (s.p(this.Wt, ((at.b)paramObject).lY())) && (s.p(this.Wu, ((at.b)paramObject).lO())))
      {
        AppMethodBeat.o(203479);
        return true;
      }
      AppMethodBeat.o(203479);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(203482);
      Object localObject = this.Wt;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.Wu;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(203482);
        return i * 31 + j;
      }
    }
    
    public final S lO()
    {
      return this.Wu;
    }
    
    public final S lY()
    {
      return this.Wt;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animationSpec$delegate", "durationNanos", "", "getDurationNanos$animation_core_release", "()J", "interruptionSpec", "", "isFinished", "isFinished$animation_core_release", "()Z", "setFinished$animation_core_release", "(Z)V", "isFinished$delegate", "getLabel", "()Ljava/lang/String;", "needsReset", "getNeedsReset", "setNeedsReset", "needsReset$delegate", "offsetTimeNanos", "getOffsetTimeNanos", "setOffsetTimeNanos", "(J)V", "offsetTimeNanos$delegate", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "getValue", "setValue$animation_core_release", "value$delegate", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "onPlayTimeChanged", "", "playTimeNanos", "onPlayTimeChanged$animation_core_release", "resetAnimation", "resetAnimation$animation_core_release", "seekTo", "seekTo$animation_core_release", "updateAnimation", "isInterrupted", "(Ljava/lang/Object;Z)V", "updateInitialAndTargetValue", "updateInitialAndTargetValue$animation_core_release", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateTargetValue", "updateTargetValue$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d<T, V extends k>
    implements bm<T>
  {
    private final aw<T, V> TT;
    private final an TX;
    private final an Uv;
    V Uw;
    private final aa<T> WA;
    private final an Wv;
    private final an Ww;
    private final an Wx;
    final an Wy;
    private final an Wz;
    private final String label;
    
    public d(V paramV, aw<T, V> paramaw, String paramString)
    {
      AppMethodBeat.i(203486);
      this.TT = paramString;
      this.label = localObject;
      this.TX = androidx.compose.runtime.bj.T(paramV);
      this.Wv = androidx.compose.runtime.bj.T(h.a(0.0F, 0.0F, null, 7));
      this.Ww = androidx.compose.runtime.bj.T(new as((g)lZ(), this.TT, paramV, lE(), paramaw));
      this.Wx = androidx.compose.runtime.bj.T(Boolean.TRUE);
      this.Wy = androidx.compose.runtime.bj.T(Long.valueOf(0L));
      this.Wz = androidx.compose.runtime.bj.T(Boolean.FALSE);
      this.Uv = androidx.compose.runtime.bj.T(paramV);
      this.Uw = paramaw;
      this$1 = (Float)bj.mh().get(this.TT);
      if (at.this == null)
      {
        this$1 = null;
        this.WA = ((aa)h.a(0.0F, 0.0F, at.this, 3));
        AppMethodBeat.o(203486);
        return;
      }
      float f = ((Number)at.this).floatValue();
      this$1 = (k)this.TT.md().invoke(paramV);
      int i = 0;
      int k = at.this.lK();
      if (k > 0) {}
      for (;;)
      {
        int j = i + 1;
        at.this.e(i, f);
        if (j >= k)
        {
          this$1 = this.TT.me().invoke(at.this);
          break;
        }
        i = j;
      }
    }
    
    private final void C(T paramT)
    {
      AppMethodBeat.i(203501);
      this.TX.setValue(paramT);
      AppMethodBeat.o(203501);
    }
    
    private final void a(aa<T> paramaa)
    {
      AppMethodBeat.i(203510);
      this.Wv.setValue(paramaa);
      AppMethodBeat.o(203510);
    }
    
    private final T lE()
    {
      AppMethodBeat.i(203494);
      Object localObject = ((bm)this.TX).getValue();
      AppMethodBeat.o(203494);
      return localObject;
    }
    
    private final aa<T> lZ()
    {
      AppMethodBeat.i(203505);
      aa localaa = (aa)((bm)this.Wv).getValue();
      AppMethodBeat.o(203505);
      return localaa;
    }
    
    private final boolean mc()
    {
      AppMethodBeat.i(203514);
      boolean bool = ((Boolean)((bm)this.Wz).getValue()).booleanValue();
      AppMethodBeat.o(203514);
      return bool;
    }
    
    public final void A(T paramT)
    {
      AppMethodBeat.i(203562);
      this.Uv.setValue(paramT);
      AppMethodBeat.o(203562);
    }
    
    public final void a(T paramT, aa<T> paramaa)
    {
      AppMethodBeat.i(203567);
      s.u(paramaa, "animationSpec");
      if ((!s.p(lE(), paramT)) || (mc()))
      {
        C(paramT);
        a(paramaa);
        if (mb()) {
          break label85;
        }
      }
      label85:
      for (boolean bool = true;; bool = false)
      {
        a(this, null, bool, 1);
        ak(false);
        r(at.this.lS());
        al(false);
        AppMethodBeat.o(203567);
        return;
      }
    }
    
    public final void a(T paramT1, T paramT2, aa<T> paramaa)
    {
      AppMethodBeat.i(203570);
      s.u(paramaa, "animationSpec");
      C(paramT2);
      a(paramaa);
      if (s.p(ma().UH, paramT1)) {
        s.p(ma().Us, paramT2);
      }
      a(this, paramT1, false, 2);
      AppMethodBeat.o(203570);
    }
    
    public final void ak(boolean paramBoolean)
    {
      AppMethodBeat.i(203541);
      this.Wx.setValue(Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(203541);
    }
    
    final void al(boolean paramBoolean)
    {
      AppMethodBeat.i(203550);
      this.Wz.setValue(Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(203550);
    }
    
    public final T getValue()
    {
      AppMethodBeat.i(203555);
      Object localObject = ((bm)this.Uv).getValue();
      AppMethodBeat.o(203555);
      return localObject;
    }
    
    final as<T, V> ma()
    {
      AppMethodBeat.i(203528);
      as localas = (as)((bm)this.Ww).getValue();
      AppMethodBeat.o(203528);
      return localas;
    }
    
    public final boolean mb()
    {
      AppMethodBeat.i(203534);
      boolean bool = ((Boolean)((bm)this.Wx).getValue()).booleanValue();
      AppMethodBeat.o(203534);
      return bool;
    }
    
    final void r(long paramLong)
    {
      AppMethodBeat.i(203546);
      this.Wy.setValue(Long.valueOf(paramLong));
      AppMethodBeat.o(203546);
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    e(at<S> paramat, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(203490);
      paramObject = (d)new e(this.Wp, paramd);
      AppMethodBeat.o(203490);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203480);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203480);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        paramObject = (b)new u(this.Wp) {};
        d locald = (d)this;
        this.label = 1;
        if (am.b(paramObject, locald) == locala)
        {
          AppMethodBeat.o(203480);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    f(at<S> paramat, S paramS, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    g(at<S> paramat, S paramS, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.at
 * JD-Core Version:    0.7.0.1
 */