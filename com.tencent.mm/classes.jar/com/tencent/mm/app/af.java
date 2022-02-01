package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.svg.a.e;

public final class af
{
  private static Class<?> hhL = null;
  private static Application hhM;
  private static String mPackageName = null;
  private static Resources sResources;
  
  public static void a(Application paramApplication, Resources paramResources)
  {
    AppMethodBeat.i(19471);
    e.c(paramApplication, mPackageName);
    hhM = paramApplication;
    sResources = paramResources;
    AppMethodBeat.o(19471);
  }
  
  /* Error */
  public static void aCS()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: sipush 19470
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 44
    //   10: ldc 46
    //   12: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: new 53	com/tencent/mm/app/af$1
    //   18: dup
    //   19: invokespecial 56	com/tencent/mm/app/af$1:<init>	()V
    //   22: invokestatic 59	com/tencent/mm/svg/a/e:a	(Lcom/tencent/mm/svg/b/c$a;)V
    //   25: getstatic 17	com/tencent/mm/app/af:hhL	Ljava/lang/Class;
    //   28: invokestatic 63	com/tencent/mm/svg/a/e:at	(Ljava/lang/Class;)V
    //   31: getstatic 36	com/tencent/mm/app/af:hhM	Landroid/app/Application;
    //   34: getstatic 38	com/tencent/mm/app/af:sResources	Landroid/content/res/Resources;
    //   37: getstatic 19	com/tencent/mm/app/af:mPackageName	Ljava/lang/String;
    //   40: invokestatic 66	com/tencent/mm/svg/a/e:a	(Landroid/app/Application;Landroid/content/res/Resources;Ljava/lang/String;)V
    //   43: getstatic 36	com/tencent/mm/app/af:hhM	Landroid/app/Application;
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 72	android/app/Application:getBaseContext	()Landroid/content/Context;
    //   51: invokevirtual 78	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   54: getstatic 84	com/tencent/mm/R$k:actionbar_icon	I
    //   57: invokevirtual 90	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +73 -> 135
    //   65: iconst_1
    //   66: istore_0
    //   67: invokestatic 96	com/tencent/mm/kiss/layout/b:bbG	()Lcom/tencent/mm/kiss/layout/b;
    //   70: astore_2
    //   71: iload_0
    //   72: ifne +15 -> 87
    //   75: aload_2
    //   76: iload_1
    //   77: putfield 100	com/tencent/mm/kiss/layout/b:mGi	Z
    //   80: sipush 19470
    //   83: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: return
    //   87: iconst_0
    //   88: istore_1
    //   89: goto -14 -> 75
    //   92: astore_2
    //   93: ldc 44
    //   95: aload_2
    //   96: ldc 102
    //   98: iconst_0
    //   99: anewarray 4	java/lang/Object
    //   102: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: invokestatic 96	com/tencent/mm/kiss/layout/b:bbG	()Lcom/tencent/mm/kiss/layout/b;
    //   108: iconst_1
    //   109: putfield 100	com/tencent/mm/kiss/layout/b:mGi	Z
    //   112: sipush 19470
    //   115: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: return
    //   119: astore_2
    //   120: invokestatic 96	com/tencent/mm/kiss/layout/b:bbG	()Lcom/tencent/mm/kiss/layout/b;
    //   123: iconst_1
    //   124: putfield 100	com/tencent/mm/kiss/layout/b:mGi	Z
    //   127: sipush 19470
    //   130: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_2
    //   134: athrow
    //   135: iconst_0
    //   136: istore_0
    //   137: goto -70 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   66	71	0	i	int
    //   1	88	1	bool	boolean
    //   46	30	2	localObject1	Object
    //   92	4	2	localThrowable	java.lang.Throwable
    //   119	15	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   47	61	92	finally
    //   93	105	119	finally
  }
  
  public static void at(Class<?> paramClass)
  {
    hhL = paramClass;
  }
  
  public static void setPackageName(String paramString)
  {
    mPackageName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.af
 * JD-Core Version:    0.7.0.1
 */