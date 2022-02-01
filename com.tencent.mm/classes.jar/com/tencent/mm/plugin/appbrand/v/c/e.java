package com.tencent.mm.plugin.appbrand.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ac;
import com.tencent.mm.plugin.appbrand.appstorage.u;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.v.a.c;
import com.tencent.mm.plugin.appbrand.v.a.d;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e
  extends d
{
  private u tqD = null;
  
  public final String b(i parami, c paramc)
  {
    AppMethodBeat.i(147393);
    Object localObject1 = paramc.esk;
    int i;
    if (this.tqD == null)
    {
      localObject2 = ((y)localObject1).getRuntime();
      if (!(((y)localObject1).getRuntime().getFileSystem() instanceof ac))
      {
        parami = new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
        AppMethodBeat.o(147393);
        throw parami;
      }
      localObject1 = ((ac)((AppBrandRuntime)localObject2).getFileSystem()).qNv;
      i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (w)((List)localObject1).get(i);
        if (!(localObject2 instanceof u)) {
          break label196;
        }
        this.tqD = ((u)localObject2);
      }
    }
    Object localObject2 = this.tqD;
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((u)localObject2).Ww(parami.optString("path"));
    }
    for (;;)
    {
      Log.d("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", new Object[] { parami.optString("path"), localObject1 });
      parami = new HashMap();
      parami.put("fullPath", localObject1);
      parami = paramc.Y(parami);
      AppMethodBeat.o(147393);
      return parami;
      label196:
      i += 1;
      break;
      Log.e("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
    }
  }
  
  public final int cCX()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.e
 * JD-Core Version:    0.7.0.1
 */