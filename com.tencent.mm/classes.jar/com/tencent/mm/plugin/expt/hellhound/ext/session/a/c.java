package com.tencent.mm.plugin.expt.hellhound.ext.session.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mm;
import com.tencent.mm.autogen.a.mn;
import com.tencent.mm.autogen.a.mo;
import com.tencent.mm.plugin.expt.hellhound.ext.a.a;
import com.tencent.mm.plugin.expt.hellhound.ext.f.e;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.fed;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.expt.b.d
{
  private static c zKy;
  
  public static c dLD()
  {
    AppMethodBeat.i(122091);
    if (zKy == null) {}
    try
    {
      zKy = new c();
      c localc = zKy;
      AppMethodBeat.o(122091);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122091);
    }
  }
  
  public static void ho(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122094);
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetBizId: requestId:%s, bizId:%s", new Object[] { paramString1, paramString2 });
    mm localmm = new mm();
    localmm.hOF.hOG = paramString1;
    localmm.hOF.hOH = paramString2;
    localmm.publish();
    AppMethodBeat.o(122094);
  }
  
  public static void hp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122096);
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionPageId:%s", new Object[] { paramString1, paramString2 });
    mo localmo = new mo();
    localmo.hOJ.hOG = paramString1;
    localmo.hOJ.hOK = paramString2;
    localmo.publish();
    AppMethodBeat.o(122096);
  }
  
  public static void hq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122097);
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, notifyGetSessionId: requestId:%s, sessionId:%s", new Object[] { paramString1, paramString2 });
    mn localmn = new mn();
    localmn.hOI.hOG = paramString1;
    localmn.hOI.sessionId = paramString2;
    localmn.publish();
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
    czv localczv = new czv();
    localczv.businessId = paramString3;
    localczv.value = paramString2;
    localczv.dataPath = paramString1;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(502, localczv);
    AppMethodBeat.o(122095);
  }
  
  public final void aqc(String paramString)
  {
    AppMethodBeat.i(122093);
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(501, paramString);
    AppMethodBeat.o(122093);
  }
  
  public final String dHN()
  {
    AppMethodBeat.i(169347);
    String str = d.dLE();
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, HellBizService, requestSessionPageId: %s", new Object[] { str });
    AppMethodBeat.o(169347);
    return str;
  }
  
  public final String dHO()
  {
    AppMethodBeat.i(184373);
    String str = b.dLx().dLA();
    AppMethodBeat.o(184373);
    return str;
  }
  
  public final Map<String, Boolean> dHP()
  {
    AppMethodBeat.i(184374);
    Object localObject1 = e.dME();
    if (((e)localObject1).zFd == null)
    {
      AppMethodBeat.o(184374);
      return null;
    }
    Object localObject2 = ((e)localObject1).zFd.zDf;
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      AppMethodBeat.o(184374);
      return localObject2;
    }
    localObject2 = ((e)localObject1).zFd.zDe;
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
        com.tencent.mm.plugin.expt.hellhound.ext.a.c localc = (com.tencent.mm.plugin.expt.hellhound.ext.a.c)localEntry.getValue();
        ((Map)localObject1).put((String)localEntry.getKey(), Boolean.valueOf(localc.zDG.isAd));
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
  
  public final String dHQ()
  {
    AppMethodBeat.i(300183);
    String str = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGw + "_" + com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGx;
    AppMethodBeat.o(300183);
    return str;
  }
  
  public final void he(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122092);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(122092);
      return;
    }
    Log.i("MicroMsg.HellBizService", "HABBYGE-MALI, %d putBizData key[%s] data[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2 });
    czv localczv = new czv();
    localczv.businessId = paramString1;
    localczv.value = paramString2;
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(500, localczv);
    AppMethodBeat.o(122092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.a.c
 * JD-Core Version:    0.7.0.1
 */