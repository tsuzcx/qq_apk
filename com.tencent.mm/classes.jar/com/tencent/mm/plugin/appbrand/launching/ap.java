package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.c;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bh.a;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;

public final class ap
  extends am
{
  public final String appId;
  public final String chK;
  public final int deB;
  public int dkC;
  public final boolean iQc;
  public final int kIK;
  private com.tencent.luggage.sdk.e.b kKI;
  public final boolean kLg;
  private bb kLh;
  private final int[] kLi;
  public final int scene;
  
  public ap(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this(paramString1, paramString2, paramInt1, true, paramInt2, false, 0);
  }
  
  public ap(String paramString1, String paramString2, int paramInt, com.tencent.luggage.sdk.e.b paramb)
  {
    this(paramString1, paramString2, paramInt, paramb, (byte)0);
  }
  
  private ap(String paramString1, String paramString2, int paramInt, com.tencent.luggage.sdk.e.b paramb, byte paramByte)
  {
    super(new ab(paramString1, paramString2));
    AppMethodBeat.i(196014);
    this.deB = 0;
    this.dkC = 4;
    this.kKI = null;
    this.kLi = new int[] { 6, 12 };
    this.appId = paramString1;
    this.chK = paramString2;
    this.kIK = paramInt;
    this.kLg = true;
    this.iQc = false;
    this.scene = 0;
    this.kKI = paramb;
    AppMethodBeat.o(196014);
  }
  
  public ap(String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    super(new ab(paramString1, paramString2, paramInt2));
    AppMethodBeat.i(47251);
    this.deB = 0;
    this.dkC = 4;
    this.kKI = null;
    this.kLi = new int[] { 6, 12 };
    this.appId = paramString1;
    this.chK = paramString2;
    this.kIK = paramInt1;
    this.kLg = paramBoolean1;
    this.iQc = paramBoolean2;
    this.scene = paramInt3;
    if (paramInt2 != 0) {
      this.dkC = paramInt2;
    }
    AppMethodBeat.o(47251);
  }
  
  private WxaPkgWrappingInfo Kl(String paramString)
  {
    AppMethodBeat.i(47253);
    if ((!bt.isNullOrNil(this.chK)) && (this.chK.endsWith("__PLUGINCODE__"))) {}
    for (paramString = WxaPkgWrappingInfo.Es(paramString); paramString == null; paramString = WxaPkgWrappingInfo.Er(paramString))
    {
      AppMethodBeat.o(47253);
      return null;
    }
    paramString.pkgVersion = this.kIK;
    AppMethodBeat.o(47253);
    return paramString;
  }
  
  public final String aMu()
  {
    AppMethodBeat.i(47252);
    String str = String.format(Locale.US, "pkg %s, targetVersion %d, codeType %d", new Object[] { this.kKV.toString(), Integer.valueOf(this.kIK), Integer.valueOf(0) });
    AppMethodBeat.o(47252);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(47254);
    Object localObject1 = j.aOK();
    if (localObject1 == null)
    {
      ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL storage with %s", new Object[] { aMu() });
      f(null);
      AppMethodBeat.o(47254);
      return;
    }
    this.kLh = ((bf)localObject1).a(this.kKV.toString(), this.kIK, 0, new String[0]);
    if (this.kLh == null)
    {
      ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL record with %s", new Object[] { aMu() });
      f(null);
      localObject1 = aj.getContext().getString(2131755583, new Object[] { "" });
      if ((!this.kLg) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        AppMethodBeat.o(47254);
        return;
      }
      ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "showTip key[%s] tip[%s]", new Object[] { this.kKV.toString(), localObject1 });
      com.tencent.e.h.Iye.aN(new ap.5(this, (String)localObject1));
      AppMethodBeat.o(47254);
      return;
    }
    if (bt.isNullOrNil(this.kLh.field_versionMd5))
    {
      ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get EMPTY md5 with %s", new Object[] { aMu() });
      f(null);
      AppMethodBeat.o(47254);
      return;
    }
    if (this.kLh.field_versionMd5.equals(WxaPkgIntegrityChecker.Eg(this.kLh.field_pkgPath)))
    {
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", new Object[] { aMu() });
      f(Kl(this.kLh.field_pkgPath));
      bgK();
      if (this.kKR != null) {
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).a(this.kKR.kGa, this.appId, this.kIK, this.dkC, this.chK);
      }
      AppMethodBeat.o(47254);
      return;
    }
    com.tencent.mm.vfs.i.deleteFile(this.kLh.field_pkgPath);
    localObject1 = m.a(this.kKV, 0, this.kIK, this.kLh.field_versionMd5);
    String str1;
    String str2;
    int i;
    if (localObject1 != null)
    {
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "find reusable record, target (%s), reusable (%s %d)", new Object[] { aMu(), ((bb)localObject1).field_appId, Integer.valueOf(((bb)localObject1).field_version) });
      str1 = ay.aF(this.kKV.toString(), this.kIK);
      com.tencent.mm.vfs.i.lC(((bb)localObject1).field_pkgPath, str1);
      j.aOK().d(this.kKV.toString(), 0, this.kIK, str1);
      f(Kl(str1));
      bgK();
      if (this.kKR != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class);
        str1 = this.kKR.kGa;
        str2 = this.appId;
        i = this.kIK;
        getClass();
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)localObject1).a(str1, str2, i, 0, this.chK);
      }
      AppMethodBeat.o(47254);
      return;
    }
    ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", new Object[] { aMu() });
    final bdp localbdp = new bdp();
    localbdp.dlB = this.appId;
    localbdp.CLL = this.kIK;
    localbdp.DyU = 0;
    label696:
    label867:
    final d local1;
    label782:
    Object localObject2;
    label924:
    boolean bool;
    if (!bt.isNullOrNil(this.chK))
    {
      localbdp.DyU = this.dkC;
      if (!com.tencent.mm.compatible.loader.a.contains(this.kLi, this.dkC)) {
        localbdp.DyR = this.chK;
      }
      localbdp.kKY = this.kLh.field_versionMd5;
      if ((u.aPD()) && (j.a.qD(0)))
      {
        localObject1 = this.kKV.toString();
        if (!bt.isNullOrNil((String)localObject1))
        {
          if (!((String)localObject1).endsWith("__PLUGINCODE__")) {
            break label1071;
          }
          localObject1 = m.bE((String)localObject1, this.kIK);
          if (localObject1 != null) {
            localbdp.DAL = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          }
        }
      }
      if (this.iQc) {
        localbdp.scene = this.scene;
      }
      localObject1 = localbdp.dlB;
      int j = localbdp.scene;
      int k = localbdp.DyU;
      str1 = localbdp.DyR;
      int m = localbdp.CLL;
      int n = localbdp.DAL;
      str2 = localbdp.kKY;
      if (!u.aPD()) {
        break label1082;
      }
      i = 1;
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "appid:%s,scene:%d,cgirequest pkgtype:%s,modulename:%s,version:%s,old_app_version:%s,record md5:%s,openIncremental:%s", new Object[] { localObject1, Integer.valueOf(j), Integer.valueOf(k), str1, Integer.valueOf(m), Integer.valueOf(n), str2, Integer.valueOf(i) });
      if (!this.iQc) {
        break label1087;
      }
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.b.a(localbdp);
      local1 = new d()
      {
        public final void bge()
        {
          AppMethodBeat.i(174988);
          ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "onFallback: fallback to normal cgi with %s", new Object[] { ap.this.aMu() });
          ap localap = ap.this;
          bdp localbdp = localbdp;
          this.kLk.auK().h(new ap.3(localap, localbdp));
          AppMethodBeat.o(174988);
        }
      };
      localObject2 = be.a(localbdp, this.kKI);
      if (localObject2 == null) {
        break label1206;
      }
      str2 = "";
      str1 = "";
      localObject1 = "";
      if (!((bxr)localObject2).Dtn) {
        break label1101;
      }
      str2 = ((bxr)localObject2).url;
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "tryDownloadPkyByParallelCgiOpt: %s : patchUrl = [%s], zstdUrl = [%s], fullUrl = [%s]", new Object[] { aMu(), str2, str1, localObject1 });
      localObject2 = new a(((bxr)localObject2).md5, local1)
      {
        public final void aQB()
        {
          AppMethodBeat.i(47247);
          AppMethodBeat.o(47247);
        }
        
        public final void aQC()
        {
          AppMethodBeat.i(47248);
          AppMethodBeat.o(47248);
        }
        
        final String bgJ()
        {
          AppMethodBeat.i(47243);
          String str = ap.this.aMu();
          AppMethodBeat.o(47243);
          return str;
        }
        
        protected final void c(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
        {
          AppMethodBeat.i(47245);
          ap.this.d(paramAnonymousWxaPkgLoadProgress);
          AppMethodBeat.o(47245);
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47244);
          if ((paramAnonymousWxaPkgWrappingInfo == null) || (!paramAnonymousWxaPkgWrappingInfo.md5.equals(this.kLm)))
          {
            ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: will call fallback info ==null? [%b] with %s", new Object[] { paramAnonymousWxaPkgWrappingInfo, ap.this.aMu() });
            local1.bge();
            com.tencent.mm.plugin.appbrand.launching.d.b.lI(18);
            AppMethodBeat.o(47244);
            return;
          }
          ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: downloadPkgForParallelCgi success with %s", new Object[] { ap.this.aMu() });
          ap.this.f(paramAnonymousWxaPkgWrappingInfo);
          ap.this.g(paramAnonymousWxaPkgWrappingInfo);
          AppMethodBeat.o(47244);
        }
      };
      if ((localbdp.DAL <= 0) || (bt.isNullOrNil(str2))) {
        break label1129;
      }
      bool = s.a(this.kKV.toString(), localbdp.DAL, this.kIK, str2, (bh.a)localObject2);
      bgL();
    }
    for (;;)
    {
      if (!bool) {
        break label1193;
      }
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "getDownloadURL: %s : start download success from preFetch", new Object[] { aMu() });
      AppMethodBeat.o(47254);
      return;
      if (12 != this.dkC) {
        break;
      }
      localbdp.DyU = this.dkC;
      break;
      label1071:
      localObject1 = m.bD((String)localObject1, 1);
      break label696;
      label1082:
      i = 0;
      break label782;
      label1087:
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.h(localbdp);
      break label867;
      label1101:
      if (((bxr)localObject2).Dto)
      {
        str1 = ((bxr)localObject2).url;
        break label924;
      }
      localObject1 = ((bxr)localObject2).url;
      break label924;
      label1129:
      if (!bt.isNullOrNil(str1))
      {
        bool = bp.a(str1, this.kKV.toString(), this.kIK, 0, (bh.a)localObject2);
        bgM();
      }
      else
      {
        bool = bh.b(this.kKV.toString(), 0, this.kIK, (String)localObject1, (bh.a)localObject2);
        bgM();
      }
    }
    label1193:
    local1.bge();
    AppMethodBeat.o(47254);
    return;
    label1206:
    local1.bge();
    AppMethodBeat.o(47254);
  }
  
  abstract class a
    extends al
    implements b.b, b.c
  {
    private a()
    {
      super(ap.this.kLg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ap
 * JD-Core Version:    0.7.0.1
 */