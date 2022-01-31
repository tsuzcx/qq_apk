package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bj
  extends BaseFilter
{
  public bj()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86517);
    Object localObject = new BaseFilter(GLSLRender.bvk);
    ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/nextdoor_center_curve.png", 33986));
    ((BaseFilter)localObject).addParam(new m.o("inputImageTexture3", "sh/nextdoor_center_curve_mask.png", 33987));
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.bvk);
    localBaseFilter.addParam(new m.o("inputImageTexture2", "sh/nextdoor_edge_curve.png", 33986));
    localBaseFilter.addParam(new m.o("inputImageTexture3", "sh/nextdoor_edge_curve_mask.png", 33987));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.bum);
    ((BaseFilter)localObject).addParam(new m.g("shadowsShift", new float[] { 0.0F, -0.05490196F, 0.1019608F }));
    ((BaseFilter)localObject).addParam(new m.g("midtonesShift", new float[] { 0.0F, -0.08627451F, 0.0F }));
    ((BaseFilter)localObject).addParam(new m.g("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    ((BaseFilter)localObject).addParam(new m.i("preserveLuminosity", 1));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.buo);
    localBaseFilter.addParam(new m.g("color2", new float[] { 0.9921569F, 0.8470588F, 0.6392157F, 1.0F }));
    localBaseFilter.addParam(new m.f("transparency", 0.3F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new k();
    ((k)localObject).a(1.0F, 20.0F, 0.0F, 335.0F, 352.0F, 16.0F, 28.0F);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.btt);
    localBaseFilter.addParam(new m.f("contrast", 1.1F));
    localBaseFilter.addParam(new m.f("saturation", 1.0F));
    localBaseFilter.addParam(new m.f("brightness", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.bj
 * JD-Core Version:    0.7.0.1
 */