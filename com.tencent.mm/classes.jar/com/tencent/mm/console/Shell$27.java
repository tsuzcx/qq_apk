package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.sdk.event.EventCenter;

final class Shell$27
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(231520);
    uq localuq = new uq();
    localuq.eaT.action = "wechat.shell.FINDER_VIDEO_TEST";
    localuq.eaT.intent = paramIntent;
    EventCenter.instance.publish(localuq);
    AppMethodBeat.o(231520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.Shell.27
 * JD-Core Version:    0.7.0.1
 */