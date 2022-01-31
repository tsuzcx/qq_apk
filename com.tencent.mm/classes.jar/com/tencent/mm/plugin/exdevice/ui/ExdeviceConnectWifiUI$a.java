package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class ExdeviceConnectWifiUI$a
{
  public static String av(int paramInt, String paramString)
  {
    AppMethodBeat.i(19892);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19892);
      return null;
    }
    paramString = paramInt + "@" + paramString.hashCode();
    AppMethodBeat.o(19892);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.a
 * JD-Core Version:    0.7.0.1
 */