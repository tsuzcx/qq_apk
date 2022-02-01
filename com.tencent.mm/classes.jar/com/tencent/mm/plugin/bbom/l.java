package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.booter.notification.d.a;
import com.tencent.mm.booter.notification.f;
import com.tencent.mm.booter.notification.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;

public final class l
  implements com.tencent.mm.plugin.zero.a.b
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(22366);
    String str1 = paramString2;
    if (Util.isNullOrNil(paramString2))
    {
      paramString2 = MMApplicationContext.getContext();
      if (!com.tencent.mm.n.g.Eq(paramString1)) {
        break label880;
      }
    }
    label356:
    label874:
    label880:
    for (int i = 2131757507;; i = 2131761792)
    {
      str1 = paramString2.getString(i);
      paramString2 = g.a.ali().gok;
      if (!com.tencent.mm.n.g.apQ()) {
        f.cancel();
      }
      com.tencent.mm.booter.notification.d locald;
      Context localContext;
      boolean bool2;
      boolean bool1;
      try
      {
        locald = paramString2.goc;
        localContext = MMApplicationContext.getContext();
        MMApplicationContext.getContext();
        bool2 = com.tencent.mm.booter.notification.a.e.als();
        MMApplicationContext.getContext();
        bool1 = com.tencent.mm.booter.notification.a.e.alp();
        Log.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (paramLong == 0L) {
          break label799;
        }
        if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(str1)) || (Util.isNullOrNil(paramString3)))
        {
          Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
          AppMethodBeat.o(22366);
          return;
        }
        if ((com.tencent.mm.n.g.aqD()) && (!com.tencent.mm.n.g.aqE()))
        {
          Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
          AppMethodBeat.o(22366);
          return;
        }
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.Notification.Handle", "push:notify, error");
        Log.printErrStackTrace("MicroMsg.Notification.Handle", paramString1, "", new Object[0]);
        AppMethodBeat.o(22366);
        return;
      }
      if (!com.tencent.mm.n.g.apN())
      {
        Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
        AppMethodBeat.o(22366);
        return;
      }
      if (com.tencent.mm.booter.notification.d.yP(paramLong))
      {
        Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
        AppMethodBeat.o(22366);
        return;
      }
      com.tencent.mm.booter.notification.queue.b.alj().restore();
      int j = com.tencent.mm.booter.notification.d.ale() + 1;
      paramString2 = com.tencent.mm.booter.notification.d.c(com.tencent.mm.booter.notification.d.alf(), paramString1);
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
        localObject = com.tencent.mm.booter.notification.d.alf();
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
        ((d.a)localObject).dOS = 1;
        paramString2.add(localObject);
        com.tencent.mm.booter.notification.d.h(paramString2);
        com.tencent.mm.booter.notification.d.nT(com.tencent.mm.booter.notification.d.ale() + 1);
        k = paramString2.size();
        if (com.tencent.mm.booter.notification.a.e.alo())
        {
          bool1 = false;
          bool2 = false;
        }
        localObject = com.tencent.mm.booter.notification.d.ald();
        m = com.tencent.mm.booter.notification.queue.b.alj().Da(paramString1);
        locald.dnt.goQ = j;
        locald.dnt.goP = k;
        locald.dnt.goW = bool2;
        locald.dnt.goV = bool1;
        boolean bool3 = com.tencent.mm.n.g.apQ();
        n = com.tencent.mm.bq.a.ezb();
        paramString2 = locald.dnt;
        paramString2.goI.a(paramString2.mContext, bool1, bool2, (Notification)localObject, null);
        i1 = paramString2.goI.gou;
        Log.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", new Object[] { Integer.valueOf(m), paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(k), Boolean.FALSE, Boolean.valueOf(bool3) });
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
        if (!com.tencent.mm.n.g.apQ()) {
          break label874;
        }
      }
      for (paramString2 = com.tencent.mm.booter.notification.a.a.a(localContext, com.tencent.mm.booter.notification.a.a.V(paramString1, paramString4));; paramString2 = null)
      {
        paramString2 = new NotificationItem(m, paramString1, locald.a((Notification)localObject, n, i1, localPendingIntent, str1, str2, paramString3, paramString2, paramString1));
        paramString2.gof = paramLong;
        paramString2.gog = i;
        locald.a(paramString2, locald.dnt);
        com.tencent.mm.booter.notification.e.nU(locald.dnt.alw());
        com.tencent.mm.booter.notification.e.D(paramString1, i);
        AppMethodBeat.o(22366);
        return;
        i = paramString2.dOS;
        break;
        ((d.a)localObject).dOS += 1;
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
  
  public final void ckp()
  {
    AppMethodBeat.i(22367);
    g.a.ali();
    f.r(-1, null);
    AppMethodBeat.o(22367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.l
 * JD-Core Version:    0.7.0.1
 */