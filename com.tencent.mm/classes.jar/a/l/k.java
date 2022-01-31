package a.l;

import a.i.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"})
public final class k
  implements Serializable
{
  public static final k.a CGV;
  public final Pattern CGU;
  
  static
  {
    AppMethodBeat.i(56277);
    CGV = new k.a((byte)0);
    AppMethodBeat.o(56277);
  }
  
  public k(String paramString)
  {
    this(paramString);
    AppMethodBeat.i(56276);
    AppMethodBeat.o(56276);
  }
  
  public k(Pattern paramPattern)
  {
    AppMethodBeat.i(56275);
    this.CGU = paramPattern;
    AppMethodBeat.o(56275);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(56274);
    Object localObject = this.CGU.pattern();
    a.f.b.j.p(localObject, "nativePattern.pattern()");
    localObject = new k.b((String)localObject, this.CGU.flags());
    AppMethodBeat.o(56274);
    return localObject;
  }
  
  public final boolean ao(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(56269);
    a.f.b.j.q(paramCharSequence, "input");
    boolean bool = this.CGU.matcher(paramCharSequence).matches();
    AppMethodBeat.o(56269);
    return bool;
  }
  
  public final String c(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(56271);
    a.f.b.j.q(paramCharSequence, "input");
    a.f.b.j.q(paramString, "replacement");
    paramCharSequence = this.CGU.matcher(paramCharSequence).replaceFirst(paramString);
    a.f.b.j.p(paramCharSequence, "nativePattern.matcher(in…replaceFirst(replacement)");
    AppMethodBeat.o(56271);
    return paramCharSequence;
  }
  
  public final List<String> s(CharSequence paramCharSequence, int paramInt)
  {
    int j = 10;
    AppMethodBeat.i(56272);
    a.f.b.j.q(paramCharSequence, "input");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException(("Limit must be non-negative, but was " + paramInt + '.').toString());
      AppMethodBeat.o(56272);
      throw paramCharSequence;
    }
    Matcher localMatcher = this.CGU.matcher(paramCharSequence);
    if ((!localMatcher.find()) || (paramInt == 1))
    {
      paramCharSequence = a.a.j.listOf(paramCharSequence.toString());
      AppMethodBeat.o(56272);
      return paramCharSequence;
    }
    i = j;
    if (paramInt > 0) {
      i = e.iF(paramInt, 10);
    }
    ArrayList localArrayList = new ArrayList(i);
    j = paramInt - 1;
    paramInt = 0;
    do
    {
      localArrayList.add(paramCharSequence.subSequence(paramInt, localMatcher.start()).toString());
      i = localMatcher.end();
      if ((j >= 0) && (localArrayList.size() == j)) {
        break;
      }
      paramInt = i;
    } while (localMatcher.find());
    localArrayList.add(paramCharSequence.subSequence(i, paramCharSequence.length()).toString());
    paramCharSequence = (List)localArrayList;
    AppMethodBeat.o(56272);
    return paramCharSequence;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56273);
    String str = this.CGU.toString();
    a.f.b.j.p(str, "nativePattern.toString()");
    AppMethodBeat.o(56273);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.l.k
 * JD-Core Version:    0.7.0.1
 */