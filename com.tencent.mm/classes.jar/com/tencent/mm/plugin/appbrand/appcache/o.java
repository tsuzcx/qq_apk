package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class o
  implements Closeable
{
  private final WxaPkgWrappingInfo fCJ;
  private final Map<String, ai> fCK = new HashMap();
  
  o(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    this.fCJ = paramWxaPkgWrappingInfo;
    this.fCJ.acs();
  }
  
  private ai qV(String paramString)
  {
    for (;;)
    {
      synchronized (this.fCK)
      {
        ai localai = (ai)this.fCK.get(paramString);
        if (localai != null)
        {
          paramString = localai;
          if (paramString != null) {
            paramString.abX();
          }
          return paramString;
        }
        if ("__APP__".equals(paramString))
        {
          localObject = this.fCJ.fCl;
          label60:
          if (!bk.bl((String)localObject)) {
            break label133;
          }
          paramString = localai;
        }
      }
      Object localObject = this.fCJ.fEQ.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject).next();
          if (paramString.equals(localModulePkgInfo.name))
          {
            localObject = localModulePkgInfo.fCl;
            break label60;
            label133:
            localObject = new ai((String)localObject);
            this.fCK.put(paramString, localObject);
            paramString = (String)localObject;
            break;
          }
        }
      }
      localObject = null;
    }
  }
  
  final void abK()
  {
    synchronized (this.fCK)
    {
      qV("__APP__");
      Iterator localIterator = this.fCJ.fEQ.iterator();
      if (localIterator.hasNext()) {
        qV(((ModulePkgInfo)localIterator.next()).name);
      }
    }
  }
  
  public final void close()
  {
    synchronized (this.fCK)
    {
      Collection localCollection = this.fCK.values();
      ??? = localCollection.iterator();
      if (((Iterator)???).hasNext()) {
        ((ai)((Iterator)???).next()).close();
      }
    }
  }
  
  final ai findAppropriateModuleInfo(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    paramString = i.rA(paramString);
    Object localObject = this.fCJ.fEQ.iterator();
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
      if (bk.bl(paramString)) {
        localObject = "__APP__";
      }
      return qV((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.o
 * JD-Core Version:    0.7.0.1
 */