package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable.OnSelectedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class pv
  extends oo
{
  public fp a;
  public int[] m;
  public int[] n;
  public int o;
  public GeoPoint p;
  public int q;
  public a r;
  private bd s;
  private boolean t;
  private Selectable.OnSelectedListener u;
  private float v;
  private int w;
  private mj x;
  private boolean y;
  private ao z;
  
  public pv(ao paramao, az paramaz, fp paramfp)
  {
    super(paramaz);
    AppMethodBeat.i(225667);
    this.t = true;
    this.q = -1;
    this.v = -1.0F;
    this.w = -1;
    this.z = paramao;
    this.x = paramaz.c();
    a(paramfp);
    AppMethodBeat.o(225667);
  }
  
  private boolean A()
  {
    return this.a.w;
  }
  
  private boolean B()
  {
    return this.a.z;
  }
  
  private boolean C()
  {
    return this.a.B;
  }
  
  private int D()
  {
    return this.a.C;
  }
  
  private boolean E()
  {
    return this.a.O;
  }
  
  private float F()
  {
    return this.a.x;
  }
  
  private float G()
  {
    if (this.a == null) {
      return 1.0F;
    }
    return this.a.A;
  }
  
  private a H()
  {
    return this.r;
  }
  
  private String I()
  {
    AppMethodBeat.i(225866);
    if ((this.a.r != null) && (this.a.r.length > 0))
    {
      if (this.a.r[0] == 33)
      {
        AppMethodBeat.o(225866);
        return "color_point_texture.png";
      }
      if (this.a.r[0] == 20)
      {
        AppMethodBeat.o(225866);
        return "color_texture_line_v2.png";
      }
    }
    if (gz.a(this.a.y))
    {
      AppMethodBeat.o(225866);
      return "color_texture_flat_style.png";
    }
    String str = this.a.y;
    AppMethodBeat.o(225866);
    return str;
  }
  
  private int J()
  {
    return this.q;
  }
  
  private boolean K()
  {
    return this.a.D;
  }
  
  private boolean L()
  {
    return this.a.E;
  }
  
  private Rect M()
  {
    AppMethodBeat.i(225922);
    Object localObject = this.a.l;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()) && (this.o >= 0) && (this.o < ((ArrayList)localObject).size()))
    {
      localObject = ((ArrayList)localObject).subList(this.o, ((ArrayList)localObject).size());
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label111;
      }
      localObject = null;
      if (localObject != null) {
        this.a.F = ((Rect)localObject);
      }
    }
    localObject = this.a.F;
    AppMethodBeat.o(225922);
    return localObject;
    label111:
    GeoPoint localGeoPoint = (GeoPoint)((List)localObject).get(0);
    int i2 = localGeoPoint.getLongitudeE6();
    int i1 = localGeoPoint.getLongitudeE6();
    int i6 = localGeoPoint.getLatitudeE6();
    int i = localGeoPoint.getLatitudeE6();
    int i8 = ((List)localObject).size();
    int i5 = 0;
    label163:
    int i4;
    int i3;
    int i7;
    int k;
    int j;
    if (i5 < i8)
    {
      localGeoPoint = (GeoPoint)((List)localObject).get(i5);
      i4 = i1;
      i3 = i2;
      if (localGeoPoint == null) {
        break label309;
      }
      i7 = localGeoPoint.getLatitudeE6();
      i3 = localGeoPoint.getLongitudeE6();
      if (i3 < i2)
      {
        k = i3;
        j = i1;
        label224:
        if (i7 >= i) {
          break label270;
        }
        i = i7;
      }
    }
    for (;;)
    {
      i5 += 1;
      i1 = j;
      i2 = k;
      break label163;
      j = i1;
      k = i2;
      if (i3 <= i1) {
        break label224;
      }
      j = i3;
      k = i2;
      break label224;
      label270:
      i4 = j;
      i3 = k;
      if (i7 > i6)
      {
        i6 = i7;
        continue;
        localObject = new Rect(i2, i6, i1, i);
        break;
      }
      label309:
      j = i4;
      k = i3;
    }
  }
  
  private String N()
  {
    return this.a.H;
  }
  
  private float O()
  {
    return this.a.I;
  }
  
  private int[] P()
  {
    return new int[] { this.a.J, this.a.K };
  }
  
  private List<Integer> Q()
  {
    return this.a.L;
  }
  
  private void a(float paramFloat)
  {
    this.a.x = paramFloat;
  }
  
  private void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225839);
    this.r = new a();
    this.r.a = paramInt1;
    this.r.b = paramInt2;
    q();
    AppMethodBeat.o(225839);
  }
  
  @Deprecated
  private void a(String paramString)
  {
    this.a.y = paramString;
  }
  
  private void a(List<Integer> paramList)
  {
    AppMethodBeat.i(225950);
    this.a.b(paramList);
    AppMethodBeat.o(225950);
  }
  
  private void a(boolean paramBoolean)
  {
    this.a.w = paramBoolean;
  }
  
  private static Rect b(List<GeoPoint> paramList)
  {
    AppMethodBeat.i(225980);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(225980);
      return null;
    }
    GeoPoint localGeoPoint = (GeoPoint)paramList.get(0);
    int i2 = localGeoPoint.getLongitudeE6();
    int i1 = localGeoPoint.getLongitudeE6();
    int i6 = localGeoPoint.getLatitudeE6();
    int i = localGeoPoint.getLatitudeE6();
    int i8 = paramList.size();
    int i5 = 0;
    int i4;
    int i3;
    int i7;
    int k;
    int j;
    if (i5 < i8)
    {
      localGeoPoint = (GeoPoint)paramList.get(i5);
      i4 = i1;
      i3 = i2;
      if (localGeoPoint == null) {
        break label223;
      }
      i7 = localGeoPoint.getLatitudeE6();
      i3 = localGeoPoint.getLongitudeE6();
      if (i3 < i2)
      {
        k = i3;
        j = i1;
        label135:
        if (i7 >= i) {
          break label181;
        }
        i = i7;
      }
    }
    for (;;)
    {
      i5 += 1;
      i1 = j;
      i2 = k;
      break;
      j = i1;
      k = i2;
      if (i3 <= i1) {
        break label135;
      }
      j = i3;
      k = i2;
      break label135;
      label181:
      i4 = j;
      i3 = k;
      if (i7 > i6)
      {
        i6 = i7;
        continue;
        paramList = new Rect(i2, i6, i1, i);
        AppMethodBeat.o(225980);
        return paramList;
      }
      else
      {
        label223:
        j = i4;
        k = i3;
      }
    }
  }
  
  private void b(float paramFloat)
  {
    this.a.u = paramFloat;
  }
  
  private void b(String paramString)
  {
    this.a.y = paramString;
  }
  
  private void b(boolean paramBoolean)
  {
    this.a.E = paramBoolean;
  }
  
  private void c(float paramFloat)
  {
    if ((this.a != null) && (paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {
      this.a.A = paramFloat;
    }
  }
  
  @Deprecated
  private void c(String paramString)
  {
    this.a.y = paramString;
  }
  
  private ArrayList<GeoPoint> e()
  {
    return this.a.m;
  }
  
  private int[] f()
  {
    return this.m;
  }
  
  private int[] g()
  {
    return this.n;
  }
  
  private boolean h()
  {
    return this.a.v;
  }
  
  private int[] i()
  {
    return this.a.s;
  }
  
  private int[] t()
  {
    return this.a.t;
  }
  
  private float u()
  {
    return this.a.u;
  }
  
  private int[] v()
  {
    return this.a.n;
  }
  
  private int[] w()
  {
    return this.a.o;
  }
  
  private String[] x()
  {
    return this.a.p;
  }
  
  private GeoPoint y()
  {
    return this.p;
  }
  
  private int z()
  {
    return this.o;
  }
  
  public final Rect a(ep paramep)
  {
    AppMethodBeat.i(226029);
    Object localObject2 = b(paramep);
    if (localObject2 == null)
    {
      AppMethodBeat.o(226029);
      return null;
    }
    Object localObject1 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).left);
    localObject2 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).right);
    localObject1 = paramep.a((GeoPoint)localObject1);
    paramep = paramep.a((GeoPoint)localObject2);
    paramep = new Rect((int)((fl)localObject1).a, (int)((fl)localObject1).b, (int)paramep.a, (int)paramep.b);
    AppMethodBeat.o(226029);
    return paramep;
  }
  
  public final void a(int paramInt, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(226035);
    this.o = paramInt;
    this.p = paramGeoPoint;
    q();
    AppMethodBeat.o(226035);
  }
  
  public final void a(fp paramfp)
  {
    AppMethodBeat.i(226047);
    if ((paramfp == null) || (!paramfp.a()))
    {
      kh.b("LineOptions不能为空！");
      AppMethodBeat.o(226047);
      return;
    }
    if (!paramfp.equals(this.a))
    {
      q();
      this.a = paramfp;
      this.m = paramfp.q;
      this.n = paramfp.r;
    }
    AppMethodBeat.o(226047);
  }
  
  public final Rect b(ep paramep)
  {
    AppMethodBeat.i(226017);
    if ((this.a == null) || (this.a.m == null) || (this.a.m.isEmpty()))
    {
      AppMethodBeat.o(226017);
      return null;
    }
    paramep = this.a.m.iterator();
    int i = 2147483647;
    int i1 = 2147483647;
    int k = -2147483648;
    int j = -2147483648;
    int i4;
    int i2;
    if (paramep.hasNext())
    {
      GeoPoint localGeoPoint = (GeoPoint)paramep.next();
      i4 = localGeoPoint.getLatitudeE6();
      i2 = localGeoPoint.getLongitudeE6();
      if (i4 <= j) {
        break label191;
      }
      j = i4;
    }
    label191:
    for (;;)
    {
      int i3 = i1;
      if (i4 < i1) {
        i3 = i4;
      }
      i4 = k;
      if (i2 > k) {
        i4 = i2;
      }
      if (i2 < i) {
        i = i2;
      }
      for (;;)
      {
        i1 = i3;
        k = i4;
        break;
        paramep = new Rect(i, j, k, i1);
        AppMethodBeat.o(226017);
        return paramep;
      }
    }
  }
  
  public final void d()
  {
    AppMethodBeat.i(226041);
    if (this.r != null)
    {
      this.r.a = -1;
      q();
    }
    AppMethodBeat.o(226041);
  }
  
  public final ao f_()
  {
    return this.z;
  }
  
  public final int getLevel()
  {
    return this.a.M;
  }
  
  public final int getZIndex()
  {
    return this.a.G;
  }
  
  public final void h_()
  {
    this.y = true;
  }
  
  public final boolean isSelected()
  {
    return this.t;
  }
  
  public final void j_()
  {
    AppMethodBeat.i(225992);
    Object localObject = this.x;
    if (localObject == null)
    {
      AppMethodBeat.o(225992);
      return;
    }
    this.s = ((mj)localObject).a;
    sj localsj = (sj)this.s.b();
    if (localsj == null)
    {
      AppMethodBeat.o(225992);
      return;
    }
    if ((this.y) && (this.q != -1))
    {
      kh.b("TDZ", "deleteLine..." + this.q);
      localObject = (VectorMap)localsj.e_;
      ((VectorMap)localObject).o.k.b(this);
      ((VectorMap)localObject).o.v = true;
      localObject = this.s.f();
      ((sc)localObject).a(new sc.102((sc)localObject, this.q, this.a.B));
      this.q = -1;
      AppMethodBeat.o(225992);
      return;
    }
    float f = ((mj)localObject).a.a().A.b.p;
    if ((this.v == -1.0F) || (this.v != f)) {
      this.v = f;
    }
    if (this.q == -1)
    {
      localObject = this.s.f();
      this.q = ((Integer)((sc)localObject).a(new sc.98((sc)localObject, this), Integer.valueOf(-1))).intValue();
      kh.b("TDZ", "createLine..." + this.q);
    }
    if (p())
    {
      localObject = this.s.f();
      ((sc)localObject).a(new sc.99((sc)localObject, this));
    }
    AppMethodBeat.o(225992);
  }
  
  public final boolean onTap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(226001);
    if (this.s == null)
    {
      AppMethodBeat.o(226001);
      return false;
    }
    TappedElement localTappedElement = this.s.f().a(paramFloat1, paramFloat2);
    if ((localTappedElement != null) && (localTappedElement.itemId == this.q))
    {
      AppMethodBeat.o(226001);
      return true;
    }
    AppMethodBeat.o(226001);
    return false;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(226005);
    this.t = paramBoolean;
    if ((this.s != null) && (this.s.f() != null))
    {
      sc localsc = this.s.f();
      localsc.a(new sc.101(localsc, this));
    }
    AppMethodBeat.o(226005);
  }
  
  public final void setZIndex(int paramInt)
  {
    AppMethodBeat.i(226051);
    this.a.G = paramInt;
    if ((this.s != null) && (this.s.f() != null)) {
      this.s.f().a(this.w, paramInt);
    }
    AppMethodBeat.o(226051);
  }
  
  public static final class a
  {
    public int a;
    public int b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pv
 * JD-Core Version:    0.7.0.1
 */