package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.sdk.c;
import java.util.HashMap;
import java.util.Map;

public abstract class a<T>
{
  private Map<String, c> map = new HashMap();
  
  private c Nv(String paramString)
  {
    c localc2 = (c)this.map.get(paramString);
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c(500);
      this.map.put(paramString, localc1);
    }
    return localc1;
  }
  
  public final <T extends BaseDrawActionArg> T Nu(String paramString)
  {
    BaseDrawActionArg localBaseDrawActionArg2 = (BaseDrawActionArg)Nv(paramString).acquire();
    BaseDrawActionArg localBaseDrawActionArg1 = localBaseDrawActionArg2;
    if (localBaseDrawActionArg2 == null) {
      localBaseDrawActionArg1 = (BaseDrawActionArg)Nw(paramString);
    }
    return localBaseDrawActionArg1;
  }
  
  public abstract <T> T Nw(String paramString);
  
  public final void a(BaseDrawActionArg paramBaseDrawActionArg)
  {
    if (paramBaseDrawActionArg == null) {
      return;
    }
    if (TextUtils.isEmpty(paramBaseDrawActionArg.method)) {
      throw new IllegalStateException("method is empty " + paramBaseDrawActionArg.toString());
    }
    Nv(paramBaseDrawActionArg.method).release(paramBaseDrawActionArg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.a
 * JD-Core Version:    0.7.0.1
 */