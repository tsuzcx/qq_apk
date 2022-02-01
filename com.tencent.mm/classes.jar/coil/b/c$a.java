package coil.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/bitmap/BitmapPoolStrategy$Companion;", "", "()V", "invoke", "Lcoil/bitmap/BitmapPoolStrategy;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
{
  static
  {
    AppMethodBeat.i(188164);
    clI = new a();
    AppMethodBeat.o(188164);
  }
  
  public static c MF()
  {
    AppMethodBeat.i(188158);
    if (Build.VERSION.SDK_INT >= 19)
    {
      localc = (c)new i();
      AppMethodBeat.o(188158);
      return localc;
    }
    c localc = (c)new a();
    AppMethodBeat.o(188158);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.b.c.a
 * JD-Core Version:    0.7.0.1
 */