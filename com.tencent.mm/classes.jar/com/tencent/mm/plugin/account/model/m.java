package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class m
  implements bd
{
  private static MTimerHandler cve = null;
  private static int hjI;
  public static a kiy = a.kiD;
  private IListener kiA;
  private a kix;
  private q kiz;
  
  static
  {
    hjI = 0;
  }
  
  public m()
  {
    AppMethodBeat.i(127858);
    this.kiz = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(196854);
        if ((Util.nullAsNil(paramAnonymousString).equals("ChangeLaunchImage")) && (paramAnonymousMap != null))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.BeginTime");
          paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.EndTime");
          paramAnonymousMap = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.ResId.SubType");
          Log.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", new Object[] { paramAnonymousString, paramAnonymousa, paramAnonymousMap });
          if (!Util.isNullOrNil(new String[] { paramAnonymousString, paramAnonymousa, paramAnonymousMap }))
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(723L, 5L, 1L, false);
            int i = Util.safeParseInt(paramAnonymousMap);
            if (i > 0)
            {
              paramAnonymousMap = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
              paramAnonymousMap.edit().putLong("new_launch_image_begin_time", Util.safeParseLong(paramAnonymousString)).apply();
              paramAnonymousMap.edit().putInt("new_launch_image_sub_type", i).apply();
              paramAnonymousMap.edit().putLong("new_launch_image_end_time", Util.safeParseLong(paramAnonymousa)).commit();
              b.gnC();
              m.To(b.kC(43, i));
            }
          }
        }
        AppMethodBeat.o(196854);
      }
    };
    this.kiA = new IListener() {};
    AppMethodBeat.o(127858);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(127861);
    kiy = parama;
    switch (5.kiC[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127861);
      return;
      hjI = 0;
      if (cve == null) {
        cve = new MTimerHandler(new m.2(), true);
      }
      Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
      cve.startTimer(900000L);
      AppMethodBeat.o(127861);
      return;
      if (cve != null) {
        cve.stopTimer();
      }
      Log.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
      kiy = a.kiD;
      ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(36);
      hjI = 0;
      cve = null;
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
    this.kix = new a();
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.kiz);
    this.kiA.alive();
    b.gnC();
    b.ahP(43);
    ((l)g.af(l.class)).aSN().add(com.tencent.mm.pluginsdk.i.a.JYc);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196852);
        com.tencent.mm.pluginsdk.i.a.gnp();
        com.tencent.mm.pluginsdk.i.a.gnq();
        AppMethodBeat.o(196852);
      }
    });
    AppMethodBeat.o(127860);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(127859);
    a locala = this.kix;
    EventCenter.instance.removeListener(locala.kih);
    this.kix = null;
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.kiz);
    this.kiA.dead();
    ((l)g.af(l.class)).aSN().remove(com.tencent.mm.pluginsdk.i.a.JYc);
    AppMethodBeat.o(127859);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(127857);
      kiD = new a("NONE", 0);
      kiE = new a("SENT", 1);
      kiF = new a("VERIFIED", 2);
      kiG = new a[] { kiD, kiE, kiF };
      AppMethodBeat.o(127857);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.m
 * JD-Core Version:    0.7.0.1
 */