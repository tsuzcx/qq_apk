package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.concurrent.atomic.AtomicInteger;

public final class op
  extends oo<am>
  implements am, en
{
  static final float m = 5.0F;
  private static AtomicInteger x;
  private int A;
  private px n;
  private Bitmap o;
  private int p;
  private int q;
  private GeoPoint r;
  private sj s;
  private an t;
  private boolean u;
  private float v;
  private float w;
  private boolean y;
  private View z;
  
  static
  {
    AppMethodBeat.i(222092);
    x = new AtomicInteger(0);
    AppMethodBeat.o(222092);
  }
  
  op(sj paramsj, an paraman)
  {
    super(paramsj);
    AppMethodBeat.i(221976);
    this.o = null;
    this.p = 0;
    this.q = 0;
    this.r = null;
    this.s = null;
    this.t = null;
    this.u = false;
    this.v = 0.5F;
    this.w = 0.5F;
    this.y = false;
    this.s = paramsj;
    this.t = paraman;
    if ((this.s == null) || (this.t == null) || (this.t.getOptions() == null))
    {
      AppMethodBeat.o(221976);
      return;
    }
    i();
    if (((VectorMap)this.s.e_).o.l != null)
    {
      this.n = new px(this, this.s, b(this.t.getOptions()));
      kh.a("create InfoWindowView:" + this.z);
      a(gv.a(this.z));
    }
    AppMethodBeat.o(221976);
  }
  
  static View a(Context paramContext, bd parambd, en paramen, TencentMap.InfoWindowAdapter paramInfoWindowAdapter, Marker paramMarker)
  {
    AppMethodBeat.i(222008);
    if ((paramContext == null) || (paramen == null) || (paramMarker == null) || (parambd == null))
    {
      AppMethodBeat.o(222008);
      return null;
    }
    String str1 = paramMarker.getTitle();
    String str2 = paramMarker.getSnippet();
    if (paramInfoWindowAdapter == null)
    {
      if ((gz.a(str1)) && (gz.a(str2)))
      {
        AppMethodBeat.o(222008);
        return null;
      }
      paramContext = a(paramContext, parambd, paramen, str1, str2);
      AppMethodBeat.o(222008);
      return paramContext;
    }
    paramen = (LinearLayout)paramen.g();
    if (paramen == null) {}
    for (paramContext = a(paramContext);; paramContext = paramen)
    {
      paramen = (av)parambd.c().d.a(paramMarker.getId(), av.class);
      if (paramen == null)
      {
        AppMethodBeat.o(222008);
        return null;
      }
      paramMarker = paramInfoWindowAdapter.getInfoWindow(paramen);
      if (paramMarker != null)
      {
        if (paramMarker.getParent() == paramContext)
        {
          AppMethodBeat.o(222008);
          return paramContext;
        }
        if ((paramMarker.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramMarker.getParent()).removeAllViews();
        }
        paramContext.setBackgroundDrawable(null);
        paramContext.removeAllViews();
        paramContext.addView(paramMarker);
        AppMethodBeat.o(222008);
        return paramContext;
      }
      paramen = paramInfoWindowAdapter.getInfoContents(paramen);
      if (paramen != null)
      {
        if (paramen.getParent() == paramContext)
        {
          AppMethodBeat.o(222008);
          return paramContext;
        }
        if ((paramen.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramen.getParent()).removeAllViews();
        }
        a(paramContext, "marker_infowindow.9.png");
        paramContext.removeAllViews();
        paramContext.addView(paramen);
        AppMethodBeat.o(222008);
        return paramContext;
      }
      if ((gz.a(str1)) && (gz.a(str2)))
      {
        AppMethodBeat.o(222008);
        return null;
      }
      a(paramContext, "marker_infowindow.9.png");
      paramContext.removeAllViews();
      a(parambd, paramContext, "tencent_map_infowindow_content_title", str1);
      a(parambd, paramContext, "tencent_map_infowindow_content_snippet", str2);
      AppMethodBeat.o(222008);
      return paramContext;
    }
  }
  
  private static View a(Context paramContext, TencentMapContext paramTencentMapContext, en paramen, String paramString1, String paramString2)
  {
    AppMethodBeat.i(222018);
    paramen = (LinearLayout)paramen.g();
    if (paramen == null) {}
    for (paramContext = a(paramContext);; paramContext = paramen)
    {
      a(paramContext, "marker_infowindow.9.png");
      a(paramTencentMapContext, paramContext, "tencent_map_infowindow_content_title", paramString1);
      a(paramTencentMapContext, paramContext, "tencent_map_infowindow_content_snippet", paramString2);
      AppMethodBeat.o(222018);
      return paramContext;
      paramen.removeAllViews();
    }
  }
  
  private static LinearLayout a(Context paramContext)
  {
    AppMethodBeat.i(222032);
    if (paramContext == null)
    {
      AppMethodBeat.o(222032);
      return null;
    }
    paramContext = new LinearLayout(paramContext);
    paramContext.setTag("tencent_map_infowindow_view");
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramContext.setOrientation(1);
    paramContext.setGravity(17);
    AppMethodBeat.o(222032);
    return paramContext;
  }
  
  private void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(222080);
    this.o = paramBitmap;
    if (paramBitmap == null)
    {
      AppMethodBeat.o(222080);
      return;
    }
    kh.a("setBitmapAssist:".concat(String.valueOf(paramBitmap)));
    String str = paramBitmap.hashCode() + x.getAndIncrement();
    if (this.n != null) {
      this.n.a(str, new Bitmap[] { paramBitmap });
    }
    AppMethodBeat.o(222080);
  }
  
  private static void a(ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(222044);
    if (TextUtils.isEmpty(paramString)) {
      paramViewGroup.setBackgroundDrawable(null);
    }
    paramString = gv.b(paramViewGroup.getContext(), paramString);
    if (paramString != null)
    {
      byte[] arrayOfByte = paramString.getNinePatchChunk();
      paramViewGroup.setBackgroundDrawable(new NinePatchDrawable(paramViewGroup.getContext().getResources(), paramString, arrayOfByte, new Rect(10, 10, 10, 30), null));
    }
    AppMethodBeat.o(222044);
  }
  
  private static void a(TencentMapContext paramTencentMapContext, LinearLayout paramLinearLayout, String paramString1, String paramString2)
  {
    AppMethodBeat.i(222053);
    if ((paramLinearLayout == null) || (paramLinearLayout.getContext() == null))
    {
      AppMethodBeat.o(222053);
      return;
    }
    Context localContext = paramLinearLayout.getContext();
    TextView localTextView = (TextView)paramLinearLayout.findViewWithTag(paramString1);
    if (TextUtils.isEmpty(paramString2))
    {
      if (localTextView != null)
      {
        paramLinearLayout.removeView(localTextView);
        AppMethodBeat.o(222053);
      }
    }
    else
    {
      Object localObject = localTextView;
      if (localTextView == null)
      {
        localObject = new mh(localContext, paramTencentMapContext);
        ((TextView)localObject).setTag(paramString1);
        ((TextView)localObject).setGravity(3);
        ((TextView)localObject).setTextColor(-16777216);
        paramLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-2, -2));
      }
      ((TextView)localObject).setText(paramString2);
    }
    AppMethodBeat.o(222053);
  }
  
  private py b(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(222063);
    int i = paramMarkerOptions.getInfoWindowOffsetX();
    int j = paramMarkerOptions.getInfowindowOffsetY();
    d();
    e();
    float f1 = this.v;
    float f2 = i * 1.0F / this.p;
    float f3 = this.w;
    float f4 = j * 1.0F / this.q;
    py localpy = new py();
    localpy.i = GeoPoint.from(paramMarkerOptions.getPosition());
    localpy.m = paramMarkerOptions.getAlpha();
    localpy = localpy.a(f1 - f2, f3 - f4);
    localpy.n = false;
    localpy.s = ((int)paramMarkerOptions.getZIndex());
    localpy.t = paramMarkerOptions.getLevel();
    localpy.u = this.u;
    localpy.v = true;
    AppMethodBeat.o(222063);
    return localpy;
  }
  
  private void h()
  {
    AppMethodBeat.i(221984);
    if ((this.s == null) || (this.t == null) || (this.t.getOptions() == null))
    {
      AppMethodBeat.o(221984);
      return;
    }
    i();
    if (((VectorMap)this.s.e_).o.l == null)
    {
      AppMethodBeat.o(221984);
      return;
    }
    this.n = new px(this, this.s, b(this.t.getOptions()));
    kh.a("create InfoWindowView:" + this.z);
    a(gv.a(this.z));
    AppMethodBeat.o(221984);
  }
  
  private void i()
  {
    AppMethodBeat.i(221997);
    if ((this.s == null) || (this.s.G() == null))
    {
      AppMethodBeat.o(221997);
      return;
    }
    if (this.t != null) {}
    for (TencentMap.InfoWindowAdapter localInfoWindowAdapter = this.t.g();; localInfoWindowAdapter = null)
    {
      this.z = a(this.s.G(), (bd)this.s.d_, this, localInfoWindowAdapter, this.t);
      if (this.z != null)
      {
        this.z.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.p = this.z.getMeasuredWidth();
        this.q = this.z.getMeasuredHeight();
        this.z.layout(0, 0, this.z.getMeasuredWidth(), this.z.getMeasuredHeight());
      }
      AppMethodBeat.o(221997);
      return;
    }
  }
  
  private am t()
  {
    return this;
  }
  
  public final Rect a(ep paramep)
  {
    AppMethodBeat.i(222137);
    if (this.n == null)
    {
      AppMethodBeat.o(222137);
      return null;
    }
    paramep = this.n.a(paramep);
    AppMethodBeat.o(222137);
    return paramep;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222188);
    if (this.n != null)
    {
      a(true);
      GeoPoint localGeoPoint = new GeoPoint(paramInt2, paramInt1);
      this.n.a(localGeoPoint);
    }
    AppMethodBeat.o(222188);
  }
  
  public final void a(LatLng paramLatLng)
  {
    AppMethodBeat.i(222116);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(222116);
      return;
    }
    if (this.r == null) {
      this.r = GeoPoint.from(paramLatLng);
    }
    for (;;)
    {
      if (this.n != null) {
        this.n.a(this.r);
      }
      AppMethodBeat.o(222116);
      return;
      this.r.setLatitudeE6((int)(paramLatLng.latitude * 1000000.0D));
      this.r.setLongitudeE6((int)(paramLatLng.longitude * 1000000.0D));
    }
  }
  
  public final void a(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(222104);
    if ((paramMarkerOptions == null) || (this.n == null))
    {
      AppMethodBeat.o(222104);
      return;
    }
    setVisible(paramMarkerOptions.isVisible());
    setLevel(paramMarkerOptions.getLevel());
    i();
    paramMarkerOptions = b(paramMarkerOptions);
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(222104);
      return;
    }
    this.n.a(paramMarkerOptions);
    a(gv.a(this.z));
    AppMethodBeat.o(222104);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(222181);
    this.u = paramBoolean;
    if (this.n != null) {
      this.n.a(paramBoolean);
    }
    AppMethodBeat.o(222181);
  }
  
  public final Rect b(ep paramep)
  {
    AppMethodBeat.i(222145);
    if (this.n != null)
    {
      paramep = this.n.b(paramep);
      AppMethodBeat.o(222145);
      return paramep;
    }
    paramep = new Rect(0, 0, 0, 0);
    AppMethodBeat.o(222145);
    return paramep;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.y = paramBoolean;
    if ((this.s != null) && (this.s.e_ != null)) {
      ((VectorMap)this.s.e_).o.v = true;
    }
  }
  
  public final boolean c()
  {
    return (this.y) && (this.o != null);
  }
  
  public final void d()
  {
    AppMethodBeat.i(222167);
    if ((this.t == null) || (this.s.G() == null))
    {
      AppMethodBeat.o(222167);
      return;
    }
    int k = this.t.getWidth(this.s.G());
    if (this.t.getOptions() != null) {}
    for (float f1 = this.t.getOptions().getInfoWindowAnchorU();; f1 = 0.5F)
    {
      int j = this.p;
      int i = j;
      if (j == 0) {
        i = 1;
      }
      float f2 = k;
      this.v = (f1 + (this.t.getAnchorU() - 0.5F) * f2 / i);
      AppMethodBeat.o(222167);
      return;
    }
  }
  
  public final void e()
  {
    AppMethodBeat.i(222174);
    if ((this.t == null) || (this.s.G() == null))
    {
      AppMethodBeat.o(222174);
      return;
    }
    int k = (int)(this.t.getHeight(this.s.G()) * this.t.getAnchorV());
    int j = this.q;
    float f1 = 1.0F;
    if (this.t.getOptions() != null) {
      f1 = this.t.getOptions().getInfoWindowAnchorV();
    }
    int i = j;
    if (j == 0) {
      i = 1;
    }
    float f2 = k;
    this.w = ((f1 * i + f2) / i);
    AppMethodBeat.o(222174);
  }
  
  public final void f()
  {
    AppMethodBeat.i(222258);
    if (this.t == null)
    {
      AppMethodBeat.o(222258);
      return;
    }
    a(this.t.getOptions());
    AppMethodBeat.o(222258);
  }
  
  public final View g()
  {
    return this.z;
  }
  
  public final void h_()
  {
    AppMethodBeat.i(222239);
    releaseData();
    AppMethodBeat.o(222239);
  }
  
  public final void i_()
  {
    AppMethodBeat.i(222249);
    int j;
    int i;
    if ((this.t != null) && (this.t.getOptions() != null))
    {
      j = this.t.getOptions().getInfoWindowOffsetX();
      i = this.t.getOptions().getInfowindowOffsetY();
    }
    for (;;)
    {
      d();
      e();
      float f1 = this.v;
      float f2 = j * 1.0F / this.p;
      float f3 = this.w;
      float f4 = i * 1.0F / this.q;
      if (this.n != null) {
        this.n.a(f1 - f2, f3 - f4);
      }
      AppMethodBeat.o(222249);
      return;
      i = 0;
      j = 0;
    }
  }
  
  public final void j() {}
  
  public final void j_()
  {
    AppMethodBeat.i(222194);
    if (!this.h)
    {
      AppMethodBeat.o(222194);
      return;
    }
    if (this.n != null) {
      this.n.j_();
    }
    AppMethodBeat.o(222194);
  }
  
  public final boolean onTap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222212);
    if (this.n == null)
    {
      AppMethodBeat.o(222212);
      return false;
    }
    boolean bool = this.n.onTap(paramFloat1, paramFloat2);
    AppMethodBeat.o(222212);
    return bool;
  }
  
  public final void releaseData()
  {
    AppMethodBeat.i(222222);
    if (this.o != null)
    {
      this.o.recycle();
      this.o = null;
    }
    this.t = null;
    this.s = null;
    AppMethodBeat.o(222222);
  }
  
  protected final void s()
  {
    AppMethodBeat.i(222204);
    super.s();
    if ((this.n != null) && (this.n.f() != this.A))
    {
      kh.b("TDZ", "设置主从绑定关系：" + this.t.a() + "|" + this.n.f());
      this.A = this.n.f();
    }
    AppMethodBeat.o(222204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.op
 * JD-Core Version:    0.7.0.1
 */