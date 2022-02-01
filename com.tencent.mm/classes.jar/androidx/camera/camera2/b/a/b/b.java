package androidx.camera.camera2.b.a.b;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build.VERSION;
import androidx.camera.camera2.b.a.h;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  implements ay
{
  static boolean c(h paramh)
  {
    AppMethodBeat.i(197956);
    paramh = (Integer)paramh.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    if ((paramh != null) && (paramh.intValue() == 2) && (Build.VERSION.SDK_INT == 21))
    {
      AppMethodBeat.o(197956);
      return true;
    }
    AppMethodBeat.o(197956);
    return false;
  }
  
  public static int jdMethod_if()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */