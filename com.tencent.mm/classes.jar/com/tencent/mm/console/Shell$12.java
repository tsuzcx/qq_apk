package com.tencent.mm.console;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.iq.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class Shell$12
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(16120);
    iq localiq = new iq();
    localiq.cxZ.cye = paramIntent.getExtras().getString("path", "/data/local/tmp/test.apk");
    ab.w("MicroMsg.Shell", "hotpatch test [%s]", new Object[] { localiq.cxZ.cye });
    a.ymk.l(localiq);
    AppMethodBeat.o(16120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.12
 * JD-Core Version:    0.7.0.1
 */