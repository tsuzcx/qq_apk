package androidx.camera.camera2.b;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.b.a.b;
import androidx.camera.camera2.b.a.n;
import androidx.camera.core.ak;
import androidx.camera.core.al;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.v;
import androidx.camera.core.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  implements r
{
  private final androidx.camera.core.impl.w As;
  private final v At;
  final n Au;
  private final List<String> Av;
  private final Map<String, i> Aw;
  
  public g(Context paramContext, androidx.camera.core.impl.w paramw, q paramq)
  {
    AppMethodBeat.i(197541);
    this.Aw = new HashMap();
    this.As = paramw;
    this.At = new v();
    this.Au = n.a(paramContext, this.As.jL());
    this.Av = j(u.a(this, paramq));
    AppMethodBeat.o(197541);
  }
  
  private boolean A(String paramString)
  {
    AppMethodBeat.i(197560);
    if ("robolectric".equals(Build.FINGERPRINT))
    {
      AppMethodBeat.o(197560);
      return true;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = (int[])this.Au.H(paramString).a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (paramString == null) {
          break;
        }
        int j = paramString.length;
        i = 0;
        if (i >= j) {
          break;
        }
        if (paramString[i] == 0)
        {
          AppMethodBeat.o(197560);
          return true;
        }
      }
      catch (b paramString)
      {
        paramString = new ak(w.a(paramString));
        AppMethodBeat.o(197560);
        throw paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(197560);
    return false;
  }
  
  private List<String> j(List<String> paramList)
  {
    AppMethodBeat.i(197549);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str.equals("0")) || (str.equals("1")))
      {
        localArrayList.add(str);
      }
      else if (A(str))
      {
        localArrayList.add(str);
      }
      else
      {
        new StringBuilder("Camera ").append(str).append(" is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
        al.O("Camera2CameraFactory");
      }
    }
    AppMethodBeat.o(197549);
    return localArrayList;
  }
  
  public final Set<String> gC()
  {
    AppMethodBeat.i(197582);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.Av);
    AppMethodBeat.o(197582);
    return localLinkedHashSet;
  }
  
  public final t y(String paramString)
  {
    AppMethodBeat.i(197569);
    if (!this.Av.contains(paramString))
    {
      paramString = new IllegalArgumentException("The given camera id is not on the available camera id list.");
      AppMethodBeat.o(197569);
      throw paramString;
    }
    paramString = new h(this.Au, paramString, z(paramString), this.At, this.As.jK(), this.As.jL());
    AppMethodBeat.o(197569);
    return paramString;
  }
  
  final i z(String paramString)
  {
    AppMethodBeat.i(197575);
    try
    {
      i locali2 = (i)this.Aw.get(paramString);
      i locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new i(paramString, this.Au);
        this.Aw.put(paramString, locali1);
      }
      AppMethodBeat.o(197575);
      return locali1;
    }
    catch (b paramString)
    {
      paramString = w.a(paramString);
      AppMethodBeat.o(197575);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.g
 * JD-Core Version:    0.7.0.1
 */