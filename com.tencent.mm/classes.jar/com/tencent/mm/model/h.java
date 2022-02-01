package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class h
  implements f.b
{
  public final com.tencent.mm.ak.f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(20316);
    Object localObject = (String)paramMap.get(".sysmsg.brand_username");
    String str = (String)paramMap.get(".sysmsg.revoke_climsgid");
    paramString = (String)paramMap.get(".sysmsg.replacemsg");
    az.ayM();
    paramMap = c.awD().hJ((String)localObject, str);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(20316);
      return null;
    }
    paramMap = paramMap.iterator();
    while (paramMap.hasNext())
    {
      localObject = (bo)paramMap.next();
      f.a(((dy)localObject).field_msgId, (bo)localObject, parama, paramString, "MicroMsg.BizChatSysCmdMsgConsumerHandleRevokeMsg");
    }
    AppMethodBeat.o(20316);
    return null;
  }
  
  public final String getSubType()
  {
    return "qy_revoke_msg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.h
 * JD-Core Version:    0.7.0.1
 */