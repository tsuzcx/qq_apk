package com.bumptech.glide.c.d.c;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static volatile boolean aJg = true;
  
  public static Drawable a(Context paramContext, int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(77454);
    paramContext = a(paramContext, paramContext, paramInt, paramTheme);
    AppMethodBeat.o(77454);
    return paramContext;
  }
  
  /* Error */
  private static Drawable a(Context paramContext1, Context paramContext2, int paramInt, Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: ldc 33
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 10	com/bumptech/glide/c/d/c/a:aJg	Z
    //   8: ifeq +45 -> 53
    //   11: aload_3
    //   12: ifnull +30 -> 42
    //   15: new 35	android/support/v7/view/d
    //   18: dup
    //   19: aload_1
    //   20: aload_3
    //   21: invokespecial 39	android/support/v7/view/d:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   24: astore 4
    //   26: aload 4
    //   28: iload_2
    //   29: invokestatic 45	android/support/v7/c/a/a:l	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   32: astore 4
    //   34: ldc 33
    //   36: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload 4
    //   41: areturn
    //   42: aload_1
    //   43: astore 4
    //   45: goto -19 -> 26
    //   48: astore_0
    //   49: iconst_0
    //   50: putstatic 10	com/bumptech/glide/c/d/c/a:aJg	Z
    //   53: aload_3
    //   54: ifnull +55 -> 109
    //   57: aload_1
    //   58: invokevirtual 51	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   61: iload_2
    //   62: aload_3
    //   63: invokestatic 57	android/support/v4/content/a/f:c	(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;
    //   66: astore_0
    //   67: ldc 33
    //   69: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: areturn
    //   74: astore_3
    //   75: aload_0
    //   76: invokevirtual 61	android/content/Context:getPackageName	()Ljava/lang/String;
    //   79: aload_1
    //   80: invokevirtual 61	android/content/Context:getPackageName	()Ljava/lang/String;
    //   83: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +10 -> 96
    //   89: ldc 33
    //   91: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_3
    //   95: athrow
    //   96: aload_1
    //   97: iload_2
    //   98: invokestatic 70	android/support/v4/content/b:l	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   101: astore_0
    //   102: ldc 33
    //   104: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: areturn
    //   109: aload_1
    //   110: invokevirtual 74	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   113: astore_3
    //   114: goto -57 -> 57
    //   117: astore_0
    //   118: goto -65 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext1	Context
    //   0	121	1	paramContext2	Context
    //   0	121	2	paramInt	int
    //   0	121	3	paramTheme	Resources.Theme
    //   24	20	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	48	java/lang/NoClassDefFoundError
    //   15	26	48	java/lang/NoClassDefFoundError
    //   26	34	48	java/lang/NoClassDefFoundError
    //   5	11	74	java/lang/IllegalStateException
    //   15	26	74	java/lang/IllegalStateException
    //   26	34	74	java/lang/IllegalStateException
    //   5	11	117	android/content/res/Resources$NotFoundException
    //   15	26	117	android/content/res/Resources$NotFoundException
    //   26	34	117	android/content/res/Resources$NotFoundException
  }
  
  public static Drawable b(Context paramContext1, Context paramContext2, int paramInt)
  {
    AppMethodBeat.i(77453);
    paramContext1 = a(paramContext1, paramContext2, paramInt, null);
    AppMethodBeat.o(77453);
    return paramContext1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.c.a
 * JD-Core Version:    0.7.0.1
 */