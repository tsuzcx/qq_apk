package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import java.util.Map;

public final class c
  extends BaseFilter
{
  int bgk = 1;
  float bgl = 0.5F;
  float bgm = (float)(1.0D / Math.exp(0.0D));
  float bgn = 0.0F;
  int bgo = 1;
  float bgp;
  float bgq;
  float bgr;
  float bgs;
  float bgt = 0.5F;
  float bgu = 1.2F;
  float bgv = 960.0F;
  int radius = 8;
  float tx;
  float ty;
  int type;
  
  public c()
  {
    super(GLSLRender.bcE);
  }
  
  private void V(float paramFloat)
  {
    this.bgl = (1.0F - paramFloat);
    this.radius = 5;
    if ((this.bgl < 0.8D) && (this.bgl > 0.4F)) {
      this.radius = 8;
    }
    for (;;)
    {
      if (this.bgo == 2) {
        this.bgl = (1.0F - 0.6F * paramFloat);
      }
      if (paramFloat >= 0.3D) {
        break;
      }
      this.bgu = (3.0F * paramFloat);
      return;
      if (this.bgl <= 0.4F)
      {
        this.bgl = 0.4F;
        this.radius = ((int)(8.0F + 6.0F * paramFloat));
      }
    }
    this.bgu = ((paramFloat - 0.3F) * 1.3F + 0.9F);
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
    int i;
    float f2;
    float f1;
    if (this.type != 0)
    {
      if (this.bgk == 0) {
        break label361;
      }
      this.scaleFact = (Math.min(this.bgv / Math.max(paramFloat1, paramFloat2), 1.0F) * this.bgl);
      localObject = new BokehFilter.a(this.radius, this.bgm, this.bgn, this.bgk, this.bgo);
      ((BaseFilter)localObject).addParam(new m.f("lumi_p", this.radius * 1.0F));
      ((BaseFilter)localObject).setScaleFact(this.scaleFact);
      setNextFilter((BaseFilter)localObject, null);
      localBaseFilter = new BaseFilter(GLSLRender.bcE);
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
      i = GLSLRender.bdn;
      f2 = this.bgr;
      f1 = this.bgs;
      switch (this.type)
      {
      }
    }
    for (;;)
    {
      localObject = new BaseFilter(i);
      ((BaseFilter)localObject).addParam(new m.f("ratio", paramFloat2 / paramFloat1));
      ((BaseFilter)localObject).addParam(new m.f("tx", this.tx / paramFloat1));
      ((BaseFilter)localObject).addParam(new m.f("ty", this.ty / paramFloat2));
      ((BaseFilter)localObject).addParam(new m.f("innerRadius", this.bgp / paramFloat1));
      ((BaseFilter)localObject).addParam(new m.f("outerRadius", this.bgq / paramFloat1));
      ((BaseFilter)localObject).addParam(new m.f("theta", f2));
      ((BaseFilter)localObject).addParam(new m.f("eclipseA", f1));
      localBaseFilter.setNextFilter((BaseFilter)localObject, new int[] { 0 });
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      label361:
      localBaseFilter = new BaseFilter(GLSLRender.bdp);
      localBaseFilter.addParam(new m.f("depthr", this.bgu));
      setNextFilter(localBaseFilter, null);
      break;
      i = GLSLRender.bdn;
      continue;
      i = GLSLRender.bdo;
      continue;
      f2 = 0.0F;
      i = GLSLRender.bdn;
      f1 = 1.0F;
    }
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("bokehmode")) {
      this.bgo = ((Integer)paramMap.get("bokehmode")).intValue();
    }
    if (paramMap.containsKey("inputradius")) {
      V(((Float)paramMap.get("input_radius")).floatValue());
    }
    if (paramMap.containsKey("blurRiness"))
    {
      this.bgt = ((Float)paramMap.get("blurRiness")).floatValue();
      V(this.bgt);
    }
    if (paramMap.containsKey("MethodType")) {
      this.type = ((Integer)paramMap.get("MethodType")).intValue();
    }
    if (paramMap.containsKey("bokehType")) {
      this.bgk = (((Integer)paramMap.get("bokehType")).intValue() % 6);
    }
    if (paramMap.containsKey("tx")) {
      this.tx = ((Float)paramMap.get("tx")).floatValue();
    }
    if (paramMap.containsKey("ty")) {
      this.ty = ((Float)paramMap.get("ty")).floatValue();
    }
    if (paramMap.containsKey("innerRadius")) {
      this.bgp = ((Float)paramMap.get("innerRadius")).floatValue();
    }
    if (paramMap.containsKey("outerRadius")) {
      this.bgq = ((Float)paramMap.get("outerRadius")).floatValue();
    }
    if (paramMap.containsKey("theta")) {
      this.bgr = ((Float)paramMap.get("theta")).floatValue();
    }
    if (paramMap.containsKey("eclipseA")) {
      this.bgs = ((Float)paramMap.get("eclipseA")).floatValue();
    }
    if (paramMap.containsKey("defaultWidth")) {
      this.bgv = ((Float)paramMap.get("defaultWidth")).floatValue();
    }
    if (paramMap.containsKey("lumi_threshold")) {
      this.bgn = ((Float)paramMap.get("lumi_threshold")).floatValue();
    }
    if (paramMap.containsKey("lumi_weight")) {
      this.bgm = ((float)(1.0D / Math.exp(((Float)paramMap.get("lumi_weight")).floatValue())));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.art.c
 * JD-Core Version:    0.7.0.1
 */