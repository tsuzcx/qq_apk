package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class c
{
  public static cyl a(cyl paramcyl, String paramString, long paramLong)
  {
    AppMethodBeat.i(122149);
    cyl localcyl = new cyl();
    localcyl.sessionId = paramString;
    localcyl.MDn = paramcyl.MDn;
    localcyl.MDq = paramcyl.MDq;
    localcyl.MDr = false;
    localcyl.iOu = 0;
    localcyl.MDo = paramcyl.MDo;
    localcyl.userName = paramcyl.userName;
    localcyl.MDp = paramcyl.MDp;
    localcyl.MDq = paramcyl.MDq;
    localcyl.seq = cQm();
    localcyl.startTime = paramLong;
    localcyl.MDs = paramcyl.MDs;
    AppMethodBeat.o(122149);
    return localcyl;
  }
  
  public static void a(cyh paramcyh)
  {
    AppMethodBeat.i(185586);
    cbo localcbo2 = cQs();
    cbo localcbo1 = localcbo2;
    if (localcbo2 == null) {
      localcbo1 = new cbo();
    }
    localcbo1.Mht.addLast(paramcyh);
    localcbo1.Mhu = (localcbo1.Mht.size() - 1);
    localcbo1.Mhw = false;
    c(localcbo1);
    AppMethodBeat.o(185586);
  }
  
  public static cyl aqG(String paramString)
  {
    AppMethodBeat.i(220563);
    if (paramString == null)
    {
      AppMethodBeat.o(220563);
      return null;
    }
    cbo localcbo = cQs();
    if ((localcbo == null) || (localcbo.Mhr.isEmpty()))
    {
      AppMethodBeat.o(220563);
      return null;
    }
    int i = localcbo.Mhr.size() - 1;
    while (i >= 0)
    {
      cyl localcyl = (cyl)localcbo.Mhr.get(i);
      if ((localcyl != null) && (paramString.equals(localcyl.sessionId)) && (i - 1 >= 0))
      {
        paramString = (cyl)localcbo.Mhr.get(i - 1);
        AppMethodBeat.o(220563);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(220563);
    return null;
  }
  
  public static void aqH(String paramString)
  {
    AppMethodBeat.i(122142);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122142);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, clearCurSession: %s", new Object[] { paramString });
    cbo localcbo = cQs();
    if ((localcbo == null) || (localcbo.Mhr.isEmpty()))
    {
      AppMethodBeat.o(122142);
      return;
    }
    int i = localcbo.Mhr.size();
    Log.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
    i -= 1;
    while (i >= 0)
    {
      cyl localcyl = (cyl)localcbo.Mhr.get(i);
      if (localcyl != null)
      {
        Log.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s", new Object[] { localcyl.sessionId });
        if (paramString.equals(localcyl.sessionId))
        {
          localcbo.Mhr.remove(i);
          localcbo.Mhs = (localcbo.Mhr.size() - 1);
          c(localcbo);
          AppMethodBeat.o(122142);
          return;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(122142);
  }
  
  public static void b(cbo paramcbo)
  {
    AppMethodBeat.i(122135);
    if (paramcbo == null)
    {
      AppMethodBeat.o(122135);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, setHellSession");
    c(paramcbo);
    AppMethodBeat.o(122135);
  }
  
  public static void b(cyh paramcyh)
  {
    AppMethodBeat.i(122140);
    if (paramcyh == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    cbo localcbo = cQs();
    if (localcbo == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    if (!e(localcbo))
    {
      AppMethodBeat.o(122140);
      return;
    }
    localcbo.Mht.set(localcbo.Mhu, paramcyh);
    c(localcbo);
    AppMethodBeat.o(122140);
  }
  
  private static void c(cbo paramcbo)
  {
    AppMethodBeat.i(122144);
    if (paramcbo == null)
    {
      AppMethodBeat.o(122144);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_sessions", paramcbo.toByteArray());
      AppMethodBeat.o(122144);
      return;
    }
    catch (Exception paramcbo)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionDao", paramcbo, "HellSessionDao._writeBack: %s", new Object[] { paramcbo.getMessage() });
      AppMethodBeat.o(122144);
    }
  }
  
  public static long cQm()
  {
    AppMethodBeat.i(122130);
    cbo localcbo2 = cQs();
    cbo localcbo1 = localcbo2;
    if (localcbo2 == null) {
      localcbo1 = new cbo();
    }
    long l = localcbo1.his;
    localcbo1.his = (1L + l);
    c(localcbo1);
    AppMethodBeat.o(122130);
    return l;
  }
  
  public static void cQn()
  {
    AppMethodBeat.i(122131);
    cbo localcbo = cQs();
    if (localcbo == null)
    {
      AppMethodBeat.o(122131);
      return;
    }
    localcbo.his = 0L;
    c(localcbo);
    AppMethodBeat.o(122131);
  }
  
  public static cyl cQo()
  {
    AppMethodBeat.i(122134);
    Object localObject = cQs();
    if (localObject == null)
    {
      AppMethodBeat.o(122134);
      return null;
    }
    if (d((cbo)localObject))
    {
      localObject = (cyl)((cbo)localObject).Mhr.get(((cbo)localObject).Mhs);
      AppMethodBeat.o(122134);
      return localObject;
    }
    AppMethodBeat.o(122134);
    return null;
  }
  
  public static cyl cQp()
  {
    AppMethodBeat.i(122137);
    Object localObject = cQs();
    if ((localObject == null) || (((cbo)localObject).Mhr.isEmpty()))
    {
      AppMethodBeat.o(122137);
      return null;
    }
    if (d((cbo)localObject))
    {
      localObject = (cyl)((cbo)localObject).Mhr.get(((cbo)localObject).Mhs);
      AppMethodBeat.o(122137);
      return localObject;
    }
    localObject = (cyl)((cbo)localObject).Mhr.getLast();
    AppMethodBeat.o(122137);
    return localObject;
  }
  
  public static cyl cQq()
  {
    AppMethodBeat.i(122138);
    Object localObject = cQs();
    if ((localObject == null) || (((cbo)localObject).Mhr.isEmpty()))
    {
      AppMethodBeat.o(122138);
      return null;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "getLastSession, hellSession: %s", new Object[] { Integer.valueOf(((cbo)localObject).Mhs) });
    if (d((cbo)localObject))
    {
      if (((cbo)localObject).Mhs - 1 < 0)
      {
        AppMethodBeat.o(122138);
        return null;
      }
      localObject = (cyl)((cbo)localObject).Mhr.get(((cbo)localObject).Mhs - 1);
      AppMethodBeat.o(122138);
      return localObject;
    }
    AppMethodBeat.o(122138);
    return null;
  }
  
  public static cyh cQr()
  {
    AppMethodBeat.i(185587);
    Object localObject = cQs();
    if (localObject == null)
    {
      AppMethodBeat.o(185587);
      return null;
    }
    if (e((cbo)localObject))
    {
      localObject = (cyh)((cbo)localObject).Mht.get(((cbo)localObject).Mhu);
      AppMethodBeat.o(185587);
      return localObject;
    }
    AppMethodBeat.o(185587);
    return null;
  }
  
  public static cbo cQs()
  {
    AppMethodBeat.i(122145);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_sessions");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122145);
      return null;
    }
    cbo localcbo = new cbo();
    try
    {
      localcbo.parseFrom(arrayOfByte);
      AppMethodBeat.o(122145);
      return localcbo;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionDao", localException, "HellSessionDao._read", new Object[0]);
      AppMethodBeat.o(122145);
    }
    return null;
  }
  
  private static boolean d(cbo paramcbo)
  {
    AppMethodBeat.i(122147);
    if (paramcbo == null)
    {
      AppMethodBeat.o(122147);
      return false;
    }
    if ((paramcbo.Mhs >= 0) && (paramcbo.Mhs < paramcbo.Mhr.size()))
    {
      AppMethodBeat.o(122147);
      return true;
    }
    AppMethodBeat.o(122147);
    return false;
  }
  
  private static boolean e(cbo paramcbo)
  {
    AppMethodBeat.i(122148);
    if (paramcbo == null)
    {
      AppMethodBeat.o(122148);
      return false;
    }
    if ((paramcbo.Mhu >= 0) && (paramcbo.Mhu < paramcbo.Mht.size()))
    {
      AppMethodBeat.o(122148);
      return true;
    }
    AppMethodBeat.o(122148);
    return false;
  }
  
  public static void l(cyl paramcyl)
  {
    AppMethodBeat.i(122132);
    cbo localcbo = cQs();
    if (localcbo == null) {
      localcbo = new cbo();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramcyl);
      if (!localcbo.Mhr.isEmpty())
      {
        cyl localcyl = (cyl)localcbo.Mhr.getLast();
        if ((localcyl != null) && (localcyl.iOu != 1))
        {
          String str1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(localcyl.sessionId);
          String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcyl.sessionId);
          if ((str1 != null) && (str1.equals(str2)))
          {
            localcyl.iOu = 1;
            localcyl.endTime = System.currentTimeMillis();
            Log.i("HABBYGE-MALI.HellSessionDao", "onSessionClose-addSession: %s", new Object[] { localcyl.sessionId });
          }
        }
      }
      localcbo.Mhr.addLast(paramcyl);
      localcbo.Mhs = (localcbo.Mhr.size() - 1);
      if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(paramcyl.sessionId)) {
        localcbo.Mhw = true;
      }
      Log.i("HABBYGE-MALI.HellSessionDao", "addSession: %s, %b", new Object[] { paramcyl.sessionId, Boolean.valueOf(localcbo.Mhw) });
      c(localcbo);
      AppMethodBeat.o(122132);
      return;
    }
  }
  
  public static void m(cyl paramcyl)
  {
    AppMethodBeat.i(122133);
    cbo localcbo = cQs();
    if (localcbo == null)
    {
      AppMethodBeat.o(122133);
      return;
    }
    if (!d(localcbo))
    {
      AppMethodBeat.o(122133);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramcyl);
    localcbo.Mhr.set(localcbo.Mhs, paramcyl);
    Log.i("HABBYGE-MALI.HellSessionDao", "updateCurSession, newSession: %s, %s, %d", new Object[] { paramcyl.sessionId, paramcyl.MDn, Integer.valueOf(paramcyl.MDo) });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(paramcyl.sessionId)) {
      localcbo.Mhw = true;
    }
    c(localcbo);
    AppMethodBeat.o(122133);
  }
  
  public static void n(cyl paramcyl)
  {
    AppMethodBeat.i(122136);
    if (paramcyl == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    cbo localcbo = cQs();
    if (localcbo == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    if (!d(localcbo))
    {
      AppMethodBeat.o(122136);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, updateSessionOnClose");
    localcbo.Mhr.set(localcbo.Mhs, paramcyl);
    localcbo.Mhs = -1;
    c(localcbo);
    AppMethodBeat.o(122136);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(122146);
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, reset");
    com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_sessions", new byte[0]);
    AppMethodBeat.o(122146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.c
 * JD-Core Version:    0.7.0.1
 */