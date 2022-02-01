package androidx.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private a bro;
  private Object brp;
  private boolean mCancelInProgress;
  private boolean mIsCanceled;
  
  public final void a(a parama)
  {
    AppMethodBeat.i(195445);
    try
    {
      for (;;)
      {
        boolean bool = this.mCancelInProgress;
        if (!bool) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      if (this.bro == parama) {
        return;
      }
      this.bro = parama;
      if (!this.mIsCanceled) {
        return;
      }
      parama.onCancel();
      AppMethodBeat.o(195445);
      return;
    }
    finally
    {
      AppMethodBeat.o(195445);
    }
  }
  
  /* Error */
  public final void cancel()
  {
    // Byte code:
    //   0: ldc 46
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 41	androidx/core/c/b:mIsCanceled	Z
    //   11: ifeq +11 -> 22
    //   14: aload_0
    //   15: monitorexit
    //   16: ldc 46
    //   18: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: return
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 41	androidx/core/c/b:mIsCanceled	Z
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 31	androidx/core/c/b:mCancelInProgress	Z
    //   32: aload_0
    //   33: getfield 36	androidx/core/c/b:bro	Landroidx/core/c/b$a;
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 48	androidx/core/c/b:brp	Ljava/lang/Object;
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: ifnull +9 -> 54
    //   48: aload_1
    //   49: invokeinterface 44 1 0
    //   54: aload_2
    //   55: ifnull +18 -> 73
    //   58: getstatic 54	android/os/Build$VERSION:SDK_INT	I
    //   61: bipush 16
    //   63: if_icmplt +10 -> 73
    //   66: aload_2
    //   67: checkcast 56	android/os/CancellationSignal
    //   70: invokevirtual 58	android/os/CancellationSignal:cancel	()V
    //   73: aload_0
    //   74: monitorenter
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 31	androidx/core/c/b:mCancelInProgress	Z
    //   80: aload_0
    //   81: invokevirtual 61	java/lang/Object:notifyAll	()V
    //   84: aload_0
    //   85: monitorexit
    //   86: ldc 46
    //   88: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: return
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: ldc 46
    //   97: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: ldc 46
    //   107: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: aload_0
    //   114: monitorenter
    //   115: aload_0
    //   116: iconst_0
    //   117: putfield 31	androidx/core/c/b:mCancelInProgress	Z
    //   120: aload_0
    //   121: invokevirtual 61	java/lang/Object:notifyAll	()V
    //   124: aload_0
    //   125: monitorexit
    //   126: ldc 46
    //   128: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: ldc 46
    //   138: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	b
    //   36	13	1	locala	a
    //   92	9	1	localObject1	Object
    //   102	9	1	localObject2	Object
    //   112	20	1	localObject3	Object
    //   133	9	1	localObject4	Object
    //   41	26	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	92	finally
    //   22	44	92	finally
    //   75	86	102	finally
    //   48	54	112	finally
    //   58	73	112	finally
    //   115	126	133	finally
  }
  
  public final boolean isCanceled()
  {
    try
    {
      boolean bool = this.mIsCanceled;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.c.b
 * JD-Core Version:    0.7.0.1
 */