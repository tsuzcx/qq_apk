package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.y;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Locale;

final class aq
  extends am
{
  final String appId;
  final String coY;
  final int dov;
  int duK;
  private final int[] lOm;
  
  aq(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, 4);
  }
  
  aq(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(new ad(paramString1, paramString2, paramInt2));
    AppMethodBeat.i(47261);
    this.duK = 4;
    this.lOm = new int[] { 6, 12, 13 };
    this.appId = paramString1;
    this.coY = paramString2;
    this.dov = paramInt1;
    if (a.contains(this.lOm, paramInt2)) {
      this.duK = paramInt2;
    }
    AppMethodBeat.o(47261);
  }
  
  public final String aWU()
  {
    AppMethodBeat.i(47262);
    String str = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[] { this.appId, this.coY, Integer.valueOf(this.dov), Integer.valueOf(this.duK), this.lNZ });
    AppMethodBeat.o(47262);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(47263);
    try
    {
      Pair localPair = WxaPkgIntegrityChecker.D(this.lNZ.toString(), this.dov, 1);
      if (localPair.second != null)
      {
        ((WxaPkgWrappingInfo)localPair.second).name = this.coY;
        f((WxaPkgWrappingInfo)localPair.second);
        ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s prepare ok", new Object[] { aWU() });
        bsc();
        AppMethodBeat.o(47263);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      if (!g.ajM())
      {
        f(null);
        AppMethodBeat.o(47263);
        return;
      }
      AppMethodBeat.o(47263);
      throw localNullPointerException;
      if (bu.isNullOrNil(this.coY)) {
        localObject1 = j.aZu().aS(this.appId, this.dov);
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = new al(this.dov)
        {
          protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
          {
            AppMethodBeat.i(47259);
            super.b(paramAnonymousWxaPkgLoadProgress);
            aq.this.c(paramAnonymousWxaPkgLoadProgress);
            AppMethodBeat.o(47259);
          }
          
          final String bsb()
          {
            AppMethodBeat.i(47257);
            String str = aq.this.aWU();
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
        ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", new Object[] { aWU(), localObject1 });
        if (!bu.isNullOrNil((String)localObject1)) {
          break label653;
        }
        f(null);
        AppMethodBeat.o(47263);
        return;
        localObject1 = j.aZu().a(this.lNZ.toString(), this.dov, new String[] { "versionMd5", "downloadURL" });
        if (localObject1 == null)
        {
          ae.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", new Object[] { aWU() });
          localObject1 = null;
        }
        else
        {
          if ((!DebuggerShell.bfe()) || (TextUtils.isEmpty(((bd)localObject1).field_downloadURL))) {
            break;
          }
          ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "getDownloadURL, with appId[%s], module[%s] hit monkey pushed url[%s]", new Object[] { this.appId, this.coY, ((bd)localObject1).field_downloadURL });
          localObject1 = ((bd)localObject1).field_downloadURL;
        }
      }
      ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, record md5:%s", new Object[] { aWU(), ((bd)localObject1).field_versionMd5 });
      Object localObject1 = y.a(new i(this.appId, this.coY, ((bd)localObject1).field_versionMd5, this.dov, this.duK));
      if ((localObject1 == null) || (((com.tencent.mm.ak.a.a)localObject1).errType != 0) || (((com.tencent.mm.ak.a.a)localObject1).errCode != 0))
      {
        localObject2 = aWU();
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
          ae.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, cgi failed, %d %d", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j) });
          if (localObject1 != null) {
            break label481;
          }
          i = -1;
          label428:
          if (localObject1 != null) {
            break label489;
          }
        }
        for (int j = -1;; j = ((com.tencent.mm.ak.a.a)localObject1).errCode)
        {
          bf.Sx(bf.getMMString(2131755577, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          localObject1 = null;
          break;
          i = ((com.tencent.mm.ak.a.a)localObject1).errType;
          break label386;
          j = ((com.tencent.mm.ak.a.a)localObject1).errCode;
          break label392;
          i = ((com.tencent.mm.ak.a.a)localObject1).errType;
          break label428;
        }
      }
      ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", new Object[] { Integer.valueOf(((bjx)((com.tencent.mm.ak.a.a)localObject1).hQv).error_code), ((bjx)((com.tencent.mm.ak.a.a)localObject1).hQv).error_msg, ((bjx)((com.tencent.mm.ak.a.a)localObject1).hQv).fLp });
      if (bu.isNullOrNil(((bjx)((com.tencent.mm.ak.a.a)localObject1).hQv).fLp))
      {
        if (((bjx)((com.tencent.mm.ak.a.a)localObject1).hQv).error_code != -1001) {
          break label615;
        }
        AppBrand404PageUI.show(2131755606);
        h.S(this.appId, 4, this.dov + 1);
      }
      for (;;)
      {
        localObject1 = ((bjx)((com.tencent.mm.ak.a.a)localObject1).hQv).fLp;
        break;
        label615:
        bf.Sx(f.getMMString(2131755580, new Object[] { Integer.valueOf(5), Integer.valueOf(((bjx)((com.tencent.mm.ak.a.a)localObject1).hQv).error_code) }));
      }
      label653:
      if (!bj.a(this.lNZ.toString(), this.dov, (String)localObject1, (bj.a)localObject2, new com.tencent.mm.plugin.appbrand.appcache.a.a.a()
      {
        public final String bav()
        {
          AppMethodBeat.i(47260);
          Object localObject = j.aZu().a(aq.this.lNZ.toString(), aq.this.dov, new String[] { "versionMd5" });
          localObject = "_" + ((bd)localObject).field_versionMd5;
          AppMethodBeat.o(47260);
          return localObject;
        }
      }))
      {
        ae.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", new Object[] { aWU() });
        f(null);
        AppMethodBeat.o(47263);
        return;
      }
      bse();
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