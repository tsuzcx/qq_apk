package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.ad;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class bf
  implements InvocationHandler
{
  private final Map<String, Method> nGZ;
  private final b nHa;
  
  private bf(q paramq)
  {
    AppMethodBeat.i(178543);
    this.nGZ = new ConcurrentHashMap();
    this.nHa = new b(paramq, (byte)0);
    AppMethodBeat.o(178543);
  }
  
  public static IWxaFileSystemWithModularizing L(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134684);
    try
    {
      paramAppBrandRuntime = new bf(bl.N(paramAppBrandRuntime));
      paramAppBrandRuntime = (IWxaFileSystemWithModularizing)Proxy.newProxyInstance(IWxaFileSystemWithModularizing.class.getClassLoader(), new Class[] { IWxaFileSystemWithModularizing.class }, paramAppBrandRuntime);
      AppMethodBeat.o(134684);
      return paramAppBrandRuntime;
    }
    catch (Exception paramAppBrandRuntime)
    {
      Log.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", new Object[] { paramAppBrandRuntime });
      paramAppBrandRuntime = new a((byte)0);
      AppMethodBeat.o(134684);
    }
    return paramAppBrandRuntime;
  }
  
  private static Object a(Method paramMethod, m paramm)
  {
    AppMethodBeat.i(178542);
    if (paramMethod.getReturnType().equals(m.class))
    {
      AppMethodBeat.o(178542);
      return paramm;
    }
    AppMethodBeat.o(178542);
    return null;
  }
  
  private Method a(Method paramMethod)
  {
    AppMethodBeat.i(134687);
    String str = paramMethod.toGenericString();
    Method localMethod2 = (Method)this.nGZ.get(str);
    Method localMethod1 = localMethod2;
    if (localMethod2 == null)
    {
      paramMethod = ad.class.getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
      localMethod1 = paramMethod;
      if (paramMethod != null)
      {
        this.nGZ.put(str, paramMethod);
        localMethod1 = paramMethod;
      }
    }
    AppMethodBeat.o(134687);
    return localMethod1;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(134685);
    if (paramMethod.getReturnType().equals(Boolean.TYPE))
    {
      paramObject = Boolean.TRUE;
      AppMethodBeat.o(134685);
      return paramObject;
    }
    if (Modifier.isStatic(paramMethod.getModifiers()))
    {
      AppMethodBeat.o(134685);
      return null;
    }
    if (paramMethod.getReturnType().equals(WxaPkg.Info.class)) {
      try
      {
        paramObject = b.a(this.nHa).acF((String)paramArrayOfObject[0]);
        if (paramObject != null)
        {
          paramObject = paramObject.bGI();
          AppMethodBeat.o(134685);
          return paramObject;
        }
        AppMethodBeat.o(134685);
        return null;
      }
      catch (Throwable paramObject)
      {
        Log.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), call openReadPartialInfo get exception(%s)", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject), paramObject });
        AppMethodBeat.o(134685);
        return null;
      }
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0) && ((paramArrayOfObject[0] instanceof String)))
    {
      paramObject = this.nHa.acW((String)paramArrayOfObject[0]);
      if (paramObject == null)
      {
        Log.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), get NULL targetFS", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject) });
        paramObject = a(paramMethod, m.nMX);
        AppMethodBeat.o(134685);
        return paramObject;
      }
      if (paramMethod.getReturnType().equals(WxaPkg.class))
      {
        paramObject = paramObject.nGd;
        AppMethodBeat.o(134685);
        return paramObject;
      }
      Method localMethod = a(paramMethod);
      if (localMethod != null)
      {
        paramObject = localMethod.invoke(paramObject, paramArrayOfObject);
        AppMethodBeat.o(134685);
        return paramObject;
      }
    }
    else if (paramMethod.getReturnType().equals(Void.TYPE))
    {
      paramObject = this.nHa.bHB();
      if (paramObject != null)
      {
        paramMethod = a(paramMethod);
        if (paramMethod != null)
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext()) {
            paramMethod.invoke((ad)paramObject.next(), paramArrayOfObject);
          }
        }
      }
      AppMethodBeat.o(134685);
      return null;
    }
    Log.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), fallback return access denied", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject) });
    paramObject = a(paramMethod, m.nMV);
    AppMethodBeat.o(134685);
    return paramObject;
  }
  
  static final class a
    extends j
    implements IWxaFileSystemWithModularizing
  {
    public final WxaPkg.Info openReadPartialInfo(String paramString)
    {
      return null;
    }
  }
  
  static final class b
    implements Closeable
  {
    private final q nHb;
    private final Map<WxaPkg, ad> nHc;
    
    private b(q paramq)
    {
      AppMethodBeat.i(178541);
      this.nHc = new HashMap();
      this.nHb = paramq;
      AppMethodBeat.o(178541);
    }
    
    final ad acW(String paramString)
    {
      AppMethodBeat.i(134682);
      if (this.nHb == null)
      {
        AppMethodBeat.o(134682);
        return null;
      }
      WxaPkg localWxaPkg = this.nHb.acD(paramString);
      if (localWxaPkg == null)
      {
        AppMethodBeat.o(134682);
        return null;
      }
      synchronized (this.nHc)
      {
        Object localObject = (ad)this.nHc.get(localWxaPkg);
        paramString = (String)localObject;
        if (localObject == null)
        {
          localObject = this.nHc;
          paramString = new ad(localWxaPkg);
          ((Map)localObject).put(localWxaPkg, paramString);
        }
        AppMethodBeat.o(134682);
        return paramString;
      }
    }
    
    final Collection<ad> bHB()
    {
      AppMethodBeat.i(134681);
      synchronized (this.nHc)
      {
        Collection localCollection = this.nHc.values();
        AppMethodBeat.o(134681);
        return localCollection;
      }
    }
    
    public final void close()
    {
      AppMethodBeat.i(134683);
      synchronized (this.nHc)
      {
        this.nHc.clear();
        if (this.nHb != null) {
          this.nHb.close();
        }
        AppMethodBeat.o(134683);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bf
 * JD-Core Version:    0.7.0.1
 */