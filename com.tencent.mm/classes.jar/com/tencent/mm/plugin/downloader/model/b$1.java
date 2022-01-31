package com.tencent.mm.plugin.downloader.model;

final class b$1
  implements Runnable
{
  b$1(b paramb, long paramLong, String paramString) {}
  
  public final void run()
  {
    k[] arrayOfk = b.aFL();
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      arrayOfk[i].onTaskStarted(this.iPa, this.dlh);
      i += 1;
    }
    if (b.aFM() != null) {
      b.aFM().onTaskStarted(this.iPa, this.dlh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b.1
 * JD-Core Version:    0.7.0.1
 */