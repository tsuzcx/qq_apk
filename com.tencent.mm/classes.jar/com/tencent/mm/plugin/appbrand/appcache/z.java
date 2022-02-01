package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
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
final class z
  implements q, Closeable
{
  final String appId;
  final WxaPkgWrappingInfo kLC;
  private final Map<String, WxaPkg> kLD;
  
  z(String paramString, WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(178521);
    this.kLD = new HashMap();
    this.appId = paramString;
    this.kLC = paramWxaPkgWrappingInfo;
    this.kLC.Vv(paramString);
    AppMethodBeat.o(178521);
  }
  
  private WxaPkg Vc(String paramString)
  {
    AppMethodBeat.i(134677);
    for (;;)
    {
      synchronized (this.kLD)
      {
        WxaPkg localWxaPkg = (WxaPkg)this.kLD.get(paramString);
        if (localWxaPkg != null)
        {
          paramString = localWxaPkg;
          if (paramString != null) {
            paramString.bvf();
          }
          AppMethodBeat.o(134677);
          return paramString;
        }
        if ("__APP__".equals(paramString))
        {
          localObject = this.kLC.pkgPath;
          label70:
          if (!Util.isNullOrNil((String)localObject)) {
            break label148;
          }
          paramString = localWxaPkg;
        }
      }
      Object localObject = this.kLC.kNZ.iterator();
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
            this.kLD.put(paramString, localObject);
            paramString = (String)localObject;
            break;
          }
        }
      }
      localObject = null;
    }
  }
  
  public final WxaPkg UT(String paramString)
  {
    AppMethodBeat.i(134674);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134674);
      return null;
    }
    paramString = n.We(paramString);
    if (WxaPkgWrappingInfo.kNV != null)
    {
      paramString = WxaPkgWrappingInfo.kNV.b(this.kLC.kNZ, paramString, String.format(Locale.ENGLISH, "findAppropriateModuleInfo with appId[%s]", new Object[] { this.appId }));
      if (paramString != null) {}
      for (paramString = paramString.name;; paramString = "__APP__")
      {
        paramString = Vc(paramString);
        AppMethodBeat.o(134674);
        return paramString;
      }
    }
    Object localObject = this.kLC.kNZ.iterator();
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
  
  public final InputStream UU(String paramString)
  {
    AppMethodBeat.i(178524);
    WxaPkg localWxaPkg = UT(paramString);
    int i;
    int j;
    if ((paramString.startsWith("/__plugin__/")) && (localWxaPkg != null))
    {
      Object localObject = localWxaPkg.UR(paramString);
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
      paramString = localWxaPkg.UR(paramString.substring(i + j));
      AppMethodBeat.o(178524);
      return paramString;
      i += 1;
      break;
      if (localWxaPkg == null)
      {
        AppMethodBeat.o(178524);
        return null;
      }
      paramString = localWxaPkg.UR(paramString);
      AppMethodBeat.o(178524);
      return paramString;
      label177:
      i = -1;
      j = -1;
    }
  }
  
  public final q.a UV(String paramString)
  {
    AppMethodBeat.i(178523);
    WxaPkg localWxaPkg = UT(paramString);
    if (localWxaPkg == null) {}
    for (paramString = null; paramString != null; paramString = localWxaPkg.openReadPartialInfo(paramString))
    {
      q.a locala = new q.a();
      locala.kKF = this.appId;
      locala.appVersion = this.kLC.pkgVersion();
      locala.kKG = this.kLC.checksumMd5();
      locala.kKH = localWxaPkg;
      locala.kKI = aa.z(localWxaPkg.mFile.her());
      locala.fileName = paramString.fileName;
      locala.kKJ = paramString.kKJ;
      locala.kKK = paramString.kKK;
      AppMethodBeat.o(178523);
      return locala;
    }
    AppMethodBeat.o(178523);
    return null;
  }
  
  public final boolean UW(String paramString)
  {
    AppMethodBeat.i(178525);
    if (UV(paramString) != null)
    {
      AppMethodBeat.o(178525);
      return true;
    }
    AppMethodBeat.o(178525);
    return false;
  }
  
  public final List<String> bvA()
  {
    AppMethodBeat.i(219300);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.kLD)
    {
      Iterator localIterator = this.kLD.values().iterator();
      while (localIterator.hasNext())
      {
        WxaPkg localWxaPkg = (WxaPkg)localIterator.next();
        if (localWxaPkg != null) {
          localLinkedList.addAll(localWxaPkg.bwj());
        }
      }
    }
    AppMethodBeat.o(219300);
    return localList;
  }
  
  public final void bvy()
  {
    AppMethodBeat.i(178526);
    this.kLC.Vv(this.appId);
    synchronized (this.kLD)
    {
      Vc("__APP__");
      Iterator localIterator = this.kLC.kNZ.iterator();
      if (localIterator.hasNext()) {
        Vc(((ModulePkgInfo)localIterator.next()).name);
      }
    }
    AppMethodBeat.o(178526);
  }
  
  public final List<ModulePkgInfo> bvz()
  {
    AppMethodBeat.i(178527);
    LinkedList localLinkedList = new LinkedList(this.kLC.kNZ);
    AppMethodBeat.o(178527);
    return localLinkedList;
  }
  
  public final void close()
  {
    AppMethodBeat.i(134678);
    synchronized (this.kLD)
    {
      Collection localCollection = this.kLD.values();
      this.kLD.clear();
      ??? = localCollection.iterator();
      if (((Iterator)???).hasNext()) {
        ((WxaPkg)((Iterator)???).next()).close();
      }
    }
    AppMethodBeat.o(134678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.z
 * JD-Core Version:    0.7.0.1
 */