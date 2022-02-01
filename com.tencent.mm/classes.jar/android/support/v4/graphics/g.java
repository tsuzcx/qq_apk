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
  protected final Class HY;
  protected final Constructor HZ;
  protected final Method Ia;
  protected final Method Ib;
  protected final Method Ic;
  protected final Method Ie;
  protected final Method If;
  
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
      Method localMethod1 = h(localClass);
      this.HY = localClass;
      this.HZ = localConstructor;
      this.Ia = localMethod5;
      this.Ib = localMethod4;
      this.Ic = localMethod3;
      this.Ie = localMethod2;
      this.If = localMethod1;
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
      boolean bool = ((Boolean)this.Ia.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.FALSE, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramArrayOfFontVariationAxis })).booleanValue();
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
      boolean bool = ((Boolean)this.Ib.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
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
  
  private Object eb()
  {
    try
    {
      Object localObject = this.HZ.newInstance(new Object[0]);
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
  
  private boolean eg()
  {
    return this.Ia != null;
  }
  
  private boolean q(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)this.Ic.invoke(paramObject, new Object[0])).booleanValue();
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
  
  private void r(Object paramObject)
  {
    try
    {
      this.Ie.invoke(paramObject, new Object[0]);
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
    if (!eg()) {
      paramContext = super.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    do
    {
      return paramContext;
      paramResources = eb();
      if (!a(paramContext, paramResources, paramString, 0, -1, -1, null))
      {
        r(paramResources);
        return null;
      }
      paramContext = localObject;
    } while (!q(paramResources));
    return p(paramResources);
  }
  
  public final Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt)
  {
    if (!eg()) {
      return super.a(paramContext, paramb, paramResources, paramInt);
    }
    paramResources = eb();
    paramb = paramb.HB;
    int j = paramb.length;
    paramInt = 0;
    while (paramInt < j)
    {
      Object localObject = paramb[paramInt];
      String str = localObject.mFileName;
      int k = localObject.HF;
      int m = localObject.HC;
      if (localObject.HD) {}
      for (int i = 1; !a(paramContext, paramResources, str, k, m, i, FontVariationAxis.fromFontVariationSettings(localObject.HE)); i = 0)
      {
        r(paramResources);
        return null;
      }
      paramInt += 1;
    }
    if (!q(paramResources)) {
      return null;
    }
    return p(paramResources);
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
    //   10: invokespecial 156	android/support/v4/graphics/g:eg	()Z
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
    //   71: getfield 245	android/support/v4/c/b$b:HC	I
    //   74: invokevirtual 249	android/graphics/Typeface$Builder:setWeight	(I)Landroid/graphics/Typeface$Builder;
    //   77: aload_2
    //   78: getfield 250	android/support/v4/c/b$b:HD	Z
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
    //   146: invokestatic 266	android/support/v4/c/b:a	(Landroid/content/Context;[Landroid/support/v4/c/b$b;)Ljava/util/Map;
    //   149: astore_1
    //   150: aload_0
    //   151: invokespecial 160	android/support/v4/graphics/g:eb	()Ljava/lang/Object;
    //   154: astore 9
    //   156: aload_2
    //   157: arraylength
    //   158: istore 6
    //   160: iconst_0
    //   161: istore 4
    //   163: iconst_0
    //   164: istore 5
    //   166: iload 4
    //   168: iload 6
    //   170: if_icmpge +98 -> 268
    //   173: aload_2
    //   174: iload 4
    //   176: aaload
    //   177: astore 10
    //   179: aload_1
    //   180: aload 10
    //   182: getfield 223	android/support/v4/c/b$b:mUri	Landroid/net/Uri;
    //   185: invokeinterface 272 2 0
    //   190: checkcast 58	java/nio/ByteBuffer
    //   193: astore 11
    //   195: aload 11
    //   197: ifnull +62 -> 259
    //   200: aload 10
    //   202: getfield 273	android/support/v4/c/b$b:HF	I
    //   205: istore 7
    //   207: aload 10
    //   209: getfield 245	android/support/v4/c/b$b:HC	I
    //   212: istore 8
    //   214: aload 10
    //   216: getfield 250	android/support/v4/c/b$b:HD	Z
    //   219: ifeq +31 -> 250
    //   222: iconst_1
    //   223: istore 5
    //   225: aload_0
    //   226: aload 9
    //   228: aload 11
    //   230: iload 7
    //   232: iload 8
    //   234: iload 5
    //   236: invokespecial 275	android/support/v4/graphics/g:a	(Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
    //   239: ifne +17 -> 256
    //   242: aload_0
    //   243: aload 9
    //   245: invokespecial 164	android/support/v4/graphics/g:r	(Ljava/lang/Object;)V
    //   248: aconst_null
    //   249: areturn
    //   250: iconst_0
    //   251: istore 5
    //   253: goto -28 -> 225
    //   256: iconst_1
    //   257: istore 5
    //   259: iload 4
    //   261: iconst_1
    //   262: iadd
    //   263: istore 4
    //   265: goto -99 -> 166
    //   268: iload 5
    //   270: ifne +11 -> 281
    //   273: aload_0
    //   274: aload 9
    //   276: invokespecial 164	android/support/v4/graphics/g:r	(Ljava/lang/Object;)V
    //   279: aconst_null
    //   280: areturn
    //   281: aload_0
    //   282: aload 9
    //   284: invokespecial 166	android/support/v4/graphics/g:q	(Ljava/lang/Object;)Z
    //   287: ifne +5 -> 292
    //   290: aconst_null
    //   291: areturn
    //   292: aload_0
    //   293: aload 9
    //   295: invokevirtual 170	android/support/v4/graphics/g:p	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   298: iload_3
    //   299: invokestatic 281	android/graphics/Typeface:create	(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    //   302: areturn
    //   303: astore_1
    //   304: aconst_null
    //   305: astore_2
    //   306: goto -197 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	g
    //   0	309	1	paramContext	Context
    //   0	309	2	paramArrayOfb	android.support.v4.c.b.b[]
    //   0	309	3	paramInt	int
    //   161	103	4	i	int
    //   164	105	5	j	int
    //   158	13	6	k	int
    //   205	26	7	m	int
    //   212	21	8	n	int
    //   39	80	9	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   125	12	9	localThrowable	java.lang.Throwable
    //   154	140	9	localObject	Object
    //   177	38	10	localb	android.support.v4.c.b.b
    //   193	36	11	localByteBuffer	ByteBuffer
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
    //   58	88	303	finally
  }
  
  protected Method h(Class paramClass)
  {
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    return paramClass;
  }
  
  protected Typeface p(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.HY, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.If.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
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