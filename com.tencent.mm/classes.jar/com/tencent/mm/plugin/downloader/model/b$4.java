package com.tencent.mm.plugin.downloader.model;

final class b$4
  implements Runnable
{
  b$4(b paramb, long paramLong, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    k[] arrayOfk = b.aFL();
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      arrayOfk[i].b(this.iPa, this.dlh, this.iPf);
      i += 1;
    }
    if (b.aFM() != null) {
      b.aFM().b(this.iPa, this.dlh, this.iPf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b.4
 * JD-Core Version:    0.7.0.1
 */