package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import androidx.core.content.a.c.b;
import androidx.core.content.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class h
  extends f
{
  protected final Constructor<?> KA;
  protected final Method KB;
  protected final Method KC;
  protected final Method KD;
  protected final Method KE;
  protected final Method KF;
  protected final Class<?> Kz;
  
  public h()
  {
    AppMethodBeat.i(250744);
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      localMethod5 = localClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, [Landroid.graphics.fonts.FontVariationAxis.class });
      localMethod4 = localClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, Integer.TYPE, [Landroid.graphics.fonts.FontVariationAxis.class, Integer.TYPE, Integer.TYPE });
      localMethod3 = localClass.getMethod("freeze", new Class[0]);
      localMethod2 = localClass.getMethod("abortCreation", new Class[0]);
      Method localMethod1 = a(localClass);
      this.Kz = localClass;
      this.KA = localConstructor;
      this.KB = localMethod5;
      this.KC = localMethod4;
      this.KD = localMethod3;
      this.KE = localMethod2;
      this.KF = localMethod1;
      AppMethodBeat.o(250744);
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
      label206:
      break label206;
    }
  }
  
  private boolean a(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, FontVariationAxis[] paramArrayOfFontVariationAxis)
  {
    AppMethodBeat.i(250749);
    try
    {
      boolean bool = ((Boolean)this.KB.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.FALSE, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramArrayOfFontVariationAxis })).booleanValue();
      AppMethodBeat.o(250749);
      return bool;
    }
    catch (IllegalAccessException paramContext)
    {
      AppMethodBeat.o(250749);
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      label90:
      break label90;
    }
  }
  
  private boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(250752);
    try
    {
      boolean bool = ((Boolean)this.KC.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
      AppMethodBeat.o(250752);
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(250752);
      return false;
    }
    catch (InvocationTargetException paramObject)
    {
      label65:
      break label65;
    }
  }
  
  private Object gw()
  {
    AppMethodBeat.i(250747);
    try
    {
      Object localObject = this.KA.newInstance(new Object[0]);
      AppMethodBeat.o(250747);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      AppMethodBeat.o(250747);
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label25;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label25:
      break label25;
    }
  }
  
  private boolean gy()
  {
    return this.KB != null;
  }
  
  private boolean y(Object paramObject)
  {
    AppMethodBeat.i(250756);
    try
    {
      boolean bool = ((Boolean)this.KD.invoke(paramObject, new Object[0])).booleanValue();
      AppMethodBeat.o(250756);
      return bool;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(250756);
      return false;
    }
    catch (InvocationTargetException paramObject)
    {
      label32:
      break label32;
    }
  }
  
  private void z(Object paramObject)
  {
    AppMethodBeat.i(250758);
    try
    {
      this.KE.invoke(paramObject, new Object[0]);
      AppMethodBeat.o(250758);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(250758);
      return;
    }
    catch (InvocationTargetException paramObject)
    {
      label25:
      break label25;
    }
  }
  
  public final Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(250761);
    if (!gy())
    {
      paramContext = super.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
      AppMethodBeat.o(250761);
      return paramContext;
    }
    paramResources = gw();
    if (paramResources == null)
    {
      AppMethodBeat.o(250761);
      return null;
    }
    if (!a(paramContext, paramResources, paramString, 0, -1, -1, null))
    {
      z(paramResources);
      AppMethodBeat.o(250761);
      return null;
    }
    if (!y(paramResources))
    {
      AppMethodBeat.o(250761);
      return null;
    }
    paramContext = x(paramResources);
    AppMethodBeat.o(250761);
    return paramContext;
  }
  
  public final Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(250759);
    if (!gy())
    {
      paramContext = super.a(paramContext, paramb, paramResources, paramInt);
      AppMethodBeat.o(250759);
      return paramContext;
    }
    paramResources = gw();
    if (paramResources == null)
    {
      AppMethodBeat.o(250759);
      return null;
    }
    paramb = paramb.Ka;
    int j = paramb.length;
    paramInt = 0;
    while (paramInt < j)
    {
      Object localObject = paramb[paramInt];
      String str = localObject.mFileName;
      int k = localObject.Ke;
      int m = localObject.Kb;
      if (localObject.Kc) {}
      for (int i = 1; !a(paramContext, paramResources, str, k, m, i, FontVariationAxis.fromFontVariationSettings(localObject.Kd)); i = 0)
      {
        z(paramResources);
        AppMethodBeat.o(250759);
        return null;
      }
      paramInt += 1;
    }
    if (!y(paramResources))
    {
      AppMethodBeat.o(250759);
      return null;
    }
    paramContext = x(paramResources);
    AppMethodBeat.o(250759);
    return paramContext;
  }
  
  /* Error */
  public final Typeface a(Context paramContext, androidx.core.d.b.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: arraylength
    //   7: ifgt +10 -> 17
    //   10: ldc 224
    //   12: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: invokespecial 168	androidx/core/graphics/h:gy	()Z
    //   21: ifne +123 -> 144
    //   24: aload_0
    //   25: aload_2
    //   26: iload_3
    //   27: invokevirtual 227	androidx/core/graphics/h:a	([Landroidx/core/d/b$b;I)Landroidx/core/d/b$b;
    //   30: astore_2
    //   31: aload_1
    //   32: invokevirtual 231	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: astore_1
    //   36: aload_1
    //   37: aload_2
    //   38: getfield 237	androidx/core/d/b$b:mUri	Landroid/net/Uri;
    //   41: ldc 239
    //   43: aconst_null
    //   44: invokevirtual 245	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnonnull +18 -> 67
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 250	android/os/ParcelFileDescriptor:close	()V
    //   60: ldc 224
    //   62: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aconst_null
    //   66: areturn
    //   67: new 252	android/graphics/Typeface$Builder
    //   70: dup
    //   71: aload_1
    //   72: invokevirtual 256	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   75: invokespecial 259	android/graphics/Typeface$Builder:<init>	(Ljava/io/FileDescriptor;)V
    //   78: aload_2
    //   79: getfield 260	androidx/core/d/b$b:Kb	I
    //   82: invokevirtual 264	android/graphics/Typeface$Builder:setWeight	(I)Landroid/graphics/Typeface$Builder;
    //   85: aload_2
    //   86: getfield 265	androidx/core/d/b$b:Kc	Z
    //   89: invokevirtual 269	android/graphics/Typeface$Builder:setItalic	(Z)Landroid/graphics/Typeface$Builder;
    //   92: invokevirtual 273	android/graphics/Typeface$Builder:build	()Landroid/graphics/Typeface;
    //   95: astore_2
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 250	android/os/ParcelFileDescriptor:close	()V
    //   104: ldc 224
    //   106: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_2
    //   110: areturn
    //   111: astore_2
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 250	android/os/ParcelFileDescriptor:close	()V
    //   120: ldc 224
    //   122: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_2
    //   126: athrow
    //   127: astore_1
    //   128: ldc 224
    //   130: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aconst_null
    //   134: areturn
    //   135: astore_1
    //   136: aload_2
    //   137: aload_1
    //   138: invokevirtual 277	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   141: goto -21 -> 120
    //   144: aload_1
    //   145: aload_2
    //   146: aconst_null
    //   147: invokestatic 282	androidx/core/d/b:a	(Landroid/content/Context;[Landroidx/core/d/b$b;Landroid/os/CancellationSignal;)Ljava/util/Map;
    //   150: astore_1
    //   151: aload_0
    //   152: invokespecial 172	androidx/core/graphics/h:gw	()Ljava/lang/Object;
    //   155: astore 9
    //   157: aload 9
    //   159: ifnonnull +10 -> 169
    //   162: ldc 224
    //   164: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aconst_null
    //   168: areturn
    //   169: iconst_0
    //   170: istore 5
    //   172: aload_2
    //   173: arraylength
    //   174: istore 6
    //   176: iconst_0
    //   177: istore 4
    //   179: iload 4
    //   181: iload 6
    //   183: if_icmpge +103 -> 286
    //   186: aload_2
    //   187: iload 4
    //   189: aaload
    //   190: astore 10
    //   192: aload_1
    //   193: aload 10
    //   195: getfield 237	androidx/core/d/b$b:mUri	Landroid/net/Uri;
    //   198: invokeinterface 288 2 0
    //   203: checkcast 67	java/nio/ByteBuffer
    //   206: astore 11
    //   208: aload 11
    //   210: ifnull +67 -> 277
    //   213: aload 10
    //   215: getfield 289	androidx/core/d/b$b:Ke	I
    //   218: istore 7
    //   220: aload 10
    //   222: getfield 260	androidx/core/d/b$b:Kb	I
    //   225: istore 8
    //   227: aload 10
    //   229: getfield 265	androidx/core/d/b$b:Kc	Z
    //   232: ifeq +36 -> 268
    //   235: iconst_1
    //   236: istore 5
    //   238: aload_0
    //   239: aload 9
    //   241: aload 11
    //   243: iload 7
    //   245: iload 8
    //   247: iload 5
    //   249: invokespecial 291	androidx/core/graphics/h:a	(Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
    //   252: ifne +22 -> 274
    //   255: aload_0
    //   256: aload 9
    //   258: invokespecial 176	androidx/core/graphics/h:z	(Ljava/lang/Object;)V
    //   261: ldc 224
    //   263: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aconst_null
    //   267: areturn
    //   268: iconst_0
    //   269: istore 5
    //   271: goto -33 -> 238
    //   274: iconst_1
    //   275: istore 5
    //   277: iload 4
    //   279: iconst_1
    //   280: iadd
    //   281: istore 4
    //   283: goto -104 -> 179
    //   286: iload 5
    //   288: ifne +16 -> 304
    //   291: aload_0
    //   292: aload 9
    //   294: invokespecial 176	androidx/core/graphics/h:z	(Ljava/lang/Object;)V
    //   297: ldc 224
    //   299: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: aconst_null
    //   303: areturn
    //   304: aload_0
    //   305: aload 9
    //   307: invokespecial 178	androidx/core/graphics/h:y	(Ljava/lang/Object;)Z
    //   310: ifne +10 -> 320
    //   313: ldc 224
    //   315: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: aconst_null
    //   319: areturn
    //   320: aload_0
    //   321: aload 9
    //   323: invokevirtual 182	androidx/core/graphics/h:x	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   326: astore_1
    //   327: aload_1
    //   328: ifnonnull +10 -> 338
    //   331: ldc 224
    //   333: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aconst_null
    //   337: areturn
    //   338: aload_1
    //   339: iload_3
    //   340: invokestatic 297	android/graphics/Typeface:create	(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    //   343: astore_1
    //   344: ldc 224
    //   346: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aload_1
    //   350: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	h
    //   0	351	1	paramContext	Context
    //   0	351	2	paramArrayOfb	androidx.core.d.b.b[]
    //   0	351	3	paramInt	int
    //   177	105	4	i	int
    //   170	117	5	j	int
    //   174	10	6	k	int
    //   218	26	7	m	int
    //   225	21	8	n	int
    //   155	167	9	localObject	Object
    //   190	38	10	localb	androidx.core.d.b.b
    //   206	36	11	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   67	96	111	java/lang/Throwable
    //   36	48	127	java/io/IOException
    //   56	60	127	java/io/IOException
    //   67	96	127	java/io/IOException
    //   100	104	127	java/io/IOException
    //   116	120	127	java/io/IOException
    //   120	127	127	java/io/IOException
    //   136	141	127	java/io/IOException
    //   116	120	135	java/lang/Throwable
  }
  
  protected Method a(Class<?> paramClass)
  {
    AppMethodBeat.i(250762);
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    AppMethodBeat.o(250762);
    return paramClass;
  }
  
  protected Typeface x(Object paramObject)
  {
    AppMethodBeat.i(250754);
    try
    {
      Object localObject = Array.newInstance(this.Kz, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.KF.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      AppMethodBeat.o(250754);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      AppMethodBeat.o(250754);
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      label64:
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.graphics.h
 * JD-Core Version:    0.7.0.1
 */