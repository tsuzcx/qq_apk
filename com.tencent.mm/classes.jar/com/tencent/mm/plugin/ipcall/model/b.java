package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public final class b
{
  private static IListener yov;
  
  static
  {
    AppMethodBeat.i(25337);
    yov = new IListener() {};
    AppMethodBeat.o(25337);
  }
  
  public static void init()
  {
    AppMethodBeat.i(25334);
    EventCenter.instance.addListener(yov);
    AppMethodBeat.o(25334);
  }
  
  public static void release()
  {
    AppMethodBeat.i(25335);
    EventCenter.instance.removeListener(yov);
    AppMethodBeat.o(25335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b
 * JD-Core Version:    0.7.0.1
 */