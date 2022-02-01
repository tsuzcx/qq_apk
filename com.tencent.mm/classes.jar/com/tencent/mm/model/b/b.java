package com.tencent.mm.model.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private boolean hqv;
  public ArrayList<a> mListeners;
  
  public b()
  {
    AppMethodBeat.i(20401);
    this.mListeners = new ArrayList();
    this.hqv = false;
    AppMethodBeat.o(20401);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean3, boolean paramBoolean4, String paramString5)
  {
    AppMethodBeat.i(20410);
    az.ayM();
    c.agA().set(ah.a.GNq, paramString3);
    az.ayM();
    c.agA().set(ah.a.GNr, paramString4);
    az.ayM();
    c.agA().set(ah.a.GNs, Long.valueOf(paramLong2));
    az.ayM();
    c.agA().set(ah.a.GNt, Boolean.valueOf(paramBoolean3));
    az.ayM();
    c.agA().set(ah.a.GNu, Boolean.valueOf(paramBoolean4));
    az.ayM();
    c.agA().set(ah.a.GNw, paramString5);
    az.ayM();
    c.agA().set(ah.a.GNv, Boolean.FALSE);
    az.ayM();
    c.agA().set(ah.a.GNx, paramString1);
    az.ayM();
    c.agA().set(ah.a.GNy, paramString2);
    az.ayM();
    c.agA().set(ah.a.GNz, Long.valueOf(paramLong1));
    az.ayM();
    c.agA().set(ah.a.GNA, Boolean.valueOf(paramBoolean1));
    az.ayM();
    c.agA().set(ah.a.GNB, Boolean.valueOf(paramBoolean2));
    az.ayM();
    c.agA().set(ah.a.GND, Long.valueOf(bs.aNx()));
    az.ayM();
    c.agA().set(ah.a.GNC, Boolean.FALSE);
    az.ayM();
    c.agA().set(ah.a.GNE, Boolean.FALSE);
    az.ayM();
    c.agA().faa();
    azZ();
    AppMethodBeat.o(20410);
  }
  
  public static boolean a(b paramb)
  {
    AppMethodBeat.i(20413);
    ac.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[] { paramb });
    long l2 = bs.aNx();
    az.ayM();
    long l3 = ((Long)c.agA().get(ah.a.GND, Long.valueOf(-1L))).longValue();
    az.ayM();
    String str = (String)c.agA().get(ah.a.GNw, "");
    long l1;
    boolean bool2;
    boolean bool1;
    if (paramb == b.hqx)
    {
      az.ayM();
      l1 = ((Long)c.agA().get(ah.a.GNs, Long.valueOf(0L))).longValue();
      az.ayM();
      bool2 = ((Boolean)c.agA().get(ah.a.GNv, Boolean.FALSE)).booleanValue();
      bool1 = azX();
      paramb = azU();
    }
    while (!bs.isNullOrNil(str)) {
      if (!str.equals(Build.FINGERPRINT))
      {
        h.wUl.idkeyStat(633L, 5L, 1L, false);
        ac.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", new Object[] { str, Build.FINGERPRINT });
        AppMethodBeat.o(20413);
        return false;
        az.ayM();
        l1 = ((Long)c.agA().get(ah.a.GNz, Long.valueOf(0L))).longValue();
        az.ayM();
        bool2 = ((Boolean)c.agA().get(ah.a.GNC, Boolean.FALSE)).booleanValue();
        az.ayM();
        bool1 = ((Boolean)c.agA().get(ah.a.GNB, Boolean.FALSE)).booleanValue();
        paramb = azR();
      }
      else
      {
        ac.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] equals current device's [%s] , should show banner", new Object[] { str, Build.FINGERPRINT });
      }
    }
    if (bs.isNullOrNil(paramb))
    {
      ac.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
      AppMethodBeat.o(20413);
      return false;
    }
    if (bool2)
    {
      ac.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
      AppMethodBeat.o(20413);
      return false;
    }
    if (l3 < 0L)
    {
      ac.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
      AppMethodBeat.o(20413);
      return false;
    }
    if ((bool1) && (!azY()))
    {
      ac.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
      AppMethodBeat.o(20413);
      return false;
    }
    if (l1 == -1L)
    {
      ac.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
      AppMethodBeat.o(20413);
      return true;
    }
    if (l3 + l1 > l2)
    {
      ac.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
      AppMethodBeat.o(20413);
      return true;
    }
    ac.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
    AppMethodBeat.o(20413);
    return false;
  }
  
  public static String azR()
  {
    AppMethodBeat.i(20402);
    az.ayM();
    String str = (String)c.agA().get(ah.a.GNx, "");
    AppMethodBeat.o(20402);
    return str;
  }
  
  public static String azS()
  {
    AppMethodBeat.i(20403);
    az.ayM();
    String str = (String)c.agA().get(ah.a.GNy, "");
    AppMethodBeat.o(20403);
    return str;
  }
  
  public static boolean azT()
  {
    AppMethodBeat.i(20404);
    az.ayM();
    boolean bool = ((Boolean)c.agA().get(ah.a.GNA, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20404);
    return bool;
  }
  
  public static String azU()
  {
    AppMethodBeat.i(20405);
    az.ayM();
    String str = (String)c.agA().get(ah.a.GNq, "");
    AppMethodBeat.o(20405);
    return str;
  }
  
  public static String azV()
  {
    AppMethodBeat.i(20406);
    az.ayM();
    String str = (String)c.agA().get(ah.a.GNr, "");
    AppMethodBeat.o(20406);
    return str;
  }
  
  public static boolean azW()
  {
    AppMethodBeat.i(20407);
    az.ayM();
    boolean bool = ((Boolean)c.agA().get(ah.a.GNt, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20407);
    return bool;
  }
  
  private static boolean azX()
  {
    AppMethodBeat.i(20408);
    az.ayM();
    boolean bool = ((Boolean)c.agA().get(ah.a.GNu, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20408);
    return bool;
  }
  
  private static boolean azY()
  {
    AppMethodBeat.i(20409);
    az.ayM();
    boolean bool = ((Boolean)c.agA().get(ah.a.GNE, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20409);
    return bool;
  }
  
  private void azZ()
  {
    AppMethodBeat.i(20414);
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).aAb();
      }
    }
    finally
    {
      AppMethodBeat.o(20414);
    }
    AppMethodBeat.o(20414);
  }
  
  private void g(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(20412);
    String str4 = paramString + "chatting.";
    String str1 = bs.nullAsNil((String)paramMap.get(str4 + "fingerprint"));
    if ((str4.equals(".sysmsg.banner.monitorbanner_n.")) && (!bs.isNullOrNil(str1)))
    {
      ac.e("MicroMsg.ChattingMonitoredBannerStorage", "monitorbanner_n must NOT contain fingerprint.");
      AppMethodBeat.o(20412);
      return;
    }
    String str2 = bs.nullAsNil((String)paramMap.get(str4 + "url"));
    String str3 = bs.nullAsNil((String)paramMap.get(str4 + "wording"));
    long l1 = bs.getLong((String)paramMap.get(str4 + "duration"), 0L);
    boolean bool1;
    boolean bool2;
    label284:
    String str5;
    long l2;
    boolean bool3;
    if (bs.getInt((String)paramMap.get(str4 + "autotrigger"), 0) == 1)
    {
      bool1 = true;
      if (bs.getInt((String)paramMap.get(str4 + "closable"), 0) != 1) {
        break label619;
      }
      bool2 = true;
      paramString = paramString + "mainframe.";
      str4 = bs.nullAsNil((String)paramMap.get(paramString + "url"));
      str5 = bs.nullAsNil((String)paramMap.get(paramString + "wording"));
      l2 = bs.getLong((String)paramMap.get(paramString + "duration"), 0L);
      if (bs.getInt((String)paramMap.get(paramString + "autotrigger"), 0) != 1) {
        break label625;
      }
      bool3 = true;
      label448:
      if (bs.getInt((String)paramMap.get(paramString + "closable"), 0) != 1) {
        break label631;
      }
    }
    label619:
    label625:
    label631:
    for (boolean bool4 = true;; bool4 = false)
    {
      if ((!bs.isNullOrNil(str5)) || (!bs.isNullOrNil(str3)))
      {
        ac.d("MicroMsg.ChattingMonitoredBannerStorage", "received msg:\nchattingUrl = " + str2 + "\nchattingWording = " + str3 + "\nchattingDuration = " + l1 + "\nchattingAutotrigger = " + bool1 + "\nchattingCloseable = " + bool2 + "\nfingerPrint = " + str1);
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
  
  public final void aAa()
  {
    AppMethodBeat.i(20415);
    if (azY() != true)
    {
      ac.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
      az.ayM();
      c.agA().set(ah.a.GND, Long.valueOf(bs.aNx()));
      az.ayM();
      c.agA().set(ah.a.GNE, Boolean.TRUE);
      azZ();
    }
    AppMethodBeat.o(20415);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(20416);
    if (paramb == b.hqw)
    {
      az.ayM();
      c.agA().set(ah.a.GNC, Boolean.FALSE);
    }
    for (;;)
    {
      azZ();
      AppMethodBeat.o(20416);
      return;
      az.ayM();
      c.agA().set(ah.a.GNv, Boolean.FALSE);
    }
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(20417);
    if (paramb == b.hqw)
    {
      az.ayM();
      c.agA().set(ah.a.GNz, Long.valueOf(0L));
    }
    for (;;)
    {
      azZ();
      do
      {
        AppMethodBeat.o(20417);
        return;
      } while (paramb != b.hqx);
      if (!azX())
      {
        az.ayM();
        c.agA().set(ah.a.GNs, Long.valueOf(0L));
      }
      else
      {
        az.ayM();
        c.agA().set(ah.a.GNv, Boolean.TRUE);
      }
    }
  }
  
  public final void s(Map<String, String> paramMap)
  {
    AppMethodBeat.i(20411);
    if (paramMap == null)
    {
      AppMethodBeat.o(20411);
      return;
    }
    h.wUl.idkeyStat(633L, 3L, 1L, false);
    ac.d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(paramMap)));
    g(".sysmsg.banner.monitorbanner_n.", paramMap);
    g(".sysmsg.banner.monitorbanner_o.", paramMap);
    AppMethodBeat.o(20411);
  }
  
  public static abstract interface a
  {
    public abstract void aAb();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(20400);
      hqw = new b("Main", 0);
      hqx = new b("Chatting", 1);
      hqy = new b[] { hqw, hqx };
      AppMethodBeat.o(20400);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.b.b
 * JD-Core Version:    0.7.0.1
 */