package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FilterWraper
  extends BaseFilter
{
  protected long blO = 0L;
  private boolean blP = false;
  protected String btc = "";
  
  public FilterWraper(String paramString)
  {
    super(GLSLRender.btg);
    this.btc = paramString;
  }
  
  private static native void nativeDispose(long paramLong);
  
  private static native int nativeGetOutputText(long paramLong);
  
  private static native long nativeInitialWithString(String paramString);
  
  private static native void nativeRenderContext(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86358);
    if (this.blP) {
      nativeDispose(this.blO);
    }
    this.blO = nativeInitialWithString(this.btc);
    this.blP = true;
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86358);
  }
  
  public void ClearGLSL()
  {
    AppMethodBeat.i(86361);
    if (this.blP)
    {
      nativeDispose(this.blO);
      this.blP = false;
    }
    super.ClearGLSL();
    AppMethodBeat.o(86361);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86359);
    if (this.blP) {
      nativeRenderContext(this.blO, paramInt1, paramInt2, paramInt3);
    }
    super.beforeRender(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(86359);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86360);
    if (this.blP)
    {
      bool = super.renderTexture(nativeGetOutputText(this.blO), paramInt2, paramInt3);
      AppMethodBeat.o(86360);
      return bool;
    }
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(86360);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.FilterWraper
 * JD-Core Version:    0.7.0.1
 */