package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.scatterplot.BitmapScatterPlotOverlay;
import com.tencent.map.sdk.utilities.visualization.scatterplot.DotScatterPlotOverlay;
import com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlay;
import com.tencent.map.sdk.utilities.visualization.scatterplot.ScatterPlotOverlayProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ni
  extends mm<nk>
  implements BitmapScatterPlotOverlay, DotScatterPlotOverlay, ScatterPlotOverlay
{
  ni(mn parammn, nk paramnk)
  {
    super(parammn, paramnk);
  }
  
  public void setActiveDataIndex(int paramInt)
  {
    AppMethodBeat.i(221676);
    ((nk)this.d).setActiveIndex(paramInt);
    a(this.d);
    AppMethodBeat.o(221676);
  }
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(221668);
    if (((nk)this.d).a != null) {
      ((nk)this.d).a.displayLevel(paramInt);
    }
    ((nk)this.d).setLevel(paramInt);
    a(this.d);
    AppMethodBeat.o(221668);
  }
  
  public void setOpacity(float paramFloat)
  {
    AppMethodBeat.i(221642);
    if (((nk)this.d).a != null) {
      ((nk)this.d).a.opacity(paramFloat);
    }
    ((nk)this.d).setOpacity(paramFloat);
    a(this.d);
    AppMethodBeat.o(221642);
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(221647);
    if (((nk)this.d).a != null) {
      ((nk)this.d).a.visibility(paramBoolean);
    }
    ((nk)this.d).setVisible(paramBoolean);
    a(this.d);
    AppMethodBeat.o(221647);
  }
  
  public void setZIndex(int paramInt)
  {
    AppMethodBeat.i(221656);
    if (((nk)this.d).a != null) {
      ((nk)this.d).a.zIndex(paramInt);
    }
    ((nk)this.d).setzIndex(paramInt);
    a(this.d);
    AppMethodBeat.o(221656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ni
 * JD-Core Version:    0.7.0.1
 */