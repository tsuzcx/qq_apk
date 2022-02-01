package com.tencent.mm.plugin.backup.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.br.c;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

final class a$1
  implements cl.a
{
  a$1(a parama) {}
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(22147);
    Log.i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
    h.OAn.idkeyStat(400L, 0L, 1L, false);
    String str = (String)XmlParser.parseXml(w.a(parama.mpN.YFG), "sysmsg", null).get(".sysmsg.MMBakChatNotify.url");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
      AppMethodBeat.o(22147);
      return;
    }
    parama = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
    Intent localIntent = Util.createExplicitFromImplicitIntent(MMApplicationContext.getContext(), parama);
    if (localIntent != null) {
      parama = localIntent;
    }
    for (;;)
    {
      c.startService(parama.putExtra("url", str).putExtra("isFromWifi", true));
      AppMethodBeat.o(22147);
      return;
    }
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.model.a.1
 * JD-Core Version:    0.7.0.1
 */