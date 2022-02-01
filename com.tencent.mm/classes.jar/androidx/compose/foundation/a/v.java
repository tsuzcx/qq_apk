package androidx.compose.foundation.a;

import androidx.compose.ui.d.e;
import androidx.compose.ui.g.c.a.a;
import androidx.compose.ui.g.c.i;
import androidx.compose.ui.g.c.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Landroidx.compose.ui.g.c.m;>;
import kotlin.g.a.q;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.e.c;

@Metadata(d1={""}, d2={"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "awaitChannelAllUp", "consumeAllSignal", "Landroidx/compose/runtime/MutableState;", "", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Landroidx/compose/foundation/gestures/TapGestureEvent;", "(Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitChannelDown", "Landroidx/compose/foundation/gestures/TapGestureEvent$Down;", "onlyDownsSignal", "awaitChannelSecondDown", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "firstUp", "Landroidx/compose/foundation/gestures/TapGestureEvent$Up;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/platform/ViewConfiguration;Landroidx/compose/foundation/gestures/TapGestureEvent$Up;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitChannelUpOrCancel", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withNullableTimeout", "T", "scope", "Lkotlinx/coroutines/CoroutineScope;", "timeout", "", "block", "Lkotlin/Function2;", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "requireUnconsumed", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onPress", "onTap", "Lkotlin/Function1;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapGestures", "onDoubleTap", "onLongPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translatePointerEventsToChannel", "Lkotlinx/coroutines/channels/SendChannel;", "detectDownsOnly", "Landroidx/compose/runtime/State;", "consumeAllUntilUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;Landroidx/compose/runtime/State;Landroidx/compose/runtime/MutableState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class v
{
  private static final q<l, e, kotlin.d.d<? super ah>, Object> abz;
  
  static
  {
    AppMethodBeat.i(204212);
    abz = (q)new v.a(null);
    AppMethodBeat.o(204212);
  }
  
  public static final Object a(androidx.compose.ui.g.c.a parama, boolean paramBoolean, kotlin.d.d<? super androidx.compose.ui.g.c.m> paramd)
  {
    AppMethodBeat.i(204191);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super androidx.compose.ui.g.c.m>)localObject1;; paramd = new b(paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204191);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    paramd.L$0 = parama;
    paramd.YF = paramBoolean;
    paramd.label = 1;
    Object localObject2 = a.a.d(parama, paramd);
    Object localObject1 = localObject2;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(204191);
      return locala;
      paramBoolean = paramd.YF;
      parama = (androidx.compose.ui.g.c.a)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject1 = (i)localObject1;
    localObject2 = ((i)localObject1).alK;
    int k = ((List)localObject2).size() - 1;
    if (k >= 0) {}
    int j;
    label278:
    label288:
    label290:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      androidx.compose.ui.g.c.m localm = (androidx.compose.ui.g.c.m)((List)localObject2).get(i);
      boolean bool;
      if (paramBoolean)
      {
        bool = androidx.compose.ui.g.c.j.a(localm);
        if (bool) {
          break label278;
        }
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label288;
        }
        parama = ((i)localObject1).alK.get(0);
        AppMethodBeat.o(204191);
        return parama;
        bool = androidx.compose.ui.g.c.j.b(localm);
        break;
        if (j <= k) {
          break label290;
        }
      }
      break;
    }
  }
  
  public static final Object a(u paramu, final q<? super l, ? super e, ? super kotlin.d.d<? super ah>, ? extends Object> paramq, final kotlin.g.a.b<? super e, ah> paramb, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(204180);
    paramu = j.a(paramu, (kotlin.g.a.m)new c(new m((androidx.compose.ui.n.d)paramu), paramq, paramb, null), paramd);
    if (paramu == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(204180);
      return paramu;
    }
    paramu = ah.aiuX;
    AppMethodBeat.o(204180);
    return paramu;
  }
  
  public static final Object c(androidx.compose.ui.g.c.a parama, kotlin.d.d<? super androidx.compose.ui.g.c.m> paramd)
  {
    AppMethodBeat.i(204208);
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super androidx.compose.ui.g.c.m>)localObject1;; paramd = new d(paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204208);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = androidx.compose.ui.g.c.k.aLj;
    paramd.L$0 = parama;
    paramd.label = 1;
    Object localObject2 = parama.a((androidx.compose.ui.g.c.k)localObject1, paramd);
    localObject1 = localObject2;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(204208);
      return locala;
      parama = (androidx.compose.ui.g.c.a)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject1 = (i)localObject1;
    localObject2 = ((i)localObject1).alK;
    int k = ((List)localObject2).size() - 1;
    if (k >= 0) {}
    int j;
    label512:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!androidx.compose.ui.g.c.j.c((androidx.compose.ui.g.c.m)((List)localObject2).get(i))) {}
      for (i = 0; i != 0; i = 1)
      {
        parama = ((i)localObject1).alK.get(0);
        AppMethodBeat.o(204208);
        return parama;
        if (j <= k) {
          break label512;
        }
      }
      localObject1 = ((i)localObject1).alK;
      k = ((List)localObject1).size() - 1;
      if (k >= 0) {}
      label360:
      label371:
      label502:
      label507:
      for (i = 0;; i = j)
      {
        j = i + 1;
        localObject2 = (androidx.compose.ui.g.c.m)((List)localObject1).get(i);
        if ((((androidx.compose.ui.g.c.m)localObject2).aLr.aKT) || (androidx.compose.ui.g.c.j.a((androidx.compose.ui.g.c.m)localObject2, parama.wj())))
        {
          i = 1;
          if (i == 0) {
            break label360;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label371;
          }
          AppMethodBeat.o(204208);
          return null;
          i = 0;
          break;
          if (j <= k) {
            break label507;
          }
        }
        localObject1 = androidx.compose.ui.g.c.k.aLk;
        paramd.L$0 = parama;
        paramd.label = 2;
        localObject2 = parama.a((androidx.compose.ui.g.c.k)localObject1, paramd);
        localObject1 = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(204208);
          return locala;
          parama = (androidx.compose.ui.g.c.a)paramd.L$0;
          ResultKt.throwOnFailure(localObject1);
        }
        localObject1 = ((i)localObject1).alK;
        k = ((List)localObject1).size() - 1;
        if (k >= 0) {}
        for (i = 0;; i = j)
        {
          j = i + 1;
          if (androidx.compose.ui.g.c.j.g((androidx.compose.ui.g.c.m)((List)localObject1).get(i))) {}
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(204208);
            return null;
            if (j <= k) {
              break label502;
            }
          }
          break;
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    boolean YF;
    int label;
    
    b(kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204121);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = v.a(null, false, (kotlin.d.d)this);
      AppMethodBeat.o(204121);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<u, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(m paramm, q<? super l, ? super e, ? super kotlin.d.d<? super ah>, ? extends Object> paramq, kotlin.g.a.b<? super e, ah> paramb, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204127);
      paramd = new c(this.abA, paramq, paramb, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(204127);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(204124);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204124);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (u)this.L$0;
        paramObject = (kotlin.g.a.m)new kotlin.d.b.a.k(this.abA, paramObject)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(204087);
            paramAnonymousd = new 1(this.abA, paramObject, this.abB, this.abC, paramAnonymousd);
            paramAnonymousd.L$0 = paramAnonymousObject;
            paramAnonymousObject = (kotlin.d.d)paramAnonymousd;
            AppMethodBeat.o(204087);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(204082);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(204082);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              Object localObject = (aq)this.L$0;
              paramAnonymousObject = this.abA;
              paramAnonymousObject.VA.jo(null);
              paramAnonymousObject.isReleased = false;
              paramAnonymousObject.isCanceled = false;
              paramAnonymousObject = paramObject;
              localObject = (kotlin.g.a.m)new kotlin.d.b.a.j(this.abB)
              {
                int label;
                
                public final kotlin.d.d<ah> create(Object paramAnonymous2Object, kotlin.d.d<?> paramAnonymous2d)
                {
                  AppMethodBeat.i(204047);
                  paramAnonymous2d = new 1(this.abB, this.aaS, this.abA, this.abC, paramAnonymous2d);
                  paramAnonymous2d.L$0 = paramAnonymous2Object;
                  paramAnonymous2Object = (kotlin.d.d)paramAnonymous2d;
                  AppMethodBeat.o(204047);
                  return paramAnonymous2Object;
                }
                
                public final Object invokeSuspend(Object paramAnonymous2Object)
                {
                  AppMethodBeat.i(204040);
                  kotlin.d.a.a locala1 = kotlin.d.a.a.aiwj;
                  Object localObject;
                  switch (this.label)
                  {
                  default: 
                    paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(204040);
                    throw paramAnonymous2Object;
                  case 0: 
                    ResultKt.throwOnFailure(paramAnonymous2Object);
                    paramAnonymous2Object = (androidx.compose.ui.g.c.a)this.L$0;
                    localObject = (kotlin.d.d)this;
                    this.L$0 = paramAnonymous2Object;
                    this.label = 1;
                    localObject = v.b(paramAnonymous2Object, (kotlin.d.d)localObject);
                    if (localObject == locala1)
                    {
                      AppMethodBeat.o(204040);
                      return locala1;
                    }
                    break;
                  case 1: 
                    androidx.compose.ui.g.c.a locala = (androidx.compose.ui.g.c.a)this.L$0;
                    ResultKt.throwOnFailure(paramAnonymous2Object);
                    localObject = paramAnonymous2Object;
                    paramAnonymous2Object = locala;
                  }
                  for (;;)
                  {
                    androidx.compose.ui.g.c.j.i((androidx.compose.ui.g.c.m)localObject);
                    localObject = (androidx.compose.ui.g.c.m)localObject;
                    if (this.abB != v.mq()) {
                      kotlinx.coroutines.j.a(this.aaS, null, null, (kotlin.g.a.m)new kotlin.d.b.a.k(this.abB, this.abA)
                      {
                        int label;
                        
                        public final kotlin.d.d<ah> create(Object paramAnonymous3Object, kotlin.d.d<?> paramAnonymous3d)
                        {
                          AppMethodBeat.i(204081);
                          paramAnonymous3Object = (kotlin.d.d)new 1(this.abB, this.abA, this.abE, paramAnonymous3d);
                          AppMethodBeat.o(204081);
                          return paramAnonymous3Object;
                        }
                        
                        public final Object invokeSuspend(Object paramAnonymous3Object)
                        {
                          AppMethodBeat.i(204077);
                          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
                          switch (this.label)
                          {
                          default: 
                            paramAnonymous3Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            AppMethodBeat.o(204077);
                            throw paramAnonymous3Object;
                          case 0: 
                            ResultKt.throwOnFailure(paramAnonymous3Object);
                            paramAnonymous3Object = this.abB;
                            m localm = this.abA;
                            e locale = e.N(this.abE.position);
                            this.label = 1;
                            if (paramAnonymous3Object.invoke(localm, locale, this) == locala)
                            {
                              AppMethodBeat.o(204077);
                              return locala;
                            }
                            break;
                          case 1: 
                            ResultKt.throwOnFailure(paramAnonymous3Object);
                          }
                          paramAnonymous3Object = ah.aiuX;
                          AppMethodBeat.o(204077);
                          return paramAnonymous3Object;
                        }
                      }, 3);
                    }
                    localObject = (kotlin.d.d)this;
                    this.L$0 = null;
                    this.label = 2;
                    localObject = v.c(paramAnonymous2Object, (kotlin.d.d)localObject);
                    paramAnonymous2Object = localObject;
                    if (localObject == locala1)
                    {
                      AppMethodBeat.o(204040);
                      return locala1;
                      ResultKt.throwOnFailure(paramAnonymous2Object);
                    }
                    paramAnonymous2Object = (androidx.compose.ui.g.c.m)paramAnonymous2Object;
                    if (paramAnonymous2Object == null)
                    {
                      paramAnonymous2Object = this.abA;
                      paramAnonymous2Object.isCanceled = true;
                      paramAnonymous2Object.VA.jp(null);
                    }
                    for (;;)
                    {
                      paramAnonymous2Object = ah.aiuX;
                      AppMethodBeat.o(204040);
                      return paramAnonymous2Object;
                      androidx.compose.ui.g.c.j.i(paramAnonymous2Object);
                      localObject = this.abA;
                      ((m)localObject).isReleased = true;
                      ((m)localObject).VA.jp(null);
                      localObject = this.abC;
                      if (localObject != null) {
                        ((kotlin.g.a.b)localObject).invoke(e.N(paramAnonymous2Object.position));
                      }
                    }
                  }
                }
              };
              kotlin.d.d locald = (kotlin.d.d)this;
              this.label = 1;
              if (paramAnonymousObject.a((kotlin.g.a.m)localObject, locald) == locala)
              {
                AppMethodBeat.o(204082);
                return locala;
              }
              break;
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
            }
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(204082);
            return paramAnonymousObject;
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (ar.c(paramObject, locald) == locala)
        {
          AppMethodBeat.o(204124);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(204124);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    d(kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204123);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = v.c(null, (kotlin.d.d)this);
      AppMethodBeat.o(204123);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.v
 * JD-Core Version:    0.7.0.1
 */