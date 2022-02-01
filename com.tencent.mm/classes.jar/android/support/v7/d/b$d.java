package android.support.v7.d;

import android.graphics.Color;
import android.support.v4.graphics.b;
import java.util.Arrays;

public final class b$d
{
  private final int YE;
  private final int YF;
  private final int YG;
  public final int YH;
  private boolean YI;
  private int YJ;
  private int YK;
  private float[] YL;
  final int Yj;
  
  public b$d(int paramInt1, int paramInt2)
  {
    this.YE = Color.red(paramInt1);
    this.YF = Color.green(paramInt1);
    this.YG = Color.blue(paramInt1);
    this.YH = paramInt1;
    this.Yj = paramInt2;
  }
  
  private void gH()
  {
    int j;
    if (!this.YI)
    {
      i = b.d(-1, this.YH, 4.5F);
      j = b.d(-1, this.YH, 3.0F);
      if ((i != -1) && (j != -1))
      {
        this.YK = b.q(-1, i);
        this.YJ = b.q(-1, j);
        this.YI = true;
      }
    }
    else
    {
      return;
    }
    int m = b.d(-16777216, this.YH, 4.5F);
    int k = b.d(-16777216, this.YH, 3.0F);
    if ((m != -1) && (k != -1))
    {
      this.YK = b.q(-16777216, m);
      this.YJ = b.q(-16777216, k);
      this.YI = true;
      return;
    }
    if (i != -1)
    {
      i = b.q(-1, i);
      this.YK = i;
      if (j == -1) {
        break label175;
      }
    }
    label175:
    for (int i = b.q(-1, j);; i = b.q(-16777216, k))
    {
      this.YJ = i;
      this.YI = true;
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
    } while ((this.Yj == paramObject.Yj) && (this.YH == paramObject.YH));
    return false;
  }
  
  public final float[] gF()
  {
    if (this.YL == null) {
      this.YL = new float[3];
    }
    b.a(this.YE, this.YF, this.YG, this.YL);
    return this.YL;
  }
  
  public final int gG()
  {
    gH();
    return this.YK;
  }
  
  public final int hashCode()
  {
    return this.YH * 31 + this.Yj;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.YH)).append(']').append(" [HSL: ").append(Arrays.toString(gF())).append(']').append(" [Population: ").append(this.Yj).append(']').append(" [Title Text: #");
    gH();
    return Integer.toHexString(this.YJ) + ']' + " [Body Text: #" + Integer.toHexString(gG()) + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.d.b.d
 * JD-Core Version:    0.7.0.1
 */