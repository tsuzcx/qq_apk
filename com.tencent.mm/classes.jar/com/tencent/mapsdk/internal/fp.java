package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class fp
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 9;
  public static final int f = -1;
  public static final float g = 200.0F;
  public static final float h = 60.0F;
  public static final String i = "color_texture_flat_style.png";
  public static final String j = "color_point_texture.png";
  public static final String k = "color_texture_line_v2.png";
  public float A;
  public boolean B;
  public int C;
  public boolean D;
  public boolean E;
  public Rect F;
  public int G;
  public String H;
  public float I;
  public int J;
  public int K;
  public List<Integer> L;
  public int M;
  public int N;
  public boolean O;
  public ArrayList<GeoPoint> l;
  public ArrayList<GeoPoint> m;
  public int[] n;
  public int[] o;
  public String[] p;
  public int[] q;
  public int[] r;
  public int[] s;
  public int[] t;
  public float u;
  public boolean v;
  public boolean w;
  public float x;
  public String y;
  public boolean z;
  
  public fp()
  {
    AppMethodBeat.i(222098);
    this.x = 9.0F;
    this.y = "";
    this.z = true;
    this.A = 1.0F;
    this.B = true;
    this.C = 0;
    this.D = false;
    this.E = false;
    this.F = new Rect();
    this.G = 0;
    this.H = "";
    this.I = -1.0F;
    this.J = -1;
    this.K = -15248742;
    this.L = null;
    this.M = 2;
    this.N = -7829368;
    AppMethodBeat.o(222098);
  }
  
  private fp a(float paramFloat)
  {
    this.A = paramFloat;
    return this;
  }
  
  private fp a(int paramInt)
  {
    this.N = paramInt;
    return this;
  }
  
  private fp a(int paramInt1, int paramInt2)
  {
    this.J = paramInt1;
    this.K = paramInt2;
    return this;
  }
  
  private fp a(String[] paramArrayOfString)
  {
    AppMethodBeat.i(222233);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      kh.b("参数roadNames不能为空!");
      AppMethodBeat.o(222233);
      return this;
    }
    this.p = paramArrayOfString;
    AppMethodBeat.o(222233);
    return this;
  }
  
  @Deprecated
  private void a(String paramString)
  {
    this.y = paramString;
  }
  
  @Deprecated
  private void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  private fp b()
  {
    this.v = true;
    return this;
  }
  
  private fp b(int paramInt)
  {
    this.C = paramInt;
    return this;
  }
  
  private fp b(String paramString)
  {
    this.y = paramString;
    return this;
  }
  
  private fp b(boolean paramBoolean)
  {
    this.w = paramBoolean;
    return this;
  }
  
  @Deprecated
  private void b(float paramFloat)
  {
    this.A = paramFloat;
  }
  
  private int c()
  {
    return this.C;
  }
  
  private fp c(float paramFloat)
  {
    this.x = paramFloat;
    return this;
  }
  
  private fp c(int paramInt)
  {
    this.G = paramInt;
    return this;
  }
  
  private fp c(String paramString)
  {
    this.H = paramString;
    return this;
  }
  
  private fp c(boolean paramBoolean)
  {
    this.B = paramBoolean;
    return this;
  }
  
  private fp c(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(222217);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      kh.b("参数startNums不能为空!");
      AppMethodBeat.o(222217);
      return this;
    }
    this.n = paramArrayOfInt;
    AppMethodBeat.o(222217);
    return this;
  }
  
  private fp d(float paramFloat)
  {
    this.u = paramFloat;
    return this;
  }
  
  private fp d(boolean paramBoolean)
  {
    this.D = paramBoolean;
    return this;
  }
  
  private fp d(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(222227);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      kh.b("参数endNums不能为空!");
      AppMethodBeat.o(222227);
      return this;
    }
    this.o = paramArrayOfInt;
    AppMethodBeat.o(222227);
    return this;
  }
  
  private void d(int paramInt)
  {
    this.M = paramInt;
  }
  
  private int[] d()
  {
    return new int[] { this.J, this.K };
  }
  
  private float e()
  {
    return this.I;
  }
  
  private fp e(float paramFloat)
  {
    this.I = paramFloat;
    return this;
  }
  
  private fp e(boolean paramBoolean)
  {
    this.E = paramBoolean;
    return this;
  }
  
  private int f()
  {
    return this.M;
  }
  
  public final fp a(List<GeoPoint> paramList)
  {
    AppMethodBeat.i(222295);
    if ((paramList == null) || (paramList.size() < 2))
    {
      kh.b("参数points不能小于2!");
      AppMethodBeat.o(222295);
      return this;
    }
    this.m = new ArrayList(paramList.size());
    this.m.addAll(paramList);
    if (this.m.size() < 2)
    {
      kh.b("参数points存在null值");
      AppMethodBeat.o(222295);
      return this;
    }
    this.l = new ArrayList(paramList.size());
    this.l.addAll(this.m);
    AppMethodBeat.o(222295);
    return this;
  }
  
  public final fp a(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(222301);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      kh.b("参数startIndexes不能为空!");
      AppMethodBeat.o(222301);
      return this;
    }
    this.q = paramArrayOfInt;
    AppMethodBeat.o(222301);
    return this;
  }
  
  public final fp a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i2 = 0;
    AppMethodBeat.i(222325);
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0) || (paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0))
    {
      kh.b("参数colors 、borderColors为空，或者两者长度不同");
      AppMethodBeat.o(222325);
      return this;
    }
    if (!this.v)
    {
      this.r = paramArrayOfInt1;
      AppMethodBeat.o(222325);
      return this;
    }
    int[] arrayOfInt = paramArrayOfInt2;
    if (paramArrayOfInt2.length < paramArrayOfInt1.length)
    {
      arrayOfInt = new int[paramArrayOfInt1.length];
      i1 = 0;
      if (i1 < paramArrayOfInt1.length)
      {
        if (i1 < paramArrayOfInt2.length) {
          arrayOfInt[i1] = paramArrayOfInt2[i1];
        }
        for (;;)
        {
          i1 += 1;
          break;
          arrayOfInt[i1] = paramArrayOfInt2[(paramArrayOfInt2.length - 1)];
        }
      }
    }
    paramArrayOfInt2 = new ArrayList();
    this.r = new int[paramArrayOfInt1.length];
    int i1 = 0;
    while (i1 < paramArrayOfInt1.length)
    {
      b localb = new b(paramArrayOfInt1[i1], arrayOfInt[i1]);
      if (!paramArrayOfInt2.contains(localb)) {
        paramArrayOfInt2.add(localb);
      }
      this.r[i1] = paramArrayOfInt2.indexOf(localb);
      i1 += 1;
    }
    int i3 = paramArrayOfInt2.size();
    this.s = new int[i3];
    this.t = new int[i3];
    i1 = i2;
    while (i1 < i3)
    {
      this.s[i1] = ((b)paramArrayOfInt2.get(i1)).b;
      this.t[i1] = ((b)paramArrayOfInt2.get(i1)).a;
      i1 += 1;
    }
    AppMethodBeat.o(222325);
    return this;
  }
  
  public final boolean a()
  {
    AppMethodBeat.i(222349);
    if ((this.m == null) || (this.m.size() < 2))
    {
      kh.b("LineOptions中点的个数不能小于2");
      AppMethodBeat.o(222349);
      return false;
    }
    if ((this.q == null) || (this.q.length <= 0))
    {
      kh.b("参数startIndexes不能为空!");
      AppMethodBeat.o(222349);
      return false;
    }
    if ((this.r == null) || (this.r.length <= 0))
    {
      kh.b("参数colors不能为空!");
      AppMethodBeat.o(222349);
      return false;
    }
    AppMethodBeat.o(222349);
    return true;
  }
  
  public final fp b(List<Integer> paramList)
  {
    AppMethodBeat.i(222339);
    if ((paramList != null) && (paramList.size() % 2 != 0)) {
      paramList.add(paramList.get(paramList.size() - 1));
    }
    this.L = paramList;
    AppMethodBeat.o(222339);
    return this;
  }
  
  public final fp b(int[] paramArrayOfInt)
  {
    int i2 = 0;
    AppMethodBeat.i(222312);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      kh.b("参数colors不能为空!");
      AppMethodBeat.o(222312);
      return this;
    }
    if (!this.v)
    {
      this.r = paramArrayOfInt;
      AppMethodBeat.o(222312);
      return this;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(this.N));
    int i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      if (!localArrayList.contains(Integer.valueOf(paramArrayOfInt[i1]))) {
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i1]));
      }
      paramArrayOfInt[i1] = localArrayList.indexOf(Integer.valueOf(paramArrayOfInt[i1]));
      i1 += 1;
    }
    this.r = paramArrayOfInt;
    int i3 = localArrayList.size();
    this.s = new int[i3];
    i1 = i2;
    while (i1 < i3)
    {
      this.s[i1] = ((Integer)localArrayList.get(i1)).intValue();
      i1 += 1;
    }
    AppMethodBeat.o(222312);
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(222360);
    if (this == paramObject)
    {
      AppMethodBeat.o(222360);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(222360);
      return false;
    }
    paramObject = (fp)paramObject;
    if ((Float.compare(paramObject.u, this.u) == 0) && (this.v == paramObject.v) && (this.w == paramObject.w) && (Float.compare(paramObject.x, this.x) == 0) && (this.z == paramObject.z) && (Float.compare(paramObject.A, this.A) == 0) && (this.B == paramObject.B) && (this.C == paramObject.C) && (this.D == paramObject.D) && (this.E == paramObject.E) && (this.G == paramObject.G) && (Float.compare(paramObject.I, this.I) == 0) && (this.J == paramObject.J) && (this.K == paramObject.K) && (this.M == paramObject.M) && (this.N == paramObject.N) && (this.O == paramObject.O) && (Util.equals(this.l, paramObject.l)) && (Util.equals(this.m, paramObject.m)) && (Arrays.equals(this.n, paramObject.n)) && (Arrays.equals(this.o, paramObject.o)) && (Arrays.equals(this.p, paramObject.p)) && (Arrays.equals(this.q, paramObject.q)) && (Arrays.equals(this.r, paramObject.r)) && (Arrays.equals(this.s, paramObject.s)) && (Arrays.equals(this.t, paramObject.t)) && (Util.equals(this.y, paramObject.y)) && (Util.equals(this.F, paramObject.F)) && (Util.equals(this.H, paramObject.H)) && (Util.equals(this.L, paramObject.L)))
    {
      AppMethodBeat.o(222360);
      return true;
    }
    AppMethodBeat.o(222360);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(222372);
    int i1 = Util.hash(new Object[] { this.l, this.m, Float.valueOf(this.u), Boolean.valueOf(this.v), Boolean.valueOf(this.w), Float.valueOf(this.x), this.y, Boolean.valueOf(this.z), Float.valueOf(this.A), Boolean.valueOf(this.B), Integer.valueOf(this.C), Boolean.valueOf(this.D), Boolean.valueOf(this.E), this.F, Integer.valueOf(this.G), this.H, Float.valueOf(this.I), Integer.valueOf(this.J), Integer.valueOf(this.K), this.L, Integer.valueOf(this.M), Integer.valueOf(this.N), Boolean.valueOf(this.O) });
    int i2 = Arrays.hashCode(this.n);
    int i3 = Arrays.hashCode(this.o);
    int i4 = Arrays.hashCode(this.p);
    int i5 = Arrays.hashCode(this.q);
    int i6 = Arrays.hashCode(this.r);
    int i7 = Arrays.hashCode(this.s);
    int i8 = Arrays.hashCode(this.t);
    AppMethodBeat.o(222372);
    return ((((((i1 * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8;
  }
  
  final class b
  {
    public int a;
    public int b;
    
    public b(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      this.a = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
        paramObject = (b)paramObject;
      } while ((paramObject.a != this.a) || (paramObject.b != this.b));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fp
 * JD-Core Version:    0.7.0.1
 */