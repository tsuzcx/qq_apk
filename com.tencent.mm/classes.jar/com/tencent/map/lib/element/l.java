package com.tencent.map.lib.element;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.gt;
import com.tencent.tencentmap.mapsdk.maps.a.hl;
import com.tencent.tencentmap.mapsdk.maps.a.hu;
import com.tencent.tencentmap.mapsdk.maps.a.if;
import com.tencent.tencentmap.mapsdk.maps.a.ih;

public class l
  implements j
{
  protected m a;
  protected GLIcon b;
  protected n c;
  protected DoublePoint d;
  private hl e;
  private boolean f;
  private gt g;
  
  public l()
  {
    AppMethodBeat.i(97883);
    this.d = new DoublePoint();
    this.g = null;
    this.f = true;
    AppMethodBeat.o(97883);
  }
  
  public l(m paramm)
  {
    AppMethodBeat.i(97884);
    this.d = new DoublePoint();
    this.g = null;
    this.a = paramm;
    this.b = new GLIcon(this.a.c(), this.a.a(), this.a.f(), this.a.g(), this.a.k(), this.a.l(), this.a.b());
    this.b.setFixPos(paramm.o());
    this.b.setFastLoad(paramm.p());
    this.b.setRotateAngle(paramm.h());
    this.b.setAvoidAnno(paramm.j());
    this.b.setAlpha(paramm.e());
    this.f = true;
    AppMethodBeat.o(97884);
  }
  
  public Rect a(hu paramhu)
  {
    AppMethodBeat.i(146995);
    if ((this.b == null) || (this.a == null) || (this.a.a() == null))
    {
      AppMethodBeat.o(146995);
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (e())
    {
      localObject1 = a();
      localObject2 = new DoublePoint(0.0D, 0.0D);
      if (localObject1 != null)
      {
        ((DoublePoint)localObject2).x = ((GeoPoint)localObject1).getLongitudeE6();
        ((DoublePoint)localObject2).y = ((GeoPoint)localObject1).getLatitudeE6();
      }
    }
    for (this.d = ((DoublePoint)localObject2);; this.d = paramhu.b(a()))
    {
      localObject2 = new DoublePoint();
      localObject1 = new DoublePoint();
      Bitmap localBitmap = this.b.getTextureBm(this.b.getState());
      int j = localBitmap.getWidth();
      int i = localBitmap.getHeight();
      ((DoublePoint)localObject2).x = this.d.x;
      ((DoublePoint)localObject1).x = (this.d.x + j);
      ((DoublePoint)localObject2).y = this.d.y;
      ((DoublePoint)localObject1).y = (this.d.y + i);
      float f1 = this.a.f();
      j = (int)(j * f1);
      f1 = this.a.g();
      i = (int)(i * f1);
      ((DoublePoint)localObject2).x -= j;
      ((DoublePoint)localObject1).x -= j;
      ((DoublePoint)localObject2).y -= i;
      ((DoublePoint)localObject1).y -= i;
      i = this.a.k();
      j = this.a.l();
      ((DoublePoint)localObject2).x += i;
      ((DoublePoint)localObject1).x += i;
      ((DoublePoint)localObject2).y += j;
      double d1 = ((DoublePoint)localObject1).y;
      ((DoublePoint)localObject1).y = (j + d1);
      localObject2 = paramhu.a((DoublePoint)localObject2);
      paramhu = paramhu.a((DoublePoint)localObject1);
      paramhu = new Rect(((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject2).getLatitudeE6(), paramhu.getLongitudeE6(), paramhu.getLatitudeE6());
      AppMethodBeat.o(146995);
      return paramhu;
    }
  }
  
  public GeoPoint a()
  {
    AppMethodBeat.i(97893);
    GeoPoint localGeoPoint = this.a.a();
    AppMethodBeat.o(97893);
    return localGeoPoint;
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(97895);
    this.a = this.a.a(paramFloat);
    if (this.b != null)
    {
      this.b.setAlpha(paramFloat);
      this.b.setDirty(true);
    }
    AppMethodBeat.o(97895);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97896);
    this.a = this.a.a(paramFloat1, paramFloat2);
    if (this.b != null)
    {
      this.b.setAnchor(paramFloat1, paramFloat2);
      this.b.setDirty(true);
    }
    AppMethodBeat.o(97896);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(97892);
    this.a = this.a.c(paramInt);
    if (this.b != null) {
      this.b.setDirty(true);
    }
    AppMethodBeat.o(97892);
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(97891);
    this.a = this.a.a(paramGeoPoint);
    if (this.b != null)
    {
      this.b.setPosition(paramGeoPoint);
      this.b.setDirty(true);
    }
    AppMethodBeat.o(97891);
  }
  
  public void a(m paramm)
  {
    AppMethodBeat.i(97885);
    if (paramm == null)
    {
      AppMethodBeat.o(97885);
      return;
    }
    if (this.a == null) {
      this.a = paramm;
    }
    for (;;)
    {
      if (this.b == null) {
        this.b = new GLIcon(this.a.c(), this.a.a(), this.a.f(), this.a.g(), this.a.k(), this.a.l(), this.a.b());
      }
      this.b.setAlpha(this.a.e());
      this.b.setAnchor(this.a.f(), this.a.g());
      this.b.setRotateAngle(paramm.h());
      this.b.setFixPos(paramm.o());
      this.b.setFastLoad(paramm.p());
      this.b.setAvoidAnno(paramm.j());
      AppMethodBeat.o(97885);
      return;
      this.a.a(paramm.e());
      this.a.a(paramm.f(), paramm.g());
      this.a.b(paramm.d());
      this.a.a(paramm.h());
      this.a.b(paramm.m());
      this.a.c(paramm.j());
      this.a.c(paramm.n());
    }
  }
  
  public void a(String paramString, Bitmap... paramVarArgs)
  {
    AppMethodBeat.i(97890);
    this.a = this.a.a(paramString, paramVarArgs);
    if (this.b != null)
    {
      this.b.update(paramString, paramVarArgs);
      this.b.setDirty(true);
    }
    AppMethodBeat.o(97890);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(hu paramhu, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146994);
    if ((!d()) || (this.a.a() == null) || (this.e == null))
    {
      AppMethodBeat.o(146994);
      return false;
    }
    paramhu = this.e.f().a(paramFloat1, paramFloat2);
    if ((paramhu != null) && (paramhu.itemId == f())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.b.setState(1);
      }
      for (;;)
      {
        if ((bool) && (this.c != null)) {
          this.c.a(this);
        }
        AppMethodBeat.o(146994);
        return bool;
        this.b.setState(0);
      }
    }
  }
  
  public float b()
  {
    AppMethodBeat.i(97897);
    float f1 = this.a.f();
    AppMethodBeat.o(97897);
    return f1;
  }
  
  public Rect b(hu paramhu)
  {
    AppMethodBeat.i(146996);
    if ((this.b == null) || (this.a == null) || (this.a.a() == null))
    {
      AppMethodBeat.o(146996);
      return null;
    }
    DoublePoint localDoublePoint;
    int j;
    int i;
    if (e())
    {
      paramhu = a();
      localDoublePoint = new DoublePoint(0.0D, 0.0D);
      if (paramhu != null)
      {
        localDoublePoint.x = paramhu.getLongitudeE6();
        localDoublePoint.y = paramhu.getLatitudeE6();
      }
      this.d = localDoublePoint;
      paramhu = new DoublePoint();
      localDoublePoint = new DoublePoint();
      Bitmap localBitmap = this.b.getTextureBm(this.b.getState());
      if (localBitmap == null) {
        break label405;
      }
      j = localBitmap.getWidth();
      i = localBitmap.getHeight();
    }
    for (;;)
    {
      paramhu.x = this.d.x;
      localDoublePoint.x = (this.d.x + j);
      paramhu.y = this.d.y;
      localDoublePoint.y = (this.d.y + i);
      j = (int)(this.a.f() * j);
      float f1 = this.a.g();
      i = (int)(i * f1);
      paramhu.x -= j;
      localDoublePoint.x -= j;
      paramhu.y -= i;
      localDoublePoint.y -= i;
      i = this.a.k();
      j = this.a.l();
      paramhu.x += i;
      localDoublePoint.x += i;
      paramhu.y += j;
      double d1 = localDoublePoint.y;
      localDoublePoint.y = (j + d1);
      paramhu = new Rect((int)paramhu.x, (int)paramhu.y, (int)localDoublePoint.x, (int)localDoublePoint.y);
      AppMethodBeat.o(146996);
      return paramhu;
      this.d = paramhu.b(a());
      break;
      label405:
      i = 0;
      j = 0;
    }
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97899);
    if (this.b != null)
    {
      this.b.setScale(paramFloat1, paramFloat2);
      this.b.setDirty(true);
    }
    AppMethodBeat.o(97899);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(97894);
    this.a = this.a.a(paramInt);
    if (this.b != null)
    {
      this.b.setRotateAngle(paramInt);
      this.b.setDirty(true);
    }
    AppMethodBeat.o(97894);
  }
  
  public void b(ih paramih, hu paramhu)
  {
    AppMethodBeat.i(146993);
    if (!d())
    {
      if (this.b != null) {
        this.b.mDisplayId = -1;
      }
      AppMethodBeat.o(146993);
      return;
    }
    this.e = paramih.b();
    if (this.g != null)
    {
      if (this.g.b()) {
        break label138;
      }
      this.g.a();
    }
    for (;;)
    {
      if (this.b != null) {
        paramih.a(this.a.a(), this.b, this.a.d(), this.a.h(), this.a.i(), this.a.q(), this.a.m(), this.a.n());
      }
      AppMethodBeat.o(146993);
      return;
      label138:
      this.g = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(97901);
    if (this.b != null)
    {
      this.b.setFixPos(paramBoolean);
      this.b.setDirty(true);
    }
    AppMethodBeat.o(97901);
  }
  
  public float c()
  {
    AppMethodBeat.i(97898);
    float f1 = this.a.g();
    AppMethodBeat.o(97898);
    return f1;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(97900);
    this.a = this.a.b(paramInt);
    if (this.b != null) {
      this.b.setDirty(true);
    }
    AppMethodBeat.o(97900);
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    AppMethodBeat.i(97902);
    if (this.b != null)
    {
      boolean bool = this.b.isFixPos();
      AppMethodBeat.o(97902);
      return bool;
    }
    AppMethodBeat.o(97902);
    return false;
  }
  
  public int f()
  {
    if (this.b != null) {
      return this.b.mDisplayId;
    }
    return -1;
  }
  
  public void g()
  {
    if (this.b != null) {
      this.b.mDisplayId = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.element.l
 * JD-Core Version:    0.7.0.1
 */