package androidx.core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class f
{
  public static int b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(196118);
    if (paramInt1 < paramInt2)
    {
      paramString = new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      AppMethodBeat.o(196118);
      throw paramString;
    }
    if (paramInt1 > paramInt3)
    {
      paramString = new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      AppMethodBeat.o(196118);
      throw paramString;
    }
    AppMethodBeat.o(196118);
    return paramInt1;
  }
  
  public static void b(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(196081);
    if (!paramBoolean)
    {
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(196081);
      throw paramString;
    }
    AppMethodBeat.o(196081);
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(196027);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(196027);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(196027);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(196040);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(196040);
      throw paramObject;
    }
    AppMethodBeat.o(196040);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(196051);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(196051);
      throw paramT;
    }
    AppMethodBeat.o(196051);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(196063);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(196063);
      throw paramT;
    }
    AppMethodBeat.o(196063);
    return paramT;
  }
  
  public static int el(int paramInt)
  {
    AppMethodBeat.i(196097);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(196097);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(196097);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.f.f
 * JD-Core Version:    0.7.0.1
 */