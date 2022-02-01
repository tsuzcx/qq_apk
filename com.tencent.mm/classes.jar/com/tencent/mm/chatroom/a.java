package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.j;
import com.tencent.mm.chatroom.d.l;
import com.tencent.mm.chatroom.d.n;
import com.tencent.mm.chatroom.d.p;
import com.tencent.mm.chatroom.d.q;
import com.tencent.mm.chatroom.d.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.buz;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.roomsdk.a.c.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public String TAG = "MicroMsg.DefaultChatRoom";
  
  public final com.tencent.mm.roomsdk.a.c.a D(String paramString, int paramInt)
  {
    AppMethodBeat.i(12411);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.vC(true);
    localb.BQv = new n(paramString, paramInt);
    AppMethodBeat.o(12411);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a E(String paramString, int paramInt)
  {
    AppMethodBeat.i(12414);
    c localc = com.tencent.mm.roomsdk.a.c.a.vD(true);
    localc.Gkz = new com.tencent.mm.chatroom.f.a(paramString, paramInt);
    AppMethodBeat.o(12414);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a V(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12412);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.vC(true);
    localb.BQv = new q(paramString1, paramString2);
    AppMethodBeat.o(12412);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.e VH()
  {
    AppMethodBeat.i(12404);
    com.tencent.mm.roomsdk.a.c.e locale = new com.tencent.mm.roomsdk.a.c.e();
    AppMethodBeat.o(12404);
    return locale;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a X(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12415);
    c localc = com.tencent.mm.roomsdk.a.c.a.vD(true);
    buz localbuz = new buz();
    localbuz.DPA = new crm().aJV(bs.nullAsNil(paramString1));
    localbuz.FkD = new crm().aJV(bs.nullAsNil(paramString2));
    localc.Gkz = new j.a(27, localbuz);
    AppMethodBeat.o(12415);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197016);
    c localc = com.tencent.mm.roomsdk.a.c.a.vD(true);
    paramString1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramString1);
    if ((paramString1 != null) && ((int)paramString1.fLJ > 0))
    {
      paramString1.qh(paramString2);
      localc.Gkz = new j.a(2, w.A(paramString1));
    }
    AppMethodBeat.o(197016);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12416);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.vC(true);
    localb.BQv = new u(paramString1, paramString2);
    AppMethodBeat.o(12416);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12405);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.vC(true);
    localb.BQv = new com.tencent.mm.chatroom.d.i(paramString, paramList);
    AppMethodBeat.o(12405);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12407);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.vC(true);
    localb.BQv = new j(paramString, paramList, paramInt);
    AppMethodBeat.o(12407);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(12406);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.vC(true);
    localb.BQv = new com.tencent.mm.chatroom.d.g(paramString1, paramList, paramString2);
    AppMethodBeat.o(12406);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, bo parambo)
  {
    AppMethodBeat.i(12409);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.vC(true);
    localb.BQv = new p(paramString1, paramList, paramString2, parambo);
    AppMethodBeat.o(12409);
    return localb;
  }
  
  public final void a(ai paramai, boolean paramBoolean)
  {
    AppMethodBeat.i(12419);
    if (paramBoolean)
    {
      w.v(paramai);
      AppMethodBeat.o(12419);
      return;
    }
    w.z(paramai);
    AppMethodBeat.o(12419);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(12418);
    c localc = com.tencent.mm.roomsdk.a.c.a.vD(true);
    bux localbux = new bux();
    localbux.DPx = paramString1;
    localbux.ncR = paramString2;
    localbux.FkC = 1;
    if (paramBoolean) {}
    for (;;)
    {
      localbux.wTE = i;
      localc.Gkz = new j.a(49, localbux);
      AppMethodBeat.o(12418);
      return localc;
      i = 2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12408);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.vC(true);
    localb.BQv = new p(paramString, paramList);
    AppMethodBeat.o(12408);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12417);
    c localc = com.tencent.mm.roomsdk.a.c.a.vD(true);
    buw localbuw = new buw();
    localbuw.DPx = paramString1;
    localbuw.ncR = paramString2;
    localbuw.Eoe = bs.nullAsNil(paramString3);
    localc.Gkz = new j.a(48, localbuw);
    AppMethodBeat.o(12417);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a rU(String paramString)
  {
    AppMethodBeat.i(12410);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.vC(true);
    localb.BQv = new l(paramString);
    AppMethodBeat.o(12410);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a rV(String paramString)
  {
    AppMethodBeat.i(12413);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new com.tencent.mm.ba.d(paramString));
    com.tencent.mm.roomsdk.a.c.d locald = new com.tencent.mm.roomsdk.a.c.d();
    locald.e(new com.tencent.mm.chatroom.f.b((String)com.tencent.mm.kernel.g.agR().agA().get(2, null), paramString));
    AppMethodBeat.o(12413);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.a
 * JD-Core Version:    0.7.0.1
 */