package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginOpenIMRoom
  extends f
  implements c
{
  private com.tencent.mm.openim.c.a jHN;
  private com.tencent.mm.openim.c.b jHO;
  
  public PluginOpenIMRoom()
  {
    AppMethodBeat.i(151308);
    this.jHN = new com.tencent.mm.openim.c.a();
    this.jHO = new com.tencent.mm.openim.c.b();
    AppMethodBeat.o(151308);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151309);
    Log.i("MicroMsg.PluginOpenIMRoom", "onAccountInitialized");
    com.tencent.mm.roomsdk.a.b.a("@im.chatroom", new a());
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.jHN);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.jHN);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("SendMsgFailed", this.jHO);
    AppMethodBeat.o(151309);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151310);
    Log.i("MicroMsg.PluginOpenIMRoom", "onAccountRelease");
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.jHN);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.jHN);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("SendMsgFailed", this.jHO);
    AppMethodBeat.o(151310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.PluginOpenIMRoom
 * JD-Core Version:    0.7.0.1
 */