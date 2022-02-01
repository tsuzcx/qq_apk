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
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public class l
  implements ax
{
  private static av cjg = null;
  private static int gun;
  public static a jhC = a.jhH;
  private a jhB;
  private q jhD;
  private c jhE;
  
  static
  {
    gun = 0;
  }
  
  public l()
  {
    AppMethodBeat.i(127858);
    this.jhD = new l.3(this);
    this.jhE = new l.4(this);
    AppMethodBeat.o(127858);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127861);
    jhC = parama;
    switch (5.jhG[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127861);
      return;
      gun = 0;
      if (cjg == null) {
        cjg = new av(new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(207109);
            l.access$008();
            Object localObject1;
            Object localObject2;
            if ((l.gun == 1) || (l.gun == 16) || (l.gun % 96 == 0))
            {
              localObject1 = aj.getContext();
              localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
              ad.d("MicroMsg.SubCoreAccountSync", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", new Object[] { ((ComponentName)localObject2).getClassName() });
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
                s.c localc = com.tencent.mm.br.a.bI((Context)localObject1, "reminder_channel_id");
                localc.f(((Context)localObject1).getString(2131755866));
                localc.as(com.tencent.mm.br.a.dwe());
                localc.i(System.currentTimeMillis());
                localc.Hl = ((PendingIntent)localObject2);
                localObject1 = new s.b(localc).e(((Context)localObject1).getString(2131761227)).build();
                ((Notification)localObject1).defaults |= 0x1;
                ((Notification)localObject1).flags |= 0x10;
                ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(36, (Notification)localObject1, false);
              }
              AppMethodBeat.o(207109);
              return true;
            }
          }
        }, true);
      }
      ad.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
      cjg.az(900000L, 900000L);
      AppMethodBeat.o(127861);
      return;
      if (cjg != null) {
        cjg.stopTimer();
      }
      ad.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
      jhC = a.jhH;
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(36);
      gun = 0;
      cjg = null;
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
    this.jhB = new a();
    ((r)g.ad(r.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.jhD);
    this.jhE.alive();
    b.faE();
    b.Yx(43);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().a(d.EOP);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207108);
        d.far();
        d.fas();
        AppMethodBeat.o(207108);
      }
    });
    AppMethodBeat.o(127860);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127859);
    a locala = this.jhB;
    com.tencent.mm.sdk.b.a.IbL.d(locala.jhm);
    this.jhB = null;
    ((r)g.ad(r.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.jhD);
    this.jhE.dead();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().b(d.EOP);
    AppMethodBeat.o(127859);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(127857);
      jhH = new a("NONE", 0);
      jhI = new a("SENT", 1);
      jhJ = new a("VERIFIED", 2);
      jhK = new a[] { jhH, jhI, jhJ };
      AppMethodBeat.o(127857);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.l
 * JD-Core Version:    0.7.0.1
 */