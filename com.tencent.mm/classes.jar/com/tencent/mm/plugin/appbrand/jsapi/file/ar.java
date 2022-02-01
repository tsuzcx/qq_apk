package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class ar
  extends t
{
  static
  {
    AppMethodBeat.i(147172);
    ar.class.getClassLoader();
    com.tencent.mm.compatible.util.j.sC("appbrandcommon");
    AppMethodBeat.o(147172);
  }
  
  public ar(c paramc, d paramd)
  {
    super(new LinkedList());
    AppMethodBeat.i(147163);
    if (bl.V(paramc) != null) {}
    for (Object localObject = new az(be.U(paramc));; localObject = ba.S(paramc))
    {
      this.jti.clear();
      n localn = new n(AppBrandLocalMediaObjectManager.aXR() + paramc.mAppId + "/", paramc.mAppId, "wxfile://");
      localn.jsY = (paramd.ccC * 1048576L);
      x localx1 = cZ(p.getString(paramc.DC().uin), paramc.mAppId);
      localx1.jtp = (paramd.ccC * 1048576L);
      x localx2 = da(p.getString(paramc.DC().uin), paramc.mAppId);
      localx2.jtp = (paramd.jCX * 1048576L);
      this.jti.add(localx2);
      localx2 = db(p.getString(paramc.DC().uin), paramc.mAppId);
      localx2.jtp = 9223372036854775807L;
      this.jti.add(localx2);
      paramc = dc(p.getString(paramc.DC().uin), paramc.mAppId);
      paramc.jtp = (paramd.ccC * 1048576L);
      this.jti.add(paramc);
      this.jti.add(localx1);
      this.jti.add(localn);
      this.jti.add(localObject);
      initialize();
      AppMethodBeat.o(147163);
      return;
    }
  }
  
  public static String bgC()
  {
    AppMethodBeat.i(210395);
    String str = AppBrandLocalMediaObjectManager.aXR();
    AppMethodBeat.o(210395);
    return str;
  }
  
  public static x cZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147168);
    paramString1 = new x(m(new String[] { paramString1, paramString2 }), "wxfile://usr");
    AppMethodBeat.o(147168);
    return paramString1;
  }
  
  public static x da(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147169);
    paramString1 = new x(m(new String[] { paramString1, paramString2, "opendata" }), "wxfile://opendata");
    AppMethodBeat.o(147169);
    return paramString1;
  }
  
  public static x db(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147170);
    paramString1 = new x(m(new String[] { paramString1, paramString2, "clientdata" }), "wxfile://clientdata");
    AppMethodBeat.o(147170);
    return paramString1;
  }
  
  public static x dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182990);
    paramString1 = new x(m(new String[] { paramString1, paramString2, "singlePage" }), "wxfile://singlepage");
    AppMethodBeat.o(182990);
    return paramString1;
  }
  
  public static String m(String... paramVarArgs)
  {
    AppMethodBeat.i(147171);
    Object localObject = new StringBuilder(";");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(bs.nullAsNil(paramVarArgs[i])).append(';');
      i += 1;
    }
    String str = g.getMessageDigest(((StringBuilder)localObject).toString().getBytes());
    if (!com.tencent.mm.compatible.util.e.YD()) {}
    for (paramVarArgs = null; paramVarArgs == null; paramVarArgs = new com.tencent.mm.vfs.e(paramVarArgs + "wxanewfiles/"))
    {
      ac.e("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
      AppMethodBeat.o(147171);
      return null;
      localObject = com.tencent.mm.loader.j.b.aph();
      paramVarArgs = (String[])localObject;
      if (!((String)localObject).endsWith("/")) {
        paramVarArgs = (String)localObject + "/";
      }
    }
    paramVarArgs = q.B(new com.tencent.mm.vfs.e(q.B(paramVarArgs.mUri) + "/" + str).mUri);
    AppMethodBeat.o(147171);
    return paramVarArgs;
  }
  
  public final com.tencent.mm.vfs.e IU(String paramString)
  {
    AppMethodBeat.i(147166);
    paramString = ((n)av(n.class)).IU(paramString);
    AppMethodBeat.o(147166);
    return paramString;
  }
  
  public l a(com.tencent.mm.vfs.e parame, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(169493);
    parame = ((n)av(n.class)).a(parame, paramString, paramBoolean, parami);
    AppMethodBeat.o(169493);
    return parame;
  }
  
  public final l a(String paramString, i<List<com.tencent.mm.plugin.appbrand.appstorage.j>> parami)
  {
    AppMethodBeat.i(147164);
    Object localObject = Uri.parse(paramString);
    if (("wxfile".equals(((Uri)localObject).getScheme())) && (bs.isNullOrNil(((Uri)localObject).getAuthority())))
    {
      paramString = new LinkedList();
      ((n)av(n.class)).a("", parami);
      if (!bs.gY((List)parami.value))
      {
        localObject = ((List)parami.value).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.appbrand.appstorage.j localj = (com.tencent.mm.plugin.appbrand.appstorage.j)((Iterator)localObject).next();
          localj.fileName = localj.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
        }
      }
      com.tencent.luggage.h.b.c(paramString, (List)parami.value);
      ((x)Jc("wxfile://usr")).a("wxfile://usr", parami);
      com.tencent.luggage.h.b.c(paramString, (List)parami.value);
      parami.value = paramString;
      paramString = l.jsB;
      AppMethodBeat.o(147164);
      return paramString;
    }
    paramString = super.a(paramString, parami);
    AppMethodBeat.o(147164);
    return paramString;
  }
  
  public final List<w> aYc()
  {
    AppMethodBeat.i(147167);
    List localList = ((n)av(n.class)).jsW.aYe();
    AppMethodBeat.o(147167);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ar
 * JD-Core Version:    0.7.0.1
 */