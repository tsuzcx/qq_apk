package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

public final class ScanSettingsCompat$a
{
  private int goj = 0;
  private final int gok = 1;
  private long gol = 0L;
  
  public final ScanSettingsCompat aiy()
  {
    return new ScanSettingsCompat(this.goj, this.gol, (byte)0);
  }
  
  public final a ll(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid scan mode " + paramInt);
    }
    this.goj = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat.a
 * JD-Core Version:    0.7.0.1
 */