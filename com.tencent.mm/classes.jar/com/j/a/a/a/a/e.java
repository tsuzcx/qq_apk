package com.j.a.a.a.a;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.List;

public class e
  implements com.tencent.mapsdk.raster.model.Marker
{
  private i airt;
  private com.tencent.tencentmap.mapsdk.maps.model.Marker mMarker;
  
  public e(i parami, com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(207004);
    this.airt = parami;
    this.mMarker = paramMarker;
    if ((this.airt != null) && (this.airt.airy != null)) {
      try
      {
        this.airt.airy.add(this.mMarker);
        return;
      }
      finally
      {
        AppMethodBeat.o(207004);
      }
    }
    AppMethodBeat.o(207004);
  }
  
  public float getAlpha()
  {
    AppMethodBeat.i(207011);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getAlpha();
      AppMethodBeat.o(207011);
      return f;
    }
    AppMethodBeat.o(207011);
    return 0.0F;
  }
  
  public String getContentDescription()
  {
    AppMethodBeat.i(207292);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getContentDescription();
      AppMethodBeat.o(207292);
      return str;
    }
    AppMethodBeat.o(207292);
    return null;
  }
  
  public String getId()
  {
    AppMethodBeat.i(207019);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getId();
      AppMethodBeat.o(207019);
      return str;
    }
    AppMethodBeat.o(207019);
    return "";
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(207284);
    if (this.mMarker != null)
    {
      int i = this.mMarker.getLevel();
      AppMethodBeat.o(207284);
      return i;
    }
    AppMethodBeat.o(207284);
    return 0;
  }
  
  public View getMarkerView()
  {
    return null;
  }
  
  public LatLng getPosition()
  {
    AppMethodBeat.i(207023);
    if (this.mMarker != null)
    {
      LatLng localLatLng = l.d(this.mMarker.getPosition());
      AppMethodBeat.o(207023);
      return localLatLng;
    }
    AppMethodBeat.o(207023);
    return null;
  }
  
  public float getRotation()
  {
    AppMethodBeat.i(207030);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getRotation();
      AppMethodBeat.o(207030);
      return f;
    }
    AppMethodBeat.o(207030);
    return 0.0F;
  }
  
  public String getSnippet()
  {
    AppMethodBeat.i(207037);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getSnippet();
      AppMethodBeat.o(207037);
      return str;
    }
    AppMethodBeat.o(207037);
    return null;
  }
  
  public Object getTag()
  {
    AppMethodBeat.i(207249);
    if (this.mMarker != null)
    {
      Object localObject = this.mMarker.getTag();
      AppMethodBeat.o(207249);
      return localObject;
    }
    AppMethodBeat.o(207249);
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(207042);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getTitle();
      AppMethodBeat.o(207042);
      return str;
    }
    AppMethodBeat.o(207042);
    return null;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(207268);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getZIndex();
      AppMethodBeat.o(207268);
      return f;
    }
    AppMethodBeat.o(207268);
    return 0.0F;
  }
  
  public void hideInfoWindow()
  {
    AppMethodBeat.i(207054);
    if (this.mMarker != null) {
      this.mMarker.hideInfoWindow();
    }
    AppMethodBeat.o(207054);
  }
  
  public boolean isDraggable()
  {
    AppMethodBeat.i(207065);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isDraggable();
      AppMethodBeat.o(207065);
      return bool;
    }
    AppMethodBeat.o(207065);
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    AppMethodBeat.i(207074);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isInfoWindowShown();
      AppMethodBeat.o(207074);
      return bool;
    }
    AppMethodBeat.o(207074);
    return false;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(207084);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isVisible();
      AppMethodBeat.o(207084);
      return bool;
    }
    AppMethodBeat.o(207084);
    return false;
  }
  
  public void refreshInfoWindow()
  {
    AppMethodBeat.i(207299);
    if (this.mMarker != null) {
      this.mMarker.refreshInfoWindow();
    }
    AppMethodBeat.o(207299);
  }
  
  public void remove()
  {
    AppMethodBeat.i(207102);
    if (this.mMarker != null) {}
    try
    {
      if ((this.airt != null) && (this.airt.airy != null)) {
        this.airt.airy.remove(this.mMarker);
      }
      this.mMarker.remove();
      AppMethodBeat.o(207102);
      return;
    }
    finally
    {
      AppMethodBeat.o(207102);
    }
  }
  
  public void set2Top()
  {
    AppMethodBeat.i(207220);
    if ((this.airt == null) || (this.airt.airy == null))
    {
      AppMethodBeat.o(207220);
      return;
    }
    try
    {
      int i = this.airt.airy.size();
      Object localObject1 = this.airt.airy.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          com.tencent.tencentmap.mapsdk.maps.model.Marker localMarker = (com.tencent.tencentmap.mapsdk.maps.model.Marker)((Iterator)localObject1).next();
          if (localMarker.getZIndex() != 2147483647)
          {
            if (localMarker.getZIndex() <= i) {
              break;
            }
            i = localMarker.getZIndex();
          }
        }
        else
        {
          localObject1 = this.mMarker;
          if (i < 2147483647) {
            i += 1;
          }
          for (;;)
          {
            ((com.tencent.tencentmap.mapsdk.maps.model.Marker)localObject1).setZIndex(i);
            return;
            i = 2147483647;
          }
        }
      }
    }
    finally
    {
      AppMethodBeat.o(207220);
    }
    for (;;) {}
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(207115);
    if (this.mMarker != null) {
      this.mMarker.setAlpha(paramFloat);
    }
    AppMethodBeat.o(207115);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(207127);
    if (this.mMarker != null) {
      this.mMarker.setAnchor(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(207127);
  }
  
  public void setCollisions(Collision... paramVarArgs)
  {
    AppMethodBeat.i(207316);
    if (this.mMarker != null) {
      this.mMarker.setCollisions(paramVarArgs);
    }
    AppMethodBeat.o(207316);
  }
  
  public void setContentDescription(String paramString)
  {
    AppMethodBeat.i(207288);
    if (this.mMarker != null) {
      this.mMarker.setContentDescription(paramString);
    }
    AppMethodBeat.o(207288);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    AppMethodBeat.i(207137);
    if (this.mMarker != null) {
      this.mMarker.setDraggable(paramBoolean);
    }
    AppMethodBeat.o(207137);
  }
  
  public void setIcon(com.tencent.mapsdk.raster.model.BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(207148);
    if ((this.mMarker != null) && (paramBitmapDescriptor != null))
    {
      paramBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap());
      paramBitmapDescriptor.getFormater().setScale(2);
      this.mMarker.setIcon(paramBitmapDescriptor);
    }
    AppMethodBeat.o(207148);
  }
  
  public void setInfoWindowHideAnimation(Animation paramAnimation) {}
  
  public void setInfoWindowOffset(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207307);
    if (this.mMarker != null) {
      this.mMarker.setInfoWindowOffset(paramInt1, paramInt2);
    }
    AppMethodBeat.o(207307);
  }
  
  public void setInfoWindowShowAnimation(Animation paramAnimation) {}
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(207275);
    if (this.mMarker != null) {
      this.mMarker.setLevel(paramInt);
    }
    AppMethodBeat.o(207275);
  }
  
  public void setMarkerView(View paramView)
  {
    AppMethodBeat.i(207232);
    if (this.mMarker != null) {
      this.mMarker.setIcon(BitmapDescriptorFactory.fromView(paramView));
    }
    AppMethodBeat.o(207232);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(207156);
    if (this.mMarker != null) {
      this.mMarker.setPosition(l.d(paramLatLng));
    }
    AppMethodBeat.o(207156);
  }
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(207168);
    if (this.mMarker != null) {
      this.mMarker.setRotation(paramFloat);
    }
    AppMethodBeat.o(207168);
  }
  
  public void setSnippet(String paramString)
  {
    AppMethodBeat.i(207176);
    if (this.mMarker != null) {
      this.mMarker.setSnippet(paramString);
    }
    AppMethodBeat.o(207176);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(207254);
    if (this.mMarker != null) {
      this.mMarker.setTag(paramObject);
    }
    AppMethodBeat.o(207254);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(207191);
    if (this.mMarker != null) {
      this.mMarker.setTitle(paramString);
    }
    AppMethodBeat.o(207191);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(207203);
    if (this.mMarker != null) {
      this.mMarker.setVisible(paramBoolean);
    }
    AppMethodBeat.o(207203);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(207261);
    if (this.mMarker != null) {
      this.mMarker.setZIndex(paramFloat);
    }
    AppMethodBeat.o(207261);
  }
  
  public void showInfoWindow()
  {
    AppMethodBeat.i(207209);
    if (this.mMarker != null) {
      this.mMarker.showInfoWindow();
    }
    AppMethodBeat.o(207209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */