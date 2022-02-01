package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.nu;
import com.tencent.mm.f.a.nv;
import com.tencent.mm.f.a.nw;
import com.tencent.mm.f.a.nx;
import com.tencent.mm.f.a.ob;
import com.tencent.mm.f.a.yp;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class b
  implements be
{
  private static com.tencent.mm.chatroom.c.a iVu;
  private c<nu> iVo;
  private c<nx> iVp;
  private c<nw> iVq;
  private c<ob> iVr;
  private c<nv> iVs;
  private IListener iVt;
  
  public b()
  {
    AppMethodBeat.i(12431);
    this.iVo = new c()
    {
      public final int arZ()
      {
        return 181;
      }
    };
    this.iVp = new c()
    {
      public final int arZ()
      {
        return 551;
      }
    };
    this.iVq = new c()
    {
      public final int arZ()
      {
        return 179;
      }
    };
    this.iVr = new c()
    {
      public final int arZ()
      {
        return 700;
      }
    };
    this.iVs = new c()
    {
      public final int arZ()
      {
        return 119;
      }
    };
    this.iVt = new IListener() {};
    AppMethodBeat.o(12431);
  }
  
  private static b arX()
  {
    AppMethodBeat.i(12432);
    b localb = (b)y.as(b.class);
    AppMethodBeat.o(12432);
    return localb;
  }
  
  private static com.tencent.mm.chatroom.c.a arY()
  {
    AppMethodBeat.i(12433);
    h.aHE().aGH();
    arX();
    if (iVu == null)
    {
      arX();
      iVu = new com.tencent.mm.chatroom.c.a();
    }
    arX();
    com.tencent.mm.chatroom.c.a locala = iVu;
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
    EventCenter.instance.addListener(this.iVt);
    EventCenter.instance.addListener(this.iVo);
    EventCenter.instance.addListener(this.iVs);
    EventCenter.instance.addListener(this.iVp);
    EventCenter.instance.addListener(this.iVq);
    EventCenter.instance.addListener(this.iVr);
    com.tencent.mm.chatroom.c.a locala = arY();
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", locala.iVX, true);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", locala.iVX, true);
    ((e)h.ae(e.class)).a("link_admin_explain", locala);
    AppMethodBeat.o(12434);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(12435);
    EventCenter.instance.removeListener(this.iVt);
    EventCenter.instance.removeListener(this.iVo);
    EventCenter.instance.removeListener(this.iVs);
    EventCenter.instance.removeListener(this.iVp);
    EventCenter.instance.removeListener(this.iVq);
    EventCenter.instance.removeListener(this.iVr);
    com.tencent.mm.chatroom.c.a locala = arY();
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", locala.iVX, true);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", locala.iVX, true);
    ((e)h.ae(e.class)).aOe("link_admin_explain");
    AppMethodBeat.o(12435);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.b
 * JD-Core Version:    0.7.0.1
 */