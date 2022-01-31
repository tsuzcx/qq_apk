package com.tencent.mm.plugin.downloader.model;

final class b$6
  implements Runnable
{
  b$6(b paramb, long paramLong) {}
  
  public final void run()
  {
    k[] arrayOfk = b.aFL();
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      arrayOfk[i].onTaskPaused(this.iPa);
      i += 1;
    }
    if (b.aFM() != null) {
      b.aFM().onTaskPaused(this.iPa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b.6
 * JD-Core Version:    0.7.0.1
 */