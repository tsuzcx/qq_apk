package com.tencent.mm.console;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.ku.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

final class Shell$40
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(20163);
    ku localku = new ku();
    localku.dPP.dPU = paramIntent.getExtras().getString("path", "/data/local/tmp/test.apk");
    Log.w("MicroMsg.Shell", "hotpatch test [%s]", new Object[] { localku.dPP.dPU });
    EventCenter.instance.publish(localku);
    AppMethodBeat.o(20163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.Shell.40
 * JD-Core Version:    0.7.0.1
 */