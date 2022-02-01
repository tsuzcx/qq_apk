package com.tencent.mm.plugin.ipcall.model.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public abstract class b
  extends a
  implements a.a
{
  public a JGT = null;
  private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
  protected boolean oYG = false;
  
  public final void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    Log.i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.oYG), Integer.valueOf(getTimerInterval()) });
    fRF();
    if (this.JGT != null) {
      this.JGT.a(paramInt1, (p)paramObject, paramInt2, paramInt3);
    }
    if (this.oYG) {
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25406);
          b.this.b(b.this.JGn);
          AppMethodBeat.o(25406);
        }
      }, getTimerInterval());
    }
  }
  
  public final void a(c paramc)
  {
    super.a(paramc);
    this.oYG = true;
    Log.d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
  }
  
  public final void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    Log.i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.oYG), Integer.valueOf(getTimerInterval()) });
    fRG();
    if (this.JGT != null) {
      this.JGT.b(paramInt1, (p)paramObject, paramInt2, paramInt3);
    }
    if (fRE()) {
      stop();
    }
    while (!this.oYG) {
      return;
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25407);
        b.this.b(b.this.JGn);
        AppMethodBeat.o(25407);
      }
    }, getTimerInterval());
  }
  
  public abstract void b(c paramc);
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public abstract boolean fRE();
  
  public abstract void fRF();
  
  public abstract void fRG();
  
  public abstract int getTimerInterval();
  
  public final void init()
  {
    a(this);
    super.init();
  }
  
  public abstract void onStop();
  
  public final void stop()
  {
    this.oYG = false;
    onStop();
    Log.d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, p paramp, int paramInt2, int paramInt3);
    
    public abstract void b(int paramInt1, p paramp, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.b
 * JD-Core Version:    0.7.0.1
 */