package androidx.camera.camera2.b.a.a;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends d
{
  e(Surface paramSurface)
  {
    super(new OutputConfiguration(paramSurface));
    AppMethodBeat.i(198206);
    AppMethodBeat.o(198206);
  }
  
  e(Object paramObject)
  {
    super(paramObject);
  }
  
  public final String hX()
  {
    return null;
  }
  
  public final Object hY()
  {
    AppMethodBeat.i(198224);
    f.checkArgument(this.mObject instanceof OutputConfiguration);
    Object localObject = this.mObject;
    AppMethodBeat.o(198224);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */