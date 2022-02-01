package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class y
  implements q, Closeable
{
  final String appId;
  final WxaPkgWrappingInfo jGF;
  private final Map<String, WxaPkg> jGG;
  
  y(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(178521);
    this.jGG = new HashMap();
    this.appId = paramString;
    this.jGF = paramWxaPkgWrappingInfo;
    this.jGF.LJ(paramString);
    AppMethodBeat.o(178521);
  }
  
  private WxaPkg Lq(String paramString)
  {
    AppMethodBeat.i(134677);
    for (;;)
    {
      synchronized (this.jGG)
      {
        WxaPkg localWxaPkg = (WxaPkg)this.jGG.get(paramString);
        if (localWxaPkg != null)
        {
          paramString = localWxaPkg;
          if (paramString != null) {
            paramString.aZr();
          }
          AppMethodBeat.o(134677);
          return paramString;
        }
        if ("__APP__".equals(paramString))
        {
          localObject = this.jGF.pkgPath;
          label70:
          if (!bt.isNullOrNil((String)localObject)) {
            break label148;
          }
          paramString = localWxaPkg;
        }
      }
      Object localObject = this.jGF.jIX.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject).next();
          if (paramString.equals(localModulePkgInfo.name))
          {
            localObject = localModulePkgInfo.pkgPath;
            break label70;
            label148:
            localObject = new WxaPkg((String)localObject);
            this.jGG.put(paramString, localObject);
            paramString = (String)localObject;
            break;
          }
        }
      }
      localObject = null;
    }
  }
  
  public final WxaPkg Lj(String paramString)
  {
    AppMethodBeat.i(134674);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134674);
      return null;
    }
    paramString = m.Mp(paramString);
    if (WxaPkgWrappingInfo.jIT != null)
    {
      paramString = WxaPkgWrappingInfo.jIT.b(this.jGF.jIX, paramString, String.format(Locale.ENGLISH, "findAppropriateModuleInfo with appId[%s]", new Object[] { this.appId }));
      if (paramString != null) {}
      for (paramString = paramString.name;; paramString = "__APP__")
      {
        paramString = Lq(paramString);
        AppMethodBeat.o(134674);
        return paramString;
      }
    }
    Object localObject = this.jGF.jIX.iterator();
    ModulePkgInfo localModulePkgInfo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject).next();
    } while (!paramString.startsWith(localModulePkgInfo.name));
    for (localObject = localModulePkgInfo.name;; localObject = null)
    {
      paramString = (String)localObject;
      if (!bt.isNullOrNil((String)localObject)) {
        break;
      }
      paramString = "__APP__";
      break;
    }
  }
  
  public final InputStream Lk(String paramString)
  {
    AppMethodBeat.i(178524);
    WxaPkg localWxaPkg = Lj(paramString);
    int i;
    int j;
    if ((paramString.startsWith("/__plugin__/")) && (localWxaPkg != null))
    {
      Object localObject = localWxaPkg.Lh(paramString);
      if (localObject != null)
      {
        AppMethodBeat.o(178524);
        return localObject;
      }
      localObject = "/__plugin__/".substring(1, 11);
      String[] arrayOfString = paramString.split("/");
      i = 0;
      if (i >= arrayOfString.length) {
        break label177;
      }
      if ((arrayOfString[i].equalsIgnoreCase((String)localObject)) && (i + 1 < arrayOfString.length))
      {
        String str = arrayOfString[(i + 1)];
        if (!bt.isNullOrNil(str))
        {
          j = paramString.indexOf(str);
          i = str.length();
        }
      }
    }
    for (;;)
    {
      paramString = localWxaPkg.Lh(paramString.substring(i + j));
      AppMethodBeat.o(178524);
      return paramString;
      i += 1;
      break;
      if (localWxaPkg == null)
      {
        AppMethodBeat.o(178524);
        return null;
      }
      paramString = localWxaPkg.Lh(paramString);
      AppMethodBeat.o(178524);
      return paramString;
      label177:
      i = -1;
      j = -1;
    }
  }
  
  public final q.a Ll(String paramString)
  {
    AppMethodBeat.i(178523);
    WxaPkg localWxaPkg = Lj(paramString);
    if (localWxaPkg == null) {}
    for (paramString = null; paramString != null; paramString = localWxaPkg.openReadPartialInfo(paramString))
    {
      q.a locala = new q.a();
      locala.jFK = this.appId;
      locala.aDD = this.jGF.pkgVersion();
      locala.jFL = this.jGF.checksumMd5();
      locala.jFM = localWxaPkg;
      locala.jFN = com.tencent.mm.vfs.q.B(localWxaPkg.gdT.fOK());
      locala.fileName = paramString.fileName;
      locala.jFO = paramString.jFO;
      locala.jFP = paramString.jFP;
      AppMethodBeat.o(178523);
      return locala;
    }
    AppMethodBeat.o(178523);
    return null;
  }
  
  public final boolean Lm(String paramString)
  {
    AppMethodBeat.i(178525);
    if (Ll(paramString) != null)
    {
      AppMethodBeat.o(178525);
      return true;
    }
    AppMethodBeat.o(178525);
    return false;
  }
  
  public final List<WxaPkg.Info> aZK()
  {
    AppMethodBeat.i(134675);
    Object localObject = Lq("__APP__");
    if (localObject == null)
    {
      AppMethodBeat.o(134675);
      return null;
    }
    localObject = ((WxaPkg)localObject).bav();
    AppMethodBeat.o(134675);
    return localObject;
  }
  
  public final void aZL()
  {
    AppMethodBeat.i(178526);
    this.jGF.LJ(this.appId);
    synchronized (this.jGG)
    {
      Lq("__APP__");
      Iterator localIterator = this.jGF.jIX.iterator();
      if (localIterator.hasNext()) {
        Lq(((ModulePkgInfo)localIterator.next()).name);
      }
    }
    AppMethodBeat.o(178526);
  }
  
  public final List<ModulePkgInfo> aZM()
  {
    AppMethodBeat.i(178527);
    LinkedList localLinkedList = new LinkedList(this.jGF.jIX);
    AppMethodBeat.o(178527);
    return localLinkedList;
  }
  
  public final List<String> aZN()
  {
    AppMethodBeat.i(197269);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.jGG)
    {
      Iterator localIterator = this.jGG.values().iterator();
      while (localIterator.hasNext())
      {
        WxaPkg localWxaPkg = (WxaPkg)localIterator.next();
        if (localWxaPkg != null) {
          localLinkedList.addAll(localWxaPkg.baw());
        }
      }
    }
    AppMethodBeat.o(197269);
    return localList;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134678);
    synchronized (this.jGG)
    {
      Collection localCollection = this.jGG.values();
      this.jGG.clear();
      ??? = localCollection.iterator();
      if (((Iterator)???).hasNext()) {
        ((WxaPkg)((Iterator)???).next()).close();
      }
    }
    AppMethodBeat.o(134678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.y
 * JD-Core Version:    0.7.0.1
 */