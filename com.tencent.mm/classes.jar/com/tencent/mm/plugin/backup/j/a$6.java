package com.tencent.mm.plugin.backup.j;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class a$6
  implements bx.a
{
  a$6(a parama) {}
  
  public final void a(e.a parama)
  {
    y.i("MicroMsg.BackupCore.MsgSynchronize", "appMsgListener onreceive appmsg");
    String str1 = aa.a(parama.dBs.svH);
    parama = bn.s(str1, "appmsg");
    y.d("MicroMsg.BackupCore.MsgSynchronize", "BackupCore msgcontent:%s", new Object[] { str1 });
    if (((String)parama.get(".appmsg.action")).equals("phone"))
    {
      y.i("MicroMsg.BackupCore.MsgSynchronize", "this appmsg is from phone, ignore.");
      return;
    }
    str1 = (String)parama.get(".appmsg.messageaction");
    String str2 = (String)parama.get(".appmsg.extinfo");
    parama = ((String)parama.get(".appmsg.appattach.aeskey")).getBytes();
    au.DS().O(new a.6.1(this, str1, str2, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.6
 * JD-Core Version:    0.7.0.1
 */