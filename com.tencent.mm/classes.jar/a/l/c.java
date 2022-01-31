package a.l;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"equals", "", "", "other", "ignoreCase", "isSurrogate", "plus", "", "kotlin-stdlib"}, eaR=1)
public class c
  extends b
{
  public static final boolean a(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    AppMethodBeat.i(56297);
    if (paramChar1 == paramChar2)
    {
      AppMethodBeat.o(56297);
      return true;
    }
    if (!paramBoolean)
    {
      AppMethodBeat.o(56297);
      return false;
    }
    if (Character.toUpperCase(paramChar1) == Character.toUpperCase(paramChar2))
    {
      AppMethodBeat.o(56297);
      return true;
    }
    if (Character.toLowerCase(paramChar1) == Character.toLowerCase(paramChar2))
    {
      AppMethodBeat.o(56297);
      return true;
    }
    AppMethodBeat.o(56297);
    return false;
  }
  
  public static final boolean isSurrogate(char paramChar)
  {
    if (55296 > paramChar) {}
    while (57343 < paramChar) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.l.c
 * JD-Core Version:    0.7.0.1
 */