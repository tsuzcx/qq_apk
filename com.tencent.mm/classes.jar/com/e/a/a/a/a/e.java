package com.e.a.a.a.a;

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
  private i aalG;
  private com.tencent.tencentmap.mapsdk.maps.model.Marker mMarker;
  
  public e(i parami, com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(188267);
    this.aalG = parami;
    this.mMarker = paramMarker;
    if ((this.aalG != null) && (this.aalG.aalL != null)) {
      try
      {
        this.aalG.aalL.add(this.mMarker);
        return;
      }
      finally
      {
        AppMethodBeat.o(188267);
      }
    }
    AppMethodBeat.o(188267);
  }
  
  public float getAlpha()
  {
    AppMethodBeat.i(188269);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getAlpha();
      AppMethodBeat.o(188269);
      return f;
    }
    AppMethodBeat.o(188269);
    return 0.0F;
  }
  
  public String getContentDescription()
  {
    AppMethodBeat.i(188330);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getContentDescription();
      AppMethodBeat.o(188330);
      return str;
    }
    AppMethodBeat.o(188330);
    return null;
  }
  
  public String getId()
  {
    AppMethodBeat.i(188275);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getId();
      AppMethodBeat.o(188275);
      return str;
    }
    AppMethodBeat.o(188275);
    return "";
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(188327);
    if (this.mMarker != null)
    {
      int i = this.mMarker.getLevel();
      AppMethodBeat.o(188327);
      return i;
    }
    AppMethodBeat.o(188327);
    return 0;
  }
  
  public View getMarkerView()
  {
    return null;
  }
  
  public LatLng getPosition()
  {
    AppMethodBeat.i(188277);
    if (this.mMarker != null)
    {
      LatLng localLatLng = l.a(this.mMarker.getPosition());
      AppMethodBeat.o(188277);
      return localLatLng;
    }
    AppMethodBeat.o(188277);
    return null;
  }
  
  public float getRotation()
  {
    AppMethodBeat.i(188279);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getRotation();
      AppMethodBeat.o(188279);
      return f;
    }
    AppMethodBeat.o(188279);
    return 0.0F;
  }
  
  public String getSnippet()
  {
    AppMethodBeat.i(188281);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getSnippet();
      AppMethodBeat.o(188281);
      return str;
    }
    AppMethodBeat.o(188281);
    return null;
  }
  
  public Object getTag()
  {
    AppMethodBeat.i(188319);
    if (this.mMarker != null)
    {
      Object localObject = this.mMarker.getTag();
      AppMethodBeat.o(188319);
      return localObject;
    }
    AppMethodBeat.o(188319);
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(188282);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getTitle();
      AppMethodBeat.o(188282);
      return str;
    }
    AppMethodBeat.o(188282);
    return null;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(188325);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getZIndex();
      AppMethodBeat.o(188325);
      return f;
    }
    AppMethodBeat.o(188325);
    return 0.0F;
  }
  
  public void hideInfoWindow()
  {
    AppMethodBeat.i(188284);
    if (this.mMarker != null) {
      this.mMarker.hideInfoWindow();
    }
    AppMethodBeat.o(188284);
  }
  
  public boolean isDraggable()
  {
    AppMethodBeat.i(188286);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isDraggable();
      AppMethodBeat.o(188286);
      return bool;
    }
    AppMethodBeat.o(188286);
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    AppMethodBeat.i(188288);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isInfoWindowShown();
      AppMethodBeat.o(188288);
      return bool;
    }
    AppMethodBeat.o(188288);
    return false;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(188290);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isVisible();
      AppMethodBeat.o(188290);
      return bool;
    }
    AppMethodBeat.o(188290);
    return false;
  }
  
  public void refreshInfoWindow()
  {
    AppMethodBeat.i(188331);
    if (this.mMarker != null) {
      this.mMarker.refreshInfoWindow();
    }
    AppMethodBeat.o(188331);
  }
  
  public void remove()
  {
    AppMethodBeat.i(188292);
    if (this.mMarker != null) {}
    try
    {
      if ((this.aalG != null) && (this.aalG.aalL != null)) {
        this.aalG.aalL.remove(this.mMarker);
      }
      this.mMarker.remove();
      AppMethodBeat.o(188292);
      return;
    }
    finally
    {
      AppMethodBeat.o(188292);
    }
  }
  
  public void set2Top()
  {
    AppMethodBeat.i(188314);
    if ((this.aalG == null) || (this.aalG.aalL == null))
    {
      AppMethodBeat.o(188314);
      return;
    }
    try
    {
      int i = this.aalG.aalL.size();
      Object localObject1 = this.aalG.aalL.iterator();
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
      AppMethodBeat.o(188314);
    }
    for (;;) {}
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(188294);
    if (this.mMarker != null) {
      this.mMarker.setAlpha(paramFloat);
    }
    AppMethodBeat.o(188294);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(188296);
    if (this.mMarker != null) {
      this.mMarker.setAnchor(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(188296);
  }
  
  public void setCollisions(Collision... paramVarArgs)
  {
    AppMethodBeat.i(188333);
    if (this.mMarker != null) {
      this.mMarker.setCollisions(paramVarArgs);
    }
    AppMethodBeat.o(188333);
  }
  
  public void setContentDescription(String paramString)
  {
    AppMethodBeat.i(188328);
    if (this.mMarker != null) {
      this.mMarker.setContentDescription(paramString);
    }
    AppMethodBeat.o(188328);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    AppMethodBeat.i(188297);
    if (this.mMarker != null) {
      this.mMarker.setDraggable(paramBoolean);
    }
    AppMethodBeat.o(188297);
  }
  
  public void setIcon(com.tencent.mapsdk.raster.model.BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(188298);
    if ((this.mMarker != null) && (paramBitmapDescriptor != null))
    {
      paramBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap());
      paramBitmapDescriptor.getFormater().setScale(2);
      this.mMarker.setIcon(paramBitmapDescriptor);
    }
    AppMethodBeat.o(188298);
  }
  
  public void setInfoWindowHideAnimation(Animation paramAnimation) {}
  
  public void setInfoWindowOffset(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188332);
    if (this.mMarker != null) {
      this.mMarker.setInfoWindowOffset(paramInt1, paramInt2);
    }
    AppMethodBeat.o(188332);
  }
  
  public void setInfoWindowShowAnimation(Animation paramAnimation) {}
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(188326);
    if (this.mMarker != null) {
      this.mMarker.setLevel(paramInt);
    }
    AppMethodBeat.o(188326);
  }
  
  public void setMarkerView(View paramView)
  {
    AppMethodBeat.i(188316);
    if (this.mMarker != null) {
      this.mMarker.setIcon(BitmapDescriptorFactory.fromView(paramView));
    }
    AppMethodBeat.o(188316);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(188301);
    if (this.mMarker != null) {
      this.mMarker.setPosition(l.c(paramLatLng));
    }
    AppMethodBeat.o(188301);
  }
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(188302);
    if (this.mMarker != null) {
      this.mMarker.setRotation(paramFloat);
    }
    AppMethodBeat.o(188302);
  }
  
  public void setSnippet(String paramString)
  {
    AppMethodBeat.i(188304);
    if (this.mMarker != null) {
      this.mMarker.setSnippet(paramString);
    }
    AppMethodBeat.o(188304);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(188321);
    if (this.mMarker != null) {
      this.mMarker.setTag(paramObject);
    }
    AppMethodBeat.o(188321);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(188307);
    if (this.mMarker != null) {
      this.mMarker.setTitle(paramString);
    }
    AppMethodBeat.o(188307);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(188310);
    if (this.mMarker != null) {
      this.mMarker.setVisible(paramBoolean);
    }
    AppMethodBeat.o(188310);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(188323);
    if (this.mMarker != null) {
      this.mMarker.setZIndex(paramFloat);
    }
    AppMethodBeat.o(188323);
  }
  
  public void showInfoWindow()
  {
    AppMethodBeat.i(188312);
    if (this.mMarker != null) {
      this.mMarker.showInfoWindow();
    }
    AppMethodBeat.o(188312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */