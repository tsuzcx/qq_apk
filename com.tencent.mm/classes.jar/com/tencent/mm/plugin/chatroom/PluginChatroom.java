package com.tencent.mm.plugin.chatroom;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dc;
import com.tencent.mm.autogen.a.mw;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;

public class PluginChatroom
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.chatroom.a.c
{
  private com.tencent.mm.ax.h wPl;
  private IListener wPm;
  private IListener wPn;
  
  public PluginChatroom()
  {
    AppMethodBeat.i(184640);
    this.wPl = new com.tencent.mm.ax.h();
    this.wPm = new IListener(com.tencent.mm.app.f.hfK) {};
    this.wPn = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(184640);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(101789);
    if (paramg.bbA()) {
      com.tencent.mm.kernel.h.b(a.class, new w());
    }
    AppMethodBeat.o(101789);
  }
  
  public int getMembersCountByChatRoomName(String paramString)
  {
    AppMethodBeat.i(369707);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(369707);
      return 0;
    }
    int i = com.tencent.mm.model.v.getMembersCountByChatRoomName(paramString);
    AppMethodBeat.o(369707);
    return i;
  }
  
  public boolean isChatRoomDismiss(String paramString)
  {
    AppMethodBeat.i(369705);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(369705);
      return false;
    }
    if ((au.bwE(paramString)) && (((b)com.tencent.mm.kernel.h.ax(b.class)).alQ(paramString)))
    {
      AppMethodBeat.o(369705);
      return true;
    }
    AppMethodBeat.o(369705);
    return false;
  }
  
  public boolean isNotInChatRoom(String paramString)
  {
    AppMethodBeat.i(369706);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(369706);
      return false;
    }
    if ((au.bwE(paramString)) && (!com.tencent.mm.model.v.If(paramString)))
    {
      AppMethodBeat.o(369706);
      return true;
    }
    AppMethodBeat.o(369706);
    return false;
  }
  
  public String name()
  {
    return "plugin-chatroom";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(184641);
    Log.d("MicroMsg.PluginChatroom", "onAccountInitialized");
    this.wPm.alive();
    this.wPn.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("NewXmlUpgradeAssociateChatRoom", this.wPl);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("mmchatroombarannouncememt", this.wPl);
    AppMethodBeat.o(184641);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(184642);
    Log.d("MicroMsg.PluginChatroom", "onAccountRelease");
    this.wPm.dead();
    this.wPn.dead();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("NewXmlUpgradeAssociateChatRoom", this.wPl);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("mmchatroombarannouncememt", this.wPl);
    AppMethodBeat.o(184642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.PluginChatroom
 * JD-Core Version:    0.7.0.1
 */