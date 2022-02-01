package androidx.compose.ui.m.e.a;

import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.ax;
import androidx.compose.ui.e.z;
import androidx.compose.ui.e.z.a;
import androidx.compose.ui.m.a.a;
import androidx.compose.ui.m.a.b.g;
import androidx.compose.ui.m.a.b.h;
import androidx.compose.ui.m.a.b.i;
import androidx.compose.ui.m.n;
import androidx.compose.ui.n.o;
import androidx.compose.ui.n.q.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"createLetterSpacingSpan", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "density", "Landroidx/compose/ui/unit/Density;", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "flattenFontStylesAndApply", "", "contextFontSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "block", "Lkotlin/Function3;", "", "hasFontAttributes", "", "Landroidx/compose/ui/text/TextStyle;", "merge", "spanStyle", "setBackground", "Landroid/text/Spannable;", "color", "Landroidx/compose/ui/graphics/Color;", "start", "end", "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setBaselineShift", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-0ocSgnM", "setColor", "setColor-RPmYEkk", "setFontAttributes", "contextTextStyle", "typefaceAdapter", "Landroidx/compose/ui/text/platform/TypefaceAdapter;", "setFontFeatureSettings", "fontFeatureSettings", "", "setFontSize", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setGeometricTransform", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "setLineHeight", "lineHeight", "contextFontSize", "", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "setLocaleList", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setShadow", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "setSpan", "span", "", "setSpanStyle", "spanStyleRange", "lowPrioritySpans", "Ljava/util/ArrayList;", "Landroidx/compose/ui/text/platform/extensions/SpanRange;", "Lkotlin/collections/ArrayList;", "setSpanStyles", "setTextDecoration", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setTextIndent", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final n a(n paramn1, n paramn2)
  {
    AppMethodBeat.i(205439);
    if (paramn1 == null)
    {
      AppMethodBeat.o(205439);
      return paramn2;
    }
    paramn1 = paramn1.a(paramn2);
    AppMethodBeat.o(205439);
    return paramn1;
  }
  
  public static final void a(Spannable paramSpannable, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205416);
    s.u(paramSpannable, "$this$setBackground");
    z.a locala = z.awK;
    if (paramLong != z.sw()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        a(paramSpannable, new BackgroundColorSpan(ab.ai(paramLong)), paramInt1, paramInt2);
      }
      AppMethodBeat.o(205416);
      return;
    }
  }
  
  public static final void a(Spannable paramSpannable, long paramLong, androidx.compose.ui.n.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205428);
    s.u(paramSpannable, "$this$setFontSize");
    s.u(paramd, "density");
    long l = o.bn(paramLong);
    q.a locala = androidx.compose.ui.n.q.beU;
    if (androidx.compose.ui.n.q.e(l, androidx.compose.ui.n.q.Ci()))
    {
      a(paramSpannable, new AbsoluteSizeSpan(kotlin.h.a.eH(paramd.t(paramLong)), false), paramInt1, paramInt2);
      AppMethodBeat.o(205428);
      return;
    }
    paramd = androidx.compose.ui.n.q.beU;
    if (androidx.compose.ui.n.q.e(l, androidx.compose.ui.n.q.Cj())) {
      a(paramSpannable, new RelativeSizeSpan(o.bo(paramLong)), paramInt1, paramInt2);
    }
    AppMethodBeat.o(205428);
  }
  
  public static final void a(Spannable paramSpannable, androidx.compose.ui.m.d.e parame, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205421);
    s.u(paramSpannable, "<this>");
    if (parame != null)
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        parame = b.bdV.a(parame);
        a(paramSpannable, parame, paramInt1, paramInt2);
      }
    }
    else
    {
      AppMethodBeat.o(205421);
      return;
    }
    if (parame.isEmpty()) {
      parame = androidx.compose.ui.m.d.d.bdB;
    }
    for (parame = androidx.compose.ui.m.d.d.a.BJ();; parame = parame.BK())
    {
      parame = new LocaleSpan(a.a(parame));
      break;
    }
  }
  
  public static final void a(Spannable paramSpannable, androidx.compose.ui.m.u paramu, List<a.a<n>> paramList, androidx.compose.ui.n.d paramd, final androidx.compose.ui.m.e.f paramf)
  {
    AppMethodBeat.i(205402);
    s.u(paramSpannable, "<this>");
    s.u(paramu, "contextTextStyle");
    s.u(paramList, "spanStyles");
    s.u(paramd, "density");
    s.u(paramf, "typefaceAdapter");
    Object localObject1 = new ArrayList(paramList.size());
    int i = 0;
    int k = paramList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      Object localObject2 = paramList.get(i);
      a.a locala = (a.a)localObject2;
      if ((e.b((n)locala.aYG)) || (((n)locala.aYG).bal != null))
      {
        i = 1;
        if (i != 0) {
          ((Collection)localObject1).add(localObject2);
        }
        if (j <= k) {
          break label844;
        }
        localObject1 = (List)localObject1;
        if ((!e.b(paramu.AR())) && (paramu.bal == null)) {
          break label780;
        }
        i = 1;
        label175:
        if (i == 0) {
          break label786;
        }
        localObject2 = paramu.bam;
        paramu = new n(0L, 0L, paramu.baj, paramu.bak, paramu.bal, (androidx.compose.ui.m.b.d)localObject2, null, 0L, null, null, null, 0L, null, null, 16323);
        label221:
        a(paramu, (List)localObject1, (kotlin.g.a.q)new a(paramSpannable, paramf));
        paramf = new ArrayList();
        i = 0;
        k = paramList.size() - 1;
        if (k < 0) {}
      }
      for (;;)
      {
        j = i + 1;
        paramu = (a.a)paramList.get(i);
        i = paramu.start;
        int m = paramu.end;
        long l1;
        long l2;
        if ((i >= 0) && (i < paramSpannable.length()) && (m > i) && (m <= paramSpannable.length()))
        {
          i = paramu.start;
          m = paramu.end;
          paramu = (n)paramu.aYG;
          localObject1 = paramu.bap;
          if (localObject1 != null) {
            a(paramSpannable, new androidx.compose.ui.m.a.b.a(((androidx.compose.ui.m.f.a)localObject1).bby), i, m);
          }
          b(paramSpannable, paramu.ayn, i, m);
          localObject1 = paramu.bat;
          s.u(paramSpannable, "<this>");
          if (localObject1 != null)
          {
            localObject2 = androidx.compose.ui.m.f.d.bek;
            boolean bool = ((androidx.compose.ui.m.f.d)localObject1).b(androidx.compose.ui.m.f.d.BU());
            localObject2 = androidx.compose.ui.m.f.d.bek;
            a(paramSpannable, new i(bool, ((androidx.compose.ui.m.f.d)localObject1).b(androidx.compose.ui.m.f.d.BV())), i, m);
          }
          a(paramSpannable, paramu.bai, paramd, i, m);
          localObject1 = paramu.ban;
          if (localObject1 != null) {
            a(paramSpannable, new androidx.compose.ui.m.a.b.b((String)localObject1), i, m);
          }
          localObject1 = paramu.baq;
          if (localObject1 != null)
          {
            a(paramSpannable, new ScaleXSpan(((androidx.compose.ui.m.f.f)localObject1).scaleX), i, m);
            a(paramSpannable, new h(((androidx.compose.ui.m.f.f)localObject1).bbL), i, m);
          }
          a(paramSpannable, paramu.bar, i, m);
          a(paramSpannable, paramu.bas, i, m);
          localObject1 = paramu.bau;
          if (localObject1 != null) {
            a(paramSpannable, new g(ab.ai(((ax)localObject1).ayn), androidx.compose.ui.d.e.F(((ax)localObject1).offset), androidx.compose.ui.d.e.G(((ax)localObject1).offset), ((ax)localObject1).ayo), i, m);
          }
          l1 = paramu.bao;
          l2 = o.bn(l1);
          paramu = androidx.compose.ui.n.q.beU;
          if (!androidx.compose.ui.n.q.e(l2, androidx.compose.ui.n.q.Ci())) {
            break label791;
          }
          paramu = (MetricAffectingSpan)new androidx.compose.ui.m.a.b.d(paramd.t(l1));
          label674:
          if (paramu != null) {
            paramf.add(new c(paramu, i, m));
          }
        }
        if (j > k)
        {
          paramu = (List)paramf;
          i = 0;
          k = paramu.size() - 1;
          if (k >= 0) {}
          for (;;)
          {
            j = i + 1;
            paramList = (c)paramu.get(i);
            a(paramSpannable, paramList.bdW, paramList.start, paramList.end);
            if (j > k)
            {
              AppMethodBeat.o(205402);
              return;
              i = 0;
              break;
              label780:
              i = 0;
              break label175;
              label786:
              paramu = null;
              break label221;
              label791:
              paramu = androidx.compose.ui.n.q.beU;
              if (androidx.compose.ui.n.q.e(l2, androidx.compose.ui.n.q.Cj()))
              {
                paramu = (MetricAffectingSpan)new androidx.compose.ui.m.a.b.c(o.bo(l1));
                break label674;
              }
              paramu = null;
              break label674;
            }
            i = j;
          }
        }
        i = j;
      }
      label844:
      i = j;
    }
  }
  
  public static final void a(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205378);
    s.u(paramSpannable, "<this>");
    s.u(paramObject, "span");
    paramSpannable.setSpan(paramObject, paramInt1, paramInt2, 33);
    AppMethodBeat.o(205378);
  }
  
  private static void a(n paramn, List<a.a<n>> paramList, kotlin.g.a.q<? super n, ? super Integer, ? super Integer, ah> paramq)
  {
    AppMethodBeat.i(205412);
    s.u(paramList, "spanStyles");
    s.u(paramq, "block");
    if (paramList.size() <= 1)
    {
      if (!((Collection)paramList).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          paramq.invoke(a(paramn, (n)((a.a)paramList.get(0)).aYG), Integer.valueOf(((a.a)paramList.get(0)).start), Integer.valueOf(((a.a)paramList.get(0)).end));
        }
        AppMethodBeat.o(205412);
        return;
      }
    }
    int k = paramList.size();
    int j = k * 2;
    Integer[] arrayOfInteger = new Integer[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    int m = paramList.size() - 1;
    if (m >= 0) {}
    for (i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = (a.a)paramList.get(i);
      arrayOfInteger[i] = Integer.valueOf(((a.a)localObject).start);
      arrayOfInteger[(i + k)] = Integer.valueOf(((a.a)localObject).end);
      if (j > m)
      {
        k.W((Object[])arrayOfInteger);
        j = ((Number)k.X(arrayOfInteger)).intValue();
        int i1 = arrayOfInteger.length;
        i = 0;
        label407:
        label414:
        label417:
        label423:
        for (;;)
        {
          label308:
          int n;
          if (i < i1)
          {
            m = arrayOfInteger[i].intValue();
            i += 1;
            if (m == j) {
              break label423;
            }
            int i2 = paramList.size() - 1;
            if (i2 < 0) {
              break label417;
            }
            localObject = paramn;
            k = 0;
            n = k + 1;
            a.a locala = (a.a)paramList.get(k);
            if (!androidx.compose.ui.m.b.i(j, m, locala.start, locala.end)) {
              break label414;
            }
            localObject = a((n)localObject, (n)locala.aYG);
            label362:
            if (n <= i2) {
              break label407;
            }
          }
          for (;;)
          {
            if (localObject != null) {
              paramq.invoke(localObject, Integer.valueOf(j), Integer.valueOf(m));
            }
            j = m;
            break;
            AppMethodBeat.o(205412);
            return;
            k = n;
            break label308;
            break label362;
            localObject = paramn;
          }
        }
      }
    }
  }
  
  public static final void b(Spannable paramSpannable, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205433);
    s.u(paramSpannable, "$this$setColor");
    z.a locala = z.awK;
    if (paramLong != z.sw()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        a(paramSpannable, new ForegroundColorSpan(ab.ai(paramLong)), paramInt1, paramInt2);
      }
      AppMethodBeat.o(205433);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.q<n, Integer, Integer, ah>
  {
    a(Spannable paramSpannable, androidx.compose.ui.m.e.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.e.a.d
 * JD-Core Version:    0.7.0.1
 */