package androidx.camera.camera2.b.a.b;

import android.os.Build;
import androidx.camera.core.a.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class m
  implements d
{
  private static final Set<String> FL;
  
  static
  {
    AppMethodBeat.i(198016);
    FL = new HashSet(Arrays.asList(new String[] { "heroqltevzw", "heroqltetmo" }));
    AppMethodBeat.o(198016);
  }
  
  static boolean il()
  {
    AppMethodBeat.i(198004);
    boolean bool = FL.contains(Build.DEVICE.toLowerCase(Locale.US));
    AppMethodBeat.o(198004);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.m
 * JD-Core Version:    0.7.0.1
 */