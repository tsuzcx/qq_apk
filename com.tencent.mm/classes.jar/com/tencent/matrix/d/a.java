package com.tencent.matrix.d;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.e.b;
import com.tencent.matrix.g.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
  extends b
{
  public final com.tencent.matrix.d.a.a cEk;
  private com.tencent.matrix.d.b.a cEl;
  
  public a(com.tencent.matrix.d.a.a parama)
  {
    this.cEk = parama;
  }
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final JSONObject getJsonInfo()
  {
    return this.cEl.getJsonInfo();
  }
  
  public final String getTag()
  {
    return "memoryinfo";
  }
  
  public final void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    super.init(paramApplication, paramc);
    this.cEl = new com.tencent.matrix.d.b.a(this);
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    try
    {
      com.tencent.matrix.g.c.i("Matrix.MemoryCanaryPlugin", "onForeground:".concat(String.valueOf(paramBoolean)), new Object[0]);
      super.onForeground(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void start()
  {
    for (;;)
    {
      try
      {
        com.tencent.matrix.d.b.a locala;
        if (!isPluginStarted())
        {
          super.start();
          locala = this.cEl;
          locala.cEo = com.tencent.matrix.g.a.aO(locala.mContext);
          if ((!com.tencent.matrix.d.b.a.Iu()) || (locala.cEo == a.a.cNH) || (locala.cEo == a.a.cNI) || (locala.cEo == a.a.cNJ)) {
            locala.mIsOpen = false;
          }
        }
        else
        {
          return;
        }
        locala.mIsOpen = true;
        locala.mStartTime = System.currentTimeMillis();
        locala.cEu = 1;
        locala.cEt = (locala.mStartTime + locala.Iv() - 5000L);
        com.tencent.matrix.g.c.d("Matrix.MemoryCanaryCore", "next report delay:%d, starttime:%d", new Object[] { Long.valueOf(locala.Iv()), Long.valueOf(locala.mStartTime) });
        locala.mHandler.postDelayed(locala.cEy, locala.Iv());
        locala.cEx = new HashMap();
        com.tencent.matrix.d.b.a.cEp = com.tencent.matrix.g.a.getTotalMemory(locala.mContext) / 1024L;
        com.tencent.matrix.d.b.a.cEq = com.tencent.matrix.g.a.aP(locala.mContext) / 1024L;
        com.tencent.matrix.d.b.a.cEr = com.tencent.matrix.g.a.aQ(locala.mContext);
        if ((com.tencent.matrix.d.b.a.cEq >= com.tencent.matrix.d.b.a.cEp) || (com.tencent.matrix.d.b.a.cEq <= 0L) || (com.tencent.matrix.d.b.a.cEr <= 102400) || (com.tencent.matrix.d.b.a.cEp <= 0L))
        {
          locala.mIsOpen = false;
          continue;
        }
        ((Application)localObject.mContext).registerActivityLifecycleCallbacks(localObject.cEA);
      }
      finally {}
      localObject.mContext.registerComponentCallbacks(localObject.cEB);
    }
  }
  
  public final void stop()
  {
    try
    {
      if (isPluginStarted())
      {
        super.stop();
        com.tencent.matrix.d.b.a locala = this.cEl;
        ((Application)locala.mContext).unregisterActivityLifecycleCallbacks(locala.cEA);
        locala.mContext.unregisterComponentCallbacks(locala.cEB);
        locala.mIsOpen = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.d.a
 * JD-Core Version:    0.7.0.1
 */