package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;

public final class i
{
  private static void bk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124277);
    long l = e.Ew(paramString1);
    if (l == -1L)
    {
      ad.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[] { paramString1 });
      AppMethodBeat.o(124277);
      return;
    }
    int i = ag.aGc().rS(l).field_newUnReadCount;
    ag.aGc().rU(l);
    paramString1 = ag.aGb().bd(l);
    at localat = ((l)g.ab(l.class)).azv().aTz(paramString2);
    if (localat == null)
    {
      ad.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[] { paramString2 });
      AppMethodBeat.o(124277);
      return;
    }
    if (paramString1.hj(1))
    {
      if (localat.field_unReadMuteCount <= i)
      {
        localat.kv(0);
        ((l)g.ab(l.class)).azv().a(localat, paramString2);
        ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
        AppMethodBeat.o(124277);
        return;
      }
      localat.kv(localat.field_unReadMuteCount - i);
      ((l)g.ab(l.class)).azv().a(localat, paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    if (localat.field_unReadCount <= i)
    {
      ((l)g.ab(l.class)).azv().aTB(paramString2);
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    localat.ku(0);
    localat.kp(localat.field_unReadCount - i);
    ((l)g.ab(l.class)).azv().a(localat, paramString2);
    AppMethodBeat.o(124277);
  }
  
  public static void h(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124276);
    if (!"EnterpriseChatStatus".equals(paramString1))
    {
      AppMethodBeat.o(124276);
      return;
    }
    paramString1 = paramString2.split(";");
    paramString2 = paramString1[0];
    String str = paramString1[1];
    bt.getInt(paramString1[2], 0);
    if (paramInt == 7)
    {
      bk(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 8)
    {
      bk(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 9) {
      bk(str, paramString2);
    }
    AppMethodBeat.o(124276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.a.i
 * JD-Core Version:    0.7.0.1
 */