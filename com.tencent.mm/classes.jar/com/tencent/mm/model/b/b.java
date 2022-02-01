package com.tencent.mm.model.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private boolean hLG;
  public ArrayList<a> mListeners;
  
  public b()
  {
    AppMethodBeat.i(20401);
    this.mListeners = new ArrayList();
    this.hLG = false;
    AppMethodBeat.o(20401);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean3, boolean paramBoolean4, String paramString5)
  {
    AppMethodBeat.i(20410);
    bc.aCg();
    c.ajA().set(am.a.IUg, paramString3);
    bc.aCg();
    c.ajA().set(am.a.IUh, paramString4);
    bc.aCg();
    c.ajA().set(am.a.IUi, Long.valueOf(paramLong2));
    bc.aCg();
    c.ajA().set(am.a.IUj, Boolean.valueOf(paramBoolean3));
    bc.aCg();
    c.ajA().set(am.a.IUk, Boolean.valueOf(paramBoolean4));
    bc.aCg();
    c.ajA().set(am.a.IUm, paramString5);
    bc.aCg();
    c.ajA().set(am.a.IUl, Boolean.FALSE);
    bc.aCg();
    c.ajA().set(am.a.IUn, paramString1);
    bc.aCg();
    c.ajA().set(am.a.IUo, paramString2);
    bc.aCg();
    c.ajA().set(am.a.IUp, Long.valueOf(paramLong1));
    bc.aCg();
    c.ajA().set(am.a.IUq, Boolean.valueOf(paramBoolean1));
    bc.aCg();
    c.ajA().set(am.a.IUr, Boolean.valueOf(paramBoolean2));
    bc.aCg();
    c.ajA().set(am.a.IUt, Long.valueOf(bu.aRi()));
    bc.aCg();
    c.ajA().set(am.a.IUs, Boolean.FALSE);
    bc.aCg();
    c.ajA().set(am.a.IUu, Boolean.FALSE);
    bc.aCg();
    c.ajA().fuc();
    aDs();
    AppMethodBeat.o(20410);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(20413);
    ae.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[] { paramb });
    long l2 = bu.aRi();
    bc.aCg();
    long l3 = ((Long)c.ajA().get(am.a.IUt, Long.valueOf(-1L))).longValue();
    bc.aCg();
    String str = (String)c.ajA().get(am.a.IUm, "");
    long l1;
    boolean bool2;
    boolean bool1;
    if (paramb == b.hLI)
    {
      bc.aCg();
      l1 = ((Long)c.ajA().get(am.a.IUi, Long.valueOf(0L))).longValue();
      bc.aCg();
      bool2 = ((Boolean)c.ajA().get(am.a.IUl, Boolean.FALSE)).booleanValue();
      bool1 = aDq();
      paramb = aDn();
    }
    while (!bu.isNullOrNil(str)) {
      if (!str.equals(Build.FINGERPRINT))
      {
        g.yxI.idkeyStat(633L, 5L, 1L, false);
        ae.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", new Object[] { str, Build.FINGERPRINT });
        AppMethodBeat.o(20413);
        return false;
        bc.aCg();
        l1 = ((Long)c.ajA().get(am.a.IUp, Long.valueOf(0L))).longValue();
        bc.aCg();
        bool2 = ((Boolean)c.ajA().get(am.a.IUs, Boolean.FALSE)).booleanValue();
        bc.aCg();
        bool1 = ((Boolean)c.ajA().get(am.a.IUr, Boolean.FALSE)).booleanValue();
        paramb = aDk();
      }
      else
      {
        ae.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] equals current device's [%s] , should show banner", new Object[] { str, Build.FINGERPRINT });
      }
    }
    if (bu.isNullOrNil(paramb))
    {
      ae.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
      AppMethodBeat.o(20413);
      return false;
    }
    if (bool2)
    {
      ae.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
      AppMethodBeat.o(20413);
      return false;
    }
    if (l3 < 0L)
    {
      ae.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
      AppMethodBeat.o(20413);
      return false;
    }
    if ((bool1) && (!aDr()))
    {
      ae.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
      AppMethodBeat.o(20413);
      return false;
    }
    if (l1 == -1L)
    {
      ae.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
      AppMethodBeat.o(20413);
      return true;
    }
    if (l3 + l1 > l2)
    {
      ae.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
      AppMethodBeat.o(20413);
      return true;
    }
    ae.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
    AppMethodBeat.o(20413);
    return false;
  }
  
  public static String aDk()
  {
    AppMethodBeat.i(20402);
    bc.aCg();
    String str = (String)c.ajA().get(am.a.IUn, "");
    AppMethodBeat.o(20402);
    return str;
  }
  
  public static String aDl()
  {
    AppMethodBeat.i(20403);
    bc.aCg();
    String str = (String)c.ajA().get(am.a.IUo, "");
    AppMethodBeat.o(20403);
    return str;
  }
  
  public static boolean aDm()
  {
    AppMethodBeat.i(20404);
    bc.aCg();
    boolean bool = ((Boolean)c.ajA().get(am.a.IUq, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20404);
    return bool;
  }
  
  public static String aDn()
  {
    AppMethodBeat.i(20405);
    bc.aCg();
    String str = (String)c.ajA().get(am.a.IUg, "");
    AppMethodBeat.o(20405);
    return str;
  }
  
  public static String aDo()
  {
    AppMethodBeat.i(20406);
    bc.aCg();
    String str = (String)c.ajA().get(am.a.IUh, "");
    AppMethodBeat.o(20406);
    return str;
  }
  
  public static boolean aDp()
  {
    AppMethodBeat.i(20407);
    bc.aCg();
    boolean bool = ((Boolean)c.ajA().get(am.a.IUj, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20407);
    return bool;
  }
  
  private static boolean aDq()
  {
    AppMethodBeat.i(20408);
    bc.aCg();
    boolean bool = ((Boolean)c.ajA().get(am.a.IUk, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20408);
    return bool;
  }
  
  private static boolean aDr()
  {
    AppMethodBeat.i(20409);
    bc.aCg();
    boolean bool = ((Boolean)c.ajA().get(am.a.IUu, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20409);
    return bool;
  }
  
  private void aDs()
  {
    AppMethodBeat.i(20414);
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).aDu();
      }
    }
    finally
    {
      AppMethodBeat.o(20414);
    }
    AppMethodBeat.o(20414);
  }
  
  private void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(20412);
    String str4 = paramString + "chatting.";
    String str1 = bu.nullAsNil((String)paramMap.get(str4 + "fingerprint"));
    if ((str4.equals(".sysmsg.banner.monitorbanner_n.")) && (!bu.isNullOrNil(str1)))
    {
      ae.e("MicroMsg.ChattingMonitoredBannerStorage", "monitorbanner_n must NOT contain fingerprint.");
      AppMethodBeat.o(20412);
      return;
    }
    String str2 = bu.nullAsNil((String)paramMap.get(str4 + "url"));
    String str3 = bu.nullAsNil((String)paramMap.get(str4 + "wording"));
    long l1 = bu.getLong((String)paramMap.get(str4 + "duration"), 0L);
    boolean bool1;
    boolean bool2;
    label284:
    String str5;
    long l2;
    boolean bool3;
    if (bu.getInt((String)paramMap.get(str4 + "autotrigger"), 0) == 1)
    {
      bool1 = true;
      if (bu.getInt((String)paramMap.get(str4 + "closable"), 0) != 1) {
        break label619;
      }
      bool2 = true;
      paramString = paramString + "mainframe.";
      str4 = bu.nullAsNil((String)paramMap.get(paramString + "url"));
      str5 = bu.nullAsNil((String)paramMap.get(paramString + "wording"));
      l2 = bu.getLong((String)paramMap.get(paramString + "duration"), 0L);
      if (bu.getInt((String)paramMap.get(paramString + "autotrigger"), 0) != 1) {
        break label625;
      }
      bool3 = true;
      label448:
      if (bu.getInt((String)paramMap.get(paramString + "closable"), 0) != 1) {
        break label631;
      }
    }
    label619:
    label625:
    label631:
    for (boolean bool4 = true;; bool4 = false)
    {
      if ((!bu.isNullOrNil(str5)) || (!bu.isNullOrNil(str3)))
      {
        ae.d("MicroMsg.ChattingMonitoredBannerStorage", "received msg:\nchattingUrl = " + str2 + "\nchattingWording = " + str3 + "\nchattingDuration = " + l1 + "\nchattingAutotrigger = " + bool1 + "\nchattingCloseable = " + bool2 + "\nfingerPrint = " + str1);
        a(str5, str4, l2, bool4, bool3, str3, str2, l1, bool2, bool1, str1);
      }
      AppMethodBeat.o(20412);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label284;
      bool3 = false;
      break label448;
    }
  }
  
  public final void A(Map<String, String> paramMap)
  {
    AppMethodBeat.i(20411);
    if (paramMap == null)
    {
      AppMethodBeat.o(20411);
      return;
    }
    g.yxI.idkeyStat(633L, 3L, 1L, false);
    ae.d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(paramMap)));
    i(".sysmsg.banner.monitorbanner_n.", paramMap);
    i(".sysmsg.banner.monitorbanner_o.", paramMap);
    AppMethodBeat.o(20411);
  }
  
  public final void aDt()
  {
    AppMethodBeat.i(20415);
    if (aDr() != true)
    {
      ae.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
      bc.aCg();
      c.ajA().set(am.a.IUt, Long.valueOf(bu.aRi()));
      bc.aCg();
      c.ajA().set(am.a.IUu, Boolean.TRUE);
      aDs();
    }
    AppMethodBeat.o(20415);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(20416);
    if (paramb == b.hLH)
    {
      bc.aCg();
      c.ajA().set(am.a.IUs, Boolean.FALSE);
    }
    for (;;)
    {
      aDs();
      AppMethodBeat.o(20416);
      return;
      bc.aCg();
      c.ajA().set(am.a.IUl, Boolean.FALSE);
    }
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(20417);
    if (paramb == b.hLH)
    {
      bc.aCg();
      c.ajA().set(am.a.IUp, Long.valueOf(0L));
    }
    for (;;)
    {
      aDs();
      do
      {
        AppMethodBeat.o(20417);
        return;
      } while (paramb != b.hLI);
      if (!aDq())
      {
        bc.aCg();
        c.ajA().set(am.a.IUi, Long.valueOf(0L));
      }
      else
      {
        bc.aCg();
        c.ajA().set(am.a.IUl, Boolean.TRUE);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aDu();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(20400);
      hLH = new b("Main", 0);
      hLI = new b("Chatting", 1);
      hLJ = new b[] { hLH, hLI };
      AppMethodBeat.o(20400);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.b.b
 * JD-Core Version:    0.7.0.1
 */