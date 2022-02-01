package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.event.IListener;

public final class b
{
  private static IListener JFM;
  
  static
  {
    AppMethodBeat.i(25337);
    JFM = new IPCallAddressUpdater.1(f.hfK);
    AppMethodBeat.o(25337);
  }
  
  public static void init()
  {
    AppMethodBeat.i(25334);
    JFM.alive();
    AppMethodBeat.o(25334);
  }
  
  public static void release()
  {
    AppMethodBeat.i(25335);
    JFM.dead();
    AppMethodBeat.o(25335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b
 * JD-Core Version:    0.7.0.1
 */