package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraCharacteristics.Key;
import com.tencent.matrix.trace.core.AppMethodBeat;

class g
  implements h.a
{
  protected final CameraCharacteristics Fb;
  
  g(CameraCharacteristics paramCameraCharacteristics)
  {
    this.Fb = paramCameraCharacteristics;
  }
  
  public final <T> T a(CameraCharacteristics.Key<T> paramKey)
  {
    AppMethodBeat.i(198052);
    paramKey = this.Fb.get(paramKey);
    AppMethodBeat.o(198052);
    return paramKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.g
 * JD-Core Version:    0.7.0.1
 */