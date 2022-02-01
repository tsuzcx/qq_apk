package androidx.camera.core.impl;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
  extends bh
{
  private final Size KE;
  private final Size KF;
  private final Size KG;
  
  f(Size paramSize1, Size paramSize2, Size paramSize3)
  {
    AppMethodBeat.i(198724);
    if (paramSize1 == null)
    {
      paramSize1 = new NullPointerException("Null analysisSize");
      AppMethodBeat.o(198724);
      throw paramSize1;
    }
    this.KE = paramSize1;
    if (paramSize2 == null)
    {
      paramSize1 = new NullPointerException("Null previewSize");
      AppMethodBeat.o(198724);
      throw paramSize1;
    }
    this.KF = paramSize2;
    if (paramSize3 == null)
    {
      paramSize1 = new NullPointerException("Null recordSize");
      AppMethodBeat.o(198724);
      throw paramSize1;
    }
    this.KG = paramSize3;
    AppMethodBeat.o(198724);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198779);
    if (paramObject == this)
    {
      AppMethodBeat.o(198779);
      return true;
    }
    if ((paramObject instanceof bh))
    {
      paramObject = (bh)paramObject;
      if ((this.KE.equals(paramObject.jQ())) && (this.KF.equals(paramObject.hq())) && (this.KG.equals(paramObject.hB())))
      {
        AppMethodBeat.o(198779);
        return true;
      }
      AppMethodBeat.o(198779);
      return false;
    }
    AppMethodBeat.o(198779);
    return false;
  }
  
  public final Size hB()
  {
    return this.KG;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198789);
    int i = this.KE.hashCode();
    int j = this.KF.hashCode();
    int k = this.KG.hashCode();
    AppMethodBeat.o(198789);
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k;
  }
  
  public final Size hq()
  {
    return this.KF;
  }
  
  public final Size jQ()
  {
    return this.KE;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198765);
    String str = "SurfaceSizeDefinition{analysisSize=" + this.KE + ", previewSize=" + this.KF + ", recordSize=" + this.KG + "}";
    AppMethodBeat.o(198765);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.f
 * JD-Core Version:    0.7.0.1
 */