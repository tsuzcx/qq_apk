package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class ExdeviceConnectWifiUI$a
{
  public static String aS(int paramInt, String paramString)
  {
    AppMethodBeat.i(23960);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(23960);
      return null;
    }
    paramString = paramInt + "@" + paramString.hashCode();
    AppMethodBeat.o(23960);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.a
 * JD-Core Version:    0.7.0.1
 */