package com.tencent.mm.model;

import com.tencent.mm.kernel.g;

final class c$3
  implements com.tencent.mm.kernel.api.f
{
  c$3(c paramc) {}
  
  public final void DU() {}
  
  public final void gj(String paramString)
  {
    if (com.tencent.mm.compatible.util.f.zF())
    {
      g.DQ();
      if (g.DP().dKs.equals(com.tencent.mm.compatible.util.e.bkH))
      {
        g.DQ();
        com.tencent.mm.sdk.f.e.post(new c.b(g.DP().cachePath, paramString), "AccountStorage_moveDataFiles");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.c.3
 * JD-Core Version:    0.7.0.1
 */