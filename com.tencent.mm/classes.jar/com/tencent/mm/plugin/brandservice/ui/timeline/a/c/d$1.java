package com.tencent.mm.plugin.brandservice.ui.timeline.a.c;

import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.c.bxy;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements Runnable
{
  public final void run()
  {
    f.ayA();
    if (f.a(908, "https://res.wx.qq.com/mmbizwap/zh_CN/htmledition/html/native/skeleton.html", null, com.tencent.mm.plugin.brandservice.ui.timeline.a.c.iib))
    {
      y.i("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] download success");
      Object localObject1 = d.oE(0);
      Object localObject2 = c.k(0, 2147483647, "SERVER");
      if ((localObject1 != null) && (com.tencent.mm.a.e.bK((String)localObject2)) && (g.bQ((String)localObject2).equals(g.bQ(com.tencent.mm.plugin.brandservice.ui.timeline.a.c.iib))))
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.a.e.cp("MicroMsg.Preload.TmplInfoManager", "server file already exist, only see for debug");
        return;
      }
      FileOp.r(com.tencent.mm.plugin.brandservice.ui.timeline.a.c.iib, (String)localObject2);
      localObject1 = g.bQ((String)localObject2);
      localObject2 = new bxy();
      ((bxy)localObject2).type = 0;
      ((bxy)localObject2).hQQ = 2147483647;
      ((bxy)localObject2).sND = "";
      ((bxy)localObject2).sNE = 0;
      ((bxy)localObject2).tNV = "SERVER";
      ((bxy)localObject2).jnU = ((String)localObject1);
      ((bxy)localObject2).tFj = 908;
      d.a((bxy)localObject2);
      com.tencent.mm.plugin.brandservice.ui.timeline.a.e.cp("MicroMsg.Preload.TmplInfoManager", "server file download success, only see for debug");
      return;
    }
    y.e("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] download fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c.d.1
 * JD-Core Version:    0.7.0.1
 */