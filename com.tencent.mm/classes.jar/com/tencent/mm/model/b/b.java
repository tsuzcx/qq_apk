package com.tencent.mm.model.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b
{
  public ArrayList<b.a> mListeners;
  private boolean ooj;
  
  public b()
  {
    AppMethodBeat.i(20401);
    this.mListeners = new ArrayList();
    this.ooj = false;
    AppMethodBeat.o(20401);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean3, boolean paramBoolean4, String paramString5)
  {
    AppMethodBeat.i(20410);
    bh.bCz();
    c.ban().set(at.a.acRZ, paramString3);
    bh.bCz();
    c.ban().set(at.a.acSa, paramString4);
    bh.bCz();
    c.ban().set(at.a.acSb, Long.valueOf(paramLong2));
    bh.bCz();
    c.ban().set(at.a.acSc, Boolean.valueOf(paramBoolean3));
    bh.bCz();
    c.ban().set(at.a.acSd, Boolean.valueOf(paramBoolean4));
    bh.bCz();
    c.ban().set(at.a.acSf, paramString5);
    bh.bCz();
    c.ban().set(at.a.acSe, Boolean.FALSE);
    bh.bCz();
    c.ban().set(at.a.acSg, paramString1);
    bh.bCz();
    c.ban().set(at.a.acSh, paramString2);
    bh.bCz();
    c.ban().set(at.a.acSi, Long.valueOf(paramLong1));
    bh.bCz();
    c.ban().set(at.a.acSj, Boolean.valueOf(paramBoolean1));
    bh.bCz();
    c.ban().set(at.a.acSk, Boolean.valueOf(paramBoolean2));
    bh.bCz();
    c.ban().set(at.a.acSm, Long.valueOf(Util.nowSecond()));
    bh.bCz();
    c.ban().set(at.a.acSl, Boolean.FALSE);
    bh.bCz();
    c.ban().set(at.a.acSn, Boolean.FALSE);
    bh.bCz();
    c.ban().iZy();
    bEc();
    AppMethodBeat.o(20410);
  }
  
  public static boolean a(b.b paramb)
  {
    AppMethodBeat.i(20413);
    Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[] { paramb });
    long l2 = Util.nowSecond();
    bh.bCz();
    long l3 = ((Long)c.ban().get(at.a.acSm, Long.valueOf(-1L))).longValue();
    bh.bCz();
    String str = (String)c.ban().get(at.a.acSf, "");
    long l1;
    boolean bool2;
    boolean bool1;
    if (paramb == b.b.ool)
    {
      bh.bCz();
      l1 = ((Long)c.ban().get(at.a.acSb, Long.valueOf(0L))).longValue();
      bh.bCz();
      bool2 = ((Boolean)c.ban().get(at.a.acSe, Boolean.FALSE)).booleanValue();
      bool1 = bEa();
      paramb = bDX();
    }
    while (!Util.isNullOrNil(str)) {
      if (!str.equals(Build.FINGERPRINT))
      {
        h.OAn.idkeyStat(633L, 5L, 1L, false);
        Log.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", new Object[] { str, Build.FINGERPRINT });
        AppMethodBeat.o(20413);
        return false;
        bh.bCz();
        l1 = ((Long)c.ban().get(at.a.acSi, Long.valueOf(0L))).longValue();
        bh.bCz();
        bool2 = ((Boolean)c.ban().get(at.a.acSl, Boolean.FALSE)).booleanValue();
        bh.bCz();
        bool1 = ((Boolean)c.ban().get(at.a.acSk, Boolean.FALSE)).booleanValue();
        paramb = bDU();
      }
      else
      {
        Log.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] equals current device's [%s] , should show banner", new Object[] { str, Build.FINGERPRINT });
      }
    }
    if (Util.isNullOrNil(paramb))
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
      AppMethodBeat.o(20413);
      return false;
    }
    if (bool2)
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
      AppMethodBeat.o(20413);
      return false;
    }
    if (l3 < 0L)
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
      AppMethodBeat.o(20413);
      return false;
    }
    if ((bool1) && (!bEb()))
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
      AppMethodBeat.o(20413);
      return false;
    }
    if (l1 == -1L)
    {
      Log.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
      AppMethodBeat.o(20413);
      return true;
    }
    if (l3 + l1 > l2)
    {
      Log.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
      AppMethodBeat.o(20413);
      return true;
    }
    Log.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
    AppMethodBeat.o(20413);
    return false;
  }
  
  public static String bDU()
  {
    AppMethodBeat.i(20402);
    bh.bCz();
    String str = (String)c.ban().get(at.a.acSg, "");
    AppMethodBeat.o(20402);
    return str;
  }
  
  public static String bDV()
  {
    AppMethodBeat.i(20403);
    bh.bCz();
    String str = (String)c.ban().get(at.a.acSh, "");
    AppMethodBeat.o(20403);
    return str;
  }
  
  public static boolean bDW()
  {
    AppMethodBeat.i(20404);
    bh.bCz();
    boolean bool = ((Boolean)c.ban().get(at.a.acSj, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20404);
    return bool;
  }
  
  public static String bDX()
  {
    AppMethodBeat.i(20405);
    bh.bCz();
    String str = (String)c.ban().get(at.a.acRZ, "");
    AppMethodBeat.o(20405);
    return str;
  }
  
  public static String bDY()
  {
    AppMethodBeat.i(20406);
    bh.bCz();
    String str = (String)c.ban().get(at.a.acSa, "");
    AppMethodBeat.o(20406);
    return str;
  }
  
  public static boolean bDZ()
  {
    AppMethodBeat.i(20407);
    bh.bCz();
    boolean bool = ((Boolean)c.ban().get(at.a.acSc, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20407);
    return bool;
  }
  
  private static boolean bEa()
  {
    AppMethodBeat.i(20408);
    bh.bCz();
    boolean bool = ((Boolean)c.ban().get(at.a.acSd, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20408);
    return bool;
  }
  
  private static boolean bEb()
  {
    AppMethodBeat.i(20409);
    bh.bCz();
    boolean bool = ((Boolean)c.ban().get(at.a.acSn, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20409);
    return bool;
  }
  
  private void bEc()
  {
    AppMethodBeat.i(20414);
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).bEe();
      }
    }
    finally
    {
      AppMethodBeat.o(20414);
    }
    AppMethodBeat.o(20414);
  }
  
  private void h(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(20412);
    String str4 = paramString + "chatting.";
    String str1 = Util.nullAsNil((String)paramMap.get(str4 + "fingerprint"));
    if ((str4.equals(".sysmsg.banner.monitorbanner_n.")) && (!Util.isNullOrNil(str1)))
    {
      Log.e("MicroMsg.ChattingMonitoredBannerStorage", "monitorbanner_n must NOT contain fingerprint.");
      AppMethodBeat.o(20412);
      return;
    }
    String str2 = Util.nullAsNil((String)paramMap.get(str4 + "url"));
    String str3 = Util.nullAsNil((String)paramMap.get(str4 + "wording"));
    long l1 = Util.getLong((String)paramMap.get(str4 + "duration"), 0L);
    boolean bool1;
    boolean bool2;
    label284:
    String str5;
    long l2;
    boolean bool3;
    if (Util.getInt((String)paramMap.get(str4 + "autotrigger"), 0) == 1)
    {
      bool1 = true;
      if (Util.getInt((String)paramMap.get(str4 + "closable"), 0) != 1) {
        break label619;
      }
      bool2 = true;
      paramString = paramString + "mainframe.";
      str4 = Util.nullAsNil((String)paramMap.get(paramString + "url"));
      str5 = Util.nullAsNil((String)paramMap.get(paramString + "wording"));
      l2 = Util.getLong((String)paramMap.get(paramString + "duration"), 0L);
      if (Util.getInt((String)paramMap.get(paramString + "autotrigger"), 0) != 1) {
        break label625;
      }
      bool3 = true;
      label448:
      if (Util.getInt((String)paramMap.get(paramString + "closable"), 0) != 1) {
        break label631;
      }
    }
    label619:
    label625:
    label631:
    for (boolean bool4 = true;; bool4 = false)
    {
      if ((!Util.isNullOrNil(str5)) || (!Util.isNullOrNil(str3)))
      {
        Log.d("MicroMsg.ChattingMonitoredBannerStorage", "received msg:\nchattingUrl = " + str2 + "\nchattingWording = " + str3 + "\nchattingDuration = " + l1 + "\nchattingAutotrigger = " + bool1 + "\nchattingCloseable = " + bool2 + "\nfingerPrint = " + str1);
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
  
  public final void C(Map<String, String> paramMap)
  {
    AppMethodBeat.i(20411);
    if (paramMap == null)
    {
      AppMethodBeat.o(20411);
      return;
    }
    h.OAn.idkeyStat(633L, 3L, 1L, false);
    Log.d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(paramMap)));
    h(".sysmsg.banner.monitorbanner_n.", paramMap);
    h(".sysmsg.banner.monitorbanner_o.", paramMap);
    AppMethodBeat.o(20411);
  }
  
  public final void b(b.b paramb)
  {
    AppMethodBeat.i(20416);
    if (paramb == b.b.ook)
    {
      bh.bCz();
      c.ban().set(at.a.acSl, Boolean.FALSE);
    }
    for (;;)
    {
      bEc();
      AppMethodBeat.o(20416);
      return;
      bh.bCz();
      c.ban().set(at.a.acSe, Boolean.FALSE);
    }
  }
  
  public final void bEd()
  {
    AppMethodBeat.i(20415);
    if (bEb() != true)
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
      bh.bCz();
      c.ban().set(at.a.acSm, Long.valueOf(Util.nowSecond()));
      bh.bCz();
      c.ban().set(at.a.acSn, Boolean.TRUE);
      bEc();
    }
    AppMethodBeat.o(20415);
  }
  
  public final void c(b.b paramb)
  {
    AppMethodBeat.i(20417);
    if (paramb == b.b.ook)
    {
      bh.bCz();
      c.ban().set(at.a.acSi, Long.valueOf(0L));
    }
    for (;;)
    {
      bEc();
      do
      {
        AppMethodBeat.o(20417);
        return;
      } while (paramb != b.b.ool);
      if (!bEa())
      {
        bh.bCz();
        c.ban().set(at.a.acSb, Long.valueOf(0L));
      }
      else
      {
        bh.bCz();
        c.ban().set(at.a.acSe, Boolean.TRUE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.b.b
 * JD-Core Version:    0.7.0.1
 */