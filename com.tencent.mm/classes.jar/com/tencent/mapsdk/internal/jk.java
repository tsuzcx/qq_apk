package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.utils.cache.DiskCache;
import com.tencent.mapsdk.core.utils.cache.MemoryCache;
import com.tencent.mapsdk.core.utils.cache.MemoryCache.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

public final class jk
{
  private static ji a;
  
  static
  {
    AppMethodBeat.i(224393);
    a = new ji();
    AppMethodBeat.o(224393);
  }
  
  public static <D extends jh> jg<D> a(Class<D> paramClass, jg.a... paramVarArgs)
  {
    AppMethodBeat.i(224336);
    if ((paramClass == null) || (paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(224336);
      return null;
    }
    jj localjj = new jj();
    if (paramVarArgs.length > 1) {}
    for (int i = 1;; i = 0)
    {
      int k = paramVarArgs.length;
      int j = 0;
      Object localObject2 = null;
      if (j < k)
      {
        Object localObject3 = paramVarArgs[j];
        Object localObject1;
        if ((localObject3 instanceof MemoryCache.a))
        {
          localObject1 = (MemoryCache.a)localObject3;
          localObject1 = a.a(paramClass, (jg.a)localObject1, MemoryCache.class);
        }
        for (;;)
        {
          if ((i != 0) && (localObject1 != null)) {
            localjj.a.addAll(Arrays.asList(new jg[] { localObject1 }));
          }
          j += 1;
          localObject2 = localObject1;
          break;
          localObject1 = localObject2;
          if ((localObject3 instanceof jm.c))
          {
            localObject3 = (jm.c)localObject3;
            if (((jm.c)localObject3).i == jm.a.a)
            {
              localObject1 = a.a(paramClass, (jg.a)localObject3, DiskCache.class);
            }
            else
            {
              localObject1 = localObject2;
              if (((jm.c)localObject3).i == jm.a.b) {
                localObject1 = a.a(paramClass, (jg.a)localObject3, jl.class);
              }
            }
          }
        }
      }
      if (i != 0)
      {
        AppMethodBeat.o(224336);
        return localjj;
      }
      AppMethodBeat.o(224336);
      return localObject2;
    }
  }
  
  public static <D extends jh> jn<D> a(jg<D> paramjg)
  {
    if ((paramjg instanceof jn)) {
      return (jn)paramjg;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(224323);
    paramString = a.a.a(paramString);
    AppMethodBeat.o(224323);
    return paramString;
  }
  
  private static <D extends jh> je<D> b(jg<D> paramjg)
  {
    if ((paramjg instanceof je)) {
      return (je)paramjg;
    }
    return null;
  }
  
  private static <D extends jh> jn<D> b(Class<D> paramClass, jg.a... paramVarArgs)
  {
    AppMethodBeat.i(224349);
    paramClass = a(a(paramClass, paramVarArgs));
    AppMethodBeat.o(224349);
    return paramClass;
  }
  
  private static <D extends jh> je<D> c(Class<D> paramClass, jg.a... paramVarArgs)
  {
    AppMethodBeat.i(224372);
    paramClass = a(paramClass, paramVarArgs);
    if ((paramClass instanceof je))
    {
      paramClass = (je)paramClass;
      AppMethodBeat.o(224372);
      return paramClass;
    }
    AppMethodBeat.o(224372);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jk
 * JD-Core Version:    0.7.0.1
 */