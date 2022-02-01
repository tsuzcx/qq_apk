package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class c
  extends b
{
  public final void a(i parami, com.tencent.mm.plugin.appbrand.u.a.c paramc)
  {
    AppMethodBeat.i(237917);
    Log.i("GetFileSysFolderSizeAsync", "[execute] reqArgs:".concat(String.valueOf(parami)));
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
        paramc.R(localHashMap);
        AppMethodBeat.o(237917);
        return;
      }
    }
    localHashMap.put("size", Integer.valueOf(-1));
    paramc.R(localHashMap);
    AppMethodBeat.o(237917);
  }
  
  public final int ccB()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.c
 * JD-Core Version:    0.7.0.1
 */