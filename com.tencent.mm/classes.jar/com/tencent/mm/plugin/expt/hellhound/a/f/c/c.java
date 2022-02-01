package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class c
{
  public static ccs a(ccs paramccs, String paramString, long paramLong)
  {
    AppMethodBeat.i(122149);
    ccs localccs = new ccs();
    localccs.sessionId = paramString;
    localccs.Frd = paramccs.Frd;
    localccs.Frg = paramccs.Frg;
    localccs.Frh = false;
    localccs.hxS = 0;
    localccs.Fre = paramccs.Fre;
    localccs.userName = paramccs.userName;
    localccs.Frf = paramccs.Frf;
    localccs.Frg = paramccs.Frg;
    localccs.seq = ckN();
    localccs.startTime = paramLong;
    localccs.Fri = paramccs.Fri;
    AppMethodBeat.o(122149);
    return localccs;
  }
  
  public static void a(cco paramcco)
  {
    AppMethodBeat.i(185586);
    bjw localbjw2 = ckU();
    bjw localbjw1 = localbjw2;
    if (localbjw2 == null) {
      localbjw1 = new bjw();
    }
    localbjw1.EZq.addLast(paramcco);
    localbjw1.EZr = (localbjw1.EZq.size() - 1);
    localbjw1.EZu = false;
    c(localbjw1);
    AppMethodBeat.o(185586);
  }
  
  public static ccs abm(String paramString)
  {
    AppMethodBeat.i(195293);
    if (paramString == null)
    {
      AppMethodBeat.o(195293);
      return null;
    }
    bjw localbjw = ckU();
    if ((localbjw == null) || (localbjw.EZo.isEmpty()))
    {
      AppMethodBeat.o(195293);
      return null;
    }
    int i = localbjw.EZo.size() - 1;
    while (i >= 0)
    {
      ccs localccs = (ccs)localbjw.EZo.get(i);
      if ((localccs != null) && (paramString.equals(localccs.sessionId)) && (i - 1 >= 0))
      {
        paramString = (ccs)localbjw.EZo.get(i - 1);
        AppMethodBeat.o(195293);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(195293);
    return null;
  }
  
  public static void abn(String paramString)
  {
    AppMethodBeat.i(122142);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122142);
      return;
    }
    ac.i("HellSessionDao", "HABBYGE-MALI, HellSessionDao, clearCurSession: %s", new Object[] { paramString });
    bjw localbjw = ckU();
    if ((localbjw == null) || (localbjw.EZo.isEmpty()))
    {
      AppMethodBeat.o(122142);
      return;
    }
    int i = localbjw.EZo.size();
    ac.i("HellSessionDao", "HABBYGE-MALI, clearCurSession, length: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
    i -= 1;
    while (i >= 0)
    {
      ccs localccs = (ccs)localbjw.EZo.get(i);
      if (localccs != null)
      {
        ac.i("HellSessionDao", "HABBYGE-MALI, clearCurSession, length: %s", new Object[] { localccs.sessionId });
        if (paramString.equals(localccs.sessionId))
        {
          localbjw.EZo.remove(i);
          localbjw.EZp = (localbjw.EZo.size() - 1);
          c(localbjw);
          AppMethodBeat.o(122142);
          return;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(122142);
  }
  
  public static void b(bjw parambjw)
  {
    AppMethodBeat.i(122135);
    if (parambjw == null)
    {
      AppMethodBeat.o(122135);
      return;
    }
    ac.i("HellSessionDao", "HABBYGE-MALI, HellSessionDao, setHellSession");
    c(parambjw);
    AppMethodBeat.o(122135);
  }
  
  public static void b(cco paramcco)
  {
    AppMethodBeat.i(122140);
    if (paramcco == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    bjw localbjw = ckU();
    if (localbjw == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    if (!e(localbjw))
    {
      AppMethodBeat.o(122140);
      return;
    }
    localbjw.EZq.set(localbjw.EZr, paramcco);
    c(localbjw);
    AppMethodBeat.o(122140);
  }
  
  private static void c(bjw parambjw)
  {
    AppMethodBeat.i(122144);
    if (parambjw == null)
    {
      AppMethodBeat.o(122144);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_sessions", parambjw.toByteArray());
      AppMethodBeat.o(122144);
      return;
    }
    catch (Exception parambjw)
    {
      ac.printErrStackTrace("HellSessionDao", parambjw, "HABBYGE-MALI, HellSessionDao._writeBack: %s", new Object[] { parambjw.getMessage() });
      AppMethodBeat.o(122144);
    }
  }
  
  public static long ckN()
  {
    AppMethodBeat.i(122130);
    bjw localbjw2 = ckU();
    bjw localbjw1 = localbjw2;
    if (localbjw2 == null) {
      localbjw1 = new bjw();
    }
    long l = localbjw1.EZt;
    localbjw1.EZt = (1L + l);
    c(localbjw1);
    AppMethodBeat.o(122130);
    return l;
  }
  
  public static void ckO()
  {
    AppMethodBeat.i(122131);
    bjw localbjw = ckU();
    if (localbjw == null)
    {
      AppMethodBeat.o(122131);
      return;
    }
    localbjw.EZt = 0L;
    c(localbjw);
    AppMethodBeat.o(122131);
  }
  
  public static ccs ckP()
  {
    AppMethodBeat.i(122134);
    Object localObject = ckU();
    if (localObject == null)
    {
      AppMethodBeat.o(122134);
      return null;
    }
    if (d((bjw)localObject))
    {
      localObject = (ccs)((bjw)localObject).EZo.get(((bjw)localObject).EZp);
      AppMethodBeat.o(122134);
      return localObject;
    }
    AppMethodBeat.o(122134);
    return null;
  }
  
  public static ccs ckQ()
  {
    AppMethodBeat.i(122137);
    Object localObject = ckU();
    if ((localObject == null) || (((bjw)localObject).EZo.isEmpty()))
    {
      AppMethodBeat.o(122137);
      return null;
    }
    if (d((bjw)localObject))
    {
      localObject = (ccs)((bjw)localObject).EZo.get(((bjw)localObject).EZp);
      AppMethodBeat.o(122137);
      return localObject;
    }
    localObject = (ccs)((bjw)localObject).EZo.getLast();
    AppMethodBeat.o(122137);
    return localObject;
  }
  
  public static ccs ckR()
  {
    AppMethodBeat.i(122138);
    Object localObject = ckU();
    if ((localObject == null) || (((bjw)localObject).EZo.isEmpty()))
    {
      AppMethodBeat.o(122138);
      return null;
    }
    ac.i("HellSessionDao", "HABBYGE-MALI, getLastSession, hellSession: %s", new Object[] { Integer.valueOf(((bjw)localObject).EZp) });
    if (d((bjw)localObject))
    {
      if (((bjw)localObject).EZp - 1 < 0)
      {
        AppMethodBeat.o(122138);
        return null;
      }
      localObject = (ccs)((bjw)localObject).EZo.get(((bjw)localObject).EZp - 1);
      AppMethodBeat.o(122138);
      return localObject;
    }
    AppMethodBeat.o(122138);
    return null;
  }
  
  public static cco ckS()
  {
    AppMethodBeat.i(185587);
    Object localObject = ckU();
    if (localObject == null)
    {
      AppMethodBeat.o(185587);
      return null;
    }
    if (e((bjw)localObject))
    {
      localObject = (cco)((bjw)localObject).EZq.get(((bjw)localObject).EZr);
      AppMethodBeat.o(185587);
      return localObject;
    }
    AppMethodBeat.o(185587);
    return null;
  }
  
  public static boolean ckT()
  {
    AppMethodBeat.i(122143);
    bjw localbjw = ckU();
    if ((localbjw != null) && (localbjw.EZu))
    {
      AppMethodBeat.o(122143);
      return true;
    }
    AppMethodBeat.o(122143);
    return false;
  }
  
  public static bjw ckU()
  {
    AppMethodBeat.i(122145);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_sessions");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ac.e("HellSessionDao", "HABBYGE-MALI, HellSession read(): NULL");
      AppMethodBeat.o(122145);
      return null;
    }
    bjw localbjw = new bjw();
    try
    {
      localbjw.parseFrom(arrayOfByte);
      AppMethodBeat.o(122145);
      return localbjw;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("HellSessionDao", localException, "HABBYGE-MALI, HellSessionDao._read", new Object[0]);
      AppMethodBeat.o(122145);
    }
    return null;
  }
  
  private static boolean d(bjw parambjw)
  {
    AppMethodBeat.i(122147);
    if (parambjw == null)
    {
      AppMethodBeat.o(122147);
      return false;
    }
    if ((parambjw.EZp >= 0) && (parambjw.EZp < parambjw.EZo.size()))
    {
      AppMethodBeat.o(122147);
      return true;
    }
    AppMethodBeat.o(122147);
    return false;
  }
  
  private static boolean e(bjw parambjw)
  {
    AppMethodBeat.i(122148);
    if (parambjw == null)
    {
      AppMethodBeat.o(122148);
      return false;
    }
    if ((parambjw.EZr >= 0) && (parambjw.EZr < parambjw.EZq.size()))
    {
      AppMethodBeat.o(122148);
      return true;
    }
    AppMethodBeat.o(122148);
    return false;
  }
  
  public static void i(ccs paramccs)
  {
    AppMethodBeat.i(122132);
    bjw localbjw = ckU();
    if (localbjw == null) {
      localbjw = new bjw();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.f(paramccs);
      if (!localbjw.EZo.isEmpty())
      {
        ccs localccs = (ccs)localbjw.EZo.getLast();
        if ((localccs != null) && (localccs.hxS != 1))
        {
          String str1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(localccs.sessionId);
          String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(paramccs.sessionId);
          if ((str1 != null) && (str1.equals(str2)))
          {
            localccs.hxS = 1;
            localccs.endTime = System.currentTimeMillis();
            ac.i("HellSessionDao", "HABBYGE-MALI, onSessionClose-addSession: %s", new Object[] { localccs.sessionId });
          }
        }
      }
      localbjw.EZo.addLast(paramccs);
      localbjw.EZp = (localbjw.EZo.size() - 1);
      if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaY(paramccs.sessionId)) {
        localbjw.EZu = true;
      }
      ac.i("HellSessionDao", "HABBYGE-MALI, addSession: %s, %b", new Object[] { paramccs.sessionId, Boolean.valueOf(localbjw.EZu) });
      c(localbjw);
      AppMethodBeat.o(122132);
      return;
    }
  }
  
  public static void j(ccs paramccs)
  {
    AppMethodBeat.i(122133);
    bjw localbjw = ckU();
    if (localbjw == null)
    {
      AppMethodBeat.o(122133);
      return;
    }
    if (!d(localbjw))
    {
      AppMethodBeat.o(122133);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.f(paramccs);
    localbjw.EZo.set(localbjw.EZp, paramccs);
    ac.i("HellSessionDao", "HABBYGE-MALI, updateCurSession, newSession: %s, %s, %d", new Object[] { paramccs.sessionId, paramccs.Frd, Integer.valueOf(paramccs.Fre) });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaY(paramccs.sessionId)) {
      localbjw.EZu = true;
    }
    c(localbjw);
    AppMethodBeat.o(122133);
  }
  
  public static void k(ccs paramccs)
  {
    AppMethodBeat.i(122136);
    if (paramccs == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    bjw localbjw = ckU();
    if (localbjw == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    if (!d(localbjw))
    {
      AppMethodBeat.o(122136);
      return;
    }
    ac.i("HellSessionDao", "HABBYGE-MALI, HellSessionDao, updateSessionOnClose");
    localbjw.EZo.set(localbjw.EZp, paramccs);
    localbjw.EZp = -1;
    c(localbjw);
    AppMethodBeat.o(122136);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(122146);
    ac.i("HellSessionDao", "HABBYGE-MALI, HellSessionDao, reset");
    com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_sessions", new byte[0]);
    AppMethodBeat.o(122146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.c
 * JD-Core Version:    0.7.0.1
 */