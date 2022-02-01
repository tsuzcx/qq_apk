package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.we;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class b
  implements ax
{
  private static com.tencent.mm.chatroom.c.a fJU;
  private com.tencent.mm.pluginsdk.c.c<mk> fJO;
  private com.tencent.mm.pluginsdk.c.c<mn> fJP;
  private com.tencent.mm.pluginsdk.c.c<mm> fJQ;
  private com.tencent.mm.pluginsdk.c.c<mr> fJR;
  private com.tencent.mm.pluginsdk.c.c<ml> fJS;
  private com.tencent.mm.sdk.b.c fJT;
  
  public b()
  {
    AppMethodBeat.i(12431);
    this.fJO = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yb()
      {
        return 181;
      }
    };
    this.fJP = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yb()
      {
        return 551;
      }
    };
    this.fJQ = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yb()
      {
        return 179;
      }
    };
    this.fJR = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yb()
      {
        return 700;
      }
    };
    this.fJS = new com.tencent.mm.pluginsdk.c.c()
    {
      public final int Yb()
      {
        return 119;
      }
    };
    this.fJT = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(12431);
  }
  
  private static b XZ()
  {
    AppMethodBeat.i(12432);
    b localb = (b)t.ap(b.class);
    AppMethodBeat.o(12432);
    return localb;
  }
  
  private static com.tencent.mm.chatroom.c.a Ya()
  {
    AppMethodBeat.i(12433);
    g.ajA().aiF();
    XZ();
    if (fJU == null)
    {
      XZ();
      fJU = new com.tencent.mm.chatroom.c.a();
    }
    XZ();
    com.tencent.mm.chatroom.c.a locala = fJU;
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
    com.tencent.mm.sdk.b.a.IbL.c(this.fJT);
    com.tencent.mm.sdk.b.a.IbL.c(this.fJO);
    com.tencent.mm.sdk.b.a.IbL.c(this.fJS);
    com.tencent.mm.sdk.b.a.IbL.c(this.fJP);
    com.tencent.mm.sdk.b.a.IbL.c(this.fJQ);
    com.tencent.mm.sdk.b.a.IbL.c(this.fJR);
    com.tencent.mm.chatroom.c.a locala = Ya();
    ((r)g.ad(r.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", locala.fKw, true);
    ((r)g.ad(r.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", locala.fKw, true);
    ((e)g.ab(e.class)).a("link_admin_explain", locala);
    AppMethodBeat.o(12434);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(12435);
    com.tencent.mm.sdk.b.a.IbL.d(this.fJT);
    com.tencent.mm.sdk.b.a.IbL.d(this.fJO);
    com.tencent.mm.sdk.b.a.IbL.d(this.fJS);
    com.tencent.mm.sdk.b.a.IbL.d(this.fJP);
    com.tencent.mm.sdk.b.a.IbL.d(this.fJQ);
    com.tencent.mm.sdk.b.a.IbL.d(this.fJR);
    com.tencent.mm.chatroom.c.a locala = Ya();
    ((r)g.ad(r.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", locala.fKw, true);
    ((r)g.ad(r.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", locala.fKw, true);
    ((e)g.ab(e.class)).apu("link_admin_explain");
    AppMethodBeat.o(12435);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.b
 * JD-Core Version:    0.7.0.1
 */