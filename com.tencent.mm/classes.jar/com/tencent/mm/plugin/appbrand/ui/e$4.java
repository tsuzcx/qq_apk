package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.preload.a;
import com.tencent.mm.plugin.appbrand.game.preload.a.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

final class e$4
  implements Runnable
{
  e$4(e parame, String paramString, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(48591);
    a.cpe();
    Object localObject1 = e.a(this.uaz).mAppId;
    String str1 = this.uaD;
    a.a locala = this.uaE;
    String str2;
    Object localObject3;
    if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str1)))
    {
      localObject1 = a.oqs + "/" + (String)localObject1 + "/";
      FilePathGenerator.checkMkdir((String)localObject1);
      str2 = (String)localObject1 + MD5Util.getMD5String(str1);
      Log.i("MicroMsg.WAGameLoadingImgManager", "loadingImgPath:%s", new Object[] { str2 });
      localObject3 = null;
      localObject1 = null;
      if (!new u(str2).jKS()) {}
    }
    else
    {
      try
      {
        localObject3 = y.Lh(str2);
        localObject1 = localObject3;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException2, "", new Object[0]);
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
        locala.a(BitmapUtil.decodeStream((InputStream)localObject1), l);
        localObject3 = localObject1;
      }
      catch (IOException localIOException1)
      {
        Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException1, "read contentLength", new Object[0]);
        localObject4 = localObject1;
        continue;
      }
      Util.qualityClose((Closeable)localObject3);
      AppMethodBeat.o(48591);
      return;
      Object localObject4;
      a.dL(str2, str1);
      try
      {
        localObject1 = y.Lh(str2);
        localObject4 = localObject1;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          l = ((InputStream)localObject1).available();
          locala.a(BitmapUtil.decodeStream((InputStream)localObject1), l);
          localObject4 = localObject1;
        }
        catch (IOException localIOException2)
        {
          Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException2, "read contentLength", new Object[0]);
          localObject5 = localObject1;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          Object localObject5;
          Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException1, "", new Object[0]);
          Object localObject2 = localObject5;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.e.4
 * JD-Core Version:    0.7.0.1
 */