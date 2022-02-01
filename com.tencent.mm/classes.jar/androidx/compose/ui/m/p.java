package androidx.compose.ui.m;

import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import androidx.compose.ui.m.b.c.a;
import androidx.compose.ui.m.f.h;
import androidx.compose.ui.n.b;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/TextLayoutInput;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getMaxLines", "()I", "getOverflow-gIe3tQ8", "I", "getPlaceholders", "()Ljava/util/List;", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "copy", "copy-hu-1Yfo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;J)Landroidx/compose/ui/text/TextLayoutInput;", "equals", "other", "hashCode", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public final d TD;
  public final long aeB;
  public final n agm;
  public final a ahm;
  public final u ahn;
  public final boolean aho;
  public final int ahp;
  public final c.a ahq;
  public final List<a.a<Object>> ahr;
  public final int maxLines;
  
  private p(a parama, u paramu, List<a.a<Object>> paramList, int paramInt1, boolean paramBoolean, int paramInt2, d paramd, n paramn, c.a parama1, long paramLong)
  {
    this.ahm = parama;
    this.ahn = paramu;
    this.ahr = paramList;
    this.maxLines = paramInt1;
    this.aho = paramBoolean;
    this.ahp = paramInt2;
    this.TD = paramd;
    this.agm = paramn;
    this.ahq = parama1;
    this.aeB = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204962);
    if (this == paramObject)
    {
      AppMethodBeat.o(204962);
      return true;
    }
    if (!(paramObject instanceof p))
    {
      AppMethodBeat.o(204962);
      return false;
    }
    if (!s.p(this.ahm, ((p)paramObject).ahm))
    {
      AppMethodBeat.o(204962);
      return false;
    }
    if (!s.p(this.ahn, ((p)paramObject).ahn))
    {
      AppMethodBeat.o(204962);
      return false;
    }
    if (!s.p(this.ahr, ((p)paramObject).ahr))
    {
      AppMethodBeat.o(204962);
      return false;
    }
    if (this.maxLines != ((p)paramObject).maxLines)
    {
      AppMethodBeat.o(204962);
      return false;
    }
    if (this.aho != ((p)paramObject).aho)
    {
      AppMethodBeat.o(204962);
      return false;
    }
    if (!h.C(this.ahp, ((p)paramObject).ahp))
    {
      AppMethodBeat.o(204962);
      return false;
    }
    if (!s.p(this.TD, ((p)paramObject).TD))
    {
      AppMethodBeat.o(204962);
      return false;
    }
    if (this.agm != ((p)paramObject).agm)
    {
      AppMethodBeat.o(204962);
      return false;
    }
    if (!s.p(this.ahq, ((p)paramObject).ahq))
    {
      AppMethodBeat.o(204962);
      return false;
    }
    if (!b.e(this.aeB, ((p)paramObject).aeB))
    {
      AppMethodBeat.o(204962);
      return false;
    }
    AppMethodBeat.o(204962);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204976);
    int i = this.ahm.hashCode();
    int j = this.ahn.hashCode();
    int k = this.ahr.hashCode();
    int m = this.maxLines;
    int n = e..ExternalSyntheticBackport0.m(this.aho);
    int i1 = h.cG(this.ahp);
    int i2 = this.TD.hashCode();
    int i3 = this.agm.hashCode();
    int i4 = this.ahq.hashCode();
    int i5 = b.I(this.aeB);
    AppMethodBeat.o(204976);
    return ((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204990);
    String str = "TextLayoutInput(text=" + this.ahm + ", style=" + this.ahn + ", placeholders=" + this.ahr + ", maxLines=" + this.maxLines + ", softWrap=" + this.aho + ", overflow=" + h.cJ(this.ahp) + ", density=" + this.TD + ", layoutDirection=" + this.agm + ", resourceLoader=" + this.ahq + ", constraints=" + b.H(this.aeB) + ')';
    AppMethodBeat.o(204990);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.p
 * JD-Core Version:    0.7.0.1
 */