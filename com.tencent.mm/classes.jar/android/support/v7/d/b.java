package android.support.v7.d;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b
{
  static final b abg = new b()
  {
    public final boolean e(float[] paramAnonymousArrayOfFloat)
    {
      if (paramAnonymousArrayOfFloat[2] >= 0.95F)
      {
        i = 1;
        if (i != 0) {
          break label80;
        }
        if (paramAnonymousArrayOfFloat[2] > 0.05F) {
          break label70;
        }
        i = 1;
        label26:
        if (i != 0) {
          break label80;
        }
        if ((paramAnonymousArrayOfFloat[0] < 10.0F) || (paramAnonymousArrayOfFloat[0] > 37.0F) || (paramAnonymousArrayOfFloat[1] > 0.82F)) {
          break label75;
        }
      }
      label70:
      label75:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label80;
        }
        return true;
        i = 0;
        break;
        i = 0;
        break label26;
      }
      label80:
      return false;
    }
  };
  private final List<d> abb;
  private final List<c> abc;
  private final Map<c, d> abd;
  private final SparseBooleanArray abe;
  public final d abf;
  
  b(List<d> paramList, List<c> paramList1)
  {
    this.abb = paramList;
    this.abc = paramList1;
    this.abe = new SparseBooleanArray();
    this.abd = new android.support.v4.e.a();
    this.abf = hb();
  }
  
  public static a d(Bitmap paramBitmap)
  {
    return new a(paramBitmap);
  }
  
  private d hb()
  {
    int j = -2147483648;
    Object localObject = null;
    int k = this.abb.size();
    int i = 0;
    if (i < k)
    {
      d locald = (d)this.abb.get(i);
      if (locald.aaT <= j) {
        break label67;
      }
      j = locald.aaT;
      localObject = locald;
    }
    label67:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  final void ha()
  {
    int m = this.abc.size();
    int i = 0;
    c localc;
    float f1;
    int j;
    int k;
    float f3;
    float f2;
    Object localObject;
    Map localMap;
    label179:
    d locald;
    if (i < m)
    {
      localc = (c)this.abc.get(i);
      f1 = 0.0F;
      j = 0;
      k = localc.abF.length;
      while (j < k)
      {
        f3 = localc.abF[j];
        f2 = f1;
        if (f3 > 0.0F) {
          f2 = f1 + f3;
        }
        j += 1;
        f1 = f2;
      }
      if (f1 != 0.0F)
      {
        j = 0;
        k = localc.abF.length;
        while (j < k)
        {
          if (localc.abF[j] > 0.0F)
          {
            localObject = localc.abF;
            localObject[j] /= f1;
          }
          j += 1;
        }
      }
      localMap = this.abd;
      f1 = 0.0F;
      localObject = null;
      int n = this.abb.size();
      j = 0;
      if (j < n)
      {
        locald = (d)this.abb.get(j);
        float[] arrayOfFloat = locald.he();
        if ((arrayOfFloat[1] >= localc.abD[0]) && (arrayOfFloat[1] <= localc.abD[2]) && (arrayOfFloat[2] >= localc.abE[0]) && (arrayOfFloat[2] <= localc.abE[2]) && (!this.abe.get(locald.abs)))
        {
          k = 1;
          label287:
          if (k == 0) {
            break label531;
          }
          arrayOfFloat = locald.he();
          f2 = 0.0F;
          f3 = 0.0F;
          if (this.abf == null) {
            break label470;
          }
          k = this.abf.aaT;
          label319:
          if (localc.abF[0] > 0.0F) {
            f2 = localc.abF[0] * (1.0F - Math.abs(arrayOfFloat[1] - localc.abD[1]));
          }
          if (localc.abF[1] > 0.0F) {
            f3 = localc.abF[1] * (1.0F - Math.abs(arrayOfFloat[2] - localc.abE[1]));
          }
          if (localc.abF[2] <= 0.0F) {
            break label534;
          }
          f4 = localc.abF[2];
        }
      }
    }
    label531:
    label534:
    for (float f4 = locald.aaT / k * f4;; f4 = 0.0F)
    {
      f2 = f4 + (f2 + f3);
      if ((localObject == null) || (f2 > f1))
      {
        f1 = f2;
        localObject = locald;
      }
      for (;;)
      {
        j += 1;
        break label179;
        k = 0;
        break label287;
        label470:
        k = 1;
        break label319;
        if ((localObject != null) && (localc.abG)) {
          this.abe.append(((d)localObject).abs, true);
        }
        localMap.put(localc, localObject);
        i += 1;
        break;
        this.abe.clear();
        return;
      }
    }
  }
  
  public static final class a
  {
    private final List<b.d> abb;
    private final List<c> abc = new ArrayList();
    private int abh = 16;
    private int abj = 12544;
    private int abk = -1;
    private final List<b.b> abl = new ArrayList();
    private Rect abm;
    public final Bitmap mBitmap;
    
    public a(Bitmap paramBitmap)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        throw new IllegalArgumentException("Bitmap is not valid");
      }
      this.abl.add(b.abg);
      this.mBitmap = paramBitmap;
      this.abb = null;
      this.abc.add(c.abx);
      this.abc.add(c.aby);
      this.abc.add(c.abz);
      this.abc.add(c.abA);
      this.abc.add(c.abB);
      this.abc.add(c.abC);
    }
    
    private int[] e(Bitmap paramBitmap)
    {
      int i = 0;
      int j = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      int[] arrayOfInt = new int[j * k];
      paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
      if (this.abm == null) {
        return arrayOfInt;
      }
      k = this.abm.width();
      int m = this.abm.height();
      paramBitmap = new int[k * m];
      while (i < m)
      {
        System.arraycopy(arrayOfInt, (this.abm.top + i) * j + this.abm.left, paramBitmap, i * k, k);
        i += 1;
      }
      return paramBitmap;
    }
    
    public final b hc()
    {
      double d2;
      int i;
      double d1;
      label67:
      Object localObject2;
      if (this.mBitmap != null)
      {
        localObject1 = this.mBitmap;
        d2 = -1.0D;
        if (this.abj > 0)
        {
          i = ((Bitmap)localObject1).getWidth() * ((Bitmap)localObject1).getHeight();
          d1 = d2;
          if (i > this.abj) {
            d1 = Math.sqrt(this.abj / i);
          }
          if (d1 > 0.0D) {
            break label323;
          }
          localObject2 = this.abm;
          if ((localObject1 != this.mBitmap) && (localObject2 != null))
          {
            d1 = ((Bitmap)localObject1).getWidth() / this.mBitmap.getWidth();
            ((Rect)localObject2).left = ((int)Math.floor(((Rect)localObject2).left * d1));
            ((Rect)localObject2).top = ((int)Math.floor(((Rect)localObject2).top * d1));
            ((Rect)localObject2).right = Math.min((int)Math.ceil(((Rect)localObject2).right * d1), ((Bitmap)localObject1).getWidth());
            ((Rect)localObject2).bottom = Math.min((int)Math.ceil(d1 * ((Rect)localObject2).bottom), ((Bitmap)localObject1).getHeight());
          }
          int[] arrayOfInt = e((Bitmap)localObject1);
          i = this.abh;
          if (!this.abl.isEmpty()) {
            break label358;
          }
          localObject2 = null;
          label216:
          localObject2 = new a(arrayOfInt, i, (b.b[])localObject2);
          if (localObject1 != this.mBitmap) {
            ((Bitmap)localObject1).recycle();
          }
        }
      }
      for (Object localObject1 = ((a)localObject2).aaM;; localObject1 = this.abb)
      {
        localObject1 = new b((List)localObject1, this.abc);
        ((b)localObject1).ha();
        return localObject1;
        d1 = d2;
        if (this.abk <= 0) {
          break;
        }
        i = Math.max(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        d1 = d2;
        if (i <= this.abk) {
          break;
        }
        d1 = this.abk / i;
        break;
        label323:
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)Math.ceil(((Bitmap)localObject1).getWidth() * d1), (int)Math.ceil(d1 * ((Bitmap)localObject1).getHeight()), false);
        break label67;
        label358:
        localObject2 = (b.b[])this.abl.toArray(new b.b[this.abl.size()]);
        break label216;
        if (this.abb == null) {
          break label403;
        }
      }
      label403:
      throw new AssertionError();
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean e(float[] paramArrayOfFloat);
  }
  
  public static abstract interface c
  {
    public abstract void a(b paramb);
  }
  
  public static final class d
  {
    final int aaT;
    private final int abp;
    private final int abq;
    private final int abr;
    public final int abs;
    private boolean abt;
    private int abu;
    private int abv;
    private float[] abw;
    
    public d(int paramInt1, int paramInt2)
    {
      this.abp = Color.red(paramInt1);
      this.abq = Color.green(paramInt1);
      this.abr = Color.blue(paramInt1);
      this.abs = paramInt1;
      this.aaT = paramInt2;
    }
    
    private void hg()
    {
      int j;
      if (!this.abt)
      {
        i = android.support.v4.graphics.b.d(-1, this.abs, 4.5F);
        j = android.support.v4.graphics.b.d(-1, this.abs, 3.0F);
        if ((i != -1) && (j != -1))
        {
          this.abv = android.support.v4.graphics.b.x(-1, i);
          this.abu = android.support.v4.graphics.b.x(-1, j);
          this.abt = true;
        }
      }
      else
      {
        return;
      }
      int m = android.support.v4.graphics.b.d(-16777216, this.abs, 4.5F);
      int k = android.support.v4.graphics.b.d(-16777216, this.abs, 3.0F);
      if ((m != -1) && (k != -1))
      {
        this.abv = android.support.v4.graphics.b.x(-16777216, m);
        this.abu = android.support.v4.graphics.b.x(-16777216, k);
        this.abt = true;
        return;
      }
      if (i != -1)
      {
        i = android.support.v4.graphics.b.x(-1, i);
        this.abv = i;
        if (j == -1) {
          break label175;
        }
      }
      label175:
      for (int i = android.support.v4.graphics.b.x(-1, j);; i = android.support.v4.graphics.b.x(-16777216, k))
      {
        this.abu = i;
        this.abt = true;
        return;
        i = android.support.v4.graphics.b.x(-16777216, m);
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
      } while ((this.aaT == paramObject.aaT) && (this.abs == paramObject.abs));
      return false;
    }
    
    public final int hashCode()
    {
      return this.abs * 31 + this.aaT;
    }
    
    public final float[] he()
    {
      if (this.abw == null) {
        this.abw = new float[3];
      }
      android.support.v4.graphics.b.a(this.abp, this.abq, this.abr, this.abw);
      return this.abw;
    }
    
    public final int hf()
    {
      hg();
      return this.abv;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.abs)).append(']').append(" [HSL: ").append(Arrays.toString(he())).append(']').append(" [Population: ").append(this.aaT).append(']').append(" [Title Text: #");
      hg();
      return Integer.toHexString(this.abu) + ']' + " [Body Text: #" + Integer.toHexString(hf()) + ']';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.d.b
 * JD-Core Version:    0.7.0.1
 */