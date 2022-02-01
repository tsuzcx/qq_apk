package com.e.a.a.a.a;

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
  private i KIS;
  private com.tencent.tencentmap.mapsdk.maps.model.Marker mMarker;
  
  public e(i parami, com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(205857);
    this.KIS = parami;
    this.mMarker = paramMarker;
    if ((this.KIS != null) && (this.KIS.KIX != null)) {
      try
      {
        this.KIS.KIX.add(this.mMarker);
        return;
      }
      finally
      {
        AppMethodBeat.o(205857);
      }
    }
    AppMethodBeat.o(205857);
  }
  
  public float getAlpha()
  {
    AppMethodBeat.i(205858);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getAlpha();
      AppMethodBeat.o(205858);
      return f;
    }
    AppMethodBeat.o(205858);
    return 0.0F;
  }
  
  public String getContentDescription()
  {
    AppMethodBeat.i(205888);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getContentDescription();
      AppMethodBeat.o(205888);
      return str;
    }
    AppMethodBeat.o(205888);
    return null;
  }
  
  public String getId()
  {
    AppMethodBeat.i(205859);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getId();
      AppMethodBeat.o(205859);
      return str;
    }
    AppMethodBeat.o(205859);
    return "";
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(205886);
    if (this.mMarker != null)
    {
      int i = this.mMarker.getLevel();
      AppMethodBeat.o(205886);
      return i;
    }
    AppMethodBeat.o(205886);
    return 0;
  }
  
  public View getMarkerView()
  {
    return null;
  }
  
  public LatLng getPosition()
  {
    AppMethodBeat.i(205860);
    if (this.mMarker != null)
    {
      LatLng localLatLng = l.a(this.mMarker.getPosition());
      AppMethodBeat.o(205860);
      return localLatLng;
    }
    AppMethodBeat.o(205860);
    return null;
  }
  
  public float getRotation()
  {
    AppMethodBeat.i(205861);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getRotation();
      AppMethodBeat.o(205861);
      return f;
    }
    AppMethodBeat.o(205861);
    return 0.0F;
  }
  
  public String getSnippet()
  {
    AppMethodBeat.i(205862);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getSnippet();
      AppMethodBeat.o(205862);
      return str;
    }
    AppMethodBeat.o(205862);
    return null;
  }
  
  public Object getTag()
  {
    AppMethodBeat.i(205881);
    if (this.mMarker != null)
    {
      Object localObject = this.mMarker.getTag();
      AppMethodBeat.o(205881);
      return localObject;
    }
    AppMethodBeat.o(205881);
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(205863);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getTitle();
      AppMethodBeat.o(205863);
      return str;
    }
    AppMethodBeat.o(205863);
    return null;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(205884);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getZIndex();
      AppMethodBeat.o(205884);
      return f;
    }
    AppMethodBeat.o(205884);
    return 0.0F;
  }
  
  public void hideInfoWindow()
  {
    AppMethodBeat.i(205864);
    if (this.mMarker != null) {
      this.mMarker.hideInfoWindow();
    }
    AppMethodBeat.o(205864);
  }
  
  public boolean isDraggable()
  {
    AppMethodBeat.i(205865);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isDraggable();
      AppMethodBeat.o(205865);
      return bool;
    }
    AppMethodBeat.o(205865);
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    AppMethodBeat.i(205866);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isInfoWindowShown();
      AppMethodBeat.o(205866);
      return bool;
    }
    AppMethodBeat.o(205866);
    return false;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(205867);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isVisible();
      AppMethodBeat.o(205867);
      return bool;
    }
    AppMethodBeat.o(205867);
    return false;
  }
  
  public void refreshInfoWindow()
  {
    AppMethodBeat.i(205889);
    if (this.mMarker != null) {
      this.mMarker.refreshInfoWindow();
    }
    AppMethodBeat.o(205889);
  }
  
  public void remove()
  {
    AppMethodBeat.i(205868);
    if (this.mMarker != null) {}
    try
    {
      if ((this.KIS != null) && (this.KIS.KIX != null)) {
        this.KIS.KIX.remove(this.mMarker);
      }
      this.mMarker.remove();
      AppMethodBeat.o(205868);
      return;
    }
    finally
    {
      AppMethodBeat.o(205868);
    }
  }
  
  public void set2Top()
  {
    AppMethodBeat.i(205879);
    if ((this.KIS == null) || (this.KIS.KIX == null))
    {
      AppMethodBeat.o(205879);
      return;
    }
    try
    {
      int i = this.KIS.KIX.size();
      Object localObject1 = this.KIS.KIX.iterator();
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
      AppMethodBeat.o(205879);
    }
    for (;;) {}
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(205869);
    if (this.mMarker != null) {
      this.mMarker.setAlpha(paramFloat);
    }
    AppMethodBeat.o(205869);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205870);
    if (this.mMarker != null) {
      this.mMarker.setAnchor(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(205870);
  }
  
  public void setContentDescription(String paramString)
  {
    AppMethodBeat.i(205887);
    if (this.mMarker != null) {
      this.mMarker.setContentDescription(paramString);
    }
    AppMethodBeat.o(205887);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    AppMethodBeat.i(205871);
    if (this.mMarker != null) {
      this.mMarker.setDraggable(paramBoolean);
    }
    AppMethodBeat.o(205871);
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(205872);
    if ((this.mMarker != null) && (paramBitmapDescriptor != null)) {
      this.mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    }
    AppMethodBeat.o(205872);
  }
  
  public void setInfoWindowHideAnimation(Animation paramAnimation) {}
  
  public void setInfoWindowShowAnimation(Animation paramAnimation) {}
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(205885);
    if (this.mMarker != null) {
      this.mMarker.setLevel(paramInt);
    }
    AppMethodBeat.o(205885);
  }
  
  public void setMarkerView(View paramView)
  {
    AppMethodBeat.i(205880);
    if (this.mMarker != null) {
      this.mMarker.setIcon(BitmapDescriptorFactory.fromView(paramView));
    }
    AppMethodBeat.o(205880);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(205873);
    if (this.mMarker != null) {
      this.mMarker.setPosition(l.c(paramLatLng));
    }
    AppMethodBeat.o(205873);
  }
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(205874);
    if (this.mMarker != null) {
      this.mMarker.setRotation(paramFloat);
    }
    AppMethodBeat.o(205874);
  }
  
  public void setSnippet(String paramString)
  {
    AppMethodBeat.i(205875);
    if (this.mMarker != null) {
      this.mMarker.setSnippet(paramString);
    }
    AppMethodBeat.o(205875);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(205882);
    if (this.mMarker != null) {
      this.mMarker.setTag(paramObject);
    }
    AppMethodBeat.o(205882);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(205876);
    if (this.mMarker != null) {
      this.mMarker.setTitle(paramString);
    }
    AppMethodBeat.o(205876);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(205877);
    if (this.mMarker != null) {
      this.mMarker.setVisible(paramBoolean);
    }
    AppMethodBeat.o(205877);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(205883);
    if (this.mMarker != null) {
      this.mMarker.setZIndex(paramFloat);
    }
    AppMethodBeat.o(205883);
  }
  
  public void showInfoWindow()
  {
    AppMethodBeat.i(205878);
    if (this.mMarker != null) {
      this.mMarker.showInfoWindow();
    }
    AppMethodBeat.o(205878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */