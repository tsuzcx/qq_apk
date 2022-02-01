package com.d.a.a.a.a;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.List;

public class e
  implements com.tencent.mapsdk.raster.model.Marker
{
  private i SJM;
  private com.tencent.tencentmap.mapsdk.maps.model.Marker mMarker;
  
  public e(i parami, com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(217314);
    this.SJM = parami;
    this.mMarker = paramMarker;
    if ((this.SJM != null) && (this.SJM.SJR != null)) {
      try
      {
        this.SJM.SJR.add(this.mMarker);
        return;
      }
      finally
      {
        AppMethodBeat.o(217314);
      }
    }
    AppMethodBeat.o(217314);
  }
  
  public float getAlpha()
  {
    AppMethodBeat.i(217315);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getAlpha();
      AppMethodBeat.o(217315);
      return f;
    }
    AppMethodBeat.o(217315);
    return 0.0F;
  }
  
  public String getContentDescription()
  {
    AppMethodBeat.i(217345);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getContentDescription();
      AppMethodBeat.o(217345);
      return str;
    }
    AppMethodBeat.o(217345);
    return null;
  }
  
  public String getId()
  {
    AppMethodBeat.i(217316);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getId();
      AppMethodBeat.o(217316);
      return str;
    }
    AppMethodBeat.o(217316);
    return "";
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(217343);
    if (this.mMarker != null)
    {
      int i = this.mMarker.getLevel();
      AppMethodBeat.o(217343);
      return i;
    }
    AppMethodBeat.o(217343);
    return 0;
  }
  
  public View getMarkerView()
  {
    return null;
  }
  
  public LatLng getPosition()
  {
    AppMethodBeat.i(217317);
    if (this.mMarker != null)
    {
      LatLng localLatLng = l.a(this.mMarker.getPosition());
      AppMethodBeat.o(217317);
      return localLatLng;
    }
    AppMethodBeat.o(217317);
    return null;
  }
  
  public float getRotation()
  {
    AppMethodBeat.i(217318);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getRotation();
      AppMethodBeat.o(217318);
      return f;
    }
    AppMethodBeat.o(217318);
    return 0.0F;
  }
  
  public String getSnippet()
  {
    AppMethodBeat.i(217319);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getSnippet();
      AppMethodBeat.o(217319);
      return str;
    }
    AppMethodBeat.o(217319);
    return null;
  }
  
  public Object getTag()
  {
    AppMethodBeat.i(217338);
    if (this.mMarker != null)
    {
      Object localObject = this.mMarker.getTag();
      AppMethodBeat.o(217338);
      return localObject;
    }
    AppMethodBeat.o(217338);
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(217320);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getTitle();
      AppMethodBeat.o(217320);
      return str;
    }
    AppMethodBeat.o(217320);
    return null;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(217341);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getZIndex();
      AppMethodBeat.o(217341);
      return f;
    }
    AppMethodBeat.o(217341);
    return 0.0F;
  }
  
  public void hideInfoWindow()
  {
    AppMethodBeat.i(217321);
    if (this.mMarker != null) {
      this.mMarker.hideInfoWindow();
    }
    AppMethodBeat.o(217321);
  }
  
  public boolean isDraggable()
  {
    AppMethodBeat.i(217322);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isDraggable();
      AppMethodBeat.o(217322);
      return bool;
    }
    AppMethodBeat.o(217322);
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    AppMethodBeat.i(217323);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isInfoWindowShown();
      AppMethodBeat.o(217323);
      return bool;
    }
    AppMethodBeat.o(217323);
    return false;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(217324);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isVisible();
      AppMethodBeat.o(217324);
      return bool;
    }
    AppMethodBeat.o(217324);
    return false;
  }
  
  public void refreshInfoWindow()
  {
    AppMethodBeat.i(217346);
    if (this.mMarker != null) {
      this.mMarker.refreshInfoWindow();
    }
    AppMethodBeat.o(217346);
  }
  
  public void remove()
  {
    AppMethodBeat.i(217325);
    if (this.mMarker != null) {}
    try
    {
      if ((this.SJM != null) && (this.SJM.SJR != null)) {
        this.SJM.SJR.remove(this.mMarker);
      }
      this.mMarker.remove();
      AppMethodBeat.o(217325);
      return;
    }
    finally
    {
      AppMethodBeat.o(217325);
    }
  }
  
  public void set2Top()
  {
    AppMethodBeat.i(217336);
    if ((this.SJM == null) || (this.SJM.SJR == null))
    {
      AppMethodBeat.o(217336);
      return;
    }
    try
    {
      int i = this.SJM.SJR.size();
      Object localObject1 = this.SJM.SJR.iterator();
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
      AppMethodBeat.o(217336);
    }
    for (;;) {}
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(217326);
    if (this.mMarker != null) {
      this.mMarker.setAlpha(paramFloat);
    }
    AppMethodBeat.o(217326);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(217327);
    if (this.mMarker != null) {
      this.mMarker.setAnchor(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(217327);
  }
  
  public void setContentDescription(String paramString)
  {
    AppMethodBeat.i(217344);
    if (this.mMarker != null) {
      this.mMarker.setContentDescription(paramString);
    }
    AppMethodBeat.o(217344);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    AppMethodBeat.i(217328);
    if (this.mMarker != null) {
      this.mMarker.setDraggable(paramBoolean);
    }
    AppMethodBeat.o(217328);
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(217329);
    if ((this.mMarker != null) && (paramBitmapDescriptor != null)) {
      this.mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    }
    AppMethodBeat.o(217329);
  }
  
  public void setInfoWindowHideAnimation(Animation paramAnimation) {}
  
  public void setInfoWindowOffset(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217347);
    if (this.mMarker != null) {
      this.mMarker.setInfoWindowOffset(paramInt1, paramInt2);
    }
    AppMethodBeat.o(217347);
  }
  
  public void setInfoWindowShowAnimation(Animation paramAnimation) {}
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(217342);
    if (this.mMarker != null) {
      this.mMarker.setLevel(paramInt);
    }
    AppMethodBeat.o(217342);
  }
  
  public void setMarkerView(View paramView)
  {
    AppMethodBeat.i(217337);
    if (this.mMarker != null) {
      this.mMarker.setIcon(BitmapDescriptorFactory.fromView(paramView));
    }
    AppMethodBeat.o(217337);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(217330);
    if (this.mMarker != null) {
      this.mMarker.setPosition(l.c(paramLatLng));
    }
    AppMethodBeat.o(217330);
  }
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(217331);
    if (this.mMarker != null) {
      this.mMarker.setRotation(paramFloat);
    }
    AppMethodBeat.o(217331);
  }
  
  public void setSnippet(String paramString)
  {
    AppMethodBeat.i(217332);
    if (this.mMarker != null) {
      this.mMarker.setSnippet(paramString);
    }
    AppMethodBeat.o(217332);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(217339);
    if (this.mMarker != null) {
      this.mMarker.setTag(paramObject);
    }
    AppMethodBeat.o(217339);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(217333);
    if (this.mMarker != null) {
      this.mMarker.setTitle(paramString);
    }
    AppMethodBeat.o(217333);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(217334);
    if (this.mMarker != null) {
      this.mMarker.setVisible(paramBoolean);
    }
    AppMethodBeat.o(217334);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(217340);
    if (this.mMarker != null) {
      this.mMarker.setZIndex(paramFloat);
    }
    AppMethodBeat.o(217340);
  }
  
  public void showInfoWindow()
  {
    AppMethodBeat.i(217335);
    if (this.mMarker != null) {
      this.mMarker.showInfoWindow();
    }
    AppMethodBeat.o(217335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */