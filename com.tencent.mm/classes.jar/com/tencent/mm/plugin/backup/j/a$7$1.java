package com.tencent.mm.plugin.backup.j;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class a$7$1
  implements Runnable
{
  a$7$1(a.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(22150);
    Toast.makeText(MMApplicationContext.getContext(), "test open", 0).show();
    AppMethodBeat.o(22150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.7.1
 * JD-Core Version:    0.7.0.1
 */