package android.support.v4.content;

import android.os.Binder;
import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

final class e$2
  extends e.d<Params, Result>
{
  e$2(e parame) {}
  
  public final Result call()
  {
    this.zW.zV.set(true);
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    Object localObject1 = localObject5;
    try
    {
      Process.setThreadPriority(10);
      localObject2 = localObject4;
      localObject1 = localObject5;
      localObject4 = this.zW.cL();
      localObject2 = localObject4;
      localObject1 = localObject4;
      Binder.flushPendingCommands();
      return localObject4;
    }
    catch (Throwable localThrowable)
    {
      localObject1 = localObject2;
      this.zW.zU.set(true);
      localObject1 = localObject2;
      throw localThrowable;
    }
    finally
    {
      this.zW.m(localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.content.e.2
 * JD-Core Version:    0.7.0.1
 */