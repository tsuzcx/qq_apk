package c.t.m.g;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

public final class ap$b
  extends ap.a
{
  private String a;
  private boolean b;
  
  public ap$b(ap paramap, String paramString)
  {
    super(paramap, (byte)0);
    this.a = paramString;
    this.b = true;
  }
  
  public final void run()
  {
    ap.b(this.c).decrementAndGet();
    if (TextUtils.isEmpty(this.a)) {}
    int i;
    do
    {
      return;
      i = x.a.a("report_new_record_num", 1, 50, 10);
      if (az.a(this.c.b()).b(this.a) == -1L) {
        break;
      }
      if (ap.c(this.c))
      {
        ap.a(this.c, false);
        ap.b(this.c, false);
      }
    } while (ap.d(this.c).incrementAndGet() < i);
    ap.a(this.c, false, this.b);
    return;
    ap.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     c.t.m.g.ap.b
 * JD-Core Version:    0.7.0.1
 */