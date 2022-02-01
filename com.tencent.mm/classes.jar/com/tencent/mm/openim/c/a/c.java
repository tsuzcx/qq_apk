package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.Map;

public final class c
  extends a
{
  public String ioA = null;
  public String ioz = null;
  
  public c(Map<String, String> paramMap, bo parambo)
  {
    super(paramMap, parambo);
  }
  
  public final boolean axn()
  {
    AppMethodBeat.i(151264);
    if (this.values == null)
    {
      ac.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(151264);
      return false;
    }
    ac.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bs.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bs.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved")))
    {
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username")) {
        this.ioz = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid")) {
        this.ioA = bs.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid"));
      }
      AppMethodBeat.o(151264);
      return true;
    }
    ac.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type err :%s", new Object[] { bs.nullAsNil(this.TYPE) });
    AppMethodBeat.o(151264);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.c
 * JD-Core Version:    0.7.0.1
 */