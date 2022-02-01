package androidx.compose.ui.m.e;

import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.m.a.a;
import androidx.compose.ui.m.b.c.a;
import androidx.compose.ui.m.b.g;
import androidx.compose.ui.m.b.h;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.m.b.j;
import androidx.compose.ui.m.n;
import androidx.compose.ui.m.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"setSpanStyle", "", "Landroid/text/SpannableString;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "density", "Landroidx/compose/ui/unit/Density;", "typefaceAdapter", "Landroidx/compose/ui/text/platform/TypefaceAdapter;", "toAccessibilitySpannableString", "Landroidx/compose/ui/text/AnnotatedString;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final SpannableString a(androidx.compose.ui.m.a parama, androidx.compose.ui.n.d paramd, c.a parama1)
  {
    int j = 0;
    AppMethodBeat.i(205337);
    s.u(parama, "<this>");
    s.u(paramd, "density");
    s.u(parama1, "resourceLoader");
    SpannableString localSpannableString = new SpannableString((CharSequence)parama.text);
    parama1 = new f(parama1);
    List localList = parama.aYD;
    int m = localList.size() - 1;
    if (m >= 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      a.a locala = (a.a)localList.get(i);
      a(localSpannableString, (n)locala.aYG, locala.start, locala.end, paramd, parama1);
      if (k > m)
      {
        parama = parama.dg(parama.length());
        k = parama.size() - 1;
        if (k >= 0) {}
        for (i = j;; i = j)
        {
          j = i + 1;
          paramd = (a.a)parama.get(i);
          parama1 = (w)paramd.aYG;
          i = paramd.start;
          m = paramd.end;
          localSpannableString.setSpan(androidx.compose.ui.m.e.a.f.a(parama1), i, m, 33);
          if (j > k)
          {
            AppMethodBeat.o(205337);
            return localSpannableString;
          }
        }
      }
    }
  }
  
  private static final void a(SpannableString paramSpannableString, n paramn, int paramInt1, int paramInt2, androidx.compose.ui.n.d paramd, f paramf)
  {
    AppMethodBeat.i(205348);
    androidx.compose.ui.m.e.a.d.b((Spannable)paramSpannableString, paramn.ayn, paramInt1, paramInt2);
    androidx.compose.ui.m.e.a.d.a((Spannable)paramSpannableString, paramn.bai, paramd, paramInt1, paramInt2);
    if ((paramn.baj != null) || (paramn.bak != null))
    {
      localObject = paramn.baj;
      paramd = (androidx.compose.ui.n.d)localObject;
      if (localObject == null)
      {
        paramd = i.bcc;
        paramd = i.Bk();
      }
      localObject = paramn.bak;
      if (localObject == null)
      {
        localObject = g.bbW;
        i = g.Bd();
        localObject = f.bdP;
        paramSpannableString.setSpan(new StyleSpan(f.b.a(paramd, i)), paramInt1, paramInt2, 33);
      }
    }
    else if (paramn.bam != null)
    {
      if (!(paramn.bam instanceof j)) {
        break label314;
      }
      paramSpannableString.setSpan(new TypefaceSpan(((j)paramn.bam).name), paramInt1, paramInt2, 33);
    }
    label314:
    while (Build.VERSION.SDK_INT < 28)
    {
      if (paramn.bat != null)
      {
        paramd = paramn.bat;
        paramf = androidx.compose.ui.m.f.d.bek;
        if (paramd.b(androidx.compose.ui.m.f.d.BU())) {
          paramSpannableString.setSpan(new UnderlineSpan(), paramInt1, paramInt2, 33);
        }
        paramd = paramn.bat;
        paramf = androidx.compose.ui.m.f.d.bek;
        if (paramd.b(androidx.compose.ui.m.f.d.BV())) {
          paramSpannableString.setSpan(new StrikethroughSpan(), paramInt1, paramInt2, 33);
        }
      }
      if (paramn.baq != null) {
        paramSpannableString.setSpan(new ScaleXSpan(paramn.baq.scaleX), paramInt1, paramInt2, 33);
      }
      androidx.compose.ui.m.e.a.d.a((Spannable)paramSpannableString, paramn.bar, paramInt1, paramInt2);
      androidx.compose.ui.m.e.a.d.a((Spannable)paramSpannableString, paramn.bas, paramInt1, paramInt2);
      AppMethodBeat.o(205348);
      return;
      i = ((g)localObject).value;
      break;
    }
    paramd = paramn.bam;
    Object localObject = paramn.bal;
    if (localObject == null) {
      localObject = h.bbZ;
    }
    for (int i = h.Bf();; i = ((h)localObject).value)
    {
      paramd = f.a(paramf, paramd, i);
      paramSpannableString.setSpan(e.bdO.c(paramd), paramInt1, paramInt2, 33);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.e.a
 * JD-Core Version:    0.7.0.1
 */