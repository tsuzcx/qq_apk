package android.support.v7.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b
{
  static final b Zr = new b()
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
  private final List<b.d> Zm;
  private final List<c> Zn;
  private final Map<c, b.d> Zo;
  private final SparseBooleanArray Zp;
  public final b.d Zq;
  
  b(List<b.d> paramList, List<c> paramList1)
  {
    this.Zm = paramList;
    this.Zn = paramList1;
    this.Zp = new SparseBooleanArray();
    this.Zo = new android.support.v4.e.a();
    this.Zq = gK();
  }
  
  public static a d(Bitmap paramBitmap)
  {
    return new a(paramBitmap);
  }
  
  private b.d gK()
  {
    int j = -2147483648;
    Object localObject = null;
    int k = this.Zm.size();
    int i = 0;
    if (i < k)
    {
      b.d locald = (b.d)this.Zm.get(i);
      if (locald.Ze <= j) {
        break label67;
      }
      j = locald.Ze;
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
  
  final void gJ()
  {
    int m = this.Zn.size();
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
    b.d locald;
    if (i < m)
    {
      localc = (c)this.Zn.get(i);
      f1 = 0.0F;
      j = 0;
      k = localc.ZP.length;
      while (j < k)
      {
        f3 = localc.ZP[j];
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
        k = localc.ZP.length;
        while (j < k)
        {
          if (localc.ZP[j] > 0.0F)
          {
            localObject = localc.ZP;
            localObject[j] /= f1;
          }
          j += 1;
        }
      }
      localMap = this.Zo;
      f1 = 0.0F;
      localObject = null;
      int n = this.Zm.size();
      j = 0;
      if (j < n)
      {
        locald = (b.d)this.Zm.get(j);
        float[] arrayOfFloat = locald.gN();
        if ((arrayOfFloat[1] >= localc.ZN[0]) && (arrayOfFloat[1] <= localc.ZN[2]) && (arrayOfFloat[2] >= localc.ZO[0]) && (arrayOfFloat[2] <= localc.ZO[2]) && (!this.Zp.get(locald.ZC)))
        {
          k = 1;
          label287:
          if (k == 0) {
            break label531;
          }
          arrayOfFloat = locald.gN();
          f2 = 0.0F;
          f3 = 0.0F;
          if (this.Zq == null) {
            break label470;
          }
          k = this.Zq.Ze;
          label319:
          if (localc.ZP[0] > 0.0F) {
            f2 = localc.ZP[0] * (1.0F - Math.abs(arrayOfFloat[1] - localc.ZN[1]));
          }
          if (localc.ZP[1] > 0.0F) {
            f3 = localc.ZP[1] * (1.0F - Math.abs(arrayOfFloat[2] - localc.ZO[1]));
          }
          if (localc.ZP[2] <= 0.0F) {
            break label534;
          }
          f4 = localc.ZP[2];
        }
      }
    }
    label531:
    label534:
    for (float f4 = locald.Ze / k * f4;; f4 = 0.0F)
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
        if ((localObject != null) && (localc.ZQ)) {
          this.Zp.append(((b.d)localObject).ZC, true);
        }
        localMap.put(localc, localObject);
        i += 1;
        break;
        this.Zp.clear();
        return;
      }
    }
  }
  
  public static final class a
  {
    private final List<b.d> Zm;
    private final List<c> Zn = new ArrayList();
    private int Zs = 16;
    private int Zt = 12544;
    private int Zu = -1;
    private final List<b.b> Zv = new ArrayList();
    private Rect Zw;
    public final Bitmap mBitmap;
    
    public a(Bitmap paramBitmap)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        throw new IllegalArgumentException("Bitmap is not valid");
      }
      this.Zv.add(b.Zr);
      this.mBitmap = paramBitmap;
      this.Zm = null;
      this.Zn.add(c.ZH);
      this.Zn.add(c.ZI);
      this.Zn.add(c.ZJ);
      this.Zn.add(c.ZK);
      this.Zn.add(c.ZL);
      this.Zn.add(c.ZM);
    }
    
    private int[] e(Bitmap paramBitmap)
    {
      int i = 0;
      int j = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      int[] arrayOfInt = new int[j * k];
      paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
      if (this.Zw == null) {
        return arrayOfInt;
      }
      k = this.Zw.width();
      int m = this.Zw.height();
      paramBitmap = new int[k * m];
      while (i < m)
      {
        System.arraycopy(arrayOfInt, (this.Zw.top + i) * j + this.Zw.left, paramBitmap, i * k, k);
        i += 1;
      }
      return paramBitmap;
    }
    
    public final b gL()
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
        if (this.Zt > 0)
        {
          i = ((Bitmap)localObject1).getWidth() * ((Bitmap)localObject1).getHeight();
          d1 = d2;
          if (i > this.Zt) {
            d1 = Math.sqrt(this.Zt / i);
          }
          if (d1 > 0.0D) {
            break label323;
          }
          localObject2 = this.Zw;
          if ((localObject1 != this.mBitmap) && (localObject2 != null))
          {
            d1 = ((Bitmap)localObject1).getWidth() / this.mBitmap.getWidth();
            ((Rect)localObject2).left = ((int)Math.floor(((Rect)localObject2).left * d1));
            ((Rect)localObject2).top = ((int)Math.floor(((Rect)localObject2).top * d1));
            ((Rect)localObject2).right = Math.min((int)Math.ceil(((Rect)localObject2).right * d1), ((Bitmap)localObject1).getWidth());
            ((Rect)localObject2).bottom = Math.min((int)Math.ceil(d1 * ((Rect)localObject2).bottom), ((Bitmap)localObject1).getHeight());
          }
          int[] arrayOfInt = e((Bitmap)localObject1);
          i = this.Zs;
          if (!this.Zv.isEmpty()) {
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
      for (Object localObject1 = ((a)localObject2).YX;; localObject1 = this.Zm)
      {
        localObject1 = new b((List)localObject1, this.Zn);
        ((b)localObject1).gJ();
        return localObject1;
        d1 = d2;
        if (this.Zu <= 0) {
          break;
        }
        i = Math.max(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        d1 = d2;
        if (i <= this.Zu) {
          break;
        }
        d1 = this.Zu / i;
        break;
        label323:
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)Math.ceil(((Bitmap)localObject1).getWidth() * d1), (int)Math.ceil(d1 * ((Bitmap)localObject1).getHeight()), false);
        break label67;
        label358:
        localObject2 = (b.b[])this.Zv.toArray(new b.b[this.Zv.size()]);
        break label216;
        if (this.Zm == null) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.d.b
 * JD-Core Version:    0.7.0.1
 */