package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.g;
import com.tencent.mm.chatroom.d.i;
import com.tencent.mm.chatroom.d.l;
import com.tencent.mm.chatroom.d.p;
import com.tencent.mm.chatroom.d.q;
import com.tencent.mm.chatroom.d.u;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.roomsdk.a.c.c;
import com.tencent.mm.roomsdk.a.c.e;
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
  
  public final com.tencent.mm.roomsdk.a.c.a Kk(String paramString)
  {
    AppMethodBeat.i(12410);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ED(true);
    localb.jxA = new l(paramString);
    AppMethodBeat.o(12410);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Kl(String paramString)
  {
    AppMethodBeat.i(12413);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbK().d(new com.tencent.mm.bd.d(paramString));
    com.tencent.mm.roomsdk.a.c.d locald = new com.tencent.mm.roomsdk.a.c.d();
    locald.a(new com.tencent.mm.chatroom.f.b((String)h.aHG().aHp().b(2, null), paramString));
    AppMethodBeat.o(12413);
    return locald;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Z(String paramString, int paramInt)
  {
    AppMethodBeat.i(12411);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ED(true);
    localb.jxA = new com.tencent.mm.chatroom.d.n(paramString, paramInt);
    AppMethodBeat.o(12411);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12405);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ED(true);
    localb.jxA = new i(paramString, paramList);
    AppMethodBeat.o(12405);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12407);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ED(true);
    localb.jxA = new com.tencent.mm.chatroom.d.j(paramString, paramList, paramInt);
    AppMethodBeat.o(12407);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(190994);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ED(true);
    localb.jxA = new p(paramString, paramList, paramObject);
    AppMethodBeat.o(190994);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, ca paramca)
  {
    AppMethodBeat.i(12409);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ED(true);
    localb.jxA = new p(paramString1, paramList, paramString2, paramca);
    AppMethodBeat.o(12409);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(190989);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ED(true);
    localb.jxA = new g(paramString1, paramList, paramString2, paramObject);
    AppMethodBeat.o(190989);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(190986);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ED(true);
    localb.jxA = new i(paramString1, paramList, paramString2, paramString3);
    AppMethodBeat.o(190986);
    return localb;
  }
  
  public final void a(as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(12419);
    if (paramBoolean)
    {
      ab.I(paramas);
      AppMethodBeat.o(12419);
      return;
    }
    ab.M(paramas);
    AppMethodBeat.o(12419);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a aa(String paramString, int paramInt)
  {
    AppMethodBeat.i(12414);
    c localc = com.tencent.mm.roomsdk.a.c.a.EE(true);
    localc.URn = new com.tencent.mm.chatroom.f.a(paramString, paramInt);
    AppMethodBeat.o(12414);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12412);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ED(true);
    localb.jxA = new q(paramString1, paramString2);
    AppMethodBeat.o(12412);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a ae(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12415);
    c localc = com.tencent.mm.roomsdk.a.c.a.EE(true);
    cya localcya = new cya();
    localcya.RIl = new eaf().btQ(Util.nullAsNil(paramString1));
    localcya.TGe = new eaf().btQ(Util.nullAsNil(paramString2));
    localc.URn = new k.a(27, localcya);
    AppMethodBeat.o(12415);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a af(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191014);
    c localc = com.tencent.mm.roomsdk.a.c.a.EE(true);
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramString1);
    if ((paramString1 != null) && ((int)paramString1.jxt > 0))
    {
      paramString1.Ir(paramString2);
      localc.URn = new k.a(2, ab.O(paramString1));
    }
    AppMethodBeat.o(191014);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a ag(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12416);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ED(true);
    localb.jxA = new u(paramString1, paramString2);
    AppMethodBeat.o(12416);
    return localb;
  }
  
  public final e arW()
  {
    AppMethodBeat.i(12404);
    e locale = e.hrO();
    AppMethodBeat.o(12404);
    return locale;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(12418);
    c localc = com.tencent.mm.roomsdk.a.c.a.EE(true);
    cxy localcxy = new cxy();
    localcxy.RIi = paramString1;
    localcxy.UserName = paramString2;
    localcxy.TGd = 1;
    if (paramBoolean) {}
    for (;;)
    {
      localcxy.Iza = i;
      localc.URn = new k.a(49, localcxy);
      AppMethodBeat.o(12418);
      return localc;
      i = 2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12417);
    c localc = com.tencent.mm.roomsdk.a.c.a.EE(true);
    cxx localcxx = new cxx();
    localcxx.RIi = paramString1;
    localcxx.UserName = paramString2;
    localcxx.SjH = Util.nullAsNil(paramString3);
    localc.URn = new k.a(48, localcxx);
    AppMethodBeat.o(12417);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.a
 * JD-Core Version:    0.7.0.1
 */