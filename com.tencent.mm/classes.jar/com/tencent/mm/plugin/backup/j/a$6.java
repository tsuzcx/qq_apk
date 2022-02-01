package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.r.f;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

final class a$6
  implements cf.a
{
  a$6(a parama) {}
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(22149);
    ae.i("MicroMsg.BackupCore.MsgSynchronize", "appMsgListener onreceive appmsg");
    final String str1 = z.a(parama.gte.FNI);
    parama = bx.M(str1, "appmsg");
    ae.d("MicroMsg.BackupCore.MsgSynchronize", "BackupCore msgcontent:%s", new Object[] { str1 });
    if (((String)parama.get(".appmsg.action")).equals("phone"))
    {
      ae.i("MicroMsg.BackupCore.MsgSynchronize", "this appmsg is from phone, ignore.");
      AppMethodBeat.o(22149);
      return;
    }
    str1 = (String)parama.get(".appmsg.messageaction");
    final String str2 = (String)parama.get(".appmsg.extinfo");
    parama = ((String)parama.get(".appmsg.appattach.aeskey")).getBytes();
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22148);
        ae.i("MicroMsg.BackupCore.MsgSynchronize", "start MsgSynchronizeServer");
        f.oJ(false).d(str1, str2, parama);
        AppMethodBeat.o(22148);
      }
    });
    AppMethodBeat.o(22149);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.6
 * JD-Core Version:    0.7.0.1
 */