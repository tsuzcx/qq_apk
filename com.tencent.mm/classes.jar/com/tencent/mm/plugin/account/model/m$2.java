package com.tencent.mm.plugin.account.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.s.b;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.List;

final class m$2
  implements MTimerHandler.CallBack
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(196853);
    m.access$008();
    Object localObject1;
    Object localObject2;
    if ((m.access$000() == 1) || (m.access$000() == 16) || (m.access$000() % 96 == 0))
    {
      localObject1 = MMApplicationContext.getContext();
      localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
      Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", new Object[] { ((ComponentName)localObject2).getClassName() });
      if (MobileVerifyUI.class.getName().equals(((ComponentName)localObject2).getClassName())) {
        break label259;
      }
    }
    label259:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = new Intent((Context)localObject1, MobileVerifyUI.class);
        ((Intent)localObject2).addFlags(2);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        localObject2 = PendingIntent.getActivity((Context)localObject1, 36, (Intent)localObject2, 1073741824);
        s.c localc = com.tencent.mm.bq.a.cd((Context)localObject1, "reminder_channel_id");
        localc.f(((Context)localObject1).getString(2131755955));
        localc.as(com.tencent.mm.bq.a.ezb());
        localc.i(System.currentTimeMillis());
        localc.Hv = ((PendingIntent)localObject2);
        localObject1 = new s.b(localc).e(((Context)localObject1).getString(2131763042)).build();
        ((Notification)localObject1).defaults |= 0x1;
        ((Notification)localObject1).flags |= 0x10;
        ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(36, (Notification)localObject1, false);
      }
      AppMethodBeat.o(196853);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.m.2
 * JD-Core Version:    0.7.0.1
 */