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
  private i MWE;
  private com.tencent.tencentmap.mapsdk.maps.model.Marker mMarker;
  
  public e(i parami, com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(212655);
    this.MWE = parami;
    this.mMarker = paramMarker;
    if ((this.MWE != null) && (this.MWE.MWJ != null)) {
      try
      {
        this.MWE.MWJ.add(this.mMarker);
        return;
      }
      finally
      {
        AppMethodBeat.o(212655);
      }
    }
    AppMethodBeat.o(212655);
  }
  
  public float getAlpha()
  {
    AppMethodBeat.i(212656);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getAlpha();
      AppMethodBeat.o(212656);
      return f;
    }
    AppMethodBeat.o(212656);
    return 0.0F;
  }
  
  public String getContentDescription()
  {
    AppMethodBeat.i(212686);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getContentDescription();
      AppMethodBeat.o(212686);
      return str;
    }
    AppMethodBeat.o(212686);
    return null;
  }
  
  public String getId()
  {
    AppMethodBeat.i(212657);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getId();
      AppMethodBeat.o(212657);
      return str;
    }
    AppMethodBeat.o(212657);
    return "";
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(212684);
    if (this.mMarker != null)
    {
      int i = this.mMarker.getLevel();
      AppMethodBeat.o(212684);
      return i;
    }
    AppMethodBeat.o(212684);
    return 0;
  }
  
  public View getMarkerView()
  {
    return null;
  }
  
  public LatLng getPosition()
  {
    AppMethodBeat.i(212658);
    if (this.mMarker != null)
    {
      LatLng localLatLng = l.a(this.mMarker.getPosition());
      AppMethodBeat.o(212658);
      return localLatLng;
    }
    AppMethodBeat.o(212658);
    return null;
  }
  
  public float getRotation()
  {
    AppMethodBeat.i(212659);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getRotation();
      AppMethodBeat.o(212659);
      return f;
    }
    AppMethodBeat.o(212659);
    return 0.0F;
  }
  
  public String getSnippet()
  {
    AppMethodBeat.i(212660);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getSnippet();
      AppMethodBeat.o(212660);
      return str;
    }
    AppMethodBeat.o(212660);
    return null;
  }
  
  public Object getTag()
  {
    AppMethodBeat.i(212679);
    if (this.mMarker != null)
    {
      Object localObject = this.mMarker.getTag();
      AppMethodBeat.o(212679);
      return localObject;
    }
    AppMethodBeat.o(212679);
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(212661);
    if (this.mMarker != null)
    {
      String str = this.mMarker.getTitle();
      AppMethodBeat.o(212661);
      return str;
    }
    AppMethodBeat.o(212661);
    return null;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(212682);
    if (this.mMarker != null)
    {
      float f = this.mMarker.getZIndex();
      AppMethodBeat.o(212682);
      return f;
    }
    AppMethodBeat.o(212682);
    return 0.0F;
  }
  
  public void hideInfoWindow()
  {
    AppMethodBeat.i(212662);
    if (this.mMarker != null) {
      this.mMarker.hideInfoWindow();
    }
    AppMethodBeat.o(212662);
  }
  
  public boolean isDraggable()
  {
    AppMethodBeat.i(212663);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isDraggable();
      AppMethodBeat.o(212663);
      return bool;
    }
    AppMethodBeat.o(212663);
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    AppMethodBeat.i(212664);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isInfoWindowShown();
      AppMethodBeat.o(212664);
      return bool;
    }
    AppMethodBeat.o(212664);
    return false;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(212665);
    if (this.mMarker != null)
    {
      boolean bool = this.mMarker.isVisible();
      AppMethodBeat.o(212665);
      return bool;
    }
    AppMethodBeat.o(212665);
    return false;
  }
  
  public void refreshInfoWindow()
  {
    AppMethodBeat.i(212687);
    if (this.mMarker != null) {
      this.mMarker.refreshInfoWindow();
    }
    AppMethodBeat.o(212687);
  }
  
  public void remove()
  {
    AppMethodBeat.i(212666);
    if (this.mMarker != null) {}
    try
    {
      if ((this.MWE != null) && (this.MWE.MWJ != null)) {
        this.MWE.MWJ.remove(this.mMarker);
      }
      this.mMarker.remove();
      AppMethodBeat.o(212666);
      return;
    }
    finally
    {
      AppMethodBeat.o(212666);
    }
  }
  
  public void set2Top()
  {
    AppMethodBeat.i(212677);
    if ((this.MWE == null) || (this.MWE.MWJ == null))
    {
      AppMethodBeat.o(212677);
      return;
    }
    try
    {
      int i = this.MWE.MWJ.size();
      Object localObject1 = this.MWE.MWJ.iterator();
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
      AppMethodBeat.o(212677);
    }
    for (;;) {}
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(212667);
    if (this.mMarker != null) {
      this.mMarker.setAlpha(paramFloat);
    }
    AppMethodBeat.o(212667);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(212668);
    if (this.mMarker != null) {
      this.mMarker.setAnchor(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(212668);
  }
  
  public void setContentDescription(String paramString)
  {
    AppMethodBeat.i(212685);
    if (this.mMarker != null) {
      this.mMarker.setContentDescription(paramString);
    }
    AppMethodBeat.o(212685);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    AppMethodBeat.i(212669);
    if (this.mMarker != null) {
      this.mMarker.setDraggable(paramBoolean);
    }
    AppMethodBeat.o(212669);
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(212670);
    if ((this.mMarker != null) && (paramBitmapDescriptor != null)) {
      this.mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    }
    AppMethodBeat.o(212670);
  }
  
  public void setInfoWindowHideAnimation(Animation paramAnimation) {}
  
  public void setInfoWindowShowAnimation(Animation paramAnimation) {}
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(212683);
    if (this.mMarker != null) {
      this.mMarker.setLevel(paramInt);
    }
    AppMethodBeat.o(212683);
  }
  
  public void setMarkerView(View paramView)
  {
    AppMethodBeat.i(212678);
    if (this.mMarker != null) {
      this.mMarker.setIcon(BitmapDescriptorFactory.fromView(paramView));
    }
    AppMethodBeat.o(212678);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(212671);
    if (this.mMarker != null) {
      this.mMarker.setPosition(l.c(paramLatLng));
    }
    AppMethodBeat.o(212671);
  }
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(212672);
    if (this.mMarker != null) {
      this.mMarker.setRotation(paramFloat);
    }
    AppMethodBeat.o(212672);
  }
  
  public void setSnippet(String paramString)
  {
    AppMethodBeat.i(212673);
    if (this.mMarker != null) {
      this.mMarker.setSnippet(paramString);
    }
    AppMethodBeat.o(212673);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(212680);
    if (this.mMarker != null) {
      this.mMarker.setTag(paramObject);
    }
    AppMethodBeat.o(212680);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(212674);
    if (this.mMarker != null) {
      this.mMarker.setTitle(paramString);
    }
    AppMethodBeat.o(212674);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(212675);
    if (this.mMarker != null) {
      this.mMarker.setVisible(paramBoolean);
    }
    AppMethodBeat.o(212675);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(212681);
    if (this.mMarker != null) {
      this.mMarker.setZIndex(paramFloat);
    }
    AppMethodBeat.o(212681);
  }
  
  public void showInfoWindow()
  {
    AppMethodBeat.i(212676);
    if (this.mMarker != null) {
      this.mMarker.showInfoWindow();
    }
    AppMethodBeat.o(212676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */