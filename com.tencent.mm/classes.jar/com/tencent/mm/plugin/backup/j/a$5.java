package com.tencent.mm.plugin.backup.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class a$5
  implements bz.a
{
  a$5(a parama) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(18094);
    ab.i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
    h.qsU.idkeyStat(400L, 0L, 1L, false);
    String str = (String)br.F(aa.a(parama.eyJ.woR), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
      AppMethodBeat.o(18094);
      return;
    }
    parama = new Intent().setClassName(ah.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
    Intent localIntent = bo.I(ah.getContext(), parama);
    if (localIntent != null) {
      parama = localIntent;
    }
    for (;;)
    {
      d.aG(parama.putExtra("url", str).putExtra("isFromWifi", true));
      AppMethodBeat.o(18094);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.5
 * JD-Core Version:    0.7.0.1
 */