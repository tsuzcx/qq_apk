package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.pc;
import com.tencent.mm.autogen.a.pd;
import com.tencent.mm.autogen.a.pe;
import com.tencent.mm.autogen.a.pf;
import com.tencent.mm.autogen.a.pj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.event.OnSceneEndProxy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class b
  implements be
{
  private static com.tencent.mm.chatroom.c.a lxz;
  private OnSceneEndProxy<pc> lxt;
  private OnSceneEndProxy<pf> lxu;
  private OnSceneEndProxy<pe> lxv;
  private OnSceneEndProxy<pj> lxw;
  private OnSceneEndProxy<pd> lxx;
  private IListener lxy;
  
  public b()
  {
    AppMethodBeat.i(12431);
    this.lxt = new SubCoreChatroom.1(this);
    this.lxu = new SubCoreChatroom.2(this);
    this.lxv = new SubCoreChatroom.3(this);
    this.lxw = new SubCoreChatroom.4(this);
    this.lxx = new SubCoreChatroom.5(this);
    this.lxy = new SubCoreChatroom.6(this, f.hfK);
    AppMethodBeat.o(12431);
  }
  
  private static b aLT()
  {
    AppMethodBeat.i(12432);
    b localb = (b)y.aL(b.class);
    AppMethodBeat.o(12432);
    return localb;
  }
  
  private static com.tencent.mm.chatroom.c.a aLU()
  {
    AppMethodBeat.i(12433);
    h.baC().aZJ();
    aLT();
    if (lxz == null)
    {
      aLT();
      lxz = new com.tencent.mm.chatroom.c.a();
    }
    aLT();
    com.tencent.mm.chatroom.c.a locala = lxz;
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
    com.tencent.mm.roomsdk.model.b.a("@chatroom", new a());
    this.lxy.alive();
    this.lxt.alive();
    this.lxx.alive();
    this.lxu.alive();
    this.lxv.alive();
    this.lxw.alive();
    com.tencent.mm.chatroom.c.a locala = aLU();
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", locala.lxU, true);
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", locala.lxU, true);
    ((e)h.ax(e.class)).a("link_admin_explain", locala);
    AppMethodBeat.o(12434);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(12435);
    this.lxy.dead();
    this.lxt.dead();
    this.lxx.dead();
    this.lxu.dead();
    this.lxv.dead();
    this.lxw.dead();
    com.tencent.mm.chatroom.c.a locala = aLU();
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", locala.lxU, true);
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", locala.lxU, true);
    ((e)h.ax(e.class)).aLc("link_admin_explain");
    AppMethodBeat.o(12435);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.b
 * JD-Core Version:    0.7.0.1
 */