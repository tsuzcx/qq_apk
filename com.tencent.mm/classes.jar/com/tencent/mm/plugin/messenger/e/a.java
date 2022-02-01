package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.b.a.ds;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends e
{
  private static final Map<Long, a> vWQ;
  
  static
  {
    AppMethodBeat.i(218178);
    vWQ = new ConcurrentHashMap();
    AppMethodBeat.o(218178);
  }
  
  public static void R(long paramLong, int paramInt)
  {
    AppMethodBeat.i(218176);
    a locala = (a)vWQ.get(Long.valueOf(paramLong));
    if (locala == null)
    {
      ae.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(msgId:%s action:%s)", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(218176);
      return;
    }
    a(locala, paramInt);
    AppMethodBeat.o(218176);
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(218175);
    if (parama == null)
    {
      ae.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(action:%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(218175);
      return;
    }
    ds localds = new ds();
    localds.nr(parama.vWR);
    localds.ns(parama.vWS);
    localds.nt(parama.vWT);
    localds.nu(parama.vWU);
    localds.nv(parama.sessionId);
    localds.dQB = paramInt;
    localds.aLH();
    AppMethodBeat.o(218175);
  }
  
  private static a b(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(218174);
    Object localObject = bu.bI((String)paramMap.get(paramString + ".origin_username"), "");
    String str = bu.bI((String)paramMap.get(paramString + ".heir_username"), "");
    paramMap = bu.bI((String)paramMap.get(paramString + ".succeed_ticket"), "");
    paramString = new a();
    paramString.vWR = ((String)localObject);
    paramString.vWS = str;
    localObject = ((l)g.ab(l.class)).azF().BH((String)localObject);
    paramString.vWT = ((aw)localObject).field_descWordingId;
    paramString.vWU = ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).bC(((aw)localObject).field_openImAppid, ((aw)localObject).field_descWordingId);
    paramString.sessionId = paramMap;
    vWQ.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(218174);
    return paramString;
  }
  
  public static boolean yy(long paramLong)
  {
    AppMethodBeat.i(218177);
    if ((a)vWQ.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(218177);
      return true;
    }
    AppMethodBeat.o(218177);
    return false;
  }
  
  public final void b(Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(218172);
    Object localObject = parama.gte;
    parama = z.a(((cv)localObject).FNG);
    localObject = ((l)g.ab(l.class)).doJ().aJ(parama, ((cv)localObject).xrk);
    String str = m(paramMap, "new_link_succeed_contact");
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onReceivedImp head is null.(%s %s)", new Object[] { parama, Long.valueOf(((ei)localObject).field_msgSvrId) });
      AppMethodBeat.o(218172);
      return;
    }
    a(b(((ei)localObject).field_msgId, paramMap, str), 1);
    AppMethodBeat.o(218172);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(218173);
    String str = m(paramMap, "new_link_succeed_contact");
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(218173);
      return;
    }
    long l = paramBundle.getLong("msg_id");
    paramBundle = (a)vWQ.get(Long.valueOf(l));
    if (paramBundle != null) {}
    for (paramMap = paramBundle; bu.lX(paramString, "link_profile"); paramMap = b(l, paramMap, str))
    {
      a(paramMap, 2);
      AppMethodBeat.o(218173);
      return;
    }
    if (bu.lX(paramString, "new_link_succeed_contact")) {
      a(paramMap, 5);
    }
    AppMethodBeat.o(218173);
  }
  
  public final String dpf()
  {
    return "new_tmpl_type_succeed_contact";
  }
  
  public static final class a
  {
    public String sessionId = "";
    public String vWR = "";
    public String vWS = "";
    public String vWT = "";
    public String vWU = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.a
 * JD-Core Version:    0.7.0.1
 */