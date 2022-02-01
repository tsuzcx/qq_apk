package androidx.camera.camera2.b.a.b;

import android.os.Build;
import androidx.camera.core.a.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  implements c
{
  static boolean il()
  {
    AppMethodBeat.i(198011);
    if (("motorola".equalsIgnoreCase(Build.BRAND)) && ("MotoG3".equalsIgnoreCase(Build.MODEL)))
    {
      i = 1;
      if (i == 0)
      {
        if ((!"samsung".equalsIgnoreCase(Build.BRAND)) || (!"SM-G532F".equalsIgnoreCase(Build.MODEL))) {
          break label101;
        }
        i = 1;
        label57:
        if (i == 0) {
          if ((!"samsung".equalsIgnoreCase(Build.BRAND)) || (!"SM-J700F".equalsIgnoreCase(Build.MODEL))) {
            break label106;
          }
        }
      }
    }
    label101:
    label106:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label111;
      }
      AppMethodBeat.o(198011);
      return true;
      i = 0;
      break;
      i = 0;
      break label57;
    }
    label111:
    AppMethodBeat.o(198011);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.s
 * JD-Core Version:    0.7.0.1
 */