package a.l;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "kotlin.jvm.PlatformType", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"})
public final class j
  implements i
{
  private final CharSequence CGG;
  final MatchResult CGO;
  private final g CGP;
  private List<String> CGQ;
  private final Matcher CGR;
  
  public j(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(56293);
    this.CGR = paramMatcher;
    this.CGG = paramCharSequence;
    this.CGO = this.CGR.toMatchResult();
    this.CGP = ((g)new j.b(this));
    AppMethodBeat.o(56293);
  }
  
  public final List<String> epk()
  {
    AppMethodBeat.i(56292);
    if (this.CGQ == null) {
      this.CGQ = ((List)new j.a(this));
    }
    List localList = this.CGQ;
    if (localList == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(56292);
    return localList;
  }
  
  public final i.a epl()
  {
    AppMethodBeat.i(56294);
    i.a locala = new i.a(this);
    AppMethodBeat.o(56294);
    return locala;
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(56291);
    String str = this.CGO.group();
    a.f.b.j.p(str, "matchResult.group()");
    AppMethodBeat.o(56291);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.l.j
 * JD-Core Version:    0.7.0.1
 */