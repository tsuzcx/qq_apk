package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.ReturnCallback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionItem;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public final class oq
  extends oo<an>
  implements an
{
  protected float A;
  protected float B;
  protected float C;
  public boolean D;
  public sj E;
  public en F;
  private boolean G;
  private int H;
  private int I;
  private boolean J;
  private GeoPoint K;
  private px L;
  private AnimationListener M;
  private hu N;
  private TencentMap.OnMarkerClickListener O;
  private boolean P;
  private LatLng Q;
  private Collision[] R;
  private int S;
  private final hu.b T;
  protected Object a;
  protected Bitmap m;
  boolean n;
  protected final Object o;
  float p;
  float q;
  protected boolean r;
  protected float s;
  protected float t;
  protected float u;
  protected MarkerOptions v;
  protected String w;
  protected GeoPoint x;
  protected GeoPoint y;
  protected GeoPoint z;
  
  public oq(sj paramsj)
  {
    super(paramsj);
    AppMethodBeat.i(221975);
    this.a = null;
    this.m = null;
    this.n = false;
    this.o = new Object();
    this.p = 0.5F;
    this.q = 0.5F;
    this.r = false;
    this.s = 0.0F;
    this.t = 0.0F;
    this.u = -1.0F;
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = 1.0F;
    this.B = 1.0F;
    this.C = 1.0F;
    this.D = false;
    this.G = false;
    this.H = 0;
    this.I = 0;
    this.J = false;
    this.K = null;
    this.E = null;
    this.M = null;
    this.N = null;
    this.T = new hu.b()
    {
      public final void a(float paramAnonymousFloat)
      {
        AppMethodBeat.i(225631);
        oq.this.A = paramAnonymousFloat;
        if (oq.a(oq.this) != null)
        {
          oq.a(oq.this).a(oq.this.A);
          oq.this.v.alpha(oq.this.A);
        }
        if (oq.this.F != null) {
          oq.this.F.a(oq.this.v);
        }
        AppMethodBeat.o(225631);
      }
      
      public final void a(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(225651);
        oq.this.B = paramAnonymousFloat1;
        oq.this.C = paramAnonymousFloat2;
        if (oq.a(oq.this) != null) {
          oq.a(oq.this).b(oq.this.B, oq.this.C);
        }
        if (oq.this.F != null) {
          oq.this.refreshInfoWindow();
        }
        AppMethodBeat.o(225651);
      }
      
      public final void a(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(225622);
        oq.this.setRotation(paramAnonymousFloat1);
        oq.this.s = paramAnonymousFloat2;
        oq.this.t = paramAnonymousFloat3;
        oq.this.u = paramAnonymousFloat4;
        oq.this.r = true;
        if (oq.a(oq.this) != null) {
          oq.a(oq.this).a((int)oq.this.getRotation());
        }
        AppMethodBeat.o(225622);
      }
      
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(225642);
        if ((oq.b(oq.this) != null) && (oq.this.x != null))
        {
          Object localObject = new GeoPoint();
          if ((!oq.c(oq.this)) || (oq.d(oq.this) == null) || (oq.b(oq.this).e_ == null)) {
            break label326;
          }
          GeoPoint localGeoPoint = ((VectorMap)oq.b(oq.this).e_).v().a(new fl(oq.e(oq.this), oq.f(oq.this)));
          int i = localGeoPoint.getLatitudeE6();
          int j = oq.d(oq.this).getLatitudeE6();
          int k = localGeoPoint.getLongitudeE6();
          int m = oq.d(oq.this).getLongitudeE6();
          ((GeoPoint)localObject).setLatitudeE6(i - j + paramAnonymousInt1);
          ((GeoPoint)localObject).setLongitudeE6(k - m + paramAnonymousInt2);
          localObject = ((VectorMap)oq.b(oq.this).e_).v().a((GeoPoint)localObject);
          oq.this.x.setLatitudeE6((int)((fl)localObject).b);
          oq.this.x.setLongitudeE6((int)((fl)localObject).a);
        }
        for (;;)
        {
          if (oq.this.v != null) {
            oq.this.v.position(jz.a(oq.this.x));
          }
          if (oq.a(oq.this) != null) {
            oq.a(oq.this).a(oq.this.x);
          }
          if (oq.this.F != null) {
            oq.this.F.a(jz.a(oq.this.x));
          }
          AppMethodBeat.o(225642);
          return;
          label326:
          oq.this.x.setLatitudeE6(paramAnonymousInt1 + 0);
          oq.this.x.setLongitudeE6(paramAnonymousInt2 + 0);
        }
      }
      
      public final void b(float paramAnonymousFloat) {}
    };
    this.E = paramsj;
    setClickable(true);
    AppMethodBeat.o(221975);
  }
  
  private boolean A()
  {
    return this.J;
  }
  
  private Boundable<ep> B()
  {
    return this.L;
  }
  
  private an C()
  {
    return this;
  }
  
  private boolean D()
  {
    AppMethodBeat.i(222128);
    if ((this.v != null) && (this.v.isInfoWindowEnable()) && (((this.F != null) && (this.F.g() != null)) || (!gz.a(this.v.getTitle())) || (!gz.a(this.v.getSnippet()))))
    {
      AppMethodBeat.o(222128);
      return true;
    }
    AppMethodBeat.o(222128);
    return false;
  }
  
  private boolean E()
  {
    AppMethodBeat.i(222133);
    if (this.E == null)
    {
      AppMethodBeat.o(222133);
      return false;
    }
    Rect localRect = i();
    int i = this.E.X();
    int j = this.E.Y();
    if ((localRect.left >= 0) && (localRect.top >= 0) && (localRect.right <= i) && (localRect.bottom <= j))
    {
      AppMethodBeat.o(222133);
      return true;
    }
    AppMethodBeat.o(222133);
    return false;
  }
  
  private void a(Context paramContext, BitmapDescriptor.BitmapFormator paramBitmapFormator)
  {
    AppMethodBeat.i(221983);
    if (paramBitmapFormator != null)
    {
      paramContext = paramBitmapFormator.getBitmap(paramContext);
      if ((this.w != null) && (this.w.equals(paramBitmapFormator.getBitmapId())))
      {
        AppMethodBeat.o(221983);
        return;
      }
      a(paramBitmapFormator.getBitmapId());
      a(paramContext);
    }
    AppMethodBeat.o(221983);
  }
  
  private void a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(221992);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(221992);
      return;
    }
    if (this.x == null) {
      this.x = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    for (;;)
    {
      if (this.L != null) {
        this.L.a(this.x);
      }
      if (this.F != null) {
        this.F.a(jz.a(this.x));
      }
      AppMethodBeat.o(221992);
      return;
      this.x.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.x.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
  }
  
  private void a(hu paramhu)
  {
    AppMethodBeat.i(222037);
    this.N = paramhu;
    if (this.N != null) {
      this.N.a(this.T);
    }
    AppMethodBeat.o(222037);
  }
  
  private void a(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(222120);
    if ((this.E == null) || (paramMarkerOptions == null) || (this.L != null))
    {
      AppMethodBeat.o(222120);
      return;
    }
    py localpy = new py();
    localpy.i = GeoPoint.from(paramMarkerOptions.getPosition());
    localpy.m = paramMarkerOptions.getAlpha();
    localpy.a(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV());
    localObject1 = new SecureRandom();
    Object localObject2 = new byte[20];
    ((SecureRandom)localObject1).nextBytes((byte[])localObject2);
    localObject4 = new String((byte[])localObject2);
    localObject1 = null;
    try
    {
      localObject2 = paramMarkerOptions.getIcon().getBitmap(this.E.G());
      localObject1 = localObject2;
      String str = paramMarkerOptions.getIcon().getFormater().getBitmapId();
      localObject1 = str;
      localObject4 = localObject2;
      localObject2 = localObject1;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        boolean bool;
        Object localObject3 = localObject4;
        localObject4 = localObject1;
      }
    }
    localObject1 = localpy.a((String)localObject2, new Bitmap[] { localObject4 });
    ((py)localObject1).o = ((int)paramMarkerOptions.getRotation());
    ((py)localObject1).n = paramMarkerOptions.isFlat();
    ((py)localObject1).s = ((int)paramMarkerOptions.getZIndex());
    ((py)localObject1).u = this.G;
    ((py)localObject1).y = false;
    ((py)localObject1).x = isCollisionBy(MarkerCollisionItem.POI);
    ((py)localObject1).z = paramMarkerOptions.isClockwise();
    ((py)localObject1).v = paramMarkerOptions.isFastLoad();
    ((py)localObject1).t = paramMarkerOptions.getLevel();
    this.L = new px(this, this.E, localpy);
    bool = paramMarkerOptions.isIconLooperEnable();
    if (paramMarkerOptions.getIcon().getFormater().activeSize() > 1)
    {
      this.S = -1;
      localObject1 = new hj();
      ((hj)localObject1).a(paramMarkerOptions.getIconLooperDuration());
      ((hj)localObject1).a(new hj.a()
      {
        public final void a(float paramAnonymousFloat)
        {
          AppMethodBeat.i(225625);
          super.a(paramAnonymousFloat);
          if ((oq.a(oq.this) == null) || (oq.b(oq.this) == null) || (oq.this.v == null))
          {
            AppMethodBeat.o(225625);
            return;
          }
          BitmapDescriptor localBitmapDescriptor = oq.this.v.getIcon();
          int i = Math.round(localBitmapDescriptor.getFormater().activeSize() * paramAnonymousFloat);
          if (i != oq.g(oq.this))
          {
            oq.a(oq.this, oq.b(oq.this).G(), localBitmapDescriptor.getFormater());
            localBitmapDescriptor.getFormater().nextActiveIndex();
            oq.a(oq.this, i);
          }
          AppMethodBeat.o(225625);
        }
      });
      this.L.p = ((hj)localObject1);
      ((hj)localObject1).a(bool);
    }
    AppMethodBeat.o(222120);
  }
  
  private void a(String paramString)
  {
    synchronized (this.o)
    {
      this.w = paramString;
      return;
    }
  }
  
  private void b(Bitmap paramBitmap)
  {
    AppMethodBeat.i(222015);
    synchronized (this.o)
    {
      this.m = paramBitmap;
      if (this.w == null) {
        this.w = paramBitmap.toString();
      }
      if (this.L != null) {
        this.L.a(this.w, new Bitmap[] { this.m });
      }
      AppMethodBeat.o(222015);
      return;
    }
  }
  
  private int c(boolean paramBoolean)
  {
    AppMethodBeat.i(222078);
    if ((this.m != null) && (this.L != null))
    {
      int i = this.m.getHeight();
      if (!paramBoolean)
      {
        i = (int)(i * this.L.e());
        AppMethodBeat.o(222078);
        return i;
      }
      i = (int)(i * (1.0F - this.L.e()));
      AppMethodBeat.o(222078);
      return i;
    }
    AppMethodBeat.o(222078);
    return 0;
  }
  
  private void t()
  {
    AppMethodBeat.i(222001);
    if ((this.E == null) || (!this.D))
    {
      AppMethodBeat.o(222001);
      return;
    }
    a(this.E.s());
    AppMethodBeat.o(222001);
  }
  
  private void u()
  {
    AppMethodBeat.i(222022);
    synchronized (this.o)
    {
      if ((this.m != null) && (!this.m.isRecycled())) {
        this.n = true;
      }
      AppMethodBeat.o(222022);
      return;
    }
  }
  
  private String v()
  {
    AppMethodBeat.i(222031);
    String str = "GLMarkerOverlay-" + this.b_;
    AppMethodBeat.o(222031);
    return str;
  }
  
  private Rect w()
  {
    AppMethodBeat.i(222048);
    if ((this.L != null) && (this.E != null) && (this.E.e_ != null))
    {
      localRect = this.L.b(((VectorMap)this.E.e_).v());
      AppMethodBeat.o(222048);
      return localRect;
    }
    Rect localRect = new Rect();
    AppMethodBeat.o(222048);
    return localRect;
  }
  
  private boolean x()
  {
    AppMethodBeat.i(222060);
    if (this.E == null)
    {
      AppMethodBeat.o(222060);
      return false;
    }
    if (this.N != null)
    {
      this.N.b();
      this.J = this.N.b;
      if ((this.J) && (this.E.e_ != null)) {
        ((VectorMap)this.E.e_).o.v = true;
      }
      AppMethodBeat.o(222060);
      return true;
    }
    AppMethodBeat.o(222060);
    return false;
  }
  
  private boolean y()
  {
    return this.G;
  }
  
  private int z()
  {
    AppMethodBeat.i(222088);
    if ((this.m != null) && (this.L != null))
    {
      int i = this.m.getWidth();
      i = (int)(i * this.L.d() - i * 0.5F);
      AppMethodBeat.o(222088);
      return i;
    }
    AppMethodBeat.o(222088);
    return 0;
  }
  
  public final int a()
  {
    AppMethodBeat.i(222199);
    if (this.L != null)
    {
      i = this.L.a();
      AppMethodBeat.o(222199);
      return i;
    }
    int i = super.a();
    AppMethodBeat.o(222199);
    return i;
  }
  
  public final Rect a(ep paramep)
  {
    Rect localRect1 = null;
    AppMethodBeat.i(222704);
    if (this.L == null)
    {
      AppMethodBeat.o(222704);
      return null;
    }
    Rect localRect2 = this.L.a(paramep);
    if (this.F != null) {
      localRect1 = this.F.getScreenBound(paramep);
    }
    if (localRect2 == null)
    {
      AppMethodBeat.o(222704);
      return localRect1;
    }
    if (localRect1 == null)
    {
      AppMethodBeat.o(222704);
      return localRect2;
    }
    int i = Math.min(localRect2.left, localRect1.left);
    int j = Math.max(localRect2.right, localRect1.right);
    paramep = new Rect(i, Math.min(localRect2.top, localRect1.top), j, Math.max(localRect2.bottom, localRect1.bottom));
    AppMethodBeat.o(222704);
    return paramep;
  }
  
  public final void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(222408);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(222408);
      return;
    }
    b(paramBitmap);
    u();
    AppMethodBeat.o(222408);
  }
  
  public final void a(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    this.O = paramOnMarkerClickListener;
  }
  
  public final void a(AnimationListener paramAnimationListener)
  {
    this.M = paramAnimationListener;
  }
  
  public final void a(BitmapDescriptor paramBitmapDescriptor1, BitmapDescriptor paramBitmapDescriptor2)
  {
    AppMethodBeat.i(222245);
    sj localsj = this.E;
    if (localsj == null)
    {
      AppMethodBeat.o(222245);
      return;
    }
    BitmapDescriptor localBitmapDescriptor = paramBitmapDescriptor1;
    if (paramBitmapDescriptor1 == null)
    {
      localBitmapDescriptor = paramBitmapDescriptor1;
      if (paramBitmapDescriptor2 != null) {
        localBitmapDescriptor = paramBitmapDescriptor2;
      }
    }
    if (localBitmapDescriptor == null)
    {
      AppMethodBeat.o(222245);
      return;
    }
    if (this.L != null)
    {
      paramBitmapDescriptor1 = localBitmapDescriptor.getFormater();
      a(localsj.G(), paramBitmapDescriptor1);
    }
    if (this.v != null) {
      this.v.icon(localBitmapDescriptor);
    }
    if (this.F != null) {
      this.F.f();
    }
    AppMethodBeat.o(222245);
  }
  
  public final void a(LatLng paramLatLng)
  {
    AppMethodBeat.i(222390);
    sj localsj = this.E;
    setPosition(paramLatLng);
    String str = "";
    if (localsj != null) {
      str = localsj.h;
    }
    if ((getId().equals(str)) && (this.F != null)) {
      this.F.a(paramLatLng);
    }
    AppMethodBeat.o(222390);
  }
  
  @Deprecated
  public final void a(boolean paramBoolean)
  {
    sj localsj = this.E;
    if (localsj != null) {
      localsj.i = paramBoolean;
    }
  }
  
  public final Rect b(ep paramep)
  {
    AppMethodBeat.i(222485);
    paramep = w();
    AppMethodBeat.o(222485);
    return paramep;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.G;
  }
  
  public final Point c()
  {
    AppMethodBeat.i(222652);
    Point localPoint = new Point(this.H, this.I);
    AppMethodBeat.o(222652);
    return localPoint;
  }
  
  public final TencentMap.OnMarkerClickListener d()
  {
    return this.O;
  }
  
  public final List<LatLng> e()
  {
    AppMethodBeat.i(222685);
    Object localObject1 = this.E;
    if (localObject1 == null)
    {
      AppMethodBeat.o(222685);
      return null;
    }
    Object localObject2 = (VectorMap)((bn)localObject1).e_;
    if (localObject2 == null)
    {
      AppMethodBeat.o(222685);
      return null;
    }
    localObject1 = new ArrayList();
    Object localObject5 = w();
    LatLng localLatLng;
    Object localObject4;
    if (localObject5 != null)
    {
      localObject3 = new LatLng(((Rect)localObject5).top / 1000000.0D, ((Rect)localObject5).left / 1000000.0D);
      localLatLng = new LatLng(((Rect)localObject5).bottom / 1000000.0D, ((Rect)localObject5).left / 1000000.0D);
      localObject4 = new LatLng(((Rect)localObject5).top / 1000000.0D, ((Rect)localObject5).right / 1000000.0D);
      localObject5 = new LatLng(((Rect)localObject5).bottom / 1000000.0D, ((Rect)localObject5).right / 1000000.0D);
      ((List)localObject1).add(localObject3);
      ((List)localObject1).add(localLatLng);
      ((List)localObject1).add(localObject4);
      ((List)localObject1).add(localObject5);
    }
    Object localObject3 = this.F;
    if ((localObject3 != null) && (((en)localObject3).c()))
    {
      localObject4 = ((en)localObject3).getBound(((VectorMap)localObject2).v());
      if (localObject4 != null)
      {
        localObject2 = new LatLng(((Rect)localObject4).top / 1000000.0D, ((Rect)localObject4).left / 1000000.0D);
        localObject3 = new LatLng(((Rect)localObject4).bottom / 1000000.0D, ((Rect)localObject4).left / 1000000.0D);
        localLatLng = new LatLng(((Rect)localObject4).top / 1000000.0D, ((Rect)localObject4).right / 1000000.0D);
        localObject4 = new LatLng(((Rect)localObject4).bottom / 1000000.0D, ((Rect)localObject4).right / 1000000.0D);
        ((List)localObject1).add(localObject2);
        ((List)localObject1).add(localObject3);
        ((List)localObject1).add(localLatLng);
        ((List)localObject1).add(localObject4);
      }
    }
    AppMethodBeat.o(222685);
    return localObject1;
  }
  
  public final List<Boundable<ep>> f()
  {
    AppMethodBeat.i(222688);
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(this.L);
    en localen = this.F;
    if ((localen != null) && (localen.c())) {
      localArrayList.add(this.F);
    }
    AppMethodBeat.o(222688);
    return localArrayList;
  }
  
  public final TencentMap.InfoWindowAdapter g()
  {
    if (this.E != null) {
      return this.E.aI;
    }
    return null;
  }
  
  public final float getAlpha()
  {
    return this.A;
  }
  
  public final float getAnchorU()
  {
    AppMethodBeat.i(222373);
    float f = this.v.getAnchorU();
    AppMethodBeat.o(222373);
    return f;
  }
  
  public final float getAnchorV()
  {
    AppMethodBeat.i(222383);
    float f = this.v.getAnchorV();
    AppMethodBeat.o(222383);
    return f;
  }
  
  public final String getContentDescription()
  {
    AppMethodBeat.i(222509);
    if (this.v == null)
    {
      AppMethodBeat.o(222509);
      return null;
    }
    String str = this.v.getContentDescription();
    AppMethodBeat.o(222509);
    return str;
  }
  
  @Deprecated
  public final int getDisplayLevel()
  {
    AppMethodBeat.i(222596);
    int i = getLevel();
    AppMethodBeat.o(222596);
    return i;
  }
  
  public final int getHeight(Context paramContext)
  {
    AppMethodBeat.i(222589);
    BitmapDescriptor localBitmapDescriptor = this.v.getIcon();
    if (localBitmapDescriptor == null)
    {
      AppMethodBeat.o(222589);
      return 0;
    }
    paramContext = localBitmapDescriptor.getFormater().getBitmap(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(222589);
      return 0;
    }
    int i = paramContext.getHeight();
    AppMethodBeat.o(222589);
    return i;
  }
  
  @Deprecated
  public final TencentMap.OnMarkerDragListener getOnDragListener()
  {
    return null;
  }
  
  public final MarkerOptions getOptions()
  {
    return this.v;
  }
  
  public final LatLng getPosition()
  {
    return this.Q;
  }
  
  public final String getSnippet()
  {
    AppMethodBeat.i(222350);
    if (this.v != null)
    {
      String str = this.v.getSnippet();
      AppMethodBeat.o(222350);
      return str;
    }
    AppMethodBeat.o(222350);
    return null;
  }
  
  public final Object getTag()
  {
    return this.a;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(222333);
    if (this.v != null)
    {
      String str = this.v.getTitle();
      AppMethodBeat.o(222333);
      return str;
    }
    AppMethodBeat.o(222333);
    return null;
  }
  
  public final int getWidth(Context paramContext)
  {
    AppMethodBeat.i(222581);
    BitmapDescriptor localBitmapDescriptor = this.v.getIcon();
    if (localBitmapDescriptor == null)
    {
      AppMethodBeat.o(222581);
      return 0;
    }
    paramContext = localBitmapDescriptor.getFormater().getBitmap(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(222581);
      return 0;
    }
    int i = paramContext.getWidth();
    AppMethodBeat.o(222581);
    return i;
  }
  
  public final en h()
  {
    return this.F;
  }
  
  public final void h_()
  {
    AppMethodBeat.i(222451);
    sj localsj = this.E;
    if (localsj != null)
    {
      String str = localsj.h;
      if (getId().equals(str)) {
        localsj.b("");
      }
    }
    if (this.L != null) {
      this.L.h();
    }
    if (this.F != null) {
      this.F.remove();
    }
    this.E = null;
    AppMethodBeat.o(222451);
  }
  
  public final boolean handleOnTap()
  {
    return true;
  }
  
  public final void hideInfoWindow()
  {
    AppMethodBeat.i(222714);
    if (this.E == null)
    {
      AppMethodBeat.o(222714);
      return;
    }
    this.E.b("");
    ((VectorMap)this.E.e_).o.v = true;
    synchronized (this.E.g)
    {
      if (this.F == null)
      {
        AppMethodBeat.o(222714);
        return;
      }
      this.F.b(false);
      this.P = false;
      AppMethodBeat.o(222714);
      return;
    }
  }
  
  public final Rect i()
  {
    AppMethodBeat.i(222490);
    if ((this.L != null) && (this.E != null) && (this.E.e_ != null))
    {
      localRect = this.L.a(((VectorMap)this.E.e_).v());
      AppMethodBeat.o(222490);
      return localRect;
    }
    Rect localRect = new Rect();
    AppMethodBeat.o(222490);
    return localRect;
  }
  
  public final boolean isCollisionBy(final Collision paramCollision)
  {
    AppMethodBeat.i(222765);
    if (this.R != null)
    {
      boolean bool = Util.where(this.R, new ReturnCallback()
      {
        private Boolean a(Collision paramAnonymousCollision)
        {
          AppMethodBeat.i(225571);
          if (paramAnonymousCollision == paramCollision) {}
          for (boolean bool = true;; bool = false)
          {
            AppMethodBeat.o(225571);
            return Boolean.valueOf(bool);
          }
        }
      });
      AppMethodBeat.o(222765);
      return bool;
    }
    AppMethodBeat.o(222765);
    return false;
  }
  
  public final boolean isFastLoad()
  {
    AppMethodBeat.i(222573);
    if (this.L == null)
    {
      AppMethodBeat.o(222573);
      return false;
    }
    boolean bool = this.L.i();
    AppMethodBeat.o(222573);
    return bool;
  }
  
  public final boolean isInMapCenterState()
  {
    return this.D;
  }
  
  @Deprecated
  public final boolean isInfoWindowAutoOverturn()
  {
    return false;
  }
  
  public final boolean isInfoWindowEnable()
  {
    AppMethodBeat.i(222298);
    if (this.v != null)
    {
      boolean bool = this.v.isInfoWindowEnable();
      AppMethodBeat.o(222298);
      return bool;
    }
    AppMethodBeat.o(222298);
    return false;
  }
  
  public final boolean isInfoWindowShown()
  {
    AppMethodBeat.i(222738);
    if ((this.E == null) || (this.v == null) || (this.F == null))
    {
      AppMethodBeat.o(222738);
      return false;
    }
    boolean bool = this.F.c();
    AppMethodBeat.o(222738);
    return bool;
  }
  
  public final void j() {}
  
  public final void j_()
  {
    AppMethodBeat.i(222418);
    if (this.E == null)
    {
      AppMethodBeat.o(222418);
      return;
    }
    if (!isVisible())
    {
      releaseData();
      AppMethodBeat.o(222418);
      return;
    }
    if ((this.E == null) || (!this.D)) {}
    for (;;)
    {
      if ((this.E != null) && (this.N != null))
      {
        this.N.b();
        this.J = this.N.b;
        if ((this.J) && (this.E.e_ != null)) {
          ((VectorMap)this.E.e_).o.v = true;
        }
      }
      if ((this.E != null) && (this.E.e_ != null))
      {
        if ((((VectorMap)this.E.e_).o.l != null) && (this.L != null)) {
          this.L.j_();
        }
        if ((this.P) && ((this.F == null) || (!this.F.c()))) {
          showInfoWindow();
        }
        if ((this.F != null) && (this.F.c())) {
          this.F.a(null);
        }
      }
      AppMethodBeat.o(222418);
      return;
      a(this.E.s());
    }
  }
  
  public final boolean k()
  {
    AppMethodBeat.i(222754);
    if ((this.a != null) && ("AUTH_MARKER".equals(this.a.toString())))
    {
      AppMethodBeat.o(222754);
      return true;
    }
    AppMethodBeat.o(222754);
    return false;
  }
  
  public final boolean onTap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222426);
    if ((this.E == null) || (!isClickable()))
    {
      AppMethodBeat.o(222426);
      return false;
    }
    if (this.L != null)
    {
      boolean bool = this.L.onTap(paramFloat1, paramFloat2);
      if ((bool) && (this.O != null)) {
        this.O.onMarkerClick(this);
      }
      AppMethodBeat.o(222426);
      return bool;
    }
    AppMethodBeat.o(222426);
    return false;
  }
  
  @Deprecated
  public final boolean onTapMapViewBubbleHidden()
  {
    return false;
  }
  
  public final void refreshInfoWindow()
  {
    AppMethodBeat.i(222733);
    if (!isInfoWindowEnable())
    {
      AppMethodBeat.o(222733);
      return;
    }
    if ((this.F != null) && (this.F.c())) {
      this.F.f();
    }
    AppMethodBeat.o(222733);
  }
  
  public final void releaseData()
  {
    AppMethodBeat.i(222438);
    if (this.F != null)
    {
      this.F.remove();
      this.F = null;
    }
    if (this.L != null) {
      this.L.h();
    }
    AppMethodBeat.o(222438);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(222549);
    this.A = paramFloat;
    if (this.v != null) {
      this.v.alpha(paramFloat);
    }
    if (this.L != null) {
      this.L.a(paramFloat);
    }
    q();
    AppMethodBeat.o(222549);
  }
  
  public final void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222366);
    if (this.v != null) {
      this.v.anchor(paramFloat1, paramFloat2);
    }
    float f;
    if (paramFloat1 > 1.0F)
    {
      f = 1.0F;
      if (paramFloat2 <= 1.0F) {
        break label107;
      }
      paramFloat1 = 1.0F;
    }
    for (;;)
    {
      this.p = f;
      this.q = paramFloat1;
      if (this.L != null) {
        this.L.a(this.p, this.q);
      }
      if (this.F != null) {
        this.F.i_();
      }
      AppMethodBeat.o(222366);
      return;
      f = paramFloat1;
      if (paramFloat1 >= 0.0F) {
        break;
      }
      f = 0.0F;
      break;
      label107:
      paramFloat1 = paramFloat2;
      if (paramFloat2 < 0.0F) {
        paramFloat1 = 0.0F;
      }
    }
  }
  
  public final void setAnimation(Animation paramAnimation)
  {
    AppMethodBeat.i(222458);
    sj localsj = this.E;
    if (localsj == null)
    {
      AppMethodBeat.o(222458);
      return;
    }
    paramAnimation = ic.a(localsj.d_, paramAnimation);
    if (paramAnimation != null)
    {
      this.N = paramAnimation.a;
      if (this.N != null) {
        this.N.a(this.T);
      }
    }
    AppMethodBeat.o(222458);
  }
  
  public final void setCollisions(Collision... paramVarArgs)
  {
    AppMethodBeat.i(222761);
    this.R = paramVarArgs;
    paramVarArgs = this.L;
    if (paramVarArgs == null)
    {
      AppMethodBeat.o(222761);
      return;
    }
    paramVarArgs.b(isCollisionBy(MarkerCollisionItem.POI));
    paramVarArgs.g();
    AppMethodBeat.o(222761);
  }
  
  public final void setContentDescription(String paramString)
  {
    AppMethodBeat.i(222500);
    if (this.v != null) {
      this.v.contentDescription(paramString);
    }
    AppMethodBeat.o(222500);
  }
  
  public final void setDraggable(boolean paramBoolean)
  {
    AppMethodBeat.i(222534);
    super.setDraggable(paramBoolean);
    if (this.v != null) {
      this.v.draggable(paramBoolean);
    }
    AppMethodBeat.o(222534);
  }
  
  public final void setFastLoad(boolean paramBoolean)
  {
    AppMethodBeat.i(222563);
    if (this.L == null)
    {
      AppMethodBeat.o(222563);
      return;
    }
    this.L.c(paramBoolean);
    q();
    AppMethodBeat.o(222563);
  }
  
  public final void setFixingPoint(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222647);
    this.H = paramInt1;
    this.I = paramInt2;
    if (this.L != null)
    {
      setFixingPointEnable(true);
      GeoPoint localGeoPoint = new GeoPoint(this.I, this.H);
      this.L.a(localGeoPoint);
    }
    if (this.F != null) {
      this.F.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(222647);
  }
  
  public final void setFixingPointEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(222640);
    this.G = paramBoolean;
    if (this.L != null) {
      this.L.a(paramBoolean);
    }
    if (this.F != null)
    {
      if (!paramBoolean) {
        break label65;
      }
      this.F.a(this.H, this.I);
    }
    for (;;)
    {
      q();
      AppMethodBeat.o(222640);
      return;
      label65:
      this.F.a(false);
    }
  }
  
  public final void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(222235);
    Object localObject = this.E;
    if (localObject == null)
    {
      AppMethodBeat.o(222235);
      return;
    }
    BitmapDescriptor localBitmapDescriptor = BitmapDescriptorFactory.defaultMarker(((bn)localObject).d_);
    sj localsj = this.E;
    if (localsj != null)
    {
      localObject = paramBitmapDescriptor;
      if (paramBitmapDescriptor == null)
      {
        localObject = paramBitmapDescriptor;
        if (localBitmapDescriptor != null) {
          localObject = localBitmapDescriptor;
        }
      }
      if (localObject != null)
      {
        if (this.L != null)
        {
          paramBitmapDescriptor = ((BitmapDescriptor)localObject).getFormater();
          a(localsj.G(), paramBitmapDescriptor);
        }
        if (this.v != null) {
          this.v.icon((BitmapDescriptor)localObject);
        }
        if (this.F != null) {
          this.F.f();
        }
      }
    }
    AppMethodBeat.o(222235);
  }
  
  public final void setInMapCenterState(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public final void setInfoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222617);
    if (this.v != null) {
      this.v.infoWindowAnchor(paramFloat1, paramFloat2);
    }
    if (this.F != null) {
      this.F.f();
    }
    q();
    AppMethodBeat.o(222617);
  }
  
  public final void setInfoWindowEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(222289);
    if (this.v != null) {
      this.v.infoWindowEnable(paramBoolean);
    }
    if ((this.F != null) && (this.F.c())) {
      this.F.b(paramBoolean);
    }
    AppMethodBeat.o(222289);
  }
  
  public final void setInfoWindowOffset(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222623);
    if (this.v != null) {
      this.v.infoWindowOffset(paramInt1, paramInt2);
    }
    if (this.F != null) {
      this.F.f();
    }
    q();
    AppMethodBeat.o(222623);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(222255);
    super.setLevel(paramInt);
    if (this.L != null) {
      this.L.setLevel(paramInt);
    }
    if (this.v != null) {
      this.v.level(paramInt);
    }
    AppMethodBeat.o(222255);
  }
  
  public final void setMarkerOptions(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(222220);
    if ((this.E == null) || (paramMarkerOptions == null))
    {
      AppMethodBeat.o(222220);
      return;
    }
    this.v = paramMarkerOptions;
    this.l = true;
    setTitle(paramMarkerOptions.getTitle());
    setDraggable(paramMarkerOptions.isDraggable());
    setPosition(paramMarkerOptions.getPosition());
    setSnippet(paramMarkerOptions.getSnippet());
    setAnchor(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV());
    setVisible(paramMarkerOptions.isVisible());
    setRotation(paramMarkerOptions.getRotation());
    setIcon(paramMarkerOptions.getIcon());
    setAlpha(paramMarkerOptions.getAlpha());
    setZIndex(paramMarkerOptions.getZIndex());
    setLevel(paramMarkerOptions.getLevel());
    a(paramMarkerOptions.getIndoorInfo());
    setTag(paramMarkerOptions.getTag());
    setCollisions(paramMarkerOptions.getCollisions());
    MarkerOptions localMarkerOptions = getOptions();
    if ((this.E == null) || (localMarkerOptions == null) || (this.L != null)) {}
    for (;;)
    {
      r();
      AppMethodBeat.o(222220);
      return;
      py localpy = new py();
      localpy.i = GeoPoint.from(localMarkerOptions.getPosition());
      localpy.m = localMarkerOptions.getAlpha();
      localpy.a(localMarkerOptions.getAnchorU(), localMarkerOptions.getAnchorV());
      paramMarkerOptions = new SecureRandom();
      Object localObject1 = new byte[20];
      paramMarkerOptions.nextBytes((byte[])localObject1);
      localObject3 = new String((byte[])localObject1);
      paramMarkerOptions = null;
      try
      {
        localObject1 = localMarkerOptions.getIcon().getBitmap(this.E.G());
        paramMarkerOptions = (MarkerOptions)localObject1;
        String str = localMarkerOptions.getIcon().getFormater().getBitmapId();
        paramMarkerOptions = str;
        localObject3 = localObject1;
        localObject1 = paramMarkerOptions;
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          boolean bool;
          Object localObject2 = localObject3;
          localObject3 = paramMarkerOptions;
        }
      }
      paramMarkerOptions = localpy.a((String)localObject1, new Bitmap[] { localObject3 });
      paramMarkerOptions.o = ((int)localMarkerOptions.getRotation());
      paramMarkerOptions.n = localMarkerOptions.isFlat();
      paramMarkerOptions.s = ((int)localMarkerOptions.getZIndex());
      paramMarkerOptions.u = this.G;
      paramMarkerOptions.y = false;
      paramMarkerOptions.x = isCollisionBy(MarkerCollisionItem.POI);
      paramMarkerOptions.z = localMarkerOptions.isClockwise();
      paramMarkerOptions.v = localMarkerOptions.isFastLoad();
      paramMarkerOptions.t = localMarkerOptions.getLevel();
      this.L = new px(this, this.E, localpy);
      bool = localMarkerOptions.isIconLooperEnable();
      if (localMarkerOptions.getIcon().getFormater().activeSize() > 1)
      {
        this.S = -1;
        paramMarkerOptions = new hj();
        paramMarkerOptions.a(localMarkerOptions.getIconLooperDuration());
        paramMarkerOptions.a(new hj.a()
        {
          public final void a(float paramAnonymousFloat)
          {
            AppMethodBeat.i(225625);
            super.a(paramAnonymousFloat);
            if ((oq.a(oq.this) == null) || (oq.b(oq.this) == null) || (oq.this.v == null))
            {
              AppMethodBeat.o(225625);
              return;
            }
            BitmapDescriptor localBitmapDescriptor = oq.this.v.getIcon();
            int i = Math.round(localBitmapDescriptor.getFormater().activeSize() * paramAnonymousFloat);
            if (i != oq.g(oq.this))
            {
              oq.a(oq.this, oq.b(oq.this).G(), localBitmapDescriptor.getFormater());
              localBitmapDescriptor.getFormater().nextActiveIndex();
              oq.a(oq.this, i);
            }
            AppMethodBeat.o(225625);
          }
        });
        this.L.p = paramMarkerOptions;
        paramMarkerOptions.a(bool);
      }
    }
  }
  
  @Deprecated
  public final void setOnTapMapViewBubbleHidden(boolean paramBoolean) {}
  
  public final void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(222278);
    this.Q = paramLatLng;
    if (paramLatLng != null) {
      a(GeoPoint.from(paramLatLng));
    }
    if (this.v != null) {
      this.v.position(paramLatLng);
    }
    AppMethodBeat.o(222278);
  }
  
  public final void setRotation(float paramFloat)
  {
    AppMethodBeat.i(222357);
    super.setRotation(paramFloat);
    if (this.L != null) {
      this.L.a((int)getRotation());
    }
    if (this.v != null) {
      this.v.rotation(paramFloat);
    }
    AppMethodBeat.o(222357);
  }
  
  public final void setSnippet(String paramString)
  {
    AppMethodBeat.i(222341);
    if (this.v != null) {
      this.v.snippet(paramString);
    }
    if (this.F != null) {
      this.F.f();
    }
    AppMethodBeat.o(222341);
  }
  
  public final void setTag(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(222326);
    if (this.v != null) {
      this.v.title(paramString);
    }
    if (this.F != null) {
      this.F.f();
    }
    AppMethodBeat.o(222326);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(222429);
    super.setVisible(paramBoolean);
    if (this.L != null) {
      this.L.setVisible(paramBoolean);
    }
    if ((this.E != null) && (this.E.e_ != null)) {
      ((VectorMap)this.E.e_).o.v = true;
    }
    AppMethodBeat.o(222429);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(222558);
    this.g = paramFloat;
    if (this.v != null) {
      this.v.zIndex(paramFloat);
    }
    if (this.L != null) {
      this.L.setZIndex((int)paramFloat);
    }
    q();
    AppMethodBeat.o(222558);
  }
  
  public final void showInfoWindow()
  {
    int j = 1;
    AppMethodBeat.i(222722);
    if ((this.E == null) || (this.v == null))
    {
      AppMethodBeat.o(222722);
      return;
    }
    for (;;)
    {
      synchronized (this.E.g)
      {
        if (this.F == null)
        {
          if (this.v.isViewInfowindow())
          {
            this.F = new ot(this.E, this);
            if (this.G) {
              this.F.a(this.H, this.I);
            }
            if ((this.v == null) || (!this.v.isInfoWindowEnable())) {
              break label236;
            }
            if (this.F != null)
            {
              i = j;
              if (this.F.g() != null) {}
            }
            else
            {
              i = j;
              if (gz.a(this.v.getTitle()))
              {
                if (gz.a(this.v.getSnippet())) {
                  break label236;
                }
                i = j;
              }
            }
            if (i != 0)
            {
              this.F.b(true);
              this.P = true;
            }
            AppMethodBeat.o(222722);
            return;
          }
          this.F = new op(this.E, this);
        }
      }
      this.F.f();
      continue;
      label236:
      int i = 0;
    }
  }
  
  public final void startAnimation(Animation paramAnimation)
  {
    AppMethodBeat.i(222475);
    setAnimation(paramAnimation);
    startAnimation();
    AppMethodBeat.o(222475);
  }
  
  public final boolean startAnimation()
  {
    AppMethodBeat.i(222468);
    if ((this.E == null) || (this.N == null))
    {
      AppMethodBeat.o(222468);
      return false;
    }
    GeoPoint localGeoPoint2 = this.x;
    GeoPoint localGeoPoint1 = localGeoPoint2;
    if (this.G)
    {
      localGeoPoint1 = localGeoPoint2;
      if (this.E.e_ != null)
      {
        localGeoPoint1 = ((VectorMap)this.E.e_).v().a(new fl(this.H, this.I));
        this.K = new GeoPoint(localGeoPoint1);
      }
    }
    boolean bool = this.N.a(localGeoPoint1, this.z);
    AppMethodBeat.o(222468);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.oq
 * JD-Core Version:    0.7.0.1
 */