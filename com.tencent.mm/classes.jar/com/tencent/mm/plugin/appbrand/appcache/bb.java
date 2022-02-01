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
public final class bb
  implements InvocationHandler
{
  private final Map<String, Method> jIf;
  private final b jIg;
  
  private bb(q paramq)
  {
    AppMethodBeat.i(178543);
    this.jIf = new ConcurrentHashMap();
    this.jIg = new b(paramq, (byte)0);
    AppMethodBeat.o(178543);
  }
  
  public static IWxaFileSystemWithModularizing M(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134684);
    try
    {
      paramAppBrandRuntime = new bb(bf.O(paramAppBrandRuntime));
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
    Method localMethod2 = (Method)this.jIf.get(str);
    Method localMethod1 = localMethod2;
    if (localMethod2 == null)
    {
      paramMethod = z.class.getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
      localMethod1 = paramMethod;
      if (paramMethod != null)
      {
        this.jIf.put(str, paramMethod);
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
        paramObject = b.a(this.jIg).Ll((String)paramArrayOfObject[0]);
        if (paramObject != null)
        {
          paramObject = paramObject.aZO();
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
      paramObject = this.jIg.LA((String)paramArrayOfObject[0]);
      if (paramObject == null)
      {
        ad.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), get NULL targetFS", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject) });
        paramObject = a(paramMethod, l.jMB);
        AppMethodBeat.o(134685);
        return paramObject;
      }
      if (paramMethod.getReturnType().equals(WxaPkg.class))
      {
        paramObject = paramObject.jHm;
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
      paramObject = this.jIg.baH();
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
    paramObject = a(paramMethod, l.jMz);
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
    private final q jIh;
    private final Map<WxaPkg, z> jIi;
    
    private b(q paramq)
    {
      AppMethodBeat.i(178541);
      this.jIi = new HashMap();
      this.jIh = paramq;
      AppMethodBeat.o(178541);
    }
    
    final z LA(String paramString)
    {
      AppMethodBeat.i(134682);
      if (this.jIh == null)
      {
        AppMethodBeat.o(134682);
        return null;
      }
      WxaPkg localWxaPkg = this.jIh.Lj(paramString);
      if (localWxaPkg == null)
      {
        AppMethodBeat.o(134682);
        return null;
      }
      synchronized (this.jIi)
      {
        Object localObject = (z)this.jIi.get(localWxaPkg);
        paramString = (String)localObject;
        if (localObject == null)
        {
          localObject = this.jIi;
          paramString = new z(localWxaPkg);
          ((Map)localObject).put(localWxaPkg, paramString);
        }
        AppMethodBeat.o(134682);
        return paramString;
      }
    }
    
    final Collection<z> baH()
    {
      AppMethodBeat.i(134681);
      synchronized (this.jIi)
      {
        Collection localCollection = this.jIi.values();
        AppMethodBeat.o(134681);
        return localCollection;
      }
    }
    
    public final void close()
    {
      AppMethodBeat.i(134683);
      synchronized (this.jIi)
      {
        this.jIi.clear();
        if (this.jIh != null) {
          this.jIh.close();
        }
        AppMethodBeat.o(134683);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bb
 * JD-Core Version:    0.7.0.1
 */