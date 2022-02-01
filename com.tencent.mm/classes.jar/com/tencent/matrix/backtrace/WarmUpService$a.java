package com.tencent.matrix.backtrace;

import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;

final class WarmUpService$a
  implements Handler.Callback
{
  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      com.tencent.matrix.e.c.i("Matrix.WarmUpService", "Suicide.", new Object[0]);
      paramMessage = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramMessage.aYi(), "com/tencent/matrix/backtrace/WarmUpService$RecyclerCallback", "handleMessage", "(Landroid/os/Message;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramMessage.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/backtrace/WarmUpService$RecyclerCallback", "handleMessage", "(Landroid/os/Message;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      paramMessage = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramMessage.aYi(), "com/tencent/matrix/backtrace/WarmUpService$RecyclerCallback", "handleMessage", "(Landroid/os/Message;)Z", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramMessage.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/backtrace/WarmUpService$RecyclerCallback", "handleMessage", "(Landroid/os/Message;)Z", "java/lang/System_EXEC_", "exit", "(I)V");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.backtrace.WarmUpService.a
 * JD-Core Version:    0.7.0.1
 */