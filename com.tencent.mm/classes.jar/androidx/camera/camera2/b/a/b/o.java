package androidx.camera.camera2.b.a.b;

import android.os.Build;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class o
  implements ay
{
  private static final List<String> FN;
  
  static
  {
    AppMethodBeat.i(198002);
    FN = Arrays.asList(new String[] { "sunfish", "bramble", "redfin", "barbet" });
    AppMethodBeat.o(198002);
  }
  
  static boolean load()
  {
    AppMethodBeat.i(197993);
    if (("Google".equals(Build.MANUFACTURER)) && (FN.contains(Build.DEVICE.toLowerCase(Locale.getDefault()))))
    {
      AppMethodBeat.o(197993);
      return true;
    }
    AppMethodBeat.o(197993);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.o
 * JD-Core Version:    0.7.0.1
 */