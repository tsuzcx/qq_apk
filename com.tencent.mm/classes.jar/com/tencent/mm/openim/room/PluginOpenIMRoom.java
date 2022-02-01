package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginOpenIMRoom
  extends f
  implements c
{
  private com.tencent.mm.openim.b.a ptP;
  private com.tencent.mm.openim.b.b ptQ;
  
  public PluginOpenIMRoom()
  {
    AppMethodBeat.i(151308);
    this.ptP = new com.tencent.mm.openim.b.a();
    this.ptQ = new com.tencent.mm.openim.b.b();
    AppMethodBeat.o(151308);
  }
  
  public void configure(g paramg) {}
  
  public void execute(g paramg) {}
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(151309);
    Log.i("MicroMsg.PluginOpenIMRoom", "onAccountInitialized");
    com.tencent.mm.roomsdk.model.b.a("@im.chatroom", new a());
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.ptP);
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.ptP);
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("SendMsgFailed", this.ptQ);
    AppMethodBeat.o(151309);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(151310);
    Log.i("MicroMsg.PluginOpenIMRoom", "onAccountRelease");
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.ptP);
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.ptP);
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("SendMsgFailed", this.ptQ);
    AppMethodBeat.o(151310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.room.PluginOpenIMRoom
 * JD-Core Version:    0.7.0.1
 */