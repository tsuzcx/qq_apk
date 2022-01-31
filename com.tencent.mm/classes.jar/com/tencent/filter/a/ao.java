package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
  extends BaseFilter
{
  public float p = 1.0F;
  
  public ao()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86496);
    int i = getTheFilterIndex(this);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.btg);
    localBaseFilter.scaleFact = Math.min(100.0F / Math.min(paramFloat2, paramFloat1), 1.0F);
    setNextFilter(localBaseFilter, null);
    localBaseFilter.setNextFilter(new al(this.p), new int[] { i + (this.srcTextureIndex + 1) });
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.ao
 * JD-Core Version:    0.7.0.1
 */