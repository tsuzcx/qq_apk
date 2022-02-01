package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xj;

final class Shell$26
  implements Shell.a
{
  public final void v(Intent paramIntent)
  {
    AppMethodBeat.i(231965);
    xj localxj = new xj();
    localxj.iaN.action = "wechat.shell.FINDER_SHELL";
    localxj.iaN.intent = paramIntent;
    localxj.publish();
    AppMethodBeat.o(231965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.26
 * JD-Core Version:    0.7.0.1
 */