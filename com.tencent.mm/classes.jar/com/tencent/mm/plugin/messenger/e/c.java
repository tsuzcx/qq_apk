package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Map;

public final class c
  extends e
{
  public final void b(Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(211872);
    Object localObject = parama.gqE;
    parama = z.a(((cv)localObject).Fvi);
    localObject = ((l)g.ab(l.class)).dlK().aI(parama, ((cv)localObject).xbt);
    String str = m(paramMap, "link_history");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp head(LINK_TYPE_HISTORY) is null.(%s %s)", new Object[] { parama, Long.valueOf(((ei)localObject).field_msgSvrId) });
      AppMethodBeat.o(211872);
      return;
    }
    ((u)g.ab(u.class)).a(((ei)localObject).field_msgId, paramMap, str);
    paramMap = bt.bI((String)paramMap.get(str + ".historyid"), "");
    ((bu)localObject).tU(paramMap);
    ((l)g.ab(l.class)).dlK().a(((ei)localObject).field_msgId, (bu)localObject);
    ((u)g.ab(u.class)).cq(paramMap, ((ei)localObject).field_msgId);
    ad.i("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp msgId:%s historyId:%s", new Object[] { Long.valueOf(((ei)localObject).field_msgId), paramMap });
    AppMethodBeat.o(211872);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(211873);
    if (bt.isNullOrNil(m(paramMap, "link_history")))
    {
      ad.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(211873);
      return;
    }
    AppMethodBeat.o(211873);
  }
  
  public final String dmg()
  {
    return "tmpl_type_profilewithrevoke";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.e.c
 * JD-Core Version:    0.7.0.1
 */