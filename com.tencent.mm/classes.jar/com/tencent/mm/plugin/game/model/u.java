package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

public final class u
  implements f
{
  public u()
  {
    g.Dk().a(1223, this);
  }
  
  public static void b(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    y.i("MicroMsg.GameMsgReportService", "appId = %s, opType = %d, opStatus = %d, extInfo = %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString3 });
    paramString1 = new au(paramString1, paramInt1, paramInt2, paramString2, paramString3);
    g.Dk().a(paramString1, 0);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.u
 * JD-Core Version:    0.7.0.1
 */