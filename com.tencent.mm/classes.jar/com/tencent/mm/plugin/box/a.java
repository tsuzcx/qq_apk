package com.tencent.mm.plugin.box;

import android.content.Context;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.UUID;

public final class a
  implements com.tencent.mm.plugin.box.a.b
{
  public final void a(Context paramContext, String paramString, long paramLong)
  {
    AppMethodBeat.i(76317);
    String str = aa.RZ(2).eio();
    ad.i("MicroMsg.Box.BoxUILogic", "startBoxHomeUI type=%d query=%s messageSvrID=%d", new Object[] { Integer.valueOf(3), paramString, Long.valueOf(paramLong) });
    oe localoe = new oe();
    localoe.CLJ = UUID.randomUUID().toString();
    localoe.CLI = paramString;
    localoe.mBH = 3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString);
    localHashMap.put("type", "3");
    localHashMap.put("messageSvrID", String.valueOf(paramLong));
    localoe.Url = com.tencent.mm.plugin.box.c.b.a(localHashMap, str);
    paramContext = new com.tencent.mm.plugin.box.c.a(paramContext, localoe);
    paramContext.show();
    paramContext.getWindow().setLayout(-1, -1);
    AppMethodBeat.o(76317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.a
 * JD-Core Version:    0.7.0.1
 */