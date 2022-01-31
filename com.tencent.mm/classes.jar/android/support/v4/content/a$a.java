package android.support.v4.content;

import android.support.v4.os.b;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$a
  extends e<Void, Void, D>
  implements Runnable
{
  boolean zA;
  final CountDownLatch zz = new CountDownLatch(1);
  
  a$a(a parama) {}
  
  private D cK()
  {
    try
    {
      Object localObject = this.zB.onLoadInBackground();
      return localObject;
    }
    catch (b localb)
    {
      if (!this.zU.get()) {
        throw localb;
      }
    }
    return null;
  }
  
  protected final void onCancelled(D paramD)
  {
    try
    {
      this.zB.dispatchOnCancelled(this, paramD);
      return;
    }
    finally
    {
      this.zz.countDown();
    }
  }
  
  protected final void onPostExecute(D paramD)
  {
    try
    {
      this.zB.dispatchOnLoadComplete(this, paramD);
      return;
    }
    finally
    {
      this.zz.countDown();
    }
  }
  
  public final void run()
  {
    this.zA = false;
    this.zB.executePendingTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.content.a.a
 * JD-Core Version:    0.7.0.1
 */