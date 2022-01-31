package com.tencent.mm.modelvoice;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.e.b;
import com.tencent.mm.sdk.platformtools.ah;

final class k$a$1
  implements Runnable
{
  k$a$1(k.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(55795);
    Toast.makeText(ah.getContext(), "Save to: " + k.n(this.gae.gad).mFilePath, 1).show();
    AppMethodBeat.o(55795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.k.a.1
 * JD-Core Version:    0.7.0.1
 */