package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.b.a.dq;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends e
{
  private static final Map<Long, a> vKM;
  
  static
  {
    AppMethodBeat.i(211869);
    vKM = new ConcurrentHashMap();
    AppMethodBeat.o(211869);
  }
  
  public static void R(long paramLong, int paramInt)
  {
    AppMethodBeat.i(211867);
    a locala = (a)vKM.get(Long.valueOf(paramLong));
    if (locala == null)
    {
      ad.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(msgId:%s action:%s)", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(211867);
      return;
    }
    a(locala, paramInt);
    AppMethodBeat.o(211867);
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(211866);
    if (parama == null)
    {
      ad.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(action:%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(211866);
      return;
    }
    dq localdq = new dq();
    localdq.mW(parama.vKN);
    localdq.mX(parama.vKO);
    localdq.mY(parama.vKP);
    localdq.mZ(parama.vKQ);
    localdq.na(parama.sessionId);
    localdq.dPl = paramInt;
    localdq.aLk();
    AppMethodBeat.o(211866);
  }
  
  private static a b(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(211865);
    Object localObject = bt.bI((String)paramMap.get(paramString + ".origin_username"), "");
    String str = bt.bI((String)paramMap.get(paramString + ".heir_username"), "");
    paramMap = bt.bI((String)paramMap.get(paramString + ".succeed_ticket"), "");
    paramString = new a();
    paramString.vKN = ((String)localObject);
    paramString.vKO = str;
    localObject = ((l)g.ab(l.class)).azp().Bf((String)localObject);
    paramString.vKP = ((aw)localObject).field_descWordingId;
    paramString.vKQ = ((b)g.ab(b.class)).bC(((aw)localObject).field_openImAppid, ((aw)localObject).field_descWordingId);
    paramString.sessionId = paramMap;
    vKM.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(211865);
    return paramString;
  }
  
  public static boolean ye(long paramLong)
  {
    AppMethodBeat.i(211868);
    if ((a)vKM.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(211868);
      return true;
    }
    AppMethodBeat.o(211868);
    return false;
  }
  
  public final void b(Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(211863);
    Object localObject = parama.gqE;
    parama = z.a(((cv)localObject).Fvi);
    localObject = ((l)g.ab(l.class)).dlK().aI(parama, ((cv)localObject).xbt);
    String str = m(paramMap, "new_link_succeed_contact");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onReceivedImp head is null.(%s %s)", new Object[] { parama, Long.valueOf(((ei)localObject).field_msgSvrId) });
      AppMethodBeat.o(211863);
      return;
    }
    a(b(((ei)localObject).field_msgId, paramMap, str), 1);
    AppMethodBeat.o(211863);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(211864);
    String str = m(paramMap, "new_link_succeed_contact");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(211864);
      return;
    }
    long l = paramBundle.getLong("msg_id");
    paramBundle = (a)vKM.get(Long.valueOf(l));
    if (paramBundle != null) {}
    for (paramMap = paramBundle; bt.lQ(paramString, "link_profile"); paramMap = b(l, paramMap, str))
    {
      a(paramMap, 2);
      AppMethodBeat.o(211864);
      return;
    }
    if (bt.lQ(paramString, "new_link_succeed_contact")) {
      a(paramMap, 5);
    }
    AppMethodBeat.o(211864);
  }
  
  public final String dmg()
  {
    return "new_tmpl_type_succeed_contact";
  }
  
  public static final class a
  {
    public String sessionId = "";
    public String vKN = "";
    public String vKO = "";
    public String vKP = "";
    public String vKQ = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.a
 * JD-Core Version:    0.7.0.1
 */