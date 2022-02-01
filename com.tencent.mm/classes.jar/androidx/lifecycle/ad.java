package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.savedstate.b;
import androidx.savedstate.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public final class ad
  extends ah.c
{
  private static final Class<?>[] bIp = { Application.class, ac.class };
  private static final Class<?>[] bIq = { ac.class };
  private final Application bGP;
  private final ah.b bIm;
  private final Bundle bIn;
  private final b bIo;
  private final j ez;
  
  public ad(Application paramApplication, d paramd, Bundle paramBundle)
  {
    AppMethodBeat.i(194442);
    this.bIo = paramd.getSavedStateRegistry();
    this.ez = paramd.getLifecycle();
    this.bIn = paramBundle;
    this.bGP = paramApplication;
    if (paramApplication != null) {}
    for (paramApplication = ah.a.a(paramApplication);; paramApplication = ah.d.bIw)
    {
      this.bIm = paramApplication;
      AppMethodBeat.o(194442);
      return;
      if (ah.d.bIw == null) {
        ah.d.bIw = new ah.d();
      }
    }
  }
  
  private static <T> Constructor<T> a(Class<T> paramClass, Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(194455);
    paramClass = paramClass.getConstructors();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Constructor<T> localConstructor = paramClass[i];
      if (Arrays.equals(paramArrayOfClass, localConstructor.getParameterTypes()))
      {
        AppMethodBeat.o(194455);
        return localConstructor;
      }
      i += 1;
    }
    AppMethodBeat.o(194455);
    return null;
  }
  
  final void a(af paramaf)
  {
    AppMethodBeat.i(194491);
    SavedStateHandleController.a(paramaf, this.bIo, this.ez);
    AppMethodBeat.o(194491);
  }
  
  /* Error */
  public final <T extends af> T c(String paramString, Class<T> paramClass)
  {
    // Byte code:
    //   0: ldc 114
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 116
    //   7: aload_2
    //   8: invokevirtual 120	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   11: istore_3
    //   12: iload_3
    //   13: ifeq +42 -> 55
    //   16: aload_0
    //   17: getfield 60	androidx/lifecycle/ad:bGP	Landroid/app/Application;
    //   20: ifnull +35 -> 55
    //   23: aload_2
    //   24: getstatic 28	androidx/lifecycle/ad:bIp	[Ljava/lang/Class;
    //   27: invokestatic 122	androidx/lifecycle/ad:a	(Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnonnull +33 -> 67
    //   37: aload_0
    //   38: getfield 68	androidx/lifecycle/ad:bIm	Landroidx/lifecycle/ah$b;
    //   41: aload_2
    //   42: invokeinterface 128 2 0
    //   47: astore_1
    //   48: ldc 114
    //   50: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_1
    //   54: areturn
    //   55: aload_2
    //   56: getstatic 30	androidx/lifecycle/ad:bIq	[Ljava/lang/Class;
    //   59: invokestatic 122	androidx/lifecycle/ad:a	(Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   62: astore 4
    //   64: goto -32 -> 32
    //   67: aload_0
    //   68: getfield 50	androidx/lifecycle/ad:bIo	Landroidx/savedstate/b;
    //   71: aload_0
    //   72: getfield 56	androidx/lifecycle/ad:ez	Landroidx/lifecycle/j;
    //   75: aload_1
    //   76: aload_0
    //   77: getfield 58	androidx/lifecycle/ad:bIn	Landroid/os/Bundle;
    //   80: invokestatic 131	androidx/lifecycle/SavedStateHandleController:a	(Landroidx/savedstate/b;Landroidx/lifecycle/j;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/lifecycle/SavedStateHandleController;
    //   83: astore 5
    //   85: iload_3
    //   86: ifeq +54 -> 140
    //   89: aload_0
    //   90: getfield 60	androidx/lifecycle/ad:bGP	Landroid/app/Application;
    //   93: ifnull +47 -> 140
    //   96: aload 4
    //   98: iconst_2
    //   99: anewarray 133	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_0
    //   105: getfield 60	androidx/lifecycle/ad:bGP	Landroid/app/Application;
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload 5
    //   113: getfield 137	androidx/lifecycle/SavedStateHandleController:bIk	Landroidx/lifecycle/ac;
    //   116: aastore
    //   117: invokevirtual 141	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast 143	androidx/lifecycle/af
    //   123: astore_1
    //   124: aload_1
    //   125: ldc 145
    //   127: aload 5
    //   129: invokevirtual 149	androidx/lifecycle/af:setTagIfAbsent	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: ldc 114
    //   135: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_1
    //   139: areturn
    //   140: aload 4
    //   142: iconst_1
    //   143: anewarray 133	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload 5
    //   150: getfield 137	androidx/lifecycle/SavedStateHandleController:bIk	Landroidx/lifecycle/ac;
    //   153: aastore
    //   154: invokevirtual 141	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   157: checkcast 143	androidx/lifecycle/af
    //   160: astore_1
    //   161: goto -37 -> 124
    //   164: astore_1
    //   165: new 151	java/lang/RuntimeException
    //   168: dup
    //   169: ldc 153
    //   171: aload_2
    //   172: invokestatic 159	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   175: invokevirtual 163	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   178: aload_1
    //   179: invokespecial 166	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   182: astore_1
    //   183: ldc 114
    //   185: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: athrow
    //   190: astore_1
    //   191: new 151	java/lang/RuntimeException
    //   194: dup
    //   195: new 168	java/lang/StringBuilder
    //   198: dup
    //   199: ldc 170
    //   201: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload_2
    //   205: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   208: ldc 179
    //   210: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: aload_1
    //   217: invokespecial 166	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: astore_1
    //   221: ldc 114
    //   223: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_1
    //   227: athrow
    //   228: astore_1
    //   229: new 151	java/lang/RuntimeException
    //   232: dup
    //   233: ldc 188
    //   235: aload_2
    //   236: invokestatic 159	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   239: invokevirtual 163	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   242: aload_1
    //   243: invokevirtual 192	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   246: invokespecial 166	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   249: astore_1
    //   250: ldc 114
    //   252: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload_1
    //   256: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	ad
    //   0	257	1	paramString	String
    //   0	257	2	paramClass	Class<T>
    //   11	75	3	bool	boolean
    //   30	111	4	localConstructor	Constructor
    //   83	66	5	localSavedStateHandleController	SavedStateHandleController
    // Exception table:
    //   from	to	target	type
    //   89	124	164	java/lang/IllegalAccessException
    //   124	133	164	java/lang/IllegalAccessException
    //   140	161	164	java/lang/IllegalAccessException
    //   89	124	190	java/lang/InstantiationException
    //   124	133	190	java/lang/InstantiationException
    //   140	161	190	java/lang/InstantiationException
    //   89	124	228	java/lang/reflect/InvocationTargetException
    //   124	133	228	java/lang/reflect/InvocationTargetException
    //   140	161	228	java/lang/reflect/InvocationTargetException
  }
  
  public final <T extends af> T create(Class<T> paramClass)
  {
    AppMethodBeat.i(194483);
    String str = paramClass.getCanonicalName();
    if (str == null)
    {
      paramClass = new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
      AppMethodBeat.o(194483);
      throw paramClass;
    }
    paramClass = c(str, paramClass);
    AppMethodBeat.o(194483);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.ad
 * JD-Core Version:    0.7.0.1
 */