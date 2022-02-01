package com.tencent.mm.plugin.login_exdevice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  implements n
{
  public static volatile m mIG;
  public static volatile l mIH;
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(288329);
    Log.i("MicroMsg.LoginAsExDeviceApplication", "regitMMModelCallback %s", new Object[] { paraml });
    mIH = paraml;
    AppMethodBeat.o(288329);
  }
  
  public final void a(m paramm)
  {
    mIG = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.a
 * JD-Core Version:    0.7.0.1
 */