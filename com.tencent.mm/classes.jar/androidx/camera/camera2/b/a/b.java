package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraAccessException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class b
  extends Exception
{
  static final Set<Integer> ET;
  static final Set<Integer> EU;
  public final int EV;
  private final CameraAccessException EW;
  
  static
  {
    AppMethodBeat.i(198051);
    ET = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })));
    EU = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(10001), Integer.valueOf(10002) })));
    AppMethodBeat.o(198051);
  }
  
  private b(CameraAccessException paramCameraAccessException)
  {
    super(paramCameraAccessException.getMessage(), paramCameraAccessException.getCause());
    AppMethodBeat.i(198036);
    this.EV = paramCameraAccessException.getReason();
    this.EW = paramCameraAccessException;
    AppMethodBeat.o(198036);
  }
  
  public b(String paramString, Throwable paramThrowable)
  {
    super(String.format("%s (%d): %s", new Object[] { "CAMERA_CHARACTERISTICS_CREATION_ERROR", Integer.valueOf(10002), paramString }), paramThrowable);
    AppMethodBeat.i(198023);
    this.EV = 10002;
    if (ET.contains(Integer.valueOf(10002))) {}
    for (paramString = new CameraAccessException(10002, paramString, paramThrowable);; paramString = null)
    {
      this.EW = paramString;
      AppMethodBeat.o(198023);
      return;
    }
  }
  
  public b(Throwable paramThrowable)
  {
    super("Some API 28 devices cannot access the camera when the device is in \"Do Not Disturb\" mode. The camera will not be accessible until \"Do Not Disturb\" mode is disabled.", paramThrowable);
    AppMethodBeat.i(198031);
    this.EV = 10001;
    if (ET.contains(Integer.valueOf(10001))) {}
    for (paramThrowable = new CameraAccessException(10001, null, paramThrowable);; paramThrowable = null)
    {
      this.EW = paramThrowable;
      AppMethodBeat.o(198031);
      return;
    }
  }
  
  public static b a(CameraAccessException paramCameraAccessException)
  {
    AppMethodBeat.i(198043);
    paramCameraAccessException = new b(paramCameraAccessException);
    AppMethodBeat.o(198043);
    return paramCameraAccessException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b
 * JD-Core Version:    0.7.0.1
 */