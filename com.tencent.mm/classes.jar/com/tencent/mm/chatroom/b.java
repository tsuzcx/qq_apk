package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class b
  implements aw
{
  private static com.tencent.mm.chatroom.c.a frL;
  private com.tencent.mm.pluginsdk.c.c<mb> frF;
  private com.tencent.mm.pluginsdk.c.c<me> frG;
  private com.tencent.mm.pluginsdk.c.c<md> frH;
  private com.tencent.mm.pluginsdk.c.c<mi> frI;
  private com.tencent.mm.pluginsdk.c.c<mc> frJ;
  private com.tencent.mm.sdk.b.c frK;
  
  public b()
  {
    AppMethodBeat.i(12431);
    this.frF = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int VK()
      {
        return 181;
      }
    };
    this.frG = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int VK()
      {
        return 551;
      }
    };
    this.frH = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int VK()
      {
        return 179;
      }
    };
    this.frI = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int VK()
      {
        return 700;
      }
    };
    this.frJ = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int VK()
      {
        return 119;
      }
    };
    this.frK = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(12431);
  }
  
  private static b VI()
  {
    AppMethodBeat.i(12432);
    b localb = (b)t.ap(b.class);
    AppMethodBeat.o(12432);
    return localb;
  }
  
  private static com.tencent.mm.chatroom.c.a VJ()
  {
    AppMethodBeat.i(12433);
    g.agP().afT();
    VI();
    if (frL == null)
    {
      VI();
      frL = new com.tencent.mm.chatroom.c.a();
    }
    VI();
    com.tencent.mm.chatroom.c.a locala = frL;
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
    com.tencent.mm.sdk.b.a.GpY.c(this.frK);
    com.tencent.mm.sdk.b.a.GpY.c(this.frF);
    com.tencent.mm.sdk.b.a.GpY.c(this.frJ);
    com.tencent.mm.sdk.b.a.GpY.c(this.frG);
    com.tencent.mm.sdk.b.a.GpY.c(this.frH);
    com.tencent.mm.sdk.b.a.GpY.c(this.frI);
    com.tencent.mm.chatroom.c.a locala = VJ();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", locala.frW, true);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", locala.frW, true);
    ((f)g.ab(f.class)).a("link_admin_explain", locala);
    AppMethodBeat.o(12434);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(12435);
    com.tencent.mm.sdk.b.a.GpY.d(this.frK);
    com.tencent.mm.sdk.b.a.GpY.d(this.frF);
    com.tencent.mm.sdk.b.a.GpY.d(this.frJ);
    com.tencent.mm.sdk.b.a.GpY.d(this.frG);
    com.tencent.mm.sdk.b.a.GpY.d(this.frH);
    com.tencent.mm.sdk.b.a.GpY.d(this.frI);
    com.tencent.mm.chatroom.c.a locala = VJ();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", locala.frW, true);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", locala.frW, true);
    ((f)g.ab(f.class)).akI("link_admin_explain");
    AppMethodBeat.o(12435);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.b
 * JD-Core Version:    0.7.0.1
 */