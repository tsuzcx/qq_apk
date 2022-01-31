package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.d.g;

public final class b
{
  private static b lsx;
  private g lsy;
  
  public static b bcJ()
  {
    if (lsx == null) {
      lsx = new b();
    }
    return lsx;
  }
  
  public final void gZ(boolean paramBoolean)
  {
    au.Dk().c(this.lsy);
    this.lsy = null;
    if (paramBoolean) {}
    for (this.lsy = new g(1);; this.lsy = new g(0))
    {
      au.Dk().a(this.lsy, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.b
 * JD-Core Version:    0.7.0.1
 */