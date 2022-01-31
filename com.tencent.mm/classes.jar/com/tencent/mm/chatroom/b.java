package com.tencent.mm.chatroom;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.ka;
import com.tencent.mm.h.a.kb;
import com.tencent.mm.h.a.kc;
import com.tencent.mm.h.a.kd;
import com.tencent.mm.h.a.kh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.messenger.a.e;
import java.util.HashMap;

public class b
  implements ar
{
  private static com.tencent.mm.chatroom.b.a dmu;
  private com.tencent.mm.pluginsdk.c.c<ka> dmo = new b.1(this);
  private com.tencent.mm.pluginsdk.c.c<kd> dmp = new com.tencent.mm.pluginsdk.c.c()
  {
    public final int xf()
    {
      return 551;
    }
  };
  private com.tencent.mm.pluginsdk.c.c<kc> dmq = new b.3(this);
  private com.tencent.mm.pluginsdk.c.c<kh> dmr = new com.tencent.mm.pluginsdk.c.c()
  {
    public final int xf()
    {
      return 700;
    }
  };
  private com.tencent.mm.pluginsdk.c.c<kb> dms = new b.5(this);
  private com.tencent.mm.sdk.b.c dmt = new b.6(this);
  
  private static b xc()
  {
    return (b)com.tencent.mm.model.p.B(b.class);
  }
  
  private static com.tencent.mm.chatroom.b.a xd()
  {
    g.DN().CX();
    xc();
    if (dmu == null)
    {
      xc();
      dmu = new com.tencent.mm.chatroom.b.a();
    }
    xc();
    return dmu;
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.roomsdk.a.b.a("@chatroom", new a());
    com.tencent.mm.sdk.b.a.udP.c(this.dmt);
    com.tencent.mm.sdk.b.a.udP.c(this.dmo);
    com.tencent.mm.sdk.b.a.udP.c(this.dms);
    com.tencent.mm.sdk.b.a.udP.c(this.dmp);
    com.tencent.mm.sdk.b.a.udP.c(this.dmq);
    com.tencent.mm.sdk.b.a.udP.c(this.dmr);
    com.tencent.mm.chatroom.b.a locala = xd();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", locala.dmF, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", locala.dmF, true);
    ((e)g.r(e.class)).a("link_admin_explain", locala);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.dmt);
    com.tencent.mm.sdk.b.a.udP.d(this.dmo);
    com.tencent.mm.sdk.b.a.udP.d(this.dms);
    com.tencent.mm.sdk.b.a.udP.d(this.dmp);
    com.tencent.mm.sdk.b.a.udP.d(this.dmq);
    com.tencent.mm.sdk.b.a.udP.d(this.dmr);
    com.tencent.mm.chatroom.b.a locala = xd();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", locala.dmF, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", locala.dmF, true);
    ((e)g.r(e.class)).Hb("link_admin_explain");
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.b
 * JD-Core Version:    0.7.0.1
 */