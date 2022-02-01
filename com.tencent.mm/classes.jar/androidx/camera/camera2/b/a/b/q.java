package androidx.camera.camera2.b.a.b;

import android.os.Build;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class q
  implements ay
{
  static boolean load()
  {
    AppMethodBeat.i(198020);
    if (("SAMSUNG".equals(Build.MANUFACTURER.toUpperCase(Locale.US))) && (Build.MODEL.toUpperCase(Locale.US).startsWith("SM-A716")))
    {
      AppMethodBeat.o(198020);
      return true;
    }
    AppMethodBeat.o(198020);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.q
 * JD-Core Version:    0.7.0.1
 */