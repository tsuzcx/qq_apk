package android.support.v7.d;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.e.a;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b
{
  static final b Rw = new b.1();
  public final List<c> Rr;
  public final List<c> Rs;
  public final Map<c, c> Rt;
  public final SparseBooleanArray Ru;
  public final c Rv;
  
  public b(List<c> paramList, List<c> paramList1)
  {
    this.Rr = paramList;
    this.Rs = paramList1;
    this.Ru = new SparseBooleanArray();
    this.Rt = new a();
    this.Rv = fi();
  }
  
  public static b.a e(Bitmap paramBitmap)
  {
    return new b.a(paramBitmap);
  }
  
  private c fi()
  {
    int j = -2147483648;
    Object localObject = null;
    int k = this.Rr.size();
    int i = 0;
    if (i < k)
    {
      c localc = (c)this.Rr.get(i);
      if (localc.Rj <= j) {
        break label67;
      }
      j = localc.Rj;
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
  
  public static abstract interface b
  {
    public abstract boolean d(float[] paramArrayOfFloat);
  }
  
  public static final class c
  {
    private final int RB;
    private final int RC;
    private final int RD;
    public final int RE;
    private boolean RF;
    private int RG;
    private int RH;
    private float[] RI;
    public final int Rj;
    
    public c(int paramInt1, int paramInt2)
    {
      this.RB = Color.red(paramInt1);
      this.RC = Color.green(paramInt1);
      this.RD = Color.blue(paramInt1);
      this.RE = paramInt1;
      this.Rj = paramInt2;
    }
    
    private void fl()
    {
      int j;
      if (!this.RF)
      {
        i = android.support.v4.graphics.b.d(-1, this.RE, 4.5F);
        j = android.support.v4.graphics.b.d(-1, this.RE, 3.0F);
        if ((i != -1) && (j != -1))
        {
          this.RH = android.support.v4.graphics.b.p(-1, i);
          this.RG = android.support.v4.graphics.b.p(-1, j);
          this.RF = true;
        }
      }
      else
      {
        return;
      }
      int m = android.support.v4.graphics.b.d(-16777216, this.RE, 4.5F);
      int k = android.support.v4.graphics.b.d(-16777216, this.RE, 3.0F);
      if ((m != -1) && (k != -1))
      {
        this.RH = android.support.v4.graphics.b.p(-16777216, m);
        this.RG = android.support.v4.graphics.b.p(-16777216, k);
        this.RF = true;
        return;
      }
      if (i != -1)
      {
        i = android.support.v4.graphics.b.p(-1, i);
        this.RH = i;
        if (j == -1) {
          break label175;
        }
      }
      label175:
      for (int i = android.support.v4.graphics.b.p(-1, j);; i = android.support.v4.graphics.b.p(-16777216, k))
      {
        this.RG = i;
        this.RF = true;
        return;
        i = android.support.v4.graphics.b.p(-16777216, m);
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
        paramObject = (c)paramObject;
      } while ((this.Rj == paramObject.Rj) && (this.RE == paramObject.RE));
      return false;
    }
    
    public final float[] fj()
    {
      if (this.RI == null) {
        this.RI = new float[3];
      }
      android.support.v4.graphics.b.a(this.RB, this.RC, this.RD, this.RI);
      return this.RI;
    }
    
    public final int fk()
    {
      fl();
      return this.RH;
    }
    
    public final int hashCode()
    {
      return this.RE * 31 + this.Rj;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.RE)).append(']').append(" [HSL: ").append(Arrays.toString(fj())).append(']').append(" [Population: ").append(this.Rj).append(']').append(" [Title Text: #");
      fl();
      return Integer.toHexString(this.RG) + ']' + " [Body Text: #" + Integer.toHexString(fk()) + ']';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.d.b
 * JD-Core Version:    0.7.0.1
 */