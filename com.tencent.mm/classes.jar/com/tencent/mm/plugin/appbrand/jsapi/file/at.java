package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.i.a;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class at
  extends v
{
  static
  {
    AppMethodBeat.i(147172);
    at.class.getClassLoader();
    j.Ed("appbrandcommon");
    AppMethodBeat.o(147172);
  }
  
  public at(final com.tencent.luggage.sdk.d.d paramd, d paramd1)
  {
    super(new LinkedList());
    AppMethodBeat.i(147163);
    if (bn.O(paramd) != null) {}
    for (Object localObject1 = new bb(bg.M(paramd));; localObject1 = bc.K(paramd))
    {
      this.kTe.clear();
      Object localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.i(AppBrandLocalMediaObjectManager.bxo() + paramd.mAppId + "/blobTmp/", paramd.mAppId, "wxblob://", new i.a()
      {
        public final f bxr()
        {
          AppMethodBeat.i(229902);
          s locals = paramd.NY();
          AppMethodBeat.o(229902);
          return locals;
        }
      });
      ((com.tencent.mm.plugin.appbrand.appstorage.i)localObject2).kSt = (paramd1.cyR * 1048576L);
      this.kTe.add(localObject2);
      localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.o(AppBrandLocalMediaObjectManager.bxo() + paramd.mAppId + "/", paramd.mAppId, "wxfile://");
      ((com.tencent.mm.plugin.appbrand.appstorage.o)localObject2).kSt = (paramd1.cyR * 1048576L);
      z localz1 = dt(p.getString(paramd.ON().uin), paramd.mAppId);
      localz1.kTk = (paramd1.cyR * 1048576L);
      z localz2 = du(p.getString(paramd.ON().uin), paramd.mAppId);
      localz2.kTk = (paramd1.ldl * 1048576L);
      this.kTe.add(localz2);
      localz2 = dv(p.getString(paramd.ON().uin), paramd.mAppId);
      localz2.kTk = 9223372036854775807L;
      this.kTe.add(localz2);
      paramd = dw(p.getString(paramd.ON().uin), paramd.mAppId);
      paramd.kTk = (paramd1.cyR * 1048576L);
      this.kTe.add(paramd);
      this.kTe.add(localz1);
      this.kTe.add(localObject2);
      this.kTe.add(localObject1);
      initialize();
      AppMethodBeat.o(147163);
      return;
    }
  }
  
  public static String bGo()
  {
    AppMethodBeat.i(258558);
    String str = AppBrandLocalMediaObjectManager.bxo();
    AppMethodBeat.o(258558);
    return str;
  }
  
  public static z dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147168);
    paramString1 = new z(o(new String[] { paramString1, paramString2 }), "wxfile://usr");
    AppMethodBeat.o(147168);
    return paramString1;
  }
  
  public static z du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147169);
    paramString1 = new z(o(new String[] { paramString1, paramString2, "opendata" }), "wxfile://opendata");
    AppMethodBeat.o(147169);
    return paramString1;
  }
  
  public static z dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147170);
    paramString1 = new z(o(new String[] { paramString1, paramString2, "clientdata" }), "wxfile://clientdata");
    AppMethodBeat.o(147170);
    return paramString1;
  }
  
  public static z dw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182990);
    paramString1 = new z(o(new String[] { paramString1, paramString2, "singlePage" }), "wxfile://singlepage");
    AppMethodBeat.o(182990);
    return paramString1;
  }
  
  public static String o(String... paramVarArgs)
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
    if (!e.apn()) {}
    for (paramVarArgs = null; paramVarArgs == null; paramVarArgs = new com.tencent.mm.vfs.o(paramVarArgs + "wxanewfiles/"))
    {
      Log.e("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
      AppMethodBeat.o(147171);
      return null;
      localObject = com.tencent.mm.loader.j.b.aKJ();
      paramVarArgs = (String[])localObject;
      if (!((String)localObject).endsWith("/")) {
        paramVarArgs = (String)localObject + "/";
      }
    }
    paramVarArgs = aa.z(new com.tencent.mm.vfs.o(aa.z(paramVarArgs.mUri) + "/" + str).mUri);
    AppMethodBeat.o(147171);
    return paramVarArgs;
  }
  
  public final com.tencent.mm.vfs.o Wa(String paramString)
  {
    AppMethodBeat.i(147166);
    paramString = ((com.tencent.mm.plugin.appbrand.appstorage.o)az(com.tencent.mm.plugin.appbrand.appstorage.o.class)).Wa(paramString);
    AppMethodBeat.o(147166);
    return paramString;
  }
  
  public m a(com.tencent.mm.vfs.o paramo, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.ac.i<String> parami)
  {
    AppMethodBeat.i(169493);
    paramo = ((com.tencent.mm.plugin.appbrand.appstorage.o)az(com.tencent.mm.plugin.appbrand.appstorage.o.class)).a(paramo, paramString, paramBoolean, parami);
    AppMethodBeat.o(169493);
    return paramo;
  }
  
  public final m a(String paramString, com.tencent.mm.plugin.appbrand.ac.i<List<k>> parami)
  {
    AppMethodBeat.i(147164);
    Object localObject = Uri.parse(paramString);
    if (("wxfile".equals(((Uri)localObject).getScheme())) && (Util.isNullOrNil(((Uri)localObject).getAuthority())))
    {
      paramString = new LinkedList();
      ((com.tencent.mm.plugin.appbrand.appstorage.o)az(com.tencent.mm.plugin.appbrand.appstorage.o.class)).a("", parami);
      if (!Util.isNullOrNil((List)parami.value))
      {
        localObject = ((List)parami.value).iterator();
        while (((Iterator)localObject).hasNext())
        {
          k localk = (k)((Iterator)localObject).next();
          localk.fileName = localk.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
        }
      }
      com.tencent.luggage.h.b.c(paramString, (List)parami.value);
      ((z)Wj("wxfile://usr")).a("wxfile://usr", parami);
      com.tencent.luggage.h.b.c(paramString, (List)parami.value);
      parami.value = paramString;
      paramString = m.kSu;
      AppMethodBeat.o(147164);
      return paramString;
    }
    paramString = super.a(paramString, parami);
    AppMethodBeat.o(147164);
    return paramString;
  }
  
  public final List<y> bxs()
  {
    AppMethodBeat.i(147167);
    List localList = ((com.tencent.mm.plugin.appbrand.appstorage.o)az(com.tencent.mm.plugin.appbrand.appstorage.o.class)).kSN.bxw();
    AppMethodBeat.o(147167);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.at
 * JD-Core Version:    0.7.0.1
 */