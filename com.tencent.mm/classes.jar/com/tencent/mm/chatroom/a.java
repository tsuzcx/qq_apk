package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.i;
import com.tencent.mm.chatroom.d.n;
import com.tencent.mm.chatroom.d.p;
import com.tencent.mm.chatroom.d.q;
import com.tencent.mm.chatroom.d.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.bzo;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.roomsdk.a.c.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public String TAG = "MicroMsg.DefaultChatRoom";
  
  public final com.tencent.mm.roomsdk.a.c.a F(String paramString, int paramInt)
  {
    AppMethodBeat.i(12411);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(true);
    localb.DqO = new n(paramString, paramInt);
    AppMethodBeat.o(12411);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a G(String paramString, int paramInt)
  {
    AppMethodBeat.i(12414);
    c localc = com.tencent.mm.roomsdk.a.c.a.wp(true);
    localc.HWl = new com.tencent.mm.chatroom.f.a(paramString, paramInt);
    AppMethodBeat.o(12414);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a X(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12412);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(true);
    localb.DqO = new q(paramString1, paramString2);
    AppMethodBeat.o(12412);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.e XY()
  {
    AppMethodBeat.i(12404);
    com.tencent.mm.roomsdk.a.c.e locale = new com.tencent.mm.roomsdk.a.c.e();
    AppMethodBeat.o(12404);
    return locale;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12415);
    c localc = com.tencent.mm.roomsdk.a.c.a.wp(true);
    bzo localbzo = new bzo();
    localbzo.FuO = new cwt().aPy(bt.nullAsNil(paramString1));
    localbzo.GUl = new cwt().aPy(bt.nullAsNil(paramString2));
    localc.HWl = new k.a(27, localbzo);
    AppMethodBeat.o(12415);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a Z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213382);
    c localc = com.tencent.mm.roomsdk.a.c.a.wp(true);
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString1);
    if ((paramString1 != null) && ((int)paramString1.gfj > 0))
    {
      paramString1.sR(paramString2);
      localc.HWl = new k.a(2, w.A(paramString1));
    }
    AppMethodBeat.o(213382);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12405);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(true);
    localb.DqO = new i(paramString, paramList);
    AppMethodBeat.o(12405);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12407);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(true);
    localb.DqO = new com.tencent.mm.chatroom.d.j(paramString, paramList, paramInt);
    AppMethodBeat.o(12407);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, Object paramObject)
  {
    AppMethodBeat.i(213381);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(true);
    localb.DqO = new p(paramString, paramList, paramObject);
    AppMethodBeat.o(213381);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, bu parambu)
  {
    AppMethodBeat.i(12409);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(true);
    localb.DqO = new p(paramString1, paramList, paramString2, parambu);
    AppMethodBeat.o(12409);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(213380);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(true);
    localb.DqO = new com.tencent.mm.chatroom.d.g(paramString1, paramList, paramString2, paramObject);
    AppMethodBeat.o(213380);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213379);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(true);
    localb.DqO = new i(paramString1, paramList, paramString2, paramString3);
    AppMethodBeat.o(213379);
    return localb;
  }
  
  public final void a(am paramam, boolean paramBoolean)
  {
    AppMethodBeat.i(12419);
    if (paramBoolean)
    {
      w.v(paramam);
      AppMethodBeat.o(12419);
      return;
    }
    w.z(paramam);
    AppMethodBeat.o(12419);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12416);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(true);
    localb.DqO = new u(paramString1, paramString2);
    AppMethodBeat.o(12416);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(12418);
    c localc = com.tencent.mm.roomsdk.a.c.a.wp(true);
    bzm localbzm = new bzm();
    localbzm.FuL = paramString1;
    localbzm.nDo = paramString2;
    localbzm.GUk = 1;
    if (paramBoolean) {}
    for (;;)
    {
      localbzm.yho = i;
      localc.HWl = new k.a(49, localbzm);
      AppMethodBeat.o(12418);
      return localc;
      i = 2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12417);
    c localc = com.tencent.mm.roomsdk.a.c.a.wp(true);
    bzl localbzl = new bzl();
    localbzl.FuL = paramString1;
    localbzl.nDo = paramString2;
    localbzl.FVn = bt.nullAsNil(paramString3);
    localc.HWl = new k.a(48, localbzl);
    AppMethodBeat.o(12417);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a uH(String paramString)
  {
    AppMethodBeat.i(12410);
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.wo(true);
    localb.DqO = new com.tencent.mm.chatroom.d.l(paramString);
    AppMethodBeat.o(12410);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a uI(String paramString)
  {
    AppMethodBeat.i(12413);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new com.tencent.mm.bb.d(paramString));
    com.tencent.mm.roomsdk.a.c.d locald = new com.tencent.mm.roomsdk.a.c.d();
    locald.e(new com.tencent.mm.chatroom.f.b((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, null), paramString));
    AppMethodBeat.o(12413);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.a
 * JD-Core Version:    0.7.0.1
 */