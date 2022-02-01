package androidx.camera.camera2.b.a.b;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.b.a.h;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class c
  implements ay
{
  private static final List<String> FE;
  
  static
  {
    AppMethodBeat.i(197984);
    FE = Arrays.asList(new String[] { "PIXEL 3A", "PIXEL 3A XL" });
    AppMethodBeat.o(197984);
  }
  
  static boolean c(h paramh)
  {
    AppMethodBeat.i(197972);
    if ((FE.contains(Build.MODEL.toUpperCase(Locale.US))) && (((Integer)paramh.a(CameraCharacteristics.LENS_FACING)).intValue() == 1))
    {
      AppMethodBeat.o(197972);
      return true;
    }
    AppMethodBeat.o(197972);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */