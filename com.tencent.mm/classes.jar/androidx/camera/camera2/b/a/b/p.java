package androidx.camera.camera2.b.a.b;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.ay;
import androidx.camera.core.impl.bg.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class p
  implements ay
{
  private static final List<String> FO;
  
  static
  {
    AppMethodBeat.i(198042);
    FO = Arrays.asList(new String[] { "SM-T580", "SM-J710MN", "SM-A320FL", "SM-G570M" });
    AppMethodBeat.o(198042);
  }
  
  public static Size a(bg.b paramb)
  {
    AppMethodBeat.i(198026);
    if (im())
    {
      switch (1.FP[paramb.ordinal()])
      {
      default: 
        AppMethodBeat.o(198026);
        return null;
      case 1: 
        paramb = new Size(1920, 1080);
        AppMethodBeat.o(198026);
        return paramb;
      case 2: 
        paramb = new Size(1280, 720);
        AppMethodBeat.o(198026);
        return paramb;
      }
      paramb = new Size(3264, 1836);
      AppMethodBeat.o(198026);
      return paramb;
    }
    AppMethodBeat.o(198026);
    return null;
  }
  
  private static boolean im()
  {
    AppMethodBeat.i(198034);
    if (("samsung".equalsIgnoreCase(Build.BRAND)) && (FO.contains(Build.MODEL.toUpperCase(Locale.US))))
    {
      AppMethodBeat.o(198034);
      return true;
    }
    AppMethodBeat.o(198034);
    return false;
  }
  
  static boolean load()
  {
    AppMethodBeat.i(198012);
    boolean bool = im();
    AppMethodBeat.o(198012);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.p
 * JD-Core Version:    0.7.0.1
 */