package a.l;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"})
final class y
{
  public static final y CHe;
  public static final String LINE_SEPARATOR;
  
  static
  {
    AppMethodBeat.i(56363);
    CHe = new y();
    String str = System.getProperty("line.separator");
    if (str == null) {
      j.ebi();
    }
    LINE_SEPARATOR = str;
    AppMethodBeat.o(56363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.l.y
 * JD-Core Version:    0.7.0.1
 */