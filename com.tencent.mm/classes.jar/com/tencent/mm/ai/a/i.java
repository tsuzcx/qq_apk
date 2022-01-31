package com.tencent.mm.ai.a;

import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;

public final class i
{
  private static void as(String paramString1, String paramString2)
  {
    long l = e.lx(paramString1);
    if (l == -1L)
    {
      y.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[] { paramString1 });
      return;
    }
    int i = z.MB().bK(l).field_newUnReadCount;
    z.MB().bM(l);
    paramString1 = z.MA().aj(l);
    ak localak = ((j)g.r(j.class)).FB().abv(paramString2);
    if (localak == null)
    {
      y.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[] { paramString2 });
      return;
    }
    if (paramString1.il(1))
    {
      if (localak.field_unReadMuteCount <= i)
      {
        localak.fE(0);
        ((j)g.r(j.class)).FB().a(localak, paramString2);
        ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
        return;
      }
      localak.fE(localak.field_unReadMuteCount - i);
      ((j)g.r(j.class)).FB().a(localak, paramString2);
      return;
    }
    if (localak.field_unReadCount <= i)
    {
      ((j)g.r(j.class)).FB().abx(paramString2);
      ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
      return;
    }
    localak.fD(0);
    localak.fy(localak.field_unReadCount - i);
    ((j)g.r(j.class)).FB().a(localak, paramString2);
  }
  
  public static void e(int paramInt, String paramString1, String paramString2)
  {
    if (!"EnterpriseChatStatus".equals(paramString1)) {}
    String str;
    do
    {
      return;
      paramString1 = paramString2.split(";");
      paramString2 = paramString1[0];
      str = paramString1[1];
      bk.getInt(paramString1[2], 0);
      if (paramInt == 7)
      {
        as(str, paramString2);
        return;
      }
      if (paramInt == 8)
      {
        as(str, paramString2);
        return;
      }
    } while (paramInt != 9);
    as(str, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.a.i
 * JD-Core Version:    0.7.0.1
 */