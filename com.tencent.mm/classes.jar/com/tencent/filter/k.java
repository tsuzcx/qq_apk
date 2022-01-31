package com.tencent.filter;

public final class k
  extends BaseFilter
{
  float bfK = 0.5F;
  float bfL = 0.5F;
  float bfM = 0.5F;
  float bfN = -1.0F;
  float bfO = -1.0F;
  float bfP = -1.0F;
  float bfQ = -1.0F;
  int bfR = -1;
  
  public k()
  {
    super(GLSLRender.bfh);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    switch (this.bfR)
    {
    default: 
      this.glsl_programID = GLSLRender.bfh;
    }
    for (;;)
    {
      addParam(new m.f("fh", this.bfK));
      addParam(new m.f("fs", this.bfL));
      addParam(new m.f("fv", this.bfM));
      addParam(new m.f("flb", this.bfN));
      addParam(new m.f("fld", this.bfO));
      addParam(new m.f("frd", this.bfP));
      addParam(new m.f("frb", this.bfQ));
      addParam(new m.i("channelflag", this.bfR));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.glsl_programID = GLSLRender.bfd;
      continue;
      this.glsl_programID = GLSLRender.bfe;
      continue;
      this.glsl_programID = GLSLRender.bff;
      continue;
      this.glsl_programID = GLSLRender.bfg;
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.bfN = (paramFloat4 / 360.0F);
    this.bfO = (paramFloat5 / 360.0F);
    this.bfP = (paramFloat6 / 360.0F);
    this.bfQ = (paramFloat7 / 360.0F);
    this.bfK = (paramFloat1 / 180.0F * 0.5F);
    this.bfL = (paramFloat2 / 100.0F);
    this.bfM = (paramFloat3 / 100.0F);
    double d1 = paramFloat4;
    double d2 = paramFloat5;
    double d3 = paramFloat6;
    double d4 = paramFloat7;
    int i;
    if ((d1 < d2) && (d2 < d3) && (d3 < d4)) {
      i = 0;
    }
    for (;;)
    {
      this.bfR = i;
      addParam(new m.f("fh", this.bfK));
      addParam(new m.f("fs", this.bfL));
      addParam(new m.f("fv", this.bfM));
      addParam(new m.f("flb", this.bfN));
      addParam(new m.f("fld", this.bfO));
      addParam(new m.f("frd", this.bfP));
      addParam(new m.f("frb", this.bfQ));
      addParam(new m.i("channelflag", this.bfR));
      this.glsl_programID = GLSLRender.bfh;
      return;
      if ((d1 < d2) && (d3 < d4) && (d1 > d4)) {
        i = 1;
      } else if ((d1 > d4) && (d2 < d3) && (d3 < d4)) {
        i = 2;
      } else if ((d1 < d2) && (d2 < d3) && (d1 > d4) && ((d1 != 303.0D) || (d2 != 323.0D))) {
        i = 3;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.k
 * JD-Core Version:    0.7.0.1
 */