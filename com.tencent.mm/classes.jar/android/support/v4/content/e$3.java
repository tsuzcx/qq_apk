package android.support.v4.content;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class e$3
  extends FutureTask<Result>
{
  e$3(e parame, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected final void done()
  {
    try
    {
      Object localObject = get();
      this.zy.l(localObject);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      throw new RuntimeException("An error occurred while executing doInBackground()", localExecutionException.getCause());
    }
    catch (CancellationException localCancellationException)
    {
      this.zy.l(null);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException("An error occurred while executing doInBackground()", localThrowable);
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.content.e.3
 * JD-Core Version:    0.7.0.1
 */