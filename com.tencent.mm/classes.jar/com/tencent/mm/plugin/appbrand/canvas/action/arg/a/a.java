package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.sdk.SynchronizedPool;
import java.util.HashMap;
import java.util.Map;

public abstract class a<T>
{
  private Map<String, SynchronizedPool> map = new HashMap();
  
  private SynchronizedPool WR(String paramString)
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
  
  public final <T extends BaseDrawActionArg> T WQ(String paramString)
  {
    BaseDrawActionArg localBaseDrawActionArg2 = (BaseDrawActionArg)WR(paramString).acquire();
    BaseDrawActionArg localBaseDrawActionArg1 = localBaseDrawActionArg2;
    if (localBaseDrawActionArg2 == null) {
      localBaseDrawActionArg1 = (BaseDrawActionArg)WS(paramString);
    }
    return localBaseDrawActionArg1;
  }
  
  public abstract <T> T WS(String paramString);
  
  public final void a(BaseDrawActionArg paramBaseDrawActionArg)
  {
    if (paramBaseDrawActionArg == null) {
      return;
    }
    if (TextUtils.isEmpty(paramBaseDrawActionArg.method)) {
      throw new IllegalStateException("method is empty " + paramBaseDrawActionArg.toString());
    }
    WR(paramBaseDrawActionArg.method).release(paramBaseDrawActionArg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.a.a
 * JD-Core Version:    0.7.0.1
 */