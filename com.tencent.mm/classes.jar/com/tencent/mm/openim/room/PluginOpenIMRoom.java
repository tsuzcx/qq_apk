package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginOpenIMRoom
  extends f
  implements c
{
  private com.tencent.mm.openim.c.a ggz;
  
  public PluginOpenIMRoom()
  {
    AppMethodBeat.i(78964);
    this.ggz = new com.tencent.mm.openim.c.a();
    AppMethodBeat.o(78964);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(78965);
    ab.i("MicroMsg.PluginOpenIMRoom", "onAccountInitialized");
    b.a("@im.chatroom", new a());
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.ggz);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.ggz);
    AppMethodBeat.o(78965);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(78966);
    ab.i("MicroMsg.PluginOpenIMRoom", "onAccountRelease");
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.ggz);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.ggz);
    AppMethodBeat.o(78966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.room.PluginOpenIMRoom
 * JD-Core Version:    0.7.0.1
 */