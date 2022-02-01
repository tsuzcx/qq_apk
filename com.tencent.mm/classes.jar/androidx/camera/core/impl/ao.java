package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.a.b.e;
import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
  extends ad
{
  private final Surface mSurface;
  
  public ao(Surface paramSurface)
  {
    this.mSurface = paramSurface;
  }
  
  public ao(Surface paramSurface, Size paramSize, int paramInt)
  {
    super(paramSize, paramInt);
    this.mSurface = paramSurface;
  }
  
  public final f<Surface> jq()
  {
    AppMethodBeat.i(198636);
    f localf = e.v(this.mSurface);
    AppMethodBeat.o(198636);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.ao
 * JD-Core Version:    0.7.0.1
 */