package com.tencent.mm.plugin.appbrand.v.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.v.a.c;
import com.tencent.mm.plugin.appbrand.v.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

public final class a
  extends d
{
  public final String b(i parami, c paramc)
  {
    AppMethodBeat.i(321230);
    Object localObject1 = paramc.esk.getFileSystem();
    if (localObject1 == null)
    {
      parami = paramc.Cz(1);
      AppMethodBeat.o(321230);
      return parami;
    }
    localObject1 = ((w)localObject1).cim();
    if (localObject1 == null)
    {
      parami = paramc.Cz(1);
      AppMethodBeat.o(321230);
      return parami;
    }
    Log.i("FileSizeChangeEvent", "[execute] reqArgs:".concat(String.valueOf(parami)));
    Object localObject2 = parami.Ft("info");
    if (localObject2 == null)
    {
      parami = paramc.Y(null);
      AppMethodBeat.o(321230);
      return parami;
    }
    parami = ((i)localObject2).optString("path", "");
    long l = ((i)localObject2).optLong("sizeDiff", -1L);
    localObject2 = ((i)localObject2).optString("event", "");
    if ((TextUtils.isEmpty(parami)) || (l == -1L))
    {
      parami = paramc.Y(null);
      AppMethodBeat.o(321230);
      return parami;
    }
    ((com.tencent.mm.plugin.appbrand.appstorage.y)localObject1).c(new File(parami).getPath(), l, (String)localObject2);
    parami = paramc.Y(null);
    AppMethodBeat.o(321230);
    return parami;
  }
  
  public final int cCX()
  {
    return 9;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.a
 * JD-Core Version:    0.7.0.1
 */