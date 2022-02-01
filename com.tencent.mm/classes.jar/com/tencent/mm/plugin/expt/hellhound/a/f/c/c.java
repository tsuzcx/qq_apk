package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class c
{
  public static chk a(chk paramchk, String paramString, long paramLong)
  {
    AppMethodBeat.i(122149);
    chk localchk = new chk();
    localchk.sessionId = paramString;
    localchk.HaP = paramchk.HaP;
    localchk.HaS = paramchk.HaS;
    localchk.HaT = false;
    localchk.hQn = 0;
    localchk.HaQ = paramchk.HaQ;
    localchk.userName = paramchk.userName;
    localchk.HaR = paramchk.HaR;
    localchk.HaS = paramchk.HaS;
    localchk.seq = cqc();
    localchk.startTime = paramLong;
    localchk.HaU = paramchk.HaU;
    AppMethodBeat.o(122149);
    return localchk;
  }
  
  public static void a(chg paramchg)
  {
    AppMethodBeat.i(185586);
    boe localboe2 = cqi();
    boe localboe1 = localboe2;
    if (localboe2 == null) {
      localboe1 = new boe();
    }
    localboe1.GIO.addLast(paramchg);
    localboe1.GIP = (localboe1.GIO.size() - 1);
    localboe1.GIS = false;
    c(localboe1);
    AppMethodBeat.o(185586);
  }
  
  public static chk aeZ(String paramString)
  {
    AppMethodBeat.i(210465);
    if (paramString == null)
    {
      AppMethodBeat.o(210465);
      return null;
    }
    boe localboe = cqi();
    if ((localboe == null) || (localboe.GIM.isEmpty()))
    {
      AppMethodBeat.o(210465);
      return null;
    }
    int i = localboe.GIM.size() - 1;
    while (i >= 0)
    {
      chk localchk = (chk)localboe.GIM.get(i);
      if ((localchk != null) && (paramString.equals(localchk.sessionId)) && (i - 1 >= 0))
      {
        paramString = (chk)localboe.GIM.get(i - 1);
        AppMethodBeat.o(210465);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(210465);
    return null;
  }
  
  public static void afa(String paramString)
  {
    AppMethodBeat.i(122142);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122142);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, clearCurSession: %s", new Object[] { paramString });
    boe localboe = cqi();
    if ((localboe == null) || (localboe.GIM.isEmpty()))
    {
      AppMethodBeat.o(122142);
      return;
    }
    int i = localboe.GIM.size();
    ad.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
    i -= 1;
    while (i >= 0)
    {
      chk localchk = (chk)localboe.GIM.get(i);
      if (localchk != null)
      {
        ad.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s", new Object[] { localchk.sessionId });
        if (paramString.equals(localchk.sessionId))
        {
          localboe.GIM.remove(i);
          localboe.GIN = (localboe.GIM.size() - 1);
          c(localboe);
          AppMethodBeat.o(122142);
          return;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(122142);
  }
  
  public static void b(boe paramboe)
  {
    AppMethodBeat.i(122135);
    if (paramboe == null)
    {
      AppMethodBeat.o(122135);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, setHellSession");
    c(paramboe);
    AppMethodBeat.o(122135);
  }
  
  public static void b(chg paramchg)
  {
    AppMethodBeat.i(122140);
    if (paramchg == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    boe localboe = cqi();
    if (localboe == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    if (!e(localboe))
    {
      AppMethodBeat.o(122140);
      return;
    }
    localboe.GIO.set(localboe.GIP, paramchg);
    c(localboe);
    AppMethodBeat.o(122140);
  }
  
  private static void c(boe paramboe)
  {
    AppMethodBeat.i(122144);
    if (paramboe == null)
    {
      AppMethodBeat.o(122144);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_hell_sessions", paramboe.toByteArray());
      AppMethodBeat.o(122144);
      return;
    }
    catch (Exception paramboe)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellSessionDao", paramboe, "HellSessionDao._writeBack: %s", new Object[] { paramboe.getMessage() });
      AppMethodBeat.o(122144);
    }
  }
  
  public static long cqc()
  {
    AppMethodBeat.i(122130);
    boe localboe2 = cqi();
    boe localboe1 = localboe2;
    if (localboe2 == null) {
      localboe1 = new boe();
    }
    long l = localboe1.GIR;
    localboe1.GIR = (1L + l);
    c(localboe1);
    AppMethodBeat.o(122130);
    return l;
  }
  
  public static void cqd()
  {
    AppMethodBeat.i(122131);
    boe localboe = cqi();
    if (localboe == null)
    {
      AppMethodBeat.o(122131);
      return;
    }
    localboe.GIR = 0L;
    c(localboe);
    AppMethodBeat.o(122131);
  }
  
  public static chk cqe()
  {
    AppMethodBeat.i(122134);
    Object localObject = cqi();
    if (localObject == null)
    {
      AppMethodBeat.o(122134);
      return null;
    }
    if (d((boe)localObject))
    {
      localObject = (chk)((boe)localObject).GIM.get(((boe)localObject).GIN);
      AppMethodBeat.o(122134);
      return localObject;
    }
    AppMethodBeat.o(122134);
    return null;
  }
  
  public static chk cqf()
  {
    AppMethodBeat.i(122137);
    Object localObject = cqi();
    if ((localObject == null) || (((boe)localObject).GIM.isEmpty()))
    {
      AppMethodBeat.o(122137);
      return null;
    }
    if (d((boe)localObject))
    {
      localObject = (chk)((boe)localObject).GIM.get(((boe)localObject).GIN);
      AppMethodBeat.o(122137);
      return localObject;
    }
    localObject = (chk)((boe)localObject).GIM.getLast();
    AppMethodBeat.o(122137);
    return localObject;
  }
  
  public static chk cqg()
  {
    AppMethodBeat.i(122138);
    Object localObject = cqi();
    if ((localObject == null) || (((boe)localObject).GIM.isEmpty()))
    {
      AppMethodBeat.o(122138);
      return null;
    }
    ad.i("HABBYGE-MALI.HellSessionDao", "getLastSession, hellSession: %s", new Object[] { Integer.valueOf(((boe)localObject).GIN) });
    if (d((boe)localObject))
    {
      if (((boe)localObject).GIN - 1 < 0)
      {
        AppMethodBeat.o(122138);
        return null;
      }
      localObject = (chk)((boe)localObject).GIM.get(((boe)localObject).GIN - 1);
      AppMethodBeat.o(122138);
      return localObject;
    }
    AppMethodBeat.o(122138);
    return null;
  }
  
  public static chg cqh()
  {
    AppMethodBeat.i(185587);
    Object localObject = cqi();
    if (localObject == null)
    {
      AppMethodBeat.o(185587);
      return null;
    }
    if (e((boe)localObject))
    {
      localObject = (chg)((boe)localObject).GIO.get(((boe)localObject).GIP);
      AppMethodBeat.o(185587);
      return localObject;
    }
    AppMethodBeat.o(185587);
    return null;
  }
  
  public static boe cqi()
  {
    AppMethodBeat.i(122145);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_sessions");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ad.e("HABBYGE-MALI.HellSessionDao", "HellSession read(): NULL");
      AppMethodBeat.o(122145);
      return null;
    }
    boe localboe = new boe();
    try
    {
      localboe.parseFrom(arrayOfByte);
      AppMethodBeat.o(122145);
      return localboe;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellSessionDao", localException, "HellSessionDao._read", new Object[0]);
      AppMethodBeat.o(122145);
    }
    return null;
  }
  
  private static boolean d(boe paramboe)
  {
    AppMethodBeat.i(122147);
    if (paramboe == null)
    {
      AppMethodBeat.o(122147);
      return false;
    }
    if ((paramboe.GIN >= 0) && (paramboe.GIN < paramboe.GIM.size()))
    {
      AppMethodBeat.o(122147);
      return true;
    }
    AppMethodBeat.o(122147);
    return false;
  }
  
  private static boolean e(boe paramboe)
  {
    AppMethodBeat.i(122148);
    if (paramboe == null)
    {
      AppMethodBeat.o(122148);
      return false;
    }
    if ((paramboe.GIP >= 0) && (paramboe.GIP < paramboe.GIO.size()))
    {
      AppMethodBeat.o(122148);
      return true;
    }
    AppMethodBeat.o(122148);
    return false;
  }
  
  public static void h(chk paramchk)
  {
    AppMethodBeat.i(122132);
    boe localboe = cqi();
    if (localboe == null) {
      localboe = new boe();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.e(paramchk);
      if (!localboe.GIM.isEmpty())
      {
        chk localchk = (chk)localboe.GIM.getLast();
        if ((localchk != null) && (localchk.hQn != 1))
        {
          String str1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(localchk.sessionId);
          String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramchk.sessionId);
          if ((str1 != null) && (str1.equals(str2)))
          {
            localchk.hQn = 1;
            localchk.endTime = System.currentTimeMillis();
            ad.i("HABBYGE-MALI.HellSessionDao", "onSessionClose-addSession: %s", new Object[] { localchk.sessionId });
          }
        }
      }
      localboe.GIM.addLast(paramchk);
      localboe.GIN = (localboe.GIM.size() - 1);
      if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeM(paramchk.sessionId)) {
        localboe.GIS = true;
      }
      ad.i("HABBYGE-MALI.HellSessionDao", "addSession: %s, %b", new Object[] { paramchk.sessionId, Boolean.valueOf(localboe.GIS) });
      c(localboe);
      AppMethodBeat.o(122132);
      return;
    }
  }
  
  public static void i(chk paramchk)
  {
    AppMethodBeat.i(122133);
    boe localboe = cqi();
    if (localboe == null)
    {
      AppMethodBeat.o(122133);
      return;
    }
    if (!d(localboe))
    {
      AppMethodBeat.o(122133);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.e(paramchk);
    localboe.GIM.set(localboe.GIN, paramchk);
    ad.i("HABBYGE-MALI.HellSessionDao", "updateCurSession, newSession: %s, %s, %d", new Object[] { paramchk.sessionId, paramchk.HaP, Integer.valueOf(paramchk.HaQ) });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeM(paramchk.sessionId)) {
      localboe.GIS = true;
    }
    c(localboe);
    AppMethodBeat.o(122133);
  }
  
  public static void j(chk paramchk)
  {
    AppMethodBeat.i(122136);
    if (paramchk == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    boe localboe = cqi();
    if (localboe == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    if (!d(localboe))
    {
      AppMethodBeat.o(122136);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, updateSessionOnClose");
    localboe.GIM.set(localboe.GIN, paramchk);
    localboe.GIN = -1;
    c(localboe);
    AppMethodBeat.o(122136);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(122146);
    ad.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, reset");
    com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_hell_sessions", new byte[0]);
    AppMethodBeat.o(122146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.c
 * JD-Core Version:    0.7.0.1
 */