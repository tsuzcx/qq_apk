package com.tencent.mm.plugin.fts.ui;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.Map;

final class FTSMainUI$16
  implements Runnable
{
  FTSMainUI$16(FTSMainUI paramFTSMainUI) {}
  
  public final void run()
  {
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100441");
    Map localMap;
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localMap = ((com.tencent.mm.storage.c)localObject).ctr();
      if (localMap != null) {
        break label87;
      }
    }
    label87:
    for (localObject = "";; localObject = localMap.toString())
    {
      y.i("MicroMsg.FTS.FTSMainUI", "widget switch conf is %s", new Object[] { localObject });
      FTSMainUI.a(this.kCm, "1".equals(localMap.get("isOpen")));
      FTSMainUI.b(this.kCm, bk.ZS((String)localMap.get("searchBarWaitTimeoutMs")));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.16
 * JD-Core Version:    0.7.0.1
 */