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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;

public final class k
  implements com.tencent.mm.plugin.zero.a.b
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(22366);
    String str1 = paramString2;
    if (bt.isNullOrNil(paramString2))
    {
      paramString2 = aj.getContext();
      if (!com.tencent.mm.m.f.pF(paramString1)) {
        break label880;
      }
    }
    label356:
    label874:
    label880:
    for (int i = 2131757293;; i = 2131760347)
    {
      str1 = paramString2.getString(i);
      paramString2 = f.a.Ub().flq;
      if (!com.tencent.mm.m.f.Yl()) {
        com.tencent.mm.booter.notification.e.cancel();
      }
      c localc;
      Context localContext;
      boolean bool2;
      boolean bool1;
      try
      {
        localc = paramString2.fli;
        localContext = aj.getContext();
        aj.getContext();
        bool2 = com.tencent.mm.booter.notification.a.e.Ul();
        aj.getContext();
        bool1 = com.tencent.mm.booter.notification.a.e.Ui();
        ad.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (paramLong == 0L) {
          break label799;
        }
        if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(str1)) || (bt.isNullOrNil(paramString3)))
        {
          ad.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
          AppMethodBeat.o(22366);
          return;
        }
        if ((com.tencent.mm.m.f.YV()) && (!com.tencent.mm.m.f.YW()))
        {
          ad.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
          AppMethodBeat.o(22366);
          return;
        }
      }
      catch (Exception paramString1)
      {
        ad.e("MicroMsg.Notification.Handle", "push:notify, error");
        ad.printErrStackTrace("MicroMsg.Notification.Handle", paramString1, "", new Object[0]);
        AppMethodBeat.o(22366);
        return;
      }
      if (!com.tencent.mm.m.f.Yi())
      {
        ad.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
        AppMethodBeat.o(22366);
        return;
      }
      if (c.li(paramLong))
      {
        ad.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
        AppMethodBeat.o(22366);
        return;
      }
      com.tencent.mm.booter.notification.queue.b.Uc().restore();
      int j = c.TX() + 1;
      paramString2 = c.c(c.TY(), paramString1);
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
        localObject = c.TY();
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
        ((c.a)localObject).dmL = 1;
        paramString2.add(localObject);
        c.e(paramString2);
        c.kv(c.TX() + 1);
        k = paramString2.size();
        if (com.tencent.mm.booter.notification.a.e.Uh())
        {
          bool1 = false;
          bool2 = false;
        }
        localObject = c.TW();
        m = com.tencent.mm.booter.notification.queue.b.Uc().ow(paramString1);
        localc.cNn.flV = j;
        localc.cNn.flU = k;
        localc.cNn.fmb = bool2;
        localc.cNn.fma = bool1;
        boolean bool3 = com.tencent.mm.m.f.Yl();
        n = com.tencent.mm.br.a.cYf();
        paramString2 = localc.cNn;
        paramString2.flN.a(paramString2.mContext, bool1, bool2, (Notification)localObject, null);
        i1 = paramString2.flN.flz;
        ad.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", new Object[] { Integer.valueOf(m), paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(k), Boolean.FALSE, Boolean.valueOf(bool3) });
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
        if (!com.tencent.mm.m.f.Yl()) {
          break label874;
        }
      }
      for (paramString2 = com.tencent.mm.booter.notification.a.a.a(localContext, com.tencent.mm.booter.notification.a.a.R(paramString1, paramString4));; paramString2 = null)
      {
        paramString2 = new NotificationItem(m, paramString1, localc.a((Notification)localObject, n, i1, localPendingIntent, str1, str2, paramString3, paramString2, paramString1));
        paramString2.fll = paramLong;
        paramString2.flm = i;
        localc.a(paramString2, localc.cNn);
        com.tencent.mm.booter.notification.d.kw(localc.cNn.flV);
        com.tencent.mm.booter.notification.d.z(paramString1, i);
        AppMethodBeat.o(22366);
        return;
        i = paramString2.dmL;
        break;
        ((c.a)localObject).dmL += 1;
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
  
  public final void bBp()
  {
    AppMethodBeat.i(22367);
    f.a.Ub();
    com.tencent.mm.booter.notification.e.p(-1, null);
    AppMethodBeat.o(22367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.k
 * JD-Core Version:    0.7.0.1
 */