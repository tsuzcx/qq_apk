package androidx.camera.camera2.b.a.c;

import android.util.Range;
import androidx.camera.core.impl.az;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final Range<Integer> FQ;
  
  public a(az paramaz)
  {
    AppMethodBeat.i(198191);
    paramaz = (androidx.camera.camera2.b.a.b.a)paramaz.f(androidx.camera.camera2.b.a.b.a.class);
    if (paramaz == null)
    {
      this.FQ = null;
      AppMethodBeat.o(198191);
      return;
    }
    this.FQ = paramaz.FD;
    AppMethodBeat.o(198191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */