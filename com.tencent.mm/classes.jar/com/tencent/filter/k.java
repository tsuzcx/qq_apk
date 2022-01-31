package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends BaseFilter
{
  float bwn = 0.5F;
  float bwo = 0.5F;
  float bwp = 0.5F;
  float bwq = -1.0F;
  float bwr = -1.0F;
  float bws = -1.0F;
  float bwt = -1.0F;
  int bwu = -1;
  
  public k()
  {
    super(GLSLRender.bvK);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86384);
    switch (this.bwu)
    {
    default: 
      this.glsl_programID = GLSLRender.bvK;
    }
    for (;;)
    {
      addParam(new m.f("fh", this.bwn));
      addParam(new m.f("fs", this.bwo));
      addParam(new m.f("fv", this.bwp));
      addParam(new m.f("flb", this.bwq));
      addParam(new m.f("fld", this.bwr));
      addParam(new m.f("frd", this.bws));
      addParam(new m.f("frb", this.bwt));
      addParam(new m.i("channelflag", this.bwu));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86384);
      return;
      this.glsl_programID = GLSLRender.bvG;
      continue;
      this.glsl_programID = GLSLRender.bvH;
      continue;
      this.glsl_programID = GLSLRender.bvI;
      continue;
      this.glsl_programID = GLSLRender.bvJ;
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    AppMethodBeat.i(86383);
    this.bwq = (paramFloat4 / 360.0F);
    this.bwr = (paramFloat5 / 360.0F);
    this.bws = (paramFloat6 / 360.0F);
    this.bwt = (paramFloat7 / 360.0F);
    this.bwn = (paramFloat1 / 180.0F * 0.5F);
    this.bwo = (paramFloat2 / 100.0F);
    this.bwp = (paramFloat3 / 100.0F);
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
      this.bwu = i;
      addParam(new m.f("fh", this.bwn));
      addParam(new m.f("fs", this.bwo));
      addParam(new m.f("fv", this.bwp));
      addParam(new m.f("flb", this.bwq));
      addParam(new m.f("fld", this.bwr));
      addParam(new m.f("frd", this.bws));
      addParam(new m.f("frb", this.bwt));
      addParam(new m.i("channelflag", this.bwu));
      this.glsl_programID = GLSLRender.bvK;
      AppMethodBeat.o(86383);
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