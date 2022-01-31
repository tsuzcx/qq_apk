package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class u
  implements Closeable
{
  private final WxaPkgWrappingInfo gVa;
  private final Map<String, ao> gVb;
  
  u(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(86796);
    this.gVb = new HashMap();
    this.gVa = paramWxaPkgWrappingInfo;
    this.gVa.awj();
    AppMethodBeat.o(86796);
  }
  
  private ao yr(String paramString)
  {
    AppMethodBeat.i(86799);
    for (;;)
    {
      synchronized (this.gVb)
      {
        ao localao = (ao)this.gVb.get(paramString);
        if (localao != null)
        {
          paramString = localao;
          if (paramString != null) {
            paramString.avO();
          }
          AppMethodBeat.o(86799);
          return paramString;
        }
        if ("__APP__".equals(paramString))
        {
          localObject = this.gVa.gUy;
          label70:
          if (!bo.isNullOrNil((String)localObject)) {
            break label148;
          }
          paramString = localao;
        }
      }
      Object localObject = this.gVa.gXi.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject).next();
          if (paramString.equals(localModulePkgInfo.name))
          {
            localObject = localModulePkgInfo.gUy;
            break label70;
            label148:
            localObject = new ao((String)localObject);
            this.gVb.put(paramString, localObject);
            paramString = (String)localObject;
            break;
          }
        }
      }
      localObject = null;
    }
  }
  
  final void avC()
  {
    AppMethodBeat.i(86798);
    synchronized (this.gVb)
    {
      yr("__APP__");
      Iterator localIterator = this.gVa.gXi.iterator();
      if (localIterator.hasNext()) {
        yr(((ModulePkgInfo)localIterator.next()).name);
      }
    }
    AppMethodBeat.o(86798);
  }
  
  public final void close()
  {
    AppMethodBeat.i(86800);
    synchronized (this.gVb)
    {
      Collection localCollection = this.gVb.values();
      ??? = localCollection.iterator();
      if (((Iterator)???).hasNext()) {
        ((ao)((Iterator)???).next()).close();
      }
    }
    AppMethodBeat.o(86800);
  }
  
  final ao findAppropriateModuleInfo(String paramString)
  {
    AppMethodBeat.i(86797);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(86797);
      return null;
    }
    paramString = k.zl(paramString);
    Object localObject = this.gVa.gXi.iterator();
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
      if (bo.isNullOrNil(paramString)) {
        localObject = "__APP__";
      }
      paramString = yr((String)localObject);
      AppMethodBeat.o(86797);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.u
 * JD-Core Version:    0.7.0.1
 */