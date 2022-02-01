package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.b.a.gv;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends e
{
  private static final Map<Long, a> zqV;
  
  static
  {
    AppMethodBeat.i(194507);
    zqV = new ConcurrentHashMap();
    AppMethodBeat.o(194507);
  }
  
  public static boolean Hh(long paramLong)
  {
    AppMethodBeat.i(194506);
    if ((a)zqV.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(194506);
      return true;
    }
    AppMethodBeat.o(194506);
    return false;
  }
  
  public static void Q(long paramLong, int paramInt)
  {
    AppMethodBeat.i(194505);
    a locala = (a)zqV.get(Long.valueOf(paramLong));
    if (locala == null)
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(msgId:%s action:%s)", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(194505);
      return;
    }
    a(locala, paramInt);
    AppMethodBeat.o(194505);
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(194504);
    if (parama == null)
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(action:%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(194504);
      return;
    }
    gv localgv = new gv();
    localgv.uE(parama.zqW);
    localgv.uF(parama.zqX);
    localgv.uG(parama.zqY);
    localgv.uH(parama.zqZ);
    localgv.uI(parama.sessionId);
    localgv.ejA = paramInt;
    localgv.bfK();
    AppMethodBeat.o(194504);
  }
  
  private static a b(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(194503);
    Object localObject = Util.nullAs((String)paramMap.get(paramString + ".origin_username"), "");
    String str = Util.nullAs((String)paramMap.get(paramString + ".heir_username"), "");
    paramMap = Util.nullAs((String)paramMap.get(paramString + ".succeed_ticket"), "");
    paramString = new a();
    paramString.zqW = ((String)localObject);
    paramString.zqX = str;
    localObject = ((l)g.af(l.class)).aSN().Kn((String)localObject);
    paramString.zqY = ((ax)localObject).field_descWordingId;
    paramString.zqZ = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).bN(((ax)localObject).field_openImAppid, ((ax)localObject).field_descWordingId);
    paramString.sessionId = paramMap;
    zqV.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(194503);
    return paramString;
  }
  
  public final void b(Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(194501);
    Object localObject = parama.heO;
    parama = z.a(((de)localObject).KHl);
    localObject = ((l)g.af(l.class)).eiy().aJ(parama, ((de)localObject).Brn);
    String str = n(paramMap, "new_link_succeed_contact");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onReceivedImp head is null.(%s %s)", new Object[] { parama, Long.valueOf(((eo)localObject).field_msgSvrId) });
      AppMethodBeat.o(194501);
      return;
    }
    a(b(((eo)localObject).field_msgId, paramMap, str), 1);
    AppMethodBeat.o(194501);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(194502);
    String str = n(paramMap, "new_link_succeed_contact");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(194502);
      return;
    }
    long l = paramBundle.getLong("msg_id");
    paramBundle = (a)zqV.get(Long.valueOf(l));
    if (paramBundle != null) {}
    for (paramMap = paramBundle; Util.isEqual(paramString, "link_profile"); paramMap = b(l, paramMap, str))
    {
      a(paramMap, 2);
      AppMethodBeat.o(194502);
      return;
    }
    if (Util.isEqual(paramString, "new_link_succeed_contact")) {
      a(paramMap, 5);
    }
    AppMethodBeat.o(194502);
  }
  
  public final String eiU()
  {
    return "new_tmpl_type_succeed_contact";
  }
  
  public static final class a
  {
    public String sessionId = "";
    public String zqW = "";
    public String zqX = "";
    public String zqY = "";
    public String zqZ = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.a
 * JD-Core Version:    0.7.0.1
 */