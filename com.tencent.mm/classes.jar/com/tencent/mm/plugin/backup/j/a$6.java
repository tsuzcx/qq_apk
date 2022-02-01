package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.r.f;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

final class a$6
  implements cc.a
{
  a$6(a parama) {}
  
  public final void a(final f.a parama)
  {
    AppMethodBeat.i(22149);
    ac.i("MicroMsg.BackupCore.MsgSynchronize", "appMsgListener onreceive appmsg");
    final String str1 = z.a(parama.fXi.DPV);
    parama = bv.L(str1, "appmsg");
    ac.d("MicroMsg.BackupCore.MsgSynchronize", "BackupCore msgcontent:%s", new Object[] { str1 });
    if (((String)parama.get(".appmsg.action")).equals("phone"))
    {
      ac.i("MicroMsg.BackupCore.MsgSynchronize", "this appmsg is from phone, ignore.");
      AppMethodBeat.o(22149);
      return;
    }
    str1 = (String)parama.get(".appmsg.messageaction");
    final String str2 = (String)parama.get(".appmsg.extinfo");
    parama = ((String)parama.get(".appmsg.appattach.aeskey")).getBytes();
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22148);
        ac.i("MicroMsg.BackupCore.MsgSynchronize", "start MsgSynchronizeServer");
        f.ok(false).d(str1, str2, parama);
        AppMethodBeat.o(22148);
      }
    });
    AppMethodBeat.o(22149);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.6
 * JD-Core Version:    0.7.0.1
 */