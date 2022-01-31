package com.tencent.mm.plugin.boots.c;

import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class a
  implements f
{
  public static a hXZ;
  private com.tencent.mm.plugin.boots.c.a.a hYa;
  
  public a(com.tencent.mm.plugin.boots.c.a.a parama)
  {
    this.hYa = parama;
  }
  
  public final List<com.tencent.mm.plugin.boots.a.a> awD()
  {
    if (this.hYa != null) {
      return this.hYa.awD();
    }
    return null;
  }
  
  public final void c(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = 255;
    if (this.hYa != null)
    {
      com.tencent.mm.plugin.boots.a.a locala = this.hYa.oe(paramInt1);
      paramInt1 = this.hYa.od(paramInt1);
      if ((paramBoolean) && (locala.field_dau != paramInt1))
      {
        if (paramInt1 <= 255) {
          break label67;
        }
        paramInt1 = i;
      }
      label67:
      for (;;)
      {
        h.nFQ.a(paramInt2, paramInt1, 1L, false);
        return;
      }
    }
    y.w("MicroMsg.Boots.TinkerLogic", "storage is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.c.a
 * JD-Core Version:    0.7.0.1
 */