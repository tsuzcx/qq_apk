package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.pluginsdk.j.a.c.c;
import com.tencent.mm.pluginsdk.j.a.c.f.d;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vfs.o;
import java.util.Collection;
import java.util.Iterator;

public final class az
{
  final b jKM;
  
  az()
  {
    AppMethodBeat.i(90618);
    this.jKM = new b();
    AppMethodBeat.o(90618);
  }
  
  public static String baY()
  {
    AppMethodBeat.i(90619);
    String str2 = g.ajR().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "appbrand/pkg/";
    com.tencent.mm.sdk.platformtools.n.aMy(str1);
    AppMethodBeat.o(90619);
    return str1;
  }
  
  public final int c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(90620);
    if (this.jKM.aNB(parama.Fhz))
    {
      ae.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[] { parama.Fhz });
      AppMethodBeat.o(90620);
      return 0;
    }
    int i = this.jKM.b(parama);
    ae.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[] { parama.Fhz, Integer.valueOf(i) });
    AppMethodBeat.o(90620);
    return i;
  }
  
  final class b
    extends com.tencent.mm.pluginsdk.j.a.c.n
  {
    b()
    {
      super(new az.d(az.this));
      AppMethodBeat.i(90596);
      AppMethodBeat.o(90596);
    }
    
    public final f.d a(com.tencent.mm.pluginsdk.j.a.c.l paraml)
    {
      AppMethodBeat.i(90598);
      paraml = new az.c((com.tencent.mm.plugin.appbrand.appcache.a.a)paraml);
      paraml.Fjn = this.Fjk;
      AppMethodBeat.o(90598);
      return paraml;
    }
    
    public final int b(com.tencent.mm.pluginsdk.j.a.c.l paraml)
    {
      AppMethodBeat.i(90599);
      int i = super.b(paraml);
      if (i == 1)
      {
        super.b(paraml);
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
      ((az.d)this.Fjk).jLa.quit();
      AppMethodBeat.o(90597);
    }
  }
  
  final class d
    implements c
  {
    final aq jLa;
    
    d()
    {
      AppMethodBeat.i(90611);
      this.jLa = new aq("WxaPkgDownloadPerformerEventDispatchThread");
      AppMethodBeat.o(90611);
    }
    
    private static void a(az.c paramc, m paramm)
    {
      AppMethodBeat.i(90617);
      o.deleteFile(paramm.filePath);
      if ((paramc.baZ() instanceof l))
      {
        k.jIB.a((l)paramc.baZ(), paramm);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.baZ() instanceof aw))
      {
        s.a((aw)paramc.baZ(), paramm, paramc.jKZ);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.baZ() instanceof bs))
      {
        bt.a((bs)paramc.baZ(), paramm, paramc.jKZ);
        AppMethodBeat.o(90617);
        return;
      }
      String str = paramc.baZ().appId;
      if ((paramm.Fji instanceof com.tencent.mm.pluginsdk.j.a.b.a)) {
        paramc = b.a.a.jME;
      }
      for (;;)
      {
        bj.a(paramm.Fhz, str, paramc);
        AppMethodBeat.o(90617);
        return;
        switch (paramm.httpStatusCode)
        {
        default: 
          paramc = b.a.a.jMz;
          break;
        case 403: 
        case 404: 
          paramc = b.a.a.jMD;
        }
      }
    }
    
    public static void b(com.tencent.mm.pluginsdk.j.a.c.e parame, m paramm)
    {
      AppMethodBeat.i(90613);
      a((az.c)parame, paramm);
      AppMethodBeat.o(90613);
    }
    
    public static void c(com.tencent.mm.pluginsdk.j.a.c.e parame, m paramm)
    {
      AppMethodBeat.i(90614);
      Object localObject1 = ((az.c)parame).baZ();
      if ((localObject1 instanceof aw))
      {
        paramm = (aw)localObject1;
        localObject1 = ((az.c)parame).jKZ;
        parame = ((com.tencent.mm.plugin.appbrand.api.e)g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP();
        if (parame == null)
        {
          bj.a(paramm.Fhz, paramm.appId, b.a.a.jMF, null);
          AppMethodBeat.o(90614);
          return;
        }
        Object localObject2 = paramm.appId;
        j = paramm.jKu;
        i = paramm.jKv;
        String str = paramm.baN();
        Object localObject3 = parame.a((String)localObject2, j, 0, new String[] { "pkgPath" });
        if (localObject3 == null)
        {
          ae.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, get NULL oldInfo with appId[%s] version[%d]", new Object[] { localObject2, Integer.valueOf(j) });
          bj.a(paramm.Fhz, paramm.appId, b.a.a.jMF, null);
          AppMethodBeat.o(90614);
          return;
        }
        ((ae.a)localObject1).aZV();
        long l1 = SystemClock.elapsedRealtime();
        j = s.z(((bd)localObject3).field_pkgPath, str, paramm.getFilePath());
        long l2 = SystemClock.elapsedRealtime();
        ae.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", new Object[] { paramm.appId, ((bd)localObject3).field_pkgPath, str, paramm.getFilePath(), Long.valueOf(l2 - l1), Integer.valueOf(j) });
        ((ae.a)localObject1).rU(j);
        boolean bool2 = paramm.jKw instanceof b.b;
        if (j == 0)
        {
          Collection localCollection = bj.Ml(paramm.Fhz);
          localObject2 = new i();
          localObject3 = new i();
          i locali = new i();
          s.1 local1 = new s.1((i)localObject2, (i)localObject3, locali);
          bj.a(paramm.Fhz, local1);
          bj.a(paramm.Fhz, paramm.appId, str, i, 0, (ae.a)localObject1);
          if (b.a.a.jMy == ((i)localObject3).value) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            ae.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, urlKey[%s] verifyOk[%s] canFallback[%b]", new Object[] { paramm.Fhz, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if ((!bool1) && (bool2)) {
              break label484;
            }
            if (localCollection == null) {
              break;
            }
            parame = localCollection.iterator();
            while (parame.hasNext()) {
              ((bj.a)parame.next()).a((String)((i)localObject2).value, (b.a.a)((i)localObject3).value, locali.value);
            }
          }
          AppMethodBeat.o(90614);
          return;
          label484:
          bj.a(paramm.Fhz, localCollection);
        }
        o.deleteFile(str);
        o.deleteFile(paramm.getFilePath());
        localObject1 = new s.2(bj.Ml(paramm.Fhz), paramm);
        if ((paramm.jKw instanceof b.b)) {
          ((b.b)paramm.jKw).bbq();
        }
        parame = parame.a(paramm.appId, paramm.jKv, 0, new String[] { "downloadURL" });
        if ((parame == null) || (TextUtils.isEmpty(parame.field_downloadURL)))
        {
          ae.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, fallback non-incremental get EMPTY url with key[%s]", new Object[] { paramm.Fhz });
          ((bj.a)localObject1).a(paramm.appId, b.a.a.jMF, null);
          AppMethodBeat.o(90614);
          return;
        }
        if (!bj.b(paramm.appId, 0, paramm.jKv, parame.field_downloadURL, (bj.a)localObject1)) {
          ((bj.a)localObject1).a(paramm.appId, b.a.a.jMF, null);
        }
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof bs))
      {
        bt.a((bs)localObject1, ((az.c)parame).jKZ);
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof l))
      {
        k.jIB.a((l)localObject1, paramm);
        AppMethodBeat.o(90614);
        return;
      }
      localObject1 = ((az.c)parame).baZ().appId;
      int i = ((az.c)parame).baZ().version;
      int j = ((az.c)parame).baZ().duK;
      try
      {
        bj.a(paramm.Fhz, (String)localObject1, paramm.filePath, i, j, ((az.c)parame).jKZ);
        AppMethodBeat.o(90614);
        return;
      }
      catch (Exception parame)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", parame, "dispatchComplete", new Object[0]);
        bj.cg(paramm.Fhz, (String)localObject1);
        AppMethodBeat.o(90614);
      }
    }
    
    public static void d(com.tencent.mm.pluginsdk.j.a.c.e parame, m paramm)
    {
      AppMethodBeat.i(90615);
      a((az.c)parame, paramm);
      AppMethodBeat.o(90615);
    }
    
    public final void C(String paramString, int paramInt1, int paramInt2) {}
    
    public final void O(String paramString, long paramLong) {}
    
    public final void a(final com.tencent.mm.pluginsdk.j.a.c.e parame, final m paramm)
    {
      AppMethodBeat.i(90612);
      this.jLa.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(90610);
          switch (paramm.status)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(90610);
            return;
            az.d.d(parame, paramm);
            AppMethodBeat.o(90610);
            return;
            az.d.c(parame, paramm);
            AppMethodBeat.o(90610);
            return;
            az.d.b(parame, paramm);
          }
        }
      });
      AppMethodBeat.o(90612);
    }
    
    public final void a(String paramString, com.tencent.mm.pluginsdk.j.a.c.k paramk)
    {
      AppMethodBeat.i(90616);
      bj.a(paramString, (WxaPkgLoadProgress)paramk);
      AppMethodBeat.o(90616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.az
 * JD-Core Version:    0.7.0.1
 */