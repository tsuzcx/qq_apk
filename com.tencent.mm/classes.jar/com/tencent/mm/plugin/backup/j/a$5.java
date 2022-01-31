package com.tencent.mm.plugin.backup.j;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class a$5
  implements bx.a
{
  a$5(a parama) {}
  
  public final void a(e.a parama)
  {
    y.i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
    h.nFQ.a(400L, 0L, 1L, false);
    String str = (String)bn.s(aa.a(parama.dBs.svH), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
    if (bk.bl(str))
    {
      y.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
      return;
    }
    parama = new Intent().setClassName(ae.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
    Intent localIntent = bk.B(ae.getContext(), parama);
    if (localIntent != null) {
      parama = localIntent;
    }
    for (;;)
    {
      ae.getContext().startService(parama.putExtra("url", str).putExtra("isFromWifi", true));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.5
 * JD-Core Version:    0.7.0.1
 */