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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public class l
  implements az
{
  private static aw cji = null;
  private static int gwU;
  public static a jkv = a.jkA;
  private a jku;
  private q jkw;
  private c jkx;
  
  static
  {
    gwU = 0;
  }
  
  public l()
  {
    AppMethodBeat.i(127858);
    this.jkw = new l.3(this);
    this.jkx = new l.4(this);
    AppMethodBeat.o(127858);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127861);
    jkv = parama;
    switch (5.jkz[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127861);
      return;
      gwU = 0;
      if (cji == null) {
        cji = new aw(new aw.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(188400);
            l.access$008();
            Object localObject1;
            Object localObject2;
            if ((l.gwU == 1) || (l.gwU == 16) || (l.gwU % 96 == 0))
            {
              localObject1 = ak.getContext();
              localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
              ae.d("MicroMsg.SubCoreAccountSync", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", new Object[] { ((ComponentName)localObject2).getClassName() });
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
                s.c localc = com.tencent.mm.bq.a.bJ((Context)localObject1, "reminder_channel_id");
                localc.f(((Context)localObject1).getString(2131755866));
                localc.as(com.tencent.mm.bq.a.dzu());
                localc.i(System.currentTimeMillis());
                localc.Hl = ((PendingIntent)localObject2);
                localObject1 = new s.b(localc).e(((Context)localObject1).getString(2131761227)).build();
                ((Notification)localObject1).defaults |= 0x1;
                ((Notification)localObject1).flags |= 0x10;
                ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(36, (Notification)localObject1, false);
              }
              AppMethodBeat.o(188400);
              return true;
            }
          }
        }, true);
      }
      ae.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
      cji.ay(900000L, 900000L);
      AppMethodBeat.o(127861);
      return;
      if (cji != null) {
        cji.stopTimer();
      }
      ae.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
      jkv = a.jkA;
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(36);
      gwU = 0;
      cji = null;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(127860);
    this.jku = new a();
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.jkw);
    this.jkx.alive();
    b.fes();
    b.Zd(43);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().a(d.Fhk);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188399);
        d.fef();
        d.feg();
        AppMethodBeat.o(188399);
      }
    });
    AppMethodBeat.o(127860);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127859);
    a locala = this.jku;
    com.tencent.mm.sdk.b.a.IvT.d(locala.jkf);
    this.jku = null;
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.jkw);
    this.jkx.dead();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().b(d.Fhk);
    AppMethodBeat.o(127859);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(127857);
      jkA = new a("NONE", 0);
      jkB = new a("SENT", 1);
      jkC = new a("VERIFIED", 2);
      jkD = new a[] { jkA, jkB, jkC };
      AppMethodBeat.o(127857);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.l
 * JD-Core Version:    0.7.0.1
 */