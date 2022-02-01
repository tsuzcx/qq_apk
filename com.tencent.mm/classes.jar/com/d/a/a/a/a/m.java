package com.d.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements com.tencent.tencentmap.mapsdk.map.UiSettings
{
  private com.tencent.tencentmap.mapsdk.maps.UiSettings SKv;
  
  public m(com.tencent.tencentmap.mapsdk.maps.UiSettings paramUiSettings)
  {
    this.SKv = paramUiSettings;
  }
  
  public final boolean isAnimationEnabled()
  {
    return false;
  }
  
  public final boolean isCompassEnabled()
  {
    AppMethodBeat.i(217566);
    if (this.SKv == null)
    {
      AppMethodBeat.o(217566);
      return false;
    }
    boolean bool = this.SKv.isCompassEnabled();
    AppMethodBeat.o(217566);
    return bool;
  }
  
  public final boolean isIndoorLevelPickerEnabled()
  {
    AppMethodBeat.i(217564);
    if (this.SKv == null)
    {
      AppMethodBeat.o(217564);
      return false;
    }
    boolean bool = this.SKv.isIndoorLevelPickerEnabled();
    AppMethodBeat.o(217564);
    return bool;
  }
  
  public final boolean isRotateGesturesEnabled()
  {
    AppMethodBeat.i(217561);
    if (this.SKv == null)
    {
      AppMethodBeat.o(217561);
      return false;
    }
    boolean bool = this.SKv.isRotateGesturesEnabled();
    AppMethodBeat.o(217561);
    return bool;
  }
  
  public final boolean isScaleControlsEnabled()
  {
    AppMethodBeat.i(217556);
    if (this.SKv != null)
    {
      boolean bool = this.SKv.isScaleViewEnabled();
      AppMethodBeat.o(217556);
      return bool;
    }
    AppMethodBeat.o(217556);
    return false;
  }
  
  public final boolean isTiltGesturesEnabled()
  {
    AppMethodBeat.i(217559);
    if (this.SKv == null)
    {
      AppMethodBeat.o(217559);
      return false;
    }
    boolean bool = this.SKv.isTiltGesturesEnabled();
    AppMethodBeat.o(217559);
    return bool;
  }
  
  public final void setAllGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217553);
    if (this.SKv != null) {
      this.SKv.setAllGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(217553);
  }
  
  public final void setAnimationEnabled(boolean paramBoolean) {}
  
  public final void setCompassEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217565);
    if (this.SKv == null)
    {
      AppMethodBeat.o(217565);
      return;
    }
    this.SKv.setCompassEnabled(paramBoolean);
    AppMethodBeat.o(217565);
  }
  
  public final void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217563);
    if (this.SKv != null) {
      this.SKv.setIndoorLevelPickerEnabled(paramBoolean);
    }
    AppMethodBeat.o(217563);
  }
  
  public final void setLogoPosition(int paramInt)
  {
    AppMethodBeat.i(217554);
    if (this.SKv != null) {
      this.SKv.setLogoPosition(paramInt);
    }
    AppMethodBeat.o(217554);
  }
  
  public final void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(217562);
    if (this.SKv != null) {
      this.SKv.setLogoPosition(paramInt, paramArrayOfInt);
    }
    AppMethodBeat.o(217562);
  }
  
  public final void setLogoScale(float paramFloat)
  {
    AppMethodBeat.i(217560);
    if (this.SKv == null)
    {
      AppMethodBeat.o(217560);
      return;
    }
    this.SKv.setLogoScale(paramFloat);
    AppMethodBeat.o(217560);
  }
  
  public final void setRotateGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217558);
    if (this.SKv == null)
    {
      AppMethodBeat.o(217558);
      return;
    }
    this.SKv.setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(217558);
  }
  
  public final void setScaleControlsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217550);
    if (this.SKv != null) {
      this.SKv.setScaleViewEnabled(paramBoolean);
    }
    AppMethodBeat.o(217550);
  }
  
  public final void setScaleViewPosition(int paramInt)
  {
    AppMethodBeat.i(217555);
    if (this.SKv != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.SKv.setScaleViewPosition(paramInt);
      AppMethodBeat.o(217555);
      return;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217551);
    if (this.SKv != null) {
      this.SKv.setScrollGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(217551);
  }
  
  public final void setTiltGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217557);
    if (this.SKv == null)
    {
      AppMethodBeat.o(217557);
      return;
    }
    this.SKv.setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(217557);
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217552);
    if (this.SKv != null) {
      this.SKv.setZoomGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(217552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */