package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.a;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class cp
  extends BaseFilter
{
  public cp()
  {
    super(GLSLRender.btg);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86548);
    a locala = new a(GLSLRender.btg);
    Object localObject = new HashMap();
    ((Map)localObject).put("intensity", Float.valueOf(0.65F));
    locala.setParameterDic((Map)localObject);
    setNextFilter(locala, null);
    localObject = new ab();
    ((BaseFilter)localObject).addParam(new m.o("inputImageTexture2", "sh/kongcheng_lf.png", 33986));
    locala.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.cp
 * JD-Core Version:    0.7.0.1
 */