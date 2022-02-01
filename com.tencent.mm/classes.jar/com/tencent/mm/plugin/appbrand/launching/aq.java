package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.compatible.loader.a;
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
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Locale;

final class aq
  extends am
{
  final String appId;
  final String ceF;
  final int dbX;
  int dib;
  private final int[] lmE;
  
  aq(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, 4);
  }
  
  aq(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(new ab(paramString1, paramString2, paramInt2));
    AppMethodBeat.i(47261);
    this.dib = 4;
    this.lmE = new int[] { 6, 12, 13 };
    this.appId = paramString1;
    this.ceF = paramString2;
    this.dbX = paramInt1;
    if (a.contains(this.lmE, paramInt2)) {
      this.dib = paramInt2;
    }
    AppMethodBeat.o(47261);
  }
  
  public final String aTk()
  {
    AppMethodBeat.i(47262);
    String str = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[] { this.appId, this.ceF, Integer.valueOf(this.dbX), Integer.valueOf(this.dib), this.lmr });
    AppMethodBeat.o(47262);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(47263);
    try
    {
      Pair localPair = WxaPkgIntegrityChecker.B(this.lmr.toString(), this.dbX, 1);
      if (localPair.second != null)
      {
        ((WxaPkgWrappingInfo)localPair.second).name = this.ceF;
        f((WxaPkgWrappingInfo)localPair.second);
        ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s prepare ok", new Object[] { aTk() });
        bnE();
        AppMethodBeat.o(47263);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      if (!com.tencent.mm.kernel.g.agM())
      {
        f(null);
        AppMethodBeat.o(47263);
        return;
      }
      AppMethodBeat.o(47263);
      throw localNullPointerException;
      if (bs.isNullOrNil(this.ceF)) {
        localObject1 = j.aVC().aN(this.appId, this.dbX);
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = new al(this.dbX)
        {
          protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
          {
            AppMethodBeat.i(47259);
            super.b(paramAnonymousWxaPkgLoadProgress);
            aq.this.c(paramAnonymousWxaPkgLoadProgress);
            AppMethodBeat.o(47259);
          }
          
          final String bnD()
          {
            AppMethodBeat.i(47257);
            String str = aq.this.aTk();
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
        ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", new Object[] { aTk(), localObject1 });
        if (!bs.isNullOrNil((String)localObject1)) {
          break label653;
        }
        f(null);
        AppMethodBeat.o(47263);
        return;
        localObject1 = j.aVC().a(this.lmr.toString(), this.dbX, new String[] { "versionMd5", "downloadURL" });
        if (localObject1 == null)
        {
          ac.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", new Object[] { aTk() });
          localObject1 = null;
        }
        else
        {
          if ((!DebuggerShell.baW()) || (TextUtils.isEmpty(((bb)localObject1).field_downloadURL))) {
            break;
          }
          ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "getDownloadURL, with appId[%s], module[%s] hit monkey pushed url[%s]", new Object[] { this.appId, this.ceF, ((bb)localObject1).field_downloadURL });
          localObject1 = ((bb)localObject1).field_downloadURL;
        }
      }
      ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, record md5:%s", new Object[] { aTk(), ((bb)localObject1).field_versionMd5 });
      Object localObject1 = y.a(new i(this.appId, this.ceF, ((bb)localObject1).field_versionMd5, this.dbX, this.dib));
      if ((localObject1 == null) || (((c.a)localObject1).errType != 0) || (((c.a)localObject1).errCode != 0))
      {
        localObject2 = aTk();
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
          ac.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, cgi failed, %d %d", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j) });
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
          bc.Oq(bc.getMMString(2131755577, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
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
      ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", new Object[] { Integer.valueOf(((bex)((c.a)localObject1).hvj).error_code), ((bex)((c.a)localObject1).hvj).error_msg, ((bex)((c.a)localObject1).hvj).fre });
      if (bs.isNullOrNil(((bex)((c.a)localObject1).hvj).fre))
      {
        if (((bex)((c.a)localObject1).hvj).error_code != -1001) {
          break label615;
        }
        AppBrand404PageUI.show(2131755606);
        com.tencent.mm.plugin.appbrand.report.g.Q(this.appId, 4, this.dbX + 1);
      }
      for (;;)
      {
        localObject1 = ((bex)((c.a)localObject1).hvj).fre;
        break;
        label615:
        bc.Oq(e.getMMString(2131755580, new Object[] { Integer.valueOf(5), Integer.valueOf(((bex)((c.a)localObject1).hvj).error_code) }));
      }
      label653:
      if (!bh.a(this.lmr.toString(), this.dbX, (String)localObject1, (bh.a)localObject2, new a.a()
      {
        public final String aWB()
        {
          AppMethodBeat.i(47260);
          Object localObject = j.aVC().a(aq.this.lmr.toString(), aq.this.dbX, new String[] { "versionMd5" });
          localObject = "_" + ((bb)localObject).field_versionMd5;
          AppMethodBeat.o(47260);
          return localObject;
        }
      }))
      {
        ac.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", new Object[] { aTk() });
        f(null);
        AppMethodBeat.o(47263);
        return;
      }
      bnG();
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