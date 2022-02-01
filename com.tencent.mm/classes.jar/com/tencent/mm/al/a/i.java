package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;

public final class i
{
  private static void bk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124277);
    long l = e.EY(paramString1);
    if (l == -1L)
    {
      ae.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[] { paramString1 });
      AppMethodBeat.o(124277);
      return;
    }
    int i = ag.aGs().sf(l).field_newUnReadCount;
    ag.aGs().sh(l);
    paramString1 = ag.aGr().bd(l);
    au localau = ((l)g.ab(l.class)).azL().aVa(paramString2);
    if (localau == null)
    {
      ae.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[] { paramString2 });
      AppMethodBeat.o(124277);
      return;
    }
    if (paramString1.hk(1))
    {
      if (localau.field_unReadMuteCount <= i)
      {
        localau.kx(0);
        ((l)g.ab(l.class)).azL().a(localau, paramString2);
        ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
        AppMethodBeat.o(124277);
        return;
      }
      localau.kx(localau.field_unReadMuteCount - i);
      ((l)g.ab(l.class)).azL().a(localau, paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    if (localau.field_unReadCount <= i)
    {
      ((l)g.ab(l.class)).azL().aVc(paramString2);
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    localau.kw(0);
    localau.kr(localau.field_unReadCount - i);
    ((l)g.ab(l.class)).azL().a(localau, paramString2);
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
    bu.getInt(paramString1[2], 0);
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
 * Qualified Name:     com.tencent.mm.al.a.i
 * JD-Core Version:    0.7.0.1
 */