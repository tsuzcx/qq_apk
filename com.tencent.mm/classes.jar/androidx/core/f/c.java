package androidx.core.f;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Objects;

public final class c
{
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(196002);
    if (Build.VERSION.SDK_INT >= 19)
    {
      boolean bool = Objects.equals(paramObject1, paramObject2);
      AppMethodBeat.o(196002);
      return bool;
    }
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(196002);
      return true;
    }
    AppMethodBeat.o(196002);
    return false;
  }
  
  public static int hash(Object... paramVarArgs)
  {
    AppMethodBeat.i(196011);
    if (Build.VERSION.SDK_INT >= 19)
    {
      i = Objects.hash(paramVarArgs);
      AppMethodBeat.o(196011);
      return i;
    }
    int i = Arrays.hashCode(paramVarArgs);
    AppMethodBeat.o(196011);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.f.c
 * JD-Core Version:    0.7.0.1
 */