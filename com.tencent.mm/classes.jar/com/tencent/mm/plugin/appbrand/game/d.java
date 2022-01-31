package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.PartialFile;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.plugin.appbrand.i.q;
import com.tencent.mm.plugin.appbrand.t.o;
import com.tencent.mm.plugin.appbrand.t.o.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

final class d
  extends com.tencent.luggage.game.e.a.a.d
{
  d(c paramc, q paramq)
  {
    super(paramc, paramq);
  }
  
  private static String Br(String paramString)
  {
    AppMethodBeat.i(143113);
    Object localObject = null;
    try
    {
      paramString = com.tencent.mm.vfs.e.cS(paramString);
      AppMethodBeat.o(143113);
      return paramString;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WAGameJsContextInterfaceWC", paramString, "getGameEngineScript exception:%s", new Object[] { paramString.toString() });
        paramString = localObject;
      }
    }
  }
  
  public final void a(g paramg, String paramString1, String paramString2)
  {
    AppMethodBeat.i(143112);
    PartialFile[] arrayOfPartialFile = ((c)this.bEw).wj().wR().hiX.gUA;
    if ((paramString1.equals("game.js")) && (arrayOfPartialFile != null) && (arrayOfPartialFile.length > 0))
    {
      ab.i("MicroMsg.WAGameJsContextInterfaceWC", "inject codeLib size:%s", new Object[] { Integer.valueOf(arrayOfPartialFile.length) });
      int j = arrayOfPartialFile.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = arrayOfPartialFile[i];
        int k = ((PartialFile)localObject).version;
        String str1 = ((PartialFile)localObject).bsd;
        String str2 = str1 + "_" + k;
        String str3 = ((PartialFile)localObject).cqq;
        localObject = ((PartialFile)localObject).filePath;
        if ((!bo.isNullOrNil(str1)) && (!bo.isNullOrNil((String)localObject)))
        {
          ab.i("MicroMsg.WAGameJsContextInterfaceWC", "provider:%s,version:%s", new Object[] { str1, Integer.valueOf(k) });
          localObject = Br((String)localObject);
          if (!bo.isNullOrNil((String)localObject)) {
            break label214;
          }
          ab.e("MicroMsg.WAGameJsContextInterfaceWC", "game engine null!");
        }
        for (;;)
        {
          i += 1;
          break;
          label214:
          ab.i("MicroMsg.WAGameJsContextInterfaceWC", "game engine:%s", new Object[] { ((String)localObject).substring(0, 20) });
          long l = System.currentTimeMillis();
          o.a(((c)this.bEw).wj(), paramg, paramString1, str2, str3, (String)localObject, o.a.iXQ, new d.1(this, str1, (String)localObject, l));
        }
      }
    }
    super.a(paramg, paramString1, paramString2);
    AppMethodBeat.o(143112);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(143114);
    if ("WAGameSubContext.js".equals(paramString1))
    {
      if ((paramBoolean) && ((((c)this.bEw).aud()) || (((c)this.bEw).isRunning())))
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
        com.tencent.mm.plugin.appbrand.report.quality.b.a(((c)this.bEw).aud(), ((c)this.bEw).getAppId(), paramLong1, paramString1, paramString2.length());
      }
      h.qsU.idkeyStat(778L, 17L, 1L, false);
      if (paramBoolean)
      {
        h.qsU.idkeyStat(778L, 19L, 1L, false);
        AppMethodBeat.o(143114);
        return;
      }
      h.qsU.idkeyStat(778L, 18L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.e.bq(((c)this.bEw).getAppId(), 24);
      com.tencent.mm.plugin.appbrand.report.e.b(((c)this.bEw).getAppId(), ((c)this.bEw).wj().wR().hiX.gXf, ((c)this.bEw).wj().wR().hiX.gXe, 778, 18);
      AppMethodBeat.o(143114);
      return;
    }
    if (paramString1.endsWith("game.js"))
    {
      com.tencent.luggage.sdk.d.b localb;
      String str;
      if ((((c)this.bEw).aud()) || (((c)this.bEw).isRunning()))
      {
        localb = ((c)this.bEw).wj();
        if (localb == null) {
          break label365;
        }
        i = localb.hashCode();
        ab.i("MicroMsg.WAGameJsContextInterfaceWC", "[QualitySystem] app-service.js runtime.hashCode = [%d]", new Object[] { Integer.valueOf(i) });
        str = ((c)this.bEw).getAppId();
        if (localb == null) {
          break label371;
        }
      }
      label365:
      label371:
      for (int i = localb.hashCode();; i = -1)
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.a(str, paramString1, paramString2, paramLong1, i);
        h.qsU.idkeyStat(778L, 21L, 1L, false);
        if (!paramBoolean) {
          break label377;
        }
        h.qsU.idkeyStat(778L, 23L, 1L, false);
        AppMethodBeat.o(143114);
        return;
        i = -1;
        break;
      }
      label377:
      h.qsU.idkeyStat(778L, 22L, 1L, false);
      com.tencent.mm.plugin.appbrand.report.e.bq(((c)this.bEw).getAppId(), 24);
      com.tencent.mm.plugin.appbrand.report.e.b(((c)this.bEw).getAppId(), ((c)this.bEw).wj().wR().hiX.gXf, ((c)this.bEw).wj().wR().hiX.gXe, 778, 22);
    }
    AppMethodBeat.o(143114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d
 * JD-Core Version:    0.7.0.1
 */