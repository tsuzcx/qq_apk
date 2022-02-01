package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.ac;
import com.tencent.mm.plugin.appbrand.appstorage.ae;
import com.tencent.mm.plugin.appbrand.appstorage.af;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.n.a;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class ax
  extends ac
{
  static
  {
    AppMethodBeat.i(147172);
    ax.class.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("appbrandcommon");
    AppMethodBeat.o(147172);
  }
  
  public ax(final com.tencent.luggage.sdk.e.d paramd, d paramd1)
  {
    super(new LinkedList());
    AppMethodBeat.i(147163);
    bf localbf = new bf(bl.R(paramd));
    this.qNv.clear();
    Object localObject = new n(AppBrandLocalMediaObjectManager.cPU() + paramd.mAppId + "/blobTmp/", paramd.mAppId, "wxblob://", new n.a()
    {
      public final f cik()
      {
        AppMethodBeat.i(328973);
        y localy = paramd.ari();
        AppMethodBeat.o(328973);
        return localy;
      }
    });
    ((n)localObject).qMK = (paramd1.epQ * 1048576L);
    this.qNv.add(localObject);
    localObject = paramd.mAppId;
    localObject = new com.tencent.mm.plugin.appbrand.appstorage.u(AppBrandLocalMediaObjectManager.cPU() + (String)localObject + "/", (String)localObject, "wxfile://");
    ((com.tencent.mm.plugin.appbrand.appstorage.u)localObject).qMK = (paramd1.epQ * 1048576L);
    af localaf1 = dU(com.tencent.mm.b.p.getString(paramd.asA().uin), paramd.mAppId);
    localaf1.qNB = (paramd1.epQ * 1048576L);
    af localaf2 = dV(com.tencent.mm.b.p.getString(paramd.asA().uin), paramd.mAppId);
    localaf2.qNB = (paramd1.qXk * 1048576L);
    this.qNv.add(localaf2);
    localaf2 = dW(com.tencent.mm.b.p.getString(paramd.asA().uin), paramd.mAppId);
    localaf2.qNB = 9223372036854775807L;
    this.qNv.add(localaf2);
    paramd = dX(com.tencent.mm.b.p.getString(paramd.asA().uin), paramd.mAppId);
    paramd.qNB = (paramd1.epQ * 1048576L);
    this.qNv.add(paramd);
    this.qNv.add(localaf1);
    this.qNv.add(localObject);
    this.qNv.add(localbf);
    initialize();
    AppMethodBeat.o(147163);
  }
  
  public static String cse()
  {
    AppMethodBeat.i(370031);
    String str = AppBrandLocalMediaObjectManager.cPU();
    AppMethodBeat.o(370031);
    return str;
  }
  
  public static af dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147168);
    paramString1 = new af(n(new String[] { paramString1, paramString2 }), "wxfile://usr");
    AppMethodBeat.o(147168);
    return paramString1;
  }
  
  public static af dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147169);
    paramString1 = new af(n(new String[] { paramString1, paramString2, "opendata" }), "wxfile://opendata");
    AppMethodBeat.o(147169);
    return paramString1;
  }
  
  public static af dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147170);
    paramString1 = new af(n(new String[] { paramString1, paramString2, "clientdata" }), "wxfile://clientdata");
    AppMethodBeat.o(147170);
    return paramString1;
  }
  
  public static af dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182990);
    paramString1 = new af(n(new String[] { paramString1, paramString2, "singlePage" }), "wxfile://singlepage");
    AppMethodBeat.o(182990);
    return paramString1;
  }
  
  public static String n(String... paramVarArgs)
  {
    AppMethodBeat.i(147171);
    Object localObject = new StringBuilder(";");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(Util.nullAsNil(paramVarArgs[i])).append(';');
      i += 1;
    }
    String str = g.getMessageDigest(((StringBuilder)localObject).toString().getBytes());
    if (!e.aPU()) {}
    for (paramVarArgs = null; paramVarArgs == null; paramVarArgs = new com.tencent.mm.vfs.u(paramVarArgs + "wxanewfiles/"))
    {
      Log.e("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
      AppMethodBeat.o(147171);
      return null;
      localObject = com.tencent.mm.loader.i.b.bmz();
      paramVarArgs = (String[])localObject;
      if (!((String)localObject).endsWith("/")) {
        paramVarArgs = (String)localObject + "/";
      }
    }
    paramVarArgs = ah.v(new com.tencent.mm.vfs.u(ah.v(paramVarArgs.mUri) + "/" + str).mUri);
    AppMethodBeat.o(147171);
    return paramVarArgs;
  }
  
  public com.tencent.mm.vfs.u Wo(String paramString)
  {
    AppMethodBeat.i(147166);
    paramString = ((com.tencent.mm.plugin.appbrand.appstorage.u)aR(com.tencent.mm.plugin.appbrand.appstorage.u.class)).Wo(paramString);
    AppMethodBeat.o(147166);
    return paramString;
  }
  
  public r a(com.tencent.mm.vfs.u paramu, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.af.k<String> paramk)
  {
    AppMethodBeat.i(169493);
    paramu = ((com.tencent.mm.plugin.appbrand.appstorage.u)aR(com.tencent.mm.plugin.appbrand.appstorage.u.class)).a(paramu, paramString, paramBoolean, paramk);
    AppMethodBeat.o(169493);
    return paramu;
  }
  
  public final r a(String paramString, com.tencent.mm.plugin.appbrand.af.k<List<com.tencent.mm.plugin.appbrand.appstorage.p>> paramk)
  {
    AppMethodBeat.i(147164);
    Object localObject = Uri.parse(paramString);
    if (("wxfile".equals(((Uri)localObject).getScheme())) && (Util.isNullOrNil(((Uri)localObject).getAuthority())))
    {
      paramString = new LinkedList();
      ((com.tencent.mm.plugin.appbrand.appstorage.u)aR(com.tencent.mm.plugin.appbrand.appstorage.u.class)).a("", paramk);
      if (!Util.isNullOrNil((List)paramk.value))
      {
        localObject = ((List)paramk.value).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.appbrand.appstorage.p localp = (com.tencent.mm.plugin.appbrand.appstorage.p)((Iterator)localObject).next();
          localp.fileName = localp.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
        }
      }
      com.tencent.luggage.l.b.h(paramString, (List)paramk.value);
      ((af)Wy("wxfile://usr")).a("wxfile://usr", paramk);
      com.tencent.luggage.l.b.h(paramString, (List)paramk.value);
      paramk.value = paramString;
      paramString = r.qML;
      AppMethodBeat.o(147164);
      return paramString;
    }
    paramString = super.a(paramString, paramk);
    AppMethodBeat.o(147164);
    return paramString;
  }
  
  public final List<ae> cil()
  {
    AppMethodBeat.i(147167);
    List localList = ((com.tencent.mm.plugin.appbrand.appstorage.u)aR(com.tencent.mm.plugin.appbrand.appstorage.u.class)).qNd.cip();
    AppMethodBeat.o(147167);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ax
 * JD-Core Version:    0.7.0.1
 */