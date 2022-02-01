package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class av
  extends au<an>
  implements Marker
{
  public an a;
  
  public av(an paraman)
  {
    this.a = paraman;
  }
  
  private an b()
  {
    return this.a;
  }
  
  public final float getAlpha()
  {
    AppMethodBeat.i(224318);
    float f = this.a.getAlpha();
    AppMethodBeat.o(224318);
    return f;
  }
  
  public final float getAnchorU()
  {
    AppMethodBeat.i(224540);
    float f = this.a.getAnchorU();
    AppMethodBeat.o(224540);
    return f;
  }
  
  public final float getAnchorV()
  {
    AppMethodBeat.i(224551);
    float f = this.a.getAnchorV();
    AppMethodBeat.o(224551);
    return f;
  }
  
  public final String getContentDescription()
  {
    AppMethodBeat.i(224644);
    if (this.a != null)
    {
      String str = this.a.getContentDescription();
      AppMethodBeat.o(224644);
      return str;
    }
    AppMethodBeat.o(224644);
    return null;
  }
  
  public final int getDisplayLevel()
  {
    AppMethodBeat.i(224559);
    int i = this.a.getDisplayLevel();
    AppMethodBeat.o(224559);
    return i;
  }
  
  public final int getHeight(Context paramContext)
  {
    AppMethodBeat.i(224534);
    if (this.a == null)
    {
      AppMethodBeat.o(224534);
      return 0;
    }
    int i = this.a.getHeight(paramContext);
    AppMethodBeat.o(224534);
    return i;
  }
  
  public final TencentMap.OnMarkerDragListener getOnDragListener()
  {
    AppMethodBeat.i(224578);
    TencentMap.OnMarkerDragListener localOnMarkerDragListener = this.a.getOnDragListener();
    AppMethodBeat.o(224578);
    return localOnMarkerDragListener;
  }
  
  public final MarkerOptions getOptions()
  {
    AppMethodBeat.i(224495);
    MarkerOptions localMarkerOptions = this.a.getOptions();
    AppMethodBeat.o(224495);
    return localMarkerOptions;
  }
  
  public final LatLng getPosition()
  {
    AppMethodBeat.i(224274);
    LatLng localLatLng = this.a.getPosition();
    AppMethodBeat.o(224274);
    return localLatLng;
  }
  
  public final float getRotation()
  {
    AppMethodBeat.i(224422);
    if (this.a == null)
    {
      AppMethodBeat.o(224422);
      return 0.0F;
    }
    float f = this.a.getRotation();
    AppMethodBeat.o(224422);
    return f;
  }
  
  public final String getSnippet()
  {
    AppMethodBeat.i(224312);
    String str = this.a.getSnippet();
    AppMethodBeat.o(224312);
    return str;
  }
  
  public final Object getTag()
  {
    AppMethodBeat.i(224599);
    Object localObject = this.a.getTag();
    AppMethodBeat.o(224599);
    return localObject;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(224293);
    String str = this.a.getTitle();
    AppMethodBeat.o(224293);
    return str;
  }
  
  public final int getWidth(Context paramContext)
  {
    AppMethodBeat.i(224521);
    if (this.a == null)
    {
      AppMethodBeat.o(224521);
      return 0;
    }
    int i = this.a.getWidth(paramContext);
    AppMethodBeat.o(224521);
    return i;
  }
  
  public final void hideInfoWindow()
  {
    AppMethodBeat.i(224368);
    if (this.a == null)
    {
      AppMethodBeat.o(224368);
      return;
    }
    this.a.hideInfoWindow();
    AppMethodBeat.o(224368);
  }
  
  public final boolean isClickable()
  {
    AppMethodBeat.i(224469);
    if (this.a == null)
    {
      AppMethodBeat.o(224469);
      return false;
    }
    boolean bool = this.a.isClickable();
    AppMethodBeat.o(224469);
    return bool;
  }
  
  public final boolean isCollisionBy(Collision paramCollision)
  {
    AppMethodBeat.i(224666);
    if (this.a != null)
    {
      boolean bool = this.a.isCollisionBy(paramCollision);
      AppMethodBeat.o(224666);
      return bool;
    }
    AppMethodBeat.o(224666);
    return false;
  }
  
  public final boolean isDraggable()
  {
    AppMethodBeat.i(224338);
    boolean bool = this.a.isDraggable();
    AppMethodBeat.o(224338);
    return bool;
  }
  
  public final boolean isFastLoad()
  {
    AppMethodBeat.i(224512);
    if (this.a == null)
    {
      AppMethodBeat.o(224512);
      return false;
    }
    boolean bool = this.a.isFastLoad();
    AppMethodBeat.o(224512);
    return bool;
  }
  
  public final boolean isInMapCenterState()
  {
    AppMethodBeat.i(224263);
    boolean bool = this.a.isInMapCenterState();
    AppMethodBeat.o(224263);
    return bool;
  }
  
  public final boolean isInfoWindowAutoOverturn()
  {
    AppMethodBeat.i(224567);
    boolean bool = this.a.isInfoWindowAutoOverturn();
    AppMethodBeat.o(224567);
    return bool;
  }
  
  public final boolean isInfoWindowEnable()
  {
    AppMethodBeat.i(224248);
    boolean bool = this.a.isInfoWindowEnable();
    AppMethodBeat.o(224248);
    return bool;
  }
  
  public final boolean isInfoWindowShown()
  {
    AppMethodBeat.i(224379);
    if (this.a == null)
    {
      AppMethodBeat.o(224379);
      return false;
    }
    boolean bool = this.a.isInfoWindowShown();
    AppMethodBeat.o(224379);
    return bool;
  }
  
  public final boolean onTapMapViewBubbleHidden()
  {
    AppMethodBeat.i(224224);
    boolean bool = this.a.onTapMapViewBubbleHidden();
    AppMethodBeat.o(224224);
    return bool;
  }
  
  public final void refreshInfoWindow()
  {
    AppMethodBeat.i(224358);
    if (this.a == null)
    {
      AppMethodBeat.o(224358);
      return;
    }
    this.a.refreshInfoWindow();
    AppMethodBeat.o(224358);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(224452);
    if (this.a == null)
    {
      AppMethodBeat.o(224452);
      return;
    }
    this.a.setAlpha(paramFloat);
    AppMethodBeat.o(224452);
  }
  
  public final void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224390);
    if (this.a == null)
    {
      AppMethodBeat.o(224390);
      return;
    }
    this.a.setAnchor(paramFloat1, paramFloat2);
    AppMethodBeat.o(224390);
  }
  
  public final void setAnimation(Animation paramAnimation)
  {
    AppMethodBeat.i(224429);
    if ((this.a == null) || (paramAnimation == null))
    {
      AppMethodBeat.o(224429);
      return;
    }
    this.a.setAnimation(paramAnimation);
    AppMethodBeat.o(224429);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(224462);
    if (this.a == null)
    {
      AppMethodBeat.o(224462);
      return;
    }
    this.a.setClickable(paramBoolean);
    AppMethodBeat.o(224462);
  }
  
  public final void setCollisions(Collision... paramVarArgs)
  {
    AppMethodBeat.i(224656);
    if (this.a != null) {
      this.a.setCollisions(paramVarArgs);
    }
    AppMethodBeat.o(224656);
  }
  
  public final void setContentDescription(String paramString)
  {
    AppMethodBeat.i(224633);
    if (this.a != null) {
      this.a.setContentDescription(paramString);
    }
    AppMethodBeat.o(224633);
  }
  
  public final void setDraggable(boolean paramBoolean)
  {
    AppMethodBeat.i(224329);
    if (this.a == null)
    {
      AppMethodBeat.o(224329);
      return;
    }
    this.a.setDraggable(paramBoolean);
    an localan = this.a;
    if ((!paramBoolean) && (this.a.b())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localan.setFixingPointEnable(paramBoolean);
      AppMethodBeat.o(224329);
      return;
    }
  }
  
  public final void setFastLoad(boolean paramBoolean)
  {
    AppMethodBeat.i(224505);
    this.a.setFastLoad(paramBoolean);
    AppMethodBeat.o(224505);
  }
  
  public final void setFixingPoint(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224481);
    this.a.setFixingPoint(paramInt1, paramInt2);
    this.a.setDraggable(false);
    AppMethodBeat.o(224481);
  }
  
  public final void setFixingPointEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(224476);
    this.a.setFixingPointEnable(paramBoolean);
    if (this.a.isDraggable()) {
      if (paramBoolean) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      setDraggable(bool);
      if (!paramBoolean) {
        this.a.setPosition(this.a.getPosition());
      }
      AppMethodBeat.o(224476);
      return;
    }
  }
  
  public final void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(224402);
    if (this.a == null)
    {
      AppMethodBeat.o(224402);
      return;
    }
    this.a.setIcon(paramBitmapDescriptor);
    AppMethodBeat.o(224402);
  }
  
  public final void setInMapCenterState(boolean paramBoolean)
  {
    AppMethodBeat.i(224257);
    if (this.a == null)
    {
      AppMethodBeat.o(224257);
      return;
    }
    this.a.setInMapCenterState(paramBoolean);
    AppMethodBeat.o(224257);
  }
  
  public final void setInfoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224610);
    if (this.a == null)
    {
      AppMethodBeat.o(224610);
      return;
    }
    this.a.setInfoWindowAnchor(paramFloat1, paramFloat2);
    refreshInfoWindow();
    AppMethodBeat.o(224610);
  }
  
  public final void setInfoWindowEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(224241);
    if (this.a == null)
    {
      AppMethodBeat.o(224241);
      return;
    }
    this.a.setInfoWindowEnable(paramBoolean);
    AppMethodBeat.o(224241);
  }
  
  public final void setInfoWindowOffset(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224619);
    if (this.a == null)
    {
      AppMethodBeat.o(224619);
      return;
    }
    this.a.setInfoWindowOffset(paramInt1, paramInt2);
    refreshInfoWindow();
    AppMethodBeat.o(224619);
  }
  
  public final void setMarkerOptions(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(224486);
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(224486);
      return;
    }
    this.a.setMarkerOptions(paramMarkerOptions);
    AppMethodBeat.o(224486);
  }
  
  public final void setOnTapMapViewBubbleHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(224214);
    this.a.a(paramBoolean);
    AppMethodBeat.o(224214);
  }
  
  public final void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(224233);
    if ((this.a == null) || (paramLatLng == null))
    {
      AppMethodBeat.o(224233);
      return;
    }
    this.a.setPosition(paramLatLng);
    AppMethodBeat.o(224233);
  }
  
  public final void setRotation(float paramFloat)
  {
    AppMethodBeat.i(224416);
    if (this.a == null)
    {
      AppMethodBeat.o(224416);
      return;
    }
    this.a.setRotation(paramFloat);
    AppMethodBeat.o(224416);
  }
  
  public final void setSnippet(String paramString)
  {
    AppMethodBeat.i(224304);
    if (this.a == null)
    {
      AppMethodBeat.o(224304);
      return;
    }
    this.a.setSnippet(paramString);
    AppMethodBeat.o(224304);
  }
  
  public final void setTag(Object paramObject)
  {
    AppMethodBeat.i(224589);
    this.a.setTag(paramObject);
    AppMethodBeat.o(224589);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(224282);
    if (this.a == null)
    {
      AppMethodBeat.o(224282);
      return;
    }
    this.a.setTitle(paramString);
    AppMethodBeat.o(224282);
  }
  
  public final void showInfoWindow()
  {
    AppMethodBeat.i(224347);
    if (this.a == null)
    {
      AppMethodBeat.o(224347);
      return;
    }
    this.a.showInfoWindow();
    AppMethodBeat.o(224347);
  }
  
  public final void startAnimation(Animation paramAnimation)
  {
    AppMethodBeat.i(224444);
    setAnimation(paramAnimation);
    startAnimation();
    AppMethodBeat.o(224444);
  }
  
  public final boolean startAnimation()
  {
    AppMethodBeat.i(224437);
    if (this.a == null)
    {
      AppMethodBeat.o(224437);
      return false;
    }
    boolean bool = this.a.startAnimation();
    AppMethodBeat.o(224437);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.av
 * JD-Core Version:    0.7.0.1
 */