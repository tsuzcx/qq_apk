package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.bu;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.aa;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.i.a;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class av
  extends x
{
  static
  {
    AppMethodBeat.i(147172);
    av.class.getClassLoader();
    j.KW("appbrandcommon");
    AppMethodBeat.o(147172);
  }
  
  public av(final com.tencent.luggage.sdk.e.d paramd, d paramd1)
  {
    super(new LinkedList());
    AppMethodBeat.i(147163);
    if (bu.P(paramd) != null) {}
    for (Object localObject1 = new be(bl.N(paramd));; localObject1 = bf.L(paramd))
    {
      this.nNC.clear();
      Object localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.i(AppBrandLocalMediaObjectManager.bIr() + paramd.mAppId + "/blobTmp/", paramd.mAppId, "wxblob://", new i.a()
      {
        public final com.tencent.mm.plugin.appbrand.jsapi.e bIF()
        {
          AppMethodBeat.i(250548);
          v localv = paramd.QW();
          AppMethodBeat.o(250548);
          return localv;
        }
      });
      ((com.tencent.mm.plugin.appbrand.appstorage.i)localObject2).nMQ = (paramd1.cxy * 1048576L);
      this.nNC.add(localObject2);
      localObject2 = paramd.mAppId;
      localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.p(AppBrandLocalMediaObjectManager.bIr() + (String)localObject2 + "/", (String)localObject2, "wxfile://");
      ((com.tencent.mm.plugin.appbrand.appstorage.p)localObject2).nMQ = (paramd1.cxy * 1048576L);
      ab localab1 = dB(com.tencent.mm.b.p.getString(paramd.Sk().uin), paramd.mAppId);
      localab1.nNJ = (paramd1.cxy * 1048576L);
      ab localab2 = dC(com.tencent.mm.b.p.getString(paramd.Sk().uin), paramd.mAppId);
      localab2.nNJ = (paramd1.nXu * 1048576L);
      this.nNC.add(localab2);
      localab2 = dD(com.tencent.mm.b.p.getString(paramd.Sk().uin), paramd.mAppId);
      localab2.nNJ = 9223372036854775807L;
      this.nNC.add(localab2);
      paramd = dE(com.tencent.mm.b.p.getString(paramd.Sk().uin), paramd.mAppId);
      paramd.nNJ = (paramd1.cxy * 1048576L);
      this.nNC.add(paramd);
      this.nNC.add(localab1);
      this.nNC.add(localObject2);
      this.nNC.add(localObject1);
      initialize();
      AppMethodBeat.o(147163);
      return;
    }
  }
  
  public static String bSa()
  {
    AppMethodBeat.i(293034);
    String str = AppBrandLocalMediaObjectManager.bIr();
    AppMethodBeat.o(293034);
    return str;
  }
  
  public static ab dB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147168);
    paramString1 = new ab(n(new String[] { paramString1, paramString2 }), "wxfile://usr");
    AppMethodBeat.o(147168);
    return paramString1;
  }
  
  public static ab dC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147169);
    paramString1 = new ab(n(new String[] { paramString1, paramString2, "opendata" }), "wxfile://opendata");
    AppMethodBeat.o(147169);
    return paramString1;
  }
  
  public static ab dD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147170);
    paramString1 = new ab(n(new String[] { paramString1, paramString2, "clientdata" }), "wxfile://clientdata");
    AppMethodBeat.o(147170);
    return paramString1;
  }
  
  public static ab dE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182990);
    paramString1 = new ab(n(new String[] { paramString1, paramString2, "singlePage" }), "wxfile://singlepage");
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
    if (!com.tencent.mm.compatible.util.e.avA()) {}
    for (paramVarArgs = null; paramVarArgs == null; paramVarArgs = new q(paramVarArgs + "wxanewfiles/"))
    {
      Log.e("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
      AppMethodBeat.o(147171);
      return null;
      localObject = com.tencent.mm.loader.j.b.aSL();
      paramVarArgs = (String[])localObject;
      if (!((String)localObject).endsWith("/")) {
        paramVarArgs = (String)localObject + "/";
      }
    }
    paramVarArgs = new q(paramVarArgs.getPath() + "/" + str).getPath();
    AppMethodBeat.o(147171);
    return paramVarArgs;
  }
  
  public m a(q paramq, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.ac.i<String> parami)
  {
    AppMethodBeat.i(169493);
    paramq = ((com.tencent.mm.plugin.appbrand.appstorage.p)ay(com.tencent.mm.plugin.appbrand.appstorage.p.class)).a(paramq, paramString, paramBoolean, parami);
    AppMethodBeat.o(169493);
    return paramq;
  }
  
  public final m a(String paramString, com.tencent.mm.plugin.appbrand.ac.i<List<k>> parami)
  {
    AppMethodBeat.i(147164);
    Object localObject = Uri.parse(paramString);
    if (("wxfile".equals(((Uri)localObject).getScheme())) && (Util.isNullOrNil(((Uri)localObject).getAuthority())))
    {
      paramString = new LinkedList();
      ((com.tencent.mm.plugin.appbrand.appstorage.p)ay(com.tencent.mm.plugin.appbrand.appstorage.p.class)).a("", parami);
      if (!Util.isNullOrNil((List)parami.value))
      {
        localObject = ((List)parami.value).iterator();
        while (((Iterator)localObject).hasNext())
        {
          k localk = (k)((Iterator)localObject).next();
          localk.fileName = localk.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
        }
      }
      com.tencent.luggage.k.b.c(paramString, (List)parami.value);
      ((ab)adY("wxfile://usr")).a("wxfile://usr", parami);
      com.tencent.luggage.k.b.c(paramString, (List)parami.value);
      parami.value = paramString;
      paramString = m.nMR;
      AppMethodBeat.o(147164);
      return paramString;
    }
    paramString = super.a(paramString, parami);
    AppMethodBeat.o(147164);
    return paramString;
  }
  
  public q adN(String paramString)
  {
    AppMethodBeat.i(147166);
    paramString = ((com.tencent.mm.plugin.appbrand.appstorage.p)ay(com.tencent.mm.plugin.appbrand.appstorage.p.class)).adN(paramString);
    AppMethodBeat.o(147166);
    return paramString;
  }
  
  public final List<aa> bIG()
  {
    AppMethodBeat.i(147167);
    List localList = ((com.tencent.mm.plugin.appbrand.appstorage.p)ay(com.tencent.mm.plugin.appbrand.appstorage.p.class)).nNk.bIL();
    AppMethodBeat.o(147167);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.av
 * JD-Core Version:    0.7.0.1
 */