package com.tencent.mm.plugin.messenger.f;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.f.b.a.ja;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.e.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends e
{
  private static final Map<Long, a> EWw;
  
  static
  {
    AppMethodBeat.i(213495);
    EWw = new ConcurrentHashMap();
    AppMethodBeat.o(213495);
  }
  
  public static boolean Ow(long paramLong)
  {
    AppMethodBeat.i(213491);
    if ((a)EWw.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(213491);
      return true;
    }
    AppMethodBeat.o(213491);
    return false;
  }
  
  public static void Z(long paramLong, int paramInt)
  {
    AppMethodBeat.i(213488);
    a locala = (a)EWw.get(Long.valueOf(paramLong));
    if (locala == null)
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(msgId:%s action:%s)", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(213488);
      return;
    }
    a(locala, paramInt);
    AppMethodBeat.o(213488);
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(213486);
    if (parama == null)
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(action:%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(213486);
      return;
    }
    ja localja = new ja();
    localja.Ab(parama.EWx);
    localja.Ac(parama.EWy);
    localja.Ad(parama.EWz);
    localja.Ae(parama.EWA);
    localja.Af(parama.sessionId);
    localja.gef = paramInt;
    localja.bpa();
    AppMethodBeat.o(213486);
  }
  
  private static a b(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(213483);
    Object localObject = Util.nullAs((String)paramMap.get(paramString + ".origin_username"), "");
    String str = Util.nullAs((String)paramMap.get(paramString + ".heir_username"), "");
    paramMap = Util.nullAs((String)paramMap.get(paramString + ".succeed_ticket"), "");
    paramString = new a();
    paramString.EWx = ((String)localObject);
    paramString.EWy = str;
    localObject = ((n)h.ae(n.class)).bbL().RG((String)localObject);
    paramString.EWz = ((ax)localObject).field_descWordingId;
    paramString.EWA = ((com.tencent.mm.openim.a.a)h.ae(com.tencent.mm.openim.a.a.class)).bR(((ax)localObject).field_openImAppid, ((ax)localObject).field_descWordingId);
    paramString.sessionId = paramMap;
    EWw.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(213483);
    return paramString;
  }
  
  public final void b(Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(213481);
    Object localObject = parama.jQG;
    parama = z.a(((db)localObject).RID);
    localObject = ((n)h.ae(n.class)).eSe().aL(parama, ((db)localObject).HlH);
    String str = n(paramMap, "new_link_succeed_contact");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onReceivedImp head is null.(%s %s)", new Object[] { parama, Long.valueOf(((et)localObject).field_msgSvrId) });
      AppMethodBeat.o(213481);
      return;
    }
    a(b(((et)localObject).field_msgId, paramMap, str), 1);
    AppMethodBeat.o(213481);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(213482);
    String str = n(paramMap, "new_link_succeed_contact");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(213482);
      return;
    }
    long l = paramBundle.getLong("msg_id");
    paramBundle = (a)EWw.get(Long.valueOf(l));
    if (paramBundle != null) {}
    for (paramMap = paramBundle; Util.isEqual(paramString, "link_profile"); paramMap = b(l, paramMap, str))
    {
      a(paramMap, 2);
      AppMethodBeat.o(213482);
      return;
    }
    if (Util.isEqual(paramString, "new_link_succeed_contact")) {
      a(paramMap, 5);
    }
    AppMethodBeat.o(213482);
  }
  
  public final String eSA()
  {
    return "new_tmpl_type_succeed_contact";
  }
  
  public static final class a
  {
    public String EWA = "";
    public String EWx = "";
    public String EWy = "";
    public String EWz = "";
    public String sessionId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.f.a
 * JD-Core Version:    0.7.0.1
 */