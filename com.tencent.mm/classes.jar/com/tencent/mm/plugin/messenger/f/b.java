package com.tencent.mm.plugin.messenger.f;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.e.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class b
  extends e
{
  public final void b(Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(213507);
    Object localObject = parama.jQG;
    parama = z.a(((db)localObject).RID);
    localObject = ((n)h.ae(n.class)).eSe().aL(parama, ((db)localObject).HlH);
    String str = n(paramMap, "link_history");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp head(LINK_TYPE_HISTORY) is null.(%s %s)", new Object[] { parama, Long.valueOf(((et)localObject).field_msgSvrId) });
      AppMethodBeat.o(213507);
      return;
    }
    ((y)h.ae(y.class)).a(((et)localObject).field_msgId, paramMap, str);
    paramMap = Util.nullAs((String)paramMap.get(str + ".historyid"), "");
    ((ca)localObject).Jt(paramMap);
    ((n)h.ae(n.class)).eSe().a(((et)localObject).field_msgId, (ca)localObject);
    ((y)h.ae(y.class)).aC(paramMap, ((et)localObject).field_msgId);
    Log.i("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp msgId:%s historyId:%s", new Object[] { Long.valueOf(((et)localObject).field_msgId), paramMap });
    AppMethodBeat.o(213507);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(213508);
    if (Util.isNullOrNil(n(paramMap, "link_history")))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(213508);
      return;
    }
    AppMethodBeat.o(213508);
  }
  
  public final String eSA()
  {
    return "tmpl_type_profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.f.b
 * JD-Core Version:    0.7.0.1
 */