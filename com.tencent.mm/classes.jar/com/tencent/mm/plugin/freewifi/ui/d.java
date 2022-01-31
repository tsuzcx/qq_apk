package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  public static void IE()
  {
    AppMethodBeat.i(21006);
    try
    {
      c.bBz().a(new d.1());
      AppMethodBeat.o(21006);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + localException.getMessage());
      AppMethodBeat.o(21006);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.d
 * JD-Core Version:    0.7.0.1
 */