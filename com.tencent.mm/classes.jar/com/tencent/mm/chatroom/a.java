package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.j;
import com.tencent.mm.chatroom.d.l;
import com.tencent.mm.chatroom.d.n;
import com.tencent.mm.chatroom.d.p;
import com.tencent.mm.chatroom.d.q;
import com.tencent.mm.chatroom.d.u;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.bqf;
import com.tencent.mm.protocal.protobuf.bqg;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.roomsdk.a.c.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public String TAG = "MicroMsg.DefaultChatRoom";
  
  public final com.tencent.mm.roomsdk.a.c.a D(String paramString, int paramInt)
  {
    AppMethodBeat.i(12411);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(true);
    localb.AxZ = new n(paramString, paramInt);
    AppMethodBeat.o(12411);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a E(String paramString, int paramInt)
  {
    AppMethodBeat.i(12414);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.uB(true);
    localc.ENn = new com.tencent.mm.chatroom.f.b(paramString, paramInt);
    AppMethodBeat.o(12414);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a U(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12412);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(true);
    localb.AxZ = new q(paramString1, paramString2);
    AppMethodBeat.o(12412);
    return localb;
  }
  
  public final d UL()
  {
    AppMethodBeat.i(12404);
    d locald = new d();
    AppMethodBeat.o(12404);
    return locald;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a V(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12415);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.uB(true);
    bqi localbqi = new bqi();
    localbqi.Cxe = new cmf().aEE(bt.nullAsNil(paramString1));
    localbqi.DOm = new cmf().aEE(bt.nullAsNil(paramString2));
    localc.ENn = new j.a(27, localbqi);
    AppMethodBeat.o(12415);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a X(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196562);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.uB(true);
    paramString1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramString1);
    if ((paramString1 != null) && ((int)paramString1.fId > 0))
    {
      paramString1.nb(paramString2);
      localc.ENn = new j.a(2, w.A(paramString1));
    }
    AppMethodBeat.o(196562);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12416);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(true);
    localb.AxZ = new u(paramString1, paramString2);
    AppMethodBeat.o(12416);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12405);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(true);
    localb.AxZ = new com.tencent.mm.chatroom.d.i(paramString, paramList);
    AppMethodBeat.o(12405);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12407);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(true);
    localb.AxZ = new j(paramString, paramList, paramInt);
    AppMethodBeat.o(12407);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(12406);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(true);
    localb.AxZ = new com.tencent.mm.chatroom.d.g(paramString1, paramList, paramString2);
    AppMethodBeat.o(12406);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, bl parambl)
  {
    AppMethodBeat.i(12409);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(true);
    localb.AxZ = new p(paramString1, paramList, paramString2, parambl);
    AppMethodBeat.o(12409);
    return localb;
  }
  
  public final void a(af paramaf, boolean paramBoolean)
  {
    AppMethodBeat.i(12419);
    if (paramBoolean)
    {
      w.v(paramaf);
      AppMethodBeat.o(12419);
      return;
    }
    w.z(paramaf);
    AppMethodBeat.o(12419);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(12418);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.uB(true);
    bqg localbqg = new bqg();
    localbqg.Cxb = paramString1;
    localbqg.mAQ = paramString2;
    localbqg.DOl = 1;
    if (paramBoolean) {}
    for (;;)
    {
      localbqg.vJA = i;
      localc.ENn = new j.a(49, localbqg);
      AppMethodBeat.o(12418);
      return localc;
      i = 2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12408);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(true);
    localb.AxZ = new p(paramString, paramList);
    AppMethodBeat.o(12408);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12417);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.uB(true);
    bqf localbqf = new bqf();
    localbqf.Cxb = paramString1;
    localbqf.mAQ = paramString2;
    localbqf.CVu = bt.nullAsNil(paramString3);
    localc.ENn = new j.a(48, localbqf);
    AppMethodBeat.o(12417);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a oL(String paramString)
  {
    AppMethodBeat.i(12410);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.uA(true);
    localb.AxZ = new l(paramString);
    AppMethodBeat.o(12410);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a oM(String paramString)
  {
    AppMethodBeat.i(12413);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apL().c(new com.tencent.mm.bb.c(paramString));
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.uB(true);
    localc.ENn = new com.tencent.mm.chatroom.f.c((String)com.tencent.mm.kernel.g.afB().afk().get(2, null), paramString);
    AppMethodBeat.o(12413);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.a
 * JD-Core Version:    0.7.0.1
 */