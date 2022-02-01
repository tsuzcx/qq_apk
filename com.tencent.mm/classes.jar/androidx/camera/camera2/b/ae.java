package androidx.camera.camera2.b;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.Size;
import android.view.Display;
import androidx.camera.camera2.b.a.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ae
{
  private static final Size CK;
  private static final Object CL;
  private static volatile ae CM;
  volatile Size CN;
  private final g CO;
  private final DisplayManager mDisplayManager;
  
  static
  {
    AppMethodBeat.i(197430);
    CK = new Size(1920, 1080);
    CL = new Object();
    AppMethodBeat.o(197430);
  }
  
  private ae(Context paramContext)
  {
    AppMethodBeat.i(197409);
    this.CN = null;
    this.CO = new g();
    this.mDisplayManager = ((DisplayManager)paramContext.getSystemService("display"));
    AppMethodBeat.o(197409);
  }
  
  static ae N(Context paramContext)
  {
    AppMethodBeat.i(197422);
    if (CM == null) {}
    synchronized (CL)
    {
      if (CM == null) {
        CM = new ae(paramContext);
      }
      paramContext = CM;
      AppMethodBeat.o(197422);
      return paramContext;
    }
  }
  
  final Display hp()
  {
    AppMethodBeat.i(197440);
    Display[] arrayOfDisplay = this.mDisplayManager.getDisplays();
    if (arrayOfDisplay.length == 1)
    {
      localObject = arrayOfDisplay[0];
      AppMethodBeat.o(197440);
      return localObject;
    }
    Object localObject = null;
    int j = -1;
    int k = arrayOfDisplay.length;
    int i = 0;
    if (i < k)
    {
      Display localDisplay = arrayOfDisplay[i];
      Point localPoint = new Point();
      localDisplay.getRealSize(localPoint);
      if (localPoint.x * localPoint.y <= j) {
        break label143;
      }
      j = localPoint.x * localPoint.y;
      localObject = localDisplay;
    }
    label143:
    for (;;)
    {
      i += 1;
      break;
      if (localObject == null)
      {
        localObject = new IllegalArgumentException("No display can be found from the input display manager!");
        AppMethodBeat.o(197440);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(197440);
      return localObject;
    }
  }
  
  final Size hq()
  {
    AppMethodBeat.i(197449);
    if (this.CN != null)
    {
      localSize = this.CN;
      AppMethodBeat.o(197449);
      return localSize;
    }
    this.CN = hr();
    Size localSize = this.CN;
    AppMethodBeat.o(197449);
    return localSize;
  }
  
  final Size hr()
  {
    AppMethodBeat.i(197455);
    Object localObject1 = new Point();
    hp().getRealSize((Point)localObject1);
    if (((Point)localObject1).x > ((Point)localObject1).y) {}
    for (localObject1 = new Size(((Point)localObject1).x, ((Point)localObject1).y);; localObject1 = new Size(((Point)localObject1).y, ((Point)localObject1).x))
    {
      Object localObject2 = localObject1;
      if (((Size)localObject1).getWidth() * ((Size)localObject1).getHeight() > CK.getWidth() * CK.getHeight()) {
        localObject2 = CK;
      }
      localObject1 = this.CO.b((Size)localObject2);
      AppMethodBeat.o(197455);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.ae
 * JD-Core Version:    0.7.0.1
 */