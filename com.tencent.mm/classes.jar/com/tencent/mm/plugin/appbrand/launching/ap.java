package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.cn.f;
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
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Locale;

public final class ap
  extends am
{
  public final String appId;
  public final String ceF;
  public final int dbX;
  public int dib;
  public final boolean jqm;
  public final int lkg;
  public final boolean lmC;
  private bb lmD;
  private final int[] lmE;
  private com.tencent.luggage.sdk.e.b lme;
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
    AppMethodBeat.i(186838);
    this.dbX = 0;
    this.dib = 4;
    this.lme = null;
    this.lmE = new int[] { 6, 12 };
    this.appId = paramString1;
    this.ceF = paramString2;
    this.lkg = paramInt;
    this.lmC = true;
    this.jqm = false;
    this.scene = 0;
    this.lme = paramb;
    AppMethodBeat.o(186838);
  }
  
  public ap(String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    super(new ab(paramString1, paramString2, paramInt2));
    AppMethodBeat.i(47251);
    this.dbX = 0;
    this.dib = 4;
    this.lme = null;
    this.lmE = new int[] { 6, 12 };
    this.appId = paramString1;
    this.ceF = paramString2;
    this.lkg = paramInt1;
    this.lmC = paramBoolean1;
    this.jqm = paramBoolean2;
    this.scene = paramInt3;
    if (paramInt2 != 0) {
      this.dib = paramInt2;
    }
    AppMethodBeat.o(47251);
  }
  
  private WxaPkgWrappingInfo Os(String paramString)
  {
    AppMethodBeat.i(47253);
    if ((!bs.isNullOrNil(this.ceF)) && (this.ceF.endsWith("__PLUGINCODE__"))) {}
    for (paramString = WxaPkgWrappingInfo.Iv(paramString); paramString == null; paramString = WxaPkgWrappingInfo.Iu(paramString))
    {
      AppMethodBeat.o(47253);
      return null;
    }
    paramString.pkgVersion = this.lkg;
    AppMethodBeat.o(47253);
    return paramString;
  }
  
  public final String aTk()
  {
    AppMethodBeat.i(47252);
    String str = String.format(Locale.US, "pkg %s, targetVersion %d, codeType %d", new Object[] { this.lmr.toString(), Integer.valueOf(this.lkg), Integer.valueOf(0) });
    AppMethodBeat.o(47252);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(47254);
    Object localObject1 = j.aVC();
    if (localObject1 == null)
    {
      ac.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL storage with %s", new Object[] { aTk() });
      f(null);
      AppMethodBeat.o(47254);
      return;
    }
    this.lmD = ((bf)localObject1).a(this.lmr.toString(), this.lkg, 0, new String[0]);
    if (this.lmD == null)
    {
      ac.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL record with %s", new Object[] { aTk() });
      f(null);
      localObject1 = ai.getContext().getString(2131755583, new Object[] { "" });
      if ((!this.lmC) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        AppMethodBeat.o(47254);
        return;
      }
      ac.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "showTip key[%s] tip[%s]", new Object[] { this.lmr.toString(), localObject1 });
      com.tencent.e.h.JZN.aQ(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174996);
          Toast.makeText(ai.getContext(), this.lmK, 0).show();
          AppMethodBeat.o(174996);
        }
      });
      AppMethodBeat.o(47254);
      return;
    }
    if (bs.isNullOrNil(this.lmD.field_versionMd5))
    {
      ac.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get EMPTY md5 with %s", new Object[] { aTk() });
      f(null);
      AppMethodBeat.o(47254);
      return;
    }
    if (this.lmD.field_versionMd5.equals(WxaPkgIntegrityChecker.Ij(this.lmD.field_pkgPath)))
    {
      ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", new Object[] { aTk() });
      f(Os(this.lmD.field_pkgPath));
      bnE();
      if (this.lmn != null) {
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).a(this.lmn.lht, this.appId, this.lkg, this.dib, this.ceF);
      }
      AppMethodBeat.o(47254);
      return;
    }
    com.tencent.mm.vfs.i.deleteFile(this.lmD.field_pkgPath);
    localObject1 = m.a(this.lmr, 0, this.lkg, new String[] { this.lmD.field_versionMd5 });
    String str1;
    String str2;
    int i;
    if (localObject1 != null)
    {
      ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "find reusable record, target (%s), reusable (%s %d)", new Object[] { aTk(), ((bb)localObject1).field_appId, Integer.valueOf(((bb)localObject1).field_version) });
      str1 = ay.aJ(this.lmr.toString(), this.lkg);
      com.tencent.mm.vfs.i.lZ(((bb)localObject1).field_pkgPath, str1);
      j.aVC().e(this.lmr.toString(), 0, this.lkg, str1);
      f(Os(str1));
      bnE();
      if (this.lmn != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class);
        str1 = this.lmn.lht;
        str2 = this.appId;
        i = this.lkg;
        getClass();
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)localObject1).a(str1, str2, i, 0, this.ceF);
      }
      AppMethodBeat.o(47254);
      return;
    }
    ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", new Object[] { aTk() });
    final bhh localbhh = new bhh();
    localbhh.djj = this.appId;
    localbhh.Eeo = this.lkg;
    localbhh.EUq = 0;
    label703:
    label874:
    final d local1;
    label789:
    Object localObject2;
    label931:
    boolean bool;
    if (!bs.isNullOrNil(this.ceF))
    {
      localbhh.EUq = this.dib;
      if (!com.tencent.mm.compatible.loader.a.contains(this.lmE, this.dib)) {
        localbhh.EUn = this.ceF;
      }
      localbhh.lmu = this.lmD.field_versionMd5;
      if ((u.aWv()) && (j.a.rq(0)))
      {
        localObject1 = this.lmr.toString();
        if (!bs.isNullOrNil((String)localObject1))
        {
          if (!((String)localObject1).endsWith("__PLUGINCODE__")) {
            break label1078;
          }
          localObject1 = m.bI((String)localObject1, this.lkg);
          if (localObject1 != null) {
            localbhh.EWh = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          }
        }
      }
      if (this.jqm) {
        localbhh.scene = this.scene;
      }
      localObject1 = localbhh.djj;
      int j = localbhh.scene;
      int k = localbhh.EUq;
      str1 = localbhh.EUn;
      int m = localbhh.Eeo;
      int n = localbhh.EWh;
      str2 = localbhh.lmu;
      if (!u.aWv()) {
        break label1089;
      }
      i = 1;
      ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "appid:%s,scene:%d,cgirequest pkgtype:%s,modulename:%s,version:%s,old_app_version:%s,record md5:%s,openIncremental:%s", new Object[] { localObject1, Integer.valueOf(j), Integer.valueOf(k), str1, Integer.valueOf(m), Integer.valueOf(n), str2, Integer.valueOf(i) });
      if (!this.jqm) {
        break label1094;
      }
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.b.a(localbhh);
      local1 = new d()
      {
        public final void bmY()
        {
          AppMethodBeat.i(174988);
          ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "onFallback: fallback to normal cgi with %s", new Object[] { ap.this.aTk() });
          ap localap = ap.this;
          bhh localbhh = localbhh;
          this.lmG.aBB().h(new ap.3(localap, localbhh));
          AppMethodBeat.o(174988);
        }
      };
      localObject2 = be.a(localbhh, this.lme);
      if (localObject2 == null) {
        break label1213;
      }
      str2 = "";
      str1 = "";
      localObject1 = "";
      if (!((ccm)localObject2).EOr) {
        break label1108;
      }
      str2 = ((ccm)localObject2).url;
      ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "tryDownloadPkyByParallelCgiOpt: %s : patchUrl = [%s], zstdUrl = [%s], fullUrl = [%s]", new Object[] { aTk(), str2, str1, localObject1 });
      localObject2 = new a(((ccm)localObject2).md5, local1)
      {
        public final void aXt()
        {
          AppMethodBeat.i(47247);
          AppMethodBeat.o(47247);
        }
        
        public final void aXu()
        {
          AppMethodBeat.i(47248);
          AppMethodBeat.o(47248);
        }
        
        protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
        {
          AppMethodBeat.i(47245);
          ap.this.c(paramAnonymousWxaPkgLoadProgress);
          AppMethodBeat.o(47245);
        }
        
        final String bnD()
        {
          AppMethodBeat.i(47243);
          String str = ap.this.aTk();
          AppMethodBeat.o(47243);
          return str;
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47244);
          if ((paramAnonymousWxaPkgWrappingInfo == null) || (!paramAnonymousWxaPkgWrappingInfo.md5.equals(this.lmI)))
          {
            ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: will call fallback info ==null? [%b] with %s", new Object[] { paramAnonymousWxaPkgWrappingInfo, ap.this.aTk() });
            local1.bmY();
            com.tencent.mm.plugin.appbrand.launching.d.b.lA(18);
            AppMethodBeat.o(47244);
            return;
          }
          ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: downloadPkgForParallelCgi success with %s", new Object[] { ap.this.aTk() });
          ap.this.f(paramAnonymousWxaPkgWrappingInfo);
          ap.this.g(paramAnonymousWxaPkgWrappingInfo);
          AppMethodBeat.o(47244);
        }
      };
      if ((localbhh.EWh <= 0) || (bs.isNullOrNil(str2))) {
        break label1136;
      }
      bool = s.a(this.lmr.toString(), localbhh.EWh, this.lkg, str2, (bh.a)localObject2);
      bnF();
    }
    for (;;)
    {
      if (!bool) {
        break label1200;
      }
      ac.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "getDownloadURL: %s : start download success from preFetch", new Object[] { aTk() });
      AppMethodBeat.o(47254);
      return;
      if (12 != this.dib) {
        break;
      }
      localbhh.EUq = this.dib;
      break;
      label1078:
      localObject1 = m.bH((String)localObject1, 1);
      break label703;
      label1089:
      i = 0;
      break label789;
      label1094:
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.h(localbhh);
      break label874;
      label1108:
      if (((ccm)localObject2).EOs)
      {
        str1 = ((ccm)localObject2).url;
        break label931;
      }
      localObject1 = ((ccm)localObject2).url;
      break label931;
      label1136:
      if (!bs.isNullOrNil(str1))
      {
        bool = bp.a(str1, this.lmr.toString(), this.lkg, 0, (bh.a)localObject2);
        bnG();
      }
      else
      {
        bool = bh.b(this.lmr.toString(), 0, this.lkg, (String)localObject1, (bh.a)localObject2);
        bnG();
      }
    }
    label1200:
    local1.bmY();
    AppMethodBeat.o(47254);
    return;
    label1213:
    local1.bmY();
    AppMethodBeat.o(47254);
  }
  
  abstract class a
    extends al
    implements b.b, b.c
  {
    private a()
    {
      super(ap.this.lmC);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ap
 * JD-Core Version:    0.7.0.1
 */