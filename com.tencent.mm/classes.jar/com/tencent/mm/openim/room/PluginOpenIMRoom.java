package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.ad;

public class PluginOpenIMRoom
  extends f
  implements c
{
  private com.tencent.mm.openim.c.a iIo;
  private com.tencent.mm.openim.c.b iIp;
  
  public PluginOpenIMRoom()
  {
    AppMethodBeat.i(151308);
    this.iIo = new com.tencent.mm.openim.c.a();
    this.iIp = new com.tencent.mm.openim.c.b();
    AppMethodBeat.o(151308);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(151309);
    ad.i("MicroMsg.PluginOpenIMRoom", "onAccountInitialized");
    com.tencent.mm.roomsdk.a.b.a("@im.chatroom", new a());
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.iIo);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.iIo);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("SendMsgFailed", this.iIp);
    AppMethodBeat.o(151309);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151310);
    ad.i("MicroMsg.PluginOpenIMRoom", "onAccountRelease");
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.iIo);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.iIo);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("SendMsgFailed", this.iIp);
    AppMethodBeat.o(151310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.PluginOpenIMRoom
 * JD-Core Version:    0.7.0.1
 */