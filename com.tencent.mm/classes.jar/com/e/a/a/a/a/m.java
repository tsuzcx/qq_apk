package com.e.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements com.tencent.tencentmap.mapsdk.map.UiSettings
{
  private com.tencent.tencentmap.mapsdk.maps.UiSettings KJt;
  
  public m(com.tencent.tencentmap.mapsdk.maps.UiSettings paramUiSettings)
  {
    this.KJt = paramUiSettings;
  }
  
  public final boolean isAnimationEnabled()
  {
    return false;
  }
  
  public final boolean isCompassEnabled()
  {
    AppMethodBeat.i(206089);
    if (this.KJt == null)
    {
      AppMethodBeat.o(206089);
      return false;
    }
    boolean bool = this.KJt.isCompassEnabled();
    AppMethodBeat.o(206089);
    return bool;
  }
  
  public final boolean isIndoorLevelPickerEnabled()
  {
    AppMethodBeat.i(206087);
    if (this.KJt == null)
    {
      AppMethodBeat.o(206087);
      return false;
    }
    boolean bool = this.KJt.isIndoorLevelPickerEnabled();
    AppMethodBeat.o(206087);
    return bool;
  }
  
  public final boolean isRotateGesturesEnabled()
  {
    AppMethodBeat.i(206084);
    if (this.KJt == null)
    {
      AppMethodBeat.o(206084);
      return false;
    }
    boolean bool = this.KJt.isRotateGesturesEnabled();
    AppMethodBeat.o(206084);
    return bool;
  }
  
  public final boolean isScaleControlsEnabled()
  {
    AppMethodBeat.i(206079);
    if (this.KJt != null)
    {
      boolean bool = this.KJt.isScaleViewEnabled();
      AppMethodBeat.o(206079);
      return bool;
    }
    AppMethodBeat.o(206079);
    return false;
  }
  
  public final boolean isTiltGesturesEnabled()
  {
    AppMethodBeat.i(206082);
    if (this.KJt == null)
    {
      AppMethodBeat.o(206082);
      return false;
    }
    boolean bool = this.KJt.isTiltGesturesEnabled();
    AppMethodBeat.o(206082);
    return bool;
  }
  
  public final void setAllGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206076);
    if (this.KJt != null) {
      this.KJt.setAllGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(206076);
  }
  
  public final void setAnimationEnabled(boolean paramBoolean) {}
  
  public final void setCompassEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206088);
    if (this.KJt == null)
    {
      AppMethodBeat.o(206088);
      return;
    }
    this.KJt.setCompassEnabled(paramBoolean);
    AppMethodBeat.o(206088);
  }
  
  public final void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206086);
    if (this.KJt != null) {
      this.KJt.setIndoorLevelPickerEnabled(paramBoolean);
    }
    AppMethodBeat.o(206086);
  }
  
  public final void setLogoPosition(int paramInt)
  {
    AppMethodBeat.i(206077);
    if (this.KJt != null) {
      this.KJt.setLogoPosition(paramInt);
    }
    AppMethodBeat.o(206077);
  }
  
  public final void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206085);
    if (this.KJt != null) {
      this.KJt.setLogoPosition(paramInt, paramArrayOfInt);
    }
    AppMethodBeat.o(206085);
  }
  
  public final void setLogoScale(float paramFloat)
  {
    AppMethodBeat.i(206083);
    if (this.KJt == null)
    {
      AppMethodBeat.o(206083);
      return;
    }
    this.KJt.setLogoScale(paramFloat);
    AppMethodBeat.o(206083);
  }
  
  public final void setRotateGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206081);
    if (this.KJt == null)
    {
      AppMethodBeat.o(206081);
      return;
    }
    this.KJt.setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(206081);
  }
  
  public final void setScaleControlsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206073);
    if (this.KJt != null) {
      this.KJt.setScaleViewEnabled(paramBoolean);
    }
    AppMethodBeat.o(206073);
  }
  
  public final void setScaleViewPosition(int paramInt)
  {
    AppMethodBeat.i(206078);
    if (this.KJt != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.KJt.setScaleViewPosition(paramInt);
      AppMethodBeat.o(206078);
      return;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206074);
    if (this.KJt != null) {
      this.KJt.setScrollGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(206074);
  }
  
  public final void setTiltGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206080);
    if (this.KJt == null)
    {
      AppMethodBeat.o(206080);
      return;
    }
    this.KJt.setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(206080);
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(206075);
    if (this.KJt != null) {
      this.KJt.setZoomGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(206075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */