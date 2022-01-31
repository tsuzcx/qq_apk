package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.y;

public final class c$a
  implements Runnable
{
  private com.tencent.mm.f.b.c lqC = null;
  
  public c$a(c paramc, com.tencent.mm.f.b.c paramc1)
  {
    this.lqC = paramc1;
  }
  
  public final void run()
  {
    y.d("MicroMsg.IPCallRecorder", "do stopRecord");
    if (this.lqC != null)
    {
      this.lqC.uh();
      this.lqC = null;
      c localc = this.lqB;
      localc.lqx = 92;
      localc.lqy = true;
      localc.lqz = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */