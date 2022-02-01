package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.v4.content.a.c.b;
import android.support.v4.content.a.c.c;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class g
  extends e
{
  protected final Class Kb;
  protected final Constructor Kc;
  protected final Method Kd;
  protected final Method Ke;
  protected final Method Kf;
  protected final Method Kg;
  protected final Method Kh;
  
  public g()
  {
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      localMethod5 = localClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, [Landroid.graphics.fonts.FontVariationAxis.class });
      localMethod4 = localClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, Integer.TYPE, [Landroid.graphics.fonts.FontVariationAxis.class, Integer.TYPE, Integer.TYPE });
      localMethod3 = localClass.getMethod("freeze", new Class[0]);
      localMethod2 = localClass.getMethod("abortCreation", new Class[0]);
      Method localMethod1 = i(localClass);
      this.Kb = localClass;
      this.Kc = localConstructor;
      this.Kd = localMethod5;
      this.Ke = localMethod4;
      this.Kf = localMethod3;
      this.Kg = localMethod2;
      this.Kh = localMethod1;
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
      label196:
      break label196;
    }
  }
  
  private boolean a(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, FontVariationAxis[] paramArrayOfFontVariationAxis)
  {
    try
    {
      boolean bool = ((Boolean)this.Kd.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.FALSE, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramArrayOfFontVariationAxis })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      label80:
      break label80;
    }
  }
  
  private boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)this.Ke.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label55:
      break label55;
    }
  }
  
  private Object eA()
  {
    try
    {
      Object localObject = this.Kc.newInstance(new Object[0]);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label15;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label15:
      break label15;
    }
  }
  
  private boolean eB()
  {
    return this.Kd != null;
  }
  
  private boolean r(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)this.Kf.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label22:
      break label22;
    }
  }
  
  private void s(Object paramObject)
  {
    try
    {
      this.Kg.invoke(paramObject, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label15:
      break label15;
    }
  }
  
  public final Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = null;
    if (!eB()) {
      paramContext = super.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    do
    {
      return paramContext;
      paramResources = eA();
      if (!a(paramContext, paramResources, paramString, 0, -1, -1, null))
      {
        s(paramResources);
        return null;
      }
      paramContext = localObject;
    } while (!r(paramResources));
    return q(paramResources);
  }
  
  public final Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt)
  {
    if (!eB()) {
      return super.a(paramContext, paramb, paramResources, paramInt);
    }
    paramResources = eA();
    paramb = paramb.JE;
    int j = paramb.length;
    paramInt = 0;
    while (paramInt < j)
    {
      Object localObject = paramb[paramInt];
      String str = localObject.mFileName;
      int k = localObject.JI;
      int m = localObject.JF;
      if (localObject.JG) {}
      for (int i = 1; !a(paramContext, paramResources, str, k, m, i, FontVariationAxis.fromFontVariationSettings(localObject.JH)); i = 0)
      {
        s(paramResources);
        return null;
      }
      paramInt += 1;
    }
    if (!r(paramResources)) {
      return null;
    }
    return q(paramResources);
  }
  
  /* Error */
  public final Typeface a(Context paramContext, android.support.v4.c.b.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: arraylength
    //   2: ifgt +7 -> 9
    //   5: aconst_null
    //   6: astore_1
    //   7: aload_1
    //   8: areturn
    //   9: aload_0
    //   10: invokespecial 156	android/support/v4/graphics/g:eB	()Z
    //   13: ifne +131 -> 144
    //   16: aload_0
    //   17: aload_2
    //   18: iload_3
    //   19: invokevirtual 213	android/support/v4/graphics/g:a	([Landroid/support/v4/c/b$b;I)Landroid/support/v4/c/b$b;
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 217	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   27: astore_1
    //   28: aload_1
    //   29: aload_2
    //   30: getfield 223	android/support/v4/c/b$b:mUri	Landroid/net/Uri;
    //   33: ldc 224
    //   35: aconst_null
    //   36: invokevirtual 230	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   39: astore 9
    //   41: aload 9
    //   43: ifnonnull +15 -> 58
    //   46: aload 9
    //   48: ifnull +8 -> 56
    //   51: aload 9
    //   53: invokevirtual 235	android/os/ParcelFileDescriptor:close	()V
    //   56: aconst_null
    //   57: areturn
    //   58: new 237	android/graphics/Typeface$Builder
    //   61: dup
    //   62: aload 9
    //   64: invokevirtual 241	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   67: invokespecial 244	android/graphics/Typeface$Builder:<init>	(Ljava/io/FileDescriptor;)V
    //   70: aload_2
    //   71: getfield 245	android/support/v4/c/b$b:JF	I
    //   74: invokevirtual 249	android/graphics/Typeface$Builder:setWeight	(I)Landroid/graphics/Typeface$Builder;
    //   77: aload_2
    //   78: getfield 250	android/support/v4/c/b$b:JG	Z
    //   81: invokevirtual 254	android/graphics/Typeface$Builder:setItalic	(Z)Landroid/graphics/Typeface$Builder;
    //   84: invokevirtual 258	android/graphics/Typeface$Builder:build	()Landroid/graphics/Typeface;
    //   87: astore_2
    //   88: aload_2
    //   89: astore_1
    //   90: aload 9
    //   92: ifnull -85 -> 7
    //   95: aload 9
    //   97: invokevirtual 235	android/os/ParcelFileDescriptor:close	()V
    //   100: aload_2
    //   101: areturn
    //   102: astore_1
    //   103: aconst_null
    //   104: areturn
    //   105: astore_2
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: aload 9
    //   111: ifnull +12 -> 123
    //   114: aload_2
    //   115: ifnull +21 -> 136
    //   118: aload 9
    //   120: invokevirtual 235	android/os/ParcelFileDescriptor:close	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore 9
    //   127: aload_2
    //   128: aload 9
    //   130: invokevirtual 261	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   133: goto -10 -> 123
    //   136: aload 9
    //   138: invokevirtual 235	android/os/ParcelFileDescriptor:close	()V
    //   141: goto -18 -> 123
    //   144: aload_1
    //   145: aload_2
    //   146: aconst_null
    //   147: invokestatic 266	android/support/v4/c/b:a	(Landroid/content/Context;[Landroid/support/v4/c/b$b;Landroid/os/CancellationSignal;)Ljava/util/Map;
    //   150: astore_1
    //   151: aload_0
    //   152: invokespecial 160	android/support/v4/graphics/g:eA	()Ljava/lang/Object;
    //   155: astore 9
    //   157: aload_2
    //   158: arraylength
    //   159: istore 6
    //   161: iconst_0
    //   162: istore 4
    //   164: iconst_0
    //   165: istore 5
    //   167: iload 4
    //   169: iload 6
    //   171: if_icmpge +98 -> 269
    //   174: aload_2
    //   175: iload 4
    //   177: aaload
    //   178: astore 10
    //   180: aload_1
    //   181: aload 10
    //   183: getfield 223	android/support/v4/c/b$b:mUri	Landroid/net/Uri;
    //   186: invokeinterface 272 2 0
    //   191: checkcast 58	java/nio/ByteBuffer
    //   194: astore 11
    //   196: aload 11
    //   198: ifnull +62 -> 260
    //   201: aload 10
    //   203: getfield 273	android/support/v4/c/b$b:JI	I
    //   206: istore 7
    //   208: aload 10
    //   210: getfield 245	android/support/v4/c/b$b:JF	I
    //   213: istore 8
    //   215: aload 10
    //   217: getfield 250	android/support/v4/c/b$b:JG	Z
    //   220: ifeq +31 -> 251
    //   223: iconst_1
    //   224: istore 5
    //   226: aload_0
    //   227: aload 9
    //   229: aload 11
    //   231: iload 7
    //   233: iload 8
    //   235: iload 5
    //   237: invokespecial 275	android/support/v4/graphics/g:a	(Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
    //   240: ifne +17 -> 257
    //   243: aload_0
    //   244: aload 9
    //   246: invokespecial 164	android/support/v4/graphics/g:s	(Ljava/lang/Object;)V
    //   249: aconst_null
    //   250: areturn
    //   251: iconst_0
    //   252: istore 5
    //   254: goto -28 -> 226
    //   257: iconst_1
    //   258: istore 5
    //   260: iload 4
    //   262: iconst_1
    //   263: iadd
    //   264: istore 4
    //   266: goto -99 -> 167
    //   269: iload 5
    //   271: ifne +11 -> 282
    //   274: aload_0
    //   275: aload 9
    //   277: invokespecial 164	android/support/v4/graphics/g:s	(Ljava/lang/Object;)V
    //   280: aconst_null
    //   281: areturn
    //   282: aload_0
    //   283: aload 9
    //   285: invokespecial 166	android/support/v4/graphics/g:r	(Ljava/lang/Object;)Z
    //   288: ifne +5 -> 293
    //   291: aconst_null
    //   292: areturn
    //   293: aload_0
    //   294: aload 9
    //   296: invokevirtual 170	android/support/v4/graphics/g:q	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   299: iload_3
    //   300: invokestatic 281	android/graphics/Typeface:create	(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    //   303: areturn
    //   304: astore_1
    //   305: aconst_null
    //   306: astore_2
    //   307: goto -198 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	g
    //   0	310	1	paramContext	Context
    //   0	310	2	paramArrayOfb	android.support.v4.c.b.b[]
    //   0	310	3	paramInt	int
    //   162	103	4	i	int
    //   165	105	5	j	int
    //   159	13	6	k	int
    //   206	26	7	m	int
    //   213	21	8	n	int
    //   39	80	9	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   125	12	9	localThrowable	java.lang.Throwable
    //   155	140	9	localObject	Object
    //   178	38	10	localb	android.support.v4.c.b.b
    //   194	36	11	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   28	41	102	java/io/IOException
    //   51	56	102	java/io/IOException
    //   95	100	102	java/io/IOException
    //   118	123	102	java/io/IOException
    //   123	125	102	java/io/IOException
    //   127	133	102	java/io/IOException
    //   136	141	102	java/io/IOException
    //   58	88	105	java/lang/Throwable
    //   106	108	108	finally
    //   118	123	125	java/lang/Throwable
    //   58	88	304	finally
  }
  
  protected Method i(Class paramClass)
  {
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    return paramClass;
  }
  
  protected Typeface q(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.Kb, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.Kh.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      label52:
      break label52;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.graphics.g
 * JD-Core Version:    0.7.0.1
 */