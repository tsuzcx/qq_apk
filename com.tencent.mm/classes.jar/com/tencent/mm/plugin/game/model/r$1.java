package com.tencent.mm.plugin.game.model;

import com.tencent.mm.h.a.un;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class r$1
  implements Runnable
{
  public r$1(r paramr, String paramString) {}
  
  public final void run()
  {
    if (bk.bl(this.fEp)) {
      y.e("MicroMsg.GameMessageService", "msg content is null");
    }
    String str;
    int i;
    do
    {
      return;
      localObject = bn.s(this.fEp, "sysmsg");
      if ((localObject == null) || (((Map)localObject).size() == 0))
      {
        y.e("MicroMsg.GameMessageService", "Parse failed");
        return;
      }
      str = bk.aM((String)((Map)localObject).get(".sysmsg.wepkg.$pkg_id"), "");
      i = bk.getInt((String)((Map)localObject).get(".sysmsg.wepkg.download_trigger_type"), 0);
      y.i("MicroMsg.GameMessageService", "MicroMsg.Wepkg message pkgid:%s, downloadTriggerType:%d", new Object[] { str, Integer.valueOf(i) });
    } while (bk.bl(str));
    Object localObject = new un();
    ((un)localObject).cfh.bHz = 1;
    ((un)localObject).cfh.cfi = str;
    ((un)localObject).cfh.cfl = i;
    a.udP.m((b)localObject);
    h.nFQ.a(858L, 15L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.r.1
 * JD-Core Version:    0.7.0.1
 */