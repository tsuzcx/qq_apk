package androidx.compose.ui.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"EmptyAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "AnnotatedString", "text", "", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "buildAnnotatedString", "builder", "Lkotlin/Function1;", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "", "Lkotlin/ExtensionFunctionType;", "contains", "", "baseStart", "", "baseEnd", "targetStart", "targetEnd", "emptyAnnotatedString", "filterRanges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "ranges", "start", "end", "intersect", "lStart", "lEnd", "rStart", "rEnd", "capitalize", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "decapitalize", "getLocalStyles", "mapEachParagraphStyle", "defaultParagraphStyle", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "annotatedString", "normalizedParagraphStyles", "substringWithoutParagraphStyles", "toLowerCase", "toUpperCase", "withAnnotation", "R", "", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/TtsAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tag", "annotation", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withStyle", "style", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/ParagraphStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/SpanStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final a aYH;
  
  static
  {
    AppMethodBeat.i(204965);
    aYH = new a("", null, null, 6);
    AppMethodBeat.o(204965);
  }
  
  private static final List<a.a<n>> a(a parama, int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(204944);
    if (paramInt1 == paramInt2)
    {
      parama = (List)ab.aivy;
      AppMethodBeat.o(204944);
      return parama;
    }
    if ((paramInt1 == 0) && (paramInt2 >= parama.text.length()))
    {
      parama = parama.aYD;
      AppMethodBeat.o(204944);
      return parama;
    }
    parama = parama.aYD;
    ArrayList localArrayList = new ArrayList(parama.size());
    int m = parama.size() - 1;
    if (m >= 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      Object localObject1 = parama.get(i);
      Object localObject2 = (a.a)localObject1;
      if (i(paramInt1, paramInt2, ((a.a)localObject2).start, ((a.a)localObject2).end)) {
        ((Collection)localArrayList).add(localObject1);
      }
      if (k > m)
      {
        parama = (List)localArrayList;
        localArrayList = new ArrayList(parama.size());
        k = parama.size() - 1;
        if (k >= 0) {}
        for (i = j;; i = j)
        {
          j = i + 1;
          localObject2 = parama.get(i);
          localObject1 = (Collection)localArrayList;
          localObject2 = (a.a)localObject2;
          ((Collection)localObject1).add(new a.a(((a.a)localObject2).aYG, k.bQ(((a.a)localObject2).start, paramInt1, paramInt2) - paramInt1, k.bQ(((a.a)localObject2).end, paramInt1, paramInt2) - paramInt1));
          if (j > k)
          {
            parama = (List)localArrayList;
            AppMethodBeat.o(204944);
            return parama;
          }
        }
      }
    }
  }
  
  public static final List<a.a<l>> a(a parama, l paraml)
  {
    AppMethodBeat.i(204941);
    s.u(parama, "<this>");
    s.u(paraml, "defaultParagraphStyle");
    int m = parama.text.length();
    parama = parama.aYE;
    List localList = (List)new ArrayList();
    int n = parama.size() - 1;
    int j;
    int i;
    int k;
    if (n >= 0)
    {
      j = 0;
      i = 0;
      k = j + 1;
      a.a locala = (a.a)parama.get(j);
      l locall = (l)locala.aYG;
      int i1 = locala.start;
      j = locala.end;
      if (i1 != i) {
        localList.add(new a.a(paraml, i, i1));
      }
      localList.add(new a.a(paraml.a(locall), i1, j));
      if (k <= n) {}
    }
    for (;;)
    {
      if (j != m) {
        localList.add(new a.a(paraml, j, m));
      }
      if (localList.isEmpty()) {
        localList.add(new a.a(paraml, 0, 0));
      }
      AppMethodBeat.o(204941);
      return localList;
      i = k;
      k = j;
      j = i;
      i = k;
      break;
      j = 0;
    }
  }
  
  private static boolean h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= paramInt3) && (paramInt4 <= paramInt2))
    {
      if (paramInt2 == paramInt4)
      {
        if (paramInt3 != paramInt4) {
          break label36;
        }
        paramInt3 = 1;
        if (paramInt1 != paramInt2) {
          break label41;
        }
      }
      label36:
      label41:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt3 != paramInt1) {
          break label46;
        }
        return true;
        paramInt3 = 0;
        break;
      }
    }
    label46:
    return false;
  }
  
  public static final boolean i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204951);
    if ((Math.max(paramInt1, paramInt3) < Math.min(paramInt2, paramInt4)) || (h(paramInt1, paramInt2, paramInt3, paramInt4)) || (h(paramInt3, paramInt4, paramInt1, paramInt2)))
    {
      AppMethodBeat.o(204951);
      return true;
    }
    AppMethodBeat.o(204951);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.b
 * JD-Core Version:    0.7.0.1
 */