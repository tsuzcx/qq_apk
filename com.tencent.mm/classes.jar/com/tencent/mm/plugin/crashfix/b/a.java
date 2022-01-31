package com.tencent.mm.plugin.crashfix.b;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends Dialog
{
  private Runnable mHijackDismissAction;
  private final Runnable mReplaceRunnable;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(154695);
    this.mReplaceRunnable = new a.1(this);
    hijackDismissAction();
    AppMethodBeat.o(154695);
  }
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(154696);
    this.mReplaceRunnable = new a.1(this);
    hijackDismissAction();
    AppMethodBeat.o(154696);
  }
  
  /* Error */
  private void hijackDismissAction()
  {
    // Byte code:
    //   0: ldc 48
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 4
    //   7: ldc 50
    //   9: invokevirtual 56	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   12: astore_1
    //   13: aload_1
    //   14: iconst_1
    //   15: invokevirtual 62	java/lang/reflect/Field:setAccessible	(Z)V
    //   18: ldc 58
    //   20: ldc 64
    //   22: invokevirtual 56	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   25: astore_2
    //   26: aload_2
    //   27: iconst_1
    //   28: invokevirtual 62	java/lang/reflect/Field:setAccessible	(Z)V
    //   31: aload_2
    //   32: aload_1
    //   33: aload_1
    //   34: invokevirtual 68	java/lang/reflect/Field:getModifiers	()I
    //   37: bipush 239
    //   39: iand
    //   40: invokevirtual 72	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   43: aload_0
    //   44: aload_1
    //   45: aload_0
    //   46: invokevirtual 76	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 78	java/lang/Runnable
    //   52: putfield 41	com/tencent/mm/plugin/crashfix/b/a:mHijackDismissAction	Ljava/lang/Runnable;
    //   55: aload_1
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 25	com/tencent/mm/plugin/crashfix/b/a:mReplaceRunnable	Ljava/lang/Runnable;
    //   61: invokevirtual 82	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   64: ldc 48
    //   66: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: astore_1
    //   71: ldc 84
    //   73: ldc 86
    //   75: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: ldc 48
    //   80: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_1
    //   85: ldc 84
    //   87: ldc 94
    //   89: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: ldc 48
    //   94: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_2
    //   99: goto -56 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	a
    //   12	44	1	localField1	java.lang.reflect.Field
    //   70	1	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   84	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   25	7	2	localField2	java.lang.reflect.Field
    //   98	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   5	18	70	java/lang/NoSuchFieldException
    //   18	43	70	java/lang/NoSuchFieldException
    //   43	64	70	java/lang/NoSuchFieldException
    //   5	18	84	java/lang/IllegalAccessException
    //   18	43	84	java/lang/IllegalAccessException
    //   43	64	84	java/lang/IllegalAccessException
    //   18	43	98	java/lang/Exception
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(154697);
    try
    {
      super.dismiss();
      AppMethodBeat.o(154697);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SafeDismissDialog", localException, "", new Object[0]);
      AppMethodBeat.o(154697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.b.a
 * JD-Core Version:    0.7.0.1
 */