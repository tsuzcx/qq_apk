package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.af;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;

public final class i
{
  private static void bb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124277);
    long l = e.xr(paramString1);
    if (l == -1L)
    {
      ad.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[] { paramString1 });
      AppMethodBeat.o(124277);
      return;
    }
    int i = af.awh().mf(l).field_newUnReadCount;
    af.awh().mh(l);
    paramString1 = af.awg().bg(l);
    am localam = ((k)g.ab(k.class)).apR().aIn(paramString2);
    if (localam == null)
    {
      ad.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[] { paramString2 });
      AppMethodBeat.o(124277);
      return;
    }
    if (paramString1.ht(1))
    {
      if (localam.field_unReadMuteCount <= i)
      {
        localam.jZ(0);
        ((k)g.ab(k.class)).apR().a(localam, paramString2);
        ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
        AppMethodBeat.o(124277);
        return;
      }
      localam.jZ(localam.field_unReadMuteCount - i);
      ((k)g.ab(k.class)).apR().a(localam, paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    if (localam.field_unReadCount <= i)
    {
      ((k)g.ab(k.class)).apR().aIp(paramString2);
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    localam.jY(0);
    localam.jT(localam.field_unReadCount - i);
    ((k)g.ab(k.class)).apR().a(localam, paramString2);
    AppMethodBeat.o(124277);
  }
  
  public static void i(int paramInt, String paramString1, String paramString2)
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
      bb(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 8)
    {
      bb(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 9) {
      bb(str, paramString2);
    }
    AppMethodBeat.o(124276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.i
 * JD-Core Version:    0.7.0.1
 */