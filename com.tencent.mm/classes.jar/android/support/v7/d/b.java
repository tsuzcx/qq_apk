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
  static final b Yw = new b()
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
  private final List<b.d> Yr;
  private final List<c> Ys;
  private final Map<c, b.d> Yt;
  private final SparseBooleanArray Yu;
  public final b.d Yv;
  
  b(List<b.d> paramList, List<c> paramList1)
  {
    this.Yr = paramList;
    this.Ys = paramList1;
    this.Yu = new SparseBooleanArray();
    this.Yt = new android.support.v4.e.a();
    this.Yv = gC();
  }
  
  public static a d(Bitmap paramBitmap)
  {
    return new a(paramBitmap);
  }
  
  private b.d gC()
  {
    int j = -2147483648;
    Object localObject = null;
    int k = this.Yr.size();
    int i = 0;
    if (i < k)
    {
      b.d locald = (b.d)this.Yr.get(i);
      if (locald.Yj <= j) {
        break label67;
      }
      j = locald.Yj;
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
  
  final void gB()
  {
    int m = this.Ys.size();
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
      localc = (c)this.Ys.get(i);
      f1 = 0.0F;
      j = 0;
      k = localc.YU.length;
      while (j < k)
      {
        f3 = localc.YU[j];
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
        k = localc.YU.length;
        while (j < k)
        {
          if (localc.YU[j] > 0.0F)
          {
            localObject = localc.YU;
            localObject[j] /= f1;
          }
          j += 1;
        }
      }
      localMap = this.Yt;
      f1 = 0.0F;
      localObject = null;
      int n = this.Yr.size();
      j = 0;
      if (j < n)
      {
        locald = (b.d)this.Yr.get(j);
        float[] arrayOfFloat = locald.gF();
        if ((arrayOfFloat[1] >= localc.YS[0]) && (arrayOfFloat[1] <= localc.YS[2]) && (arrayOfFloat[2] >= localc.YT[0]) && (arrayOfFloat[2] <= localc.YT[2]) && (!this.Yu.get(locald.YH)))
        {
          k = 1;
          label287:
          if (k == 0) {
            break label531;
          }
          arrayOfFloat = locald.gF();
          f2 = 0.0F;
          f3 = 0.0F;
          if (this.Yv == null) {
            break label470;
          }
          k = this.Yv.Yj;
          label319:
          if (localc.YU[0] > 0.0F) {
            f2 = localc.YU[0] * (1.0F - Math.abs(arrayOfFloat[1] - localc.YS[1]));
          }
          if (localc.YU[1] > 0.0F) {
            f3 = localc.YU[1] * (1.0F - Math.abs(arrayOfFloat[2] - localc.YT[1]));
          }
          if (localc.YU[2] <= 0.0F) {
            break label534;
          }
          f4 = localc.YU[2];
        }
      }
    }
    label531:
    label534:
    for (float f4 = locald.Yj / k * f4;; f4 = 0.0F)
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
        if ((localObject != null) && (localc.YV)) {
          this.Yu.append(((b.d)localObject).YH, true);
        }
        localMap.put(localc, localObject);
        i += 1;
        break;
        this.Yu.clear();
        return;
      }
    }
  }
  
  public static final class a
  {
    private final List<b.b> YA = new ArrayList();
    private Rect YB;
    private final List<b.d> Yr;
    private final List<c> Ys = new ArrayList();
    private int Yx = 16;
    private int Yy = 12544;
    private int Yz = -1;
    public final Bitmap mBitmap;
    
    public a(Bitmap paramBitmap)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        throw new IllegalArgumentException("Bitmap is not valid");
      }
      this.YA.add(b.Yw);
      this.mBitmap = paramBitmap;
      this.Yr = null;
      this.Ys.add(c.YM);
      this.Ys.add(c.YN);
      this.Ys.add(c.YO);
      this.Ys.add(c.YP);
      this.Ys.add(c.YQ);
      this.Ys.add(c.YR);
    }
    
    private int[] e(Bitmap paramBitmap)
    {
      int i = 0;
      int j = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      int[] arrayOfInt = new int[j * k];
      paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
      if (this.YB == null) {
        return arrayOfInt;
      }
      k = this.YB.width();
      int m = this.YB.height();
      paramBitmap = new int[k * m];
      while (i < m)
      {
        System.arraycopy(arrayOfInt, (this.YB.top + i) * j + this.YB.left, paramBitmap, i * k, k);
        i += 1;
      }
      return paramBitmap;
    }
    
    public final b gD()
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
        if (this.Yy > 0)
        {
          i = ((Bitmap)localObject1).getWidth() * ((Bitmap)localObject1).getHeight();
          d1 = d2;
          if (i > this.Yy) {
            d1 = Math.sqrt(this.Yy / i);
          }
          if (d1 > 0.0D) {
            break label323;
          }
          localObject2 = this.YB;
          if ((localObject1 != this.mBitmap) && (localObject2 != null))
          {
            d1 = ((Bitmap)localObject1).getWidth() / this.mBitmap.getWidth();
            ((Rect)localObject2).left = ((int)Math.floor(((Rect)localObject2).left * d1));
            ((Rect)localObject2).top = ((int)Math.floor(((Rect)localObject2).top * d1));
            ((Rect)localObject2).right = Math.min((int)Math.ceil(((Rect)localObject2).right * d1), ((Bitmap)localObject1).getWidth());
            ((Rect)localObject2).bottom = Math.min((int)Math.ceil(d1 * ((Rect)localObject2).bottom), ((Bitmap)localObject1).getHeight());
          }
          int[] arrayOfInt = e((Bitmap)localObject1);
          i = this.Yx;
          if (!this.YA.isEmpty()) {
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
      for (Object localObject1 = ((a)localObject2).Yc;; localObject1 = this.Yr)
      {
        localObject1 = new b((List)localObject1, this.Ys);
        ((b)localObject1).gB();
        return localObject1;
        d1 = d2;
        if (this.Yz <= 0) {
          break;
        }
        i = Math.max(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        d1 = d2;
        if (i <= this.Yz) {
          break;
        }
        d1 = this.Yz / i;
        break;
        label323:
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)Math.ceil(((Bitmap)localObject1).getWidth() * d1), (int)Math.ceil(d1 * ((Bitmap)localObject1).getHeight()), false);
        break label67;
        label358:
        localObject2 = (b.b[])this.YA.toArray(new b.b[this.YA.size()]);
        break label216;
        if (this.Yr == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.d.b
 * JD-Core Version:    0.7.0.1
 */