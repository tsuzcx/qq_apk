package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;

public final class w
  extends v
{
  public final String appId;
  public final int cpE;
  public int cvs;
  public final String gVh;
  public final int ilI;
  public final boolean ilJ;
  private at ilK;
  private final int[] ilL;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, true);
  }
  
  public w(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this(paramString1, paramString2, paramInt1, paramInt2, (byte)0);
  }
  
  private w(String paramString1, String paramString2, int paramInt1, int paramInt2, byte paramByte)
  {
    super(new y(paramString1, paramString2, paramInt2));
    AppMethodBeat.i(131892);
    this.cpE = 0;
    this.cvs = 4;
    this.ilL = new int[] { 14, 12 };
    this.appId = paramString1;
    this.gVh = paramString2;
    this.ilI = paramInt1;
    this.ilJ = true;
    if (paramInt2 != 0) {
      this.cvs = paramInt2;
    }
    AppMethodBeat.o(131892);
  }
  
  public w(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    super(new y(paramString1, paramString2));
    AppMethodBeat.i(131891);
    this.cpE = 0;
    this.cvs = 4;
    this.ilL = new int[] { 14, 12 };
    this.appId = paramString1;
    this.gVh = paramString2;
    this.ilI = paramInt;
    this.ilJ = paramBoolean;
    AppMethodBeat.o(131891);
  }
  
  private WxaPkgWrappingInfo Dm(String paramString)
  {
    AppMethodBeat.i(131894);
    if ((!bo.isNullOrNil(this.gVh)) && (this.gVh.endsWith("__CODELIB__"))) {}
    for (paramString = WxaPkgWrappingInfo.yM(paramString);; paramString = WxaPkgWrappingInfo.yL(paramString))
    {
      paramString.gXf = this.ilI;
      AppMethodBeat.o(131894);
      return paramString;
    }
  }
  
  public final String aHc()
  {
    AppMethodBeat.i(131893);
    String str = String.format(Locale.US, "pkg %s, targetVersion %d, codeType %d", new Object[] { this.ilG.toString(), Integer.valueOf(this.ilI), Integer.valueOf(0) });
    AppMethodBeat.o(131893);
    return str;
  }
  
  public final void prepare()
  {
    Object localObject4 = null;
    Object localObject1 = null;
    int i = 1;
    AppMethodBeat.i(131895);
    Object localObject5 = com.tencent.mm.plugin.appbrand.app.g.auM();
    if (localObject5 == null)
    {
      ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL storage with %s", new Object[] { aHc() });
      d(null);
      AppMethodBeat.o(131895);
      return;
    }
    this.ilK = ((ay)localObject5).a(this.ilG.toString(), this.ilI, 0, new String[0]);
    if (this.ilK == null)
    {
      ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL record with %s", new Object[] { aHc() });
      d(null);
      localObject1 = ah.getContext().getString(2131296792, new Object[] { "" });
      if ((!this.ilJ) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        AppMethodBeat.o(131895);
        return;
      }
      com.tencent.mm.sdk.g.d.ysm.d(new w.3(this, (String)localObject1));
      AppMethodBeat.o(131895);
      return;
    }
    if (bo.isNullOrNil(this.ilK.field_versionMd5))
    {
      ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get EMPTY md5 with %s", new Object[] { aHc() });
      d(null);
      AppMethodBeat.o(131895);
      return;
    }
    try
    {
      localObject5 = com.tencent.mm.vfs.e.openRead(this.ilK.field_pkgPath);
      localObject1 = localObject5;
      localObject4 = localObject5;
      if (this.ilK.field_versionMd5.equals(com.tencent.mm.a.g.b((InputStream)localObject5, 4096)))
      {
        localObject1 = localObject5;
        localObject4 = localObject5;
        ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", new Object[] { aHc() });
        localObject1 = localObject5;
        localObject4 = localObject5;
        d(Dm(this.ilK.field_pkgPath));
        localObject1 = localObject5;
        localObject4 = localObject5;
        aHa();
        bo.b((Closeable)localObject5);
        AppMethodBeat.o(131895);
        return;
      }
      bo.b((Closeable)localObject5);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        bo.b((Closeable)localObject1);
      }
    }
    finally
    {
      bo.b(localFileNotFoundException);
      AppMethodBeat.o(131895);
    }
    com.tencent.mm.vfs.e.deleteFile(this.ilK.field_pkgPath);
    localObject1 = h.a(this.ilG, 0, this.ilI, this.ilK.field_versionMd5);
    if (localObject1 != null)
    {
      ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "find reusable record, target (%s), reusable (%s %d)", new Object[] { aHc(), ((at)localObject1).field_appId, Integer.valueOf(((at)localObject1).field_version) });
      localObject4 = aq.ar(this.ilG.toString(), this.ilI);
      com.tencent.mm.vfs.e.C(((at)localObject1).field_pkgPath, (String)localObject4);
      com.tencent.mm.plugin.appbrand.app.g.auM().d(this.ilG.toString(), 0, this.ilI, (String)localObject4);
      d(Dm((String)localObject4));
      aHa();
      AppMethodBeat.o(131895);
      return;
    }
    ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", new Object[] { aHc() });
    ass localass = new ass();
    localass.cwc = this.appId;
    localass.wAy = this.ilI;
    localass.xfY = 0;
    if (!bo.isNullOrNil(this.gVh))
    {
      localass.xfY = this.cvs;
      if (!a.contains(this.ilL, this.cvs)) {
        localass.xfV = this.gVh;
      }
    }
    localass.xhH = this.ilK.field_versionMd5;
    if ((r.avv()) && (j.a.nk(0)))
    {
      localObject3 = this.ilG.toString();
      if (!bo.isNullOrNil((String)localObject3))
      {
        if (!((String)localObject3).endsWith("__CODELIB__")) {
          break label803;
        }
        localObject3 = h.bl((String)localObject3, 0);
        if (localObject3 != null) {
          localass.xhI = ((WxaPkgWrappingInfo)localObject3).gXf;
        }
      }
    }
    Object localObject3 = localass.cwc;
    int j = localass.xfY;
    localObject5 = localass.xfV;
    int k = localass.wAy;
    int m = localass.xhI;
    String str = localass.xhH;
    if (r.avv()) {}
    for (;;)
    {
      ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "appid:%s,cgirequest pkgtype:%s,modulename:%s,version:%s,old_app_version:%s,record md5:%s,openIncremental:%s", new Object[] { localObject3, Integer.valueOf(j), localObject5, Integer.valueOf(k), Integer.valueOf(m), str, Integer.valueOf(i) });
      new com.tencent.mm.plugin.appbrand.appcache.d(localass).adl().h(new w.1(this, localass));
      AppMethodBeat.o(131895);
      return;
      label803:
      localObject3 = h.bl((String)localObject3, 1);
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.w
 * JD-Core Version:    0.7.0.1
 */