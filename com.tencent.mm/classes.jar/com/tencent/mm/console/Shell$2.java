package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

final class Shell$2
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(16110);
    if (!ah.brt())
    {
      AppMethodBeat.o(16110);
      return;
    }
    String str = paramIntent.getStringExtra("sql");
    paramIntent = paramIntent.getStringExtra("file");
    if ((str != null) && (str.length() > 0))
    {
      g.RO().ac(new Shell.2.1(this, str));
      AppMethodBeat.o(16110);
      return;
    }
    if ((paramIntent != null) && (paramIntent.length() > 0)) {
      g.RO().ac(new Shell.2.2(this, paramIntent));
    }
    AppMethodBeat.o(16110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.2
 * JD-Core Version:    0.7.0.1
 */