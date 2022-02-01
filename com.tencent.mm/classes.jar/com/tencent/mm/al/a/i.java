package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;

public final class i
{
  private static void bj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124277);
    long l = e.Bx(paramString1);
    if (l == -1L)
    {
      ac.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[] { paramString1 });
      AppMethodBeat.o(124277);
      return;
    }
    int i = af.aCZ().pT(l).field_newUnReadCount;
    af.aCZ().pV(l);
    paramString1 = af.aCY().bd(l);
    ap localap = ((k)g.ab(k.class)).awG().aNI(paramString2);
    if (localap == null)
    {
      ac.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[] { paramString2 });
      AppMethodBeat.o(124277);
      return;
    }
    if (paramString1.hc(1))
    {
      if (localap.field_unReadMuteCount <= i)
      {
        localap.jX(0);
        ((k)g.ab(k.class)).awG().a(localap, paramString2);
        ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
        AppMethodBeat.o(124277);
        return;
      }
      localap.jX(localap.field_unReadMuteCount - i);
      ((k)g.ab(k.class)).awG().a(localap, paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    if (localap.field_unReadCount <= i)
    {
      ((k)g.ab(k.class)).awG().aNK(paramString2);
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    localap.jW(0);
    localap.jR(localap.field_unReadCount - i);
    ((k)g.ab(k.class)).awG().a(localap, paramString2);
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
    bs.getInt(paramString1[2], 0);
    if (paramInt == 7)
    {
      bj(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 8)
    {
      bj(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 9) {
      bj(str, paramString2);
    }
    AppMethodBeat.o(124276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.i
 * JD-Core Version:    0.7.0.1
 */