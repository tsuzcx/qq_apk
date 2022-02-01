package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.h;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.chatroom.a.d;
import com.tencent.mm.sdk.platformtools.ae;

public class PluginChatroom
  extends f
  implements c, d
{
  private h oYh;
  
  public PluginChatroom()
  {
    AppMethodBeat.i(184640);
    this.oYh = new h();
    AppMethodBeat.o(184640);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(101789);
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.b(b.class, new com.tencent.mm.model.s());
    }
    AppMethodBeat.o(101789);
  }
  
  public String name()
  {
    return "plugin-chatroom";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(184641);
    ae.d("MicroMsg.PluginChatroom", "onAccountInitialized");
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewXmlUpgradeAssociateChatRoom", this.oYh);
    AppMethodBeat.o(184641);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184642);
    ae.d("MicroMsg.PluginChatroom", "onAccountRelease");
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("NewXmlUpgradeAssociateChatRoom", this.oYh);
    AppMethodBeat.o(184642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.PluginChatroom
 * JD-Core Version:    0.7.0.1
 */