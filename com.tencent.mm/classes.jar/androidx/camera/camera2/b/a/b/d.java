package androidx.camera.camera2.b.a.b;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build.VERSION;
import android.util.Size;
import androidx.camera.camera2.b.a.h;
import androidx.camera.core.al;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class d
  implements ay
{
  public final List<Size> FF;
  
  public d(h paramh)
  {
    AppMethodBeat.i(197983);
    StreamConfigurationMap localStreamConfigurationMap = (StreamConfigurationMap)paramh.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (localStreamConfigurationMap == null) {
      al.T("CamcorderProfileResolutionQuirk");
    }
    if (Build.VERSION.SDK_INT < 23) {
      if (localStreamConfigurationMap != null)
      {
        paramh = localStreamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        if (paramh == null) {
          break label119;
        }
      }
    }
    label119:
    for (paramh = Arrays.asList((Size[])paramh.clone());; paramh = Collections.emptyList())
    {
      this.FF = paramh;
      new StringBuilder("mSupportedResolutions = ").append(this.FF);
      al.O("CamcorderProfileResolutionQuirk");
      AppMethodBeat.o(197983);
      return;
      paramh = null;
      break;
      paramh = localObject;
      if (localStreamConfigurationMap != null) {
        paramh = localStreamConfigurationMap.getOutputSizes(34);
      }
      break;
    }
  }
  
  static boolean c(h paramh)
  {
    AppMethodBeat.i(197967);
    paramh = (Integer)paramh.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    if ((paramh != null) && (paramh.intValue() == 2))
    {
      AppMethodBeat.o(197967);
      return true;
    }
    AppMethodBeat.o(197967);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */