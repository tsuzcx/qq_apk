package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class b
  implements az
{
  private static com.tencent.mm.chatroom.c.a fLX;
  private com.tencent.mm.pluginsdk.c.c<ml> fLR;
  private com.tencent.mm.pluginsdk.c.c<mo> fLS;
  private com.tencent.mm.pluginsdk.c.c<mn> fLT;
  private com.tencent.mm.pluginsdk.c.c<ms> fLU;
  private com.tencent.mm.pluginsdk.c.c<mm> fLV;
  private com.tencent.mm.sdk.b.c fLW;
  
  public b()
  {
    AppMethodBeat.i(12431);
    this.fLR = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yl()
      {
        return 181;
      }
    };
    this.fLS = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yl()
      {
        return 551;
      }
    };
    this.fLT = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yl()
      {
        return 179;
      }
    };
    this.fLU = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yl()
      {
        return 700;
      }
    };
    this.fLV = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yl()
      {
        return 119;
      }
    };
    this.fLW = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(12431);
  }
  
  private static b Yj()
  {
    AppMethodBeat.i(12432);
    b localb = (b)u.ap(b.class);
    AppMethodBeat.o(12432);
    return localb;
  }
  
  private static com.tencent.mm.chatroom.c.a Yk()
  {
    AppMethodBeat.i(12433);
    g.ajP().aiU();
    Yj();
    if (fLX == null)
    {
      Yj();
      fLX = new com.tencent.mm.chatroom.c.a();
    }
    Yj();
    com.tencent.mm.chatroom.c.a locala = fLX;
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
    com.tencent.mm.sdk.b.a.IvT.c(this.fLW);
    com.tencent.mm.sdk.b.a.IvT.c(this.fLR);
    com.tencent.mm.sdk.b.a.IvT.c(this.fLV);
    com.tencent.mm.sdk.b.a.IvT.c(this.fLS);
    com.tencent.mm.sdk.b.a.IvT.c(this.fLT);
    com.tencent.mm.sdk.b.a.IvT.c(this.fLU);
    com.tencent.mm.chatroom.c.a locala = Yk();
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", locala.fMz, true);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", locala.fMz, true);
    ((e)g.ab(e.class)).a("link_admin_explain", locala);
    AppMethodBeat.o(12434);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(12435);
    com.tencent.mm.sdk.b.a.IvT.d(this.fLW);
    com.tencent.mm.sdk.b.a.IvT.d(this.fLR);
    com.tencent.mm.sdk.b.a.IvT.d(this.fLV);
    com.tencent.mm.sdk.b.a.IvT.d(this.fLS);
    com.tencent.mm.sdk.b.a.IvT.d(this.fLT);
    com.tencent.mm.sdk.b.a.IvT.d(this.fLU);
    com.tencent.mm.chatroom.c.a locala = Yk();
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", locala.fMz, true);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", locala.fMz, true);
    ((e)g.ab(e.class)).aqz("link_admin_explain");
    AppMethodBeat.o(12435);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.b
 * JD-Core Version:    0.7.0.1
 */