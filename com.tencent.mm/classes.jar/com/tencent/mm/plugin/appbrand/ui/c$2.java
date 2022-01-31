package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.preload.a;
import com.tencent.mm.plugin.appbrand.game.preload.a.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

final class c$2
  implements Runnable
{
  c$2(c paramc, String paramString, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(132935);
    a.aAL();
    Object localObject4 = c.e(this.iMp).mAppId;
    Object localObject1 = this.iMs;
    a.a locala = this.iMt;
    if ((!bo.isNullOrNil((String)localObject4)) && (!bo.isNullOrNil((String)localObject1)))
    {
      localObject4 = a.fqs + File.separator + (String)localObject4 + File.separator;
      j.akQ((String)localObject4);
      localObject4 = (String)localObject4 + ag.cE((String)localObject1);
      ab.i("MicroMsg.WAGameLoadingImgManager", "loadingImgPath:%s", new Object[] { localObject4 });
      if (!new File((String)localObject4).exists()) {
        break label231;
      }
    }
    for (;;)
    {
      long l;
      Object localObject2;
      try
      {
        localObject1 = new FileInputStream((String)localObject4);
        localObject4 = localObject1;
        if (localObject1 != null) {}
        try
        {
          l = ((InputStream)localObject1).available();
          locala.a(d.decodeStream((InputStream)localObject1), l);
          localObject4 = localObject1;
        }
        catch (IOException localIOException1)
        {
          ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException1, "read contentLength", new Object[0]);
          localObject5 = localObject2;
          continue;
        }
        bo.b((Closeable)localObject4);
        AppMethodBeat.o(132935);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException1, "", new Object[0]);
        localObject2 = null;
        continue;
      }
      Object localObject5;
      label231:
      a.bX(localObject5, (String)localObject2);
      try
      {
        localObject2 = new FileInputStream(localObject5);
        localObject5 = localObject2;
        if (localObject2 == null) {
          continue;
        }
        try
        {
          l = ((InputStream)localObject2).available();
          locala.a(d.decodeStream((InputStream)localObject2), l);
          localObject5 = localObject2;
        }
        catch (IOException localIOException2)
        {
          ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException2, "read contentLength", new Object[0]);
          Object localObject6 = localObject2;
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException2, "", new Object[0]);
          Object localObject3 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.2
 * JD-Core Version:    0.7.0.1
 */