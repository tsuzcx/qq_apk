package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.pluginsdk.k.a.c.c;
import com.tencent.mm.pluginsdk.k.a.c.f.d;
import com.tencent.mm.pluginsdk.k.a.c.m;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.Iterator;

public final class bc
{
  final b nGG;
  
  bc()
  {
    AppMethodBeat.i(90618);
    this.nGG = new b();
    AppMethodBeat.o(90618);
  }
  
  public static String bHt()
  {
    AppMethodBeat.i(90619);
    String str2 = h.aHG().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "appbrand/pkg/";
    FilePathGenerator.checkMkdir(str1);
    AppMethodBeat.o(90619);
    return str1;
  }
  
  public final int c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(90620);
    if (this.nGG.bqz(parama.QYU))
    {
      Log.i("MicroMsg.WxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[] { parama.QYU });
      AppMethodBeat.o(90620);
      return 0;
    }
    int i = this.nGG.b(parama);
    Log.i("MicroMsg.WxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[] { parama.QYU, Integer.valueOf(i) });
    AppMethodBeat.o(90620);
    return i;
  }
  
  static final class b
    extends m
  {
    b()
    {
      super(new bc.d());
      AppMethodBeat.i(206813);
      AppMethodBeat.o(206813);
    }
    
    public final f.d<com.tencent.mm.plugin.appbrand.appcache.a.a> a(com.tencent.mm.pluginsdk.k.a.c.k paramk)
    {
      AppMethodBeat.i(90598);
      paramk = new bc.c((com.tencent.mm.plugin.appbrand.appcache.a.a)paramk);
      paramk.RaJ = hiI();
      AppMethodBeat.o(90598);
      return paramk;
    }
    
    public final int b(com.tencent.mm.pluginsdk.k.a.c.k paramk)
    {
      AppMethodBeat.i(90599);
      int i = super.b(paramk);
      if (i == 1)
      {
        super.b(paramk);
        AppMethodBeat.o(90599);
        return 2;
      }
      AppMethodBeat.o(90599);
      return i;
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(90597);
      super.shutdown();
      ((bc.d)hiI()).nGT.quit();
      AppMethodBeat.o(90597);
    }
  }
  
  static final class d
    implements c
  {
    final MMHandler nGT;
    
    d()
    {
      AppMethodBeat.i(206630);
      this.nGT = new MMHandler("WxaPkgDownloadPerformerEventDispatchThread");
      AppMethodBeat.o(206630);
    }
    
    private static void a(bc.c paramc, com.tencent.mm.pluginsdk.k.a.c.l paraml)
    {
      AppMethodBeat.i(90617);
      u.deleteFile(paraml.filePath);
      if ((paramc.bHu() instanceof l))
      {
        k.nEn.a((l)paramc.bHu(), paraml);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.bHu() instanceof az))
      {
        t.a((az)paramc.bHu(), paraml, paramc.nGS);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.bHu() instanceof ca))
      {
        cb.a((ca)paramc.bHu(), paraml, paramc.nGS);
        AppMethodBeat.o(90617);
        return;
      }
      String str = paramc.bHu().appId;
      if ((paraml.RaE instanceof com.tencent.mm.pluginsdk.k.a.b.a)) {
        paramc = b.a.a.nIL;
      }
      for (;;)
      {
        bq.a(paraml.QYU, str, paramc);
        AppMethodBeat.o(90617);
        return;
        switch (paraml.httpStatusCode)
        {
        default: 
          paramc = b.a.a.nIG;
          break;
        case 403: 
        case 404: 
          paramc = b.a.a.nIK;
        }
      }
    }
    
    public static void b(com.tencent.mm.pluginsdk.k.a.c.e parame, com.tencent.mm.pluginsdk.k.a.c.l paraml)
    {
      AppMethodBeat.i(90613);
      a((bc.c)parame, paraml);
      AppMethodBeat.o(90613);
    }
    
    public static void c(com.tencent.mm.pluginsdk.k.a.c.e parame, com.tencent.mm.pluginsdk.k.a.c.l paraml)
    {
      AppMethodBeat.i(90614);
      Object localObject1 = ((bc.c)parame).bHu();
      if ((localObject1 instanceof az))
      {
        paraml = (az)localObject1;
        localObject1 = ((bc.c)parame).nGS;
        parame = ((com.tencent.mm.plugin.appbrand.api.e)h.ae(com.tencent.mm.plugin.appbrand.api.e.class)).bFb();
        if (parame == null)
        {
          bq.a(paraml.QYU, paraml.appId, b.a.a.nIM, null);
          AppMethodBeat.o(90614);
          return;
        }
        Object localObject2 = paraml.appId;
        j = paraml.nGn;
        i = paraml.nGo;
        str = paraml.bHi();
        Object localObject3 = parame.b((String)localObject2, j, 0, new String[] { "pkgPath" });
        if (localObject3 == null)
        {
          Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, get NULL oldInfo with appId[%s] version[%d]", new Object[] { localObject2, Integer.valueOf(j) });
          bq.a(paraml.QYU, paraml.appId, b.a.a.nIM, null);
          AppMethodBeat.o(90614);
          return;
        }
        ((af.a)localObject1).bGs();
        long l1 = SystemClock.elapsedRealtime();
        j = t.C(((bh)localObject3).field_pkgPath, str, paraml.getFilePath());
        long l2 = SystemClock.elapsedRealtime();
        Log.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", new Object[] { paraml.appId, ((bh)localObject3).field_pkgPath, str, paraml.getFilePath(), Long.valueOf(l2 - l1), Integer.valueOf(j) });
        ((af.a)localObject1).zb(j);
        boolean bool2 = paraml.nGp instanceof b.b;
        if (j == 0)
        {
          Collection localCollection = bq.ade(paraml.QYU);
          localObject2 = new i();
          localObject3 = new i();
          i locali = new i();
          t.1 local1 = new t.1((i)localObject2, (i)localObject3, locali);
          bq.a(paraml.QYU, local1);
          bq.a(paraml.QYU, paraml.appId, str, i, 0, (af.a)localObject1);
          if (b.a.a.nIF == ((i)localObject3).value) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, urlKey[%s] verifyOk[%s] canFallback[%b]", new Object[] { paraml.QYU, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if ((!bool1) && (bool2)) {
              break label484;
            }
            if (localCollection == null) {
              break;
            }
            parame = localCollection.iterator();
            while (parame.hasNext()) {
              ((bq.a)parame.next()).a((String)((i)localObject2).value, (b.a.a)((i)localObject3).value, locali.value);
            }
          }
          AppMethodBeat.o(90614);
          return;
          label484:
          bq.a(paraml.QYU, localCollection);
        }
        u.deleteFile(str);
        u.deleteFile(paraml.getFilePath());
        localObject1 = new t.2(bq.ade(paraml.QYU), paraml);
        parame = parame.b(paraml.appId, paraml.nGo, 0, new String[] { "downloadURL" });
        if ((parame == null) || (TextUtils.isEmpty(parame.field_downloadURL)))
        {
          Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, fallback non-incremental get EMPTY url with key[%s]", new Object[] { paraml.QYU });
          ((bq.a)localObject1).a(paraml.appId, b.a.a.nIM, null);
          AppMethodBeat.o(90614);
          return;
        }
        if (!bq.c(paraml.appId, 0, paraml.nGo, parame.field_downloadURL, (bq.a)localObject1)) {
          ((bq.a)localObject1).a(paraml.appId, b.a.a.nIM, null);
        }
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof ca))
      {
        cb.a((ca)localObject1, ((bc.c)parame).nGS);
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof l))
      {
        k.nEn.a((l)localObject1, paraml);
        AppMethodBeat.o(90614);
        return;
      }
      String str = ((bc.c)parame).bHu().appId;
      int i = ((bc.c)parame).bHu().version;
      int j = ((bc.c)parame).bHu().fES;
      try
      {
        if ((localObject1 instanceof ay)) {}
        for (localObject1 = ((ay)localObject1).nGm;; localObject1 = null)
        {
          bq.a(paraml.QYU, str, paraml.filePath, i, j, (String)localObject1, ((bc.c)parame).nGS);
          AppMethodBeat.o(90614);
          return;
        }
        return;
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace("MicroMsg.WxaPkgDownloadPerformer", parame, "dispatchComplete", new Object[0]);
        bq.cz(paraml.QYU, str);
        AppMethodBeat.o(90614);
      }
    }
    
    public static void d(com.tencent.mm.pluginsdk.k.a.c.e parame, com.tencent.mm.pluginsdk.k.a.c.l paraml)
    {
      AppMethodBeat.i(90615);
      a((bc.c)parame, paraml);
      AppMethodBeat.o(90615);
    }
    
    public final void C(String paramString, int paramInt1, int paramInt2) {}
    
    public final void O(String paramString, long paramLong) {}
    
    public final void a(final com.tencent.mm.pluginsdk.k.a.c.e parame, final com.tencent.mm.pluginsdk.k.a.c.l paraml)
    {
      AppMethodBeat.i(90612);
      this.nGT.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(90610);
          switch (paraml.status)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(90610);
            return;
            bc.d.d(parame, paraml);
            AppMethodBeat.o(90610);
            return;
            bc.d.c(parame, paraml);
            AppMethodBeat.o(90610);
            return;
            bc.d.b(parame, paraml);
          }
        }
      });
      AppMethodBeat.o(90612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bc
 * JD-Core Version:    0.7.0.1
 */