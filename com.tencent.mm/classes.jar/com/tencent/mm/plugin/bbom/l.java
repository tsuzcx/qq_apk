package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.a.d;
import com.tencent.mm.booter.notification.e.a;
import com.tencent.mm.booter.notification.f;
import com.tencent.mm.booter.notification.h.a;
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
    int i;
    if (Util.isNullOrNil(paramString2))
    {
      paramString2 = MMApplicationContext.getContext();
      if (!com.tencent.mm.k.h.DQ(paramString1)) {
        break label161;
      }
      i = R.l.gzv;
    }
    com.tencent.mm.booter.notification.e locale;
    Context localContext;
    boolean bool2;
    for (;;)
    {
      str1 = paramString2.getString(i);
      paramString2 = h.a.aLc().luq;
      if (!com.tencent.mm.k.h.aQI()) {
        com.tencent.mm.booter.notification.g.cancel();
      }
      try
      {
        locale = paramString2.lui;
        localContext = MMApplicationContext.getContext();
        MMApplicationContext.getContext();
        bool2 = com.tencent.mm.booter.notification.a.e.aLm();
        MMApplicationContext.getContext();
        bool1 = com.tencent.mm.booter.notification.a.e.aLj();
        Log.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (paramLong == 0L) {
          break label863;
        }
        if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(str1)) || (Util.isNullOrNil(paramString3)))
        {
          Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
          AppMethodBeat.o(22366);
          return;
          label161:
          i = R.l.intro_title;
        }
        else if ((com.tencent.mm.k.h.aRw()) && (!com.tencent.mm.k.h.aRx()))
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
    }
    if (!com.tencent.mm.k.h.aQF())
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
      AppMethodBeat.o(22366);
      return;
    }
    if (com.tencent.mm.booter.notification.e.hh(paramLong))
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
      AppMethodBeat.o(22366);
      return;
    }
    com.tencent.mm.booter.notification.queue.b.aLd().restore();
    int j = com.tencent.mm.booter.notification.e.aKZ() + 1;
    paramString2 = com.tencent.mm.booter.notification.e.c(com.tencent.mm.booter.notification.e.aLa(), paramString1);
    Object localObject;
    label365:
    int k;
    int m;
    boolean bool3;
    int n;
    int i1;
    if (paramString2 == null)
    {
      i = 0;
      i += 1;
      localObject = com.tencent.mm.booter.notification.e.aLa();
      paramString2 = (String)localObject;
      if (localObject == null) {
        paramString2 = new ArrayList();
      }
      localObject = com.tencent.mm.booter.notification.e.c(paramString2, paramString1);
      if (localObject != null) {
        break label880;
      }
      localObject = new e.a((byte)0);
      ((e.a)localObject).userName = paramString1;
      ((e.a)localObject).hND = 1;
      paramString2.add(localObject);
      com.tencent.mm.booter.notification.e.k(paramString2);
      com.tencent.mm.booter.notification.e.qi(com.tencent.mm.booter.notification.e.aKZ() + 1);
      k = paramString2.size();
      if (com.tencent.mm.booter.notification.a.e.aLi())
      {
        bool1 = false;
        bool2 = false;
      }
      localObject = com.tencent.mm.booter.notification.e.aKY();
      m = com.tencent.mm.booter.notification.queue.b.aLd().Cy(paramString1);
      locale.hjR.luX = j;
      locale.hjR.luW = k;
      locale.hjR.lvd = bool2;
      locale.hjR.lvc = bool1;
      bool3 = com.tencent.mm.k.h.aQI();
      n = com.tencent.mm.bq.a.guX();
      paramString2 = locale.hjR;
      paramString2.luP.a(paramString2.mContext, bool1, bool2, (Notification)localObject, null);
      i1 = paramString2.luP.luA;
      Log.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", new Object[] { Integer.valueOf(m), paramString1, Integer.valueOf(paramInt), Integer.valueOf(j), Integer.valueOf(k), Boolean.FALSE, Boolean.valueOf(bool3) });
      paramString2 = (com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class);
      if (paramString2 != null) {
        paramString2.bUW();
      }
      if ((paramString2 == null) || (!paramString2.ep(localContext))) {
        break label944;
      }
    }
    label938:
    label944:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramString2 = new Intent(localContext, LauncherUI.class);
      paramString2.putExtra("nofification_type", "new_msg_nofification");
      paramString2.putExtra("Main_User", paramString1);
      paramString2.putExtra("MainUI_User_Last_Msg_Type", paramInt);
      paramString2.putExtra("MainUI_FromFinderNotification", bool1);
      paramString2.addFlags(536870912);
      paramString2.addFlags(67108864);
      PendingIntent localPendingIntent;
      String str2;
      if (bool3)
      {
        paramString2.putExtra("talkerCount", 1);
        paramString2.putExtra("Intro_Is_Muti_Talker", false);
        paramString2.putExtra("pushcontent_unread_count", j);
        localPendingIntent = d.c(localContext, m, paramString2);
        str1 = com.tencent.mm.booter.notification.a.h.d(localContext, str1, bool3);
        str2 = com.tencent.mm.booter.notification.a.h.a(localContext, paramString3, k, j, i, bool3);
        paramString3 = com.tencent.mm.booter.notification.a.h.e(localContext, paramString3, bool3);
        if (!com.tencent.mm.k.h.aQI()) {
          break label938;
        }
      }
      for (paramString2 = com.tencent.mm.booter.notification.a.a.a(localContext, com.tencent.mm.booter.notification.a.a.af(paramString1, paramString4));; paramString2 = null)
      {
        paramString2 = new NotificationItem(m, paramString1, locale.a((Notification)localObject, n, i1, localPendingIntent, str1, str2, paramString3, paramString2, paramString1));
        paramString2.lul = paramLong;
        paramString2.lum = i;
        locale.a(paramString2, locale.hjR);
        f.qj(locale.hjR.aLq());
        f.ae(paramString1, i);
        label863:
        AppMethodBeat.o(22366);
        return;
        i = paramString2.hND;
        break;
        label880:
        ((e.a)localObject).hND += 1;
        break label365;
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
  
  public final void daw()
  {
    AppMethodBeat.i(22367);
    h.a.aLc().s(-1, null);
    AppMethodBeat.o(22367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.l
 * JD-Core Version:    0.7.0.1
 */