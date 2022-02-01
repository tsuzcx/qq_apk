package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.h;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.chatroom.a.d;
import com.tencent.mm.sdk.platformtools.ad;

public class PluginChatroom
  extends f
  implements c, d
{
  private h oRF;
  
  public PluginChatroom()
  {
    AppMethodBeat.i(184640);
    this.oRF = new h();
    AppMethodBeat.o(184640);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(101789);
    if (paramg.akw()) {
      com.tencent.mm.kernel.g.b(b.class, new com.tencent.mm.model.r());
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
    ad.d("MicroMsg.PluginChatroom", "onAccountInitialized");
    ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("NewXmlUpgradeAssociateChatRoom", this.oRF);
    AppMethodBeat.o(184641);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184642);
    ad.d("MicroMsg.PluginChatroom", "onAccountRelease");
    ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().b("NewXmlUpgradeAssociateChatRoom", this.oRF);
    AppMethodBeat.o(184642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.PluginChatroom
 * JD-Core Version:    0.7.0.1
 */