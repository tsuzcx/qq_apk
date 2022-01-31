package a.l;

import a.f.a.m;
import a.i.d;
import a.k.h;
import a.l;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
final class e
  implements h<d>
{
  final CharSequence CGG;
  final m<CharSequence, Integer, o<Integer, Integer>> CGH;
  final int jih;
  final int limit;
  
  public e(CharSequence paramCharSequence, m<? super CharSequence, ? super Integer, o<Integer, Integer>> paramm)
  {
    AppMethodBeat.i(56301);
    this.CGG = paramCharSequence;
    this.jih = 0;
    this.limit = 0;
    this.CGH = paramm;
    AppMethodBeat.o(56301);
  }
  
  public final Iterator<d> iterator()
  {
    AppMethodBeat.i(56300);
    Iterator localIterator = (Iterator)new e.a(this);
    AppMethodBeat.o(56300);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.l.e
 * JD-Core Version:    0.7.0.1
 */