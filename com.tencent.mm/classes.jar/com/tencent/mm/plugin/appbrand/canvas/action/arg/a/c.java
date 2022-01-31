package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.d;
import java.util.Map;

public final class c
  extends a<BaseDrawActionArg>
{
  private static com.tencent.mm.plugin.appbrand.canvas.c fMi = new com.tencent.mm.plugin.appbrand.canvas.c();
  private static c fMj = new c();
  
  public static c adI()
  {
    return fMj;
  }
  
  public final <T> T rM(String paramString)
  {
    paramString = (d)fMi.fLo.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.adE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c
 * JD-Core Version:    0.7.0.1
 */