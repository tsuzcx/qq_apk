package com.tencent.mm.plugin.box;

import android.content.Context;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.box.c.a;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.protobuf.pq;
import java.util.HashMap;
import java.util.UUID;

public final class b
  implements com.tencent.mm.plugin.box.a.b
{
  public final void a(Context paramContext, String paramString, long paramLong)
  {
    AppMethodBeat.i(76317);
    String str = com.tencent.mm.plugin.websearch.api.ad.Wc(2).eMz();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Box.BoxUILogic", "startBoxHomeUI type=%d query=%s messageSvrID=%d", new Object[] { Integer.valueOf(3), paramString, Long.valueOf(paramLong) });
    pq localpq = new pq();
    localpq.FKL = UUID.randomUUID().toString();
    localpq.FKK = paramString;
    localpq.nEf = 3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString);
    localHashMap.put("type", "3");
    localHashMap.put("messageSvrID", String.valueOf(paramLong));
    localpq.Url = com.tencent.mm.plugin.box.c.b.a(localHashMap, str);
    paramContext = new a(paramContext, localpq);
    paramContext.show();
    paramContext.getWindow().setLayout(-1, -1);
    AppMethodBeat.o(76317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.b
 * JD-Core Version:    0.7.0.1
 */