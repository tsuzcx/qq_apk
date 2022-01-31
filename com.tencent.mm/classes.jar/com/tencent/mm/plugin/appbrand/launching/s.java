package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.PartialFile;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaCodeLibInfo;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class s
  implements n
{
  final String appId;
  final int hcr;
  final List<WxaAttributes.WxaCodeLibInfo> hkg;
  final int iln;
  private final AtomicInteger ilp;
  private volatile boolean ilq;
  LinkedHashMap<String, j<WxaPkgWrappingInfo>> ilw;
  private com.tencent.mm.plugin.appbrand.launching.c.a ilx;
  
  s(String paramString, int paramInt1, int paramInt2, List<WxaAttributes.WxaCodeLibInfo> paramList)
  {
    AppMethodBeat.i(131854);
    this.ilw = new LinkedHashMap();
    this.ilp = new AtomicInteger(0);
    this.ilq = false;
    ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "appId:%s,versionType:%s,desirePkgVersion:%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.appId = paramString;
    this.hcr = paramInt1;
    this.hkg = paramList;
    this.iln = paramInt2;
    this.ilx = new com.tencent.mm.plugin.appbrand.launching.c.a(paramString, paramInt2, paramInt1, paramList);
    AppMethodBeat.o(131854);
  }
  
  private WxaPkgWrappingInfo azY()
  {
    AppMethodBeat.i(131855);
    Object localObject1 = as.F(this.appId, this.hcr, this.iln);
    if (((Pair)localObject1).second != null)
    {
      ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.hcr), Integer.valueOf(this.iln) });
      try
      {
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)g.w(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).az(this.appId, this.iln);
        localObject1 = (WxaPkgWrappingInfo)((Pair)localObject1).second;
        AppMethodBeat.o(131855);
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", localThrowable, "checkReportOnLocalPkgFound, appId[%s], version[%d]", new Object[] { this.appId, Integer.valueOf(this.iln) });
        }
      }
    }
    int j = this.hkg.size();
    ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codeLibList size:%d", new Object[] { Integer.valueOf(j) });
    localObject1 = new CountDownLatch(j + 1);
    int i = 0;
    if (i < j)
    {
      localObject3 = (WxaAttributes.WxaCodeLibInfo)this.hkg.get(i);
      if (localObject3 == null) {
        ab.e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codelibInfo:%d null!", new Object[] { Integer.valueOf(i) });
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((WxaAttributes.WxaCodeLibInfo)localObject3).bsd;
        int k = ((WxaAttributes.WxaCodeLibInfo)localObject3).version;
        if ((bo.isNullOrNil((String)localObject2)) || (bo.isNullOrNil(((WxaAttributes.WxaCodeLibInfo)localObject3).cqq)))
        {
          ab.e("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "codeLib null or codeLib md5 null!");
          com.tencent.mm.plugin.appbrand.launching.c.a.oK(6);
          ((CountDownLatch)localObject1).countDown();
        }
        else
        {
          this.ilw.put(((WxaAttributes.WxaCodeLibInfo)localObject3).cqq, new j());
          localObject3 = o.d.b((String)localObject2, "__CODELIB__", 0, k, 14);
          ((o)localObject3).a(new s.1(this, (CountDownLatch)localObject1, (String)localObject2, k));
          ((o)localObject3).a(new s.2(this, (CountDownLatch)localObject1, (String)localObject2));
          ((o)localObject3).prepareAsync();
        }
      }
    }
    Object localObject2 = new j();
    Object localObject3 = o.d.b(this.appId, "__WITHOUT_CODELIB__", this.hcr, this.iln, 12);
    ((o)localObject3).a(new s.3(this, (j)localObject2, (CountDownLatch)localObject1));
    ((o)localObject3).a(new s.4(this, (CountDownLatch)localObject1));
    ((o)localObject3).prepareAsync();
    ((CountDownLatch)localObject1).await();
    ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "both downloaded");
    if (this.ilq) {
      aGQ();
    }
    if ((((j)localObject2).value == null) || (this.ilw.size() <= 0))
    {
      ab.i("MicroMsg.AppBrand.LaunchCheckPkgSplitCodeLibHandler", "mainModule value or codeLibList result null!!");
      AppMethodBeat.o(131855);
      return null;
    }
    this.ilx.IE();
    localObject1 = (WxaPkgWrappingInfo)((j)localObject2).value;
    ((WxaPkgWrappingInfo)localObject1).gUA = new PartialFile[j];
    i = 0;
    while (i < this.hkg.size())
    {
      localObject2 = (WxaAttributes.WxaCodeLibInfo)this.hkg.get(i);
      ((WxaPkgWrappingInfo)localObject1).gUA[i] = new PartialFile();
      if (!bo.isNullOrNil(((WxaAttributes.WxaCodeLibInfo)this.hkg.get(i)).cqq))
      {
        localObject3 = (WxaPkgWrappingInfo)((j)this.ilw.get(((WxaAttributes.WxaCodeLibInfo)this.hkg.get(i)).cqq)).value;
        if (localObject3 != null)
        {
          localObject1.gUA[i].cqq = ((WxaAttributes.WxaCodeLibInfo)this.hkg.get(i)).cqq;
          localObject1.gUA[i].bsd = ((WxaAttributes.WxaCodeLibInfo)localObject2).bsd;
          localObject1.gUA[i].version = ((WxaAttributes.WxaCodeLibInfo)localObject2).version;
          localObject1.gUA[i].filePath = ((WxaPkgWrappingInfo)localObject3).gUy;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(131855);
    return localObject1;
  }
  
  private void oE(int paramInt)
  {
    AppMethodBeat.i(131856);
    this.ilx.oL(paramInt);
    AppMethodBeat.o(131856);
  }
  
  public void aGL() {}
  
  public void aGQ() {}
  
  public void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.s
 * JD-Core Version:    0.7.0.1
 */