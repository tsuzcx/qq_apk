package a.l;

import a.f.a.b;
import a.i.e;
import a.k.i;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, eaR=1)
public class n
{
  private static final int azr(String paramString)
  {
    AppMethodBeat.i(56296);
    CharSequence localCharSequence = (CharSequence)paramString;
    int k = localCharSequence.length();
    int i = 0;
    int j;
    if (i < k) {
      if (!a.isWhitespace(localCharSequence.charAt(i)))
      {
        j = 1;
        label42:
        if (j == 0) {
          break label68;
        }
      }
    }
    for (;;)
    {
      if (i != -1) {
        break label80;
      }
      i = paramString.length();
      AppMethodBeat.o(56296);
      return i;
      j = 0;
      break label42;
      label68:
      i += 1;
      break;
      i = -1;
    }
    label80:
    AppMethodBeat.o(56296);
    return i;
  }
  
  public static final String jv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(56295);
    a.f.b.j.q(paramString1, "receiver$0");
    a.f.b.j.q(paramString2, "newIndent");
    Object localObject1 = (CharSequence)paramString1;
    a.f.b.j.q(localObject1, "receiver$0");
    a.f.b.j.q(localObject1, "receiver$0");
    localObject1 = i.c(m.a((CharSequence)localObject1, new String[] { "\r\n", "\n", "\r" }, false, 6));
    Object localObject3 = (Iterable)localObject1;
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    int i;
    label152:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if (!m.ap((CharSequence)localObject4)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label152;
        }
        ((Collection)localObject2).add(localObject4);
        break;
      }
    }
    localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Integer.valueOf(azr((String)((Iterator)localObject3).next())));
    }
    localObject2 = (Integer)a.a.j.s((Iterable)localObject2);
    int j;
    int m;
    int n;
    int i1;
    label289:
    label300:
    int i2;
    if (localObject2 != null)
    {
      j = ((Integer)localObject2).intValue();
      m = paramString1.length();
      n = paramString2.length();
      i1 = ((List)localObject1).size();
      if (((CharSequence)paramString2).length() != 0) {
        break label418;
      }
      i = 1;
      if (i == 0) {
        break label423;
      }
      paramString2 = (b)n.a.CGZ;
      i2 = a.a.j.fO((List)localObject1);
      paramString1 = (Iterable)localObject1;
      localObject3 = (Collection)new ArrayList();
      localObject4 = paramString1.iterator();
      i = 0;
    }
    for (;;)
    {
      label335:
      if (!((Iterator)localObject4).hasNext()) {
        break label559;
      }
      paramString1 = ((Iterator)localObject4).next();
      int k = i + 1;
      if (i < 0) {
        a.a.j.eaS();
      }
      localObject1 = (String)paramString1;
      if (((i == 0) || (i == i2)) && (m.ap((CharSequence)localObject1))) {
        paramString1 = null;
      }
      for (;;)
      {
        if (paramString1 == null) {
          break label553;
        }
        ((Collection)localObject3).add(paramString1);
        i = k;
        break label335;
        j = 0;
        break;
        label418:
        i = 0;
        break label289;
        label423:
        paramString2 = (b)new n.b(paramString2);
        break label300;
        a.f.b.j.q(localObject1, "receiver$0");
        if (j >= 0) {}
        for (i = 1; i == 0; i = 0)
        {
          paramString1 = (Throwable)new IllegalArgumentException(("Requested character count " + j + " is less than zero.").toString());
          AppMethodBeat.o(56295);
          throw paramString1;
        }
        paramString1 = ((String)localObject1).substring(e.iF(j, ((String)localObject1).length()));
        a.f.b.j.p(paramString1, "(this as java.lang.String).substring(startIndex)");
        if (paramString1 != null)
        {
          localObject2 = (String)paramString2.S(paramString1);
          paramString1 = (String)localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          paramString1 = (String)localObject1;
        }
      }
      label553:
      i = k;
    }
    label559:
    paramString1 = ((StringBuilder)a.a.j.a((Iterable)localObject3, (Appendable)new StringBuilder(m + n * i1), (CharSequence)"\n", null, null, 0, null, null, 124)).toString();
    a.f.b.j.p(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
    AppMethodBeat.o(56295);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.l.n
 * JD-Core Version:    0.7.0.1
 */