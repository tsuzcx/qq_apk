package com.tencent.maas.camerafun;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum MJCamFunSession$a
{
  private final int eEP;
  
  static
  {
    AppMethodBeat.i(216862);
    eEW = new a("nMFVideoOrientationNone", 0, -1);
    eEX = new a("nMFVideoOrientationPortrait", 1, 1);
    eEY = new a("nMFVideoOrientationPortraitUpsideDown", 2, 2);
    eEZ = new a("nMFVideoOrientationLandscapeRight", 3, 3);
    eFa = new a("nMFVideoOrientationLandscapeLeft", 4, 4);
    eFb = new a("nMFVideoOrientationLandscape", 5, eEZ.eEP);
    eFc = new a("nMFVideoOrientationDefault", 6, eEZ.eEP);
    eFd = new a("nMFVideoOrientationCW90", 7, eEX.eEP);
    eFe = new a("nMFVideoOrientationCW180", 8, eFa.eEP);
    eFf = new a("nMFVideoOrientationCW270", 9, eEY.eEP);
    eFg = new a("nMFVideoOrientationMin", 10, 1);
    eFh = new a("nMFVideoOrientationCount", 11, 4);
    eFi = new a("nMFVideoOrientationNext", 12, 100);
    eFj = new a[] { eEW, eEX, eEY, eEZ, eFa, eFb, eFc, eFd, eFe, eFf, eFg, eFh, eFi };
    AppMethodBeat.o(216862);
  }
  
  private MJCamFunSession$a(int paramInt)
  {
    this.eEP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJCamFunSession.a
 * JD-Core Version:    0.7.0.1
 */