package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class al
  extends m
{
  public al(n paramn, a parama)
  {
    super(paramn);
    this.fHm.clear();
    IWxaFileSystemWithModularizing localIWxaFileSystemWithModularizing = com.tencent.mm.plugin.appbrand.appcache.al.j(paramn);
    j localj = new j(aiR() + paramn.mAppId + "/", paramn.mAppId, "wxfile://");
    localj.fHl = parama.gqC;
    parama = bA(com.tencent.mm.a.o.getString(paramn.aac().uin), paramn.mAppId);
    if (paramn.aaa().fQf > 0L) {}
    for (long l = paramn.aaa().fQf;; l = 10L)
    {
      parama.fHr = (l * 1048576L);
      this.fHm.add(parama);
      this.fHm.add(localj);
      this.fHm.add(localIWxaFileSystemWithModularizing);
      initialize();
      return;
    }
  }
  
  public static String aiR()
  {
    String str2 = com.tencent.mm.loader.a.b.bkH;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    return str1 + "wxafiles/";
  }
  
  public static q bA(String paramString1, String paramString2)
  {
    return new q(j(new String[] { paramString1, paramString2 }), "wxfile://usr");
  }
  
  private static String j(String... paramVarArgs)
  {
    Object localObject = new StringBuilder(";");
    int i = 0;
    while (i < 2)
    {
      ((StringBuilder)localObject).append(bk.pm(paramVarArgs[i])).append(';');
      i += 1;
    }
    String str = g.o(((StringBuilder)localObject).toString().getBytes());
    if (!com.tencent.mm.compatible.util.f.zF()) {}
    for (paramVarArgs = null; paramVarArgs == null; paramVarArgs = new File(paramVarArgs + "wxanewfiles/"))
    {
      return null;
      localObject = com.tencent.mm.loader.a.b.bkH;
      paramVarArgs = (String[])localObject;
      if (!((String)localObject).endsWith("/")) {
        paramVarArgs = (String)localObject + "/";
      }
    }
    return new File(paramVarArgs.getPath() + "/" + str).getPath();
  }
  
  public final h a(File paramFile, String paramString, boolean paramBoolean, k<String> paramk)
  {
    return ((j)H(j.class)).a(paramFile, paramString, paramBoolean, paramk);
  }
  
  public final h a(String paramString, k<List<com.tencent.mm.plugin.appbrand.appstorage.f>> paramk)
  {
    Object localObject = Uri.parse(paramString);
    if ((((Uri)localObject).getScheme().equals("wxfile")) && (bk.bl(((Uri)localObject).getAuthority())))
    {
      paramString = new LinkedList();
      ((j)H(j.class)).a("", paramk);
      if (!bk.dk((List)paramk.value))
      {
        localObject = ((List)paramk.value).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.appbrand.appstorage.f localf = (com.tencent.mm.plugin.appbrand.appstorage.f)((Iterator)localObject).next();
          localf.fileName = localf.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
        }
      }
      com.tencent.luggage.j.b.c(paramString, (List)paramk.value);
      ((q)H(q.class)).a("wxfile://usr", paramk);
      com.tencent.luggage.j.b.c(paramString, (List)paramk.value);
      paramk.value = paramString;
      return h.fGU;
    }
    return super.a(paramString, paramk);
  }
  
  public final List<com.tencent.mm.plugin.appbrand.appstorage.o> acI()
  {
    return ((j)H(j.class)).fHk.listStoredFiles();
  }
  
  public final com.tencent.mm.vfs.b ry(String paramString)
  {
    return ((j)H(j.class)).ry(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.al
 * JD-Core Version:    0.7.0.1
 */