package androidx.j.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b
{
  static final b aeZ;
  private final List<d> aeU;
  private final List<c> aeV;
  private final Map<c, d> aeW;
  private final SparseBooleanArray aeX;
  public final d aeY;
  
  static
  {
    AppMethodBeat.i(243017);
    aeZ = new b()
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
    AppMethodBeat.o(243017);
  }
  
  b(List<d> paramList, List<c> paramList1)
  {
    AppMethodBeat.i(243010);
    this.aeU = paramList;
    this.aeV = paramList1;
    this.aeX = new SparseBooleanArray();
    this.aeW = new androidx.b.a();
    this.aeY = jV();
    AppMethodBeat.o(243010);
  }
  
  public static a e(Bitmap paramBitmap)
  {
    AppMethodBeat.i(243008);
    paramBitmap = new a(paramBitmap);
    AppMethodBeat.o(243008);
    return paramBitmap;
  }
  
  private d jV()
  {
    AppMethodBeat.i(243016);
    int j = -2147483648;
    Object localObject = null;
    int k = this.aeU.size();
    int i = 0;
    if (i < k)
    {
      d locald = (d)this.aeU.get(i);
      if (locald.aeM <= j) {
        break label77;
      }
      j = locald.aeM;
      localObject = locald;
    }
    label77:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(243016);
      return localObject;
    }
  }
  
  public final d jT()
  {
    return this.aeY;
  }
  
  final void jU()
  {
    AppMethodBeat.i(243014);
    int m = this.aeV.size();
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
    d locald;
    if (i < m)
    {
      localc = (c)this.aeV.get(i);
      f1 = 0.0F;
      j = 0;
      k = localc.afw.length;
      while (j < k)
      {
        f3 = localc.afw[j];
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
        k = localc.afw.length;
        while (j < k)
        {
          if (localc.afw[j] > 0.0F)
          {
            localObject = localc.afw;
            localObject[j] /= f1;
          }
          j += 1;
        }
      }
      localMap = this.aeW;
      f1 = 0.0F;
      localObject = null;
      int n = this.aeU.size();
      j = 0;
      if (j < n)
      {
        locald = (d)this.aeU.get(j);
        float[] arrayOfFloat = locald.jZ();
        if ((arrayOfFloat[1] >= localc.afu[0]) && (arrayOfFloat[1] <= localc.afu[2]) && (arrayOfFloat[2] >= localc.afv[0]) && (arrayOfFloat[2] <= localc.afv[2]) && (!this.aeX.get(locald.afk)))
        {
          k = 1;
          label292:
          if (k == 0) {
            break label541;
          }
          arrayOfFloat = locald.jZ();
          f2 = 0.0F;
          f3 = 0.0F;
          if (this.aeY == null) {
            break label475;
          }
          k = this.aeY.aeM;
          label324:
          if (localc.afw[0] > 0.0F) {
            f2 = localc.afw[0] * (1.0F - Math.abs(arrayOfFloat[1] - localc.afu[1]));
          }
          if (localc.afw[1] > 0.0F) {
            f3 = localc.afw[1] * (1.0F - Math.abs(arrayOfFloat[2] - localc.afv[1]));
          }
          if (localc.afw[2] <= 0.0F) {
            break label544;
          }
          f4 = localc.afw[2];
        }
      }
    }
    label541:
    label544:
    for (float f4 = locald.aeM / k * f4;; f4 = 0.0F)
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
        if ((localObject != null) && (localc.afx)) {
          this.aeX.append(((d)localObject).afk, true);
        }
        localMap.put(localc, localObject);
        i += 1;
        break;
        this.aeX.clear();
        AppMethodBeat.o(243014);
        return;
      }
    }
  }
  
  public static final class a
  {
    private final List<b.d> aeU;
    private final List<c> aeV;
    private int afa;
    private int afb;
    private int afc;
    private final List<b.b> afd;
    private Rect afe;
    private final Bitmap mBitmap;
    
    public a(Bitmap paramBitmap)
    {
      AppMethodBeat.i(242994);
      this.aeV = new ArrayList();
      this.afa = 16;
      this.afb = 12544;
      this.afc = -1;
      this.afd = new ArrayList();
      if ((paramBitmap == null) || (paramBitmap.isRecycled()))
      {
        paramBitmap = new IllegalArgumentException("Bitmap is not valid");
        AppMethodBeat.o(242994);
        throw paramBitmap;
      }
      this.afd.add(b.aeZ);
      this.mBitmap = paramBitmap;
      this.aeU = null;
      this.aeV.add(c.afo);
      this.aeV.add(c.afp);
      this.aeV.add(c.afq);
      this.aeV.add(c.afr);
      this.aeV.add(c.afs);
      this.aeV.add(c.aft);
      AppMethodBeat.o(242994);
    }
    
    private int[] f(Bitmap paramBitmap)
    {
      int i = 0;
      AppMethodBeat.i(242997);
      int j = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      int[] arrayOfInt = new int[j * k];
      paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
      if (this.afe == null)
      {
        AppMethodBeat.o(242997);
        return arrayOfInt;
      }
      k = this.afe.width();
      int m = this.afe.height();
      paramBitmap = new int[k * m];
      while (i < m)
      {
        System.arraycopy(arrayOfInt, (this.afe.top + i) * j + this.afe.left, paramBitmap, i * k, k);
        i += 1;
      }
      AppMethodBeat.o(242997);
      return paramBitmap;
    }
    
    public final AsyncTask<Bitmap, Void, b> a(final b.c paramc)
    {
      AppMethodBeat.i(242996);
      paramc = new AsyncTask()
      {
        private b jX()
        {
          AppMethodBeat.i(242991);
          try
          {
            b localb = b.a.this.jW();
            AppMethodBeat.o(242991);
            return localb;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(242991);
          }
          return null;
        }
      }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[] { this.mBitmap });
      AppMethodBeat.o(242996);
      return paramc;
    }
    
    public final b jW()
    {
      AppMethodBeat.i(242995);
      double d2;
      int i;
      double d1;
      label72:
      Object localObject2;
      if (this.mBitmap != null)
      {
        localObject1 = this.mBitmap;
        d2 = -1.0D;
        if (this.afb > 0)
        {
          i = ((Bitmap)localObject1).getWidth() * ((Bitmap)localObject1).getHeight();
          d1 = d2;
          if (i > this.afb) {
            d1 = Math.sqrt(this.afb / i);
          }
          if (d1 > 0.0D) {
            break label333;
          }
          localObject2 = this.afe;
          if ((localObject1 != this.mBitmap) && (localObject2 != null))
          {
            d1 = ((Bitmap)localObject1).getWidth() / this.mBitmap.getWidth();
            ((Rect)localObject2).left = ((int)Math.floor(((Rect)localObject2).left * d1));
            ((Rect)localObject2).top = ((int)Math.floor(((Rect)localObject2).top * d1));
            ((Rect)localObject2).right = Math.min((int)Math.ceil(((Rect)localObject2).right * d1), ((Bitmap)localObject1).getWidth());
            ((Rect)localObject2).bottom = Math.min((int)Math.ceil(d1 * ((Rect)localObject2).bottom), ((Bitmap)localObject1).getHeight());
          }
          int[] arrayOfInt = f((Bitmap)localObject1);
          i = this.afa;
          if (!this.afd.isEmpty()) {
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
      for (Object localObject1 = ((a)localObject2).aeF;; localObject1 = this.aeU)
      {
        localObject1 = new b((List)localObject1, this.aeV);
        ((b)localObject1).jU();
        AppMethodBeat.o(242995);
        return localObject1;
        d1 = d2;
        if (this.afc <= 0) {
          break;
        }
        i = Math.max(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        d1 = d2;
        if (i <= this.afc) {
          break;
        }
        d1 = this.afc / i;
        break;
        label333:
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)Math.ceil(((Bitmap)localObject1).getWidth() * d1), (int)Math.ceil(d1 * ((Bitmap)localObject1).getHeight()), false);
        break label72;
        label368:
        localObject2 = (b.b[])this.afd.toArray(new b.b[this.afd.size()]);
        break label221;
        if (this.aeU == null) {
          break label413;
        }
      }
      label413:
      localObject1 = new AssertionError();
      AppMethodBeat.o(242995);
      throw ((Throwable)localObject1);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean e(float[] paramArrayOfFloat);
  }
  
  public static final class d
  {
    final int aeM;
    private final int afh;
    private final int afi;
    private final int afj;
    public final int afk;
    private boolean afl;
    private int afm;
    private float[] afn;
    private int wW;
    
    public d(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242998);
      this.afh = Color.red(paramInt1);
      this.afi = Color.green(paramInt1);
      this.afj = Color.blue(paramInt1);
      this.afk = paramInt1;
      this.aeM = paramInt2;
      AppMethodBeat.o(242998);
    }
    
    private void kb()
    {
      AppMethodBeat.i(243002);
      int j;
      int m;
      int k;
      if (!this.afl)
      {
        i = androidx.core.graphics.b.b(-1, this.afk, 4.5F);
        j = androidx.core.graphics.b.b(-1, this.afk, 3.0F);
        if ((i != -1) && (j != -1))
        {
          this.afm = androidx.core.graphics.b.C(-1, i);
          this.wW = androidx.core.graphics.b.C(-1, j);
          this.afl = true;
          AppMethodBeat.o(243002);
          return;
        }
        m = androidx.core.graphics.b.b(-16777216, this.afk, 4.5F);
        k = androidx.core.graphics.b.b(-16777216, this.afk, 3.0F);
        if ((m != -1) && (k != -1))
        {
          this.afm = androidx.core.graphics.b.C(-16777216, m);
          this.wW = androidx.core.graphics.b.C(-16777216, k);
          this.afl = true;
          AppMethodBeat.o(243002);
          return;
        }
        if (i == -1) {
          break label184;
        }
        i = androidx.core.graphics.b.C(-1, i);
        this.afm = i;
        if (j == -1) {
          break label195;
        }
      }
      label184:
      label195:
      for (int i = androidx.core.graphics.b.C(-1, j);; i = androidx.core.graphics.b.C(-16777216, k))
      {
        this.wW = i;
        this.afl = true;
        AppMethodBeat.o(243002);
        return;
        i = androidx.core.graphics.b.C(-16777216, m);
        break;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(243004);
      if (this == paramObject)
      {
        AppMethodBeat.o(243004);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(243004);
        return false;
      }
      paramObject = (d)paramObject;
      if ((this.aeM == paramObject.aeM) && (this.afk == paramObject.afk))
      {
        AppMethodBeat.o(243004);
        return true;
      }
      AppMethodBeat.o(243004);
      return false;
    }
    
    public final int hashCode()
    {
      return this.afk * 31 + this.aeM;
    }
    
    public final int jY()
    {
      return this.afk;
    }
    
    public final float[] jZ()
    {
      AppMethodBeat.i(242999);
      if (this.afn == null) {
        this.afn = new float[3];
      }
      androidx.core.graphics.b.a(this.afh, this.afi, this.afj, this.afn);
      float[] arrayOfFloat = this.afn;
      AppMethodBeat.o(242999);
      return arrayOfFloat;
    }
    
    public final int ka()
    {
      AppMethodBeat.i(243000);
      kb();
      int i = this.afm;
      AppMethodBeat.o(243000);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(243003);
      Object localObject = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.afk)).append(']').append(" [HSL: ").append(Arrays.toString(jZ())).append(']').append(" [Population: ").append(this.aeM).append(']').append(" [Title Text: #");
      kb();
      localObject = Integer.toHexString(this.wW) + ']' + " [Body Text: #" + Integer.toHexString(ka()) + ']';
      AppMethodBeat.o(243003);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.j.a.b
 * JD-Core Version:    0.7.0.1
 */