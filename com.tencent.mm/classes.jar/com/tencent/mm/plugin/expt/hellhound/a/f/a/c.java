package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.js;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.expt.hellhound.a.f.b;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.expt.a.c
{
  private static c qpV;
  
  public static c cku()
  {
    AppMethodBeat.i(122091);
    if (qpV == null) {}
    try
    {
      qpV = new c();
      c localc = qpV;
      AppMethodBeat.o(122091);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122091);
    }
  }
  
  public static void fK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122094);
    ac.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetBizId: requestId:%s, bizId:%s", new Object[] { paramString1, paramString2 });
    jr localjr = new jr();
    localjr.dli.dlj = paramString1;
    localjr.dli.dlk = paramString2;
    com.tencent.mm.sdk.b.a.GpY.l(localjr);
    AppMethodBeat.o(122094);
  }
  
  public static void fL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122096);
    ac.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionPageId:%s", new Object[] { paramString1, paramString2 });
    jt localjt = new jt();
    localjt.dlm.dlj = paramString1;
    localjt.dlm.dln = paramString2;
    com.tencent.mm.sdk.b.a.GpY.l(localjt);
    AppMethodBeat.o(122096);
  }
  
  public static void fM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122097);
    ac.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionId:%s", new Object[] { paramString1, paramString2 });
    js localjs = new js();
    localjs.dll.dlj = paramString1;
    localjs.dll.sessionId = paramString2;
    com.tencent.mm.sdk.b.a.GpY.l(localjs);
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
    ac.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s] bizId[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3 });
    ac.i("AsyncBizCollector", "HABBYGE-MALI, collectBizData: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    bjv localbjv = new bjv();
    localbjv.koY = paramString3;
    localbjv.value = paramString2;
    localbjv.dsY = paramString1;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(502, localbjv);
    AppMethodBeat.o(122095);
  }
  
  public final void Zy(String paramString)
  {
    AppMethodBeat.i(122093);
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(501, paramString);
    AppMethodBeat.o(122093);
  }
  
  public final String cit()
  {
    AppMethodBeat.i(169347);
    String str = d.ckv();
    ac.i("MicroMsg.HellBizService", "HABBYGE-MALI, HellBizService, requestSessionPageId: %s", new Object[] { str });
    AppMethodBeat.o(169347);
    return str;
  }
  
  public final String ciu()
  {
    AppMethodBeat.i(184373);
    String str = b.ckp().ckr();
    AppMethodBeat.o(184373);
    return str;
  }
  
  public final Map<String, Boolean> civ()
  {
    AppMethodBeat.i(184374);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.g.c.clv();
    if (((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).qlE == null)
    {
      AppMethodBeat.o(184374);
      return null;
    }
    Object localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).qlE.qjY;
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      AppMethodBeat.o(184374);
      return localObject2;
    }
    localObject2 = ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).qlE.qjX;
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
        ((Map)localObject1).put(localEntry.getKey(), Boolean.valueOf(localc.qkB.isAd));
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
  
  public final void fD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122092);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(122092);
      return;
    }
    ac.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2 });
    bjv localbjv = new bjv();
    localbjv.koY = paramString1;
    localbjv.value = paramString2;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(500, localbjv);
    AppMethodBeat.o(122092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.c
 * JD-Core Version:    0.7.0.1
 */