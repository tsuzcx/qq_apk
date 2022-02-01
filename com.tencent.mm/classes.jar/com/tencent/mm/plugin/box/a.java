package com.tencent.mm.plugin.box;

import android.content.Context;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.UUID;

public final class a
  implements com.tencent.mm.plugin.box.a.b
{
  public final void a(Context paramContext, String paramString, long paramLong)
  {
    AppMethodBeat.i(76317);
    String str = z.Uj(2).exI();
    ac.i("MicroMsg.Box.BoxUILogic", "startBoxHomeUI type=%d query=%s messageSvrID=%d", new Object[] { Integer.valueOf(3), paramString, Long.valueOf(paramLong) });
    ol localol = new ol();
    localol.Eem = UUID.randomUUID().toString();
    localol.Eel = paramString;
    localol.ndI = 3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString);
    localHashMap.put("type", "3");
    localHashMap.put("messageSvrID", String.valueOf(paramLong));
    localol.Url = com.tencent.mm.plugin.box.c.b.a(localHashMap, str);
    paramContext = new com.tencent.mm.plugin.box.c.a(paramContext, localol);
    paramContext.show();
    paramContext.getWindow().setLayout(-1, -1);
    AppMethodBeat.o(76317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.a
 * JD-Core Version:    0.7.0.1
 */