package android.support.v7.d;

import android.graphics.Color;
import android.support.v4.graphics.b;
import java.util.Arrays;

public final class b$d
{
  private final int ZA;
  private final int ZB;
  public final int ZC;
  private boolean ZD;
  private int ZE;
  private int ZF;
  private float[] ZG;
  final int Ze;
  private final int Zz;
  
  public b$d(int paramInt1, int paramInt2)
  {
    this.Zz = Color.red(paramInt1);
    this.ZA = Color.green(paramInt1);
    this.ZB = Color.blue(paramInt1);
    this.ZC = paramInt1;
    this.Ze = paramInt2;
  }
  
  private void gP()
  {
    int j;
    if (!this.ZD)
    {
      i = b.d(-1, this.ZC, 4.5F);
      j = b.d(-1, this.ZC, 3.0F);
      if ((i != -1) && (j != -1))
      {
        this.ZF = b.q(-1, i);
        this.ZE = b.q(-1, j);
        this.ZD = true;
      }
    }
    else
    {
      return;
    }
    int m = b.d(-16777216, this.ZC, 4.5F);
    int k = b.d(-16777216, this.ZC, 3.0F);
    if ((m != -1) && (k != -1))
    {
      this.ZF = b.q(-16777216, m);
      this.ZE = b.q(-16777216, k);
      this.ZD = true;
      return;
    }
    if (i != -1)
    {
      i = b.q(-1, i);
      this.ZF = i;
      if (j == -1) {
        break label175;
      }
    }
    label175:
    for (int i = b.q(-1, j);; i = b.q(-16777216, k))
    {
      this.ZE = i;
      this.ZD = true;
      return;
      i = b.q(-16777216, m);
      break;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (d)paramObject;
    } while ((this.Ze == paramObject.Ze) && (this.ZC == paramObject.ZC));
    return false;
  }
  
  public final float[] gN()
  {
    if (this.ZG == null) {
      this.ZG = new float[3];
    }
    b.a(this.Zz, this.ZA, this.ZB, this.ZG);
    return this.ZG;
  }
  
  public final int gO()
  {
    gP();
    return this.ZF;
  }
  
  public final int hashCode()
  {
    return this.ZC * 31 + this.Ze;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.ZC)).append(']').append(" [HSL: ").append(Arrays.toString(gN())).append(']').append(" [Population: ").append(this.Ze).append(']').append(" [Title Text: #");
    gP();
    return Integer.toHexString(this.ZE) + ']' + " [Body Text: #" + Integer.toHexString(gO()) + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.d.b.d
 * JD-Core Version:    0.7.0.1
 */