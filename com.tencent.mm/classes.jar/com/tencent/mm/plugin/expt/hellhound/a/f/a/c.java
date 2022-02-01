package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.plugin.expt.hellhound.a.f.b;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.expt.b.c
{
  private static c rha;
  
  public static c crm()
  {
    AppMethodBeat.i(122091);
    if (rha == null) {}
    try
    {
      rha = new c();
      c localc = rha;
      AppMethodBeat.o(122091);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122091);
    }
  }
  
  public static void fY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122094);
    ae.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetBizId: requestId:%s, bizId:%s", new Object[] { paramString1, paramString2 });
    ka localka = new ka();
    localka.dya.dyb = paramString1;
    localka.dya.dyc = paramString2;
    com.tencent.mm.sdk.b.a.IvT.l(localka);
    AppMethodBeat.o(122094);
  }
  
  public static void fZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122096);
    ae.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionPageId:%s", new Object[] { paramString1, paramString2 });
    kc localkc = new kc();
    localkc.dye.dyb = paramString1;
    localkc.dye.dyf = paramString2;
    com.tencent.mm.sdk.b.a.IvT.l(localkc);
    AppMethodBeat.o(122096);
  }
  
  public static void ga(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122097);
    ae.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionId:%s", new Object[] { paramString1, paramString2 });
    kb localkb = new kb();
    localkb.dyd.dyb = paramString1;
    localkb.dyd.sessionId = paramString2;
    com.tencent.mm.sdk.b.a.IvT.l(localkb);
    AppMethodBeat.o(122097);
  }
  
  public final void V(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(122095);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(122095);
      return;
    }
    ae.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s] bizId[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3 });
    ae.i("HABBYGE-MALI.AsyncBizCollector", "collectBizData: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    bov localbov = new bov();
    localbov.kNn = paramString3;
    localbov.value = paramString2;
    localbov.dGe = paramString1;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(502, localbov);
    AppMethodBeat.o(122095);
  }
  
  public final void adV(String paramString)
  {
    AppMethodBeat.i(122093);
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(501, paramString);
    AppMethodBeat.o(122093);
  }
  
  public final String cos()
  {
    AppMethodBeat.i(169347);
    String str = d.crn();
    ae.i("MicroMsg.HellBizService", "HABBYGE-MALI, HellBizService, requestSessionPageId: %s", new Object[] { str });
    AppMethodBeat.o(169347);
    return str;
  }
  
  public final String cot()
  {
    AppMethodBeat.i(184373);
    String str = b.crg().crj();
    AppMethodBeat.o(184373);
    return str;
  }
  
  public final Map<String, Boolean> cou()
  {
    AppMethodBeat.i(184374);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.g.c.csm();
    if (((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).rcz == null)
    {
      AppMethodBeat.o(184374);
      return null;
    }
    Object localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).rcz.raS;
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      AppMethodBeat.o(184374);
      return localObject2;
    }
    localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).rcz.raR;
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
        ((Map)localObject1).put(localEntry.getKey(), Boolean.valueOf(localc.rbv.isAd));
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
  
  public final void fR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122092);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(122092);
      return;
    }
    ae.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2 });
    bov localbov = new bov();
    localbov.kNn = paramString1;
    localbov.value = paramString2;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(500, localbov);
    AppMethodBeat.o(122092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.c
 * JD-Core Version:    0.7.0.1
 */