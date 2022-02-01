package androidx.j.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b
{
  static final b bTe;
  public final List<b.d> bSZ;
  private final List<c> bTa;
  private final Map<c, b.d> bTb;
  private final SparseBooleanArray bTc;
  public final b.d bTd;
  
  static
  {
    AppMethodBeat.i(192753);
    bTe = new b()
    {
      public final boolean n(float[] paramAnonymousArrayOfFloat)
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
    AppMethodBeat.o(192753);
  }
  
  b(List<b.d> paramList, List<c> paramList1)
  {
    AppMethodBeat.i(192731);
    this.bSZ = paramList;
    this.bTa = paramList1;
    this.bTc = new SparseBooleanArray();
    this.bTb = new androidx.b.a();
    this.bTd = IA();
    AppMethodBeat.o(192731);
  }
  
  private b.d IA()
  {
    AppMethodBeat.i(192743);
    int j = -2147483648;
    Object localObject = null;
    int k = this.bSZ.size();
    int i = 0;
    if (i < k)
    {
      b.d locald = (b.d)this.bSZ.get(i);
      if (locald.bSR <= j) {
        break label77;
      }
      j = locald.bSR;
      localObject = locald;
    }
    label77:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(192743);
      return localObject;
    }
  }
  
  public static a l(Bitmap paramBitmap)
  {
    AppMethodBeat.i(192725);
    paramBitmap = new a(paramBitmap);
    AppMethodBeat.o(192725);
    return paramBitmap;
  }
  
  final void Iz()
  {
    AppMethodBeat.i(192764);
    int m = this.bTa.size();
    int i = 0;
    c localc;
    float f1;
    int j;
    int k;
    float f3;
    float f2;
    Object localObject;
    Map localMap;
    label184:
    b.d locald;
    if (i < m)
    {
      localc = (c)this.bTa.get(i);
      f1 = 0.0F;
      j = 0;
      k = localc.bTB.length;
      while (j < k)
      {
        f3 = localc.bTB[j];
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
        k = localc.bTB.length;
        while (j < k)
        {
          if (localc.bTB[j] > 0.0F)
          {
            localObject = localc.bTB;
            localObject[j] /= f1;
          }
          j += 1;
        }
      }
      localMap = this.bTb;
      f1 = 0.0F;
      localObject = null;
      int n = this.bSZ.size();
      j = 0;
      if (j < n)
      {
        locald = (b.d)this.bSZ.get(j);
        float[] arrayOfFloat = locald.IF();
        if ((arrayOfFloat[1] >= localc.bTz[0]) && (arrayOfFloat[1] <= localc.bTz[2]) && (arrayOfFloat[2] >= localc.bTA[0]) && (arrayOfFloat[2] <= localc.bTA[2]) && (!this.bTc.get(locald.bTp)))
        {
          k = 1;
          label292:
          if (k == 0) {
            break label541;
          }
          arrayOfFloat = locald.IF();
          f2 = 0.0F;
          f3 = 0.0F;
          if (this.bTd == null) {
            break label475;
          }
          k = this.bTd.bSR;
          label324:
          if (localc.bTB[0] > 0.0F) {
            f2 = localc.bTB[0] * (1.0F - Math.abs(arrayOfFloat[1] - localc.bTz[1]));
          }
          if (localc.bTB[1] > 0.0F) {
            f3 = localc.bTB[1] * (1.0F - Math.abs(arrayOfFloat[2] - localc.bTA[1]));
          }
          if (localc.bTB[2] <= 0.0F) {
            break label544;
          }
          f4 = localc.bTB[2];
        }
      }
    }
    label541:
    label544:
    for (float f4 = locald.bSR / k * f4;; f4 = 0.0F)
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
        break label184;
        k = 0;
        break label292;
        label475:
        k = 1;
        break label324;
        if ((localObject != null) && (localc.bTC)) {
          this.bTc.append(((b.d)localObject).bTp, true);
        }
        localMap.put(localc, localObject);
        i += 1;
        break;
        this.bTc.clear();
        AppMethodBeat.o(192764);
        return;
      }
    }
  }
  
  public static final class a
  {
    private final List<b.d> bSZ;
    private final List<c> bTa;
    public int bTf;
    private int bTg;
    private int bTh;
    private final List<b.b> bTi;
    private Rect bTj;
    private final Bitmap mBitmap;
    
    public a(Bitmap paramBitmap)
    {
      AppMethodBeat.i(192703);
      this.bTa = new ArrayList();
      this.bTf = 16;
      this.bTg = 12544;
      this.bTh = -1;
      this.bTi = new ArrayList();
      if ((paramBitmap == null) || (paramBitmap.isRecycled()))
      {
        paramBitmap = new IllegalArgumentException("Bitmap is not valid");
        AppMethodBeat.o(192703);
        throw paramBitmap;
      }
      this.bTi.add(b.bTe);
      this.mBitmap = paramBitmap;
      this.bSZ = null;
      this.bTa.add(c.bTt);
      this.bTa.add(c.bTu);
      this.bTa.add(c.bTv);
      this.bTa.add(c.bTw);
      this.bTa.add(c.bTx);
      this.bTa.add(c.bTy);
      AppMethodBeat.o(192703);
    }
    
    private int[] m(Bitmap paramBitmap)
    {
      int i = 0;
      AppMethodBeat.i(192719);
      int j = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      int[] arrayOfInt = new int[j * k];
      paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
      if (this.bTj == null)
      {
        AppMethodBeat.o(192719);
        return arrayOfInt;
      }
      k = this.bTj.width();
      int m = this.bTj.height();
      paramBitmap = new int[k * m];
      while (i < m)
      {
        System.arraycopy(arrayOfInt, (this.bTj.top + i) * j + this.bTj.left, paramBitmap, i * k, k);
        i += 1;
      }
      AppMethodBeat.o(192719);
      return paramBitmap;
    }
    
    public final a IB()
    {
      AppMethodBeat.i(192742);
      this.bTi.clear();
      AppMethodBeat.o(192742);
      return this;
    }
    
    public final a IC()
    {
      AppMethodBeat.i(192755);
      if (this.bTa != null) {
        this.bTa.clear();
      }
      AppMethodBeat.o(192755);
      return this;
    }
    
    public final b ID()
    {
      AppMethodBeat.i(192771);
      double d2;
      int i;
      double d1;
      label72:
      Object localObject2;
      if (this.mBitmap != null)
      {
        localObject1 = this.mBitmap;
        d2 = -1.0D;
        if (this.bTg > 0)
        {
          i = ((Bitmap)localObject1).getWidth() * ((Bitmap)localObject1).getHeight();
          d1 = d2;
          if (i > this.bTg) {
            d1 = Math.sqrt(this.bTg / i);
          }
          if (d1 > 0.0D) {
            break label333;
          }
          localObject2 = this.bTj;
          if ((localObject1 != this.mBitmap) && (localObject2 != null))
          {
            d1 = ((Bitmap)localObject1).getWidth() / this.mBitmap.getWidth();
            ((Rect)localObject2).left = ((int)Math.floor(((Rect)localObject2).left * d1));
            ((Rect)localObject2).top = ((int)Math.floor(((Rect)localObject2).top * d1));
            ((Rect)localObject2).right = Math.min((int)Math.ceil(((Rect)localObject2).right * d1), ((Bitmap)localObject1).getWidth());
            ((Rect)localObject2).bottom = Math.min((int)Math.ceil(d1 * ((Rect)localObject2).bottom), ((Bitmap)localObject1).getHeight());
          }
          int[] arrayOfInt = m((Bitmap)localObject1);
          i = this.bTf;
          if (!this.bTi.isEmpty()) {
            break label368;
          }
          localObject2 = null;
          label221:
          localObject2 = new a(arrayOfInt, i, (b.b[])localObject2);
          if (localObject1 != this.mBitmap) {
            ((Bitmap)localObject1).recycle();
          }
        }
      }
      for (Object localObject1 = ((a)localObject2).bSK;; localObject1 = this.bSZ)
      {
        localObject1 = new b((List)localObject1, this.bTa);
        ((b)localObject1).Iz();
        AppMethodBeat.o(192771);
        return localObject1;
        d1 = d2;
        if (this.bTh <= 0) {
          break;
        }
        i = Math.max(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        d1 = d2;
        if (i <= this.bTh) {
          break;
        }
        d1 = this.bTh / i;
        break;
        label333:
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)Math.ceil(((Bitmap)localObject1).getWidth() * d1), (int)Math.ceil(d1 * ((Bitmap)localObject1).getHeight()), false);
        break label72;
        label368:
        localObject2 = (b.b[])this.bTi.toArray(new b.b[this.bTi.size()]);
        break label221;
        if (this.bSZ == null) {
          break label413;
        }
      }
      label413:
      localObject1 = new AssertionError();
      AppMethodBeat.o(192771);
      throw ((Throwable)localObject1);
    }
    
    public final AsyncTask<Bitmap, Void, b> a(final b.c paramc)
    {
      AppMethodBeat.i(192779);
      if (paramc == null)
      {
        paramc = new IllegalArgumentException("listener can not be null");
        AppMethodBeat.o(192779);
        throw paramc;
      }
      paramc = new AsyncTask()
      {
        private b IE()
        {
          AppMethodBeat.i(192744);
          try
          {
            b localb = b.a.this.ID();
            AppMethodBeat.o(192744);
            return localb;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(192744);
          }
          return null;
        }
      }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[] { this.mBitmap });
      AppMethodBeat.o(192779);
      return paramc;
    }
    
    public final a fu(int paramInt)
    {
      this.bTg = paramInt;
      this.bTh = -1;
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean n(float[] paramArrayOfFloat);
  }
  
  public static abstract interface c
  {
    public abstract void onGenerated(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.j.a.b
 * JD-Core Version:    0.7.0.1
 */