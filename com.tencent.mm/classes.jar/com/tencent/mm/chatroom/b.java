package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class b
  implements bd
{
  private static com.tencent.mm.chatroom.c.a grl;
  private c<nc> grf;
  private c<nf> grg;
  private c<ne> grh;
  private c<nj> gri;
  private c<nd> grj;
  private IListener grk;
  
  public b()
  {
    AppMethodBeat.i(12431);
    this.grf = new c()
    {
      public final int alY()
      {
        return 181;
      }
    };
    this.grg = new c()
    {
      public final int alY()
      {
        return 551;
      }
    };
    this.grh = new c()
    {
      public final int alY()
      {
        return 179;
      }
    };
    this.gri = new c()
    {
      public final int alY()
      {
        return 700;
      }
    };
    this.grj = new c()
    {
      public final int alY()
      {
        return 119;
      }
    };
    this.grk = new IListener() {};
    AppMethodBeat.o(12431);
  }
  
  private static b alW()
  {
    AppMethodBeat.i(12432);
    b localb = (b)y.at(b.class);
    AppMethodBeat.o(12432);
    return localb;
  }
  
  private static com.tencent.mm.chatroom.c.a alX()
  {
    AppMethodBeat.i(12433);
    g.aAf().azk();
    alW();
    if (grl == null)
    {
      alW();
      grl = new com.tencent.mm.chatroom.c.a();
    }
    alW();
    com.tencent.mm.chatroom.c.a locala = grl;
    AppMethodBeat.o(12433);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(12434);
    com.tencent.mm.roomsdk.a.b.a("@chatroom", new a());
    EventCenter.instance.addListener(this.grk);
    EventCenter.instance.addListener(this.grf);
    EventCenter.instance.addListener(this.grj);
    EventCenter.instance.addListener(this.grg);
    EventCenter.instance.addListener(this.grh);
    EventCenter.instance.addListener(this.gri);
    com.tencent.mm.chatroom.c.a locala = alX();
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", locala.grL, true);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", locala.grL, true);
    ((e)g.af(e.class)).a("link_admin_explain", locala);
    AppMethodBeat.o(12434);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(12435);
    EventCenter.instance.removeListener(this.grk);
    EventCenter.instance.removeListener(this.grf);
    EventCenter.instance.removeListener(this.grj);
    EventCenter.instance.removeListener(this.grg);
    EventCenter.instance.removeListener(this.grh);
    EventCenter.instance.removeListener(this.gri);
    com.tencent.mm.chatroom.c.a locala = alX();
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", locala.grL, true);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", locala.grL, true);
    ((e)g.af(e.class)).aDU("link_admin_explain");
    AppMethodBeat.o(12435);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.b
 * JD-Core Version:    0.7.0.1
 */