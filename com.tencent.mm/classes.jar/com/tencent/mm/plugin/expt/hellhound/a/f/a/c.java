package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.plugin.expt.hellhound.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.b;
import com.tencent.mm.plugin.expt.hellhound.a.g.e;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.expt.b.c
{
  private static c sIw;
  
  public static c cPU()
  {
    AppMethodBeat.i(122091);
    if (sIw == null) {}
    try
    {
      sIw = new c();
      c localc = sIw;
      AppMethodBeat.o(122091);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122091);
    }
  }
  
  public static void gs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122094);
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetBizId: requestId:%s, bizId:%s", new Object[] { paramString1, paramString2 });
    kp localkp = new kp();
    localkp.dPH.dPI = paramString1;
    localkp.dPH.dPJ = paramString2;
    EventCenter.instance.publish(localkp);
    AppMethodBeat.o(122094);
  }
  
  public static void gt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122096);
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionPageId:%s", new Object[] { paramString1, paramString2 });
    kr localkr = new kr();
    localkr.dPL.dPI = paramString1;
    localkr.dPL.dPM = paramString2;
    EventCenter.instance.publish(localkr);
    AppMethodBeat.o(122096);
  }
  
  public static void gu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122097);
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionId:%s", new Object[] { paramString1, paramString2 });
    kq localkq = new kq();
    localkq.dPK.dPI = paramString1;
    localkq.dPK.sessionId = paramString2;
    EventCenter.instance.publish(localkq);
    AppMethodBeat.o(122097);
  }
  
  public final void aa(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(122095);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(122095);
      return;
    }
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s] bizId[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3 });
    Log.i("HABBYGE-MALI.AsyncBizCollector", "collectBizData: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    cbn localcbn = new cbn();
    localcbn.businessId = paramString3;
    localcbn.value = paramString2;
    localcbn.dataPath = paramString1;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(502, localcbn);
    AppMethodBeat.o(122095);
  }
  
  public final void aoe(String paramString)
  {
    AppMethodBeat.i(122093);
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(501, paramString);
    AppMethodBeat.o(122093);
  }
  
  public final String cMD()
  {
    AppMethodBeat.i(169347);
    String str = d.cPV();
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, HellBizService, requestSessionPageId: %s", new Object[] { str });
    AppMethodBeat.o(169347);
    return str;
  }
  
  public final String cME()
  {
    AppMethodBeat.i(184373);
    String str = b.cPO().cPR();
    AppMethodBeat.o(184373);
    return str;
  }
  
  public final Map<String, Boolean> cMF()
  {
    AppMethodBeat.i(184374);
    Object localObject1 = e.cQV();
    if (((e)localObject1).sDg == null)
    {
      AppMethodBeat.o(184374);
      return null;
    }
    Object localObject2 = ((e)localObject1).sDg.sBj;
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      AppMethodBeat.o(184374);
      return localObject2;
    }
    localObject2 = ((e)localObject1).sDg.sBi;
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
        ((Map)localObject1).put(localEntry.getKey(), Boolean.valueOf(localc.sBK.isAd));
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
  
  public final String cMG()
  {
    AppMethodBeat.i(220557);
    String str = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEw + "_" + com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEx;
    AppMethodBeat.o(220557);
    return str;
  }
  
  public final void gk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122092);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(122092);
      return;
    }
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2 });
    cbn localcbn = new cbn();
    localcbn.businessId = paramString1;
    localcbn.value = paramString2;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(500, localcbn);
    AppMethodBeat.o(122092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.c
 * JD-Core Version:    0.7.0.1
 */