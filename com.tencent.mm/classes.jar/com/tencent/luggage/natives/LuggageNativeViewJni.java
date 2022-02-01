package com.tencent.luggage.natives;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class LuggageNativeViewJni
{
  public long ceQ = -1L;
  
  static
  {
    AppMethodBeat.i(140472);
    System.loadLibrary("wechatlv");
    AppMethodBeat.o(140472);
  }
  
  private native long createNativeRender();
  
  private native void destroyNativeRender(long paramLong);
  
  private native long getPageViewPtr(long paramLong);
  
  private native void initJsBinding(long paramLong1, long paramLong2, long paramLong3);
  
  private native void onPageViewCreate(long paramLong, String paramString);
  
  private native void setDisplayParams(long paramLong, int paramInt1, int paramInt2, int paramInt3, float paramFloat);
  
  private native void showPageView(long paramLong);
  
  public final long CR()
  {
    AppMethodBeat.i(140469);
    long l = getPageViewPtr(this.ceQ);
    AppMethodBeat.o(140469);
    return l;
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(140471);
    setDisplayParams(this.ceQ, paramInt1, paramInt2, paramInt3, paramFloat);
    AppMethodBeat.o(140471);
  }
  
  public final void cp(String paramString)
  {
    AppMethodBeat.i(140470);
    onPageViewCreate(this.ceQ, paramString);
    AppMethodBeat.o(140470);
  }
  
  public final void init()
  {
    AppMethodBeat.i(140466);
    this.ceQ = createNativeRender();
    AppMethodBeat.o(140466);
  }
  
  public final void s(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(140468);
    if (this.ceQ <= 0L)
    {
      ad.e("LuggageNativeViewJni", "mRenderPtr <= 0");
      AppMethodBeat.o(140468);
      return;
    }
    initJsBinding(this.ceQ, paramLong1, paramLong2);
    AppMethodBeat.o(140468);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(140467);
    if (this.ceQ <= 0L)
    {
      AppMethodBeat.o(140467);
      return;
    }
    destroyNativeRender(this.ceQ);
    this.ceQ = -1L;
    AppMethodBeat.o(140467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.natives.LuggageNativeViewJni
 * JD-Core Version:    0.7.0.1
 */