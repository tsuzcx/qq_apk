package com.f.a.a.a.a;

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
  private i Mzx;
  private com.tencent.tencentmap.mapsdk.maps.model.Marker mMarker;
  
  public e(i parami, com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(199963);
    this.Mzx = parami;
    this.mMarker = paramMarker;
    if ((this.Mzx != null) && (this.Mzx.MzC != null)) {
      try
      {
        this.Mzx.MzC.add(this.mMarker);
        return;
      }
      finally
      {
        AppMethodBeat.o(199963);
      }
    }
    AppMethodBeat.o(199963);
  }
  
  public float getAlpha()
  {
    AppMethodBeat.i(199964);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getAlpha();
      AppMethodBeat.o(199964);
      return f;
    }
    AppMethodBeat.o(199964);
    return 0.0F;
  }
  
  public String getContentDescription()
  {
    AppMethodBeat.i(199994);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getContentDescription();
      AppMethodBeat.o(199994);
      return str;
    }
    AppMethodBeat.o(199994);
    return null;
  }
  
  public String getId()
  {
    AppMethodBeat.i(199965);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getId();
      AppMethodBeat.o(199965);
      return str;
    }
    AppMethodBeat.o(199965);
    return "";
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(199992);
    if (this.mMarker != null)
    {
      int i = this.mMarker.getLevel();
      AppMethodBeat.o(199992);
      return i;
    }
    AppMethodBeat.o(199992);
    return 0;
  }
  
  public View getMarkerView()
  {
    return null;
  }
  
  public LatLng getPosition()
  {
    AppMethodBeat.i(199966);
    if (this.mMarker != null)
    {
      LatLng localLatLng = l.a(this.mMarker.getPosition());
      AppMethodBeat.o(199966);
      return localLatLng;
    }
    AppMethodBeat.o(199966);
    return null;
  }
  
  public float getRotation()
  {
    AppMethodBeat.i(199967);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getRotation();
      AppMethodBeat.o(199967);
      return f;
    }
    AppMethodBeat.o(199967);
    return 0.0F;
  }
  
  public String getSnippet()
  {
    AppMethodBeat.i(199968);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getSnippet();
      AppMethodBeat.o(199968);
      return str;
    }
    AppMethodBeat.o(199968);
    return null;
  }
  
  public Object getTag()
  {
    AppMethodBeat.i(199987);
    if (this.mMarker != null)
    {
      Object localObject = this.mMarker.getTag();
      AppMethodBeat.o(199987);
      return localObject;
    }
    AppMethodBeat.o(199987);
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(199969);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getTitle();
      AppMethodBeat.o(199969);
      return str;
    }
    AppMethodBeat.o(199969);
    return null;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(199990);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getZIndex();
      AppMethodBeat.o(199990);
      return f;
    }
    AppMethodBeat.o(199990);
    return 0.0F;
  }
  
  public void hideInfoWindow()
  {
    AppMethodBeat.i(199970);
    if (this.mMarker != null) {
      this.mMarker.hideInfoWindow();
    }
    AppMethodBeat.o(199970);
  }
  
  public boolean isDraggable()
  {
    AppMethodBeat.i(199971);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isDraggable();
      AppMethodBeat.o(199971);
      return bool;
    }
    AppMethodBeat.o(199971);
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    AppMethodBeat.i(199972);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isInfoWindowShown();
      AppMethodBeat.o(199972);
      return bool;
    }
    AppMethodBeat.o(199972);
    return false;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(199973);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isVisible();
      AppMethodBeat.o(199973);
      return bool;
    }
    AppMethodBeat.o(199973);
    return false;
  }
  
  public void refreshInfoWindow()
  {
    AppMethodBeat.i(199995);
    if (this.mMarker != null) {
      this.mMarker.refreshInfoWindow();
    }
    AppMethodBeat.o(199995);
  }
  
  public void remove()
  {
    AppMethodBeat.i(199974);
    if (this.mMarker != null) {}
    try
    {
      if ((this.Mzx != null) && (this.Mzx.MzC != null)) {
        this.Mzx.MzC.remove(this.mMarker);
      }
      this.mMarker.remove();
      AppMethodBeat.o(199974);
      return;
    }
    finally
    {
      AppMethodBeat.o(199974);
    }
  }
  
  public void set2Top()
  {
    AppMethodBeat.i(199985);
    if ((this.Mzx == null) || (this.Mzx.MzC == null))
    {
      AppMethodBeat.o(199985);
      return;
    }
    try
    {
      int i = this.Mzx.MzC.size();
      Object localObject1 = this.Mzx.MzC.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          com.tencent.tencentmap.mapsdk.maps.model.Marker localMarker = (com.tencent.tencentmap.mapsdk.maps.model.Marker)((Iterator)localObject1).next();
          if (localMarker.getZIndex() <= i) {
            break;
          }
          i = (int)localMarker.getZIndex();
        }
        else
        {
          localObject1 = this.mMarker;
          if (i < 2147483647) {}
          for (float f = i + 1;; f = 2.147484E+009F)
          {
            ((com.tencent.tencentmap.mapsdk.maps.model.Marker)localObject1).setZIndex(f);
            return;
          }
        }
      }
    }
    finally
    {
      AppMethodBeat.o(199985);
    }
    for (;;) {}
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(199975);
    if (this.mMarker != null) {
      this.mMarker.setAlpha(paramFloat);
    }
    AppMethodBeat.o(199975);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199976);
    if (this.mMarker != null) {
      this.mMarker.setAnchor(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(199976);
  }
  
  public void setContentDescription(String paramString)
  {
    AppMethodBeat.i(199993);
    if (this.mMarker != null) {
      this.mMarker.setContentDescription(paramString);
    }
    AppMethodBeat.o(199993);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    AppMethodBeat.i(199977);
    if (this.mMarker != null) {
      this.mMarker.setDraggable(paramBoolean);
    }
    AppMethodBeat.o(199977);
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(199978);
    if ((this.mMarker != null) && (paramBitmapDescriptor != null)) {
      this.mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    }
    AppMethodBeat.o(199978);
  }
  
  public void setInfoWindowHideAnimation(Animation paramAnimation) {}
  
  public void setInfoWindowShowAnimation(Animation paramAnimation) {}
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(199991);
    if (this.mMarker != null) {
      this.mMarker.setLevel(paramInt);
    }
    AppMethodBeat.o(199991);
  }
  
  public void setMarkerView(View paramView)
  {
    AppMethodBeat.i(199986);
    if (this.mMarker != null) {
      this.mMarker.setIcon(BitmapDescriptorFactory.fromView(paramView));
    }
    AppMethodBeat.o(199986);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(199979);
    if (this.mMarker != null) {
      this.mMarker.setPosition(l.c(paramLatLng));
    }
    AppMethodBeat.o(199979);
  }
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(199980);
    if (this.mMarker != null) {
      this.mMarker.setRotation(paramFloat);
    }
    AppMethodBeat.o(199980);
  }
  
  public void setSnippet(String paramString)
  {
    AppMethodBeat.i(199981);
    if (this.mMarker != null) {
      this.mMarker.setSnippet(paramString);
    }
    AppMethodBeat.o(199981);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(199988);
    if (this.mMarker != null) {
      this.mMarker.setTag(paramObject);
    }
    AppMethodBeat.o(199988);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(199982);
    if (this.mMarker != null) {
      this.mMarker.setTitle(paramString);
    }
    AppMethodBeat.o(199982);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(199983);
    if (this.mMarker != null) {
      this.mMarker.setVisible(paramBoolean);
    }
    AppMethodBeat.o(199983);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(199989);
    if (this.mMarker != null) {
      this.mMarker.setZIndex(paramFloat);
    }
    AppMethodBeat.o(199989);
  }
  
  public void showInfoWindow()
  {
    AppMethodBeat.i(199984);
    if (this.mMarker != null) {
      this.mMarker.showInfoWindow();
    }
    AppMethodBeat.o(199984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */