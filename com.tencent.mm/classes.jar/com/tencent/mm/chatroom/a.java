package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.i;
import com.tencent.mm.chatroom.d.k;
import com.tencent.mm.chatroom.d.l;
import com.tencent.mm.chatroom.d.o;
import com.tencent.mm.chatroom.d.q;
import com.tencent.mm.chatroom.d.s;
import com.tencent.mm.chatroom.d.t;
import com.tencent.mm.chatroom.d.x;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dpd;
import com.tencent.mm.protocal.protobuf.dpg;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.roomsdk.model.factory.c;
import com.tencent.mm.roomsdk.model.factory.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.model.a.a
{
  public String TAG = "MicroMsg.DefaultChatRoom";
  
  public final com.tencent.mm.roomsdk.model.factory.a CP(String paramString)
  {
    AppMethodBeat.i(12410);
    com.tencent.mm.roomsdk.model.factory.b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(true);
    localb.maU = new o(paramString);
    AppMethodBeat.o(12410);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a CQ(String paramString)
  {
    AppMethodBeat.i(12413);
    ((n)h.ax(n.class)).bzz().d(new com.tencent.mm.ay.d(paramString));
    com.tencent.mm.roomsdk.model.factory.d locald = new com.tencent.mm.roomsdk.model.factory.d();
    locald.a(new com.tencent.mm.chatroom.f.b((String)h.baE().ban().d(2, null), paramString));
    AppMethodBeat.o(12413);
    return locald;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12407);
    com.tencent.mm.roomsdk.model.factory.b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(true);
    localb.maU = new l(paramString, paramList, paramInt);
    AppMethodBeat.o(12407);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a a(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(241392);
    com.tencent.mm.roomsdk.model.factory.b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(true);
    localb.maU = new s(paramString, paramList, paramObject);
    AppMethodBeat.o(241392);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a a(String paramString1, List<String> paramList, String paramString2, cc paramcc)
  {
    AppMethodBeat.i(12409);
    com.tencent.mm.roomsdk.model.factory.b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(true);
    localb.maU = new s(paramString1, paramList, paramString2, paramcc);
    AppMethodBeat.o(12409);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a a(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(241388);
    com.tencent.mm.roomsdk.model.factory.b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(true);
    localb.maU = new i(paramString1, paramList, paramString2, paramObject);
    AppMethodBeat.o(241388);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a a(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(241384);
    com.tencent.mm.roomsdk.model.factory.b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(true);
    localb.maU = new k(paramString1, paramList, paramString2, paramString3);
    AppMethodBeat.o(241384);
    return localb;
  }
  
  public final void a(au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(12419);
    if (paramBoolean)
    {
      ab.J(paramau);
      AppMethodBeat.o(12419);
      return;
    }
    ab.N(paramau);
    AppMethodBeat.o(12419);
  }
  
  public final e aLS()
  {
    AppMethodBeat.i(12404);
    e locale = e.iRU();
    AppMethodBeat.o(12404);
    return locale;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(12411);
    com.tencent.mm.roomsdk.model.factory.b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(true);
    localb.maU = new q(paramString, paramInt);
    AppMethodBeat.o(12411);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a ai(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12412);
    com.tencent.mm.roomsdk.model.factory.b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(true);
    localb.maU = new t(paramString1, paramString2);
    AppMethodBeat.o(12412);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a aj(String paramString, int paramInt)
  {
    AppMethodBeat.i(12414);
    c localc = com.tencent.mm.roomsdk.model.factory.a.Kq(true);
    localc.acmB = new com.tencent.mm.chatroom.f.a(paramString, paramInt);
    AppMethodBeat.o(12414);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a aj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12415);
    c localc = com.tencent.mm.roomsdk.model.factory.a.Kq(true);
    dpg localdpg = new dpg();
    localdpg.YFn = new etl().btH(Util.nullAsNil(paramString1));
    localdpg.aaVK = new etl().btH(Util.nullAsNil(paramString2));
    localc.acmB = new k.a(27, localdpg);
    AppMethodBeat.o(12415);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a ak(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241416);
    c localc = com.tencent.mm.roomsdk.model.factory.a.Kq(true);
    paramString1 = ((n)h.ax(n.class)).bzA().JE(paramString1);
    if ((paramString1 != null) && ((int)paramString1.maN > 0))
    {
      paramString1.AW(paramString2);
      localc.acmB = new k.a(2, ab.P(paramString1));
    }
    AppMethodBeat.o(241416);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a al(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12416);
    com.tencent.mm.roomsdk.model.factory.b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(true);
    localb.maU = new x(paramString1, paramString2);
    AppMethodBeat.o(12416);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(12418);
    c localc = com.tencent.mm.roomsdk.model.factory.a.Kq(true);
    dpd localdpd = new dpd();
    localdpd.YFk = paramString1;
    localdpd.UserName = paramString2;
    localdpd.aaVJ = 1;
    if (paramBoolean) {}
    for (;;)
    {
      localdpd.OzH = i;
      localc.acmB = new k.a(49, localdpd);
      AppMethodBeat.o(12418);
      return localc;
      i = 2;
    }
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a b(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12405);
    com.tencent.mm.roomsdk.model.factory.b localb = com.tencent.mm.roomsdk.model.factory.a.Kp(true);
    localb.maU = new k(paramString, paramList);
    AppMethodBeat.o(12405);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.model.factory.a l(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12417);
    c localc = com.tencent.mm.roomsdk.model.factory.a.Kq(true);
    dpc localdpc = new dpc();
    localdpc.YFk = paramString1;
    localdpc.UserName = paramString2;
    localdpc.ZhN = Util.nullAsNil(paramString3);
    localc.acmB = new k.a(48, localdpc);
    AppMethodBeat.o(12417);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.a
 * JD-Core Version:    0.7.0.1
 */