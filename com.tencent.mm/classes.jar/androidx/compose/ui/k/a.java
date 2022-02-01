package androidx.compose.ui.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/AccessibilityAction;", "T", "Lkotlin/Function;", "", "", "label", "", "action", "(Ljava/lang/String;Lkotlin/Function;)V", "getAction", "()Lkotlin/Function;", "Lkotlin/Function;", "getLabel", "()Ljava/lang/String;", "equals", "other", "hashCode", "", "toString", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<T extends d<? extends Boolean>>
{
  public final T aWk;
  public final String label;
  
  public a(String paramString, T paramT)
  {
    this.label = paramString;
    this.aWk = paramT;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205426);
    if (this == paramObject)
    {
      AppMethodBeat.o(205426);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(205426);
      return false;
    }
    if (!s.p(this.label, ((a)paramObject).label))
    {
      AppMethodBeat.o(205426);
      return false;
    }
    if (!s.p(this.aWk, ((a)paramObject).aWk))
    {
      AppMethodBeat.o(205426);
      return false;
    }
    AppMethodBeat.o(205426);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(205432);
    Object localObject = this.label;
    if (localObject == null) {}
    for (int i = 0;; i = ((String)localObject).hashCode())
    {
      localObject = this.aWk;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(205432);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205437);
    String str = "AccessibilityAction(label=" + this.label + ", action=" + this.aWk + ')';
    AppMethodBeat.o(205437);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.a
 * JD-Core Version:    0.7.0.1
 */