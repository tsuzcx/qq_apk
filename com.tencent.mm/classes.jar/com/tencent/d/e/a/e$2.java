package com.tencent.d.e.a;

import android.os.Handler;
import com.tencent.d.e.a.a.c;
import com.tencent.d.e.a.a.f;
import com.tencent.d.e.a.a.g;
import com.tencent.d.e.a.a.g.a;

final class e$2
  extends c
{
  e$2(e parame) {}
  
  public final void cOQ()
  {
    synchronized (this.wNh)
    {
      if (!e.c(this.wNh)) {
        return;
      }
      if (e.g(this.wNh) == null) {
        return;
      }
    }
    if (e.g(this.wNh).il(e.a(this.wNh).wMY))
    {
      long l = e.g(this.wNh).wNx.cOU();
      e.a locala = e.d(this.wNh);
      int i = (int)(e.a(this.wNh).wMY / f.wNq);
      locala.mCount = 1;
      locala.mMaxCount = i;
      locala.wNn = l;
      l = l + f.wNq - System.currentTimeMillis();
      if (l <= 0L) {
        break label164;
      }
      e.e(this.wNh).postDelayed(e.d(this.wNh), l);
    }
    for (;;)
    {
      return;
      label164:
      e.e(this.wNh).post(e.d(this.wNh));
    }
  }
  
  public final void cOR()
  {
    if (e.f(this.wNh) != null) {
      e.f(this.wNh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.e.a.e.2
 * JD-Core Version:    0.7.0.1
 */