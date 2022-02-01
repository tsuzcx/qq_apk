package androidx.compose.foundation.a;

import androidx.compose.ui.g.c.i;
import androidx.compose.ui.g.c.k;
import androidx.compose.ui.g.c.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.g.a.m<-Landroidx.compose.ui.g.c.u;-Lkotlin.d.d<-Lkotlin.ah;>;+Ljava.lang.Object;>;
import kotlin.g.b.s;
import kotlinx.coroutines.cg;

@Metadata(d1={""}, d2={"allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forEachGesture", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final Object a(androidx.compose.ui.g.c.a parama, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(204206);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new b(paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204206);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    s.u(parama, "<this>");
    Object localObject1 = parama.wk().alK;
    int k = ((List)localObject1).size() - 1;
    if (k >= 0) {}
    int j;
    label332:
    label337:
    label342:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (((androidx.compose.ui.g.c.m)((List)localObject1).get(i)).aLn)
      {
        i = 1;
        if (i != 0) {
          break label242;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          localObject1 = k.aLk;
          paramd.L$0 = parama;
          paramd.label = 1;
          Object localObject2 = parama.a((k)localObject1, paramd);
          localObject1 = localObject2;
          if (localObject2 == locala)
          {
            AppMethodBeat.o(204206);
            return locala;
            if (j <= k) {
              break label342;
            }
            i = 0;
            break;
            label242:
            i = 0;
            continue;
            parama = (androidx.compose.ui.g.c.a)paramd.L$0;
            ResultKt.throwOnFailure(localObject1);
          }
          localObject1 = ((i)localObject1).alK;
          k = ((List)localObject1).size() - 1;
          if (k < 0) {
            break label332;
          }
        }
      }
      for (i = 0;; i = j)
      {
        j = i + 1;
        if (((androidx.compose.ui.g.c.m)((List)localObject1).get(i)).aLn) {}
        for (i = 1; i == 0; i = 0)
        {
          parama = ah.aiuX;
          AppMethodBeat.o(204206);
          return parama;
          if (j <= k) {
            break label337;
          }
        }
        break;
      }
    }
  }
  
  private static Object a(u paramu, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(204190);
    paramu = paramu.a((kotlin.g.a.m)new a(null), paramd);
    if (paramu == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(204190);
      return paramu;
    }
    paramu = ah.aiuX;
    AppMethodBeat.o(204190);
    return paramu;
  }
  
  public static final Object a(u paramu, kotlin.g.a.m<? super u, ? super kotlin.d.d<? super ah>, ? extends Object> paramm, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(204181);
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new c(paramd))
    {
      localObject5 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramu = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204181);
        throw paramu;
      }
    }
    ResultKt.throwOnFailure(localObject5);
    localObject2 = paramd.getContext();
    Object localObject1 = paramm;
    paramm = paramu;
    paramu = (u)localObject2;
    while (cg.f(paramu))
    {
      localObject2 = paramu;
      localObject3 = paramd;
      Object localObject4 = paramm;
      localObject5 = localObject1;
      try
      {
        paramd.L$0 = paramm;
        localObject2 = paramu;
        localObject3 = paramd;
        localObject4 = paramm;
        localObject5 = localObject1;
        paramd.Uf = localObject1;
        localObject2 = paramu;
        localObject3 = paramd;
        localObject4 = paramm;
        localObject5 = localObject1;
        paramd.VC = paramu;
        localObject2 = paramu;
        localObject3 = paramd;
        localObject4 = paramm;
        localObject5 = localObject1;
        paramd.label = 1;
        localObject2 = paramu;
        localObject3 = paramd;
        localObject4 = paramm;
        localObject5 = localObject1;
        localObject6 = ((kotlin.g.a.m)localObject1).invoke(paramm, paramd);
        if (localObject6 == locala)
        {
          AppMethodBeat.o(204181);
          return locala;
          localObject2 = (f)paramd.VC;
          localObject4 = (kotlin.g.a.m)paramd.Uf;
          localObject3 = (u)paramd.L$0;
          paramu = (u)localObject2;
          localObject1 = localObject4;
          paramm = (kotlin.g.a.m<? super u, ? super kotlin.d.d<? super ah>, ? extends Object>)localObject3;
        }
      }
      catch (CancellationException paramu)
      {
        Object localObject6;
        localObject1 = localObject5;
        localObject5 = localObject4;
        localObject4 = paramu;
      }
      try
      {
        ResultKt.throwOnFailure(localObject5);
        localObject1 = localObject4;
        paramm = (kotlin.g.a.m<? super u, ? super kotlin.d.d<? super ah>, ? extends Object>)localObject3;
        paramu = (u)localObject2;
        localObject2 = paramu;
        localObject3 = paramd;
        localObject4 = paramm;
        localObject5 = localObject1;
        paramd.L$0 = paramm;
        localObject2 = paramu;
        localObject3 = paramd;
        localObject4 = paramm;
        localObject5 = localObject1;
        paramd.Uf = localObject1;
        localObject2 = paramu;
        localObject3 = paramd;
        localObject4 = paramm;
        localObject5 = localObject1;
        paramd.VC = paramu;
        localObject2 = paramu;
        localObject3 = paramd;
        localObject4 = paramm;
        localObject5 = localObject1;
        paramd.label = 2;
        localObject2 = paramu;
        localObject3 = paramd;
        localObject4 = paramm;
        localObject5 = localObject1;
        localObject6 = a(paramm, paramd);
        if (localObject6 != locala) {
          continue;
        }
        AppMethodBeat.o(204181);
        return locala;
      }
      catch (CancellationException localCancellationException)
      {
        for (;;)
        {
          localObject2 = paramu;
          localObject3 = paramd;
          localObject5 = paramm;
          continue;
          paramu = localCancellationException;
        }
      }
      localObject2 = (f)paramd.VC;
      localObject4 = (kotlin.g.a.m)paramd.Uf;
      localObject3 = (u)paramd.L$0;
      paramu = (u)localObject2;
      localObject1 = localObject4;
      paramm = (kotlin.g.a.m<? super u, ? super kotlin.d.d<? super ah>, ? extends Object>)localObject3;
      ResultKt.throwOnFailure(localObject5);
      localObject1 = localObject4;
      paramm = (kotlin.g.a.m<? super u, ? super kotlin.d.d<? super ah>, ? extends Object>)localObject3;
      paramu = (u)localObject2;
      continue;
      paramu = (u)localObject2;
      paramd = (kotlin.d.d<? super ah>)localObject3;
      paramm = (kotlin.g.a.m<? super u, ? super kotlin.d.d<? super ah>, ? extends Object>)localObject5;
      if (cg.f((f)localObject2))
      {
        ((c)localObject3).L$0 = localObject4;
        ((c)localObject3).Uf = null;
        ((c)localObject3).VC = null;
        ((c)localObject3).label = 3;
        if (a((u)localObject5, (kotlin.d.d)localObject3) != locala) {
          break label568;
        }
        AppMethodBeat.o(204181);
        return locala;
        paramu = (CancellationException)paramd.L$0;
        ResultKt.throwOnFailure(localObject5);
        AppMethodBeat.o(204181);
        throw paramu;
      }
    }
    paramu = ah.aiuX;
    AppMethodBeat.o(204181);
    return paramu;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<androidx.compose.ui.g.c.a, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204001);
      paramd = new a(paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(204001);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203992);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203992);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (androidx.compose.ui.g.c.a)this.L$0;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (j.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(203992);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(203992);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    b(kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203985);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = j.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(203985);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    c(kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203982);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = j.a(null, null, (kotlin.d.d)this);
      AppMethodBeat.o(203982);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.j
 * JD-Core Version:    0.7.0.1
 */