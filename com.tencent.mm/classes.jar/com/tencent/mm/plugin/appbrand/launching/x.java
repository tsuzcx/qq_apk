package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.ba.a;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;

final class x
  extends v
{
  final String appId;
  final int cpE;
  int cvs;
  final String gVh;
  private final int[] ilL;
  
  x(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, 0);
  }
  
  x(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(new y(paramString1, paramString2, paramInt2));
    AppMethodBeat.i(131900);
    this.cvs = 4;
    this.ilL = new int[] { 14, 12, 13 };
    this.appId = paramString1;
    this.gVh = paramString2;
    this.cpE = paramInt1;
    if (a.contains(this.ilL, paramInt2)) {
      this.cvs = paramInt2;
    }
    AppMethodBeat.o(131900);
  }
  
  public final String aHc()
  {
    AppMethodBeat.i(131901);
    String str = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[] { this.appId, this.gVh, Integer.valueOf(this.cpE), Integer.valueOf(this.cvs), this.ilG });
    AppMethodBeat.o(131901);
    return str;
  }
  
  public final void prepare()
  {
    int k = -1;
    AppMethodBeat.i(131902);
    Object localObject1 = as.F(this.ilG.toString(), this.cpE, 1);
    if (((Pair)localObject1).second != null)
    {
      ((WxaPkgWrappingInfo)((Pair)localObject1).second).name = this.gVh;
      d((WxaPkgWrappingInfo)((Pair)localObject1).second);
      ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s prepare ok", new Object[] { aHc() });
      aHa();
      AppMethodBeat.o(131902);
      return;
    }
    if (bo.isNullOrNil(this.gVh)) {
      localObject1 = g.auM().au(this.appId, this.cpE);
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = new x.1(this, this.cpE);
      ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", new Object[] { aHc(), localObject1 });
      if (!bo.isNullOrNil((String)localObject1)) {
        break label667;
      }
      d(null);
      AppMethodBeat.o(131902);
      return;
      localObject1 = g.auM().a(this.ilG.toString(), this.cpE, new String[] { "versionMd5", "downloadURL" });
      if (localObject1 == null)
      {
        ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", new Object[] { aHc() });
        localObject1 = null;
      }
      else
      {
        if ((!DebuggerShell.ayQ()) || (TextUtils.isEmpty(((at)localObject1).field_downloadURL))) {
          break;
        }
        ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "getDownloadURL, with appId[%s], module[%s] hit monkey pushed url[%s]", new Object[] { this.appId, this.gVh, ((at)localObject1).field_downloadURL });
        localObject1 = ((at)localObject1).field_downloadURL;
      }
    }
    ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, record md5:%s", new Object[] { aHc(), ((at)localObject1).field_versionMd5 });
    localObject1 = com.tencent.mm.ai.x.a(new com.tencent.mm.plugin.appbrand.appcache.e(this.appId, this.gVh, ((at)localObject1).field_versionMd5, this.cpE, this.cvs));
    if ((localObject1 == null) || (((a.a)localObject1).errType != 0) || (((a.a)localObject1).errCode != 0))
    {
      localObject2 = aHc();
      int i;
      if (localObject1 == null)
      {
        i = -1;
        label384:
        if (localObject1 != null) {
          break label476;
        }
        j = -1;
        label391:
        ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, cgi failed, %d %d", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j) });
        if (localObject1 != null) {
          break label485;
        }
        i = -1;
        label428:
        if (localObject1 != null) {
          break label494;
        }
      }
      label476:
      label485:
      label494:
      for (int j = k;; j = ((a.a)localObject1).errCode)
      {
        ah.Do(ah.getMMString(2131296786, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        localObject1 = null;
        break;
        i = ((a.a)localObject1).errType;
        break label384;
        j = ((a.a)localObject1).errCode;
        break label391;
        i = ((a.a)localObject1).errType;
        break label428;
      }
    }
    ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", new Object[] { Integer.valueOf(((aqq)((a.a)localObject1).fsN).error_code), ((aqq)((a.a)localObject1).fsN).error_msg, ((aqq)((a.a)localObject1).fsN).eds });
    if (bo.isNullOrNil(((aqq)((a.a)localObject1).fsN).eds))
    {
      if (((aqq)((a.a)localObject1).fsN).error_code != -1001) {
        break label628;
      }
      AppBrand404PageUI.show(2131296813);
      com.tencent.mm.plugin.appbrand.report.e.U(this.appId, 4, this.cpE + 1);
    }
    for (;;)
    {
      localObject1 = ((aqq)((a.a)localObject1).fsN).eds;
      break;
      label628:
      ah.Do(com.tencent.mm.plugin.appbrand.t.e.getMMString(2131296789, new Object[] { Integer.valueOf(5), Integer.valueOf(((aqq)((a.a)localObject1).fsN).error_code) }));
    }
    label667:
    if (!ba.a(this.ilG.toString(), this.cpE, (String)localObject1, (ba.a)localObject2, new x.2(this)))
    {
      ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", new Object[] { aHc() });
      d(null);
      AppMethodBeat.o(131902);
      return;
    }
    aHb();
    AppMethodBeat.o(131902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.x
 * JD-Core Version:    0.7.0.1
 */