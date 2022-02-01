package androidx.camera.extensions.a.a.a;

import android.os.Build;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  implements ay
{
  static boolean load()
  {
    AppMethodBeat.i(198216);
    if (("google".equalsIgnoreCase(Build.BRAND)) && ("redfin".equalsIgnoreCase(Build.DEVICE)))
    {
      AppMethodBeat.o(198216);
      return true;
    }
    AppMethodBeat.o(198216);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.extensions.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */