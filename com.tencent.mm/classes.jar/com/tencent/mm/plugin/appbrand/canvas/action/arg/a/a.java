package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.sdk.d;
import java.util.HashMap;
import java.util.Map;

public abstract class a<T>
{
  private Map<String, d> map = new HashMap();
  
  private d zB(String paramString)
  {
    d locald2 = (d)this.map.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d(500);
      this.map.put(paramString, locald1);
    }
    return locald1;
  }
  
  public final void a(BaseDrawActionArg paramBaseDrawActionArg)
  {
    if (paramBaseDrawActionArg == null) {
      return;
    }
    if (TextUtils.isEmpty(paramBaseDrawActionArg.method)) {
      throw new IllegalStateException("method is empty " + paramBaseDrawActionArg.toString());
    }
    zB(paramBaseDrawActionArg.method).release(paramBaseDrawActionArg);
  }
  
  public final <T extends BaseDrawActionArg> T zA(String paramString)
  {
    BaseDrawActionArg localBaseDrawActionArg2 = (BaseDrawActionArg)zB(paramString).acquire();
    BaseDrawActionArg localBaseDrawActionArg1 = localBaseDrawActionArg2;
    if (localBaseDrawActionArg2 == null) {
      localBaseDrawActionArg1 = (BaseDrawActionArg)zC(paramString);
    }
    return localBaseDrawActionArg1;
  }
  
  public abstract <T> T zC(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.a
 * JD-Core Version:    0.7.0.1
 */