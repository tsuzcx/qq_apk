package androidx.camera.camera2.b.a.b;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.camera.camera2.b.a.h;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  implements ay
{
  public final Range<Integer> FD;
  
  public a(h paramh)
  {
    AppMethodBeat.i(197959);
    this.FD = a((Range[])paramh.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    AppMethodBeat.o(197959);
  }
  
  private static Range<Integer> a(Range<Integer>[] paramArrayOfRange)
  {
    Object localObject1 = null;
    AppMethodBeat.i(197995);
    if ((paramArrayOfRange == null) || (paramArrayOfRange.length == 0))
    {
      AppMethodBeat.o(197995);
      return null;
    }
    int m = paramArrayOfRange.length;
    int i = 0;
    Object localObject2;
    int j;
    int k;
    if (i < m)
    {
      localObject2 = paramArrayOfRange[i];
      j = ((Integer)((Range)localObject2).getUpper()).intValue();
      k = ((Integer)((Range)localObject2).getLower()).intValue();
      if (((Integer)((Range)localObject2).getUpper()).intValue() < 1000) {
        break label226;
      }
      j = ((Integer)((Range)localObject2).getUpper()).intValue() / 1000;
    }
    label226:
    for (;;)
    {
      if (((Integer)((Range)localObject2).getLower()).intValue() >= 1000) {
        k = ((Integer)((Range)localObject2).getLower()).intValue() / 1000;
      }
      for (;;)
      {
        localObject2 = new Range(Integer.valueOf(k), Integer.valueOf(j));
        if (((Integer)((Range)localObject2).getUpper()).intValue() == 30) {
          if (localObject1 == null) {
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (((Integer)((Range)localObject2).getLower()).intValue() < ((Integer)localObject1.getLower()).intValue())
          {
            localObject1 = localObject2;
            continue;
            AppMethodBeat.o(197995);
            return localObject1;
          }
        }
      }
    }
  }
  
  static boolean c(h paramh)
  {
    AppMethodBeat.i(197976);
    paramh = (Integer)paramh.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    if ((paramh != null) && (paramh.intValue() == 2))
    {
      AppMethodBeat.o(197976);
      return true;
    }
    AppMethodBeat.o(197976);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */