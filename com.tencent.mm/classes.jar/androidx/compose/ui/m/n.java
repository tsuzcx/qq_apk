package androidx.compose.ui.m;

import androidx.compose.ui.e.ax;
import androidx.compose.ui.e.z;
import androidx.compose.ui.m.b.g;
import androidx.compose.ui.m.b.h;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.m.d.e;
import androidx.compose.ui.m.f.a;
import androidx.compose.ui.m.f.f;
import androidx.compose.ui.n.o;
import androidx.compose.ui.n.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/SpanStyle;", "", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackground-0d7_KjU", "()J", "J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getColor-0d7_KjU", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getLetterSpacing-XSAIIZE", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "copy", "copy-IuqyXdg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;)Landroidx/compose/ui/text/SpanStyle;", "equals", "", "other", "hashCode", "", "merge", "plus", "toString", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public final long ayn;
  public final long bai;
  public final i baj;
  public final g bak;
  public final h bal;
  public final androidx.compose.ui.m.b.d bam;
  public final String ban;
  public final long bao;
  public final a bap;
  public final f baq;
  public final e bar;
  public final long bas;
  public final androidx.compose.ui.m.f.d bat;
  public final ax bau;
  
  private n(long paramLong1, long paramLong2, i parami, g paramg, h paramh, androidx.compose.ui.m.b.d paramd, String paramString, long paramLong3, a parama, f paramf, e parame, long paramLong4, androidx.compose.ui.m.f.d paramd1, ax paramax)
  {
    this.ayn = paramLong1;
    this.bai = paramLong2;
    this.baj = parami;
    this.bak = paramg;
    this.bal = paramh;
    this.bam = paramd;
    this.ban = paramString;
    this.bao = paramLong3;
    this.bap = parama;
    this.baq = paramf;
    this.bar = parame;
    this.bas = paramLong4;
    this.bat = paramd1;
    this.bau = paramax;
  }
  
  public final n a(n paramn)
  {
    AppMethodBeat.i(204988);
    if (paramn == null)
    {
      AppMethodBeat.o(204988);
      return this;
    }
    long l1 = paramn.ayn;
    Object localObject1 = z.awK;
    int i;
    label40:
    Object localObject2;
    long l2;
    label77:
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    long l3;
    label177:
    Object localObject7;
    Object localObject8;
    Object localObject9;
    long l4;
    if (l1 != z.sw())
    {
      i = 1;
      if (i == 0) {
        break label353;
      }
      localObject2 = paramn.bam;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.bam;
      }
      if (p.bq(paramn.bai)) {
        break label361;
      }
      l2 = paramn.bai;
      localObject3 = paramn.baj;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = this.baj;
      }
      localObject4 = paramn.bak;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = this.bak;
      }
      localObject5 = paramn.bal;
      localObject4 = localObject5;
      if (localObject5 == null) {
        localObject4 = this.bal;
      }
      localObject6 = paramn.ban;
      localObject5 = localObject6;
      if (localObject6 == null) {
        localObject5 = this.ban;
      }
      if (p.bq(paramn.bao)) {
        break label370;
      }
      l3 = paramn.bao;
      localObject7 = paramn.bap;
      localObject6 = localObject7;
      if (localObject7 == null) {
        localObject6 = this.bap;
      }
      localObject8 = paramn.baq;
      localObject7 = localObject8;
      if (localObject8 == null) {
        localObject7 = this.baq;
      }
      localObject9 = paramn.bar;
      localObject8 = localObject9;
      if (localObject9 == null) {
        localObject8 = this.bar;
      }
      l4 = paramn.bas;
      localObject9 = z.awK;
      if (l4 == z.sw()) {
        break label379;
      }
      i = 1;
      label262:
      if (i == 0) {
        break label384;
      }
    }
    for (;;)
    {
      Object localObject10 = paramn.bat;
      localObject9 = localObject10;
      if (localObject10 == null) {
        localObject9 = this.bat;
      }
      localObject10 = paramn.bau;
      paramn = (n)localObject10;
      if (localObject10 == null) {
        paramn = this.bau;
      }
      paramn = new n(l1, l2, (i)localObject2, (g)localObject3, (h)localObject4, (androidx.compose.ui.m.b.d)localObject1, (String)localObject5, l3, (a)localObject6, (f)localObject7, (e)localObject8, l4, (androidx.compose.ui.m.f.d)localObject9, paramn, (byte)0);
      AppMethodBeat.o(204988);
      return paramn;
      i = 0;
      break;
      label353:
      l1 = this.ayn;
      break label40;
      label361:
      l2 = this.bai;
      break label77;
      label370:
      l3 = this.bao;
      break label177;
      label379:
      i = 0;
      break label262;
      label384:
      l4 = this.bas;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204996);
    if (this == paramObject)
    {
      AppMethodBeat.o(204996);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!z.e(this.ayn, ((n)paramObject).ayn))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!o.e(this.bai, ((n)paramObject).bai))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!s.p(this.baj, ((n)paramObject).baj))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!s.p(this.bak, ((n)paramObject).bak))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!s.p(this.bal, ((n)paramObject).bal))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!s.p(this.bam, ((n)paramObject).bam))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!s.p(this.ban, ((n)paramObject).ban))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!o.e(this.bao, ((n)paramObject).bao))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!s.p(this.bap, ((n)paramObject).bap))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!s.p(this.baq, ((n)paramObject).baq))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!s.p(this.bar, ((n)paramObject).bar))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!z.e(this.bas, ((n)paramObject).bas))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!s.p(this.bat, ((n)paramObject).bat))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    if (!s.p(this.bau, ((n)paramObject).bau))
    {
      AppMethodBeat.o(204996);
      return false;
    }
    AppMethodBeat.o(204996);
    return true;
  }
  
  public final int hashCode()
  {
    int i5 = 0;
    AppMethodBeat.i(205005);
    int i6 = z.I(this.ayn);
    int i7 = o.I(this.bai);
    Object localObject = this.baj;
    int i;
    int j;
    label52:
    int k;
    label65:
    int m;
    label79:
    int n;
    label93:
    int i8;
    int i1;
    label116:
    int i2;
    label130:
    int i3;
    label144:
    int i9;
    int i4;
    if (localObject == null)
    {
      i = 0;
      localObject = this.bak;
      if (localObject != null) {
        break label270;
      }
      j = 0;
      localObject = this.bal;
      if (localObject != null) {
        break label282;
      }
      k = 0;
      localObject = this.bam;
      if (localObject != null) {
        break label294;
      }
      m = 0;
      localObject = this.ban;
      if (localObject != null) {
        break label304;
      }
      n = 0;
      i8 = o.I(this.bao);
      localObject = this.bap;
      if (localObject != null) {
        break label314;
      }
      i1 = 0;
      localObject = this.baq;
      if (localObject != null) {
        break label327;
      }
      i2 = 0;
      localObject = this.bar;
      if (localObject != null) {
        break label337;
      }
      i3 = 0;
      i9 = z.I(this.bas);
      localObject = this.bat;
      if (localObject != null) {
        break label347;
      }
      i4 = 0;
      label167:
      localObject = this.bau;
      if (localObject != null) {
        break label357;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(205005);
      return (i4 + ((i3 + (i2 + (i1 + ((n + (m + (k + (j + (i + (i6 * 31 + i7) * 31) * 31) * 31) * 31) * 31) * 31 + i8) * 31) * 31) * 31) * 31 + i9) * 31) * 31 + i5;
      i = ((i)localObject).hashCode();
      break;
      label270:
      j = g.cG(((g)localObject).value);
      break label52;
      label282:
      k = h.cG(((h)localObject).value);
      break label65;
      label294:
      m = ((androidx.compose.ui.m.b.d)localObject).hashCode();
      break label79;
      label304:
      n = ((String)localObject).hashCode();
      break label93;
      label314:
      i1 = a.ah(((a)localObject).bby);
      break label116;
      label327:
      i2 = ((f)localObject).hashCode();
      break label130;
      label337:
      i3 = ((e)localObject).hashCode();
      break label144;
      label347:
      i4 = ((androidx.compose.ui.m.f.d)localObject).hashCode();
      break label167;
      label357:
      i5 = ((ax)localObject).hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205016);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SpanStyle(color=").append(z.H(this.ayn)).append(", fontSize=").append(o.H(this.bai)).append(", fontWeight=").append(this.baj).append(", fontStyle=").append(this.bak).append(", fontSynthesis=").append(this.bal).append(", fontFamily=").append(this.bam).append(", fontFeatureSettings=").append(this.ban).append(", letterSpacing=").append(o.H(this.bao)).append(", baselineShift=").append(this.bap).append(", textGeometricTransform=").append(this.baq).append(", localeList=").append(this.bar).append(", background=");
    ((StringBuilder)localObject).append(z.H(this.bas)).append(", textDecoration=").append(this.bat).append(", shadow=").append(this.bau).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(205016);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.n
 * JD-Core Version:    0.7.0.1
 */