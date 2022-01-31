package c.t.m.g;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class au
  implements Runnable
{
  au(ap paramap) {}
  
  public final void run()
  {
    if (ap.e(this.a).size() == 0)
    {
      ap.f(this.a).incrementAndGet();
      ap.b(this.a, true);
      return;
    }
    ap.a(this.a, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.g.au
 * JD-Core Version:    0.7.0.1
 */