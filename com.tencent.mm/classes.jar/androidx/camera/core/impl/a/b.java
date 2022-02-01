package androidx.camera.core.impl.a;

import androidx.camera.core.al;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static int aY(int paramInt)
  {
    AppMethodBeat.i(198995);
    switch (paramInt)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Unsupported surface rotation: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(198995);
      throw localIllegalArgumentException;
    case 0: 
      paramInt = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(198995);
      return paramInt;
      paramInt = 90;
      continue;
      paramInt = 180;
      continue;
      paramInt = 270;
    }
  }
  
  public static int c(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(198987);
    if (paramBoolean) {}
    for (int i = (paramInt2 - paramInt1 + 360) % 360;; i = (paramInt2 + paramInt1) % 360)
    {
      if (al.N("CameraOrientationUtil"))
      {
        String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
        al.O("CameraOrientationUtil");
      }
      AppMethodBeat.o(198987);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.b
 * JD-Core Version:    0.7.0.1
 */