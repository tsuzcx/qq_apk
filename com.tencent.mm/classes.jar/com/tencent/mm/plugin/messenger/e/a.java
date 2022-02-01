package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends e
{
  private static final Map<Long, a> tzk;
  
  static
  {
    AppMethodBeat.i(196735);
    tzk = new ConcurrentHashMap();
    AppMethodBeat.o(196735);
  }
  
  public static void K(long paramLong, int paramInt)
  {
    AppMethodBeat.i(196733);
    a locala = (a)tzk.get(Long.valueOf(paramLong));
    if (locala == null)
    {
      ad.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(msgId:%s action:%s)", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(196733);
      return;
    }
    a(locala, paramInt);
    AppMethodBeat.o(196733);
  }
  
  private static a a(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(196731);
    Object localObject = bt.by((String)paramMap.get(paramString + ".origin_username"), "");
    String str = bt.by((String)paramMap.get(paramString + ".heir_username"), "");
    paramMap = bt.by((String)paramMap.get(paramString + ".succeed_ticket"), "");
    paramString = new a();
    paramString.tzl = ((String)localObject);
    paramString.tzm = str;
    localObject = ((k)g.ab(k.class)).apM().aHY((String)localObject);
    paramString.tzn = ((au)localObject).field_descWordingId;
    paramString.tzo = ((b)g.ab(b.class)).bt(((au)localObject).field_openImAppid, ((au)localObject).field_descWordingId);
    paramString.sessionId = paramMap;
    tzk.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(196731);
    return paramString;
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(196732);
    if (parama == null)
    {
      ad.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(action:%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(196732);
      return;
    }
    bj localbj = new bj();
    localbj.ie(parama.tzl);
    localbj.jdMethod_if(parama.tzm);
    localbj.ig(parama.tzn);
    localbj.ih(parama.tzo);
    localbj.ii(parama.sessionId);
    localbj.dFd = paramInt;
    localbj.aBj();
    AppMethodBeat.o(196732);
  }
  
  public static boolean rs(long paramLong)
  {
    AppMethodBeat.i(196734);
    if ((a)tzk.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(196734);
      return true;
    }
    AppMethodBeat.o(196734);
    return false;
  }
  
  public final void b(Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(196729);
    Object localObject = parama.fTo;
    parama = z.a(((cs)localObject).Cxx);
    localObject = ((k)g.ab(k.class)).cOI().aD(parama, ((cs)localObject).uKZ);
    String str = l(paramMap, "new_link_succeed_contact");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onReceivedImp head is null.(%s %s)", new Object[] { parama, Long.valueOf(((du)localObject).field_msgSvrId) });
      AppMethodBeat.o(196729);
      return;
    }
    a(a(((du)localObject).field_msgId, paramMap, str), 1);
    AppMethodBeat.o(196729);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(196730);
    String str = l(paramMap, "new_link_succeed_contact");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(196730);
      return;
    }
    long l = paramBundle.getLong("msg_id");
    paramBundle = (a)tzk.get(Long.valueOf(l));
    if (paramBundle != null) {}
    for (paramMap = paramBundle; bt.kU(paramString, "link_profile"); paramMap = a(l, paramMap, str))
    {
      a(paramMap, 2);
      AppMethodBeat.o(196730);
      return;
    }
    if (bt.kU(paramString, "new_link_succeed_contact")) {
      a(paramMap, 5);
    }
    AppMethodBeat.o(196730);
  }
  
  public final String cPd()
  {
    return "new_tmpl_type_succeed_contact";
  }
  
  public static final class a
  {
    public String sessionId = "";
    public String tzl = "";
    public String tzm = "";
    public String tzn = "";
    public String tzo = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.a
 * JD-Core Version:    0.7.0.1
 */