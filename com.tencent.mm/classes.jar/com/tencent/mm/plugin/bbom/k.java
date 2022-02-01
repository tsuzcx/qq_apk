package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.booter.notification.c;
import com.tencent.mm.booter.notification.c.a;
import com.tencent.mm.booter.notification.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;

public final class k
  implements com.tencent.mm.plugin.zero.a.b
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(22366);
    String str1 = paramString2;
    if (bs.isNullOrNil(paramString2))
    {
      paramString2 = ai.getContext();
      if (!com.tencent.mm.m.f.sQ(paramString1)) {
        break label880;
      }
    }
    label356:
    label874:
    label880:
    for (int i = 2131757293;; i = 2131760347)
    {
      str1 = paramString2.getString(i);
      paramString2 = f.a.UW().foK;
      if (!com.tencent.mm.m.f.Zi()) {
        com.tencent.mm.booter.notification.e.cancel();
      }
      c localc;
      Context localContext;
      boolean bool2;
      boolean bool1;
      try
      {
        localc = paramString2.foC;
        localContext = ai.getContext();
        ai.getContext();
        bool2 = com.tencent.mm.booter.notification.a.e.Vg();
        ai.getContext();
        bool1 = com.tencent.mm.booter.notification.a.e.Vd();
        ac.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (paramLong == 0L) {
          break label799;
        }
        if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(str1)) || (bs.isNullOrNil(paramString3)))
        {
          ac.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
          AppMethodBeat.o(22366);
          return;
        }
        if ((com.tencent.mm.m.f.ZS()) && (!com.tencent.mm.m.f.ZT()))
        {
          ac.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
          AppMethodBeat.o(22366);
          return;
        }
      }
      catch (Exception paramString1)
      {
        ac.e("MicroMsg.Notification.Handle", "push:notify, error");
        ac.printErrStackTrace("MicroMsg.Notification.Handle", paramString1, "", new Object[0]);
        AppMethodBeat.o(22366);
        return;
      }
      if (!com.tencent.mm.m.f.Zf())
      {
        ac.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
        AppMethodBeat.o(22366);
        return;
      }
      if (c.oK(paramLong))
      {
        ac.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
        AppMethodBeat.o(22366);
        return;
      }
      com.tencent.mm.booter.notification.queue.b.UX().restore();
      int j = c.US() + 1;
      paramString2 = c.c(c.UT(), paramString1);
      Object localObject;
      int k;
      int m;
      int n;
      int i1;
      PendingIntent localPendingIntent;
      String str2;
      if (paramString2 == null)
      {
        i = 0;
        i += 1;
        localObject = c.UT();
        paramString2 = (String)localObject;
        if (localObject == null) {
          paramString2 = new ArrayList();
        }
        localObject = c.c(paramString2, paramString1);
        if (localObject != null) {
          break label816;
        }
        localObject = new c.a((byte)0);
        ((c.a)localObject).userName = paramString1;
        ((c.a)localObject).dkt = 1;
        paramString2.add(localObject);
        c.f(paramString2);
        c.ks(c.US() + 1);
        k = paramString2.size();
        if (com.tencent.mm.booter.notification.a.e.Vc())
        {
          bool1 = false;
          bool2 = false;
        }
        localObject = c.UR();
        m = com.tencent.mm.booter.notification.queue.b.UX().rC(paramString1);
        localc.cKI.fpp = j;
        localc.cKI.fpo = k;
        localc.cKI.fpw = bool2;
        localc.cKI.fpv = bool1;
        boolean bool3 = com.tencent.mm.m.f.Zi();
        n = com.tencent.mm.bq.a.dlN();
        paramString2 = localc.cKI;
        paramString2.fph.a(paramString2.mContext, bool1, bool2, (Notification)localObject, null);
        i1 = paramString2.fph.foT;
        ac.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", new Object[] { Integer.valueOf(m), paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(k), Boolean.FALSE, Boolean.valueOf(bool3) });
        paramString2 = new Intent(localContext, LauncherUI.class);
        paramString2.putExtra("nofification_type", "new_msg_nofification");
        paramString2.putExtra("Main_User", paramString1);
        paramString2.putExtra("MainUI_User_Last_Msg_Type", paramInt);
        paramString2.addFlags(536870912);
        paramString2.addFlags(67108864);
        if (!bool3) {
          break label831;
        }
        paramString2.putExtra("talkerCount", 1);
        paramString2.putExtra("Intro_Is_Muti_Talker", false);
        paramString2.putExtra("pushcontent_unread_count", j);
        localPendingIntent = com.tencent.mm.booter.notification.a.d.c(localContext, m, paramString2);
        str1 = h.d(localContext, str1, bool3);
        str2 = h.a(localContext, paramString3, k, j, i, bool3);
        paramString3 = h.e(localContext, paramString3, bool3);
        if (!com.tencent.mm.m.f.Zi()) {
          break label874;
        }
      }
      for (paramString2 = com.tencent.mm.booter.notification.a.a.a(localContext, com.tencent.mm.booter.notification.a.a.S(paramString1, paramString4));; paramString2 = null)
      {
        paramString2 = new NotificationItem(m, paramString1, localc.a((Notification)localObject, n, i1, localPendingIntent, str1, str2, paramString3, paramString2, paramString1));
        paramString2.foF = paramLong;
        paramString2.foG = i;
        localc.a(paramString2, localc.cKI);
        com.tencent.mm.booter.notification.d.kt(localc.cKI.fpp);
        com.tencent.mm.booter.notification.d.z(paramString1, i);
        AppMethodBeat.o(22366);
        return;
        i = paramString2.dkt;
        break;
        ((c.a)localObject).dkt += 1;
        break label356;
        if (k <= 1) {
          paramString2.putExtra("Intro_Is_Muti_Talker", false);
        }
        for (;;)
        {
          paramString2.putExtra("talkerCount", k);
          break;
          paramString2.putExtra("Intro_Is_Muti_Talker", true);
        }
      }
    }
  }
  
  public final void bIl()
  {
    AppMethodBeat.i(22367);
    f.a.UW();
    com.tencent.mm.booter.notification.e.p(-1, null);
    AppMethodBeat.o(22367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.k
 * JD-Core Version:    0.7.0.1
 */