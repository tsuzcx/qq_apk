package com.tencent.mm.media.camera.instance.camera1;

import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/instance/camera1/Camera1ZoomHelper;", "", "()V", "availableZoomRatioIndexList", "Ljava/util/ArrayList;", "", "isZooming", "", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "bindCameraRes", "", "getAvailableZoomRatioIndexList", "parameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "onZoomIn", "onZoomOut", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a nvc;
  boolean isZooming;
  final ArrayList<Integer> nvd;
  d.a.a nve;
  
  static
  {
    AppMethodBeat.i(237420);
    nvc = new e.a((byte)0);
    AppMethodBeat.o(237420);
  }
  
  public e()
  {
    AppMethodBeat.i(237406);
    this.nvd = new ArrayList();
    AppMethodBeat.o(237406);
  }
  
  private final void e(Camera.Parameters paramParameters)
  {
    int j = 0;
    AppMethodBeat.i(237414);
    int i;
    Object localObject;
    if (paramParameters == null)
    {
      i = 0;
      this.nvd.clear();
      this.nvd.add(Integer.valueOf(0));
      float f = i;
      if (paramParameters == null) {
        break label194;
      }
      paramParameters = paramParameters.getZoomRatios();
      if (paramParameters == null) {
        break label194;
      }
      localObject = ((Iterable)paramParameters).iterator();
      f += 10.0F;
      i = j;
      label68:
      if (!((Iterator)localObject).hasNext()) {
        break label194;
      }
      paramParameters = ((Iterator)localObject).next();
      if (i < 0) {
        p.kkW();
      }
      paramParameters = (Integer)paramParameters;
      if (paramParameters != null) {
        break label182;
      }
      paramParameters = null;
      label104:
      if (paramParameters.floatValue() <= f) {
        break label200;
      }
      f += 10.0F;
      this.nvd.add(Integer.valueOf(i));
    }
    label182:
    label194:
    label200:
    for (;;)
    {
      i += 1;
      break label68;
      localObject = paramParameters.getZoomRatios();
      if (localObject == null)
      {
        i = 0;
        break;
      }
      localObject = (Integer)p.oK((List)localObject);
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((Integer)localObject).intValue();
      break;
      paramParameters = Float.valueOf(paramParameters.intValue());
      break label104;
      AppMethodBeat.o(237414);
      return;
    }
  }
  
  public final void b(d.a.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(237425);
    this.nve = parama;
    if (parama == null) {
      parama = localObject;
    }
    for (;;)
    {
      e(parama);
      AppMethodBeat.o(237425);
      return;
      w localw = parama.lTN;
      parama = localObject;
      if (localw != null) {
        parama = localw.aPy();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.camera1.e
 * JD-Core Version:    0.7.0.1
 */