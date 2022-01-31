package c.t.m.g;

import android.os.Handler;

public abstract class ap$a
  implements Runnable
{
  private ap$a(ap paramap) {}
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!ap.a(this.a).postAtFrontOfQueue(this)) {
        ap.a(this.a).post(this);
      }
      return;
    }
    ap.a(this.a).post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.ap.a
 * JD-Core Version:    0.7.0.1
 */