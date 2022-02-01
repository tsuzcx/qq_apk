package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.AlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.EmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.ColorType;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

public final class os
  extends oo<aq>
  implements aq
{
  private hu A;
  private float B;
  private a C;
  private float D;
  private int E;
  private PolylineOptions.Text F;
  private boolean G;
  private boolean H;
  private float I;
  private boolean J;
  private boolean K;
  private int L;
  private GeoPoint M;
  private String N;
  private int O;
  private List<Integer> P;
  private final float Q;
  private boolean R;
  private Animation S;
  private PolylineOptions T;
  private List<LatLng> U;
  private final az V;
  private String W;
  private boolean X;
  private hu.b Y;
  public pv a;
  private pw m;
  private Polyline n;
  private final List<a> o;
  private final List<GeoPoint> p;
  private float q;
  private final mk r;
  private boolean s;
  private int[] t;
  private int[] u;
  private int[] v;
  private int w;
  private PolylineOptions.ColorType x;
  private BitmapDescriptor y;
  private final int z;
  
  public os(az paramaz)
  {
    super(paramaz);
    AppMethodBeat.i(221929);
    this.a = null;
    this.m = null;
    this.n = null;
    this.s = false;
    this.t = null;
    this.u = null;
    this.v = null;
    this.w = -7829368;
    this.y = null;
    this.z = 12;
    this.C = null;
    this.D = 1.0F;
    this.E = 0;
    this.G = false;
    this.H = true;
    this.I = 0.0F;
    this.J = false;
    this.K = false;
    this.L = -1;
    this.M = null;
    this.O = -1;
    this.W = "tms-gl";
    this.Y = new hu.b()
    {
      public final void a(float paramAnonymousFloat)
      {
        AppMethodBeat.i(225240);
        os.a(os.this, paramAnonymousFloat);
        AppMethodBeat.o(225240);
      }
      
      public final void a(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
      
      public final void a(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4) {}
      
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void b(float paramAnonymousFloat)
      {
        AppMethodBeat.i(225268);
        os.b(os.this, paramAnonymousFloat);
        AppMethodBeat.o(225268);
      }
    };
    this.V = paramaz;
    this.r = paramaz.b();
    this.o = new CopyOnWriteArrayList();
    this.p = new CopyOnWriteArrayList();
    this.Q = this.r.getContext().getResources().getDisplayMetrics().density;
    AppMethodBeat.o(221929);
  }
  
  private static float a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(222049);
    float f = 0.0F;
    if (paramGeoPoint2 != null)
    {
      int i = paramGeoPoint1.getLatitudeE6();
      int j = paramGeoPoint2.getLatitudeE6();
      int k = paramGeoPoint1.getLongitudeE6();
      int i1 = paramGeoPoint2.getLongitudeE6();
      f = (float)(Math.hypot(i - j, k - i1) + 0.0D);
    }
    AppMethodBeat.o(222049);
    return f;
  }
  
  private static float a(a parama1, a parama2, GeoPoint paramGeoPoint, a parama3)
  {
    AppMethodBeat.i(222101);
    int i = parama1.getLongitudeE6();
    int j = parama1.getLatitudeE6();
    int k = parama2.getLongitudeE6();
    int i1 = parama2.getLatitudeE6();
    int i2 = paramGeoPoint.getLongitudeE6();
    int i3 = paramGeoPoint.getLatitudeE6();
    float f1 = (k - i) * (i2 - i) + (i1 - j) * (i3 - j);
    if (f1 <= 0.0F)
    {
      parama3.setLatitudeE6(parama1.getLatitudeE6());
      parama3.setLongitudeE6(parama1.getLongitudeE6());
      parama3.a = parama1.a;
      f1 = (float)Math.hypot(i2 - i, i3 - j);
      AppMethodBeat.o(222101);
      return f1;
    }
    double d = (k - i) * (k - i) + (i1 - j) * (i1 - j);
    if (f1 >= d)
    {
      parama3.setLatitudeE6(parama2.getLatitudeE6());
      parama3.setLongitudeE6(parama2.getLongitudeE6());
      parama3.a = parama2.a;
      f1 = (float)Math.hypot(i2 - k, i3 - i1);
      AppMethodBeat.o(222101);
      return f1;
    }
    f1 = (float)(f1 / d);
    float f2 = i;
    f2 = (k - i) * f1 + f2;
    float f3 = j;
    f3 = (i1 - j) * f1 + f3;
    parama3.setLongitudeE6(Math.round(f2));
    parama3.setLatitudeE6(Math.round(f3));
    parama1.a += (parama2.a - parama1.a) * f1;
    f1 = (float)Math.hypot(i2 - f2, i3 - f3);
    AppMethodBeat.o(222101);
    return f1;
  }
  
  private static int a(Context paramContext, BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(222193);
    if ((paramContext == null) || (paramBitmapDescriptor == null))
    {
      AppMethodBeat.o(222193);
      return 0;
    }
    paramBitmapDescriptor = paramBitmapDescriptor.getBitmap(paramContext);
    if (paramBitmapDescriptor == null)
    {
      AppMethodBeat.o(222193);
      return 0;
    }
    int i = paramBitmapDescriptor.getHeight();
    if (i <= 0)
    {
      AppMethodBeat.o(222193);
      return 0;
    }
    float f = ha.a(paramContext);
    i = (int)(Math.pow(2.0D, 25.0D) / Math.pow(i, 2.0D) / f);
    AppMethodBeat.o(222193);
    return i;
  }
  
  private a a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(222176);
    float f1 = 3.4028235E+38F;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = new a();
    Object localObject4 = localObject3;
    int i;
    if (this.o != null)
    {
      localObject4 = localObject3;
      if (this.o.size() >= 2)
      {
        localObject4 = localObject3;
        if (paramGeoPoint != null)
        {
          localObject3 = (a)this.o.get(0);
          i = 1;
          localObject4 = localObject2;
          if (i < this.o.size())
          {
            localObject4 = (a)this.o.get(i);
            float f2 = a((a)localObject3, (a)localObject4, paramGeoPoint, (a)localObject1);
            if (f2 >= f1) {
              break label168;
            }
            localObject3 = new a();
            f1 = f2;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
    label168:
    for (;;)
    {
      i += 1;
      localObject3 = localObject4;
      break;
      AppMethodBeat.o(222176);
      return localObject4;
    }
  }
  
  private static a a(a parama1, a parama2, float paramFloat)
  {
    AppMethodBeat.i(222073);
    a locala = new a();
    int i = parama2.getLongitudeE6();
    int j = parama1.getLongitudeE6();
    int k = parama2.getLatitudeE6();
    int i1 = parama1.getLatitudeE6();
    int i2 = parama1.getLatitudeE6();
    locala.setLatitudeE6(Math.round((k - i1) * paramFloat) + i2);
    k = parama1.getLongitudeE6();
    locala.setLongitudeE6(Math.round((i - j) * paramFloat) + k);
    parama1.a += (parama2.a - parama1.a) * paramFloat;
    AppMethodBeat.o(222073);
    return locala;
  }
  
  private PolylineOptions.ColorType a(PolylineOptions.ColorType paramColorType)
  {
    if (paramColorType != PolylineOptions.ColorType.LINE_COLOR_NONE) {
      return paramColorType;
    }
    if ((this.t != null) && (this.t.length > 0))
    {
      int i = 0;
      int j = this.t.length;
      while (i < j)
      {
        if ((this.t[i] < 0) || (this.t[i] >= 12)) {
          return PolylineOptions.ColorType.LINE_COLOR_ARGB;
        }
        i += 1;
      }
      return PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
    }
    if ((this.f < 0) || (this.f >= 12)) {
      return PolylineOptions.ColorType.LINE_COLOR_ARGB;
    }
    return PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
  }
  
  private void a(int paramInt)
  {
    this.O = paramInt;
  }
  
  private void a(ht paramht)
  {
    AppMethodBeat.i(222168);
    this.A = paramht;
    this.A.a(this.Y);
    this.A.a(null, null);
    if (this.r != null) {
      this.r.v = true;
    }
    AppMethodBeat.o(222168);
  }
  
  private void a(hw paramhw)
  {
    AppMethodBeat.i(222161);
    if (this.r == null)
    {
      AppMethodBeat.o(222161);
      return;
    }
    this.A = paramhw;
    GeoPoint localGeoPoint = GeoPoint.from(paramhw.i);
    this.C = a(localGeoPoint);
    if (this.C == null)
    {
      kh.c("Error, start point not found. [p=" + localGeoPoint + "] [offsetGeoPoints=" + this.o + "]");
      AppMethodBeat.o(222161);
      return;
    }
    paramhw.a(this.Y);
    paramhw.a(null, null);
    this.r.v = true;
    AppMethodBeat.o(222161);
  }
  
  private void a(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(221938);
    if (paramBitmapDescriptor.getBitmap(this.V.G()) != null) {
      this.N = paramBitmapDescriptor.getFormater().getBitmapId();
    }
    AppMethodBeat.o(221938);
  }
  
  private void a(Polyline paramPolyline)
  {
    this.n = paramPolyline;
  }
  
  private void a(List<LatLng> paramList)
  {
    AppMethodBeat.i(221954);
    this.U = paramList;
    if (paramList == null)
    {
      AppMethodBeat.o(221954);
      return;
    }
    int j = paramList.size();
    if (j <= 0)
    {
      AppMethodBeat.o(221954);
      return;
    }
    this.I = 0.0F;
    this.o.clear();
    Object localObject1 = null;
    int i = 0;
    if (i < j)
    {
      Object localObject2 = (LatLng)paramList.get(i);
      if (localObject2 == null) {
        break label229;
      }
      localObject2 = new a(GeoPoint.from((LatLng)localObject2));
      if (localObject1 != null)
      {
        float f2 = this.I;
        float f1 = 0.0F;
        if (localObject1 != null)
        {
          int k = ((GeoPoint)localObject2).getLatitudeE6();
          int i1 = localObject1.getLatitudeE6();
          int i2 = ((GeoPoint)localObject2).getLongitudeE6();
          int i3 = localObject1.getLongitudeE6();
          f1 = (float)(Math.hypot(k - i1, i2 - i3) + 0.0D);
        }
        this.I = (f1 + f2);
        ((a)localObject2).a = this.I;
        ((a)localObject2).b = (localObject1.b + 1);
      }
      this.o.add(localObject2);
      localObject1 = localObject2;
    }
    label229:
    for (;;)
    {
      i += 1;
      break;
      q();
      AppMethodBeat.o(221954);
      return;
    }
  }
  
  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      return 6;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 2;
    case 1: 
      return 1;
    case 0: 
      return 0;
    }
    return 33;
  }
  
  private ArrayList<GeoPoint> b(List<a> paramList)
  {
    AppMethodBeat.i(222062);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() < 2))
    {
      AppMethodBeat.o(222062);
      return localArrayList;
    }
    float f2 = this.C.a;
    float f3 = this.I;
    float f4 = this.C.a;
    float f1 = this.D;
    float f5 = this.D;
    f1 = f2 - f1 * f2;
    f2 += (f3 - f4) * f5;
    Object localObject = null;
    int i = 0;
    a locala1;
    if (i < paramList.size())
    {
      locala1 = (a)paramList.get(i);
      if ((locala1.a > f1) && (locala1.a < f2))
      {
        if ((localObject != null) && (((a)localObject).a < f1))
        {
          f3 = locala1.a;
          f4 = ((a)localObject).a;
          a locala2 = a((a)localObject, locala1, (f1 - ((a)localObject).a) / (f3 - f4));
          locala2.b = ((a)localObject).b;
          localArrayList.add(locala2);
        }
        localArrayList.add(locala1);
      }
    }
    for (;;)
    {
      i += 1;
      localObject = locala1;
      break;
      if (locala1.a > f2)
      {
        if ((localObject != null) && (((a)localObject).a < f2))
        {
          f1 = locala1.a;
          f3 = ((a)localObject).a;
          paramList = a((a)localObject, locala1, (f2 - ((a)localObject).a) / (f1 - f3));
          paramList.b = locala1.b;
          localArrayList.add(paramList);
        }
        AppMethodBeat.o(222062);
        return localArrayList;
      }
      if ((Float.compare(locala1.a, f1) == 0) || (Float.compare(locala1.a, f2) == 0)) {
        localArrayList.add(locala1);
      }
    }
  }
  
  private void b(float paramFloat)
  {
    this.q = paramFloat;
  }
  
  private static int c(int paramInt)
  {
    if (paramInt >= 12) {
      paramInt = 11;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      return i;
    }
  }
  
  private b c(List<GeoPoint> paramList)
  {
    int j = 0;
    AppMethodBeat.i(222091);
    if ((this.t == null) || (this.u == null) || (paramList == null) || (this.t.length == 0) || (this.u.length == 0) || (paramList.isEmpty()))
    {
      j = this.f;
      i = j;
      if (this.x == PolylineOptions.ColorType.LINE_COLOR_TEXTURE) {
        i = c(j);
      }
      paramList = new b(1);
      paramList.a(0, i);
      AppMethodBeat.o(222091);
      return paramList;
    }
    Object localObject2 = new TreeSet(new os.2(this));
    Object localObject1 = this.u;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      int i1 = localObject1[i];
      if ((i1 >= 0) && (i1 < paramList.size())) {
        ((Set)localObject2).add(Integer.valueOf(i1));
      }
      i += 1;
    }
    localObject1 = new ArrayList();
    Object localObject3 = this.t;
    k = localObject3.length;
    i = 0;
    while (i < k)
    {
      ((List)localObject1).add(Integer.valueOf(localObject3[i]));
      i += 1;
    }
    localObject3 = (Integer[])((Set)localObject2).toArray(new Integer[0]);
    if (localObject3[0].intValue() != 0)
    {
      ((Set)localObject2).add(Integer.valueOf(0));
      ((List)localObject1).add(0, Integer.valueOf(this.t[0]));
    }
    if (localObject3[(localObject3.length - 1)].intValue() != paramList.size() - 1)
    {
      ((Set)localObject2).add(Integer.valueOf(paramList.size() - 1));
      if (localObject3.length > this.t.length) {
        ((List)localObject1).add(((List)localObject1).size() - 1, Integer.valueOf(this.t[(this.t.length - 1)]));
      }
    }
    paramList = new ArrayList((Collection)localObject2);
    k = paramList.size();
    localObject2 = new b(k);
    i = j;
    if (i < k)
    {
      if (i > ((List)localObject1).size() - 1) {
        ((b)localObject2).a(((Integer)paramList.get(i)).intValue(), ((Integer)((List)localObject1).get(((List)localObject1).size() - 1)).intValue());
      }
      for (;;)
      {
        i += 1;
        break;
        ((b)localObject2).a(((Integer)paramList.get(i)).intValue(), ((Integer)((List)localObject1).get(i)).intValue());
      }
    }
    AppMethodBeat.o(222091);
    return localObject2;
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(222140);
    this.K = paramBoolean;
    q();
    AppMethodBeat.o(222140);
  }
  
  private void d()
  {
    AppMethodBeat.i(221962);
    if (Thread.currentThread().getName().contains(this.W))
    {
      e();
      AppMethodBeat.o(221962);
      return;
    }
    this.r.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225344);
        os.a(os.this);
        AppMethodBeat.o(225344);
      }
    });
    AppMethodBeat.o(221962);
  }
  
  private void d(List<Integer> paramList)
  {
    AppMethodBeat.i(222146);
    this.P = paramList;
    q();
    AppMethodBeat.o(222146);
  }
  
  private void e()
  {
    AppMethodBeat.i(221972);
    if ((this.r == null) || (this.p.size() < 2) || (!isVisible()))
    {
      AppMethodBeat.o(221972);
      return;
    }
    pv localpv = this.a;
    fp localfp = g();
    if (!localfp.a())
    {
      AppMethodBeat.o(221972);
      return;
    }
    if (localpv == null)
    {
      localpv = new pv(this, this.V, localfp);
      localpv.c_ = this.c_;
      this.r.k.a(localpv);
      this.a = localpv;
    }
    for (;;)
    {
      localpv.a(this.L, this.M);
      this.r.v = true;
      AppMethodBeat.o(221972);
      return;
      localpv.a(localfp);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(221982);
    if ((this.r == null) || (!this.R))
    {
      AppMethodBeat.o(221982);
      return;
    }
    this.R = false;
    if ((this.F == null) && (this.m != null))
    {
      this.m.a();
      this.m = null;
      AppMethodBeat.o(221982);
      return;
    }
    Object localObject = this.r.g;
    if (this.F != null)
    {
      if (this.m == null)
      {
        if ((this.p == null) || (this.p.size() < 2))
        {
          AppMethodBeat.o(221982);
          return;
        }
        this.m = new pw((sc)localObject, (GeoPoint[])this.p.toArray(new GeoPoint[this.p.size()]), this.F);
        AppMethodBeat.o(221982);
        return;
      }
      localObject = this.m;
      PolylineOptions.Text localText = this.F;
      if ((((pw)localObject).b == null) || (((pw)localObject).a <= 0))
      {
        AppMethodBeat.o(221982);
        return;
      }
      sc localsc = ((pw)localObject).b;
      localsc.a(new sc.48(localsc, ((pw)localObject).a, localText));
    }
    AppMethodBeat.o(221982);
  }
  
  private fp g()
  {
    AppMethodBeat.i(222024);
    fp localfp = new fp();
    if (this.r == null)
    {
      AppMethodBeat.o(222024);
      return localfp;
    }
    if ((this.y != null) && (this.y.getFormater() != null)) {
      localfp.y = this.y.getFormater().getBitmapId();
    }
    b localb = c(this.p);
    localfp.w = this.s;
    localfp.I = this.O;
    localfp.a(this.p);
    localfp.N = this.w;
    int i;
    float f;
    label158:
    int[] arrayOfInt;
    if (this.E == 0)
    {
      i = a(this.r.getContext(), this.y);
      if (i > 0) {
        if (this.d > i)
        {
          f = i;
          localfp.x = f;
          if (this.x == PolylineOptions.ColorType.LINE_COLOR_ARGB)
          {
            localfp.v = true;
            if (this.q * 2.0F >= this.d) {
              this.q = (this.d / 3.0F);
            }
            localfp.u = this.q;
          }
          arrayOfInt = this.v;
          if (!this.H) {
            break label422;
          }
          localfp.a(localb.a);
          if ((this.q <= 0.0F) || (arrayOfInt == null) || (arrayOfInt.length <= 0)) {
            break label408;
          }
          localfp.a(localb.b, arrayOfInt);
        }
      }
    }
    for (;;)
    {
      localfp.A = this.B;
      localfp.C = this.E;
      localfp.G = ((int)this.g);
      localfp.D = this.G;
      localfp.E = this.J;
      localfp.z = this.K;
      localfp.B = this.H;
      localfp.H = this.N;
      localfp.b(this.P);
      localfp.M = this.j;
      localfp.O = this.X;
      AppMethodBeat.o(222024);
      return localfp;
      f = this.d;
      break;
      localfp.x = this.d;
      break label158;
      localfp.x = this.d;
      break label158;
      label408:
      localfp.b(localb.b);
      continue;
      label422:
      localfp.a(new int[] { 0 });
      if ((this.q > 0.0F) && (arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        i = this.f;
        int j = arrayOfInt[0];
        localfp.a(new int[] { i }, new int[] { j });
      }
      else
      {
        localfp.b(new int[] { this.f });
      }
    }
  }
  
  private boolean h()
  {
    AppMethodBeat.i(222038);
    if (this.r == null)
    {
      AppMethodBeat.o(222038);
      return false;
    }
    if ((this.A != null) && (this.A.d))
    {
      this.A.b();
      List localList2;
      ArrayList localArrayList;
      if ((this.A instanceof hw))
      {
        this.p.clear();
        List localList1 = this.p;
        localList2 = this.o;
        localArrayList = new ArrayList();
        if ((localList2 == null) || (localList2.size() < 2))
        {
          localList1.addAll(localArrayList);
          if (this.p.size() >= 2) {
            d();
          }
        }
      }
      for (;;)
      {
        this.r.v = true;
        if (this.A.e)
        {
          this.A.a(null);
          this.A = null;
        }
        AppMethodBeat.o(222038);
        return true;
        float f2 = this.C.a;
        float f3 = this.I;
        float f4 = this.C.a;
        float f1 = this.D;
        float f5 = this.D;
        f1 = f2 - f1 * f2;
        f2 += (f3 - f4) * f5;
        int i = 0;
        Object localObject = null;
        label222:
        a locala1;
        if (i < localList2.size())
        {
          locala1 = (a)localList2.get(i);
          if ((locala1.a > f1) && (locala1.a < f2))
          {
            if ((localObject != null) && (((a)localObject).a < f1))
            {
              f3 = locala1.a;
              f4 = ((a)localObject).a;
              a locala2 = a((a)localObject, locala1, (f1 - ((a)localObject).a) / (f3 - f4));
              locala2.b = ((a)localObject).b;
              localArrayList.add(locala2);
            }
            localArrayList.add(locala1);
          }
        }
        for (;;)
        {
          i += 1;
          localObject = locala1;
          break label222;
          if (locala1.a > f2)
          {
            if ((localObject != null) && (((a)localObject).a < f2))
            {
              f1 = locala1.a;
              f3 = ((a)localObject).a;
              localObject = a((a)localObject, locala1, (f2 - ((a)localObject).a) / (f1 - f3));
              ((a)localObject).b = locala1.b;
              localArrayList.add(localObject);
            }
            break;
          }
          if ((Float.compare(locala1.a, f1) == 0) || (Float.compare(locala1.a, f2) == 0)) {
            localArrayList.add(locala1);
          }
        }
        if ((this.A instanceof ht)) {
          d();
        }
      }
    }
    AppMethodBeat.o(222038);
    return false;
  }
  
  private int[] i()
  {
    return this.v;
  }
  
  private aq t()
  {
    return this;
  }
  
  private Polyline u()
  {
    return this.n;
  }
  
  private float v()
  {
    return this.B;
  }
  
  private pv w()
  {
    return this.a;
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(222553);
    this.B = paramFloat;
    q();
    AppMethodBeat.o(222553);
  }
  
  public final void a(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(222579);
    paramLatLng = GeoPoint.from(paramLatLng);
    if ((paramInt == -1) || (paramLatLng == null))
    {
      AppMethodBeat.o(222579);
      return;
    }
    this.L = paramInt;
    this.M = paramLatLng;
    if (this.a != null) {
      this.a.a(this.L, this.M);
    }
    if (this.r != null) {
      this.r.v = true;
    }
    AppMethodBeat.o(222579);
  }
  
  public final void a(hu paramhu)
  {
    AppMethodBeat.i(222605);
    if (this.A != null)
    {
      this.A.b = false;
      this.A.a(null);
    }
    if ((paramhu instanceof hw))
    {
      a((hw)paramhu);
      AppMethodBeat.o(222605);
      return;
    }
    if ((paramhu instanceof ht))
    {
      a((ht)paramhu);
      AppMethodBeat.o(222605);
      return;
    }
    this.A = null;
    AppMethodBeat.o(222605);
  }
  
  public final void a(IndoorBuilding paramIndoorBuilding)
  {
    AppMethodBeat.i(222448);
    super.a(paramIndoorBuilding);
    if (this.a != null) {
      this.a.a(paramIndoorBuilding);
    }
    AppMethodBeat.o(222448);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(222611);
    c(paramBoolean);
    AppMethodBeat.o(222611);
  }
  
  public final void addTurnArrow(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222538);
    if (this.a == null)
    {
      AppMethodBeat.o(222538);
      return;
    }
    this.a.d();
    pv localpv = this.a;
    localpv.r = new pv.a();
    localpv.r.a = paramInt1;
    localpv.r.b = paramInt2;
    localpv.q();
    d();
    AppMethodBeat.o(222538);
  }
  
  public final void appendPoint(LatLng... paramVarArgs)
  {
    AppMethodBeat.i(222248);
    if (this.U == null) {
      this.U = new ArrayList();
    }
    this.U.addAll(Arrays.asList(paramVarArgs));
    a(this.U);
    AppMethodBeat.o(222248);
  }
  
  public final void appendPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(222256);
    if (this.U == null) {
      this.U = new ArrayList();
    }
    this.U.addAll(paramList);
    a(this.U);
    AppMethodBeat.o(222256);
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(222586);
    this.J = paramBoolean;
    if (this.a != null) {
      this.a.a.E = paramBoolean;
    }
    q();
    AppMethodBeat.o(222586);
  }
  
  public final void cleanTurnArrow()
  {
    AppMethodBeat.i(222499);
    if (this.a == null)
    {
      AppMethodBeat.o(222499);
      return;
    }
    this.a.d();
    d();
    AppMethodBeat.o(222499);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(222407);
    if (paramObject == null)
    {
      AppMethodBeat.o(222407);
      return false;
    }
    if (!(paramObject instanceof os))
    {
      AppMethodBeat.o(222407);
      return false;
    }
    paramObject = (os)paramObject;
    boolean bool = TextUtils.equals(this.b_, paramObject.b_);
    AppMethodBeat.o(222407);
    return bool;
  }
  
  public final void eraseTo(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(222294);
    a(paramInt, paramLatLng);
    AppMethodBeat.o(222294);
  }
  
  public final int getColor()
  {
    AppMethodBeat.i(222362);
    int i = getStrokeColor();
    AppMethodBeat.o(222362);
    return i;
  }
  
  public final int[][] getColors()
  {
    AppMethodBeat.i(222493);
    if ((this.t == null) || (this.u == null))
    {
      AppMethodBeat.o(222493);
      return null;
    }
    int i = Math.max(this.t.length, this.u.length);
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, i });
    arrayOfInt[0] = this.t;
    arrayOfInt[1] = this.u;
    AppMethodBeat.o(222493);
    return arrayOfInt;
  }
  
  public final List<Boundable<ep>> getGroupBounds()
  {
    AppMethodBeat.i(222616);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(this.a);
    AppMethodBeat.o(222616);
    return localArrayList;
  }
  
  public final List<Integer> getPattern()
  {
    return this.P;
  }
  
  public final List<LatLng> getPoints()
  {
    return this.U;
  }
  
  public final PolylineOptions getPolylineOptions()
  {
    return this.T;
  }
  
  public final PolylineOptions.Text getText()
  {
    return this.F;
  }
  
  public final Rect getVisibleRect()
  {
    AppMethodBeat.i(222313);
    pv localpv = this.a;
    Object localObject = localpv.a.l;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()) && (localpv.o >= 0) && (localpv.o < ((ArrayList)localObject).size()))
    {
      localObject = ((ArrayList)localObject).subList(localpv.o, ((ArrayList)localObject).size());
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label125;
      }
      localObject = null;
      if (localObject != null) {
        localpv.a.F = ((Rect)localObject);
      }
    }
    localObject = localpv.a.F;
    AppMethodBeat.o(222313);
    return localObject;
    label125:
    GeoPoint localGeoPoint = (GeoPoint)((List)localObject).get(0);
    int i2 = localGeoPoint.getLongitudeE6();
    int i1 = localGeoPoint.getLongitudeE6();
    int i6 = localGeoPoint.getLatitudeE6();
    int i = localGeoPoint.getLatitudeE6();
    int i8 = ((List)localObject).size();
    int i5 = 0;
    label177:
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
        break label323;
      }
      i7 = localGeoPoint.getLatitudeE6();
      i3 = localGeoPoint.getLongitudeE6();
      if (i3 < i2)
      {
        k = i3;
        j = i1;
        label238:
        if (i7 >= i) {
          break label284;
        }
        i = i7;
      }
    }
    for (;;)
    {
      i5 += 1;
      i1 = j;
      i2 = k;
      break label177;
      j = i1;
      k = i2;
      if (i3 <= i1) {
        break label238;
      }
      j = i3;
      k = i2;
      break label238;
      label284:
      i4 = j;
      i3 = k;
      if (i7 > i6)
      {
        i6 = i7;
        continue;
        localObject = new Rect(i2, i6, i1, i);
        break;
      }
      label323:
      j = i4;
      k = i3;
    }
  }
  
  public final float getWidth()
  {
    return this.d;
  }
  
  public final void h_()
  {
    AppMethodBeat.i(222397);
    if (this.a != null)
    {
      this.a.remove();
      this.a = null;
    }
    if (this.m != null)
    {
      this.m.a();
      this.m = null;
    }
    if (this.o != null) {
      this.o.clear();
    }
    if (this.p != null) {
      this.p.clear();
    }
    AppMethodBeat.o(222397);
  }
  
  public final boolean handleOnTap()
  {
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(222415);
    int i = this.b_.hashCode();
    AppMethodBeat.o(222415);
    return i;
  }
  
  public final boolean isAboveMaskLayer()
  {
    return this.G;
  }
  
  public final boolean isGradientEnable()
  {
    return this.X;
  }
  
  public final void j()
  {
    AppMethodBeat.i(222473);
    d();
    AppMethodBeat.o(222473);
  }
  
  public final void j_()
  {
    AppMethodBeat.i(222431);
    this.W = Thread.currentThread().getName();
    if (this.r == null)
    {
      AppMethodBeat.o(222431);
      return;
    }
    if (!isVisible())
    {
      AppMethodBeat.o(222431);
      return;
    }
    if (p())
    {
      if (this.o.size() >= 2)
      {
        this.p.clear();
        this.p.addAll(this.o);
      }
      d();
    }
    Object localObject3;
    List localList;
    ArrayList localArrayList;
    if ((this.r != null) && (this.A != null) && (this.A.d))
    {
      this.A.b();
      if (!(this.A instanceof hw)) {
        break label559;
      }
      this.p.clear();
      localObject3 = this.p;
      localList = this.o;
      localArrayList = new ArrayList();
      if ((localList != null) && (localList.size() >= 2)) {
        break label257;
      }
      ((List)localObject3).addAll(localArrayList);
      if (this.p.size() >= 2) {
        d();
      }
    }
    label257:
    label312:
    Object localObject2;
    for (;;)
    {
      this.r.v = true;
      if (this.A.e)
      {
        this.A.a(null);
        this.A = null;
      }
      if ((this.r != null) && (this.R)) {
        break label576;
      }
      AppMethodBeat.o(222431);
      return;
      float f2 = this.C.a;
      float f3 = this.I;
      float f4 = this.C.a;
      float f1 = this.D;
      float f5 = this.D;
      f1 = f2 - f1 * f2;
      f2 += (f3 - f4) * f5;
      int i = 0;
      localObject1 = null;
      if (i < localList.size())
      {
        localObject2 = (a)localList.get(i);
        if ((((a)localObject2).a > f1) && (((a)localObject2).a < f2))
        {
          if ((localObject1 != null) && (((a)localObject1).a < f1))
          {
            f3 = ((a)localObject2).a;
            f4 = ((a)localObject1).a;
            a locala = a((a)localObject1, (a)localObject2, (f1 - ((a)localObject1).a) / (f3 - f4));
            locala.b = ((a)localObject1).b;
            localArrayList.add(locala);
          }
          localArrayList.add(localObject2);
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break label312;
        if (((a)localObject2).a > f2)
        {
          if ((localObject1 != null) && (((a)localObject1).a < f2))
          {
            f1 = ((a)localObject2).a;
            f3 = ((a)localObject1).a;
            localObject1 = a((a)localObject1, (a)localObject2, (f2 - ((a)localObject1).a) / (f1 - f3));
            ((a)localObject1).b = ((a)localObject2).b;
            localArrayList.add(localObject1);
          }
          break;
        }
        if ((Float.compare(((a)localObject2).a, f1) == 0) || (Float.compare(((a)localObject2).a, f2) == 0)) {
          localArrayList.add(localObject2);
        }
      }
      label559:
      if ((this.A instanceof ht)) {
        d();
      }
    }
    label576:
    this.R = false;
    if ((this.F == null) && (this.m != null))
    {
      this.m.a();
      this.m = null;
      AppMethodBeat.o(222431);
      return;
    }
    Object localObject1 = this.r.g;
    if (this.F != null)
    {
      if (this.m == null)
      {
        if ((this.p == null) || (this.p.size() < 2))
        {
          AppMethodBeat.o(222431);
          return;
        }
        this.m = new pw((sc)localObject1, (GeoPoint[])this.p.toArray(new GeoPoint[this.p.size()]), this.F);
        AppMethodBeat.o(222431);
        return;
      }
      localObject1 = this.m;
      localObject2 = this.F;
      if ((((pw)localObject1).b == null) || (((pw)localObject1).a <= 0))
      {
        AppMethodBeat.o(222431);
        return;
      }
      localObject3 = ((pw)localObject1).b;
      ((sc)localObject3).a(new sc.48((sc)localObject3, ((pw)localObject1).a, (PolylineOptions.Text)localObject2));
    }
    AppMethodBeat.o(222431);
  }
  
  public final Rect l_()
  {
    AppMethodBeat.i(222597);
    pv localpv = this.a;
    Object localObject = localpv.a.l;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()) && (localpv.o >= 0) && (localpv.o < ((ArrayList)localObject).size()))
    {
      localObject = ((ArrayList)localObject).subList(localpv.o, ((ArrayList)localObject).size());
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        break label125;
      }
      localObject = null;
      if (localObject != null) {
        localpv.a.F = ((Rect)localObject);
      }
    }
    localObject = localpv.a.F;
    AppMethodBeat.o(222597);
    return localObject;
    label125:
    GeoPoint localGeoPoint = (GeoPoint)((List)localObject).get(0);
    int i2 = localGeoPoint.getLongitudeE6();
    int i1 = localGeoPoint.getLongitudeE6();
    int i6 = localGeoPoint.getLatitudeE6();
    int i = localGeoPoint.getLatitudeE6();
    int i8 = ((List)localObject).size();
    int i5 = 0;
    label177:
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
        break label323;
      }
      i7 = localGeoPoint.getLatitudeE6();
      i3 = localGeoPoint.getLongitudeE6();
      if (i3 < i2)
      {
        k = i3;
        j = i1;
        label238:
        if (i7 >= i) {
          break label284;
        }
        i = i7;
      }
    }
    for (;;)
    {
      i5 += 1;
      i1 = j;
      i2 = k;
      break label177;
      j = i1;
      k = i2;
      if (i3 <= i1) {
        break label238;
      }
      j = i3;
      k = i2;
      break label238;
      label284:
      i4 = j;
      i3 = k;
      if (i7 > i6)
      {
        i6 = i7;
        continue;
        localObject = new Rect(i2, i6, i1, i);
        break;
      }
      label323:
      j = i4;
      k = i3;
    }
  }
  
  public final void o()
  {
    AppMethodBeat.i(222444);
    super.o();
    if (this.a != null) {
      this.a.o();
    }
    AppMethodBeat.o(222444);
  }
  
  public final boolean onTap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222439);
    if ((this.r == null) || (!isVisible()))
    {
      AppMethodBeat.o(222439);
      return false;
    }
    if (this.a != null)
    {
      boolean bool = this.a.onTap(paramFloat1, paramFloat2);
      AppMethodBeat.o(222439);
      return bool;
    }
    AppMethodBeat.o(222439);
    return false;
  }
  
  public final void pattern(List<Integer> paramList)
  {
    AppMethodBeat.i(222285);
    d(paramList);
    AppMethodBeat.o(222285);
  }
  
  public final void q()
  {
    AppMethodBeat.i(222457);
    super.q();
    if (this.a != null) {
      this.a.q();
    }
    AppMethodBeat.o(222457);
  }
  
  public final void setAboveMaskLayer(boolean paramBoolean)
  {
    AppMethodBeat.i(222264);
    if (this.G != paramBoolean)
    {
      this.G = paramBoolean;
      q();
    }
    AppMethodBeat.o(222264);
  }
  
  public final void setAnimation(Animation paramAnimation)
  {
    AppMethodBeat.i(222322);
    if (((paramAnimation instanceof AlphaAnimation)) || ((paramAnimation instanceof EmergeAnimation)) || ((paramAnimation instanceof IAlphaAnimation)) || ((paramAnimation instanceof IEmergeAnimation)))
    {
      this.S = paramAnimation;
      AppMethodBeat.o(222322);
      return;
    }
    kh.b("Unsupported animation, only AlphaAnimation and EmergeAnimation allowed.");
    AppMethodBeat.o(222322);
  }
  
  public final void setArrow(boolean paramBoolean)
  {
    AppMethodBeat.i(222347);
    if (this.s != paramBoolean)
    {
      this.s = paramBoolean;
      if (this.T != null) {
        this.T.arrow(paramBoolean);
      }
      q();
    }
    AppMethodBeat.o(222347);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(222528);
    setStrokeColor(paramInt);
    if (this.T != null) {
      this.T.color(paramInt);
    }
    AppMethodBeat.o(222528);
  }
  
  public final void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(222370);
    if ((this.r == null) || (paramBitmapDescriptor == null) || (paramBitmapDescriptor.getFormater() == null))
    {
      AppMethodBeat.o(222370);
      return;
    }
    this.y = paramBitmapDescriptor;
    this.y.getBitmap(this.r.getContext());
    this.x = PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
    q();
    AppMethodBeat.o(222370);
  }
  
  public final void setColorTexture(String paramString)
  {
    AppMethodBeat.i(222355);
    setColorTexture(BitmapDescriptorFactory.fromAsset(paramString));
    AppMethodBeat.o(222355);
  }
  
  public final void setColors(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(222483);
    this.t = paramArrayOfInt1;
    this.u = paramArrayOfInt2;
    this.x = a(PolylineOptions.ColorType.LINE_COLOR_NONE);
    this.H = true;
    q();
    AppMethodBeat.o(222483);
  }
  
  public final void setEraseable(boolean paramBoolean)
  {
    AppMethodBeat.i(222302);
    this.J = paramBoolean;
    if (this.a != null) {
      this.a.a.E = paramBoolean;
    }
    q();
    AppMethodBeat.o(222302);
  }
  
  public final void setGradientEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(222378);
    if ((this.E == 0) && (this.H))
    {
      this.X = paramBoolean;
      q();
    }
    AppMethodBeat.o(222378);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(222240);
    a(paramList);
    AppMethodBeat.o(222240);
  }
  
  public final void setPolylineOptions(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(222224);
    if ((this.r == null) || (paramPolylineOptions == null))
    {
      AppMethodBeat.o(222224);
      return;
    }
    this.l = true;
    this.T = paramPolylineOptions;
    if (paramPolylineOptions.getWidth() == -1.0F) {
      setStrokeWidth(this.Q * 9.0F);
    }
    for (;;)
    {
      setStrokeColor(paramPolylineOptions.getColor());
      setZIndex(paramPolylineOptions.getZIndex());
      setVisible(paramPolylineOptions.isVisible());
      this.B = paramPolylineOptions.getAlpha();
      q();
      setArrow(paramPolylineOptions.isArrow());
      setColorTexture(paramPolylineOptions.getColorTexture());
      c(paramPolylineOptions.getLineCap());
      d(paramPolylineOptions.getPattern());
      this.q = paramPolylineOptions.getBorderWidth();
      setClickable(paramPolylineOptions.isClickable());
      this.v = paramPolylineOptions.getBorderColors();
      this.c_ = paramPolylineOptions.getIndoorInfo();
      this.E = paramPolylineOptions.getLineType();
      this.j = paramPolylineOptions.getLevel();
      this.w = paramPolylineOptions.getEraseColor();
      if ((paramPolylineOptions.isAbovePillar()) && (this.j == 0)) {
        this.j = 2;
      }
      a(paramPolylineOptions.getPoints());
      if (paramPolylineOptions.getArrowTexture() != null)
      {
        localObject1 = paramPolylineOptions.getArrowTexture();
        if (((BitmapDescriptor)localObject1).getBitmap(this.V.G()) != null) {
          this.N = ((BitmapDescriptor)localObject1).getFormater().getBitmapId();
        }
      }
      this.O = paramPolylineOptions.getArrowSpacing();
      this.H = paramPolylineOptions.isRoad();
      Object localObject1 = paramPolylineOptions.getAnimation();
      if (localObject1 != null) {
        a(((hd)localObject1).a);
      }
      Object localObject2 = paramPolylineOptions.getColors();
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        if ((localObject1 != null) && (localObject2 != null)) {
          setColors((int[])localObject1, (int[])localObject2);
        }
      }
      this.x = a(paramPolylineOptions.getColorType());
      setText(paramPolylineOptions.getText());
      setGradientEnable(paramPolylineOptions.isGradientEnable());
      r();
      d();
      AppMethodBeat.o(222224);
      return;
      setStrokeWidth(paramPolylineOptions.getWidth());
    }
  }
  
  public final void setText(PolylineOptions.Text paramText)
  {
    if (this.F != paramText)
    {
      this.F = paramText;
      this.R = true;
    }
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(222465);
    super.setVisible(paramBoolean);
    if (this.a != null) {
      this.a.setVisible(paramBoolean);
    }
    AppMethodBeat.o(222465);
  }
  
  public final void setWidth(float paramFloat)
  {
    float f = 128.0F;
    AppMethodBeat.i(222515);
    if (paramFloat < 0.0F) {
      paramFloat = 1.0F;
    }
    for (;;)
    {
      if (paramFloat > 128.0F) {
        paramFloat = f;
      }
      for (;;)
      {
        setStrokeWidth(paramFloat);
        AppMethodBeat.o(222515);
        return;
      }
    }
  }
  
  public final void startAnimation(Animation paramAnimation)
  {
    AppMethodBeat.i(222338);
    setAnimation(paramAnimation);
    startAnimation();
    AppMethodBeat.o(222338);
  }
  
  public final boolean startAnimation()
  {
    AppMethodBeat.i(222328);
    if (this.S != null)
    {
      hd localhd = ic.a(this.r.C(), this.S);
      if (localhd != null) {
        a(localhd.a);
      }
    }
    AppMethodBeat.o(222328);
    return false;
  }
  
  static final class a
    extends GeoPoint
  {
    float a = 0.0F;
    int b = 0;
    
    public a() {}
    
    public a(GeoPoint paramGeoPoint)
    {
      super();
    }
    
    public final String toString()
    {
      AppMethodBeat.i(223658);
      String str = super.toString() + "," + this.a;
      AppMethodBeat.o(223658);
      return str;
    }
  }
  
  static final class b
  {
    int[] a;
    int[] b;
    int c;
    int d;
    
    b(int paramInt)
    {
      AppMethodBeat.i(223538);
      this.d = paramInt;
      this.a = new int[paramInt];
      this.b = new int[paramInt];
      AppMethodBeat.o(223538);
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      if (this.c >= this.d) {
        return;
      }
      this.a[this.c] = paramInt1;
      this.b[this.c] = paramInt2;
      this.c += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.os
 * JD-Core Version:    0.7.0.1
 */