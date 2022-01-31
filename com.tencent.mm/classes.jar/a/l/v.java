package a.l;

import a.i.b.a;
import a.i.d;
import a.k.h;
import a.k.i;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, eaR=1)
public class v
  extends u
{
  public static final int a(CharSequence paramCharSequence, char paramChar, int paramInt)
  {
    AppMethodBeat.i(56324);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    if (!(paramCharSequence instanceof String))
    {
      char[] arrayOfChar = new char[1];
      arrayOfChar[0] = paramChar;
      a.f.b.j.q(paramCharSequence, "receiver$0");
      a.f.b.j.q(arrayOfChar, "chars");
      int i;
      if ((paramCharSequence instanceof String))
      {
        i = a.a.e.b(arrayOfChar);
        paramInt = ((String)paramCharSequence).indexOf(i, paramInt);
        AppMethodBeat.o(56324);
        return paramInt;
      }
      paramInt = a.i.e.iE(paramInt, 0);
      int j = m.ar(paramCharSequence);
      if (paramInt <= j) {
        for (;;)
        {
          paramChar = paramCharSequence.charAt(paramInt);
          i = 0;
          if (i <= 0) {
            if (!a.a(arrayOfChar[i], paramChar, false)) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label140;
            }
            AppMethodBeat.o(56324);
            return paramInt;
            i += 1;
            break;
          }
          label140:
          if (paramInt == j) {
            break;
          }
          paramInt += 1;
        }
      }
      AppMethodBeat.o(56324);
      return -1;
    }
    paramInt = ((String)paramCharSequence).indexOf(paramChar, paramInt);
    AppMethodBeat.o(56324);
    return paramInt;
  }
  
  private static final int a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(56322);
    Object localObject;
    if (!paramBoolean2)
    {
      localObject = (a.i.b)new d(a.i.e.iE(paramInt1, 0), a.i.e.iF(paramInt2, paramCharSequence1.length()));
      if ((!(paramCharSequence1 instanceof String)) || (!(paramCharSequence2 instanceof String))) {
        break label162;
      }
      paramInt1 = ((a.i.b)localObject).BNv;
      paramInt2 = ((a.i.b)localObject).BNw;
      i = ((a.i.b)localObject).hAu;
      if (i <= 0) {
        break label141;
      }
      if (paramInt1 > paramInt2) {
        break label236;
      }
    }
    for (;;)
    {
      if (m.a((String)paramCharSequence2, (String)paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1))
      {
        AppMethodBeat.o(56322);
        return paramInt1;
        paramInt1 = a.i.e.iF(paramInt1, m.ar(paramCharSequence1));
        paramInt2 = a.i.e.iE(paramInt2, 0);
        localObject = a.i.b.BNx;
        localObject = b.a.aO(paramInt1, paramInt2, -1);
        break;
        label141:
        if (paramInt1 < paramInt2) {
          break label236;
        }
        continue;
      }
      if (paramInt1 == paramInt2) {
        break label236;
      }
      paramInt1 += i;
    }
    label162:
    paramInt1 = ((a.i.b)localObject).BNv;
    paramInt2 = ((a.i.b)localObject).BNw;
    int i = ((a.i.b)localObject).hAu;
    if (i > 0)
    {
      if (paramInt1 > paramInt2) {}
    }
    else {
      for (;;)
      {
        if (m.a(paramCharSequence2, paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1))
        {
          AppMethodBeat.o(56322);
          return paramInt1;
          if (paramInt1 < paramInt2) {
            break;
          }
        }
        else
        {
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += i;
        }
      }
    }
    label236:
    AppMethodBeat.o(56322);
    return -1;
  }
  
  public static final int a(CharSequence paramCharSequence, String paramString, int paramInt)
  {
    AppMethodBeat.i(56330);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    a.f.b.j.q(paramString, "string");
    if (!(paramCharSequence instanceof String))
    {
      paramInt = a(paramCharSequence, (CharSequence)paramString, paramInt, 0, false, true);
      AppMethodBeat.o(56330);
      return paramInt;
    }
    paramInt = ((String)paramCharSequence).lastIndexOf(paramString, paramInt);
    AppMethodBeat.o(56330);
    return paramInt;
  }
  
  public static final int a(CharSequence paramCharSequence, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(56326);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    a.f.b.j.q(paramString, "string");
    if ((paramBoolean) || (!(paramCharSequence instanceof String)))
    {
      paramInt = b(paramCharSequence, (CharSequence)paramString, paramInt, paramCharSequence.length(), paramBoolean);
      AppMethodBeat.o(56326);
      return paramInt;
    }
    paramInt = ((String)paramCharSequence).indexOf(paramString, paramInt);
    AppMethodBeat.o(56326);
    return paramInt;
  }
  
  public static final String a(CharSequence paramCharSequence, d paramd)
  {
    AppMethodBeat.i(56309);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    a.f.b.j.q(paramd, "range");
    paramCharSequence = paramCharSequence.subSequence(paramd.BNv, paramd.BNw + 1).toString();
    AppMethodBeat.o(56309);
    return paramCharSequence;
  }
  
  public static final String a(String paramString1, char paramChar, String paramString2)
  {
    AppMethodBeat.i(56316);
    a.f.b.j.q(paramString1, "receiver$0");
    a.f.b.j.q(paramString2, "missingDelimiterValue");
    int i = m.a((CharSequence)paramString1, paramChar);
    if (i == -1)
    {
      AppMethodBeat.o(56316);
      return paramString2;
    }
    paramString1 = paramString1.substring(i + 1, paramString1.length());
    a.f.b.j.p(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(56316);
    return paramString1;
  }
  
  public static final List<String> a(CharSequence paramCharSequence, String[] paramArrayOfString)
  {
    AppMethodBeat.i(56339);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    a.f.b.j.q(paramArrayOfString, "delimiters");
    if (paramArrayOfString.length == 1)
    {
      localObject = paramArrayOfString[0];
      int i;
      if (((CharSequence)localObject).length() == 0) {
        i = 1;
      }
      while (i == 0)
      {
        int j = m.a(paramCharSequence, (String)localObject, 0, false);
        if (j == -1)
        {
          paramCharSequence = a.a.j.listOf(paramCharSequence.toString());
          AppMethodBeat.o(56339);
          return paramCharSequence;
          i = 0;
        }
        else
        {
          paramArrayOfString = new ArrayList(10);
          i = 0;
          int k;
          int m;
          do
          {
            paramArrayOfString.add(paramCharSequence.subSequence(i, j).toString());
            k = ((String)localObject).length() + j;
            m = m.a(paramCharSequence, (String)localObject, k, false);
            j = m;
            i = k;
          } while (m != -1);
          paramArrayOfString.add(paramCharSequence.subSequence(k, paramCharSequence.length()).toString());
          paramCharSequence = (List)paramArrayOfString;
          AppMethodBeat.o(56339);
          return paramCharSequence;
        }
      }
    }
    Object localObject = i.f(a(paramCharSequence, paramArrayOfString, false));
    paramArrayOfString = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfString.add(m.a(paramCharSequence, (d)((Iterator)localObject).next()));
    }
    paramCharSequence = (List)paramArrayOfString;
    AppMethodBeat.o(56339);
    return paramCharSequence;
  }
  
  public static final boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(56319);
    a.f.b.j.q(paramCharSequence1, "receiver$0");
    a.f.b.j.q(paramCharSequence2, "other");
    if ((paramInt1 < 0) || (paramCharSequence1.length() - paramInt2 < 0) || (paramInt1 > paramCharSequence2.length() - paramInt2))
    {
      AppMethodBeat.o(56319);
      return false;
    }
    int i = 0;
    while (i < paramInt2)
    {
      if (!a.a(paramCharSequence1.charAt(i + 0), paramCharSequence2.charAt(paramInt1 + i), paramBoolean))
      {
        AppMethodBeat.o(56319);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(56319);
    return true;
  }
  
  public static final boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    AppMethodBeat.i(56332);
    a.f.b.j.q(paramCharSequence1, "receiver$0");
    a.f.b.j.q(paramCharSequence2, "other");
    if ((paramCharSequence2 instanceof String))
    {
      if (m.a(paramCharSequence1, (String)paramCharSequence2, 0, paramBoolean, 2) >= 0)
      {
        AppMethodBeat.o(56332);
        return true;
      }
      AppMethodBeat.o(56332);
      return false;
    }
    if (b(paramCharSequence1, paramCharSequence2, 0, paramCharSequence1.length(), paramBoolean) >= 0)
    {
      AppMethodBeat.o(56332);
      return true;
    }
    AppMethodBeat.o(56332);
    return false;
  }
  
  public static final String aM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(56311);
    a.f.b.j.q(paramString1, "receiver$0");
    a.f.b.j.q(paramString2, "delimiter");
    a.f.b.j.q(paramString3, "missingDelimiterValue");
    int i = m.a((CharSequence)paramString1, paramString2, 0, false, 6);
    if (i == -1)
    {
      AppMethodBeat.o(56311);
      return paramString3;
    }
    paramString1 = paramString1.substring(0, i);
    a.f.b.j.p(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(56311);
    return paramString1;
  }
  
  public static final String aN(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(56313);
    a.f.b.j.q(paramString1, "receiver$0");
    a.f.b.j.q(paramString2, "delimiter");
    a.f.b.j.q(paramString3, "missingDelimiterValue");
    int i = m.a((CharSequence)paramString1, paramString2, 0, false, 6);
    if (i == -1)
    {
      AppMethodBeat.o(56313);
      return paramString3;
    }
    paramString1 = paramString1.substring(i + paramString2.length(), paramString1.length());
    a.f.b.j.p(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(56313);
    return paramString1;
  }
  
  public static final d aq(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(56307);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    paramCharSequence = new d(0, paramCharSequence.length() - 1);
    AppMethodBeat.o(56307);
    return paramCharSequence;
  }
  
  public static final int ar(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(56308);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    int i = paramCharSequence.length();
    AppMethodBeat.o(56308);
    return i - 1;
  }
  
  public static final boolean as(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(56320);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    if ((paramCharSequence.length() > 0) && (a.a(paramCharSequence.charAt(0), '0', false)))
    {
      AppMethodBeat.o(56320);
      return true;
    }
    AppMethodBeat.o(56320);
    return false;
  }
  
  public static final int b(CharSequence paramCharSequence, char paramChar, int paramInt)
  {
    AppMethodBeat.i(56328);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    if (!(paramCharSequence instanceof String))
    {
      char[] arrayOfChar = new char[1];
      arrayOfChar[0] = paramChar;
      a.f.b.j.q(paramCharSequence, "receiver$0");
      a.f.b.j.q(arrayOfChar, "chars");
      int i;
      if ((paramCharSequence instanceof String))
      {
        i = a.a.e.b(arrayOfChar);
        paramInt = ((String)paramCharSequence).lastIndexOf(i, paramInt);
        AppMethodBeat.o(56328);
        return paramInt;
      }
      paramInt = a.i.e.iF(paramInt, m.ar(paramCharSequence));
      while (paramInt >= 0)
      {
        paramChar = paramCharSequence.charAt(paramInt);
        i = 0;
        if (i <= 0) {
          if (!a.a(arrayOfChar[i], paramChar, false)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label138;
          }
          AppMethodBeat.o(56328);
          return paramInt;
          i += 1;
          break;
        }
        label138:
        paramInt -= 1;
      }
      AppMethodBeat.o(56328);
      return -1;
    }
    paramInt = ((String)paramCharSequence).lastIndexOf(paramChar, paramInt);
    AppMethodBeat.o(56328);
    return paramInt;
  }
  
  public static final h<String> b(CharSequence paramCharSequence, String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(56337);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    a.f.b.j.q(paramArrayOfString, "delimiters");
    paramCharSequence = i.d(a(paramCharSequence, paramArrayOfString, paramBoolean), (a.f.a.b)new v.b(paramCharSequence));
    AppMethodBeat.o(56337);
    return paramCharSequence;
  }
  
  public static final String b(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(56318);
    a.f.b.j.q(paramString, "receiver$0");
    a.f.b.j.q(paramCharSequence, "prefix");
    if (m.c((CharSequence)paramString, paramCharSequence))
    {
      paramString = paramString.substring(paramCharSequence.length());
      a.f.b.j.p(paramString, "(this as java.lang.String).substring(startIndex)");
      AppMethodBeat.o(56318);
      return paramString;
    }
    AppMethodBeat.o(56318);
    return paramString;
  }
  
  public static final boolean b(CharSequence paramCharSequence, char paramChar)
  {
    AppMethodBeat.i(56334);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    if (m.a(paramCharSequence, paramChar, 0, 2) >= 0)
    {
      AppMethodBeat.o(56334);
      return true;
    }
    AppMethodBeat.o(56334);
    return false;
  }
  
  public static final boolean c(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(56321);
    a.f.b.j.q(paramCharSequence1, "receiver$0");
    a.f.b.j.q(paramCharSequence2, "prefix");
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
    {
      bool = m.jw((String)paramCharSequence1, (String)paramCharSequence2);
      AppMethodBeat.o(56321);
      return bool;
    }
    boolean bool = m.a(paramCharSequence1, paramCharSequence2, 0, paramCharSequence2.length(), false);
    AppMethodBeat.o(56321);
    return bool;
  }
  
  public static final String jB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(56315);
    a.f.b.j.q(paramString1, "receiver$0");
    a.f.b.j.q(paramString2, "missingDelimiterValue");
    int i = m.a((CharSequence)paramString1, '/');
    if (i == -1)
    {
      AppMethodBeat.o(56315);
      return paramString2;
    }
    paramString1 = paramString1.substring(0, i);
    a.f.b.j.p(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(56315);
    return paramString1;
  }
  
  public static final String jy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(56310);
    a.f.b.j.q(paramString1, "receiver$0");
    a.f.b.j.q(paramString2, "missingDelimiterValue");
    int i = m.a((CharSequence)paramString1, '<', 0, 6);
    if (i == -1)
    {
      AppMethodBeat.o(56310);
      return paramString2;
    }
    paramString1 = paramString1.substring(0, i);
    a.f.b.j.p(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(56310);
    return paramString1;
  }
  
  public static final CharSequence trim(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(56306);
    a.f.b.j.q(paramCharSequence, "receiver$0");
    int i = paramCharSequence.length() - 1;
    int k = 0;
    int j = 0;
    while (j <= i)
    {
      if (k == 0) {}
      boolean bool;
      for (int m = j;; m = i)
      {
        bool = a.isWhitespace(paramCharSequence.charAt(m));
        if (k != 0) {
          break label77;
        }
        if (bool) {
          break label70;
        }
        k = 1;
        break;
      }
      label70:
      j += 1;
      continue;
      label77:
      if (!bool) {
        break;
      }
      i -= 1;
    }
    paramCharSequence = paramCharSequence.subSequence(j, i + 1);
    AppMethodBeat.o(56306);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.l.v
 * JD-Core Version:    0.7.0.1
 */