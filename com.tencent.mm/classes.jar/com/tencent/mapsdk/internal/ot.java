package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public final class ot
  extends au<am>
  implements am, en, oc
{
  private sj d;
  private View e;
  private int f;
  private int g;
  private float h;
  private float i;
  private GeoPoint j;
  private boolean k;
  private boolean l;
  private boolean m;
  private final fl n;
  private an o;
  
  ot(sj paramsj, an paraman)
  {
    AppMethodBeat.i(221919);
    this.f = 0;
    this.g = 0;
    this.h = 0.5F;
    this.i = 0.5F;
    this.m = false;
    this.n = new fl();
    this.d = paramsj;
    this.o = paraman;
    j();
    if ((this.d == null) || (this.d.G() == null))
    {
      this.k = true;
      AppMethodBeat.o(221919);
      return;
    }
    if (this.o != null) {}
    for (paramsj = this.o.g();; paramsj = null)
    {
      this.e = op.a(this.d.G(), (bd)this.d.d_, this, paramsj, this.o);
      if (this.o == null) {
        break;
      }
      a(this.o.getPosition());
      break;
    }
  }
  
  private void j()
  {
    AppMethodBeat.i(221926);
    if ((this.d == null) || (this.d.e_ == null))
    {
      AppMethodBeat.o(221926);
      return;
    }
    ((VectorMap)this.d.e_).a(this);
    AppMethodBeat.o(221926);
  }
  
  private void k()
  {
    AppMethodBeat.i(221935);
    if ((this.d == null) || (this.d.e_ == null))
    {
      AppMethodBeat.o(221935);
      return;
    }
    mk localmk = ((VectorMap)this.d.e_).o;
    if (!localmk.I.isEmpty()) {
      localmk.I.remove(this);
    }
    AppMethodBeat.o(221935);
  }
  
  private void l()
  {
    AppMethodBeat.i(221943);
    if ((this.d == null) || (this.d.G() == null))
    {
      AppMethodBeat.o(221943);
      return;
    }
    if (this.o != null) {}
    for (TencentMap.InfoWindowAdapter localInfoWindowAdapter = this.o.g();; localInfoWindowAdapter = null)
    {
      this.e = op.a(this.d.G(), (bd)this.d.d_, this, localInfoWindowAdapter, this.o);
      if (this.o != null) {
        a(this.o.getPosition());
      }
      AppMethodBeat.o(221943);
      return;
    }
  }
  
  private void m()
  {
    AppMethodBeat.i(221950);
    Object localObject = this.d;
    if (localObject == null)
    {
      AppMethodBeat.o(221950);
      return;
    }
    final View localView = this.e;
    if (localView == null)
    {
      AppMethodBeat.o(221950);
      return;
    }
    localObject = (VectorMap)((bn)localObject).e_;
    if (localObject == null)
    {
      AppMethodBeat.o(221950);
      return;
    }
    if (((VectorMap)localObject).v() == null)
    {
      AppMethodBeat.o(221950);
      return;
    }
    localObject = o();
    if (localObject != null) {
      ((ViewGroup)localObject).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222178);
          if (!ot.a(ot.this))
          {
            localView.setVisibility(8);
            AppMethodBeat.o(222178);
            return;
          }
          localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          ot.a(ot.this, localView.getMeasuredWidth());
          ot.b(ot.this, localView.getMeasuredHeight());
          localView.layout(0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
          ViewGroup localViewGroup = ot.b(ot.this).d;
          Object localObject = ((VectorMap)ot.b(ot.this).e_).v();
          localObject = ot.this.a((ep)localObject);
          if (localObject == null)
          {
            AppMethodBeat.o(222178);
            return;
          }
          if (localView.getParent() == null) {
            localViewGroup.addView(localView);
          }
          Rect localRect = new Rect();
          localViewGroup.getLocalVisibleRect(localRect);
          if (localRect.isEmpty())
          {
            localView.setVisibility(8);
            AppMethodBeat.o(222178);
            return;
          }
          if (localRect.intersect((Rect)localObject)) {
            localView.setVisibility(0);
          }
          localView.setX(((Rect)localObject).left);
          localView.setY(((Rect)localObject).top);
          AppMethodBeat.o(222178);
        }
      });
    }
    AppMethodBeat.o(221950);
  }
  
  private am n()
  {
    return this;
  }
  
  private ViewGroup o()
  {
    sj localsj = this.d;
    if (localsj == null) {
      return null;
    }
    return localsj.d;
  }
  
  public final Rect a(ep paramep)
  {
    AppMethodBeat.i(222132);
    if ((paramep == null) || (this.e == null))
    {
      AppMethodBeat.o(222132);
      return null;
    }
    if (this.m) {}
    for (paramep = this.n; paramep == null; paramep = paramep.a(this.j))
    {
      AppMethodBeat.o(222132);
      return null;
    }
    int i2;
    int i1;
    if ((this.o != null) && (this.o.getOptions() != null))
    {
      i2 = this.o.getOptions().getInfoWindowOffsetX();
      i1 = this.o.getOptions().getInfowindowOffsetY();
    }
    for (;;)
    {
      d();
      e();
      float f1 = this.h;
      float f2 = i2 * 1.0F / this.f;
      float f3 = this.i;
      float f4 = i1 * 1.0F / this.g;
      i1 = (int)(paramep.a - (f1 - f2) * this.f);
      i2 = this.f;
      int i3 = (int)(paramep.b - (f3 - f4) * this.g);
      paramep = new Rect(i1, i3, i2 + i1, i3 + this.g);
      AppMethodBeat.o(222132);
      return paramep;
      i1 = 0;
      i2 = 0;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222099);
    a(true);
    this.n.a(paramInt1, paramInt2);
    m();
    AppMethodBeat.o(222099);
  }
  
  public final void a(LatLng paramLatLng)
  {
    AppMethodBeat.i(222079);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(222079);
      return;
    }
    if (this.j == null) {
      this.j = GeoPoint.from(paramLatLng);
    }
    for (;;)
    {
      m();
      AppMethodBeat.o(222079);
      return;
      this.j.setLatitudeE6((int)(paramLatLng.latitude * 1000000.0D));
      this.j.setLongitudeE6((int)(paramLatLng.longitude * 1000000.0D));
    }
  }
  
  public final void a(MarkerOptions paramMarkerOptions) {}
  
  public final void a(GL10 paramGL10) {}
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(222090);
    this.m = paramBoolean;
    if (paramBoolean)
    {
      k();
      AppMethodBeat.o(222090);
      return;
    }
    j();
    AppMethodBeat.o(222090);
  }
  
  public final Rect b(ep paramep)
  {
    AppMethodBeat.i(222143);
    Rect localRect = a(paramep);
    if ((localRect == null) || (paramep == null))
    {
      AppMethodBeat.o(222143);
      return null;
    }
    GeoPoint localGeoPoint = paramep.a(new fl(localRect.left, localRect.top));
    paramep = paramep.a(new fl(localRect.right, localRect.bottom));
    if ((localGeoPoint == null) || (paramep == null))
    {
      AppMethodBeat.o(222143);
      return null;
    }
    paramep = new Rect(localGeoPoint.getLongitudeE6(), localGeoPoint.getLatitudeE6(), paramep.getLongitudeE6(), paramep.getLatitudeE6());
    AppMethodBeat.o(222143);
    return paramep;
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(222039);
    if (this.e == null)
    {
      AppMethodBeat.o(222039);
      return;
    }
    this.k = paramBoolean;
    m();
    AppMethodBeat.o(222039);
  }
  
  public final boolean c()
  {
    AppMethodBeat.i(222047);
    if ((this.k) && (this.e != null) && (this.e.getVisibility() == 0))
    {
      AppMethodBeat.o(222047);
      return true;
    }
    AppMethodBeat.o(222047);
    return false;
  }
  
  public final void d()
  {
    AppMethodBeat.i(222059);
    if ((this.o == null) || (this.d.G() == null))
    {
      AppMethodBeat.o(222059);
      return;
    }
    int i3 = this.o.getWidth(this.d.G());
    if (this.o.getOptions() != null) {}
    for (float f1 = this.o.getOptions().getInfoWindowAnchorU();; f1 = 0.5F)
    {
      int i2 = this.f;
      int i1 = i2;
      if (i2 == 0) {
        i1 = 1;
      }
      float f2 = i3;
      this.h = (f1 + (this.o.getAnchorU() - 0.5F) * f2 / i1);
      AppMethodBeat.o(222059);
      return;
    }
  }
  
  public final void e()
  {
    AppMethodBeat.i(222071);
    if ((this.o == null) || (this.d.G() == null))
    {
      AppMethodBeat.o(222071);
      return;
    }
    int i3 = (int)(this.o.getHeight(this.d.G()) * this.o.getAnchorV());
    int i2 = this.g;
    float f1 = 1.0F;
    if (this.o.getOptions() != null) {
      f1 = this.o.getOptions().getInfoWindowAnchorV();
    }
    int i1 = i2;
    if (i2 == 0) {
      i1 = 1;
    }
    float f2 = i3;
    this.i = ((f1 * i1 + f2) / i1);
    AppMethodBeat.o(222071);
  }
  
  public final void f()
  {
    AppMethodBeat.i(222119);
    Object localObject = this.d;
    if (localObject == null)
    {
      AppMethodBeat.o(222119);
      return;
    }
    if (this.o != null) {}
    for (final TencentMap.InfoWindowAdapter localInfoWindowAdapter = this.o.g();; localInfoWindowAdapter = null)
    {
      final Context localContext = ((sj)localObject).G();
      localObject = (bd)((bn)localObject).d_;
      ViewGroup localViewGroup = o();
      if (localViewGroup != null) {
        localViewGroup.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(222013);
            ot.a(ot.this, op.a(localContext, this.b, ot.this, localInfoWindowAdapter, ot.c(ot.this)));
            ot.d(ot.this);
            AppMethodBeat.o(222013);
          }
        });
      }
      AppMethodBeat.o(222119);
      return;
    }
  }
  
  public final View g()
  {
    return this.e;
  }
  
  public final void h()
  {
    AppMethodBeat.i(222197);
    m();
    AppMethodBeat.o(222197);
  }
  
  public final void i()
  {
    AppMethodBeat.i(222205);
    m();
    AppMethodBeat.o(222205);
  }
  
  public final void i_()
  {
    AppMethodBeat.i(222112);
    m();
    AppMethodBeat.o(222112);
  }
  
  public final boolean isRemoved()
  {
    return this.l;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(222162);
    boolean bool = c();
    AppMethodBeat.o(222162);
    return bool;
  }
  
  public final boolean onTap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222156);
    if ((this.e == null) || (!this.k) || (this.d == null) || (this.d.e_ == null) || (((VectorMap)this.d.e_).v() == null))
    {
      AppMethodBeat.o(222156);
      return false;
    }
    Rect localRect = a(((VectorMap)this.d.e_).v());
    if ((localRect == null) || (localRect.isEmpty()))
    {
      AppMethodBeat.o(222156);
      return false;
    }
    boolean bool = localRect.contains((int)paramFloat1, (int)paramFloat2);
    AppMethodBeat.o(222156);
    return bool;
  }
  
  public final void releaseData()
  {
    AppMethodBeat.i(222190);
    k();
    AppMethodBeat.o(222190);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(222169);
    final View localView = this.e;
    if (localView == null)
    {
      AppMethodBeat.o(222169);
      return;
    }
    final ViewParent localViewParent = localView.getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(221993);
          ((ViewGroup)localViewParent).removeView(localView);
          if ((localView instanceof ViewGroup)) {
            ((ViewGroup)localView).removeAllViews();
          }
          ot.this.releaseData();
          AppMethodBeat.o(221993);
        }
      });
    }
    this.l = true;
    AppMethodBeat.o(222169);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(222182);
    b(paramBoolean);
    AppMethodBeat.o(222182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ot
 * JD-Core Version:    0.7.0.1
 */