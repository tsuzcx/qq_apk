package com.tencent.mm.modelmulti;

import java.util.Queue;

final class o$2
  implements Runnable
{
  o$2(o paramo, o.c paramc) {}
  
  public final void run()
  {
    if (this.etO != null)
    {
      if (!(this.etO instanceof o.f)) {
        break label43;
      }
      o.b(this.etN).add(this.etO);
    }
    for (;;)
    {
      o.a(this.etN, null);
      return;
      label43:
      o.c(this.etN).add(this.etO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.2
 * JD-Core Version:    0.7.0.1
 */