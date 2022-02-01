package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 11}, iBL={""}, iBM={"Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "", "()V", "inst", "", "instToRelease", "draw", "", "init", "initView", "nativeInit", "nativeRelease", "preRelease", "setColor", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setupGlslFiles", "vertexShader", "", "fragmentShader", "vertexFrameBuffer", "fragFrameBuffer", "textureVertexShader", "textureFragmentShader", "bgVertexShader", "bgFragmentShader", "surfaceChanged", "width", "height", "surfaceCreated", "Companion", "dynamicbg_release"})
public final class DynamicBackgroundNative
{
  public static final DynamicBackgroundNative.a jBB;
  public long jBA;
  public long jBz;
  
  static
  {
    AppMethodBeat.i(214010);
    jBB = new DynamicBackgroundNative.a((byte)0);
    AppMethodBeat.o(214010);
  }
  
  public DynamicBackgroundNative()
  {
    AppMethodBeat.i(103077);
    this.jBz = -1L;
    this.jBA = -1L;
    Object localObject = d.jBF;
    localObject = d.aAF();
    if (localObject != null)
    {
      ((c)localObject).aAv();
      AppMethodBeat.o(103077);
      return;
    }
    AppMethodBeat.o(103077);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(214001);
    p.k(paramString1, "vertexShader");
    p.k(paramString2, "fragmentShader");
    p.k(paramString3, "vertexFrameBuffer");
    p.k(paramString4, "fragFrameBuffer");
    p.k(paramString5, "textureVertexShader");
    p.k(paramString6, "textureFragmentShader");
    p.k(paramString7, "bgVertexShader");
    p.k(paramString8, "bgFragmentShader");
    if (this.jBz > 0L) {
      try
      {
        setupGlslFiles(this.jBz, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
        paramString1 = x.aazN;
        return;
      }
      finally
      {
        AppMethodBeat.o(214001);
      }
    }
    AppMethodBeat.o(214001);
  }
  
  public final void cQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214000);
    if (this.jBz > 0L) {
      surfaceCreated(this.jBz, paramInt1, paramInt2);
    }
    AppMethodBeat.o(214000);
  }
  
  public final native void draw(long paramLong);
  
  public final void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(214003);
    if (this.jBz > 0L) {
      setColor(this.jBz, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(214003);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(214002);
    if (this.jBz > 0L) {
      initView(this.jBz);
    }
    AppMethodBeat.o(214002);
  }
  
  public final native void initView(long paramLong);
  
  public final native long nativeInit();
  
  public final void nativeRelease()
  {
    AppMethodBeat.i(213999);
    if (this.jBA > 0L)
    {
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBackgroundNative", "destroy DynamicBackgroundNative toRelease: " + this.jBA + " inst: " + this.jBz, new Object[0]);
      nativeRelease(this.jBA);
      this.jBA = -1L;
    }
    AppMethodBeat.o(213999);
  }
  
  public final native void nativeRelease(long paramLong);
  
  public final native void setColor(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public final native void setupGlslFiles(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
  
  public final native void surfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  public final native void surfaceCreated(long paramLong, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative
 * JD-Core Version:    0.7.0.1
 */