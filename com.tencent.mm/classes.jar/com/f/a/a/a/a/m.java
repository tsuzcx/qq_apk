package com.f.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements com.tencent.tencentmap.mapsdk.map.UiSettings
{
  private com.tencent.tencentmap.mapsdk.maps.UiSettings MXn;
  
  public m(com.tencent.tencentmap.mapsdk.maps.UiSettings paramUiSettings)
  {
    this.MXn = paramUiSettings;
  }
  
  public final boolean isAnimationEnabled()
  {
    return false;
  }
  
  public final boolean isCompassEnabled()
  {
    AppMethodBeat.i(212906);
    if (this.MXn == null)
    {
      AppMethodBeat.o(212906);
      return false;
    }
    boolean bool = this.MXn.isCompassEnabled();
    AppMethodBeat.o(212906);
    return bool;
  }
  
  public final boolean isIndoorLevelPickerEnabled()
  {
    AppMethodBeat.i(212904);
    if (this.MXn == null)
    {
      AppMethodBeat.o(212904);
      return false;
    }
    boolean bool = this.MXn.isIndoorLevelPickerEnabled();
    AppMethodBeat.o(212904);
    return bool;
  }
  
  public final boolean isRotateGesturesEnabled()
  {
    AppMethodBeat.i(212901);
    if (this.MXn == null)
    {
      AppMethodBeat.o(212901);
      return false;
    }
    boolean bool = this.MXn.isRotateGesturesEnabled();
    AppMethodBeat.o(212901);
    return bool;
  }
  
  public final boolean isScaleControlsEnabled()
  {
    AppMethodBeat.i(212896);
    if (this.MXn != null)
    {
      boolean bool = this.MXn.isScaleViewEnabled();
      AppMethodBeat.o(212896);
      return bool;
    }
    AppMethodBeat.o(212896);
    return false;
  }
  
  public final boolean isTiltGesturesEnabled()
  {
    AppMethodBeat.i(212899);
    if (this.MXn == null)
    {
      AppMethodBeat.o(212899);
      return false;
    }
    boolean bool = this.MXn.isTiltGesturesEnabled();
    AppMethodBeat.o(212899);
    return bool;
  }
  
  public final void setAllGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212893);
    if (this.MXn != null) {
      this.MXn.setAllGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(212893);
  }
  
  public final void setAnimationEnabled(boolean paramBoolean) {}
  
  public final void setCompassEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212905);
    if (this.MXn == null)
    {
      AppMethodBeat.o(212905);
      return;
    }
    this.MXn.setCompassEnabled(paramBoolean);
    AppMethodBeat.o(212905);
  }
  
  public final void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212903);
    if (this.MXn != null) {
      this.MXn.setIndoorLevelPickerEnabled(paramBoolean);
    }
    AppMethodBeat.o(212903);
  }
  
  public final void setLogoPosition(int paramInt)
  {
    AppMethodBeat.i(212894);
    if (this.MXn != null) {
      this.MXn.setLogoPosition(paramInt);
    }
    AppMethodBeat.o(212894);
  }
  
  public final void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(212902);
    if (this.MXn != null) {
      this.MXn.setLogoPosition(paramInt, paramArrayOfInt);
    }
    AppMethodBeat.o(212902);
  }
  
  public final void setLogoScale(float paramFloat)
  {
    AppMethodBeat.i(212900);
    if (this.MXn == null)
    {
      AppMethodBeat.o(212900);
      return;
    }
    this.MXn.setLogoScale(paramFloat);
    AppMethodBeat.o(212900);
  }
  
  public final void setRotateGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212898);
    if (this.MXn == null)
    {
      AppMethodBeat.o(212898);
      return;
    }
    this.MXn.setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(212898);
  }
  
  public final void setScaleControlsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212890);
    if (this.MXn != null) {
      this.MXn.setScaleViewEnabled(paramBoolean);
    }
    AppMethodBeat.o(212890);
  }
  
  public final void setScaleViewPosition(int paramInt)
  {
    AppMethodBeat.i(212895);
    if (this.MXn != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.MXn.setScaleViewPosition(paramInt);
      AppMethodBeat.o(212895);
      return;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212891);
    if (this.MXn != null) {
      this.MXn.setScrollGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(212891);
  }
  
  public final void setTiltGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212897);
    if (this.MXn == null)
    {
      AppMethodBeat.o(212897);
      return;
    }
    this.MXn.setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(212897);
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(212892);
    if (this.MXn != null) {
      this.MXn.setZoomGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(212892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */