package com.tencent.mm.plugin.appbrand.q.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.a.c;
import com.tencent.mm.plugin.appbrand.q.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends d
{
  private n lyr = null;
  
  public final String b(i parami, c paramc)
  {
    AppMethodBeat.i(147393);
    Object localObject1 = paramc.ceh;
    int i;
    if (this.lyr == null)
    {
      localObject2 = ((q)localObject1).getRuntime();
      if (!(((q)localObject1).getRuntime().DH() instanceof t))
      {
        parami = new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
        AppMethodBeat.o(147393);
        throw parami;
      }
      localObject1 = ((t)((AppBrandRuntime)localObject2).DH()).jti;
      i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (p)((List)localObject1).get(i);
        if (!(localObject2 instanceof n)) {
          break label196;
        }
        this.lyr = ((n)localObject2);
      }
    }
    Object localObject2 = this.lyr;
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((n)localObject2).Jb(parami.optString("path"));
    }
    for (;;)
    {
      ac.d("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", new Object[] { parami.optString("path"), localObject1 });
      parami = new HashMap();
      parami.put("fullPath", localObject1);
      parami = paramc.O(parami);
      AppMethodBeat.o(147393);
      return parami;
      label196:
      i += 1;
      break;
      ac.e("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
    }
  }
  
  public final int bpA()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c.b
 * JD-Core Version:    0.7.0.1
 */