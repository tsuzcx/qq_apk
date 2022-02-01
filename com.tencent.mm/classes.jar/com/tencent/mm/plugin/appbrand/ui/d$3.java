package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.preload.a;
import com.tencent.mm.plugin.appbrand.game.preload.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

final class d$3
  implements Runnable
{
  d$3(d paramd, String paramString, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(48590);
    a.bdR();
    Object localObject1 = d.e(this.mbg).mAppId;
    String str1 = this.mbl;
    a.a locala = this.mbm;
    String str2;
    Object localObject3;
    if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil(str1)))
    {
      localObject1 = a.hsx + "/" + (String)localObject1 + "/";
      l.aFC((String)localObject1);
      str2 = (String)localObject1 + ah.dg(str1);
      ac.i("MicroMsg.WAGameLoadingImgManager", "loadingImgPath:%s", new Object[] { str2 });
      localObject3 = null;
      localObject1 = null;
      if (!new e(str2).exists()) {}
    }
    else
    {
      try
      {
        localObject3 = i.openRead(str2);
        localObject1 = localObject3;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException2, "", new Object[0]);
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null) {}
    }
    for (;;)
    {
      long l;
      try
      {
        l = ((InputStream)localObject1).available();
        locala.a(f.decodeStream((InputStream)localObject1), l);
        localObject3 = localObject1;
      }
      catch (IOException localIOException1)
      {
        ac.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException1, "read contentLength", new Object[0]);
        localObject4 = localObject1;
        continue;
      }
      bs.d((Closeable)localObject3);
      AppMethodBeat.o(48590);
      return;
      Object localObject4;
      a.cQ(str2, str1);
      try
      {
        localObject1 = i.openRead(str2);
        localObject4 = localObject1;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          l = ((InputStream)localObject1).available();
          locala.a(f.decodeStream((InputStream)localObject1), l);
          localObject4 = localObject1;
        }
        catch (IOException localIOException2)
        {
          ac.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException2, "read contentLength", new Object[0]);
          localObject5 = localObject1;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          Object localObject5;
          ac.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException1, "", new Object[0]);
          Object localObject2 = localObject5;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d.3
 * JD-Core Version:    0.7.0.1
 */