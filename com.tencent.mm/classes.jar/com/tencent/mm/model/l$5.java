package com.tencent.mm.model;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ax.f;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class l$5
  implements n
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    paramString = new f();
    if (paramMap == null) {}
    try
    {
      y.e("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] values == null ");
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", paramString, "", new Object[0]);
    }
    parama = aa.a(parama.dBs.svF);
    y.i("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bk.pm(paramString.TYPE), Integer.valueOf(paramMap.size()) });
    paramString.evO = ((String)paramMap.get(".sysmsg.confirm_username"));
    paramString.evP = bk.getLong((String)paramMap.get(".sysmsg.newmsgid"), 0L);
    y.i("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] mConfirmUsername:%s, mDisableMsgId:%s username:%s", new Object[] { paramString.evO, Long.valueOf(paramString.evP), parama });
    if (bk.bl(parama))
    {
      y.e("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[handle] username is null!");
    }
    else
    {
      paramString = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().O(parama, paramString.evP);
      if ((paramString.field_msgId > 0L) && (!bk.bl(paramString.field_talker)))
      {
        paramString.cvE();
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().b(paramString.field_msgSvrId, paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.l.5
 * JD-Core Version:    0.7.0.1
 */