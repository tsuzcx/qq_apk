package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends BaseFilter
{
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public final void setAdjustParam(float paramFloat)
  {
    AppMethodBeat.i(86280);
    addParam(new m.f("filterAdjustParam", paramFloat));
    AppMethodBeat.o(86280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.a
 * JD-Core Version:    0.7.0.1
 */