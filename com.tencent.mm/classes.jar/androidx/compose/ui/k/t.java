package androidx.compose.ui.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "T", "", "name", "", "mergePolicy", "Lkotlin/Function2;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getMergePolicy$ui_release", "()Lkotlin/jvm/functions/Function2;", "getName", "()Ljava/lang/String;", "getValue", "thisRef", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "merge", "parentValue", "childValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "setValue", "", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t<T>
{
  final m<T, T, T> aYx;
  final String name;
  
  public t(String paramString, m<? super T, ? super T, ? extends T> paramm)
  {
    AppMethodBeat.i(205425);
    this.name = paramString;
    this.aYx = paramm;
    AppMethodBeat.o(205425);
  }
  
  public final void a(u paramu, o<?> paramo, T paramT)
  {
    AppMethodBeat.i(205438);
    s.u(paramu, "thisRef");
    s.u(paramo, "property");
    paramu.a(this, paramT);
    AppMethodBeat.o(205438);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205445);
    String str = s.X("SemanticsPropertyKey: ", this.name);
    AppMethodBeat.o(205445);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.k.t
 * JD-Core Version:    0.7.0.1
 */