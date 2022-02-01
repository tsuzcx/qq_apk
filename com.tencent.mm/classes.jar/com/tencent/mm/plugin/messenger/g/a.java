package com.tencent.mm.plugin.messenger.g;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.lk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  extends com.tencent.mm.plugin.messenger.f.e
{
  private static final Map<Long, a> KSg;
  
  static
  {
    AppMethodBeat.i(288593);
    KSg = new ConcurrentHashMap();
    AppMethodBeat.o(288593);
  }
  
  private static a a(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(288573);
    Object localObject = Util.nullAs((String)paramMap.get(paramString + ".origin_username"), "");
    String str = Util.nullAs((String)paramMap.get(paramString + ".heir_username"), "");
    paramMap = Util.nullAs((String)paramMap.get(paramString + ".succeed_ticket"), "");
    paramString = new a();
    paramString.KSh = ((String)localObject);
    paramString.KSi = str;
    localObject = ((n)h.ax(n.class)).bzA().JE((String)localObject);
    paramString.KSj = ((az)localObject).field_descWordingId;
    paramString.KSk = ((com.tencent.mm.openim.api.e)h.ax(com.tencent.mm.openim.api.e.class)).cc(((az)localObject).field_openImAppid, ((az)localObject).field_descWordingId);
    paramString.sessionId = paramMap;
    KSg.put(Long.valueOf(paramLong), paramString);
    AppMethodBeat.o(288573);
    return paramString;
  }
  
  private static void a(a parama, int paramInt)
  {
    AppMethodBeat.i(288578);
    if (parama == null)
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(action:%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(288578);
      return;
    }
    lk locallk = new lk();
    locallk.um(parama.KSh);
    locallk.un(parama.KSi);
    locallk.uo(parama.KSj);
    locallk.up(parama.KSk);
    locallk.uq(parama.sessionId);
    locallk.ikE = paramInt;
    locallk.bMH();
    AppMethodBeat.o(288578);
  }
  
  public static void aq(long paramLong, int paramInt)
  {
    AppMethodBeat.i(288581);
    a locala = (a)KSg.get(Long.valueOf(paramLong));
    if (locala == null)
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(msgId:%s action:%s)", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(288581);
      return;
    }
    a(locala, paramInt);
    AppMethodBeat.o(288581);
  }
  
  public static boolean sr(long paramLong)
  {
    AppMethodBeat.i(288586);
    if ((a)KSg.get(Long.valueOf(paramLong)) != null)
    {
      AppMethodBeat.o(288586);
      return true;
    }
    AppMethodBeat.o(288586);
    return false;
  }
  
  public final void b(Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(288602);
    Object localObject = parama.mpN;
    parama = w.a(((dl)localObject).YFE);
    localObject = ((n)h.ax(n.class)).gaZ().aU(parama, ((dl)localObject).Njv);
    String str = p(paramMap, "new_link_succeed_contact");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onReceivedImp head is null.(%s %s)", new Object[] { parama, Long.valueOf(((fi)localObject).field_msgSvrId) });
      AppMethodBeat.o(288602);
      return;
    }
    a(a(((fi)localObject).field_msgId, paramMap, str), 1);
    AppMethodBeat.o(288602);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(288605);
    String str = p(paramMap, "new_link_succeed_contact");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(288605);
      return;
    }
    long l = paramBundle.getLong("msg_id");
    paramBundle = (a)KSg.get(Long.valueOf(l));
    if (paramBundle != null) {}
    for (paramMap = paramBundle; Util.isEqual(paramString, "link_profile"); paramMap = a(l, paramMap, str))
    {
      a(paramMap, 2);
      AppMethodBeat.o(288605);
      return;
    }
    if (Util.isEqual(paramString, "new_link_succeed_contact")) {
      a(paramMap, 5);
    }
    AppMethodBeat.o(288605);
  }
  
  public final String gbu()
  {
    return "new_tmpl_type_succeed_contact";
  }
  
  public static final class a
  {
    public String KSh = "";
    public String KSi = "";
    public String KSj = "";
    public String KSk = "";
    public String sessionId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.g.a
 * JD-Core Version:    0.7.0.1
 */