package androidx.camera.camera2.b.a.b;

import android.os.Build;
import androidx.camera.core.impl.ay;
import androidx.camera.core.impl.bf;
import androidx.camera.core.impl.bg;
import androidx.camera.core.impl.bg.a;
import androidx.camera.core.impl.bg.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class j
  implements ay
{
  private static final bf FH;
  private static final bf FI;
  private static final Set<String> FJ;
  
  static
  {
    AppMethodBeat.i(198075);
    bf localbf = new bf();
    localbf.a(bg.a(bg.b.Nx, bg.a.Nq));
    localbf.a(bg.a(bg.b.Nw, bg.a.Nr));
    localbf.a(bg.a(bg.b.Nx, bg.a.Nt));
    FH = localbf;
    localbf = new bf();
    localbf.a(bg.a(bg.b.Nx, bg.a.Nq));
    localbf.a(bg.a(bg.b.Nx, bg.a.Nr));
    localbf.a(bg.a(bg.b.Nx, bg.a.Nt));
    FI = localbf;
    FJ = new HashSet(Arrays.asList(new String[] { "SM-A515F", "SM-A515U", "SM-A515U1", "SM-A515W", "SM-S515DL", "SC-54A", "SCG07", "SM-A5160", "SM-A516B", "SM-A516N", "SM-A516U", "SM-A516U1", "SM-A516V", "SM-A715F", "SM-A715W", "SM-A7160", "SM-A716B", "SM-A716U", "SM-A716U1", "SM-A716V", "SM-A8050", "SM-A805F", "SM-A805N", "SCV44", "SM-F9000", "SM-F900F", "SM-F900U", "SM-F900U1", "SM-F900W", "SM-F907B", "SM-F907N", "SM-N970F", "SM-N9700", "SM-N970U", "SM-N970U1", "SM-N970W", "SM-N971N", "SM-N770F", "SC-01M", "SCV45", "SM-N9750", "SM-N975C", "SM-N975U", "SM-N975U1", "SM-N975W", "SM-N975F", "SM-N976B", "SM-N976N", "SM-N9760", "SM-N976Q", "SM-N976V", "SM-N976U", "SM-N9810", "SM-N981N", "SM-N981U", "SM-N981U1", "SM-N981W", "SM-N981B", "SC-53A", "SCG06", "SM-N9860", "SM-N986N", "SM-N986U", "SM-N986U1", "SM-N986W", "SM-N986B", "SC-03L", "SCV41", "SM-G973F", "SM-G973N", "SM-G9730", "SM-G9738", "SM-G973C", "SM-G973U", "SM-G973U1", "SM-G973W", "SM-G977B", "SM-G977N", "SM-G977P", "SM-G977T", "SM-G977U", "SM-G770F", "SM-G770U1", "SC-04L", "SCV42", "SM-G975F", "SM-G975N", "SM-G9750", "SM-G9758", "SM-G975U", "SM-G975U1", "SM-G975W", "SC-05L", "SM-G970F", "SM-G970N", "SM-G9700", "SM-G9708", "SM-G970U", "SM-G970U1", "SM-G970W", "SC-51A", "SC51Aa", "SCG01", "SM-G9810", "SM-G981N", "SM-G981U", "SM-G981U1", "SM-G981V", "SM-G981W", "SM-G981B", "SCG03", "SM-G9880", "SM-G988N", "SM-G988Q", "SM-G988U", "SM-G988U1", "SM-G988W", "SM-G988B", "SC-52A", "SCG02", "SM-G9860", "SM-G986N", "SM-G986U", "SM-G986U1", "SM-G986W", "SM-G986B", "SCV47", "SM-F7000", "SM-F700F", "SM-F700N", "SM-F700U", "SM-F700U1", "SM-F700W", "SCG04", "SM-F7070", "SM-F707B", "SM-F707N", "SM-F707U", "SM-F707U1", "SM-F707W", "SM-F9160", "SM-F916B", "SM-F916N", "SM-F916Q", "SM-F916U", "SM-F916U1", "SM-F916W" }));
    AppMethodBeat.o(198075);
  }
  
  public static List<bf> L(String paramString)
  {
    AppMethodBeat.i(198035);
    ArrayList localArrayList = new ArrayList();
    if (paramString.equals("1")) {
      localArrayList.add(FH);
    }
    AppMethodBeat.o(198035);
    return localArrayList;
  }
  
  public static List<bf> aQ(int paramInt)
  {
    AppMethodBeat.i(198048);
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
    {
      localArrayList.add(FH);
      localArrayList.add(FI);
    }
    AppMethodBeat.o(198048);
    return localArrayList;
  }
  
  public static boolean ij()
  {
    AppMethodBeat.i(198008);
    if (("heroqltevzw".equalsIgnoreCase(Build.DEVICE)) || ("heroqltetmo".equalsIgnoreCase(Build.DEVICE)))
    {
      AppMethodBeat.o(198008);
      return true;
    }
    AppMethodBeat.o(198008);
    return false;
  }
  
  public static boolean ik()
  {
    AppMethodBeat.i(198022);
    if (!"samsung".equalsIgnoreCase(Build.BRAND))
    {
      AppMethodBeat.o(198022);
      return false;
    }
    String str = Build.MODEL.toUpperCase(Locale.US);
    boolean bool = FJ.contains(str);
    AppMethodBeat.o(198022);
    return bool;
  }
  
  static boolean load()
  {
    AppMethodBeat.i(197996);
    if ((ij()) || (ik()))
    {
      AppMethodBeat.o(197996);
      return true;
    }
    AppMethodBeat.o(197996);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.j
 * JD-Core Version:    0.7.0.1
 */