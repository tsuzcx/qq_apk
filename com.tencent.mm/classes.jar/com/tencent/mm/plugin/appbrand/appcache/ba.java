package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.sdk.platformtools.ad;
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
public final class ba
  implements InvocationHandler
{
  private final Map<String, Method> iOb;
  private final b iOc;
  
  private ba(q paramq)
  {
    AppMethodBeat.i(178543);
    this.iOb = new ConcurrentHashMap();
    this.iOc = new b(paramq, (byte)0);
    AppMethodBeat.o(178543);
  }
  
  public static IWxaFileSystemWithModularizing S(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134684);
    try
    {
      paramAppBrandRuntime = new ba(be.U(paramAppBrandRuntime));
      paramAppBrandRuntime = (IWxaFileSystemWithModularizing)Proxy.newProxyInstance(IWxaFileSystemWithModularizing.class.getClassLoader(), new Class[] { IWxaFileSystemWithModularizing.class }, paramAppBrandRuntime);
      AppMethodBeat.o(134684);
      return paramAppBrandRuntime;
    }
    catch (Exception paramAppBrandRuntime)
    {
      ad.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", new Object[] { paramAppBrandRuntime });
      paramAppBrandRuntime = new a((byte)0);
      AppMethodBeat.o(134684);
    }
    return paramAppBrandRuntime;
  }
  
  private static Object a(Method paramMethod, l paraml)
  {
    AppMethodBeat.i(178542);
    if (paramMethod.getReturnType().equals(l.class))
    {
      AppMethodBeat.o(178542);
      return paraml;
    }
    AppMethodBeat.o(178542);
    return null;
  }
  
  private Method a(Method paramMethod)
  {
    AppMethodBeat.i(134687);
    String str = paramMethod.toGenericString();
    Method localMethod2 = (Method)this.iOb.get(str);
    Method localMethod1 = localMethod2;
    if (localMethod2 == null)
    {
      paramMethod = z.class.getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
      localMethod1 = paramMethod;
      if (paramMethod != null)
      {
        this.iOb.put(str, paramMethod);
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
        paramObject = b.a(this.iOc).DQ((String)paramArrayOfObject[0]);
        if (paramObject != null)
        {
          paramObject = paramObject.aPB();
          AppMethodBeat.o(134685);
          return paramObject;
        }
        AppMethodBeat.o(134685);
        return null;
      }
      catch (Throwable paramObject)
      {
        ad.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), call openReadPartialInfo get exception(%s)", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject), paramObject });
        AppMethodBeat.o(134685);
        return null;
      }
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0) && ((paramArrayOfObject[0] instanceof String)))
    {
      paramObject = this.iOc.Ef((String)paramArrayOfObject[0]);
      if (paramObject == null)
      {
        ad.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), get NULL targetFS", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject) });
        paramObject = a(paramMethod, l.iSw);
        AppMethodBeat.o(134685);
        return paramObject;
      }
      if (paramMethod.getReturnType().equals(WxaPkg.class))
      {
        paramObject = paramObject.iNh;
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
      paramObject = this.iOc.aQr();
      if (paramObject != null)
      {
        paramMethod = a(paramMethod);
        if (paramMethod != null)
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext()) {
            paramMethod.invoke((z)paramObject.next(), paramArrayOfObject);
          }
        }
      }
      AppMethodBeat.o(134685);
      return null;
    }
    ad.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), fallback return access denied", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject) });
    paramObject = a(paramMethod, l.iSu);
    AppMethodBeat.o(134685);
    return paramObject;
  }
  
  static final class a
    extends i
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
    private final q iOd;
    private final Map<WxaPkg, z> iOe;
    
    private b(q paramq)
    {
      AppMethodBeat.i(178541);
      this.iOe = new HashMap();
      this.iOd = paramq;
      AppMethodBeat.o(178541);
    }
    
    final z Ef(String paramString)
    {
      AppMethodBeat.i(134682);
      if (this.iOd == null)
      {
        AppMethodBeat.o(134682);
        return null;
      }
      WxaPkg localWxaPkg = this.iOd.DO(paramString);
      if (localWxaPkg == null)
      {
        AppMethodBeat.o(134682);
        return null;
      }
      synchronized (this.iOe)
      {
        Object localObject = (z)this.iOe.get(localWxaPkg);
        paramString = (String)localObject;
        if (localObject == null)
        {
          localObject = this.iOe;
          paramString = new z(localWxaPkg);
          ((Map)localObject).put(localWxaPkg, paramString);
        }
        AppMethodBeat.o(134682);
        return paramString;
      }
    }
    
    final Collection<z> aQr()
    {
      AppMethodBeat.i(134681);
      synchronized (this.iOe)
      {
        Collection localCollection = this.iOe.values();
        AppMethodBeat.o(134681);
        return localCollection;
      }
    }
    
    public final void close()
    {
      AppMethodBeat.i(134683);
      synchronized (this.iOe)
      {
        this.iOe.clear();
        if (this.iOd != null) {
          this.iOd.close();
        }
        AppMethodBeat.o(134683);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ba
 * JD-Core Version:    0.7.0.1
 */