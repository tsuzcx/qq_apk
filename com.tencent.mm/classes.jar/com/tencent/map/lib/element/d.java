package com.tencent.map.lib.element;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hl;
import com.tencent.tencentmap.mapsdk.maps.a.hu;
import com.tencent.tencentmap.mapsdk.maps.a.if;
import com.tencent.tencentmap.mapsdk.maps.a.ih;
import com.tencent.tencentmap.mapsdk.maps.a.ja;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class d
  implements j
{
  private hl a;
  private e b;
  private int[] c;
  private int[] d;
  private int e;
  private GeoPoint f;
  private boolean g;
  private int h;
  private d.a i;
  private float j;
  private int k;
  
  public d(e parame)
  {
    AppMethodBeat.i(97863);
    this.g = true;
    this.h = -1;
    this.j = -1.0F;
    this.k = -1;
    a(parame);
    AppMethodBeat.o(97863);
  }
  
  private Rect a(List<GeoPoint> paramList)
  {
    AppMethodBeat.i(97874);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(97874);
      return null;
    }
    GeoPoint localGeoPoint = (GeoPoint)paramList.get(0);
    int i3 = localGeoPoint.getLongitudeE6();
    int i2 = localGeoPoint.getLongitudeE6();
    int i7 = localGeoPoint.getLatitudeE6();
    int m = localGeoPoint.getLatitudeE6();
    int i9 = paramList.size();
    int i6 = 0;
    int i5;
    int i4;
    int i8;
    int i1;
    int n;
    if (i6 < i9)
    {
      localGeoPoint = (GeoPoint)paramList.get(i6);
      i5 = i2;
      i4 = i3;
      if (localGeoPoint == null) {
        break label228;
      }
      i8 = localGeoPoint.getLatitudeE6();
      i4 = localGeoPoint.getLongitudeE6();
      if (i4 < i3)
      {
        i1 = i4;
        n = i2;
        label136:
        if (i8 >= m) {
          break label185;
        }
        m = i8;
      }
    }
    for (;;)
    {
      i6 += 1;
      i2 = n;
      i3 = i1;
      break;
      n = i2;
      i1 = i3;
      if (i4 <= i2) {
        break label136;
      }
      n = i4;
      i1 = i3;
      break label136;
      label185:
      i5 = n;
      i4 = i1;
      if (i8 > i7)
      {
        i7 = i8;
        continue;
        paramList = new Rect(i3, i7, i2, m);
        AppMethodBeat.o(97874);
        return paramList;
      }
      else
      {
        label228:
        n = i5;
        i1 = i4;
      }
    }
  }
  
  private void a(ih paramih, hu paramhu)
  {
    AppMethodBeat.i(146992);
    if (this.b == null)
    {
      AppMethodBeat.o(146992);
      return;
    }
    if ((this.b.r != 2) && (this.b.r != 3))
    {
      AppMethodBeat.o(146992);
      return;
    }
    List localList = this.b.q;
    if ((localList == null) || (localList.isEmpty()))
    {
      AppMethodBeat.o(146992);
      return;
    }
    ArrayList localArrayList1 = this.b.a;
    if ((localArrayList1 == null) || (localArrayList1.size() < 2))
    {
      AppMethodBeat.o(146992);
      return;
    }
    int i1 = localArrayList1.size();
    int[] arrayOfInt = new int[i1 - 1];
    int m = 0;
    while (m < i1 - 1)
    {
      arrayOfInt[m] = 0;
      m += 1;
    }
    m = ja.a(localArrayList1, arrayOfInt, paramhu);
    if (m <= 0)
    {
      AppMethodBeat.o(146992);
      return;
    }
    paramhu = new ArrayList(m + i1);
    ArrayList localArrayList2;
    int n;
    Object localObject;
    GeoPoint localGeoPoint1;
    GeoPoint localGeoPoint2;
    if (this.b.r == 2)
    {
      localArrayList2 = new ArrayList(3);
      n = localList.size();
      m = 0;
      while ((m < i1 - 1) && (m < n))
      {
        localObject = new GeoPoint((GeoPoint)localArrayList1.get(m));
        localGeoPoint1 = new GeoPoint((GeoPoint)localList.get(m));
        localGeoPoint2 = new GeoPoint((GeoPoint)localArrayList1.get(m + 1));
        paramhu.add(localArrayList1.get(m));
        localArrayList2.clear();
        localArrayList2.add(localObject);
        localArrayList2.add(localGeoPoint1);
        localArrayList2.add(localGeoPoint2);
        if (arrayOfInt[m] > 0)
        {
          localObject = ja.a(localArrayList2, arrayOfInt[m]);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            paramhu.addAll((Collection)localObject);
          }
        }
        m += 1;
      }
      paramhu.add(localArrayList1.get(i1 - 1));
    }
    for (;;)
    {
      if (this.h != -1) {
        paramih.a(this.h);
      }
      this.b.b = paramhu;
      AppMethodBeat.o(146992);
      return;
      localArrayList2 = new ArrayList(4);
      n = 0;
      int i2 = localList.size();
      m = 0;
      while ((n < i1 - 1) && (m < i2))
      {
        localObject = new GeoPoint((GeoPoint)localArrayList1.get(n));
        localGeoPoint1 = new GeoPoint((GeoPoint)localList.get(m));
        localGeoPoint2 = new GeoPoint((GeoPoint)localList.get(m + 1));
        GeoPoint localGeoPoint3 = new GeoPoint((GeoPoint)localArrayList1.get(n + 1));
        paramhu.add(localArrayList1.get(n));
        localArrayList2.clear();
        localArrayList2.add(localObject);
        localArrayList2.add(localGeoPoint1);
        localArrayList2.add(localGeoPoint2);
        localArrayList2.add(localGeoPoint3);
        if (arrayOfInt[n] > 0)
        {
          localObject = ja.a(localArrayList2, arrayOfInt[n]);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            paramhu.addAll((Collection)localObject);
          }
        }
        n += 1;
        m += 2;
      }
      paramhu.add(localArrayList1.get(i1 - 1));
    }
  }
  
  public int A()
  {
    AppMethodBeat.i(97873);
    int m = this.b.c();
    AppMethodBeat.o(97873);
    return m;
  }
  
  public void B()
  {
    this.k = -1;
  }
  
  public Rect a(hu paramhu)
  {
    AppMethodBeat.i(146991);
    if ((this.b == null) || (this.b.b == null))
    {
      AppMethodBeat.o(146991);
      return null;
    }
    paramhu = this.b.b.iterator();
    int m = 2147483647;
    int i2 = 2147483647;
    int i1 = -2147483648;
    int n = -2147483648;
    int i5;
    int i3;
    if (paramhu.hasNext())
    {
      GeoPoint localGeoPoint = (GeoPoint)paramhu.next();
      i5 = localGeoPoint.getLatitudeE6();
      i3 = localGeoPoint.getLongitudeE6();
      if (i5 <= n) {
        break label171;
      }
      n = i5;
    }
    label171:
    for (;;)
    {
      int i4 = i2;
      if (i5 < i2) {
        i4 = i5;
      }
      i5 = i1;
      if (i3 > i1) {
        i5 = i3;
      }
      if (i3 < m) {
        m = i3;
      }
      for (;;)
      {
        i2 = i4;
        i1 = i5;
        break;
        paramhu = new Rect(m, n, i1, i2);
        AppMethodBeat.o(146991);
        return paramhu;
      }
    }
  }
  
  public ArrayList<GeoPoint> a()
  {
    return this.b.b;
  }
  
  public void a(float paramFloat)
  {
    this.b.j = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(97868);
      this.i = new d.a();
      this.i.a = paramInt1;
      this.i.b = paramInt2;
      AppMethodBeat.o(97868);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, GeoPoint paramGeoPoint)
  {
    this.e = paramInt;
    this.f = paramGeoPoint;
  }
  
  public void a(e parame)
  {
    try
    {
      AppMethodBeat.i(97870);
      if (parame == null)
      {
        parame = new IllegalArgumentException("LineOptions不能为空！");
        AppMethodBeat.o(97870);
        throw parame;
      }
    }
    finally {}
    if ((parame.b == null) || (parame.b.size() < 2))
    {
      parame = new IllegalArgumentException("LineOptions中点的个数不能小于2");
      AppMethodBeat.o(97870);
      throw parame;
    }
    if ((parame.c == null) || (parame.c.length <= 0))
    {
      parame = new IllegalArgumentException("参数startIndexes不能为空!");
      AppMethodBeat.o(97870);
      throw parame;
    }
    if ((parame.d == null) || (parame.d.length <= 0))
    {
      parame = new IllegalArgumentException("参数colors不能为空!");
      AppMethodBeat.o(97870);
      throw parame;
    }
    this.b = parame;
    this.c = parame.c;
    this.d = parame.d;
    this.h = -1;
    AppMethodBeat.o(97870);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.s = paramBoolean;
  }
  
  public boolean a(hu paramhu, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(146990);
        if (this.a == null)
        {
          AppMethodBeat.o(146990);
          return bool;
        }
        paramhu = this.a.f().a(paramFloat1, paramFloat2);
        if ((paramhu != null) && (paramhu.itemId == s()))
        {
          bool = true;
          AppMethodBeat.o(146990);
        }
        else
        {
          AppMethodBeat.o(146990);
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void b(ih paramih, hu paramhu)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 221
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: ldc 221
    //   13: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 224	com/tencent/tencentmap/mapsdk/maps/a/ih:b	()Lcom/tencent/tencentmap/mapsdk/maps/a/hl;
    //   24: putfield 202	com/tencent/map/lib/element/d:a	Lcom/tencent/tencentmap/mapsdk/maps/a/hl;
    //   27: aload_1
    //   28: invokevirtual 227	com/tencent/tencentmap/mapsdk/maps/a/ih:d	()F
    //   31: fstore_3
    //   32: aload_0
    //   33: getfield 45	com/tencent/map/lib/element/d:j	F
    //   36: ldc 43
    //   38: fcmpl
    //   39: ifeq +12 -> 51
    //   42: aload_0
    //   43: getfield 45	com/tencent/map/lib/element/d:j	F
    //   46: fload_3
    //   47: fcmpl
    //   48: ifeq +14 -> 62
    //   51: aload_0
    //   52: fload_3
    //   53: putfield 45	com/tencent/map/lib/element/d:j	F
    //   56: aload_0
    //   57: aload_1
    //   58: aload_2
    //   59: invokespecial 229	com/tencent/map/lib/element/d:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/ih;Lcom/tencent/tencentmap/mapsdk/maps/a/hu;)V
    //   62: aload_1
    //   63: aload_0
    //   64: invokevirtual 232	com/tencent/tencentmap/mapsdk/maps/a/ih:a	(Lcom/tencent/map/lib/element/d;)V
    //   67: ldc 221
    //   69: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -56 -> 16
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	d
    //   0	80	1	paramih	ih
    //   0	80	2	paramhu	hu
    //   31	22	3	f1	float
    // Exception table:
    //   from	to	target	type
    //   2	7	75	finally
    //   11	16	75	finally
    //   19	51	75	finally
    //   51	62	75	finally
    //   62	72	75	finally
  }
  
  public int[] b()
  {
    return this.c;
  }
  
  public int[] c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.b.h;
  }
  
  public int[] e()
  {
    return this.b.e;
  }
  
  public int[] f()
  {
    return this.b.f;
  }
  
  public float g()
  {
    return this.b.g;
  }
  
  public GeoPoint h()
  {
    return this.f;
  }
  
  public int i()
  {
    return this.e;
  }
  
  public boolean j()
  {
    return this.b.i;
  }
  
  public boolean k()
  {
    return this.b.l;
  }
  
  public boolean l()
  {
    return this.b.n;
  }
  
  public int m()
  {
    AppMethodBeat.i(97867);
    int m = this.b.a();
    AppMethodBeat.o(97867);
    return m;
  }
  
  public float n()
  {
    return this.b.j;
  }
  
  public float o()
  {
    if (this.b == null) {
      return 1.0F;
    }
    return this.b.m;
  }
  
  public void p()
  {
    try
    {
      this.i = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public d.a q()
  {
    try
    {
      d.a locala = this.i;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String r()
  {
    AppMethodBeat.i(97869);
    if ((this.b.d != null) && (this.b.d.length > 0))
    {
      if (this.b.d[0] == 33)
      {
        AppMethodBeat.o(97869);
        return "color_point_texture.png";
      }
      if (this.b.d[0] == 20)
      {
        AppMethodBeat.o(97869);
        return "color_texture_line_v2.png";
      }
    }
    if (StringUtil.isEmpty(this.b.k))
    {
      AppMethodBeat.o(97869);
      return "color_texture_flat_style.png";
    }
    String str = this.b.k;
    AppMethodBeat.o(97869);
    return str;
  }
  
  public final int s()
  {
    return this.h;
  }
  
  public boolean t()
  {
    return this.b.s;
  }
  
  public Rect u()
  {
    AppMethodBeat.i(97871);
    Object localObject = this.b.a;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()) && (this.e >= 0) && (this.e < ((ArrayList)localObject).size()))
    {
      localObject = a(((ArrayList)localObject).subList(this.e, ((ArrayList)localObject).size()));
      if (localObject != null) {
        this.b.t = ((Rect)localObject);
      }
    }
    localObject = this.b.t;
    AppMethodBeat.o(97871);
    return localObject;
  }
  
  public int v()
  {
    return this.b.u;
  }
  
  public String w()
  {
    return this.b.v;
  }
  
  public float x()
  {
    AppMethodBeat.i(97872);
    float f1 = this.b.b();
    AppMethodBeat.o(97872);
    return f1;
  }
  
  public int[] y()
  {
    return new int[] { this.b.x, this.b.y };
  }
  
  public List<Integer> z()
  {
    return this.b.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.lib.element.d
 * JD-Core Version:    0.7.0.1
 */