package androidx.compose.ui.m.c;

import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/ImeOptions;", "", "singleLine", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "(ZIZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getImeAction-eUduSuo", "getKeyboardType-PjHm6EE", "getSingleLine", "copy", "copy-uxg59PA", "(ZIZII)Landroidx/compose/ui/text/input/ImeOptions;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a bcE;
  private static final g bcK;
  public final boolean bcF = false;
  public final int bcG;
  public final boolean bcH;
  public final int bcI;
  public final int bcJ;
  
  static
  {
    AppMethodBeat.i(205276);
    bcE = new g.a((byte)0);
    bcK = new g();
    AppMethodBeat.o(205276);
  }
  
  private g(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    this.bcG = paramInt1;
    this.bcH = true;
    this.bcI = paramInt2;
    this.bcJ = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205279);
    if (this == paramObject)
    {
      AppMethodBeat.o(205279);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(205279);
      return false;
    }
    if (this.bcF != ((g)paramObject).bcF)
    {
      AppMethodBeat.o(205279);
      return false;
    }
    if (!k.C(this.bcG, ((g)paramObject).bcG))
    {
      AppMethodBeat.o(205279);
      return false;
    }
    if (this.bcH != ((g)paramObject).bcH)
    {
      AppMethodBeat.o(205279);
      return false;
    }
    if (!l.C(this.bcI, ((g)paramObject).bcI))
    {
      AppMethodBeat.o(205279);
      return false;
    }
    if (!f.C(this.bcJ, ((g)paramObject).bcJ))
    {
      AppMethodBeat.o(205279);
      return false;
    }
    AppMethodBeat.o(205279);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205281);
    int i = e..ExternalSyntheticBackport0.m(this.bcF);
    int j = k.cG(this.bcG);
    int k = e..ExternalSyntheticBackport0.m(this.bcH);
    int m = l.cG(this.bcI);
    int n = f.cG(this.bcJ);
    AppMethodBeat.o(205281);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205286);
    String str = "ImeOptions(singleLine=" + this.bcF + ", capitalization=" + k.cJ(this.bcG) + ", autoCorrect=" + this.bcH + ", keyboardType=" + l.cJ(this.bcI) + ", imeAction=" + f.cJ(this.bcJ) + ')';
    AppMethodBeat.o(205286);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.c.g
 * JD-Core Version:    0.7.0.1
 */