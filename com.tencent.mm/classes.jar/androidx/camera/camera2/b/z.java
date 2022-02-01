package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class z
{
  static void a(h paramh, List<CameraCaptureSession.CaptureCallback> paramList)
  {
    AppMethodBeat.i(197894);
    if ((paramh instanceof i.a))
    {
      AppMethodBeat.o(197894);
      throw null;
    }
    if ((paramh instanceof y))
    {
      paramList.add(((y)paramh).Cd);
      AppMethodBeat.o(197894);
      return;
    }
    paramList.add(new x(paramh));
    AppMethodBeat.o(197894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.z
 * JD-Core Version:    0.7.0.1
 */