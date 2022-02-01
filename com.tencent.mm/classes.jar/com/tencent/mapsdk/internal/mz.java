package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlay;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class mz
  extends mm<nb>
  implements GradientVectorOverlay
{
  mz(na paramna, nb paramnb)
  {
    super(paramna, paramnb);
  }
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(221491);
    if (((nb)this.d).a != null) {
      ((nb)this.d).a.displayLevel(paramInt);
    }
    ((nb)this.d).setLevel(paramInt);
    a(this.d);
    AppMethodBeat.o(221491);
  }
  
  public void setOpacity(float paramFloat)
  {
    AppMethodBeat.i(221468);
    if (((nb)this.d).a != null) {
      ((nb)this.d).a.opacity(paramFloat);
    }
    ((nb)this.d).setOpacity(paramFloat);
    a(this.d);
    AppMethodBeat.o(221468);
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(221474);
    if (((nb)this.d).a != null) {
      ((nb)this.d).a.visibility(paramBoolean);
    }
    ((nb)this.d).setVisible(paramBoolean);
    a(this.d);
    AppMethodBeat.o(221474);
  }
  
  public void setZIndex(int paramInt)
  {
    AppMethodBeat.i(221483);
    if (((nb)this.d).a != null) {
      ((nb)this.d).a.zIndex(paramInt);
    }
    ((nb)this.d).setzIndex(paramInt);
    a(this.d);
    AppMethodBeat.o(221483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mz
 * JD-Core Version:    0.7.0.1
 */