package androidx.camera.core.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  extends d
{
  private final float PX;
  private final float PY;
  private final float PZ;
  private final float Qa;
  
  a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.PX = paramFloat1;
    this.PY = paramFloat2;
    this.PZ = paramFloat3;
    this.Qa = paramFloat4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199193);
    if (paramObject == this)
    {
      AppMethodBeat.o(199193);
      return true;
    }
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      if ((Float.floatToIntBits(this.PX) == Float.floatToIntBits(paramObject.hN())) && (Float.floatToIntBits(this.PY) == Float.floatToIntBits(paramObject.hO())) && (Float.floatToIntBits(this.PZ) == Float.floatToIntBits(paramObject.hP())) && (Float.floatToIntBits(this.Qa) == Float.floatToIntBits(paramObject.hQ())))
      {
        AppMethodBeat.o(199193);
        return true;
      }
      AppMethodBeat.o(199193);
      return false;
    }
    AppMethodBeat.o(199193);
    return false;
  }
  
  public final float hN()
  {
    return this.PX;
  }
  
  public final float hO()
  {
    return this.PY;
  }
  
  public final float hP()
  {
    return this.PZ;
  }
  
  public final float hQ()
  {
    return this.Qa;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(199195);
    int i = Float.floatToIntBits(this.PX);
    int j = Float.floatToIntBits(this.PY);
    int k = Float.floatToIntBits(this.PZ);
    int m = Float.floatToIntBits(this.Qa);
    AppMethodBeat.o(199195);
    return (((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199186);
    String str = "ImmutableZoomState{zoomRatio=" + this.PX + ", maxZoomRatio=" + this.PY + ", minZoomRatio=" + this.PZ + ", linearZoom=" + this.Qa + "}";
    AppMethodBeat.o(199186);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.a.a
 * JD-Core Version:    0.7.0.1
 */