package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Map;

public final class c
  extends a
{
  public String iHW = null;
  public String iHX = null;
  
  public c(Map<String, String> paramMap, bu parambu)
  {
    super(paramMap, parambu);
  }
  
  public final boolean aAc()
  {
    AppMethodBeat.i(151264);
    if (this.values == null)
    {
      ad.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(151264);
      return false;
    }
    ad.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bt.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bt.isNullOrNil(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved")))
    {
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username")) {
        this.iHW = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid")) {
        this.iHX = bt.nullAsNil((String)this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid"));
      }
      AppMethodBeat.o(151264);
      return true;
    }
    ad.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type err :%s", new Object[] { bt.nullAsNil(this.TYPE) });
    AppMethodBeat.o(151264);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.c
 * JD-Core Version:    0.7.0.1
 */