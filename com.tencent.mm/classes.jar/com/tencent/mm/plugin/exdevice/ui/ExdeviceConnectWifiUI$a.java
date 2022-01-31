package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.sdk.platformtools.bk;

final class ExdeviceConnectWifiUI$a
{
  public static String ac(int paramInt, String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return paramInt + "@" + paramString.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.a
 * JD-Core Version:    0.7.0.1
 */