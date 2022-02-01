package com.bumptech.glide.load.b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y
{
  private boolean aIe;
  private final Handler handler;
  
  y()
  {
    AppMethodBeat.i(77057);
    this.handler = new Handler(Looper.getMainLooper(), new a());
    AppMethodBeat.o(77057);
  }
  
  /* Error */
  final void e(v<?> paramv)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 43
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 45	com/bumptech/glide/load/b/y:aIe	Z
    //   11: ifeq +23 -> 34
    //   14: aload_0
    //   15: getfield 36	com/bumptech/glide/load/b/y:handler	Landroid/os/Handler;
    //   18: iconst_1
    //   19: aload_1
    //   20: invokevirtual 49	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   23: invokevirtual 54	android/os/Message:sendToTarget	()V
    //   26: ldc 43
    //   28: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: iconst_1
    //   36: putfield 45	com/bumptech/glide/load/b/y:aIe	Z
    //   39: aload_1
    //   40: invokeinterface 59 1 0
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 45	com/bumptech/glide/load/b/y:aIe	Z
    //   50: ldc 43
    //   52: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: goto -24 -> 31
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	y
    //   0	63	1	paramv	v<?>
    // Exception table:
    //   from	to	target	type
    //   2	31	58	finally
    //   34	55	58	finally
  }
  
  static final class a
    implements Handler.Callback
  {
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(77056);
      if (paramMessage.what == 1)
      {
        ((v)paramMessage.obj).recycle();
        AppMethodBeat.o(77056);
        return true;
      }
      AppMethodBeat.o(77056);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.y
 * JD-Core Version:    0.7.0.1
 */