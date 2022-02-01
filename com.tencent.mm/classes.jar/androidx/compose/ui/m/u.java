package androidx.compose.ui.m;

import androidx.compose.ui.e.ax;
import androidx.compose.ui.e.z;
import androidx.compose.ui.m.b.h;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.m.f.a;
import androidx.compose.ui.m.f.c;
import androidx.compose.ui.m.f.f;
import androidx.compose.ui.n.o;
import androidx.compose.ui.n.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/TextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackground-0d7_KjU", "()J", "J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getColor-0d7_KjU", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getLetterSpacing-XSAIIZE", "getLineHeight-XSAIIZE", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "copy", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "equals", "", "other", "hashCode", "", "merge", "plus", "toParagraphStyle", "toSpanStyle", "toString", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
{
  public static final u.a baB;
  private static final u baC;
  public final c aZc;
  public final androidx.compose.ui.m.f.e aZd;
  public final long aZe;
  public final androidx.compose.ui.m.f.g aZf;
  public final long ayn;
  public final long bai;
  public final i baj;
  public final androidx.compose.ui.m.b.g bak;
  public final h bal;
  public final androidx.compose.ui.m.b.d bam;
  public final String ban;
  public final long bao;
  public final a bap;
  public final f baq;
  public final androidx.compose.ui.m.d.e bar;
  public final long bas;
  final androidx.compose.ui.m.f.d bat;
  final ax bau;
  
  static
  {
    AppMethodBeat.i(205040);
    baB = new u.a((byte)0);
    baC = new u(0L, 0L, null, null, null, 0L, 0L, null, null, 0L, 262143);
    AppMethodBeat.o(205040);
  }
  
  private u(long paramLong1, long paramLong2, i parami, androidx.compose.ui.m.b.g paramg, h paramh, androidx.compose.ui.m.b.d paramd, String paramString, long paramLong3, a parama, f paramf, androidx.compose.ui.m.d.e parame, long paramLong4, androidx.compose.ui.m.f.d paramd1, ax paramax, c paramc, androidx.compose.ui.m.f.e parame1, long paramLong5, androidx.compose.ui.m.f.g paramg1)
  {
    AppMethodBeat.i(204981);
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
    this.aZc = paramc;
    this.aZd = parame1;
    this.aZe = paramLong5;
    this.aZf = paramg1;
    if (!p.bq(this.aZe))
    {
      if (o.bo(this.aZe) >= 0.0F) {}
      for (int i = 1; i == 0; i = 0)
      {
        parami = (Throwable)new IllegalStateException(("lineHeight can't be negative (" + o.bo(this.aZe) + ')').toString());
        AppMethodBeat.o(204981);
        throw parami;
      }
    }
    AppMethodBeat.o(204981);
  }
  
  public u(n paramn, l paraml)
  {
    this(paramn.ayn, paramn.bai, paramn.baj, paramn.bak, paramn.bal, paramn.bam, paramn.ban, paramn.bao, paramn.bap, paramn.baq, paramn.bar, paramn.bas, paramn.bat, paramn.bau, paraml.aZc, paraml.aZd, paraml.aZe, paraml.aZf, (byte)0);
    AppMethodBeat.i(205002);
    AppMethodBeat.o(205002);
  }
  
  public final n AR()
  {
    AppMethodBeat.i(205046);
    n localn = new n(this.ayn, this.bai, this.baj, this.bak, this.bal, this.bam, this.ban, this.bao, this.bap, this.baq, this.bar, this.bas, this.bat, this.bau, (byte)0);
    AppMethodBeat.o(205046);
    return localn;
  }
  
  public final l AS()
  {
    AppMethodBeat.i(205050);
    l locall = new l(this.aZc, this.aZd, this.aZe, this.aZf, (byte)0);
    AppMethodBeat.o(205050);
    return locall;
  }
  
  public final u a(u paramu)
  {
    AppMethodBeat.i(205056);
    if ((paramu == null) || (s.p(paramu, baC)))
    {
      AppMethodBeat.o(205056);
      return this;
    }
    paramu = new u(AR().a(paramu.AR()), AS().a(paramu.AS()));
    AppMethodBeat.o(205056);
    return paramu;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205064);
    if (this == paramObject)
    {
      AppMethodBeat.o(205064);
      return true;
    }
    if (!(paramObject instanceof u))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!z.e(this.ayn, ((u)paramObject).ayn))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!o.e(this.bai, ((u)paramObject).bai))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.baj, ((u)paramObject).baj))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.bak, ((u)paramObject).bak))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.bal, ((u)paramObject).bal))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.bam, ((u)paramObject).bam))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.ban, ((u)paramObject).ban))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!o.e(this.bao, ((u)paramObject).bao))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.bap, ((u)paramObject).bap))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.baq, ((u)paramObject).baq))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.bar, ((u)paramObject).bar))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!z.e(this.bas, ((u)paramObject).bas))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.bat, ((u)paramObject).bat))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.bau, ((u)paramObject).bau))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.aZc, ((u)paramObject).aZc))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.aZd, ((u)paramObject).aZd))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!o.e(this.aZe, ((u)paramObject).aZe))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    if (!s.p(this.aZf, ((u)paramObject).aZf))
    {
      AppMethodBeat.o(205064);
      return false;
    }
    AppMethodBeat.o(205064);
    return true;
  }
  
  public final int hashCode()
  {
    int i8 = 0;
    AppMethodBeat.i(205071);
    int i9 = z.I(this.ayn);
    int i10 = o.I(this.bai);
    Object localObject = this.baj;
    int i;
    int j;
    label53:
    int k;
    label66:
    int m;
    label80:
    int n;
    label94:
    int i11;
    int i1;
    label117:
    int i2;
    label131:
    int i3;
    label145:
    int i12;
    int i4;
    label168:
    int i5;
    label182:
    int i6;
    label196:
    int i7;
    label210:
    int i13;
    if (localObject == null)
    {
      i = 0;
      localObject = this.bak;
      if (localObject != null) {
        break label347;
      }
      j = 0;
      localObject = this.bal;
      if (localObject != null) {
        break label359;
      }
      k = 0;
      localObject = this.bam;
      if (localObject != null) {
        break label371;
      }
      m = 0;
      localObject = this.ban;
      if (localObject != null) {
        break label381;
      }
      n = 0;
      i11 = o.I(this.bao);
      localObject = this.bap;
      if (localObject != null) {
        break label391;
      }
      i1 = 0;
      localObject = this.baq;
      if (localObject != null) {
        break label404;
      }
      i2 = 0;
      localObject = this.bar;
      if (localObject != null) {
        break label414;
      }
      i3 = 0;
      i12 = z.I(this.bas);
      localObject = this.bat;
      if (localObject != null) {
        break label424;
      }
      i4 = 0;
      localObject = this.bau;
      if (localObject != null) {
        break label434;
      }
      i5 = 0;
      localObject = this.aZc;
      if (localObject != null) {
        break label444;
      }
      i6 = 0;
      localObject = this.aZd;
      if (localObject != null) {
        break label457;
      }
      i7 = 0;
      i13 = o.I(this.aZe);
      localObject = this.aZf;
      if (localObject != null) {
        break label470;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(205071);
      return ((i7 + (i6 + (i5 + (i4 + ((i3 + (i2 + (i1 + ((n + (m + (k + (j + (i + (i9 * 31 + i10) * 31) * 31) * 31) * 31) * 31) * 31 + i11) * 31) * 31) * 31) * 31 + i12) * 31) * 31) * 31) * 31) * 31 + i13) * 31 + i8;
      i = ((i)localObject).hashCode();
      break;
      label347:
      j = androidx.compose.ui.m.b.g.cG(((androidx.compose.ui.m.b.g)localObject).value);
      break label53;
      label359:
      k = h.cG(((h)localObject).value);
      break label66;
      label371:
      m = ((androidx.compose.ui.m.b.d)localObject).hashCode();
      break label80;
      label381:
      n = ((String)localObject).hashCode();
      break label94;
      label391:
      i1 = a.ah(((a)localObject).bby);
      break label117;
      label404:
      i2 = ((f)localObject).hashCode();
      break label131;
      label414:
      i3 = ((androidx.compose.ui.m.d.e)localObject).hashCode();
      break label145;
      label424:
      i4 = ((androidx.compose.ui.m.f.d)localObject).hashCode();
      break label168;
      label434:
      i5 = ((ax)localObject).hashCode();
      break label182;
      label444:
      i6 = c.cG(((c)localObject).value);
      break label196;
      label457:
      i7 = androidx.compose.ui.m.f.e.cG(((androidx.compose.ui.m.f.e)localObject).value);
      break label210;
      label470:
      i8 = ((androidx.compose.ui.m.f.g)localObject).hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205080);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TextStyle(color=").append(z.H(this.ayn)).append(", fontSize=").append(o.H(this.bai)).append(", fontWeight=").append(this.baj).append(", fontStyle=").append(this.bak).append(", fontSynthesis=").append(this.bal).append(", fontFamily=").append(this.bam).append(", fontFeatureSettings=").append(this.ban).append(", letterSpacing=").append(o.H(this.bao)).append(", baselineShift=").append(this.bap).append(", textGeometricTransform=").append(this.baq).append(", localeList=").append(this.bar).append(", background=");
    ((StringBuilder)localObject).append(z.H(this.bas)).append(", textDecoration=").append(this.bat).append(", shadow=").append(this.bau).append(", textAlign=").append(this.aZc).append(", textDirection=").append(this.aZd).append(", lineHeight=").append(o.H(this.aZe)).append(", textIndent=").append(this.aZf).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(205080);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.u
 * JD-Core Version:    0.7.0.1
 */