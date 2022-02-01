package androidx.camera.camera2.b;

import androidx.camera.core.ba;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class at
  implements ba
{
  private float EP;
  private final float EQ;
  private final float ER;
  private float ES;
  
  at(float paramFloat1, float paramFloat2)
  {
    this.EQ = paramFloat1;
    this.ER = paramFloat2;
  }
  
  private float j(float paramFloat)
  {
    if (this.EQ == this.ER) {}
    do
    {
      return 0.0F;
      if (paramFloat == this.EQ) {
        return 1.0F;
      }
    } while (paramFloat == this.ER);
    paramFloat = 1.0F / paramFloat;
    float f1 = 1.0F / this.EQ;
    float f2 = 1.0F / this.ER;
    return (paramFloat - f2) / (f1 - f2);
  }
  
  public final float hN()
  {
    return this.EP;
  }
  
  public final float hO()
  {
    return this.EQ;
  }
  
  public final float hP()
  {
    return this.ER;
  }
  
  public final float hQ()
  {
    return this.ES;
  }
  
  final void i(float paramFloat)
  {
    AppMethodBeat.i(197350);
    if ((paramFloat > this.EQ) || (paramFloat < this.ER))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Requested zoomRatio " + paramFloat + " is not within valid range [" + this.ER + " , " + this.EQ + "]");
      AppMethodBeat.o(197350);
      throw localIllegalArgumentException;
    }
    this.EP = paramFloat;
    this.ES = j(this.EP);
    AppMethodBeat.o(197350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.at
 * JD-Core Version:    0.7.0.1
 */