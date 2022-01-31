package com.tencent.filter;

import java.util.Map;

public final class j
  extends BaseFilter
{
  float bfC = 25.0F;
  float bfD = 0.3F;
  float bfE = 1.25F;
  float bfF = 0.001F;
  float bfG = 0.999F;
  private BaseFilter bfH = null;
  private j.a bfI = null;
  
  public j()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.bcE;
    float f = Math.min(paramFloat2, paramFloat1);
    this.scaleFact = Math.min(100.0F / f, 1.0F);
    Object localObject2 = new l(this.bfF, this.bfG);
    setNextFilter((BaseFilter)localObject2, new int[] { this.srcTextureIndex });
    Object localObject1 = new BaseFilter(GLSLRender.bdg);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bcE);
    ((BaseFilter)localObject2).scaleFact = Math.min(400.0F / f, 1.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    this.bfI = new j.a(((BaseFilter)localObject2).scaleFact);
    this.bfI.U(this.bfC);
    ((BaseFilter)localObject2).setNextFilter(this.bfI, new int[] { this.srcTextureIndex + 3 });
    localObject1 = this.bfI;
    this.bfH = new BaseFilter(GLSLRender.bfq, GLSLRender.bdl);
    this.bfH.addParam(new m.f("sharpness", this.bfD));
    ((BaseFilter)localObject1).setNextFilter(this.bfH, null);
    localObject2 = this.bfH;
    localObject1 = new BaseFilter(GLSLRender.bdh);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.bdj);
    ((BaseFilter)localObject2).addParam(new m.f("saturation", this.bfE));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final boolean isAdjustFilter()
  {
    return true;
  }
  
  public final void setAdjustParam(float paramFloat)
  {
    paramFloat = (float)Math.max((float)Math.min(paramFloat, 1.0D), 0.0D);
    this.bfC = (50.0F * paramFloat);
    this.bfD = (paramFloat * 0.6F);
    if (this.bfI != null) {
      this.bfI.U(this.bfC);
    }
    if (this.bfH != null) {
      this.bfH.addParam(new m.f("sharpness", this.bfD));
    }
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("stretechMag")) {
      this.bfC = ((Float)paramMap.get("stretechMag")).floatValue();
    }
    if (paramMap.containsKey("sharpnessMag")) {
      this.bfD = ((Float)paramMap.get("sharpnessMag")).floatValue();
    }
    if (paramMap.containsKey("saturationMag")) {
      this.bfE = ((Float)paramMap.get("saturationMag")).floatValue();
    }
    if (paramMap.containsKey("percent"))
    {
      this.bfF = ((Float)paramMap.get("percent")).floatValue();
      this.bfG = (1.0F - this.bfF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.j
 * JD-Core Version:    0.7.0.1
 */