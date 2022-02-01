package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.lg;
import com.tencent.mm.f.a.lh;
import com.tencent.mm.f.a.li;
import com.tencent.mm.plugin.expt.hellhound.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.b;
import com.tencent.mm.plugin.expt.hellhound.a.g.e;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.ejv;
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
  private static c wot;
  
  public static c deO()
  {
    AppMethodBeat.i(122091);
    if (wot == null) {}
    try
    {
      wot = new c();
      c localc = wot;
      AppMethodBeat.o(122091);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122091);
    }
  }
  
  public static void gG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122094);
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetBizId: requestId:%s, bizId:%s", new Object[] { paramString1, paramString2 });
    lg locallg = new lg();
    locallg.fIX.fIY = paramString1;
    locallg.fIX.fIZ = paramString2;
    EventCenter.instance.publish(locallg);
    AppMethodBeat.o(122094);
  }
  
  public static void gH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122096);
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionPageId:%s", new Object[] { paramString1, paramString2 });
    li localli = new li();
    localli.fJb.fIY = paramString1;
    localli.fJb.fJc = paramString2;
    EventCenter.instance.publish(localli);
    AppMethodBeat.o(122096);
  }
  
  public static void gI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122097);
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionId:%s", new Object[] { paramString1, paramString2 });
    lh locallh = new lh();
    locallh.fJa.fIY = paramString1;
    locallh.fJa.sessionId = paramString2;
    EventCenter.instance.publish(locallh);
    AppMethodBeat.o(122097);
  }
  
  public final void X(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(122095);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      AppMethodBeat.o(122095);
      return;
    }
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s] bizId[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3 });
    Log.i("HABBYGE-MALI.AsyncBizCollector", "collectBizData: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    cjq localcjq = new cjq();
    localcjq.businessId = paramString3;
    localcjq.value = paramString2;
    localcjq.dataPath = paramString1;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(502, localcjq);
    AppMethodBeat.o(122095);
  }
  
  public final void awc(String paramString)
  {
    AppMethodBeat.i(122093);
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(501, paramString);
    AppMethodBeat.o(122093);
  }
  
  public final String dbr()
  {
    AppMethodBeat.i(169347);
    String str = d.deP();
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, HellBizService, requestSessionPageId: %s", new Object[] { str });
    AppMethodBeat.o(169347);
    return str;
  }
  
  public final String dbs()
  {
    AppMethodBeat.i(184373);
    String str = b.deI().deL();
    AppMethodBeat.o(184373);
    return str;
  }
  
  public final Map<String, Boolean> dbt()
  {
    AppMethodBeat.i(184374);
    Object localObject1 = e.dfQ();
    if (((e)localObject1).wja == null)
    {
      AppMethodBeat.o(184374);
      return null;
    }
    Object localObject2 = ((e)localObject1).wja.whd;
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      AppMethodBeat.o(184374);
      return localObject2;
    }
    localObject2 = ((e)localObject1).wja.whc;
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
        ((Map)localObject1).put(localEntry.getKey(), Boolean.valueOf(localc.whE.isAd));
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
  
  public final String dbu()
  {
    AppMethodBeat.i(256696);
    String str = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkr + "_" + com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wks;
    AppMethodBeat.o(256696);
    return str;
  }
  
  public final void gy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122092);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(122092);
      return;
    }
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2 });
    cjq localcjq = new cjq();
    localcjq.businessId = paramString1;
    localcjq.value = paramString2;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(500, localcjq);
    AppMethodBeat.o(122092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.c
 * JD-Core Version:    0.7.0.1
 */