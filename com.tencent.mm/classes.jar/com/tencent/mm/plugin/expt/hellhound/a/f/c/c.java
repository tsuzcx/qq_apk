package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class c
{
  public static bxx WP(String paramString)
  {
    AppMethodBeat.i(190898);
    if (paramString == null)
    {
      AppMethodBeat.o(190898);
      return null;
    }
    bge localbge = cdm();
    if ((localbge == null) || (localbge.DDT.isEmpty()))
    {
      AppMethodBeat.o(190898);
      return null;
    }
    int i = localbge.DDT.size() - 1;
    while (i >= 0)
    {
      bxx localbxx = (bxx)localbge.DDT.get(i);
      if ((localbxx != null) && (paramString.equals(localbxx.sessionId)) && (i - 1 >= 0))
      {
        paramString = (bxx)localbge.DDT.get(i - 1);
        AppMethodBeat.o(190898);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(190898);
    return null;
  }
  
  public static void WQ(String paramString)
  {
    AppMethodBeat.i(122142);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122142);
      return;
    }
    ad.i("HellSessionDao", "HABBYGE-MALI, HellSessionDao, clearCurSession: %s", new Object[] { paramString });
    bge localbge = cdm();
    if ((localbge == null) || (localbge.DDT.isEmpty()))
    {
      AppMethodBeat.o(122142);
      return;
    }
    int i = localbge.DDT.size();
    ad.i("HellSessionDao", "HABBYGE-MALI, clearCurSession, length: %s, %d", new Object[] { paramString, Integer.valueOf(i) });
    i -= 1;
    while (i >= 0)
    {
      bxx localbxx = (bxx)localbge.DDT.get(i);
      if (localbxx != null)
      {
        ad.i("HellSessionDao", "HABBYGE-MALI, clearCurSession, length: %s", new Object[] { localbxx.sessionId });
        if (paramString.equals(localbxx.sessionId))
        {
          localbge.DDT.remove(i);
          localbge.DDU = (localbge.DDT.size() - 1);
          c(localbge);
          AppMethodBeat.o(122142);
          return;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(122142);
  }
  
  public static bxx a(bxx parambxx, String paramString, long paramLong)
  {
    AppMethodBeat.i(122149);
    bxx localbxx = new bxx();
    localbxx.sessionId = paramString;
    localbxx.DUq = parambxx.DUq;
    localbxx.DUt = parambxx.DUt;
    localbxx.DUu = false;
    localbxx.gXt = 0;
    localbxx.DUr = parambxx.DUr;
    localbxx.userName = parambxx.userName;
    localbxx.DUs = parambxx.DUs;
    localbxx.DUt = parambxx.DUt;
    localbxx.seq = cdf();
    localbxx.startTime = paramLong;
    localbxx.DUv = parambxx.DUv;
    AppMethodBeat.o(122149);
    return localbxx;
  }
  
  public static void a(bxt parambxt)
  {
    AppMethodBeat.i(185586);
    bge localbge2 = cdm();
    bge localbge1 = localbge2;
    if (localbge2 == null) {
      localbge1 = new bge();
    }
    localbge1.DDV.addLast(parambxt);
    localbge1.DDW = (localbge1.DDV.size() - 1);
    localbge1.DDZ = false;
    c(localbge1);
    AppMethodBeat.o(185586);
  }
  
  public static void b(bge parambge)
  {
    AppMethodBeat.i(122135);
    if (parambge == null)
    {
      AppMethodBeat.o(122135);
      return;
    }
    ad.i("HellSessionDao", "HABBYGE-MALI, HellSessionDao, setHellSession");
    c(parambge);
    AppMethodBeat.o(122135);
  }
  
  public static void b(bxt parambxt)
  {
    AppMethodBeat.i(122140);
    if (parambxt == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    bge localbge = cdm();
    if (localbge == null)
    {
      AppMethodBeat.o(122140);
      return;
    }
    if (!e(localbge))
    {
      AppMethodBeat.o(122140);
      return;
    }
    localbge.DDV.set(localbge.DDW, parambxt);
    c(localbge);
    AppMethodBeat.o(122140);
  }
  
  private static void c(bge parambge)
  {
    AppMethodBeat.i(122144);
    if (parambge == null)
    {
      AppMethodBeat.o(122144);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_sessions", parambge.toByteArray());
      AppMethodBeat.o(122144);
      return;
    }
    catch (Exception parambge)
    {
      ad.printErrStackTrace("HellSessionDao", parambge, "HABBYGE-MALI, HellSessionDao._writeBack: %s", new Object[] { parambge.getMessage() });
      AppMethodBeat.o(122144);
    }
  }
  
  public static long cdf()
  {
    AppMethodBeat.i(122130);
    bge localbge2 = cdm();
    bge localbge1 = localbge2;
    if (localbge2 == null) {
      localbge1 = new bge();
    }
    long l = localbge1.DDY;
    localbge1.DDY = (1L + l);
    c(localbge1);
    AppMethodBeat.o(122130);
    return l;
  }
  
  public static void cdg()
  {
    AppMethodBeat.i(122131);
    bge localbge = cdm();
    if (localbge == null)
    {
      AppMethodBeat.o(122131);
      return;
    }
    localbge.DDY = 0L;
    c(localbge);
    AppMethodBeat.o(122131);
  }
  
  public static bxx cdh()
  {
    AppMethodBeat.i(122134);
    Object localObject = cdm();
    if (localObject == null)
    {
      AppMethodBeat.o(122134);
      return null;
    }
    if (d((bge)localObject))
    {
      localObject = (bxx)((bge)localObject).DDT.get(((bge)localObject).DDU);
      AppMethodBeat.o(122134);
      return localObject;
    }
    AppMethodBeat.o(122134);
    return null;
  }
  
  public static bxx cdi()
  {
    AppMethodBeat.i(122137);
    Object localObject = cdm();
    if ((localObject == null) || (((bge)localObject).DDT.isEmpty()))
    {
      AppMethodBeat.o(122137);
      return null;
    }
    if (d((bge)localObject))
    {
      localObject = (bxx)((bge)localObject).DDT.get(((bge)localObject).DDU);
      AppMethodBeat.o(122137);
      return localObject;
    }
    localObject = (bxx)((bge)localObject).DDT.getLast();
    AppMethodBeat.o(122137);
    return localObject;
  }
  
  public static bxx cdj()
  {
    AppMethodBeat.i(122138);
    Object localObject = cdm();
    if ((localObject == null) || (((bge)localObject).DDT.isEmpty()))
    {
      AppMethodBeat.o(122138);
      return null;
    }
    ad.i("HellSessionDao", "HABBYGE-MALI, getLastSession, hellSession: %s", new Object[] { Integer.valueOf(((bge)localObject).DDU) });
    if (d((bge)localObject))
    {
      if (((bge)localObject).DDU - 1 < 0)
      {
        AppMethodBeat.o(122138);
        return null;
      }
      localObject = (bxx)((bge)localObject).DDT.get(((bge)localObject).DDU - 1);
      AppMethodBeat.o(122138);
      return localObject;
    }
    AppMethodBeat.o(122138);
    return null;
  }
  
  public static bxt cdk()
  {
    AppMethodBeat.i(185587);
    Object localObject = cdm();
    if (localObject == null)
    {
      AppMethodBeat.o(185587);
      return null;
    }
    if (e((bge)localObject))
    {
      localObject = (bxt)((bge)localObject).DDV.get(((bge)localObject).DDW);
      AppMethodBeat.o(185587);
      return localObject;
    }
    AppMethodBeat.o(185587);
    return null;
  }
  
  public static boolean cdl()
  {
    AppMethodBeat.i(122143);
    bge localbge = cdm();
    if ((localbge != null) && (localbge.DDZ))
    {
      AppMethodBeat.o(122143);
      return true;
    }
    AppMethodBeat.o(122143);
    return false;
  }
  
  public static bge cdm()
  {
    AppMethodBeat.i(122145);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_sessions");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ad.e("HellSessionDao", "HABBYGE-MALI, HellSession read(): NULL");
      AppMethodBeat.o(122145);
      return null;
    }
    bge localbge = new bge();
    try
    {
      localbge.parseFrom(arrayOfByte);
      AppMethodBeat.o(122145);
      return localbge;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HellSessionDao", localException, "HABBYGE-MALI, HellSessionDao._read", new Object[0]);
      AppMethodBeat.o(122145);
    }
    return null;
  }
  
  private static boolean d(bge parambge)
  {
    AppMethodBeat.i(122147);
    if (parambge == null)
    {
      AppMethodBeat.o(122147);
      return false;
    }
    if ((parambge.DDU >= 0) && (parambge.DDU < parambge.DDT.size()))
    {
      AppMethodBeat.o(122147);
      return true;
    }
    AppMethodBeat.o(122147);
    return false;
  }
  
  private static boolean e(bge parambge)
  {
    AppMethodBeat.i(122148);
    if (parambge == null)
    {
      AppMethodBeat.o(122148);
      return false;
    }
    if ((parambge.DDW >= 0) && (parambge.DDW < parambge.DDV.size()))
    {
      AppMethodBeat.o(122148);
      return true;
    }
    AppMethodBeat.o(122148);
    return false;
  }
  
  public static void h(bxx parambxx)
  {
    AppMethodBeat.i(122132);
    bge localbge = cdm();
    if (localbge == null) {
      localbge = new bge();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.e(parambxx);
      if (!localbge.DDT.isEmpty())
      {
        bxx localbxx = (bxx)localbge.DDT.getLast();
        if ((localbxx != null) && (localbxx.gXt != 1))
        {
          String str1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(localbxx.sessionId);
          String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(parambxx.sessionId);
          if ((str1 != null) && (str1.equals(str2)))
          {
            localbxx.gXt = 1;
            localbxx.endTime = System.currentTimeMillis();
            ad.i("HellSessionDao", "HABBYGE-MALI, onSessionClose-addSession: %s", new Object[] { localbxx.sessionId });
          }
        }
      }
      localbge.DDT.addLast(parambxx);
      localbge.DDU = (localbge.DDT.size() - 1);
      if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WB(parambxx.sessionId)) {
        localbge.DDZ = true;
      }
      ad.i("HellSessionDao", "HABBYGE-MALI, addSession: %s, %b", new Object[] { parambxx.sessionId, Boolean.valueOf(localbge.DDZ) });
      c(localbge);
      AppMethodBeat.o(122132);
      return;
    }
  }
  
  public static void i(bxx parambxx)
  {
    AppMethodBeat.i(122133);
    bge localbge = cdm();
    if (localbge == null)
    {
      AppMethodBeat.o(122133);
      return;
    }
    if (!d(localbge))
    {
      AppMethodBeat.o(122133);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.e(parambxx);
    localbge.DDT.set(localbge.DDU, parambxx);
    ad.i("HellSessionDao", "HABBYGE-MALI, updateCurSession, newSession: %s, %s, %d", new Object[] { parambxx.sessionId, parambxx.DUq, Integer.valueOf(parambxx.DUr) });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WB(parambxx.sessionId)) {
      localbge.DDZ = true;
    }
    c(localbge);
    AppMethodBeat.o(122133);
  }
  
  public static void j(bxx parambxx)
  {
    AppMethodBeat.i(122136);
    if (parambxx == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    bge localbge = cdm();
    if (localbge == null)
    {
      AppMethodBeat.o(122136);
      return;
    }
    if (!d(localbge))
    {
      AppMethodBeat.o(122136);
      return;
    }
    ad.i("HellSessionDao", "HABBYGE-MALI, HellSessionDao, updateSessionOnClose");
    localbge.DDT.set(localbge.DDU, parambxx);
    localbge.DDU = -1;
    c(localbge);
    AppMethodBeat.o(122136);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(122146);
    ad.i("HellSessionDao", "HABBYGE-MALI, HellSessionDao, reset");
    com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_sessions", new byte[0]);
    AppMethodBeat.o(122146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.c
 * JD-Core Version:    0.7.0.1
 */