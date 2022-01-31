package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionNormalArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionRadialArg;

public final class g
  extends a<BaseDrawActionArg>
{
  private static g fMp = new g();
  
  public static g adM()
  {
    return fMp;
  }
  
  public final <T> T rM(String paramString)
  {
    Object localObject = null;
    if ("linear".equalsIgnoreCase(paramString)) {
      localObject = new RealSetFillStyleActionLinearArg();
    }
    for (;;)
    {
      ((BaseDrawActionArg)localObject).method = paramString;
      return localObject;
      if ("radial".equalsIgnoreCase(paramString)) {
        localObject = new RealSetFillStyleActionRadialArg();
      } else if ("normal".equalsIgnoreCase(paramString)) {
        localObject = new RealSetFillStyleActionNormalArg();
      } else if ("pattern".equalsIgnoreCase(paramString)) {
        localObject = new RealSetFillStyleActionPatternArg();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.g
 * JD-Core Version:    0.7.0.1
 */