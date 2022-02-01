package androidx.camera.camera2.a;

import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CaptureRequest.Key;
import androidx.camera.camera2.c.c.a;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.as;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.av;
import androidx.camera.core.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

public final class a
  extends androidx.camera.camera2.c.c
{
  public static final ac.a<Integer> zB;
  public static final ac.a<CameraDevice.StateCallback> zC;
  public static final ac.a<CameraCaptureSession.StateCallback> zD;
  public static final ac.a<CameraCaptureSession.CaptureCallback> zE;
  public static final ac.a<c> zF;
  public static final ac.a<Object> zG;
  
  static
  {
    AppMethodBeat.i(197283);
    zB = ac.a.a("camera2.captureRequest.templateType", Integer.TYPE, null);
    zC = ac.a.a("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class, null);
    zD = ac.a.a("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class, null);
    zE = ac.a.a("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class, null);
    zF = ac.a.a("camera2.cameraEvent.callback", c.class, null);
    zG = ac.a.a("camera2.captureRequest.tag", Object.class, null);
    AppMethodBeat.o(197283);
  }
  
  public a(ac paramac)
  {
    super(paramac);
  }
  
  public static ac.a<Object> a(CaptureRequest.Key<?> paramKey)
  {
    AppMethodBeat.i(197276);
    paramKey = ac.a.a("camera2.captureRequest.option." + paramKey.getName(), Object.class, paramKey);
    AppMethodBeat.o(197276);
    return paramKey;
  }
  
  public final CameraCaptureSession.CaptureCallback a(CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    AppMethodBeat.i(197297);
    paramCaptureCallback = (CameraCaptureSession.CaptureCallback)hx().b(zE, paramCaptureCallback);
    AppMethodBeat.o(197297);
    return paramCaptureCallback;
  }
  
  public final c a(c paramc)
  {
    AppMethodBeat.i(197300);
    paramc = (c)hx().b(zF, paramc);
    AppMethodBeat.o(197300);
    return paramc;
  }
  
  public final int aD(int paramInt)
  {
    AppMethodBeat.i(197293);
    paramInt = ((Integer)hx().b(zB, Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(197293);
    return paramInt;
  }
  
  public final androidx.camera.camera2.c.c fT()
  {
    AppMethodBeat.i(197287);
    androidx.camera.camera2.c.c localc = c.a.c(hx()).ir();
    AppMethodBeat.o(197287);
    return localc;
  }
  
  public static final class a
    implements x<a>
  {
    public final at zH;
    
    public a()
    {
      AppMethodBeat.i(197273);
      this.zH = at.ku();
      AppMethodBeat.o(197273);
    }
    
    public final <ValueT> a a(CaptureRequest.Key<ValueT> paramKey, ValueT paramValueT)
    {
      AppMethodBeat.i(197284);
      paramKey = a.a(paramKey);
      this.zH.c(paramKey, paramValueT);
      AppMethodBeat.o(197284);
      return this;
    }
    
    public final a a(ac paramac)
    {
      AppMethodBeat.i(197290);
      Iterator localIterator = paramac.ke().iterator();
      while (localIterator.hasNext())
      {
        ac.a locala = (ac.a)localIterator.next();
        this.zH.c(locala, paramac.b(locala));
      }
      AppMethodBeat.o(197290);
      return this;
    }
    
    public final as fU()
    {
      return this.zH;
    }
    
    public final a fV()
    {
      AppMethodBeat.i(197294);
      a locala = new a(av.l(this.zH));
      AppMethodBeat.o(197294);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.a.a
 * JD-Core Version:    0.7.0.1
 */