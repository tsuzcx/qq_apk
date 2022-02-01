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
  public final com.tencent.matrix.d.a.a cER;
  private com.tencent.matrix.d.b.a cES;
  
  public a(com.tencent.matrix.d.a.a parama)
  {
    this.cER = parama;
  }
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final JSONObject getJsonInfo()
  {
    return this.cES.getJsonInfo();
  }
  
  public final String getTag()
  {
    return "memoryinfo";
  }
  
  public final void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    super.init(paramApplication, paramc);
    this.cES = new com.tencent.matrix.d.b.a(this);
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
          locala = this.cES;
          locala.cEV = com.tencent.matrix.g.a.aP(locala.mContext);
          if ((!com.tencent.matrix.d.b.a.IC()) || (locala.cEV == a.a.cOr) || (locala.cEV == a.a.cOs) || (locala.cEV == a.a.cOt)) {
            locala.mIsOpen = false;
          }
        }
        else
        {
          return;
        }
        locala.mIsOpen = true;
        locala.mStartTime = System.currentTimeMillis();
        locala.cFb = 1;
        locala.cFa = (locala.mStartTime + locala.ID() - 5000L);
        com.tencent.matrix.g.c.d("Matrix.MemoryCanaryCore", "next report delay:%d, starttime:%d", new Object[] { Long.valueOf(locala.ID()), Long.valueOf(locala.mStartTime) });
        locala.mHandler.postDelayed(locala.cFf, locala.ID());
        locala.cFe = new HashMap();
        com.tencent.matrix.d.b.a.cEW = com.tencent.matrix.g.a.getTotalMemory(locala.mContext) / 1024L;
        com.tencent.matrix.d.b.a.cEX = com.tencent.matrix.g.a.aQ(locala.mContext) / 1024L;
        com.tencent.matrix.d.b.a.cEY = com.tencent.matrix.g.a.aR(locala.mContext);
        if ((com.tencent.matrix.d.b.a.cEX >= com.tencent.matrix.d.b.a.cEW) || (com.tencent.matrix.d.b.a.cEX <= 0L) || (com.tencent.matrix.d.b.a.cEY <= 102400) || (com.tencent.matrix.d.b.a.cEW <= 0L))
        {
          locala.mIsOpen = false;
          continue;
        }
        ((Application)localObject.mContext).registerActivityLifecycleCallbacks(localObject.cFh);
      }
      finally {}
      localObject.mContext.registerComponentCallbacks(localObject.cFi);
    }
  }
  
  public final void stop()
  {
    try
    {
      if (isPluginStarted())
      {
        super.stop();
        com.tencent.matrix.d.b.a locala = this.cES;
        ((Application)locala.mContext).unregisterActivityLifecycleCallbacks(locala.cFh);
        locala.mContext.unregisterComponentCallbacks(locala.cFi);
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