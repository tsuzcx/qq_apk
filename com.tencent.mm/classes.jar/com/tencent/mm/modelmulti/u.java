package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.modelgetchatroommsg.GetChatroomMsgReceiver;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.by;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class u
  implements be
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private GetChatroomMsgReceiver oNv;
  
  static
  {
    AppMethodBeat.i(20556);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(20556);
  }
  
  public static o bKX()
  {
    AppMethodBeat.i(20552);
    h.baF();
    h.baC().aZJ();
    o localo = ((n)h.ax(n.class)).bKX();
    AppMethodBeat.o(20552);
    return localo;
  }
  
  public static v bKY()
  {
    AppMethodBeat.i(20553);
    v localv = ((com.tencent.mm.plugin.zero.b.b)h.ax(com.tencent.mm.plugin.zero.b.b.class)).bKY();
    AppMethodBeat.o(20553);
    return localv;
  }
  
  public static u bKZ()
  {
    AppMethodBeat.i(20554);
    bh.bCt();
    u localu2 = (u)ci.Ka(u.class.getName());
    u localu1 = localu2;
    if (localu2 == null)
    {
      localu1 = new u();
      bh.bCt().a(u.class.getName(), localu1);
    }
    AppMethodBeat.o(20554);
    return localu1;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20551);
    this.oNv = new GetChatroomMsgReceiver();
    this.oNv.alive();
    AppMethodBeat.o(20551);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20555);
    if (this.oNv != null)
    {
      GetChatroomMsgReceiver localGetChatroomMsgReceiver = this.oNv;
      localGetChatroomMsgReceiver.oFf.dead();
      com.tencent.mm.modelgetchatroommsg.b.bJr().oEY = null;
      ((n)h.ax(n.class)).bzG().remove(localGetChatroomMsgReceiver);
      bKZ();
      bKX().remove(localGetChatroomMsgReceiver);
      this.oNv.dead();
    }
    AppMethodBeat.o(20555);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.u
 * JD-Core Version:    0.7.0.1
 */