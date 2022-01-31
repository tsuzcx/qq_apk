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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;

public final class j
  implements com.tencent.mm.plugin.zero.a.b
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(18260);
    String str1 = paramString2;
    if (bo.isNullOrNil(paramString2))
    {
      paramString2 = ah.getContext();
      if (!com.tencent.mm.m.f.lA(paramString1)) {
        break label880;
      }
    }
    label356:
    label874:
    label880:
    for (int i = 2131298302;; i = 2131300746)
    {
      str1 = paramString2.getString(i);
      paramString2 = f.a.IN().ebd;
      if (!com.tencent.mm.m.f.MA()) {
        com.tencent.mm.booter.notification.e.cancel();
      }
      c localc;
      Context localContext;
      boolean bool2;
      boolean bool1;
      try
      {
        localc = paramString2.eaV;
        localContext = ah.getContext();
        ah.getContext();
        bool2 = com.tencent.mm.booter.notification.a.e.IW();
        ah.getContext();
        bool1 = com.tencent.mm.booter.notification.a.e.IU();
        ab.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (paramLong == 0L) {
          break label799;
        }
        if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(str1)) || (bo.isNullOrNil(paramString3)))
        {
          ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
          AppMethodBeat.o(18260);
          return;
        }
        if ((com.tencent.mm.m.f.Ni()) && (!com.tencent.mm.m.f.Nj()))
        {
          ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
          AppMethodBeat.o(18260);
          return;
        }
      }
      catch (Exception paramString1)
      {
        ab.e("MicroMsg.Notification.Handle", "push:notify, error");
        ab.printErrStackTrace("MicroMsg.Notification.Handle", paramString1, "", new Object[0]);
        AppMethodBeat.o(18260);
        return;
      }
      if (!com.tencent.mm.m.f.Mx())
      {
        ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
        AppMethodBeat.o(18260);
        return;
      }
      if (c.fZ(paramLong))
      {
        ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
        AppMethodBeat.o(18260);
        return;
      }
      com.tencent.mm.booter.notification.queue.b.IO().restore();
      int j = c.IJ() + 1;
      paramString2 = c.b(c.IK(), paramString1);
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
        localObject = c.IK();
        paramString2 = (String)localObject;
        if (localObject == null) {
          paramString2 = new ArrayList();
        }
        localObject = c.b(paramString2, paramString1);
        if (localObject != null) {
          break label816;
        }
        localObject = new c.a((byte)0);
        ((c.a)localObject).userName = paramString1;
        ((c.a)localObject).eaG = 1;
        paramString2.add(localObject);
        c.e(paramString2);
        c.ij(c.IJ() + 1);
        k = paramString2.size();
        if (com.tencent.mm.booter.notification.a.e.IT())
        {
          bool1 = false;
          bool2 = false;
        }
        localObject = c.II();
        m = com.tencent.mm.booter.notification.queue.b.IO().kE(paramString1);
        localc.bZK.ebJ = j;
        localc.bZK.ebI = k;
        localc.bZK.ebP = bool2;
        localc.bZK.ebO = bool1;
        boolean bool3 = com.tencent.mm.m.f.MA();
        n = com.tencent.mm.bp.a.bYt();
        paramString2 = localc.bZK;
        paramString2.ebB.a(paramString2.mContext, bool1, bool2, (Notification)localObject, null);
        i1 = paramString2.ebB.ebn;
        ab.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", new Object[] { Integer.valueOf(m), paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(k), Boolean.FALSE, Boolean.valueOf(bool3) });
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
        localPendingIntent = com.tencent.mm.booter.notification.a.d.b(localContext, m, paramString2);
        str1 = h.d(localContext, str1, bool3);
        str2 = h.a(localContext, paramString3, k, j, i, bool3);
        paramString3 = h.e(localContext, paramString3, bool3);
        if (!com.tencent.mm.m.f.MA()) {
          break label874;
        }
      }
      for (paramString2 = com.tencent.mm.booter.notification.a.a.a(localContext, com.tencent.mm.booter.notification.a.a.L(paramString1, paramString4));; paramString2 = null)
      {
        paramString2 = new NotificationItem(m, paramString1, localc.a((Notification)localObject, n, i1, localPendingIntent, str1, str2, paramString3, paramString2, paramString1));
        paramString2.eaY = paramLong;
        paramString2.eaZ = i;
        localc.a(paramString2, localc.bZK);
        com.tencent.mm.booter.notification.d.ik(localc.bZK.ebJ);
        com.tencent.mm.booter.notification.d.z(paramString1, i);
        AppMethodBeat.o(18260);
        return;
        i = paramString2.eaG;
        break;
        ((c.a)localObject).eaG += 1;
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
  
  public final void aVN()
  {
    AppMethodBeat.i(18261);
    f.a.IN();
    com.tencent.mm.booter.notification.e.n(-1, null);
    AppMethodBeat.o(18261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.j
 * JD-Core Version:    0.7.0.1
 */