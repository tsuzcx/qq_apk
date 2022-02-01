package com.tencent.mm.plugin.backup.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.br.d;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

final class a$5
  implements cf.a
{
  a$5(a parama) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(22147);
    ae.i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
    g.yxI.idkeyStat(400L, 0L, 1L, false);
    String str = (String)bx.M(z.a(parama.gte.FNI), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
      AppMethodBeat.o(22147);
      return;
    }
    parama = new Intent().setClassName(ak.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
    Intent localIntent = bu.ak(ak.getContext(), parama);
    if (localIntent != null) {
      parama = localIntent;
    }
    for (;;)
    {
      d.bf(parama.putExtra("url", str).putExtra("isFromWifi", true));
      AppMethodBeat.o(22147);
      return;
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.5
 * JD-Core Version:    0.7.0.1
 */