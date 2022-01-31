package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip.model.b;

public final class a$a
  implements Runnable
{
  private b lqn = null;
  
  public a$a(a parama, b paramb)
  {
    this.lqn = paramb;
  }
  
  public final void run()
  {
    if (this.lqn != null)
    {
      this.lqn.bPF();
      this.lqn.bPC();
      this.lqn = null;
      this.lqm.lql = false;
    }
    au.Hy().setMode(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */