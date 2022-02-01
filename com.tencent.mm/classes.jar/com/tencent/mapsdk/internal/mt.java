package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlay;
import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class mt
  extends mm<mv>
  implements ArcLineOverlay
{
  mt(mu parammu, mv parammv)
  {
    super(parammu, parammv);
  }
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(222927);
    if (((mv)this.d).a != null) {
      ((mv)this.d).a.displayLevel(paramInt);
    }
    ((mv)this.d).setDisplayLevel(paramInt);
    a(this.d);
    AppMethodBeat.o(222927);
  }
  
  public void setOpacity(float paramFloat)
  {
    AppMethodBeat.i(222899);
    if (((mv)this.d).a != null) {
      ((mv)this.d).a.opacity(paramFloat);
    }
    ((mv)this.d).setOpacity(paramFloat);
    a(this.d);
    AppMethodBeat.o(222899);
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(222913);
    if (((mv)this.d).a != null) {
      ((mv)this.d).a.visibility(paramBoolean);
    }
    ((mv)this.d).setVisibility(paramBoolean);
    a(this.d);
    AppMethodBeat.o(222913);
  }
  
  public void setZIndex(int paramInt)
  {
    AppMethodBeat.i(222919);
    if (((mv)this.d).a != null) {
      ((mv)this.d).a.zIndex(paramInt);
    }
    ((mv)this.d).setzIndex(paramInt);
    a(this.d);
    AppMethodBeat.o(222919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mt
 * JD-Core Version:    0.7.0.1
 */