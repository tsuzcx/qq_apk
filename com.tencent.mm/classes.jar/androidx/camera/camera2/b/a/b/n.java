package androidx.camera.camera2.b.a.b;

import android.os.Build;
import android.os.Build.VERSION;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class n
  implements ay
{
  private static final List<String> FM;
  
  static
  {
    AppMethodBeat.i(198015);
    FM = Arrays.asList(new String[] { "NEXUS 4" });
    AppMethodBeat.o(198015);
  }
  
  public static int jdMethod_if()
  {
    return 2;
  }
  
  static boolean load()
  {
    AppMethodBeat.i(197999);
    if (("GOOGLE".equalsIgnoreCase(Build.BRAND)) && (Build.VERSION.SDK_INT < 23) && (FM.contains(Build.MODEL.toUpperCase(Locale.US))))
    {
      AppMethodBeat.o(197999);
      return true;
    }
    AppMethodBeat.o(197999);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.n
 * JD-Core Version:    0.7.0.1
 */