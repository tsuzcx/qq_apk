package com.tencent.mm.plugin.appbrand.q.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.q.a.c;
import com.tencent.mm.plugin.appbrand.q.a.d;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends d
{
  private o mcw = null;
  
  public final String b(i parami, c paramc)
  {
    AppMethodBeat.i(147393);
    Object localObject1 = paramc.coz;
    int i;
    if (this.mcw == null)
    {
      localObject2 = ((r)localObject1).getRuntime();
      if (!(((r)localObject1).getRuntime().Fl() instanceof v))
      {
        parami = new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
        AppMethodBeat.o(147393);
        throw parami;
      }
      localObject1 = ((v)((AppBrandRuntime)localObject2).Fl()).jQv;
      i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (q)((List)localObject1).get(i);
        if (!(localObject2 instanceof o)) {
          break label196;
        }
        this.mcw = ((o)localObject2);
      }
    }
    Object localObject2 = this.mcw;
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((o)localObject2).MY(parami.optString("path"));
    }
    for (;;)
    {
      ae.d("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", new Object[] { parami.optString("path"), localObject1 });
      parami = new HashMap();
      parami.put("fullPath", localObject1);
      parami = paramc.V(parami);
      AppMethodBeat.o(147393);
      return parami;
      label196:
      i += 1;
      break;
      ae.e("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
    }
  }
  
  public final int bum()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c.b
 * JD-Core Version:    0.7.0.1
 */