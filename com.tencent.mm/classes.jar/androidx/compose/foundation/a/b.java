package androidx.compose.foundation.a;

import androidx.compose.foundation.o;
import androidx.compose.foundation.p.b;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/DefaultScrollableState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "onDelta", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "isScrollInProgress", "", "()Z", "isScrollingState", "Landroidx/compose/runtime/MutableState;", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "scrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "dispatchRawDelta", "delta", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b
  implements s
{
  final kotlin.g.a.b<Float, Float> ZT;
  final p ZU;
  final androidx.compose.foundation.p ZV;
  final an<Boolean> ZW;
  
  public b(kotlin.g.a.b<? super Float, Float> paramb)
  {
    AppMethodBeat.i(204104);
    this.ZT = paramb;
    this.ZU = ((p)new b(this));
    this.ZV = new androidx.compose.foundation.p();
    this.ZW = bj.T(Boolean.FALSE);
    AppMethodBeat.o(204104);
  }
  
  public final Object a(final o paramo, final m<? super p, ? super d<? super ah>, ? extends Object> paramm, d<? super ah> paramd)
  {
    AppMethodBeat.i(204111);
    paramo = ar.c((m)new a(this, paramo, paramm, null), paramd);
    if (paramo == a.aiwj)
    {
      AppMethodBeat.o(204111);
      return paramo;
    }
    paramo = ah.aiuX;
    AppMethodBeat.o(204111);
    return paramo;
  }
  
  public final boolean ml()
  {
    AppMethodBeat.i(204117);
    boolean bool = ((Boolean)this.ZW.getValue()).booleanValue();
    AppMethodBeat.o(204117);
    return bool;
  }
  
  public final float s(float paramFloat)
  {
    AppMethodBeat.i(204115);
    paramFloat = ((Number)this.ZT.invoke(Float.valueOf(paramFloat))).floatValue();
    AppMethodBeat.o(204115);
    return paramFloat;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(b paramb, o paramo, m<? super p, ? super d<? super ah>, ? extends Object> paramm, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(204045);
      paramObject = (d)new a(this.ZX, paramo, paramm, paramd);
      AppMethodBeat.o(204045);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204041);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204041);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ZX.ZV;
        p localp = this.ZX.ZU;
        o localo = paramo;
        m localm = (m)new k(this.ZX, paramm)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(204135);
            paramAnonymousd = new 1(this.ZX, this.VV, paramAnonymousd);
            paramAnonymousd.L$0 = paramAnonymousObject;
            paramAnonymousObject = (d)paramAnonymousd;
            AppMethodBeat.o(204135);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(204128);
            a locala = a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(204128);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = (p)this.L$0;
              this.ZX.ZW.setValue(Boolean.TRUE);
              m localm = this.VV;
              this.label = 1;
              if (localm.invoke(paramAnonymousObject, this) == locala)
              {
                AppMethodBeat.o(204128);
                return locala;
              }
              break;
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
            }
            this.ZX.ZW.setValue(Boolean.FALSE);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(204128);
            return paramAnonymousObject;
          }
        };
        d locald = (d)this;
        this.label = 1;
        if (ar.c((m)new p.b(localo, paramObject, localm, localp, null), locald) == locala)
        {
          AppMethodBeat.o(204041);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(204041);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/gestures/DefaultScrollableState$scrollScope$1", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollBy", "", "pixels", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements p
  {
    b(b paramb) {}
    
    public final float t(float paramFloat)
    {
      AppMethodBeat.i(204035);
      paramFloat = ((Number)this.ZX.ZT.invoke(Float.valueOf(paramFloat))).floatValue();
      AppMethodBeat.o(204035);
      return paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.b
 * JD-Core Version:    0.7.0.1
 */