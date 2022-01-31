package com.tencent.filter;

public class FilterWraper
  extends BaseFilter
{
  protected long aVf = 0L;
  private boolean aVg = false;
  protected String bcA = "";
  
  public FilterWraper(String paramString)
  {
    super(GLSLRender.bcE);
    this.bcA = paramString;
  }
  
  private static native void nativeDispose(long paramLong);
  
  private static native int nativeGetOutputText(long paramLong);
  
  private static native long nativeInitialWithString(String paramString);
  
  private static native void nativeRenderContext(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (this.aVg) {
      nativeDispose(this.aVf);
    }
    this.aVf = nativeInitialWithString(this.bcA);
    this.aVg = true;
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void ClearGLSL()
  {
    if (this.aVg)
    {
      nativeDispose(this.aVf);
      this.aVg = false;
    }
    super.ClearGLSL();
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.aVg) {
      nativeRenderContext(this.aVf, paramInt1, paramInt2, paramInt3);
    }
    super.beforeRender(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.aVg) {
      return super.renderTexture(nativeGetOutputText(this.aVf), paramInt2, paramInt3);
    }
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.FilterWraper
 * JD-Core Version:    0.7.0.1
 */