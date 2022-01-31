package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class DofCpuFilter
  extends BaseFilter
{
  Bitmap bwK = null;
  int bwY = 0;
  int bwZ = 0;
  int bxa = 0;
  int bxb = 0;
  int bxc = 0;
  int bxd = 0;
  int bxe = 0;
  int bxf = 0;
  int bxg = 0;
  int paramTEXTRUEID = 0;
  int type = 0;
  
  public DofCpuFilter(int paramInt)
  {
    super(GLSLRender.btg);
    this.type = paramInt;
  }
  
  private static Bitmap i(Bitmap paramBitmap)
  {
    AppMethodBeat.i(86299);
    QImage localQImage2 = QImage.BindBitmap(paramBitmap);
    QImage localQImage1 = nativeSacle(localQImage2, 2);
    nativeRoundBlurProcess(localQImage1, 4);
    localQImage2.UnBindBitmap(paramBitmap);
    paramBitmap = Bitmap.createBitmap(localQImage1.getWidth(), localQImage1.getHeight(), Bitmap.Config.ARGB_8888);
    localQImage1.ToBitmap(paramBitmap);
    localQImage1.Dispose();
    AppMethodBeat.o(86299);
    return paramBitmap;
  }
  
  public static native void nativeRoundBlurProcess(QImage paramQImage, int paramInt);
  
  public static native QImage nativeSacle(QImage paramQImage, int paramInt);
  
  public static native void nativeblurBorder(Bitmap paramBitmap, int paramInt);
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86297);
    float f1;
    float f5;
    float f6;
    float f2;
    Object localObject;
    if (this.type == 0)
    {
      this.glsl_programID = GLSLRender.buh;
      if (this.bwK != null) {
        addParam(new m.k("inputImageTexture2", i(this.bwK), 33986, true));
      }
      if ((this.bwY != 0) || (this.bxa != 0) || (this.bwZ != 0) || (this.bxb != 0))
      {
        f1 = this.bxb - this.bwZ;
        f5 = this.bwZ;
        f6 = f1 / 2.0F;
        float f7 = paramFloat2 / 2.0F;
        f2 = f1 / this.bxb;
        float f3 = (this.bxb - this.bwZ) / paramFloat2;
        float f4 = (this.bxa - this.bwY) / paramFloat1;
        f5 = Math.abs(f5 + f6 - f7) / paramFloat2;
        f6 = Math.abs(paramFloat2 - this.bxb) / paramFloat2;
        this.bxc = this.bxb;
        this.bxe = 0;
        if ((f3 > 0.7F) && (f4 > 0.8F))
        {
          this.bxd = ((int)((1.0F - f2) * f1));
          this.bxf = ((int)(f1 * (1.0F - f2) + 50.0F));
        }
      }
      else
      {
        addParam(new m.f("py", this.bxc / paramFloat2));
        addParam(new m.f("up_innerradius", this.bxd / paramFloat2));
        addParam(new m.f("down_innerradius", this.bxe / paramFloat2));
        addParam(new m.f("up_outerradius", this.bxf / paramFloat2));
        addParam(new m.f("down_outerradius", this.bxg / paramFloat2));
        localObject = new BaseFilter(GLSLRender.btS);
        if (this.bwK != null)
        {
          Bitmap localBitmap = this.bwK.copy(this.bwK.getConfig(), false);
          nativeblurBorder(localBitmap, 2);
          ((BaseFilter)localObject).addParam(new m.k("inputImageTexture3", localBitmap, 33987, true));
        }
        setNextFilter((BaseFilter)localObject, new int[] { this.srcTextureIndex });
      }
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86297);
      return;
      this.bxd = ((int)(f1 * 0.3F));
      this.bxf = ((int)(this.bxd + 0.5F * f1));
      f2 = this.bxf;
      f2 = this.bxd / f2;
      if (this.bxf > paramFloat2 * 0.6F)
      {
        this.bxf = ((int)(paramFloat2 * 0.6F));
        this.bxd = ((int)(f2 * (paramFloat2 * 0.6F)));
      }
      for (;;)
      {
        if (f5 < f6)
        {
          this.bxe = ((int)(0.1F * f1));
          this.bxg = ((int)(f1 * 0.5F + this.bxe));
          f1 = this.bxg;
          f1 = this.bxe / f1;
          if (this.bxg > paramFloat2 * 0.6F)
          {
            this.bxg = ((int)(paramFloat2 * 0.6F));
            this.bxe = ((int)(f1 * (paramFloat2 * 0.6F)));
            break;
            if (this.bxf >= paramFloat2 * 0.3F) {
              continue;
            }
            this.bxf = ((int)(paramFloat2 * 0.3F));
            this.bxd = ((int)(f2 * (paramFloat2 * 0.3F)));
            continue;
          }
          if (this.bxg >= paramFloat2 * 0.2F) {
            break;
          }
          this.bxg = ((int)(paramFloat2 * 0.2F));
          this.bxe = ((int)(f1 * (paramFloat2 * 0.2F)));
          break;
        }
      }
      this.bxe = 0;
      break;
      this.glsl_programID = GLSLRender.bui;
      if (this.bwK != null)
      {
        localObject = this.bwK.copy(this.bwK.getConfig(), false);
        nativeblurBorder((Bitmap)localObject, 2);
        addParam(new m.k("inputImageTexture3", (Bitmap)localObject, 33987, true));
        addParam(new m.k("inputImageTexture2", i(this.bwK), 33986, true));
      }
    }
  }
  
  public void ClearGLSL()
  {
    AppMethodBeat.i(86298);
    this.bwK = null;
    super.ClearGLSL();
    AppMethodBeat.o(86298);
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86296);
    if (paramMap.containsKey("xmin")) {
      this.bwY = ((Integer)paramMap.get("xmin")).intValue();
    }
    if (paramMap.containsKey("ymin")) {
      this.bwZ = ((Integer)paramMap.get("ymin")).intValue();
    }
    if (paramMap.containsKey("xmax")) {
      this.bxa = ((Integer)paramMap.get("xmax")).intValue();
    }
    if (paramMap.containsKey("ymax")) {
      this.bxb = ((Integer)paramMap.get("ymax")).intValue();
    }
    if (paramMap.containsKey("maskbmp")) {
      this.bwK = ((Bitmap)paramMap.get("maskbmp"));
    }
    AppMethodBeat.o(86296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.art.DofCpuFilter
 * JD-Core Version:    0.7.0.1
 */