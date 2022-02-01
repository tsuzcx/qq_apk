package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cs;
import com.tencent.mm.f.a.lr;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginChatroom
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.chatroom.a.c
{
  private com.tencent.mm.bc.h tLV;
  private IListener tLW;
  private IListener tLX;
  
  public PluginChatroom()
  {
    AppMethodBeat.i(184640);
    this.tLV = new com.tencent.mm.bc.h();
    this.tLW = new IListener() {};
    this.tLX = new IListener() {};
    AppMethodBeat.o(184640);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(101789);
    if (paramg.aIE()) {
      com.tencent.mm.kernel.h.b(a.class, new w());
    }
    AppMethodBeat.o(101789);
  }
  
  public String name()
  {
    return "plugin-chatroom";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(184641);
    Log.d("MicroMsg.PluginChatroom", "onAccountInitialized");
    this.tLW.alive();
    this.tLX.alive();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("NewXmlUpgradeAssociateChatRoom", this.tLV);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("mmchatroombarannouncememt", this.tLV);
    AppMethodBeat.o(184641);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184642);
    Log.d("MicroMsg.PluginChatroom", "onAccountRelease");
    this.tLW.dead();
    this.tLX.dead();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("NewXmlUpgradeAssociateChatRoom", this.tLV);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("mmchatroombarannouncememt", this.tLV);
    AppMethodBeat.o(184642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.PluginChatroom
 * JD-Core Version:    0.7.0.1
 */