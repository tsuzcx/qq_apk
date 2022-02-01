package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "", "()V", "inst", "", "instToRelease", "draw", "", "init", "initView", "nativeInit", "nativeRelease", "preRelease", "setColor", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setupGlslFiles", "vertexShader", "", "fragmentShader", "vertexFrameBuffer", "fragFrameBuffer", "textureVertexShader", "textureFragmentShader", "bgVertexShader", "bgFragmentShader", "surfaceChanged", "width", "height", "surfaceCreated", "Companion", "dynamicbg_release"}, k=1, mv={1, 1, 11})
public final class DynamicBackgroundNative
{
  public static final DynamicBackgroundNative.a mbo;
  public long mbm;
  public long mbn;
  
  static
  {
    AppMethodBeat.i(233217);
    mbo = new DynamicBackgroundNative.a((byte)0);
    AppMethodBeat.o(233217);
  }
  
  public DynamicBackgroundNative()
  {
    AppMethodBeat.i(103077);
    this.mbm = -1L;
    this.mbn = -1L;
    Object localObject = d.mbs;
    localObject = d.aTA();
    if (localObject != null)
    {
      ((c)localObject).aTq();
      AppMethodBeat.o(103077);
      return;
    }
    AppMethodBeat.o(103077);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(233222);
    s.t(paramString1, "vertexShader");
    s.t(paramString2, "fragmentShader");
    s.t(paramString3, "vertexFrameBuffer");
    s.t(paramString4, "fragFrameBuffer");
    s.t(paramString5, "textureVertexShader");
    s.t(paramString6, "textureFragmentShader");
    s.t(paramString7, "bgVertexShader");
    s.t(paramString8, "bgFragmentShader");
    if (this.mbm > 0L) {
      try
      {
        setupGlslFiles(this.mbm, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
        paramString1 = ah.aiuX;
        return;
      }
      finally
      {
        AppMethodBeat.o(233222);
      }
    }
    AppMethodBeat.o(233222);
  }
  
  public final void dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233220);
    if (this.mbm > 0L) {
      surfaceCreated(this.mbm, paramInt1, paramInt2);
    }
    AppMethodBeat.o(233220);
  }
  
  public final native void draw(long paramLong);
  
  public final void initView()
  {
    AppMethodBeat.i(233224);
    if (this.mbm > 0L) {
      initView(this.mbm);
    }
    AppMethodBeat.o(233224);
  }
  
  public final native void initView(long paramLong);
  
  public final void j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(233225);
    if (this.mbm > 0L) {
      setColor(this.mbm, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(233225);
  }
  
  public final native long nativeInit();
  
  public final void nativeRelease()
  {
    AppMethodBeat.i(233219);
    if (this.mbn > 0L)
    {
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBackgroundNative", "destroy DynamicBackgroundNative toRelease: " + this.mbn + " inst: " + this.mbm, new Object[0]);
      nativeRelease(this.mbn);
      this.mbn = -1L;
    }
    AppMethodBeat.o(233219);
  }
  
  public final native void nativeRelease(long paramLong);
  
  public final native void setColor(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public final native void setupGlslFiles(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
  
  public final native void surfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  public final native void surfaceCreated(long paramLong, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative
 * JD-Core Version:    0.7.0.1
 */