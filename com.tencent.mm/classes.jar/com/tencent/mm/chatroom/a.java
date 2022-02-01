package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.i;
import com.tencent.mm.chatroom.d.n;
import com.tencent.mm.chatroom.d.p;
import com.tencent.mm.chatroom.d.q;
import com.tencent.mm.chatroom.d.u;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public String TAG = "MicroMsg.DefaultChatRoom";
  
  public final com.tencent.mm.roomsdk.a.c.a G(String paramString, int paramInt)
  {
    AppMethodBeat.i(12411);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(true);
    localb.ghA = new n(paramString, paramInt);
    AppMethodBeat.o(12411);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a H(String paramString, int paramInt)
  {
    AppMethodBeat.i(12414);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wx(true);
    localc.Iqt = new com.tencent.mm.chatroom.f.a(paramString, paramInt);
    AppMethodBeat.o(12414);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a X(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12412);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(true);
    localb.ghA = new q(paramString1, paramString2);
    AppMethodBeat.o(12412);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12415);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wx(true);
    cai localcai = new cai();
    localcai.FNm = new cxn().aQV(bu.nullAsNil(paramString1));
    localcai.HnM = new cxn().aQV(bu.nullAsNil(paramString2));
    localc.Iqt = new k.a(27, localcai);
    AppMethodBeat.o(12415);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.e Yi()
  {
    AppMethodBeat.i(12404);
    com.tencent.mm.roomsdk.a.c.e locale = new com.tencent.mm.roomsdk.a.c.e();
    AppMethodBeat.o(12404);
    return locale;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217094);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wx(true);
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString1);
    if ((paramString1 != null) && ((int)paramString1.ght > 0))
    {
      paramString1.tm(paramString2);
      localc.Iqt = new k.a(2, x.H(paramString1));
    }
    AppMethodBeat.o(217094);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12405);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(true);
    localb.ghA = new i(paramString, paramList);
    AppMethodBeat.o(12405);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12407);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(true);
    localb.ghA = new com.tencent.mm.chatroom.d.j(paramString, paramList, paramInt);
    AppMethodBeat.o(12407);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(217093);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(true);
    localb.ghA = new p(paramString, paramList, paramObject);
    AppMethodBeat.o(217093);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, bv parambv)
  {
    AppMethodBeat.i(12409);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(true);
    localb.ghA = new p(paramString1, paramList, paramString2, parambv);
    AppMethodBeat.o(12409);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(217092);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(true);
    localb.ghA = new com.tencent.mm.chatroom.d.g(paramString1, paramList, paramString2, paramObject);
    AppMethodBeat.o(217092);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(217091);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(true);
    localb.ghA = new i(paramString1, paramList, paramString2, paramString3);
    AppMethodBeat.o(217091);
    return localb;
  }
  
  public final void a(an paraman, boolean paramBoolean)
  {
    AppMethodBeat.i(12419);
    if (paramBoolean)
    {
      x.C(paraman);
      AppMethodBeat.o(12419);
      return;
    }
    x.G(paraman);
    AppMethodBeat.o(12419);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12416);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(true);
    localb.ghA = new u(paramString1, paramString2);
    AppMethodBeat.o(12416);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(12418);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wx(true);
    cag localcag = new cag();
    localcag.FNj = paramString1;
    localcag.nIJ = paramString2;
    localcag.HnL = 1;
    if (paramBoolean) {}
    for (;;)
    {
      localcag.yxf = i;
      localc.Iqt = new k.a(49, localcag);
      AppMethodBeat.o(12418);
      return localc;
      i = 2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12417);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.wx(true);
    caf localcaf = new caf();
    localcaf.FNj = paramString1;
    localcaf.nIJ = paramString2;
    localcaf.GnM = bu.nullAsNil(paramString3);
    localc.Iqt = new k.a(48, localcaf);
    AppMethodBeat.o(12417);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a vc(String paramString)
  {
    AppMethodBeat.i(12410);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.ww(true);
    localb.ghA = new com.tencent.mm.chatroom.d.l(paramString);
    AppMethodBeat.o(12410);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a vd(String paramString)
  {
    AppMethodBeat.i(12413);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new com.tencent.mm.ba.d(paramString));
    com.tencent.mm.roomsdk.a.c.d locald = new com.tencent.mm.roomsdk.a.c.d();
    locald.a(new com.tencent.mm.chatroom.f.b((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, null), paramString));
    AppMethodBeat.o(12413);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.a
 * JD-Core Version:    0.7.0.1
 */