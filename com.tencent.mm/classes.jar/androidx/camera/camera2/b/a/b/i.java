package androidx.camera.camera2.b.a.b;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.al;
import androidx.camera.core.impl.ay;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class i
  implements ay
{
  public static List<Size> g(String paramString, int paramInt)
  {
    AppMethodBeat.i(198024);
    ArrayList localArrayList;
    if (ig())
    {
      localArrayList = new ArrayList();
      if ((paramString.equals("0")) && (paramInt == 256))
      {
        localArrayList.add(new Size(4160, 3120));
        localArrayList.add(new Size(4000, 3000));
      }
      AppMethodBeat.o(198024);
      return localArrayList;
    }
    if (ih())
    {
      localArrayList = new ArrayList();
      if ((paramString.equals("0")) && (paramInt == 256))
      {
        localArrayList.add(new Size(4160, 3120));
        localArrayList.add(new Size(4000, 3000));
      }
      AppMethodBeat.o(198024);
      return localArrayList;
    }
    if (ii())
    {
      localArrayList = new ArrayList();
      if ((paramString.equals("0")) && ((paramInt == 34) || (paramInt == 35)))
      {
        localArrayList.add(new Size(720, 720));
        localArrayList.add(new Size(400, 400));
      }
      AppMethodBeat.o(198024);
      return localArrayList;
    }
    al.R("ExcludedSupportedSizesQuirk");
    paramString = Collections.emptyList();
    AppMethodBeat.o(198024);
    return paramString;
  }
  
  private static boolean ig()
  {
    AppMethodBeat.i(197980);
    if (("OnePlus".equalsIgnoreCase(Build.BRAND)) && ("OnePlus6".equalsIgnoreCase(Build.DEVICE)))
    {
      AppMethodBeat.o(197980);
      return true;
    }
    AppMethodBeat.o(197980);
    return false;
  }
  
  private static boolean ih()
  {
    AppMethodBeat.i(197989);
    if (("OnePlus".equalsIgnoreCase(Build.BRAND)) && ("OnePlus6T".equalsIgnoreCase(Build.DEVICE)))
    {
      AppMethodBeat.o(197989);
      return true;
    }
    AppMethodBeat.o(197989);
    return false;
  }
  
  private static boolean ii()
  {
    AppMethodBeat.i(197998);
    if (("HUAWEI".equalsIgnoreCase(Build.BRAND)) && ("HWANE".equalsIgnoreCase(Build.DEVICE)))
    {
      AppMethodBeat.o(197998);
      return true;
    }
    AppMethodBeat.o(197998);
    return false;
  }
  
  static boolean load()
  {
    AppMethodBeat.i(197970);
    if ((ig()) || (ih()) || (ii()))
    {
      AppMethodBeat.o(197970);
      return true;
    }
    AppMethodBeat.o(197970);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.b.i
 * JD-Core Version:    0.7.0.1
 */