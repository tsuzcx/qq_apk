package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.c.b;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    if (this.hKq.hIr != null) {
      this.hKq.hIr.cancel();
    }
    this.hKq.hIr = new b();
    this.hKq.hIr.a(this.hKq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.a.1
 * JD-Core Version:    0.7.0.1
 */