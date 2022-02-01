package com.tencent.mm.plugin.backup.j;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class a$7$2
  implements Runnable
{
  a$7$2(a.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(22151);
    Toast.makeText(ak.getContext(), "no merge data", 0).show();
    AppMethodBeat.o(22151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.7.2
 * JD-Core Version:    0.7.0.1
 */