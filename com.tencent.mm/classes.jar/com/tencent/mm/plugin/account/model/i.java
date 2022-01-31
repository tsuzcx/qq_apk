package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g.a.a.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public class i
  implements ar
{
  private static int eGp = 0;
  public static i.a fjB = i.a.fjH;
  private static am fjC = null;
  private a fjA;
  private o fjD = new o()
  {
    public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
    {
      if ((bk.pm(paramAnonymousString).equals("ChangeLaunchImage")) && (paramAnonymousMap != null))
      {
        paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.BeginTime");
        paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.EndTime");
        paramAnonymousMap = (String)paramAnonymousMap.get(".sysmsg.ChangeLaunchImage.ResId.SubType");
        y.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", new Object[] { paramAnonymousString, paramAnonymousa, paramAnonymousMap });
        if (!bk.H(new String[] { paramAnonymousString, paramAnonymousa, paramAnonymousMap }))
        {
          h.nFQ.a(723L, 5L, 1L, false);
          int i = bk.ZR(paramAnonymousMap);
          if (i > 0)
          {
            paramAnonymousMap = ae.getContext().getSharedPreferences("system_config_prefs", 0);
            paramAnonymousMap.edit().putLong("new_launch_image_begin_time", bk.ZS(paramAnonymousString)).apply();
            paramAnonymousMap.edit().putInt("new_launch_image_sub_type", i).apply();
            paramAnonymousMap.edit().putLong("new_launch_image_end_time", bk.ZS(paramAnonymousa)).commit();
            b.c.clv();
            i.pX(b.eV(43, i));
          }
        }
      }
    }
  };
  private c fjE = new i.3(this);
  
  public static void a(i.a parama)
  {
    fjB = parama;
    switch (i.4.fjG[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      eGp = 0;
      if (fjC == null) {
        fjC = new am(new i.1(), true);
      }
      y.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
      fjC.S(900000L, 900000L);
      return;
    }
    if (fjC != null) {
      fjC.stopTimer();
    }
    y.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
    fjB = i.a.fjH;
    ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().wr();
    eGp = 0;
    fjC = null;
  }
  
  public final void bh(boolean paramBoolean)
  {
    this.fjA = new a();
    ((p)g.t(p.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.fjD);
    this.fjE.cqo();
    b.c.clv();
    b.DL(43);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    a locala = this.fjA;
    com.tencent.mm.sdk.b.a.udP.d(locala.fjk);
    this.fjA = null;
    ((p)g.t(p.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.fjD);
    this.fjE.dead();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.i
 * JD-Core Version:    0.7.0.1
 */