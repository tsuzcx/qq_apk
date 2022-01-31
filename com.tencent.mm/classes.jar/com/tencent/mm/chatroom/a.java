package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.c.h;
import com.tencent.mm.chatroom.c.k;
import com.tencent.mm.chatroom.c.m;
import com.tencent.mm.chatroom.c.n;
import com.tencent.mm.chatroom.c.o;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.roomsdk.a.c.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public String TAG = "MicroMsg.DefaultChatRoom";
  
  public final com.tencent.mm.roomsdk.a.c.a D(String paramString, int paramInt)
  {
    AppMethodBeat.i(103865);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.pB(true);
    localb.uAW = new k(paramString, paramInt);
    AppMethodBeat.o(103865);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a E(String paramString, int paramInt)
  {
    AppMethodBeat.i(103868);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.pC(true);
    localc.yjM = new com.tencent.mm.chatroom.e.b(paramString, paramInt);
    AppMethodBeat.o(103868);
    return localc;
  }
  
  public final d Ju()
  {
    AppMethodBeat.i(103858);
    d locald = new d();
    AppMethodBeat.o(103858);
    return locald;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a O(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103866);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.pB(true);
    localb.uAW = new n(paramString1, paramString2);
    AppMethodBeat.o(103866);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a P(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103869);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.pC(true);
    bds localbds = new bds();
    localbds.wow = new bwc().aoF(bo.nullAsNil(paramString1));
    localbds.xtn = new bwc().aoF(bo.nullAsNil(paramString2));
    localc.yjM = new j.a(27, localbds);
    AppMethodBeat.o(103869);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Q(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103870);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.pB(true);
    localb.uAW = new o(paramString1, paramString2);
    AppMethodBeat.o(103870);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(103861);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.pB(true);
    localb.uAW = new h(paramString, paramList, paramInt);
    AppMethodBeat.o(103861);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2)
  {
    AppMethodBeat.i(103860);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.pB(true);
    localb.uAW = new com.tencent.mm.chatroom.c.e(paramString1, paramList, paramString2);
    AppMethodBeat.o(103860);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, bi parambi)
  {
    AppMethodBeat.i(103863);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.pB(true);
    localb.uAW = new m(paramString1, paramList, paramString2, parambi);
    AppMethodBeat.o(103863);
    return localb;
  }
  
  public final void a(ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(103873);
    if (paramBoolean)
    {
      t.r(paramad);
      AppMethodBeat.o(103873);
      return;
    }
    t.u(paramad);
    AppMethodBeat.o(103873);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(103859);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.pB(true);
    localb.uAW = new com.tencent.mm.chatroom.c.g(paramString, paramList);
    AppMethodBeat.o(103859);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a c(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(103872);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.pC(true);
    bdq localbdq = new bdq();
    localbdq.wot = paramString1;
    localbdq.jJA = paramString2;
    localbdq.xtm = 1;
    if (paramBoolean) {}
    for (;;)
    {
      localbdq.qsl = i;
      localc.yjM = new j.a(49, localbdq);
      AppMethodBeat.o(103872);
      return localc;
      i = 2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a c(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(103862);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.pB(true);
    localb.uAW = new m(paramString, paramList);
    AppMethodBeat.o(103862);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a j(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(103871);
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.pC(true);
    bdp localbdp = new bdp();
    localbdp.wot = paramString1;
    localbdp.jJA = paramString2;
    localbdp.wJp = bo.nullAsNil(paramString3);
    localc.yjM = new j.a(48, localbdp);
    AppMethodBeat.o(103871);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a kT(String paramString)
  {
    AppMethodBeat.i(103864);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.pB(true);
    localb.uAW = new com.tencent.mm.chatroom.c.i(paramString);
    AppMethodBeat.o(103864);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a kU(String paramString)
  {
    AppMethodBeat.i(103867);
    ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new com.tencent.mm.az.c(paramString));
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.pC(true);
    localc.yjM = new com.tencent.mm.chatroom.e.c((String)com.tencent.mm.kernel.g.RL().Ru().get(2, null), paramString);
    AppMethodBeat.o(103867);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.a
 * JD-Core Version:    0.7.0.1
 */