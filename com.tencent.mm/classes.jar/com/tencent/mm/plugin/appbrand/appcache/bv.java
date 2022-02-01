package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage;", "Lcom/tencent/mm/kernel/service/IService;", "checkIsPageIndexExisted", "", "appId", "", "appVersion", "", "checkIsPagePathIncluded", "pagePath", "cleanExpiredIndex", "", "removeIndexByAppId", "updatePageIndex", "pagesJson", "Factory", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bv
  extends com.tencent.mm.kernel.c.a
{
  public abstract void Vi(String paramString);
  
  public abstract boolean bz(String paramString, int paramInt);
  
  public abstract void cgi();
  
  public abstract boolean r(String paramString1, int paramInt, String paramString2);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage$Factory;", "", "()V", "TAG", "", "install", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "updatePageIndexWithPkgInfo", "appId", "wxaPkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a qIr;
    
    static
    {
      AppMethodBeat.i(320377);
      qIr = new a();
      AppMethodBeat.o(320377);
    }
    
    public static final void a(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      AppMethodBeat.i(320376);
      s.u(paramString, "appId");
      s.u(paramWxaPkgWrappingInfo, "wxaPkgWrappingInfo");
      Object localObject1 = ((Iterable)paramWxaPkgWrappingInfo).iterator();
      Object localObject2;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ModulePkgInfo)((Iterator)localObject1).next();
      } while ((!((ModulePkgInfo)localObject2).independent) || (!y.ZC(((ModulePkgInfo)localObject2).pkgPath)));
      for (;;)
      {
        try
        {
          if (s.p("__APP__", ((ModulePkgInfo)localObject2).name))
          {
            localObject1 = "";
            localObject1 = s.X((String)localObject1, "/app-config.json");
            localObject1 = WxaPkg.cP(((ModulePkgInfo)localObject2).pkgPath, (String)localObject1);
            localObject2 = (CharSequence)localObject1;
            if (localObject2 == null) {
              break label229;
            }
            if (((CharSequence)localObject2).length() == 0)
            {
              break label229;
              if (i != 0) {
                continue;
              }
              localObject1 = com.eclipsesource.a.a.co((String)localObject1).Ph().cr("pages").toString();
              s.s(localObject1, "parse(configJson).asObje…).get(\"pages\").toString()");
              localObject2 = w.qEE;
              w.s(paramString, paramWxaPkgWrappingInfo.pkgVersion(), (String)localObject1);
              AppMethodBeat.o(320376);
            }
          }
          else
          {
            localObject1 = e.UZ(((ModulePkgInfo)localObject2).name);
            continue;
          }
          i = 0;
          continue;
          AppMethodBeat.o(320376);
        }
        catch (Exception paramWxaPkgWrappingInfo)
        {
          Log.e("MicroMsg.WxaVersionPagePathIndexStorage", "updatePageIndexWithPkgInfo(appId:" + paramString + ") get exception:" + paramWxaPkgWrappingInfo);
          AppMethodBeat.o(320376);
          return;
        }
        return;
        label229:
        int i = 1;
      }
    }
    
    public static final void f(g paramg)
    {
      AppMethodBeat.i(320373);
      s.u(paramg, "profile");
      if (paramg.bbA()) {
        com.tencent.mm.kernel.h.a(bv.class, (c)new com.tencent.mm.kernel.c.e((com.tencent.mm.kernel.c.a)w.qEE));
      }
      AppMethodBeat.o(320373);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bv
 * JD-Core Version:    0.7.0.1
 */