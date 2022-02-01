package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.plugin.expt.hellhound.a.a.g;
import com.tencent.mm.plugin.expt.hellhound.a.f.b;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.expt.a.c
{
  private static c pHo;
  
  public static c ccM()
  {
    AppMethodBeat.i(122091);
    if (pHo == null) {}
    try
    {
      pHo = new c();
      c localc = pHo;
      AppMethodBeat.o(122091);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122091);
    }
  }
  
  public static void fx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122094);
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetBizId: requestId:%s, bizId:%s", new Object[] { paramString1, paramString2 });
    jk localjk = new jk();
    localjk.dnA.dnB = paramString1;
    localjk.dnA.dnC = paramString2;
    com.tencent.mm.sdk.b.a.ESL.l(localjk);
    AppMethodBeat.o(122094);
  }
  
  public static void fy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122096);
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionPageId:%s", new Object[] { paramString1, paramString2 });
    jm localjm = new jm();
    localjm.dnE.dnB = paramString1;
    localjm.dnE.dnF = paramString2;
    com.tencent.mm.sdk.b.a.ESL.l(localjm);
    AppMethodBeat.o(122096);
  }
  
  public static void fz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122097);
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionId:%s", new Object[] { paramString1, paramString2 });
    jl localjl = new jl();
    localjl.dnD.dnB = paramString1;
    localjl.dnD.sessionId = paramString2;
    com.tencent.mm.sdk.b.a.ESL.l(localjl);
    AppMethodBeat.o(122097);
  }
  
  public final void T(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(122095);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(122095);
      return;
    }
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s] bizId[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3 });
    ad.i("AsyncBizCollector", "HABBYGE-MALI, collectBizData: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    bgd localbgd = new bgd();
    localbgd.jOx = paramString3;
    localbgd.value = paramString2;
    localbgd.dvm = paramString1;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(502, localbgd);
    AppMethodBeat.o(122095);
  }
  
  public final void Vm(String paramString)
  {
    AppMethodBeat.i(122093);
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(501, paramString);
    AppMethodBeat.o(122093);
  }
  
  public final String cbk()
  {
    AppMethodBeat.i(169347);
    String str = d.ccN();
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, HellBizService, requestSessionPageId: %s", new Object[] { str });
    AppMethodBeat.o(169347);
    return str;
  }
  
  public final String cbl()
  {
    AppMethodBeat.i(184373);
    String str = b.ccH().ccJ();
    AppMethodBeat.o(184373);
    return str;
  }
  
  public final Map<String, Boolean> cbm()
  {
    AppMethodBeat.i(184374);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO();
    if (((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).pGv == null)
    {
      AppMethodBeat.o(184374);
      return null;
    }
    Object localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).pGv.pFk;
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      AppMethodBeat.o(184374);
      return localObject2;
    }
    localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).pGv.pFj;
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
        g localg = (g)localEntry.getValue();
        ((Map)localObject1).put(localEntry.getKey(), Boolean.valueOf(localg.KEO.isAd));
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
  
  public final void fq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122092);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(122092);
      return;
    }
    ad.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2 });
    bgd localbgd = new bgd();
    localbgd.jOx = paramString1;
    localbgd.value = paramString2;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(500, localbgd);
    AppMethodBeat.o(122092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.c
 * JD-Core Version:    0.7.0.1
 */