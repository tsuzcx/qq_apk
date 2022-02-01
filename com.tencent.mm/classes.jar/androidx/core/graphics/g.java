package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.core.content.a.c.b;
import androidx.core.content.a.c.c;
import androidx.core.d.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

final class g
  extends k
{
  private static final Class<?> Ku;
  private static final Constructor<?> Kv;
  private static final Method Kw;
  private static final Method Kx;
  
  static
  {
    AppMethodBeat.i(250736);
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      localMethod2 = localClass.getMethod("addFontWeightStyle", new Class[] { ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE });
      Method localMethod1 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass() });
      Kv = localConstructor;
      Ku = localClass;
      Kw = localMethod2;
      Kx = localMethod1;
      AppMethodBeat.o(250736);
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
      label105:
      break label105;
    }
  }
  
  private static boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(250729);
    try
    {
      paramBoolean = ((Boolean)Kw.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
      AppMethodBeat.o(250729);
      return paramBoolean;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(250729);
      return false;
    }
    catch (InvocationTargetException paramObject)
    {
      label63:
      break label63;
    }
  }
  
  private static Object gw()
  {
    AppMethodBeat.i(250728);
    try
    {
      Object localObject = Kv.newInstance(new Object[0]);
      AppMethodBeat.o(250728);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      AppMethodBeat.o(250728);
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label24;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label24:
      break label24;
    }
  }
  
  public static boolean gx()
  {
    return Kw != null;
  }
  
  private static Typeface x(Object paramObject)
  {
    AppMethodBeat.i(250730);
    try
    {
      Object localObject = Array.newInstance(Ku, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)Kx.invoke(null, new Object[] { localObject });
      AppMethodBeat.o(250730);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(250730);
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      label46:
      break label46;
    }
  }
  
  public final Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(250734);
    Object localObject1 = gw();
    if (localObject1 == null)
    {
      AppMethodBeat.o(250734);
      return null;
    }
    paramb = paramb.Ka;
    int i = paramb.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject2 = paramb[paramInt];
      ByteBuffer localByteBuffer = l.a(paramContext, paramResources, localObject2.Kf);
      if (localByteBuffer == null)
      {
        AppMethodBeat.o(250734);
        return null;
      }
      if (!a(localObject1, localByteBuffer, localObject2.Ke, localObject2.Kb, localObject2.Kc))
      {
        AppMethodBeat.o(250734);
        return null;
      }
      paramInt += 1;
    }
    paramContext = x(localObject1);
    AppMethodBeat.o(250734);
    return paramContext;
  }
  
  public final Typeface a(Context paramContext, b.b[] paramArrayOfb, int paramInt)
  {
    AppMethodBeat.i(250733);
    Object localObject = gw();
    if (localObject == null)
    {
      AppMethodBeat.o(250733);
      return null;
    }
    androidx.b.g localg = new androidx.b.g();
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b.b localb = paramArrayOfb[i];
      Uri localUri = localb.mUri;
      ByteBuffer localByteBuffer2 = (ByteBuffer)localg.get(localUri);
      ByteBuffer localByteBuffer1 = localByteBuffer2;
      if (localByteBuffer2 == null)
      {
        localByteBuffer1 = l.a(paramContext, null, localUri);
        localg.put(localUri, localByteBuffer1);
      }
      if (localByteBuffer1 == null)
      {
        AppMethodBeat.o(250733);
        return null;
      }
      if (!a(localObject, localByteBuffer1, localb.Ke, localb.Kb, localb.Kc))
      {
        AppMethodBeat.o(250733);
        return null;
      }
      i += 1;
    }
    paramContext = x(localObject);
    if (paramContext == null)
    {
      AppMethodBeat.o(250733);
      return null;
    }
    paramContext = Typeface.create(paramContext, paramInt);
    AppMethodBeat.o(250733);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.graphics.g
 * JD-Core Version:    0.7.0.1
 */