package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage;", "Lcom/tencent/mm/kernel/service/IService;", "checkIsPageIndexExisted", "", "appId", "", "appVersion", "", "checkIsPagePathIncluded", "pagePath", "cleanExpiredIndex", "", "removeIndexByAppId", "updatePageIndex", "pagesJson", "Factory", "plugin-appbrand-integration_release"})
public abstract interface bw
  extends com.tencent.mm.kernel.c.a
{
  public abstract void acJ(String paramString);
  
  public abstract void bGK();
  
  public abstract boolean bi(String paramString, int paramInt);
  
  public abstract boolean p(String paramString1, int paramInt, String paramString2);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage$Factory;", "", "()V", "TAG", "", "install", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "updatePageIndexWithPkgInfo", "appId", "wxaPkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static final a nIB;
    
    static
    {
      AppMethodBeat.i(275895);
      nIB = new a();
      AppMethodBeat.o(275895);
    }
    
    public static final void a(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      AppMethodBeat.i(275893);
      p.k(paramString, "appId");
      p.k(paramWxaPkgWrappingInfo, "wxaPkgWrappingInfo");
      Object localObject1 = ((Iterable)paramWxaPkgWrappingInfo).iterator();
      Object localObject2;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ModulePkgInfo)((Iterator)localObject1).next();
      } while ((!((ModulePkgInfo)localObject2).independent) || (!com.tencent.mm.vfs.u.agG(((ModulePkgInfo)localObject2).pkgPath)));
      for (;;)
      {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (p.h("__APP__", ((ModulePkgInfo)localObject2).name))
          {
            localObject1 = "";
            localObject1 = (String)localObject1 + "/app-config.json";
            localObject1 = WxaPkg.cy(((ModulePkgInfo)localObject2).pkgPath, (String)localObject1);
            localObject2 = (CharSequence)localObject1;
            if (localObject2 == null) {
              break label246;
            }
            if (((CharSequence)localObject2).length() == 0)
            {
              break label246;
              if (i != 0) {
                continue;
              }
              localObject1 = com.eclipsesource.a.a.bb((String)localObject1).pW().be("pages").toString();
              p.j(localObject1, "Json.parse(configJson).a…).get(\"pages\").toString()");
              localObject2 = u.nEH;
              u.q(paramString, paramWxaPkgWrappingInfo.pkgVersion(), (String)localObject1);
              AppMethodBeat.o(275893);
            }
          }
          else
          {
            localObject1 = e.acA(((ModulePkgInfo)localObject2).name);
            continue;
          }
          i = 0;
          continue;
          AppMethodBeat.o(275893);
        }
        catch (Exception paramWxaPkgWrappingInfo)
        {
          Log.e("MicroMsg.WxaVersionPagePathIndexStorage", "updatePageIndexWithPkgInfo(appId:" + paramString + ") get exception:" + paramWxaPkgWrappingInfo);
          AppMethodBeat.o(275893);
          return;
        }
        return;
        label246:
        int i = 1;
      }
    }
    
    public static final void e(g paramg)
    {
      AppMethodBeat.i(275890);
      p.k(paramg, "profile");
      if (paramg.aIE()) {
        com.tencent.mm.kernel.h.a(bw.class, (c)new com.tencent.mm.kernel.c.e((com.tencent.mm.kernel.c.a)u.nEH));
      }
      AppMethodBeat.o(275890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bw
 * JD-Core Version:    0.7.0.1
 */