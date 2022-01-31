package com.tencent.mm.plugin.ipcall.a.a;

import android.os.Looper;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public abstract class b
  extends a
  implements a.a
{
  protected boolean fVw = false;
  private ak mHandler = new ak(Looper.getMainLooper());
  public b.a nMX = null;
  
  public final void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    ab.i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.fVw), Integer.valueOf(bJA()) });
    bJB();
    if (this.nMX != null) {
      this.nMX.a(paramInt1, (m)paramObject, paramInt2, paramInt3);
    }
    if (this.fVw) {
      this.mHandler.postDelayed(new b.1(this), bJA());
    }
  }
  
  public final void a(c paramc)
  {
    super.a(paramc);
    this.fVw = true;
    ab.d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
  }
  
  public final void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    ab.i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.fVw), Integer.valueOf(bJA()) });
    bJC();
    if (this.nMX != null) {
      this.nMX.b(paramInt1, (m)paramObject, paramInt2, paramInt3);
    }
    if (this.fVw) {
      this.mHandler.postDelayed(new b.2(this), bJA());
    }
  }
  
  public abstract void b(c paramc);
  
  public abstract int bJA();
  
  public abstract void bJB();
  
  public abstract void bJC();
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final void init()
  {
    a(this);
    super.init();
  }
  
  public abstract void onStop();
  
  public final void stop()
  {
    this.fVw = false;
    onStop();
    ab.d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", new Object[] { Integer.valueOf(getServiceType()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a.b
 * JD-Core Version:    0.7.0.1
 */