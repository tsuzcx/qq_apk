package com.f.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements com.tencent.tencentmap.mapsdk.map.UiSettings
{
  private com.tencent.tencentmap.mapsdk.maps.UiSettings MAg;
  
  public m(com.tencent.tencentmap.mapsdk.maps.UiSettings paramUiSettings)
  {
    this.MAg = paramUiSettings;
  }
  
  public final boolean isAnimationEnabled()
  {
    return false;
  }
  
  public final boolean isCompassEnabled()
  {
    AppMethodBeat.i(200212);
    if (this.MAg == null)
    {
      AppMethodBeat.o(200212);
      return false;
    }
    boolean bool = this.MAg.isCompassEnabled();
    AppMethodBeat.o(200212);
    return bool;
  }
  
  public final boolean isIndoorLevelPickerEnabled()
  {
    AppMethodBeat.i(200210);
    if (this.MAg == null)
    {
      AppMethodBeat.o(200210);
      return false;
    }
    boolean bool = this.MAg.isIndoorLevelPickerEnabled();
    AppMethodBeat.o(200210);
    return bool;
  }
  
  public final boolean isRotateGesturesEnabled()
  {
    AppMethodBeat.i(200207);
    if (this.MAg == null)
    {
      AppMethodBeat.o(200207);
      return false;
    }
    boolean bool = this.MAg.isRotateGesturesEnabled();
    AppMethodBeat.o(200207);
    return bool;
  }
  
  public final boolean isScaleControlsEnabled()
  {
    AppMethodBeat.i(200202);
    if (this.MAg != null)
    {
      boolean bool = this.MAg.isScaleViewEnabled();
      AppMethodBeat.o(200202);
      return bool;
    }
    AppMethodBeat.o(200202);
    return false;
  }
  
  public final boolean isTiltGesturesEnabled()
  {
    AppMethodBeat.i(200205);
    if (this.MAg == null)
    {
      AppMethodBeat.o(200205);
      return false;
    }
    boolean bool = this.MAg.isTiltGesturesEnabled();
    AppMethodBeat.o(200205);
    return bool;
  }
  
  public final void setAllGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200199);
    if (this.MAg != null) {
      this.MAg.setAllGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(200199);
  }
  
  public final void setAnimationEnabled(boolean paramBoolean) {}
  
  public final void setCompassEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200211);
    if (this.MAg == null)
    {
      AppMethodBeat.o(200211);
      return;
    }
    this.MAg.setCompassEnabled(paramBoolean);
    AppMethodBeat.o(200211);
  }
  
  public final void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200209);
    if (this.MAg != null) {
      this.MAg.setIndoorLevelPickerEnabled(paramBoolean);
    }
    AppMethodBeat.o(200209);
  }
  
  public final void setLogoPosition(int paramInt)
  {
    AppMethodBeat.i(200200);
    if (this.MAg != null) {
      this.MAg.setLogoPosition(paramInt);
    }
    AppMethodBeat.o(200200);
  }
  
  public final void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200208);
    if (this.MAg != null) {
      this.MAg.setLogoPosition(paramInt, paramArrayOfInt);
    }
    AppMethodBeat.o(200208);
  }
  
  public final void setLogoScale(float paramFloat)
  {
    AppMethodBeat.i(200206);
    if (this.MAg == null)
    {
      AppMethodBeat.o(200206);
      return;
    }
    this.MAg.setLogoScale(paramFloat);
    AppMethodBeat.o(200206);
  }
  
  public final void setRotateGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200204);
    if (this.MAg == null)
    {
      AppMethodBeat.o(200204);
      return;
    }
    this.MAg.setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(200204);
  }
  
  public final void setScaleControlsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200196);
    if (this.MAg != null) {
      this.MAg.setScaleViewEnabled(paramBoolean);
    }
    AppMethodBeat.o(200196);
  }
  
  public final void setScaleViewPosition(int paramInt)
  {
    AppMethodBeat.i(200201);
    if (this.MAg != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.MAg.setScaleViewPosition(paramInt);
      AppMethodBeat.o(200201);
      return;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200197);
    if (this.MAg != null) {
      this.MAg.setScrollGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(200197);
  }
  
  public final void setTiltGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200203);
    if (this.MAg == null)
    {
      AppMethodBeat.o(200203);
      return;
    }
    this.MAg.setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(200203);
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(200198);
    if (this.MAg != null) {
      this.MAg.setZoomGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(200198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.f.a.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */