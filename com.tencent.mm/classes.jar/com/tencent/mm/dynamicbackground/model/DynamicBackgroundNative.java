package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 11}, hxE={""}, hxF={"Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "", "()V", "draw", "", "initView", "nativeInit", "nativeRelease", "setColor", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setupGlslFiles", "vertexShader", "", "fragmentShader", "vertexFrameBuffer", "fragFrameBuffer", "textureVertexShader", "textureFragmentShader", "bgVertexShader", "bgFragmentShader", "surfaceChanged", "width", "height", "surfaceCreated", "dynamicbg_release"})
public final class DynamicBackgroundNative
{
  public DynamicBackgroundNative()
  {
    AppMethodBeat.i(103077);
    Object localObject = d.gRj;
    localObject = d.atN();
    if (localObject != null)
    {
      ((c)localObject).atD();
      AppMethodBeat.o(103077);
      return;
    }
    AppMethodBeat.o(103077);
  }
  
  public final native void draw();
  
  public final native void initView();
  
  public final native void nativeInit();
  
  public final native void nativeRelease();
  
  public final native void setColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public final native void setupGlslFiles(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
  
  public final native void surfaceChanged(int paramInt1, int paramInt2);
  
  public final native void surfaceCreated(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative
 * JD-Core Version:    0.7.0.1
 */