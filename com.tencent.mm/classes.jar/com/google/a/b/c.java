package com.google.a.b;

import com.google.a.b.b.b;
import com.google.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

public final class c
{
  private final b bNK;
  private final Map<Type, com.google.a.h<?>> bNc;
  
  public c(Map<Type, com.google.a.h<?>> paramMap)
  {
    AppMethodBeat.i(107906);
    this.bNK = b.yT();
    this.bNc = paramMap;
    AppMethodBeat.o(107906);
  }
  
  private <T> h<T> C(final Class<? super T> paramClass)
  {
    AppMethodBeat.i(107908);
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible()) {
        this.bNK.a(paramClass);
      }
      paramClass = new h()
      {
        public final T yH()
        {
          AppMethodBeat.i(107888);
          try
          {
            Object localObject = paramClass.newInstance(null);
            AppMethodBeat.o(107888);
            return localObject;
          }
          catch (InstantiationException localInstantiationException)
          {
            RuntimeException localRuntimeException1 = new RuntimeException("Failed to invoke " + paramClass + " with no args", localInstantiationException);
            AppMethodBeat.o(107888);
            throw localRuntimeException1;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            RuntimeException localRuntimeException2 = new RuntimeException("Failed to invoke " + paramClass + " with no args", localInvocationTargetException.getTargetException());
            AppMethodBeat.o(107888);
            throw localRuntimeException2;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            AssertionError localAssertionError = new AssertionError(localIllegalAccessException);
            AppMethodBeat.o(107888);
            throw localAssertionError;
          }
        }
      };
      AppMethodBeat.o(107908);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      AppMethodBeat.o(107908);
    }
    return null;
  }
  
  public final <T> h<T> b(final a<T> parama)
  {
    AppMethodBeat.i(107907);
    final Type localType = parama.bPh;
    final Class localClass = parama.bQy;
    parama = (com.google.a.h)this.bNc.get(localType);
    if (parama != null)
    {
      parama = new h()
      {
        public final T yH()
        {
          AppMethodBeat.i(107887);
          Object localObject = parama.yw();
          AppMethodBeat.o(107887);
          return localObject;
        }
      };
      AppMethodBeat.o(107907);
      return parama;
    }
    parama = (com.google.a.h)this.bNc.get(localClass);
    if (parama != null)
    {
      parama = new h()
      {
        public final T yH()
        {
          AppMethodBeat.i(107910);
          Object localObject = parama.yw();
          AppMethodBeat.o(107910);
          return localObject;
        }
      };
      AppMethodBeat.o(107907);
      return parama;
    }
    parama = C(localClass);
    if (parama != null)
    {
      AppMethodBeat.o(107907);
      return parama;
    }
    if (Collection.class.isAssignableFrom(localClass)) {
      if (SortedSet.class.isAssignableFrom(localClass)) {
        parama = new c.9(this);
      }
    }
    while (parama != null)
    {
      AppMethodBeat.o(107907);
      return parama;
      if (EnumSet.class.isAssignableFrom(localClass))
      {
        parama = new h()
        {
          public final T yH()
          {
            AppMethodBeat.i(107891);
            if ((localType instanceof ParameterizedType))
            {
              localObject = ((ParameterizedType)localType).getActualTypeArguments()[0];
              if ((localObject instanceof Class))
              {
                localObject = EnumSet.noneOf((Class)localObject);
                AppMethodBeat.o(107891);
                return localObject;
              }
              localObject = new com.google.a.l("Invalid EnumSet type: " + localType.toString());
              AppMethodBeat.o(107891);
              throw ((Throwable)localObject);
            }
            Object localObject = new com.google.a.l("Invalid EnumSet type: " + localType.toString());
            AppMethodBeat.o(107891);
            throw ((Throwable)localObject);
          }
        };
      }
      else if (Set.class.isAssignableFrom(localClass))
      {
        parama = new c.11(this);
      }
      else if (Queue.class.isAssignableFrom(localClass))
      {
        parama = new c.12(this);
      }
      else
      {
        parama = new c.13(this);
        continue;
        if (Map.class.isAssignableFrom(localClass))
        {
          if (ConcurrentNavigableMap.class.isAssignableFrom(localClass)) {
            parama = new c.14(this);
          } else if (ConcurrentMap.class.isAssignableFrom(localClass)) {
            parama = new c.2(this);
          } else if (SortedMap.class.isAssignableFrom(localClass)) {
            parama = new c.3(this);
          } else if (((localType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(a.h(((ParameterizedType)localType).getActualTypeArguments()[0]).bQy))) {
            parama = new c.4(this);
          } else {
            parama = new h()
            {
              public final T yH()
              {
                AppMethodBeat.i(107985);
                g localg = new g();
                AppMethodBeat.o(107985);
                return localg;
              }
            };
          }
        }
        else {
          parama = null;
        }
      }
    }
    parama = new h()
    {
      private final l bNO;
      
      public final T yH()
      {
        AppMethodBeat.i(107951);
        try
        {
          Object localObject = this.bNO.H(localClass);
          AppMethodBeat.o(107951);
          return localObject;
        }
        catch (Exception localException)
        {
          RuntimeException localRuntimeException = new RuntimeException("Unable to invoke no-args constructor for " + localType + ". Registering an InstanceCreator with Gson for this type may fix this problem.", localException);
          AppMethodBeat.o(107951);
          throw localRuntimeException;
        }
      }
    };
    AppMethodBeat.o(107907);
    return parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(107909);
    String str = this.bNc.toString();
    AppMethodBeat.o(107909);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.c
 * JD-Core Version:    0.7.0.1
 */