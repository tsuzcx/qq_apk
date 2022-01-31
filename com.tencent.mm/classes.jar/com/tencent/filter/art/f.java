package com.tencent.filter.art;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import java.util.Map;

public final class f
  extends BaseFilter
{
  private float bgI = 1.0F;
  private int type = 0;
  
  public f()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    ClearGLSL();
    if (paramBoolean)
    {
      this.glsl_programID = GLSLRender.bcE;
      setNextFilter(null, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    this.glsl_programID = GLSLRender.bee;
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.bed);
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.bef);
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.bdY);
    localBaseFilter2.addParam(new m.f("threshold", 0.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.bej);
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    BaseFilter localBaseFilter3 = new BaseFilter(GLSLRender.bek);
    localBaseFilter3.addParam(new m.f("inv_2sigma2", 127.00195F));
    localBaseFilter3.addParam(new m.f("inv_sigma_root_2pi", 0.0008F));
    localBaseFilter3.addParam(new m.f("edge_factor", this.bgI));
    localBaseFilter1.setNextFilter(localBaseFilter3, new int[] { 2 });
    localBaseFilter2 = new BaseFilter(GLSLRender.bel);
    localBaseFilter2.addParam(new m.f("par", 0.35F));
    localBaseFilter2.addParam(new m.f("par_b", 0.2F));
    if (this.type == 0)
    {
      localBaseFilter2.addParam(new m.g("colorA", new float[] { 1.0F, 1.0F, 1.0F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorB", new float[] { 0.8666667F, 0.8470588F, 0.6666667F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorC", new float[] { 0.8705882F, 0.3098039F, 0.1647059F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorD", new float[] { 0.2039216F, 0.4078431F, 0.4078431F, 1.0F }));
    }
    if (this.type == 1)
    {
      localBaseFilter2.addParam(new m.g("colorA", new float[] { 0.8117647F, 0.9647059F, 0.9607843F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorB", new float[] { 0.8627451F, 0.882353F, 0.7921569F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorC", new float[] { 0.827451F, 0.690196F, 0.2352941F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorD", new float[] { 0.4470588F, 0.4078431F, 0.3176471F, 1.0F }));
    }
    if (this.type == 2)
    {
      localBaseFilter2.addParam(new m.g("colorA", new float[] { 0.7411765F, 0.8627451F, 0.827451F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorB", new float[] { 0.882353F, 0.682353F, 0.7333334F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorC", new float[] { 0.6313726F, 0.5215687F, 0.690196F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorD", new float[] { 0.3960784F, 0.3294118F, 0.4980392F, 1.0F }));
    }
    if (this.type == 3)
    {
      localBaseFilter2.addParam(new m.g("colorA", new float[] { 0.9882353F, 0.9960784F, 0.882353F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorB", new float[] { 0.9882353F, 0.9960784F, 0.882353F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorC", new float[] { 0.854902F, 0.7372549F, 0.4392157F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorD", new float[] { 0.654902F, 0.4588235F, 0.4784314F, 1.0F }));
    }
    if (this.type == 4)
    {
      localBaseFilter2.addParam(new m.g("colorA", new float[] { 1.0F, 0.9529412F, 0.7843137F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorB", new float[] { 1.0F, 0.9529412F, 0.7843137F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorC", new float[] { 0.8F, 0.8431373F, 0.5372549F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorD", new float[] { 0.0F, 0.3254902F, 0.3529412F, 1.0F }));
    }
    if (this.type == 5)
    {
      localBaseFilter2.addParam(new m.g("colorA", new float[] { 1.0F, 0.913726F, 0.6862745F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorB", new float[] { 1.0F, 0.913726F, 0.6862745F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorC", new float[] { 0.4352941F, 0.854902F, 0.8901961F, 1.0F }));
      localBaseFilter2.addParam(new m.g("colorD", new float[] { 0.9647059F, 0.3607843F, 0.5333334F, 1.0F }));
    }
    localBaseFilter3.setNextFilter(localBaseFilter2, new int[] { 4 });
    if (GLES20.glGetString(7937).indexOf("NVIDIA Tegra") != -1) {
      localBaseFilter1 = new BaseFilter(GLSLRender.ben);
    }
    for (;;)
    {
      localBaseFilter1.addParam(new m.f("inv_2sigma", 4.4F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
      break;
      localBaseFilter1 = new BaseFilter(GLSLRender.bem);
      localBaseFilter1.addParam(new m.i("radius", 2));
    }
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    if (paramMap.containsKey("detail")) {
      this.bgI = ((Float)paramMap.get("detail")).floatValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.art.f
 * JD-Core Version:    0.7.0.1
 */