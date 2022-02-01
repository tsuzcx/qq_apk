package androidx.camera.camera2.b.a.c;

import android.util.Size;
import androidx.camera.camera2.b.a.b.h;
import androidx.camera.camera2.b.a.b.p;
import androidx.camera.core.impl.bg.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  private final p FU;
  
  public g()
  {
    this((p)h.f(p.class));
    AppMethodBeat.i(198193);
    AppMethodBeat.o(198193);
  }
  
  private g(p paramp)
  {
    this.FU = paramp;
  }
  
  public final Size b(Size paramSize)
  {
    AppMethodBeat.i(198200);
    if (this.FU == null)
    {
      AppMethodBeat.o(198200);
      return paramSize;
    }
    Size localSize = p.a(bg.b.Nw);
    if (localSize == null)
    {
      AppMethodBeat.o(198200);
      return paramSize;
    }
    if (localSize.getWidth() * localSize.getHeight() > paramSize.getWidth() * paramSize.getHeight()) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(198200);
      return localSize;
    }
    AppMethodBeat.o(198200);
    return paramSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.c.g
 * JD-Core Version:    0.7.0.1
 */