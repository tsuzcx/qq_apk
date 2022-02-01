package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;

final class ai
  extends ag
  implements aa
{
  final String appId;
  final String cBp;
  final int dFL;
  int dMe;
  private final int[] mVs;
  
  ai(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, (byte)0);
  }
  
  private ai(String paramString1, String paramString2, int paramInt, byte paramByte)
  {
    super(new ad(paramString1, paramString2, 4));
    AppMethodBeat.i(227089);
    this.dMe = 4;
    this.mVs = new int[] { 6, 12, 13 };
    this.appId = paramString1;
    this.cBp = paramString2;
    this.dFL = paramInt;
    if (a.contains(this.mVs, 4)) {
      this.dMe = 4;
    }
    AppMethodBeat.o(227089);
  }
  
  public final String brS()
  {
    AppMethodBeat.i(47262);
    String str = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[] { this.appId, this.cBp, Integer.valueOf(this.dFL), Integer.valueOf(this.dMe), this.mVm });
    AppMethodBeat.o(47262);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(47263);
    try
    {
      Pair localPair = WxaPkgIntegrityChecker.D(this.mVm.toString(), this.dFL, 1);
      if (localPair.second != null)
      {
        ((WxaPkgWrappingInfo)localPair.second).name = this.cBp;
        e((WxaPkgWrappingInfo)localPair.second);
        Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s prepare ok", new Object[] { brS() });
        bNE();
        AppMethodBeat.o(47263);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      if (!g.aAc())
      {
        e(null);
        AppMethodBeat.o(47263);
        return;
      }
      AppMethodBeat.o(47263);
      throw localNullPointerException;
      if (Util.isNullOrNil(this.cBp)) {
        localObject1 = n.buL().aX(this.appId, this.dFL);
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = new af(this.dFL, this)
        {
          protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
          {
            AppMethodBeat.i(47259);
            super.b(paramAnonymousWxaPkgLoadProgress);
            ai.this.c(paramAnonymousWxaPkgLoadProgress);
            AppMethodBeat.o(47259);
          }
          
          final String bND()
          {
            AppMethodBeat.i(47257);
            String str = ai.this.brS();
            AppMethodBeat.o(47257);
            return str;
          }
          
          final void d(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(47258);
            ai.this.e(paramAnonymousWxaPkgWrappingInfo);
            AppMethodBeat.o(47258);
          }
        };
        Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", new Object[] { brS(), localObject1 });
        if (!Util.isNullOrNil((String)localObject1)) {
          break label656;
        }
        e(null);
        AppMethodBeat.o(47263);
        return;
        localObject1 = n.buL().a(this.mVm.toString(), this.dFL, new String[] { "versionMd5", "downloadURL" });
        if (localObject1 == null)
        {
          Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", new Object[] { brS() });
          localObject1 = null;
        }
        else
        {
          if ((!DebuggerShell.bAx()) || (TextUtils.isEmpty(((bd)localObject1).field_downloadURL))) {
            break;
          }
          Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "getDownloadURL, with appId[%s], module[%s] hit monkey pushed url[%s]", new Object[] { this.appId, this.cBp, ((bd)localObject1).field_downloadURL });
          localObject1 = ((bd)localObject1).field_downloadURL;
        }
      }
      Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, record md5:%s", new Object[] { brS(), ((bd)localObject1).field_versionMd5 });
      Object localObject1 = ab.a(new com.tencent.mm.plugin.appbrand.appcache.i(this.appId, this.cBp, ((bd)localObject1).field_versionMd5, this.dFL, this.dMe));
      if ((localObject1 == null) || (((c.a)localObject1).errType != 0) || (((c.a)localObject1).errCode != 0))
      {
        localObject2 = brS();
        int i;
        if (localObject1 == null)
        {
          i = -1;
          label387:
          if (localObject1 != null) {
            break label475;
          }
          j = -1;
          label393:
          Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, cgi failed, %d %d", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j) });
          if (localObject1 != null) {
            break label483;
          }
          i = -1;
          label429:
          if (localObject1 != null) {
            break label491;
          }
        }
        for (int j = -1;; j = ((c.a)localObject1).errCode)
        {
          ax.a(ax.getMMString(2131755620, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }), this);
          localObject1 = null;
          break;
          i = ((c.a)localObject1).errType;
          break label387;
          j = ((c.a)localObject1).errCode;
          break label393;
          i = ((c.a)localObject1).errType;
          break label429;
        }
      }
      Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", new Object[] { Integer.valueOf(((bwc)((c.a)localObject1).iLC).error_code), ((bwc)((c.a)localObject1).iLC).error_msg, ((bwc)((c.a)localObject1).iLC).gqB });
      if (Util.isNullOrNil(((bwc)((c.a)localObject1).iLC).gqB))
      {
        if (((bwc)((c.a)localObject1).iLC).error_code != -1001) {
          break label617;
        }
        AppBrand404PageUI.show(2131755653);
        com.tencent.mm.plugin.appbrand.report.i.T(this.appId, 4, this.dFL + 1);
      }
      for (;;)
      {
        localObject1 = ((bwc)((c.a)localObject1).iLC).gqB;
        break;
        label617:
        ax.a(f.getMMString(2131755623, new Object[] { Integer.valueOf(5), Integer.valueOf(((bwc)((c.a)localObject1).iLC).error_code) }), this);
      }
      label656:
      if (!bj.a(this.mVm.toString(), this.dFL, (String)localObject1, (bj.a)localObject2, new a.a()
      {
        public final String bvJ()
        {
          AppMethodBeat.i(47260);
          Object localObject = n.buL().a(ai.this.mVm.toString(), ai.this.dFL, new String[] { "versionMd5" });
          localObject = "_" + ((bd)localObject).field_versionMd5;
          AppMethodBeat.o(47260);
          return localObject;
        }
      }))
      {
        Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", new Object[] { brS() });
        e(null);
      }
      AppMethodBeat.o(47263);
      return;
    }
    catch (b localb)
    {
      label82:
      label475:
      label483:
      label491:
      break label82;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai
 * JD-Core Version:    0.7.0.1
 */