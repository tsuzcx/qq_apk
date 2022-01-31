package com.tencent.mm.e;

import com.tencent.mm.sdk.platformtools.y;

final class e$a$1
  implements Runnable
{
  e$a$1(e.a parama) {}
  
  public final void run()
  {
    y.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
    if (this.bBk.bBj.tI() == null) {}
    com.tencent.mm.z.c localc;
    do
    {
      return;
      localc = ((com.tencent.mm.cache.c)this.bBk.bBj.tI()).wR();
    } while ((localc == null) || (!localc.dpc));
    localc.setSelected(false);
    e.a.a(this.bBk).aS(false);
    e.a.a(this.bBk).tQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.e.e.a.1
 * JD-Core Version:    0.7.0.1
 */