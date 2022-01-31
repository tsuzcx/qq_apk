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
import com.tencent.mm.model.an;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.List;

final class j$1
  implements ap.a
{
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(124698);
    j.EU();
    Object localObject1;
    Object localObject2;
    if ((j.access$000() == 1) || (j.access$000() == 16) || (j.access$000() % 96 == 0))
    {
      localObject1 = ah.getContext();
      localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
      ab.d("MicroMsg.SubCoreAccountSync", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", new Object[] { ((ComponentName)localObject2).getClassName() });
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
        s.c localc = com.tencent.mm.bp.a.br((Context)localObject1, "reminder_channel_id");
        localc.e(((Context)localObject1).getString(2131297049));
        localc.Y(com.tencent.mm.bp.a.bYt());
        localc.g(System.currentTimeMillis());
        localc.ya = ((PendingIntent)localObject2);
        localObject1 = new s.b(localc).d(((Context)localObject1).getString(2131301556)).build();
        ((Notification)localObject1).defaults |= 0x1;
        ((Notification)localObject1).flags |= 0x10;
        ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(36, (Notification)localObject1, false);
      }
      AppMethodBeat.o(124698);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.j.1
 * JD-Core Version:    0.7.0.1
 */