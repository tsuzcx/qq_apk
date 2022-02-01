package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.gamelive.c.b;
import com.tencent.mm.plugin.gamelive.c.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 1032;
  public static final String NAME = "gameLiveInfoControl";
  
  static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(273428);
      oTp = new a("WAGameLiveInfoControlActionUnknow", 0, 0);
      oTq = new a("WAGameLiveInfoControlActionEnableInfo", 1, 1);
      oTr = new a("WAGameLiveInfoControlActionDisableInfo", 2, 2);
      oTs = new a("WAGameLiveInfoControlActionGetCurrentRoomMemberInfo", 3, 3);
      oTt = new a("WAGameLiveInfoControlActionGetCurrentRoomInfo", 4, 4);
      oTu = new a("WAGameLiveInfoControlActionEnableMic", 5, 5);
      oTv = new a("WAGameLiveInfoControlActionDisableMic", 6, 6);
      oTw = new a("WAGameLiveInfoControlActionGetCurrentMicState", 7, 7);
      oTx = new a("WAGameLiveInfoControlActionEnableMicInfo", 8, 8);
      oTy = new a("WAGameLiveInfoControlActionDisableMicInfo", 9, 9);
      oTz = new a[] { oTp, oTq, oTr, oTs, oTt, oTu, oTv, oTw, oTx, oTy };
      AppMethodBeat.o(273428);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a Ax(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return oTp;
      case 1: 
        return oTq;
      case 2: 
        return oTr;
      case 3: 
        return oTs;
      case 4: 
        return oTt;
      case 5: 
        return oTu;
      case 6: 
        return oTv;
      case 7: 
        return oTw;
      case 8: 
        return oTx;
      }
      return oTy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.c
 * JD-Core Version:    0.7.0.1
 */