package com.tencent.mm.plugin.backup.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.br.d;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

final class a$5
  implements cc.a
{
  a$5(a parama) {}
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(22147);
    ac.i("MicroMsg.BackupCore.BackupToPc", "sysMsgListener onreceive sysmsg");
    h.wUl.idkeyStat(400L, 0L, 1L, false);
    String str = (String)bv.L(z.a(parama.fXi.DPV), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
      AppMethodBeat.o(22147);
      return;
    }
    parama = new Intent().setClassName(ai.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
    Intent localIntent = bs.ai(ai.getContext(), parama);
    if (localIntent != null) {
      parama = localIntent;
    }
    for (;;)
    {
      d.aZ(parama.putExtra("url", str).putExtra("isFromWifi", true));
      AppMethodBeat.o(22147);
      return;
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.5
 * JD-Core Version:    0.7.0.1
 */