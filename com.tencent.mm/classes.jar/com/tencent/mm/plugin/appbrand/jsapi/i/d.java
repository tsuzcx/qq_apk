package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 1039;
  public static final String NAME = "getGameLivePermission";
  
  private void a(com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt1, a parama, int paramInt2)
  {
    AppMethodBeat.i(325871);
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", Integer.valueOf(paramInt1));
    localHashMap.put("errCode", Integer.valueOf(parama.rYT));
    paramc.callback(paramInt2, m("ok", localHashMap));
    AppMethodBeat.o(325871);
  }
  
  public static enum a
  {
    int rYT;
    
    static
    {
      AppMethodBeat.i(325898);
      rYN = new a("GameLiveStatusErrCodeUnKnownError", 0, -1);
      rYO = new a("GameLiveStatusErrCodeNormal", 1, 0);
      rYP = new a("GameLiveStatusErrCodeNotPermitted", 2, 1);
      rYQ = new a("GameLiveStatusErrCodeIsLiving", 3, 2);
      rYR = new a("GameLiveStatusErrCodeVoipConflict", 4, 3);
      rYS = new a("GameLiveStatusErrCodeCameraConfict", 5, 4);
      rYU = new a[] { rYN, rYO, rYP, rYQ, rYR, rYS };
      AppMethodBeat.o(325898);
    }
    
    private a(int paramInt)
    {
      this.rYT = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.d
 * JD-Core Version:    0.7.0.1
 */