package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.preload.a;
import com.tencent.mm.plugin.appbrand.game.preload.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

final class f$2
  implements Runnable
{
  f$2(f paramf, String paramString, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(223086);
    a.bid();
    Object localObject1 = f.e(this.mGu).mAppId;
    String str1 = this.mGx;
    a.a locala = this.mGy;
    String str2;
    Object localObject3;
    if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil(str1)))
    {
      localObject1 = a.hNI + "/" + (String)localObject1 + "/";
      n.aMy((String)localObject1);
      str2 = (String)localObject1 + aj.ej(str1);
      ae.i("MicroMsg.WAGameLoadingImgManager", "loadingImgPath:%s", new Object[] { str2 });
      localObject3 = null;
      localObject1 = null;
      if (!new k(str2).exists()) {}
    }
    else
    {
      try
      {
        localObject3 = o.openRead(str2);
        localObject1 = localObject3;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException2, "", new Object[0]);
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
        locala.a(h.decodeStream((InputStream)localObject1), l);
        localObject3 = localObject1;
      }
      catch (IOException localIOException1)
      {
        ae.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException1, "read contentLength", new Object[0]);
        localObject4 = localObject1;
        continue;
      }
      bu.d((Closeable)localObject3);
      AppMethodBeat.o(223086);
      return;
      Object localObject4;
      a.cU(str2, str1);
      try
      {
        localObject1 = o.openRead(str2);
        localObject4 = localObject1;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          l = ((InputStream)localObject1).available();
          locala.a(h.decodeStream((InputStream)localObject1), l);
          localObject4 = localObject1;
        }
        catch (IOException localIOException2)
        {
          ae.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException2, "read contentLength", new Object[0]);
          localObject5 = localObject1;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          Object localObject5;
          ae.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException1, "", new Object[0]);
          Object localObject2 = localObject5;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f.2
 * JD-Core Version:    0.7.0.1
 */