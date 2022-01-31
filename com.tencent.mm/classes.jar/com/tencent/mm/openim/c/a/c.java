package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class c
  extends a
{
  public String ggh = null;
  public String ggi = null;
  
  public c(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
  }
  
  public final boolean Zh()
  {
    AppMethodBeat.i(78920);
    if (this.values == null)
    {
      ab.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(78920);
      return false;
    }
    ab.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bo.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved")))
    {
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username")) {
        this.ggh = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid")) {
        this.ggi = bo.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid"));
      }
      AppMethodBeat.o(78920);
      return true;
    }
    ab.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type err :%s", new Object[] { bo.nullAsNil(this.TYPE) });
    AppMethodBeat.o(78920);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.c
 * JD-Core Version:    0.7.0.1
 */