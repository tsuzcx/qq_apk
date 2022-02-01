package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.storage.bl;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class h
  implements f.b
{
  public final com.tencent.mm.al.f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(20316);
    Object localObject = (String)paramMap.get(".sysmsg.brand_username");
    String str = (String)paramMap.get(".sysmsg.revoke_climsgid");
    paramString = (String)paramMap.get(".sysmsg.replacemsg");
    az.arV();
    paramMap = c.apO().hq((String)localObject, str);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(20316);
      return null;
    }
    paramMap = paramMap.iterator();
    while (paramMap.hasNext())
    {
      localObject = (bl)paramMap.next();
      f.a(((du)localObject).field_msgId, (bl)localObject, parama, paramString, "MicroMsg.BizChatSysCmdMsgConsumerHandleRevokeMsg");
    }
    AppMethodBeat.o(20316);
    return null;
  }
  
  public final String getSubType()
  {
    return "qy_revoke_msg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.h
 * JD-Core Version:    0.7.0.1
 */