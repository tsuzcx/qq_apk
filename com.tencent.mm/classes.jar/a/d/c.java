package a.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"})
public final class c
{
  public static final int aN(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(56012);
    paramInt1 = iC(iC(paramInt1, paramInt3) - iC(paramInt2, paramInt3), paramInt3);
    AppMethodBeat.o(56012);
    return paramInt1;
  }
  
  private static final int iC(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.d.c
 * JD-Core Version:    0.7.0.1
 */