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
  public final com.tencent.matrix.d.a.a cVv;
  private com.tencent.matrix.d.b.a cVw;
  
  public a(com.tencent.matrix.d.a.a parama)
  {
    this.cVv = parama;
  }
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final JSONObject getJsonInfo()
  {
    return this.cVw.getJsonInfo();
  }
  
  public final String getTag()
  {
    return "memoryinfo";
  }
  
  public final void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    super.init(paramApplication, paramc);
    this.cVw = new com.tencent.matrix.d.b.a(this);
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
          locala = this.cVw;
          locala.cVz = com.tencent.matrix.g.a.bj(locala.mContext);
          if ((!com.tencent.matrix.d.b.a.SL()) || (locala.cVz == a.a.deQ) || (locala.cVz == a.a.deR) || (locala.cVz == a.a.deS)) {
            locala.mIsOpen = false;
          }
        }
        else
        {
          return;
        }
        locala.mIsOpen = true;
        locala.mStartTime = System.currentTimeMillis();
        locala.cVF = 1;
        locala.cVE = (locala.mStartTime + locala.SM() - 5000L);
        com.tencent.matrix.g.c.d("Matrix.MemoryCanaryCore", "next report delay:%d, starttime:%d", new Object[] { Long.valueOf(locala.SM()), Long.valueOf(locala.mStartTime) });
        locala.mHandler.postDelayed(locala.cVI, locala.SM());
        locala.cVH = new HashMap();
        com.tencent.matrix.d.b.a.cVA = com.tencent.matrix.g.a.getTotalMemory(locala.mContext) / 1024L;
        com.tencent.matrix.d.b.a.cVB = com.tencent.matrix.g.a.bk(locala.mContext) / 1024L;
        com.tencent.matrix.d.b.a.cVC = com.tencent.matrix.g.a.bl(locala.mContext);
        if ((com.tencent.matrix.d.b.a.cVB >= com.tencent.matrix.d.b.a.cVA) || (com.tencent.matrix.d.b.a.cVB <= 0L) || (com.tencent.matrix.d.b.a.cVC <= 102400) || (com.tencent.matrix.d.b.a.cVA <= 0L))
        {
          locala.mIsOpen = false;
          continue;
        }
        ((Application)localObject.mContext).registerActivityLifecycleCallbacks(localObject.cVK);
      }
      finally {}
      localObject.mContext.registerComponentCallbacks(localObject.cVL);
    }
  }
  
  public final void stop()
  {
    try
    {
      if (isPluginStarted())
      {
        super.stop();
        com.tencent.matrix.d.b.a locala = this.cVw;
        ((Application)locala.mContext).unregisterActivityLifecycleCallbacks(locala.cVK);
        locala.mContext.unregisterComponentCallbacks(locala.cVL);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.d.a
 * JD-Core Version:    0.7.0.1
 */