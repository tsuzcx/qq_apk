package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import androidx.core.content.a.c.b;
import androidx.core.content.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class f
  extends k
{
  private static Class<?> bqC;
  private static Constructor<?> bqD;
  private static Method bqE;
  private static Method bqF;
  private static boolean bqG = false;
  
  private static Object DH()
  {
    AppMethodBeat.i(196066);
    init();
    try
    {
      Object localObject = bqD.newInstance(new Object[0]);
      AppMethodBeat.o(196066);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      RuntimeException localRuntimeException = new RuntimeException(localInstantiationException);
      AppMethodBeat.o(196066);
      throw localRuntimeException;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label27;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label27:
      break label27;
    }
  }
  
  private static File a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(196054);
    try
    {
      paramParcelFileDescriptor = Os.readlink("/proc/self/fd/" + paramParcelFileDescriptor.getFd());
      if (OsConstants.S_ISREG(Os.stat(paramParcelFileDescriptor).st_mode))
      {
        paramParcelFileDescriptor = new File(paramParcelFileDescriptor);
        AppMethodBeat.o(196054);
        return paramParcelFileDescriptor;
      }
      AppMethodBeat.o(196054);
      return null;
    }
    catch (ErrnoException paramParcelFileDescriptor)
    {
      AppMethodBeat.o(196054);
    }
    return null;
  }
  
  private static boolean a(Object paramObject, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(196088);
    init();
    try
    {
      paramBoolean = ((Boolean)bqE.invoke(paramObject, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).booleanValue();
      AppMethodBeat.o(196088);
      return paramBoolean;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject = new RuntimeException(paramObject);
      AppMethodBeat.o(196088);
      throw paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      label52:
      break label52;
    }
  }
  
  private static Typeface aw(Object paramObject)
  {
    AppMethodBeat.i(196077);
    init();
    try
    {
      Object localObject = Array.newInstance(bqC, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)bqF.invoke(null, new Object[] { localObject });
      AppMethodBeat.o(196077);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject = new RuntimeException(paramObject);
      AppMethodBeat.o(196077);
      throw paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      label49:
      break label49;
    }
  }
  
  private static void init()
  {
    AppMethodBeat.i(196045);
    if (bqG)
    {
      AppMethodBeat.o(196045);
      return;
    }
    bqG = true;
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      localMethod2 = localClass.getMethod("addFontWeightStyle", new Class[] { String.class, Integer.TYPE, Boolean.TYPE });
      Method localMethod1 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass() });
      bqD = localConstructor;
      bqC = localClass;
      bqE = localMethod2;
      bqF = localMethod1;
      AppMethodBeat.o(196045);
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
      label110:
      break label110;
    }
  }
  
  public Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(196127);
    Object localObject = DH();
    c.c[] arrayOfc = paramb.bqf;
    int i = arrayOfc.length;
    paramInt = 0;
    while (paramInt < i)
    {
      c.c localc = arrayOfc[paramInt];
      paramb = l.ai(paramContext);
      if (paramb == null)
      {
        AppMethodBeat.o(196127);
        return null;
      }
      try
      {
        boolean bool = l.a(paramb, paramResources, localc.bqk);
        if (!bool) {
          return null;
        }
        bool = a(localObject, paramb.getPath(), localc.bqg, localc.bqh);
        if (!bool) {
          return null;
        }
        paramb.delete();
        paramInt += 1;
      }
      catch (RuntimeException paramContext)
      {
        return null;
      }
      finally
      {
        paramb.delete();
        AppMethodBeat.o(196127);
      }
    }
    paramContext = aw(localObject);
    AppMethodBeat.o(196127);
    return paramContext;
  }
  
  /* Error */
  public Typeface a(Context paramContext, androidx.core.d.e.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: ldc 235
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: arraylength
    //   7: ifgt +10 -> 17
    //   10: ldc 235
    //   12: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: aload_2
    //   19: iload_3
    //   20: invokevirtual 238	androidx/core/graphics/f:a	([Landroidx/core/d/e$b;I)Landroidx/core/d/e$b;
    //   23: astore_2
    //   24: aload_1
    //   25: invokevirtual 244	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: astore 4
    //   30: aload 4
    //   32: aload_2
    //   33: getfield 250	androidx/core/d/e$b:mUri	Landroid/net/Uri;
    //   36: ldc 252
    //   38: aconst_null
    //   39: invokevirtual 258	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnonnull +18 -> 62
    //   47: aload_2
    //   48: ifnull +7 -> 55
    //   51: aload_2
    //   52: invokevirtual 261	android/os/ParcelFileDescriptor:close	()V
    //   55: ldc 235
    //   57: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aconst_null
    //   61: areturn
    //   62: aload_2
    //   63: invokestatic 263	androidx/core/graphics/f:a	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +11 -> 81
    //   73: aload 4
    //   75: invokevirtual 266	java/io/File:canRead	()Z
    //   78: ifne +92 -> 170
    //   81: new 268	java/io/FileInputStream
    //   84: dup
    //   85: aload_2
    //   86: invokevirtual 272	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   89: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   92: astore 4
    //   94: aload_0
    //   95: aload_1
    //   96: aload 4
    //   98: invokespecial 278	androidx/core/graphics/k:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   101: astore_1
    //   102: aload 4
    //   104: invokevirtual 279	java/io/FileInputStream:close	()V
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 261	android/os/ParcelFileDescriptor:close	()V
    //   115: ldc 235
    //   117: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: areturn
    //   122: astore_1
    //   123: aload 4
    //   125: invokevirtual 279	java/io/FileInputStream:close	()V
    //   128: ldc 235
    //   130: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 261	android/os/ParcelFileDescriptor:close	()V
    //   144: ldc 235
    //   146: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: ldc 235
    //   154: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aconst_null
    //   158: areturn
    //   159: astore 4
    //   161: aload_1
    //   162: aload 4
    //   164: invokevirtual 284	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   167: goto -39 -> 128
    //   170: aload 4
    //   172: invokestatic 288	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   175: astore_1
    //   176: aload_2
    //   177: ifnull +7 -> 184
    //   180: aload_2
    //   181: invokevirtual 261	android/os/ParcelFileDescriptor:close	()V
    //   184: ldc 235
    //   186: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_1
    //   190: areturn
    //   191: astore_2
    //   192: aload_1
    //   193: aload_2
    //   194: invokevirtual 284	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   197: goto -53 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	f
    //   0	200	1	paramContext	Context
    //   0	200	2	paramArrayOfb	androidx.core.d.e.b[]
    //   0	200	3	paramInt	int
    //   28	96	4	localObject	Object
    //   159	12	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   94	102	122	finally
    //   62	68	135	finally
    //   73	81	135	finally
    //   81	94	135	finally
    //   102	107	135	finally
    //   128	135	135	finally
    //   161	167	135	finally
    //   170	176	135	finally
    //   30	43	151	java/io/IOException
    //   51	55	151	java/io/IOException
    //   111	115	151	java/io/IOException
    //   144	151	151	java/io/IOException
    //   180	184	151	java/io/IOException
    //   192	197	151	java/io/IOException
    //   123	128	159	finally
    //   140	144	191	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.graphics.f
 * JD-Core Version:    0.7.0.1
 */