package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Map;

public final class c
  extends e
{
  public final void b(Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(218181);
    Object localObject = parama.gte;
    parama = z.a(((cv)localObject).FNG);
    localObject = ((l)g.ab(l.class)).doJ().aJ(parama, ((cv)localObject).xrk);
    String str = m(paramMap, "link_history");
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp head(LINK_TYPE_HISTORY) is null.(%s %s)", new Object[] { parama, Long.valueOf(((ei)localObject).field_msgSvrId) });
      AppMethodBeat.o(218181);
      return;
    }
    ((v)g.ab(v.class)).a(((ei)localObject).field_msgId, paramMap, str);
    paramMap = bu.bI((String)paramMap.get(str + ".historyid"), "");
    ((bv)localObject).up(paramMap);
    ((l)g.ab(l.class)).doJ().a(((ei)localObject).field_msgId, (bv)localObject);
    ((v)g.ab(v.class)).aA(paramMap, ((ei)localObject).field_msgId);
    ae.i("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp msgId:%s historyId:%s", new Object[] { Long.valueOf(((ei)localObject).field_msgId), paramMap });
    AppMethodBeat.o(218181);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(218182);
    if (bu.isNullOrNil(m(paramMap, "link_history")))
    {
      ae.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(218182);
      return;
    }
    AppMethodBeat.o(218182);
  }
  
  public final String dpf()
  {
    return "tmpl_type_profilewithrevoke";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.c
 * JD-Core Version:    0.7.0.1
 */