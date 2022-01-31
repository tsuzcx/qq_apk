package com.tencent.filter.a;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.a;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.b;
import java.util.HashMap;
import java.util.Map;

public final class cq
  extends BaseFilter
{
  public cq()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86549);
    a locala = new a(GLSLRender.btg);
    Object localObject = new HashMap();
    ((Map)localObject).put("intensity", Float.valueOf(0.65F));
    locala.setParameterDic((Map)localObject);
    setNextFilter(locala, null);
    localObject = new ab();
    boolean bool = b.BzJ;
    b.BzJ = true;
    Bitmap localBitmap = b.wv("filter/egWeizhidao/eftMeiwei/meiwei_lf.png");
    b.BzJ = bool;
    ((BaseFilter)localObject).addParam(new m.k("inputImageTexture2", localBitmap, 33986, true));
    locala.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.a.cq
 * JD-Core Version:    0.7.0.1
 */