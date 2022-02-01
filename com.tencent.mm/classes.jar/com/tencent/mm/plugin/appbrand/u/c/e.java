package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.plugin.appbrand.u.a.d;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e
  extends d
{
  private p qlF = null;
  
  public final String b(i parami, c paramc)
  {
    AppMethodBeat.i(147393);
    Object localObject1 = paramc.czP;
    int i;
    if (this.qlF == null)
    {
      localObject2 = ((v)localObject1).getRuntime();
      if (!(((v)localObject1).getRuntime().getFileSystem() instanceof x))
      {
        parami = new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
        AppMethodBeat.o(147393);
        throw parami;
      }
      localObject1 = ((x)((AppBrandRuntime)localObject2).getFileSystem()).nNC;
      i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (r)((List)localObject1).get(i);
        if (!(localObject2 instanceof p)) {
          break label196;
        }
        this.qlF = ((p)localObject2);
      }
    }
    Object localObject2 = this.qlF;
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((p)localObject2).adW(parami.optString("path"));
    }
    for (;;)
    {
      Log.d("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", new Object[] { parami.optString("path"), localObject1 });
      parami = new HashMap();
      parami.put("fullPath", localObject1);
      parami = paramc.R(parami);
      AppMethodBeat.o(147393);
      return parami;
      label196:
      i += 1;
      break;
      Log.e("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
    }
  }
  
  public final int ccB()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.e
 * JD-Core Version:    0.7.0.1
 */