package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
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
public final class bc
  implements InvocationHandler
{
  private final Map<String, Method> kNf;
  private final b kNg;
  
  private bc(q paramq)
  {
    AppMethodBeat.i(178543);
    this.kNf = new ConcurrentHashMap();
    this.kNg = new b(paramq, (byte)0);
    AppMethodBeat.o(178543);
  }
  
  public static IWxaFileSystemWithModularizing K(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134684);
    try
    {
      paramAppBrandRuntime = new bc(bg.M(paramAppBrandRuntime));
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
    Method localMethod2 = (Method)this.kNf.get(str);
    Method localMethod1 = localMethod2;
    if (localMethod2 == null)
    {
      paramMethod = ab.class.getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
      localMethod1 = paramMethod;
      if (paramMethod != null)
      {
        this.kNf.put(str, paramMethod);
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
        paramObject = b.a(this.kNg).UV((String)paramArrayOfObject[0]);
        if (paramObject != null)
        {
          paramObject = paramObject.bvB();
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
      paramObject = this.kNg.Vm((String)paramArrayOfObject[0]);
      if (paramObject == null)
      {
        Log.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), get NULL targetFS", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject) });
        paramObject = a(paramMethod, m.kSA);
        AppMethodBeat.o(134685);
        return paramObject;
      }
      if (paramMethod.getReturnType().equals(WxaPkg.class))
      {
        paramObject = paramObject.kMl;
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
      paramObject = this.kNg.bwu();
      if (paramObject != null)
      {
        paramMethod = a(paramMethod);
        if (paramMethod != null)
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext()) {
            paramMethod.invoke((ab)paramObject.next(), paramArrayOfObject);
          }
        }
      }
      AppMethodBeat.o(134685);
      return null;
    }
    Log.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), fallback return access denied", new Object[] { paramMethod.toGenericString(), Arrays.toString(paramArrayOfObject) });
    paramObject = a(paramMethod, m.kSy);
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
    private final q kNh;
    private final Map<WxaPkg, ab> kNi;
    
    private b(q paramq)
    {
      AppMethodBeat.i(178541);
      this.kNi = new HashMap();
      this.kNh = paramq;
      AppMethodBeat.o(178541);
    }
    
    final ab Vm(String paramString)
    {
      AppMethodBeat.i(134682);
      if (this.kNh == null)
      {
        AppMethodBeat.o(134682);
        return null;
      }
      WxaPkg localWxaPkg = this.kNh.UT(paramString);
      if (localWxaPkg == null)
      {
        AppMethodBeat.o(134682);
        return null;
      }
      synchronized (this.kNi)
      {
        Object localObject = (ab)this.kNi.get(localWxaPkg);
        paramString = (String)localObject;
        if (localObject == null)
        {
          localObject = this.kNi;
          paramString = new ab(localWxaPkg);
          ((Map)localObject).put(localWxaPkg, paramString);
        }
        AppMethodBeat.o(134682);
        return paramString;
      }
    }
    
    final Collection<ab> bwu()
    {
      AppMethodBeat.i(134681);
      synchronized (this.kNi)
      {
        Collection localCollection = this.kNi.values();
        AppMethodBeat.o(134681);
        return localCollection;
      }
    }
    
    public final void close()
    {
      AppMethodBeat.i(134683);
      synchronized (this.kNi)
      {
        this.kNi.clear();
        if (this.kNh != null) {
          this.kNh.close();
        }
        AppMethodBeat.o(134683);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bc
 * JD-Core Version:    0.7.0.1
 */