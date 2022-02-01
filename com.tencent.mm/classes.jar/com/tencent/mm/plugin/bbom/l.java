package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.booter.notification.d.a;
import com.tencent.mm.booter.notification.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;

public final class l
  implements com.tencent.mm.plugin.zero.a.b
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(22366);
    String str1 = paramString2;
    if (bu.isNullOrNil(paramString2))
    {
      paramString2 = ak.getContext();
      if (!com.tencent.mm.n.f.wb(paramString1)) {
        break label880;
      }
    }
    label356:
    label874:
    label880:
    for (int i = 2131757293;; i = 2131760347)
    {
      str1 = paramString2.getString(i);
      paramString2 = g.a.Xv().fIW;
      if (!com.tencent.mm.n.f.abR()) {
        com.tencent.mm.booter.notification.f.cancel();
      }
      com.tencent.mm.booter.notification.d locald;
      Context localContext;
      boolean bool2;
      boolean bool1;
      try
      {
        locald = paramString2.fIO;
        localContext = ak.getContext();
        ak.getContext();
        bool2 = com.tencent.mm.booter.notification.a.e.XF();
        ak.getContext();
        bool1 = com.tencent.mm.booter.notification.a.e.XC();
        ae.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (paramLong == 0L) {
          break label799;
        }
        if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(str1)) || (bu.isNullOrNil(paramString3)))
        {
          ae.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
          AppMethodBeat.o(22366);
          return;
        }
        if ((com.tencent.mm.n.f.acF()) && (!com.tencent.mm.n.f.acG()))
        {
          ae.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
          AppMethodBeat.o(22366);
          return;
        }
      }
      catch (Exception paramString1)
      {
        ae.e("MicroMsg.Notification.Handle", "push:notify, error");
        ae.printErrStackTrace("MicroMsg.Notification.Handle", paramString1, "", new Object[0]);
        AppMethodBeat.o(22366);
        return;
      }
      if (!com.tencent.mm.n.f.abO())
      {
        ae.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
        AppMethodBeat.o(22366);
        return;
      }
      if (com.tencent.mm.booter.notification.d.qX(paramLong))
      {
        ae.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
        AppMethodBeat.o(22366);
        return;
      }
      com.tencent.mm.booter.notification.queue.b.Xw().restore();
      int j = com.tencent.mm.booter.notification.d.Xr() + 1;
      paramString2 = com.tencent.mm.booter.notification.d.c(com.tencent.mm.booter.notification.d.Xs(), paramString1);
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
        localObject = com.tencent.mm.booter.notification.d.Xs();
        paramString2 = (String)localObject;
        if (localObject == null) {
          paramString2 = new ArrayList();
        }
        localObject = com.tencent.mm.booter.notification.d.c(paramString2, paramString1);
        if (localObject != null) {
          break label816;
        }
        localObject = new d.a((byte)0);
        ((d.a)localObject).userName = paramString1;
        ((d.a)localObject).dxl = 1;
        paramString2.add(localObject);
        com.tencent.mm.booter.notification.d.f(paramString2);
        com.tencent.mm.booter.notification.d.kR(com.tencent.mm.booter.notification.d.Xr() + 1);
        k = paramString2.size();
        if (com.tencent.mm.booter.notification.a.e.XB())
        {
          bool1 = false;
          bool2 = false;
        }
        localObject = com.tencent.mm.booter.notification.d.Xq();
        m = com.tencent.mm.booter.notification.queue.b.Xw().uK(paramString1);
        locald.cWS.fJB = j;
        locald.cWS.fJA = k;
        locald.cWS.fJH = bool2;
        locald.cWS.fJG = bool1;
        boolean bool3 = com.tencent.mm.n.f.abR();
        n = com.tencent.mm.bq.a.dzu();
        paramString2 = locald.cWS;
        paramString2.fJt.a(paramString2.mContext, bool1, bool2, (Notification)localObject, null);
        i1 = paramString2.fJt.fJf;
        ae.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", new Object[] { Integer.valueOf(m), paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(k), Boolean.FALSE, Boolean.valueOf(bool3) });
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
        if (!com.tencent.mm.n.f.abR()) {
          break label874;
        }
      }
      for (paramString2 = com.tencent.mm.booter.notification.a.a.a(localContext, com.tencent.mm.booter.notification.a.a.T(paramString1, paramString4));; paramString2 = null)
      {
        paramString2 = new NotificationItem(m, paramString1, locald.a((Notification)localObject, n, i1, localPendingIntent, str1, str2, paramString3, paramString2, paramString1));
        paramString2.fIR = paramLong;
        paramString2.fIS = i;
        locald.a(paramString2, locald.cWS);
        com.tencent.mm.booter.notification.e.kS(locald.cWS.XJ());
        com.tencent.mm.booter.notification.e.C(paramString1, i);
        AppMethodBeat.o(22366);
        return;
        i = paramString2.dxl;
        break;
        ((d.a)localObject).dxl += 1;
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
  
  public final void bNu()
  {
    AppMethodBeat.i(22367);
    g.a.Xv();
    com.tencent.mm.booter.notification.f.p(-1, null);
    AppMethodBeat.o(22367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.l
 * JD-Core Version:    0.7.0.1
 */