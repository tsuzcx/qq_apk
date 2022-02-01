package androidx.camera.camera2.b.a.c;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.b.a.b.h;
import androidx.camera.camera2.b.a.b.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class j
{
  private final boolean FX;
  
  public j()
  {
    AppMethodBeat.i(198207);
    if ((q)h.f(q.class) != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.FX = bool;
      AppMethodBeat.o(198207);
      return;
    }
  }
  
  public final boolean a(List<CaptureRequest> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(198211);
    if ((!this.FX) || (!paramBoolean))
    {
      AppMethodBeat.o(198211);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((Integer)((CaptureRequest)paramList.next()).get(CaptureRequest.CONTROL_AE_MODE)).intValue();
      if ((i == 2) || (i == 3))
      {
        AppMethodBeat.o(198211);
        return true;
      }
    }
    AppMethodBeat.o(198211);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.c.j
 * JD-Core Version:    0.7.0.1
 */