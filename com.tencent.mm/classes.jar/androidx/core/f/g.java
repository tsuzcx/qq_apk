package androidx.core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public static int bv(int paramInt)
  {
    AppMethodBeat.i(251353);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(251353);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(251353);
    return paramInt;
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(251350);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(251350);
      throw paramT;
    }
    AppMethodBeat.o(251350);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(251352);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(251352);
      throw paramT;
    }
    AppMethodBeat.o(251352);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.f.g
 * JD-Core Version:    0.7.0.1
 */