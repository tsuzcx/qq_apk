package com.tencent.filter;

import java.util.Map;

public final class b
  extends BaseFilter
{
  private final int[] bcv = { 0, 1, 3, 4, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 28, 29, 31, 33, 34, 36, 38, 39, 41, 42, 44, 46, 47, 49, 51, 52, 54, 55, 57, 59, 60, 62, 64, 65, 67, 68, 70, 71, 73, 75, 76, 78, 79, 81, 82, 84, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 107, 108, 110, 111, 113, 114, 116, 117, 119, 120, 121, 123, 124, 126, 127, 128, 130, 131, 133, 134, 135, 137, 138, 139, 141, 142, 143, 145, 146, 147, 149, 150, 151, 152, 154, 155, 156, 157, 159, 160, 161, 162, 164, 165, 166, 167, 168, 169, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 186, 187, 188, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 200, 201, 202, 203, 204, 205, 205, 206, 207, 208, 208, 209, 210, 211, 211, 212, 213, 214, 214, 215, 216, 216, 217, 218, 218, 219, 219, 220, 221, 221, 222, 223, 223, 224, 224, 225, 225, 226, 226, 227, 228, 228, 229, 229, 230, 230, 231, 231, 232, 232, 233, 233, 234, 234, 234, 235, 235, 236, 236, 237, 237, 237, 238, 238, 239, 239, 240, 240, 240, 241, 241, 241, 242, 242, 243, 243, 243, 244, 244, 244, 245, 245, 245, 246, 246, 246, 247, 247, 247, 248, 248, 248, 249, 249, 249, 250, 250, 250, 251, 251, 251, 252, 252, 252, 253, 253, 253, 254, 254, 254, 255 };
  int bcw = 0;
  int bcx = 1;
  private final int[] curve_static = { 0, 1, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 47, 49, 50, 52, 53, 55, 56, 58, 59, 61, 62, 63, 65, 66, 68, 69, 71, 72, 73, 75, 76, 78, 79, 80, 82, 83, 85, 86, 87, 89, 90, 92, 93, 94, 96, 97, 98, 100, 101, 102, 104, 105, 106, 108, 109, 110, 112, 113, 114, 116, 117, 118, 119, 121, 122, 123, 125, 126, 127, 128, 130, 131, 132, 133, 134, 136, 137, 138, 139, 140, 142, 143, 144, 145, 146, 147, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 181, 182, 183, 184, 185, 186, 187, 188, 188, 189, 190, 191, 192, 193, 193, 194, 195, 196, 197, 197, 198, 199, 200, 201, 201, 202, 203, 204, 204, 205, 206, 207, 207, 208, 209, 209, 210, 211, 211, 212, 213, 213, 214, 215, 215, 216, 217, 217, 218, 219, 219, 220, 221, 221, 222, 222, 223, 224, 224, 225, 226, 226, 227, 227, 228, 228, 229, 230, 230, 231, 231, 232, 232, 233, 234, 234, 235, 235, 236, 236, 237, 237, 238, 238, 239, 240, 240, 241, 241, 242, 242, 243, 243, 244, 244, 245, 245, 246, 246, 247, 247, 248, 248, 249, 249, 250, 250, 251, 251, 252, 252, 253, 253, 254, 254, 255 };
  
  public b(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.bcx = paramInt2;
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (IsFilterInvalute())
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    this.glsl_programID = GLSLRender.bcE;
    Object localObject;
    BaseFilter localBaseFilter;
    if (this.bcx == 1)
    {
      localObject = new BaseFilter(GLSLRender.bcT);
      ((BaseFilter)localObject).addParam(new m.f("radius", 2.0F));
      setNextFilter((BaseFilter)localObject, null);
      localBaseFilter = new BaseFilter(GLSLRender.bcU);
      localBaseFilter.addParam(new m.f("radius", 2.0F));
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
      localObject = new BaseFilter(GLSLRender.bcV);
      ((BaseFilter)localObject).addParam(new m.m("inputImageTexture2", this.curve_static, 33986));
      localBaseFilter.setNextFilter((BaseFilter)localObject, null);
      ((BaseFilter)localObject).setNextFilter(new BaseFilter(GLSLRender.bcW), new int[] { this.srcTextureIndex + 1 });
    }
    for (;;)
    {
      switch (this.bcw)
      {
      default: 
        localBaseFilter = null;
        ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
        localObject = localBaseFilter;
        if (this.bcw != 1)
        {
          localObject = localBaseFilter;
          if (this.bcw != 8)
          {
            localObject = localBaseFilter;
            if (this.bcw > 0)
            {
              localObject = new BaseFilter(GLSLRender.bcX);
              ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "glowcenter.jpg", 33986));
              localBaseFilter.setNextFilter((BaseFilter)localObject, null);
            }
          }
        }
        if (this.bcw == 9)
        {
          localBaseFilter = new BaseFilter(GLSLRender.bcI);
          localBaseFilter.addParam(new m.f("filterAdjustParam", 0.6400001F));
          ((BaseFilter)localObject).setNextFilter(localBaseFilter, new int[] { this.srcTextureIndex + 1 });
        }
        break;
      }
      for (;;)
      {
        super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
        return;
        localBaseFilter = new BaseFilter(GLSLRender.bcY);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bcZ);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bda);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bdv);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bdb);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bdc);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "portraitbeauty.png", 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bdd);
        localBaseFilter.addParam(new m.m("inputImageTexture2", this.bcv, 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bde);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "fennen.png", 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bcQ);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "gradient.jpg", 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bdt);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "yangguang.png", 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bdu);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "hongrun.png", 33986));
        break;
        localBaseFilter = new BaseFilter(GLSLRender.bds);
        localBaseFilter.addParam(new m.o("inputImageTexture2", "tianmei.png", 33986));
        break;
        if (this.bcw == 1002)
        {
          localBaseFilter = new BaseFilter(GLSLRender.bcI);
          localBaseFilter.addParam(new m.f("filterAdjustParam", 0.56F));
          ((BaseFilter)localObject).setNextFilter(localBaseFilter, new int[] { this.srcTextureIndex + 1 });
        }
      }
      localObject = this;
    }
  }
  
  public final void setEffectIndex(int paramInt)
  {
    this.bcw = paramInt;
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.bcw = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.b
 * JD-Core Version:    0.7.0.1
 */