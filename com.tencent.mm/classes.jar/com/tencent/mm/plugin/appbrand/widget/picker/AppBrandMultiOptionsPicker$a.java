package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandMultiOptionsPicker$a
{
  public final String[] jsq;
  public final int selected;
  
  public AppBrandMultiOptionsPicker$a(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(126703);
    this.jsq = paramArrayOfString;
    this.selected = Math.max(0, Math.min(paramInt, paramArrayOfString.length - 1));
    AppMethodBeat.o(126703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a
 * JD-Core Version:    0.7.0.1
 */