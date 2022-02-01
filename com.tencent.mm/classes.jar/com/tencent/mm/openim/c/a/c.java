package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Map;

public final class c
  extends a
{
  public String iKP = null;
  public String iKQ = null;
  
  public c(Map<String, String> paramMap, bv parambv)
  {
    super(paramMap, parambv);
  }
  
  public final boolean aAs()
  {
    AppMethodBeat.i(151264);
    if (this.values == null)
    {
      ae.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(151264);
      return false;
    }
    ae.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bu.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bu.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved")))
    {
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username")) {
        this.iKP = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid")) {
        this.iKQ = bu.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid"));
      }
      AppMethodBeat.o(151264);
      return true;
    }
    ae.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type err :%s", new Object[] { bu.nullAsNil(this.TYPE) });
    AppMethodBeat.o(151264);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.c
 * JD-Core Version:    0.7.0.1
 */