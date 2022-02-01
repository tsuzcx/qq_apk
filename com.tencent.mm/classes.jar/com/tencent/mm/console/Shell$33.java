package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xj;

final class Shell$33
  implements Shell.a
{
  public final void v(Intent paramIntent)
  {
    AppMethodBeat.i(231928);
    xj localxj = new xj();
    localxj.iaN.action = "wechat.shell.EXPT_TEST";
    localxj.iaN.intent = paramIntent;
    localxj.publish();
    AppMethodBeat.o(231928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.33
 * JD-Core Version:    0.7.0.1
 */