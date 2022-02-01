package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class c
  extends e
{
  public final void b(Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(194510);
    Object localObject = parama.heO;
    parama = z.a(((de)localObject).KHl);
    localObject = ((l)g.af(l.class)).eiy().aJ(parama, ((de)localObject).Brn);
    String str = n(paramMap, "link_history");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp head(LINK_TYPE_HISTORY) is null.(%s %s)", new Object[] { parama, Long.valueOf(((eo)localObject).field_msgSvrId) });
      AppMethodBeat.o(194510);
      return;
    }
    ((v)g.af(v.class)).a(((eo)localObject).field_msgId, paramMap, str);
    paramMap = Util.nullAs((String)paramMap.get(str + ".historyid"), "");
    ((ca)localObject).CF(paramMap);
    ((l)g.af(l.class)).eiy().a(((eo)localObject).field_msgId, (ca)localObject);
    ((v)g.af(v.class)).aA(paramMap, ((eo)localObject).field_msgId);
    Log.i("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp msgId:%s historyId:%s", new Object[] { Long.valueOf(((eo)localObject).field_msgId), paramMap });
    AppMethodBeat.o(194510);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(194511);
    if (Util.isNullOrNil(n(paramMap, "link_history")))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(194511);
      return;
    }
    AppMethodBeat.o(194511);
  }
  
  public final String eiU()
  {
    return "tmpl_type_profilewithrevoke";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.c
 * JD-Core Version:    0.7.0.1
 */