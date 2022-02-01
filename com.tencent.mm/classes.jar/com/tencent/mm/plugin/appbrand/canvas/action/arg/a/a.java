package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.sdk.SynchronizedPool;
import java.util.HashMap;
import java.util.Map;

public abstract class a<T>
{
  private Map<String, SynchronizedPool> map = new HashMap();
  
  private SynchronizedPool aeo(String paramString)
  {
    SynchronizedPool localSynchronizedPool2 = (SynchronizedPool)this.map.get(paramString);
    SynchronizedPool localSynchronizedPool1 = localSynchronizedPool2;
    if (localSynchronizedPool2 == null)
    {
      localSynchronizedPool1 = new SynchronizedPool(500);
      this.map.put(paramString, localSynchronizedPool1);
    }
    return localSynchronizedPool1;
  }
  
  public final void a(BaseDrawActionArg paramBaseDrawActionArg)
  {
    if (paramBaseDrawActionArg == null) {
      return;
    }
    if (TextUtils.isEmpty(paramBaseDrawActionArg.method)) {
      throw new IllegalStateException("method is empty " + paramBaseDrawActionArg.toString());
    }
    aeo(paramBaseDrawActionArg.method).release(paramBaseDrawActionArg);
  }
  
  public final <T extends BaseDrawActionArg> T aen(String paramString)
  {
    BaseDrawActionArg localBaseDrawActionArg2 = (BaseDrawActionArg)aeo(paramString).acquire();
    BaseDrawActionArg localBaseDrawActionArg1 = localBaseDrawActionArg2;
    if (localBaseDrawActionArg2 == null) {
      localBaseDrawActionArg1 = (BaseDrawActionArg)aep(paramString);
    }
    return localBaseDrawActionArg1;
  }
  
  public abstract <T> T aep(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.a
 * JD-Core Version:    0.7.0.1
 */