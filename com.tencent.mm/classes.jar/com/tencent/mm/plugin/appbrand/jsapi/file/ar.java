package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.i;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    com.tencent.mm.compatible.util.j.pq("appbrandcommon");
    AppMethodBeat.o(147172);
  }
  
  public ar(c paramc, d paramd)
  {
    super(new LinkedList());
    AppMethodBeat.i(147163);
    if (bl.V(paramc) != null) {}
    for (Object localObject = new az(be.U(paramc));; localObject = ba.S(paramc))
    {
      this.iSX.clear();
      n localn = new n(AppBrandLocalMediaObjectManager.fQU() + paramc.mAppId + "/", paramc.mAppId, "wxfile://");
      localn.iSN = (paramd.cfF * 1048576L);
      x localx1 = cO(p.getString(paramc.DZ().uin), paramc.mAppId);
      localx1.iTe = (paramd.cfF * 1048576L);
      x localx2 = cP(p.getString(paramc.DZ().uin), paramc.mAppId);
      localx2.iTe = (paramd.jcK * 1048576L);
      this.iSX.add(localx2);
      localx2 = cQ(p.getString(paramc.DZ().uin), paramc.mAppId);
      localx2.iTe = 9223372036854775807L;
      this.iSX.add(localx2);
      paramc = cR(p.getString(paramc.DZ().uin), paramc.mAppId);
      paramc.iTe = (paramd.cfF * 1048576L);
      this.iSX.add(paramc);
      this.iSX.add(localx1);
      this.iSX.add(localn);
      this.iSX.add(localObject);
      initialize();
      AppMethodBeat.o(147163);
      return;
    }
  }
  
  public static String aZK()
  {
    AppMethodBeat.i(202257);
    String str = AppBrandLocalMediaObjectManager.fQU();
    AppMethodBeat.o(202257);
    return str;
  }
  
  public static x cO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147168);
    paramString1 = new x(n(new String[] { paramString1, paramString2 }), "wxfile://usr");
    AppMethodBeat.o(147168);
    return paramString1;
  }
  
  public static x cP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147169);
    paramString1 = new x(n(new String[] { paramString1, paramString2, "opendata" }), "wxfile://opendata");
    AppMethodBeat.o(147169);
    return paramString1;
  }
  
  public static x cQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147170);
    paramString1 = new x(n(new String[] { paramString1, paramString2, "clientdata" }), "wxfile://clientdata");
    AppMethodBeat.o(147170);
    return paramString1;
  }
  
  public static x cR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182990);
    paramString1 = new x(n(new String[] { paramString1, paramString2, "singlePage" }), "wxfile://singlepage");
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
      ((StringBuilder)localObject).append(bt.nullAsNil(paramVarArgs[i])).append(';');
      i += 1;
    }
    String str = g.getMessageDigest(((StringBuilder)localObject).toString().getBytes());
    if (!com.tencent.mm.compatible.util.e.XG()) {}
    for (paramVarArgs = null; paramVarArgs == null; paramVarArgs = new com.tencent.mm.vfs.e(paramVarArgs + "wxanewfiles/"))
    {
      ad.e("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
      AppMethodBeat.o(147171);
      return null;
      localObject = com.tencent.mm.loader.j.b.aih();
      paramVarArgs = (String[])localObject;
      if (!((String)localObject).endsWith("/")) {
        paramVarArgs = (String)localObject + "/";
      }
    }
    paramVarArgs = q.B(new com.tencent.mm.vfs.e(q.B(paramVarArgs.mUri) + "/" + str).mUri);
    AppMethodBeat.o(147171);
    return paramVarArgs;
  }
  
  public final com.tencent.mm.vfs.e ER(String paramString)
  {
    AppMethodBeat.i(147166);
    paramString = ((n)av(n.class)).ER(paramString);
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
    if (("wxfile".equals(((Uri)localObject).getScheme())) && (bt.isNullOrNil(((Uri)localObject).getAuthority())))
    {
      paramString = new LinkedList();
      ((n)av(n.class)).a("", parami);
      if (!bt.gL((List)parami.value))
      {
        localObject = ((List)parami.value).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.appbrand.appstorage.j localj = (com.tencent.mm.plugin.appbrand.appstorage.j)((Iterator)localObject).next();
          localj.fileName = localj.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
        }
      }
      com.tencent.luggage.h.b.c(paramString, (List)parami.value);
      ((x)EZ("wxfile://usr")).a("wxfile://usr", parami);
      com.tencent.luggage.h.b.c(paramString, (List)parami.value);
      parami.value = paramString;
      paramString = l.iSq;
      AppMethodBeat.o(147164);
      return paramString;
    }
    paramString = super.a(paramString, parami);
    AppMethodBeat.o(147164);
    return paramString;
  }
  
  public final List<w> aRh()
  {
    AppMethodBeat.i(147167);
    List localList = ((n)av(n.class)).iSL.aRj();
    AppMethodBeat.o(147167);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ar
 * JD-Core Version:    0.7.0.1
 */