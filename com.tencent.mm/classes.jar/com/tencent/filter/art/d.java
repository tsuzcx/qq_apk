package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.filter.m.o;
import java.util.Map;

public final class d
  extends BaseFilter
{
  Bitmap bgF = null;
  int type = 0;
  
  public d()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    float f1 = 852.0F;
    float f2 = 640.0F;
    this.glsl_programID = GLSLRender.bcE;
    BaseFilter localBaseFilter3 = new BaseFilter(GLSLRender.bfx, GLSLRender.bep);
    setNextFilter(localBaseFilter3, null);
    BaseFilter localBaseFilter2;
    BaseFilter localBaseFilter1;
    label224:
    float f3;
    float f4;
    if (this.bgF == null)
    {
      localBaseFilter2 = new BaseFilter(GLSLRender.bfy, GLSLRender.beu);
      localBaseFilter3.setNextFilter(localBaseFilter2, null);
      if (GLES20.glGetString(7937).indexOf("PowerVR SGX 540") != -1)
      {
        localBaseFilter1 = new BaseFilter(GLSLRender.bew);
        localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 2 });
        localBaseFilter2 = new BaseFilter(GLSLRender.bfz, GLSLRender.ber);
        localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { this.srcTextureIndex + 3 });
        localBaseFilter1 = new BaseFilter(GLSLRender.bes);
        localBaseFilter1.addParam(new m.o("inputImageTexture2", "manga/manga.png", 33986));
        localBaseFilter1.addParam(new m.f("height_scale", paramFloat2 / 64.0F));
        localBaseFilter1.addParam(new m.f("width_scale", paramFloat1 / 64.0F));
        localBaseFilter2.setNextFilter(localBaseFilter1, null);
        localBaseFilter2 = new BaseFilter(GLSLRender.bet);
        localBaseFilter2.addParam(new m.f("rx", 1.0F));
        localBaseFilter2.addParam(new m.f("ry", 1.0F));
        localBaseFilter2.addParam(new m.f("tx", 0.0F));
        localBaseFilter2.addParam(new m.f("ty", 0.0F));
        localBaseFilter2.addParam(new m.i("flag", this.type));
        if ((paramFloat1 <= 640.0F) || (paramFloat2 <= 852.0F)) {
          break label552;
        }
        f3 = paramFloat1 / 640.0F;
        f4 = paramFloat2 / 852.0F;
        if (f3 >= f4) {
          break label543;
        }
        f1 = paramFloat2 / f3;
      }
    }
    for (;;)
    {
      localBaseFilter2.addParam(new m.f("w", f2));
      localBaseFilter2.addParam(new m.f("h", f1));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      localBaseFilter1 = new BaseFilter(GLSLRender.beq);
      break;
      localBaseFilter1 = new BaseFilter(GLSLRender.bev);
      localBaseFilter1.addParam(new m.o("inputImageTexture3", "manga/manga.png", 33987));
      localBaseFilter1.addParam(new m.k("inputImageTexture2", this.bgF, 33986, false));
      localBaseFilter1.addParam(new m.f("par", 0.45F));
      localBaseFilter1.addParam(new m.f("height_scale", paramFloat2 / 64.0F));
      localBaseFilter1.addParam(new m.f("width_scale", paramFloat1 / 64.0F));
      localBaseFilter3.setNextFilter(localBaseFilter1, null);
      break label224;
      label543:
      f2 = paramFloat1 / f4;
      continue;
      label552:
      f3 = 640.0F / paramFloat1;
      f4 = 852.0F / paramFloat2;
      if (f3 < f4) {
        f2 = paramFloat1 * f4;
      } else {
        f1 = paramFloat2 * f3;
      }
    }
  }
  
  public final void ClearGLSL()
  {
    if (this.bgF != null)
    {
      this.bgF.recycle();
      this.bgF = null;
    }
    super.ClearGLSL();
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("graybitmap")) {
      this.bgF = ((Bitmap)paramMap.get("graybitmap"));
    }
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.art.d
 * JD-Core Version:    0.7.0.1
 */