package androidx.compose.ui.m.e;

import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan.Standard;
import androidx.compose.ui.e.z;
import androidx.compose.ui.m.a.a;
import androidx.compose.ui.m.b.h;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.m.d.d.a;
import androidx.compose.ui.m.d.e.a;
import androidx.compose.ui.m.e.a.b;
import androidx.compose.ui.m.k;
import androidx.compose.ui.m.n;
import androidx.compose.ui.m.u;
import androidx.compose.ui.n.o;
import androidx.compose.ui.n.q;
import androidx.compose.ui.n.q.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "typefaceAdapter", "Landroidx/compose/ui/text/platform/TypefaceAdapter;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;Landroidx/compose/ui/text/platform/TypefaceAdapter;Landroidx/compose/ui/unit/Density;)V", "charSequence", "", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "getLayoutIntrinsics$ui_text_release", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "getPlaceholders", "()Ljava/util/List;", "getSpanStyles", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Ljava/lang/String;", "textDirectionHeuristic", "", "getTextDirectionHeuristic$ui_text_release", "()I", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTypefaceAdapter", "()Landroidx/compose/ui/text/platform/TypefaceAdapter;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements k
{
  private final androidx.compose.ui.n.d TD;
  private final List<a.a<n>> aYD;
  final u ahn;
  private final List<a.a<Object>> ahr;
  final androidx.compose.ui.m.a.c bbs;
  final CharSequence bbw;
  private final f bdL;
  final d bdM;
  final int bdN;
  private final String text;
  
  public c(String paramString, u paramu, List<a.a<n>> paramList, List<a.a<Object>> paramList1, f paramf, androidx.compose.ui.n.d paramd)
  {
    AppMethodBeat.i(205386);
    this.text = paramString;
    this.ahn = paramu;
    this.aYD = paramList;
    this.ahr = paramList1;
    this.bdL = paramf;
    this.TD = paramd;
    this.bdM = new d(this.TD.mn());
    paramu = this.ahn.aZd;
    paramString = this.ahn.bar;
    int i;
    label148:
    long l1;
    label244:
    int j;
    label294:
    label312:
    label569:
    label580:
    long l2;
    label412:
    label610:
    float f1;
    boolean bool;
    label631:
    label638:
    float f2;
    Object localObject1;
    Object localObject2;
    if (paramu == null)
    {
      paramu = androidx.compose.ui.m.f.e.beo;
      i = androidx.compose.ui.m.f.e.BY();
      paramu = androidx.compose.ui.m.f.e.beo;
      if (!androidx.compose.ui.m.f.e.C(i, androidx.compose.ui.m.f.e.BZ())) {
        break label877;
      }
      i = 2;
      this.bdN = i;
      paramList1 = this.bdM;
      paramList = this.ahn.AR();
      paramf = this.bdL;
      paramString = this.TD;
      s.u(paramList1, "<this>");
      s.u(paramList, "style");
      s.u(paramf, "typefaceAdapter");
      s.u(paramString, "density");
      l1 = o.bn(paramList.bai);
      paramu = q.beU;
      if (!q.e(l1, q.Ci())) {
        break label1055;
      }
      paramList1.setTextSize(paramString.t(paramList.bai));
      if (androidx.compose.ui.m.e.a.e.b(paramList))
      {
        paramd = paramList.bam;
        paramu = paramList.baj;
        paramString = paramu;
        if (paramu == null)
        {
          paramString = i.bcc;
          paramString = i.Bk();
        }
        paramu = paramList.bak;
        if (paramu != null) {
          break label1091;
        }
        paramu = androidx.compose.ui.m.b.g.bbW;
        i = androidx.compose.ui.m.b.g.Bd();
        paramu = paramList.bal;
        if (paramu != null) {
          break label1100;
        }
        paramu = h.bbZ;
        j = h.Bf();
        paramList1.setTypeface(paramf.a(paramd, paramString, i, j));
      }
      if (paramList.bar != null)
      {
        paramString = paramList.bar;
        paramu = androidx.compose.ui.m.d.e.bdD;
        if (!s.p(paramString, e.a.BL()))
        {
          if (Build.VERSION.SDK_INT < 24) {
            break label1109;
          }
          b.bdV.a(paramList1, paramList.bar);
        }
      }
      l1 = o.bn(paramList.bao);
      paramString = q.beU;
      if (!q.e(l1, q.Cj())) {
        break label1150;
      }
      paramList1.setLetterSpacing(o.bo(paramList.bao));
      if ((paramList.ban != null) && (!s.p(paramList.ban, ""))) {
        paramList1.setFontFeatureSettings(paramList.ban);
      }
      if (paramList.baq != null)
      {
        paramString = paramList.baq;
        paramu = androidx.compose.ui.m.f.f.beu;
        if (!s.p(paramString, androidx.compose.ui.m.f.f.Cb()))
        {
          paramList1.setTextScaleX(paramList1.getTextScaleX() * paramList.baq.scaleX);
          paramList1.setTextSkewX(paramList1.getTextSkewX() + paramList.baq.bbL);
        }
      }
      paramList1.W(paramList.ayn);
      paramList1.a(paramList.bau);
      paramList1.a(paramList.bat);
      l1 = o.bn(paramList.bao);
      paramString = q.beU;
      if (!q.e(l1, q.Ci())) {
        break label1172;
      }
      if (o.bo(paramList.bao) != 0.0F) {
        break label1166;
      }
      i = 1;
      if (i != 0) {
        break label1172;
      }
      l1 = paramList.bao;
      l2 = paramList.bas;
      paramString = z.awK;
      if (!z.e(l2, z.tz())) {
        break label1184;
      }
      paramString = z.awK;
      l2 = z.sw();
      paramString = paramList.bap;
      paramu = androidx.compose.ui.m.f.a.bdZ;
      f1 = androidx.compose.ui.m.f.a.BO();
      if (paramString != null) {
        break label1193;
      }
      bool = false;
      if (!bool) {
        break label1207;
      }
      paramString = null;
      paramu = new n(0L, 0L, null, null, null, null, null, l1, paramString, null, null, l2, null, null, 13951);
      paramd = this.text;
      f2 = this.bdM.getTextSize();
      paramString = this.ahn;
      paramu = kotlin.a.p.b((Collection)kotlin.a.p.listOf(new a.a(paramu, 0, this.text.length())), (Iterable)this.aYD);
      paramList = this.ahr;
      paramList1 = this.TD;
      paramf = this.bdL;
      s.u(paramd, "text");
      s.u(paramString, "contextTextStyle");
      s.u(paramu, "spanStyles");
      s.u(paramList, "placeholders");
      s.u(paramList1, "density");
      s.u(paramf, "typefaceAdapter");
      if ((!paramu.isEmpty()) || (!paramList.isEmpty())) {
        break label1215;
      }
      localObject1 = paramString.aZf;
      localObject2 = androidx.compose.ui.m.f.g.bew;
      if ((!s.p(localObject1, androidx.compose.ui.m.f.g.Cc())) || (!androidx.compose.ui.n.p.bq(paramString.aZe))) {
        break label1215;
      }
    }
    label1055:
    label1184:
    label1193:
    label1707:
    for (paramString = (CharSequence)paramd;; paramString = (CharSequence)paramd)
    {
      this.bbw = paramString;
      this.bbs = new androidx.compose.ui.m.a.c(this.bbw, (TextPaint)this.bdM, this.bdN);
      AppMethodBeat.o(205386);
      return;
      i = paramu.value;
      break;
      label877:
      paramu = androidx.compose.ui.m.f.e.beo;
      if (androidx.compose.ui.m.f.e.C(i, androidx.compose.ui.m.f.e.Ca()))
      {
        i = 3;
        break label148;
      }
      paramu = androidx.compose.ui.m.f.e.beo;
      if (androidx.compose.ui.m.f.e.C(i, androidx.compose.ui.m.f.e.BW()))
      {
        i = 0;
        break label148;
      }
      paramu = androidx.compose.ui.m.f.e.beo;
      if (androidx.compose.ui.m.f.e.C(i, androidx.compose.ui.m.f.e.BX()))
      {
        i = 1;
        break label148;
      }
      paramu = androidx.compose.ui.m.f.e.beo;
      if (androidx.compose.ui.m.f.e.C(i, androidx.compose.ui.m.f.e.BY()))
      {
        if (paramString == null) {}
        for (paramString = null;; paramString = ((androidx.compose.ui.m.d.a)paramString.BK().bdC).bdA)
        {
          paramu = paramString;
          if (paramString == null) {
            paramu = Locale.getDefault();
          }
          switch (androidx.core.e.f.d(paramu))
          {
          default: 
            i = 2;
            break label148;
          }
        }
        i = 2;
        break label148;
        i = 3;
        break label148;
      }
      paramString = (Throwable)new IllegalStateException("Invalid TextDirection.".toString());
      AppMethodBeat.o(205386);
      throw paramString;
      paramString = q.beU;
      if (!q.e(l1, q.Cj())) {
        break label244;
      }
      paramList1.setTextSize(paramList1.getTextSize() * o.bo(paramList.bai));
      break label244;
      label1091:
      i = paramu.value;
      break label294;
      label1100:
      j = paramu.value;
      break label312;
      label1109:
      if (paramList.bar.isEmpty()) {
        paramString = androidx.compose.ui.m.d.d.bdB;
      }
      for (paramString = d.a.BJ();; paramString = paramList.bar.BK())
      {
        paramList1.setTextLocale(androidx.compose.ui.m.e.a.a.a(paramString));
        break;
      }
      label1150:
      paramString = q.beU;
      q.e(l1, q.Ci());
      break label412;
      i = 0;
      break label569;
      paramString = o.beS;
      l1 = o.sw();
      break label580;
      l2 = paramList.bas;
      break label610;
      bool = androidx.compose.ui.m.f.a.G(paramString.bby, f1);
      break label631;
      label1207:
      paramString = paramList.bap;
      break label638;
      label1215:
      paramd = new SpannableString((CharSequence)paramd);
      localObject1 = (Spannable)paramd;
      l1 = paramString.aZe;
      s.u(localObject1, "$this$setLineHeight");
      s.u(paramList1, "density");
      l2 = o.bn(l1);
      localObject2 = q.beU;
      q.a locala;
      if (q.e(l2, q.Ci()))
      {
        androidx.compose.ui.m.e.a.d.a((Spannable)localObject1, new androidx.compose.ui.m.a.b.e((int)(float)Math.ceil(paramList1.t(l1))), 0, ((Spannable)localObject1).length());
        localObject1 = (Spannable)paramd;
        localObject2 = paramString.aZf;
        s.u(localObject1, "<this>");
        s.u(paramList1, "density");
        if ((localObject2 != null) && ((!o.e(((androidx.compose.ui.m.f.g)localObject2).bex, androidx.compose.ui.n.p.dG(0))) || (!o.e(((androidx.compose.ui.m.f.g)localObject2).bey, androidx.compose.ui.n.p.dG(0)))) && (!androidx.compose.ui.n.p.bq(((androidx.compose.ui.m.f.g)localObject2).bex)) && (!androidx.compose.ui.n.p.bq(((androidx.compose.ui.m.f.g)localObject2).bey)))
        {
          l1 = o.bn(((androidx.compose.ui.m.f.g)localObject2).bex);
          locala = q.beU;
          if (!q.e(l1, q.Ci())) {
            break label1631;
          }
          f1 = paramList1.t(((androidx.compose.ui.m.f.g)localObject2).bex);
          l1 = o.bn(((androidx.compose.ui.m.f.g)localObject2).bey);
          locala = q.beU;
          if (!q.e(l1, q.Ci())) {
            break label1669;
          }
          f2 = paramList1.t(((androidx.compose.ui.m.f.g)localObject2).bey);
        }
      }
      for (;;)
      {
        androidx.compose.ui.m.e.a.d.a((Spannable)localObject1, new LeadingMarginSpan.Standard((int)(float)Math.ceil(f1), (int)(float)Math.ceil(f2)), 0, ((Spannable)localObject1).length());
        androidx.compose.ui.m.e.a.d.a((Spannable)paramd, paramString, paramu, paramList1, paramf);
        s.u((Spannable)paramd, "<this>");
        s.u(paramList, "placeholders");
        s.u(paramList1, "density");
        if (paramList.size() - 1 < 0) {
          break label1707;
        }
        paramList.get(0);
        AppMethodBeat.o(205386);
        throw null;
        localObject2 = q.beU;
        if (!q.e(l2, q.Cj())) {
          break;
        }
        androidx.compose.ui.m.e.a.d.a((Spannable)localObject1, new androidx.compose.ui.m.a.b.e((int)(float)Math.ceil(o.bo(l1) * f2)), 0, ((Spannable)localObject1).length());
        break;
        label1631:
        locala = q.beU;
        if (q.e(l1, q.Cj()))
        {
          f1 = o.bo(((androidx.compose.ui.m.f.g)localObject2).bex) * f2;
          break label1439;
        }
        f1 = 0.0F;
        break label1439;
        locala = q.beU;
        if (q.e(l1, q.Cj())) {
          f2 *= o.bo(((androidx.compose.ui.m.f.g)localObject2).bey);
        } else {
          f2 = 0.0F;
        }
      }
    }
  }
  
  public final float AF()
  {
    AppMethodBeat.i(205398);
    float f = ((Number)this.bbs.aYT.getValue()).floatValue();
    AppMethodBeat.o(205398);
    return f;
  }
  
  public final float AG()
  {
    AppMethodBeat.i(205394);
    float f = this.bbs.AG();
    AppMethodBeat.o(205394);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.e.c
 * JD-Core Version:    0.7.0.1
 */