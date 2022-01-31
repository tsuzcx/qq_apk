package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import java.util.Map;

public final class q
  extends BaseFilter
{
  private int bgZ = 1;
  private int quality = 2;
  
  public q()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    new StringBuilder("value = ").append(this.bgZ);
    this.glsl_programID = GLSLRender.bcE;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bez);
    setNextFilter(localBaseFilter, null);
    int i = this.bgZ;
    int j = this.quality;
    double d8 = 0.0D;
    double d6 = 0.0D;
    double d10 = 0.0D;
    double d11 = 0.0D;
    double d7 = 0.0D;
    double d12 = 0.0D;
    double d3 = 0.0D;
    if (i == 1)
    {
      d8 = 0.09D;
      d6 = 0.09D;
      d3 = 0.15D;
    }
    if (i == 3)
    {
      d7 = -0.06D;
      d3 = 0.07000000000000001D;
    }
    double d9 = d3;
    double d2 = d6;
    double d1 = d12;
    double d4 = d11;
    double d5 = d10;
    label207:
    Object localObject;
    float f;
    if (i == 4)
    {
      if (j == 1)
      {
        d2 = 0.455D;
        d5 = 0.17D;
        d4 = 0.177D;
        d1 = 0.2D;
        d9 = d3;
      }
    }
    else
    {
      d3 = d2;
      d10 = d1;
      d6 = d8;
      if (i == 2)
      {
        if (j != 1) {
          break label669;
        }
        d6 = 0.121D;
        d3 = 0.354D;
        d10 = d1;
      }
      d1 = d7;
      if (i == 5) {
        d1 = -0.08D;
      }
      if (i == 7)
      {
        d3 = 0.1D;
        d1 = -0.08D;
        d9 = 0.15D;
      }
      if (i == 6)
      {
        d1 = -0.12D;
        d9 = 0.16D;
      }
      localBaseFilter.addParam(new m.f("percent1", (float)d6));
      localBaseFilter.addParam(new m.f("percent2", (float)d3));
      localBaseFilter.addParam(new m.f("percent3", (float)d5));
      localBaseFilter.addParam(new m.f("percent4", (float)d4));
      localBaseFilter.addParam(new m.f("percent5", (float)d1));
      localBaseFilter.addParam(new m.f("percent6", (float)d10));
      localBaseFilter.addParam(new m.f("percent7", (float)d9));
      localObject = new q.b(this, this.bgZ, this.quality);
      localBaseFilter.setNextFilter((BaseFilter)localObject, null);
      if (this.bgZ == 5)
      {
        f = Math.min(paramFloat2, paramFloat1);
        localBaseFilter = new BaseFilter(GLSLRender.bcE);
        localBaseFilter.scaleFact = Math.min(400.0F / f, 1.0F);
        ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
        localObject = new q.a(this, this.quality, localBaseFilter.scaleFact);
        localBaseFilter.setNextFilter((BaseFilter)localObject, null);
        localBaseFilter = new BaseFilter(GLSLRender.bcH);
        f = 0.0F;
        switch (this.quality)
        {
        }
      }
    }
    for (;;)
    {
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, new int[] { this.srcTextureIndex + 3 });
      ((BaseFilter)localObject).addParam(new m.f("filterAdjustParam", 1.0F - f));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      if (j == 2)
      {
        d2 = 0.62D;
        d5 = 0.375D;
        d4 = 0.07000000000000001D;
        d1 = 0.125D;
        d9 = 0.26D;
        break;
      }
      d9 = d3;
      d2 = d6;
      d1 = d12;
      d4 = d11;
      d5 = d10;
      if (j != 3) {
        break;
      }
      d2 = 0.824D;
      d5 = 0.461D;
      d4 = 0.152D;
      d1 = 0.2D;
      d9 = d3;
      break;
      label669:
      if (j == 2)
      {
        d6 = 0.32D;
        d3 = 0.35D;
        d10 = -0.1D;
        break label207;
      }
      d3 = d2;
      d10 = d1;
      d6 = d8;
      if (j != 3) {
        break label207;
      }
      d6 = 0.366D;
      d3 = 0.5540000000000001D;
      d10 = d1;
      break label207;
      f = 0.89F;
      continue;
      f = 0.78F;
      continue;
      f = 0.573F;
    }
  }
  
  public final void setEffectIndex(int paramInt)
  {
    this.bgZ = paramInt;
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.bgZ = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    if (paramMap.containsKey("filter_type")) {
      this.bgZ = ((Integer)paramMap.get("filter_type")).intValue();
    }
    if (paramMap.containsKey("filter_quality")) {
      this.quality = ((Integer)paramMap.get("filter_quality")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.q
 * JD-Core Version:    0.7.0.1
 */