package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$a
{
  int oTG;
  
  static
  {
    AppMethodBeat.i(283519);
    oTA = new a("GameLiveStatusErrCodeUnKnownError", 0, -1);
    oTB = new a("GameLiveStatusErrCodeNormal", 1, 0);
    oTC = new a("GameLiveStatusErrCodeNotPermitted", 2, 1);
    oTD = new a("GameLiveStatusErrCodeIsLiving", 3, 2);
    oTE = new a("GameLiveStatusErrCodeVoipConflict", 4, 3);
    oTF = new a("GameLiveStatusErrCodeCameraConfict", 5, 4);
    oTH = new a[] { oTA, oTB, oTC, oTD, oTE, oTF };
    AppMethodBeat.o(283519);
  }
  
  private d$a(int paramInt)
  {
    this.oTG = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.d.a
 * JD-Core Version:    0.7.0.1
 */