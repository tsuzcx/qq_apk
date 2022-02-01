package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vt;
import com.tencent.mm.sdk.event.EventCenter;

final class Shell$21
  implements Shell.a
{
  public final void u(Intent paramIntent)
  {
    AppMethodBeat.i(274671);
    vt localvt = new vt();
    localvt.fUQ.action = "wechat.shell.FINDER_SHELL";
    localvt.fUQ.intent = paramIntent;
    EventCenter.instance.publish(localvt);
    AppMethodBeat.o(274671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.Shell.21
 * JD-Core Version:    0.7.0.1
 */