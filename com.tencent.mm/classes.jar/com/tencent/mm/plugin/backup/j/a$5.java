package com.tencent.mm.plugin.backup.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

final class a$5
  implements cd.a
{
  a$5(a parama) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(22147);
    ad.i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
    g.yhR.idkeyStat(400L, 0L, 1L, false);
    String str = (String)bw.M(z.a(parama.gqE.Fvk), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
      AppMethodBeat.o(22147);
      return;
    }
    parama = new Intent().setClassName(aj.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
    Intent localIntent = bt.ak(aj.getContext(), parama);
    if (localIntent != null) {
      parama = localIntent;
    }
    for (;;)
    {
      d.be(parama.putExtra("url", str).putExtra("isFromWifi", true));
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