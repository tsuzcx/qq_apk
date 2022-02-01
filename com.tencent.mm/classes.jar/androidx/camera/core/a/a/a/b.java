package androidx.camera.core.a.a.a;

import android.os.Build;
import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.ay;
import androidx.camera.core.impl.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements ay
{
  public static boolean f(ac.a<?> parama)
  {
    return parama != z.LT;
  }
  
  static boolean load()
  {
    AppMethodBeat.i(199158);
    if (("HUAWEI".equalsIgnoreCase(Build.BRAND)) && ("SNE-LX1".equalsIgnoreCase(Build.MODEL)))
    {
      i = 1;
      if (i == 0) {
        if ((!"HONOR".equalsIgnoreCase(Build.BRAND)) || (!"STK-LX1".equalsIgnoreCase(Build.MODEL))) {
          break label73;
        }
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label78;
      }
      AppMethodBeat.o(199158);
      return true;
      i = 0;
      break;
    }
    label78:
    AppMethodBeat.o(199158);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */