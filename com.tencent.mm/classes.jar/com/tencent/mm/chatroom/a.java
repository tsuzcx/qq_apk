package com.tencent.mm.chatroom;

import com.tencent.mm.chatroom.c.i;
import com.tencent.mm.chatroom.c.k;
import com.tencent.mm.chatroom.c.m;
import com.tencent.mm.chatroom.c.n;
import com.tencent.mm.chatroom.c.o;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.awz;
import com.tencent.mm.protocal.c.axa;
import com.tencent.mm.protocal.c.axc;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.roomsdk.a.c.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public String TAG = "MicroMsg.DefaultChatRoom";
  
  public final com.tencent.mm.roomsdk.a.c.a C(String paramString1, String paramString2)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(true);
    localb.ubv = new n(paramString1, paramString2);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a F(String paramString1, String paramString2)
  {
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.mn(true);
    axc localaxc = new axc();
    localaxc.svp = new bml().YI(bk.pm(paramString1));
    localaxc.ttn = new bml().YI(bk.pm(paramString2));
    localc.ubx = new i.a(27, localaxc);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a G(String paramString1, String paramString2)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(true);
    localb.ubv = new o(paramString1, paramString2);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(true);
    localb.ubv = new com.tencent.mm.chatroom.c.h(paramString, paramList, paramInt);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(true);
    localb.ubv = new com.tencent.mm.chatroom.c.e(paramString1, paramList, paramString2);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, bi parambi)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(true);
    localb.ubv = new m(paramString1, paramList, paramString2, parambi);
    return localb;
  }
  
  public final void a(ad paramad, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      s.r(paramad);
      return;
    }
    s.u(paramad);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString, List<String> paramList)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(true);
    localb.ubv = new com.tencent.mm.chatroom.c.g(paramString, paramList);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a c(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.mn(true);
    axa localaxa = new axa();
    localaxa.svm = paramString1;
    localaxa.hPY = paramString2;
    localaxa.ttm = 1;
    if (paramBoolean) {}
    for (;;)
    {
      localaxa.nFj = i;
      localc.ubx = new i.a(49, localaxa);
      return localc;
      i = 2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a c(String paramString, List<String> paramList)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(true);
    localb.ubv = new m(paramString, paramList);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a eM(String paramString)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(true);
    localb.ubv = new i(paramString);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a eN(String paramString)
  {
    ((j)com.tencent.mm.kernel.g.r(j.class)).Fv().b(new com.tencent.mm.ay.b(paramString));
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.mn(true);
    localc.ubx = new com.tencent.mm.chatroom.e.c((String)com.tencent.mm.kernel.g.DP().Dz().get(2, null), paramString);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a h(String paramString1, String paramString2, String paramString3)
  {
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.mn(true);
    awz localawz = new awz();
    localawz.svm = paramString1;
    localawz.hPY = paramString2;
    localawz.sLC = bk.pm(paramString3);
    localc.ubx = new i.a(48, localawz);
    return localc;
  }
  
  public final d xb()
  {
    return new d();
  }
  
  public final com.tencent.mm.roomsdk.a.c.a y(String paramString, int paramInt)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(true);
    localb.ubv = new k(paramString, paramInt);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a z(String paramString, int paramInt)
  {
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.mn(true);
    localc.ubx = new com.tencent.mm.chatroom.e.b(paramString, paramInt);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.a
 * JD-Core Version:    0.7.0.1
 */