package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.c;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.plugin.appbrand.appcache.bi.a;
import com.tencent.mm.plugin.appbrand.appcache.br;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;

public final class ap
  extends am
{
  public final String appId;
  public final String coW;
  public final int dnt;
  public int dtF;
  public final boolean jKg;
  public final int lHo;
  public final boolean lJK;
  private bc lJL;
  private final int[] lJM;
  private com.tencent.luggage.sdk.e.b lJm;
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
    super(new ac(paramString1, paramString2));
    AppMethodBeat.i(188618);
    this.dnt = 0;
    this.dtF = 4;
    this.lJm = null;
    this.lJM = new int[] { 6, 12 };
    this.appId = paramString1;
    this.coW = paramString2;
    this.lHo = paramInt;
    this.lJK = true;
    this.jKg = false;
    this.scene = 0;
    this.lJm = paramb;
    AppMethodBeat.o(188618);
  }
  
  public ap(String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    super(new ac(paramString1, paramString2, paramInt2));
    AppMethodBeat.i(47251);
    this.dnt = 0;
    this.dtF = 4;
    this.lJm = null;
    this.lJM = new int[] { 6, 12 };
    this.appId = paramString1;
    this.coW = paramString2;
    this.lHo = paramInt1;
    this.lJK = paramBoolean1;
    this.jKg = paramBoolean2;
    this.scene = paramInt3;
    if (paramInt2 != 0) {
      this.dtF = paramInt2;
    }
    AppMethodBeat.o(47251);
  }
  
  private WxaPkgWrappingInfo RQ(String paramString)
  {
    AppMethodBeat.i(47253);
    if ((!bt.isNullOrNil(this.coW)) && (this.coW.endsWith("__PLUGINCODE__"))) {}
    for (paramString = WxaPkgWrappingInfo.LM(paramString); paramString == null; paramString = WxaPkgWrappingInfo.LL(paramString))
    {
      AppMethodBeat.o(47253);
      return null;
    }
    paramString.pkgVersion = this.lHo;
    AppMethodBeat.o(47253);
    return paramString;
  }
  
  public final String aWs()
  {
    AppMethodBeat.i(47252);
    String str = String.format(Locale.US, "pkg %s, targetVersion %d, codeType %d", new Object[] { this.lJz.toString(), Integer.valueOf(this.lHo), Integer.valueOf(0) });
    AppMethodBeat.o(47252);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(47254);
    Object localObject1 = j.aYX();
    if (localObject1 == null)
    {
      ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL storage with %s", new Object[] { aWs() });
      f(null);
      AppMethodBeat.o(47254);
      return;
    }
    this.lJL = ((bg)localObject1).a(this.lJz.toString(), this.lHo, 0, new String[0]);
    if (this.lJL == null)
    {
      ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL record with %s", new Object[] { aWs() });
      f(null);
      localObject1 = aj.getContext().getString(2131755583, new Object[] { "" });
      if ((!this.lJK) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        AppMethodBeat.o(47254);
        return;
      }
      ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "showTip key[%s] tip[%s]", new Object[] { this.lJz.toString(), localObject1 });
      com.tencent.e.h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174996);
          Toast.makeText(aj.getContext(), this.lJS, 0).show();
          AppMethodBeat.o(174996);
        }
      });
      AppMethodBeat.o(47254);
      return;
    }
    if (bt.isNullOrNil(this.lJL.field_versionMd5))
    {
      ad.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get EMPTY md5 with %s", new Object[] { aWs() });
      f(null);
      AppMethodBeat.o(47254);
      return;
    }
    if (this.lJL.field_versionMd5.equals(WxaPkgIntegrityChecker.LB(this.lJL.field_pkgPath)))
    {
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", new Object[] { aWs() });
      f(RQ(this.lJL.field_pkgPath));
      brr();
      if (this.lJv != null) {
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).a(this.lJv.lEv, this.appId, this.lHo, this.dtF, this.coW);
      }
      AppMethodBeat.o(47254);
      return;
    }
    com.tencent.mm.vfs.i.deleteFile(this.lJL.field_pkgPath);
    localObject1 = m.a(this.lJz, 0, this.lHo, new String[] { this.lJL.field_versionMd5 });
    String str1;
    String str2;
    int i;
    if (localObject1 != null)
    {
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "find reusable record, target (%s), reusable (%s %d)", new Object[] { aWs(), ((bc)localObject1).field_appId, Integer.valueOf(((bc)localObject1).field_version) });
      str1 = az.aL(this.lJz.toString(), this.lHo);
      com.tencent.mm.vfs.i.mz(((bc)localObject1).field_pkgPath, str1);
      j.aYX().e(this.lJz.toString(), 0, this.lHo, str1);
      f(RQ(str1));
      brr();
      if (this.lJv != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class);
        str1 = this.lJv.lEv;
        str2 = this.appId;
        i = this.lHo;
        getClass();
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)localObject1).a(str1, str2, i, 0, this.coW);
      }
      AppMethodBeat.o(47254);
      return;
    }
    ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", new Object[] { aWs() });
    if (this.lJx != null) {
      this.lJx.brl();
    }
    final blp localblp = new blp();
    localblp.duW = this.appId;
    localblp.FKN = this.lHo;
    localblp.GDN = 0;
    label717:
    label888:
    final d local1;
    label803:
    Object localObject2;
    label953:
    boolean bool;
    if (!bt.isNullOrNil(this.coW))
    {
      localblp.GDN = this.dtF;
      if (!com.tencent.mm.compatible.loader.a.contains(this.lJM, this.dtF)) {
        localblp.GDK = this.coW;
      }
      localblp.lJC = this.lJL.field_versionMd5;
      if ((u.aZQ()) && (j.a.rQ(0)))
      {
        localObject1 = this.lJz.toString();
        if (!bt.isNullOrNil((String)localObject1))
        {
          if (!((String)localObject1).endsWith("__PLUGINCODE__")) {
            break label1100;
          }
          localObject1 = m.bL((String)localObject1, this.lHo);
          if (localObject1 != null) {
            localblp.GFE = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          }
        }
      }
      if (this.jKg) {
        localblp.scene = this.scene;
      }
      localObject1 = localblp.duW;
      int j = localblp.scene;
      int k = localblp.GDN;
      str1 = localblp.GDK;
      int m = localblp.FKN;
      int n = localblp.GFE;
      str2 = localblp.lJC;
      if (!u.aZQ()) {
        break label1111;
      }
      i = 1;
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "appid:%s,scene:%d,cgirequest pkgtype:%s,modulename:%s,version:%s,old_app_version:%s,record md5:%s,openIncremental:%s", new Object[] { localObject1, Integer.valueOf(j), Integer.valueOf(k), str1, Integer.valueOf(m), Integer.valueOf(n), str2, Integer.valueOf(i) });
      if (!this.jKg) {
        break label1116;
      }
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.b.a(localblp);
      local1 = new d()
      {
        public final void bqJ()
        {
          AppMethodBeat.i(174988);
          ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "onFallback: fallback to normal cgi with %s", new Object[] { ap.this.aWs() });
          ap localap = ap.this;
          blp localblp = localblp;
          this.lJO.aED().h(new ap.3(localap, localblp));
          AppMethodBeat.o(174988);
        }
      };
      if (localblp.GFE != 0) {
        break label1235;
      }
      localObject2 = bh.a(localblp, this.lJm);
      if (localObject2 == null) {
        break label1235;
      }
      str2 = "";
      str1 = "";
      localObject1 = "";
      if (!((chd)localObject2).Gxv) {
        break label1130;
      }
      str2 = ((chd)localObject2).url;
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "tryDownloadPkyByParallelCgiOpt: %s : patchUrl = [%s], zstdUrl = [%s], fullUrl = [%s]", new Object[] { aWs(), str2, str1, localObject1 });
      localObject2 = new a(((chd)localObject2).md5, local1)
      {
        protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
        {
          AppMethodBeat.i(47245);
          ap.this.c(paramAnonymousWxaPkgLoadProgress);
          AppMethodBeat.o(47245);
        }
        
        public final void baR()
        {
          AppMethodBeat.i(47247);
          AppMethodBeat.o(47247);
        }
        
        public final void baS()
        {
          AppMethodBeat.i(47248);
          AppMethodBeat.o(47248);
        }
        
        final String brq()
        {
          AppMethodBeat.i(47243);
          String str = ap.this.aWs();
          AppMethodBeat.o(47243);
          return str;
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47244);
          if ((paramAnonymousWxaPkgWrappingInfo == null) || (!paramAnonymousWxaPkgWrappingInfo.md5.equals(this.lJQ)))
          {
            ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: will call fallback info ==null? [%b] with %s", new Object[] { paramAnonymousWxaPkgWrappingInfo, ap.this.aWs() });
            local1.bqJ();
            com.tencent.mm.plugin.appbrand.launching.d.b.ma(18);
            AppMethodBeat.o(47244);
            return;
          }
          ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: downloadPkgForParallelCgi success with %s", new Object[] { ap.this.aWs() });
          ap.this.f(paramAnonymousWxaPkgWrappingInfo);
          ap.this.g(paramAnonymousWxaPkgWrappingInfo);
          AppMethodBeat.o(47244);
        }
      };
      if ((localblp.GFE <= 0) || (bt.isNullOrNil(str2))) {
        break label1158;
      }
      bool = s.a(this.lJz.toString(), localblp.GFE, this.lHo, str2, (bi.a)localObject2);
      brs();
    }
    for (;;)
    {
      if (!bool) {
        break label1222;
      }
      ad.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "getDownloadURL: %s : start download success from preFetch", new Object[] { aWs() });
      AppMethodBeat.o(47254);
      return;
      if (12 != this.dtF) {
        break;
      }
      localblp.GDN = this.dtF;
      break;
      label1100:
      localObject1 = m.bK((String)localObject1, 1);
      break label717;
      label1111:
      i = 0;
      break label803;
      label1116:
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.h(localblp);
      break label888;
      label1130:
      if (((chd)localObject2).Gxw)
      {
        str1 = ((chd)localObject2).url;
        break label953;
      }
      localObject1 = ((chd)localObject2).url;
      break label953;
      label1158:
      if (!bt.isNullOrNil(str1))
      {
        bool = br.a(str1, this.lJz.toString(), this.lHo, 0, (bi.a)localObject2);
        brt();
      }
      else
      {
        bool = bi.b(this.lJz.toString(), 0, this.lHo, (String)localObject1, (bi.a)localObject2);
        brt();
      }
    }
    label1222:
    local1.bqJ();
    AppMethodBeat.o(47254);
    return;
    label1235:
    local1.bqJ();
    AppMethodBeat.o(47254);
  }
  
  abstract class a
    extends al
    implements b.b, b.c
  {
    private a()
    {
      super(ap.this.lJK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ap
 * JD-Core Version:    0.7.0.1
 */