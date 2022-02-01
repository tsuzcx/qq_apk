package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Deprecated
final class aa
  implements q, Closeable
{
  final String appId;
  final WxaPkgWrappingInfo nFv;
  private final Map<String, WxaPkg> nFw;
  
  aa(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(178521);
    this.nFw = new HashMap();
    this.appId = paramString;
    this.nFv = paramWxaPkgWrappingInfo;
    this.nFv.adf(paramString);
    AppMethodBeat.o(178521);
  }
  
  private WxaPkg acM(String paramString)
  {
    AppMethodBeat.i(134677);
    for (;;)
    {
      synchronized (this.nFw)
      {
        WxaPkg localWxaPkg = (WxaPkg)this.nFw.get(paramString);
        if (localWxaPkg != null)
        {
          paramString = localWxaPkg;
          if (paramString != null) {
            paramString.bGl();
          }
          AppMethodBeat.o(134677);
          return paramString;
        }
        if ("__APP__".equals(paramString))
        {
          localObject = this.nFv.pkgPath;
          label70:
          if (!Util.isNullOrNil((String)localObject)) {
            break label148;
          }
          paramString = localWxaPkg;
        }
      }
      Object localObject = this.nFv.nIb.iterator();
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
            this.nFw.put(paramString, localObject);
            paramString = (String)localObject;
            break;
          }
        }
      }
      localObject = null;
    }
  }
  
  public final WxaPkg acD(String paramString)
  {
    AppMethodBeat.i(134674);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134674);
      return null;
    }
    paramString = o.adS(paramString);
    if (WxaPkgWrappingInfo.nHX != null)
    {
      paramString = WxaPkgWrappingInfo.nHX.b(this.nFv.nIb, paramString, String.format(Locale.ENGLISH, "findAppropriateModuleInfo with appId[%s]", new Object[] { this.appId }));
      if (paramString != null) {}
      for (paramString = paramString.name;; paramString = "__APP__")
      {
        paramString = acM(paramString);
        AppMethodBeat.o(134674);
        return paramString;
      }
    }
    Object localObject = this.nFv.nIb.iterator();
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
      if (!Util.isNullOrNil((String)localObject)) {
        break;
      }
      paramString = "__APP__";
      break;
    }
  }
  
  public final InputStream acE(String paramString)
  {
    AppMethodBeat.i(178524);
    WxaPkg localWxaPkg = acD(paramString);
    int i;
    int j;
    if ((paramString.startsWith("/__plugin__/")) && (localWxaPkg != null))
    {
      Object localObject = localWxaPkg.acB(paramString);
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
        if (!Util.isNullOrNil(str))
        {
          j = paramString.indexOf(str);
          i = str.length();
        }
      }
    }
    for (;;)
    {
      paramString = localWxaPkg.acB(paramString.substring(i + j));
      AppMethodBeat.o(178524);
      return paramString;
      i += 1;
      break;
      if (localWxaPkg == null)
      {
        AppMethodBeat.o(178524);
        return null;
      }
      paramString = localWxaPkg.acB(paramString);
      AppMethodBeat.o(178524);
      return paramString;
      label177:
      i = -1;
      j = -1;
    }
  }
  
  public final q.a acF(String paramString)
  {
    AppMethodBeat.i(178523);
    WxaPkg localWxaPkg = acD(paramString);
    if (localWxaPkg == null) {}
    for (paramString = null; paramString != null; paramString = localWxaPkg.openReadPartialInfo(paramString))
    {
      q.a locala = new q.a();
      locala.nEu = this.appId;
      locala.appVersion = this.nFv.pkgVersion();
      locala.nEv = this.nFv.checksumMd5();
      locala.nEw = localWxaPkg;
      locala.nEx = localWxaPkg.mFile.bOF();
      locala.fileName = paramString.fileName;
      locala.nEy = paramString.nEy;
      locala.nEz = paramString.nEz;
      AppMethodBeat.o(178523);
      return locala;
    }
    AppMethodBeat.o(178523);
    return null;
  }
  
  public final boolean acG(String paramString)
  {
    AppMethodBeat.i(178525);
    if (acF(paramString) != null)
    {
      AppMethodBeat.o(178525);
      return true;
    }
    AppMethodBeat.o(178525);
    return false;
  }
  
  public final void bGF()
  {
    AppMethodBeat.i(178526);
    this.nFv.adf(this.appId);
    synchronized (this.nFw)
    {
      acM("__APP__");
      Iterator localIterator = this.nFv.nIb.iterator();
      if (localIterator.hasNext()) {
        acM(((ModulePkgInfo)localIterator.next()).name);
      }
    }
    AppMethodBeat.o(178526);
  }
  
  public final List<ModulePkgInfo> bGG()
  {
    AppMethodBeat.i(178527);
    LinkedList localLinkedList = new LinkedList(this.nFv.nIb);
    AppMethodBeat.o(178527);
    return localLinkedList;
  }
  
  public final List<String> bGH()
  {
    AppMethodBeat.i(243114);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.nFw)
    {
      Iterator localIterator = this.nFw.values().iterator();
      while (localIterator.hasNext())
      {
        WxaPkg localWxaPkg = (WxaPkg)localIterator.next();
        if (localWxaPkg != null) {
          localLinkedList.addAll(localWxaPkg.bHq());
        }
      }
    }
    AppMethodBeat.o(243114);
    return localList;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134678);
    synchronized (this.nFw)
    {
      Collection localCollection = this.nFw.values();
      this.nFw.clear();
      ??? = localCollection.iterator();
      if (((Iterator)???).hasNext()) {
        ((WxaPkg)((Iterator)???).next()).close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aa
 * JD-Core Version:    0.7.0.1
 */