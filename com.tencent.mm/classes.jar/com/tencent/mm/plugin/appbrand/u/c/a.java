package com.tencent.mm.plugin.appbrand.u.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.plugin.appbrand.u.a.d;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

public final class a
  extends d
{
  public final String b(i parami, c paramc)
  {
    AppMethodBeat.i(233931);
    Object localObject1 = paramc.czP.getFileSystem();
    if (localObject1 == null)
    {
      parami = paramc.Ck(1);
      AppMethodBeat.o(233931);
      return parami;
    }
    localObject1 = ((r)localObject1).bIH();
    if (localObject1 == null)
    {
      parami = paramc.Ck(1);
      AppMethodBeat.o(233931);
      return parami;
    }
    Log.i("FileSizeChangeEvent", "[execute] reqArgs:".concat(String.valueOf(parami)));
    Object localObject2 = parami.MK("info");
    if (localObject2 == null)
    {
      parami = paramc.R(null);
      AppMethodBeat.o(233931);
      return parami;
    }
    parami = ((i)localObject2).optString("path", "");
    long l = ((i)localObject2).optLong("sizeDiff", -1L);
    localObject2 = ((i)localObject2).optString("event", "");
    if ((TextUtils.isEmpty(parami)) || (l == -1L))
    {
      parami = paramc.R(null);
      AppMethodBeat.o(233931);
      return parami;
    }
    ((t)localObject1).d(new File(parami).getPath(), l, (String)localObject2);
    parami = paramc.R(null);
    AppMethodBeat.o(233931);
    return parami;
  }
  
  public final int ccB()
  {
    return 9;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.a
 * JD-Core Version:    0.7.0.1
 */