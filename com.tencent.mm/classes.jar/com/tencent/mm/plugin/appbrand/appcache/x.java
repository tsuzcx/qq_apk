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
import java.util.Map;

final class x
  implements q, Closeable
{
  final String appId;
  final WxaPkgWrappingInfo iMC;
  private final Map<String, WxaPkg> iMD;
  
  x(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(178521);
    this.iMD = new HashMap();
    this.appId = paramString;
    this.iMC = paramWxaPkgWrappingInfo;
    this.iMC.Ep(paramString);
    AppMethodBeat.o(178521);
  }
  
  private WxaPkg DV(String paramString)
  {
    AppMethodBeat.i(134677);
    for (;;)
    {
      synchronized (this.iMD)
      {
        WxaPkg localWxaPkg = (WxaPkg)this.iMD.get(paramString);
        if (localWxaPkg != null)
        {
          paramString = localWxaPkg;
          if (paramString != null) {
            paramString.aPe();
          }
          AppMethodBeat.o(134677);
          return paramString;
        }
        if ("__APP__".equals(paramString))
        {
          localObject = this.iMC.pkgPath;
          label70:
          if (!bt.isNullOrNil((String)localObject)) {
            break label148;
          }
          paramString = localWxaPkg;
        }
      }
      Object localObject = this.iMC.iOT.iterator();
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
            this.iMD.put(paramString, localObject);
            paramString = (String)localObject;
            break;
          }
        }
      }
      localObject = null;
    }
  }
  
  public final WxaPkg DO(String paramString)
  {
    AppMethodBeat.i(134674);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134674);
      return null;
    }
    paramString = m.EV(paramString);
    Object localObject = this.iMC.iOT.iterator();
    ModulePkgInfo localModulePkgInfo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject).next();
    } while (!paramString.startsWith(localModulePkgInfo.name));
    for (paramString = localModulePkgInfo.name;; paramString = null)
    {
      localObject = paramString;
      if (bt.isNullOrNil(paramString)) {
        localObject = "__APP__";
      }
      paramString = DV((String)localObject);
      AppMethodBeat.o(134674);
      return paramString;
    }
  }
  
  public final InputStream DP(String paramString)
  {
    AppMethodBeat.i(178524);
    WxaPkg localWxaPkg = DO(paramString);
    int i;
    int j;
    if ((paramString.startsWith("/__plugin__/")) && (localWxaPkg != null))
    {
      Object localObject = localWxaPkg.DM(paramString);
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
      paramString = localWxaPkg.DM(paramString.substring(i + j));
      AppMethodBeat.o(178524);
      return paramString;
      i += 1;
      break;
      if (localWxaPkg == null)
      {
        AppMethodBeat.o(178524);
        return null;
      }
      paramString = localWxaPkg.DM(paramString);
      AppMethodBeat.o(178524);
      return paramString;
      label177:
      i = -1;
      j = -1;
    }
  }
  
  public final q.a DQ(String paramString)
  {
    AppMethodBeat.i(178523);
    WxaPkg localWxaPkg = DO(paramString);
    if (localWxaPkg == null) {}
    for (paramString = null; paramString != null; paramString = localWxaPkg.openReadPartialInfo(paramString))
    {
      q.a locala = new q.a();
      locala.iLN = this.appId;
      locala.aAS = this.iMC.pkgVersion();
      locala.iLO = this.iMC.checksumMd5();
      locala.iLP = localWxaPkg;
      locala.iLQ = com.tencent.mm.vfs.q.B(localWxaPkg.fGL.fhU());
      locala.fileName = paramString.fileName;
      locala.iLR = paramString.iLR;
      locala.iLS = paramString.iLS;
      AppMethodBeat.o(178523);
      return locala;
    }
    AppMethodBeat.o(178523);
    return null;
  }
  
  public final boolean DR(String paramString)
  {
    AppMethodBeat.i(178525);
    if (DQ(paramString) != null)
    {
      AppMethodBeat.o(178525);
      return true;
    }
    AppMethodBeat.o(178525);
    return false;
  }
  
  public final List<String> aPA()
  {
    AppMethodBeat.i(194462);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.iMD)
    {
      Iterator localIterator = this.iMD.values().iterator();
      while (localIterator.hasNext())
      {
        WxaPkg localWxaPkg = (WxaPkg)localIterator.next();
        if (localWxaPkg != null) {
          localLinkedList.addAll(new LinkedList(localWxaPkg.iLy.keySet()));
        }
      }
    }
    AppMethodBeat.o(194462);
    return localList;
  }
  
  public final List<WxaPkg.Info> aPx()
  {
    AppMethodBeat.i(134675);
    Object localObject = DV("__APP__");
    if (localObject == null)
    {
      AppMethodBeat.o(134675);
      return null;
    }
    localObject = ((WxaPkg)localObject).aQg();
    AppMethodBeat.o(134675);
    return localObject;
  }
  
  public final void aPy()
  {
    AppMethodBeat.i(178526);
    this.iMC.Ep(this.appId);
    synchronized (this.iMD)
    {
      DV("__APP__");
      Iterator localIterator = this.iMC.iOT.iterator();
      if (localIterator.hasNext()) {
        DV(((ModulePkgInfo)localIterator.next()).name);
      }
    }
    AppMethodBeat.o(178526);
  }
  
  public final List<ModulePkgInfo> aPz()
  {
    AppMethodBeat.i(178527);
    LinkedList localLinkedList = new LinkedList(this.iMC.iOT);
    AppMethodBeat.o(178527);
    return localLinkedList;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134678);
    synchronized (this.iMD)
    {
      Collection localCollection = this.iMD.values();
      this.iMD.clear();
      ??? = localCollection.iterator();
      if (((Iterator)???).hasNext()) {
        ((WxaPkg)((Iterator)???).next()).close();
      }
    }
    AppMethodBeat.o(134678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.x
 * JD-Core Version:    0.7.0.1
 */