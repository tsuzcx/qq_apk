package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ScanSettingsCompat$a
{
  private int hIg = 0;
  private final int hIh = 1;
  private long hIi = 0L;
  
  public final ScanSettingsCompat aCt()
  {
    AppMethodBeat.i(94337);
    ScanSettingsCompat localScanSettingsCompat = new ScanSettingsCompat(this.hIg, this.hIi, (byte)0);
    AppMethodBeat.o(94337);
    return localScanSettingsCompat;
  }
  
  public final a nV(int paramInt)
  {
    AppMethodBeat.i(94336);
    if ((paramInt < 0) || (paramInt > 2))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid scan mode ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(94336);
      throw localIllegalArgumentException;
    }
    this.hIg = paramInt;
    AppMethodBeat.o(94336);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat.a
 * JD-Core Version:    0.7.0.1
 */