package android.support.v7.d;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.f.a;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b
{
  static final b.b RP = new b.1();
  public final List<c> RK;
  public final List<c> RL;
  public final Map<c, c> RM;
  public final SparseBooleanArray RN;
  public final c RO;
  
  public b(List<c> paramList, List<c> paramList1)
  {
    this.RK = paramList;
    this.RL = paramList1;
    this.RN = new SparseBooleanArray();
    this.RM = new a();
    this.RO = eD();
  }
  
  public static b.a d(Bitmap paramBitmap)
  {
    return new b.a(paramBitmap);
  }
  
  private c eD()
  {
    int j = -2147483648;
    Object localObject = null;
    int k = this.RK.size();
    int i = 0;
    if (i < k)
    {
      c localc = (c)this.RK.get(i);
      if (localc.RC <= j) {
        break label67;
      }
      j = localc.RC;
      localObject = localc;
    }
    label67:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public static final class c
  {
    public final int RC;
    private final int RU;
    private final int RV;
    private final int RW;
    public final int RX;
    private boolean RY;
    private int RZ;
    private int Sa;
    private float[] Sb;
    
    public c(int paramInt1, int paramInt2)
    {
      this.RU = Color.red(paramInt1);
      this.RV = Color.green(paramInt1);
      this.RW = Color.blue(paramInt1);
      this.RX = paramInt1;
      this.RC = paramInt2;
    }
    
    private void eG()
    {
      int j;
      if (!this.RY)
      {
        i = android.support.v4.a.b.c(-1, this.RX, 4.5F);
        j = android.support.v4.a.b.c(-1, this.RX, 3.0F);
        if ((i != -1) && (j != -1))
        {
          this.Sa = android.support.v4.a.b.p(-1, i);
          this.RZ = android.support.v4.a.b.p(-1, j);
          this.RY = true;
        }
      }
      else
      {
        return;
      }
      int m = android.support.v4.a.b.c(-16777216, this.RX, 4.5F);
      int k = android.support.v4.a.b.c(-16777216, this.RX, 3.0F);
      if ((m != -1) && (k != -1))
      {
        this.Sa = android.support.v4.a.b.p(-16777216, m);
        this.RZ = android.support.v4.a.b.p(-16777216, k);
        this.RY = true;
        return;
      }
      if (i != -1)
      {
        i = android.support.v4.a.b.p(-1, i);
        this.Sa = i;
        if (j == -1) {
          break label175;
        }
      }
      label175:
      for (int i = android.support.v4.a.b.p(-1, j);; i = android.support.v4.a.b.p(-16777216, k))
      {
        this.RZ = i;
        this.RY = true;
        return;
        i = android.support.v4.a.b.p(-16777216, m);
        break;
      }
    }
    
    public final float[] eE()
    {
      if (this.Sb == null) {
        this.Sb = new float[3];
      }
      android.support.v4.a.b.a(this.RU, this.RV, this.RW, this.Sb);
      return this.Sb;
    }
    
    public final int eF()
    {
      eG();
      return this.Sa;
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
        paramObject = (c)paramObject;
      } while ((this.RC == paramObject.RC) && (this.RX == paramObject.RX));
      return false;
    }
    
    public final int hashCode()
    {
      return this.RX * 31 + this.RC;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.RX)).append(']').append(" [HSL: ").append(Arrays.toString(eE())).append(']').append(" [Population: ").append(this.RC).append(']').append(" [Title Text: #");
      eG();
      return Integer.toHexString(this.RZ) + ']' + " [Body Text: #" + Integer.toHexString(eF()) + ']';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.d.b
 * JD-Core Version:    0.7.0.1
 */