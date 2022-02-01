package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/Updater;", "T", "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "init", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "reconcile", "reconcile-impl", "set", "V", "value", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "set-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Landroidx/compose/runtime/Composer;ILkotlin/jvm/functions/Function2;)V", "toString", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "update", "update-impl", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class br<T>
{
  public static final <V> void a(h paramh, V paramV, m<? super T, ? super V, ah> paramm)
  {
    AppMethodBeat.i(201981);
    s.u(paramh, "arg0");
    s.u(paramm, "block");
    if ((paramh.nY()) || (!s.p(paramh.or(), paramV)))
    {
      paramh.F(paramV);
      paramh.c(paramV, paramm);
    }
    AppMethodBeat.o(201981);
  }
  
  public static final void a(h paramh, b<? super T, ah> paramb)
  {
    AppMethodBeat.i(201984);
    s.u(paramh, "arg0");
    s.u(paramb, "block");
    if (paramh.nY()) {
      paramh.c(ah.aiuX, (m)new br.a(paramb));
    }
    AppMethodBeat.o(201984);
  }
  
  public final boolean equals(Object paramObject)
  {
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final String toString()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.br
 * JD-Core Version:    0.7.0.1
 */