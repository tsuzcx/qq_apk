package androidx.core.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah$m
{
  static int es(int paramInt)
  {
    AppMethodBeat.i(195846);
    switch (paramInt)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(195846);
      throw localIllegalArgumentException;
    case 1: 
      AppMethodBeat.o(195846);
      return 0;
    case 2: 
      AppMethodBeat.o(195846);
      return 1;
    case 4: 
      AppMethodBeat.o(195846);
      return 2;
    case 8: 
      AppMethodBeat.o(195846);
      return 3;
    case 16: 
      AppMethodBeat.o(195846);
      return 4;
    case 32: 
      AppMethodBeat.o(195846);
      return 5;
    case 64: 
      AppMethodBeat.o(195846);
      return 6;
    case 128: 
      AppMethodBeat.o(195846);
      return 7;
    }
    AppMethodBeat.o(195846);
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.core.g.ah.m
 * JD-Core Version:    0.7.0.1
 */