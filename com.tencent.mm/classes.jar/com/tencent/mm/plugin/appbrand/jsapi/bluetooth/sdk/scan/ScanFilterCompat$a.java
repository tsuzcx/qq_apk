package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ScanFilterCompat$a
{
  String hHM;
  ParcelUuid hHN;
  ParcelUuid hHP;
  byte[] hHQ;
  byte[] hHR;
  int hHS = -1;
  byte[] hHT;
  byte[] hHU;
  ParcelUuid hHW;
  String mDeviceName;
  
  public final a a(ParcelUuid paramParcelUuid)
  {
    this.hHN = paramParcelUuid;
    this.hHW = null;
    return this;
  }
  
  public final ScanFilterCompat aCs()
  {
    AppMethodBeat.i(94313);
    ScanFilterCompat localScanFilterCompat = new ScanFilterCompat(this.mDeviceName, this.hHM, this.hHN, this.hHW, this.hHP, this.hHQ, this.hHR, this.hHS, this.hHT, this.hHU, (byte)0);
    AppMethodBeat.o(94313);
    return localScanFilterCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat.a
 * JD-Core Version:    0.7.0.1
 */