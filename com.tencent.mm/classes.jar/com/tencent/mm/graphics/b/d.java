package com.tencent.mm.graphics.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;

public enum d
{
  public WeakReference<Context> eAW;
  public HashMap<Integer, a> eAX;
  public final Object eAY;
  public boolean isRunning;
  public Timer mTimer;
  
  static
  {
    AppMethodBeat.i(57092);
    eAV = new d("INSTANCE");
    eAZ = new d[] { eAV };
    AppMethodBeat.o(57092);
  }
  
  private d()
  {
    AppMethodBeat.i(57089);
    this.eAW = null;
    this.eAX = new HashMap();
    this.isRunning = false;
    this.mTimer = null;
    this.eAY = new Object();
    AppMethodBeat.o(57089);
  }
  
  public final b Px()
  {
    AppMethodBeat.i(57090);
    synchronized (this.eAY)
    {
      if (this.eAX != null)
      {
        Object localObject2 = (a)this.eAX.get(Integer.valueOf(2));
        if ((localObject2 != null) && ((localObject2 instanceof b)))
        {
          ((a)localObject2).Pv();
          localObject2 = (b)localObject2;
          AppMethodBeat.o(57090);
          return localObject2;
        }
      }
      AppMethodBeat.o(57090);
      return null;
    }
  }
  
  public final void Py()
  {
    AppMethodBeat.i(57091);
    synchronized (this.eAY)
    {
      if (!this.isRunning)
      {
        AppMethodBeat.o(57091);
        return;
      }
      if (this.mTimer != null) {
        this.mTimer.cancel();
      }
      this.isRunning = false;
      if (this.eAX != null) {
        this.eAX.clear();
      }
      AppMethodBeat.o(57091);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.b.d
 * JD-Core Version:    0.7.0.1
 */