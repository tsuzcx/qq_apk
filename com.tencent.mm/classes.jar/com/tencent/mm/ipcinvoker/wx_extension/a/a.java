package com.tencent.mm.ipcinvoker.wx_extension.a;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;

public final class a
{
  public static com.tencent.mm.storage.c fJ(String paramString)
  {
    if (paramString.length() == 0)
    {
      y.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", new Object[] { paramString });
      return null;
    }
    if (ae.cqV())
    {
      if ((!g.DQ().dKP.dLj) || (!g.DN().dJH))
      {
        y.e("MicroMsg.IPCNewABTest", "kernel or account not ready.");
        return null;
      }
      return com.tencent.mm.model.c.c.IX().fJ(paramString);
    }
    paramString = (Bundle)f.a("com.tencent.mm", new IPCString(paramString), a.a.class);
    if (paramString == null) {
      return null;
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
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a.a
 * JD-Core Version:    0.7.0.1
 */