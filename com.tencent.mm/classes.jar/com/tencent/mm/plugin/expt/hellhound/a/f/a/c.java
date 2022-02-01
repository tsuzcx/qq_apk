package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.plugin.expt.hellhound.a.f.b;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.expt.b.c
{
  private static c qYU;
  
  public static c cpK()
  {
    AppMethodBeat.i(122091);
    if (qYU == null) {}
    try
    {
      qYU = new c();
      c localc = qYU;
      AppMethodBeat.o(122091);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122091);
    }
  }
  
  public static void fT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122094);
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetBizId: requestId:%s, bizId:%s", new Object[] { paramString1, paramString2 });
    jz localjz = new jz();
    localjz.dwV.dwW = paramString1;
    localjz.dwV.dwX = paramString2;
    com.tencent.mm.sdk.b.a.IbL.l(localjz);
    AppMethodBeat.o(122094);
  }
  
  public static void fU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122096);
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionPageId:%s", new Object[] { paramString1, paramString2 });
    kb localkb = new kb();
    localkb.dwZ.dwW = paramString1;
    localkb.dwZ.dxa = paramString2;
    com.tencent.mm.sdk.b.a.IbL.l(localkb);
    AppMethodBeat.o(122096);
  }
  
  public static void fV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122097);
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionId:%s", new Object[] { paramString1, paramString2 });
    ka localka = new ka();
    localka.dwY.dwW = paramString1;
    localka.dwY.sessionId = paramString2;
    com.tencent.mm.sdk.b.a.IbL.l(localka);
    AppMethodBeat.o(122097);
  }
  
  public final void U(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(122095);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(122095);
      return;
    }
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s] bizId[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3 });
    ad.i("HABBYGE-MALI.AsyncBizCollector", "collectBizData: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    bod localbod = new bod();
    localbod.kJY = paramString3;
    localbod.value = paramString2;
    localbod.dEZ = paramString1;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(502, localbod);
    AppMethodBeat.o(122095);
  }
  
  public final void ade(String paramString)
  {
    AppMethodBeat.i(122093);
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(501, paramString);
    AppMethodBeat.o(122093);
  }
  
  public final String cnc()
  {
    AppMethodBeat.i(169347);
    String str = d.cpL();
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, HellBizService, requestSessionPageId: %s", new Object[] { str });
    AppMethodBeat.o(169347);
    return str;
  }
  
  public final String cnd()
  {
    AppMethodBeat.i(184373);
    String str = b.cpE().cpH();
    AppMethodBeat.o(184373);
    return str;
  }
  
  public final Map<String, Boolean> cne()
  {
    AppMethodBeat.i(184374);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK();
    if (((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).qUB == null)
    {
      AppMethodBeat.o(184374);
      return null;
    }
    Object localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).qUB.qSU;
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      AppMethodBeat.o(184374);
      return localObject2;
    }
    localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).qUB.qST;
    if ((localObject2 == null) || (((Map)localObject2).isEmpty()))
    {
      AppMethodBeat.o(184374);
      return null;
    }
    localObject1 = new HashMap();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (localEntry != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.a.c localc = (com.tencent.mm.plugin.expt.hellhound.a.a.c)localEntry.getValue();
        ((Map)localObject1).put(localEntry.getKey(), Boolean.valueOf(localc.qTx.isAd));
      }
    }
    if (((Map)localObject1).isEmpty())
    {
      AppMethodBeat.o(184374);
      return null;
    }
    AppMethodBeat.o(184374);
    return localObject1;
  }
  
  public final void fN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122092);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(122092);
      return;
    }
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2 });
    bod localbod = new bod();
    localbod.kJY = paramString1;
    localbod.value = paramString2;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(500, localbod);
    AppMethodBeat.o(122092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.c
 * JD-Core Version:    0.7.0.1
 */