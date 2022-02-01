package com.tencent.mm.plugin.backup.j;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class a$7$4
  implements Runnable
{
  a$7$4(a.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(22153);
    Toast.makeText(ak.getContext(), "merge data delete", 0).show();
    AppMethodBeat.o(22153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.7.4
 * JD-Core Version:    0.7.0.1
 */