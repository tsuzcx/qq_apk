package com.j.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements com.tencent.tencentmap.mapsdk.map.UiSettings
{
  private com.tencent.tencentmap.mapsdk.maps.UiSettings aisc;
  
  public m(com.tencent.tencentmap.mapsdk.maps.UiSettings paramUiSettings)
  {
    this.aisc = paramUiSettings;
  }
  
  public final boolean isAnimationEnabled()
  {
    return false;
  }
  
  public final boolean isCompassEnabled()
  {
    AppMethodBeat.i(207223);
    if (this.aisc == null)
    {
      AppMethodBeat.o(207223);
      return false;
    }
    boolean bool = this.aisc.isCompassEnabled();
    AppMethodBeat.o(207223);
    return bool;
  }
  
  public final boolean isIndoorLevelPickerEnabled()
  {
    AppMethodBeat.i(207204);
    if (this.aisc == null)
    {
      AppMethodBeat.o(207204);
      return false;
    }
    boolean bool = this.aisc.isIndoorLevelPickerEnabled();
    AppMethodBeat.o(207204);
    return bool;
  }
  
  public final boolean isRotateGesturesEnabled()
  {
    AppMethodBeat.i(207175);
    if (this.aisc == null)
    {
      AppMethodBeat.o(207175);
      return false;
    }
    boolean bool = this.aisc.isRotateGesturesEnabled();
    AppMethodBeat.o(207175);
    return bool;
  }
  
  public final boolean isScaleControlsEnabled()
  {
    AppMethodBeat.i(207120);
    if (this.aisc != null)
    {
      boolean bool = this.aisc.isScaleViewEnabled();
      AppMethodBeat.o(207120);
      return bool;
    }
    AppMethodBeat.o(207120);
    return false;
  }
  
  public final boolean isTiltGesturesEnabled()
  {
    AppMethodBeat.i(207150);
    if (this.aisc == null)
    {
      AppMethodBeat.o(207150);
      return false;
    }
    boolean bool = this.aisc.isTiltGesturesEnabled();
    AppMethodBeat.o(207150);
    return bool;
  }
  
  public final void setAllGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207081);
    if (this.aisc != null) {
      this.aisc.setAllGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(207081);
  }
  
  public final void setAnimationEnabled(boolean paramBoolean) {}
  
  public final void setCompassEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207216);
    if (this.aisc == null)
    {
      AppMethodBeat.o(207216);
      return;
    }
    this.aisc.setCompassEnabled(paramBoolean);
    AppMethodBeat.o(207216);
  }
  
  public final void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207199);
    if (this.aisc != null) {
      this.aisc.setIndoorLevelPickerEnabled(paramBoolean);
    }
    AppMethodBeat.o(207199);
  }
  
  public final void setLogoPosition(int paramInt)
  {
    AppMethodBeat.i(207091);
    if (this.aisc != null) {
      this.aisc.setLogoPosition(paramInt);
    }
    AppMethodBeat.o(207091);
  }
  
  public final void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(207187);
    if (this.aisc != null) {
      this.aisc.setLogoPosition(paramInt, paramArrayOfInt);
    }
    AppMethodBeat.o(207187);
  }
  
  public final void setLogoScale(float paramFloat)
  {
    AppMethodBeat.i(207165);
    if (this.aisc == null)
    {
      AppMethodBeat.o(207165);
      return;
    }
    this.aisc.setLogoScale(paramFloat);
    AppMethodBeat.o(207165);
  }
  
  public final void setRotateGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207139);
    if (this.aisc == null)
    {
      AppMethodBeat.o(207139);
      return;
    }
    this.aisc.setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(207139);
  }
  
  public final void setScaleControlsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207051);
    if (this.aisc != null) {
      this.aisc.setScaleViewEnabled(paramBoolean);
    }
    AppMethodBeat.o(207051);
  }
  
  public final void setScaleViewPosition(int paramInt)
  {
    AppMethodBeat.i(207109);
    if (this.aisc != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.aisc.setScaleViewPosition(paramInt);
      AppMethodBeat.o(207109);
      return;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
  }
  
  public final void setScrollGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207064);
    if (this.aisc != null) {
      this.aisc.setScrollGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(207064);
  }
  
  public final void setTiltGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207129);
    if (this.aisc == null)
    {
      AppMethodBeat.o(207129);
      return;
    }
    this.aisc.setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(207129);
  }
  
  public final void setZoomGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(207072);
    if (this.aisc != null) {
      this.aisc.setZoomGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(207072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */