package com.e.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements com.tencent.tencentmap.mapsdk.map.UiSettings
{
  private com.tencent.tencentmap.mapsdk.maps.UiSettings aamp;
  
  public m(com.tencent.tencentmap.mapsdk.maps.UiSettings paramUiSettings)
  {
    this.aamp = paramUiSettings;
  }
  
  public final boolean isAnimationEnabled()
  {
    return false;
  }
  
  public final boolean isCompassEnabled()
  {
    AppMethodBeat.i(189178);
    if (this.aamp == null)
    {
      AppMethodBeat.o(189178);
      return false;
    }
    boolean bool = this.aamp.isCompassEnabled();
    AppMethodBeat.o(189178);
    return bool;
  }
  
  public final boolean isIndoorLevelPickerEnabled()
  {
    AppMethodBeat.i(189174);
    if (this.aamp == null)
    {
      AppMethodBeat.o(189174);
      return false;
    }
    boolean bool = this.aamp.isIndoorLevelPickerEnabled();
    AppMethodBeat.o(189174);
    return bool;
  }
  
  public final boolean isRotateGesturesEnabled()
  {
    AppMethodBeat.i(189168);
    if (this.aamp == null)
    {
      AppMethodBeat.o(189168);
      return false;
    }
    boolean bool = this.aamp.isRotateGesturesEnabled();
    AppMethodBeat.o(189168);
    return bool;
  }
  
  public final boolean isScaleControlsEnabled()
  {
    AppMethodBeat.i(189156);
    if (this.aamp != null)
    {
      boolean bool = this.aamp.isScaleViewEnabled();
      AppMethodBeat.o(189156);
      return bool;
    }
    AppMethodBeat.o(189156);
    return false;
  }
  
  public final boolean isTiltGesturesEnabled()
  {
    AppMethodBeat.i(189164);
    if (this.aamp == null)
    {
      AppMethodBeat.o(189164);
      return false;
    }
    boolean bool = this.aamp.isTiltGesturesEnabled();
    AppMethodBeat.o(189164);
    return bool;
  }
  
  public final void setAllGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189153);
    if (this.aamp != null) {
      this.aamp.setAllGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(189153);
  }
  
  public final void setAnimationEnabled(boolean paramBoolean) {}
  
  public final void setCompassEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189176);
    if (this.aamp == null)
    {
      AppMethodBeat.o(189176);
      return;
    }
    this.aamp.setCompassEnabled(paramBoolean);
    AppMethodBeat.o(189176);
  }
  
  public final void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189172);
    if (this.aamp != null) {
      this.aamp.setIndoorLevelPickerEnabled(paramBoolean);
    }
    AppMethodBeat.o(189172);
  }
  
  public final void setLogoPosition(int paramInt)
  {
    AppMethodBeat.i(189154);
    if (this.aamp != null) {
      this.aamp.setLogoPosition(paramInt);
    }
    AppMethodBeat.o(189154);
  }
  
  public final void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(189170);
    if (this.aamp != null) {
      this.aamp.setLogoPosition(paramInt, paramArrayOfInt);
    }
    AppMethodBeat.o(189170);
  }
  
  public final void setLogoScale(float paramFloat)
  {
    AppMethodBeat.i(189166);
    if (this.aamp == null)
    {
      AppMethodBeat.o(189166);
      return;
    }
    this.aamp.setLogoScale(paramFloat);
    AppMethodBeat.o(189166);
  }
  
  public final void setRotateGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189162);
    if (this.aamp == null)
    {
      AppMethodBeat.o(189162);
      return;
    }
    this.aamp.setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(189162);
  }
  
  public final void setScaleControlsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189150);
    if (this.aamp != null) {
      this.aamp.setScaleViewEnabled(paramBoolean);
    }
    AppMethodBeat.o(189150);
  }
  
  public final void setScaleViewPosition(int paramInt)
  {
    AppMethodBeat.i(189155);
    if (this.aamp != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.aamp.setScaleViewPosition(paramInt);
      AppMethodBeat.o(189155);
      return;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189151);
    if (this.aamp != null) {
      this.aamp.setScrollGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(189151);
  }
  
  public final void setTiltGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189159);
    if (this.aamp == null)
    {
      AppMethodBeat.o(189159);
      return;
    }
    this.aamp.setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(189159);
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189152);
    if (this.aamp != null) {
      this.aamp.setZoomGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(189152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.e.a.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */