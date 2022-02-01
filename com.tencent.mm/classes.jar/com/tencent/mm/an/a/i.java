package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;

public final class i
{
  private static void bD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124277);
    long l = e.Nh(paramString1);
    if (l == -1L)
    {
      Log.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[] { paramString1 });
      AppMethodBeat.o(124277);
      return;
    }
    paramString1 = af.bHi().iD(l);
    if (paramString1 == null)
    {
      Log.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizCvs == null:%s", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(124277);
      return;
    }
    int i = paramString1.field_newUnReadCount;
    af.bHi().iF(l);
    paramString1 = af.bHh().dW(l);
    bb localbb = ((n)h.ax(n.class)).bzG().bxM(paramString2);
    if (localbb == null)
    {
      Log.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[] { paramString2 });
      AppMethodBeat.o(124277);
      return;
    }
    if ((paramString1 != null) && (paramString1.nG(1)))
    {
      if (localbb.field_unReadMuteCount <= i)
      {
        localbb.pM(0);
        ((n)h.ax(n.class)).bzG().c(localbb, paramString2);
        ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().iH(paramString2);
        AppMethodBeat.o(124277);
        return;
      }
      localbb.pM(localbb.field_unReadMuteCount - i);
      ((n)h.ax(n.class)).bzG().c(localbb, paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    if (localbb.field_unReadCount <= i)
    {
      ((n)h.ax(n.class)).bzG().bxO(paramString2);
      ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().iH(paramString2);
      AppMethodBeat.o(124277);
      return;
    }
    localbb.pL(0);
    localbb.pG(localbb.field_unReadCount - i);
    ((n)h.ax(n.class)).bzG().c(localbb, paramString2);
    AppMethodBeat.o(124277);
  }
  
  public static void k(int paramInt, String paramString1, String paramString2)
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
      bD(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 8)
    {
      bD(str, paramString2);
      AppMethodBeat.o(124276);
      return;
    }
    if (paramInt == 9) {
      bD(str, paramString2);
    }
    AppMethodBeat.o(124276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a.i
 * JD-Core Version:    0.7.0.1
 */