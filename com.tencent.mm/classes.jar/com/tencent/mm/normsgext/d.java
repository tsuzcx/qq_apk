package com.tencent.mm.normsgext;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class d
{
  static final class m
  {
    static
    {
      AppMethodBeat.i(231271);
      Object localObject1 = new StringBuilder("txegsmron").reverse().toString();
      if (Process.myPid() == Process.myTid())
      {
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        localObject3 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/normsgext/d$m", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/normsgext/d$m", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        AppMethodBeat.o(231271);
        return;
      }
      Object localObject3 = new CountDownLatch(1);
      new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231267);
          Object localObject1 = this.pqH;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          Object localObject2 = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/normsgext/d$m$1", "run", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
          System.loadLibrary((String)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/normsgext/d$m$1", "run", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
          this.hlZ.countDown();
          AppMethodBeat.o(231267);
        }
      });
      try
      {
        ((CountDownLatch)localObject3).await();
        return;
      }
      finally
      {
        AppMethodBeat.o(231271);
      }
    }
    
    static native boolean ba(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, QValue<Integer> paramQValue1, QValue<Integer> paramQValue2, QValue<byte[]> paramQValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.normsgext.d
 * JD-Core Version:    0.7.0.1
 */