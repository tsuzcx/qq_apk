package android.support.v4.content;

import android.support.v4.os.c;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$a
  extends e<Void, Void, D>
  implements Runnable
{
  final CountDownLatch yU = new CountDownLatch(1);
  boolean yV;
  
  a$a(a parama) {}
  
  private D ci()
  {
    try
    {
      Object localObject = this.yW.onLoadInBackground();
      return localObject;
    }
    catch (c localc)
    {
      if (!this.zw.get()) {
        throw localc;
      }
    }
    return null;
  }
  
  protected final void onCancelled(D paramD)
  {
    try
    {
      this.yW.dispatchOnCancelled(this, paramD);
      return;
    }
    finally
    {
      this.yU.countDown();
    }
  }
  
  protected final void onPostExecute(D paramD)
  {
    try
    {
      this.yW.dispatchOnLoadComplete(this, paramD);
      return;
    }
    finally
    {
      this.yU.countDown();
    }
  }
  
  public final void run()
  {
    this.yV = false;
    this.yW.executePendingTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.content.a.a
 * JD-Core Version:    0.7.0.1
 */