package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.a.vb;
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
  private static com.tencent.mm.chatroom.c.a foq;
  private com.tencent.mm.pluginsdk.c.c<ls> fok;
  private com.tencent.mm.pluginsdk.c.c<lv> fol;
  private com.tencent.mm.pluginsdk.c.c<lu> fom;
  private com.tencent.mm.pluginsdk.c.c<lz> fon;
  private com.tencent.mm.pluginsdk.c.c<lt> foo;
  private com.tencent.mm.sdk.b.c fop;
  
  public b()
  {
    AppMethodBeat.i(12431);
    this.fok = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int UO()
      {
        return 181;
      }
    };
    this.fol = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int UO()
      {
        return 551;
      }
    };
    this.fom = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int UO()
      {
        return 179;
      }
    };
    this.fon = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int UO()
      {
        return 700;
      }
    };
    this.foo = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int UO()
      {
        return 119;
      }
    };
    this.fop = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(12431);
  }
  
  private static b UM()
  {
    AppMethodBeat.i(12432);
    b localb = (b)t.ap(b.class);
    AppMethodBeat.o(12432);
    return localb;
  }
  
  private static com.tencent.mm.chatroom.c.a UN()
  {
    AppMethodBeat.i(12433);
    g.afz().aeD();
    UM();
    if (foq == null)
    {
      UM();
      foq = new com.tencent.mm.chatroom.c.a();
    }
    UM();
    com.tencent.mm.chatroom.c.a locala = foq;
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
    com.tencent.mm.sdk.b.a.ESL.c(this.fop);
    com.tencent.mm.sdk.b.a.ESL.c(this.fok);
    com.tencent.mm.sdk.b.a.ESL.c(this.foo);
    com.tencent.mm.sdk.b.a.ESL.c(this.fol);
    com.tencent.mm.sdk.b.a.ESL.c(this.fom);
    com.tencent.mm.sdk.b.a.ESL.c(this.fon);
    com.tencent.mm.chatroom.c.a locala = UN();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", locala.foB, true);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", locala.foB, true);
    ((f)g.ab(f.class)).a("link_admin_explain", locala);
    AppMethodBeat.o(12434);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(12435);
    com.tencent.mm.sdk.b.a.ESL.d(this.fop);
    com.tencent.mm.sdk.b.a.ESL.d(this.fok);
    com.tencent.mm.sdk.b.a.ESL.d(this.foo);
    com.tencent.mm.sdk.b.a.ESL.d(this.fol);
    com.tencent.mm.sdk.b.a.ESL.d(this.fom);
    com.tencent.mm.sdk.b.a.ESL.d(this.fon);
    com.tencent.mm.chatroom.c.a locala = UN();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", locala.foB, true);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", locala.foB, true);
    ((f)g.ab(f.class)).afO("link_admin_explain");
    AppMethodBeat.o(12435);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.b
 * JD-Core Version:    0.7.0.1
 */