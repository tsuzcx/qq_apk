package com.tencent.mm.platformtools;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p$6
  implements Runnable
{
  p$6(Context paramContext, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(223660);
    Toast.makeText(this.val$context, this.jMU, 1).show();
    AppMethodBeat.o(223660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.p.6
 * JD-Core Version:    0.7.0.1
 */