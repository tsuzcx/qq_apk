package com.tencent.mm.plugin.appbrand.appcache;

import com.eclipsesource.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage;", "Lcom/tencent/mm/kernel/service/IService;", "checkIsPageIndexExisted", "", "appId", "", "appVersion", "", "checkIsPagePathIncluded", "pagePath", "cleanExpiredIndex", "", "removeIndexByAppId", "updatePageIndex", "pagesJson", "Factory", "plugin-appbrand-integration_release"})
public abstract interface bp
  extends com.tencent.mm.kernel.c.a
{
  public abstract void LQ(String paramString);
  
  public abstract boolean aK(String paramString, int paramInt);
  
  public abstract void ban();
  
  public abstract boolean l(String paramString1, int paramInt, String paramString2);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage$Factory;", "", "()V", "TAG", "", "install", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "updatePageIndexWithPkgInfo", "appId", "wxaPkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static final a jMw;
    
    static
    {
      AppMethodBeat.i(223214);
      jMw = new a();
      AppMethodBeat.o(223214);
    }
    
    public static final void a(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      AppMethodBeat.i(223213);
      p.h(paramString, "appId");
      p.h(paramWxaPkgWrappingInfo, "wxaPkgWrappingInfo");
      Object localObject1 = ((Iterable)paramWxaPkgWrappingInfo).iterator();
      Object localObject2;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ModulePkgInfo)((Iterator)localObject1).next();
      } while ((!((ModulePkgInfo)localObject2).independent) || (!o.fB(((ModulePkgInfo)localObject2).pkgPath)));
      for (;;)
      {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (p.i("__APP__", ((ModulePkgInfo)localObject2).name))
          {
            localObject1 = "";
            localObject1 = (String)localObject1 + "/app-config.json";
            localObject1 = WxaPkg.cf(((ModulePkgInfo)localObject2).pkgPath, (String)localObject1);
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
              localObject1 = com.eclipsesource.a.a.aR((String)localObject1).sf().aU("pages").toString();
              p.g(localObject1, "Json.parse(configJson).a…).get(\"pages\").toString()");
              localObject2 = t.jIW;
              t.m(paramString, paramWxaPkgWrappingInfo.pkgVersion(), (String)localObject1);
              AppMethodBeat.o(223213);
            }
          }
          else
          {
            localObject1 = e.LH(((ModulePkgInfo)localObject2).name);
            continue;
          }
          i = 0;
          continue;
          AppMethodBeat.o(223213);
        }
        catch (Exception paramWxaPkgWrappingInfo)
        {
          ae.e("MicroMsg.WxaVersionPagePathIndexStorage", "updatePageIndexWithPkgInfo(appId:" + paramString + ") get exception:" + paramWxaPkgWrappingInfo);
          AppMethodBeat.o(223213);
          return;
        }
        return;
        label246:
        int i = 1;
      }
    }
    
    public static final void d(com.tencent.mm.kernel.b.g paramg)
    {
      AppMethodBeat.i(223212);
      p.h(paramg, "profile");
      if (paramg.akL()) {
        com.tencent.mm.kernel.g.a(bp.class, (c)new com.tencent.mm.kernel.c.e((com.tencent.mm.kernel.c.a)t.jIW));
      }
      AppMethodBeat.o(223212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bp
 * JD-Core Version:    0.7.0.1
 */