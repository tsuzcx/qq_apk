package androidx.camera.camera2.b.a.b;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.b.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class e
  implements r
{
  public static final List<String> FE;
  
  static
  {
    AppMethodBeat.i(197985);
    FE = Arrays.asList(new String[] { "SM-N9200", "SM-N9208", "SAMSUNG-SM-N920A", "SM-N920C", "SM-N920F", "SM-N920G", "SM-N920I", "SM-N920K", "SM-N920L", "SM-N920P", "SM-N920R4", "SM-N920R6", "SM-N920R7", "SM-N920S", "SM-N920T", "SM-N920V", "SM-N920W8", "SM-N920X", "SM-J510FN" });
    AppMethodBeat.o(197985);
  }
  
  static boolean c(h paramh)
  {
    AppMethodBeat.i(197974);
    if (("SAMSUNG".equals(Build.BRAND.toUpperCase(Locale.US))) && (FE.contains(Build.MODEL.toUpperCase(Locale.US))) && (((Integer)paramh.a(CameraCharacteristics.LENS_FACING)).intValue() == 1))
    {
      AppMethodBeat.o(197974);
      return true;
    }
    AppMethodBeat.o(197974);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.e
 * JD-Core Version:    0.7.0.1
 */