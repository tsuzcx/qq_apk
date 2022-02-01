package com.tencent.mm.plugin.account.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.e.b;
import androidx.core.app.e.d;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.k.a.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;

public class l
  implements be
{
  private static MTimerHandler cts = null;
  public static a mZX = a.nac;
  private static int mgw = 0;
  private a mZW;
  private t mZY;
  private IListener mZZ;
  
  public l()
  {
    AppMethodBeat.i(127858);
    this.mZY = new l.3(this);
    this.mZZ = new IListener() {};
    AppMethodBeat.o(127858);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127861);
    mZX = parama;
    switch (5.nab[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127861);
      return;
      mgw = 0;
      if (cts == null) {
        cts = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(216727);
            l.access$008();
            Object localObject1;
            Object localObject2;
            if ((l.mgw == 1) || (l.mgw == 16) || (l.mgw % 96 == 0))
            {
              localObject1 = MMApplicationContext.getContext();
              localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
              Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", new Object[] { ((ComponentName)localObject2).getClassName() });
              if (MobileVerifyUI.class.getName().equals(((ComponentName)localObject2).getClassName())) {
                break label261;
              }
            }
            label261:
            for (int i = 1;; i = 0)
            {
              if (i != 0)
              {
                localObject2 = new Intent((Context)localObject1, MobileVerifyUI.class);
                ((Intent)localObject2).addFlags(2);
                ((Intent)localObject2).addFlags(536870912);
                ((Intent)localObject2).addFlags(67108864);
                localObject2 = PendingIntent.getActivity((Context)localObject1, 36, (Intent)localObject2, 1073741824);
                e.d locald = com.tencent.mm.bx.a.cp((Context)localObject1, "reminder_channel_id");
                locald.k(((Context)localObject1).getString(r.j.app_pushcontent_title));
                locald.bn(com.tencent.mm.bx.a.fkG());
                locald.e(System.currentTimeMillis());
                locald.Ip = ((PendingIntent)localObject2);
                localObject1 = new e.b(locald).j(((Context)localObject1).getString(r.j.message_mobile_reg_no_verify_code)).gr();
                ((Notification)localObject1).defaults |= 0x1;
                ((Notification)localObject1).flags |= 0x10;
                ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(36, (Notification)localObject1, false);
              }
              AppMethodBeat.o(216727);
              return true;
            }
          }
        }, true);
      }
      Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
      cts.startTimer(900000L);
      AppMethodBeat.o(127861);
      return;
      if (cts != null) {
        cts.stopTimer();
      }
      Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
      mZX = a.nac;
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(36);
      mgw = 0;
      cts = null;
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
    this.mZW = new a();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.mZY);
    this.mZZ.alive();
    b.hii();
    b.apP(43);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().add(com.tencent.mm.pluginsdk.j.a.QYE);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216397);
        Log.i("MicroMsg.SubCoreAccountSync", "onAccountPostReset is to make ContactBlackListHelper Cache");
        com.tencent.mm.pluginsdk.j.a.hhV();
        com.tencent.mm.pluginsdk.j.a.hhW();
        AppMethodBeat.o(216397);
      }
    });
    AppMethodBeat.o(127860);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127859);
    a locala = this.mZW;
    EventCenter.instance.removeListener(locala.mZG);
    this.mZW = null;
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.mZY);
    this.mZZ.dead();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().remove(com.tencent.mm.pluginsdk.j.a.QYE);
    AppMethodBeat.o(127859);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(127857);
      nac = new a("NONE", 0);
      nad = new a("SENT", 1);
      nae = new a("VERIFIED", 2);
      naf = new a[] { nac, nad, nae };
      AppMethodBeat.o(127857);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.l
 * JD-Core Version:    0.7.0.1
 */