package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.preload.a;
import com.tencent.mm.plugin.appbrand.game.preload.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.i;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

final class e$2
  implements Runnable
{
  e$2(e parame, String paramString, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(188854);
    a.bhv();
    Object localObject1 = e.e(this.mBp).mAppId;
    String str1 = this.mBs;
    a.a locala = this.mBt;
    String str2;
    Object localObject3;
    if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(str1)))
    {
      localObject1 = a.hKP + "/" + (String)localObject1 + "/";
      m.aLc((String)localObject1);
      str2 = (String)localObject1 + ai.ee(str1);
      ad.i("MicroMsg.WAGameLoadingImgManager", "loadingImgPath:%s", new Object[] { str2 });
      localObject3 = null;
      localObject1 = null;
      if (!new com.tencent.mm.vfs.e(str2).exists()) {}
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
          ad.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException2, "", new Object[0]);
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
        locala.a(g.decodeStream((InputStream)localObject1), l);
        localObject3 = localObject1;
      }
      catch (IOException localIOException1)
      {
        ad.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException1, "read contentLength", new Object[0]);
        localObject4 = localObject1;
        continue;
      }
      bt.d((Closeable)localObject3);
      AppMethodBeat.o(188854);
      return;
      Object localObject4;
      a.cS(str2, str1);
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
          locala.a(g.decodeStream((InputStream)localObject1), l);
          localObject4 = localObject1;
        }
        catch (IOException localIOException2)
        {
          ad.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException2, "read contentLength", new Object[0]);
          localObject5 = localObject1;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          Object localObject5;
          ad.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException1, "", new Object[0]);
          Object localObject2 = localObject5;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.e.2
 * JD-Core Version:    0.7.0.1
 */