package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.bc.f;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class u$8
  implements s
{
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(258953);
    paramString = new f();
    if (paramMap == null) {}
    try
    {
      Log.e("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] values == null ");
      for (;;)
      {
        AppMethodBeat.o(258953);
        return null;
        parama = z.a(parama.jQG.RID);
        Log.i("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { Util.nullAsNil(paramString.TYPE), Integer.valueOf(paramMap.size()) });
        paramString.lWx = ((String)paramMap.get(".sysmsg.confirm_username"));
        paramString.lWy = Util.getLong((String)paramMap.get(".sysmsg.newmsgid"), 0L);
        Log.i("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[parseXml] mConfirmUsername:%s, mDisableMsgId:%s username:%s", new Object[] { paramString.lWx, Long.valueOf(paramString.lWy), parama });
        if (!Util.isNullOrNil(parama)) {
          break;
        }
        Log.e("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", "[handle] username is null!");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.DisableChatroomAccessVerifyNewXmlMsg", paramString, "", new Object[0]);
        continue;
        paramString = ((n)h.ae(n.class)).eSe().aL(parama, paramString.lWy);
        if ((paramString.field_msgId > 0L) && (!Util.isNullOrNil(paramString.field_talker)))
        {
          paramString.hAa();
          ((n)h.ae(n.class)).eSe().b(paramString.field_msgSvrId, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.u.8
 * JD-Core Version:    0.7.0.1
 */