package com.google.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class l
{
  static void H(Class<?> paramClass)
  {
    int i = paramClass.getModifiers();
    if (Modifier.isInterface(i)) {
      throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + paramClass.getName());
    }
    if (Modifier.isAbstract(i)) {
      throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + paramClass.getName());
    }
  }
  
  public static l Zc()
  {
    try
    {
      Object localObject1 = Class.forName("sun.misc.Unsafe");
      final Object localObject4 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject4).setAccessible(true);
      localObject4 = ((Field)localObject4).get(null);
      localObject1 = new l()
      {
        public final <T> T G(Class<T> paramAnonymousClass)
        {
          AppMethodBeat.i(108105);
          H(paramAnonymousClass);
          paramAnonymousClass = this.dFV.invoke(localObject4, new Object[] { paramAnonymousClass });
          AppMethodBeat.o(108105);
          return paramAnonymousClass;
        }
      };
      return localObject1;
    }
    catch (Exception localException1)
    {
      try
      {
        Object localObject2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
        ((Method)localObject2).setAccessible(true);
        final int i = ((Integer)((Method)localObject2).invoke(null, new Object[] { Object.class })).intValue();
        localObject2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
        ((Method)localObject2).setAccessible(true);
        localObject2 = new l()
        {
          public final <T> T G(Class<T> paramAnonymousClass)
          {
            AppMethodBeat.i(107970);
            H(paramAnonymousClass);
            paramAnonymousClass = this.dFX.invoke(null, new Object[] { paramAnonymousClass, Integer.valueOf(i) });
            AppMethodBeat.o(107970);
            return paramAnonymousClass;
          }
        };
        return localObject2;
      }
      catch (Exception localException2)
      {
        try
        {
          Object localObject3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
          ((Method)localObject3).setAccessible(true);
          localObject3 = new l()
          {
            public final <T> T G(Class<T> paramAnonymousClass)
            {
              AppMethodBeat.i(108090);
              H(paramAnonymousClass);
              paramAnonymousClass = this.dFX.invoke(null, new Object[] { paramAnonymousClass, Object.class });
              AppMethodBeat.o(108090);
              return paramAnonymousClass;
            }
          };
          return localObject3;
        }
        catch (Exception localException3) {}
      }
    }
    new l()
    {
      public final <T> T G(Class<T> paramAnonymousClass)
      {
        AppMethodBeat.i(107943);
        paramAnonymousClass = new UnsupportedOperationException("Cannot allocate ".concat(String.valueOf(paramAnonymousClass)));
        AppMethodBeat.o(107943);
        throw paramAnonymousClass;
      }
    };
  }
  
  public abstract <T> T G(Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.c.b.l
 * JD-Core Version:    0.7.0.1
 */