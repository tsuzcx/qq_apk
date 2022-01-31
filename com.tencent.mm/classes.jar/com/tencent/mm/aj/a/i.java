package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;

public final class i
{
  private static void aM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11591);
    long l = e.st(paramString1);
    if (l == -1L)
    {
      ab.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[] { paramString1 });
      AppMethodBeat.o(11591);
      return;
    }
    int i = z.afl().gF(l).field_newUnReadCount;
    z.afl().gH(l);
    paramString1 = z.afk().aG(l);
    ak localak = ((j)g.E(j.class)).YF().arH(paramString2);
    if (localak == null)
    {
      ab.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[] { paramString2 });
      AppMethodBeat.o(11591);
      return;
    }
    if (paramString1.kY(1))
    {
      if (localak.field_unReadMuteCount <= i)
      {
        localak.hP(0);
        ((j)g.E(j.class)).YF().a(localak, paramString2);
        ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
        AppMethodBeat.o(11591);
        return;
      }
      localak.hP(localak.field_unReadMuteCount - i);
      ((j)g.E(j.class)).YF().a(localak, paramString2);
      AppMethodBeat.o(11591);
      return;
    }
    if (localak.field_unReadCount <= i)
    {
      ((j)g.E(j.class)).YF().arJ(paramString2);
      ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
      AppMethodBeat.o(11591);
      return;
    }
    localak.hO(0);
    localak.hJ(localak.field_unReadCount - i);
    ((j)g.E(j.class)).YF().a(localak, paramString2);
    AppMethodBeat.o(11591);
  }
  
  public static void h(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(11590);
    if (!"EnterpriseChatStatus".equals(paramString1))
    {
      AppMethodBeat.o(11590);
      return;
    }
    paramString1 = paramString2.split(";");
    paramString2 = paramString1[0];
    String str = paramString1[1];
    bo.getInt(paramString1[2], 0);
    if (paramInt == 7)
    {
      aM(str, paramString2);
      AppMethodBeat.o(11590);
      return;
    }
    if (paramInt == 8)
    {
      aM(str, paramString2);
      AppMethodBeat.o(11590);
      return;
    }
    if (paramInt == 9) {
      aM(str, paramString2);
    }
    AppMethodBeat.o(11590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.a.i
 * JD-Core Version:    0.7.0.1
 */