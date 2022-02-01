package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class c
{
  public static cie a(cie paramcie, String paramString, long paramLong)
  {
    AppMethodBeat.i(122149);
    cie localcie = new cie();
    localcie.sessionId = paramString;
    localcie.Hup = paramcie.Hup;
    localcie.Hus = paramcie.Hus;
    localcie.Hut = false;
    localcie.hTf = 0;
    localcie.Huq = paramcie.Huq;
    localcie.userName = paramcie.userName;
    localcie.Hur = paramcie.Hur;
    localcie.Hus = paramcie.Hus;
    localcie.seq = crE();
    localcie.startTime = paramLong;
    localcie.Huu = paramcie.Huu;
    AppMethodBeat.o(122149);
    return localcie;
  }
  
  public static void a(cia paramcia)
  {
    AppMethodBeat.i(185586);
    bow localbow2 = crK();
    bow localbow1 = localbow2;
    if (localbow2 == null) {
      localbow1 = new bow();
    }
    localbow1.Hcq.addLast(paramcia);
    localbow1.Hcr = (localbow1.Hcq.size() - 1);
    localbow1.Hct = false;
    c(localbow1);
    AppMethodBeat.o(185586);
  }
  
  public static cie afV(String paramString)
  {
    AppMethodBeat.i(196132);
    if (paramString == null)
    {
      AppMethodBeat.o(196132);
      return null;
    }
    bow localbow = crK();
    if ((localbow == null) || (localbow.Hco.isEmpty()))
    {
      AppMethodBeat.o(196132);
      return null;
    }
    int i = localbow.Hco.size() - 1;
    while (i >= 0)
    {
      cie localcie = (cie)localbow.Hco.get(i);
      if ((localcie != null) && (paramString.equals(localcie.sessionId)) && (i - 1 >= 0))
      {
        paramString = (cie)localbow.Hco.get(i - 1);
        AppMethodBeat.o(196132);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(196132);
    return null;
  }
  
  public static void afW(String paramString)
  {
    AppMethodBeat.i(122142);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122142);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, clearCurSession: %s", new Object[] { paramString });
    bow localbow = crK();
    if ((localbow == null) || (localbow.Hco.isEmpty()))
    {
      AppMethodBeat.o(122142);
      return;
    }
    int i = localbow.Hco.size();
    ae.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
    i -= 1;
    while (i >= 0)
    {
      cie localcie = (cie)localbow.Hco.get(i);
      if (localcie != null)
      {
        ae.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s", new Object[] { localcie.sessionId });
        if (paramString.equals(localcie.sessionId))
        {
          localbow.Hco.remove(i);
          localbow.Hcp = (localbow.Hco.size() - 1);
          c(localbow);
          AppMethodBeat.o(122142);
          return;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(122142);
  }
  
  public static void b(bow parambow)
  {
    AppMethodBeat.i(122135);
    if (parambow == null)
    {
      AppMethodBeat.o(122135);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, setHellSession");
    c(parambow);
    AppMethodBeat.o(122135);
  }
  
  public static void b(cia paramcia)
  {
    AppMethodBeat.i(122140);
    if (paramcia == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    bow localbow = crK();
    if (localbow == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    if (!e(localbow))
    {
      AppMethodBeat.o(122140);
      return;
    }
    localbow.Hcq.set(localbow.Hcr, paramcia);
    c(localbow);
    AppMethodBeat.o(122140);
  }
  
  private static void c(bow parambow)
  {
    AppMethodBeat.i(122144);
    if (parambow == null)
    {
      AppMethodBeat.o(122144);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_hell_sessions", parambow.toByteArray());
      AppMethodBeat.o(122144);
      return;
    }
    catch (Exception parambow)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellSessionDao", parambow, "HellSessionDao._writeBack: %s", new Object[] { parambow.getMessage() });
      AppMethodBeat.o(122144);
    }
  }
  
  public static long crE()
  {
    AppMethodBeat.i(122130);
    bow localbow2 = crK();
    bow localbow1 = localbow2;
    if (localbow2 == null) {
      localbow1 = new bow();
    }
    long l = localbow1.gvD;
    localbow1.gvD = (1L + l);
    c(localbow1);
    AppMethodBeat.o(122130);
    return l;
  }
  
  public static void crF()
  {
    AppMethodBeat.i(122131);
    bow localbow = crK();
    if (localbow == null)
    {
      AppMethodBeat.o(122131);
      return;
    }
    localbow.gvD = 0L;
    c(localbow);
    AppMethodBeat.o(122131);
  }
  
  public static cie crG()
  {
    AppMethodBeat.i(122134);
    Object localObject = crK();
    if (localObject == null)
    {
      AppMethodBeat.o(122134);
      return null;
    }
    if (d((bow)localObject))
    {
      localObject = (cie)((bow)localObject).Hco.get(((bow)localObject).Hcp);
      AppMethodBeat.o(122134);
      return localObject;
    }
    AppMethodBeat.o(122134);
    return null;
  }
  
  public static cie crH()
  {
    AppMethodBeat.i(122137);
    Object localObject = crK();
    if ((localObject == null) || (((bow)localObject).Hco.isEmpty()))
    {
      AppMethodBeat.o(122137);
      return null;
    }
    if (d((bow)localObject))
    {
      localObject = (cie)((bow)localObject).Hco.get(((bow)localObject).Hcp);
      AppMethodBeat.o(122137);
      return localObject;
    }
    localObject = (cie)((bow)localObject).Hco.getLast();
    AppMethodBeat.o(122137);
    return localObject;
  }
  
  public static cie crI()
  {
    AppMethodBeat.i(122138);
    Object localObject = crK();
    if ((localObject == null) || (((bow)localObject).Hco.isEmpty()))
    {
      AppMethodBeat.o(122138);
      return null;
    }
    ae.i("HABBYGE-MALI.HellSessionDao", "getLastSession, hellSession: %s", new Object[] { Integer.valueOf(((bow)localObject).Hcp) });
    if (d((bow)localObject))
    {
      if (((bow)localObject).Hcp - 1 < 0)
      {
        AppMethodBeat.o(122138);
        return null;
      }
      localObject = (cie)((bow)localObject).Hco.get(((bow)localObject).Hcp - 1);
      AppMethodBeat.o(122138);
      return localObject;
    }
    AppMethodBeat.o(122138);
    return null;
  }
  
  public static cia crJ()
  {
    AppMethodBeat.i(185587);
    Object localObject = crK();
    if (localObject == null)
    {
      AppMethodBeat.o(185587);
      return null;
    }
    if (e((bow)localObject))
    {
      localObject = (cia)((bow)localObject).Hcq.get(((bow)localObject).Hcr);
      AppMethodBeat.o(185587);
      return localObject;
    }
    AppMethodBeat.o(185587);
    return null;
  }
  
  public static bow crK()
  {
    AppMethodBeat.i(122145);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_sessions");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ae.e("HABBYGE-MALI.HellSessionDao", "HellSession read(): NULL");
      AppMethodBeat.o(122145);
      return null;
    }
    bow localbow = new bow();
    try
    {
      localbow.parseFrom(arrayOfByte);
      AppMethodBeat.o(122145);
      return localbow;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellSessionDao", localException, "HellSessionDao._read", new Object[0]);
      AppMethodBeat.o(122145);
    }
    return null;
  }
  
  private static boolean d(bow parambow)
  {
    AppMethodBeat.i(122147);
    if (parambow == null)
    {
      AppMethodBeat.o(122147);
      return false;
    }
    if ((parambow.Hcp >= 0) && (parambow.Hcp < parambow.Hco.size()))
    {
      AppMethodBeat.o(122147);
      return true;
    }
    AppMethodBeat.o(122147);
    return false;
  }
  
  private static boolean e(bow parambow)
  {
    AppMethodBeat.i(122148);
    if (parambow == null)
    {
      AppMethodBeat.o(122148);
      return false;
    }
    if ((parambow.Hcr >= 0) && (parambow.Hcr < parambow.Hcq.size()))
    {
      AppMethodBeat.o(122148);
      return true;
    }
    AppMethodBeat.o(122148);
    return false;
  }
  
  public static void l(cie paramcie)
  {
    AppMethodBeat.i(122132);
    bow localbow = crK();
    if (localbow == null) {
      localbow = new bow();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramcie);
      if (!localbow.Hco.isEmpty())
      {
        cie localcie = (cie)localbow.Hco.getLast();
        if ((localcie != null) && (localcie.hTf != 1))
        {
          String str1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(localcie.sessionId);
          String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramcie.sessionId);
          if ((str1 != null) && (str1.equals(str2)))
          {
            localcie.hTf = 1;
            localcie.endTime = System.currentTimeMillis();
            ae.i("HABBYGE-MALI.HellSessionDao", "onSessionClose-addSession: %s", new Object[] { localcie.sessionId });
          }
        }
      }
      localbow.Hco.addLast(paramcie);
      localbow.Hcp = (localbow.Hco.size() - 1);
      if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afI(paramcie.sessionId)) {
        localbow.Hct = true;
      }
      ae.i("HABBYGE-MALI.HellSessionDao", "addSession: %s, %b", new Object[] { paramcie.sessionId, Boolean.valueOf(localbow.Hct) });
      c(localbow);
      AppMethodBeat.o(122132);
      return;
    }
  }
  
  public static void m(cie paramcie)
  {
    AppMethodBeat.i(122133);
    bow localbow = crK();
    if (localbow == null)
    {
      AppMethodBeat.o(122133);
      return;
    }
    if (!d(localbow))
    {
      AppMethodBeat.o(122133);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramcie);
    localbow.Hco.set(localbow.Hcp, paramcie);
    ae.i("HABBYGE-MALI.HellSessionDao", "updateCurSession, newSession: %s, %s, %d", new Object[] { paramcie.sessionId, paramcie.Hup, Integer.valueOf(paramcie.Huq) });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afI(paramcie.sessionId)) {
      localbow.Hct = true;
    }
    c(localbow);
    AppMethodBeat.o(122133);
  }
  
  public static void n(cie paramcie)
  {
    AppMethodBeat.i(122136);
    if (paramcie == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    bow localbow = crK();
    if (localbow == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    if (!d(localbow))
    {
      AppMethodBeat.o(122136);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, updateSessionOnClose");
    localbow.Hco.set(localbow.Hcp, paramcie);
    localbow.Hcp = -1;
    c(localbow);
    AppMethodBeat.o(122136);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(122146);
    ae.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, reset");
    com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_hell_sessions", new byte[0]);
    AppMethodBeat.o(122146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.c
 * JD-Core Version:    0.7.0.1
 */