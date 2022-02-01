package com.tencent.mm.modelvoice;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.e.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class k$a$1
  implements Runnable
{
  k$a$1(k.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(130048);
    Toast.makeText(MMApplicationContext.getContext(), "Save to: " + k.s(this.pei.peh).mFilePath, 1).show();
    AppMethodBeat.o(130048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelvoice.k.a.1
 * JD-Core Version:    0.7.0.1
 */