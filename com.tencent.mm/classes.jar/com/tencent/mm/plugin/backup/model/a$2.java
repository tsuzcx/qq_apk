package com.tencent.mm.plugin.backup.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.z.f;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

final class a$2
  implements cl.a
{
  a$2(a parama) {}
  
  public final void a(final g.a parama)
  {
    AppMethodBeat.i(22149);
    Log.i("MicroMsg.BackupCore.MsgSynchronize", "appMsgListener onreceive appmsg");
    final String str1 = w.a(parama.mpN.YFG);
    parama = XmlParser.parseXml(str1, "appmsg", null);
    Log.d("MicroMsg.BackupCore.MsgSynchronize", "BackupCore msgcontent:%s", new Object[] { str1 });
    if (((String)parama.get(".appmsg.action")).equals("phone"))
    {
      Log.i("MicroMsg.BackupCore.MsgSynchronize", "this appmsg is from phone, ignore.");
      AppMethodBeat.o(22149);
      return;
    }
    str1 = (String)parama.get(".appmsg.messageaction");
    final String str2 = (String)parama.get(".appmsg.extinfo");
    parama = ((String)parama.get(".appmsg.appattach.aeskey")).getBytes();
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22148);
        Log.i("MicroMsg.BackupCore.MsgSynchronize", "start MsgSynchronizeServer");
        f.yH(false).a(str1, str2, parama, "");
        AppMethodBeat.o(22148);
      }
    });
    AppMethodBeat.o(22149);
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.model.a.2
 * JD-Core Version:    0.7.0.1
 */