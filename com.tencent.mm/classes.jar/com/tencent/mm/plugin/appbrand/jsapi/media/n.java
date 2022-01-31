package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class n
{
  private static int CA(String paramString)
  {
    AppMethodBeat.i(143418);
    boolean bool = c.wE(paramString);
    ab.i("MicroMsg.RemuxHelper", "checkRemux, isMp4 = %b", new Object[] { Boolean.valueOf(bool) });
    int i = -10000;
    if (bool)
    {
      i = SightVideoJNI.shouldRemuxing(paramString, 660, 500, 26214400, 300000.0D, 1000000);
      ab.i("MicroMsg.RemuxHelper", "checkRemux, ret = %d", new Object[] { Integer.valueOf(i) });
    }
    if ((i == -1) || (!bool))
    {
      i = com.tencent.mm.a.e.cM(paramString);
      ab.i("MicroMsg.RemuxHelper", "fileLength = %d", new Object[] { Integer.valueOf(i) });
      if (i > 26214400) {
        i = -1;
      }
    }
    else
    {
      switch (i)
      {
      default: 
        ab.e("MicroMsg.RemuxHelper", "unknown check type");
        i = -50001;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(143418);
      return i;
      i = 1;
      break;
      i = 1;
      continue;
      i = -50006;
      continue;
      i = -50002;
    }
  }
  
  public static String Cu(String paramString)
  {
    AppMethodBeat.i(143417);
    if (CA(paramString) != -50006)
    {
      AppMethodBeat.o(143417);
      return paramString;
    }
    Object localObject = new int[2];
    j.c(paramString, (int[])localObject);
    int i = localObject[0];
    int j = localObject[1];
    localObject = com.tencent.mm.compatible.util.e.esr + "microMsg." + System.currentTimeMillis() + ".mp4";
    ab.i("MicroMsg.RemuxHelper", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { paramString, localObject, Integer.valueOf(SightVideoJNI.remuxing(paramString, (String)localObject, i, j, b.qSq, b.qSp, 8, 2, 25.0F, b.qSr, null, 0, false, 0, 51)), Integer.valueOf(i), Integer.valueOf(j) });
    AppMethodBeat.o(143417);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.n
 * JD-Core Version:    0.7.0.1
 */