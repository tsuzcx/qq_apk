package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;

public final class ScanFilterCompat$a
{
  String gnO;
  String gnP;
  ParcelUuid gnQ;
  ParcelUuid gnS;
  byte[] gnT;
  byte[] gnU;
  int gnV = -1;
  byte[] gnW;
  byte[] gnX;
  ParcelUuid gnZ;
  
  public final a a(ParcelUuid paramParcelUuid)
  {
    this.gnQ = paramParcelUuid;
    this.gnZ = null;
    return this;
  }
  
  public final ScanFilterCompat aix()
  {
    return new ScanFilterCompat(this.gnO, this.gnP, this.gnQ, this.gnZ, this.gnS, this.gnT, this.gnU, this.gnV, this.gnW, this.gnX, (byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat.a
 * JD-Core Version:    0.7.0.1
 */