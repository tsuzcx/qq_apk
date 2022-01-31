package android.support.v4.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.v4.content.a.a.b;
import android.support.v4.content.a.a.c;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class g
  extends e
{
  private static final Constructor Aa;
  private static final Method Ac;
  private static final Method Ad;
  private static final Method Ae;
  private static final Method Af;
  private static final Method Ag;
  private static final Class zZ;
  
  static
  {
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      localMethod5 = localClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, [Landroid.graphics.fonts.FontVariationAxis.class });
      localMethod4 = localClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, Integer.TYPE, [Landroid.graphics.fonts.FontVariationAxis.class, Integer.TYPE, Integer.TYPE });
      localMethod3 = localClass.getMethod("freeze", new Class[0]);
      localMethod2 = localClass.getMethod("abortCreation", new Class[0]);
      Method localMethod1 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass(), Integer.TYPE, Integer.TYPE });
      localMethod1.setAccessible(true);
      Aa = localConstructor;
      zZ = localClass;
      Ad = localMethod5;
      Ae = localMethod4;
      Af = localMethod3;
      Ag = localMethod2;
      Ac = localMethod1;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        new StringBuilder("Unable to collect necessary methods for class ").append(localClassNotFoundException.getClass().getName());
        Object localObject = null;
        Method localMethod2 = null;
        Method localMethod3 = null;
        Method localMethod4 = null;
        Method localMethod5 = null;
        Constructor localConstructor = null;
        Class localClass = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label217:
      break label217;
    }
  }
  
  private static boolean a(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      boolean bool = ((Boolean)Ad.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      label77:
      break label77;
    }
  }
  
  private static boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)Ae.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
      return bool;
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
  
  private static Object cm()
  {
    try
    {
      Object localObject = Aa.newInstance(new Object[0]);
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
  
  private static boolean cn()
  {
    return Ad != null;
  }
  
  private static Typeface o(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(zZ, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)Ac.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label50:
      break label50;
    }
  }
  
  private static boolean p(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)Af.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label21:
      break label21;
    }
  }
  
  private static void q(Object paramObject)
  {
    try
    {
      Ag.invoke(paramObject, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label14:
      break label14;
    }
  }
  
  public final Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = null;
    if (!cn()) {
      paramContext = super.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    do
    {
      return paramContext;
      paramResources = cm();
      if (!a(paramContext, paramResources, paramString, -1, -1))
      {
        q(paramResources);
        return null;
      }
      paramContext = localObject;
    } while (!p(paramResources));
    return o(paramResources);
  }
  
  public final Typeface a(Context paramContext, a.b paramb, Resources paramResources, int paramInt)
  {
    if (!cn()) {
      return super.a(paramContext, paramb, paramResources, paramInt);
    }
    paramResources = cm();
    paramb = paramb.zH;
    int j = paramb.length;
    paramInt = 0;
    while (paramInt < j)
    {
      Object localObject = paramb[paramInt];
      String str = localObject.mFileName;
      int k = localObject.zI;
      if (localObject.zJ) {}
      for (int i = 1; !a(paramContext, paramResources, str, k, i); i = 0)
      {
        q(paramResources);
        return null;
      }
      paramInt += 1;
    }
    if (!p(paramResources)) {
      return null;
    }
    return o(paramResources);
  }
  
  /* Error */
  public final Typeface a(Context paramContext, android.support.v4.d.b.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: arraylength
    //   2: ifgt +7 -> 9
    //   5: aconst_null
    //   6: astore_1
    //   7: aload_1
    //   8: areturn
    //   9: invokestatic 174	android/support/v4/a/g:cn	()Z
    //   12: ifne +131 -> 143
    //   15: aload_0
    //   16: aload_2
    //   17: iload_3
    //   18: invokevirtual 217	android/support/v4/a/g:a	([Landroid/support/v4/d/b$b;I)Landroid/support/v4/d/b$b;
    //   21: astore_2
    //   22: aload_1
    //   23: invokevirtual 221	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: astore_1
    //   27: aload_1
    //   28: aload_2
    //   29: getfield 227	android/support/v4/d/b$b:mUri	Landroid/net/Uri;
    //   32: ldc 229
    //   34: aconst_null
    //   35: invokevirtual 235	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   38: astore 9
    //   40: aload 9
    //   42: ifnonnull +15 -> 57
    //   45: aload 9
    //   47: ifnull +8 -> 55
    //   50: aload 9
    //   52: invokevirtual 240	android/os/ParcelFileDescriptor:close	()V
    //   55: aconst_null
    //   56: areturn
    //   57: new 242	android/graphics/Typeface$Builder
    //   60: dup
    //   61: aload 9
    //   63: invokevirtual 246	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   66: invokespecial 249	android/graphics/Typeface$Builder:<init>	(Ljava/io/FileDescriptor;)V
    //   69: aload_2
    //   70: getfield 250	android/support/v4/d/b$b:zI	I
    //   73: invokevirtual 254	android/graphics/Typeface$Builder:setWeight	(I)Landroid/graphics/Typeface$Builder;
    //   76: aload_2
    //   77: getfield 255	android/support/v4/d/b$b:zJ	Z
    //   80: invokevirtual 259	android/graphics/Typeface$Builder:setItalic	(Z)Landroid/graphics/Typeface$Builder;
    //   83: invokevirtual 263	android/graphics/Typeface$Builder:build	()Landroid/graphics/Typeface;
    //   86: astore_2
    //   87: aload_2
    //   88: astore_1
    //   89: aload 9
    //   91: ifnull -84 -> 7
    //   94: aload 9
    //   96: invokevirtual 240	android/os/ParcelFileDescriptor:close	()V
    //   99: aload_2
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: areturn
    //   104: astore_2
    //   105: aload_2
    //   106: athrow
    //   107: astore_1
    //   108: aload 9
    //   110: ifnull +12 -> 122
    //   113: aload_2
    //   114: ifnull +21 -> 135
    //   117: aload 9
    //   119: invokevirtual 240	android/os/ParcelFileDescriptor:close	()V
    //   122: aload_1
    //   123: athrow
    //   124: astore 9
    //   126: aload_2
    //   127: aload 9
    //   129: invokevirtual 266	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   132: goto -10 -> 122
    //   135: aload 9
    //   137: invokevirtual 240	android/os/ParcelFileDescriptor:close	()V
    //   140: goto -18 -> 122
    //   143: aload_1
    //   144: aload_2
    //   145: invokestatic 271	android/support/v4/d/b:a	(Landroid/content/Context;[Landroid/support/v4/d/b$b;)Ljava/util/Map;
    //   148: astore_1
    //   149: invokestatic 178	android/support/v4/a/g:cm	()Ljava/lang/Object;
    //   152: astore 9
    //   154: aload_2
    //   155: arraylength
    //   156: istore 6
    //   158: iconst_0
    //   159: istore 5
    //   161: iconst_0
    //   162: istore 4
    //   164: iload 5
    //   166: iload 6
    //   168: if_icmpge +96 -> 264
    //   171: aload_2
    //   172: iload 5
    //   174: aaload
    //   175: astore 10
    //   177: aload_1
    //   178: aload 10
    //   180: getfield 227	android/support/v4/d/b$b:mUri	Landroid/net/Uri;
    //   183: invokeinterface 277 2 0
    //   188: checkcast 56	java/nio/ByteBuffer
    //   191: astore 11
    //   193: aload 11
    //   195: ifnull +107 -> 302
    //   198: aload 10
    //   200: getfield 280	android/support/v4/d/b$b:Dn	I
    //   203: istore 7
    //   205: aload 10
    //   207: getfield 250	android/support/v4/d/b$b:zI	I
    //   210: istore 8
    //   212: aload 10
    //   214: getfield 255	android/support/v4/d/b$b:zJ	Z
    //   217: ifeq +29 -> 246
    //   220: iconst_1
    //   221: istore 4
    //   223: aload 9
    //   225: aload 11
    //   227: iload 7
    //   229: iload 8
    //   231: iload 4
    //   233: invokestatic 282	android/support/v4/a/g:a	(Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
    //   236: ifne +16 -> 252
    //   239: aload 9
    //   241: invokestatic 182	android/support/v4/a/g:q	(Ljava/lang/Object;)V
    //   244: aconst_null
    //   245: areturn
    //   246: iconst_0
    //   247: istore 4
    //   249: goto -26 -> 223
    //   252: iconst_1
    //   253: istore 4
    //   255: iload 5
    //   257: iconst_1
    //   258: iadd
    //   259: istore 5
    //   261: goto -97 -> 164
    //   264: iload 4
    //   266: ifne +10 -> 276
    //   269: aload 9
    //   271: invokestatic 182	android/support/v4/a/g:q	(Ljava/lang/Object;)V
    //   274: aconst_null
    //   275: areturn
    //   276: aload 9
    //   278: invokestatic 184	android/support/v4/a/g:p	(Ljava/lang/Object;)Z
    //   281: ifne +5 -> 286
    //   284: aconst_null
    //   285: areturn
    //   286: aload 9
    //   288: invokestatic 186	android/support/v4/a/g:o	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   291: iload_3
    //   292: invokestatic 286	android/graphics/Typeface:create	(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    //   295: areturn
    //   296: astore_1
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -191 -> 108
    //   302: goto -47 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	g
    //   0	305	1	paramContext	Context
    //   0	305	2	paramArrayOfb	android.support.v4.d.b.b[]
    //   0	305	3	paramInt	int
    //   162	103	4	i	int
    //   159	101	5	j	int
    //   156	13	6	k	int
    //   203	25	7	m	int
    //   210	20	8	n	int
    //   38	80	9	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   124	12	9	localThrowable	java.lang.Throwable
    //   152	135	9	localObject	Object
    //   175	38	10	localb	android.support.v4.d.b.b
    //   191	35	11	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   27	40	101	java/io/IOException
    //   50	55	101	java/io/IOException
    //   94	99	101	java/io/IOException
    //   117	122	101	java/io/IOException
    //   122	124	101	java/io/IOException
    //   126	132	101	java/io/IOException
    //   135	140	101	java/io/IOException
    //   57	87	104	java/lang/Throwable
    //   105	107	107	finally
    //   117	122	124	java/lang/Throwable
    //   57	87	296	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.a.g
 * JD-Core Version:    0.7.0.1
 */