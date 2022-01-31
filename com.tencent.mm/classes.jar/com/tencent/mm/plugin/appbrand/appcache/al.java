package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.y;
import java.io.Closeable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class al
  implements InvocationHandler
{
  private final Map<String, Method> fDX = new ConcurrentHashMap();
  private final b fDY;
  
  private al(o paramo)
  {
    this.fDY = new b(paramo, (byte)0);
  }
  
  private Method a(Method paramMethod)
  {
    Method localMethod2 = (Method)this.fDX.get(paramMethod.getName());
    Method localMethod1 = localMethod2;
    if (localMethod2 == null)
    {
      localMethod2 = s.class.getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
      localMethod1 = localMethod2;
      if (localMethod2 != null)
      {
        this.fDX.put(paramMethod.getName(), localMethod2);
        localMethod1 = localMethod2;
      }
    }
    return localMethod1;
  }
  
  public static IWxaFileSystemWithModularizing j(i parami)
  {
    try
    {
      parami = new al(aq.l(parami));
      parami = (IWxaFileSystemWithModularizing)Proxy.newProxyInstance(IWxaFileSystemWithModularizing.class.getClassLoader(), new Class[] { IWxaFileSystemWithModularizing.class }, parami);
      return parami;
    }
    catch (Exception parami)
    {
      y.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", new Object[] { parami });
    }
    return new al.a((byte)0);
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod.getReturnType().equals(Boolean.TYPE)) {
      return Boolean.TRUE;
    }
    if (Modifier.isStatic(paramMethod.getModifiers())) {
      return null;
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0) && ((paramArrayOfObject[0] instanceof String)))
    {
      paramObject = this.fDY.rd((String)paramArrayOfObject[0]);
      if (paramObject == null)
      {
        if (paramMethod.getReturnType().equals(h.class)) {
          return h.fGY;
        }
        return null;
      }
      if (paramMethod.getReturnType().equals(ai.class)) {
        return paramObject.fDd;
      }
      paramMethod = a(paramMethod);
      if (paramMethod != null) {
        return paramMethod.invoke(paramObject, paramArrayOfObject);
      }
    }
    else if (paramMethod.getReturnType().equals(Void.TYPE))
    {
      paramObject = this.fDY.acj();
      if (paramObject != null)
      {
        paramMethod = a(paramMethod);
        if (paramMethod != null)
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext()) {
            paramMethod.invoke((s)paramObject.next(), paramArrayOfObject);
          }
        }
      }
      return null;
    }
    return null;
  }
  
  private static final class b
    implements Closeable
  {
    private final o fDZ;
    private final Map<ai, s> fEa = new HashMap();
    
    private b(o paramo)
    {
      this.fDZ = paramo;
    }
    
    final Collection<s> acj()
    {
      synchronized (this.fEa)
      {
        Collection localCollection = this.fEa.values();
        return localCollection;
      }
    }
    
    public final void close()
    {
      synchronized (this.fEa)
      {
        this.fEa.clear();
        this.fDZ.close();
        return;
      }
    }
    
    final s rd(String paramString)
    {
      ai localai = this.fDZ.findAppropriateModuleInfo(paramString);
      if (localai == null) {
        return null;
      }
      synchronized (this.fEa)
      {
        Object localObject = (s)this.fEa.get(localai);
        paramString = (String)localObject;
        if (localObject == null)
        {
          localObject = this.fEa;
          paramString = new s(localai);
          ((Map)localObject).put(localai, paramString);
        }
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.al
 * JD-Core Version:    0.7.0.1
 */