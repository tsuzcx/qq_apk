package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ji
{
  kw a;
  private ConcurrentHashMap<String, Map<String, jg>> b;
  
  public ji()
  {
    AppMethodBeat.i(223460);
    this.a = new kw();
    this.b = new ConcurrentHashMap();
    AppMethodBeat.o(223460);
  }
  
  private String a(String paramString)
  {
    AppMethodBeat.i(223470);
    paramString = this.a.a(paramString);
    AppMethodBeat.o(223470);
    return paramString;
  }
  
  final <D extends jh, C extends jg<D>> C a(Class<D> paramClass, jg.a parama, Class<C> paramClass1)
  {
    AppMethodBeat.i(223482);
    Map localMap = (Map)this.b.get(paramClass1.getName());
    String str1 = jk.a(paramClass.getName() + parama.toString());
    String str2 = paramClass1.getName();
    if (localMap != null)
    {
      paramClass = (jg)localMap.get(str1);
      if (paramClass != null)
      {
        AppMethodBeat.o(223482);
        return paramClass;
      }
    }
    for (;;)
    {
      Constructor[] arrayOfConstructor = paramClass1.getDeclaredConstructors();
      paramClass1 = null;
      int j = arrayOfConstructor.length;
      int i = 0;
      if (i < j)
      {
        Constructor localConstructor = arrayOfConstructor[i];
        Class[] arrayOfClass = localConstructor.getParameterTypes();
        if ((arrayOfClass.length != 1) || (arrayOfClass[0] != parama.getClass())) {
          break label234;
        }
        paramClass1 = localConstructor;
      }
      label234:
      for (;;)
      {
        i += 1;
        break;
        if (paramClass1 != null) {}
        for (;;)
        {
          try
          {
            parama = (jg)paramClass1.newInstance(new Object[] { parama });
            paramClass = parama;
          }
          catch (IllegalAccessException parama)
          {
            continue;
          }
          catch (InstantiationException parama)
          {
            continue;
          }
          catch (InvocationTargetException parama) {}
          if (paramClass != null)
          {
            parama = localMap;
            if (localMap == null) {
              parama = new HashMap();
            }
            parama.put(str1, paramClass);
            this.b.put(str2, parama);
          }
          AppMethodBeat.o(223482);
          return paramClass;
        }
      }
      paramClass = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ji
 * JD-Core Version:    0.7.0.1
 */