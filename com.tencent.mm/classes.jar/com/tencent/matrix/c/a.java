package com.tencent.matrix.c;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.d.b;
import com.tencent.matrix.g.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
  extends b
{
  public final com.tencent.matrix.c.a.a bNM;
  private com.tencent.matrix.c.b.a bNN;
  
  public a(com.tencent.matrix.c.a.a parama)
  {
    this.bNM = parama;
  }
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final JSONObject getJsonInfo()
  {
    return this.bNN.getJsonInfo();
  }
  
  public final String getTag()
  {
    return "memoryinfo";
  }
  
  public final void init(Application paramApplication, com.tencent.matrix.d.c paramc)
  {
    super.init(paramApplication, paramc);
    this.bNN = new com.tencent.matrix.c.b.a(this);
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
        com.tencent.matrix.c.b.a locala;
        if (!isPluginStarted())
        {
          super.start();
          locala = this.bNN;
          locala.bNQ = com.tencent.matrix.g.a.aC(locala.mContext);
          if ((!com.tencent.matrix.c.b.a.za()) || (locala.bNQ == a.a.bTU) || (locala.bNQ == a.a.bTV) || (locala.bNQ == a.a.bTW)) {
            locala.mIsOpen = false;
          }
        }
        else
        {
          return;
        }
        locala.mIsOpen = true;
        locala.mStartTime = System.currentTimeMillis();
        locala.bNW = 1;
        locala.bNV = (locala.mStartTime + locala.zb() - 5000L);
        com.tencent.matrix.g.c.d("Matrix.MemoryCanaryCore", "next report delay:%d, starttime:%d", new Object[] { Long.valueOf(locala.zb()), Long.valueOf(locala.mStartTime) });
        locala.mHandler.postDelayed(locala.bOa, locala.zb());
        locala.bNZ = new HashMap();
        com.tencent.matrix.c.b.a.bNR = com.tencent.matrix.g.a.getTotalMemory(locala.mContext) / 1024L;
        com.tencent.matrix.c.b.a.bNS = com.tencent.matrix.g.a.aD(locala.mContext) / 1024L;
        com.tencent.matrix.c.b.a.bNT = com.tencent.matrix.g.a.aE(locala.mContext);
        if ((com.tencent.matrix.c.b.a.bNS >= com.tencent.matrix.c.b.a.bNR) || (com.tencent.matrix.c.b.a.bNS <= 0L) || (com.tencent.matrix.c.b.a.bNT <= 102400) || (com.tencent.matrix.c.b.a.bNR <= 0L))
        {
          locala.mIsOpen = false;
          continue;
        }
        ((Application)localObject.mContext).registerActivityLifecycleCallbacks(localObject.bOc);
      }
      finally {}
      localObject.mContext.registerComponentCallbacks(localObject.bOd);
    }
  }
  
  public final void stop()
  {
    try
    {
      if (isPluginStarted())
      {
        super.stop();
        com.tencent.matrix.c.b.a locala = this.bNN;
        ((Application)locala.mContext).unregisterActivityLifecycleCallbacks(locala.bOc);
        locala.mContext.unregisterComponentCallbacks(locala.bOd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.c.a
 * JD-Core Version:    0.7.0.1
 */