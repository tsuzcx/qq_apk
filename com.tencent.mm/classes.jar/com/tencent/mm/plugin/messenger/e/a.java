package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.g.b.a.cx;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends e
{
  private static final Map<Long, a> uHH;
  
  static
  {
    AppMethodBeat.i(198619);
    uHH = new ConcurrentHashMap();
    AppMethodBeat.o(198619);
  }
  
  public static void N(long paramLong, int paramInt)
  {
    AppMethodBeat.i(198617);
    a locala = (a)uHH.get(Long.valueOf(paramLong));
    if (locala == null)
    {
      ac.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(msgId:%s action:%s)", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(198617);
      return;
    }
    a(locala, paramInt);
    AppMethodBeat.o(198617);
  }
  
  private static a a(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(198615);
    Object localObject = bs.bG((String)paramMap.get(paramString + ".origin_username"), "");
    String str = bs.bG((String)paramMap.get(paramString + ".heir_username"), "");
    paramMap = bs.bG((String)paramMap.get(paramString + ".succeed_ticket"), "");
    paramString = new a();
    paramString.uHI = ((String)localObject);
    paramString.uHJ = str;
    localObject = ((k)g.ab(k.class)).awB().aNt((String)localObject);
    paramString.uHK = ((av)localObject).field_descWordingId;
    paramString.uHL = ((b)g.ab(b.class)).bB(((av)localObject).field_openImAppid, ((av)localObject).field_descWordingId);
    paramString.sessionId = paramMap;
    uHH.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(198615);
    return paramString;
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(198616);
    if (parama == null)
    {
      ac.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(action:%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(198616);
      return;
    }
    cx localcx = new cx();
    localcx.kT(parama.uHI);
    localcx.kU(parama.uHJ);
    localcx.kV(parama.uHK);
    localcx.kW(parama.uHL);
    localcx.kX(parama.sessionId);
    localcx.dCQ = paramInt;
    localcx.aHZ();
    AppMethodBeat.o(198616);
  }
  
  public static boolean vV(long paramLong)
  {
    AppMethodBeat.i(198618);
    if ((a)uHH.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(198618);
      return true;
    }
    AppMethodBeat.o(198618);
    return false;
  }
  
  public final void b(Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(198613);
    Object localObject = parama.fXi;
    parama = z.a(((cu)localObject).DPT);
    localObject = ((k)g.ab(k.class)).dcr().aF(parama, ((cu)localObject).vTQ);
    String str = l(paramMap, "new_link_succeed_contact");
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onReceivedImp head is null.(%s %s)", new Object[] { parama, Long.valueOf(((dy)localObject).field_msgSvrId) });
      AppMethodBeat.o(198613);
      return;
    }
    a(a(((dy)localObject).field_msgId, paramMap, str), 1);
    AppMethodBeat.o(198613);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(198614);
    String str = l(paramMap, "new_link_succeed_contact");
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(198614);
      return;
    }
    long l = paramBundle.getLong("msg_id");
    paramBundle = (a)uHH.get(Long.valueOf(l));
    if (paramBundle != null) {}
    for (paramMap = paramBundle; bs.lr(paramString, "link_profile"); paramMap = a(l, paramMap, str))
    {
      a(paramMap, 2);
      AppMethodBeat.o(198614);
      return;
    }
    if (bs.lr(paramString, "new_link_succeed_contact")) {
      a(paramMap, 5);
    }
    AppMethodBeat.o(198614);
  }
  
  public final String dcM()
  {
    return "new_tmpl_type_succeed_contact";
  }
  
  public static final class a
  {
    public String sessionId = "";
    public String uHI = "";
    public String uHJ = "";
    public String uHK = "";
    public String uHL = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.a
 * JD-Core Version:    0.7.0.1
 */