package com.tencent.mm.plugin.account.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.s.b;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.h.a.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l
  implements aw
{
  private static av cbR = null;
  private static int hyR;
  public static a ion = a.ios;
  private a iom;
  private p ioo;
  private c iop;
  
  static
  {
    hyR = 0;
  }
  
  public l()
  {
    AppMethodBeat.i(127858);
    this.ioo = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(127852);
        if ((bt.nullAsNil(paramAnonymousString).equals("ChangeLaunchImage")) && (paramAnonymousMap != null))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.BeginTime");
          paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.EndTime");
          paramAnonymousMap = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.ResId.SubType");
          ad.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", new Object[] { paramAnonymousString, paramAnonymousa, paramAnonymousMap });
          if (!bt.T(new String[] { paramAnonymousString, paramAnonymousa, paramAnonymousMap }))
          {
            h.vKh.idkeyStat(723L, 5L, 1L, false);
            int i = bt.aGh(paramAnonymousMap);
            if (i > 0)
            {
              paramAnonymousMap = aj.getContext().getSharedPreferences("system_config_prefs", 0);
              paramAnonymousMap.edit().putLong("new_launch_image_begin_time", bt.aGi(paramAnonymousString)).apply();
              paramAnonymousMap.edit().putInt("new_launch_image_sub_type", i).apply();
              paramAnonymousMap.edit().putLong("new_launch_image_end_time", bt.aGi(paramAnonymousa)).commit();
              b.ewn();
              l.Cz(b.iN(43, i));
            }
          }
        }
        AppMethodBeat.o(127852);
      }
    };
    this.iop = new c() {};
    AppMethodBeat.o(127858);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127861);
    ion = parama;
    switch (4.ior[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127861);
      return;
      hyR = 0;
      if (cbR == null) {
        cbR = new av(new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(127851);
            l.access$008();
            Object localObject1;
            Object localObject2;
            if ((l.hyR == 1) || (l.hyR == 16) || (l.hyR % 96 == 0))
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
                s.c localc = com.tencent.mm.br.a.bD((Context)localObject1, "reminder_channel_id");
                localc.f(((Context)localObject1).getString(2131755866));
                localc.as(com.tencent.mm.br.a.cYf());
                localc.g(System.currentTimeMillis());
                localc.Ew = ((PendingIntent)localObject2);
                localObject1 = new s.b(localc).e(((Context)localObject1).getString(2131761227)).build();
                ((Notification)localObject1).defaults |= 0x1;
                ((Notification)localObject1).flags |= 0x10;
                ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(36, (Notification)localObject1, false);
              }
              AppMethodBeat.o(127851);
              return true;
            }
          }
        }, true);
      }
      ad.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
      cbR.av(900000L, 900000L);
      AppMethodBeat.o(127861);
      return;
      if (cbR != null) {
        cbR.stopTimer();
      }
      ad.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
      ion = a.ios;
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(36);
      hyR = 0;
      cbR = null;
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
    this.iom = new a();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.ioo);
    this.iop.alive();
    b.ewn();
    b.Ur(43);
    AppMethodBeat.o(127860);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127859);
    a locala = this.iom;
    com.tencent.mm.sdk.b.a.ESL.d(locala.inX);
    this.iom = null;
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.ioo);
    this.iop.dead();
    AppMethodBeat.o(127859);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(127857);
      ios = new a("NONE", 0);
      iot = new a("SENT", 1);
      iou = new a("VERIFIED", 2);
      iov = new a[] { ios, iot, iou };
      AppMethodBeat.o(127857);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.l
 * JD-Core Version:    0.7.0.1
 */