package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.core.content.a.c.b;
import androidx.core.content.a.c.c;
import androidx.core.d.e.b;
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
  private static final Class<?> bqC;
  private static final Constructor<?> bqD;
  private static final Method bqE;
  private static final Method bqF;
  
  static
  {
    AppMethodBeat.i(196080);
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      localMethod2 = localClass.getMethod("addFontWeightStyle", new Class[] { ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE });
      Method localMethod1 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass() });
      bqD = localConstructor;
      bqC = localClass;
      bqE = localMethod2;
      bqF = localMethod1;
      AppMethodBeat.o(196080);
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
  
  private static Object DH()
  {
    AppMethodBeat.i(196047);
    try
    {
      Object localObject = bqD.newInstance(new Object[0]);
      AppMethodBeat.o(196047);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      AppMethodBeat.o(196047);
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
  
  public static boolean DI()
  {
    return bqE != null;
  }
  
  private static boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(196056);
    try
    {
      paramBoolean = ((Boolean)bqE.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
      AppMethodBeat.o(196056);
      return paramBoolean;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(196056);
      return false;
    }
    catch (InvocationTargetException paramObject)
    {
      label63:
      break label63;
    }
  }
  
  private static Typeface aw(Object paramObject)
  {
    AppMethodBeat.i(196067);
    try
    {
      Object localObject = Array.newInstance(bqC, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)bqF.invoke(null, new Object[] { localObject });
      AppMethodBeat.o(196067);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(196067);
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
    AppMethodBeat.i(196109);
    Object localObject1 = DH();
    if (localObject1 == null)
    {
      AppMethodBeat.o(196109);
      return null;
    }
    paramb = paramb.bqf;
    int i = paramb.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject2 = paramb[paramInt];
      ByteBuffer localByteBuffer = l.a(paramContext, paramResources, localObject2.bqk);
      if (localByteBuffer == null)
      {
        AppMethodBeat.o(196109);
        return null;
      }
      if (!a(localObject1, localByteBuffer, localObject2.bqj, localObject2.bqg, localObject2.bqh))
      {
        AppMethodBeat.o(196109);
        return null;
      }
      paramInt += 1;
    }
    paramContext = aw(localObject1);
    AppMethodBeat.o(196109);
    return paramContext;
  }
  
  public final Typeface a(Context paramContext, e.b[] paramArrayOfb, int paramInt)
  {
    AppMethodBeat.i(196093);
    Object localObject = DH();
    if (localObject == null)
    {
      AppMethodBeat.o(196093);
      return null;
    }
    androidx.b.g localg = new androidx.b.g();
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      e.b localb = paramArrayOfb[i];
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
        AppMethodBeat.o(196093);
        return null;
      }
      if (!a(localObject, localByteBuffer1, localb.bqj, localb.bqg, localb.bqh))
      {
        AppMethodBeat.o(196093);
        return null;
      }
      i += 1;
    }
    paramContext = aw(localObject);
    if (paramContext == null)
    {
      AppMethodBeat.o(196093);
      return null;
    }
    paramContext = Typeface.create(paramContext, paramInt);
    AppMethodBeat.o(196093);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.graphics.g
 * JD-Core Version:    0.7.0.1
 */