package androidx.camera.camera2.b.a.b;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.b.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class l
  implements r
{
  public static final List<String> FK;
  
  static
  {
    AppMethodBeat.i(198025);
    FK = Arrays.asList(new String[] { "SM-G9300", "SM-G930R", "SM-G930A", "SM-G930V", "SM-G930T", "SM-G930U", "SM-G930P", "SM-SC02H", "SM-SCV33", "SM-G9350", "SM-G935R", "SM-G935A", "SM-G935V", "SM-G935T", "SM-G935U", "SM-G935P" });
    AppMethodBeat.o(198025);
  }
  
  static boolean c(h paramh)
  {
    AppMethodBeat.i(198010);
    if (("SAMSUNG".equals(Build.BRAND.toUpperCase(Locale.US))) && (FK.contains(Build.MODEL.toUpperCase(Locale.US))) && (((Integer)paramh.a(CameraCharacteristics.LENS_FACING)).intValue() == 1))
    {
      AppMethodBeat.o(198010);
      return true;
    }
    AppMethodBeat.o(198010);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.l
 * JD-Core Version:    0.7.0.1
 */