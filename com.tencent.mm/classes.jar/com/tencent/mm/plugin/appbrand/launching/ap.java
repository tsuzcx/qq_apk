package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.c;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Locale;

public final class ap
  extends am
{
  public final String appId;
  public final String coY;
  public final int dov;
  public int duK;
  public final boolean jNs;
  public final int lLO;
  private com.tencent.luggage.sdk.e.b lNM;
  public final boolean lOk;
  private bd lOl;
  private final int[] lOm;
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
    super(new ad(paramString1, paramString2));
    AppMethodBeat.i(222777);
    this.dov = 0;
    this.duK = 4;
    this.lNM = null;
    this.lOm = new int[] { 6, 12 };
    this.appId = paramString1;
    this.coY = paramString2;
    this.lLO = paramInt;
    this.lOk = true;
    this.jNs = false;
    this.scene = 0;
    this.lNM = paramb;
    AppMethodBeat.o(222777);
  }
  
  public ap(String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    super(new ad(paramString1, paramString2, paramInt2));
    AppMethodBeat.i(47251);
    this.dov = 0;
    this.duK = 4;
    this.lNM = null;
    this.lOm = new int[] { 6, 12 };
    this.appId = paramString1;
    this.coY = paramString2;
    this.lLO = paramInt1;
    this.lOk = paramBoolean1;
    this.jNs = paramBoolean2;
    this.scene = paramInt3;
    if (paramInt2 != 0) {
      this.duK = paramInt2;
    }
    AppMethodBeat.o(47251);
  }
  
  private WxaPkgWrappingInfo Sz(String paramString)
  {
    AppMethodBeat.i(47253);
    if ((!bu.isNullOrNil(this.coY)) && (this.coY.endsWith("__PLUGINCODE__"))) {}
    for (paramString = WxaPkgWrappingInfo.Mp(paramString); paramString == null; paramString = WxaPkgWrappingInfo.Mo(paramString))
    {
      AppMethodBeat.o(47253);
      return null;
    }
    paramString.pkgVersion = this.lLO;
    AppMethodBeat.o(47253);
    return paramString;
  }
  
  public final String aWU()
  {
    AppMethodBeat.i(47252);
    String str = String.format(Locale.US, "pkg %s, targetVersion %d, codeType %d", new Object[] { this.lNZ.toString(), Integer.valueOf(this.lLO), Integer.valueOf(0) });
    AppMethodBeat.o(47252);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(47254);
    Object localObject1 = j.aZu();
    if (localObject1 == null)
    {
      ae.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL storage with %s", new Object[] { aWU() });
      f(null);
      AppMethodBeat.o(47254);
      return;
    }
    this.lOl = ((com.tencent.mm.plugin.appbrand.appcache.bh)localObject1).a(this.lNZ.toString(), this.lLO, 0, new String[0]);
    if (this.lOl == null)
    {
      ae.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL record with %s", new Object[] { aWU() });
      f(null);
      localObject1 = ak.getContext().getString(2131755583, new Object[] { "" });
      if ((!this.lOk) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        AppMethodBeat.o(47254);
        return;
      }
      ae.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "showTip key[%s] tip[%s]", new Object[] { this.lNZ.toString(), localObject1 });
      com.tencent.e.h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174996);
          Toast.makeText(ak.getContext(), this.lOs, 0).show();
          AppMethodBeat.o(174996);
        }
      });
      AppMethodBeat.o(47254);
      return;
    }
    if (bu.isNullOrNil(this.lOl.field_versionMd5))
    {
      ae.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get EMPTY md5 with %s", new Object[] { aWU() });
      f(null);
      AppMethodBeat.o(47254);
      return;
    }
    if (this.lOl.field_versionMd5.equals(WxaPkgIntegrityChecker.Me(this.lOl.field_pkgPath)))
    {
      ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", new Object[] { aWU() });
      f(Sz(this.lOl.field_pkgPath));
      bsc();
      if (this.lNV != null) {
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).a(this.lNV.lIU, this.appId, this.lLO, this.duK, this.coY);
      }
      AppMethodBeat.o(47254);
      return;
    }
    o.deleteFile(this.lOl.field_pkgPath);
    localObject1 = m.a(this.lNZ, 0, this.lLO, new String[] { this.lOl.field_versionMd5 });
    String str1;
    String str2;
    int i;
    if (localObject1 != null)
    {
      ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "find reusable record, target (%s), reusable (%s %d)", new Object[] { aWU(), ((bd)localObject1).field_appId, Integer.valueOf(((bd)localObject1).field_version) });
      str1 = ba.aO(this.lNZ.toString(), this.lLO);
      o.mF(((bd)localObject1).field_pkgPath, str1);
      j.aZu().e(this.lNZ.toString(), 0, this.lLO, str1);
      f(Sz(str1));
      bsc();
      if (this.lNV != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class);
        str1 = this.lNV.lIU;
        str2 = this.appId;
        i = this.lLO;
        getClass();
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)localObject1).a(str1, str2, i, 0, this.coY);
      }
      AppMethodBeat.o(47254);
      return;
    }
    ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", new Object[] { aWU() });
    if (this.lNX != null) {
      this.lNX.brW();
    }
    final bmh localbmh = new bmh();
    localbmh.dwb = this.appId;
    localbmh.Gdm = this.lLO;
    localbmh.GXq = 0;
    label717:
    label888:
    final d local1;
    label803:
    Object localObject2;
    label953:
    boolean bool;
    if (!bu.isNullOrNil(this.coY))
    {
      localbmh.GXq = this.duK;
      if (!com.tencent.mm.compatible.loader.a.contains(this.lOm, this.duK)) {
        localbmh.GXn = this.coY;
      }
      localbmh.lOc = this.lOl.field_versionMd5;
      if ((v.bap()) && (j.a.rT(0)))
      {
        localObject1 = this.lNZ.toString();
        if (!bu.isNullOrNil((String)localObject1))
        {
          if (!((String)localObject1).endsWith("__PLUGINCODE__")) {
            break label1100;
          }
          localObject1 = m.bO((String)localObject1, this.lLO);
          if (localObject1 != null) {
            localbmh.GZg = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          }
        }
      }
      if (this.jNs) {
        localbmh.scene = this.scene;
      }
      localObject1 = localbmh.dwb;
      int j = localbmh.scene;
      int k = localbmh.GXq;
      str1 = localbmh.GXn;
      int m = localbmh.Gdm;
      int n = localbmh.GZg;
      str2 = localbmh.lOc;
      if (!v.bap()) {
        break label1111;
      }
      i = 1;
      ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "appid:%s,scene:%d,cgirequest pkgtype:%s,modulename:%s,version:%s,old_app_version:%s,record md5:%s,openIncremental:%s", new Object[] { localObject1, Integer.valueOf(j), Integer.valueOf(k), str1, Integer.valueOf(m), Integer.valueOf(n), str2, Integer.valueOf(i) });
      if (!this.jNs) {
        break label1116;
      }
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.b.a(localbmh);
      local1 = new d()
      {
        public final void brt()
        {
          AppMethodBeat.i(174988);
          ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "onFallback: fallback to normal cgi with %s", new Object[] { ap.this.aWU() });
          ap localap = ap.this;
          bmh localbmh = localbmh;
          this.lOo.aET().h(new ap.3(localap, localbmh));
          AppMethodBeat.o(174988);
        }
      };
      if (localbmh.GZg != 0) {
        break label1235;
      }
      localObject2 = bh.a(localbmh, this.lNM);
      if (localObject2 == null) {
        break label1235;
      }
      str2 = "";
      str1 = "";
      localObject1 = "";
      if (!((chx)localObject2).GQV) {
        break label1130;
      }
      str2 = ((chx)localObject2).url;
      ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "tryDownloadPkyByParallelCgiOpt: %s : patchUrl = [%s], zstdUrl = [%s], fullUrl = [%s]", new Object[] { aWU(), str2, str1, localObject1 });
      localObject2 = new a(((chx)localObject2).md5, local1)
      {
        protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
        {
          AppMethodBeat.i(47245);
          ap.this.c(paramAnonymousWxaPkgLoadProgress);
          AppMethodBeat.o(47245);
        }
        
        public final void bbq()
        {
          AppMethodBeat.i(47247);
          AppMethodBeat.o(47247);
        }
        
        public final void bbr()
        {
          AppMethodBeat.i(47248);
          AppMethodBeat.o(47248);
        }
        
        final String bsb()
        {
          AppMethodBeat.i(47243);
          String str = ap.this.aWU();
          AppMethodBeat.o(47243);
          return str;
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47244);
          if ((paramAnonymousWxaPkgWrappingInfo == null) || (!paramAnonymousWxaPkgWrappingInfo.md5.equals(this.lOq)))
          {
            ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: will call fallback info ==null? [%b] with %s", new Object[] { paramAnonymousWxaPkgWrappingInfo, ap.this.aWU() });
            local1.brt();
            com.tencent.mm.plugin.appbrand.launching.d.b.md(18);
            AppMethodBeat.o(47244);
            return;
          }
          ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: downloadPkgForParallelCgi success with %s", new Object[] { ap.this.aWU() });
          ap.this.f(paramAnonymousWxaPkgWrappingInfo);
          ap.this.g(paramAnonymousWxaPkgWrappingInfo);
          AppMethodBeat.o(47244);
        }
      };
      if ((localbmh.GZg <= 0) || (bu.isNullOrNil(str2))) {
        break label1158;
      }
      bool = s.a(this.lNZ.toString(), localbmh.GZg, this.lLO, str2, (bj.a)localObject2);
      bsd();
    }
    for (;;)
    {
      if (!bool) {
        break label1222;
      }
      ae.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "getDownloadURL: %s : start download success from preFetch", new Object[] { aWU() });
      AppMethodBeat.o(47254);
      return;
      if (12 != this.duK) {
        break;
      }
      localbmh.GXq = this.duK;
      break;
      label1100:
      localObject1 = m.bN((String)localObject1, 1);
      break label717;
      label1111:
      i = 0;
      break label803;
      label1116:
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.h(localbmh);
      break label888;
      label1130:
      if (((chx)localObject2).GQW)
      {
        str1 = ((chx)localObject2).url;
        break label953;
      }
      localObject1 = ((chx)localObject2).url;
      break label953;
      label1158:
      if (!bu.isNullOrNil(str1))
      {
        bool = bt.a(str1, this.lNZ.toString(), this.lLO, 0, (bj.a)localObject2);
        bse();
      }
      else
      {
        bool = bj.b(this.lNZ.toString(), 0, this.lLO, (String)localObject1, (bj.a)localObject2);
        bse();
      }
    }
    label1222:
    local1.brt();
    AppMethodBeat.o(47254);
    return;
    label1235:
    local1.brt();
    AppMethodBeat.o(47254);
  }
  
  abstract class a
    extends al
    implements b.b, b.c
  {
    private a()
    {
      super(ap.this.lOk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ap
 * JD-Core Version:    0.7.0.1
 */