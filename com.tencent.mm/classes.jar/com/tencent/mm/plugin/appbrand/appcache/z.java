package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class z
  implements q, Closeable
{
  final String appId;
  final WxaPkgWrappingInfo jJF;
  private final Map<String, WxaPkg> jJG;
  
  z(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(178521);
    this.jJG = new HashMap();
    this.appId = paramString;
    this.jJF = paramWxaPkgWrappingInfo;
    this.jJF.Mm(paramString);
    AppMethodBeat.o(178521);
  }
  
  private WxaPkg LT(String paramString)
  {
    AppMethodBeat.i(134677);
    for (;;)
    {
      synchronized (this.jJG)
      {
        WxaPkg localWxaPkg = (WxaPkg)this.jJG.get(paramString);
        if (localWxaPkg != null)
        {
          paramString = localWxaPkg;
          if (paramString != null) {
            paramString.aZO();
          }
          AppMethodBeat.o(134677);
          return paramString;
        }
        if ("__APP__".equals(paramString))
        {
          localObject = this.jJF.pkgPath;
          label70:
          if (!bu.isNullOrNil((String)localObject)) {
            break label148;
          }
          paramString = localWxaPkg;
        }
      }
      Object localObject = this.jJF.jLY.iterator();
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
            this.jJG.put(paramString, localObject);
            paramString = (String)localObject;
            break;
          }
        }
      }
      localObject = null;
    }
  }
  
  public final WxaPkg LK(String paramString)
  {
    AppMethodBeat.i(134674);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134674);
      return null;
    }
    paramString = n.MV(paramString);
    if (WxaPkgWrappingInfo.jLU != null)
    {
      paramString = WxaPkgWrappingInfo.jLU.b(this.jJF.jLY, paramString, String.format(Locale.ENGLISH, "findAppropriateModuleInfo with appId[%s]", new Object[] { this.appId }));
      if (paramString != null) {}
      for (paramString = paramString.name;; paramString = "__APP__")
      {
        paramString = LT(paramString);
        AppMethodBeat.o(134674);
        return paramString;
      }
    }
    Object localObject = this.jJF.jLY.iterator();
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
      if (!bu.isNullOrNil((String)localObject)) {
        break;
      }
      paramString = "__APP__";
      break;
    }
  }
  
  public final InputStream LL(String paramString)
  {
    AppMethodBeat.i(178524);
    WxaPkg localWxaPkg = LK(paramString);
    int i;
    int j;
    if ((paramString.startsWith("/__plugin__/")) && (localWxaPkg != null))
    {
      Object localObject = localWxaPkg.LI(paramString);
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
        if (!bu.isNullOrNil(str))
        {
          j = paramString.indexOf(str);
          i = str.length();
        }
      }
    }
    for (;;)
    {
      paramString = localWxaPkg.LI(paramString.substring(i + j));
      AppMethodBeat.o(178524);
      return paramString;
      i += 1;
      break;
      if (localWxaPkg == null)
      {
        AppMethodBeat.o(178524);
        return null;
      }
      paramString = localWxaPkg.LI(paramString);
      AppMethodBeat.o(178524);
      return paramString;
      label177:
      i = -1;
      j = -1;
    }
  }
  
  public final q.a LM(String paramString)
  {
    AppMethodBeat.i(178523);
    WxaPkg localWxaPkg = LK(paramString);
    if (localWxaPkg == null) {}
    for (paramString = null; paramString != null; paramString = localWxaPkg.openReadPartialInfo(paramString))
    {
      q.a locala = new q.a();
      locala.jIJ = this.appId;
      locala.aDD = this.jJF.pkgVersion();
      locala.jIK = this.jJF.checksumMd5();
      locala.jIL = localWxaPkg;
      locala.jIM = w.B(localWxaPkg.ggb.fTh());
      locala.fileName = paramString.fileName;
      locala.jIN = paramString.jIN;
      locala.jIO = paramString.jIO;
      AppMethodBeat.o(178523);
      return locala;
    }
    AppMethodBeat.o(178523);
    return null;
  }
  
  public final boolean LN(String paramString)
  {
    AppMethodBeat.i(178525);
    if (LM(paramString) != null)
    {
      AppMethodBeat.o(178525);
      return true;
    }
    AppMethodBeat.o(178525);
    return false;
  }
  
  public final List<WxaPkg.Info> bah()
  {
    AppMethodBeat.i(134675);
    Object localObject = LT("__APP__");
    if (localObject == null)
    {
      AppMethodBeat.o(134675);
      return null;
    }
    localObject = ((WxaPkg)localObject).baU();
    AppMethodBeat.o(134675);
    return localObject;
  }
  
  public final void bai()
  {
    AppMethodBeat.i(178526);
    this.jJF.Mm(this.appId);
    synchronized (this.jJG)
    {
      LT("__APP__");
      Iterator localIterator = this.jJF.jLY.iterator();
      if (localIterator.hasNext()) {
        LT(((ModulePkgInfo)localIterator.next()).name);
      }
    }
    AppMethodBeat.o(178526);
  }
  
  public final List<ModulePkgInfo> baj()
  {
    AppMethodBeat.i(178527);
    LinkedList localLinkedList = new LinkedList(this.jJF.jLY);
    AppMethodBeat.o(178527);
    return localLinkedList;
  }
  
  public final List<String> bak()
  {
    AppMethodBeat.i(207749);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.jJG)
    {
      Iterator localIterator = this.jJG.values().iterator();
      while (localIterator.hasNext())
      {
        WxaPkg localWxaPkg = (WxaPkg)localIterator.next();
        if (localWxaPkg != null) {
          localLinkedList.addAll(localWxaPkg.baV());
        }
      }
    }
    AppMethodBeat.o(207749);
    return localList;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134678);
    synchronized (this.jJG)
    {
      Collection localCollection = this.jJG.values();
      this.jJG.clear();
      ??? = localCollection.iterator();
      if (((Iterator)???).hasNext()) {
        ((WxaPkg)((Iterator)???).next()).close();
      }
    }
    AppMethodBeat.o(134678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.z
 * JD-Core Version:    0.7.0.1
 */