package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.chatroom.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ad;

public class PluginChatroom
  extends f
  implements c, d
{
  private com.tencent.mm.ba.g nLk;
  
  public PluginChatroom()
  {
    AppMethodBeat.i(184640);
    this.nLk = new com.tencent.mm.ba.g();
    AppMethodBeat.o(184640);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(101789);
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.b(b.class, new r());
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
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("NewXmlUpgradeAssociateChatRoom", this.nLk);
    AppMethodBeat.o(184641);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184642);
    ad.d("MicroMsg.PluginChatroom", "onAccountRelease");
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("NewXmlUpgradeAssociateChatRoom", this.nLk);
    AppMethodBeat.o(184642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.PluginChatroom
 * JD-Core Version:    0.7.0.1
 */