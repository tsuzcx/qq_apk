package com.tencent.filter.a;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.a;
import com.tencent.filter.m.k;
import com.tencent.view.b;
import java.util.HashMap;
import java.util.Map;

public final class ce
  extends BaseFilter
{
  public ce()
  {
    super(GLSLRender.bcE);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    a locala = new a(GLSLRender.bcE);
    Object localObject = new HashMap();
    ((Map)localObject).put("intensity", Float.valueOf(0.65F));
    locala.setParameterDic((Map)localObject);
    setNextFilter(locala, null);
    localObject = new x();
    boolean bool = b.xdb;
    b.xdb = true;
    Bitmap localBitmap = b.pe("filter/egWeizhidao/eftMeiwei/meiwei_lf.png");
    b.xdb = bool;
    ((BaseFilter)localObject).addParam(new m.k("inputImageTexture2", localBitmap, 33986, true));
    locala.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.a.ce
 * JD-Core Version:    0.7.0.1
 */