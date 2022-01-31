package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import java.util.HashMap;

public class b
  implements at
{
  private static com.tencent.mm.chatroom.b.a edX;
  private com.tencent.mm.pluginsdk.c.c<kn> edR;
  private com.tencent.mm.pluginsdk.c.c<kq> edS;
  private com.tencent.mm.pluginsdk.c.c<kp> edT;
  private com.tencent.mm.pluginsdk.c.c<ku> edU;
  private com.tencent.mm.pluginsdk.c.c<ko> edV;
  private com.tencent.mm.sdk.b.c edW;
  
  public b()
  {
    AppMethodBeat.i(103886);
    this.edR = new b.1(this);
    this.edS = new b.2(this);
    this.edT = new b.3(this);
    this.edU = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Jx()
      {
        return 700;
      }
    };
    this.edV = new b.5(this);
    this.edW = new b.6(this);
    AppMethodBeat.o(103886);
  }
  
  private static b Jv()
  {
    AppMethodBeat.i(103887);
    b localb = (b)q.S(b.class);
    AppMethodBeat.o(103887);
    return localb;
  }
  
  private static com.tencent.mm.chatroom.b.a Jw()
  {
    AppMethodBeat.i(103888);
    g.RJ().QQ();
    Jv();
    if (edX == null)
    {
      Jv();
      edX = new com.tencent.mm.chatroom.b.a();
    }
    Jv();
    com.tencent.mm.chatroom.b.a locala = edX;
    AppMethodBeat.o(103888);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(103889);
    com.tencent.mm.roomsdk.a.b.a("@chatroom", new a());
    com.tencent.mm.sdk.b.a.ymk.c(this.edW);
    com.tencent.mm.sdk.b.a.ymk.c(this.edR);
    com.tencent.mm.sdk.b.a.ymk.c(this.edV);
    com.tencent.mm.sdk.b.a.ymk.c(this.edS);
    com.tencent.mm.sdk.b.a.ymk.c(this.edT);
    com.tencent.mm.sdk.b.a.ymk.c(this.edU);
    com.tencent.mm.chatroom.b.a locala = Jw();
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", locala.eei, true);
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", locala.eei, true);
    ((e)g.E(e.class)).a("link_admin_explain", locala);
    AppMethodBeat.o(103889);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(103890);
    com.tencent.mm.sdk.b.a.ymk.d(this.edW);
    com.tencent.mm.sdk.b.a.ymk.d(this.edR);
    com.tencent.mm.sdk.b.a.ymk.d(this.edV);
    com.tencent.mm.sdk.b.a.ymk.d(this.edS);
    com.tencent.mm.sdk.b.a.ymk.d(this.edT);
    com.tencent.mm.sdk.b.a.ymk.d(this.edU);
    com.tencent.mm.chatroom.b.a locala = Jw();
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", locala.eei, true);
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", locala.eei, true);
    ((e)g.E(e.class)).SM("link_admin_explain");
    AppMethodBeat.o(103890);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.b
 * JD-Core Version:    0.7.0.1
 */