package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.floatball.b;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

final class z$3
  implements h
{
  z$3(z paramz) {}
  
  public final void bo(List<BallInfo> paramList)
  {
    AppMethodBeat.i(174791);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BallInfo localBallInfo = (BallInfo)paramList.next();
      if ((localBallInfo != null) && (localBallInfo.type == 4) && (localBallInfo.ime != null) && (bt.nullAsNil(localBallInfo.ime.getString("appId")).equals(z.d(this.kMQ))))
      {
        localBallInfo.ime.putString("processName", aj.getProcessName());
        if (z.a(this.kMQ) != null) {
          z.a(this.kMQ).a(localBallInfo);
        }
      }
    }
    AppMethodBeat.o(174791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.z.3
 * JD-Core Version:    0.7.0.1
 */