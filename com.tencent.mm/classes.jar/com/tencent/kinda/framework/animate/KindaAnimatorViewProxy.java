package com.tencent.kinda.framework.animate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.kinda.framework.widget.base.MMKView;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Deprecated
public class KindaAnimatorViewProxy
  implements InvocationHandler
{
  private static final String TAG = "MicroMsg.Kinda.KindaAnimatorViewProxy";
  private static ArgbEvaluator defaultArgbEvaluator;
  private static KindaAnimatorViewProxy.DoubleEvaluator defaultDoubleEvaluator;
  private static KindaAnimatorViewProxy.LongEvaluator defaultLongEvaluator;
  private MMKView target = null;
  
  static
  {
    AppMethodBeat.i(144284);
    defaultLongEvaluator = new KindaAnimatorViewProxy.LongEvaluator();
    defaultDoubleEvaluator = new KindaAnimatorViewProxy.DoubleEvaluator();
    defaultArgbEvaluator = new ArgbEvaluator();
    AppMethodBeat.o(144284);
  }
  
  private ValueAnimator buildAnimator(final Method paramMethod1, Method paramMethod2, Object paramObject)
  {
    AppMethodBeat.i(144279);
    if (paramObject.getClass().equals(Integer.class))
    {
      paramMethod2 = ValueAnimator.ofInt(new int[] { ((Integer)paramMethod2.invoke(this.target, new Object[0])).intValue(), ((Integer)paramObject).intValue() });
      paramMethod2.addUpdateListener(new KindaAnimatorViewProxy.1(this, paramMethod1));
      paramMethod2.setDuration(KindaGlobalAnimator.animateDuration());
      AppMethodBeat.o(144279);
      return paramMethod2;
    }
    if (paramObject.getClass().equals(Long.class)) {
      if (paramMethod1.getName().equals("setBackgroundColor")) {
        ValueAnimator.ofObject(defaultArgbEvaluator, new Object[] { Integer.valueOf((int)((Long)paramMethod2.invoke(this.target, new Object[0])).longValue()), Integer.valueOf((int)((Long)paramObject).longValue()) }).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(144268);
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            try
            {
              paramMethod1.invoke(KindaAnimatorViewProxy.this.target, new Object[] { Long.valueOf(i) });
              AppMethodBeat.o(144268);
              return;
            }
            catch (Exception paramAnonymousValueAnimator)
            {
              AppMethodBeat.o(144268);
            }
          }
        });
      }
    }
    do
    {
      AppMethodBeat.o(144279);
      return null;
      paramMethod2 = ValueAnimator.ofObject(defaultLongEvaluator, new Object[] { (Long)paramMethod2.invoke(this.target, new Object[0]), (Long)paramObject });
      paramMethod2.addUpdateListener(new KindaAnimatorViewProxy.3(this, paramMethod1));
      paramMethod2.setDuration(KindaGlobalAnimator.animateDuration());
      AppMethodBeat.o(144279);
      return paramMethod2;
      if (paramObject.getClass().equals(Float.class))
      {
        paramMethod2 = ValueAnimator.ofFloat(new float[] { ((Float)paramMethod2.invoke(this.target, new Object[0])).floatValue(), ((Float)paramObject).floatValue() });
        paramMethod2.addUpdateListener(new KindaAnimatorViewProxy.4(this, paramMethod1));
        paramMethod2.setDuration(KindaGlobalAnimator.animateDuration());
        AppMethodBeat.o(144279);
        return paramMethod2;
      }
    } while (!paramObject.getClass().equals(Double.class));
    paramMethod2 = ValueAnimator.ofObject(defaultDoubleEvaluator, new Object[] { (Double)paramMethod2.invoke(this.target, new Object[0]), (Double)paramObject });
    paramMethod2.addUpdateListener(new KindaAnimatorViewProxy.5(this, paramMethod1));
    paramMethod2.setDuration(KindaGlobalAnimator.animateDuration());
    AppMethodBeat.o(144279);
    return paramMethod2;
  }
  
  private boolean checkHasPrimitiveTypeParams(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(144282);
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0))
    {
      AppMethodBeat.o(144282);
      return false;
    }
    if (paramArrayOfObject.length == 1)
    {
      paramArrayOfObject = paramArrayOfObject[0];
      if (paramArrayOfObject.getClass().isPrimitive())
      {
        AppMethodBeat.o(144282);
        return true;
      }
      if ((paramArrayOfObject.getClass().equals(Integer.class)) || (paramArrayOfObject.getClass().equals(Long.class)) || (paramArrayOfObject.getClass().equals(Float.class)) || (paramArrayOfObject.getClass().equals(Double.class)))
      {
        AppMethodBeat.o(144282);
        return true;
      }
    }
    AppMethodBeat.o(144282);
    return false;
  }
  
  private Method getterMethod(Class paramClass, String paramString)
  {
    AppMethodBeat.i(144280);
    paramClass = paramClass.getMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramClass[i];
      if ((localMethod.getName().startsWith("get")) && (localMethod.getName().toLowerCase().endsWith(paramString.toLowerCase())))
      {
        AppMethodBeat.o(144280);
        return localMethod;
      }
      i += 1;
    }
    AppMethodBeat.o(144280);
    return null;
  }
  
  private String propName(Method paramMethod)
  {
    AppMethodBeat.i(144281);
    if ((paramMethod != null) && (paramMethod.getName().startsWith("set")))
    {
      paramMethod = paramMethod.getName().substring(3);
      AppMethodBeat.o(144281);
      return paramMethod;
    }
    AppMethodBeat.o(144281);
    return null;
  }
  
  public static KView unWrapRealObj(Object paramObject)
  {
    AppMethodBeat.i(144278);
    if ((paramObject instanceof Proxy)) {
      try
      {
        Object localObject = Proxy.getInvocationHandler(paramObject);
        if ((localObject instanceof KindaAnimatorViewProxy))
        {
          localObject = ((KindaAnimatorViewProxy)localObject).target;
          AppMethodBeat.o(144278);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Kinda.KindaAnimatorViewProxy", localException, "unWrapRealObj %s", new Object[] { localException.getMessage() });
      }
    }
    if ((paramObject instanceof KView))
    {
      paramObject = (KView)paramObject;
      AppMethodBeat.o(144278);
      return paramObject;
    }
    AppMethodBeat.o(144278);
    return null;
  }
  
  public static Object unwrapProxyObject(Object paramObject)
  {
    AppMethodBeat.i(144283);
    if ((paramObject instanceof Proxy)) {
      try
      {
        Object localObject = Proxy.getInvocationHandler(paramObject);
        if ((localObject instanceof KindaAnimatorViewProxy))
        {
          localObject = ((KindaAnimatorViewProxy)localObject).target;
          AppMethodBeat.o(144283);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(144283);
        return paramObject;
      }
    }
    AppMethodBeat.o(144283);
    return paramObject;
  }
  
  private Object[] unwrapProxyParams(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(144277);
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      Object[] arrayOfObject = new Object[paramArrayOfObject.length];
      int k = paramArrayOfObject.length;
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (i < k)
        {
          Object localObject = paramArrayOfObject[i];
          arrayOfObject[j] = localObject;
          if ((localObject instanceof Proxy)) {}
          try
          {
            InvocationHandler localInvocationHandler = Proxy.getInvocationHandler(localObject);
            if ((localInvocationHandler instanceof KindaAnimatorViewProxy)) {
              arrayOfObject[j] = ((KindaAnimatorViewProxy)localInvocationHandler).target;
            }
            j += 1;
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              arrayOfObject[j] = localObject;
            }
          }
        }
      }
      AppMethodBeat.o(144277);
      return arrayOfObject;
    }
    AppMethodBeat.o(144277);
    return paramArrayOfObject;
  }
  
  public MMKView getTarget()
  {
    return this.target;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(144276);
    try
    {
      if ((KindaGlobalAnimator.hasAnimate()) && (paramMethod.getName().startsWith("set")) && (checkHasPrimitiveTypeParams(paramArrayOfObject)) && (paramMethod.getReturnType() == Void.TYPE))
      {
        paramObject = propName(paramMethod);
        if ((paramObject != null) && (paramObject.length() > 0))
        {
          paramObject = getterMethod(this.target.getClass(), paramObject);
          if (paramObject != null)
          {
            paramObject = buildAnimator(paramMethod, paramObject, paramArrayOfObject[0]);
            if (paramObject != null)
            {
              KindaGlobalAnimator.addAnimator(paramObject);
              AppMethodBeat.o(144276);
              return null;
            }
          }
        }
      }
      paramObject = unwrapProxyParams(paramArrayOfObject);
      paramObject = paramMethod.invoke(this.target, paramObject);
      AppMethodBeat.o(144276);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      ab.printErrStackTrace("MicroMsg.Kinda.KindaAnimatorViewProxy", paramObject, "invoke %s error: %s %s", new Object[] { paramMethod.getName(), paramObject.getMessage(), this.target });
      AppMethodBeat.o(144276);
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Kinda.KindaAnimatorViewProxy", paramObject, "invoke %s error: %s %s", new Object[] { paramMethod.getName(), paramObject.getMessage(), this.target });
      }
    }
    catch (IllegalArgumentException paramObject)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Kinda.KindaAnimatorViewProxy", paramObject, "invoke %s error: %s %s", new Object[] { paramMethod.getName(), paramObject.getMessage(), this.target });
      }
    }
  }
  
  public void setTarget(MMKView paramMMKView)
  {
    this.target = paramMMKView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimatorViewProxy
 * JD-Core Version:    0.7.0.1
 */