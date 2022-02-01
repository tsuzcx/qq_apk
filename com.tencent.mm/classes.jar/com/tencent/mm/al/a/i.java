package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;

public final class i
{
  private static void bo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124277);
    long l = e.NM(paramString1);
    if (l == -1L)
    {
      Log.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[] { paramString1 });
      AppMethodBeat.o(124277);
      return;
    }
    int i = ag.bak().Al(l).field_newUnReadCount;
    ag.bak().An(l);
    paramString1 = ag.baj().bs(l);
    az localaz = ((l)g.af(l.class)).aST().bjY(paramString2);
    if (localaz == null)
    {
      Log.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[] { paramString2 });
      AppMethodBeat.o(124277);
      return;
    }
    if (paramString1.iE(1))
    {
      if (localaz.field_unReadMuteCount <= i)
      {
        localaz.nz(0);
        ((l)g.af(l.class)).aST().a(localaz, paramString2);
        ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
        AppMethodBeat.o(124277);
        return;
      }
      localaz.nz(localaz.field_unReadMuteCount - i);
      ((l)g.af(l.class)).aST().a(localaz, paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    if (localaz.field_unReadCount <= i)
    {
      ((l)g.af(l.class)).aST().bka(paramString2);
      ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    localaz.ny(0);
    localaz.nt(localaz.field_unReadCount - i);
    ((l)g.af(l.class)).aST().a(localaz, paramString2);
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
      bo(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 8)
    {
      bo(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 9) {
      bo(str, paramString2);
    }
    AppMethodBeat.o(124276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.a.i
 * JD-Core Version:    0.7.0.1
 */