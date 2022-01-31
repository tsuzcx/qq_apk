package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;
import java.util.Map;

public final class j
  extends BaseFilter
{
  float bwf = 25.0F;
  float bwg = 0.3F;
  float bwh = 1.25F;
  float bwi = 0.001F;
  float bwj = 0.999F;
  private BaseFilter bwk = null;
  private a bwl = null;
  
  public j()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86379);
    this.glsl_programID = GLSLRender.btg;
    float f = Math.min(paramFloat2, paramFloat1);
    this.scaleFact = Math.min(100.0F / f, 1.0F);
    Object localObject2 = new l(this.bwi, this.bwj);
    setNextFilter((BaseFilter)localObject2, new int[] { this.srcTextureIndex });
    Object localObject1 = new BaseFilter(GLSLRender.btI);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.btg);
    ((BaseFilter)localObject2).scaleFact = Math.min(400.0F / f, 1.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    this.bwl = new a(((BaseFilter)localObject2).scaleFact);
    this.bwl.U(this.bwf);
    ((BaseFilter)localObject2).setNextFilter(this.bwl, new int[] { this.srcTextureIndex + 3 });
    localObject1 = this.bwl;
    this.bwk = new BaseFilter(GLSLRender.bvT, GLSLRender.btN);
    this.bwk.addParam(new m.f("sharpness", this.bwg));
    ((BaseFilter)localObject1).setNextFilter(this.bwk, null);
    localObject2 = this.bwk;
    localObject1 = new BaseFilter(GLSLRender.btJ);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.btL);
    ((BaseFilter)localObject2).addParam(new m.f("saturation", this.bwh));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86379);
  }
  
  public final boolean isAdjustFilter()
  {
    return true;
  }
  
  public final void setAdjustParam(float paramFloat)
  {
    AppMethodBeat.i(86377);
    paramFloat = Math.max((float)Math.min(paramFloat, 1.0D), 0.0F);
    this.bwf = (50.0F * paramFloat);
    this.bwg = (paramFloat * 0.6F);
    if (this.bwl != null) {
      this.bwl.U(this.bwf);
    }
    if (this.bwk != null) {
      this.bwk.addParam(new m.f("sharpness", this.bwg));
    }
    AppMethodBeat.o(86377);
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86378);
    if (paramMap.containsKey("stretechMag")) {
      this.bwf = ((Float)paramMap.get("stretechMag")).floatValue();
    }
    if (paramMap.containsKey("sharpnessMag")) {
      this.bwg = ((Float)paramMap.get("sharpnessMag")).floatValue();
    }
    if (paramMap.containsKey("saturationMag")) {
      this.bwh = ((Float)paramMap.get("saturationMag")).floatValue();
    }
    if (paramMap.containsKey("percent"))
    {
      this.bwi = ((Float)paramMap.get("percent")).floatValue();
      this.bwj = (1.0F - this.bwi);
    }
    AppMethodBeat.o(86378);
  }
  
  public static final class a
    extends BaseFilter
  {
    float bwf = 25.0F;
    float bwm = 1.0F;
    int paramTEXTRUEID = 0;
    
    public a(float paramFloat)
    {
      super();
      this.bwm = paramFloat;
    }
    
    public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(86373);
      this.paramTEXTRUEID = g.dXe();
      addParam(new m.f("strength", this.bwf));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86373);
    }
    
    public final void ClearGLSL()
    {
      AppMethodBeat.i(86376);
      g.Tn(this.paramTEXTRUEID);
      super.ClearGLSL();
      AppMethodBeat.o(86376);
    }
    
    public final void U(float paramFloat)
    {
      AppMethodBeat.i(86372);
      this.bwf = paramFloat;
      addParam(new m.f("strength", this.bwf));
      AppMethodBeat.o(86372);
    }
    
    public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(86374);
      QImage localQImage1 = g.aK(paramInt1, paramInt2, paramInt3);
      QImage localQImage2 = localQImage1.InplaceBlur8bitQImage(1, (int)(80.0F * this.bwm));
      localQImage1.Dispose();
      GLSLRender.nativeTextImage(localQImage2, this.paramTEXTRUEID);
      localQImage2.Dispose();
      AppMethodBeat.o(86374);
    }
    
    public final boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(86375);
      setTextureParam(this.paramTEXTRUEID, 1);
      boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(86375);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.j
 * JD-Core Version:    0.7.0.1
 */