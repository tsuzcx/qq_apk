package com.tencent.mm.plugin.appbrand.q.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.a.c;
import com.tencent.mm.plugin.appbrand.q.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends d
{
  private n lXP = null;
  
  public final String b(i parami, c paramc)
  {
    AppMethodBeat.i(147393);
    Object localObject1 = paramc.cox;
    int i;
    if (this.lXP == null)
    {
      localObject2 = ((q)localObject1).getRuntime();
      if (!(((q)localObject1).getRuntime().Fg() instanceof t))
      {
        parami = new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
        AppMethodBeat.o(147393);
        throw parami;
      }
      localObject1 = ((t)((AppBrandRuntime)localObject2).Fg()).jNc;
      i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (p)((List)localObject1).get(i);
        if (!(localObject2 instanceof n)) {
          break label196;
        }
        this.lXP = ((n)localObject2);
      }
    }
    Object localObject2 = this.lXP;
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((n)localObject2).Ms(parami.optString("path"));
    }
    for (;;)
    {
      ad.d("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", new Object[] { parami.optString("path"), localObject1 });
      parami = new HashMap();
      parami.put("fullPath", localObject1);
      parami = paramc.O(parami);
      AppMethodBeat.o(147393);
      return parami;
      label196:
      i += 1;
      break;
      ad.e("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
    }
  }
  
  public final int btB()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c.b
 * JD-Core Version:    0.7.0.1
 */