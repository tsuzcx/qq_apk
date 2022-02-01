package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.i;
import com.tencent.mm.chatroom.d.n;
import com.tencent.mm.chatroom.d.p;
import com.tencent.mm.chatroom.d.q;
import com.tencent.mm.chatroom.d.u;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public String TAG = "MicroMsg.DefaultChatRoom";
  
  public final com.tencent.mm.roomsdk.a.c.a Dt(String paramString)
  {
    AppMethodBeat.i(12410);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(true);
    localb.gNg = new com.tencent.mm.chatroom.d.l(paramString);
    AppMethodBeat.o(12410);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Du(String paramString)
  {
    AppMethodBeat.i(12413);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.ba.d(paramString));
    com.tencent.mm.roomsdk.a.c.d locald = new com.tencent.mm.roomsdk.a.c.d();
    locald.a(new com.tencent.mm.chatroom.f.b((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null), paramString));
    AppMethodBeat.o(12413);
    return locald;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a H(String paramString, int paramInt)
  {
    AppMethodBeat.i(12411);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(true);
    localb.gNg = new n(paramString, paramInt);
    AppMethodBeat.o(12411);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a I(String paramString, int paramInt)
  {
    AppMethodBeat.i(12414);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.Ax(true);
    localc.NDQ = new com.tencent.mm.chatroom.f.a(paramString, paramInt);
    AppMethodBeat.o(12414);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12412);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(true);
    localb.gNg = new q(paramString1, paramString2);
    AppMethodBeat.o(12412);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12405);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(true);
    localb.gNg = new i(paramString, paramList);
    AppMethodBeat.o(12405);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12407);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(true);
    localb.gNg = new com.tencent.mm.chatroom.d.j(paramString, paramList, paramInt);
    AppMethodBeat.o(12407);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(194007);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(true);
    localb.gNg = new p(paramString, paramList, paramObject);
    AppMethodBeat.o(194007);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, ca paramca)
  {
    AppMethodBeat.i(12409);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(true);
    localb.gNg = new p(paramString1, paramList, paramString2, paramca);
    AppMethodBeat.o(12409);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(194006);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(true);
    localb.gNg = new com.tencent.mm.chatroom.d.g(paramString1, paramList, paramString2, paramObject);
    AppMethodBeat.o(194006);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194005);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(true);
    localb.gNg = new i(paramString1, paramList, paramString2, paramString3);
    AppMethodBeat.o(194005);
    return localb;
  }
  
  public final void a(as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(12419);
    if (paramBoolean)
    {
      ab.C(paramas);
      AppMethodBeat.o(12419);
      return;
    }
    ab.G(paramas);
    AppMethodBeat.o(12419);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12415);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.Ax(true);
    cpk localcpk = new cpk();
    localcpk.KGR = new dqi().bhy(Util.nullAsNil(paramString1));
    localcpk.Mvg = new dqi().bhy(Util.nullAsNil(paramString2));
    localc.NDQ = new k.a(27, localcpk);
    AppMethodBeat.o(12415);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194008);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.Ax(true);
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString1);
    if ((paramString1 != null) && ((int)paramString1.gMZ > 0))
    {
      paramString1.BD(paramString2);
      localc.NDQ = new k.a(2, ab.H(paramString1));
    }
    AppMethodBeat.o(194008);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a ac(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12416);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.Aw(true);
    localb.gNg = new u(paramString1, paramString2);
    AppMethodBeat.o(12416);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.e alV()
  {
    AppMethodBeat.i(12404);
    com.tencent.mm.roomsdk.a.c.e locale = com.tencent.mm.roomsdk.a.c.e.gvQ();
    AppMethodBeat.o(12404);
    return locale;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(12418);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.Ax(true);
    cpi localcpi = new cpi();
    localcpi.KGO = paramString1;
    localcpi.UserName = paramString2;
    localcpi.Mvf = 1;
    if (paramBoolean) {}
    for (;;)
    {
      localcpi.Cyb = i;
      localc.NDQ = new k.a(49, localcpi);
      AppMethodBeat.o(12418);
      return localc;
      i = 2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12417);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.Ax(true);
    cph localcph = new cph();
    localcph.KGO = paramString1;
    localcph.UserName = paramString2;
    localcph.Liq = Util.nullAsNil(paramString3);
    localc.NDQ = new k.a(48, localcph);
    AppMethodBeat.o(12417);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.a
 * JD-Core Version:    0.7.0.1
 */