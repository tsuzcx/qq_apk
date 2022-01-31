package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public boolean bSr = false;
  public boolean dnJ = false;
  c.a iED = new c.1(this);
  boolean lqA = true;
  public com.tencent.mm.f.b.c lqv = null;
  public final Object lqw = new Object();
  int lqx = 92;
  boolean lqy = true;
  int lqz = 0;
  
  public final void setMute(boolean paramBoolean)
  {
    y.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.bSr) && (this.lqv != null)) {
      this.lqv.aZ(paramBoolean);
    }
    this.dnJ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.c
 * JD-Core Version:    0.7.0.1
 */