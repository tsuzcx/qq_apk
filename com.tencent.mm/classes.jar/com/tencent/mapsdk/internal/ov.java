package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;

public final class ov
  extends AccessibleTouchItem
{
  private an a;
  private sj b;
  
  public ov(sj paramsj, an paraman)
  {
    this.b = paramsj;
    this.a = paraman;
  }
  
  private static Rect a(Rect paramRect)
  {
    AppMethodBeat.i(221855);
    if (paramRect == null)
    {
      AppMethodBeat.o(221855);
      return null;
    }
    int j = paramRect.left;
    int i = paramRect.right;
    int m = paramRect.top;
    int k = paramRect.bottom;
    int i3 = (paramRect.right + paramRect.left) / 2;
    int n = (paramRect.top + paramRect.bottom) / 2;
    int i4 = paramRect.right;
    int i5 = paramRect.left;
    int i1 = paramRect.bottom;
    int i2 = paramRect.top;
    if (i4 - i5 < gw.m() * 40.0F)
    {
      j = (int)(i3 - gw.m() * 20.0F);
      i = (int)(i3 + gw.m() * 20.0F);
    }
    if (i1 - i2 < gw.m() * 40.0F)
    {
      m = (int)(n - gw.m() * 20.0F);
      k = (int)(n + gw.m() * 20.0F);
    }
    paramRect = new Rect(j, m, i, k);
    AppMethodBeat.o(221855);
    return paramRect;
  }
  
  public final Rect getBounds()
  {
    AppMethodBeat.i(221869);
    if (this.a == null)
    {
      AppMethodBeat.o(221869);
      return null;
    }
    Rect localRect = this.a.i();
    if (localRect == null)
    {
      AppMethodBeat.o(221869);
      return null;
    }
    int j = localRect.left;
    int i = localRect.right;
    int m = localRect.top;
    int k = localRect.bottom;
    int i3 = (localRect.right + localRect.left) / 2;
    int n = (localRect.top + localRect.bottom) / 2;
    int i4 = localRect.right;
    int i5 = localRect.left;
    int i1 = localRect.bottom;
    int i2 = localRect.top;
    if (i4 - i5 < gw.m() * 40.0F)
    {
      j = (int)(i3 - gw.m() * 20.0F);
      i = (int)(i3 + gw.m() * 20.0F);
    }
    if (i1 - i2 < gw.m() * 40.0F)
    {
      m = (int)(n - gw.m() * 20.0F);
      k = (int)(n + gw.m() * 20.0F);
    }
    localRect = new Rect(j, m, i, k);
    AppMethodBeat.o(221869);
    return localRect;
  }
  
  public final String getContentDescription()
  {
    AppMethodBeat.i(221877);
    if (this.a == null)
    {
      AppMethodBeat.o(221877);
      return null;
    }
    String str = this.a.getContentDescription();
    AppMethodBeat.o(221877);
    return str;
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(221886);
    if (this.b != null)
    {
      TencentMap.OnMarkerClickListener localOnMarkerClickListener = this.b.y;
      if ((this.a != null) && (localOnMarkerClickListener != null)) {
        localOnMarkerClickListener.onMarkerClick(this.a);
      }
    }
    AppMethodBeat.o(221886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ov
 * JD-Core Version:    0.7.0.1
 */