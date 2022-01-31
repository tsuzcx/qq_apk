package c.t.m.g;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k
{
  protected i a;
  public String b;
  public String c;
  protected AtomicInteger d = new AtomicInteger(0);
  protected ai e;
  private int f;
  private long g;
  private int h = 0;
  
  public k(i parami)
  {
    this.a = parami;
    this.b = parami.a;
    this.c = parami.a;
    this.f = parami.e;
    this.g = SystemClock.elapsedRealtime();
  }
  
  public an a()
  {
    for (;;)
    {
      try
      {
        x.a.a("app_http_proxy_timeout", 0, 20000, 5000);
        if (this.f <= 0) {
          this.f = x.a.a("app_req_timeout", 1000, 1000000, 15000);
        }
        if ((this.a.h > 0) && (this.a.h < this.f)) {
          this.f = this.a.h;
        }
        int i = this.f;
        an localan = a(i);
        i = cm.a((int)(this.f - (SystemClock.elapsedRealtime() - this.g)), this.f);
        String str;
        if ((localan.a == 0) && (localan.c >= 300) && (localan.c < 400) && (this.a.d) && (i > 200))
        {
          str = localan.a("location");
          if (TextUtils.isEmpty(str)) {
            localan.a = -6;
          }
        }
        else
        {
          boolean bool = this.a.g;
          if (!this.a.k) {
            break label289;
          }
          this.e.j = true;
          this.e.i = true;
          this.e.k = this.a.h;
          this.e.a(false);
          return localan;
        }
        this.c = str;
        this.h += 1;
        if (this.h > 5)
        {
          localan.a = -5;
          continue;
        }
        this.e.a(true);
      }
      catch (Throwable localThrowable)
      {
        return new an(-1, cm.a(localThrowable));
      }
      continue;
      label289:
      this.e.k = (SystemClock.elapsedRealtime() - this.g);
    }
  }
  
  protected abstract an a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.k
 * JD-Core Version:    0.7.0.1
 */