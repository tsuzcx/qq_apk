package com.google.c.b;

import com.google.c.b.b.b;
import com.google.c.c.a;
import com.google.c.f;
import com.google.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class c
{
  private final Map<Type, f<?>> dED;
  private final b dFi;
  
  public c(Map<Type, f<?>> paramMap)
  {
    AppMethodBeat.i(107906);
    this.dFi = b.Zw();
    this.dED = paramMap;
    AppMethodBeat.o(107906);
  }
  
  private <T> i<T> A(final Class<? super T> paramClass)
  {
    AppMethodBeat.i(107908);
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible()) {
        this.dFi.a(paramClass);
      }
      paramClass = new i()
      {
        public final T YW()
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
  
  public final <T> i<T> b(final a<T> parama)
  {
    AppMethodBeat.i(107907);
    final Type localType = parama.dGJ;
    final Class localClass = parama.dIb;
    parama = (f)this.dED.get(localType);
    if (parama != null)
    {
      parama = new i()
      {
        public final T YW()
        {
          AppMethodBeat.i(107887);
          Object localObject = parama.YJ();
          AppMethodBeat.o(107887);
          return localObject;
        }
      };
      AppMethodBeat.o(107907);
      return parama;
    }
    parama = (f)this.dED.get(localClass);
    if (parama != null)
    {
      parama = new i()
      {
        public final T YW()
        {
          AppMethodBeat.i(107910);
          Object localObject = parama.YJ();
          AppMethodBeat.o(107910);
          return localObject;
        }
      };
      AppMethodBeat.o(107907);
      return parama;
    }
    parama = A(localClass);
    if (parama != null)
    {
      AppMethodBeat.o(107907);
      return parama;
    }
    if (Collection.class.isAssignableFrom(localClass)) {
      if (SortedSet.class.isAssignableFrom(localClass)) {
        parama = new i()
        {
          public final T YW()
          {
            AppMethodBeat.i(107933);
            TreeSet localTreeSet = new TreeSet();
            AppMethodBeat.o(107933);
            return localTreeSet;
          }
        };
      }
    }
    while (parama != null)
    {
      AppMethodBeat.o(107907);
      return parama;
      if (EnumSet.class.isAssignableFrom(localClass))
      {
        parama = new i()
        {
          public final T YW()
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
              localObject = new j("Invalid EnumSet type: " + localType.toString());
              AppMethodBeat.o(107891);
              throw ((Throwable)localObject);
            }
            Object localObject = new j("Invalid EnumSet type: " + localType.toString());
            AppMethodBeat.o(107891);
            throw ((Throwable)localObject);
          }
        };
      }
      else if (Set.class.isAssignableFrom(localClass))
      {
        parama = new i()
        {
          public final T YW()
          {
            AppMethodBeat.i(107939);
            LinkedHashSet localLinkedHashSet = new LinkedHashSet();
            AppMethodBeat.o(107939);
            return localLinkedHashSet;
          }
        };
      }
      else if (Queue.class.isAssignableFrom(localClass))
      {
        parama = new i()
        {
          public final T YW()
          {
            AppMethodBeat.i(107889);
            ArrayDeque localArrayDeque = new ArrayDeque();
            AppMethodBeat.o(107889);
            return localArrayDeque;
          }
        };
      }
      else
      {
        parama = new i()
        {
          public final T YW()
          {
            AppMethodBeat.i(107949);
            ArrayList localArrayList = new ArrayList();
            AppMethodBeat.o(107949);
            return localArrayList;
          }
        };
        continue;
        if (Map.class.isAssignableFrom(localClass))
        {
          if (ConcurrentNavigableMap.class.isAssignableFrom(localClass)) {
            parama = new i()
            {
              public final T YW()
              {
                AppMethodBeat.i(107980);
                ConcurrentSkipListMap localConcurrentSkipListMap = new ConcurrentSkipListMap();
                AppMethodBeat.o(107980);
                return localConcurrentSkipListMap;
              }
            };
          } else if (ConcurrentMap.class.isAssignableFrom(localClass)) {
            parama = new i()
            {
              public final T YW()
              {
                AppMethodBeat.i(107942);
                ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
                AppMethodBeat.o(107942);
                return localConcurrentHashMap;
              }
            };
          } else if (SortedMap.class.isAssignableFrom(localClass)) {
            parama = new i()
            {
              public final T YW()
              {
                AppMethodBeat.i(107975);
                TreeMap localTreeMap = new TreeMap();
                AppMethodBeat.o(107975);
                return localTreeMap;
              }
            };
          } else if (((localType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(a.h(((ParameterizedType)localType).getActualTypeArguments()[0]).dIb))) {
            parama = new i()
            {
              public final T YW()
              {
                AppMethodBeat.i(107941);
                LinkedHashMap localLinkedHashMap = new LinkedHashMap();
                AppMethodBeat.o(107941);
                return localLinkedHashMap;
              }
            };
          } else {
            parama = new i()
            {
              public final T YW()
              {
                AppMethodBeat.i(107985);
                h localh = new h();
                AppMethodBeat.o(107985);
                return localh;
              }
            };
          }
        }
        else {
          parama = null;
        }
      }
    }
    parama = new i()
    {
      private final l dFm;
      
      public final T YW()
      {
        AppMethodBeat.i(107951);
        try
        {
          Object localObject = this.dFm.G(localClass);
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
    String str = this.dED.toString();
    AppMethodBeat.o(107909);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.c.b.c
 * JD-Core Version:    0.7.0.1
 */