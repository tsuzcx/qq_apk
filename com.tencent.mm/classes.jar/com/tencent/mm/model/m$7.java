package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class m$7
  implements n
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(5507);
    paramString = new f();
    if (paramMap == null) {}
    try
    {
      ab.e("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] values == null ");
      for (;;)
      {
        AppMethodBeat.o(5507);
        return null;
        parama = aa.a(parama.eyJ.woP);
        ab.i("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bo.nullAsNil(paramString.TYPE), Integer.valueOf(paramMap.size()) });
        paramString.fLB = ((String)paramMap.get(".sysmsg.confirm_username"));
        paramString.fLC = bo.getLong((String)paramMap.get(".sysmsg.newmsgid"), 0L);
        ab.i("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] mConfirmUsername:%s, mDisableMsgId:%s username:%s", new Object[] { paramString.fLB, Long.valueOf(paramString.fLC), parama });
        if (!bo.isNullOrNil(parama)) {
          break;
        }
        ab.e("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[handle] username is null!");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", paramString, "", new Object[0]);
        continue;
        paramString = ((j)g.E(j.class)).bPQ().ag(parama, paramString.fLC);
        if ((paramString.field_msgId > 0L) && (!bo.isNullOrNil(paramString.field_talker)))
        {
          paramString.dyl();
          ((j)g.E(j.class)).bPQ().b(paramString.field_msgSvrId, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.m.7
 * JD-Core Version:    0.7.0.1
 */