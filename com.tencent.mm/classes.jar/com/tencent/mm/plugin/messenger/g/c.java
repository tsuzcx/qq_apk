package com.tencent.mm.plugin.messenger.g;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.f.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.Map;

public final class c
  extends e
{
  public final void b(Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(288584);
    Object localObject = parama.mpN;
    parama = w.a(((dl)localObject).YFE);
    localObject = ((n)h.ax(n.class)).gaZ().aU(parama, ((dl)localObject).Njv);
    String str = p(paramMap, "link_history");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp head(LINK_TYPE_HISTORY) is null.(%s %s)", new Object[] { parama, Long.valueOf(((fi)localObject).field_msgSvrId) });
      AppMethodBeat.o(288584);
      return;
    }
    ((y)h.ax(y.class)).a((cc)localObject, paramMap, str, "tmpl_type_profilewithrevoke");
    paramMap = Util.nullAs((String)paramMap.get(str + ".historyid"), "");
    ((cc)localObject).BZ(paramMap);
    ((n)h.ax(n.class)).gaZ().a(((fi)localObject).field_msgId, (cc)localObject);
    ((y)h.ax(y.class)).f(paramMap, ((fi)localObject).field_msgId, ((fi)localObject).field_talker);
    Log.i("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp msgId:%s historyId:%s", new Object[] { Long.valueOf(((fi)localObject).field_msgId), paramMap });
    AppMethodBeat.o(288584);
  }
  
  public final void c(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(288592);
    if (Util.isNullOrNil(p(paramMap, "link_history")))
    {
      Log.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onClickLinkImp head is null.");
      AppMethodBeat.o(288592);
      return;
    }
    AppMethodBeat.o(288592);
  }
  
  public final String gbu()
  {
    return "tmpl_type_profilewithrevoke";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.g.c
 * JD-Core Version:    0.7.0.1
 */