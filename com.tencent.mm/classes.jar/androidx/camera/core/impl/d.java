package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
  extends aw
{
  private final int KA;
  private final Size Kz;
  private final Surface surface;
  
  d(Surface paramSurface, Size paramSize, int paramInt)
  {
    AppMethodBeat.i(198725);
    if (paramSurface == null)
    {
      paramSurface = new NullPointerException("Null surface");
      AppMethodBeat.o(198725);
      throw paramSurface;
    }
    this.surface = paramSurface;
    if (paramSize == null)
    {
      paramSurface = new NullPointerException("Null size");
      AppMethodBeat.o(198725);
      throw paramSurface;
    }
    this.Kz = paramSize;
    this.KA = paramInt;
    AppMethodBeat.o(198725);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198760);
    if (paramObject == this)
    {
      AppMethodBeat.o(198760);
      return true;
    }
    if ((paramObject instanceof aw))
    {
      paramObject = (aw)paramObject;
      if ((this.surface.equals(paramObject.getSurface())) && (this.Kz.equals(paramObject.getSize())) && (this.KA == paramObject.iw()))
      {
        AppMethodBeat.o(198760);
        return true;
      }
      AppMethodBeat.o(198760);
      return false;
    }
    AppMethodBeat.o(198760);
    return false;
  }
  
  public final Size getSize()
  {
    return this.Kz;
  }
  
  public final Surface getSurface()
  {
    return this.surface;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198766);
    int i = this.surface.hashCode();
    int j = this.Kz.hashCode();
    int k = this.KA;
    AppMethodBeat.o(198766);
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k;
  }
  
  public final int iw()
  {
    return this.KA;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198751);
    String str = "OutputSurface{surface=" + this.surface + ", size=" + this.Kz + ", imageFormat=" + this.KA + "}";
    AppMethodBeat.o(198751);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.d
 * JD-Core Version:    0.7.0.1
 */