package com.tencent.mm.plugin.downloader_app.b;

import java.util.Map;

final class c$8
  implements g.a
{
  c$8(a parama) {}
  
  public final void eR(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      f localf = g.aGn();
      if (localf != null)
      {
        String str = this.iRW.appId;
        if (localf.iSl.get(str) == null) {
          break label52;
        }
      }
    }
    label52:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        k.Af(this.iRW.appId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.8
 * JD-Core Version:    0.7.0.1
 */