package a.l;

import a.a.ab;
import a.f.b.j;
import a.k.i;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "contentEquals", "charSequence", "", "decapitalize", "endsWith", "suffix", "equals", "format", "locale", "Ljava/util/Locale;", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "startIndex", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "kotlin-stdlib"}, eaR=1)
public class u
  extends t
{
  public static final boolean I(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(56352);
    if (paramString1 == null)
    {
      if (paramString2 == null)
      {
        AppMethodBeat.o(56352);
        return true;
      }
      AppMethodBeat.o(56352);
      return false;
    }
    if (!paramBoolean)
    {
      paramBoolean = paramString1.equals(paramString2);
      AppMethodBeat.o(56352);
      return paramBoolean;
    }
    paramBoolean = paramString1.equalsIgnoreCase(paramString2);
    AppMethodBeat.o(56352);
    return paramBoolean;
  }
  
  public static final String a(String paramString, char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(56353);
    j.q(paramString, "receiver$0");
    paramString = paramString.replace(paramChar1, paramChar2);
    j.p(paramString, "(this as java.lang.Strin…replace(oldChar, newChar)");
    AppMethodBeat.o(56353);
    return paramString;
  }
  
  public static final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(56359);
    j.q(paramString1, "receiver$0");
    j.q(paramString2, "other");
    if (!paramBoolean)
    {
      paramBoolean = paramString1.regionMatches(0, paramString2, paramInt1, paramInt2);
      AppMethodBeat.o(56359);
      return paramBoolean;
    }
    paramBoolean = paramString1.regionMatches(paramBoolean, 0, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(56359);
    return paramBoolean;
  }
  
  public static final String aL(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(56355);
    j.q(paramString1, "receiver$0");
    j.q(paramString2, "oldValue");
    j.q(paramString3, "newValue");
    int i = m.a((CharSequence)paramString1, paramString2, 0, false, 2);
    if (i < 0)
    {
      AppMethodBeat.o(56355);
      return paramString1;
    }
    int j = i + paramString2.length();
    paramString1 = (CharSequence)paramString1;
    paramString2 = (CharSequence)paramString3;
    j.q(paramString1, "receiver$0");
    j.q(paramString2, "replacement");
    if (j < i)
    {
      paramString1 = (Throwable)new IndexOutOfBoundsException("End index (" + j + ") is less than start index (" + i + ").");
      AppMethodBeat.o(56355);
      throw paramString1;
    }
    paramString3 = new StringBuilder();
    paramString3.append(paramString1, 0, i);
    paramString3.append(paramString2);
    paramString3.append(paramString1, j, paramString1.length());
    paramString1 = ((CharSequence)paramString3).toString();
    AppMethodBeat.o(56355);
    return paramString1;
  }
  
  public static final boolean ap(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(56358);
    j.q(paramCharSequence, "receiver$0");
    if (paramCharSequence.length() != 0)
    {
      Iterator localIterator = ((Iterable)m.aq(paramCharSequence)).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (a.isWhitespace(paramCharSequence.charAt(((ab)localIterator).nextInt())));
    }
    for (int i = 0; i != 0; i = 1)
    {
      AppMethodBeat.o(56358);
      return true;
    }
    AppMethodBeat.o(56358);
    return false;
  }
  
  public static final String capitalize(String paramString)
  {
    AppMethodBeat.i(56360);
    j.q(paramString, "receiver$0");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while ((i != 0) && (Character.isLowerCase(paramString.charAt(0))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString.substring(0, 1);
      j.p(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (str == null)
      {
        paramString = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(56360);
        throw paramString;
        i = 0;
      }
      else
      {
        str = str.toUpperCase();
        j.p(str, "(this as java.lang.String).toUpperCase()");
        localStringBuilder = localStringBuilder.append(str);
        paramString = paramString.substring(1);
        j.p(paramString, "(this as java.lang.String).substring(startIndex)");
        paramString = paramString;
        AppMethodBeat.o(56360);
        return paramString;
      }
    }
    AppMethodBeat.o(56360);
    return paramString;
  }
  
  public static final String h(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(56354);
    j.q(paramString1, "receiver$0");
    j.q(paramString2, "oldValue");
    j.q(paramString3, "newValue");
    paramString1 = i.a(m.a((CharSequence)paramString1, new String[] { paramString2 }, paramBoolean, 4), (CharSequence)paramString3);
    AppMethodBeat.o(56354);
    return paramString1;
  }
  
  public static final boolean jw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(56356);
    j.q(paramString1, "receiver$0");
    j.q(paramString2, "prefix");
    boolean bool = paramString1.startsWith(paramString2);
    AppMethodBeat.o(56356);
    return bool;
  }
  
  public static final boolean jx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(56357);
    j.q(paramString1, "receiver$0");
    j.q(paramString2, "suffix");
    boolean bool = paramString1.endsWith(paramString2);
    AppMethodBeat.o(56357);
    return bool;
  }
  
  public static final String t(CharSequence paramCharSequence, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(56361);
    j.q(paramCharSequence, "receiver$0");
    if (paramInt >= 0) {}
    for (int j = 1; j == 0; j = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException(("Count 'n' must be non-negative, but was " + paramInt + '.').toString());
      AppMethodBeat.o(56361);
      throw paramCharSequence;
    }
    StringBuilder localStringBuilder;
    switch (paramInt)
    {
    default: 
      switch (paramCharSequence.length())
      {
      default: 
        localStringBuilder = new StringBuilder(paramCharSequence.length() * paramInt);
        if (paramInt > 0)
        {
          j = k;
          for (;;)
          {
            localStringBuilder.append(paramCharSequence);
            if (j == paramInt) {
              break;
            }
            j += 1;
          }
        }
        break;
      }
    case 0: 
      AppMethodBeat.o(56361);
      return "";
    case 1: 
      paramCharSequence = paramCharSequence.toString();
      AppMethodBeat.o(56361);
      return paramCharSequence;
      AppMethodBeat.o(56361);
      return "";
      int i = paramCharSequence.charAt(0);
      paramCharSequence = new char[paramInt];
      j = paramCharSequence.length;
      paramInt = 0;
      while (paramInt < j)
      {
        paramCharSequence[paramInt] = i;
        paramInt += 1;
      }
      paramCharSequence = new String(paramCharSequence);
      AppMethodBeat.o(56361);
      return paramCharSequence;
    }
    paramCharSequence = localStringBuilder.toString();
    j.p(paramCharSequence, "sb.toString()");
    AppMethodBeat.o(56361);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.l.u
 * JD-Core Version:    0.7.0.1
 */