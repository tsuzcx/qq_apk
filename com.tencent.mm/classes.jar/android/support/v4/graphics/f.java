package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.c.b.b;
import android.support.v4.content.a.c.b;
import android.support.v4.content.a.c.c;
import android.support.v4.e.n;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

final class f
  extends i
{
  private static final Class GX;
  private static final Constructor GY;
  private static final Method GZ;
  private static final Method Ha;
  
  static
  {
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      localMethod2 = localClass.getMethod("addFontWeightStyle", new Class[] { ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE });
      Method localMethod1 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass() });
      GY = localConstructor;
      GX = localClass;
      GZ = localMethod2;
      Ha = localMethod1;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.getClass().getName();
        Object localObject = null;
        Method localMethod2 = null;
        Constructor localConstructor = null;
        Class localClass = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label95:
      break label95;
    }
  }
  
  private static boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      paramBoolean = ((Boolean)GZ.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label53:
      break label53;
    }
  }
  
  public static boolean dT()
  {
    return GZ != null;
  }
  
  private static Object dU()
  {
    try
    {
      Object localObject = GY.newInstance(new Object[0]);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label14;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label14:
      break label14;
    }
  }
  
  private static Typeface n(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(GX, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)Ha.invoke(null, new Object[] { localObject });
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label36:
      break label36;
    }
  }
  
  public final Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt)
  {
    Object localObject1 = dU();
    paramb = paramb.GD;
    int i = paramb.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject2 = paramb[paramInt];
      ByteBuffer localByteBuffer = j.a(paramContext, paramResources, localObject2.GI);
      if (localByteBuffer == null) {}
      while (!a(localObject1, localByteBuffer, localObject2.GH, localObject2.GE, localObject2.GF)) {
        return null;
      }
      paramInt += 1;
    }
    return n(localObject1);
  }
  
  public final Typeface a(Context paramContext, b.b[] paramArrayOfb, int paramInt)
  {
    Object localObject = dU();
    n localn = new n();
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b.b localb = paramArrayOfb[i];
      Uri localUri = localb.mUri;
      ByteBuffer localByteBuffer2 = (ByteBuffer)localn.get(localUri);
      ByteBuffer localByteBuffer1 = localByteBuffer2;
      if (localByteBuffer2 == null)
      {
        localByteBuffer1 = j.b(paramContext, localUri);
        localn.put(localUri, localByteBuffer1);
      }
      if (!a(localObject, localByteBuffer1, localb.GH, localb.GE, localb.GF)) {
        return null;
      }
      i += 1;
    }
    return Typeface.create(n(localObject), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.graphics.f
 * JD-Core Version:    0.7.0.1
 */