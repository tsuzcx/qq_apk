package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class b$5
  implements Runnable
{
  b$5(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(17811);
    Looper.prepare();
    b.a(this.jHi, new ak());
    Looper.loop();
    AppMethodBeat.o(17811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.5
 * JD-Core Version:    0.7.0.1
 */