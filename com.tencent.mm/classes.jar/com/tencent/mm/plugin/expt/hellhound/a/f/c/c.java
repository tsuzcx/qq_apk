package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class c
{
  public static dhx a(dhx paramdhx, String paramString, long paramLong)
  {
    AppMethodBeat.i(122149);
    dhx localdhx = new dhx();
    localdhx.sessionId = paramString;
    localdhx.TOW = paramdhx.TOW;
    localdhx.TOZ = paramdhx.TOZ;
    localdhx.TPa = false;
    localdhx.lEK = 0;
    localdhx.TOX = paramdhx.TOX;
    localdhx.userName = paramdhx.userName;
    localdhx.TOY = paramdhx.TOY;
    localdhx.TOZ = paramdhx.TOZ;
    localdhx.seq = dfg();
    localdhx.startTime = paramLong;
    localdhx.TPb = paramdhx.TPb;
    AppMethodBeat.o(122149);
    return localdhx;
  }
  
  public static void a(dht paramdht)
  {
    AppMethodBeat.i(185586);
    cjr localcjr2 = dfm();
    cjr localcjr1 = localcjr2;
    if (localcjr2 == null) {
      localcjr1 = new cjr();
    }
    localcjr1.Trg.addLast(paramdht);
    localcjr1.Trh = (localcjr1.Trg.size() - 1);
    localcjr1.Trj = false;
    c(localcjr1);
    AppMethodBeat.o(185586);
  }
  
  public static dhx ayH(String paramString)
  {
    AppMethodBeat.i(256136);
    if (paramString == null)
    {
      AppMethodBeat.o(256136);
      return null;
    }
    cjr localcjr = dfm();
    if ((localcjr == null) || (localcjr.Trf.isEmpty()))
    {
      AppMethodBeat.o(256136);
      return null;
    }
    int i = localcjr.Trf.size() - 1;
    while (i >= 0)
    {
      dhx localdhx = (dhx)localcjr.Trf.get(i);
      if ((localdhx != null) && (paramString.equals(localdhx.sessionId)) && (i - 1 >= 0))
      {
        paramString = (dhx)localcjr.Trf.get(i - 1);
        AppMethodBeat.o(256136);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(256136);
    return null;
  }
  
  public static void ayI(String paramString)
  {
    AppMethodBeat.i(122142);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122142);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, clearCurSession: %s", new Object[] { paramString });
    cjr localcjr = dfm();
    if ((localcjr == null) || (localcjr.Trf.isEmpty()))
    {
      AppMethodBeat.o(122142);
      return;
    }
    int i = localcjr.Trf.size();
    Log.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
    i -= 1;
    while (i >= 0)
    {
      dhx localdhx = (dhx)localcjr.Trf.get(i);
      if (localdhx != null)
      {
        Log.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s", new Object[] { localdhx.sessionId });
        if (paramString.equals(localdhx.sessionId))
        {
          localcjr.Trf.remove(i);
          localcjr.FXs = (localcjr.Trf.size() - 1);
          c(localcjr);
          AppMethodBeat.o(122142);
          return;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(122142);
  }
  
  public static void b(cjr paramcjr)
  {
    AppMethodBeat.i(122135);
    if (paramcjr == null)
    {
      AppMethodBeat.o(122135);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, setHellSession");
    c(paramcjr);
    AppMethodBeat.o(122135);
  }
  
  public static void b(dht paramdht)
  {
    AppMethodBeat.i(122140);
    if (paramdht == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    cjr localcjr = dfm();
    if (localcjr == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    if (!e(localcjr))
    {
      AppMethodBeat.o(122140);
      return;
    }
    localcjr.Trg.set(localcjr.Trh, paramdht);
    c(localcjr);
    AppMethodBeat.o(122140);
  }
  
  private static void c(cjr paramcjr)
  {
    AppMethodBeat.i(122144);
    if (paramcjr == null)
    {
      AppMethodBeat.o(122144);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_key_hell_sessions", paramcjr.toByteArray());
      AppMethodBeat.o(122144);
      return;
    }
    catch (Exception paramcjr)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionDao", paramcjr, "HellSessionDao._writeBack: %s", new Object[] { paramcjr.getMessage() });
      AppMethodBeat.o(122144);
    }
  }
  
  private static boolean d(cjr paramcjr)
  {
    AppMethodBeat.i(122147);
    if (paramcjr == null)
    {
      AppMethodBeat.o(122147);
      return false;
    }
    if ((paramcjr.FXs >= 0) && (paramcjr.FXs < paramcjr.Trf.size()))
    {
      AppMethodBeat.o(122147);
      return true;
    }
    AppMethodBeat.o(122147);
    return false;
  }
  
  public static long dfg()
  {
    AppMethodBeat.i(122130);
    cjr localcjr2 = dfm();
    cjr localcjr1 = localcjr2;
    if (localcjr2 == null) {
      localcjr1 = new cjr();
    }
    long l = localcjr1.jUq;
    localcjr1.jUq = (1L + l);
    c(localcjr1);
    AppMethodBeat.o(122130);
    return l;
  }
  
  public static void dfh()
  {
    AppMethodBeat.i(122131);
    cjr localcjr = dfm();
    if (localcjr == null)
    {
      AppMethodBeat.o(122131);
      return;
    }
    localcjr.jUq = 0L;
    c(localcjr);
    AppMethodBeat.o(122131);
  }
  
  public static dhx dfi()
  {
    AppMethodBeat.i(122134);
    Object localObject = dfm();
    if (localObject == null)
    {
      AppMethodBeat.o(122134);
      return null;
    }
    if (d((cjr)localObject))
    {
      localObject = (dhx)((cjr)localObject).Trf.get(((cjr)localObject).FXs);
      AppMethodBeat.o(122134);
      return localObject;
    }
    AppMethodBeat.o(122134);
    return null;
  }
  
  public static dhx dfj()
  {
    AppMethodBeat.i(122137);
    Object localObject = dfm();
    if ((localObject == null) || (((cjr)localObject).Trf.isEmpty()))
    {
      AppMethodBeat.o(122137);
      return null;
    }
    if (d((cjr)localObject))
    {
      localObject = (dhx)((cjr)localObject).Trf.get(((cjr)localObject).FXs);
      AppMethodBeat.o(122137);
      return localObject;
    }
    localObject = (dhx)((cjr)localObject).Trf.getLast();
    AppMethodBeat.o(122137);
    return localObject;
  }
  
  public static dhx dfk()
  {
    AppMethodBeat.i(122138);
    Object localObject = dfm();
    if ((localObject == null) || (((cjr)localObject).Trf.isEmpty()))
    {
      AppMethodBeat.o(122138);
      return null;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "getLastSession, hellSession: %s", new Object[] { Integer.valueOf(((cjr)localObject).FXs) });
    if (d((cjr)localObject))
    {
      if (((cjr)localObject).FXs - 1 < 0)
      {
        AppMethodBeat.o(122138);
        return null;
      }
      localObject = (dhx)((cjr)localObject).Trf.get(((cjr)localObject).FXs - 1);
      AppMethodBeat.o(122138);
      return localObject;
    }
    AppMethodBeat.o(122138);
    return null;
  }
  
  public static dht dfl()
  {
    AppMethodBeat.i(185587);
    Object localObject = dfm();
    if (localObject == null)
    {
      AppMethodBeat.o(185587);
      return null;
    }
    if (e((cjr)localObject))
    {
      localObject = (dht)((cjr)localObject).Trg.get(((cjr)localObject).Trh);
      AppMethodBeat.o(185587);
      return localObject;
    }
    AppMethodBeat.o(185587);
    return null;
  }
  
  public static cjr dfm()
  {
    AppMethodBeat.i(122145);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("mmkv_key_hell_sessions");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122145);
      return null;
    }
    cjr localcjr = new cjr();
    try
    {
      localcjr.parseFrom(arrayOfByte);
      AppMethodBeat.o(122145);
      return localcjr;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionDao", localException, "HellSessionDao._read", new Object[0]);
      AppMethodBeat.o(122145);
    }
    return null;
  }
  
  private static boolean e(cjr paramcjr)
  {
    AppMethodBeat.i(122148);
    if (paramcjr == null)
    {
      AppMethodBeat.o(122148);
      return false;
    }
    if ((paramcjr.Trh >= 0) && (paramcjr.Trh < paramcjr.Trg.size()))
    {
      AppMethodBeat.o(122148);
      return true;
    }
    AppMethodBeat.o(122148);
    return false;
  }
  
  public static void l(dhx paramdhx)
  {
    AppMethodBeat.i(122132);
    cjr localcjr = dfm();
    if (localcjr == null) {
      localcjr = new cjr();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramdhx);
      if (!localcjr.Trf.isEmpty())
      {
        dhx localdhx = (dhx)localcjr.Trf.getLast();
        if ((localdhx != null) && (localdhx.lEK != 1))
        {
          String str1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(localdhx.sessionId);
          String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramdhx.sessionId);
          if ((str1 != null) && (str1.equals(str2)))
          {
            localdhx.lEK = 1;
            localdhx.endTime = System.currentTimeMillis();
            Log.i("HABBYGE-MALI.HellSessionDao", "onSessionClose-addSession: %s", new Object[] { localdhx.sessionId });
          }
        }
      }
      localcjr.Trf.addLast(paramdhx);
      localcjr.FXs = (localcjr.Trf.size() - 1);
      if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayt(paramdhx.sessionId)) {
        localcjr.Trj = true;
      }
      Log.i("HABBYGE-MALI.HellSessionDao", "addSession: %s, %b", new Object[] { paramdhx.sessionId, Boolean.valueOf(localcjr.Trj) });
      c(localcjr);
      AppMethodBeat.o(122132);
      return;
    }
  }
  
  public static void m(dhx paramdhx)
  {
    AppMethodBeat.i(122133);
    cjr localcjr = dfm();
    if (localcjr == null)
    {
      AppMethodBeat.o(122133);
      return;
    }
    if (!d(localcjr))
    {
      AppMethodBeat.o(122133);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramdhx);
    localcjr.Trf.set(localcjr.FXs, paramdhx);
    Log.i("HABBYGE-MALI.HellSessionDao", "updateCurSession, newSession: %s, %s, %d", new Object[] { paramdhx.sessionId, paramdhx.TOW, Integer.valueOf(paramdhx.TOX) });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayt(paramdhx.sessionId)) {
      localcjr.Trj = true;
    }
    c(localcjr);
    AppMethodBeat.o(122133);
  }
  
  public static void n(dhx paramdhx)
  {
    AppMethodBeat.i(122136);
    if (paramdhx == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    cjr localcjr = dfm();
    if (localcjr == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    if (!d(localcjr))
    {
      AppMethodBeat.o(122136);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, updateSessionOnClose");
    localcjr.Trf.set(localcjr.FXs, paramdhx);
    localcjr.FXs = -1;
    c(localcjr);
    AppMethodBeat.o(122136);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(122146);
    Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, reset");
    com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_key_hell_sessions", new byte[0]);
    AppMethodBeat.o(122146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.c
 * JD-Core Version:    0.7.0.1
 */