package com.tencent.mm.plugin.ipcall.model.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public abstract class b
  extends a
  implements a.a
{
  protected boolean iuX = false;
  private aq mHandler = new aq(Looper.getMainLooper());
  public a uXe = null;
  
  public final void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    ae.i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.iuX), Integer.valueOf(getTimerInterval()) });
    dgM();
    if (this.uXe != null) {
      this.uXe.a(paramInt1, (n)paramObject, paramInt2, paramInt3);
    }
    if (this.iuX) {
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25406);
          b.this.b(b.this.uWv);
          AppMethodBeat.o(25406);
        }
      }, getTimerInterval());
    }
  }
  
  public final void a(c paramc)
  {
    super.a(paramc);
    this.iuX = true;
    ae.d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
  }
  
  public final void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    ae.i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.iuX), Integer.valueOf(getTimerInterval()) });
    dgN();
    if (this.uXe != null) {
      this.uXe.b(paramInt1, (n)paramObject, paramInt2, paramInt3);
    }
    if (this.iuX) {
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(25407);
          b.this.b(b.this.uWv);
          AppMethodBeat.o(25407);
        }
      }, getTimerInterval());
    }
  }
  
  public abstract void b(c paramc);
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public abstract void dgM();
  
  public abstract void dgN();
  
  public abstract int getTimerInterval();
  
  public final void init()
  {
    a(this);
    super.init();
  }
  
  public abstract void onStop();
  
  public final void stop()
  {
    this.iuX = false;
    onStop();
    ae.d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, n paramn, int paramInt2, int paramInt3);
    
    public abstract void b(int paramInt1, n paramn, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.b
 * JD-Core Version:    0.7.0.1
 */