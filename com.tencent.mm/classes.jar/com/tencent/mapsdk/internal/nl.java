package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.trails.TrailOverlay;
import com.tencent.map.sdk.utilities.visualization.trails.TrailOverlayProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class nl
  extends mm<nn>
  implements TrailOverlay
{
  nl(nm paramnm, nn paramnn)
  {
    super(paramnm, paramnn);
  }
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(221678);
    if (((nn)this.d).a != null) {
      ((nn)this.d).a.displayLevel(paramInt);
    }
    ((nn)this.d).setDisplayLevel(paramInt);
    a(this.d);
    AppMethodBeat.o(221678);
  }
  
  public void setOpacity(float paramFloat)
  {
    AppMethodBeat.i(221636);
    if (((nn)this.d).a != null) {
      ((nn)this.d).a.opacity(paramFloat);
    }
    ((nn)this.d).setOpacity(paramFloat);
    a(this.d);
    AppMethodBeat.o(221636);
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(221649);
    if (((nn)this.d).a != null) {
      ((nn)this.d).a.visibility(paramBoolean);
    }
    ((nn)this.d).setVisibility(paramBoolean);
    a(this.d);
    AppMethodBeat.o(221649);
  }
  
  public void setZIndex(int paramInt)
  {
    AppMethodBeat.i(221662);
    if (((nn)this.d).a != null) {
      ((nn)this.d).a.zIndex(paramInt);
    }
    ((nn)this.d).setzIndex(paramInt);
    a(this.d);
    AppMethodBeat.o(221662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.nl
 * JD-Core Version:    0.7.0.1
 */