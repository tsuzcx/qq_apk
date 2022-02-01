package com.tencent.mm.plugin.appbrand.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.v.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends b
{
  public final void a(i parami, com.tencent.mm.plugin.appbrand.v.a.c paramc)
  {
    AppMethodBeat.i(321233);
    Log.i("GetFileSysFolderSizeAsync", "[execute] reqArgs:".concat(String.valueOf(parami)));
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
        paramc.Y(localHashMap);
        AppMethodBeat.o(321233);
        return;
      }
    }
    localHashMap.put("size", Integer.valueOf(-1));
    paramc.Y(localHashMap);
    AppMethodBeat.o(321233);
  }
  
  public final int cCX()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.c
 * JD-Core Version:    0.7.0.1
 */