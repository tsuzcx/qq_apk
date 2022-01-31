package com.tencent.mm.plugin.emojicapture.ui.a;

import a.d.a.a;

public final class c$b
  implements Runnable
{
  public c$b(c paramc, a parama) {}
  
  public final void run()
  {
    c.b(this.jrg);
    c.a(this.jrg).onSurfaceCreated(c.c(this.jrg), this.jrg.jqZ);
    c.a(this.jrg).onSurfaceChanged(c.c(this.jrg), this.jrg.width, this.jrg.height);
    a locala = this.jrh;
    if (locala != null) {
      locala.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.c.b
 * JD-Core Version:    0.7.0.1
 */