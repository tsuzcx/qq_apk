package com.tencent.mm.ipcinvoker.wx_extension.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.d;

public final class a
{
  public static com.tencent.mm.storage.c me(String paramString)
  {
    AppMethodBeat.i(126211);
    if (paramString.length() == 0)
    {
      ab.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", new Object[] { paramString });
      AppMethodBeat.o(126211);
      return null;
    }
    if (ah.brt())
    {
      if ((!g.RM().eIn.eIH) || (!g.RJ().eHg))
      {
        ab.e("MicroMsg.IPCNewABTest", "kernel or account not ready.");
        AppMethodBeat.o(126211);
        return null;
      }
      paramString = com.tencent.mm.model.c.c.abU().me(paramString);
      AppMethodBeat.o(126211);
      return paramString;
    }
    try
    {
      paramString = (Bundle)f.a("com.tencent.mm", new IPCString(paramString), a.a.class);
      if (paramString == null)
      {
        AppMethodBeat.o(126211);
        return null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.IPCNewABTest", "invokeSync e = %s", new Object[] { paramString });
        paramString = null;
      }
      com.tencent.mm.storage.c localc = new com.tencent.mm.storage.c();
      localc.field_layerId = paramString.getString("layerId");
      localc.field_business = paramString.getString("business");
      localc.field_expId = paramString.getString("expId");
      localc.field_rawXML = paramString.getString("rawXML");
      localc.field_startTime = paramString.getLong("startTime");
      localc.field_endTime = paramString.getLong("endTime");
      localc.field_sequence = paramString.getLong("sequence");
      localc.field_prioritylevel = paramString.getInt("prioritylevel");
      localc.field_needReport = paramString.getBoolean("needReport");
      AppMethodBeat.o(126211);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a.a
 * JD-Core Version:    0.7.0.1
 */