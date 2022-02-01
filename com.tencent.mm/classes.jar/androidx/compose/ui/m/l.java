package androidx.compose.ui.m;

import androidx.compose.ui.m.f.c;
import androidx.compose.ui.m.f.e;
import androidx.compose.ui.m.f.g;
import androidx.compose.ui.n.o;
import androidx.compose.ui.n.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/ParagraphStyle;", "", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineHeight-XSAIIZE", "()J", "J", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "copy", "copy-Elsmlbk", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/ParagraphStyle;", "equals", "", "other", "hashCode", "", "merge", "plus", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  final c aZc;
  final e aZd;
  final long aZe;
  final g aZf;
  
  private l(c paramc, e parame, long paramLong, g paramg)
  {
    AppMethodBeat.i(204901);
    this.aZc = paramc;
    this.aZd = parame;
    this.aZe = paramLong;
    this.aZf = paramg;
    paramLong = this.aZe;
    paramc = o.beS;
    if (!o.e(paramLong, o.sw()))
    {
      if (o.bo(this.aZe) >= 0.0F) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramc = (Throwable)new IllegalStateException(("lineHeight can't be negative (" + o.bo(this.aZe) + ')').toString());
        AppMethodBeat.o(204901);
        throw paramc;
      }
    }
    AppMethodBeat.o(204901);
  }
  
  public final l a(l paraml)
  {
    AppMethodBeat.i(204910);
    if (paraml == null)
    {
      AppMethodBeat.o(204910);
      return this;
    }
    if (p.bq(paraml.aZe)) {}
    for (long l = this.aZe;; l = paraml.aZe)
    {
      Object localObject2 = paraml.aZf;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.aZf;
      }
      Object localObject3 = paraml.aZc;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = this.aZc;
      }
      localObject3 = paraml.aZd;
      paraml = (l)localObject3;
      if (localObject3 == null) {
        paraml = this.aZd;
      }
      paraml = new l((c)localObject2, paraml, l, (g)localObject1, (byte)0);
      AppMethodBeat.o(204910);
      return paraml;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204914);
    if (this == paramObject)
    {
      AppMethodBeat.o(204914);
      return true;
    }
    if (!(paramObject instanceof l))
    {
      AppMethodBeat.o(204914);
      return false;
    }
    if (!s.p(this.aZc, ((l)paramObject).aZc))
    {
      AppMethodBeat.o(204914);
      return false;
    }
    if (!s.p(this.aZd, ((l)paramObject).aZd))
    {
      AppMethodBeat.o(204914);
      return false;
    }
    if (!o.e(this.aZe, ((l)paramObject).aZe))
    {
      AppMethodBeat.o(204914);
      return false;
    }
    if (!s.p(this.aZf, ((l)paramObject).aZf))
    {
      AppMethodBeat.o(204914);
      return false;
    }
    AppMethodBeat.o(204914);
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(204920);
    Object localObject = this.aZc;
    int i;
    int j;
    label33:
    int m;
    if (localObject == null)
    {
      i = 0;
      localObject = this.aZd;
      if (localObject != null) {
        break label88;
      }
      j = 0;
      m = o.I(this.aZe);
      localObject = this.aZf;
      if (localObject != null) {
        break label100;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(204920);
      return ((j + i * 31) * 31 + m) * 31 + k;
      i = c.cG(((c)localObject).value);
      break;
      label88:
      j = e.cG(((e)localObject).value);
      break label33;
      label100:
      k = ((g)localObject).hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204924);
    String str = "ParagraphStyle(textAlign=" + this.aZc + ", textDirection=" + this.aZd + ", lineHeight=" + o.H(this.aZe) + ", textIndent=" + this.aZf + ')';
    AppMethodBeat.o(204924);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.l
 * JD-Core Version:    0.7.0.1
 */