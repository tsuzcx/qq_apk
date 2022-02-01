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
  public final com.tencent.matrix.d.a.a cto;
  private com.tencent.matrix.d.b.a ctp;
  
  public a(com.tencent.matrix.d.a.a parama)
  {
    this.cto = parama;
  }
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final JSONObject getJsonInfo()
  {
    return this.ctp.getJsonInfo();
  }
  
  public final String getTag()
  {
    return "memoryinfo";
  }
  
  public final void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    super.init(paramApplication, paramc);
    this.ctp = new com.tencent.matrix.d.b.a(this);
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
          locala = this.ctp;
          locala.cts = com.tencent.matrix.g.a.aO(locala.mContext);
          if ((!com.tencent.matrix.d.b.a.GZ()) || (locala.cts == a.a.cCJ) || (locala.cts == a.a.cCK) || (locala.cts == a.a.cCL)) {
            locala.mIsOpen = false;
          }
        }
        else
        {
          return;
        }
        locala.mIsOpen = true;
        locala.mStartTime = System.currentTimeMillis();
        locala.ctz = 1;
        locala.cty = (locala.mStartTime + locala.Ha() - 5000L);
        com.tencent.matrix.g.c.d("Matrix.MemoryCanaryCore", "next report delay:%d, starttime:%d", new Object[] { Long.valueOf(locala.Ha()), Long.valueOf(locala.mStartTime) });
        locala.mHandler.postDelayed(locala.ctD, locala.Ha());
        locala.ctC = new HashMap();
        com.tencent.matrix.d.b.a.ctt = com.tencent.matrix.g.a.getTotalMemory(locala.mContext) / 1024L;
        com.tencent.matrix.d.b.a.ctu = com.tencent.matrix.g.a.aP(locala.mContext) / 1024L;
        com.tencent.matrix.d.b.a.ctv = com.tencent.matrix.g.a.aQ(locala.mContext);
        if ((com.tencent.matrix.d.b.a.ctu >= com.tencent.matrix.d.b.a.ctt) || (com.tencent.matrix.d.b.a.ctu <= 0L) || (com.tencent.matrix.d.b.a.ctv <= 102400) || (com.tencent.matrix.d.b.a.ctt <= 0L))
        {
          locala.mIsOpen = false;
          continue;
        }
        ((Application)localObject.mContext).registerActivityLifecycleCallbacks(localObject.ctF);
      }
      finally {}
      localObject.mContext.registerComponentCallbacks(localObject.ctG);
    }
  }
  
  public final void stop()
  {
    try
    {
      if (isPluginStarted())
      {
        super.stop();
        com.tencent.matrix.d.b.a locala = this.ctp;
        ((Application)locala.mContext).unregisterActivityLifecycleCallbacks(locala.ctF);
        locala.mContext.unregisterComponentCallbacks(locala.ctG);
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