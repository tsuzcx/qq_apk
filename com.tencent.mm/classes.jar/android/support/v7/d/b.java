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
  static final b abu = new b()
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
  private final List<d> abp;
  private final List<c> abq;
  private final Map<c, d> abr;
  private final SparseBooleanArray abs;
  public final d abt;
  
  b(List<d> paramList, List<c> paramList1)
  {
    this.abp = paramList;
    this.abq = paramList1;
    this.abs = new SparseBooleanArray();
    this.abr = new android.support.v4.e.a();
    this.abt = hj();
  }
  
  public static a d(Bitmap paramBitmap)
  {
    return new a(paramBitmap);
  }
  
  private d hj()
  {
    int j = -2147483648;
    Object localObject = null;
    int k = this.abp.size();
    int i = 0;
    if (i < k)
    {
      d locald = (d)this.abp.get(i);
      if (locald.abg <= j) {
        break label67;
      }
      j = locald.abg;
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
  
  public final d hh()
  {
    return this.abt;
  }
  
  final void hi()
  {
    int m = this.abq.size();
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
      localc = (c)this.abq.get(i);
      f1 = 0.0F;
      j = 0;
      k = localc.abS.length;
      while (j < k)
      {
        f3 = localc.abS[j];
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
        k = localc.abS.length;
        while (j < k)
        {
          if (localc.abS[j] > 0.0F)
          {
            localObject = localc.abS;
            localObject[j] /= f1;
          }
          j += 1;
        }
      }
      localMap = this.abr;
      f1 = 0.0F;
      localObject = null;
      int n = this.abp.size();
      j = 0;
      if (j < n)
      {
        locald = (d)this.abp.get(j);
        float[] arrayOfFloat = locald.hn();
        if ((arrayOfFloat[1] >= localc.abQ[0]) && (arrayOfFloat[1] <= localc.abQ[2]) && (arrayOfFloat[2] >= localc.abR[0]) && (arrayOfFloat[2] <= localc.abR[2]) && (!this.abs.get(locald.abF)))
        {
          k = 1;
          label287:
          if (k == 0) {
            break label531;
          }
          arrayOfFloat = locald.hn();
          f2 = 0.0F;
          f3 = 0.0F;
          if (this.abt == null) {
            break label470;
          }
          k = this.abt.abg;
          label319:
          if (localc.abS[0] > 0.0F) {
            f2 = localc.abS[0] * (1.0F - Math.abs(arrayOfFloat[1] - localc.abQ[1]));
          }
          if (localc.abS[1] > 0.0F) {
            f3 = localc.abS[1] * (1.0F - Math.abs(arrayOfFloat[2] - localc.abR[1]));
          }
          if (localc.abS[2] <= 0.0F) {
            break label534;
          }
          f4 = localc.abS[2];
        }
      }
    }
    label531:
    label534:
    for (float f4 = locald.abg / k * f4;; f4 = 0.0F)
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
        if ((localObject != null) && (localc.abT)) {
          this.abs.append(((d)localObject).abF, true);
        }
        localMap.put(localc, localObject);
        i += 1;
        break;
        this.abs.clear();
        return;
      }
    }
  }
  
  public static final class a
  {
    private final List<b.d> abp;
    private final List<c> abq = new ArrayList();
    private int abv = 16;
    private int abw = 12544;
    private int abx = -1;
    private final List<b.b> aby = new ArrayList();
    private Rect abz;
    private final Bitmap mBitmap;
    
    public a(Bitmap paramBitmap)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        throw new IllegalArgumentException("Bitmap is not valid");
      }
      this.aby.add(b.abu);
      this.mBitmap = paramBitmap;
      this.abp = null;
      this.abq.add(c.abK);
      this.abq.add(c.abL);
      this.abq.add(c.abM);
      this.abq.add(c.abN);
      this.abq.add(c.abO);
      this.abq.add(c.abP);
    }
    
    private int[] e(Bitmap paramBitmap)
    {
      int i = 0;
      int j = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      int[] arrayOfInt = new int[j * k];
      paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
      if (this.abz == null) {
        return arrayOfInt;
      }
      k = this.abz.width();
      int m = this.abz.height();
      paramBitmap = new int[k * m];
      while (i < m)
      {
        System.arraycopy(arrayOfInt, (this.abz.top + i) * j + this.abz.left, paramBitmap, i * k, k);
        i += 1;
      }
      return paramBitmap;
    }
    
    public final AsyncTask<Bitmap, Void, b> a(final b.c paramc)
    {
      new AsyncTask()
      {
        private b hl()
        {
          try
          {
            b localb = b.a.this.hk();
            return localb;
          }
          catch (Exception localException) {}
          return null;
        }
      }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[] { this.mBitmap });
    }
    
    public final b hk()
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
        if (this.abw > 0)
        {
          i = ((Bitmap)localObject1).getWidth() * ((Bitmap)localObject1).getHeight();
          d1 = d2;
          if (i > this.abw) {
            d1 = Math.sqrt(this.abw / i);
          }
          if (d1 > 0.0D) {
            break label323;
          }
          localObject2 = this.abz;
          if ((localObject1 != this.mBitmap) && (localObject2 != null))
          {
            d1 = ((Bitmap)localObject1).getWidth() / this.mBitmap.getWidth();
            ((Rect)localObject2).left = ((int)Math.floor(((Rect)localObject2).left * d1));
            ((Rect)localObject2).top = ((int)Math.floor(((Rect)localObject2).top * d1));
            ((Rect)localObject2).right = Math.min((int)Math.ceil(((Rect)localObject2).right * d1), ((Bitmap)localObject1).getWidth());
            ((Rect)localObject2).bottom = Math.min((int)Math.ceil(d1 * ((Rect)localObject2).bottom), ((Bitmap)localObject1).getHeight());
          }
          int[] arrayOfInt = e((Bitmap)localObject1);
          i = this.abv;
          if (!this.aby.isEmpty()) {
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
      for (Object localObject1 = ((a)localObject2).aaZ;; localObject1 = this.abp)
      {
        localObject1 = new b((List)localObject1, this.abq);
        ((b)localObject1).hi();
        return localObject1;
        d1 = d2;
        if (this.abx <= 0) {
          break;
        }
        i = Math.max(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        d1 = d2;
        if (i <= this.abx) {
          break;
        }
        d1 = this.abx / i;
        break;
        label323:
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)Math.ceil(((Bitmap)localObject1).getWidth() * d1), (int)Math.ceil(d1 * ((Bitmap)localObject1).getHeight()), false);
        break label67;
        label358:
        localObject2 = (b.b[])this.aby.toArray(new b.b[this.aby.size()]);
        break label216;
        if (this.abp == null) {
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
    private final int abC;
    private final int abD;
    private final int abE;
    public final int abF;
    private boolean abG;
    private int abH;
    private int abI;
    private float[] abJ;
    final int abg;
    
    public d(int paramInt1, int paramInt2)
    {
      this.abC = Color.red(paramInt1);
      this.abD = Color.green(paramInt1);
      this.abE = Color.blue(paramInt1);
      this.abF = paramInt1;
      this.abg = paramInt2;
    }
    
    private void hp()
    {
      int j;
      if (!this.abG)
      {
        i = android.support.v4.graphics.b.d(-1, this.abF, 4.5F);
        j = android.support.v4.graphics.b.d(-1, this.abF, 3.0F);
        if ((i != -1) && (j != -1))
        {
          this.abI = android.support.v4.graphics.b.x(-1, i);
          this.abH = android.support.v4.graphics.b.x(-1, j);
          this.abG = true;
        }
      }
      else
      {
        return;
      }
      int m = android.support.v4.graphics.b.d(-16777216, this.abF, 4.5F);
      int k = android.support.v4.graphics.b.d(-16777216, this.abF, 3.0F);
      if ((m != -1) && (k != -1))
      {
        this.abI = android.support.v4.graphics.b.x(-16777216, m);
        this.abH = android.support.v4.graphics.b.x(-16777216, k);
        this.abG = true;
        return;
      }
      if (i != -1)
      {
        i = android.support.v4.graphics.b.x(-1, i);
        this.abI = i;
        if (j == -1) {
          break label175;
        }
      }
      label175:
      for (int i = android.support.v4.graphics.b.x(-1, j);; i = android.support.v4.graphics.b.x(-16777216, k))
      {
        this.abH = i;
        this.abG = true;
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
      } while ((this.abg == paramObject.abg) && (this.abF == paramObject.abF));
      return false;
    }
    
    public final int hashCode()
    {
      return this.abF * 31 + this.abg;
    }
    
    public final int hm()
    {
      return this.abF;
    }
    
    public final float[] hn()
    {
      if (this.abJ == null) {
        this.abJ = new float[3];
      }
      android.support.v4.graphics.b.a(this.abC, this.abD, this.abE, this.abJ);
      return this.abJ;
    }
    
    public final int ho()
    {
      hp();
      return this.abI;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.abF)).append(']').append(" [HSL: ").append(Arrays.toString(hn())).append(']').append(" [Population: ").append(this.abg).append(']').append(" [Title Text: #");
      hp();
      return Integer.toHexString(this.abH) + ']' + " [Body Text: #" + Integer.toHexString(ho()) + ']';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.d.b
 * JD-Core Version:    0.7.0.1
 */