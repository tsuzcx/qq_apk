package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaCodeLibInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import org.json.JSONObject;

public class aj
  extends ag<WxaPkgWrappingInfo>
  implements n
{
  public static volatile boolean imI = false;
  private n imJ;
  
  aj(String paramString1, int paramInt1, String paramString2, int paramInt2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(143448);
    this.imJ = null;
    Object localObject1;
    Object localObject3;
    List localList1;
    int j;
    if (j.a.nk(paramInt1)) {
      if ((paramWxaVersionInfo.hki) || ((imI) && (!bo.es(paramWxaVersionInfo.moduleList))))
      {
        i = 1;
        localObject1 = paramWxaVersionInfo.moduleList;
        localObject3 = paramWxaVersionInfo.hkj;
        localList1 = paramWxaVersionInfo.hkg;
        j = paramWxaVersionInfo.hkh;
      }
    }
    List localList2;
    for (;;)
    {
      if ((!paramBoolean) || (!r.avz()) || (localList1 == null) || (localList1.size() <= 0)) {
        break label322;
      }
      if ((i == 0) || (bo.es((List)localObject1)) || (!r.avx())) {
        break label288;
      }
      ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitCodeLibModuleHandler");
      this.imJ = new aj.1(this, paramString1, paramInt1, paramWxaVersionInfo.bDc, (List)localObject1);
      AppMethodBeat.o(143448);
      return;
      i = 0;
      break;
      localObject1 = ((m)g.w(m.class)).bm(paramString1, paramInt1);
      try
      {
        localObject1 = h.mo((String)localObject1);
        if (localObject1 == null)
        {
          i = 0;
          localObject1 = null;
          localObject3 = null;
          localList1 = null;
          j = 0;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject2 = null;
        }
        localList2 = WxaAttributes.WxaVersionModuleInfo.AE(((JSONObject)localObject2).optString("module_list"));
        localList1 = WxaAttributes.WxaCodeLibInfo.AC(((JSONObject)localObject2).optString("wxacode_lib_info_list"));
        if (bo.es(localList2)) {
          break label275;
        }
      }
    }
    int i = 1;
    label250:
    if (i != 0) {}
    for (Object localObject2 = ((JSONObject)localObject2).optString("entrance_module");; localObject2 = "")
    {
      localObject3 = localObject2;
      localObject2 = localList2;
      break;
      label275:
      i = 0;
      break label250;
    }
    label288:
    ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitCodeLibHandler");
    this.imJ = new aj.2(this, paramString1, paramInt1, paramWxaVersionInfo.bDc, localList1);
    AppMethodBeat.o(143448);
    return;
    label322:
    if ((i != 0) && (!bo.es((List)localObject2)) && (r.avx()))
    {
      ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgModularizingHandler");
      this.imJ = new aj.3(this, paramString1, paramInt1, paramString2, paramInt2, paramWxaVersionInfo.bDc, j, (String)localObject3, (List)localObject2);
      AppMethodBeat.o(143448);
      return;
    }
    ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgIntegratedHandler");
    this.imJ = new aj.4(this, paramString1, paramInt1, paramWxaVersionInfo.bDc, paramInt2, paramWxaVersionInfo);
    AppMethodBeat.o(143448);
  }
  
  aj(String paramString1, String paramString2, int paramInt, WxaAttributes paramWxaAttributes)
  {
    this(paramString1, 0, paramString2, paramInt, paramWxaAttributes.ayE(), paramWxaAttributes.ayC().vY());
    AppMethodBeat.i(143447);
    AppMethodBeat.o(143447);
  }
  
  public void aGL() {}
  
  public void aGQ() {}
  
  public final WxaPkgWrappingInfo azY()
  {
    AppMethodBeat.i(131983);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = (WxaPkgWrappingInfo)this.imJ.call();
    AppMethodBeat.o(131983);
    return localWxaPkgWrappingInfo;
  }
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
  }
  
  public void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aj
 * JD-Core Version:    0.7.0.1
 */