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
  public final com.tencent.matrix.d.a.a cwg;
  private com.tencent.matrix.d.b.a cwh;
  
  public a(com.tencent.matrix.d.a.a parama)
  {
    this.cwg = parama;
  }
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final JSONObject getJsonInfo()
  {
    return this.cwh.getJsonInfo();
  }
  
  public final String getTag()
  {
    return "memoryinfo";
  }
  
  public final void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    super.init(paramApplication, paramc);
    this.cwh = new com.tencent.matrix.d.b.a(this);
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
          locala = this.cwh;
          locala.cwk = com.tencent.matrix.g.a.aN(locala.mContext);
          if ((!com.tencent.matrix.d.b.a.Ho()) || (locala.cwk == a.a.cFB) || (locala.cwk == a.a.cFC) || (locala.cwk == a.a.cFD)) {
            locala.mIsOpen = false;
          }
        }
        else
        {
          return;
        }
        locala.mIsOpen = true;
        locala.mStartTime = System.currentTimeMillis();
        locala.cwq = 1;
        locala.cwp = (locala.mStartTime + locala.Hp() - 5000L);
        com.tencent.matrix.g.c.d("Matrix.MemoryCanaryCore", "next report delay:%d, starttime:%d", new Object[] { Long.valueOf(locala.Hp()), Long.valueOf(locala.mStartTime) });
        locala.mHandler.postDelayed(locala.cwu, locala.Hp());
        locala.cwt = new HashMap();
        com.tencent.matrix.d.b.a.cwl = com.tencent.matrix.g.a.getTotalMemory(locala.mContext) / 1024L;
        com.tencent.matrix.d.b.a.cwm = com.tencent.matrix.g.a.aO(locala.mContext) / 1024L;
        com.tencent.matrix.d.b.a.cwn = com.tencent.matrix.g.a.aP(locala.mContext);
        if ((com.tencent.matrix.d.b.a.cwm >= com.tencent.matrix.d.b.a.cwl) || (com.tencent.matrix.d.b.a.cwm <= 0L) || (com.tencent.matrix.d.b.a.cwn <= 102400) || (com.tencent.matrix.d.b.a.cwl <= 0L))
        {
          locala.mIsOpen = false;
          continue;
        }
        ((Application)localObject.mContext).registerActivityLifecycleCallbacks(localObject.cww);
      }
      finally {}
      localObject.mContext.registerComponentCallbacks(localObject.cwx);
    }
  }
  
  public final void stop()
  {
    try
    {
      if (isPluginStarted())
      {
        super.stop();
        com.tencent.matrix.d.b.a locala = this.cwh;
        ((Application)locala.mContext).unregisterActivityLifecycleCallbacks(locala.cww);
        locala.mContext.unregisterComponentCallbacks(locala.cwx);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.d.a
 * JD-Core Version:    0.7.0.1
 */