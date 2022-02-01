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
import androidx.core.app.f.b;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.app.f;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storagebase.h.b;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l
  implements be
{
  private static MTimerHandler eln = null;
  private static int oZt;
  public static a pWG = a.pWL;
  private a pWF;
  private t pWH;
  private IListener pWI;
  
  static
  {
    oZt = 0;
  }
  
  public l()
  {
    AppMethodBeat.i(127858);
    this.pWH = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(304857);
        if ((Util.nullAsNil(paramAnonymousString).equals("ChangeLaunchImage")) && (paramAnonymousMap != null))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.BeginTime");
          paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.EndTime");
          paramAnonymousMap = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.ResId.SubType");
          Log.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", new Object[] { paramAnonymousString, paramAnonymousa, paramAnonymousMap });
          if (!Util.isNullOrNil(new String[] { paramAnonymousString, paramAnonymousa, paramAnonymousMap }))
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(723L, 5L, 1L, false);
            int i = Util.safeParseInt(paramAnonymousMap);
            if (i > 0)
            {
              paramAnonymousMap = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
              paramAnonymousMap.edit().putLong("new_launch_image_begin_time", Util.safeParseLong(paramAnonymousString)).apply();
              paramAnonymousMap.edit().putInt("new_launch_image_sub_type", i).apply();
              paramAnonymousMap.edit().putLong("new_launch_image_end_time", Util.safeParseLong(paramAnonymousa)).commit();
              com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
              l.Tn(com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(43, i));
            }
          }
        }
        AppMethodBeat.o(304857);
      }
    };
    this.pWI = new SubCoreAccountSync.4(this, f.hfK);
    AppMethodBeat.o(127858);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127861);
    pWG = parama;
    switch (4.pWK[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127861);
      return;
      oZt = 0;
      if (eln == null) {
        eln = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(304855);
            l.access$008();
            Object localObject1;
            Object localObject2;
            if ((l.oZt == 1) || (l.oZt == 16) || (l.oZt % 96 == 0))
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
                f.d locald = com.tencent.mm.bq.a.cA((Context)localObject1, "reminder_channel_id");
                locald.l(((Context)localObject1).getString(r.j.app_pushcontent_title));
                locald.eb(com.tencent.mm.bq.a.guX());
                locald.bt(System.currentTimeMillis());
                locald.bor = ((PendingIntent)localObject2);
                localObject1 = new f.b(locald).k(((Context)localObject1).getString(r.j.message_mobile_reg_no_verify_code)).DA();
                ((Notification)localObject1).defaults |= 0x1;
                ((Notification)localObject1).flags |= 0x10;
                ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().a(36, (Notification)localObject1, false);
              }
              AppMethodBeat.o(304855);
              return true;
            }
          }
        }, true);
      }
      Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
      eln.startTimer(900000L);
      AppMethodBeat.o(127861);
      return;
      if (eln != null) {
        eln.stopTimer();
      }
      Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
      pWG = a.pWL;
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(36);
      oZt = 0;
      eln = null;
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
    this.pWF = new a();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.pWH);
    this.pWI.alive();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(43);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().add(com.tencent.mm.pluginsdk.platformtools.a.XUF);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(304856);
        Log.i("MicroMsg.SubCoreAccountSync", "onAccountPostReset is to make ContactBlackListHelper Cache");
        com.tencent.mm.pluginsdk.platformtools.a.iIW();
        com.tencent.mm.pluginsdk.platformtools.a.iIX();
        AppMethodBeat.o(304856);
      }
    });
    com.tencent.mm.plugin.account.sdk.model.a.bXO();
    AppMethodBeat.o(127860);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127859);
    this.pWF.pWp.dead();
    this.pWF = null;
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.pWH);
    this.pWI.dead();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().remove(com.tencent.mm.pluginsdk.platformtools.a.XUF);
    AppMethodBeat.o(127859);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(127857);
      pWL = new a("NONE", 0);
      pWM = new a("SENT", 1);
      pWN = new a("VERIFIED", 2);
      pWO = new a[] { pWL, pWM, pWN };
      AppMethodBeat.o(127857);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.l
 * JD-Core Version:    0.7.0.1
 */