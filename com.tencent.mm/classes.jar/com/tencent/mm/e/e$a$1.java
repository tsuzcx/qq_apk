package com.tencent.mm.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.y.c;

final class e$a$1
  implements Runnable
{
  e$a$1(e.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(116183);
    ab.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
    if (this.ceh.ceg.CB() == null)
    {
      AppMethodBeat.o(116183);
      return;
    }
    c localc = ((d)this.ceh.ceg.CB()).Jj();
    if ((localc != null) && (localc.egy))
    {
      localc.setSelected(false);
      e.a.a(this.ceh).bt(false);
      e.a.a(this.ceh).CI();
    }
    AppMethodBeat.o(116183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.e.a.1
 * JD-Core Version:    0.7.0.1
 */