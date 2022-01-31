package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.a.p;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class an
  extends t
{
  static
  {
    AppMethodBeat.i(140837);
    k.a("appbrandcommon", an.class.getClassLoader());
    AppMethodBeat.o(140837);
  }
  
  public an(com.tencent.luggage.sdk.d.b paramb, c paramc)
  {
    super(paramb);
    AppMethodBeat.i(140835);
    this.had.clear();
    IWxaFileSystemWithModularizing localIWxaFileSystemWithModularizing = ar.o(paramb);
    l locall = new l(AppBrandLocalMediaObjectManager.gZo + paramb.mAppId + "/", paramb.mAppId, "wxfile://");
    locall.gZU = (paramc.bDx * 1048576L);
    w localw1 = ch(p.getString(paramb.wS().uin), paramb.mAppId);
    localw1.hak = (paramc.bDx * 1048576L);
    w localw2 = ci(p.getString(paramb.wS().uin), paramb.mAppId);
    localw2.hak = (paramc.hhZ * 1048576L);
    this.had.add(localw2);
    paramb = cj(p.getString(paramb.wS().uin), paramb.mAppId);
    paramb.hak = 9223372036854775807L;
    this.had.add(paramb);
    this.had.add(localw1);
    this.had.add(locall);
    this.had.add(localIWxaFileSystemWithModularizing);
    initialize();
    AppMethodBeat.o(140835);
  }
  
  public static String aCY()
  {
    return AppBrandLocalMediaObjectManager.gZo;
  }
  
  public static w ch(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131082);
    paramString1 = new w(j(new String[] { paramString1, paramString2 }), "wxfile://usr");
    AppMethodBeat.o(131082);
    return paramString1;
  }
  
  public static w ci(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131083);
    paramString1 = new w(j(new String[] { paramString1, paramString2, "opendata" }), "wxfile://opendata");
    AppMethodBeat.o(131083);
    return paramString1;
  }
  
  public static w cj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140836);
    paramString1 = new w(j(new String[] { paramString1, paramString2, "clientdata" }), "wxfile://clientdata");
    AppMethodBeat.o(140836);
    return paramString1;
  }
  
  private static String j(String... paramVarArgs)
  {
    AppMethodBeat.i(131084);
    Object localObject = new StringBuilder(";");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(bo.nullAsNil(paramVarArgs[i])).append(';');
      i += 1;
    }
    String str = g.w(((StringBuilder)localObject).toString().getBytes());
    if (!f.Mi()) {}
    for (paramVarArgs = null; paramVarArgs == null; paramVarArgs = new File(paramVarArgs + "wxanewfiles/"))
    {
      ab.e("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
      AppMethodBeat.o(131084);
      return null;
      localObject = com.tencent.mm.loader.j.b.eQz;
      paramVarArgs = (String[])localObject;
      if (!((String)localObject).endsWith("/")) {
        paramVarArgs = (String)localObject + "/";
      }
    }
    paramVarArgs = new File(paramVarArgs.getPath() + "/" + str).getPath();
    AppMethodBeat.o(131084);
    return paramVarArgs;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.j a(File paramFile, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    AppMethodBeat.i(131079);
    paramFile = ((l)Y(l.class)).a(paramFile, paramString, paramBoolean, paramj);
    AppMethodBeat.o(131079);
    return paramFile;
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.j a(String paramString, com.tencent.mm.plugin.appbrand.s.j<List<h>> paramj)
  {
    AppMethodBeat.i(131078);
    Object localObject = Uri.parse(paramString);
    if (("wxfile".equals(((Uri)localObject).getScheme())) && (bo.isNullOrNil(((Uri)localObject).getAuthority())))
    {
      paramString = new LinkedList();
      ((l)Y(l.class)).a("", paramj);
      if (!bo.es((List)paramj.value))
      {
        localObject = ((List)paramj.value).iterator();
        while (((Iterator)localObject).hasNext())
        {
          h localh = (h)((Iterator)localObject).next();
          localh.fileName = localh.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
        }
      }
      com.tencent.luggage.g.c.c(paramString, (List)paramj.value);
      ((w)zn("wxfile://usr")).a("wxfile://usr", paramj);
      com.tencent.luggage.g.c.c(paramString, (List)paramj.value);
      paramj.value = paramString;
      paramString = com.tencent.mm.plugin.appbrand.appstorage.j.gZA;
      AppMethodBeat.o(131078);
      return paramString;
    }
    paramString = super.a(paramString, paramj);
    AppMethodBeat.o(131078);
    return paramString;
  }
  
  public final List<v> awJ()
  {
    AppMethodBeat.i(131081);
    List localList = ((l)Y(l.class)).gZT.awK();
    AppMethodBeat.o(131081);
    return localList;
  }
  
  public final com.tencent.mm.vfs.b zh(String paramString)
  {
    AppMethodBeat.i(131080);
    paramString = ((l)Y(l.class)).zh(paramString);
    AppMethodBeat.o(131080);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.an
 * JD-Core Version:    0.7.0.1
 */