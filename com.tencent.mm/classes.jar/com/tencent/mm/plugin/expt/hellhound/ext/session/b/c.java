package com.tencent.mm.plugin.expt.hellhound.ext.session.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class c
{
  public static eah a(eah parameah, String paramString, long paramLong)
  {
    AppMethodBeat.i(122149);
    eah localeah = new eah();
    localeah.sessionId = paramString;
    localeah.abfs = parameah.abfs;
    localeah.abfv = parameah.abfv;
    localeah.abfw = false;
    localeah.owq = 0;
    localeah.abft = parameah.abft;
    localeah.userName = parameah.userName;
    localeah.abfu = parameah.abfu;
    localeah.abfv = parameah.abfv;
    localeah.seq = dLV();
    localeah.startTime = paramLong;
    localeah.abfx = parameah.abfx;
    AppMethodBeat.o(122149);
    return localeah;
  }
  
  public static void a(ead paramead)
  {
    AppMethodBeat.i(185586);
    czw localczw2 = dMa();
    czw localczw1 = localczw2;
    if (localczw2 == null) {
      localczw1 = new czw();
    }
    localczw1.aaFo.addLast(paramead);
    localczw1.aaFp = (localczw1.aaFo.size() - 1);
    localczw1.aaFr = false;
    c(localczw1);
    AppMethodBeat.o(185586);
  }
  
  public static eah asM(String paramString)
  {
    AppMethodBeat.i(300181);
    if (paramString == null)
    {
      AppMethodBeat.o(300181);
      return null;
    }
    czw localczw = dMa();
    if ((localczw == null) || (localczw.aaFn.isEmpty()))
    {
      AppMethodBeat.o(300181);
      return null;
    }
    int i = localczw.aaFn.size() - 1;
    while (i >= 0)
    {
      eah localeah = (eah)localczw.aaFn.get(i);
      if ((localeah != null) && (paramString.equals(localeah.sessionId)) && (i - 1 >= 0))
      {
        paramString = (eah)localczw.aaFn.get(i - 1);
        AppMethodBeat.o(300181);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(300181);
    return null;
  }
  
  public static void asN(String paramString)
  {
    AppMethodBeat.i(122142);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122142);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, clearCurSession: %s", new Object[] { paramString });
    czw localczw = dMa();
    if ((localczw == null) || (localczw.aaFn.isEmpty()))
    {
      AppMethodBeat.o(122142);
      return;
    }
    int i = localczw.aaFn.size();
    Log.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
    i -= 1;
    while (i >= 0)
    {
      eah localeah = (eah)localczw.aaFn.get(i);
      if (localeah != null)
      {
        Log.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s", new Object[] { localeah.sessionId });
        if (paramString.equals(localeah.sessionId))
        {
          localczw.aaFn.remove(i);
          localczw.LSR = (localczw.aaFn.size() - 1);
          c(localczw);
          AppMethodBeat.o(122142);
          return;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(122142);
  }
  
  public static void b(czw paramczw)
  {
    AppMethodBeat.i(122135);
    if (paramczw == null)
    {
      AppMethodBeat.o(122135);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, setHellSession");
    c(paramczw);
    AppMethodBeat.o(122135);
  }
  
  public static void b(ead paramead)
  {
    AppMethodBeat.i(122140);
    if (paramead == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    czw localczw = dMa();
    if (localczw == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    if (!e(localczw))
    {
      AppMethodBeat.o(122140);
      return;
    }
    localczw.aaFo.set(localczw.aaFp, paramead);
    c(localczw);
    AppMethodBeat.o(122140);
  }
  
  private static void c(czw paramczw)
  {
    AppMethodBeat.i(122144);
    if (paramczw == null)
    {
      AppMethodBeat.o(122144);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_key_hell_sessions", paramczw.toByteArray());
      AppMethodBeat.o(122144);
      return;
    }
    catch (Exception paramczw)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionDao", paramczw, "HellSessionDao._writeBack: %s", new Object[] { paramczw.getMessage() });
      AppMethodBeat.o(122144);
    }
  }
  
  public static boolean d(czw paramczw)
  {
    AppMethodBeat.i(122147);
    if (paramczw == null)
    {
      AppMethodBeat.o(122147);
      return false;
    }
    if ((paramczw.LSR >= 0) && (paramczw.LSR < paramczw.aaFn.size()))
    {
      AppMethodBeat.o(122147);
      return true;
    }
    AppMethodBeat.o(122147);
    return false;
  }
  
  public static long dLV()
  {
    AppMethodBeat.i(122130);
    czw localczw2 = dMa();
    czw localczw1 = localczw2;
    if (localczw2 == null) {
      localczw1 = new czw();
    }
    long l = localczw1.muJ;
    localczw1.muJ = (1L + l);
    c(localczw1);
    AppMethodBeat.o(122130);
    return l;
  }
  
  public static void dLW()
  {
    AppMethodBeat.i(122131);
    czw localczw = dMa();
    if (localczw == null)
    {
      AppMethodBeat.o(122131);
      return;
    }
    localczw.muJ = 0L;
    c(localczw);
    AppMethodBeat.o(122131);
  }
  
  public static eah dLX()
  {
    AppMethodBeat.i(122134);
    Object localObject = dMa();
    if (localObject == null)
    {
      AppMethodBeat.o(122134);
      return null;
    }
    if (d((czw)localObject))
    {
      localObject = (eah)((czw)localObject).aaFn.get(((czw)localObject).LSR);
      AppMethodBeat.o(122134);
      return localObject;
    }
    AppMethodBeat.o(122134);
    return null;
  }
  
  public static eah dLY()
  {
    AppMethodBeat.i(122138);
    Object localObject = dMa();
    if ((localObject == null) || (((czw)localObject).aaFn.isEmpty()))
    {
      AppMethodBeat.o(122138);
      return null;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "getLastSession, hellSession: %s", new Object[] { Integer.valueOf(((czw)localObject).LSR) });
    if (d((czw)localObject))
    {
      if (((czw)localObject).LSR - 1 < 0)
      {
        AppMethodBeat.o(122138);
        return null;
      }
      localObject = (eah)((czw)localObject).aaFn.get(((czw)localObject).LSR - 1);
      AppMethodBeat.o(122138);
      return localObject;
    }
    AppMethodBeat.o(122138);
    return null;
  }
  
  public static ead dLZ()
  {
    AppMethodBeat.i(185587);
    Object localObject = dMa();
    if (localObject == null)
    {
      AppMethodBeat.o(185587);
      return null;
    }
    if (e((czw)localObject))
    {
      localObject = (ead)((czw)localObject).aaFo.get(((czw)localObject).aaFp);
      AppMethodBeat.o(185587);
      return localObject;
    }
    AppMethodBeat.o(185587);
    return null;
  }
  
  public static czw dMa()
  {
    AppMethodBeat.i(122145);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard("mmkv_key_hell_sessions");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122145);
      return null;
    }
    czw localczw = new czw();
    try
    {
      localczw.parseFrom(arrayOfByte);
      AppMethodBeat.o(122145);
      return localczw;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionDao", localException, "HellSessionDao._read", new Object[0]);
      AppMethodBeat.o(122145);
    }
    return null;
  }
  
  private static boolean e(czw paramczw)
  {
    AppMethodBeat.i(122148);
    if (paramczw == null)
    {
      AppMethodBeat.o(122148);
      return false;
    }
    if ((paramczw.aaFp >= 0) && (paramczw.aaFp < paramczw.aaFo.size()))
    {
      AppMethodBeat.o(122148);
      return true;
    }
    AppMethodBeat.o(122148);
    return false;
  }
  
  public static void j(eah parameah)
  {
    AppMethodBeat.i(122132);
    czw localczw = dMa();
    if (localczw == null) {
      localczw = new czw();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.g(parameah);
      if (!localczw.aaFn.isEmpty())
      {
        eah localeah = (eah)localczw.aaFn.getLast();
        if ((localeah != null) && (localeah.owq != 1))
        {
          String str1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(localeah.sessionId);
          String str2 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(parameah.sessionId);
          if ((str1 != null) && (str1.equals(str2)))
          {
            localeah.owq = 1;
            localeah.endTime = System.currentTimeMillis();
            Log.i("HABBYGE-MALI.HellSessionDao", "onSessionClose-addSession: %s", new Object[] { localeah.sessionId });
          }
        }
      }
      localczw.aaFn.addLast(parameah);
      localczw.LSR = (localczw.aaFn.size() - 1);
      if (!com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asy(parameah.sessionId)) {
        localczw.aaFr = true;
      }
      Log.i("HABBYGE-MALI.HellSessionDao", "addSession: %s, %b", new Object[] { parameah.sessionId, Boolean.valueOf(localczw.aaFr) });
      c(localczw);
      AppMethodBeat.o(122132);
      return;
    }
  }
  
  public static void k(eah parameah)
  {
    AppMethodBeat.i(122133);
    czw localczw = dMa();
    if (localczw == null)
    {
      AppMethodBeat.o(122133);
      return;
    }
    if (!d(localczw))
    {
      AppMethodBeat.o(122133);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.g(parameah);
    localczw.aaFn.set(localczw.LSR, parameah);
    Log.i("HABBYGE-MALI.HellSessionDao", "updateCurSession, newSession: %s, %s, %d", new Object[] { parameah.sessionId, parameah.abfs, Integer.valueOf(parameah.abft) });
    if (!com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asy(parameah.sessionId)) {
      localczw.aaFr = true;
    }
    c(localczw);
    AppMethodBeat.o(122133);
  }
  
  public static void l(eah parameah)
  {
    AppMethodBeat.i(122136);
    if (parameah == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    czw localczw = dMa();
    if (localczw == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    if (!d(localczw))
    {
      AppMethodBeat.o(122136);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, updateSessionOnClose");
    localczw.aaFn.set(localczw.LSR, parameah);
    localczw.LSR = -1;
    c(localczw);
    AppMethodBeat.o(122136);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(122146);
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, reset");
    com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_key_hell_sessions", new byte[0]);
    AppMethodBeat.o(122146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b.c
 * JD-Core Version:    0.7.0.1
 */