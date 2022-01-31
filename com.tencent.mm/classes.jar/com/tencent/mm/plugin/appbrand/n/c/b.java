package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.n.a.c;
import com.tencent.mm.plugin.appbrand.n.a.d;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  extends d
{
  private l ium = null;
  
  public final int aIA()
  {
    return 7;
  }
  
  public final String b(com.tencent.mm.aa.i parami, c paramc)
  {
    AppMethodBeat.i(102193);
    Object localObject1 = paramc.bEw;
    int i;
    if (this.ium == null)
    {
      localObject2 = ((r)localObject1).getRuntime();
      if (!(((r)localObject1).getRuntime().wX() instanceof s))
      {
        parami = new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
        AppMethodBeat.o(102193);
        throw parami;
      }
      localObject1 = ((s)((com.tencent.mm.plugin.appbrand.i)localObject2).wX()).had;
      i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (o)((List)localObject1).get(i);
        if (!(localObject2 instanceof l)) {
          break label196;
        }
        this.ium = ((l)localObject2);
      }
    }
    Object localObject2 = this.ium;
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((l)localObject2).zm(parami.optString("path"));
    }
    for (;;)
    {
      ab.d("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", new Object[] { parami.optString("path"), localObject1 });
      parami = new HashMap();
      parami.put("fullPath", localObject1);
      parami = paramc.C(parami);
      AppMethodBeat.o(102193);
      return parami;
      label196:
      i += 1;
      break;
      ab.e("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c.b
 * JD-Core Version:    0.7.0.1
 */