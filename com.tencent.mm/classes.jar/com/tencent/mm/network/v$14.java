package com.tencent.mm.network;

import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.SyncTask;

public final class v$14
  extends SyncTask<Object>
{
  public v$14(v paramv, String paramString1, String paramString2)
  {
    super(1000L, null);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(132786);
    StnLogic.setDebugIP(this.jEO, this.val$ip);
    AppMethodBeat.o(132786);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.v.14
 * JD-Core Version:    0.7.0.1
 */