package androidx.compose.ui.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ValueElement;", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "getName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
{
  public static final int Ue = 8;
  private final String name;
  private final Object value;
  
  public ar(String paramString, Object paramObject)
  {
    AppMethodBeat.i(206712);
    this.name = paramString;
    this.value = paramObject;
    AppMethodBeat.o(206712);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206723);
    if (this == paramObject)
    {
      AppMethodBeat.o(206723);
      return true;
    }
    if (!(paramObject instanceof ar))
    {
      AppMethodBeat.o(206723);
      return false;
    }
    paramObject = (ar)paramObject;
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(206723);
      return false;
    }
    if (!s.p(this.value, paramObject.value))
    {
      AppMethodBeat.o(206723);
      return false;
    }
    AppMethodBeat.o(206723);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206719);
    int j = this.name.hashCode();
    if (this.value == null) {}
    for (int i = 0;; i = this.value.hashCode())
    {
      AppMethodBeat.o(206719);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206716);
    String str = "ValueElement(name=" + this.name + ", value=" + this.value + ')';
    AppMethodBeat.o(206716);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.platform.ar
 * JD-Core Version:    0.7.0.1
 */