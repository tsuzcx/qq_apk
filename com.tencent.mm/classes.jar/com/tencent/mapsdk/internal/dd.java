package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetFileResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetHead;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetJceResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetJsonResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class dd<R extends ch.a>
  implements ch<R>
{
  public boolean a = false;
  public boolean b = true;
  public boolean c = true;
  private volatile R d;
  private Map<String, String> e;
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (gz.a(paramString)) {
      str = i();
    }
    if (!TextUtils.isEmpty(str))
    {
      paramString = j();
      if (!TextUtils.isEmpty(paramString)) {
        localStringBuilder.append(paramString).append("://");
      }
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private String b(a parama, Object... paramVarArgs)
  {
    Object localObject = parama.e;
    StringBuilder localStringBuilder = new StringBuilder();
    int j;
    if ((localObject != null) && (paramVarArgs != null) && (localObject.length <= paramVarArgs.length))
    {
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localStringBuilder.append(localObject[i]).append("=%s&");
        i += 1;
      }
    }
    localObject = parama.g;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("&");
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        String[] arrayOfString = localObject[i].split("=");
        if (arrayOfString.length == 2) {
          localStringBuilder.append(arrayOfString[0]).append("=").append(arrayOfString[1]).append("&");
        }
        i += 1;
      }
    }
    if ((parama.j) && (this.e != null) && (!this.e.isEmpty()))
    {
      parama = this.e.entrySet().iterator();
      while (parama.hasNext())
      {
        localObject = (Map.Entry)parama.next();
        localStringBuilder.append((String)((Map.Entry)localObject).getKey()).append("=").append((String)((Map.Entry)localObject).getValue()).append("&");
      }
    }
    int i = localStringBuilder.lastIndexOf("&");
    if ((i >= 0) && (i == localStringBuilder.length() - 1)) {
      localStringBuilder.deleteCharAt(i);
    }
    return String.format(localStringBuilder.toString(), paramVarArgs);
  }
  
  private String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = i();
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = j();
      if (!TextUtils.isEmpty(str2)) {
        localStringBuilder.append(str2).append("://");
      }
      localStringBuilder.append(str1);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private R l()
  {
    Object localObject = getClass().getGenericSuperclass();
    if ((localObject instanceof ParameterizedType))
    {
      localObject = ((ParameterizedType)localObject).getActualTypeArguments();
      if ((localObject.length > 0) && ((localObject[0] instanceof Class)))
      {
        localObject = (Class)localObject[0];
        ClassLoader localClassLoader = ((Class)localObject).getClassLoader();
        if (((Class)localObject).isInterface()) {}
        for (localObject = new Class[] { localObject };; localObject = ((Class)localObject).getInterfaces()) {
          return (ch.a)Proxy.newProxyInstance(localClassLoader, (Class[])localObject, new b(getClass()));
        }
      }
    }
    return null;
  }
  
  final NetResponse a(a parama, Object... paramVarArgs)
  {
    Object localObject1 = null;
    if (parama != null)
    {
      localObject1 = parama.c;
      label247:
      for (;;)
      {
        try
        {
          localObject2 = b(parama, paramVarArgs);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label247;
          }
          localObject1 = (String)localObject1 + "?" + (String)localObject2;
          parama.c = ((String)localObject1);
          kh.c("TS", parama.toString());
          switch (dd.1.a[parama.k.ordinal()])
          {
          case 1: 
            return NetManager.getInstance().builder().forceHttps(false).userAgent(parama.h).url((String)localObject1).retryNum(parama.i).header(parama.f).doGet();
          }
        }
        catch (Exception parama)
        {
          Object localObject2;
          int j;
          int i;
          return null;
        }
        if (paramVarArgs.length > 0)
        {
          j = paramVarArgs.length;
          i = 0;
          if (i < j)
          {
            localObject2 = paramVarArgs[i];
            if ((localObject2 instanceof byte[]))
            {
              paramVarArgs = (byte[])localObject2;
              parama = NetManager.getInstance().builder().userAgent(parama.h).forceHttps(false).url((String)localObject1).retryNum(parama.i).header(parama.f).postData(paramVarArgs).doPost();
              break;
            }
            i += 1;
            continue;
          }
        }
        paramVarArgs = new byte[0];
      }
      parama = null;
      localObject1 = parama;
    }
    return localObject1;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if (this.e != null)
    {
      this.e.putAll(paramMap);
      return;
    }
    this.e = paramMap;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final boolean c()
  {
    return this.a;
  }
  
  public final boolean d()
  {
    return this.c;
  }
  
  public String f()
  {
    return null;
  }
  
  public final String g()
  {
    return null;
  }
  
  public final R h()
  {
    if (this.d != null) {
      return this.d;
    }
    this.d = l();
    return this.d;
  }
  
  public final String i()
  {
    String str = e();
    if (this.a) {
      str = f();
    }
    return str;
  }
  
  public final String j()
  {
    String str = "http";
    if (this.b) {
      str = "https";
    }
    return str;
  }
  
  static final class a
  {
    String a;
    String b;
    String c;
    String d;
    String[] e;
    HashMap<String, String> f;
    String g;
    String h;
    int i;
    boolean j;
    NetMethod k;
    du l;
    int[] m;
    
    public final String toString()
    {
      AppMethodBeat.i(226196);
      String str = "RequestEntity{service='" + this.a + '\'' + ", request='" + this.b + '\'' + ", method=" + this.k + ", heads=" + this.f + ", authority=" + this.d + ", queryKeys=" + Arrays.toString(this.e) + ", constQuery='" + this.g + '\'' + ", useAgent='" + this.h + '\'' + ", resolver='" + this.l + '\'' + ", retry=" + this.i + ", useExtraQuery=" + this.j + "\nurl='" + this.c + '\'' + '}';
      AppMethodBeat.o(226196);
      return str;
    }
  }
  
  final class b
    implements InvocationHandler
  {
    private Class<? extends dd> b;
    
    b()
    {
      Object localObject;
      this.b = localObject;
    }
    
    private dd.a a(Method paramMethod)
    {
      AppMethodBeat.i(226205);
      dd.a locala = new dd.a((byte)0);
      Object localObject1 = (NetJceResolver)paramMethod.getAnnotation(NetJceResolver.class);
      Object localObject2 = (NetFileResolver)paramMethod.getAnnotation(NetFileResolver.class);
      Object localObject3 = (NetJsonResolver)paramMethod.getAnnotation(NetJsonResolver.class);
      NetRequest localNetRequest = (NetRequest)paramMethod.getAnnotation(NetRequest.class);
      if (localObject1 != null)
      {
        locala.l = new ds(((NetJceResolver)localObject1).inJce(), ((NetJceResolver)localObject1).outJce());
        locala.m = ((NetJceResolver)localObject1).queryRange();
      }
      while (localNetRequest != null)
      {
        locala.a = this.b.getSimpleName();
        locala.k = localNetRequest.method();
        locala.b = paramMethod.getName();
        locala.d = localNetRequest.authority();
        locala.h = localNetRequest.userAgent();
        locala.e = localNetRequest.queryKeys();
        locala.i = localNetRequest.retry();
        locala.j = localNetRequest.useExtraQuery();
        localObject1 = localNetRequest.head();
        paramMethod = ((NetHead)localObject1).keys();
        localObject1 = ((NetHead)localObject1).values();
        if ((paramMethod.length > 0) && (paramMethod.length == localObject1.length))
        {
          locala.f = new HashMap();
          int i = 0;
          for (;;)
          {
            if (i < paramMethod.length)
            {
              locala.f.put(paramMethod[i], localObject1[i]);
              i += 1;
              continue;
              if (localObject2 != null)
              {
                locala.l = new dr(((NetFileResolver)localObject2).outFile());
                locala.m = ((NetFileResolver)localObject2).queryRange();
                break;
              }
              if (localObject3 == null) {
                break;
              }
              locala.l = new dt(((NetJsonResolver)localObject3).outModel());
              locala.m = ((NetJsonResolver)localObject3).queryRange();
              break;
            }
          }
        }
        localObject2 = new StringBuilder();
        dd localdd = dd.this;
        localObject1 = locala.d;
        localObject3 = new StringBuilder();
        paramMethod = (Method)localObject1;
        if (gz.a((String)localObject1)) {
          paramMethod = localdd.i();
        }
        if (TextUtils.isEmpty(paramMethod)) {
          break label510;
        }
        localObject1 = localdd.j();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((StringBuilder)localObject3).append((String)localObject1).append("://");
        }
        ((StringBuilder)localObject3).append(paramMethod);
      }
      label510:
      for (paramMethod = ((StringBuilder)localObject3).toString();; paramMethod = null)
      {
        if (!TextUtils.isEmpty(paramMethod)) {
          ((StringBuilder)localObject2).append(paramMethod);
        }
        paramMethod = localNetRequest.path();
        if (paramMethod.length() != 0) {
          ((StringBuilder)localObject2).append("/").append(paramMethod);
        }
        locala.g = localNetRequest.constQuery();
        locala.c = ((StringBuilder)localObject2).toString();
        AppMethodBeat.o(226205);
        return locala;
      }
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(226222);
      dd.a locala = new dd.a((byte)0);
      paramObject = (NetJceResolver)paramMethod.getAnnotation(NetJceResolver.class);
      Object localObject1 = (NetFileResolver)paramMethod.getAnnotation(NetFileResolver.class);
      Object localObject2 = (NetJsonResolver)paramMethod.getAnnotation(NetJsonResolver.class);
      NetRequest localNetRequest = (NetRequest)paramMethod.getAnnotation(NetRequest.class);
      if (paramObject != null)
      {
        locala.l = new ds(paramObject.inJce(), paramObject.outJce());
        locala.m = paramObject.queryRange();
      }
      while (localNetRequest != null)
      {
        locala.a = this.b.getSimpleName();
        locala.k = localNetRequest.method();
        locala.b = paramMethod.getName();
        locala.d = localNetRequest.authority();
        locala.h = localNetRequest.userAgent();
        locala.e = localNetRequest.queryKeys();
        locala.i = localNetRequest.retry();
        locala.j = localNetRequest.useExtraQuery();
        paramMethod = localNetRequest.head();
        paramObject = paramMethod.keys();
        paramMethod = paramMethod.values();
        if ((paramObject.length > 0) && (paramObject.length == paramMethod.length))
        {
          locala.f = new HashMap();
          int i = 0;
          for (;;)
          {
            if (i < paramObject.length)
            {
              locala.f.put(paramObject[i], paramMethod[i]);
              i += 1;
              continue;
              if (localObject1 != null)
              {
                locala.l = new dr(((NetFileResolver)localObject1).outFile());
                locala.m = ((NetFileResolver)localObject1).queryRange();
                break;
              }
              if (localObject2 == null) {
                break;
              }
              locala.l = new dt(((NetJsonResolver)localObject2).outModel());
              locala.m = ((NetJsonResolver)localObject2).queryRange();
              break;
            }
          }
        }
        localObject1 = new StringBuilder();
        dd localdd = dd.this;
        paramMethod = locala.d;
        localObject2 = new StringBuilder();
        paramObject = paramMethod;
        if (gz.a(paramMethod)) {
          paramObject = localdd.i();
        }
        if (TextUtils.isEmpty(paramObject)) {
          break label569;
        }
        paramMethod = localdd.j();
        if (!TextUtils.isEmpty(paramMethod)) {
          ((StringBuilder)localObject2).append(paramMethod).append("://");
        }
        ((StringBuilder)localObject2).append(paramObject);
      }
      label569:
      for (paramObject = ((StringBuilder)localObject2).toString();; paramObject = null)
      {
        if (!TextUtils.isEmpty(paramObject)) {
          ((StringBuilder)localObject1).append(paramObject);
        }
        paramObject = localNetRequest.path();
        if (paramObject.length() != 0) {
          ((StringBuilder)localObject1).append("/").append(paramObject);
        }
        locala.g = localNetRequest.constQuery();
        locala.c = ((StringBuilder)localObject1).toString();
        if (dd.this.c) {
          break label581;
        }
        kh.d("TS", "The Service[" + this.b.getSimpleName() + "] is block!!  Please check the ServiceProtocol for corrected, or contact the Tencent MapSdk Office to enable it. ");
        if (locala.k != NetMethod.URL) {
          break;
        }
        AppMethodBeat.o(226222);
        return "";
      }
      AppMethodBeat.o(226222);
      return null;
      label581:
      if (locala.k == NetMethod.URL)
      {
        paramMethod = locala.c;
        paramArrayOfObject = dd.a(dd.this, locala, paramArrayOfObject);
        paramObject = paramMethod;
        if (paramArrayOfObject.length() != 0) {
          paramObject = paramMethod + "?" + paramArrayOfObject;
        }
        locala.c = paramObject;
        kh.c("TS", locala.toString());
        AppMethodBeat.o(226222);
        return paramObject;
      }
      if (locala.l != null)
      {
        paramObject = locala.l.a(locala.m, paramArrayOfObject);
        paramObject = locala.l.a(dd.this.a(locala, paramObject));
        AppMethodBeat.o(226222);
        return paramObject;
      }
      paramObject = dd.this.a(locala, paramArrayOfObject);
      AppMethodBeat.o(226222);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.dd
 * JD-Core Version:    0.7.0.1
 */