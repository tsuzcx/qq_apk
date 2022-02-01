package androidx.camera.camera2.b.a.b;

import android.os.Build;
import android.os.Build.VERSION;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public class k
  implements ay
{
  public static final List<String> FK;
  
  static
  {
    AppMethodBeat.i(198013);
    FK = Arrays.asList(new String[] { "Pixel 2", "Pixel 2 XL", "Pixel 3", "Pixel 3 XL" });
    AppMethodBeat.o(198013);
  }
  
  static boolean load()
  {
    AppMethodBeat.i(198005);
    if ((FK.contains(Build.MODEL)) && ("Google".equals(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 26))
    {
      AppMethodBeat.o(198005);
      return true;
    }
    AppMethodBeat.o(198005);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.k
 * JD-Core Version:    0.7.0.1
 */