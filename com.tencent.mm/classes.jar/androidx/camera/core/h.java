package androidx.camera.core;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h
  extends aw.c
{
  private final int Gj;
  private final Rect Gl;
  private final int Gm;
  
  h(Rect paramRect, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198502);
    if (paramRect == null)
    {
      paramRect = new NullPointerException("Null cropRect");
      AppMethodBeat.o(198502);
      throw paramRect;
    }
    this.Gl = paramRect;
    this.Gj = paramInt1;
    this.Gm = paramInt2;
    AppMethodBeat.o(198502);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198529);
    if (paramObject == this)
    {
      AppMethodBeat.o(198529);
      return true;
    }
    if ((paramObject instanceof aw.c))
    {
      paramObject = (aw.c)paramObject;
      if ((this.Gl.equals(paramObject.iD())) && (this.Gj == paramObject.iB()) && (this.Gm == paramObject.iE()))
      {
        AppMethodBeat.o(198529);
        return true;
      }
      AppMethodBeat.o(198529);
      return false;
    }
    AppMethodBeat.o(198529);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198533);
    int i = this.Gl.hashCode();
    int j = this.Gj;
    int k = this.Gm;
    AppMethodBeat.o(198533);
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ k;
  }
  
  public final int iB()
  {
    return this.Gj;
  }
  
  public final Rect iD()
  {
    return this.Gl;
  }
  
  public final int iE()
  {
    return this.Gm;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198525);
    String str = "TransformationInfo{cropRect=" + this.Gl + ", rotationDegrees=" + this.Gj + ", targetRotation=" + this.Gm + "}";
    AppMethodBeat.o(198525);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.h
 * JD-Core Version:    0.7.0.1
 */