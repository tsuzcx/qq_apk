package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.h;
import com.tencent.mm.g.a.la;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.chatroom.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginChatroom
  extends f
  implements c, d
{
  private h qne;
  private IListener qnf;
  
  public PluginChatroom()
  {
    AppMethodBeat.i(184640);
    this.qne = new h();
    this.qnf = new IListener() {};
    AppMethodBeat.o(184640);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(101789);
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.b(b.class, new w());
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
    Log.d("MicroMsg.PluginChatroom", "onAccountInitialized");
    this.qnf.alive();
    v.fr(false);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlUpgradeAssociateChatRoom", this.qne);
    AppMethodBeat.o(184641);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184642);
    Log.d("MicroMsg.PluginChatroom", "onAccountRelease");
    this.qnf.dead();
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlUpgradeAssociateChatRoom", this.qne);
    AppMethodBeat.o(184642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.PluginChatroom
 * JD-Core Version:    0.7.0.1
 */