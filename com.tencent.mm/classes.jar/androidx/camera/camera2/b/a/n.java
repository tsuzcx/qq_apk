package androidx.camera.camera2.b.a;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager.AvailabilityCallback;
import android.os.Handler;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.Executor;

public final class n
{
  public final b Fh;
  private final Map<String, h> Fi;
  
  private n(b paramb)
  {
    AppMethodBeat.i(198064);
    this.Fi = new ArrayMap(4);
    this.Fh = paramb;
    AppMethodBeat.o(198064);
  }
  
  public static n a(Context paramContext, Handler paramHandler)
  {
    AppMethodBeat.i(198069);
    paramContext = new n(n.b.-CC.b(paramContext, paramHandler));
    AppMethodBeat.o(198069);
    return paramContext;
  }
  
  public final h H(String paramString)
  {
    AppMethodBeat.i(198080);
    synchronized (this.Fi)
    {
      h localh2 = (h)this.Fi.get(paramString);
      h localh1 = localh2;
      if (localh2 == null) {}
      try
      {
        localh1 = new h(this.Fh.K(paramString));
        this.Fi.put(paramString, localh1);
        AppMethodBeat.o(198080);
        return localh1;
      }
      catch (AssertionError paramString)
      {
        paramString = new b(paramString.getMessage(), paramString);
        AppMethodBeat.o(198080);
        throw paramString;
      }
    }
  }
  
  public final void a(String paramString, Executor paramExecutor, CameraDevice.StateCallback paramStateCallback)
  {
    AppMethodBeat.i(198086);
    this.Fh.a(paramString, paramExecutor, paramStateCallback);
    AppMethodBeat.o(198086);
  }
  
  public static abstract interface b
  {
    public abstract CameraCharacteristics K(String paramString);
    
    public abstract void a(String paramString, Executor paramExecutor, CameraDevice.StateCallback paramStateCallback);
    
    public abstract void a(Executor paramExecutor, CameraManager.AvailabilityCallback paramAvailabilityCallback);
    
    public abstract void b(CameraManager.AvailabilityCallback paramAvailabilityCallback);
    
    public abstract String[] hU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.n
 * JD-Core Version:    0.7.0.1
 */