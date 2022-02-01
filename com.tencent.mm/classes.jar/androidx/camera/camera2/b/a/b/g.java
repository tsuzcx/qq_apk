package androidx.camera.camera2.b.a.b;

import android.os.Build;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class g
  implements ay
{
  static final List<String> FE;
  
  static
  {
    AppMethodBeat.i(197986);
    FE = Arrays.asList(new String[] { "SM-A3000", "SM-A3009", "SM-A300F", "SM-A300FU", "SM-A300G", "SM-A300H", "SM-A300M", "SM-A300X", "SM-A300XU", "SM-A300XZ", "SM-A300Y", "SM-A300YZ", "SM-J510FN", "5059X" });
    AppMethodBeat.o(197986);
  }
  
  static boolean load()
  {
    AppMethodBeat.i(197975);
    boolean bool = FE.contains(Build.MODEL.toUpperCase(Locale.US));
    AppMethodBeat.o(197975);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.g
 * JD-Core Version:    0.7.0.1
 */