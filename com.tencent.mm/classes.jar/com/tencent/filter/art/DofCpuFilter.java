package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.filter.m.k;
import java.util.Map;

public class DofCpuFilter
  extends BaseFilter
{
  int aVo = 0;
  int bgA = 0;
  int bgB = 0;
  int bgC = 0;
  int bgD = 0;
  int bgE = 0;
  Bitmap bgi = null;
  int bgw = 0;
  int bgx = 0;
  int bgy = 0;
  int bgz = 0;
  int type = 0;
  
  public DofCpuFilter(int paramInt)
  {
    super(GLSLRender.bcE);
    this.type = paramInt;
  }
  
  private static Bitmap h(Bitmap paramBitmap)
  {
    QImage localQImage2 = QImage.BindBitmap(paramBitmap);
    QImage localQImage1 = nativeSacle(localQImage2, 2);
    nativeRoundBlurProcess(localQImage1, 4);
    localQImage2.UnBindBitmap(paramBitmap);
    paramBitmap = Bitmap.createBitmap(localQImage1.getWidth(), localQImage1.getHeight(), Bitmap.Config.ARGB_8888);
    localQImage1.ToBitmap(paramBitmap);
    localQImage1.Dispose();
    return paramBitmap;
  }
  
  public static native void nativeRoundBlurProcess(QImage paramQImage, int paramInt);
  
  public static native QImage nativeSacle(QImage paramQImage, int paramInt);
  
  public static native void nativeblurBorder(Bitmap paramBitmap, int paramInt);
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    float f1;
    float f5;
    float f6;
    float f2;
    Object localObject;
    if (this.type == 0)
    {
      this.glsl_programID = GLSLRender.bdE;
      if (this.bgi != null) {
        addParam(new m.k("inputImageTexture2", h(this.bgi), 33986, true));
      }
      if ((this.bgw != 0) || (this.bgy != 0) || (this.bgx != 0) || (this.bgz != 0))
      {
        f1 = this.bgz - this.bgx;
        f5 = this.bgx;
        f6 = f1 / 2.0F;
        float f7 = paramFloat2 / 2.0F;
        f2 = f1 / this.bgz;
        float f3 = (this.bgz - this.bgx) / paramFloat2;
        float f4 = (this.bgy - this.bgw) / paramFloat1;
        f5 = Math.abs(f5 + f6 - f7) / paramFloat2;
        f6 = Math.abs(paramFloat2 - this.bgz) / paramFloat2;
        this.bgA = this.bgz;
        this.bgC = 0;
        if ((f3 > 0.7F) && (f4 > 0.8F))
        {
          this.bgB = ((int)((1.0F - f2) * f1));
          this.bgD = ((int)(f1 * (1.0F - f2) + 50.0F));
        }
      }
      else
      {
        addParam(new m.f("py", this.bgA / paramFloat2));
        addParam(new m.f("up_innerradius", this.bgB / paramFloat2));
        addParam(new m.f("down_innerradius", this.bgC / paramFloat2));
        addParam(new m.f("up_outerradius", this.bgD / paramFloat2));
        addParam(new m.f("down_outerradius", this.bgE / paramFloat2));
        localObject = new BaseFilter(GLSLRender.bdq);
        if (this.bgi != null)
        {
          Bitmap localBitmap = this.bgi.copy(this.bgi.getConfig(), false);
          nativeblurBorder(localBitmap, 2);
          ((BaseFilter)localObject).addParam(new m.k("inputImageTexture3", localBitmap, 33987, true));
        }
        setNextFilter((BaseFilter)localObject, new int[] { this.srcTextureIndex });
      }
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.bgB = ((int)(f1 * 0.3F));
      this.bgD = ((int)(this.bgB + 0.5F * f1));
      f2 = this.bgD;
      f2 = this.bgB / f2;
      if (this.bgD > paramFloat2 * 0.6F)
      {
        this.bgD = ((int)(paramFloat2 * 0.6F));
        this.bgB = ((int)(f2 * (paramFloat2 * 0.6F)));
      }
      for (;;)
      {
        if (f5 < f6)
        {
          this.bgC = ((int)(0.1F * f1));
          this.bgE = ((int)(f1 * 0.5F + this.bgC));
          f1 = this.bgE;
          f1 = this.bgC / f1;
          if (this.bgE > paramFloat2 * 0.6F)
          {
            this.bgE = ((int)(paramFloat2 * 0.6F));
            this.bgC = ((int)(f1 * (paramFloat2 * 0.6F)));
            break;
            if (this.bgD >= paramFloat2 * 0.3F) {
              continue;
            }
            this.bgD = ((int)(paramFloat2 * 0.3F));
            this.bgB = ((int)(f2 * (paramFloat2 * 0.3F)));
            continue;
          }
          if (this.bgE >= paramFloat2 * 0.2F) {
            break;
          }
          this.bgE = ((int)(paramFloat2 * 0.2F));
          this.bgC = ((int)(f1 * (paramFloat2 * 0.2F)));
          break;
        }
      }
      this.bgC = 0;
      break;
      this.glsl_programID = GLSLRender.bdF;
      if (this.bgi != null)
      {
        localObject = this.bgi.copy(this.bgi.getConfig(), false);
        nativeblurBorder((Bitmap)localObject, 2);
        addParam(new m.k("inputImageTexture3", (Bitmap)localObject, 33987, true));
        addParam(new m.k("inputImageTexture2", h(this.bgi), 33986, true));
      }
    }
  }
  
  public void ClearGLSL()
  {
    this.bgi = null;
    super.ClearGLSL();
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("xmin")) {
      this.bgw = ((Integer)paramMap.get("xmin")).intValue();
    }
    if (paramMap.containsKey("ymin")) {
      this.bgx = ((Integer)paramMap.get("ymin")).intValue();
    }
    if (paramMap.containsKey("xmax")) {
      this.bgy = ((Integer)paramMap.get("xmax")).intValue();
    }
    if (paramMap.containsKey("ymax")) {
      this.bgz = ((Integer)paramMap.get("ymax")).intValue();
    }
    if (paramMap.containsKey("maskbmp")) {
      this.bgi = ((Bitmap)paramMap.get("maskbmp"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.art.DofCpuFilter
 * JD-Core Version:    0.7.0.1
 */