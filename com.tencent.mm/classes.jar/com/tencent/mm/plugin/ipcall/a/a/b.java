package com.tencent.mm.plugin.ipcall.a.a;

import android.os.Looper;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public abstract class b
  extends a
  implements a.a
{
  protected boolean eFF = false;
  public b.a lpB = null;
  private ah mHandler = new ah(Looper.getMainLooper());
  
  public final void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.eFF), Integer.valueOf(bct()) });
    bcu();
    if (this.lpB != null) {
      this.lpB.a(paramInt1, (m)paramObject, paramInt2, paramInt3);
    }
    if (this.eFF) {
      this.mHandler.postDelayed(new b.1(this), bct());
    }
  }
  
  public final void a(c paramc)
  {
    super.a(paramc);
    this.eFF = true;
    y.d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", new Object[] { Integer.valueOf(LW()) });
  }
  
  public final void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.eFF), Integer.valueOf(bct()) });
    bcv();
    if (this.lpB != null) {
      this.lpB.b(paramInt1, (m)paramObject, paramInt2, paramInt3);
    }
    if (this.eFF) {
      this.mHandler.postDelayed(new b.2(this), bct());
    }
  }
  
  public abstract void b(c paramc);
  
  public abstract int bct();
  
  public abstract void bcu();
  
  public abstract void bcv();
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final void init()
  {
    this.lpA = this;
    super.init();
  }
  
  public abstract void onStop();
  
  public final void stop()
  {
    this.eFF = false;
    onStop();
    y.d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", new Object[] { Integer.valueOf(LW()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a.b
 * JD-Core Version:    0.7.0.1
 */