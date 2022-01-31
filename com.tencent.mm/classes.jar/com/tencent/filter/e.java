package com.tencent.filter;

public final class e
  extends BaseFilter
{
  float[] bcz = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  
  public e()
  {
    super(GLSLRender.bcL);
    addParam(new m.g("colorMat", this.bcz));
    addParam(new m.g("transMat", new float[] { 1.0F, 1.0F, 0.0F, 0.0F }));
  }
  
  public e(String paramString)
  {
    this();
    addParam(new m.o("inputImageTexture2", paramString, 33986));
  }
  
  public final void setMatrix(float[] paramArrayOfFloat)
  {
    addParam(new m.g("colorMat", paramArrayOfFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.filter.e
 * JD-Core Version:    0.7.0.1
 */