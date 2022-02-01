package com.tencent.mm.plugin.appbrand.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.v.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends com.tencent.mm.plugin.appbrand.v.a.d
{
  public final String b(i parami, c paramc)
  {
    AppMethodBeat.i(321236);
    Log.i("GetFileSysFolderSizeSync", "[execute] reqArgs:".concat(String.valueOf(parami)));
    String str = parami.optString("dirPath", "");
    parami = parami.optString("filePath", "");
    HashMap localHashMap = new HashMap();
    Object localObject = paramc.esk.getFileSystem();
    if (localObject != null)
    {
      localObject = ((w)localObject).cim();
      if (localObject != null)
      {
        localHashMap.put("size", Long.valueOf(((com.tencent.mm.plugin.appbrand.appstorage.y)localObject).df(str, parami)));
        parami = paramc.Y(localHashMap);
        AppMethodBeat.o(321236);
        return parami;
      }
    }
    localHashMap.put("size", Integer.valueOf(-1));
    parami = paramc.Cz(1);
    AppMethodBeat.o(321236);
    return parami;
  }
  
  public final int cCX()
  {
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.d
 * JD-Core Version:    0.7.0.1
 */