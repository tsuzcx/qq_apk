package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.y;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bh.a;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;

final class aq
  extends am
{
  final String appId;
  final String chK;
  final int deB;
  int dkC;
  private final int[] kLi;
  
  aq(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, 4);
  }
  
  aq(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(new ab(paramString1, paramString2, paramInt2));
    AppMethodBeat.i(47261);
    this.dkC = 4;
    this.kLi = new int[] { 6, 12, 13 };
    this.appId = paramString1;
    this.chK = paramString2;
    this.deB = paramInt1;
    if (a.contains(this.kLi, paramInt2)) {
      this.dkC = paramInt2;
    }
    AppMethodBeat.o(47261);
  }
  
  public final String aMu()
  {
    AppMethodBeat.i(47262);
    String str = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[] { this.appId, this.chK, Integer.valueOf(this.deB), Integer.valueOf(this.dkC), this.kKV });
    AppMethodBeat.o(47262);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(47263);
    try
    {
      Pair localPair = WxaPkgIntegrityChecker.C(this.kKV.toString(), this.deB, 1);
      if (localPair.second != null)
      {
        ((WxaPkgWrappingInfo)localPair.second).name = this.chK;
        f((WxaPkgWrappingInfo)localPair.second);
        ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s prepare ok", new Object[] { aMu() });
        bgK();
        AppMethodBeat.o(47263);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      if (!g.afw())
      {
        f(null);
        AppMethodBeat.o(47263);
        return;
      }
      AppMethodBeat.o(47263);
      throw localNullPointerException;
      if (bt.isNullOrNil(this.chK)) {
        localObject1 = j.aOK().aJ(this.appId, this.deB);
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = new al(this.deB)
        {
          final String bgJ()
          {
            AppMethodBeat.i(47257);
            String str = aq.this.aMu();
            AppMethodBeat.o(47257);
            return str;
          }
          
          protected final void c(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
          {
            AppMethodBeat.i(47259);
            super.c(paramAnonymousWxaPkgLoadProgress);
            aq.this.d(paramAnonymousWxaPkgLoadProgress);
            AppMethodBeat.o(47259);
          }
          
          final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(47258);
            aq.this.f(paramAnonymousWxaPkgWrappingInfo);
            aq.this.g(paramAnonymousWxaPkgWrappingInfo);
            AppMethodBeat.o(47258);
          }
        };
        ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", new Object[] { aMu(), localObject1 });
        if (!bt.isNullOrNil((String)localObject1)) {
          break label653;
        }
        f(null);
        AppMethodBeat.o(47263);
        return;
        localObject1 = j.aOK().a(this.kKV.toString(), this.deB, new String[] { "versionMd5", "downloadURL" });
        if (localObject1 == null)
        {
          ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", new Object[] { aMu() });
          localObject1 = null;
        }
        else
        {
          if ((!DebuggerShell.aTY()) || (TextUtils.isEmpty(((bb)localObject1).field_downloadURL))) {
            break;
          }
          ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "getDownloadURL, with appId[%s], module[%s] hit monkey pushed url[%s]", new Object[] { this.appId, this.chK, ((bb)localObject1).field_downloadURL });
          localObject1 = ((bb)localObject1).field_downloadURL;
        }
      }
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, record md5:%s", new Object[] { aMu(), ((bb)localObject1).field_versionMd5 });
      Object localObject1 = y.a(new i(this.appId, this.chK, ((bb)localObject1).field_versionMd5, this.deB, this.dkC));
      if ((localObject1 == null) || (((c.a)localObject1).errType != 0) || (((c.a)localObject1).errCode != 0))
      {
        localObject2 = aMu();
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
        for (int j = -1;; j = ((c.a)localObject1).errCode)
        {
          bc.Kj(bc.getMMString(2131755577, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          localObject1 = null;
          break;
          i = ((c.a)localObject1).errType;
          break label386;
          j = ((c.a)localObject1).errCode;
          break label392;
          i = ((c.a)localObject1).errType;
          break label428;
        }
      }
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", new Object[] { Integer.valueOf(((bbf)((c.a)localObject1).gUK).error_code), ((bbf)((c.a)localObject1).gUK).error_msg, ((bbf)((c.a)localObject1).gUK).fnK });
      if (bt.isNullOrNil(((bbf)((c.a)localObject1).gUK).fnK))
      {
        if (((bbf)((c.a)localObject1).gUK).error_code != -1001) {
          break label615;
        }
        AppBrand404PageUI.show(2131755606);
        h.R(this.appId, 4, this.deB + 1);
      }
      for (;;)
      {
        localObject1 = ((bbf)((c.a)localObject1).gUK).fnK;
        break;
        label615:
        bc.Kj(e.getMMString(2131755580, new Object[] { Integer.valueOf(5), Integer.valueOf(((bbf)((c.a)localObject1).gUK).error_code) }));
      }
      label653:
      if (!bh.a(this.kKV.toString(), this.deB, (String)localObject1, (bh.a)localObject2, new a.a()
      {
        public final String aPJ()
        {
          AppMethodBeat.i(47260);
          Object localObject = j.aOK().a(aq.this.kKV.toString(), aq.this.deB, new String[] { "versionMd5" });
          localObject = "_" + ((bb)localObject).field_versionMd5;
          AppMethodBeat.o(47260);
          return localObject;
        }
      }))
      {
        ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", new Object[] { aMu() });
        f(null);
        AppMethodBeat.o(47263);
        return;
      }
      bgM();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aq
 * JD-Core Version:    0.7.0.1
 */