package com.tencent.mm.model.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private boolean lwK;
  public ArrayList<b.a> mListeners;
  
  public b()
  {
    AppMethodBeat.i(20401);
    this.mListeners = new ArrayList();
    this.lwK = false;
    AppMethodBeat.o(20401);
  }
  
  private void a(String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean3, boolean paramBoolean4, String paramString5)
  {
    AppMethodBeat.i(20410);
    bh.beI();
    c.aHp().set(ar.a.Vqx, paramString3);
    bh.beI();
    c.aHp().set(ar.a.Vqy, paramString4);
    bh.beI();
    c.aHp().set(ar.a.Vqz, Long.valueOf(paramLong2));
    bh.beI();
    c.aHp().set(ar.a.VqA, Boolean.valueOf(paramBoolean3));
    bh.beI();
    c.aHp().set(ar.a.VqB, Boolean.valueOf(paramBoolean4));
    bh.beI();
    c.aHp().set(ar.a.VqD, paramString5);
    bh.beI();
    c.aHp().set(ar.a.VqC, Boolean.FALSE);
    bh.beI();
    c.aHp().set(ar.a.VqE, paramString1);
    bh.beI();
    c.aHp().set(ar.a.VqF, paramString2);
    bh.beI();
    c.aHp().set(ar.a.VqG, Long.valueOf(paramLong1));
    bh.beI();
    c.aHp().set(ar.a.VqH, Boolean.valueOf(paramBoolean1));
    bh.beI();
    c.aHp().set(ar.a.VqI, Boolean.valueOf(paramBoolean2));
    bh.beI();
    c.aHp().set(ar.a.VqK, Long.valueOf(Util.nowSecond()));
    bh.beI();
    c.aHp().set(ar.a.VqJ, Boolean.FALSE);
    bh.beI();
    c.aHp().set(ar.a.VqL, Boolean.FALSE);
    bh.beI();
    c.aHp().hxT();
    bgl();
    AppMethodBeat.o(20410);
  }
  
  public static boolean a(b.b paramb)
  {
    AppMethodBeat.i(20413);
    Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", new Object[] { paramb });
    long l2 = Util.nowSecond();
    bh.beI();
    long l3 = ((Long)c.aHp().get(ar.a.VqK, Long.valueOf(-1L))).longValue();
    bh.beI();
    String str = (String)c.aHp().get(ar.a.VqD, "");
    long l1;
    boolean bool2;
    boolean bool1;
    if (paramb == b.b.lwM)
    {
      bh.beI();
      l1 = ((Long)c.aHp().get(ar.a.Vqz, Long.valueOf(0L))).longValue();
      bh.beI();
      bool2 = ((Boolean)c.aHp().get(ar.a.VqC, Boolean.FALSE)).booleanValue();
      bool1 = bgj();
      paramb = bgg();
    }
    while (!Util.isNullOrNil(str)) {
      if (!str.equals(Build.FINGERPRINT))
      {
        h.IzE.idkeyStat(633L, 5L, 1L, false);
        Log.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", new Object[] { str, Build.FINGERPRINT });
        AppMethodBeat.o(20413);
        return false;
        bh.beI();
        l1 = ((Long)c.aHp().get(ar.a.VqG, Long.valueOf(0L))).longValue();
        bh.beI();
        bool2 = ((Boolean)c.aHp().get(ar.a.VqJ, Boolean.FALSE)).booleanValue();
        bh.beI();
        bool1 = ((Boolean)c.aHp().get(ar.a.VqI, Boolean.FALSE)).booleanValue();
        paramb = bgd();
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
    if ((bool1) && (!bgk()))
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
  
  public static String bgd()
  {
    AppMethodBeat.i(20402);
    bh.beI();
    String str = (String)c.aHp().get(ar.a.VqE, "");
    AppMethodBeat.o(20402);
    return str;
  }
  
  public static String bge()
  {
    AppMethodBeat.i(20403);
    bh.beI();
    String str = (String)c.aHp().get(ar.a.VqF, "");
    AppMethodBeat.o(20403);
    return str;
  }
  
  public static boolean bgf()
  {
    AppMethodBeat.i(20404);
    bh.beI();
    boolean bool = ((Boolean)c.aHp().get(ar.a.VqH, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20404);
    return bool;
  }
  
  public static String bgg()
  {
    AppMethodBeat.i(20405);
    bh.beI();
    String str = (String)c.aHp().get(ar.a.Vqx, "");
    AppMethodBeat.o(20405);
    return str;
  }
  
  public static String bgh()
  {
    AppMethodBeat.i(20406);
    bh.beI();
    String str = (String)c.aHp().get(ar.a.Vqy, "");
    AppMethodBeat.o(20406);
    return str;
  }
  
  public static boolean bgi()
  {
    AppMethodBeat.i(20407);
    bh.beI();
    boolean bool = ((Boolean)c.aHp().get(ar.a.VqA, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20407);
    return bool;
  }
  
  private static boolean bgj()
  {
    AppMethodBeat.i(20408);
    bh.beI();
    boolean bool = ((Boolean)c.aHp().get(ar.a.VqB, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20408);
    return bool;
  }
  
  private static boolean bgk()
  {
    AppMethodBeat.i(20409);
    bh.beI();
    boolean bool = ((Boolean)c.aHp().get(ar.a.VqL, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(20409);
    return bool;
  }
  
  private void bgl()
  {
    AppMethodBeat.i(20414);
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).bgn();
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
  
  public final void b(b.b paramb)
  {
    AppMethodBeat.i(20416);
    if (paramb == b.b.lwL)
    {
      bh.beI();
      c.aHp().set(ar.a.VqJ, Boolean.FALSE);
    }
    for (;;)
    {
      bgl();
      AppMethodBeat.o(20416);
      return;
      bh.beI();
      c.aHp().set(ar.a.VqC, Boolean.FALSE);
    }
  }
  
  public final void bgm()
  {
    AppMethodBeat.i(20415);
    if (bgk() != true)
    {
      Log.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
      bh.beI();
      c.aHp().set(ar.a.VqK, Long.valueOf(Util.nowSecond()));
      bh.beI();
      c.aHp().set(ar.a.VqL, Boolean.TRUE);
      bgl();
    }
    AppMethodBeat.o(20415);
  }
  
  public final void c(b.b paramb)
  {
    AppMethodBeat.i(20417);
    if (paramb == b.b.lwL)
    {
      bh.beI();
      c.aHp().set(ar.a.VqG, Long.valueOf(0L));
    }
    for (;;)
    {
      bgl();
      do
      {
        AppMethodBeat.o(20417);
        return;
      } while (paramb != b.b.lwM);
      if (!bgj())
      {
        bh.beI();
        c.aHp().set(ar.a.Vqz, Long.valueOf(0L));
      }
      else
      {
        bh.beI();
        c.aHp().set(ar.a.VqC, Boolean.TRUE);
      }
    }
  }
  
  public final void v(Map<String, String> paramMap)
  {
    AppMethodBeat.i(20411);
    if (paramMap == null)
    {
      AppMethodBeat.o(20411);
      return;
    }
    h.IzE.idkeyStat(633L, 3L, 1L, false);
    Log.d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(paramMap)));
    h(".sysmsg.banner.monitorbanner_n.", paramMap);
    h(".sysmsg.banner.monitorbanner_o.", paramMap);
    AppMethodBeat.o(20411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.b.b
 * JD-Core Version:    0.7.0.1
 */