package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends com.tencent.mm.plugin.appbrand.u.a.d
{
  public final String b(i parami, c paramc)
  {
    AppMethodBeat.i(239324);
    Log.i("GetFileSysFolderSizeSync", "[execute] reqArgs:".concat(String.valueOf(parami)));
    String str = parami.optString("dirPath", "");
    parami = parami.optString("filePath", "");
    HashMap localHashMap = new HashMap();
    Object localObject = paramc.czP.getFileSystem();
    if (localObject != null)
    {
      localObject = ((r)localObject).bIH();
      if (localObject != null)
      {
        localHashMap.put("size", Long.valueOf(((t)localObject).cO(str, parami)));
        parami = paramc.R(localHashMap);
        AppMethodBeat.o(239324);
        return parami;
      }
    }
    localHashMap.put("size", Integer.valueOf(-1));
    parami = paramc.Ck(1);
    AppMethodBeat.o(239324);
    return parami;
  }
  
  public final int ccB()
  {
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.d
 * JD-Core Version:    0.7.0.1
 */