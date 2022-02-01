package androidx.camera.core;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g
  extends aw.b
{
  private final int resultCode;
  private final Surface surface;
  
  g(int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(198516);
    this.resultCode = paramInt;
    if (paramSurface == null)
    {
      paramSurface = new NullPointerException("Null surface");
      AppMethodBeat.o(198516);
      throw paramSurface;
    }
    this.surface = paramSurface;
    AppMethodBeat.o(198516);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198536);
    if (paramObject == this)
    {
      AppMethodBeat.o(198536);
      return true;
    }
    if ((paramObject instanceof aw.b))
    {
      paramObject = (aw.b)paramObject;
      if ((this.resultCode == paramObject.getResultCode()) && (this.surface.equals(paramObject.getSurface())))
      {
        AppMethodBeat.o(198536);
        return true;
      }
      AppMethodBeat.o(198536);
      return false;
    }
    AppMethodBeat.o(198536);
    return false;
  }
  
  public final int getResultCode()
  {
    return this.resultCode;
  }
  
  public final Surface getSurface()
  {
    return this.surface;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198541);
    int i = this.resultCode;
    int j = this.surface.hashCode();
    AppMethodBeat.o(198541);
    return (i ^ 0xF4243) * 1000003 ^ j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198532);
    String str = "Result{resultCode=" + this.resultCode + ", surface=" + this.surface + "}";
    AppMethodBeat.o(198532);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.g
 * JD-Core Version:    0.7.0.1
 */