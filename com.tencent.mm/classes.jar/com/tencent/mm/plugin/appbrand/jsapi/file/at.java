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
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.w;
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
    j.vN("appbrandcommon");
    AppMethodBeat.o(147172);
  }
  
  public at(final com.tencent.luggage.sdk.d.d paramd, d paramd1)
  {
    super(new LinkedList());
    AppMethodBeat.i(147163);
    if (bn.N(paramd) != null) {}
    for (Object localObject1 = new bb(bg.M(paramd));; localObject1 = bc.K(paramd))
    {
      this.jQv.clear();
      Object localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.i(AppBrandLocalMediaObjectManager.bbX() + paramd.mAppId + "/blobTmp/", paramd.mAppId, "wxblob://", new i.a()
      {
        public final c bcc()
        {
          AppMethodBeat.i(220795);
          r localr = paramd.Ey();
          AppMethodBeat.o(220795);
          return localr;
        }
      });
      ((com.tencent.mm.plugin.appbrand.appstorage.i)localObject2).jPL = (paramd1.cmV * 1048576L);
      this.jQv.add(localObject2);
      localObject2 = new o(AppBrandLocalMediaObjectManager.bbX() + paramd.mAppId + "/", paramd.mAppId, "wxfile://");
      ((o)localObject2).jPL = (paramd1.cmV * 1048576L);
      z localz1 = dd(p.getString(paramd.Fg().uin), paramd.mAppId);
      localz1.jQA = (paramd1.cmV * 1048576L);
      z localz2 = de(p.getString(paramd.Fg().uin), paramd.mAppId);
      localz2.jQA = (paramd1.kai * 1048576L);
      this.jQv.add(localz2);
      localz2 = dg(p.getString(paramd.Fg().uin), paramd.mAppId);
      localz2.jQA = 9223372036854775807L;
      this.jQv.add(localz2);
      paramd = dh(p.getString(paramd.Fg().uin), paramd.mAppId);
      paramd.jQA = (paramd1.cmV * 1048576L);
      this.jQv.add(paramd);
      this.jQv.add(localz1);
      this.jQv.add(localObject2);
      this.jQv.add(localObject1);
      initialize();
      AppMethodBeat.o(147163);
      return;
    }
  }
  
  public static String bkQ()
  {
    AppMethodBeat.i(224455);
    String str = AppBrandLocalMediaObjectManager.bbX();
    AppMethodBeat.o(224455);
    return str;
  }
  
  public static z dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147168);
    paramString1 = new z(m(new String[] { paramString1, paramString2 }), "wxfile://usr");
    AppMethodBeat.o(147168);
    return paramString1;
  }
  
  public static z de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147169);
    paramString1 = new z(m(new String[] { paramString1, paramString2, "opendata" }), "wxfile://opendata");
    AppMethodBeat.o(147169);
    return paramString1;
  }
  
  public static z dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147170);
    paramString1 = new z(m(new String[] { paramString1, paramString2, "clientdata" }), "wxfile://clientdata");
    AppMethodBeat.o(147170);
    return paramString1;
  }
  
  public static z dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(182990);
    paramString1 = new z(m(new String[] { paramString1, paramString2, "singlePage" }), "wxfile://singlepage");
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
      ((StringBuilder)localObject).append(bu.nullAsNil(paramVarArgs[i])).append(';');
      i += 1;
    }
    String str = g.getMessageDigest(((StringBuilder)localObject).toString().getBytes());
    if (!e.abo()) {}
    for (paramVarArgs = null; paramVarArgs == null; paramVarArgs = new com.tencent.mm.vfs.k(paramVarArgs + "wxanewfiles/"))
    {
      ae.e("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
      AppMethodBeat.o(147171);
      return null;
      localObject = com.tencent.mm.loader.j.b.asj();
      paramVarArgs = (String[])localObject;
      if (!((String)localObject).endsWith("/")) {
        paramVarArgs = (String)localObject + "/";
      }
    }
    paramVarArgs = w.B(new com.tencent.mm.vfs.k(w.B(paramVarArgs.mUri) + "/" + str).mUri);
    AppMethodBeat.o(147171);
    return paramVarArgs;
  }
  
  public final com.tencent.mm.vfs.k MR(String paramString)
  {
    AppMethodBeat.i(147166);
    paramString = ((o)av(o.class)).MR(paramString);
    AppMethodBeat.o(147166);
    return paramString;
  }
  
  public m a(com.tencent.mm.vfs.k paramk, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.y.i<String> parami)
  {
    AppMethodBeat.i(169493);
    paramk = ((o)av(o.class)).a(paramk, paramString, paramBoolean, parami);
    AppMethodBeat.o(169493);
    return paramk;
  }
  
  public final m a(String paramString, com.tencent.mm.plugin.appbrand.y.i<List<com.tencent.mm.plugin.appbrand.appstorage.k>> parami)
  {
    AppMethodBeat.i(147164);
    Object localObject = Uri.parse(paramString);
    if (("wxfile".equals(((Uri)localObject).getScheme())) && (bu.isNullOrNil(((Uri)localObject).getAuthority())))
    {
      paramString = new LinkedList();
      ((o)av(o.class)).a("", parami);
      if (!bu.ht((List)parami.value))
      {
        localObject = ((List)parami.value).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.appbrand.appstorage.k localk = (com.tencent.mm.plugin.appbrand.appstorage.k)((Iterator)localObject).next();
          localk.fileName = localk.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
        }
      }
      com.tencent.luggage.h.b.c(paramString, (List)parami.value);
      ((z)Na("wxfile://usr")).a("wxfile://usr", parami);
      com.tencent.luggage.h.b.c(paramString, (List)parami.value);
      parami.value = paramString;
      paramString = m.jPM;
      AppMethodBeat.o(147164);
      return paramString;
    }
    paramString = super.a(paramString, parami);
    AppMethodBeat.o(147164);
    return paramString;
  }
  
  public final List<y> bcd()
  {
    AppMethodBeat.i(147167);
    List localList = ((o)av(o.class)).jQe.bch();
    AppMethodBeat.o(147167);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.at
 * JD-Core Version:    0.7.0.1
 */