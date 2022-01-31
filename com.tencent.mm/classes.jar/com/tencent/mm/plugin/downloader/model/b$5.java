package com.tencent.mm.plugin.downloader.model;

final class b$5
  implements Runnable
{
  b$5(b paramb, long paramLong, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    k[] arrayOfk = b.aFL();
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      arrayOfk[i].b(this.iPa, this.bEg, this.iPf);
      i += 1;
    }
    if (b.aFM() != null) {
      b.aFM().b(this.iPa, this.bEg, this.iPf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.b.5
 * JD-Core Version:    0.7.0.1
 */