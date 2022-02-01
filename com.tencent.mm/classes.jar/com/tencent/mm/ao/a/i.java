package com.tencent.mm.ao.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;

public final class i
{
  private static void bs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124277);
    long l = e.Vi(paramString1);
    if (l == -1L)
    {
      Log.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[] { paramString1 });
      AppMethodBeat.o(124277);
      return;
    }
    int i = af.bjy().Gt(l).field_newUnReadCount;
    af.bjy().Gv(l);
    paramString1 = af.bjx().bF(l);
    az localaz = ((n)h.ae(n.class)).bbR().bwx(paramString2);
    if (localaz == null)
    {
      Log.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[] { paramString2 });
      AppMethodBeat.o(124277);
      return;
    }
    if (paramString1.jQ(1))
    {
      if (localaz.field_unReadMuteCount <= i)
      {
        localaz.pN(0);
        ((n)h.ae(n.class)).bbR().a(localaz, paramString2);
        ((com.tencent.mm.plugin.notification.b.a)h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().hg(paramString2);
        AppMethodBeat.o(124277);
        return;
      }
      localaz.pN(localaz.field_unReadMuteCount - i);
      ((n)h.ae(n.class)).bbR().a(localaz, paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    if (localaz.field_unReadCount <= i)
    {
      ((n)h.ae(n.class)).bbR().bwz(paramString2);
      ((com.tencent.mm.plugin.notification.b.a)h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().hg(paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    localaz.pM(0);
    localaz.pH(localaz.field_unReadCount - i);
    ((n)h.ae(n.class)).bbR().a(localaz, paramString2);
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
    Util.getInt(paramString1[2], 0);
    if (paramInt == 7)
    {
      bs(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 8)
    {
      bs(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 9) {
      bs(str, paramString2);
    }
    AppMethodBeat.o(124276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.a.i
 * JD-Core Version:    0.7.0.1
 */