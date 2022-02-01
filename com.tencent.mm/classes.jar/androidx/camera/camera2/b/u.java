package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.b.a.b;
import androidx.camera.camera2.b.a.h;
import androidx.camera.camera2.b.a.n;
import androidx.camera.camera2.b.a.n.b;
import androidx.camera.core.ak;
import androidx.camera.core.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class u
{
  static List<String> a(g paramg, q paramq)
  {
    localArrayList2 = null;
    AppMethodBeat.i(197884);
    ArrayList localArrayList3;
    for (;;)
    {
      Object localObject2;
      try
      {
        localArrayList3 = new ArrayList();
        localObject2 = Arrays.asList(paramg.Au.Fh.hU());
        if (paramq == null)
        {
          paramg = ((List)localObject2).iterator();
          if (paramg.hasNext())
          {
            localArrayList3.add((String)paramg.next());
            continue;
          }
        }
        localObject1 = localArrayList2;
      }
      catch (b paramg)
      {
        paramg = new ak(w.a(paramg));
        AppMethodBeat.o(197884);
        throw paramg;
        AppMethodBeat.o(197884);
        return localArrayList3;
        try
        {
          localObject3 = paramq.gW();
          localn = paramg.Au;
          if (localObject3 != null) {
            break label202;
          }
          localObject1 = localArrayList2;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          Object localObject3;
          n localn;
          Object localObject1;
          ArrayList localArrayList1 = localArrayList2;
          continue;
          localArrayList1 = null;
          continue;
        }
        localArrayList2 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        if (((String)localObject3).equals(localObject1)) {
          continue;
        }
        localArrayList2.add(paramg.z((String)localObject3));
        continue;
      }
      catch (androidx.camera.core.s paramg)
      {
        paramg = new ak(paramg);
        AppMethodBeat.o(197884);
        throw paramg;
      }
      label202:
      if (((List)localObject2).contains("0"))
      {
        localObject1 = localArrayList2;
        if (((List)localObject2).contains("1"))
        {
          if (((Integer)localObject3).intValue() == 1)
          {
            if (((Integer)localn.H("0").a(CameraCharacteristics.LENS_FACING)).intValue() != 1) {
              break label366;
            }
            localObject1 = "1";
            break label368;
          }
          if ((((Integer)localObject3).intValue() != 0) || (((Integer)localn.H("1").a(CameraCharacteristics.LENS_FACING)).intValue() != 0)) {
            break label366;
          }
          localObject1 = "0";
          break label368;
        }
      }
    }
    paramg = paramq.F(localArrayList2).iterator();
    while (paramg.hasNext()) {
      localArrayList3.add(((androidx.camera.core.impl.s)paramg.next()).gV());
    }
    AppMethodBeat.o(197884);
    return localArrayList3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.u
 * JD-Core Version:    0.7.0.1
 */