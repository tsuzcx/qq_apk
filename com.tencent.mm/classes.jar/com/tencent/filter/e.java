package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends BaseFilter
{
  float[] btb;
  
  public e()
  {
    super(GLSLRender.btn);
    AppMethodBeat.i(86353);
    this.btb = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    addParam(new m.g("colorMat", this.btb));
    addParam(new m.g("transMat", new float[] { 1.0F, 1.0F, 0.0F, 0.0F }));
    AppMethodBeat.o(86353);
  }
  
  public e(String paramString)
  {
    this();
    AppMethodBeat.i(86354);
    addParam(new m.o("inputImageTexture2", paramString, 33986));
    AppMethodBeat.o(86354);
  }
  
  public final void setMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(86355);
    addParam(new m.g("colorMat", paramArrayOfFloat));
    AppMethodBeat.o(86355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.e
 * JD-Core Version:    0.7.0.1
 */