package com.tencent.kinda.framework.animate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.kinda.framework.widget.base.MMKView;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
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
    AppMethodBeat.i(18319);
    defaultLongEvaluator = new KindaAnimatorViewProxy.LongEvaluator();
    defaultDoubleEvaluator = new KindaAnimatorViewProxy.DoubleEvaluator();
    defaultArgbEvaluator = new ArgbEvaluator();
    AppMethodBeat.o(18319);
  }
  
  private ValueAnimator buildAnimator(final Method paramMethod1, Method paramMethod2, Object paramObject)
  {
    AppMethodBeat.i(18314);
    if (paramObject.getClass().equals(Integer.class))
    {
      paramMethod2 = ValueAnimator.ofInt(new int[] { ((Integer)paramMethod2.invoke(this.target, new Object[0])).intValue(), ((Integer)paramObject).intValue() });
      paramMethod2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(18302);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          try
          {
            paramMethod1.invoke(KindaAnimatorViewProxy.this.target, new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(18302);
            return;
          }
          catch (Exception paramAnonymousValueAnimator)
          {
            AppMethodBeat.o(18302);
          }
        }
      });
      paramMethod2.setDuration(KindaGlobalAnimator.animateDuration());
      AppMethodBeat.o(18314);
      return paramMethod2;
    }
    if (paramObject.getClass().equals(Long.class)) {
      if (paramMethod1.getName().equals("setBackgroundColor")) {
        ValueAnimator.ofObject(defaultArgbEvaluator, new Object[] { Integer.valueOf((int)((Long)paramMethod2.invoke(this.target, new Object[0])).longValue()), Integer.valueOf((int)((Long)paramObject).longValue()) }).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(18303);
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            try
            {
              paramMethod1.invoke(KindaAnimatorViewProxy.this.target, new Object[] { Long.valueOf(i) });
              AppMethodBeat.o(18303);
              return;
            }
            catch (Exception paramAnonymousValueAnimator)
            {
              AppMethodBeat.o(18303);
            }
          }
        });
      }
    }
    do
    {
      AppMethodBeat.o(18314);
      return null;
      paramMethod2 = ValueAnimator.ofObject(defaultLongEvaluator, new Object[] { (Long)paramMethod2.invoke(this.target, new Object[0]), (Long)paramObject });
      paramMethod2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(18304);
          long l = ((Long)paramAnonymousValueAnimator.getAnimatedValue()).longValue();
          try
          {
            paramMethod1.invoke(KindaAnimatorViewProxy.this.target, new Object[] { Long.valueOf(l) });
            AppMethodBeat.o(18304);
            return;
          }
          catch (Exception paramAnonymousValueAnimator)
          {
            AppMethodBeat.o(18304);
          }
        }
      });
      paramMethod2.setDuration(KindaGlobalAnimator.animateDuration());
      AppMethodBeat.o(18314);
      return paramMethod2;
      if (paramObject.getClass().equals(Float.class))
      {
        paramMethod2 = ValueAnimator.ofFloat(new float[] { ((Float)paramMethod2.invoke(this.target, new Object[0])).floatValue(), ((Float)paramObject).floatValue() });
        paramMethod2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(18305);
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            try
            {
              paramMethod1.invoke(KindaAnimatorViewProxy.this.target, new Object[] { Float.valueOf(f) });
              AppMethodBeat.o(18305);
              return;
            }
            catch (Exception paramAnonymousValueAnimator)
            {
              AppMethodBeat.o(18305);
            }
          }
        });
        paramMethod2.setDuration(KindaGlobalAnimator.animateDuration());
        AppMethodBeat.o(18314);
        return paramMethod2;
      }
    } while (!paramObject.getClass().equals(Double.class));
    paramMethod2 = ValueAnimator.ofObject(defaultDoubleEvaluator, new Object[] { (Double)paramMethod2.invoke(this.target, new Object[0]), (Double)paramObject });
    paramMethod2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(18306);
        double d = ((Double)paramAnonymousValueAnimator.getAnimatedValue()).doubleValue();
        try
        {
          paramMethod1.invoke(KindaAnimatorViewProxy.this.target, new Object[] { Double.valueOf(d) });
          AppMethodBeat.o(18306);
          return;
        }
        catch (Exception paramAnonymousValueAnimator)
        {
          AppMethodBeat.o(18306);
        }
      }
    });
    paramMethod2.setDuration(KindaGlobalAnimator.animateDuration());
    AppMethodBeat.o(18314);
    return paramMethod2;
  }
  
  private boolean checkHasPrimitiveTypeParams(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(18317);
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0))
    {
      AppMethodBeat.o(18317);
      return false;
    }
    if (paramArrayOfObject.length == 1)
    {
      paramArrayOfObject = paramArrayOfObject[0];
      if (paramArrayOfObject.getClass().isPrimitive())
      {
        AppMethodBeat.o(18317);
        return true;
      }
      if ((paramArrayOfObject.getClass().equals(Integer.class)) || (paramArrayOfObject.getClass().equals(Long.class)) || (paramArrayOfObject.getClass().equals(Float.class)) || (paramArrayOfObject.getClass().equals(Double.class)))
      {
        AppMethodBeat.o(18317);
        return true;
      }
    }
    AppMethodBeat.o(18317);
    return false;
  }
  
  private Method getterMethod(Class paramClass, String paramString)
  {
    AppMethodBeat.i(18315);
    paramClass = paramClass.getMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramClass[i];
      if ((localMethod.getName().startsWith("get")) && (localMethod.getName().toLowerCase().endsWith(paramString.toLowerCase())))
      {
        AppMethodBeat.o(18315);
        return localMethod;
      }
      i += 1;
    }
    AppMethodBeat.o(18315);
    return null;
  }
  
  private String propName(Method paramMethod)
  {
    AppMethodBeat.i(18316);
    if ((paramMethod != null) && (paramMethod.getName().startsWith("set")))
    {
      paramMethod = paramMethod.getName().substring(3);
      AppMethodBeat.o(18316);
      return paramMethod;
    }
    AppMethodBeat.o(18316);
    return null;
  }
  
  public static KView unWrapRealObj(Object paramObject)
  {
    AppMethodBeat.i(18313);
    if ((paramObject instanceof Proxy)) {
      try
      {
        Object localObject = Proxy.getInvocationHandler(paramObject);
        if ((localObject instanceof KindaAnimatorViewProxy))
        {
          localObject = ((KindaAnimatorViewProxy)localObject).target;
          AppMethodBeat.o(18313);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.Kinda.KindaAnimatorViewProxy", localException, "unWrapRealObj %s", new Object[] { localException.getMessage() });
      }
    }
    if ((paramObject instanceof KView))
    {
      paramObject = (KView)paramObject;
      AppMethodBeat.o(18313);
      return paramObject;
    }
    AppMethodBeat.o(18313);
    return null;
  }
  
  public static Object unwrapProxyObject(Object paramObject)
  {
    AppMethodBeat.i(18318);
    if ((paramObject instanceof Proxy)) {
      try
      {
        Object localObject = Proxy.getInvocationHandler(paramObject);
        if ((localObject instanceof KindaAnimatorViewProxy))
        {
          localObject = ((KindaAnimatorViewProxy)localObject).target;
          AppMethodBeat.o(18318);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(18318);
        return paramObject;
      }
    }
    AppMethodBeat.o(18318);
    return paramObject;
  }
  
  private Object[] unwrapProxyParams(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(18312);
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
      AppMethodBeat.o(18312);
      return arrayOfObject;
    }
    AppMethodBeat.o(18312);
    return paramArrayOfObject;
  }
  
  public MMKView getTarget()
  {
    return this.target;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(18311);
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
              AppMethodBeat.o(18311);
              return null;
            }
          }
        }
      }
      paramObject = unwrapProxyParams(paramArrayOfObject);
      paramObject = paramMethod.invoke(this.target, paramObject);
      AppMethodBeat.o(18311);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      ad.printErrStackTrace("MicroMsg.Kinda.KindaAnimatorViewProxy", paramObject, "invoke %s error: %s %s", new Object[] { paramMethod.getName(), paramObject.getMessage(), this.target });
      AppMethodBeat.o(18311);
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Kinda.KindaAnimatorViewProxy", paramObject, "invoke %s error: %s %s", new Object[] { paramMethod.getName(), paramObject.getMessage(), this.target });
      }
    }
    catch (IllegalArgumentException paramObject)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Kinda.KindaAnimatorViewProxy", paramObject, "invoke %s error: %s %s", new Object[] { paramMethod.getName(), paramObject.getMessage(), this.target });
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