package androidx.camera.camera2.b;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class t
{
  public static CameraDevice.StateCallback r(List<CameraDevice.StateCallback> paramList)
  {
    AppMethodBeat.i(197912);
    if (paramList.isEmpty())
    {
      paramList = new b();
      AppMethodBeat.o(197912);
      return paramList;
    }
    if (paramList.size() == 1)
    {
      paramList = (CameraDevice.StateCallback)paramList.get(0);
      AppMethodBeat.o(197912);
      return paramList;
    }
    paramList = new a(paramList);
    AppMethodBeat.o(197912);
    return paramList;
  }
  
  static final class a
    extends CameraDevice.StateCallback
  {
    private final List<CameraDevice.StateCallback> cQ;
    
    a(List<CameraDevice.StateCallback> paramList)
    {
      AppMethodBeat.i(197645);
      this.cQ = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CameraDevice.StateCallback localStateCallback = (CameraDevice.StateCallback)paramList.next();
        if (!(localStateCallback instanceof t.b)) {
          this.cQ.add(localStateCallback);
        }
      }
      AppMethodBeat.o(197645);
    }
    
    public final void onClosed(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(197657);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        ((CameraDevice.StateCallback)localIterator.next()).onClosed(paramCameraDevice);
      }
      AppMethodBeat.o(197657);
    }
    
    public final void onDisconnected(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(197665);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        ((CameraDevice.StateCallback)localIterator.next()).onDisconnected(paramCameraDevice);
      }
      AppMethodBeat.o(197665);
    }
    
    public final void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      AppMethodBeat.i(197669);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        ((CameraDevice.StateCallback)localIterator.next()).onError(paramCameraDevice, paramInt);
      }
      AppMethodBeat.o(197669);
    }
    
    public final void onOpened(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(197650);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        ((CameraDevice.StateCallback)localIterator.next()).onOpened(paramCameraDevice);
      }
      AppMethodBeat.o(197650);
    }
  }
  
  static final class b
    extends CameraDevice.StateCallback
  {
    public final void onClosed(CameraDevice paramCameraDevice) {}
    
    public final void onDisconnected(CameraDevice paramCameraDevice) {}
    
    public final void onError(CameraDevice paramCameraDevice, int paramInt) {}
    
    public final void onOpened(CameraDevice paramCameraDevice) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.t
 * JD-Core Version:    0.7.0.1
 */