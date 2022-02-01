package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.bs;
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

final class x
  implements q, Closeable
{
  final String appId;
  final WxaPkgWrappingInfo jmJ;
  private final Map<String, WxaPkg> jmK;
  
  x(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(178521);
    this.jmK = new HashMap();
    this.appId = paramString;
    this.jmJ = paramWxaPkgWrappingInfo;
    this.jmJ.Is(paramString);
    AppMethodBeat.o(178521);
  }
  
  private WxaPkg HY(String paramString)
  {
    AppMethodBeat.i(134677);
    for (;;)
    {
      synchronized (this.jmK)
      {
        WxaPkg localWxaPkg = (WxaPkg)this.jmK.get(paramString);
        if (localWxaPkg != null)
        {
          paramString = localWxaPkg;
          if (paramString != null) {
            paramString.aVW();
          }
          AppMethodBeat.o(134677);
          return paramString;
        }
        if ("__APP__".equals(paramString))
        {
          localObject = this.jmJ.pkgPath;
          label70:
          if (!bs.isNullOrNil((String)localObject)) {
            break label148;
          }
          paramString = localWxaPkg;
        }
      }
      Object localObject = this.jmJ.jpd.iterator();
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
            this.jmK.put(paramString, localObject);
            paramString = (String)localObject;
            break;
          }
        }
      }
      localObject = null;
    }
  }
  
  public final WxaPkg HR(String paramString)
  {
    AppMethodBeat.i(134674);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134674);
      return null;
    }
    paramString = m.IY(paramString);
    if (WxaPkgWrappingInfo.joZ != null)
    {
      paramString = WxaPkgWrappingInfo.joZ.b(this.jmJ.jpd, paramString, String.format(Locale.ENGLISH, "findAppropriateModuleInfo with appId[%s]", new Object[] { this.appId }));
      if (paramString != null) {}
      for (paramString = paramString.name;; paramString = "__APP__")
      {
        paramString = HY(paramString);
        AppMethodBeat.o(134674);
        return paramString;
      }
    }
    Object localObject = this.jmJ.jpd.iterator();
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
      if (!bs.isNullOrNil((String)localObject)) {
        break;
      }
      paramString = "__APP__";
      break;
    }
  }
  
  public final InputStream HS(String paramString)
  {
    AppMethodBeat.i(178524);
    WxaPkg localWxaPkg = HR(paramString);
    int i;
    int j;
    if ((paramString.startsWith("/__plugin__/")) && (localWxaPkg != null))
    {
      Object localObject = localWxaPkg.HP(paramString);
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
        if (!bs.isNullOrNil(str))
        {
          j = paramString.indexOf(str);
          i = str.length();
        }
      }
    }
    for (;;)
    {
      paramString = localWxaPkg.HP(paramString.substring(i + j));
      AppMethodBeat.o(178524);
      return paramString;
      i += 1;
      break;
      if (localWxaPkg == null)
      {
        AppMethodBeat.o(178524);
        return null;
      }
      paramString = localWxaPkg.HP(paramString);
      AppMethodBeat.o(178524);
      return paramString;
      label177:
      i = -1;
      j = -1;
    }
  }
  
  public final q.a HT(String paramString)
  {
    AppMethodBeat.i(178523);
    WxaPkg localWxaPkg = HR(paramString);
    if (localWxaPkg == null) {}
    for (paramString = null; paramString != null; paramString = localWxaPkg.openReadPartialInfo(paramString))
    {
      q.a locala = new q.a();
      locala.jlU = this.appId;
      locala.aBM = this.jmJ.pkgVersion();
      locala.jlV = this.jmJ.checksumMd5();
      locala.jlW = localWxaPkg;
      locala.jlX = com.tencent.mm.vfs.q.B(localWxaPkg.fKs.fxV());
      locala.fileName = paramString.fileName;
      locala.jlY = paramString.jlY;
      locala.jlZ = paramString.jlZ;
      AppMethodBeat.o(178523);
      return locala;
    }
    AppMethodBeat.o(178523);
    return null;
  }
  
  public final boolean HU(String paramString)
  {
    AppMethodBeat.i(178525);
    if (HT(paramString) != null)
    {
      AppMethodBeat.o(178525);
      return true;
    }
    AppMethodBeat.o(178525);
    return false;
  }
  
  public final List<WxaPkg.Info> aWp()
  {
    AppMethodBeat.i(134675);
    Object localObject = HY("__APP__");
    if (localObject == null)
    {
      AppMethodBeat.o(134675);
      return null;
    }
    localObject = ((WxaPkg)localObject).aWY();
    AppMethodBeat.o(134675);
    return localObject;
  }
  
  public final void aWq()
  {
    AppMethodBeat.i(178526);
    this.jmJ.Is(this.appId);
    synchronized (this.jmK)
    {
      HY("__APP__");
      Iterator localIterator = this.jmJ.jpd.iterator();
      if (localIterator.hasNext()) {
        HY(((ModulePkgInfo)localIterator.next()).name);
      }
    }
    AppMethodBeat.o(178526);
  }
  
  public final List<ModulePkgInfo> aWr()
  {
    AppMethodBeat.i(178527);
    LinkedList localLinkedList = new LinkedList(this.jmJ.jpd);
    AppMethodBeat.o(178527);
    return localLinkedList;
  }
  
  public final List<String> aWs()
  {
    AppMethodBeat.i(193378);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.jmK)
    {
      Iterator localIterator = this.jmK.values().iterator();
      while (localIterator.hasNext())
      {
        WxaPkg localWxaPkg = (WxaPkg)localIterator.next();
        if (localWxaPkg != null) {
          localLinkedList.addAll(new LinkedList(localWxaPkg.jlF.keySet()));
        }
      }
    }
    AppMethodBeat.o(193378);
    return localList;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134678);
    synchronized (this.jmK)
    {
      Collection localCollection = this.jmK.values();
      this.jmK.clear();
      ??? = localCollection.iterator();
      if (((Iterator)???).hasNext()) {
        ((WxaPkg)((Iterator)???).next()).close();
      }
    }
    AppMethodBeat.o(134678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.x
 * JD-Core Version:    0.7.0.1
 */