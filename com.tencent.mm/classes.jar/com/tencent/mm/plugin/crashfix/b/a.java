package com.tencent.mm.plugin.crashfix.b;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends Dialog
{
  private Runnable mHijackDismissAction;
  private final Runnable mReplaceRunnable;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145618);
    this.mReplaceRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145617);
        try
        {
          ae.i("MicroMsg.SafeDismissDialog", "run on hijack runnable");
          a.a(a.this).run();
          AppMethodBeat.o(145617);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.SafeDismissDialog", "protect : " + localException.getMessage());
          AppMethodBeat.o(145617);
        }
      }
    };
    hijackDismissAction();
    AppMethodBeat.o(145618);
  }
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(145619);
    this.mReplaceRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145617);
        try
        {
          ae.i("MicroMsg.SafeDismissDialog", "run on hijack runnable");
          a.a(a.this).run();
          AppMethodBeat.o(145617);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.SafeDismissDialog", "protect : " + localException.getMessage());
          AppMethodBeat.o(145617);
        }
      }
    };
    hijackDismissAction();
    AppMethodBeat.o(145619);
  }
  
  /* Error */
  private void hijackDismissAction()
  {
    // Byte code:
    //   0: ldc 48
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 54	android/os/Build$VERSION:SDK_INT	I
    //   8: bipush 28
    //   10: if_icmple +9 -> 19
    //   13: ldc 48
    //   15: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: ldc 4
    //   21: ldc 56
    //   23: invokevirtual 62	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   26: astore_1
    //   27: aload_1
    //   28: iconst_1
    //   29: invokevirtual 68	java/lang/reflect/Field:setAccessible	(Z)V
    //   32: ldc 64
    //   34: ldc 70
    //   36: invokevirtual 62	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   39: astore_2
    //   40: aload_2
    //   41: iconst_1
    //   42: invokevirtual 68	java/lang/reflect/Field:setAccessible	(Z)V
    //   45: aload_2
    //   46: aload_1
    //   47: aload_1
    //   48: invokevirtual 74	java/lang/reflect/Field:getModifiers	()I
    //   51: bipush 239
    //   53: iand
    //   54: invokevirtual 78	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   57: aload_0
    //   58: aload_1
    //   59: aload_0
    //   60: invokevirtual 82	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 84	java/lang/Runnable
    //   66: putfield 41	com/tencent/mm/plugin/crashfix/b/a:mHijackDismissAction	Ljava/lang/Runnable;
    //   69: aload_1
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 25	com/tencent/mm/plugin/crashfix/b/a:mReplaceRunnable	Ljava/lang/Runnable;
    //   75: invokevirtual 88	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   78: ldc 48
    //   80: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_1
    //   85: ldc 90
    //   87: ldc 92
    //   89: invokestatic 98	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: ldc 48
    //   94: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_1
    //   99: ldc 90
    //   101: ldc 100
    //   103: invokestatic 98	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: ldc 48
    //   108: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: return
    //   112: astore_2
    //   113: goto -56 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	a
    //   26	44	1	localField1	java.lang.reflect.Field
    //   84	1	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   98	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   39	7	2	localField2	java.lang.reflect.Field
    //   112	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   19	32	84	java/lang/NoSuchFieldException
    //   32	57	84	java/lang/NoSuchFieldException
    //   57	78	84	java/lang/NoSuchFieldException
    //   19	32	98	java/lang/IllegalAccessException
    //   32	57	98	java/lang/IllegalAccessException
    //   57	78	98	java/lang/IllegalAccessException
    //   32	57	112	java/lang/Exception
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(145620);
    try
    {
      super.dismiss();
      AppMethodBeat.o(145620);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SafeDismissDialog", localException, "", new Object[0]);
      AppMethodBeat.o(145620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.b.a
 * JD-Core Version:    0.7.0.1
 */