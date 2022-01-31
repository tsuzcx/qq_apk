package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.sdk.b;
import java.util.HashMap;
import java.util.Map;

public abstract class a<T>
{
  private Map<String, b> map = new HashMap();
  
  private b rL(String paramString)
  {
    b localb2 = (b)this.map.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b(500);
      this.map.put(paramString, localb1);
    }
    return localb1;
  }
  
  public final void a(BaseDrawActionArg paramBaseDrawActionArg)
  {
    if (paramBaseDrawActionArg == null) {
      return;
    }
    if (TextUtils.isEmpty(paramBaseDrawActionArg.method)) {
      throw new IllegalStateException("method is empty " + paramBaseDrawActionArg.toString());
    }
    rL(paramBaseDrawActionArg.method).D(paramBaseDrawActionArg);
  }
  
  public final <T extends BaseDrawActionArg> T rK(String paramString)
  {
    BaseDrawActionArg localBaseDrawActionArg2 = (BaseDrawActionArg)rL(paramString).de();
    BaseDrawActionArg localBaseDrawActionArg1 = localBaseDrawActionArg2;
    if (localBaseDrawActionArg2 == null) {
      localBaseDrawActionArg1 = (BaseDrawActionArg)rM(paramString);
    }
    return localBaseDrawActionArg1;
  }
  
  public abstract <T> T rM(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.a
 * JD-Core Version:    0.7.0.1
 */