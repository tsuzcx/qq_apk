package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.booter.notification.c;
import com.tencent.mm.booter.notification.c.a;
import com.tencent.mm.booter.notification.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;

public final class j
  implements com.tencent.mm.plugin.zero.a.b
{
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    String str1 = paramString2;
    int i;
    if (bk.bl(paramString2))
    {
      paramString2 = ae.getContext();
      if (!com.tencent.mm.m.f.fn(paramString1)) {
        break label141;
      }
      i = R.l.chatting_roominfo_noname;
    }
    c localc;
    Context localContext;
    boolean bool2;
    boolean bool1;
    for (;;)
    {
      str1 = paramString2.getString(i);
      paramString2 = f.a.wy().djJ;
      if (!com.tencent.mm.m.f.zS()) {
        com.tencent.mm.booter.notification.e.cancel();
      }
      try
      {
        localc = paramString2.djB;
        localContext = ae.getContext();
        bool2 = com.tencent.mm.booter.notification.a.e.wH();
        bool1 = com.tencent.mm.booter.notification.a.e.wF();
        y.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (paramLong != 0L)
        {
          if ((bk.bl(paramString1)) || (bk.bl(str1)) || (bk.bl(paramString3))) {
            y.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
          }
        }
        else
        {
          return;
          label141:
          i = R.l.intro_title;
          continue;
        }
        if ((com.tencent.mm.m.f.As()) && (!com.tencent.mm.m.f.At()))
        {
          y.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
          return;
        }
      }
      catch (Exception paramString1)
      {
        y.e("MicroMsg.Notification.Handle", "push:notify, error");
        y.printErrStackTrace("MicroMsg.Notification.Handle", paramString1, "", new Object[0]);
        return;
      }
    }
    if (!com.tencent.mm.m.f.zQ())
    {
      y.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
      return;
    }
    if (c.bp(paramLong))
    {
      y.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
      return;
    }
    com.tencent.mm.booter.notification.queue.b.wz().restore();
    int j = c.wu() + 1;
    paramString2 = c.a(c.wv(), paramString1);
    Object localObject;
    label321:
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
      localObject = c.wv();
      paramString2 = (String)localObject;
      if (localObject == null) {
        paramString2 = new ArrayList();
      }
      localObject = c.a(paramString2, paramString1);
      if (localObject != null) {
        break label774;
      }
      localObject = new c.a((byte)0);
      ((c.a)localObject).userName = paramString1;
      ((c.a)localObject).djo = 1;
      paramString2.add(localObject);
      c.e(paramString2);
      c.fV(c.wu() + 1);
      k = paramString2.size();
      if (com.tencent.mm.booter.notification.a.e.wE())
      {
        bool1 = false;
        bool2 = false;
      }
      localObject = c.wt();
      m = com.tencent.mm.booter.notification.queue.b.wz().ez(paramString1);
      localc.bxJ.dko = j;
      localc.bxJ.dkn = k;
      localc.bxJ.dku = bool2;
      localc.bxJ.dkt = bool1;
      boolean bool3 = com.tencent.mm.m.f.zS();
      n = com.tencent.mm.bq.a.bSL();
      paramString2 = localc.bxJ;
      paramString2.dkg.a(paramString2.mContext, bool1, bool2, (Notification)localObject, null);
      i1 = paramString2.dkg.djT;
      y.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", new Object[] { Integer.valueOf(m), paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(false), Boolean.valueOf(bool3) });
      paramString2 = new Intent(localContext, LauncherUI.class);
      paramString2.putExtra("nofification_type", "new_msg_nofification");
      paramString2.putExtra("Main_User", paramString1);
      paramString2.putExtra("MainUI_User_Last_Msg_Type", paramInt);
      paramString2.addFlags(536870912);
      paramString2.addFlags(67108864);
      if (!bool3) {
        break label789;
      }
      paramString2.putExtra("talkerCount", 1);
      paramString2.putExtra("Intro_Is_Muti_Talker", false);
      paramString2.putExtra("pushcontent_unread_count", j);
      localPendingIntent = com.tencent.mm.booter.notification.a.d.a(localContext, m, paramString2);
      str1 = h.c(localContext, str1, bool3);
      str2 = h.a(localContext, paramString3, k, j, i, bool3);
      paramString3 = h.d(localContext, paramString3, bool3);
      if (!com.tencent.mm.m.f.zS()) {
        break label832;
      }
    }
    label774:
    label789:
    label832:
    for (paramString2 = com.tencent.mm.booter.notification.a.a.a(localContext, com.tencent.mm.booter.notification.a.a.z(paramString1, paramString4));; paramString2 = null)
    {
      paramString2 = new NotificationItem(m, paramString1, localc.a((Notification)localObject, n, i1, localPendingIntent, str1, str2, paramString3, paramString2, paramString1));
      paramString2.djE = paramLong;
      paramString2.djF = i;
      localc.a(paramString2, localc.bxJ);
      com.tencent.mm.booter.notification.d.fW(localc.bxJ.dko);
      com.tencent.mm.booter.notification.d.u(paramString1, i);
      return;
      i = paramString2.djo;
      break;
      ((c.a)localObject).djo += 1;
      break label321;
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
  
  public final void awj()
  {
    f.a.wy();
    com.tencent.mm.booter.notification.f.k(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.j
 * JD-Core Version:    0.7.0.1
 */