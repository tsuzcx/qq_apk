package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import java.util.List;

public abstract class bn<C extends bm, M extends bk>
  implements MapDelegate<C, M, bt>
{
  public bt c;
  public ViewGroup d;
  public C d_;
  protected Context e;
  public M e_;
  protected TencentMapOptions f;
  private jw.c g;
  
  public bn(Context paramContext, TencentMapOptions paramTencentMapOptions, ViewGroup paramViewGroup)
  {
    this.e = paramContext;
    this.d = paramViewGroup;
    this.f = paramTencentMapOptions;
    if (this.g == null) {
      this.g = jw.a();
    }
    jw.a(this.g);
    paramContext = new kj(paramContext, paramTencentMapOptions);
    if (kh.a != paramContext) {
      kh.a = paramContext;
    }
    kl.b("API_STATUS");
    kl.b("DG_INIT");
    if (paramTencentMapOptions != null) {
      kl.a("API_STATUS", "options", kl.a(paramTencentMapOptions.toString()));
    }
  }
  
  private static void S() {}
  
  private MapViewType U()
  {
    return this.d_.a.getMapViewType();
  }
  
  private M V()
  {
    return this.e_;
  }
  
  private C W()
  {
    return this.d_;
  }
  
  private void b(float paramFloat)
  {
    if (this.c != null) {
      this.c.a(paramFloat);
    }
  }
  
  public final ViewGroup L()
  {
    return this.d;
  }
  
  protected void O()
  {
    if (this.d_ != null) {
      this.d_.o();
    }
  }
  
  protected void P() {}
  
  protected void Q() {}
  
  public final M a(C paramC)
  {
    return b(paramC);
  }
  
  protected abstract C a(Context paramContext, TencentMapOptions paramTencentMapOptions);
  
  public final bt a(C paramC, ViewGroup paramViewGroup)
  {
    return b(paramC, paramViewGroup);
  }
  
  protected abstract M b(C paramC);
  
  protected abstract bt b(C paramC, ViewGroup paramViewGroup);
  
  public bt getMapRenderView()
  {
    return this.c;
  }
  
  public boolean isOpaque()
  {
    if (this.c != null) {
      return this.c.e();
    }
    return true;
  }
  
  public boolean isTouchable()
  {
    return (this.e_ != null) && (this.e_.a());
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.d_ != null) {
      this.d_.f = paramBoolean;
    }
  }
  
  public void onCreated()
  {
    kl.b("DG_ON_CREATE_MAP_CONTEXT");
    this.d_ = a(this.e, this.f);
    O();
    kl.d("DG_ON_CREATE_MAP_CONTEXT");
    kl.b("DG_ON_CREATE_MAP_RENDER_VIEW");
    this.c = b(this.d_, this.d);
    View localView = this.c.getView();
    localView.setEnabled(true);
    localView.setClickable(true);
    kl.d("DG_ON_CREATE_MAP_RENDER_VIEW");
    kl.b("DG_ON_CREATE_MAP");
    this.e_ = b(this.d_);
    P();
    this.e_.b(bm.r());
    Q();
    kl.d("DG_ON_CREATE_MAP");
    kl.d("DG_INIT");
  }
  
  public void onDestroy()
  {
    if (this.d != null) {
      this.d.removeAllViews();
    }
    if (this.e_ != null) {
      this.e_.m();
    }
    bm localbm;
    Object localObject2;
    Object localObject3;
    if (this.d_ != null)
    {
      localbm = this.d_;
      localObject2 = localbm.c;
      localObject3 = localbm.d;
      ((gq)localObject3).b = (System.currentTimeMillis() - ((gq)localObject3).a);
      ((gb)localObject2).a -= 1;
      if (localObject3 == null) {}
    }
    try
    {
      ((gb)localObject2).b.add(localObject3);
      if ((((gb)localObject2).a == 0) && (!((gb)localObject2).b.isEmpty())) {
        ((gb)localObject2).a(gb.a(((gb)localObject2).b, null), new gb.4((gb)localObject2));
      }
      localObject2 = new Bundle();
      if (((Bundle)localObject2).size() > 0)
      {
        localObject3 = Parcel.obtain();
        ((Bundle)localObject2).writeToParcel((Parcel)localObject3, 0);
        ka.a(ka.b(ka.d, "map-context.cache"), ((Parcel)localObject3).marshall());
        ((Parcel)localObject3).recycle();
      }
      localbm.s();
      BitmapDescriptorFactory.detachMapContext(localbm);
      jw.b(this.g);
      return;
    }
    finally {}
  }
  
  public void onPause()
  {
    if (this.e_ != null) {
      this.e_.j();
    }
  }
  
  public void onRestart()
  {
    if (this.e_ != null)
    {
      kl.b("M_ON_RESTART");
      kl.d("M_ON_RESTART");
    }
  }
  
  public void onResume()
  {
    if (this.e_ != null) {
      this.e_.i();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.c != null) {
      this.c.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onStart()
  {
    if (this.e_ != null) {
      this.e_.h();
    }
  }
  
  public void onStop()
  {
    if (this.e_ != null) {
      this.e_.l();
    }
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.c != null) {
      this.c.a(paramObject, paramInt1, paramInt2);
    }
  }
  
  public void onUpdateOptions(TencentMapOptions paramTencentMapOptions) {}
  
  public void setOnTop(boolean paramBoolean)
  {
    if (this.e_ != null) {
      this.e_.a(paramBoolean);
    }
  }
  
  public void setOpaque(boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.setMapOpaque(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bn
 * JD-Core Version:    0.7.0.1
 */