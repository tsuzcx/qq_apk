package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ac;

public class PluginOpenIMRoom
  extends f
  implements c
{
  private com.tencent.mm.openim.c.a ioR;
  private com.tencent.mm.openim.c.b ioS;
  
  public PluginOpenIMRoom()
  {
    AppMethodBeat.i(151308);
    this.ioR = new com.tencent.mm.openim.c.a();
    this.ioS = new com.tencent.mm.openim.c.b();
    AppMethodBeat.o(151308);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151309);
    ac.i("MicroMsg.PluginOpenIMRoom", "onAccountInitialized");
    com.tencent.mm.roomsdk.a.b.a("@im.chatroom", new a());
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.ioR);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.ioR);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("SendMsgFailed", this.ioS);
    AppMethodBeat.o(151309);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151310);
    ac.i("MicroMsg.PluginOpenIMRoom", "onAccountRelease");
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.ioR);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.ioR);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("SendMsgFailed", this.ioS);
    AppMethodBeat.o(151310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.PluginOpenIMRoom
 * JD-Core Version:    0.7.0.1
 */