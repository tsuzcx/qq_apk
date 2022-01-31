package com.tencent.mm.graphics.b;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;

public enum d
{
  public WeakReference<Context> dDv = null;
  public HashMap<Integer, a> dDw = new HashMap();
  public final Object dDx = new Object();
  public boolean isRunning = false;
  public Timer mTimer = null;
  
  private d() {}
  
  public final b BL()
  {
    synchronized (this.dDx)
    {
      if (this.dDw != null)
      {
        Object localObject2 = (a)this.dDw.get(Integer.valueOf(2));
        if ((localObject2 != null) && ((localObject2 instanceof b)))
        {
          ((a)localObject2).BJ();
          localObject2 = (b)localObject2;
          return localObject2;
        }
      }
      return null;
    }
  }
  
  public final void BM()
  {
    synchronized (this.dDx)
    {
      if (!this.isRunning) {
        return;
      }
      if (this.mTimer != null) {
        this.mTimer.cancel();
      }
      this.isRunning = false;
      if (this.dDw != null) {
        this.dDw.clear();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.graphics.b.d
 * JD-Core Version:    0.7.0.1
 */