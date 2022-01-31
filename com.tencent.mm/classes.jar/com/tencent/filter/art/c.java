package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class c
  extends BaseFilter
{
  int bwM;
  float bwN;
  float bwO;
  float bwP;
  int bwQ;
  float bwR;
  float bwS;
  float bwT;
  float bwU;
  float bwV;
  float bwW;
  float bwX;
  int radius;
  float tx;
  float ty;
  int type;
  
  public c()
  {
    super(GLSLRender.btg);
    AppMethodBeat.i(86293);
    this.bwM = 1;
    this.bwV = 0.5F;
    this.bwN = 0.5F;
    this.bwW = 1.2F;
    this.radius = 8;
    this.bwO = ((float)(1.0D / Math.exp(0.0D)));
    this.bwP = 0.0F;
    this.bwX = 960.0F;
    this.bwQ = 1;
    AppMethodBeat.o(86293);
  }
  
  private void V(float paramFloat)
  {
    this.bwN = (1.0F - paramFloat);
    this.radius = 5;
    if ((this.bwN < 0.8D) && (this.bwN > 0.4F)) {
      this.radius = 8;
    }
    for (;;)
    {
      if (this.bwQ == 2) {
        this.bwN = (1.0F - 0.6F * paramFloat);
      }
      if (paramFloat >= 0.3D) {
        break;
      }
      this.bwW = (3.0F * paramFloat);
      return;
      if (this.bwN <= 0.4F)
      {
        this.bwN = 0.4F;
        this.radius = ((int)(8.0F + 6.0F * paramFloat));
      }
    }
    this.bwW = ((paramFloat - 0.3F) * 1.3F + 0.9F);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86295);
    if (IsFilterInvalute())
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86295);
      return;
    }
    this.glsl_programID = GLSLRender.btg;
    Object localObject;
    BaseFilter localBaseFilter;
    int i;
    float f2;
    float f1;
    if (this.type != 0)
    {
      if (this.bwM == 0) {
        break label378;
      }
      this.scaleFact = (Math.min(this.bwX / Math.max(paramFloat1, paramFloat2), 1.0F) * this.bwN);
      localObject = new BokehFilter.a(this.radius, this.bwO, this.bwP, this.bwM, this.bwQ);
      ((BaseFilter)localObject).addParam(new m.f("lumi_p", this.radius * 1.0F));
      ((BaseFilter)localObject).setScaleFact(this.scaleFact);
      setNextFilter((BaseFilter)localObject, null);
      localBaseFilter = new BaseFilter(GLSLRender.btg);
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
      i = GLSLRender.btP;
      f2 = this.bwT;
      f1 = this.bwU;
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
      ((BaseFilter)localObject).addParam(new m.f("innerRadius", this.bwR / paramFloat1));
      ((BaseFilter)localObject).addParam(new m.f("outerRadius", this.bwS / paramFloat1));
      ((BaseFilter)localObject).addParam(new m.f("theta", f2));
      ((BaseFilter)localObject).addParam(new m.f("eclipseA", f1));
      localBaseFilter.setNextFilter((BaseFilter)localObject, new int[] { 0 });
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86295);
      return;
      label378:
      localBaseFilter = new BaseFilter(GLSLRender.btR);
      localBaseFilter.addParam(new m.f("depthr", this.bwW));
      setNextFilter(localBaseFilter, null);
      break;
      i = GLSLRender.btP;
      continue;
      i = GLSLRender.btQ;
      continue;
      f2 = 0.0F;
      i = GLSLRender.btP;
      f1 = 1.0F;
    }
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86294);
    if (paramMap.containsKey("bokehmode")) {
      this.bwQ = ((Integer)paramMap.get("bokehmode")).intValue();
    }
    if (paramMap.containsKey("inputradius")) {
      V(((Float)paramMap.get("input_radius")).floatValue());
    }
    if (paramMap.containsKey("blurRiness"))
    {
      this.bwV = ((Float)paramMap.get("blurRiness")).floatValue();
      V(this.bwV);
    }
    if (paramMap.containsKey("MethodType")) {
      this.type = ((Integer)paramMap.get("MethodType")).intValue();
    }
    if (paramMap.containsKey("bokehType")) {
      this.bwM = (((Integer)paramMap.get("bokehType")).intValue() % 6);
    }
    if (paramMap.containsKey("tx")) {
      this.tx = ((Float)paramMap.get("tx")).floatValue();
    }
    if (paramMap.containsKey("ty")) {
      this.ty = ((Float)paramMap.get("ty")).floatValue();
    }
    if (paramMap.containsKey("innerRadius")) {
      this.bwR = ((Float)paramMap.get("innerRadius")).floatValue();
    }
    if (paramMap.containsKey("outerRadius")) {
      this.bwS = ((Float)paramMap.get("outerRadius")).floatValue();
    }
    if (paramMap.containsKey("theta")) {
      this.bwT = ((Float)paramMap.get("theta")).floatValue();
    }
    if (paramMap.containsKey("eclipseA")) {
      this.bwU = ((Float)paramMap.get("eclipseA")).floatValue();
    }
    if (paramMap.containsKey("defaultWidth")) {
      this.bwX = ((Float)paramMap.get("defaultWidth")).floatValue();
    }
    if (paramMap.containsKey("lumi_threshold")) {
      this.bwP = ((Float)paramMap.get("lumi_threshold")).floatValue();
    }
    if (paramMap.containsKey("lumi_weight")) {
      this.bwO = ((float)(1.0D / Math.exp(((Float)paramMap.get("lumi_weight")).floatValue())));
    }
    AppMethodBeat.o(86294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.art.c
 * JD-Core Version:    0.7.0.1
 */