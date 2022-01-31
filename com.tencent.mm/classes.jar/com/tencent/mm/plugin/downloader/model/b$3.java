package com.tencent.mm.plugin.downloader.model;

final class b$3
  implements Runnable
{
  b$3(b paramb, long paramLong) {}
  
  public final void run()
  {
    k[] arrayOfk = b.aFL();
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      arrayOfk[i].onTaskRemoved(this.iPa);
      i += 1;
    }
    if (b.aFM() != null) {
      b.aFM().onTaskRemoved(this.iPa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b.3
 * JD-Core Version:    0.7.0.1
 */