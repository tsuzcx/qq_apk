package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.y;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.plugin.appbrand.appcache.bi.a;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;

final class aq
  extends am
{
  final String appId;
  final String coW;
  final int dnt;
  int dtF;
  private final int[] lJM;
  
  aq(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, 4);
  }
  
  aq(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(new ac(paramString1, paramString2, paramInt2));
    AppMethodBeat.i(47261);
    this.dtF = 4;
    this.lJM = new int[] { 6, 12, 13 };
    this.appId = paramString1;
    this.coW = paramString2;
    this.dnt = paramInt1;
    if (a.contains(this.lJM, paramInt2)) {
      this.dtF = paramInt2;
    }
    AppMethodBeat.o(47261);
  }
  
  public final String aWs()
  {
    AppMethodBeat.i(47262);
    String str = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[] { this.appId, this.coW, Integer.valueOf(this.dnt), Integer.valueOf(this.dtF), this.lJz });
    AppMethodBeat.o(47262);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(47263);
    try
    {
      Pair localPair = WxaPkgIntegrityChecker.D(this.lJz.toString(), this.dnt, 1);
      if (localPair.second != null)
      {
        ((WxaPkgWrappingInfo)localPair.second).name = this.coW;
        f((WxaPkgWrappingInfo)localPair.second);
        ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s prepare ok", new Object[] { aWs() });
        brr();
        AppMethodBeat.o(47263);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      if (!g.ajx())
      {
        f(null);
        AppMethodBeat.o(47263);
        return;
      }
      AppMethodBeat.o(47263);
      throw localNullPointerException;
      if (bt.isNullOrNil(this.coW)) {
        localObject1 = j.aYX().aP(this.appId, this.dnt);
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = new al(this.dnt)
        {
          protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
          {
            AppMethodBeat.i(47259);
            super.b(paramAnonymousWxaPkgLoadProgress);
            aq.this.c(paramAnonymousWxaPkgLoadProgress);
            AppMethodBeat.o(47259);
          }
          
          final String brq()
          {
            AppMethodBeat.i(47257);
            String str = aq.this.aWs();
            AppMethodBeat.o(47257);
            return str;
          }
          
          final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(47258);
            aq.this.f(paramAnonymousWxaPkgWrappingInfo);
            aq.this.g(paramAnonymousWxaPkgWrappingInfo);
            AppMethodBeat.o(47258);
          }
        };
        ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", new Object[] { aWs(), localObject1 });
        if (!bt.isNullOrNil((String)localObject1)) {
          break label653;
        }
        f(null);
        AppMethodBeat.o(47263);
        return;
        localObject1 = j.aYX().a(this.lJz.toString(), this.dnt, new String[] { "versionMd5", "downloadURL" });
        if (localObject1 == null)
        {
          ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", new Object[] { aWs() });
          localObject1 = null;
        }
        else
        {
          if ((!DebuggerShell.bew()) || (TextUtils.isEmpty(((bc)localObject1).field_downloadURL))) {
            break;
          }
          ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "getDownloadURL, with appId[%s], module[%s] hit monkey pushed url[%s]", new Object[] { this.appId, this.coW, ((bc)localObject1).field_downloadURL });
          localObject1 = ((bc)localObject1).field_downloadURL;
        }
      }
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, record md5:%s", new Object[] { aWs(), ((bc)localObject1).field_versionMd5 });
      Object localObject1 = y.a(new i(this.appId, this.coW, ((bc)localObject1).field_versionMd5, this.dnt, this.dtF));
      if ((localObject1 == null) || (((com.tencent.mm.al.a.a)localObject1).errType != 0) || (((com.tencent.mm.al.a.a)localObject1).errCode != 0))
      {
        localObject2 = aWs();
        int i;
        if (localObject1 == null)
        {
          i = -1;
          label386:
          if (localObject1 != null) {
            break label473;
          }
          j = -1;
          label392:
          ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, cgi failed, %d %d", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j) });
          if (localObject1 != null) {
            break label481;
          }
          i = -1;
          label428:
          if (localObject1 != null) {
            break label489;
          }
        }
        for (int j = -1;; j = ((com.tencent.mm.al.a.a)localObject1).errCode)
        {
          bf.RO(bf.getMMString(2131755577, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          localObject1 = null;
          break;
          i = ((com.tencent.mm.al.a.a)localObject1).errType;
          break label386;
          j = ((com.tencent.mm.al.a.a)localObject1).errCode;
          break label392;
          i = ((com.tencent.mm.al.a.a)localObject1).errType;
          break label428;
        }
      }
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", new Object[] { Integer.valueOf(((bjf)((com.tencent.mm.al.a.a)localObject1).hNC).error_code), ((bjf)((com.tencent.mm.al.a.a)localObject1).hNC).error_msg, ((bjf)((com.tencent.mm.al.a.a)localObject1).hNC).fJm });
      if (bt.isNullOrNil(((bjf)((com.tencent.mm.al.a.a)localObject1).hNC).fJm))
      {
        if (((bjf)((com.tencent.mm.al.a.a)localObject1).hNC).error_code != -1001) {
          break label615;
        }
        AppBrand404PageUI.show(2131755606);
        h.S(this.appId, 4, this.dnt + 1);
      }
      for (;;)
      {
        localObject1 = ((bjf)((com.tencent.mm.al.a.a)localObject1).hNC).fJm;
        break;
        label615:
        bf.RO(e.getMMString(2131755580, new Object[] { Integer.valueOf(5), Integer.valueOf(((bjf)((com.tencent.mm.al.a.a)localObject1).hNC).error_code) }));
      }
      label653:
      if (!bi.a(this.lJz.toString(), this.dnt, (String)localObject1, (bi.a)localObject2, new com.tencent.mm.plugin.appbrand.appcache.a.a.a()
      {
        public final String aZW()
        {
          AppMethodBeat.i(47260);
          Object localObject = j.aYX().a(aq.this.lJz.toString(), aq.this.dnt, new String[] { "versionMd5" });
          localObject = "_" + ((bc)localObject).field_versionMd5;
          AppMethodBeat.o(47260);
          return localObject;
        }
      }))
      {
        ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", new Object[] { aWs() });
        f(null);
        AppMethodBeat.o(47263);
        return;
      }
      brt();
      AppMethodBeat.o(47263);
      return;
    }
    catch (b localb)
    {
      label82:
      label473:
      label481:
      label489:
      break label82;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aq
 * JD-Core Version:    0.7.0.1
 */