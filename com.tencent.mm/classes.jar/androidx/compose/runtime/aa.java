package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cg;

@Metadata(d1={""}, d2={"DisposableEffectNoParamError", "", "InternalDisposableEffectScope", "Landroidx/compose/runtime/DisposableEffectScope;", "LaunchedEffectNoParamError", "DisposableEffect", "", "effect", "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key1", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "keys", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LaunchedEffect", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SideEffect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "createCompositionCoroutineScope", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "composer", "Landroidx/compose/runtime/Composer;", "rememberCoroutineScope", "getContext", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlinx/coroutines/CoroutineScope;", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class aa
{
  private static final y anW;
  
  static
  {
    AppMethodBeat.i(201939);
    anW = new y();
    AppMethodBeat.o(201939);
  }
  
  public static final aq a(f paramf, h paramh)
  {
    AppMethodBeat.i(201935);
    s.u(paramf, "coroutineContext");
    s.u(paramh, "composer");
    if (paramf.get((f.c)cb.ajws) != null)
    {
      paramf = cg.e(null);
      paramf.R((Throwable)new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"));
      paramf = ar.d((f)paramf);
      AppMethodBeat.o(201935);
      return paramf;
    }
    paramh = paramh.ow();
    paramf = ar.d(paramh.plus((f)cg.e((cb)paramh.get((f.c)cb.ajws))).plus(paramf));
    AppMethodBeat.o(201935);
    return paramf;
  }
  
  public static final void a(Object paramObject1, Object paramObject2, Object paramObject3, b<? super y, ? extends x> paramb, h paramh)
  {
    AppMethodBeat.i(201903);
    s.u(paramb, "effect");
    paramh.bx(592134824);
    paramh.bx(-3686095);
    boolean bool1 = paramh.G(paramObject1);
    boolean bool2 = paramh.G(paramObject2);
    boolean bool3 = paramh.G(paramObject3);
    paramObject1 = paramh.or();
    if (!(bool1 | bool2 | bool3))
    {
      paramObject2 = h.alD;
      if (paramObject1 != h.a.ox()) {}
    }
    else
    {
      paramh.F(new w(paramb));
    }
    paramh.od();
    paramh.od();
    AppMethodBeat.o(201903);
  }
  
  public static final void a(Object paramObject1, Object paramObject2, Object paramObject3, m<? super aq, ? super d<? super ah>, ? extends Object> paramm, h paramh)
  {
    AppMethodBeat.i(201921);
    s.u(paramm, "block");
    paramh.bx(1036444259);
    f localf = paramh.ow();
    paramh.bx(-3686095);
    boolean bool1 = paramh.G(paramObject1);
    boolean bool2 = paramh.G(paramObject2);
    boolean bool3 = paramh.G(paramObject3);
    paramObject1 = paramh.or();
    if (!(bool1 | bool2 | bool3))
    {
      paramObject2 = h.alD;
      if (paramObject1 != h.a.ox()) {}
    }
    else
    {
      paramh.F(new aj(localf, paramm));
    }
    paramh.od();
    paramh.od();
    AppMethodBeat.o(201921);
  }
  
  public static final void a(Object paramObject1, Object paramObject2, b<? super y, ? extends x> paramb, h paramh)
  {
    AppMethodBeat.i(201897);
    s.u(paramb, "effect");
    paramh.bx(592132916);
    paramh.bx(-3686552);
    boolean bool1 = paramh.G(paramObject1);
    boolean bool2 = paramh.G(paramObject2);
    paramObject1 = paramh.or();
    if (!(bool1 | bool2))
    {
      paramObject2 = h.alD;
      if (paramObject1 != h.a.ox()) {}
    }
    else
    {
      paramh.F(new w(paramb));
    }
    paramh.od();
    paramh.od();
    AppMethodBeat.o(201897);
  }
  
  public static final void a(Object paramObject1, Object paramObject2, m<? super aq, ? super d<? super ah>, ? extends Object> paramm, h paramh)
  {
    AppMethodBeat.i(201917);
    s.u(paramm, "block");
    paramh.bx(1036443237);
    f localf = paramh.ow();
    paramh.bx(-3686552);
    boolean bool1 = paramh.G(paramObject1);
    boolean bool2 = paramh.G(paramObject2);
    paramObject1 = paramh.or();
    if (!(bool1 | bool2))
    {
      paramObject2 = h.alD;
      if (paramObject1 != h.a.ox()) {}
    }
    else
    {
      paramh.F(new aj(localf, paramm));
    }
    paramh.od();
    paramh.od();
    AppMethodBeat.o(201917);
  }
  
  public static final void a(Object paramObject, b<? super y, ? extends x> paramb, h paramh)
  {
    AppMethodBeat.i(201891);
    s.u(paramb, "effect");
    paramh.bx(592131046);
    paramh.bx(-3686930);
    boolean bool = paramh.G(paramObject);
    paramObject = paramh.or();
    if (!bool)
    {
      h.a locala = h.alD;
      if (paramObject != h.a.ox()) {}
    }
    else
    {
      paramh.F(new w(paramb));
    }
    paramh.od();
    paramh.od();
    AppMethodBeat.o(201891);
  }
  
  public static final void a(Object paramObject, m<? super aq, ? super d<? super ah>, ? extends Object> paramm, h paramh)
  {
    AppMethodBeat.i(201908);
    s.u(paramm, "block");
    paramh.bx(1036442245);
    f localf = paramh.ow();
    paramh.bx(-3686930);
    boolean bool = paramh.G(paramObject);
    paramObject = paramh.or();
    if (!bool)
    {
      h.a locala = h.alD;
      if (paramObject != h.a.ox()) {}
    }
    else
    {
      paramh.F(new aj(localf, paramm));
    }
    paramh.od();
    paramh.od();
    AppMethodBeat.o(201908);
  }
  
  public static final void a(a<ah> parama, h paramh)
  {
    AppMethodBeat.i(201881);
    s.u(parama, "effect");
    paramh.bx(-2102467972);
    paramh.b(parama);
    paramh.od();
    AppMethodBeat.o(201881);
  }
  
  public static final void a(Object[] paramArrayOfObject, m<? super aq, ? super d<? super ah>, ? extends Object> paramm, h paramh)
  {
    AppMethodBeat.i(201930);
    s.u(paramArrayOfObject, "keys");
    s.u(paramm, "block");
    paramh.bx(1036445312);
    f localf = paramh.ow();
    paramArrayOfObject = Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length);
    paramh.bx(-3685570);
    int j = paramArrayOfObject.length;
    int i = 0;
    Object localObject;
    for (boolean bool = false; i < j; bool = paramh.G(localObject) | bool)
    {
      localObject = paramArrayOfObject[i];
      i += 1;
    }
    paramArrayOfObject = paramh.or();
    if (!bool)
    {
      localObject = h.alD;
      if (paramArrayOfObject != h.a.ox()) {}
    }
    else
    {
      paramh.F(new aj(localf, paramm));
    }
    paramh.od();
    paramh.od();
    AppMethodBeat.o(201930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.aa
 * JD-Core Version:    0.7.0.1
 */