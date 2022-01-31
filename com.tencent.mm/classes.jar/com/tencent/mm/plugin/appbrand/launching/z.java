package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;
import org.json.JSONObject;

public class z
  extends w<WxaPkgWrappingInfo>
  implements i
{
  public static volatile boolean gLp = false;
  private final i gLq;
  
  z(String paramString1, int paramInt1, String paramString2, int paramInt2, WxaAttributes.d paramd)
  {
    int i;
    Object localObject2;
    String str1;
    int j;
    if (d.a.kq(paramInt1)) {
      if ((paramd.fRv) || ((gLp) && (!bk.dk(paramd.fRu))))
      {
        i = 1;
        localObject2 = paramd.fRu;
        str1 = paramd.fRw;
        j = paramd.fRt;
      }
    }
    for (;;)
    {
      if ((i != 0) && (!bk.dk((List)localObject2)) && (l.abH()))
      {
        this.gLq = new z.1(this, paramString1, paramInt1, paramString2, paramInt2, paramd.cau, j, str1, (List)localObject2);
        return;
        i = 0;
        break;
        str1 = ((h)e.G(h.class)).aV(paramString1, paramInt1);
        try
        {
          localObject2 = com.tencent.mm.ab.h.fU(str1);
          if (localObject2 == null)
          {
            str1 = null;
            localObject2 = null;
            i = 0;
            j = 0;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localObject2 = null;
            continue;
            Object localObject1 = WxaAttributes.WxaVersionModuleInfo.sJ(((JSONObject)localObject2).optString("module_list"));
            if (!bk.dk((List)localObject1)) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label218;
              }
              str2 = ((JSONObject)localObject2).optString("entrance_module");
              localObject2 = localObject1;
              localObject1 = str2;
              break;
            }
            label218:
            String str2 = "";
            localObject2 = localObject1;
            localObject1 = str2;
          }
        }
      }
    }
    this.gLq = new z.2(this, paramString1, paramInt1, paramd.cau, paramInt2, paramd);
  }
  
  public final WxaPkgWrappingInfo aft()
  {
    return (WxaPkgWrappingInfo)this.gLq.call();
  }
  
  public void alE() {}
  
  public void alG() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
  }
  
  public void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.z
 * JD-Core Version:    0.7.0.1
 */