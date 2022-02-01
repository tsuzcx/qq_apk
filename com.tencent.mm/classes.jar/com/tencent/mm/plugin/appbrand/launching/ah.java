package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.c;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.fcs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;

public final class ah
  extends ag
  implements aa
{
  public final String appId;
  public final String cBp;
  public final int dFL;
  public int dMe;
  public final boolean kPG;
  public final int mVo;
  public final boolean mVp;
  private com.tencent.luggage.sdk.e.b mVq;
  private bd mVr;
  private final int[] mVs;
  public final int scene;
  
  public ah(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, null);
  }
  
  private ah(String paramString1, String paramString2, int paramInt, com.tencent.luggage.sdk.e.b paramb)
  {
    super(new ad(paramString1, paramString2));
    AppMethodBeat.i(227088);
    this.dFL = 0;
    this.dMe = 4;
    this.mVq = null;
    this.mVs = new int[] { 6, 12 };
    this.appId = paramString1;
    this.cBp = paramString2;
    this.mVo = paramInt;
    this.mVp = true;
    this.kPG = false;
    this.scene = 0;
    this.mVq = null;
    this.mUW = this.mVp;
    AppMethodBeat.o(227088);
  }
  
  private WxaPkgWrappingInfo acc(String paramString)
  {
    AppMethodBeat.i(47253);
    if ((!Util.isNullOrNil(this.cBp)) && (this.cBp.endsWith("__PLUGINCODE__"))) {}
    for (paramString = WxaPkgWrappingInfo.Vy(paramString); paramString == null; paramString = WxaPkgWrappingInfo.Vx(paramString))
    {
      AppMethodBeat.o(47253);
      return null;
    }
    paramString.pkgVersion = this.mVo;
    AppMethodBeat.o(47253);
    return paramString;
  }
  
  public final String brS()
  {
    AppMethodBeat.i(47252);
    String str = String.format(Locale.US, "pkg %s, targetVersion %d, codeType %d", new Object[] { this.mVm.toString(), Integer.valueOf(this.mVo), Integer.valueOf(0) });
    AppMethodBeat.o(47252);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(47254);
    Object localObject1 = n.buL();
    if (localObject1 == null)
    {
      Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL storage with %s", new Object[] { brS() });
      e(null);
      AppMethodBeat.o(47254);
      return;
    }
    this.mVr = ((bh)localObject1).a(this.mVm.toString(), this.mVo, 0, new String[0]);
    if (this.mVr == null)
    {
      Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL record with %s", new Object[] { brS() });
      e(null);
      localObject1 = MMApplicationContext.getContext().getString(2131755626, new Object[] { "" });
      if ((!this.mVp) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        AppMethodBeat.o(47254);
        return;
      }
      Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "showTip key[%s] tip[%s]", new Object[] { this.mVm.toString(), localObject1 });
      com.tencent.f.h.RTc.aV(new ah.5(this, (String)localObject1));
      AppMethodBeat.o(47254);
      return;
    }
    if (Util.isNullOrNil(this.mVr.field_versionMd5))
    {
      Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get EMPTY md5 with %s", new Object[] { brS() });
      e(null);
      AppMethodBeat.o(47254);
      return;
    }
    if (this.mVr.field_versionMd5.equals(WxaPkgIntegrityChecker.Vn(this.mVr.field_pkgPath)))
    {
      Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", new Object[] { brS() });
      e(acc(this.mVr.field_pkgPath));
      bNE();
      if (this.mVi != null) {
        ((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a)n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class)).a(this.mVi.kEY, this.appId, this.mVo, this.dMe, this.cBp);
      }
      AppMethodBeat.o(47254);
      return;
    }
    com.tencent.mm.vfs.s.deleteFile(this.mVr.field_pkgPath);
    localObject1 = m.a(this.mVm, 0, this.mVo, new String[] { this.mVr.field_versionMd5 });
    String str1;
    String str2;
    int i;
    if (localObject1 != null)
    {
      Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "find reusable record, target (%s), reusable (%s %d)", new Object[] { brS(), ((bd)localObject1).field_appId, Integer.valueOf(((bd)localObject1).field_version) });
      str1 = ba.aT(this.mVm.toString(), this.mVo);
      com.tencent.mm.vfs.s.nw(((bd)localObject1).field_pkgPath, str1);
      n.buL().e(this.mVm.toString(), 0, this.mVo, str1);
      e(acc(str1));
      bNE();
      if (this.mVi != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appcache.predownload.d.a)n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class);
        str1 = this.mVi.kEY;
        str2 = this.appId;
        i = this.mVo;
        getClass();
        ((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a)localObject1).a(str1, str2, i, 0, this.cBp);
      }
      AppMethodBeat.o(47254);
      return;
    }
    Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", new Object[] { brS() });
    final byy localbyy = new byy();
    localbyy.dNI = this.appId;
    localbyy.KXD = this.mVo;
    localbyy.MbZ = 0;
    label703:
    label874:
    final d local1;
    label789:
    Object localObject2;
    label939:
    boolean bool;
    if (!Util.isNullOrNil(this.cBp))
    {
      localbyy.MbZ = this.dMe;
      if (!com.tencent.mm.compatible.loader.a.contains(this.mVs, this.dMe)) {
        localbyy.MbW = this.cBp;
      }
      localbyy.Mef = this.mVr.field_versionMd5;
      if ((v.bvE()) && (j.a.vP(0)))
      {
        localObject1 = this.mVm.toString();
        if (!Util.isNullOrNil((String)localObject1))
        {
          if (!((String)localObject1).endsWith("__PLUGINCODE__")) {
            break label1082;
          }
          localObject1 = m.bT((String)localObject1, this.mVo);
          if (localObject1 != null) {
            localbyy.Meg = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          }
        }
      }
      if (this.kPG) {
        localbyy.scene = this.scene;
      }
      localObject1 = localbyy.dNI;
      int j = localbyy.scene;
      int k = localbyy.MbZ;
      str1 = localbyy.MbW;
      int m = localbyy.KXD;
      int n = localbyy.Meg;
      str2 = localbyy.Mef;
      if (!v.bvE()) {
        break label1093;
      }
      i = 1;
      Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "appid:%s,scene:%d,cgirequest pkgtype:%s,modulename:%s,version:%s,old_app_version:%s,record md5:%s,openIncremental:%s", new Object[] { localObject1, Integer.valueOf(j), Integer.valueOf(k), str1, Integer.valueOf(m), Integer.valueOf(n), str2, Integer.valueOf(i) });
      if (!this.kPG) {
        break label1098;
      }
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.predownload.a(localbyy);
      local1 = new d()
      {
        public final void bNe()
        {
          AppMethodBeat.i(174988);
          Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "onFallback: fallback to normal cgi with %s", new Object[] { ah.this.brS() });
          ah localah = ah.this;
          byy localbyy = localbyy;
          this.mVu.aYI().h(new ah.3(localah, localbyy));
          AppMethodBeat.o(174988);
        }
      };
      if (localbyy.Meg != 0) {
        break label1209;
      }
      localObject2 = az.a(localbyy, this.mVq);
      if (localObject2 == null) {
        break label1209;
      }
      str2 = "";
      str1 = "";
      localObject1 = "";
      if (!((cye)localObject2).LVl) {
        break label1112;
      }
      str2 = ((cye)localObject2).url;
      Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "tryDownloadPkyByParallelCgiOpt: %s : patchUrl = [%s], zstdUrl = [%s], fullUrl = [%s]", new Object[] { brS(), str2, str1, localObject1 });
      localObject2 = new a(((cye)localObject2).md5)
      {
        protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
        {
          AppMethodBeat.i(47245);
          ah.this.c(paramAnonymousWxaPkgLoadProgress);
          AppMethodBeat.o(47245);
        }
        
        final String bND()
        {
          AppMethodBeat.i(47243);
          String str = ah.this.brS();
          AppMethodBeat.o(47243);
          return str;
        }
        
        public final void bwD()
        {
          AppMethodBeat.i(47247);
          AppMethodBeat.o(47247);
        }
        
        public final void bwE()
        {
          AppMethodBeat.i(47248);
          AppMethodBeat.o(47248);
        }
        
        final void d(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47244);
          if ((paramAnonymousWxaPkgWrappingInfo == null) || (!paramAnonymousWxaPkgWrappingInfo.md5.equals(this.mVw)))
          {
            Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: will call fallback info ==null? [%b] with %s", new Object[] { paramAnonymousWxaPkgWrappingInfo, ah.this.brS() });
            local1.bNe();
            com.tencent.mm.plugin.appbrand.launching.d.b.pl(18);
            AppMethodBeat.o(47244);
            return;
          }
          Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: downloadPkgForParallelCgi success with %s", new Object[] { ah.this.brS() });
          ah.this.e(paramAnonymousWxaPkgWrappingInfo);
          AppMethodBeat.o(47244);
        }
      };
      if ((localbyy.Meg <= 0) || (Util.isNullOrNil(str2))) {
        break label1140;
      }
      bool = com.tencent.mm.plugin.appbrand.appcache.s.a(this.mVm.toString(), localbyy.Meg, this.mVo, str2, (bj.a)localObject2);
    }
    for (;;)
    {
      if (!bool) {
        break label1196;
      }
      Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "getDownloadURL: %s : start download success from preFetch", new Object[] { brS() });
      AppMethodBeat.o(47254);
      return;
      if (12 != this.dMe) {
        break;
      }
      localbyy.MbZ = this.dMe;
      break;
      label1082:
      localObject1 = m.bS((String)localObject1, 1);
      break label703;
      label1093:
      i = 0;
      break label789;
      label1098:
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.h(localbyy);
      break label874;
      label1112:
      if (((cye)localObject2).LVm)
      {
        str1 = ((cye)localObject2).url;
        break label939;
      }
      localObject1 = ((cye)localObject2).url;
      break label939;
      label1140:
      if (!Util.isNullOrNil(str1)) {
        bool = bt.a(str1, this.mVm.toString(), this.mVo, 0, (bj.a)localObject2);
      } else {
        bool = bj.c(this.mVm.toString(), 0, this.mVo, (String)localObject1, (bj.a)localObject2);
      }
    }
    label1196:
    local1.bNe();
    AppMethodBeat.o(47254);
    return;
    label1209:
    local1.bNe();
    AppMethodBeat.o(47254);
  }
  
  abstract class a
    extends af
    implements b.b, b.c
  {
    private a(int paramInt)
    {
      super(ah.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ah
 * JD-Core Version:    0.7.0.1
 */