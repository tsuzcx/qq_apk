package com.tencent.mm.openim.room;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.b.f;
import com.tencent.mm.openim.b.k;
import com.tencent.mm.openim.b.m;
import com.tencent.mm.openim.room.a.b.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import java.util.List;

public final class a
  implements com.tencent.mm.roomsdk.a.a.a
{
  public final com.tencent.mm.roomsdk.a.c.a C(String paramString1, String paramString2)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(false);
    localb.ubv = new m(paramString2, paramString1);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a F(String paramString1, String paramString2)
  {
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.mn(false);
    localc.ubx = new com.tencent.mm.openim.c.g(paramString1, paramString2);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a G(String paramString1, String paramString2)
  {
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.mn(false);
    localc.ubx = new com.tencent.mm.openim.c.b(paramString1, paramString2);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString, List<String> paramList, int paramInt)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(false);
    localb.ubv = new com.tencent.mm.openim.b.d(paramString, b.a.ad(paramList));
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2)
  {
    paramString2 = com.tencent.mm.roomsdk.a.c.a.mm(false);
    paramString2.ubv = new com.tencent.mm.openim.b.a(paramString1, b.a.ad(paramList));
    return paramString2;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a a(String paramString1, List<String> paramList, String paramString2, bi parambi)
  {
    paramString2 = com.tencent.mm.roomsdk.a.c.a.mm(false);
    paramString2.ubv = new k(paramString1, b.a.ad(paramList));
    return paramString2;
  }
  
  public final void a(ad paramad, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramad.AH();
      if (s.e(paramad))
      {
        paramad.fg(43);
        paramad.dl(com.tencent.mm.platformtools.g.oZ(paramad.Bp()));
        paramad.dm(com.tencent.mm.platformtools.g.oY(paramad.Bp()));
        paramad.jdMethod_do(com.tencent.mm.platformtools.g.oY(paramad.Bq()));
        paramad.dp(paramad.Bq());
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(paramad.field_username, paramad);
      ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.a.class)).oP(paramad.field_username);
      return;
    }
    ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.a.class)).oQ(paramad.field_username);
  }
  
  public final com.tencent.mm.roomsdk.a.c.a b(String paramString, List<String> paramList)
  {
    paramString = com.tencent.mm.roomsdk.a.c.a.mm(false);
    paramString.ubv = new com.tencent.mm.openim.b.c(b.a.ad(paramList));
    return paramString;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a c(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = com.tencent.mm.roomsdk.a.c.a.mn(false);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramString2.ubx = new com.tencent.mm.openim.c.e(paramString1, i);
      return paramString2;
    }
  }
  
  public final com.tencent.mm.roomsdk.a.c.a c(String paramString, List<String> paramList)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(false);
    localb.ubv = new k(paramString, b.a.ad(paramList));
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a eM(String paramString)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(false);
    localb.ubv = new com.tencent.mm.openim.b.e(paramString);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a eN(String paramString)
  {
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.mn(false);
    localc.ubx = new com.tencent.mm.openim.c.j(paramString);
    return localc;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a h(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = com.tencent.mm.roomsdk.a.c.a.mn(false);
    paramString2.ubx = new com.tencent.mm.openim.c.d(paramString1, paramString3);
    return paramString2;
  }
  
  public final com.tencent.mm.roomsdk.a.c.d xb()
  {
    return new com.tencent.mm.roomsdk.a.c.d();
  }
  
  public final com.tencent.mm.roomsdk.a.c.a y(String paramString, int paramInt)
  {
    com.tencent.mm.roomsdk.a.c.b localb = com.tencent.mm.roomsdk.a.c.a.mm(false);
    localb.ubv = new f(paramString, paramInt);
    return localb;
  }
  
  public final com.tencent.mm.roomsdk.a.c.a z(String paramString, int paramInt)
  {
    com.tencent.mm.roomsdk.a.c.c localc = com.tencent.mm.roomsdk.a.c.a.mn(false);
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localc.ubx = new com.tencent.mm.openim.c.c(paramString, paramInt);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a
 * JD-Core Version:    0.7.0.1
 */