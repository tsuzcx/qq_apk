package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum c$a
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(325892);
    rYB = new a("WAGameLiveInfoControlActionUnknow", 0, 0);
    rYC = new a("WAGameLiveInfoControlActionEnableInfo", 1, 1);
    rYD = new a("WAGameLiveInfoControlActionDisableInfo", 2, 2);
    rYE = new a("WAGameLiveInfoControlActionGetCurrentRoomMemberInfo", 3, 3);
    rYF = new a("WAGameLiveInfoControlActionGetCurrentRoomInfo", 4, 4);
    rYG = new a("WAGameLiveInfoControlActionEnableMic", 5, 5);
    rYH = new a("WAGameLiveInfoControlActionDisableMic", 6, 6);
    rYI = new a("WAGameLiveInfoControlActionGetCurrentMicState", 7, 7);
    rYJ = new a("WAGameLiveInfoControlActionEnableMicInfo", 8, 8);
    rYK = new a("WAGameLiveInfoControlActionDisableMicInfo", 9, 9);
    rYL = new a("WAGameLiveInfoControlActionSetTopic", 10, 10);
    rYM = new a[] { rYB, rYC, rYD, rYE, rYF, rYG, rYH, rYI, rYJ, rYK, rYL };
    AppMethodBeat.o(325892);
  }
  
  private c$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a AK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return rYB;
    case 1: 
      return rYC;
    case 2: 
      return rYD;
    case 3: 
      return rYE;
    case 4: 
      return rYF;
    case 5: 
      return rYG;
    case 6: 
      return rYH;
    case 7: 
      return rYI;
    case 8: 
      return rYJ;
    case 9: 
      return rYK;
    }
    return rYL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.c.a
 * JD-Core Version:    0.7.0.1
 */