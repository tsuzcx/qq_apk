package c.t.m.g;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class ap$c
  extends ap.a
{
  private ap.d a;
  
  public ap$c(ap paramap, ap.d paramd)
  {
    super(paramap, (byte)0);
    this.a = paramd;
  }
  
  public final void run()
  {
    ap.g(this.b);
    ap.a(this.b, SystemClock.elapsedRealtime());
    int j;
    int i;
    if (this.a.d)
    {
      if (ap.j(this.b) > 0) {
        ap.k(this.b);
      }
      this.b.a.addAndGet(this.a.f);
      if (!this.a.b)
      {
        j = this.a.e.size();
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < j)
        {
          localArrayList.add(Long.valueOf(((az.a)this.a.e.get(i)).a));
          i += 1;
        }
        az.a(this.b.b()).a(localArrayList);
        if (ap.l(this.b))
        {
          ap.m(this.b);
          ap.a(this.b, true, this.a.c);
        }
      }
    }
    label363:
    label372:
    for (;;)
    {
      return;
      if (!this.a.a)
      {
        SystemClock.sleep(200L);
        ap.a(this.b, this.a.b, this.a.c);
        return;
      }
      ap.a(this.b, true);
      return;
      if (x.h())
      {
        if (ap.j(this.b) <= 0) {
          break label363;
        }
        i = x.a.a("report_interval_forbid_limit", 30, 1440, 60);
        if (ap.j(this.b) < i) {
          ap.n(this.b);
        }
      }
      for (;;)
      {
        if ((!this.a.c) || (!this.a.b)) {
          break label372;
        }
        j = this.a.e.size();
        i = 0;
        while (i < j)
        {
          az.a(this.b.b()).b(((az.a)this.a.e.get(i)).b);
          i += 1;
        }
        break;
        ap.o(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.ap.c
 * JD-Core Version:    0.7.0.1
 */