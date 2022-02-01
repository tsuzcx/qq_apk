package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;

public final class sq
  implements UiSettings
{
  private ad a = null;
  
  public sq(ad paramad)
  {
    this.a = paramad;
  }
  
  public final boolean isCompassEnabled()
  {
    AppMethodBeat.i(224004);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null)
      {
        boolean bool = localad.a.b();
        AppMethodBeat.o(224004);
        return bool;
      }
      AppMethodBeat.o(224004);
      return false;
    }
    AppMethodBeat.o(224004);
    return false;
  }
  
  public final boolean isIndoorLevelPickerEnabled()
  {
    AppMethodBeat.i(224049);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null)
      {
        boolean bool = localad.a.h();
        AppMethodBeat.o(224049);
        return bool;
      }
      AppMethodBeat.o(224049);
      return false;
    }
    AppMethodBeat.o(224049);
    return false;
  }
  
  public final boolean isMyLocationButtonEnabled()
  {
    AppMethodBeat.i(224012);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null)
      {
        boolean bool = localad.a.c();
        AppMethodBeat.o(224012);
        return bool;
      }
      AppMethodBeat.o(224012);
      return false;
    }
    AppMethodBeat.o(224012);
    return false;
  }
  
  public final boolean isRotateGesturesEnabled()
  {
    AppMethodBeat.i(224040);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null)
      {
        boolean bool = localad.a.g();
        AppMethodBeat.o(224040);
        return bool;
      }
      AppMethodBeat.o(224040);
      return false;
    }
    AppMethodBeat.o(224040);
    return false;
  }
  
  public final boolean isScaleViewEnabled()
  {
    AppMethodBeat.i(224080);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null)
      {
        boolean bool = localad.a.i();
        AppMethodBeat.o(224080);
        return bool;
      }
      AppMethodBeat.o(224080);
      return false;
    }
    AppMethodBeat.o(224080);
    return false;
  }
  
  public final boolean isScrollGesturesEnabled()
  {
    AppMethodBeat.i(224022);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null)
      {
        boolean bool = localad.a.d();
        AppMethodBeat.o(224022);
        return bool;
      }
      AppMethodBeat.o(224022);
      return false;
    }
    AppMethodBeat.o(224022);
    return false;
  }
  
  public final boolean isTiltGesturesEnabled()
  {
    AppMethodBeat.i(224033);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null)
      {
        boolean bool = localad.a.f();
        AppMethodBeat.o(224033);
        return bool;
      }
      AppMethodBeat.o(224033);
      return false;
    }
    AppMethodBeat.o(224033);
    return false;
  }
  
  public final boolean isZoomControlsEnabled()
  {
    AppMethodBeat.i(223998);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null)
      {
        boolean bool = localad.a.a();
        AppMethodBeat.o(223998);
        return bool;
      }
      AppMethodBeat.o(223998);
      return false;
    }
    AppMethodBeat.o(223998);
    return false;
  }
  
  public final boolean isZoomGesturesEnabled()
  {
    AppMethodBeat.i(224027);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null)
      {
        boolean bool = localad.a.e();
        AppMethodBeat.o(224027);
        return bool;
      }
      AppMethodBeat.o(224027);
      return false;
    }
    AppMethodBeat.o(224027);
    return false;
  }
  
  public final void setAllGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223988);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.i(paramBoolean);
      }
    }
    AppMethodBeat.o(223988);
  }
  
  public final void setCompassEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223913);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.b(paramBoolean);
      }
    }
    AppMethodBeat.o(223913);
  }
  
  public final void setCompassExtraPadding(int paramInt)
  {
    AppMethodBeat.i(223920);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.f(paramInt);
      }
    }
    AppMethodBeat.o(223920);
  }
  
  public final void setCompassExtraPadding(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223931);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.a(paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(223931);
  }
  
  public final void setFlingGestureEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223957);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.e(paramBoolean);
      }
    }
    AppMethodBeat.o(223957);
  }
  
  public final void setGestureScaleByMapCenter(boolean paramBoolean)
  {
    AppMethodBeat.i(224166);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.l(paramBoolean);
      }
    }
    AppMethodBeat.o(224166);
  }
  
  public final void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(224175);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.m(paramBoolean);
      }
    }
    AppMethodBeat.o(224175);
  }
  
  public final void setLogoPosition(int paramInt)
  {
    AppMethodBeat.i(224112);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.b(paramInt);
      }
    }
    AppMethodBeat.o(224112);
  }
  
  public final void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(224152);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.a(paramInt, paramArrayOfInt);
      }
    }
    AppMethodBeat.o(224152);
  }
  
  public final void setLogoPositionWithMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(224142);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      }
    }
    AppMethodBeat.o(224142);
  }
  
  public final void setLogoScale(float paramFloat)
  {
    AppMethodBeat.i(224185);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.a(paramFloat);
      }
    }
    AppMethodBeat.o(224185);
  }
  
  public final void setLogoSize(int paramInt)
  {
    AppMethodBeat.i(224132);
    if ((this.a != null) && (this.a != null))
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.g(paramInt);
      }
    }
    AppMethodBeat.o(224132);
  }
  
  public final void setMyLocationButtonEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223939);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.c(paramBoolean);
      }
    }
    AppMethodBeat.o(223939);
  }
  
  public final void setRotateGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223981);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.h(paramBoolean);
      }
    }
    AppMethodBeat.o(223981);
  }
  
  public final void setScaleViewEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(224058);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.j(paramBoolean);
      }
    }
    AppMethodBeat.o(224058);
  }
  
  public final void setScaleViewFadeEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(224070);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.n(paramBoolean);
      }
    }
    AppMethodBeat.o(224070);
  }
  
  public final void setScaleViewPosition(int paramInt)
  {
    AppMethodBeat.i(224088);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.e(paramInt);
      }
    }
    AppMethodBeat.o(224088);
  }
  
  public final void setScaleViewPositionWithMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(224100);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      }
    }
    AppMethodBeat.o(224100);
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223949);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.d(paramBoolean);
      }
    }
    AppMethodBeat.o(223949);
  }
  
  public final void setTiltGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223974);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.g(paramBoolean);
      }
    }
    AppMethodBeat.o(223974);
  }
  
  public final void setZoomControlsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223903);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.a(paramBoolean);
      }
    }
    AppMethodBeat.o(223903);
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(223965);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.f(paramBoolean);
      }
    }
    AppMethodBeat.o(223965);
  }
  
  public final void setZoomPosition(int paramInt)
  {
    AppMethodBeat.i(224121);
    if (this.a != null)
    {
      ad localad = this.a;
      if (localad.a != null) {
        localad.a.h(paramInt);
      }
    }
    AppMethodBeat.o(224121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sq
 * JD-Core Version:    0.7.0.1
 */