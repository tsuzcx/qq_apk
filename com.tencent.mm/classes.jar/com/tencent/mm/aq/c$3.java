package com.tencent.mm.aq;

import com.tencent.mm.model.am.b.a;
import java.util.Map;

final class c$3
  implements Runnable
{
  c$3(c paramc, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.emx.emp.containsKey(this.emy))
    {
      am.b.a locala = (am.b.a)this.emx.emp.get(this.emy);
      if (locala != null) {
        locala.m(this.emy, this.emz);
      }
      this.emx.emp.remove(this.emy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aq.c.3
 * JD-Core Version:    0.7.0.1
 */