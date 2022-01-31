package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class a$6
  implements bz.a
{
  a$6(a parama) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(18096);
    ab.i("MicroMsg.BackupCore.MsgSynchronize", "appMsgListener onreceive appmsg");
    String str1 = aa.a(parama.eyJ.woR);
    parama = br.F(str1, "appmsg");
    ab.d("MicroMsg.BackupCore.MsgSynchronize", "BackupCore msgcontent:%s", new Object[] { str1 });
    if (((String)parama.get(".appmsg.action")).equals("phone"))
    {
      ab.i("MicroMsg.BackupCore.MsgSynchronize", "this appmsg is from phone, ignore.");
      AppMethodBeat.o(18096);
      return;
    }
    str1 = (String)parama.get(".appmsg.messageaction");
    String str2 = (String)parama.get(".appmsg.extinfo");
    parama = ((String)parama.get(".appmsg.appattach.aeskey")).getBytes();
    aw.RO().ac(new a.6.1(this, str1, str2, parama));
    AppMethodBeat.o(18096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.6
 * JD-Core Version:    0.7.0.1
 */