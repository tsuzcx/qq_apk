package androidx.compose.ui.m.f;

import androidx.compose.ui.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/style/TextDecoration;", "", "mask", "", "(I)V", "getMask", "()I", "contains", "", "other", "equals", "hashCode", "plus", "decoration", "toString", "", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a bek;
  private static final d bel;
  private static final d bem;
  private static final d ben;
  public final int mask;
  
  static
  {
    AppMethodBeat.i(205060);
    bek = new a((byte)0);
    bel = new d(0);
    bem = new d(1);
    ben = new d(2);
    AppMethodBeat.o(205060);
  }
  
  public d(int paramInt)
  {
    this.mask = paramInt;
  }
  
  public final boolean b(d paramd)
  {
    AppMethodBeat.i(205065);
    s.u(paramd, "other");
    if ((this.mask | paramd.mask) == this.mask)
    {
      AppMethodBeat.o(205065);
      return true;
    }
    AppMethodBeat.o(205065);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
    } while (this.mask == ((d)paramObject).mask);
    return false;
  }
  
  public final int hashCode()
  {
    return this.mask;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205073);
    if (this.mask == 0)
    {
      AppMethodBeat.o(205073);
      return "TextDecoration.None";
    }
    Object localObject2 = (List)new ArrayList();
    if ((this.mask & bem.mask) != 0) {
      ((List)localObject2).add("Underline");
    }
    if ((this.mask & ben.mask) != 0) {
      ((List)localObject2).add("LineThrough");
    }
    if (((List)localObject2).size() == 1)
    {
      localObject1 = s.X("TextDecoration.", ((List)localObject2).get(0));
      AppMethodBeat.o(205073);
      return localObject1;
    }
    Object localObject1 = new StringBuilder("TextDecoration[");
    CharSequence localCharSequence1 = (CharSequence)", ";
    CharSequence localCharSequence2 = (CharSequence)"";
    CharSequence localCharSequence3 = (CharSequence)"";
    CharSequence localCharSequence4 = (CharSequence)"...";
    s.u(localObject2, "<this>");
    s.u(localCharSequence1, "separator");
    s.u(localCharSequence2, "prefix");
    s.u(localCharSequence3, "postfix");
    s.u(localCharSequence4, "truncated");
    localObject2 = ((StringBuilder)o.a((List)localObject2, (Appendable)new StringBuilder(), localCharSequence1, localCharSequence2, localCharSequence3)).toString();
    s.s(localObject2, "fastJoinTo(StringBuilder…form)\n        .toString()");
    localObject1 = (String)localObject2 + ']';
    AppMethodBeat.o(205073);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/text/style/TextDecoration$Companion;", "", "()V", "LineThrough", "Landroidx/compose/ui/text/style/TextDecoration;", "getLineThrough$annotations", "getLineThrough", "()Landroidx/compose/ui/text/style/TextDecoration;", "None", "getNone$annotations", "getNone", "Underline", "getUnderline$annotations", "getUnderline", "combine", "decorations", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.m.f.d
 * JD-Core Version:    0.7.0.1
 */